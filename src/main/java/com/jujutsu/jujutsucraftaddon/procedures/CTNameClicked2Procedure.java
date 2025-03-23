package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.world.entity.Entity;

public class CTNameClicked2Procedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        {
            double _setval = 0;
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.KenjakuCT2 = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
    }
}
