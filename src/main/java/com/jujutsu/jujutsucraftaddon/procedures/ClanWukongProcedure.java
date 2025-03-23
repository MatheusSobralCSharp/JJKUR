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

public class ClanWukongProcedure {
    public static void execute(CommandContext<CommandSourceStack> arguments) {
        {
            String _setval = "Wukong";
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
            ItemStack _setstack1 = new ItemStack(JujutsucraftaddonModItems.WUKONG_STAFF_TRUE.get()).copy();
            _setstack1.setCount(1);
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack1);
            ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.HALBERD_WUKONG.get()).copy();
            _setstack.setCount(1);
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            ItemStack _setstack11 = new ItemStack(JujutsucraftaddonModItems.GREAT_SWORD_WUKONG.get()).copy();
            _setstack11.setCount(1);
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack11);
            ItemStack _setstack13 = new ItemStack(JujutsucraftaddonModItems.SWORD_WUKONG.get()).copy();
            _setstack13.setCount(1);
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack13);
            ItemStack _setstack14 = new ItemStack(JujutsucraftaddonModItems.HAMMER_WUKONG.get()).copy();
            _setstack14.setCount(1);
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack14);
            ItemStack _setstack15 = new ItemStack(JujutsucraftaddonModItems.WUKONG_HAT.get()).copy();
            _setstack15.setCount(1);
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack15);
            ItemStack _setstack2 = new ItemStack(JujutsucraftaddonModItems.WUKONG_SET_CHESTPLATE.get()).copy();
            _setstack2.setCount(1);
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack2);
            ItemStack _setstack3 = new ItemStack(JujutsucraftaddonModItems.WUKONG_SET_BOOTS.get()).copy();
            _setstack3.setCount(1);
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack3);
            ItemStack _setstack4 = new ItemStack(JujutsucraftaddonModItems.WUKONG_SET_LEGGINGS.get()).copy();
            _setstack4.setCount(1);
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack4);
        }
    }
}
