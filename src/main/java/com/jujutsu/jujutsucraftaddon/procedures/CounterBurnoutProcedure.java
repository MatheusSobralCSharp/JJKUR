package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import java.util.Objects;

public class CounterBurnoutProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof LivingEntity) {
            if (entity instanceof ServerPlayer _plr1 && _plr1.level() instanceof ServerLevel
                    && _plr1.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:reverse_cursed_burnout")))).isDone()) {
                double repeats = 0.0;
                String endtext = "";
                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BrainDamage != 5) {
                    if (entity.getPersistentData().getBoolean("PRESS_BURNOUT")) {
                        LivingEntity _livEnt9;
                        Player _player;
                        if (entity.getPersistentData().getDouble("cnt_v") < 20.0) {
                            {
                                entity.getPersistentData().putDouble("cnt_v", entity.getPersistentData().getDouble("cnt_v") + 1.0);
                                endtext = "Reverse Burnout";
                            }
                            repeats = (double) Math.round((20.0 - entity.getPersistentData().getDouble("cnt_v")) * 0.25);
                            for (int index0 = 0; index0 < (int) repeats; ++index0) {
                                endtext = "■" + endtext + "■";
                            }
                            if (entity instanceof Player) {
                                _player = (Player) entity;
                                if (!_player.level().isClientSide()) {
                                    _player.displayClientMessage(Component.literal(endtext), true);
                                }
                            }
                        }
                        if (entity.getPersistentData().getDouble("cnt_v") == 20.0) {
                            {
                                Entity _ent;
                                if (entity instanceof LivingEntity) {
                                    _livEnt9 = (LivingEntity) entity;
                                    if (_livEnt9.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                        _ent = entity;
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "effect clear @s jujutsucraft:cooldown_time");
                                        }
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "effect clear @s jujutsucraft:cooldown_time_combat");
                                        }
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "effect clear @s jujutsucraft:unstable");
                                        }
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "effect clear @s jujutsucraft:cooldown_time");
                                        }
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "effect clear @s jujutsucraft:cooldown_time_combat");
                                        }
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "effect clear @s jujutsucraft:unstable");
                                        }
                                        if (_livEnt9.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                                _ent.getServer().getCommands()
                                                        .performPrefixedCommand(
                                                                new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                                                        _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                                "execute as @s at @s run particle jujutsucraft:particle_curse_power_red ~ ~1.8 ~ 0 0 0 0.1 10 normal");
                                            }
                                        } else if (_livEnt9.hasEffect(JujutsucraftModMobEffects.JACKPOT.get())) {
                                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                                _ent.getServer().getCommands()
                                                        .performPrefixedCommand(
                                                                new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                                                        _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                                "execute as @s at @s run particle jujutsucraft:particle_curse_power_green ~ ~1.8 ~ 0 0 0 0.1 10 normal");
                                            }
                                        } else {
                                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                                _ent.getServer().getCommands()
                                                        .performPrefixedCommand(
                                                                new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                                                        _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                                "execute as @s at @s run particle jujutsucraft:particle_curse_power_blue ~ ~1.8 ~ 0 0 0 0.1 10 normal");
                                            }
                                        }
                                        if (entity instanceof Player _player2 && !_player2.level().isClientSide()) {
                                            _player2.displayClientMessage(Component.literal("Recovered Exhausted Techniques"), false);
                                        }
                                        if (entity.getPersistentData().getDouble("CursedSpirit") != 1) {
                                            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BrainDamage == 4) {
                                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BROKEN_BRAIN.get(), 2400, 1, false, false));
                                                {
                                                    double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BrainDamage + 1;
                                                    entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                                        capability.BrainDamage = _setval;
                                                        capability.syncPlayerVariables(entity);
                                                    });
                                                }
                                            } else {
                                                {
                                                    double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BrainDamage + 1;
                                                    entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                                        capability.BrainDamage = _setval;
                                                        capability.syncPlayerVariables(entity);
                                                    });
                                                }
                                            }
                                        }
                                        if (entity instanceof LivingEntity _entity1 && !_entity1.level().isClientSide())
                                            _entity1.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.FATIGUE.get(), 300, 1, false, false));

                                    } else if (_livEnt9.hasEffect(JujutsucraftModMobEffects.UNSTABLE.get())) {
                                        _ent = entity;
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "effect clear @s jujutsucraft:cooldown_time");
                                        }
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "effect clear @s jujutsucraft:cooldown_time_combat");
                                        }
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "effect clear @s jujutsucraft:unstable");
                                        }
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "effect clear @s jujutsucraft:cooldown_time");
                                        }
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "effect clear @s jujutsucraft:cooldown_time_combat");
                                        }
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "effect clear @s jujutsucraft:unstable");
                                        }
                                        if (_livEnt9.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                                _ent.getServer().getCommands()
                                                        .performPrefixedCommand(
                                                                new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                                                        _ent.getName().getString(), _ent.getDisplayName(), Objects.requireNonNull(_ent.level().getServer()), _ent),
                                                                "execute as @s at @s run particle jujutsucraft:particle_curse_power_red ~ ~1.8 ~ 0 0 0 0.1 10 normal");
                                            }
                                        } else if (_livEnt9.hasEffect(JujutsucraftModMobEffects.JACKPOT.get())) {
                                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                                _ent.getServer().getCommands()
                                                        .performPrefixedCommand(
                                                                new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                                                        _ent.getName().getString(), _ent.getDisplayName(), Objects.requireNonNull(_ent.level().getServer()), _ent),
                                                                "execute as @s at @s run particle jujutsucraft:particle_curse_power_green ~ ~1.8 ~ 0 0 0 0.1 10 normal");
                                            }
                                        } else {
                                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                                _ent.getServer().getCommands()
                                                        .performPrefixedCommand(
                                                                new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                                                        _ent.getName().getString(), _ent.getDisplayName(), Objects.requireNonNull(_ent.level().getServer()), _ent),
                                                                "execute as @s at @s run particle jujutsucraft:particle_curse_power_blue ~ ~1.8 ~ 0 0 0 0.1 10 normal");
                                            }
                                        }
                                        if (entity instanceof Player _player2 && !_player2.level().isClientSide()) {
                                            _player2.displayClientMessage(Component.literal("Recovered Exhausted Techniques"), false);
                                        }

                                        if (entity instanceof LivingEntity _entity1 && !_entity1.level().isClientSide())
                                            _entity1.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.FATIGUE.get(), 300, 1, false, false));
                                        if (entity.getPersistentData().getDouble("CursedSpirit") != 1) {
                                            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BrainDamage == 4) {
                                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BROKEN_BRAIN.get(), 2400, 1, false, false));
                                                {
                                                    double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BrainDamage + 1;
                                                    entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                                        capability.BrainDamage = _setval;
                                                        capability.syncPlayerVariables(entity);
                                                    });
                                                }
                                            } else {
                                                {
                                                    double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BrainDamage + 1;
                                                    entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                                        capability.BrainDamage = _setval;
                                                        capability.syncPlayerVariables(entity);
                                                    });
                                                }
                                            }
                                        }
                                    }
                                    entity.getPersistentData().putDouble("cnt_v", 0.0);
                                    entity.getPersistentData().putBoolean("PRESS_BURNOUT", false);
                                }
                                if (entity instanceof Player) {
                                    _player = (Player) entity;
                                    if (!_player.level().isClientSide()) {
                                        _player.displayClientMessage(Component.literal(""), true);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
