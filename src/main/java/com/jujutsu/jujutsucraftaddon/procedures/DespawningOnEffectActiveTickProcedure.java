package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class DespawningOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (world instanceof ServerLevel _origLevel) {
            LevelAccessor _worldorig = world;
            world = _origLevel.getServer().getLevel(entity.level().dimension());
            if (world != null) {
                if (world instanceof ServerLevel _level) {
                    if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_NO_VANILLA)) {
                        if (!entity.level().isClientSide())
                            entity.discard();
                    }
                }
            }
            world = _worldorig;
        }
    }
}
