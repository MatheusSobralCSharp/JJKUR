package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.entity.FushiguroTojiBugEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class QuakeOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof LivingEntity) {
            if (!(entity instanceof FushiguroTojiBugEntity)) {
                if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
                    double baseIntensity = 6.0;
                    double randomFactor = entity.level().random.nextFloat(); // Random factor for chaotic effect
                    double shakeIntensity = baseIntensity * (0.7 + randomFactor * 1.5); // More intense randomness

//                    // Randomly adjust the player's yaw and pitch with a larger variation
//                    entity.setYRot((float) (entity.getYRot() + (entity.level().random.nextFloat() - 0.5) * shakeIntensity * 3));
//                    entity.setXRot((float) (entity.getXRot() + (entity.level().random.nextFloat() - 0.5) * shakeIntensity * 2));
//
//                    // Sync body and head rotations with the new yaw
//                    entity.setYBodyRot(entity.getYRot());
//                    entity.setYHeadRot(entity.getYRot());
//                    entity.yRotO = entity.getYRot();
//                    entity.xRotO = entity.getXRot();
//
//                    if (entity instanceof LivingEntity _entity) {
//                        _entity.yBodyRotO = _entity.getYRot();
//                        _entity.yHeadRotO = _entity.getYRot();
//                    }
                    entity.getPersistentData().putDouble("cnt_x", 0);
                    entity.getPersistentData().putDouble("PRESS_Z", 0.0);
                    entity.getPersistentData().putDouble("skill", 0);
                    entity.getPersistentData().putDouble("cnt_target", 0.0);
                    QuakeEffectTradeBackProcedure.execute(world, entity);
                }
            } else {
                if (entity instanceof LivingEntity _entity)
                    _entity.removeEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                entity.getPersistentData().putDouble("cnt_target", 0.0);
                entity.getPersistentData().putDouble("cnt_x", 0);
                entity.getPersistentData().putDouble("PRESS_Z", 0.0);
                entity.getPersistentData().putDouble("skill", 0);
                QuakeEffectTradeBackProcedure.execute(world, entity);
            }
        }
    }
}

