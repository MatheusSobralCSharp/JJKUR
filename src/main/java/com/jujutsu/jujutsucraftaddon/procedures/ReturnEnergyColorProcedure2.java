package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.YutaCullingGamesEntity;
import net.mcreator.jujutsucraft.entity.*;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class ReturnEnergyColorProcedure2 {
    public ReturnEnergyColorProcedure2() {
    }

    public static double execute(Entity entity) {
        if (entity == null) {
            return 0.0;
        } else {
            double curse_energy_color = 0.0;
            curse_energy_color = 1.0;
            if (entity instanceof Player) {
                if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 5.0 || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 5.0) {
                    curse_energy_color = 3.0;
                }

                if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerMAX <= 150.0) {
                    curse_energy_color = 0.0;
                }
            } else {
                if (entity instanceof OkkotsuYutaEntity || entity instanceof OkkotsuYutaCullingGameEntity || entity instanceof YutaCullingGamesEntity || entity instanceof RikaEntity || entity instanceof Rika2Entity) {
                    curse_energy_color = 3.0;
                }

                if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:no_curse_power"))) || entity instanceof ZeninMakiEntity) {
                    curse_energy_color = 0.0;
                }
            }

            LivingEntity _livEnt9;
            label39: {
                label38: {
                    if (entity instanceof LivingEntity) {
                        _livEnt9 = (LivingEntity)entity;
                        if (_livEnt9.hasEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                            break label38;
                        }
                    }

                    if (!(entity instanceof CursedSpiritGrade01Entity)) {
                        break label39;
                    }
                }

                curse_energy_color = 2.0;
            }

            if (entity instanceof LivingEntity) {
                _livEnt9 = (LivingEntity)entity;
                if (_livEnt9.hasEffect((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                    curse_energy_color = 4.0;
                }
            }

            return curse_energy_color;
        }
    }
}
