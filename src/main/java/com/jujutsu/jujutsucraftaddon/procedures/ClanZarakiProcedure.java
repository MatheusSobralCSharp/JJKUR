package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemHandlerHelper;

public class ClanZarakiProcedure {
    public static void execute(CommandContext<CommandSourceStack> arguments) {
        {
            String _setval = "Zaraki";
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
                capability.Clans = _setval;
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
        }.getEntity()) instanceof Player _player) {
            ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.NOZARASHI.get()).copy();
            _setstack.setCount(1);
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
        }
    }
}
