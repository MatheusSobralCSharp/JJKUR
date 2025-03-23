package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.world.entity.Entity;

public class Body1Procedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        {
            String _setval = "";
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.MobTexture = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
        {
            String _setval = "";
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.SkinName1 = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
    }
}
