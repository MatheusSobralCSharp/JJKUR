package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class SukunaMangaRCTProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
            if (!((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()))) {
                if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()))) {
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get(), 60,
                                (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getAmplifier() : 0) + 4, false,
                                false));
                }
            }
        }
        if (entity.getPersistentData().getDouble("rctcount") >= 2000) {
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 400) {
                if (entity.getPersistentData().getDouble("brokenBrain") <= 2) {
                    if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 400 && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 150) {
                        if (Math.random() < 0.001) {
                            if (entity.getPersistentData().getDouble("brokenBrain") <= 2) {
                                {
                                    Entity _ent = entity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                        _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                "execute as @s run effect give @s jujutsucraft:reverse_cursed_technique 2 4 true");
                                    }
                                }
                            }
                        }
                    } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 150) {
                        if (Math.random() < 0.1) {
                            if (entity.getPersistentData().getDouble("brokenBrain") <= 2) {
                                {
                                    Entity _ent = entity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                        _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                "execute as @s run effect give @s jujutsucraft:reverse_cursed_technique 1 3 true");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if (entity.getPersistentData().getDouble("rctcount") >= 1000) {
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 400) {
                if (entity.getPersistentData().getDouble("brokenBrain") <= 2) {
                    if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 400 && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 150) {
                        if (Math.random() < 0.001) {
                            if (entity.getPersistentData().getDouble("brokenBrain") <= 2) {
                                {
                                    Entity _ent = entity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                        _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                "execute as @s run effect give @s jujutsucraft:reverse_cursed_technique 1 3 true");
                                    }
                                }
                            }
                        }
                    } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 150) {
                        if (Math.random() < 0.1) {
                            if (entity.getPersistentData().getDouble("brokenBrain") <= 2) {
                                {
                                    Entity _ent = entity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                        _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                "execute as @s run effect give @s jujutsucraft:reverse_cursed_technique 1 2 true");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if (entity.getPersistentData().getDouble("rctcount") <= 1000) {
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 400) {
                if (entity.getPersistentData().getDouble("brokenBrain") <= 2) {
                    if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 400 && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 150) {
                        if (Math.random() < 0.001) {
                            if (entity.getPersistentData().getDouble("brokenBrain") <= 1) {
                                {
                                    Entity _ent = entity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                        _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                "execute as @s run effect give @s jujutsucraft:reverse_cursed_technique 1 1 true");
                                    }
                                }
                            }
                        }
                    } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 150) {
                        if (Math.random() < 0.1) {
                            if (entity.getPersistentData().getDouble("brokenBrain") <= 2) {
                                {
                                    Entity _ent = entity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                        _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                "execute as @s run effect give @s jujutsucraft:reverse_cursed_technique 1 2 true");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("rctcount", (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("rctcount");
                    }
                }.getValue() - 1));
                entity.load(dataIndex);
            }
        } else if (!((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get()))) {
            if (Math.random() < (1) / ((float) 100)) {
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("rctcount");
                    }
                }.getValue() == 0) {
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("rctcount", 4000);
                        entity.load(dataIndex);
                    }
                } else if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("rctcount");
                    }
                }.getValue() > 0) {
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("rctcount", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("rctcount");
                            }
                        }.getValue() + 1));
                        entity.load(dataIndex);
                    }
                }
            }
        }
    }
}
