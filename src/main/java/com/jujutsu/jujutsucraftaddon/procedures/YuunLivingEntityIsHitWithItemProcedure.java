package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class YuunLivingEntityIsHitWithItemProcedure {
    public static void execute(Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        entity.setDeltaMovement(new Vec3((5 * Math.cos((sourceentity.getYRot() + 90) * (Math.PI / 180))), 0, (5 * Math.sin((sourceentity.getYRot() + 90) * (Math.PI / 180)))));
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANTI_HEAL.get(), 40, 1, false, false));
    }
}
