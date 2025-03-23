package com.jujutsu.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.LogicAttackProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.PrayerSongOnEffectActiveTickProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Mixin(value = PrayerSongOnEffectActiveTickProcedure.class, priority = -10000)
public abstract class PrayerSongOnEffectActiveTickProcedureMixin {

    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();
        if (entity != null) {
            double tick = 0.0;
            double level = 0.0;
            LivingEntity _livEnt13;
            if (entity.isAlive()) {
                double var10000;
                label111: {
                    if (entity instanceof LivingEntity) {
                        _livEnt13 = (LivingEntity)entity;
                        if (_livEnt13.hasEffect((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get())) {
                            var10000 = (double)_livEnt13.getEffect((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get()).getAmplifier();
                            break label111;
                        }
                    }

                    var10000 = 0.0;
                }

                label106: {
                    if (entity instanceof LivingEntity) {
                        _livEnt13 = (LivingEntity)entity;
                        if (_livEnt13.hasEffect((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get())) {
                            var10000 = (double)_livEnt13.getEffect((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get()).getDuration();
                            break label106;
                        }
                    }

                    var10000 = 0.0;
                }

                LivingEntity _livEnt14;
                label101: {
                    tick = var10000;
                    if (entity instanceof LivingEntity) {
                        _livEnt13 = (LivingEntity)entity;
                        if (_livEnt13.hasEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                            break label101;
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _livEnt14 = (LivingEntity)entity;
                        if (!_livEnt14.level().isClientSide()) {
                            _livEnt14.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ZONE.get(), 5, 0, false, false));
                        }
                    }
                }

                LivingEntity _livingEntity9;
                if (entity.onGround()) {
                    label122: {
                        if (entity instanceof LivingEntity) {
                            _livEnt13 = (LivingEntity)entity;
                            if (_livEnt13.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                                break label122;
                            }
                        }

                        if (entity instanceof LivingEntity) {
                            _livEnt14 = (LivingEntity)entity;
                            if (_livEnt14.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                break label122;
                            }
                        }

                        if (tick % 3.0 == 0.0 && world instanceof Level) {
                            Level _level = (Level)world;
                            if (!_level.isClientSide()) {
                                _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.fall")), SoundSource.NEUTRAL, 2.0F, 2.0F);
                            } else {
                                _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.fall")), SoundSource.NEUTRAL, 2.0F, 2.0F, false);
                            }
                        }

                        if (tick % 5.0 == 0.0) {
                            if (entity instanceof LivingEntity) {
                                _livingEntity9 = (LivingEntity)entity;
                                if (_livingEntity9.getAttributes().hasAttribute((Attribute) JujutsucraftModAttributes.ANIMATION_1.get())) {
                                    _livingEntity9.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-15.0);
                                }
                            }

                            PlayAnimationProcedure.execute(world, entity);
                        }
                    }
                }

                if (tick % 5.0 == 0.0) {
                    Vec3 _center = new Vec3(x, y, z);
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(12.0), (e) -> {
                        return true;
                    }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                        return _entcnd.distanceToSqr(_center);
                    })).toList();
                    Iterator var20 = _entfound.iterator();

                    while(var20.hasNext()) {
                        Entity entityiterator = (Entity)var20.next();
                        if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && entityiterator instanceof LivingEntity) {
                            LivingEntity _entity = (LivingEntity)entityiterator;
                            if (!_entity.level().isClientSide()) {
                                MobEffectInstance currentEffect = _entity.getEffect(MobEffects.WEAKNESS);
                                int currentAmplifier = 0;

                                // If the Weakness effect exists, get its current amplifier and increment it by 1
                                if (currentEffect != null && currentEffect.getAmplifier() < 50) {
                                    currentAmplifier = currentEffect.getAmplifier() + 1;
                                }

                                if (Math.random() < (1) / ((float) 40)) {
                                    _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1200, currentAmplifier));
                                }

                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 30, 0));
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.UNSTABLE.get(), 30, 0));

                                if (Math.random() < (1) / ((float) 200)) {
                                    _entity.removeEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                                }
                            }
                        }
                    }
                }

                label120: {
                    if (entity instanceof LivingEntity) {
                        _livEnt13 = (LivingEntity)entity;
                        if (_livEnt13.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                            break label120;
                        }
                    }

                    if (!(entity instanceof LivingEntity)) {
                        return;
                    }

                    _livEnt14 = (LivingEntity)entity;
                    if (!_livEnt14.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                        return;
                    }
                }

                if (entity instanceof LivingEntity) {
                    _livingEntity9 = (LivingEntity)entity;
                    _livingEntity9.removeEffect((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get());
                }
            } else if (entity instanceof LivingEntity) {
                _livEnt13 = (LivingEntity)entity;
                _livEnt13.removeEffect((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get());
            }

        }
    }
}
