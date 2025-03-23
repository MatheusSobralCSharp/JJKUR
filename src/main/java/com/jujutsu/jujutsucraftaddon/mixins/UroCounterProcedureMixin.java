package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Mixin(value = UroCounterProcedure.class, priority = -10000)
public class UroCounterProcedureMixin {
    @Inject(
            method = "execute",
            at = @At("HEAD"),
            cancellable = true,
            remap = false
    )
    private static void execute(LevelAccessor world, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            boolean logic_a = false;
            boolean logic_b = false;
            boolean SUCCESS = false;
            double num1 = 0.0;
            double num2 = 0.0;
            double speed = 0.0;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double num3 = 0.0;
            double x_power = 0.0;
            double y_power = 0.0;
            double z_power = 0.0;
            double dis = 0.0;
            double yaw = 0.0;
            double pitch = 0.0;
            if (entity instanceof LivingEntity) {
                LivingEntity _livEnt0 = (LivingEntity)entity;
                if (_livEnt0.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                    return;
                }
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
                Mob _mobEnt = (Mob)entity;
                var10000 = _mobEnt.getTarget();
            } else {
                var10000 = null;
            }

            double var54;
            if (var10000 instanceof LivingEntity) {
                Mob _mobEnt;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                Level var53 = var10000.level();
                ClipContext var10001;
                LivingEntity var10003;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10003 = _mobEnt.getTarget();
                } else {
                    var10003 = null;
                }

                Vec3 var60 = var10003.getEyePosition(1.0F);
                LivingEntity var10004;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10004 = _mobEnt.getTarget();
                } else {
                    var10004 = null;
                }

