package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.procedures.AttackWeakProcedure;
import net.mcreator.jujutsucraft.procedures.RangeAttackProcedure;
import net.mcreator.jujutsucraft.procedures.ReturnEntitySizeProcedure;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.level.LevelAccessor;

public class DivergentProcedure {
    public DivergentProcedure() {
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double loop_num;
            LivingEntity _livingEntity5;
            double CNT6;
            double strength;
            double old_skill;
            int var10000;
            double range;
            double x_pos;
            double pitch;
            double y_pos;
            double z_pos;
            double yaw;
            label61: {
                CNT6 = 0.0;
                strength = 0.0;
                old_skill = 0.0;
                double old_cooldownticks = 0.0;
                double old_level = 0.0;
                range = 0.0;
                x_pos = 0.0;
                pitch = 0.0;
                y_pos = 0.0;
                z_pos = 0.0;
                double old_tick = 0.0;
                yaw = 0.0;
                double weapon_size = 0.0;
                loop_num = 0.0;
                double attack_reach = 0.0;
                CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
                if (entity instanceof LivingEntity) {
                    _livingEntity5 = (LivingEntity)entity;
                    if (_livingEntity5.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        var10000 = _livingEntity5.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                        break label61;
                    }
                }

                var10000 = 0;
            }

            strength = (double)Math.min(var10000, 50) * CNT6;
            range = ReturnEntitySizeProcedure.execute(entity);
            if (entity.getPersistentData().getDouble("cnt7") == 0.0) {
                old_skill = entity.getPersistentData().getDouble("skill");
                if (entity instanceof LivingEntity) {
                    _livingEntity5 = (LivingEntity)entity;
                    if (_livingEntity5.getAttributes().hasAttribute((Attribute) JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity5.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-7.0);
                    }
                }

                AttackWeakProcedure.execute(world, x, y, z, entity);
                if (entity instanceof LivingEntity) {
                    _livingEntity5 = (LivingEntity)entity;
                    if (_livingEntity5.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity5.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(0.0);
                    }
                }

                if (entity.getPersistentData().getDouble("skill") == 0.0) {
                    entity.getPersistentData().putDouble("skill", old_skill);
                    entity.getPersistentData().putDouble("cnt7", 1.0);
                    entity.getPersistentData().putDouble("cnt1", 0.0);
                    entity.getPersistentData().putBoolean("attack", false);
                    yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
                    pitch = Math.toRadians((double)entity.getXRot());
                    entity.getPersistentData().putDouble("x_pos", entity.getX() + Math.cos(yaw) * Math.cos(pitch) * 0.0);
                    entity.getPersistentData().putDouble("y_pos", entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * 0.0);
                    entity.getPersistentData().putDouble("z_pos", entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * 0.0);
                    entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 0.5 * range);
                    entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 0.5 * range);
                    entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 0.5 * range);
                }
            } else {
                entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
                if (entity.getPersistentData().getDouble("cnt1") > 0.0) {
                    label49: {
                        CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.2;
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEnt = (LivingEntity)entity;
                            if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                break label49;
                            }
                        }

                        var10000 = 0;
                    }

                    strength = (double)Math.min(var10000, 50) * CNT6;
                    range = Math.pow(ReturnEntitySizeProcedure.execute(entity), 2.0);
                    loop_num = 11.0;

                    for(int index0 = 0; index0 < (int)loop_num; ++index0) {
                        entity.getPersistentData().putDouble("x_pos", entity.getPersistentData().getDouble("x_pos") + entity.getPersistentData().getDouble("x_power"));
                        entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") + entity.getPersistentData().getDouble("y_power"));
                        entity.getPersistentData().putDouble("z_pos", entity.getPersistentData().getDouble("z_pos") + entity.getPersistentData().getDouble("z_power"));
                        x_pos = entity.getPersistentData().getDouble("x_pos");
                        y_pos = entity.getPersistentData().getDouble("y_pos");
                        z_pos = entity.getPersistentData().getDouble("z_pos");
                        entity.getPersistentData().putDouble("Damage", 12.0 * CNT6);
                        entity.getPersistentData().putDouble("knockback", 0.25 * CNT6);
                        entity.getPersistentData().putDouble("Range", 4.0 * range);
                        entity.getPersistentData().putDouble("projectile_type", 1.0);
                        RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                    }

                    entity.getPersistentData().putDouble("skill", 0.0);
                }
            }

        }
    }
}