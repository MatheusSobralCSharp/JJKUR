package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class DropItems3Procedure {
    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("JujutsuSorcerer");
            }
        }.getValue() == 1 || new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("CurseUser");
            }
        }.getValue() == 1 || new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("CursedSpirit");
            }
        }.getValue() == 1) {
            if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:kenjaku")) {
                if (!((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Profession).equals("Sage")) {
                    if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0001) {
                        if (sourceentity instanceof Player _player) {
                            ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.KENJAKU_ARMOR_HELMET.get()).copy();
                            _setstack.setCount(1);
                            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                        }
                    } else if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0002) {
                        if (sourceentity instanceof Player _player) {
                            ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.VEIL_TALISMAN.get()).copy();
                            _setstack.setCount(1);
                            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                        }
                    }
                } else {
                    if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0001 * 2) {
                        if (sourceentity instanceof Player _player) {
                            ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.KENJAKU_ARMOR_HELMET.get()).copy();
                            _setstack.setCount(1);
                            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                        }
                        if (sourceentity instanceof Player _player) {
                            ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.ARTIFACT_3.get()).copy();
                            _setstack.setCount(1);
                            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                        }
                    } else if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0002 * 2) {
                        if (sourceentity instanceof Player _player) {
                            ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.VEIL_TALISMAN.get()).copy();
                            _setstack.setCount(1);
                            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                        }
                    }
                }
            } else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).contains("gojo")) {
                if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0001) {
                    if (sourceentity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.ARTIFACT_4.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                }
                if (Math.random() < (1) / ((float) 200)) {
                    if (sourceentity instanceof Player _player) {
                        {
                            int finalLastIndex = 1;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.AttackAnimation = finalLastIndex;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                        if (!_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Unlocked Gojo Style"), false);

                    }
                }
            } else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).contains("jujutsucraft:sukuna_fushiguro") || (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).contains("mahoraga")) {
                if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0001) {
                    if (sourceentity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.ARTIFACT_5.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                }
            } else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).contains("yuta") || (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).contains("jujutsucraft:rika")) {
                if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0005 * 2) {
                    if (sourceentity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.ARTIFACT_2.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                } else if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0005) {
                    if (sourceentity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.ARTIFACT.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                }
            } else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:choso")) {
                if (!((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Profession).equals("Sage")) {
                    if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0001) {
                        if (sourceentity instanceof Player _player) {
                            ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.S_OULBOOK.get()).copy();
                            _setstack.setCount(1);
                            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                        }
                    } else if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0003) {
                        if (sourceentity instanceof Player _player) {
                            ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.CURSED_WOMB.get()).copy();
                            _setstack.setCount(1);
                            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                        }
                    }
                } else {
                    if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0001 * 2) {
                        if (sourceentity instanceof Player _player) {
                            ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.KENJAKU_ARMOR_HELMET.get()).copy();
                            _setstack.setCount(1);
                            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                        }
                    } else if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0003 * 2) {
                        if (sourceentity instanceof Player _player) {
                            ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.VEIL_TALISMAN.get()).copy();
                            _setstack.setCount(1);
                            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                        }
                    }
                }
            } else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:mahito")) {
                if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0002) {
                    if (sourceentity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.S_OULBOOK.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                }
            } else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:gojo_satoru")) {
                if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0002) {
                    if (sourceentity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.DECISIVE_CHESTPLATE.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                } else if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0005) {
                    if (sourceentity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.DECISIVE_LEGGINGS.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                }
            } else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:fushiguro_toji")) {
                if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0002) {
                    if (sourceentity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.BULLET.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                } else if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0005) {
                    if (sourceentity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.ARMORY_CHESTPLATE.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                }
            } else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:sukuna_perfect")) {
                if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.00001) {
                    if (sourceentity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.TENGEN.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                }
            } else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:sukuna") || (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:sukuna_fushiguro")) {
                if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0001) {
                    if (sourceentity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.SUKUNA_ARMOR_HELMET.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                    if (sourceentity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.SUKUNA_ARMOR_CHESTPLATE.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                } else if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0002) {
                    if (sourceentity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.SUKUNA_ARMOR_TWO_HELMET.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                    if (sourceentity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.SUKUNA_ARMOR_TWO_CHESTPLATE.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                }
            } else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:todo_aoi")) {
                if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0003) {
                    if (sourceentity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.VIBRASLAP.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                }
            }
            if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) < 20) {
                if (!((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Profession).equals("Sage")) {
                    if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0001) {
                        if (sourceentity instanceof Player _player) {
                            ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.CLAN_CHANGER.get()).copy();
                            _setstack.setCount(1);
                            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                        }
                    } else if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0002) {
                        if (sourceentity instanceof Player _player) {
                            ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.RACE_CHANGER.get()).copy();
                            _setstack.setCount(1);
                            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                        }
                    }
                } else {
                    if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0001 * 2) {
                        if (sourceentity instanceof Player _player) {
                            ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.CLAN_CHANGER.get()).copy();
                            _setstack.setCount(1);
                            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                        }
                    } else if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0002 * 2) {
                        if (sourceentity instanceof Player _player) {
                            ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.RACE_CHANGER.get()).copy();
                            _setstack.setCount(1);
                            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                        }
                    }
                }
                if (!((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Profession).equals("Sage")) {
                    if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.00001) {
                        if (sourceentity instanceof Player _player) {
                            ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.CURSED_POWER_LEVEL_SCROLL.get()).copy();
                            _setstack.setCount(1);
                            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                        }
                    } else if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.00005) {
                        if (sourceentity instanceof Player _player) {
                            ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.HEALTH_SCROLL.get()).copy();
                            _setstack.setCount(1);
                            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                        }
                    } else if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0001) {
                        if (sourceentity instanceof Player _player) {
                            ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.REVERSE_LEVEL_SCROLL.get()).copy();
                            _setstack.setCount(1);
                            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                        }
                    }
                } else {
                    if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.00001 * 2) {
                        if (sourceentity instanceof Player _player) {
                            ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.CURSED_POWER_LEVEL_SCROLL.get()).copy();
                            _setstack.setCount(1);
                            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                        }
                    } else if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.00005 * 2) {
                        if (sourceentity instanceof Player _player) {
                            ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.HEALTH_SCROLL.get()).copy();
                            _setstack.setCount(1);
                            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                        }
                    } else if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0001 * 2) {
                        if (sourceentity instanceof Player _player) {
                            ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.REVERSE_LEVEL_SCROLL.get()).copy();
                            _setstack.setCount(1);
                            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                        }
                    }
                }
            } else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) > 20) {
                if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0001) {
                    if (sourceentity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.TRAIT_RECOMMENDATION.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                }
                if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0005) {
                    if (sourceentity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.CLAN_CHANGER.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                } else if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0001) {
                    if (sourceentity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.RACE_CHANGER.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                }
                if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0001) {
                    if (sourceentity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.CURSED_POWER_LEVEL_SCROLL.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                } else if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0002) {
                    if (sourceentity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.HEALTH_SCROLL.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                } else if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0003) {
                    if (sourceentity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.REVERSE_LEVEL_SCROLL.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                }
            }
            if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) < 20) {
                if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.00015) {
                    if (sourceentity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.JUJUTSU_COIN.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                }
                if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.00003) {
                    if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_RANDOM_CT)) {
                        if (sourceentity instanceof Player _player) {
                            ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.RANDOM_CT_CHANGER.get()).copy();
                            _setstack.setCount(1);
                            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                        }
                    } else {
                        {
                            Entity _ent = entity;
                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                        _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run give @s jujutsucraft:cursed_technique_changer");
                            }
                        }
                    }
                }
            } else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) > 20) {
                if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.0003) {
                    if (sourceentity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.JUJUTSU_COIN.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                }
                if (Math.random() <= (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.00005) {
                    if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_RANDOM_CT)) {
                        if (sourceentity instanceof Player _player) {
                            ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.RANDOM_CT_CHANGER.get()).copy();
                            _setstack.setCount(1);
                            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                        }
                    } else {
                        {
                            Entity _ent = entity;
                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                        _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run give @s jujutsucraft:cursed_technique_changer");
                            }
                        }
                    }
                }
            }
        }
    }
}
