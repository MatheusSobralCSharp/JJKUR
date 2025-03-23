package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ItadoriRampageOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (world instanceof ServerLevel _level)
            _level.sendParticles(JujutsucraftaddonModParticleTypes.THUNDER_BLACK.get(), (entity.getX() + Mth.nextInt(RandomSource.create(), -1, 1)), (entity.getY() + Mth.nextInt(RandomSource.create(), 0, 1)),
                    (entity.getZ() + Mth.nextInt(RandomSource.create(), -1, 1)), 4, 0, 0, 0, 1);
        if (world instanceof ServerLevel _level)
            _level.sendParticles(JujutsucraftaddonModParticleTypes.THUNDER_WHITE.get(), (entity.getX() + Mth.nextInt(RandomSource.create(), -1, 1)), (entity.getY() + Mth.nextInt(RandomSource.create(), 0, 1)),
                    (entity.getZ() + Mth.nextInt(RandomSource.create(), -1, 1)), 4, 0, 0, 0, 1);
    }
}
