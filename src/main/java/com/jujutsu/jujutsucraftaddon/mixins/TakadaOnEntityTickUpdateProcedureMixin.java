package com.jujutsu.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.JudgemanEntity;
import net.mcreator.jujutsucraft.entity.TakadaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.LogicOwnerExistProcedure;
import net.mcreator.jujutsucraft.procedures.TakadaOnEntityTickUpdateProcedure;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;

@Mixin(value = TakadaOnEntityTickUpdateProcedure.class, priority = -10000)
public abstract class TakadaOnEntityTickUpdateProcedureMixin {

    /**
     * @author Satushi
     * @reason Adds a Variable for let Takada/Higuruma shikigamis stay alive without normal ticking conditions
     */

    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            Entity entity_a = null;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double num1 = 0.0;
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
                ServerLevel _level;
                if (entity_a instanceof LivingEntity _livEnt2) {
                    if (_livEnt2.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        if (entity instanceof JudgemanEntity && entity_a.getPersistentData().getDouble("skill") == 2719.0 && entity_a.getPersistentData().getDouble("cnt3") >= 20.0 && entity_a.getPersistentData().getDouble("cnt1") > 0.0) {
                            if (entity instanceof JudgemanEntity) {
                                ((JudgemanEntity) entity).setAnimation("empty");
                            }

                            if (entity instanceof JudgemanEntity) {
                                ((JudgemanEntity) entity).setAnimation("judgement");
                            }

                            num1 = 0.0;
                            x_pos = entity.getX();
                            y_pos = entity.getY();
                            z_pos = entity.getZ();
                            if (world instanceof ServerLevel) {
                                _level = (ServerLevel) world;
                                _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 15, 2.0, 0.5, 2.0, 0.5);
                                return;
                            }
                        }

                        return;
                    }
                }

                if (entity instanceof TakadaEntity) {
                    if (world instanceof ServerLevel) {
                        _level = (ServerLevel) world;
                        _level.sendParticles(ParticleTypes.END_ROD, x, y + (double) entity.getBbHeight() * 0.5, z, 40, 0.2, 0.5, 0.2, 0.0);
                    }
                } else if (entity instanceof JudgemanEntity && world instanceof ServerLevel) {
                    _level = (ServerLevel) world;
                    _level.sendParticles(ParticleTypes.SQUID_INK, x, y + (double) entity.getBbHeight() * 0.5, z, 40, 0.2, 0.5, 0.2, 0.0);
                }

                if (!entity.level().isClientSide()) {
                    if (!entity.getPersistentData().getBoolean("ShikigamiLevel")) {
                        entity.discard();
                    } else {
                        if (entity instanceof JudgemanEntity) {
                            ((JudgemanEntity) entity).setAnimation("judgement");
                            num1 = 0.0;
                            x_pos = entity.getX();
                            y_pos = entity.getY();
                            z_pos = entity.getZ();
                            if (world instanceof ServerLevel) {
                                _level = (ServerLevel) world;
                                _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 15, 2.0, 0.5, 2.0, 0.5);
                            }
                        }
                    }
                }
            } else if (!entity.level().isClientSide()) {
                if (!entity.getPersistentData().getBoolean("ShikigamiLevel")) {
                    entity.discard();
                } else {
                    if (entity instanceof JudgemanEntity) {
                        ((JudgemanEntity) entity).setAnimation("judgement");
                        num1 = 0.0;
                        x_pos = entity.getX();
                        y_pos = entity.getY();
                        z_pos = entity.getZ();
                        if (world instanceof ServerLevel _level) {
                            _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 15, 2.0, 0.5, 2.0, 0.5);
                            return;
                        }

                        {
                            final Vec3 _center = new Vec3(x, y, z);
                            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                            for (Entity entityiterator : _entfound) {
                                if (!(entity.getPersistentData().getString("OWNER_UUID")).equals(entityiterator.getStringUUID())) {
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.UNSTABLE.get(), 100, 1, false, false));
                                }
                            }
                        }

                    }
                }
            }

        }
    }
}
