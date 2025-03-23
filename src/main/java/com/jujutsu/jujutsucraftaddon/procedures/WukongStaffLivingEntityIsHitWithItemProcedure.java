package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class WukongStaffLivingEntityIsHitWithItemProcedure {
    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, ItemStack itemstack) {
        if (entity == null || sourceentity == null)
            return;
        if (itemstack.getOrCreateTag().getBoolean("Mode")) {

        } else {
            if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 120, (sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) + 1,
                        false, false));
            if (entity instanceof LivingEntity _entity1 && !_entity1.level().isClientSide())
                _entity1.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANTI_HEAL.get(), 60,  1, false, false));

            if (entity instanceof LivingEntity _entity1 && !_entity1.level().isClientSide())
                _entity1.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60,  4, false, false));

            if (entity instanceof LivingEntity _entity1 && !_entity1.level().isClientSide())
                _entity1.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 60,  3, false, false));

        }
    }
}
