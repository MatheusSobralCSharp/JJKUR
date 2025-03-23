package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.*;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class DomainsAIProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;

        if (sourceentity.getPersistentData().getDouble("brokenBrain") <= 1) {
            if (sourceentity instanceof YutaCullingGamesEntity) {

            } else if (sourceentity instanceof SatushiEntity) {
                if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                    if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) < 255) {
                        if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 255, false, false));
                    }
                }
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        sourceentity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("select");
                    }
                }.getValue() >= 1) {
                    if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 40, 2, false, false));
                }
                if (Math.random() < 0.01) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("brokenBrain");
                        }
                    }.getValue() <= 1) {
                        if (!(new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill_domain");
                            }
                        }.getValue() == 1 || new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == 120 || (new Object() {
                            public boolean getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getBoolean("flag_domain");
                            }
                        }.getValue()))) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("skill", 120);
                                sourceentity.load(dataIndex);
                            }
                        }
                    }
                } else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 400) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("brokenBrain");
                        }
                    }.getValue() <= 1) {
                        if (!(new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill_domain");
                            }
                        }.getValue() == 1 || new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == 120 || (new Object() {
                            public boolean getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getBoolean("flag_domain");
                            }
                        }.getValue()))) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("skill", 120);
                                sourceentity.load(dataIndex);
                            }
                        }
                    }
                } else if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("select");
                    }
                }.getValue() > 1) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("brokenBrain");
                        }
                    }.getValue() <= 1) {
                        if (!(new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill_domain");
                            }
                        }.getValue() == 1 || new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == 120 || (new Object() {
                            public boolean getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getBoolean("flag_domain");
                            }
                        }.getValue()))) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("skill", 120);
                                sourceentity.load(dataIndex);
                            }
                        }
                    }
                }
            } else if (sourceentity instanceof UraumeEntity) {
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        sourceentity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("select");
                    }
                }.getValue() >= 1) {
                    if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 40, 2, false, false));
                }
                if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                    if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) < 255) {
                        if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 255, false, false));
                    }
                }
                if (Math.random() < 0.01) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("brokenBrain");
                        }
                    }.getValue() <= 1) {
                        if (!(new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill_domain");
                            }
                        }.getValue() == 24 || new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == 2420 || (new Object() {
                            public boolean getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getBoolean("flag_domain");
                            }
                        }.getValue()))) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("skill", 2420);
                                sourceentity.load(dataIndex);
                            }
                        }
                    }
                } else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 400) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("brokenBrain");
                        }
                    }.getValue() <= 1) {
                        if (!(new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill_domain");
                            }
                        }.getValue() == 24 || new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == 2420 || (new Object() {
                            public boolean getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getBoolean("flag_domain");
                            }
                        }.getValue()))) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("skill", 2420);
                                sourceentity.load(dataIndex);
                            }
                        }
                    }
                } else if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("select");
                    }
                }.getValue() > 1) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("brokenBrain");
                        }
                    }.getValue() <= 1) {
                        if (!(new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill_domain");
                            }
                        }.getValue() == 24 || new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == 2420 || (new Object() {
                            public boolean getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getBoolean("flag_domain");
                            }
                        }.getValue()))) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("skill", 2420);
                                sourceentity.load(dataIndex);
                            }
                        }
                    }
                }
            } else if (sourceentity instanceof GegeAkutamiEntity) {
                if (Math.random() < 0.01) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("brokenBrain");
                        }
                    }.getValue() <= 1) {
                        if (!(new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill_domain");
                            }
                        }.getValue() == 1 || new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == 120 || (new Object() {
                            public boolean getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getBoolean("flag_domain");
                            }
                        }.getValue()))) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("skill", 120);
                                sourceentity.load(dataIndex);
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("skill");
                                }
                            }.getValue() == 120) {
                                {
                                    Entity _ent = sourceentity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                                4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique");
                                    }
                                }
                            }
                        }
                    }
                } else if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("select");
                    }
                }.getValue() > 1) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("brokenBrain");
                        }
                    }.getValue() <= 1) {
                        if (!(new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill_domain");
                            }
                        }.getValue() == 1 || new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == 120 || (new Object() {
                            public boolean getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getBoolean("flag_domain");
                            }
                        }.getValue()))) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("skill", 120);
                                sourceentity.load(dataIndex);
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("skill");
                                }
                            }.getValue() == 120) {
                                {
                                    Entity _ent = sourceentity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                                4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique");
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (sourceentity instanceof HakariEntity) {
                if (Math.random() < 0.01) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("brokenBrain");
                        }
                    }.getValue() <= 1) {
                        if (!(new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill_domain");
                            }
                        }.getValue() == 29 || new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == 2920 || (new Object() {
                            public boolean getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getBoolean("flag_domain");
                            }
                        }.getValue()))) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("skill", 2920);
                                sourceentity.load(dataIndex);
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("skill");
                                }
                            }.getValue() == 2920) {
                                {
                                    Entity _ent = sourceentity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                                4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique");
                                    }
                                }
                            }
                        }
                    }
                } else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 400) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("brokenBrain");
                        }
                    }.getValue() <= 1) {
                        if (!(new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill_domain");
                            }
                        }.getValue() == 29 || new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == 2920 || (new Object() {
                            public boolean getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getBoolean("flag_domain");
                            }
                        }.getValue()))) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("skill", 2920);
                                sourceentity.load(dataIndex);
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("skill");
                                }
                            }.getValue() == 2920) {
                                {
                                    Entity _ent = sourceentity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                                4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique");
                                    }
                                }
                            }
                        }
                    }
                } else if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("select");
                    }
                }.getValue() > 1) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("brokenBrain");
                        }
                    }.getValue() <= 1) {
                        if (!(new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill_domain");
                            }
                        }.getValue() == 29 || new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == 2920 || (new Object() {
                            public boolean getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getBoolean("flag_domain");
                            }
                        }.getValue()))) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("skill", 2920);
                                sourceentity.load(dataIndex);
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("skill");
                                }
                            }.getValue() == 2920) {
                                {
                                    Entity _ent = sourceentity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                                4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique");
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (sourceentity instanceof GojoMangaEntity) {
                if (Math.random() < 0.01) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("brokenBrain");
                        }
                    }.getValue() <= 1) {
                        if (!(new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill_domain");
                            }
                        }.getValue() == 2 || new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == 220 || (new Object() {
                            public boolean getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getBoolean("flag_domain");
                            }
                        }.getValue()))) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("skill", 220);
                                sourceentity.load(dataIndex);
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("skill");
                                }
                            }.getValue() == 220) {
                                {
                                    Entity _ent = sourceentity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                                4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique");
                                    }
                                }
                            }
                        }
                    }
                } else if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("select");
                    }
                }.getValue() > 1) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("brokenBrain");
                        }
                    }.getValue() <= 1) {
                        if (!(new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill_domain");
                            }
                        }.getValue() == 29 || new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == 2920 || (new Object() {
                            public boolean getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getBoolean("flag_domain");
                            }
                        }.getValue()))) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("skill", 220);
                                sourceentity.load(dataIndex);
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("skill");
                                }
                            }.getValue() == 220) {
                                {
                                    Entity _ent = sourceentity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                                4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique");
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (sourceentity instanceof HusseinDongEntity) {
                if (Math.random() < 0.01) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("brokenBrain");
                        }
                    }.getValue() <= 1) {
                        if (!(new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == 2815)) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("skill", 2815);
                                sourceentity.load(dataIndex);
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("skill");
                                }
                            }.getValue() == 2815) {
                                {
                                    Entity _ent = sourceentity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                                4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique");
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (sourceentity instanceof TanjerinaEntity) {
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        sourceentity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("select");
                    }
                }.getValue() >= 1) {
                    if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 40, 2, false, false));
                }
                if (Math.random() < 0.01) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("brokenBrain");
                        }
                    }.getValue() <= 1) {
                        if (!(new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill_domain");
                            }
                        }.getValue() == 2 || new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == 220 || (new Object() {
                            public boolean getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getBoolean("flag_domain");
                            }
                        }.getValue()))) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("skill", 220);
                                sourceentity.load(dataIndex);
                            }
                        }
                    }
                } else if (Math.random() > 0.01 && Math.random() < 0.05) {
                    if (!(new Object() {
                        public boolean getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getBoolean("Igris");
                        }
                    }.getValue())) {
                        if (world.getEntitiesOfClass(IgrisEntity.class, AABB.ofSize(new Vec3((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ())), 100, 100, 100), e -> true).isEmpty()) {
                            if (world instanceof ServerLevel _serverLevel) {
                                LevelAccessor _worldorig = world;
                                world = _serverLevel.getServer().getLevel(entity.level().dimension());
                                if (world != null) {
                                    Entity entitytospawn = JujutsucraftaddonModEntities.IGRIS.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
                                    if (entitytospawn != null) {
                                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                        CompoundTag dataIndex1 = new CompoundTag();
                                        (entitytospawn).saveWithoutId(dataIndex1);
                                        dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                                        (entitytospawn).load(dataIndex1);
                                        CompoundTag dataIndex3 = new CompoundTag();
                                        (entitytospawn).saveWithoutId(dataIndex3);
                                        dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                                            public double getValue() {
                                                CompoundTag dataIndex2 = new CompoundTag();
                                                sourceentity.saveWithoutId(dataIndex2);
                                                return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
                                            }
                                        }.getValue()));
                                        (entitytospawn).load(dataIndex3);
                                        _serverLevel.addFreshEntity(entitytospawn);
                                    }
                                }
                                world = _worldorig;
                            }
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putBoolean("Igris", true);
                                sourceentity.load(dataIndex);
                            }
                            {
                                Entity _ent = sourceentity;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                            _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] title {\"text\":\"Arise\",\"color\":\"dark_purple\",\"bold\":true}");
                                }
                            }
                        }
                    }
                    if (!(new Object() {
                        public boolean getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getBoolean("Beru");
                        }
                    }.getValue())) {
                        if (world.getEntitiesOfClass(Shadow1Entity.class, AABB.ofSize(new Vec3((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ())), 100, 100, 100), e -> true).isEmpty()) {
                            if (world instanceof ServerLevel _serverLevel) {
                                LevelAccessor _worldorig = world;
                                world = _serverLevel.getServer().getLevel(entity.level().dimension());
                                if (world != null) {
                                    Entity entitytospawn = JujutsucraftaddonModEntities.SHADOW_1.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
                                    if (entitytospawn != null) {
                                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                        CompoundTag dataIndex1 = new CompoundTag();
                                        (entitytospawn).saveWithoutId(dataIndex1);
                                        dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                                        (entitytospawn).load(dataIndex1);
                                        CompoundTag dataIndex3 = new CompoundTag();
                                        (entitytospawn).saveWithoutId(dataIndex3);
                                        dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                                            public double getValue() {
                                                CompoundTag dataIndex2 = new CompoundTag();
                                                sourceentity.saveWithoutId(dataIndex2);
                                                return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
                                            }
                                        }.getValue()));
                                        (entitytospawn).load(dataIndex3);
                                        _serverLevel.addFreshEntity(entitytospawn);
                                    }
                                }
                                world = _worldorig;
                            }
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putBoolean("Beru", true);
                                sourceentity.load(dataIndex);
                            }
                            {
                                Entity _ent = sourceentity;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                            _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] title {\"text\":\"Arise\",\"color\":\"dark_purple\",\"bold\":true}");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
