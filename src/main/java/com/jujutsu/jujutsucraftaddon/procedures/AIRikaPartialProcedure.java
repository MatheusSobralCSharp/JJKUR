package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.*;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

import java.util.UUID;
import java.util.function.BiFunction;

public class AIRikaPartialProcedure {

    public AIRikaPartialProcedure() {
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rnd = 0.0;
            double dis = 0.0;
            boolean logic_a = false;
            boolean attack = false;
            Entity entity_a = null;
            ItemStack var100001;

            if (Math.random() < (1) / ((float) 60)) {
                AIRoundDeerProcedure.execute(world, x, y, z, entity);
            }

            if (Math.random() < (1) / ((float) 2)) {
                ServerLevel _level2;
                if (world instanceof ServerLevel) {
                    _level2 = (ServerLevel) world;
                    _level2.sendParticles(ParticleTypes.SQUID_INK, x, y + (double) entity.getBbHeight() * 0.5, z, 10, 1.0, 1.0, 1.0, 0.0);
                    _level2.sendParticles(ParticleTypes.LARGE_SMOKE, x, y + (double) entity.getBbHeight() * 0.5, z, 10, 1.0, 1.0, 1.0, 0.0);
                }

                if (world instanceof ServerLevel) {
                    _level2 = (ServerLevel) world;
                    _level2.sendParticles(ParticleTypes.SQUID_INK, x, y + (double) entity.getBbHeight() * 0.5 + 1, z, 10, 1.0, 1.0, 1.0, 0.0);
                    _level2.sendParticles(ParticleTypes.LARGE_SMOKE, x, y + (double) entity.getBbHeight() * 0.5 + 1, z, 10, 1.0, 1.0, 1.0, 0.0);
                }
                if (world instanceof ServerLevel) {
                    _level2 = (ServerLevel) world;
                    _level2.sendParticles(ParticleTypes.SQUID_INK, x, y + (double) entity.getBbHeight() * 0.5 + 2, 2, 10, 1.0, 1.0, 1.0, 0.0);
                    _level2.sendParticles(ParticleTypes.LARGE_SMOKE, x, y + (double) entity.getBbHeight() * 0.5 + 2, z, 10, 1.0, 1.0, 1.0, 0.0);
                }
            }

            if (entity.isAlive()) {
                LivingEntity _livEnt5;
                LivingEntity _entity;
                label149:
                {
                    AIActiveProcedure.execute(world, x, y, z, entity);
                    if (entity instanceof LivingEntity) {
                        _livEnt5 = (LivingEntity) entity;
                        if (_livEnt5.hasEffect(MobEffects.DAMAGE_BOOST)) {
                            break label149;
                        }
                    }

                    entity.setMaxUpStep((float) Math.max(entity.getStepHeight(), 2.4));
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity) entity;
                        if (!_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, Integer.MAX_VALUE, 18, false, false));
                        }
                    }
                }

                label144:
                {
                    if (entity instanceof LivingEntity) {
                        _livEnt5 = (LivingEntity) entity;
                        if (_livEnt5.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                            break label144;
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity) entity;
                        if (!_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 3, false, false));
                        }
                    }
                }

                if (entity.getPersistentData().getDouble("skill") == 0.0) {
                    if (entity.getPersistentData().getDouble("despawn_flag") > 0.0 && entity.getPersistentData().getDouble("friend_num_worker") != 0.0) {
                        entity.getPersistentData().putDouble("cnt_target", 0.0);
                        entity.getPersistentData().putDouble("cnt_die", entity.getPersistentData().getDouble("cnt_die") + 1.0);
                        ServerLevel _level;
                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel) world;
                            _level.sendParticles(ParticleTypes.ASH, x, y + (double) entity.getBbHeight() * 0.5, z, 40, 1.0, 1.0, 1.0, 0.0);
                        }

                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel) world;
                            _level.sendParticles(ParticleTypes.LARGE_SMOKE, x, y + (double) entity.getBbHeight() * 0.5, z, 10, 1.0, 1.0, 1.0, 0.0);
                        }

                        if (entity.getPersistentData().getDouble("cnt_die") > (double) (entity.getPersistentData().getDouble("despawn_flag") == 1.0 ? 60 : 5)) {
                            DieRikaProcedure.execute(world, entity);
                            if (!entity.level().isClientSide()) {
                                entity.discard();
                            }
                        }
                    } else {
                        attack = entity.getPersistentData().getBoolean("flag_attack");
                        LivingEntity var10000;
                        if (entity instanceof Mob _mobEnt) {
                            var10000 = _mobEnt.getTarget();
                        } else {
                            var10000 = null;
                        }

                        if ((!(var10000 instanceof LivingEntity) || !(entity.getPersistentData().getDouble("cnt_target") > 6.0)) && !attack) {
                            entity.getPersistentData().putDouble("cnt_x", 0.0);
                        } else {
                            entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                            if (entity.getPersistentData().getDouble("cnt_x") > 10.0 || attack) {
                                label165:
                                {
                                    label159:
                                    {
                                        entity.getPersistentData().putBoolean("flag_attack", false);
                                        ResetCounterProcedure.execute(entity);
                                        if (!attack) {
                                            if (!(Math.random() < 0.2)) {
                                                break label159;
                                            }

                                            if (entity instanceof LivingEntity) {
                                                _entity = (LivingEntity) entity;
                                                if (_entity.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                                    break label159;
                                                }
                                            }
                                        }

                                        entity.getPersistentData().putDouble("cnt_x", 0.0);
                                        rnd = (double) Math.abs(Math.round(Math.random() * 50.0) + (long) (entity.getPersistentData().getDouble("friend_num_worker") == 0.0 ? 20 : 100));
                                        if (entity instanceof LivingEntity _entity3) {
                                            if (!_entity3.level().isClientSide()) {
                                                _entity3.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int) Math.round(rnd) / 3, 0, false, false));
                                            }
                                        }

                                        if (entity.getPersistentData().getDouble("friend_num_worker") == 0.0) {
                                            entity.getPersistentData().putDouble("skill_num", entity.getPersistentData().getDouble("skill_num") + 1.0);
                                        }

                                        if (entity.getPersistentData().getDouble("skill_num") < 8.0) {
                                            entity.getPersistentData().putDouble("skill", 11.0);
                                        } else {
                                            entity.getPersistentData().putDouble("skill", 12.0);
                                            entity.getPersistentData().putDouble("skill_num", 0.0);
                                        }
                                        break label165;
                                    }

                                    entity.getPersistentData().putDouble("cnt_x", 0.0);
                                    CalculateAttackProcedure.execute(world, x, y, z, entity);
                                }
                            }
                        }

                        if (entity.getPersistentData().getDouble("friend_num") != 0.0 && entity.level().dimension() != ResourceKey.create(Registries.DIMENSION, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension"))) {
                            if (LogicOwnerExistProcedure.execute(world, entity)) {
                                entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
                                    public Entity apply(LevelAccessor levelAccessor, String uuid) {
                                        if (levelAccessor instanceof ServerLevel serverLevel) {
                                            try {
                                                return serverLevel.getEntity(UUID.fromString(uuid));
                                            } catch (Exception var5) {
                                            }
                                        }

                                        return null;
                                    }
                                }).apply(world, entity.getPersistentData().getString("OWNER_UUID"));
                                if (entity.getPersistentData().getDouble("friend_num") == entity_a.getPersistentData().getDouble("friend_num")) {
                                    if (entity_a.isAlive()) {
                                        dis = Math.sqrt(Math.pow(entity_a.getX() - entity.getX(), 2.0) + Math.pow(entity_a.getY() - entity.getY(), 2.0) + Math.pow(entity_a.getZ() - entity.getZ(), 2.0));
                                        if (dis > 24.0) {
                                            entity.getPersistentData().putBoolean("canFly", true);
                                            GetPowerForwardProcedure.execute(entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-6.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity_a)).getBlockPos().getX(), entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-6.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity_a)).getBlockPos().getY(), entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-6.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity_a)).getBlockPos().getZ(), entity);
                                            entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 0.5, entity.getPersistentData().getDouble("y_power") * 0.5, entity.getPersistentData().getDouble("z_power") * 0.5));
                                            if (dis > 36.0) {
                                                Entity _ent = entity;
                                                _ent.teleportTo(entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-6.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity_a)).getBlockPos().getX(), entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-6.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity_a)).getBlockPos().getY(), entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-6.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity_a)).getBlockPos().getZ());
                                                if (_ent instanceof ServerPlayer _serverPlayer) {
                                                    _serverPlayer.connection.teleport(entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-6.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity_a)).getBlockPos().getX(), entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-6.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity_a)).getBlockPos().getY(), entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(-6.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity_a)).getBlockPos().getZ(), _ent.getYRot(), _ent.getXRot());
                                                }

                                                entity.setDeltaMovement(new Vec3(entity_a.getDeltaMovement().x(), entity_a.getDeltaMovement().y(), entity_a.getDeltaMovement().z()));
                                                _ent = entity;
                                                _ent.setYRot(entity_a.getYRot());
                                                _ent.setXRot(entity_a.getXRot());
                                                _ent.setYBodyRot(_ent.getYRot());
                                                _ent.setYHeadRot(_ent.getYRot());
                                                _ent.yRotO = _ent.getYRot();
                                                _ent.xRotO = _ent.getXRot();
                                                if (_ent instanceof LivingEntity) {
                                                    _entity = (LivingEntity) _ent;
                                                    _entity.yBodyRotO = _entity.getYRot();
                                                    _entity.yHeadRotO = _entity.getYRot();
                                                }
                                            }
                                        }
                                    } else {
                                        entity.getPersistentData().putDouble("friend_num", 0.0);
                                        entity.getPersistentData().putDouble("friend_num_worker", 0.0);
                                        entity.getPersistentData().putString("OWNER_UUID", "");
                                    }
                                }
                            } else {
                                entity.getPersistentData().putDouble("friend_num", 0.0);
                                entity.getPersistentData().putDouble("friend_num_worker", 0.0);
                                entity.getPersistentData().putString("OWNER_UUID", "");
                            }
                        }
                    }
                } else {
                    if (entity.getPersistentData().getDouble("skill") == 11.0) {
                        AIRika1Procedure.execute(world, x, y, z, entity);
                    } else if (entity.getPersistentData().getDouble("skill") == 12.0) {
                        AIRika3Procedure.execute(world, x, y, z, entity);
                    }

                    if (entity.getPersistentData().getDouble("skill") == 0.0) {
                        CursedTechniquePotionExpiresProcedure.execute(world, x, y, z, entity);
                    }
                }
            }

        }
    }
}