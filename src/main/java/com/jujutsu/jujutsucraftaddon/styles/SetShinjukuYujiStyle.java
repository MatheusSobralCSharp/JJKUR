package com.jujutsu.jujutsucraftaddon.styles;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class SetShinjukuYujiStyle {
    public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
        {
            double _setval = 7;
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
                capability.Style = _setval;
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

}
