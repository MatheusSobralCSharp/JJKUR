package com.jujutsu.jujutsucraftaddon.procedures;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class CreateteamProcedure {
    public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
        if (world instanceof Level _level)
            _level.getScoreboard().addPlayerTeam((StringArgumentType.getString(arguments, "teamName")));
    }
}
