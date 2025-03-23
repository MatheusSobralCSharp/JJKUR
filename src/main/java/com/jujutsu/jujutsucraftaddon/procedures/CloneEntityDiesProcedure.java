package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;

public class CloneEntityDiesProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world instanceof ServerLevel _level)
            _level.sendParticles(ParticleTypes.SMOKE, x, y, z, 5, 3, 3, 3, 1);
    }
}
