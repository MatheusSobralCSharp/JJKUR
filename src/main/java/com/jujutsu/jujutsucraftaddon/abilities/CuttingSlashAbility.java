package com.jujutsu.jujutsucraftaddon.abilities;


import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Mod.EventBusSubscriber(modid = "jujutsucraftaddon")
public class CuttingSlashAbility {
    private static final double SLASH_LENGTH = 15.0; // Slash length in blocks
    private static final double RADIUS = 5.0; // Radius for entities to take damage
    private static final double DAMAGE = 20.0; // Damage dealt to entities in the radius

    private static final List<CuttingSlashInstance> activeSlashes = new ArrayList<>();

    public static void useCuttingSlash(Player player) {
        if (player.level().isClientSide) return; // Server-side only

        Vec3 startPos = player.position().add(0, player.getEyeHeight(), 0);
        Vec3 direction = player.getLookAngle().normalize();

        activeSlashes.add(new CuttingSlashInstance(player, startPos, direction));
    }

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Iterator<CuttingSlashInstance> iterator = activeSlashes.iterator();
            while (iterator.hasNext()) {
                CuttingSlashInstance instance = iterator.next();
                instance.tick();

                if (instance.isComplete()) {
                    iterator.remove();
                }
            }
        }
    }

    private static class CuttingSlashInstance {
        private final Player player;
        private final Vec3 startPos;
        private final Vec3 direction;

        private boolean completed = false;

        public CuttingSlashInstance(Player player, Vec3 startPos, Vec3 direction) {
            this.player = player;
            this.startPos = startPos;
            this.direction = direction;
        }

        public void tick() {
            if (completed) return;

            ServerLevel level = (ServerLevel) player.level();
            Vec3 endPos = startPos.add(direction.scale(SLASH_LENGTH));

            // Check all entities within the radius of the slash
            AABB slashArea = new AABB(startPos, endPos).inflate(RADIUS); // Creating a cylinder around the line
            List<Entity> entitiesInRange = level.getEntities(null, slashArea);

            // Deal damage and destroy blocks within the area
            for (Entity entity : entitiesInRange) {
                if (entity instanceof LivingEntity && entity != player) {
                    ((LivingEntity) entity).hurt(player.damageSources().magic(), (float) DAMAGE); // Deal damage to entities
                }
                if (entity instanceof ItemEntity) {  // Check if it's an ItemEntity (which could be a BlockItem)
                    ItemEntity itemEntity = (ItemEntity) entity;
                    BlockPos pos = new BlockPos((int) itemEntity.getX(), (int) itemEntity.getY(), (int) itemEntity.getZ()); // Create a BlockPos
                    level.destroyBlock(BlockPos.containing(itemEntity.getX(), itemEntity.getY(), itemEntity.getZ()), false);// Cut blocks (remove them)
                }
            }

            // Mark the slash as complete
            completed = true;
        }

        public boolean isComplete() {
            return completed;
        }
    }
}
