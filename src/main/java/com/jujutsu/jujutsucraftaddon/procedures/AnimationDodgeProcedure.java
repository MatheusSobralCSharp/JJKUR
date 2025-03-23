package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class AnimationDodgeProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;

        if (entity instanceof LivingEntity) {
            if (!(((LivingEntity) entity).hasEffect(JujutsucraftaddonModMobEffects.DODGE.get()))) {
                ((LivingEntity) entity).addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.DODGE.get(), 10, 1, false, false));
            }
        }
    }
}
