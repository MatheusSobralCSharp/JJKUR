package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class AnimationEffectProcedureExpires {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;

        {
            double _setval = 0;
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.CustceneDone = _setval;
                capability.syncPlayerVariables(entity);
            });
        }

    }
}
