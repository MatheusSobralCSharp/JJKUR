package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.ItadoriShinjukuEntity;
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

public class AIBaseProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null || world == null)
            return;

        double tick;
        if (!(entity instanceof LivingEntity _entity && _entity.hasEffect(JujutsucraftModMobEffects.ZONE.get()) && (((LivingEntity) entity).getHealth() <= ((LivingEntity) entity).getMaxHealth() / 1.5))) {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex1 = new CompoundTag();
                    entity.saveWithoutId(dataIndex1);
                    return dataIndex1.getCompound("ForgeData").getDouble("skill");
                }
            }.getValue() >= 1) {
                if (!(entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()))) {
                    if (entity instanceof LivingEntity _entity1 && !_entity1.level().isClientSide())
                        _entity1.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 1, 1, false, false));
                    if (entity instanceof LivingEntity _entity2 && !_entity2.level().isClientSide())
                        _entity2.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 1, 1, false, false));
                    entity.getPersistentData().putDouble("PRESS_Z", 0);
                }
            }
            if (Math.random() >= 0.7) {
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex6 = new CompoundTag();
                        entity.saveWithoutId(dataIndex6);
                        return dataIndex6.getCompound("ForgeData").getDouble("skill");
                    }
                }.getValue() == 0) {
                    if (Math.random() >= 0.9) {
                        entity.getPersistentData().putDouble("skill", (Mth.nextInt(RandomSource.create(), 2100, 2118)));
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex8 = new CompoundTag();
                                entity.saveWithoutId(dataIndex8);
                                return dataIndex8.getCompound("ForgeData").getDouble("PRESS_Z");
                            }
                        }.getValue() == 0) {
                            entity.getPersistentData().putDouble("PRESS_Z", 1);
                        }
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex10 = new CompoundTag();
                                entity.saveWithoutId(dataIndex10);
                                return dataIndex10.getCompound("ForgeData").getDouble("PRESS_Z");
                            }
                        }.getValue() == 1) {
                            {
                                Entity _ent = entity;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                            4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                                }
                            }
                            entity.getPersistentData().putDouble("PRESS_Z", 1);
                            entity.getPersistentData().putDouble("cnt5", 11);
                            entity.getPersistentData().putDouble("cnt6", 6);
                            entity.getPersistentData().putDouble("PRESS_Z", 0);
                        }
                    } else if (Math.random() >= 0.7) {
                        entity.getPersistentData().putDouble("skill", (Mth.nextInt(RandomSource.create(), 105, 106)));
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex18 = new CompoundTag();
                                entity.saveWithoutId(dataIndex18);
                                return dataIndex18.getCompound("ForgeData").getDouble("PRESS_Z");
                            }
                        }.getValue() == 0) {
                            entity.getPersistentData().putDouble("PRESS_Z", 1);
                        }
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex20 = new CompoundTag();
                                entity.saveWithoutId(dataIndex20);
                                return dataIndex20.getCompound("ForgeData").getDouble("PRESS_Z");
                            }
                        }.getValue() == 1) {
                            {
                                Entity _ent = entity;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                            4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                                }
                            }
                            entity.getPersistentData().putDouble("PRESS_Z", 0);
                        }
                    }
                }
            } else {
                if (Math.random() >= 0.6) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex23 = new CompoundTag();
                            entity.saveWithoutId(dataIndex23);
                            return dataIndex23.getCompound("ForgeData").getDouble("skill");
                        }
                    }.getValue() == 0) {
                        entity.getPersistentData().putDouble("skill", (Mth.nextInt(RandomSource.create(), -98, -96)));
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex26 = new CompoundTag();
                                entity.saveWithoutId(dataIndex26);
                                return dataIndex26.getCompound("ForgeData").getDouble("PRESS_Z");
                            }
                        }.getValue() == 0) {
                            entity.getPersistentData().putDouble("PRESS_Z", 1);
                        }
                    }
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex28 = new CompoundTag();
                            entity.saveWithoutId(dataIndex28);
                            return dataIndex28.getCompound("ForgeData").getDouble("PRESS_Z");
                        }
                    }.getValue() == 1) {
                        {
                            Entity _ent = entity;
                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                        _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                            }
                        }
                        entity.getPersistentData().putDouble("cnt5", 11);
                        entity.getPersistentData().putDouble("cnt6", 6);
                        entity.getPersistentData().putDouble("PRESS_Z", 0);
                    }
                } else if (Math.random() >= 0.2) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex33 = new CompoundTag();
                            entity.saveWithoutId(dataIndex33);
                            return dataIndex33.getCompound("ForgeData").getDouble("skill");
                        }
                    }.getValue() == 0) {
                        entity.getPersistentData().putDouble("skill", (Mth.nextInt(RandomSource.create(), -98, -96)));
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex35 = new CompoundTag();
                                entity.saveWithoutId(dataIndex35);
                                return dataIndex35.getCompound("ForgeData").getDouble("PRESS_Z");
                            }
                        }.getValue() == 0) {
                            entity.getPersistentData().putDouble("PRESS_Z", 1);
                        }
                    }
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex37 = new CompoundTag();
                            entity.saveWithoutId(dataIndex37);
                            return dataIndex37.getCompound("ForgeData").getDouble("PRESS_Z");
                        }
                    }.getValue() == 1) {
                        {
                            Entity _ent = entity;
                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                        _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                            }
                        }
                    }
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex39 = new CompoundTag();
                            entity.saveWithoutId(dataIndex39);
                            return dataIndex39.getCompound("ForgeData").getDouble("PRESS_Z");
                        }
                    }.getValue() == 1) {
                        {
                            Entity _ent = entity;
                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                        _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                            }
                        }
                        entity.getPersistentData().putDouble("cnt5", 11);
                        entity.getPersistentData().putDouble("cnt6", 6);
                        entity.getPersistentData().putDouble("PRESS_Z", 0);
                    }
                }
            }
        } else if (entity instanceof ItadoriShinjukuEntity) {
            if (Math.random() >= 0.6) {
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex23 = new CompoundTag();
                        entity.saveWithoutId(dataIndex23);
                        return dataIndex23.getCompound("ForgeData").getDouble("skill");
                    }
                }.getValue() == 0) {
                    entity.getPersistentData().putDouble("skill", (Mth.nextInt(RandomSource.create(), -98, -96)));
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex26 = new CompoundTag();
                            entity.saveWithoutId(dataIndex26);
                            return dataIndex26.getCompound("ForgeData").getDouble("PRESS_Z");
                        }
                    }.getValue() == 0) {
                        CompoundTag dataIndex27 = new CompoundTag();
                        entity.saveWithoutId(dataIndex27);
                        dataIndex27.getCompound("ForgeData").putDouble("PRESS_Z", 1);
                        entity.load(dataIndex27);
                    }
                }
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex28 = new CompoundTag();
                        entity.saveWithoutId(dataIndex28);
                        return dataIndex28.getCompound("ForgeData").getDouble("PRESS_Z");
                    }
                }.getValue() == 1) {
                    {
                        Entity _ent = entity;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                    _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                        }
                    }
                    entity.getPersistentData().putDouble("cnt5", 11);
                    entity.getPersistentData().putDouble("cnt6", 6);
                    entity.getPersistentData().putDouble("PRESS_Z", 0);
                }
            } else if (Math.random() >= 0.2) {
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex33 = new CompoundTag();
                        entity.saveWithoutId(dataIndex33);
                        return dataIndex33.getCompound("ForgeData").getDouble("skill");
                    }
                }.getValue() == 0) {
                    entity.getPersistentData().putDouble("skill", (Mth.nextInt(RandomSource.create(), -98, -96)));
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex35 = new CompoundTag();
                            entity.saveWithoutId(dataIndex35);
                            return dataIndex35.getCompound("ForgeData").getDouble("PRESS_Z");
                        }
                    }.getValue() == 0) {
                        entity.getPersistentData().putDouble("PRESS_Z", 1);
                    }
                }
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex37 = new CompoundTag();
                        entity.saveWithoutId(dataIndex37);
                        return dataIndex37.getCompound("ForgeData").getDouble("PRESS_Z");
                    }
                }.getValue() == 1) {
                    {
                        Entity _ent = entity;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                    _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                        }
                    }
                }
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex39 = new CompoundTag();
                        entity.saveWithoutId(dataIndex39);
                        return dataIndex39.getCompound("ForgeData").getDouble("PRESS_Z");
                    }
                }.getValue() == 1) {
                    {
                        Entity _ent = entity;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                    _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                        }
                    }
                    entity.getPersistentData().putDouble("cnt5", 11);
                    entity.getPersistentData().putDouble("cnt6", 6);
                    entity.getPersistentData().putDouble("PRESS_Z", 0);
                }
            }
        } else {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex1 = new CompoundTag();
                    entity.saveWithoutId(dataIndex1);
                    return dataIndex1.getCompound("ForgeData").getDouble("skill");
                }
            }.getValue() >= 1) {
                if (!(entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()))) {
                    if (entity instanceof LivingEntity _entity1 && !_entity1.level().isClientSide())
                        _entity1.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 1, 1, false, false));
                    if (entity instanceof LivingEntity _entity2 && !_entity2.level().isClientSide())
                        _entity2.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 1, 1, false, false));
                    entity.getPersistentData().putDouble("PRESS_Z", 0);
                }
            }
            if (Math.random() >= 0.7) {
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex6 = new CompoundTag();
                        entity.saveWithoutId(dataIndex6);
                        return dataIndex6.getCompound("ForgeData").getDouble("skill");
                    }
                }.getValue() == 0) {
                    if (Math.random() >= 0.9) {
                        entity.getPersistentData().putDouble("skill", (Mth.nextInt(RandomSource.create(), 2100, 2118)));
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex8 = new CompoundTag();
                                entity.saveWithoutId(dataIndex8);
                                return dataIndex8.getCompound("ForgeData").getDouble("PRESS_Z");
                            }
                        }.getValue() == 0) {
                            entity.getPersistentData().putDouble("PRESS_Z", 1);
                        }
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex10 = new CompoundTag();
                                entity.saveWithoutId(dataIndex10);
                                return dataIndex10.getCompound("ForgeData").getDouble("PRESS_Z");
                            }
                        }.getValue() == 1) {
                            {
                                Entity _ent = entity;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                            4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                                }
                            }
                            entity.getPersistentData().putDouble("PRESS_Z", 1);
                            entity.getPersistentData().putDouble("cnt5", 11);
                            entity.getPersistentData().putDouble("cnt6", 6);
                            entity.getPersistentData().putDouble("PRESS_Z", 0);
                        }
                    } else if (Math.random() >= 0.7) {
                        entity.getPersistentData().putDouble("skill", (Mth.nextInt(RandomSource.create(), 105, 106)));
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex18 = new CompoundTag();
                                entity.saveWithoutId(dataIndex18);
                                return dataIndex18.getCompound("ForgeData").getDouble("PRESS_Z");
                            }
                        }.getValue() == 0) {
                            entity.getPersistentData().putDouble("PRESS_Z", 1);
                        }
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex20 = new CompoundTag();
                                entity.saveWithoutId(dataIndex20);
                                return dataIndex20.getCompound("ForgeData").getDouble("PRESS_Z");
                            }
                        }.getValue() == 1) {
                            {
                                Entity _ent = entity;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                            4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                                }
                            }
                            entity.getPersistentData().putDouble("PRESS_Z", 0);
                        }
                    }
                }
            } else {
                if (Math.random() >= 0.6) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex23 = new CompoundTag();
                            entity.saveWithoutId(dataIndex23);
                            return dataIndex23.getCompound("ForgeData").getDouble("skill");
                        }
                    }.getValue() == 0) {
                        entity.getPersistentData().putDouble("skill", (Mth.nextInt(RandomSource.create(), 2100, 2118)));
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex26 = new CompoundTag();
                                entity.saveWithoutId(dataIndex26);
                                return dataIndex26.getCompound("ForgeData").getDouble("PRESS_Z");
                            }
                        }.getValue() == 0) {
                            entity.getPersistentData().putDouble("PRESS_Z", 1);
                        }
                    }
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex28 = new CompoundTag();
                            entity.saveWithoutId(dataIndex28);
                            return dataIndex28.getCompound("ForgeData").getDouble("PRESS_Z");
                        }
                    }.getValue() == 1) {
                        {
                            Entity _ent = entity;
                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                        _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                            }
                        }
                        entity.getPersistentData().putDouble("cnt5", 11);
                        entity.getPersistentData().putDouble("cnt6", 6);
                        entity.getPersistentData().putDouble("PRESS_Z", 0);
                    }
                } else if (Math.random() >= 0.2) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex33 = new CompoundTag();
                            entity.saveWithoutId(dataIndex33);
                            return dataIndex33.getCompound("ForgeData").getDouble("skill");
                        }
                    }.getValue() == 0) {
                        entity.getPersistentData().putDouble("skill", -98);
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex35 = new CompoundTag();
                                entity.saveWithoutId(dataIndex35);
                                return dataIndex35.getCompound("ForgeData").getDouble("PRESS_Z");
                            }
                        }.getValue() == 0) {
                            entity.getPersistentData().putDouble("PRESS_Z", 1);
                        }
                    }
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex37 = new CompoundTag();
                            entity.saveWithoutId(dataIndex37);
                            return dataIndex37.getCompound("ForgeData").getDouble("PRESS_Z");
                        }
                    }.getValue() == 1) {
                        {
                            Entity _ent = entity;
                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                        _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                            }
                        }
                    }
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex39 = new CompoundTag();
                            entity.saveWithoutId(dataIndex39);
                            return dataIndex39.getCompound("ForgeData").getDouble("PRESS_Z");
                        }
                    }.getValue() == 1) {
                        {
                            Entity _ent = entity;
                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                        _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
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



