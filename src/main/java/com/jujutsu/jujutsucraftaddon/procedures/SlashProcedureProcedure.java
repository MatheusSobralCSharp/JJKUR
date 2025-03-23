package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

public class SlashProcedureProcedure {
    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, double amount) {
        if (entity == null || sourceentity == null)
            return;
        if (!sourceentity.isShiftKeyDown()) {
            if (!(sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).WorldSlash) {
                if (entity instanceof LivingEntity) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("skill");
                        }
                    }.getValue() == 105) {
                        if (ModList.get().isLoaded("jjkueffects")) {
                            if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:sukuna")
                                    || (ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:sukuna_fushiguro")) {
                                if (Math.random() < 0.5) {
                                    {
                                        Entity _ent = entity;
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "particle jjkueffects:dismantle ~ ~1 ~ 0 0 0 1 1 force");
                                        }
                                    }
                                } else if (Math.random() > 0.5) {
                                    {
                                        Entity _ent = entity;
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "particle jjkueffects:dismantle ~ ~1 ~ 0 0 0 1 1 force");
                                        }
                                    }
                                }
                            } else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:sukuna_perfect")) {
                                if (Math.random() < 0.5) {
                                    {
                                        Entity _ent = entity;
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "particle jjkueffects:de ~ ~1 ~ 0 0 0 1 1 force");
                                        }
                                    }
                                } else if (Math.random() > 0.5) {
                                    {
                                        Entity _ent = entity;
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "particle jjkueffects:de_2 ~ ~1 ~ 0 0 0 1 1 force");
                                        }
                                    }
                                }
                            } else {
                                if (Math.random() < 0.5) {
                                    {
                                        Entity _ent = entity;
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "particle jjkueffects:dismantle ~ ~1 ~ 0 0 0 1 1 force");
                                        }
                                    }
                                } else if (Math.random() > 0.5) {
                                    {
                                        Entity _ent = entity;
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "particle jjkueffects:dismantle ~ ~1 ~ 0 0 0 1 1 force");
                                        }
                                    }
                                }
                            }
                        } else {
                            if (Math.random() < 0.5) {
                                if (world instanceof ServerLevel _level)
                                    _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_3.get(), (entity.getX()), (entity.getY() + 1), (entity.getZ()), 0, 0, 0, 0, 1);
                            } else if (Math.random() > 0.5) {
                                if (world instanceof ServerLevel _level)
                                    _level.sendParticles(JujutsucraftaddonModParticleTypes.KAI_3.get(), (entity.getX()), (entity.getY() + 1), (entity.getZ()), 0, 0, 0, 0, 1);
                            }
                        }
                    }
                }
            } else if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).WorldSlash) {
                if (entity instanceof LivingEntity) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("skill");
                        }
                    }.getValue() == 105) {
                        if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Moveset == 4) {
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.FATIGUE.get(), 120,
                                        (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.FATIGUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.FATIGUE.get()).getAmplifier() : 0), false, true));
                            LimbssProcedure.execute(world, entity, amount);
                        }
                        if (ModList.get().isLoaded("jjkueffects")) {
                            if (Math.random() < 0.5) {
                                {
                                    Entity _ent = entity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                        _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                "particle jjkueffects:de ~ ~1 ~ 0 0 0 1 1 force");
                                    }
                                }
                            } else if (Math.random() > 0.5) {
                                {
                                    Entity _ent = entity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                        _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                "particle jjkueffects:de_2 ~ ~1 ~ 0 0 0 1 1 force");
                                    }
                                }
                            }
                        } else {
                            if (Math.random() < 0.5) {
                                if (world instanceof ServerLevel _level)
                                    _level.sendParticles(JujutsucraftaddonModParticleTypes.KAI_5.get(), (entity.getX()), (entity.getY() + 1), (entity.getZ()), 0, 0, 0, 0, 1);
                            } else if (Math.random() > 0.5) {
                                if (world instanceof ServerLevel _level)
                                    _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_5.get(), (entity.getX()), (entity.getY() + 1), (entity.getZ()), 0, 0, 0, 0, 1);
                            }
                        }
                    }
                }
            }
        }
    }
}
