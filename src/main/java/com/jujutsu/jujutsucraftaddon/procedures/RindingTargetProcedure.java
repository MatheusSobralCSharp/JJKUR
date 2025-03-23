package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;

public class RindingTargetProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof Mob _mob && _mob.isAggressive()) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4, false, false));
            entity.setSprinting(true);
        } else {
            entity.setSprinting(false);
        }
    }
}
