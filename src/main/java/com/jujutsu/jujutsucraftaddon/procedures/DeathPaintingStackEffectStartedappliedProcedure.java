package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemHandlerHelper;

public class DeathPaintingStackEffectStartedappliedProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof Player _player) {
            ItemStack _setstack = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).copy();
            _setstack.setCount(1);
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
        }
        {
            Entity _entity = entity;
            if (_entity instanceof Player _player) {
                _player.getInventory().armor.set(3, new ItemStack(JujutsucraftaddonModItems.CHOSO_ARMOR_HELMET.get()));
                _player.getInventory().setChanged();
            } else if (_entity instanceof LivingEntity _living) {
                _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(JujutsucraftaddonModItems.CHOSO_ARMOR_HELMET.get()));
            }
        }
        if (entity instanceof Player _player) {
            ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.CHOSO_ARMS.get()).copy();
            _setstack.setCount(2);
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
        }
    }
}
