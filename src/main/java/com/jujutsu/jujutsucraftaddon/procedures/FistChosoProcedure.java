package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class FistChosoProcedure {
    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if ((sourceentity.getDirection()) == Direction.DOWN) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.BLOOD_RED.get(), (sourceentity.getX() + 0.35), (sourceentity.getY() + 1), (sourceentity.getZ() - 0.2), 0, 0, 0, 0, 1);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.BLOOD_RED.get(), (sourceentity.getX() - 0.35), (sourceentity.getY() + 1), (sourceentity.getZ() - 0.2), 0, 0, 0, 0, 1);
        } else if ((sourceentity.getDirection()) == Direction.SOUTH) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.BLOOD_RED.get(), (sourceentity.getX() + 0.35), (sourceentity.getY() + 1), (sourceentity.getZ() - 0.2), 0, 0, 0, 0, 1);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.BLOOD_RED.get(), (sourceentity.getX() - 0.35), (sourceentity.getY() + 1), (sourceentity.getZ() - 0.2), 0, 0, 0, 0, 1);
        } else if ((sourceentity.getDirection()) == Direction.WEST) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.BLOOD_RED.get(), (sourceentity.getX()), (sourceentity.getY() + 1), (sourceentity.getZ() + 0.5), 0, 0, 0, 0, 1);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.BLOOD_RED.get(), (sourceentity.getX()), (sourceentity.getY() + 1), (sourceentity.getZ() - 0.5), 0, 0, 0, 0, 1);
        } else if ((sourceentity.getDirection()) == Direction.EAST) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.BLOOD_RED.get(), (sourceentity.getX()), (sourceentity.getY() + 1), (sourceentity.getZ() + 0.5), 0, 0, 0, 0, 1);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.BLOOD_RED.get(), (sourceentity.getX()), (sourceentity.getY() + 1), (sourceentity.getZ() - 0.5), 0, 0, 0, 0, 1);
        }
        if (Math.random() < (1) / ((float) 10)) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get(), 60,
                        (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get()).getAmplifier() : 0) + 7,
                        false, false));
            if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get(), 60,
                        (sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get()).getAmplifier() : 0)
                                + 4,
                        false, false));
        }
    }
}
