package com.jujutsu.jujutsucraftaddon.misc;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModKeyMappings;
import com.jujutsu.jujutsucraftaddon.network.ZTargetPacket;
import com.jujutsu.jujutsucraftaddon.procedures.ZTargetSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "jujutuscraftaddon", bus = Mod.EventBusSubscriber.Bus.MOD)
public class Ztarget {
    @SubscribeEvent
    public static void onKeyPress(InputEvent.Key event) {
        if (JujutsucraftaddonModKeyMappings.Z_TARGET_KEY.consumeClick()) {
            Player player = Minecraft.getInstance().player;
            if (player != null) {
                Entity currentTarget = ZTargetSystem.getTarget(player);

                if (currentTarget != null) {
                    ZTargetSystem.setTarget(player, null); // Unlock locally
                    JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new ZTargetPacket(-1)); // Send packet to clear target
                } else {
                    Entity target = ZTargetSystem.findTarget(player, 10.0);
                    if (target != null) {
                        ZTargetSystem.setTarget(player, target); // Lock locally
                        JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new ZTargetPacket(target.getId())); // Send packet to set target
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;

        if (player != null && event.phase == TickEvent.ClientTickEvent.Phase.END) {
            Entity target = ZTargetSystem.getTarget(player);
            if (target != null) {
                ZTargetSystem.updateCameraToTarget(player);
            }
        }
    }
}