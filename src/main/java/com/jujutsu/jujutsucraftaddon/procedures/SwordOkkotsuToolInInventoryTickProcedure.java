package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.item.ItemStack;

public class SwordOkkotsuToolInInventoryTickProcedure {
    public static void execute(ItemStack itemstack) {
        if (itemstack.getOrCreateTag().getDouble("CursePower") <= 0) {
            itemstack.getOrCreateTag().putDouble("CursePower", 10);
        }
    }
}
