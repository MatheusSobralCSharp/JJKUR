package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.LevelAccessor;

public class FireAspectProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.FIRE_ASPECT, 10);
    }
}
