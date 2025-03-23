package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class RespawnedEffectExpiresProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        ConcorrentSpawnProcedure.execute(entity, world, x, y, z);
        world.addParticle(JujutsucraftaddonModParticleTypes.THUNDER_WHITE.get(), x, y, z, 0, 1, 0);
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.CE_FIX_POTION.get(), 20, 1, false, false));
    }
}
