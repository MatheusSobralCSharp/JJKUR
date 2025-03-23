package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.items.ItemHandlerHelper;

public class GivePVPItemProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (Math.random() <= JujutsucraftaddonModVariables.MapVariables.get(world).PVPReward5Rate) {
            if (entity instanceof Player _player) {
                ItemStack _setstack = JujutsucraftaddonModVariables.MapVariables.get(world).PVPReward5.copy();
                _setstack.setCount((int) JujutsucraftaddonModVariables.MapVariables.get(world).PVPAmount5);
                ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }
        } else if (Math.random() <= JujutsucraftaddonModVariables.MapVariables.get(world).PVPReward4Rate) {
            if (entity instanceof Player _player) {
                ItemStack _setstack = JujutsucraftaddonModVariables.MapVariables.get(world).PVPReward4.copy();
                _setstack.setCount((int) JujutsucraftaddonModVariables.MapVariables.get(world).PVPAmount4);
                ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }
        } else if (Math.random() <= JujutsucraftaddonModVariables.MapVariables.get(world).PVPReward3Rate) {
            if (entity instanceof Player _player) {
                ItemStack _setstack = JujutsucraftaddonModVariables.MapVariables.get(world).PVPReward3.copy();
                _setstack.setCount((int) JujutsucraftaddonModVariables.MapVariables.get(world).PVPAmount3);
                ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }
        } else if (Math.random() <= JujutsucraftaddonModVariables.MapVariables.get(world).PVPReward2Rate) {
            if (entity instanceof Player _player) {
                ItemStack _setstack = JujutsucraftaddonModVariables.MapVariables.get(world).PVPReward2.copy();
                _setstack.setCount((int) JujutsucraftaddonModVariables.MapVariables.get(world).PVPAmount2);
                ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }
        } else if (Math.random() <= JujutsucraftaddonModVariables.MapVariables.get(world).PVPRewardRate) {
            if (entity instanceof Player _player) {
                ItemStack _setstack = JujutsucraftaddonModVariables.MapVariables.get(world).PVPReward.copy();
                _setstack.setCount((int) JujutsucraftaddonModVariables.MapVariables.get(world).PVPAmount1);
                ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }
        }
    }
}
