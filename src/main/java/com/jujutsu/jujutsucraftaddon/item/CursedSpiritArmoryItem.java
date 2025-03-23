package com.jujutsu.jujutsucraftaddon.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public class CursedSpiritArmoryItem extends ArmorItem {
    public CursedSpiritArmoryItem(Type type, Properties properties) {
        super(new ArmorMaterial() {
            public int getDurabilityForType(Type type) {
                return (new int[]{13, 15, 16, 11})[type.getSlot().getIndex()] * 0;
            }

            public int getDefenseForType(Type type) {
                return (new int[]{0, 0, 0, 0})[type.getSlot().getIndex()];
            }

            public int getEnchantmentValue() {
                return 0;
            }

            public SoundEvent getEquipSound() {
                return SoundEvents.EMPTY;
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.of();
            }

            public String getName() {
                return "cursed_spirit_armoury";
            }

            public float getToughness() {
                return 0.0F;
            }

            public float getKnockbackResistance() {
                return 0.0F;
            }
        }, type, properties);
    }
}
