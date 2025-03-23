package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.KeyStartTechniqueOnKeyReleasedProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class M1sProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity instanceof LivingEntity _entity) {
            entity.getPersistentData().putDouble("skill", 101);
            if (!_entity.level().isClientSide()) {
                _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int) 40, 0, false, false));
                _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int) 40, 0, false, false));
                _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
            }
            entity.getPersistentData().putDouble("cnt6", 4);
            KeyStartTechniqueOnKeyReleasedProcedure.execute(entity);
        }
    }
}
