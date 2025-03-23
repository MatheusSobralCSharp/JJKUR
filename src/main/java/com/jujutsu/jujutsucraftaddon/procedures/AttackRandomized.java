package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.GetPowerForwardProcedure;
import net.mcreator.jujutsucraft.procedures.RangeAttackProcedure;
import net.mcreator.jujutsucraft.procedures.ReturnEntitySizeProcedure;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class AttackRandomized {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double yaw = 0.0;
            double pitch = 0.0;
            double dis = 0.0;
            entity.fallDistance = 0.0F;
            dis = 20.0 + ReturnEntitySizeProcedure.execute(entity);
            LivingEntity var10000;
            if (entity instanceof Mob _mobEnt) {
                var10000 = _mobEnt.getTarget();
            } else {
                var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
                Mob _mobEnt;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                Level var22 = var10000.level();
                ClipContext var10001;
                LivingEntity var10003;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10003 = _mobEnt.getTarget();
                } else {
                    var10003 = null;
                }

                Vec3 var23 = var10003.getEyePosition(1.0F);
                LivingEntity var10004;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10004 = _mobEnt.getTarget();
                } else {
                    var10004 = null;
                }

                Vec3 var25 = var10004.getEyePosition(1.0F);
                LivingEntity var10005;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10005 = _mobEnt.getTarget();
                } else {
                    var10005 = null;
                }

                var25 = var25.add(var10005.getViewVector(1.0F).scale(0.0));
                ClipContext.Block var28 = ClipContext.Block.OUTLINE;
                ClipContext.Fluid var10006 = ClipContext.Fluid.NONE;
                LivingEntity var10007;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10007 = _mobEnt.getTarget();
                } else {
                    var10007 = null;
                }

                var10001 = new ClipContext(var23, var25, var28, var10006, var10007);
                x_pos = var22.clip(var10001).getBlockPos().getX();
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                var22 = var10000.level();
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10003 = _mobEnt.getTarget();
                } else {
                    var10003 = null;
                }

                var23 = var10003.getEyePosition(1.0F);
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10004 = _mobEnt.getTarget();
                } else {
                    var10004 = null;
                }

                var25 = var10004.getEyePosition(1.0F);
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10005 = _mobEnt.getTarget();
                } else {
                    var10005 = null;
                }

                var25 = var25.add(var10005.getViewVector(1.0F).scale(0.0));
                var28 = ClipContext.Block.OUTLINE;
                var10006 = ClipContext.Fluid.NONE;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10007 = _mobEnt.getTarget();
                } else {
                    var10007 = null;
                }

                var10001 = new ClipContext(var23, var25, var28, var10006, var10007);
                y_pos = var22.clip(var10001).getBlockPos().getY();
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                var22 = var10000.level();
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10003 = _mobEnt.getTarget();
                } else {
                    var10003 = null;
                }

                var23 = var10003.getEyePosition(1.0F);
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10004 = _mobEnt.getTarget();
                } else {
                    var10004 = null;
                }

                var25 = var10004.getEyePosition(1.0F);
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10005 = _mobEnt.getTarget();
                } else {
                    var10005 = null;
                }

                var25 = var25.add(var10005.getViewVector(1.0F).scale(0.0));
                var28 = ClipContext.Block.OUTLINE;
                var10006 = ClipContext.Fluid.NONE;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10007 = _mobEnt.getTarget();
                } else {
                    var10007 = null;
                }

                var10001 = new ClipContext(var23, var25, var28, var10006, var10007);
                z_pos = var22.clip(var10001).getBlockPos().getZ();
            } else {
                x_pos = entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(32.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
                y_pos = entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(32.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
                z_pos = entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(32.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
            }

            LivingEntity _livEnt17;
            if (entity.getPersistentData().getDouble("cnt2") <= 13.0) {
                entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
                if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
                    label170:
                    {
                        if (!entity.onGround()) {
                            label169:
                            {
                                if (entity instanceof LivingEntity) {
                                    _livEnt17 = (LivingEntity) entity;
                                    if (_livEnt17.hasEffect(JujutsucraftModMobEffects.FLY_EFFECT.get())) {
                                        break label169;
                                    }
                                }

                                entity.getPersistentData().putDouble("cnt2", Math.max(entity.getPersistentData().getDouble("cnt2"), 6.0));
                                break label170;
                            }
                        }

                        entity.getPersistentData().putDouble("cnt3", 1.0);
                        GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
                        if (entity.onGround()) {
                            if (entity.getPersistentData().getDouble("y_power") <= 0.0) {
                                entity.getPersistentData().putDouble("y_power", 0.75);
                            }

                            entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 1.25, entity.getPersistentData().getDouble("y_power") * 1.25, entity.getPersistentData().getDouble("z_power") * 1.25));
                        }
                    }
                }
            } else {
                if (entity.getPersistentData().getDouble("cnt2") == 14.0) {
                    entity.getPersistentData().putBoolean("canFly", true);
                    GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
                    entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 1.25, Math.min(entity.getPersistentData().getDouble("y_power") * 1.25, 0.0), entity.getPersistentData().getDouble("z_power") * 1.25));
                }

                entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
                x_pos = entity.getX();
                y_pos = entity.getY() + (double) entity.getBbHeight() * 0.5;
                z_pos = entity.getZ();
                entity.getPersistentData().putDouble("Damage", 8.0);
                entity.getPersistentData().putDouble("Range", dis);
                entity.getPersistentData().putDouble("knockback", 1.0);
                entity.getPersistentData().putDouble("effect", 5.0);
                entity.getPersistentData().putBoolean("swing", true);
                entity.getPersistentData().putBoolean("attack", true);
                RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                if (entity.getPersistentData().getDouble("cnt1") == 0.0 && entity.getPersistentData().getDouble("cnt2") > 2.0 && entity.onGround()) {
                    if (entity instanceof LivingEntity) {
                        _livEnt17 = (LivingEntity) entity;
                        _livEnt17.swing(InteractionHand.MAIN_HAND, true);
                    }

                    entity.getPersistentData().putDouble("cnt1", 1.0);
                }

                if (entity.getPersistentData().getDouble("cnt1") > 0.0) {
                    entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
                    entity.setDeltaMovement(new Vec3(0.0, Math.min(entity.getDeltaMovement().y(), -0.5), 0.0));
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.explode(null, x, y, z, 0.0F, Level.ExplosionInteraction.NONE);
                        }
                    }

                    ServerLevel _level;
                    if (world instanceof ServerLevel) {
                        _level = (ServerLevel) world;
                        _level.sendParticles(ParticleTypes.CLOUD, x, y, z, (int) (5.0 * dis), dis * 0.5, 0.0, dis * 0.5, 0.25);
                    }

                    if (world instanceof ServerLevel) {
                        _level = (ServerLevel) world;
                        _level.sendParticles(ParticleTypes.EXPLOSION, x, y, z, (int) (5.0 * dis), dis * 0.5, 0.0, dis * 0.5, 0.25);
                    }

                    entity.getPersistentData().putDouble("Damage", 10.0);
                    entity.getPersistentData().putDouble("Range", dis * 1.5);
                    entity.getPersistentData().putDouble("knockback", 2.0);
                    entity.getPersistentData().putDouble("projectile_type", 1.0);
                    entity.getPersistentData().putBoolean("attack", true);
                    RangeAttackProcedure.execute(world, x, y, z, entity);
                }

                if (entity.getPersistentData().getDouble("cnt2") > 60.0 && entity.getPersistentData().getDouble("cnt1") == 0.0 || entity.getPersistentData().getDouble("cnt1") > 3.0) {
                    entity.getPersistentData().putDouble("skill", 0.0);
                }
            }

            entity.getPersistentData().putBoolean("attack", true);
        }

    }
}
