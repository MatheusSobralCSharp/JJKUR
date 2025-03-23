package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.world.entity.Entity;

public class OnButtonClickedProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        {
            double _setval = 0;
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.Copy1 = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
        {
            double _setval = 0;
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.Copy2 = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
        {
            double _setval = 0;
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.Copy3 = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
        {
            double _setval = 0;
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.Copy4 = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
    }
}
