package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class SetYutaCTProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            capability.PlayerCurseTechnique2 = 5;
            capability.syncPlayerVariables(entity);
        });
    }
}
