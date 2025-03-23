package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.world.entity.Entity;

public class ResetSubraceProcedure {
    public static void execute(Entity entity) {
        {
            String _setval = "";
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.Subrace = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
    }
}
