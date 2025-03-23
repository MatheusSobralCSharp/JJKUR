package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class IniviteTeamProcedure {
    public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
        if (entity == null)
            return;
        if (!((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Team).equals("")) {
            if ((((new Object() {
                public Entity getEntity() {
                    try {
                        return EntityArgument.getEntity(arguments, "Player");
                    } catch (CommandSyntaxException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }.getEntity()).getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Team).equals("")) {
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal(("Invited " + (new Object() {
                        public Entity getEntity() {
                            try {
                                return EntityArgument.getEntity(arguments, "Player");
                            } catch (CommandSyntaxException e) {
                                e.printStackTrace();
                                return null;
                            }
                        }
                    }.getEntity()).getDisplayName().getString() + " To Team")), false);
                {
                    Entity _ent = (new Object() {
                        public Entity getEntity() {
                            try {
                                return EntityArgument.getEntity(arguments, "Player");
                            } catch (CommandSyntaxException e) {
                                e.printStackTrace();
                                return null;
                            }
                        }
                    }.getEntity());
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(
                                new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
                                        _ent.level().getServer(), _ent),
                                ("tellraw @s {\"text\":\"You have been invited to team " + (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Team
                                        + " Click here to join!\"" + ",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/jjkuTeamJoin "
                                        + (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Team));
                    }
                }
                {
                    String _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Team;
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
                        capability.TeamName = _setval;
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
            } else {
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Player Already Has a Team"), false);
            }
        } else {
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("You don't have a Team"), false);
        }
    }
}
