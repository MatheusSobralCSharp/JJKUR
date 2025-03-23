package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class EffectsBlackFlashProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        double yaw = 0;
        double r = 0;
        double curve = 0;
        double deg = 0;
        double yoff = 0;
        if (Math.random() <= 0.1) {
            if (entity instanceof LivingEntity) {
                yaw = entity.getYRot();
                // Calculate the new X, Z positions behind the target
                double distanceBehind = 2.0; // Distance behind the target (you can adjust this value)
                double offsetX = -Math.sin(Math.toRadians(yaw)) * distanceBehind;
                double offsetZ = Math.cos(Math.toRadians(yaw)) * distanceBehind;
                // Get the target's position and apply the offsets
                double newX = entity.getX() + offsetX;
                double newY = entity.getY();
                double newZ = entity.getZ() + offsetZ;
            }
//            world.addParticle(JujutsucraftaddonModParticleTypes.KOKUSEN_3.get(), x, (y + 1), z, 0, 1, 0);
//            world.addParticle(JujutsucraftaddonModParticleTypes.KOKUSEN_5.get(), x, (y + 1), z, 0, 1, 0);
//            if ((entity.getDirection()) == Direction.NORTH) {
//                world.addParticle(JujutsucraftModParticleTypes.PARTICLE_BLACK_FLASH_1.get(), (x + 2), (y + 2), z, 0, 0, 0);
//                world.addParticle(JujutsucraftaddonModParticleTypes.KOKUSEN_3.get(), (x + 2), (y + 2), z, 0, 0, 0);
//            } else if ((entity.getDirection()) == Direction.SOUTH) {
//                world.addParticle(JujutsucraftModParticleTypes.PARTICLE_BLACK_FLASH_1.get(), (x + 2), (y + 2), z, 0, 0, 0);
//                world.addParticle(JujutsucraftaddonModParticleTypes.KOKUSEN_4.get(), (x + 2), (y + 2), z, 0, 0, 0);
//            } else if ((entity.getDirection()) == Direction.WEST) {
//                world.addParticle(JujutsucraftModParticleTypes.PARTICLE_BLACK_FLASH_1.get(), x, (y + 2), (z - 2), 0, 0, 0);
//                world.addParticle(JujutsucraftaddonModParticleTypes.KOKUSEN_5.get(), (x + 2), (y + 2), z, 0, 0, 0);
//            } else if ((entity.getDirection()) == Direction.EAST) {
//                world.addParticle(JujutsucraftModParticleTypes.PARTICLE_BLACK_FLASH_1.get(), x, (y + 2), (z - 2), 0, 0, 0);
//                world.addParticle(JujutsucraftModParticleTypes.PARTICLE_BLACK_FLASH_1.get(), x, (y + 2), (z + 2), 0, 0, 0);
//            }
            deg = entity.getYRot() - 90;
            r = 1;
            curve = Mth.nextDouble(RandomSource.create(), -10, 10);
//            for (int index0 = 0; index0 < 5; index0++) {
//                for (int index1 = 0; index1 < 11; index1++) {
//                    if (r == 2 || r == 3) {
//                        yoff = Math.sin(Math.toRadians(deg)) * curve;
//                        world.addParticle(JujutsucraftaddonModParticleTypes.KOKUSEN_3.get(), (x - r * Math.sin(Math.toRadians(deg))), (y + 1 + yoff), (z + r * Math.cos(Math.toRadians(deg))),
//                                ((-0.1) * Math.sin(Math.toRadians(deg))), 0, (0.1 * Math.cos(Math.toRadians(deg))));
//                    }
//                    deg = deg + 18;
//                }
//                if (r == 2 || r == 4) {
//                    deg = entity.getYRot() - 81;
//                } else {
//                    deg = entity.getYRot() - 90;
//                }
//                r = r + 1;
//            }
//            double curve1 = Mth.nextDouble(RandomSource.create(), -60, 60);
//            for (int index0 = 0; index0 < 5; index0++) {
//                for (int index1 = 0; index1 < 11; index1++) {
//                    if (r == 2 || r == 3) {
//                        yoff = Math.sin(Math.toRadians(deg)) * curve1;
//                        world.addParticle(JujutsucraftaddonModParticleTypes.KOKUSEN_5.get(), (x + Mth.nextDouble(RandomSource.create(), -10, 10) - r * Math.sin(Math.toRadians(deg))), (y + Mth.nextDouble(RandomSource.create(), 1, 10) + yoff), (z + Mth.nextDouble(RandomSource.create(), -10, 10)  + r * Math.cos(Math.toRadians(deg))),
//                                ((-0.1) * Math.sin(Math.toRadians(deg))), 0, (0.1 * Math.cos(Math.toRadians(deg))));
//                    }
//                    deg = deg + 18;
//                }
//                if (r == 2 || r == 4) {
//                    deg = entity.getYRot() - 81;
//                } else {
//                    deg = entity.getYRot() - 90;
//                }
//                r = r + 1;
//            }
        }
    }
}
