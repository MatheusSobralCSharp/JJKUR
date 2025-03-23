package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class ChosoArmsItemInHandTickProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (!(entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get()))) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get(), 400,
                        (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get()).getAmplifier() : 0) + 1,
                        false, false));
        }
    }
}
