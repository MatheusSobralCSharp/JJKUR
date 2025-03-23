package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;


public class UraumeOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 33, false, false));
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, -1, 6, false, false));
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 3, false, false));
        ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(20);
        ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS).setBaseValue(2);
        ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).setBaseValue(5);
        ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK).setBaseValue(20);
        CompoundTag dataIndex7 = new CompoundTag();
        entity.saveWithoutId(dataIndex7);
        dataIndex7.getCompound("ForgeData").putDouble("CurseUser", 1);
        entity.load(dataIndex7);
        CompoundTag dataIndex8 = new CompoundTag();
        entity.saveWithoutId(dataIndex8);
        dataIndex8.getCompound("ForgeData").putDouble("UseCursedTechnique", 1);
        entity.load(dataIndex8);
        {
            Entity _entity = entity;
            if (_entity instanceof Player _player) {
                _player.getInventory().armor.set(0, new ItemStack(JujutsucraftModItems.CLOTHES_URAUME_BOOTS.get()));
                _player.getInventory().setChanged();
            } else if (_entity instanceof LivingEntity _living) {
                _living.setItemSlot(EquipmentSlot.FEET, new ItemStack(JujutsucraftModItems.CLOTHES_URAUME_BOOTS.get()));
            }
        }
        {
            Entity _entity = entity;
            if (_entity instanceof Player _player) {
                _player.getInventory().armor.set(1, new ItemStack(JujutsucraftModItems.CLOTHES_URAUME_LEGGINGS.get()));
                _player.getInventory().setChanged();
            } else if (_entity instanceof LivingEntity _living) {
                _living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(JujutsucraftModItems.CLOTHES_URAUME_LEGGINGS.get()));
            }
        }
        {
            Entity _entity = entity;
            if (_entity instanceof Player _player) {
                _player.getInventory().armor.set(2, new ItemStack(JujutsucraftModItems.CLOTHES_URAUME_CHESTPLATE.get()));
                _player.getInventory().setChanged();
            } else if (_entity instanceof LivingEntity _living) {
                _living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(JujutsucraftModItems.CLOTHES_URAUME_CHESTPLATE.get()));
            }
        }
        {
            Entity _entity = entity;
            if (_entity instanceof Player _player) {
                _player.getInventory().armor.set(3, new ItemStack(JujutsucraftModItems.CLOTHES_URAUME_HELMET.get()));
                _player.getInventory().setChanged();
            } else if (_entity instanceof LivingEntity _living) {
                _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(JujutsucraftModItems.CLOTHES_URAUME_HELMET.get()));
            }
        }
    }
}
