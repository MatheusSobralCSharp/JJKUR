package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;

public class YorozuUltimateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        boolean found = false;
        double sx = 0;
        double sy = 0;
        double sz = 0;
        sx = -6;
        for (int index0 = 0; index0 < 6; index0++) {
            sy = -3;
            for (int index1 = 0; index1 < 6; index1++) {
                sz = -6;
                for (int index2 = 0; index2 < 6; index2++) {
                    if (!((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.BEDROCK)) {
                        if (world instanceof ServerLevel _level)
                            _level.sendParticles(ParticleTypes.SQUID_INK, (x + sx), (y - 2), (z + sz), 0, 0, 0, 0, 1);
                        if (world instanceof ServerLevel _level)
                            _level.sendParticles(JujutsucraftModParticleTypes.PARTICLE_LIQUID_METAL.get(), (x + sx), (y + sy), (z + sz), 1, 0, 0, 0, 1);
                    }
                    sz = sz + 1;
                }
                sy = sy + 1;
            }
            sx = sx + 1;
        }
    }
}
