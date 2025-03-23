package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.world.entity.Entity;

public class Body2Procedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        {
            String _setval = "";
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.MobTexture2 = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
        {
            String _setval = "";
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.SkinName2 = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
    }
}
