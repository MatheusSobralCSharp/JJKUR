package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.item.ItemStack;

public class BloodEdgeEntitySwingsItemProcedure {
    public static void execute(ItemStack itemstack) {
        if (!(itemstack.getOrCreateTag().getDouble("CursePower") == 10)) {
            itemstack.getOrCreateTag().putDouble("CursePower", 10);
        }
    }
}
