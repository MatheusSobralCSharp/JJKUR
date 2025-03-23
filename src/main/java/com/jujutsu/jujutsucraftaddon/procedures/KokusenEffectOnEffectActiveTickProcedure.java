package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class KokusenEffectOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        double particleRadius = 0;
        double particleAmount = 0;
        if (entity instanceof LivingEntity) {
            for (int index0 = 0; index0 < 1; index0++) {
                world.addParticle(JujutsucraftaddonModParticleTypes.KOKUSEN_3.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 5),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 5), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 5), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)));
            }
            for (int index1 = 0; index1 < 1; index1++) {
                world.addParticle(JujutsucraftaddonModParticleTypes.KOKUSEN_4.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 5),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 5), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 5), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)));
            }
            for (int index2 = 0; index2 < 1; index2++) {
                world.addParticle(JujutsucraftaddonModParticleTypes.KOKUSEN_5.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -0.1, 0.1) * 5),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), 1, 2) * 5), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -0.1, 0.1) * 5), 0, 0, 0);
            }
            for (int index3 = 0; index3 < 1; index3++) {
                world.addParticle(JujutsucraftaddonModParticleTypes.KOKUSEN_1.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 5),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), 0.3, 1) * 5), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), 1, 1) * 5), 0, 0, 0);
            }
            for (int index4 = 0; index4 < 1; index4++) {
                world.addParticle(JujutsucraftaddonModParticleTypes.KOKUSEN_2.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 5),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), 0.3, 1) * 5), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), 1, 1) * 5), 0, 0, 0);
            }
        }
    }
}
