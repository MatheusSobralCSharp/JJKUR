package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;

public class JogoUltimateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        String endtext = "";
        double xRadius = 0;
        double loop = 0;
        double zRadius = 0;
        double particleAmount = 0;
        double repeats = 0;
        double sx = 0;
        double sy = 0;
        double sz = 0;
        loop = 0;
        particleAmount = 120;
        xRadius = 10;
        zRadius = 10;
        while (loop < particleAmount) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.FLAME, (x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), y, (z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 1, 0, 0.05, 0, 1);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.LAVA, (x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), y, (z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 1, 0, 0.05, 0, 1);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.LANDING_LAVA, (x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), y, (z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 1, 0, 0.05, 0, 1);
            loop = loop + 1;
        }
    }
}
