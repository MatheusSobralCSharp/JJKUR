package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class FistJogoProcedure {
    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if ((sourceentity.getDirection()) == Direction.NORTH) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (sourceentity.getX() + 0.35), (sourceentity.getY() + 1), (sourceentity.getZ() - 0.2), 0, 0, 0, 0, 1);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (sourceentity.getX() - 0.35), (sourceentity.getY() + 1), (sourceentity.getZ() - 0.2), 0, 0, 0, 0, 1);
        } else if ((sourceentity.getDirection()) == Direction.SOUTH) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (sourceentity.getX() + 0.35), (sourceentity.getY() + 1), (sourceentity.getZ() - 0.2), 0, 0, 0, 0, 1);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (sourceentity.getX() - 0.35), (sourceentity.getY() + 1), (sourceentity.getZ() - 0.2), 0, 0, 0, 0, 1);
        } else if ((sourceentity.getDirection()) == Direction.WEST) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (sourceentity.getX()), (sourceentity.getY() + 1), (sourceentity.getZ() + 0.5), 0, 0, 0, 0, 1);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (sourceentity.getX()), (sourceentity.getY() + 1), (sourceentity.getZ() - 0.5), 0, 0, 0, 0, 1);
        } else if ((sourceentity.getDirection()) == Direction.EAST) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (sourceentity.getX()), (sourceentity.getY() + 1), (sourceentity.getZ() + 0.5), 0, 0, 0, 0, 1);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (sourceentity.getX()), (sourceentity.getY() + 1), (sourceentity.getZ() - 0.5), 0, 0, 0, 0, 1);
        }
        if (Math.random() < (1) / ((float) 10)) {
            entity.setSecondsOnFire(5);
        }
        if (sourceentity.isInLava()) {
            if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 3, false, false));
        }
        if (!(sourceentity instanceof LivingEntity _livEnt44 && _livEnt44.hasEffect(JujutsucraftaddonModMobEffects.JOGO_FLAME.get()))) {
            if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.JOGO_FLAME.get(), -1, 3, false, false));
        }
    }
}
