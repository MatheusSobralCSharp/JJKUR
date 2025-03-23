package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class VeilOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        entity.setInvulnerable(true);
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 253, false, false));
    }
}
