package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class TestProjectileProjectileHitsLivingEntityProcedure {
    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        double Grow = 0;
        double timer = 0;
        double TrackZ = 0;
        double TrackY = 0;
        double TrackX = 0;
        if (!(entity == null)) {
            TrackX = entity.getX() - sourceentity.getX();
            TrackY = entity.getY() - sourceentity.getY() + entity.getBbHeight() * 0.75 - sourceentity.getBbHeight() * 0.75;
            TrackZ = entity.getZ() - sourceentity.getZ();
            Grow = 1;
            for (int index0 = 0; index0 < 20; index0++) {
                if (world instanceof ServerLevel _level)
                    _level.sendParticles(JujutsucraftaddonModParticleTypes.BLOOD_RED.get(), (sourceentity.getX() + TrackX * Grow), (sourceentity.getY() + sourceentity.getBbHeight() * 0.75 + TrackY * Grow),
                            (sourceentity.getZ() + TrackZ * Grow), 5, 0.15, 0.15, 0.15, 0);
                Grow = Grow - 0.05;
            }
        }
    }
}