                Vec3 var63 = var10004.getEyePosition(1.0F);
                LivingEntity var10005;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10005 = _mobEnt.getTarget();
                } else {
                    var10005 = null;
                }

                var63 = var63.add(var10005.getViewVector(1.0F).scale(0.0));
                ClipContext.Block var64 = ClipContext.Block.OUTLINE;
                ClipContext.Fluid var10006 = ClipContext.Fluid.NONE;
                LivingEntity var10007;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10007 = _mobEnt.getTarget();
                } else {
                    var10007 = null;
                }

                var10001 = new ClipContext(var60, var63, var64, var10006, var10007);
                var54 = (double)var53.clip(var10001).getBlockPos().getX();
                LivingEntity var52;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var52 = _mobEnt.getTarget();
                } else {
                    var52 = null;
                }

                Level var55 = var52.level();
                ClipContext var10002;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10004 = _mobEnt.getTarget();
                } else {
                    var10004 = null;
                }

                var63 = var10004.getEyePosition(1.0F);
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10005 = _mobEnt.getTarget();
                } else {
                    var10005 = null;
                }

                Vec3 var66 = var10005.getEyePosition(1.0F);
                LivingEntity var65;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var65 = _mobEnt.getTarget();
                } else {
                    var65 = null;
                }

                var66 = var66.add(var65.getViewVector(1.0F).scale(0.0));
                ClipContext.Block var67 = ClipContext.Block.OUTLINE;
                ClipContext.Fluid var68 = ClipContext.Fluid.NONE;
                LivingEntity var10008;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10008 = _mobEnt.getTarget();
                } else {
                    var10008 = null;
                }

                var10002 = new ClipContext(var63, var66, var67, var68, var10008);
                double var57 = (double)var55.clip(var10002).getBlockPos().getY();
                LivingEntity var56;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var56 = _mobEnt.getTarget();
                } else {
                    var56 = null;
                }

                Level var59 = var56.level();
                ClipContext var61;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10005 = _mobEnt.getTarget();
                } else {
                    var10005 = null;
                }

                var66 = var10005.getEyePosition(1.0F);
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var65 = _mobEnt.getTarget();
                } else {
                    var65 = null;
                }

                Vec3 var69 = var65.getEyePosition(1.0F);
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10007 = _mobEnt.getTarget();
                } else {
                    var10007 = null;
                }

                var69 = var69.add(var10007.getViewVector(1.0F).scale(0.0));
                ClipContext.Block var71 = ClipContext.Block.OUTLINE;
                ClipContext.Fluid var70 = ClipContext.Fluid.NONE;
                LivingEntity var10009;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10009 = _mobEnt.getTarget();
                } else {
                    var10009 = null;
                }

                var61 = new ClipContext(var66, var69, var71, var70, var10009);
                RotateEntityProcedure.execute(var54, var57, (double)var59.clip(var61).getBlockPos().getZ(), entity);
            }

            yaw = (double)entity.getYRot();
            pitch = (double)entity.getXRot();
            dis = 6.0;

            for(int index0 = 0; index0 < 8; ++index0) {
                x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
                y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
                z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
                Vec3 _center = new Vec3(x_pos, y_pos, z_pos);
                List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(6.0), (e) -> {
                    return true;
                }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                    return _entcnd.distanceToSqr(_center);
                })).toList();
                Iterator var35 = _entfound.iterator();

                while(var35.hasNext()) {
                    Entity entityiterator = (Entity)var35.next();
                    if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                        SUCCESS = true;
                        x_pos = entityiterator.getX();
                        y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5;
                        z_pos = entityiterator.getZ();
                        break;
                    }
                }

                if (SUCCESS) {
                    break;
                }

                dis += 6.0;
            }

            logic_a = false;
            Vec3 _center = new Vec3(entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ());
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate((double)(entity.getBbWidth() + 10.0F) / 2.0), (e) -> {
                return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                return _entcnd.distanceToSqr(_center);
            })).toList();
            Iterator var42 = _entfound.iterator();

            while(true) {
                Entity entityiterator;
                do {
                    do {
                        if (!var42.hasNext()) {
                            LivingEntity _livingEntity78;
                            if (entity instanceof Player) {
                                entity.getPersistentData().putDouble("cnt_uro", entity.getPersistentData().getDouble("cnt_uro") + 1.0);
                                if (entity.getPersistentData().getDouble("cnt_uro") > 0.0) {
                                    entity.getPersistentData().putDouble("cnt_uro", -5.0);
                                } else {
                                    logic_a = false;
                                }
                            } else {
                                if (logic_a) {
                                    entity.getPersistentData().putDouble("cnt_uro", Math.max(entity.getPersistentData().getDouble("cnt_uro"), 1.0));
                                    if (entity instanceof LivingEntity) {
                                        _livingEntity78 = (LivingEntity)entity;
                                        if (!_livingEntity78.level().isClientSide()) {
                                            _livingEntity78.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 5, 0));
                                        }
                                    }

                                    if (entity instanceof LivingEntity) {
                                        _livingEntity78 = (LivingEntity)entity;
                                        if (!_livingEntity78.level().isClientSide()) {
                                            _livingEntity78.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 9));
                                        }
                                    }

                                    if (entity instanceof LivingEntity) {
                                        _livingEntity78 = (LivingEntity)entity;
                                        if (!_livingEntity78.level().isClientSide()) {
                                            _livingEntity78.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 5, 9));
                                        }
                                    }

                                    if (entity instanceof LivingEntity) {
                                        _livingEntity78 = (LivingEntity)entity;
                                        _livingEntity78.removeEffect((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get());
                                    }
                                }

                                if (entity.getPersistentData().getDouble("cnt_uro") > 0.0) {
                                    entity.getPersistentData().putDouble("cnt_uro", entity.getPersistentData().getDouble("cnt_uro") + 1.0);
                                    if (entity.getPersistentData().getDouble("cnt_uro") > 100.0) {
                                        entity.getPersistentData().putDouble("cnt_uro", 0.0);
                                    }
                                }
                            }

                            if (logic_a) {
                                if (entity instanceof LivingEntity) {
                                    _livingEntity78 = (LivingEntity) entity;
                                    if (!_livingEntity78.level().isClientSide()) {
                                        _livingEntity78.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 10, 9));
                                    }
                                }

                                if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.WUKONG_SET_CHESTPLATE.get().asItem())) {
                                    if (entity instanceof LivingEntity) {
                                        _livingEntity78 = (LivingEntity) entity;
                                        if (_livingEntity78.getAttributes().hasAttribute((Attribute) JujutsucraftModAttributes.ANIMATION_1.get())) {
                                            _livingEntity78.getAttribute((Attribute) JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-8.0);
                                        }
                                    }

                                    if (entity instanceof LivingEntity) {
                                        _livingEntity78 = (LivingEntity) entity;
                                        if (_livingEntity78.getAttributes().hasAttribute((Attribute) JujutsucraftModAttributes.ANIMATION_2.get())) {
                                            _livingEntity78.getAttribute((Attribute) JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(1.0);
                                        }
                                    }

                                    PlayAnimationProcedure.execute(world, entity);
                                }
                            }


                            if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.WUKONG_SET_CHESTPLATE.get().asItem())) {
                                entity.setYRot((float) yaw);
                                entity.setXRot((float) pitch);
                                entity.setYBodyRot(entity.getYRot());
                                entity.setYHeadRot(entity.getYRot());
                                entity.yRotO = entity.getYRot();
                                entity.xRotO = entity.getXRot();
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity) entity;
                                    _entity.yBodyRotO = _entity.getYRot();
                                    _entity.yHeadRotO = _entity.getYRot();
                                }
                            }

                            return;

                        }

                        entityiterator = (Entity)var42.next();
                        if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo_no_move")))) {
                            break;
                        }

                        if (entityiterator instanceof Projectile) {
                            Projectile _projEnt = (Projectile)entityiterator;
                            var54 = _projEnt.getDeltaMovement().length();
                        } else {
                            var54 = 0.0;
                        }
                    } while(var54 == 0.0);
                } while(!(entityiterator.getBbWidth() + entityiterator.getBbHeight() <= (entity.getBbWidth() + entity.getBbHeight()) * 4.0F));

                logic_a = true;
                entityiterator.getPersistentData().putBoolean("betrayal", true);
                if (entityiterator instanceof Projectile) {
                    Projectile _projEnt = (Projectile)entityiterator;
                    var54 = _projEnt.getDeltaMovement().length();
                } else {
                    var54 = 0.0;
                }

                if (var54 != 0.0 && entityiterator instanceof Projectile) {
                    Projectile _projEnt = (Projectile)entityiterator;
                    if (entity instanceof LivingEntity) {
                        _projEnt.setOwner((LivingEntity)entity);
                    }
                }

                LivingEntity _entity;
                LivingEntity _livEnt;
                if (entity instanceof Player) {
                    logic_b = entity.isShiftKeyDown();
                } else {
                    int var62;
                    label256: {
                        logic_b = entity.getPersistentData().getDouble("cnt_uro") < 15.0;
                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity)entity;
                            if (_entity.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                var62 = _entity.getEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get()).getDuration();
                                break label256;
                            }
                        }

                        var62 = 0;
                    }

                    int var58;
                    label251: {
                        if (entity instanceof LivingEntity) {
                            _livEnt = (LivingEntity)entity;
                            if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                var58 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get()).getDuration();
                                break label251;
                            }
                        }

                        var58 = 0;
                    }

                    if (var62 < (var58 > 10 ? 18 : 8)) {
                        logic_b = false;
                    }
                }

                speed = 3.0;
                num1 = (double)(entity.getYRot() % 360.0F);
                num2 = (double)(entityiterator.getYRot() % 360.0F);
                num3 = Math.abs(num1 - num2);
                entityiterator.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                if (logic_b || num3 > 135.0 && num3 < 315.0) {
                    RotateEntityProcedure.execute(entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.9, entity.getZ(), entityiterator);
                    entityiterator.setYRot(entityiterator.getYRot() + (float)(GetDistanceIteratorProcedure.execute(entity, entityiterator) > 3.0 ? 45 : 90));
                    entityiterator.setXRot(entityiterator.getXRot());
                    entityiterator.setYBodyRot(entityiterator.getYRot());
                    entityiterator.setYHeadRot(entityiterator.getYRot());
                    entityiterator.yRotO = entityiterator.getYRot();
                    entityiterator.xRotO = entityiterator.getXRot();
                    if (entityiterator instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entityiterator;
                        _livEnt.yBodyRotO = _livEnt.getYRot();
                        _livEnt.yHeadRotO = _livEnt.getYRot();
                    }

                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.GUARD.get(), 20, 0, false, false));
                        }
                    }
                } else {
                    RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entityiterator);
                }

                x_power = entityiterator.getLookAngle().x * speed;
                y_power = entityiterator.getLookAngle().y * speed;
                z_power = entityiterator.getLookAngle().z * speed;
                entityiterator.setDeltaMovement(new Vec3(x_power, y_power, z_power));
                entityiterator.getPersistentData().putDouble("x_power", x_power);
                entityiterator.getPersistentData().putDouble("y_power", y_power);
                entityiterator.getPersistentData().putDouble("z_power", z_power);
            }
        }
    }

}
