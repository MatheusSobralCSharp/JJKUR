package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KeyReverseCursedTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraft.procedures.KeyReverseCursedTechniqueOnKeyReleasedProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class AutoRCTNewProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity.isAlive()) {
            if (entity instanceof LivingEntity) {
                if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower >= 1000.0) {
                    LivingEntity _livEnt0 = (LivingEntity) entity;
                    if (_livEnt0.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                        KeyReverseCursedTechniqueOnKeyReleasedProcedure.execute(entity);
                        return;
                    }

                    float var10000;
                    if (entity instanceof LivingEntity _livEnt) {
                        var10000 = _livEnt.getHealth();
                    } else {
                        var10000 = -1.0F;
                    }

                    double var11 = var10000;
                    float var10001;
                    if (entity instanceof LivingEntity _livEnt) {
                        var10001 = _livEnt.getMaxHealth();
                    } else {
                        var10001 = -1.0F;
                    }

                    if (var11 < (double) var10001 - 0.5) {
                        KeyReverseCursedTechniqueOnKeyPressedProcedure.execute(entity);
                    } else {
                        KeyReverseCursedTechniqueOnKeyReleasedProcedure.execute(entity);
                    }
                } else {
                    if (entity instanceof LivingEntity _entity) {
                        _entity.removeEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get());
                    }
                }

            }
        }

    }
}

