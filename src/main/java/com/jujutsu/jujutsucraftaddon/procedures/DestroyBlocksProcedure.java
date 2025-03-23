package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.procedures.RangeAttackProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;

public class DestroyBlocksProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if (entity instanceof LivingEntity) {
            if (Math.random() <= 0.2) {
                if (sourceentity instanceof LivingEntity) {
                    Vec3 currentPos = new Vec3(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ());
                    Level level = entity.level();
                    if (level == null)
                        return; // Ensure the level is not null
                    // Set how far forward the particle should affect blocks
                    int forwardRange = 30; // Modify this value to increase or decrease the range
                    int widthRange = (int) (0.5 * (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel); // New variable to set the radius of the affected area
                    for (int i = 0; i < forwardRange; i++) {
                        // Calculate direction based on the source entity's rotation
                        double radians = Math.toRadians(sourceentity.getYRot() + 90);
                        double xOffset = Math.cos(radians) * i; // Cosine for the x direction
                        double zOffset = Math.sin(radians) * i; // Sine for the z direction
                        Vec3 nextPos = currentPos.add(xOffset, 0, zOffset); // Calculated position
                        // Loop over the area around the current position
                        for (int dx = -widthRange; dx <= widthRange; dx++) { // Use 'dx' for the x offset
                            for (int dz = -widthRange; dz <= widthRange; dz++) { // Use 'dz' for the z offset
                                Vec3 offsetPos = nextPos.add(dx, 0, dz);
                                final Vec3 _center = offsetPos;
                                List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2.0d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                                for (Entity entityiterator : _entfound) {
                                    if (sourceentity != entityiterator) {
                                        entityiterator.hurt(
                                                new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))), 20);
                                    }
                                }
                                BlockPos blockPos = new BlockPos((int) (offsetPos.x + 1), (int) offsetPos.y, (int) (offsetPos.z + 1));
                                BlockPos blockPos2 = new BlockPos((int) (offsetPos.x + Mth.nextInt(RandomSource.create(), -5, 5)), (int) offsetPos.y + Mth.nextInt(RandomSource.create(), -1, 1),
                                        (int) (offsetPos.z + Mth.nextInt(RandomSource.create(), -5, 5)));
                                // Break blocks at the current and below positions
                                BlockState blockState = level.getBlockState(blockPos);
                                BlockState blockState2 = level.getBlockState(blockPos2);
                                Block block = blockState.getBlock();
                                Block block2 = blockState2.getBlock();
                                if (block != Blocks.BEDROCK) {
                                    level.removeBlock(blockPos, false);
                                    level.levelEvent(2001, blockPos, Block.getId(blockState)); // Block break event
                                }
                                if (block2 != Blocks.BEDROCK) {
                                    level.removeBlock(blockPos2, false);
                                    level.levelEvent(2001, blockPos2, Block.getId(blockState2)); // Block break event
                                }
                                BlockPos blockPosY1 = blockPos.below(1);
                                BlockState blockStateY1 = level.getBlockState(blockPosY1);
                                Block block3 = blockStateY1.getBlock();
                                if (block3 != Blocks.BEDROCK) {
                                    level.removeBlock(blockPosY1, false);
                                    level.levelEvent(2001, blockPosY1, Block.getId(blockStateY1)); // Block break event
                                }
                            }
                        }
                    }
                    sourceentity.getPersistentData().putDouble("Damage", 6 + Mth.nextInt(RandomSource.create(), 1, 10) * 3);
                    sourceentity.getPersistentData().putDouble("Range", sourceentity.getBbWidth() + 10.0F);
                    sourceentity.getPersistentData().putDouble("effect", 2.0);
                    sourceentity.getPersistentData().putDouble("knockback", 0.25);
                    sourceentity.getPersistentData().putDouble("projectile_type", 1.0);
                    sourceentity.getPersistentData().putBoolean("onlyRanged", true);
                    RangeAttackProcedure.execute(world, sourceentity.getX(), sourceentity.getY() + (double) sourceentity.getBbHeight() * 0.5, sourceentity.getZ(), sourceentity);
                    sourceentity.getPersistentData().putBoolean("onlyRanged", false);
                }
            }
        }
        double size = 0;
        double xRadius = 0;
        double loop = 0;
        double zRadius = 0;
        double particleAmount = 0;
        double yheight = 0;
        loop = 0;
        particleAmount = 0;
        xRadius = 0;
        zRadius = 0;
        yheight = 0;
        size = 0;
        for (int index0 = 0; index0 < 5; index0++) {
            while (loop < particleAmount) {
                if (world instanceof Level _level && !_level.isClientSide())
                    _level.explode(null, (x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), (y + yheight), (z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 0, Level.ExplosionInteraction.MOB);
                loop = loop + 1;
            }
            loop = 0;
            xRadius = xRadius + 1;
            zRadius = zRadius + 1;
        }
    }
}
