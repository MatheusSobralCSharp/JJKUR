package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class AnimationTwoOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;


        ItemStack var10000;
        if (entity instanceof LivingEntity) {
            var10000 = ((LivingEntity) entity).getItemBySlot(EquipmentSlot.HEAD);
        } else {
            var10000 = ItemStack.EMPTY;
        }
        var10000.getOrCreateTag().putDouble("P_ANIME1", 0);

        if (entity instanceof LivingEntity) {
            var10000 = ((LivingEntity) entity).getItemBySlot(EquipmentSlot.HEAD);
        } else {
            var10000 = ItemStack.EMPTY;
        }
        var10000.getOrCreateTag().putDouble("P_ANIME2", 1);

        ResourceKey<DamageType> damageTypeKey = ResourceKey.create(
                Registries.DAMAGE_TYPE,
                new ResourceLocation("jujutsucraft:start_animation")
        );

        DamageSource damageSource = new DamageSource(
                world.registryAccess()
                        .registryOrThrow(Registries.DAMAGE_TYPE)
                        .getHolderOrThrow(damageTypeKey)
        );

        entity.hurt(damageSource, 1.0F);

    }
}
