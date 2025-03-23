package com.jujutsu.jujutsucraftaddon.network;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.procedures.OpenAltarProcedure;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AltarSelectorMessage {
    int type, pressedms;

    public AltarSelectorMessage(int type, int pressedms) {
        this.type = type;
        this.pressedms = pressedms;
    }

    public AltarSelectorMessage(FriendlyByteBuf buffer) {
        this.type = buffer.readInt();
        this.pressedms = buffer.readInt();
    }

    public static void buffer(AltarSelectorMessage message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.type);
        buffer.writeInt(message.pressedms);
    }

    public static void handler(AltarSelectorMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> pressAction(context.getSender(), message.type, message.pressedms));
        context.setPacketHandled(true);
    }

    public static void pressAction(Player player, int type, int pressedMs) {
        if (player == null) return;

        Level world = player.level();
        if (!world.hasChunkAt(player.blockPosition())) return; // Prevent arbitrary chunk generation

        double x = player.getX();
        double y = player.getY();
        double z = player.getZ();

        // Execute actions based on keybind type
        if (type == 0) {
            OpenAltarProcedure.execute(world, x, y, z, player);
        } else {
            JujutsucraftaddonMod.LOGGER.warn("Unhandled keybind type: {}", type);
        }
    }

    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        JujutsucraftaddonMod.addNetworkMessage(AltarSelectorMessage.class, AltarSelectorMessage::buffer, AltarSelectorMessage::new, AltarSelectorMessage::handler);
    }
}