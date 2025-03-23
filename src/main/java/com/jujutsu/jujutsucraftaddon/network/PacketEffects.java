package com.jujutsu.jujutsucraftaddon.network;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.procedures.EffectsAction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PacketEffects {
    int page;
    UUID playerUUID;
    private static final Map<Integer, Boolean> keyState = new HashMap<>();
    private static final Map<UUID, Integer> pressCounter = new HashMap<>();
    // Constructor
    public PacketEffects(int page, UUID playerUUID) {
        this.page = page;
        this.playerUUID = playerUUID;
    }

    public PacketEffects(FriendlyByteBuf buffer) {
        this.page = buffer.readInt();
        this.playerUUID = buffer.readUUID(); // Read UUID from packet
    }

    public static void buffer(PacketEffects message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.page);
        buffer.writeUUID(message.playerUUID); // Write UUID to packet
    }


    // Handler
    public static void handler(PacketEffects message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayer serverPlayer = context.getSender(); // Get the sender

            if (serverPlayer == null) return;

            ServerLevel serverLevel = serverPlayer.server.getLevel(serverPlayer.level().dimension()); // Ensure correct world
            if (serverLevel == null) return;

            // Retrieve the correct player using UUID
            Player targetPlayer = serverLevel.getPlayerByUUID(message.playerUUID);
            if (targetPlayer == null) return;

            // Call ShortCutAction instead of old pressAction

            int currentCount = pressCounter.getOrDefault(message.playerUUID, 0);

            // Increment counter
            currentCount++;

            if (currentCount >= 2) {
                // Execute the action when the counter reaches 5
                EffectsAction.execute(targetPlayer, message.page);

                // Reset the counter
                pressCounter.put(message.playerUUID, 0);
            } else {
                // Update counter
                pressCounter.put(message.playerUUID, currentCount);
            }
        });
        context.setPacketHandled(true);
    }


    // Registrando o Packet
    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        JujutsucraftaddonMod.addNetworkMessage(PacketEffects.class, PacketEffects::buffer, PacketEffects::new, PacketEffects::handler);
    }
}