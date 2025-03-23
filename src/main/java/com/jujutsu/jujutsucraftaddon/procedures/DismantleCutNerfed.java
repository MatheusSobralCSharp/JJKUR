package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class DismantleCutNerfed {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity instanceof LivingEntity _entity) {
            entity.getPersistentData().putDouble("skill", 105);
            entity.getPersistentData().putDouble("cnt6", 5);
            entity.getPersistentData().putBoolean("flag_dismantle", true);
            if (!_entity.level().isClientSide()) {
                _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int) 400, 0, false, false));
            }
        }
    }
}

