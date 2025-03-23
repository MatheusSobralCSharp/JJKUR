package com.jujutsu.jujutsucraftaddon.network;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.procedures.AnimationKeybindOnKeyPressedProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.PassiveKeybindOnKeyReleasedProcedure;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AnimationKeybindMessage {
    private final int type;
    private final int pressedMs;

    // Constructor for direct message creation
    public AnimationKeybindMessage(int type, int pressedMs) {
        this.type = type;
        this.pressedMs = pressedMs;
    }

    // Constructor for decoding from the buffer
    public AnimationKeybindMessage(FriendlyByteBuf buffer) {
        this.type = buffer.readInt();
        this.pressedMs = buffer.readInt();
    }

    // Encodes the message to the buffer
    public static void buffer(AnimationKeybindMessage message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.type);
        buffer.writeInt(message.pressedMs);
    }

    // Handles the received message
    public static void handler(AnimationKeybindMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> pressAction(context.getSender(), message.type, message.pressedMs));
        context.setPacketHandled(true);
    }

    // Executes the corresponding action based on the keybind type
    public static void pressAction(Player player, int type, int pressedMs) {
        if (player == null) return;

        Level world = player.level();
        if (!world.hasChunkAt(player.blockPosition())) return; // Prevent arbitrary chunk generation

        double x = player.getX();
        double y = player.getY();
        double z = player.getZ();

        // Execute actions based on keybind type
        switch (type) {
            case 0 -> AnimationKeybindOnKeyPressedProcedure.execute(world, x, y, z, player);
            case 1 -> PassiveKeybindOnKeyReleasedProcedure.execute(world, x, y, z, player);
            default -> JujutsucraftaddonMod.LOGGER.warn("Unhandled keybind type: {}", type);
        }
    }

    // Registers the message for networking
    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        JujutsucraftaddonMod.addNetworkMessage(
                AnimationKeybindMessage.class,
                AnimationKeybindMessage::buffer,
                AnimationKeybindMessage::new,
                AnimationKeybindMessage::handler
        );
    }
}
