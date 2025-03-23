package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class BloodEdgeLivingEntityIsHitWithToolProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if (entity instanceof LivingEntity _entity)
            _entity.removeEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get());
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CANCEL_CURSED_TECHNIQUE.get(), 60, 1, false, false));
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get(), 60,
                    (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get())
                            ? ((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get()).getAmplifier()
                            : 0) + 4,
                    false, true));
        if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1, false, false));
        if (world instanceof ServerLevel _level)
            _level.sendParticles(JujutsucraftaddonModParticleTypes.BLOOD_RED.get(), x, (y + 1), z, 0, 0, 0, 0, 1);
    }
}
