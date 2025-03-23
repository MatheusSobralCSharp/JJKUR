package com.jujutsu.jujutsucraftaddon.item;


import com.google.common.collect.Iterables;
import com.jujutsu.jujutsucraftaddon.procedures.SunWukongDefense;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

import java.util.List;


public abstract class WukongSetItem extends ArmorItem {
    public WukongSetItem(Type type, Properties properties) {
        super(new ArmorMaterial() {
            @Override
            public int getDurabilityForType(Type type) {
                return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 0;
            }

            @Override
            public int getDefenseForType(Type type) {
                return new int[]{2, 5, 6, 2}[type.getSlot().getIndex()];
            }

            @Override
            public int getEnchantmentValue() {
                return 9;
            }

            @Override
            public SoundEvent getEquipSound() {
                return SoundEvents.EMPTY;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of();
            }

            @Override
            public String getName() {
                return "wukong_set";
            }

            @Override
            public float getToughness() {
                return 0f;
            }

            @Override
            public float getKnockbackResistance() {
                return 0f;
            }
        }, type, properties);
    }

    public static class Chestplate extends WukongSetItem {
        public Chestplate() {
            super(Type.CHESTPLATE, new Properties().rarity(Rarity.EPIC));
        }

        @Override
        public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
            super.appendHoverText(itemstack, level, list, flag);
            list.add(Component.literal("[Ability] Gives RCT Passively"));
            list.add(Component.literal("[Ability] Gives Immortality"));
            list.add(Component.literal("[Ability] Return 10% Damage to Attackers"));
        }

        @Override
        public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
            super.inventoryTick(itemstack, world, entity, slot, selected);
            if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
                SunWukongDefense.execute(world, player, itemstack);
            }
        }

        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "jujutsucraftaddon:textures/models/armor/wukong_armor_layer_1.png";
        }
    }

    public static class Leggings extends WukongSetItem {
        public Leggings() {
            super(Type.LEGGINGS, new Properties().rarity(Rarity.EPIC));
        }

        @Override
        public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
            super.appendHoverText(itemstack, level, list, flag);
            list.add(Component.literal("[Ability] Gives Double Jump"));
        }

        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "jujutsucraftaddon:textures/models/armor/wukong_armor_layer_2.png";
        }
    }


    public static class Boots extends WukongSetItem {
        public Boots() {
            super(Type.BOOTS, new Properties().rarity(Rarity.EPIC));
        }

        @Override
        public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
            super.appendHoverText(itemstack, level, list, flag);
            list.add(Component.literal("[Ability] Gives Iframes"));
        }


        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "jujutsucraftaddon:textures/models/armor/wukong_armor_layer_1.png";
        }
    }
}
