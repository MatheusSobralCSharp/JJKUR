package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class TechniqueRandomizerProcedure {
    public static void execute(CommandContext<CommandSourceStack> arguments) {
        if (BoolArgumentType.getBool(arguments, "True")) {
            {
                boolean _setval = true;
                (new Object() {
                    public Entity getEntity() {
                        try {
                            return EntityArgument.getEntity(arguments, "Player");
                        } catch (CommandSyntaxException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
                }.getEntity()).getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.SecondAllowed = _setval;
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
            if ((new Object() {
                public Entity getEntity() {
                    try {
                        return EntityArgument.getEntity(arguments, "Player");
                    } catch (CommandSyntaxException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }.getEntity()) instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("Enabled Second Technique"), false);
        } else {
            {
                boolean _setval = false;
                (new Object() {
                    public Entity getEntity() {
                        try {
                            return EntityArgument.getEntity(arguments, "Player");
                        } catch (CommandSyntaxException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
                }.getEntity()).getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.SecondAllowed = _setval;
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
            if ((new Object() {
                public Entity getEntity() {
                    try {
                        return EntityArgument.getEntity(arguments, "Player");
                    } catch (CommandSyntaxException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }.getEntity()) instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("Disabled Second Technique"), false);
        }
    }
}
