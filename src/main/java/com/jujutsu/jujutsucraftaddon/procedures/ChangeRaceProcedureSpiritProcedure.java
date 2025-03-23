package com.jujutsu.jujutsucraftaddon.procedures;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ChangeRaceProcedureSpiritProcedure {
    public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
        if (!((new Object() {
            public Entity getEntity() {
                try {
                    return EntityArgument.getEntity(arguments, "Player");
                } catch (CommandSyntaxException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }.getEntity()) == null)) {
            {
                double _setval = (-1);
                (new Object() {
                    public Entity getEntity() {
                        try {
                            return EntityArgument.getEntity(arguments, "Player");
                        } catch (CommandSyntaxException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
                }.getEntity()).getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.PlayerProfession = _setval;
                    capability.syncPlayerVariables((new Object() {
                        public Entity getEntity() {
                            try {
                                return EntityArgument.getEntity(arguments, "Player");
                            } catch (CommandSyntaxException e) {
                                e.printStackTrace();
                                return null;
                            }
                        }
                    }.getEntity()));
                });
            }
            {
                CompoundTag dataIndex = new CompoundTag();
                (new Object() {
                    public Entity getEntity() {
                        try {
                            return EntityArgument.getEntity(arguments, "Player");
                        } catch (CommandSyntaxException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
                }.getEntity()).saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putBoolean("JujutsuSorcerer", true);
                (new Object() {
                    public Entity getEntity() {
                        try {
                            return EntityArgument.getEntity(arguments, "Player");
                        } catch (CommandSyntaxException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
                }.getEntity()).load(dataIndex);
            }
            {
                CompoundTag dataIndex = new CompoundTag();
                (new Object() {
                    public Entity getEntity() {
                        try {
                            return EntityArgument.getEntity(arguments, "Player");
                        } catch (CommandSyntaxException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
                }.getEntity()).saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putBoolean("CurseUser", false);
                (new Object() {
                    public Entity getEntity() {
                        try {
                            return EntityArgument.getEntity(arguments, "Player");
                        } catch (CommandSyntaxException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
                }.getEntity()).load(dataIndex);
            }
            {
                CompoundTag dataIndex = new CompoundTag();
                (new Object() {
                    public Entity getEntity() {
                        try {
                            return EntityArgument.getEntity(arguments, "Player");
                        } catch (CommandSyntaxException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
                }.getEntity()).saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putBoolean("CursedSpirit", true);
                (new Object() {
                    public Entity getEntity() {
                        try {
                            return EntityArgument.getEntity(arguments, "Player");
                        } catch (CommandSyntaxException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
                }.getEntity()).load(dataIndex);
            }
        }
    }
}
