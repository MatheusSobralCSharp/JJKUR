package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class RemoveNegativeStatusProcedure {
    public static void execute(LevelAccessor world, Entity sourceentity) {
        if (sourceentity == null)
            return;
        if (sourceentity instanceof LivingEntity && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
            if (sourceentity instanceof LivingEntity _entity)
                _entity.removeEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get());
        } else if (sourceentity instanceof LivingEntity && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
            if (sourceentity instanceof LivingEntity _entity)
                _entity.removeEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get());
        } else if (sourceentity instanceof LivingEntity && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.UNSTABLE.get())) {
            if (sourceentity instanceof LivingEntity _entity)
                _entity.removeEffect(JujutsucraftModMobEffects.UNSTABLE.get());
        } else if (sourceentity.getPersistentData().getDouble("brokenBrain") == 2) {
            sourceentity.getPersistentData().putDouble("brokenBrain", 0);
        }
    }
}
