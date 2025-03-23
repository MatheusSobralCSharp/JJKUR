package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.entity.TanjerinaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class AIGojoMangaProcedure {
    public static void execute(LevelAccessor world, Entity sourceentity) {
        if (sourceentity == null)
            return;
        if (sourceentity instanceof TanjerinaEntity) {
            if (!(new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("skill");
                }
            }.getValue() == 220)) {
                if (Math.random() >= 0.8) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("skill");
                        }
                    }.getValue() == 0) {
                        if (Math.random() >= 0.9) {
                            if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 60, 1, false, false));
                            }
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("skill", 705);
                                sourceentity.load(dataIndex);
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("PRESS_Z");
                                }
                            }.getValue() == 0) {
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 1);
                                    sourceentity.load(dataIndex);
                                }
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("PRESS_Z");
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
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("PRESS_Z");
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
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("cnt5", 11);
                                    sourceentity.load(dataIndex);
                                }
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("cnt6", 6);
                                    sourceentity.load(dataIndex);
                                }
                                JujutsucraftaddonMod.queueServerWork(60, () -> {
                                    {
                                        CompoundTag dataIndex = new CompoundTag();
                                        sourceentity.saveWithoutId(dataIndex);
                                        dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 0);
                                        sourceentity.load(dataIndex);
                                    }
                                });
                            }
                        } else if (Math.random() >= 0.8) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("skill", (Mth.nextInt(RandomSource.create(), 105, 107)));
                                sourceentity.load(dataIndex);
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("PRESS_Z");
                                }
                            }.getValue() == 0) {
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 1);
                                    sourceentity.load(dataIndex);
                                }
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("PRESS_Z");
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
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("PRESS_Z");
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
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("cnt5", 11);
                                    sourceentity.load(dataIndex);
                                }
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("cnt6", 6);
                                    sourceentity.load(dataIndex);
                                }
                                JujutsucraftaddonMod.queueServerWork(60, () -> {
                                    {
                                        CompoundTag dataIndex = new CompoundTag();
                                        sourceentity.saveWithoutId(dataIndex);
                                        dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 0);
                                        sourceentity.load(dataIndex);
                                    }
                                });
                            }
                        } else if (Math.random() >= 0.7) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("skill", (Mth.nextInt(RandomSource.create(), -96, -97)));
                                sourceentity.load(dataIndex);
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("PRESS_Z");
                                }
                            }.getValue() == 0) {
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 1);
                                    sourceentity.load(dataIndex);
                                }
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("PRESS_Z");
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
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("PRESS_Z");
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
                                JujutsucraftaddonMod.queueServerWork(60, () -> {
                                    {
                                        CompoundTag dataIndex = new CompoundTag();
                                        sourceentity.saveWithoutId(dataIndex);
                                        dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 0);
                                        sourceentity.load(dataIndex);
                                    }
                                });
                            }
                        }
                    }
                } else {
                    if (Math.random() >= 0.7) {
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == 0) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("skill", 503);
                                sourceentity.load(dataIndex);
                            }
                        }
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("PRESS_Z");
                            }
                        }.getValue() == 0) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 1);
                                sourceentity.load(dataIndex);
                            }
                        }
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("PRESS_Z");
                            }
                        }.getValue() == 1) {
                            {
                                Entity _ent = sourceentity;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                            4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                                }
                            }
                        }
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("PRESS_Z");
                            }
                        }.getValue() == 1) {
                            {
                                Entity _ent = sourceentity;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                            4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                                }
                            }
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("cnt5", 11);
                                sourceentity.load(dataIndex);
                            }
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("cnt6", 6);
                                sourceentity.load(dataIndex);
                            }
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 0);
                                sourceentity.load(dataIndex);
                            }
                        }
                    } else if (Math.random() >= 0.2) {
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == 0) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("skill", 203);
                                sourceentity.load(dataIndex);
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("PRESS_Z");
                                }
                            }.getValue() == 0) {
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 1);
                                    sourceentity.load(dataIndex);
                                }
                            }
                        }
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("PRESS_Z");
                            }
                        }.getValue() == 1) {
                            {
                                Entity _ent = sourceentity;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                            4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                                }
                            }
                        }
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("PRESS_Z");
                            }
                        }.getValue() == 1) {
                            {
                                Entity _ent = sourceentity;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                            4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                                }
                            }
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 0);
                                sourceentity.load(dataIndex);
                            }
                        }
                    }
                }
            }
        }
    }
}
