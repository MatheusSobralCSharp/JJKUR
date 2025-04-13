package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class CursedLevelGainProcedure {
    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if (!world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_NO_POWER_PROGRESS)) {
            if ((Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString()).startsWith("jujutsucraft")) {
                if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) < 18) {
                    if (!((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Profession).equals("Sage")) {
                        {
                            double _setval = (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CursedLevel + 5;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.CursedLevel = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                        if (Math.random() < (1) / ((float) 5)) {
                            {
                                double _setval = (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).sp + 1;
                                sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.sp = _setval;
                                    capability.syncPlayerVariables(sourceentity);
                                });
                            }
                        }
                    } else if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Profession).equals("Sage")) {
                        {
                            double _setval = (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CursedLevel + 5 * 5;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.CursedLevel = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                        if (Math.random() < (1) / ((float) 5)) {
                            {
                                double _setval = (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).sp + 2;
                                sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.sp = _setval;
                                    capability.syncPlayerVariables(sourceentity);
                                });
                            }
                        }
                    }
                } else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) > 18) {
                    if (!((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Profession).equals("Sage")) {
                        {
                            double _setval = (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CursedLevel + 50;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.CursedLevel = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                        if (Math.random() < (1) / ((float) 5)) {
                            {
                                double _setval = (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).sp + 3;
                                sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.sp = _setval;
                                    capability.syncPlayerVariables(sourceentity);
                                });
                            }
                        }
                    } else if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Profession).equals("Sage")) {
                        {
                            double _setval = (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CursedLevel + 50 * 5;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.CursedLevel = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                        if (Math.random() < (1) / ((float) 5)) {
                            {
                                double _setval = (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).sp + 5;
                                sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.sp = _setval;
                                    capability.syncPlayerVariables(sourceentity);
                                });
                            }
                        }
                    }
                }
            }
            if (sourceentity instanceof ServerPlayer && sourceentity.level() instanceof ServerLevel
                    && ((ServerPlayer) sourceentity).getAdvancements().getOrStartProgress(Objects.requireNonNull(((ServerPlayer) sourceentity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sorcerer_grade_special")))).isDone()) {
                if (!(sourceentity instanceof ServerPlayer _plr9 && _plr9.level() instanceof ServerLevel
                        && _plr9.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr9.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:strong_sorcerer_grade")))).isDone())
                        && (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CursedLevel >= 4800
                        * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SYSTEM_UPGRADE_DIFFICULTY))) {
                    if (sourceentity instanceof ServerPlayer _player) {
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:strong_sorcerer_grade"));
                        assert _adv != null;
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                            for (String criteria : _ap.getRemainingCriteria())
                                _player.getAdvancements().award(_adv, criteria);
                        }
                    }
                }
                if (!(sourceentity instanceof ServerPlayer _plr12 && _plr12.level() instanceof ServerLevel
                        && _plr12.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr12.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:sorcerer_strongest_of_modern")))).isDone())
                        && (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CursedLevel >= 9600
                        * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SYSTEM_UPGRADE_DIFFICULTY))) {
                    if (sourceentity instanceof ServerPlayer _player) {
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:sorcerer_strongest_of_modern"));
                        assert _adv != null;
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                            for (String criteria : _ap.getRemainingCriteria())
                                _player.getAdvancements().award(_adv, criteria);
                        }
                    }
                }
                if (!(sourceentity instanceof ServerPlayer _plr15 && _plr15.level() instanceof ServerLevel
                        && _plr15.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr15.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:special_grade_one")))).isDone())
                        && (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CursedLevel >= 2400
                        * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SYSTEM_UPGRADE_DIFFICULTY))) {
                    if (sourceentity instanceof ServerPlayer _player) {
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:special_grade_one"));
                        assert _adv != null;
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                            for (String criteria : _ap.getRemainingCriteria())
                                _player.getAdvancements().award(_adv, criteria);
                        }
                    }
                }
                if (!(sourceentity instanceof ServerPlayer _plr18 && _plr18.level() instanceof ServerLevel
                        && _plr18.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr18.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:sorcerer_strongest_of_history")))).isDone())
                        && (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CursedLevel >= 20000
                        * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SYSTEM_UPGRADE_DIFFICULTY))) {
                    if (sourceentity instanceof ServerPlayer _player) {
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:sorcerer_strongest_of_history"));
                        assert _adv != null;
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                            for (String criteria : _ap.getRemainingCriteria())
                                _player.getAdvancements().award(_adv, criteria);
                        }
                    }
                }
            }
        }
    }
}
