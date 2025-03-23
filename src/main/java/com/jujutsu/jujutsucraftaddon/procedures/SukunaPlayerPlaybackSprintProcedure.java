package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class SukunaPlayerPlaybackSprintProcedure {
    public static boolean execute(Entity entity) {
        if (entity == null)
            return false;
        return entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MobEffects.MOVEMENT_SPEED);
    }
}
