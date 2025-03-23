package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;

public class FixProcedure {
    public static void execute(
            LevelAccessor world,
            Entity entity
    ) {
        if (
                entity == null
        ) return;
        {
            double _setval = 0;
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.CEPlus = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
        {
            double _setval = 200;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.PlayerCursePowerFormer = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
        {
            double _setval = (entity instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity12.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0);
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.HealthAttribute = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
    }
}
