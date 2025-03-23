package com.jujutsu.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.procedures.JackpotEffectStartedappliedProcedure;
import net.mcreator.jujutsucraft.procedures.JackpotOnEffectActiveTickProcedure;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = JackpotOnEffectActiveTickProcedure.class, priority = -10000)
public abstract class JackpotEffectActiveTickMixin {

    @Inject(method = "execute", at = @At("HEAD"), remap = false, cancellable = true)
    private static void execute(LevelAccessor world, Entity entity, CallbackInfo ci) {
        ci.cancel();
        if (entity != null) {
            boolean old_press_m = false;
            double level = 0.0;
            double tick = 0.0;
            double rnd = 0.0;
            double pitch = 0.0;
            if (entity.isAlive()) {
                double var10000;
                LivingEntity _entity;
                label53: {
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        if (_entity.hasEffect((MobEffect) JujutsucraftModMobEffects.JACKPOT.get())) {
                            var10000 = (double)_entity.getEffect((MobEffect)JujutsucraftModMobEffects.JACKPOT.get()).getAmplifier();
                            break label53;
                        }
                    }

                    var10000 = 0.0;
                }

                label48: {
                    level = var10000;
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        if (_entity.hasEffect((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                            var10000 = (double)_entity.getEffect((MobEffect)JujutsucraftModMobEffects.JACKPOT.get()).getDuration();
                            break label48;
                        }
                    }

                    var10000 = 0.0;
                }

                int var13;
                label43: {
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        if (_entity.hasEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                            var13 = _entity.getEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get()).getAmplifier();
                            break label43;
                        }
                    }

                    var13 = 0;
                }

                if ((double)var13 < 4.0 + level) {
                    JackpotEffectStartedappliedProcedure.execute(world, entity);
                }

                entity.getPersistentData().putBoolean("PRESS_M", false);
                if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity)entity;
                    if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get(), 2, (int)(9), false, false));
                    }
                }

                ServerLevel _level;
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel)world;
                    _level.sendParticles((SimpleParticleType) JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_GREEN.get(), entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.25, entity.getZ(), 2, (double)entity.getBbWidth() * 0.25, (double)entity.getBbHeight() * 0.25, (double)entity.getBbWidth() * 0.25, 0.5);
                }

                if (Math.random() < 0.2 && world instanceof ServerLevel) {
                    _level = (ServerLevel)world;
                    _level.sendParticles(ParticleTypes.NOTE, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.75, entity.getZ(), 1, (double)(entity.getBbWidth() * 2.0F), (double)(entity.getBbHeight() * 1.0F), (double)(entity.getBbWidth() * 2.0F), 0.5);
                }
            }

        }
    }
}
