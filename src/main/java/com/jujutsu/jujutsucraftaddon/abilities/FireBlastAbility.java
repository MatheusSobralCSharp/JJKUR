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
public class FireBlastAbility {
    private static final int BLAST_RADIUS = 5;
    private static final int FIRE_DURATION = 80;
    private static final int FIRE_LIFETIME = 60;

    private static final List<ScheduledFireRemoval> scheduledRemovals = new ArrayList<>();

    public static void createFireBlast(Player player) {
        if (player.level().isClientSide) return;

        ServerLevel serverLevel = (ServerLevel) player.level();
        BlockPos centerPos = player.blockPosition();
        List<BlockPos> fireBlocks = new ArrayList<>();

        for (int x = -BLAST_RADIUS; x <= BLAST_RADIUS; x++) {
            for (int z = -BLAST_RADIUS; z <= BLAST_RADIUS; z++) {
                BlockPos pos = centerPos.offset(x, 0, z);
                if (serverLevel.getBlockState(pos).isAir()) {
                    serverLevel.setBlock(pos, Blocks.SOUL_FIRE.defaultBlockState(), 3);
                    fireBlocks.add(pos);
                }
            }
        }

        igniteEntities(serverLevel, centerPos);
        scheduledRemovals.add(new ScheduledFireRemoval(serverLevel, fireBlocks, FIRE_LIFETIME));
    }

    private static void igniteEntities(ServerLevel level, BlockPos centerPos) {
        List<Entity> nearbyEntities = level.getEntities(null, new AABB(
                centerPos.getX() - BLAST_RADIUS, centerPos.getY(), centerPos.getZ() - BLAST_RADIUS,
                centerPos.getX() + BLAST_RADIUS, centerPos.getY() + 2, centerPos.getZ() + BLAST_RADIUS
        ));

        for (Entity entity : nearbyEntities) {
            if (entity instanceof LivingEntity && !(entity instanceof Player)) {
                entity.setSecondsOnFire(FIRE_DURATION / 20);
            }
        }
    }

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Iterator<ScheduledFireRemoval> iterator = scheduledRemovals.iterator();
            while (iterator.hasNext()) {
                ScheduledFireRemoval removal = iterator.next();
                removal.ticksLeft--;

                if (removal.ticksLeft <= 0) {
                    for (BlockPos blockPos : removal.blockPositions) {
                        if (removal.level.getBlockState(blockPos).is(Blocks.SOUL_FIRE)) {
                            removal.level.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 3);
                        }
                    }
                    iterator.remove();
                }
            }
        }
    }

    private static class ScheduledFireRemoval {
        private final ServerLevel level;
        private final List<BlockPos> blockPositions;
        private int ticksLeft;

        public ScheduledFireRemoval(ServerLevel level, List<BlockPos> blockPositions, int ticksLeft) {
            this.level = level;
            this.blockPositions = blockPositions;
            this.ticksLeft = ticksLeft;
        }
    }
}
