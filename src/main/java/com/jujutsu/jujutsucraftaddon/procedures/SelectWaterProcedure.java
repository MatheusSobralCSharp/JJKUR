package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.world.entity.Entity;

public class SelectWaterProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        {
            String _setval = "Water";
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.Element = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
    }
}
