package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ZTargetSystem {
    private static final Map<UUID, WeakReference<Entity>> targetingMap = new HashMap<>();

    /**
     * Finds a target in front of the player within a given range.
     */
    public static Entity findTarget(Player player, double range) {
        Vec3 eyePos = player.getEyePosition();
        Vec3 lookVec = player.getLookAngle();
        Vec3 targetPos = eyePos.add(lookVec.scale(range));

        AABB searchBox = new AABB(eyePos, targetPos).inflate(1.0); // Expand for better detection

        Entity nearestTarget = null;
        double nearestDistance = range;

        for (Entity entity : player.level().getEntities(player, searchBox, e -> !(e instanceof Player) && e.isAlive())) {
            double distance = entity.distanceTo(player);
            if (distance < nearestDistance) {
                nearestDistance = distance;
                nearestTarget = entity;
            }
        }
        return nearestTarget;
    }


    /**
     * Stores the locked target in a map.
     */
    public static void setTarget(Player player, Entity target) {
        if (target != null) {
            targetingMap.put(player.getUUID(), new WeakReference<>(target));
        } else {
            targetingMap.remove(player.getUUID()); // Remove if null
        }
    }

    /**
     * Retrieves the current locked target.
     */
    public static Entity getTarget(Player player) {
        WeakReference<Entity> ref = targetingMap.get(player.getUUID());
        return (ref != null) ? ref.get() : null;
    }

    /**
     * Updates the player's camera to lock onto the target.
     */
    public static void updateCameraToTarget(Player player) {
        Entity target = getTarget(player);
        if (target != null) {
            Vec3 playerPos = player.position();
            Vec3 targetPos = target.position();

            double dx = targetPos.x - playerPos.x;
            double dy = (targetPos.y + target.getBbHeight() / 2) - (playerPos.y + player.getEyeHeight());
            double dz = targetPos.z - playerPos.z;

            float yaw = (float) (Mth.atan2(dz, dx) * (180 / Math.PI)) - 90;
            float pitch = (float) -(Mth.atan2(dy, Math.sqrt(dx * dx + dz * dz)) * (180 / Math.PI));

            player.setYRot(yaw);
            player.setXRot(pitch);
            player.yHeadRot = yaw; // Make sure head follows
            player.yBodyRot = yaw; // Make sure body faces target
        }
    }

}
