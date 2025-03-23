package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class BulletProjectileHitsLivingEntityProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (world instanceof ServerLevel _level)
            _level.sendParticles(JujutsucraftaddonModParticleTypes.BLOOD.get(), (entity.getX()), (entity.getY() + 2), (entity.getZ()), 0, 0, 0, 0, 1);
        if (world instanceof ServerLevel _level)
            _level.sendParticles(JujutsucraftaddonModParticleTypes.BLOOD_RED.get(), (entity.getX()), (entity.getY() + 1.5), (entity.getZ()), 0, 0, 0, 0, 1);
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 1, false, false));
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1, false, false));
    }
}
