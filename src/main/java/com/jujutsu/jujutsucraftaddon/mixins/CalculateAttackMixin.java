package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
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

@Mixin(value = CalculateAttackProcedure.class, priority = -10000)
public abstract class CalculateAttackMixin {
    @Inject(method = "execute", at = @At("HEAD"), remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();
        if (entity != null && entity instanceof LivingEntity _liv && !_liv.hasEffect(JujutsucraftaddonModMobEffects.QUAKE.get())) {
            double rnd;
            double distance1;
            double ticks;
            double level;
            boolean success;
            int var10000;
            boolean danger;
            boolean logic_attack;
            boolean can_run_attack;
            boolean can_bullet_attack;
            boolean can_jump_attack;
            boolean can_overhead_attack;
            boolean cooltime_combat;
            boolean can_speed_attack;
            boolean cooltime_default;
            LivingEntity _entity;
            label585:
            {
                rnd = 0.0;
                distance1 = 0.0;
                ticks = 0.0;
                level = 0.0;
                success = false;
                danger = false;
                logic_attack = false;
                can_run_attack = false;
                can_bullet_attack = false;
                can_jump_attack = false;
                can_overhead_attack = false;
                boolean can_swim_attack = false;
                cooltime_combat = false;
                can_speed_attack = false;
                cooltime_default = false;
                if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity) entity;
                    if (_entity.hasEffect((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                        var10000 = _entity.getEffect((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getAmplifier();
                        break label585;
                    }
                }

                var10000 = 0;
            }

            boolean var42;
            label579:
            {
                cooltime_default = var10000 > 0;
                if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity) entity;
                    if (_entity.hasEffect((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                        var42 = true;
                        break label579;
                    }
                }

                var42 = false;
            }

            LivingEntity _livEnt36;
            LivingEntity _livEnt35;
            LivingEntity var44;
            label624:
            {
                cooltime_combat = var42;
                if (!cooltime_default || !cooltime_combat) {
                    label621:
                    {
                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity) entity;
                            if (_entity.hasEffect((MobEffect) JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                                break label621;
                            }
                        }

                        if (entity.getPersistentData().getDouble("skill") == 0.0) {
                            success = false;
                            distance1 = GetDistanceNearestEnemyProcedure.execute(world, x, y, z, entity);
                            Vec3 _center = new Vec3((double) entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), (double) entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(), (double) entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ());
                            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(8.0), (e) -> {
                                return true;
                            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                                return _entcnd.distanceToSqr(_center);
                            })).toList();
                            Iterator var30 = _entfound.iterator();

                            double var43;
                            label561:
                            {
                                Entity entityiterator;
                                do {
                                    do {
                                        do {
                                            if (!var30.hasNext()) {
                                                break label561;
                                            }

                                            entityiterator = (Entity) var30.next();
                                        } while (entity == entityiterator);

                                        logic_attack = LogicAttackProcedure.execute(world, entity, entityiterator);
                                    } while (!logic_attack);

                                    if (entityiterator.getPersistentData().getDouble("Damage") > 0.0 && entityiterator.getPersistentData().getDouble("skill") > 0.0 && entityiterator.isAlive()) {
                                        danger = true;
                                        break label561;
                                    }

                                    if (entityiterator instanceof Projectile) {
                                        Projectile _projEnt = (Projectile) entityiterator;
                                        var43 = _projEnt.getDeltaMovement().length();
                                    } else {
                                        var43 = 0.0;
                                    }
                                } while ((!(var43 > 0.0) || entity.getStringUUID().equals(entityiterator.getStringUUID())) && (!logic_attack || !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))));

                                danger = true;
                            }

                            label533:
                            {
                                if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:cant_barrage_attack"))) && !cooltime_default) {
                                    label529:
                                    {
                                        if (entity instanceof LivingEntity) {
                                            _livEnt36 = (LivingEntity) entity;
                                            if (_livEnt36.hasEffect((MobEffect) JujutsucraftModMobEffects.SPECIAL.get())) {
                                                var10000 = _livEnt36.getEffect((MobEffect) JujutsucraftModMobEffects.SPECIAL.get()).getAmplifier();
                                                break label529;
                                            }
                                        }

                                        var10000 = 0;
                                    }

                                    if (var10000 < 1) {
                                        var42 = true;
                                        break label533;
                                    }
                                }

                                var42 = false;
                            }

                            LivingEntity var10001;
                            Mob _mobEnt;
                            LivingEntity _livEnt39;
                            LivingEntity _livEnt38;
                            label522:
                            {
                                label521:
                                {
                                    can_bullet_attack = var42;
                                    if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:jumping_attackable")))) {
                                        label518:
                                        {
                                            if (entity instanceof LivingEntity) {
                                                _livEnt38 = (LivingEntity) entity;
                                                if (_livEnt38.hasEffect((MobEffect) JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                                                    var10000 = _livEnt38.getEffect((MobEffect) JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).getAmplifier();
                                                    break label518;
                                                }
                                            }

                                            var10000 = 0;
                                        }

                                        if (var10000 <= 3) {
                                            if (!(entity instanceof LivingEntity)) {
                                                break label521;
                                            }

                                            _livEnt39 = (LivingEntity) entity;
                                            if (!_livEnt39.hasEffect((MobEffect) JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get())) {
                                                break label521;
                                            }
                                        }
                                    }

                                    if (!cooltime_combat) {
                                        label625:
                                        {
                                            if (!(distance1 > 8.0) || !(distance1 < 24.0)) {
                                                var43 = entity.getY() + (double) entity.getBbHeight() + 4.0;
                                                if (entity instanceof Mob) {
                                                    _mobEnt = (Mob) entity;
                                                    var10001 = _mobEnt.getTarget();
                                                } else {
                                                    var10001 = null;
                                                }

                                                if (!(var43 < var10001.getY())) {
                                                    break label625;
                                                }

                                                if (entity instanceof Mob) {
                                                    _mobEnt = (Mob) entity;
                                                    var44 = _mobEnt.getTarget();
                                                } else {
                                                    var44 = null;
                                                }

                                                if (!var44.onGround()) {
                                                    break label625;
                                                }
                                            }

                                            if (!danger) {
                                                var42 = true;
                                                break label522;
                                            }
                                        }
                                    }
                                }

                                var42 = false;
                            }

                            label494:
                            {
                                label493:
                                {
                                    label593:
                                    {
                                        can_jump_attack = var42;
                                        if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:running_attackable")))) {
                                            label489:
                                            {
                                                if (entity instanceof LivingEntity) {
                                                    LivingEntity _livEnt = (LivingEntity) entity;
                                                    if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                                                        var10000 = _livEnt.getEffect((MobEffect) JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).getAmplifier();
                                                        break label489;
                                                    }
                                                }

                                                var10000 = 0;
                                            }

                                            if (var10000 <= 3) {
                                                label594:
                                                {
                                                    if (entity instanceof LivingEntity) {
                                                        _livEnt38 = (LivingEntity) entity;
                                                        if (_livEnt38.hasEffect((MobEffect) JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get())) {
                                                            break label594;
                                                        }
                                                    }

                                                    if (!(entity instanceof LivingEntity)) {
                                                        break label593;
                                                    }

                                                    _livEnt39 = (LivingEntity) entity;
                                                    if (!_livEnt39.hasEffect((MobEffect) JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get())) {
                                                        break label593;
                                                    }
                                                }
                                            }
                                        }

                                        if (!cooltime_combat) {
                                            label478:
                                            {
                                                if (entity instanceof LivingEntity) {
                                                    _livEnt35 = (LivingEntity) entity;
                                                    if (_livEnt35.hasEffect((MobEffect) JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                                        var10000 = _livEnt35.getEffect((MobEffect) JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                                                        break label478;
                                                    }
                                                }

                                                var10000 = 0;
                                            }

                                            if (var10000 < 1) {
                                                if (!(entity instanceof LivingEntity)) {
                                                    break label493;
                                                }

                                                _livEnt36 = (LivingEntity) entity;
                                                if (!_livEnt36.hasEffect(MobEffects.HUNGER)) {
                                                    break label493;
                                                }
                                            }
                                        }
                                    }

                                    var42 = false;
                                    break label494;
                                }

                                var42 = true;
                            }

                            label461:
                            {
                                label460:
                                {
                                    can_run_attack = var42;
                                    if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:overhead_attackable")))) {
                                        label457:
                                        {
                                            if (entity instanceof LivingEntity) {
                                                _livEnt39 = (LivingEntity) entity;
                                                if (_livEnt39.hasEffect((MobEffect) JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                                                    var10000 = _livEnt39.getEffect((MobEffect) JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).getAmplifier();
                                                    break label457;
                                                }
                                            }

                                            var10000 = 0;
                                        }

                                        if (var10000 <= 3) {
                                            label595:
                                            {
                                                if (entity instanceof LivingEntity) {
                                                    _livEnt35 = (LivingEntity) entity;
                                                    if (_livEnt35.hasEffect((MobEffect) JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get())) {
                                                        break label595;
                                                    }
                                                }

                                                if (!(entity instanceof LivingEntity)) {
                                                    break label460;
                                                }

                                                _livEnt36 = (LivingEntity) entity;
                                                if (!_livEnt36.hasEffect((MobEffect) JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get())) {
                                                    break label460;
                                                }
                                            }
                                        }
                                    }

                                    if (!cooltime_combat && distance1 < 8.0) {
                                        var42 = true;
                                        break label461;
                                    }
                                }

                                var42 = false;
                            }

                            label440:
                            {
                                label439:
                                {
                                    label438:
                                    {
                                        can_overhead_attack = var42;
                                        if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:speed_attackable")))) {
                                            label596:
                                            {
                                                if (entity instanceof LivingEntity) {
                                                    _livEnt38 = (LivingEntity) entity;
                                                    if (_livEnt38.hasEffect((MobEffect) JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get())) {
                                                        break label596;
                                                    }
                                                }

                                                if (!(entity instanceof LivingEntity)) {
                                                    break label438;
                                                }

                                                _livEnt39 = (LivingEntity) entity;
                                                if (!_livEnt39.hasEffect((MobEffect) JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get())) {
                                                    break label438;
                                                }
                                            }
                                        }

                                        if (!cooltime_combat) {
                                            if (distance1 > 8.0 && distance1 < 24.0) {
                                                break label439;
                                            }

                                            var43 = entity.getY() + (double) entity.getBbHeight() + 4.0;
                                            if (entity instanceof Mob) {
                                                _mobEnt = (Mob) entity;
                                                var10001 = _mobEnt.getTarget();
                                            } else {
                                                var10001 = null;
                                            }

                                            if (var43 < var10001.getY()) {
                                                if (entity instanceof Mob) {
                                                    _mobEnt = (Mob) entity;
                                                    var44 = _mobEnt.getTarget();
                                                } else {
                                                    var44 = null;
                                                }

                                                if (var44.onGround()) {
                                                    break label439;
                                                }
                                            }
                                        }
                                    }

                                    var42 = false;
                                    break label440;
                                }

                                var42 = true;
                            }

