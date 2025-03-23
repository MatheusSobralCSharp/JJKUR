package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class MigueruReleaseProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.PRAYER_SONG.get(), 6000,
                    (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.PRAYER_SONG.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.PRAYER_SONG.get()).getAmplifier() : 0) + 1, false, false));
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.LA_DANSA.get(), 6000, 1, false, false));
        if (world instanceof ServerLevel _level)
            _level.sendParticles(JujutsucraftaddonModParticleTypes.THUNDER_WHITE.get(), x, y, z, 5, 0, 0, 0, 1);
        if (world instanceof ServerLevel _level)
            _level.sendParticles(JujutsucraftaddonModParticleTypes.THUNDER_BLACK.get(), x, y, z, 5, 0, 0, 0, 1);
    }
}
