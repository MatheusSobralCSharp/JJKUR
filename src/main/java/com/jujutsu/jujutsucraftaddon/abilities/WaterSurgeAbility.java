package com.jujutsu.jujutsucraftaddon.abilities;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Mod.EventBusSubscriber(modid = "jujutsucraftaddon")
public class WaterSurgeAbility {
    private static final int WAVE_LENGTH = 10;
    private static final int WAVE_HEIGHT = 3;
    private static final int WAVE_LIFETIME = 60;
    private static final double PUSH_FORCE = 1.2;

    private static final List<ScheduledWaveRemoval> scheduledRemovals = new ArrayList<>();

    public static void createWaterSurge(Player player) {
        if (player.level().isClientSide) return;

        ServerLevel serverLevel = (ServerLevel) player.level();
        float yaw = player.getYRot();
        int dirX = (int) Math.round(-Math.sin(Math.toRadians(yaw)));
        int dirZ = (int) Math.round(Math.cos(Math.toRadians(yaw)));

        BlockPos startPos = player.blockPosition().offset(dirX * 2, 0, dirZ * 2);
        List<BlockPos> placedBlocks = new ArrayList<>();

        for (int z = 0; z < WAVE_LENGTH; z++) {
            for (int y = 0; y < WAVE_HEIGHT; y++) {
                BlockPos pos = startPos.offset(dirX * z, y, dirZ * z);
                if (serverLevel.getBlockState(pos).isAir()) {
                    serverLevel.setBlock(pos, Blocks.WATER.defaultBlockState(), 3);
                    placedBlocks.add(pos);
                }
            }
        }

        pushEntities(serverLevel, startPos, dirX, dirZ);
        scheduledRemovals.add(new ScheduledWaveRemoval(serverLevel, placedBlocks, WAVE_LIFETIME));
    }

    private static void pushEntities(ServerLevel level, BlockPos startPos, int dirX, int dirZ) {
        List<Entity> nearbyEntities = level.getEntities(null, new AABB(
                startPos.getX() - 5, startPos.getY(), startPos.getZ() - 5,
                startPos.getX() + 5, startPos.getY() + WAVE_HEIGHT, startPos.getZ() + WAVE_LENGTH
        ));

        for (Entity entity : nearbyEntities) {
            if (entity instanceof LivingEntity && !(entity instanceof Player)) {
                entity.setDeltaMovement(dirX * PUSH_FORCE, 0.3, dirZ * PUSH_FORCE);
                entity.hurtMarked = true;
            }
        }
    }

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Iterator<ScheduledWaveRemoval> iterator = scheduledRemovals.iterator();
            while (iterator.hasNext()) {
                ScheduledWaveRemoval removal = iterator.next();
                removal.ticksLeft--;

                if (removal.ticksLeft <= 0) {
                    for (BlockPos blockPos : removal.blockPositions) {
                        if (removal.level.getBlockState(blockPos).is(Blocks.WATER)) {
                            removal.level.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 3);
                        }
                    }
                    iterator.remove();
                }
            }
        }
    }

    private static class ScheduledWaveRemoval {
        private final ServerLevel level;
        private final List<BlockPos> blockPositions;
        private int ticksLeft;

        public ScheduledWaveRemoval(ServerLevel level, List<BlockPos> blockPositions, int ticksLeft) {
            this.level = level;
            this.blockPositions = blockPositions;
            this.ticksLeft = ticksLeft;
        }
    }
}
