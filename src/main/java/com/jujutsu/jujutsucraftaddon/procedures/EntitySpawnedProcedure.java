package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class EntitySpawnedProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 23, false, false));
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 3, false, false));
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, -1, 4, false, false));
        if (entity instanceof LivingEntity _entity) {
            ItemStack _setstack = new ItemStack(JujutsucraftModItems.NYOI_STAFF.get());
            _setstack.setCount(1);
            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
            if (_entity instanceof Player _player)
                _player.getInventory().setChanged();
        }
        {
            Entity _entity = entity;
            if (_entity instanceof Player _player) {
                _player.getInventory().armor.set(3, new ItemStack(JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_HELMET.get()));
                _player.getInventory().setChanged();
            } else if (_entity instanceof LivingEntity _living) {
                _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_HELMET.get()));
            }
        }
        {
            Entity _entity = entity;
            if (_entity instanceof Player _player) {
                _player.getInventory().armor.set(2, new ItemStack(JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_CHESTPLATE.get()));
                _player.getInventory().setChanged();
            } else if (_entity instanceof LivingEntity _living) {
                _living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_CHESTPLATE.get()));
            }
        }
        {
            Entity _entity = entity;
            if (_entity instanceof Player _player) {
                _player.getInventory().armor.set(1, new ItemStack(JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_LEGGINGS.get()));
                _player.getInventory().setChanged();
            } else if (_entity instanceof LivingEntity _living) {
                _living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_LEGGINGS.get()));
            }
        }
        {
            Entity _entity = entity;
            if (_entity instanceof Player _player) {
                _player.getInventory().armor.set(0, new ItemStack(JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_BOOTS.get()));
                _player.getInventory().setChanged();
            } else if (_entity instanceof LivingEntity _living) {
                _living.setItemSlot(EquipmentSlot.FEET, new ItemStack(JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_BOOTS.get()));
            }
        }
    }
}
