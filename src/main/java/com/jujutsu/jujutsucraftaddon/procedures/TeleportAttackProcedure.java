package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class TeleportAttackProcedure {
    public static void execute(Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        double distance = 0;
        double angle = 0;
        double yaw = 0;
        if (entity instanceof LivingEntity) {
            if (sourceentity instanceof LivingEntity) {
                yaw = entity.getYRot();
                // Calculate the new X, Z positions behind the target
                double distanceBehind = 2.0; // Distance behind the target (you can adjust this value)
                double offsetX = -Math.sin(Math.toRadians(yaw)) * distanceBehind;
                double offsetZ = Math.cos(Math.toRadians(yaw)) * distanceBehind;
                // Get the target's position and apply the offsets
                double newX = entity.getX() + offsetX;
                double newY = entity.getY();
                double newZ = entity.getZ() + offsetZ;
                {
                    Entity _ent = sourceentity;
                    _ent.teleportTo(newX, newY, newZ);
                    if (_ent instanceof ServerPlayer _serverPlayer)
                        _serverPlayer.connection.teleport(newX, newY, newZ, _ent.getYRot(), _ent.getXRot());
                }
            }
        }
    }
}
