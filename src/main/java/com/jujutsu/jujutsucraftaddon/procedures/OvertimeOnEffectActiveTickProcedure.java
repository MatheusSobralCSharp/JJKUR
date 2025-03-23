package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class OvertimeOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (!(world instanceof Level _lvl0 && _lvl0.isDay())) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.CURSE_POWER_BLUE_DARK.get(), x, (y + 1), z, 2, 0, 0, 0, 0.5);
        } else if (world instanceof Level _lvl2 && _lvl2.isDay()) {
            if (!(entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(MobEffects.WEAKNESS))) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.removeEffect(JujutsucraftaddonModMobEffects.OVERTIME.get());
            }
        }
    }
}
