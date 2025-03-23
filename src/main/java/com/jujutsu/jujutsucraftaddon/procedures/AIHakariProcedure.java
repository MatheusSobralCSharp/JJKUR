package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.HakariEntity;
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

public class AIHakariProcedure {
    public static void execute(LevelAccessor world, Entity sourceentity) {
        if (sourceentity == null)
            return;
        if (sourceentity instanceof HakariEntity) {
            if (!(new Object() {
                public double getValue() {
                    CompoundTag dataIndex2 = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex2);
                    return dataIndex2.getCompound("ForgeData").getDouble("skill");
                }
            }.getValue() == 2920)) {
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex3 = new CompoundTag();
                        sourceentity.saveWithoutId(dataIndex3);
                        return dataIndex3.getCompound("ForgeData").getDouble("skill");
                    }
                }.getValue() >= 1) {
                    if (!(sourceentity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()))) {
                        if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 1, 1, false, false));
                        if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 1, 1, false, false));
                        CompoundTag dataIndex7 = new CompoundTag();
                        sourceentity.saveWithoutId(dataIndex7);
                        dataIndex7.getCompound("ForgeData").putDouble("PRESS_Z", 0);
                        sourceentity.load(dataIndex7);
                    }
                }
                if (Math.random() >= 0.8) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex8 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex8);
                            return dataIndex8.getCompound("ForgeData").getDouble("skill");
                        }
                    }.getValue() == 0) {
                        if (Math.random() >= 0.9) {
                            CompoundTag dataIndex10 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex10);
                            dataIndex10.getCompound("ForgeData").putDouble("skill", (Mth.nextInt(RandomSource.create(), 2904, 2905)));
                            sourceentity.load(dataIndex10);
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex11 = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex11);
                                    return dataIndex11.getCompound("ForgeData").getDouble("PRESS_Z");
                                }
                            }.getValue() == 0) {
                                CompoundTag dataIndex12 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex12);
                                dataIndex12.getCompound("ForgeData").putDouble("PRESS_Z", 1);
                                sourceentity.load(dataIndex12);
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex13 = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex13);
                                    return dataIndex13.getCompound("ForgeData").getDouble("PRESS_Z");
                                }
                            }.getValue() == 1) {
                                {
                                    Entity _ent = sourceentity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                        _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                                    }
                                }
                                CompoundTag dataIndex15 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex15);
                                dataIndex15.getCompound("ForgeData").putDouble("PRESS_Z", 1);
                                sourceentity.load(dataIndex15);
                                CompoundTag dataIndex16 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex16);
                                dataIndex16.getCompound("ForgeData").putDouble("cnt5", 11);
                                sourceentity.load(dataIndex16);
                                CompoundTag dataIndex17 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex17);
                                dataIndex17.getCompound("ForgeData").putDouble("cnt6", 6);
                                sourceentity.load(dataIndex17);
                                CompoundTag dataIndex18 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex18);
                                dataIndex18.getCompound("ForgeData").putDouble("PRESS_Z", 0);
                                sourceentity.load(dataIndex18);
                            }
                        } else if (Math.random() >= 0.8) {
                            if (Math.random() < 0.4) {
                                CompoundTag dataIndex20 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex20);
                                dataIndex20.getCompound("ForgeData").putDouble("skill", (Mth.nextInt(RandomSource.create(), -99, -98)));
                                sourceentity.load(dataIndex20);
                            } else {
                                CompoundTag dataIndex22 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex22);
                                dataIndex22.getCompound("ForgeData").putDouble("skill", (Mth.nextInt(RandomSource.create(), 2905, 2906)));
                                sourceentity.load(dataIndex22);
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex23 = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex23);
                                    return dataIndex23.getCompound("ForgeData").getDouble("PRESS_Z");
                                }
                            }.getValue() == 0) {
                                CompoundTag dataIndex24 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex24);
                                dataIndex24.getCompound("ForgeData").putDouble("PRESS_Z", 1);
                                sourceentity.load(dataIndex24);
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex25 = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex25);
                                    return dataIndex25.getCompound("ForgeData").getDouble("PRESS_Z");
                                }
                            }.getValue() == 1) {
                                {
                                    Entity _ent = sourceentity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                        _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                                    }
                                }
                                CompoundTag dataIndex27 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex27);
                                dataIndex27.getCompound("ForgeData").putDouble("PRESS_Z", 0);
                                sourceentity.load(dataIndex27);
                            }
                        } else if (Math.random() >= 0.7) {
                            CompoundTag dataIndex29 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex29);
                            dataIndex29.getCompound("ForgeData").putDouble("skill", (Mth.nextInt(RandomSource.create(), -97, -96)));
                            sourceentity.load(dataIndex29);
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex30 = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex30);
                                    return dataIndex30.getCompound("ForgeData").getDouble("PRESS_Z");
                                }
                            }.getValue() == 0) {
                                CompoundTag dataIndex31 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex31);
                                dataIndex31.getCompound("ForgeData").putDouble("PRESS_Z", 1);
                                sourceentity.load(dataIndex31);
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex32 = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex32);
                                    return dataIndex32.getCompound("ForgeData").getDouble("PRESS_Z");
                                }
                            }.getValue() == 1) {
                                {
                                    Entity _ent = sourceentity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                        _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                                    }
                                }
                                CompoundTag dataIndex34 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex34);
                                dataIndex34.getCompound("ForgeData").putDouble("PRESS_Z", 0);
                                sourceentity.load(dataIndex34);
                            }
                        }
                    }
                } else {
                    if (Math.random() >= 0.7) {
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex35 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex35);
                                return dataIndex35.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == 0) {
                            CompoundTag dataIndex37 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex37);
                            dataIndex37.getCompound("ForgeData").putDouble("skill", (Mth.nextInt(RandomSource.create(), 2906, 2906)));
                            sourceentity.load(dataIndex37);
                        }
                    } else if (Math.random() >= 0.9) {
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex38 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex38);
                                return dataIndex38.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == 0) {
                            CompoundTag dataIndex40 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex40);
                            dataIndex40.getCompound("ForgeData").putDouble("skill", (Mth.nextInt(RandomSource.create(), -97, -96)));
                            sourceentity.load(dataIndex40);
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex41 = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex41);
                                    return dataIndex41.getCompound("ForgeData").getDouble("PRESS_Z");
                                }
                            }.getValue() == 0) {
                                CompoundTag dataIndex42 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex42);
                                dataIndex42.getCompound("ForgeData").putDouble("PRESS_Z", 1);
                                sourceentity.load(dataIndex42);
                            }
                        }
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex43 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex43);
                                return dataIndex43.getCompound("ForgeData").getDouble("PRESS_Z");
                            }
                        }.getValue() == 1) {
                            {
                                Entity _ent = sourceentity;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                            4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                                }
                            }
                            CompoundTag dataIndex45 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex45);
                            dataIndex45.getCompound("ForgeData").putDouble("cnt5", 11);
                            sourceentity.load(dataIndex45);
                            CompoundTag dataIndex46 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex46);
                            dataIndex46.getCompound("ForgeData").putDouble("cnt6", 6);
                            sourceentity.load(dataIndex46);
                            CompoundTag dataIndex47 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex47);
                            dataIndex47.getCompound("ForgeData").putDouble("PRESS_Z", 0);
                            sourceentity.load(dataIndex47);
                        }
                    } else if (Math.random() >= 0.85) {
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex48 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex48);
                                return dataIndex48.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == 0) {
                            CompoundTag dataIndex50 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex50);
                            dataIndex50.getCompound("ForgeData").putDouble("skill", (Mth.nextInt(RandomSource.create(), -98, -96)));
                            sourceentity.load(dataIndex50);
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex51 = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex51);
                                    return dataIndex51.getCompound("ForgeData").getDouble("PRESS_Z");
                                }
                            }.getValue() == 0) {
                                CompoundTag dataIndex52 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex52);
                                dataIndex52.getCompound("ForgeData").putDouble("PRESS_Z", 1);
                                sourceentity.load(dataIndex52);
                            }
                        }
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex53 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex53);
                                return dataIndex53.getCompound("ForgeData").getDouble("PRESS_Z");
                            }
                        }.getValue() == 1) {
                            {
                                Entity _ent = sourceentity;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                            4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                                }
                            }
                            CompoundTag dataIndex55 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex55);
                            dataIndex55.getCompound("ForgeData").putDouble("cnt5", 11);
                            sourceentity.load(dataIndex55);
                            CompoundTag dataIndex56 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex56);
                            dataIndex56.getCompound("ForgeData").putDouble("cnt6", 6);
                            sourceentity.load(dataIndex56);
                            CompoundTag dataIndex57 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex57);
                            dataIndex57.getCompound("ForgeData").putDouble("PRESS_Z", 0);
                            sourceentity.load(dataIndex57);
                        }
                    } else if (Math.random() >= 0.2) {
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex58 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex58);
                                return dataIndex58.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == 0) {
                            CompoundTag dataIndex59 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex59);
                            dataIndex59.getCompound("ForgeData").putDouble("skill", (-98));
                            sourceentity.load(dataIndex59);
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex60 = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex60);
                                    return dataIndex60.getCompound("ForgeData").getDouble("PRESS_Z");
                                }
                            }.getValue() == 0) {
                                CompoundTag dataIndex61 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex61);
                                dataIndex61.getCompound("ForgeData").putDouble("PRESS_Z", 1);
                                sourceentity.load(dataIndex61);
                            }
                        }
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex62 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex62);
                                return dataIndex62.getCompound("ForgeData").getDouble("PRESS_Z");
                            }
                        }.getValue() == 1) {
                            {
                                Entity _ent = sourceentity;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                            4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                                }
                            }
                            CompoundTag dataIndex64 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex64);
                            dataIndex64.getCompound("ForgeData").putDouble("cnt5", 11);
                            sourceentity.load(dataIndex64);
                            CompoundTag dataIndex65 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex65);
                            dataIndex65.getCompound("ForgeData").putDouble("cnt6", 6);
                            sourceentity.load(dataIndex65);
                            CompoundTag dataIndex66 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex66);
                            dataIndex66.getCompound("ForgeData").putDouble("PRESS_Z", 0);
                            sourceentity.load(dataIndex66);
                        }
                    }
                }
            }
        }
    }
}
