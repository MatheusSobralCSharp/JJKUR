package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

import java.util.Objects;

public class CeLevelProcedure {
    public static void execute(LevelAccessor world, Entity sourceentity) {
        if (sourceentity == null)
            return;

        if (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_POWER_CAP) > 0) {
            if (sourceentity instanceof ServerPlayer _plr3 && _plr3.level() instanceof ServerLevel){
                if (!((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) >= (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_POWER_CAP)))) {
                    if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_POWER_CAP)), false, false));
                }
            }
        } else if (sourceentity instanceof ServerPlayer _plr3 && _plr3.level() instanceof ServerLevel
                && _plr3.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr3.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:grade_yin_yang")))).isDone()) {
            if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CursedLevel >= 50000 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SYSTEM_UPGRADE_DIFFICULTY))) {
                if (!((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) >= 32)) {
                    if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 32, false, false));
                }
            }
        } else if (sourceentity instanceof ServerPlayer _plr3 && _plr3.level() instanceof ServerLevel
                && _plr3.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr3.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:grade_ryomen_sage")))).isDone()) {
            if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CursedLevel >= 40000 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SYSTEM_UPGRADE_DIFFICULTY))) {
                if (!((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) >= 30)) {
                    if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 30, false, false));
                }
            }
        } else if (sourceentity instanceof ServerPlayer _plr3 && _plr3.level() instanceof ServerLevel
                && _plr3.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr3.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:grade_wu")))).isDone()) {
            if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CursedLevel >= 30000 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SYSTEM_UPGRADE_DIFFICULTY))) {
                if (!((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) >= 28)) {
                    if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
                }
            }
        } else if (sourceentity instanceof ServerPlayer _plr3 && _plr3.level() instanceof ServerLevel
                && _plr3.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr3.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:sorcerer_strongest_of_history")))).isDone()) {
            if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CursedLevel >= 20000 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SYSTEM_UPGRADE_DIFFICULTY))) {
                if (!((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) >= 27)) {
                    if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 27, false, false));
                }
            }
        } else if (sourceentity instanceof ServerPlayer _plr3 && _plr3.level() instanceof ServerLevel
                && _plr3.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr3.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:sorcerer_strongest_of_modern")))).isDone()) {
            if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CursedLevel >= 15000 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SYSTEM_UPGRADE_DIFFICULTY))) {
                if (!((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) >= 25)) {
                    if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 25, false, false));
                }
            }
        } else if (sourceentity instanceof ServerPlayer _plr3 && _plr3.level() instanceof ServerLevel
                && _plr3.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr3.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:strong_sorcerer_grade")))).isDone()) {
            if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CursedLevel >= 10000 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SYSTEM_UPGRADE_DIFFICULTY))) {
                if (!((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) >= 23)) {
                    if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 23, false, false));
                }
            }
        } else if (sourceentity instanceof ServerPlayer _plr3 && _plr3.level() instanceof ServerLevel
                && _plr3.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr3.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:special_grade_one")))).isDone()) {
            if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CursedLevel >= 5000 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SYSTEM_UPGRADE_DIFFICULTY))) {
                if (!((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) >= 21)) {
                    if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 21, false, false));
                }
            }
        }
    }
}
