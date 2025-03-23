package com.jujutsu.jujutsucraftaddon;

import com.jujutsu.jujutsucraftaddon.init.*;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.util.thread.SidedThreadGroups;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Mod("jujutsucraftaddon")
public class JujutsucraftaddonMod {
    public static final Logger LOGGER = LogManager.getLogger(JujutsucraftaddonMod.class);
    public static final String MODID = "jujutsucraftaddon";

    // Register all mod components
    public JujutsucraftaddonMod() {
        MinecraftForge.EVENT_BUS.register(this);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        JujutsucraftaddonModNetworkHandler.registerMessages();
        registerModComponents(bus);
    }

    private void registerModComponents(IEventBus bus) {
        JujutsucraftaddonModSounds.REGISTRY.register(bus);
        JujutsucraftaddonModBlocks.REGISTRY.register(bus);
        JujutsucraftaddonModBlockEntities.REGISTRY.register(bus);
        JujutsucraftaddonModItems.REGISTRY.register(bus);
        JujutsucraftaddonModEntities.REGISTRY.register(bus);
        JujutsucraftaddonModEnchantments.REGISTRY.register(bus);
        JujutsucraftaddonModTabs.REGISTRY.register(bus);
        JujutsucraftaddonModMobEffects.REGISTRY.register(bus);
        JujutsucraftaddonModParticleTypes.REGISTRY.register(bus);
        JujutsucraftaddonModMenus.REGISTRY.register(bus);
        JujutsucraftaddonModFluids.REGISTRY.register(bus);
        JujutsucraftaddonModFluidTypes.REGISTRY.register(bus);
    }

    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(MODID, MODID),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );
    private static int messageID = 0;

    // Register network messages
    public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder,
                                             Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
        PACKET_HANDLER.registerMessage(messageID++, messageType, encoder, decoder, messageConsumer);
    }

    // Queue to hold server-side work tasks
    private static final Queue<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

    // Method to queue work tasks on the server
    public static void queueServerWork(int tick, Runnable action) {
        if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER) {
            workQueue.add(new AbstractMap.SimpleEntry<>(action, tick));
        }
    }

    // Server tick handler
    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            processQueuedWork();
        }
    }

    // Process and execute queued tasks
    private void processQueuedWork() {
        List<AbstractMap.SimpleEntry<Runnable, Integer>> completedTasks = new ArrayList<>();

        for (AbstractMap.SimpleEntry<Runnable, Integer> queuedWork : workQueue) {
            int remainingTicks = queuedWork.getValue() - 1;
            queuedWork.setValue(remainingTicks);
            if (remainingTicks <= 0) {
                completedTasks.add(queuedWork);
            }
        }

        // Execute completed tasks and remove them from the queue
        completedTasks.forEach(task -> {
            try {
                task.getKey().run();
            } catch (Exception e) {
                LOGGER.error("Error executing queued task", e);
            }
        });
        workQueue.removeAll(completedTasks);
    }
}
