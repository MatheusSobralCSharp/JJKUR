package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class LockOnHandler {
    public static void handleLockOn(Player player) {
        Level world = player.level();

        // Find the nearest entity
        Entity nearest = null;
        double minDist = 10; // Max lock-on distance

        for (Entity entity : world.getEntities(player, player.getBoundingBox().inflate(10))) {
            if (entity instanceof LivingEntity && entity != player) {
                double dist = player.distanceTo(entity);
                if (dist < minDist) {
                    nearest = entity;
                    minDist = dist;
                }
            }
        }

        // Toggle lock-on
        if (nearest != null) {
            // Access the LockOnCapability from the player's capabilities
            Entity finalNearest = nearest;
            player.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(playerVariables -> {
                LockOnCapability lockOnCapability = playerVariables.lockOnCapability;

                if (lockOnCapability != null) {
                    // If the target is already locked, unlock it
                    if (lockOnCapability.getTargetEntityId() == finalNearest.getId()) {
                        lockOnCapability.setTargetEntityId(-1); // Unlock if already locked
                    } else {
                        // Lock on to the nearest entity
                        lockOnCapability.setTargetEntityId(finalNearest.getId());
                    }
                }
            });
        }
    }

}
