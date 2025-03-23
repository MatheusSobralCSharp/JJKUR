package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.entity.PartialRikaEntity;
import com.jujutsu.jujutsucraftaddon.procedures.DeerBuffedProcedure;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.AIActiveProcedure;
import net.mcreator.jujutsucraft.procedures.AIRoundDeerProcedure;
import net.mcreator.jujutsucraft.procedures.FollowEntityProcedure;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Iterator;

@Mixin(value = AIRoundDeerProcedure.class, priority = -10000)
public abstract class RoundDeerAIMixin {

    @Inject(method = "execute", at = @At("HEAD"), remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            boolean StrongEnemy = false;
            double rnd = 0.0;
            double NUM1 = 0.0;
            double NUM2 = 0.0;
            double NUM3 = 0.0;
            double level = 0.0;
            if (entity.isAlive()) {
                LivingEntity _livEnt21;
                LivingEntity _entity;
                label87:
                {
                    AIActiveProcedure.execute(world, x, y, z, entity);
                    if (!(entity instanceof PartialRikaEntity)) {
                        FollowEntityProcedure.execute(world, entity);
                    }

                    NUM1 = (double) (4L + Math.round(entity.getPersistentData().getDouble("Strength") * 0.5));
                    NUM2 = (double) Math.round(Math.floor(Math.min((NUM1 + ((LivingEntity) entity).getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() * 3.0) / 4.0, 3.0)));
                    NUM3 = -60.0;
                    if (entity instanceof LivingEntity) {
                        _livEnt21 = (LivingEntity) entity;
                        if (_livEnt21.hasEffect(MobEffects.DAMAGE_BOOST)) {
                            break label87;
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity) entity;
                        if (!_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, Integer.MAX_VALUE, (int) NUM1, false, false));
                        }
                    }
                }

                int var10000;
                label82:
                {
                    if (entity instanceof LivingEntity) {
                        _livEnt21 = (LivingEntity) entity;
                        if (_livEnt21.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                            var10000 = _livEnt21.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                            break label82;
                        }
                    }

                    var10000 = 0;
                }

                if ((double) var10000 < NUM2 && entity instanceof LivingEntity) {
                    _entity = (LivingEntity) entity;
                    if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, Integer.MAX_VALUE, (int) NUM2, false, false));
                    }
                }

                LivingEntity var24;
                if (entity instanceof Mob _mobEnt) {
                    var24 = _mobEnt.getTarget();
                } else {
                    var24 = null;
                }

                if (var24 instanceof LivingEntity) {
                    entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                    if (entity instanceof Mob _mobEnt) {
                        var24 = _mobEnt.getTarget();
                    } else {
                        var24 = null;
                    }

                    if (!var24.getPersistentData().getBoolean("CursedSpirit")) {
                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity) entity;
                            if (!_entity.level().isClientSide()) {
                                _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 9, false, false));
                            }
                        }
                    } else if (entity.getPersistentData().getDouble("friend_num") != 0.0) {
                        Iterator var21 = (new ArrayList(world.players())).iterator();

                        while (var21.hasNext()) {
                            Entity entityiterator = (Entity) var21.next();
                            if (entity.getPersistentData().getDouble("friend_num") == entityiterator.getPersistentData().getDouble("friend_num")) {
                                if (entityiterator.isShiftKeyDown() && entity instanceof LivingEntity) {
                                    _entity = (LivingEntity) entity;
                                    if (!_entity.level().isClientSide()) {
                                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 9, false, false));
                                    }
                                }
                                break;
                            }
                        }
                    }
                } else {
                    entity.getPersistentData().putDouble("cnt_x", 0.0);
                }

                if (entity instanceof LivingEntity) {
                    _livEnt21 = (LivingEntity) entity;
                    if (_livEnt21.hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                        entity.getPersistentData().putDouble("BaseCursePower", Math.max(entity.getPersistentData().getDouble("BaseCursePower") - 1.0, 0.0));
                    }
                }

                DeerBuffedProcedure.execute(world, x, y, z, entity);
            }

        }
    }
}
