package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.scores.Scoreboard;

import java.util.Collection;

public class JjkuCreateProcedure {
    public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
        if (entity == null)
            return;
        double rnd1 = 0;
        boolean teamFound = false;
        String teamName = StringArgumentType.getString(arguments, "teamName");
        MinecraftServer server = world.getServer();
        Scoreboard scoreboard = server.getScoreboard();
        Collection<String> teams = scoreboard.getTeamNames();
        rnd1 = Math.random();
        teamFound = teams.contains(teamName);
        {
            double _setval = rnd1;
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.friend_num = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
        if (!teamFound) {
            entity.getPersistentData().putDouble("friend_num", rnd1);
            {
                double _setval = rnd1;
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.friend_num = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
            {
                String _setval = StringArgumentType.getString(arguments, "teamName");
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Team = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
            if (world instanceof Level _level)
                _level.getScoreboard().addPlayerTeam((StringArgumentType.getString(arguments, "teamName")));
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("Created Team"), false);
        } else {
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("This team Already Exists"), false);
        }
    }
}
