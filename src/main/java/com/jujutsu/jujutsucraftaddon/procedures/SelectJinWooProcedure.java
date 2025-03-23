package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.SelectedProcedure;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

import java.util.HashMap;

public class SelectJinWooProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
        if (entity != null && guistate != null) {
            double _setval = 100.0;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                capability.PlayerCurseTechnique = _setval;
                capability.syncPlayerVariables(entity);
            });
            SelectedProcedure.execute(world, x, y, z, entity, guistate);
        }
    }
}
