package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.entity.CrowEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KeyChangeTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraft.procedures.PlayerSetProfessionProcedure;
import net.mcreator.jujutsucraft.procedures.SummonCrowProcedure;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ConcorrentSpawnProcedure {
    public static void execute(Entity entity, LevelAccessor world, double x, double y, double z) {
        if (entity != null) {
            String STR1 = "";
            double sukuna_level = 0.0;
            double x_pos = 0.0;
            double z_pos = 0.0;
            double NUM1 = 0.0;
            Entity _ent = entity;
            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "advancement revoke @s only jujutsucraft:update");
            }

            Advancement _adv;
            AdvancementProgress _ap;
            Iterator var21;
            String criteria;
            ServerPlayer _player;
            if (entity instanceof ServerPlayer) {
                _player = (ServerPlayer) entity;
                _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:update"));
                _ap = _player.getAdvancements().getOrStartProgress(_adv);
                if (!_ap.isDone()) {
                    var21 = _ap.getRemainingCriteria().iterator();

                    while (var21.hasNext()) {
                        criteria = (String) var21.next();
                        _player.getAdvancements().award(_adv, criteria);
                    }
                }
            }


            if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).friend_num_keep != 0.0) {
                entity.getPersistentData().putDouble("friend_num", ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).friend_num_keep);
                x_pos = 0.0;
                z_pos = 0.0;
                _ent = entity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    Commands var10000 = _ent.getServer().getCommands();
                    CommandSourceStack var10001 = new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent);
                    long var10002 = Math.round(x_pos);
                    var10000.performPrefixedCommand(var10001, "execute in jujutsucraft:cursed_spirit_manipulation_dimension run forceload add " + var10002 + " " + Math.round(z_pos));
                }

                if (world instanceof ServerLevel) {
                    ServerLevel _origLevel = (ServerLevel) world;
                    LevelAccessor world2 = _origLevel.getServer().getLevel(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension")));
                    if (world2 != null) {
                        Vec3 _center = new Vec3(x_pos, 128.0, z_pos);
                        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(128.0), (e) -> {
                            return true;
                        }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                            return _entcnd.distanceToSqr(_center);
                        })).toList();
                        Iterator var38 = _entfound.iterator();

                        label243:
                        while (true) {
                            Entity entityiterator;
                            do {
                                do {
                                    do {
                                        if (!var38.hasNext()) {
                                            break label243;
                                        }

                                        entityiterator = (Entity) var38.next();
                                    } while (entity == entityiterator);
                                } while (!entityiterator.isAlive());
                            } while (entity.getPersistentData().getDouble("friend_num") != entityiterator.getPersistentData().getDouble("friend_num_worker"));

                            NUM1 = 0.0;

                            for (int index0 = 0; index0 < 10000; ++index0) {
                                ++NUM1;
                                STR1 = "data_cursed_spirit_manipulation" + Math.round(NUM1);
                                if (entity.getPersistentData().getDouble(STR1) == 0.0 || entity.getPersistentData().getDouble(STR1) == entityiterator.getY() || entity.getPersistentData().getString(STR1 + "_name").equals(entityiterator.getDisplayName().getString())) {
                                    entity.getPersistentData().putDouble(STR1, entityiterator.getY());
                                    entity.getPersistentData().putString(STR1 + "_name", entityiterator.getDisplayName().getString());
                                    entity.getPersistentData().putDouble(STR1 + "_num", entity.getPersistentData().getDouble(STR1 + "_num") + 1.0);
                                    break;
                                }
                            }

                            entityiterator.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                            entityiterator.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                        }
                    }

                    world = world;
                }

                double _setval = 0.0;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                    capability.friend_num_keep = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }

            if ((((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 11.0 || ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 11.0) && world.getEntitiesOfClass(CrowEntity.class, AABB.ofSize(new Vec3(x, y, z), 32.0, 32.0, 32.0), (e) -> {
                return true;
            }).isEmpty()) {
                SummonCrowProcedure.execute(world, x, y, z, entity);
            }

            boolean _setval;
            LivingEntity _livingEntity35;
            if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerFlag_A) {
                _setval = false;
                boolean final_setval = _setval;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                    capability.PlayerFlag_A = final_setval;
                    capability.syncPlayerVariables(entity);
                });
                if (entity instanceof LivingEntity) {
                    _livingEntity35 = (LivingEntity) entity;
                    if (_livingEntity35.getAttributes().hasAttribute(Attributes.ARMOR)) {
                        _livingEntity35.getAttribute(Attributes.ARMOR).setBaseValue(0.0);
                    }
                }

                if (entity instanceof LivingEntity) {
                    _livingEntity35 = (LivingEntity) entity;
                    if (_livingEntity35.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS)) {
                        _livingEntity35.getAttribute(Attributes.ARMOR_TOUGHNESS).setBaseValue(0.0);
                    }
                }

                if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == -99.0) {
                    double final_setval1 = 0.0;
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                        capability.PlayerCurseTechnique = final_setval1;
                        capability.syncPlayerVariables(entity);
                    });
                    double final_setval2 = 5.0;
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                        capability.PlayerCursePowerFormer = final_setval2;
                        capability.syncPlayerVariables(entity);
                    });
                } else {
                    if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 0.0) {
                        do {
                            double final_setval6 = (double) Math.round(Math.random() * 43.0);
                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                capability.PlayerCurseTechnique = final_setval6;
                                capability.syncPlayerVariables(entity);
                            });
                        } while (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 42.0);
                    }

                    if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique <= 0.0) {
                        double final_setval7 = (double) Math.round(Math.random() * 4.0);
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                            capability.PlayerCursePowerFormer = final_setval7;
                            capability.syncPlayerVariables(entity);
                        });
                        double final_setval8 = -1.0;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                            capability.PlayerCurseTechnique = final_setval8;
                            capability.syncPlayerVariables(entity);
                        });
                        if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer == 0.0) {
                            if (entity instanceof ServerPlayer) {
                                _player = (ServerPlayer) entity;
                                _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:completely_physically_gifted"));
                                _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                if (!_ap.isDone()) {
                                    var21 = _ap.getRemainingCriteria().iterator();

                                    while (var21.hasNext()) {
                                        criteria = (String) var21.next();
                                        _player.getAdvancements().award(_adv, criteria);
                                    }
                                }
                            }

                            if (entity instanceof ServerPlayer) {
                                _player = (ServerPlayer) entity;
                                _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:observation_of_the_soul"));
                                _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                if (!_ap.isDone()) {
                                    var21 = _ap.getRemainingCriteria().iterator();

                                    while (var21.hasNext()) {
                                        criteria = (String) var21.next();
                                        _player.getAdvancements().award(_adv, criteria);
                                    }
                                }
                            }
                        }
                    } else {
                        double final_setval9 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 5.0 ? 400.0 : 200.0;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                            capability.PlayerCursePowerFormer = final_setval9;
                            capability.syncPlayerVariables(entity);
                        });
                    }

                    if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerProfession >= 0.0) {
                        _setval = Math.random() < 0.01;
                        boolean final_setval10 = _setval;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                            capability.FlagSixEyes = final_setval10;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                }

                double final_setval11 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                    capability.PlayerCurseTechnique2 = final_setval11;
                    capability.syncPlayerVariables(entity);
                });
                ItemStack _setva7l = ItemStack.EMPTY;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                    capability.BodyItem = _setva7l.copy();
                    capability.syncPlayerVariables(entity);
                });
                boolean _setval3 = false;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                    capability.flag_sukuna = _setval3;
                    capability.syncPlayerVariables(entity);
                });
                boolean _setval4 = true;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                    capability.noChangeTechnique = _setval4;
                    capability.syncPlayerVariables(entity);
                });
                boolean _setval5 = false;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                    capability.SecondTechnique = _setval5;
                    capability.syncPlayerVariables(entity);
                });
                KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            }

            double final_setval3 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer * (double) Math.round((2.0 + ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerLevel) / 1.1);
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                capability.PlayerCursePowerMAX = final_setval3;
                capability.syncPlayerVariables(entity);
            });
            if (entity instanceof LivingEntity) {
                _livingEntity35 = (LivingEntity) entity;
                if (_livingEntity35.hasEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                    int var26;
                    label168:
                    {
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEnt = (LivingEntity) entity;
                            if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                var26 = _livEnt.getEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).getAmplifier();
                                break label168;
                            }
                        }

                        var26 = 0;
                    }

                    sukuna_level = (double) Math.min(var26 + 1, 20);
                    double _setval4 = Math.max(((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerMAX, sukuna_level <= 9.0 ? 3000.0 + (sukuna_level - 1.0) * 300.0 : 8000.0 + (sukuna_level - 10.0) * 1000.0);
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                        capability.PlayerCursePowerMAX = _setval4;
                        capability.syncPlayerVariables(entity);
                    });
                }
            }

            if (!((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerFlag_B) {
                _setval = true;
                boolean final_setval4 = _setval;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                    capability.PlayerFlag_B = final_setval4;
                    capability.syncPlayerVariables(entity);
                });
                if (entity instanceof LivingEntity) {
                    _livingEntity35 = (LivingEntity) entity;
                    if (!_livingEntity35.level().isClientSide()) {
                        _livingEntity35.addEffect(new MobEffectInstance(MobEffects.HEAL, 10, 10, false, false));
                    }
                }

                if (entity instanceof LivingEntity) {
                    _livingEntity35 = (LivingEntity) entity;
                    if (_livingEntity35.getAttributes().hasAttribute(Attributes.ARMOR)) {
                        _livingEntity35.getAttribute(Attributes.ARMOR).setBaseValue(0.0);
                    }
                }

                if (entity instanceof LivingEntity) {
                    _livingEntity35 = (LivingEntity) entity;
                    if (_livingEntity35.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS)) {
                        _livingEntity35.getAttribute(Attributes.ARMOR_TOUGHNESS).setBaseValue(0.0);
                    }
                }

                double _setval8 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerMAX;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                    capability.PlayerCursePower = _setval8;
                    capability.syncPlayerVariables(entity);
                });
                double _setval9 = 0.0;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                    capability.PlayerSelectCurseTechnique = _setval9;
                    capability.syncPlayerVariables(entity);
                });
                entity.getPersistentData().putBoolean("infinity", false);
                entity.getPersistentData().putDouble("brokenBrain", 0.0);
                _setval = true;
                boolean final_setval12 = _setval;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                    capability.noChangeTechnique = final_setval12;
                    capability.syncPlayerVariables(entity);
                });
                _setval = false;
                boolean final_setval5 = _setval;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                    capability.SecondTechnique = final_setval5;
                    capability.syncPlayerVariables(entity);
                });
                KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                PlayerSetProfessionProcedure.execute(entity);
                _ent = entity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "advancement revoke @s only jujutsucraft:update");
                }

                if (entity instanceof ServerPlayer) {
                    _player = (ServerPlayer) entity;
                    _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:update"));
                    _ap = _player.getAdvancements().getOrStartProgress(_adv);
                    if (!_ap.isDone()) {
                        var21 = _ap.getRemainingCriteria().iterator();

                        while (var21.hasNext()) {
                            criteria = (String) var21.next();
                            _player.getAdvancements().award(_adv, criteria);
                        }
                    }
                }
            }

            if (JujutsucraftModVariables.MapVariables.get(world).BlastGame) {
                if (entity instanceof ServerPlayer) {
                    _player = (ServerPlayer) entity;
                    _player.setGameMode(GameType.SPECTATOR);
                }

                _ent = entity;
                _ent.teleportTo(JujutsucraftModVariables.MapVariables.get(world).BlastGameXCenter, JujutsucraftModVariables.MapVariables.get(world).BlastGameYCenter, JujutsucraftModVariables.MapVariables.get(world).BlastGameZCenter);
                if (_ent instanceof ServerPlayer) {
                    ServerPlayer _serverPlayer = (ServerPlayer) _ent;
                    _serverPlayer.connection.teleport(JujutsucraftModVariables.MapVariables.get(world).BlastGameXCenter, JujutsucraftModVariables.MapVariables.get(world).BlastGameYCenter, JujutsucraftModVariables.MapVariables.get(world).BlastGameZCenter, _ent.getYRot(), _ent.getXRot());
                }
            }

        }
    }
}