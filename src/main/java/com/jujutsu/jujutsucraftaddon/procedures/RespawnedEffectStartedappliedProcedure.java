package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.fml.ModList;

public class RespawnedEffectStartedappliedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;

        if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_FINGER_RESET)) {
            if (!(entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).FingerReset) {
                {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "advancement revoke @s from jujutsucraft:sukuna_finger_1");
                    }
                }
                {
                    boolean _setval = true;
                    entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.FingerReset = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
            }

        }

        if (entity instanceof LivingEntity _entity) {
            {
                double _setval = _entity.getAttribute((Attribute) Attributes.MOVEMENT_SPEED).getBaseValue();
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.TrueSpeed = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        }


        {
            double _setval = (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_RCT_LEVEL_CAP));
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.RCTLimitLevel = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
        {
            double _setval = (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_HP_CAP));
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.HPCap = _setval;
                capability.syncPlayerVariables(entity);
            });
        }

        if (ModList.get().isLoaded("jjkueffects")) {
            {
                boolean _setval = true;
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Effects = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        } else {
            {
                boolean _setval = false;
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Effects = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        }
        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTCount < 1) {
            {
                double _setval = 1;
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.RCTCount = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        }
        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).blackflashmastery < 1) {
            {
                double _setval = 1;
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.blackflashmastery = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        }
        {
            double _setval = x;
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.AnimationDefense = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
        {
            double _setval = y;
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.AnimationSlash = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
        {
            double _setval = z;
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.AnimationYuzuki = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
        if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_NO_OPEN_FOR_SUKUNA)) {
            {
                Entity _ent = entity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                            _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run advancement revoke @s only jujutsucraft:mastery_open_barrier_type_domain");
                }
            }
        }
        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).blackflashmastery >= (world.getLevelData().getGameRules()
                .getInt(JujutsucraftaddonModGameRules.JJKU_BF_MASTERY_CAP))) {
            {
                double _setval = (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_BF_MASTERY_CAP));
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.blackflashmastery = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        }
        if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_CURSED_SPIRIT_RCT)) {
            {
                boolean _setval = true;
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.rctspirit = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        } else {
            {
                boolean _setval = false;
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.rctspirit = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        }
        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).YutaCheck == 1) {
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.PlayerCurseTechnique2 = 5;
                capability.syncPlayerVariables(entity);
            });
            {
                double _setval = 0;
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.YutaCheck = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        }
        if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_MAHORAGA_CAN_ADAPT_EVERYTHING)) {
            if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 16) {
                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).MahoragaCanAdapt != 1) {
                    {
                        double _setval = 1;
                        entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.MahoragaCanAdapt = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                }
            }
        } else if (!world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_MAHORAGA_CAN_ADAPT_EVERYTHING)) {
            if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 16) {
                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).MahoragaCanAdapt != 0) {
                    {
                        double _setval = 0;
                        entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.MahoragaCanAdapt = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                }
            }
        }
        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == -1) {
            {
                boolean _setval = false;
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.IsVessel = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
            {
                boolean _setval = false;
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.IsCursedSpirit = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        }
        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SpeedValue > 0) {
            if (entity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
                _livingEntity13.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SpeedValue));
        }
        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).HealthAttribute > 0) {
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).HPCap > 0) {
                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).HealthAttribute <= (entity
                        .getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).HPCap) {
                    if ((entity instanceof LivingEntity _livingEntity14 && _livingEntity14.getAttributes().hasAttribute(Attributes.MAX_HEALTH)
                            ? _livingEntity14.getAttribute(Attributes.MAX_HEALTH).getBaseValue()
                            : 0) != (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).HealthAttribute) {
                        if (entity instanceof LivingEntity _livingEntity15 && _livingEntity15.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                            _livingEntity15.getAttribute(Attributes.MAX_HEALTH)
                                    .setBaseValue(((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).HealthAttribute));
                    }
                } else {
                    if ((entity instanceof LivingEntity _livingEntity16 && _livingEntity16.getAttributes().hasAttribute(Attributes.MAX_HEALTH)
                            ? _livingEntity16.getAttribute(Attributes.MAX_HEALTH).getBaseValue()
                            : 0) != (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).HPCap) {
                        if (entity instanceof LivingEntity _livingEntity17 && _livingEntity17.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                            _livingEntity17.getAttribute(Attributes.MAX_HEALTH).setBaseValue(((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).HPCap));
                    }
                }
            }
        }
        if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Trait).equals("Gifted")) {
            if (entity instanceof LivingEntity _livingEntity19 && _livingEntity19.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
                _livingEntity19.getAttribute(Attributes.MOVEMENT_SPEED)
                        .setBaseValue(((entity instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity18.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) + 0.2));
            if (entity instanceof LivingEntity _livingEntity21 && _livingEntity21.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
                _livingEntity21.getAttribute(Attributes.ATTACK_DAMAGE)
                        .setBaseValue(((entity instanceof LivingEntity _livingEntity20 && _livingEntity20.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity20.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0) + 0.2));
            if (entity instanceof LivingEntity _livingEntity23 && _livingEntity23.getAttributes().hasAttribute(Attributes.ARMOR))
                _livingEntity23.getAttribute(Attributes.ARMOR)
                        .setBaseValue(((entity instanceof LivingEntity _livingEntity22 && _livingEntity22.getAttributes().hasAttribute(Attributes.ARMOR) ? _livingEntity22.getAttribute(Attributes.ARMOR).getBaseValue() : 0) + 0.2));
            if (entity instanceof LivingEntity _livingEntity25 && _livingEntity25.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                _livingEntity25.getAttribute(Attributes.MAX_HEALTH)
                        .setBaseValue(((entity instanceof LivingEntity _livingEntity24 && _livingEntity24.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity24.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) + 0.2));
        } else if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Trait).equals("The Honored One")) {
            if (entity instanceof LivingEntity _livingEntity27 && _livingEntity27.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
                _livingEntity27.getAttribute(Attributes.ATTACK_DAMAGE)
                        .setBaseValue(((entity instanceof LivingEntity _livingEntity26 && _livingEntity26.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity26.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0) + 0.5));
            if (entity instanceof LivingEntity _livingEntity29 && _livingEntity29.getAttributes().hasAttribute(Attributes.ARMOR))
                _livingEntity29.getAttribute(Attributes.ARMOR)
                        .setBaseValue(((entity instanceof LivingEntity _livingEntity28 && _livingEntity28.getAttributes().hasAttribute(Attributes.ARMOR) ? _livingEntity28.getAttribute(Attributes.ARMOR).getBaseValue() : 0) + 0.5));
            if (entity instanceof LivingEntity _livingEntity31 && _livingEntity31.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                _livingEntity31.getAttribute(Attributes.MAX_HEALTH)
                        .setBaseValue(((entity instanceof LivingEntity _livingEntity30 && _livingEntity30.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity30.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) + 0.5));
            {
                Entity _ent = entity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                            _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "advancement grant @s only jujutsucraft:advancement_six_eye");
                }
            }
            {
                Entity _ent = entity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                            _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "advancement grant @s only jujutsucraft:skill_infinity");
                }
            }
            if (!(entity instanceof ServerPlayer _plr34 && _plr34.level() instanceof ServerLevel
                    && _plr34.getAdvancements().getOrStartProgress(_plr34.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:cursed_fists"))).isDone())) {
                if (entity instanceof ServerPlayer _player) {
                    Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:extension_technique"));
                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                    if (!_ap.isDone()) {
                        for (String criteria : _ap.getRemainingCriteria())
                            _player.getAdvancements().award(_adv, criteria);
                    }
                }
                if (entity instanceof ServerPlayer _player) {
                    Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:cursed_fists"));
                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                    if (!_ap.isDone()) {
                        for (String criteria : _ap.getRemainingCriteria())
                            _player.getAdvancements().award(_adv, criteria);
                    }
                }
            }
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.FlagSixEyes = true;
                capability.syncPlayerVariables(entity);
            });
        } else if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Trait).equals("The Fallen One")) {
            if (entity instanceof LivingEntity _livingEntity42 && _livingEntity42.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
                _livingEntity42.getAttribute(Attributes.ATTACK_DAMAGE)
                        .setBaseValue(((entity instanceof LivingEntity _livingEntity41 && _livingEntity41.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity41.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0) + 1));
            if (entity instanceof LivingEntity _livingEntity44 && _livingEntity44.getAttributes().hasAttribute(Attributes.ARMOR))
                _livingEntity44.getAttribute(Attributes.ARMOR)
                        .setBaseValue(((entity instanceof LivingEntity _livingEntity43 && _livingEntity43.getAttributes().hasAttribute(Attributes.ARMOR) ? _livingEntity43.getAttribute(Attributes.ARMOR).getBaseValue() : 0) + 1));
            if (entity instanceof LivingEntity _livingEntity46 && _livingEntity46.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                _livingEntity46.getAttribute(Attributes.MAX_HEALTH)
                        .setBaseValue(((entity instanceof LivingEntity _livingEntity45 && _livingEntity45.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity45.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) + 1));
            if (!(entity instanceof ServerPlayer _plr47 && _plr47.level() instanceof ServerLevel
                    && _plr47.getAdvancements().getOrStartProgress(_plr47.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:cursed_fists"))).isDone())) {
                if (entity instanceof ServerPlayer _player) {
                    Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:extension_technique"));
                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                    if (!_ap.isDone()) {
                        for (String criteria : _ap.getRemainingCriteria())
                            _player.getAdvancements().award(_adv, criteria);
                    }
                }
                if (entity instanceof ServerPlayer _player) {
                    Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:enchained"));
                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                    if (!_ap.isDone()) {
                        for (String criteria : _ap.getRemainingCriteria())
                            _player.getAdvancements().award(_adv, criteria);
                    }
                }
                if (entity instanceof ServerPlayer _player) {
                    Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:barrierless_domain_perfected"));
                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                    if (!_ap.isDone()) {
                        for (String criteria : _ap.getRemainingCriteria())
                            _player.getAdvancements().award(_adv, criteria);
                    }
                }
                if (entity instanceof ServerPlayer _player) {
                    Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:cursed_fists"));
                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                    if (!_ap.isDone()) {
                        for (String criteria : _ap.getRemainingCriteria())
                            _player.getAdvancements().award(_adv, criteria);
                    }
                }
            }
        } else if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Trait).equals("Cursed")) {
            if (entity instanceof LivingEntity _livingEntity56 && _livingEntity56.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
                _livingEntity56.getAttribute(Attributes.MOVEMENT_SPEED)
                        .setBaseValue(((entity instanceof LivingEntity _livingEntity55 && _livingEntity55.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity55.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) + 0.1));
            if (entity instanceof LivingEntity _livingEntity58 && _livingEntity58.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
                _livingEntity58.getAttribute(Attributes.ATTACK_DAMAGE)
                        .setBaseValue(((entity instanceof LivingEntity _livingEntity57 && _livingEntity57.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity57.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0) + 0.1));
            if (entity instanceof LivingEntity _livingEntity60 && _livingEntity60.getAttributes().hasAttribute(Attributes.ARMOR))
                _livingEntity60.getAttribute(Attributes.ARMOR)
                        .setBaseValue(((entity instanceof LivingEntity _livingEntity59 && _livingEntity59.getAttributes().hasAttribute(Attributes.ARMOR) ? _livingEntity59.getAttribute(Attributes.ARMOR).getBaseValue() : 0) + 0.1));
            if (entity instanceof LivingEntity _livingEntity62 && _livingEntity62.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                _livingEntity62.getAttribute(Attributes.MAX_HEALTH)
                        .setBaseValue(((entity instanceof LivingEntity _livingEntity61 && _livingEntity61.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity61.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) + 0.1));
        } else if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Trait).equals("Speedy")) {
            if (entity instanceof LivingEntity _livingEntity64 && _livingEntity64.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
                _livingEntity64.getAttribute(Attributes.MOVEMENT_SPEED)
                        .setBaseValue(((entity instanceof LivingEntity _livingEntity63 && _livingEntity63.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity63.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) + 0.1));
        } else if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Trait).equals("Strong")) {
            if (entity instanceof LivingEntity _livingEntity66 && _livingEntity66.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
                _livingEntity66.getAttribute(Attributes.ATTACK_DAMAGE)
                        .setBaseValue(((entity instanceof LivingEntity _livingEntity65 && _livingEntity65.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity65.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0) + 0.1));
        } else if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Trait).equals("Resistant")) {
            if (entity instanceof LivingEntity _livingEntity68 && _livingEntity68.getAttributes().hasAttribute(Attributes.ARMOR))
                _livingEntity68.getAttribute(Attributes.ARMOR)
                        .setBaseValue(((entity instanceof LivingEntity _livingEntity67 && _livingEntity67.getAttributes().hasAttribute(Attributes.ARMOR) ? _livingEntity67.getAttribute(Attributes.ARMOR).getBaseValue() : 0) + 0.1));
        } else if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Trait).equals("Healthy")) {
            if (entity instanceof LivingEntity _livingEntity70 && _livingEntity70.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                _livingEntity70.getAttribute(Attributes.MAX_HEALTH)
                        .setBaseValue(((entity instanceof LivingEntity _livingEntity69 && _livingEntity69.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity69.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) + 0.1));
        }
        if (ModList.get().isLoaded("jjkueffects")) {
            {
                boolean _setval = true;
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Effects = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        } else {
            {
                boolean _setval = false;
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Effects = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        }
    }
}
