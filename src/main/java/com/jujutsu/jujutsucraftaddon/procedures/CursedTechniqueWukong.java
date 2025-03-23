package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.FistGunProcedure;
import net.mcreator.jujutsucraft.procedures.GaragaraProcedure;
import net.mcreator.jujutsucraft.procedures.OtherDomainExpansionProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueWukong {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double skill = 0.0;
            skill = (double)Math.round(entity.getPersistentData().getDouble("skill") - 10000.0);
            if (skill == 3.0) {
                GaragaraProcedure.execute(world, x, y, z, entity);
            } else if (skill == 4.0) {
                FistGunProcedure.execute(world, entity);
            } else if (skill == 5.0) {
                if (entity.isShiftKeyDown()) {
                    CloneDespawn.execute(world, x, y, z, entity);
                }
                entity.getPersistentData().putDouble("skill", 0);
            } else if (skill == 6.0) {
                WukongWrath.execute(world, x, y, z, entity);
                entity.getPersistentData().putDouble("skill", 0);
            } else if (skill == 7.0) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.GUARD.get(), 1200, 3, false, false));
                entity.getPersistentData().putDouble("skill", 0);
            } else if (skill == 8.0) {
                CloneMeteor.execute(world, x, y, z, entity);
            }else if (skill == 9.0) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 4, false, false));
                entity.getPersistentData().putDouble("skill", 0);
            }  else if (skill == 20.0) {
                OtherDomainExpansionProcedure.execute(world, x, y, z, entity);
            } else {
                if (entity instanceof LivingEntity) {
                    LivingEntity _entity = (LivingEntity)entity;
                    _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                }
            }
        }
    }
}
