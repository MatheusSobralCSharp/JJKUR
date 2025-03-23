package com.jujutsu.jujutsucraftaddon.enchantment;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class GodOfDestructionEnchantment extends Enchantment {
    private static final EnchantmentCategory ENCHANTMENT_CATEGORY = EnchantmentCategory.create("jujutsucraftaddon_god_of_destruction", item -> Ingredient.of(ItemTags.create(new ResourceLocation("enchantable/armor"))).test(new ItemStack(item)));

    public GodOfDestructionEnchantment() {
        super(Rarity.VERY_RARE, ENCHANTMENT_CATEGORY, new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET});
    }

    @Override
    public int getMinCost(int level) {
        return 1 + level * 10;
    }

    @Override
    public int getMaxCost(int level) {
        return 6 + level * 10;
    }

    @Override
    public int getMaxLevel() {
        return 1000;
    }

    @Override
    public boolean isDiscoverable() {
        return false;
    }

    @Override
    public boolean isTradeable() {
        return false;
    }
}
