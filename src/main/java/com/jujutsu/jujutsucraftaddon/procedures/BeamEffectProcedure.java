package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class BeamEffectProcedure {
    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        double timer = 0;
        double Grow = 0;
        double TrackZ = 0;
        double TrackY = 0;
        double TrackX = 0;
        if (Math.random() <= 0.005) {
            if (!(entity == null)) {
                TrackX = entity.getX() - sourceentity.getX();
                TrackY = entity.getY() - sourceentity.getY() + entity.getBbHeight() * 0.75 - sourceentity.getBbHeight() * 0.75;
                TrackZ = entity.getZ() - sourceentity.getZ();
                Grow = 1;
                if (world instanceof Level _level && !_level.isClientSide()) {
                    _level.explode(sourceentity, (entity.getX()), (entity.getY()), (entity.getZ()), 4, true, Level.ExplosionInteraction.NONE);
                }
                for (int index0 = 0; index0 < 20; index0++) {
                    if (world instanceof ServerLevel _level)
                        _level.sendParticles(JujutsucraftaddonModParticleTypes.BLUE_PUNCH.get(), (sourceentity.getX() + TrackX * Grow), (sourceentity.getY() + sourceentity.getBbHeight() * 0.75 + TrackY * Grow),
                                (sourceentity.getZ() + TrackZ * Grow), 5, 0.15, 0.15, 0.15, 0);
                    Grow = Grow - 0.05;
                }
            }
            timer = 300;
        }
    }
}
