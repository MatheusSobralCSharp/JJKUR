package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class SukunaPlayerPlaybackCondition2Procedure {
    public static boolean execute(Entity entity) {
        if (entity == null)
            return false;
        return entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftaddonModMobEffects.SUKUNA_AWAKEN_2.get());
    }
}
