package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.registries.ForgeRegistries;

public class CleaveWebModelVisualScaleProcedure {
    public static double execute(Entity entity) {
        if (entity == null)
            return 0;
        return ((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() + 10;
    }
}
