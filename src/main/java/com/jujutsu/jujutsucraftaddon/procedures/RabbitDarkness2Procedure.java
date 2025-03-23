package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;

public class RabbitDarkness2Procedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 40, 1, false, false));
        if (entity instanceof Mob) {
            try {
                ((Mob) entity).setTarget(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        entity.getPersistentData().putDouble("cnt_x", 0);
        entity.getPersistentData().putDouble("cnt_target", 0);
    }
}
