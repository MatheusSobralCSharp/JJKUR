package com.jujutsu.jujutsucraftaddon.procedures;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class CEMaxProcedure {
    public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
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
            capability.PlayerCursePowerMAX = (DoubleArgumentType.getDouble(arguments, "CEMaxYouWant"));
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
}
