package com.jujutsu.jujutsucraftaddon.misc;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModKeyMappings;
import com.jujutsu.jujutsucraftaddon.procedures.LockOnHandler;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class MovementLockOn {
    private static final float MOVEMENT_SPEED = 0.1f; // Adjust this value to control the speed of smooth movement
    private static final float MOVEMENT_SMOOTHING = 0.2f; // How much smoothing to apply to the movement

    @SubscribeEvent
    public static void onInput(InputEvent event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        KeyMapping keyMapping = JujutsucraftaddonModKeyMappings.Z_TARGET_KEY;  // Assuming you have a key mapping for this

        // Check if the key is pressed (use keyMapping.isDown() instead of getKey().getValue().isDown())
        if (keyMapping.isDown()) {
            LockOnHandler.handleLockOn(player);
        }

    }
}
