package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;

public class SnowDomainOnTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world instanceof ServerLevel _level)
            _level.sendParticles(ParticleTypes.SNOWFLAKE, x, (y + 1), z, 1, 0, 0, 0, 0.1);
    }
}
