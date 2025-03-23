package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class YagaDollNew2Procedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if ((ForgeRegistries.ITEMS.getKey((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:item_doll")) {
            if ((entity.getPersistentData().getString("OWNER_UUID")).equals(sourceentity.getStringUUID())) {
                if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).contains("jujutsucraft:doll")) {
                    if (entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
                        _livingEntity6.getAttribute(Attributes.ATTACK_DAMAGE)
                                .setBaseValue(((entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity5.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0) + 1));
                    if (entity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                        _livingEntity8.getAttribute(Attributes.MAX_HEALTH)
                                .setBaseValue(((entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity7.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) + 100));
                    if (entity instanceof LivingEntity _entity)
                        _entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                    if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("Buffed your son"), false);
                    if (sourceentity instanceof Player _player) {
                        ItemStack _stktoremove = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
                        _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                    }
                } else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:panda_normal")) {
                    SummonPanda2Procedure.execute(world, x, y, z, entity, sourceentity);
                    if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("Buffed your son"), false);
                    if (sourceentity instanceof Player _player) {
                        ItemStack _stktoremove = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
                        _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                    }
                }
            }
        }
    }
}
