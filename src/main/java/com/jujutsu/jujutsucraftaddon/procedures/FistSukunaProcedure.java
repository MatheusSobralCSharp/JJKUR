package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class FistSukunaProcedure {
    public static void execute(LevelAccessor world, Entity sourceentity) {
        if (sourceentity == null)
            return;
        if ((sourceentity.getDirection()) == Direction.NORTH) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.CURSED_POWER_SUKUNA.get(), (sourceentity.getX() + 0.35), (sourceentity.getY() + 1), (sourceentity.getZ() - 0.2), 0, 0, 0, 0, 1);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.CURSED_POWER_SUKUNA.get(), (sourceentity.getX() - 0.35), (sourceentity.getY() + 1), (sourceentity.getZ() - 0.2), 0, 0, 0, 0, 1);
        } else if ((sourceentity.getDirection()) == Direction.SOUTH) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.CURSED_POWER_SUKUNA.get(), (sourceentity.getX() + 0.35), (sourceentity.getY() + 1), (sourceentity.getZ() - 0.2), 0, 0, 0, 0, 1);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.CURSED_POWER_SUKUNA.get(), (sourceentity.getX() - 0.35), (sourceentity.getY() + 1), (sourceentity.getZ() - 0.2), 0, 0, 0, 0, 1);
        } else if ((sourceentity.getDirection()) == Direction.WEST) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.CURSED_POWER_SUKUNA.get(), (sourceentity.getX()), (sourceentity.getY() + 1), (sourceentity.getZ() + 0.5), 0, 0, 0, 0, 1);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.CURSED_POWER_SUKUNA.get(), (sourceentity.getX()), (sourceentity.getY() + 1), (sourceentity.getZ() - 0.5), 0, 0, 0, 0, 1);
        } else if ((sourceentity.getDirection()) == Direction.EAST) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.CURSED_POWER_SUKUNA.get(), (sourceentity.getX()), (sourceentity.getY() + 1), (sourceentity.getZ() + 0.5), 0, 0, 0, 0, 1);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.CURSED_POWER_SUKUNA.get(), (sourceentity.getX()), (sourceentity.getY() + 1), (sourceentity.getZ() - 0.5), 0, 0, 0, 0, 1);
        }
    }
}
