package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class YorozuReleaseProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        boolean found = false;
        double sx = 0;
        double sy = 0;
        double sz = 0;
        double x_pos = 0;
        double y_pos = 0;
        double z_pos = 0;
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.YOROZU.get(), 4800, 1, false, false));
    }
}
