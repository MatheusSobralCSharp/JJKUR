package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class NozarashiToolInHandTickProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (entity.getPersistentData().getDouble("cnt6") == 6) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (-1),
                        (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier() : 0) + 1, false,
                        false));
            entity.getPersistentData().putBoolean("PRESS_Z", true);
        }
    }
}
