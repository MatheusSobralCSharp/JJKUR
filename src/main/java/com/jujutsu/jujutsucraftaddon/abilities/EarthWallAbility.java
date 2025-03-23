package com.jujutsu.jujutsucraftaddon.abilities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Mod.EventBusSubscriber(modid = "jujutsucraftaddon")
public class EarthWallAbility {
    private static final int WALL_WIDTH = 20;   // Width of the wall
    private static final int WALL_HEIGHT = 10;  // Height of the wall
    private static final int WALL_LIFETIME = 100; // Duration in ticks (5 seconds)
    private static final double KNOCKBACK_FORCE = 1.5;

    private static final List<ScheduledWallRemoval> scheduledRemovals = new ArrayList<>();

    public static void createEarthWall(LivingEntity player) {
        if (player.level().isClientSide) return; // Only run on the server

        ServerLevel serverLevel = (ServerLevel) player.level();
        float yaw = player.getYRot(); // Get player's yaw (horizontal rotation)

        // Determine direction (north/south or east/west)
        int dirX = (int) Math.round(-Math.sin(Math.toRadians(yaw))); // X-axis offset
        int dirZ = (int) Math.round(Math.cos(Math.toRadians(yaw)));  // Z-axis offset

        // Start position 3 blocks ahead in the direction the player is facing
        BlockPos startPos = player.blockPosition().offset(dirX * 3, 0, dirZ * 3);

        List<BlockPos> placedBlocks = new ArrayList<>();

        // Create a 3x3 dirt wall perpendicular to the player's direction
        for (int x = -WALL_WIDTH / 2; x <= WALL_WIDTH / 2; x++) {
            for (int y = 0; y < WALL_HEIGHT; y++) {
                BlockPos pos;
                if (Math.abs(dirX) > Math.abs(dirZ)) {
                    // Facing North/South -> Adjust X for width
                    pos = startPos.offset(0, y, x);
                } else {
                    // Facing East/West -> Adjust Z for width
                    pos = startPos.offset(x, y, 0);
                }

                if (serverLevel.getBlockState(pos).isAir()) { // Only place if air
                    serverLevel.setBlock(pos, Blocks.STONE.defaultBlockState(), 3);
                    placedBlocks.add(pos);
                }
            }
        }

        knockbackEntities(serverLevel, startPos, dirX, dirZ);

        // Schedule the wall for removal
        scheduledRemovals.add(new ScheduledWallRemoval(serverLevel, placedBlocks, WALL_LIFETIME));
    }

    private static void knockbackEntities(ServerLevel level, BlockPos wallPos, int dirX, int dirZ) {
        double range = WALL_WIDTH / 2.0 + 2.0; // Slightly wider than the wall
        List<Entity> nearbyEntities = level.getEntities(null,
                new net.minecraft.world.phys.AABB(
                        wallPos.getX() - range, wallPos.getY(), wallPos.getZ() - range,
                        wallPos.getX() + range, wallPos.getY() + WALL_HEIGHT, wallPos.getZ() + range
                )
        );

        for (Entity entity : nearbyEntities) {
            if (entity instanceof LivingEntity && !(entity instanceof Player)) { // Exclude the player
                double knockbackX = dirX * KNOCKBACK_FORCE;
                double knockbackZ = dirZ * KNOCKBACK_FORCE;
                entity.setDeltaMovement(knockbackX, 0.5, knockbackZ); // Apply force upwards slightly
                if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                    entity.discard();
                }
                entity.hurtMarked = true; // Ensure motion syncs with the client
            }
        }
    }


    // Tick event to remove the wall after time expires
    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Iterator<ScheduledWallRemoval> iterator = scheduledRemovals.iterator();
            while (iterator.hasNext()) {
                ScheduledWallRemoval removal = iterator.next();
                removal.ticksLeft--;

                if (removal.ticksLeft <= 0) {
                    for (BlockPos blockPos : removal.blockPositions) {
                        if (removal.level.getBlockState(blockPos).is(Blocks.STONE)) {
                            removal.level.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 3);
                        }
                    }
                    iterator.remove();
                }
            }
        }
    }

    // Helper class to track walls to remove
    private static class ScheduledWallRemoval {
        private final ServerLevel level;
        private final List<BlockPos> blockPositions;
        private int ticksLeft;

        public ScheduledWallRemoval(ServerLevel level, List<BlockPos> blockPositions, int ticksLeft) {
            this.level = level;
            this.blockPositions = blockPositions;
            this.ticksLeft = ticksLeft;
        }
    }
}