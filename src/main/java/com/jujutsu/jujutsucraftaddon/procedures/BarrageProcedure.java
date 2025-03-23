package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.KeyStartTechniqueOnKeyPressedProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class BarrageProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity instanceof LivingEntity _entity) {
            entity.getPersistentData().putDouble("skill", 103);
            KeyStartTechniqueOnKeyPressedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
            if (!_entity.level().isClientSide()) {
                _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int) 60, 0, false, false));
                _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int) 60, 0, false, false));
                _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
            }
            entity.getPersistentData().putDouble("cnt6", 4);
        }
    }
}

