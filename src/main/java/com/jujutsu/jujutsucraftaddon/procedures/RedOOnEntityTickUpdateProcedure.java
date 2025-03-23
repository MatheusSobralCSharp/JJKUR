package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class RedOOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftaddonModMobEffects.RED_EFFECT.get())) {
            JujutsucraftaddonMod.queueServerWork(80, () -> {
                if (world instanceof Level _level && !_level.isClientSide())
                    _level.explode(null, x, y, z, 2, Level.ExplosionInteraction.TNT);
                if (!entity.level().isClientSide())
                    entity.discard();
            });
        }
    }
}