                            can_speed_attack = var42;
                            if (!cooltime_default || can_jump_attack || can_run_attack || can_overhead_attack || can_speed_attack) {
                                for (int index0 = 0; index0 < 255; ++index0) {
                                    if (cooltime_combat) {
                                        rnd = (double) Mth.nextInt(RandomSource.create(), 1, 3);
                                    } else if (cooltime_default) {
                                        rnd = (double) Mth.nextInt(RandomSource.create(), 4, 7);
                                    } else {
                                        rnd = (double) Mth.nextInt(RandomSource.create(), 1, 7);
                                    }

                                    if ((!(rnd >= 1.0) || !(rnd <= 3.0) || !cooltime_default && (rnd != 1.0 || !(Math.random() < (can_bullet_attack ? 0.5 : 0.75))) && rnd != 2.0 && (rnd != 3.0 || can_bullet_attack)) && (!(rnd >= 4.0) || !(rnd <= 7.0) || !cooltime_combat && (rnd != 4.0 || can_jump_attack && !(Math.random() < 0.5)) && (rnd != 5.0 || can_run_attack) && (rnd != 6.0 || can_overhead_attack && !(Math.random() < 0.75)) && (rnd != 7.0 || can_speed_attack && !(Math.random() < 0.75)))) {
                                        if (distance1 > 24.0) {
                                            if (rnd == 4.0 || rnd == 5.0 || rnd == 6.0) {
                                                success = true;
                                                break label624;
                                            }
                                        } else if (distance1 > 16.0) {
                                            if (rnd == 4.0 || rnd == 5.0 || rnd == 6.0 || rnd == 7.0) {
                                                success = true;
                                                break label624;
                                            }
                                        } else if (distance1 > 8.0) {
                                            if (rnd == 4.0 || rnd == 5.0 || rnd == 6.0 || rnd == 7.0) {
                                                success = true;
                                                break label624;
                                            }
                                        } else if (distance1 > 4.0) {
                                            if (rnd == 1.0 || rnd == 2.0 || rnd == 3.0 || rnd == 5.0 || rnd == 6.0) {
                                                success = true;
                                                break label624;
                                            }
                                        } else if (rnd == 1.0 || rnd == 2.0 || rnd == 3.0 || rnd == 5.0 || rnd == 6.0) {
                                            success = true;
                                            break label624;
                                        }

                                        if (danger && (rnd == 3.0 || !(Math.random() < 0.5)) && rnd != 2.0 && rnd != 4.0) {
                                            success = true;
                                            break label624;
                                        }
                                    }
                                }
                            }
                            break label624;
                        }
                    }
                }

                success = false;
            }

            if (success) {
                entity.getPersistentData().putDouble("cnt_x", Math.max(entity.getPersistentData().getDouble("cnt_x"), 0.0));
                if (rnd == 1.0) {
                    ticks = 5.0;
                    level = 1.0;
                } else if (rnd == 2.0) {
                    ticks = 15.0;
                    level = 1.0;
                } else if (rnd == 3.0) {
                    ticks = 20.0;
                    level = 1.0;
                } else if (rnd == 4.0) {
                    ticks = 100.0;
                    level = 0.0;
                } else if (rnd == 5.0) {
                    ticks = 200.0;
                    level = 0.0;
                } else if (rnd == 6.0) {
                    ticks = 50.0;
                    level = 0.0;
                } else if (rnd == 7.0) {
                    ticks = 50.0;
                    level = 0.0;
                }

                ResetCounterProcedure.execute(entity);
                entity.getPersistentData().putDouble("skill", 4199.0 + rnd);
                if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity) entity;
                    if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                    }
                }

                if (level > 0.0) {
                    ItemStack var45;
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity) entity;
                        var45 = _entity.getItemBySlot(EquipmentSlot.CHEST);
                    } else {
                        var45 = ItemStack.EMPTY;
                    }

                    if (var45.getItem() == JujutsucraftModItems.SUKUNA_BODY_CHESTPLATE.get()) {
                        ticks *= 0.5;
                    }

                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity) entity;
                        if (_entity.getAttributes().hasAttribute(Attributes.ATTACK_SPEED)) {
                            double var10003;
                            label295:
                            {
                                if (entity instanceof LivingEntity) {
                                    _livEnt36 = (LivingEntity) entity;
                                    if (_livEnt36.getAttributes().hasAttribute(Attributes.ATTACK_SPEED)) {
                                        var10003 = _livEnt36.getAttribute(Attributes.ATTACK_SPEED).getValue();
                                        break label295;
                                    }
                                }

                                var10003 = 0.0;
                            }

                            ticks += 20.0 * Math.max(1.7 - var10003, 0.0);
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity) entity;
                        if (!_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int) Math.round(ticks / 2), 1, false, false));
                        }
                    }
                } else if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity) entity;
                    if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int) Math.round(ticks / 2), 0, false, false));
                    }
                }

                if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:can_use_domain_amplification")))) {
                    if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob) entity;
                        var44 = _mobEnt.getTarget();
                    } else {
                        var44 = null;
                    }

                    _livEnt35 = var44;
                    if (_livEnt35 instanceof LivingEntity) {
                        _livEnt36 = (LivingEntity) _livEnt35;
                        if (_livEnt36.hasEffect((MobEffect) JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                            if (entity instanceof LivingEntity) {
                                _livEnt35 = (LivingEntity) entity;
                                _livEnt35.removeEffect((MobEffect) JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get());
                            }

                            KeyDomainAmplificationOnKeyPressedProcedure.execute(entity);
                        }
                    }
                }
            } else {
                entity.getPersistentData().putDouble("cnt_x", Math.max(entity.getPersistentData().getDouble("cnt_x"), 0.0));
            }

        }
    }
}
