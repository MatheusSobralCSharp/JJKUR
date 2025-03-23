package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.item.ItemStack;

public class WukongStaffItemGlowingConditionProcedure {
    public static boolean execute(ItemStack itemstack) {
        return itemstack.getOrCreateTag().getBoolean("Mode");
    }
}
