package com.jujutsu.jujutsucraftaddon.network;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.procedures.ZTargetSystem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ZTargetPacket {
    private final int targetId; // The entity ID to target (or -1 to clear target)

    public ZTargetPacket(int targetId) {
        this.targetId = targetId;
    }

    public ZTargetPacket(FriendlyByteBuf buffer) {
        this.targetId = buffer.readInt();
    }

    public static void buffer(ZTargetPacket message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.targetId);
    }

    public void handler(Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            Player player = context.getSender();
            if (player != null) {
                if (targetId == -1) {
                    ZTargetSystem.setTarget(player, null);
                } else {
                    Entity target = player.level().getEntity(targetId);
                    if (target != null) {
                        ZTargetSystem.setTarget(player, target);
                    }
                }
            }
        });
        context.setPacketHandled(true);
    }

    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        JujutsucraftaddonMod.addNetworkMessage(
                ZTargetPacket.class,
                ZTargetPacket::buffer,
                ZTargetPacket::new,
                ZTargetPacket::handler
        );
    }
}
