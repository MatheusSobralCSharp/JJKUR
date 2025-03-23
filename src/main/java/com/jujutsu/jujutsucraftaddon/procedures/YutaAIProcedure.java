package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.YutaCullingGamesEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class YutaAIProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null || world == null)
            return;

        if (LocatePartialSource.execute(world, entity)) {
            if (entity instanceof YutaCullingGamesEntity) {
                if (!(new Object() {
                    public double getValue() {
                        CompoundTag dataIndex1 = new CompoundTag();
                        entity.saveWithoutId(dataIndex1);
                        return dataIndex1.getCompound("ForgeData").getDouble("skill");
                    }
                }.getValue() == 520)) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex3 = new CompoundTag();
                            entity.saveWithoutId(dataIndex3);
                            return dataIndex3.getCompound("ForgeData").getDouble("skill");
                        }
                    }.getValue() >= 1) {
                        if (!(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()))) {
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 1, 1, false, false));
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 1, 1, false, false));
                            entity.getPersistentData().putDouble("PRESS_Z", 0);
                        }
                    }
                    if (Math.random() >= 0.8) {
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex8 = new CompoundTag();
                                entity.saveWithoutId(dataIndex8);
                                return dataIndex8.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == 0) {
                            if (Math.random() >= 0.9) {
                                entity.getPersistentData().putDouble("skill", (Mth.nextInt(RandomSource.create(), 105, 106)));
                                if (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex11 = new CompoundTag();
                                        entity.saveWithoutId(dataIndex11);
                                        return dataIndex11.getCompound("ForgeData").getDouble("PRESS_Z");
                                    }
                                }.getValue() == 0) {
                                    entity.getPersistentData().putDouble("PRESS_Z", 1);
                                }
                                if (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex13 = new CompoundTag();
                                        entity.saveWithoutId(dataIndex13);
                                        return dataIndex13.getCompound("ForgeData").getDouble("PRESS_Z");
                                    }
                                }.getValue() == 1) {
                                    {
                                        Entity _ent = entity;
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                                        }
                                    }
                                    entity.getPersistentData().putDouble("PRESS_Z", 1);
                                    entity.getPersistentData().putDouble("cnt5", 11);
                                    entity.getPersistentData().putDouble("cnt6", 6);
                                    entity.getPersistentData().putDouble("PRESS_Z", 0);
                                }
                            } else if (Math.random() >= 0.8) {
                                if (Math.random() < 0.4) {
                                    entity.getPersistentData().putDouble("skill", (Mth.nextInt(RandomSource.create(), -99, -98)));
                                } else {
                                    entity.getPersistentData().putDouble("skill", (Mth.nextInt(RandomSource.create(), 206, 208)));
                                }
                                if (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex23 = new CompoundTag();
                                        entity.saveWithoutId(dataIndex23);
                                        return dataIndex23.getCompound("ForgeData").getDouble("PRESS_Z");
                                    }
                                }.getValue() == 0) {
                                    entity.getPersistentData().putDouble("PRESS_Z", 1);
                                }
                                if (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex25 = new CompoundTag();
                                        entity.saveWithoutId(dataIndex25);
                                        return dataIndex25.getCompound("ForgeData").getDouble("PRESS_Z");
                                    }
                                }.getValue() == 1) {
                                    {
                                        Entity _ent = entity;
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                                        }
                                    }
                                    entity.getPersistentData().putDouble("PRESS_Z", 0);
                                }
                            } else if (Math.random() >= 0.7) {
                                entity.getPersistentData().putDouble("skill", (Mth.nextInt(RandomSource.create(), -97, -96)));
                                if (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex30 = new CompoundTag();
                                        entity.saveWithoutId(dataIndex30);
                                        return dataIndex30.getCompound("ForgeData").getDouble("PRESS_Z");
                                    }
                                }.getValue() == 0) {
                                    entity.getPersistentData().putDouble("PRESS_Z", 1);
                                }
                                if (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex32 = new CompoundTag();
                                        entity.saveWithoutId(dataIndex32);
                                        return dataIndex32.getCompound("ForgeData").getDouble("PRESS_Z");
                                    }
                                }.getValue() == 1) {
                                    {
                                        Entity _ent = entity;
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                                        }
                                    }
                                    entity.getPersistentData().putDouble("PRESS_Z", 0);
                                }
                            }
                        }
                    } else {
                        if (Math.random() >= 0.7) {
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex35 = new CompoundTag();
                                    entity.saveWithoutId(dataIndex35);
                                    return dataIndex35.getCompound("ForgeData").getDouble("skill");
                                }
                            }.getValue() == 0) {
                                entity.getPersistentData().putDouble("skill", (Mth.nextInt(RandomSource.create(), 105, 2200)));
                            }
                        } else if (Math.random() >= 0.9) {
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex38 = new CompoundTag();
                                    entity.saveWithoutId(dataIndex38);
                                    return dataIndex38.getCompound("ForgeData").getDouble("skill");
                                }
                            }.getValue() == 0) {
                                entity.getPersistentData().putDouble("skill", (Mth.nextInt(RandomSource.create(), -97, -96)));
                                if (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex41 = new CompoundTag();
                                        entity.saveWithoutId(dataIndex41);
                                        return dataIndex41.getCompound("ForgeData").getDouble("PRESS_Z");
                                    }
                                }.getValue() == 0) {
                                    entity.getPersistentData().putDouble("PRESS_Z", 1);
                                }
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex43 = new CompoundTag();
                                    entity.saveWithoutId(dataIndex43);
                                    return dataIndex43.getCompound("ForgeData").getDouble("PRESS_Z");
                                }
                            }.getValue() == 1) {
                                {
                                    Entity _ent = entity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                                4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                                    }
                                }
                                entity.getPersistentData().putDouble("cnt5", 11);
                                entity.getPersistentData().putDouble("cnt6", 6);
                                entity.getPersistentData().putDouble("PRESS_Z", 0);
                            }
                        } else if (Math.random() >= 0.85) {
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex48 = new CompoundTag();
                                    entity.saveWithoutId(dataIndex48);
                                    return dataIndex48.getCompound("ForgeData").getDouble("skill");
                                }
                            }.getValue() == 0) {
                                entity.getPersistentData().putDouble("skill", (Mth.nextInt(RandomSource.create(), 105, 2200)));
                                if (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex51 = new CompoundTag();
                                        entity.saveWithoutId(dataIndex51);
                                        return dataIndex51.getCompound("ForgeData").getDouble("PRESS_Z");
                                    }
                                }.getValue() == 0) {
                                    entity.getPersistentData().putDouble("PRESS_Z", 1);
                                }
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex53 = new CompoundTag();
                                    entity.saveWithoutId(dataIndex53);
                                    return dataIndex53.getCompound("ForgeData").getDouble("PRESS_Z");
                                }
                            }.getValue() == 1) {
                                {
                                    Entity _ent = entity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                                4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                                    }
                                }
                                entity.getPersistentData().putDouble("cnt5", 11);
                                entity.getPersistentData().putDouble("cnt6", 6);
                                entity.getPersistentData().putDouble("PRESS_Z", 0);
                            }
                        } else if (Math.random() >= 0.2) {
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex58 = new CompoundTag();
                                    entity.saveWithoutId(dataIndex58);
                                    return dataIndex58.getCompound("ForgeData").getDouble("skill");
                                }
                            }.getValue() == 0) {
                                entity.getPersistentData().putDouble("skill", -98);
                                if (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex60 = new CompoundTag();
                                        entity.saveWithoutId(dataIndex60);
                                        return dataIndex60.getCompound("ForgeData").getDouble("PRESS_Z");
                                    }
                                }.getValue() == 0) {
                                    entity.getPersistentData().putDouble("PRESS_Z", 1);
                                }
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex62 = new CompoundTag();
                                    entity.saveWithoutId(dataIndex62);
                                    return dataIndex62.getCompound("ForgeData").getDouble("PRESS_Z");
                                }
                            }.getValue() == 1) {
                                {
                                    Entity _ent = entity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                                4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                                    }
                                }
                                entity.getPersistentData().putDouble("cnt5", 11);
                                entity.getPersistentData().putDouble("cnt6", 6);
                                entity.getPersistentData().putDouble("PRESS_Z", 0);
                            }
                        }
                    }
                }
            }
        }

    }
}