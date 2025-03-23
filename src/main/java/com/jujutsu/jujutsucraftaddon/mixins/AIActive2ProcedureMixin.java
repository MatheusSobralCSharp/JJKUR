package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.entity.GojoSatoruSchoolDaysEntity;
import net.mcreator.jujutsucraft.entity.UroTakakoEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.*;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Mixin(value = AIActive2Procedure.class, priority = -10000)
public abstract class AIActive2ProcedureMixin {

    @Inject(method = "execute", at = @At("HEAD"), remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null && entity instanceof LivingEntity _liv && !_liv.hasEffect(JujutsucraftaddonModMobEffects.QUAKE.get())) {
            boolean logic_guard = false;
            boolean logic_heal = false;
            boolean logic_heal_cancel = false;
            boolean test = false;
            boolean target = false;
            boolean logic_avoid = false;
            boolean using = false;
            boolean output = false;
            double x_knockback = 0.0;
            double y_knockback = 0.0;
            double z_knockback = 0.0;
            double dis = 0.0;
            double old_skill = 0.0;
            double limit = 0.0;
            double distance = 0.0;
            double y_power = 0.0;
            double z_power = 0.0;
            double fix = 0.0;
            double x_power = 0.0;
            double speed = 0.0;
            logic_guard = false;
            logic_heal = false;
            logic_heal_cancel = true;
            logic_avoid = false;
            LivingEntity var10000;
            Mob _mobEnt;
            if (entity.getPersistentData().getDouble("cnt_target") > 6.0) {
                test = entity.getPersistentData().getDouble("cnt_target") % 5.0 == 4.0;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                target = var10000 instanceof LivingEntity;
            }

            distance = 99.0;
            Entity _ent;
            LivingEntity _livEnt29;
            LivingEntity _livEnt;
            int var66;
            double var68;
            if (entity.getPersistentData().getDouble("skill") == 0.0) {
                if (target) {
                    distance = GetDistanceProcedure.execute(world, entity);
                    if (test) {
                        logic_heal_cancel = false;
                    }

                    label695: {
                        label707: {
                            if (entity instanceof LivingEntity) {
                                _livEnt29 = (LivingEntity)entity;
                                if (_livEnt29.hasEffect((MobEffect)JujutsucraftModMobEffects.DAMAGE_EFFECT.get())) {
                                    break label707;
                                }
                            }

                            if (entity instanceof Mob) {
                                _mobEnt = (Mob)entity;
                                var10000 = _mobEnt.getTarget();
                            } else {
                                var10000 = null;
                            }

                            if (var10000.getPersistentData().getDouble("skill") == 0.0) {
                                break label695;
                            }

                            if (entity instanceof Mob) {
                                _mobEnt = (Mob)entity;
                                var10000 = _mobEnt.getTarget();
                            } else {
                                var10000 = null;
                            }

                            if (!(var10000.getPersistentData().getDouble("Damage") > 0.0)) {
                                break label695;
                            }
                        }

                        logic_heal_cancel = true;
                        if (test) {
                            logic_guard = true;
                        }
                    }

                    if (test) {
                        if (!logic_guard) {
                            label709: {
                                if (entity instanceof LivingEntity) {
                                    _livEnt29 = (LivingEntity)entity;
                                    if (_livEnt29.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                                        break label709;
                                    }
                                }

                                label675: {
                                    if (entity instanceof LivingEntity) {
                                        _livEnt = (LivingEntity)entity;
                                        if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                            var66 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                                            break label675;
                                        }
                                    }

                                    var66 = 0;
                                }

                                if (var66 > 0) {
                                    logic_guard = true;
                                }
                            }
                        }

                        Vec3 _center;
                        List _entfound;
                        Iterator var51;
                        if (!logic_guard) {
                            label668: {
                                dis = 24.0;
                                if (!(entity instanceof UroTakakoEntity)) {
                                    if (!(entity instanceof LivingEntity)) {
                                        break label668;
                                    }

                                    _livEnt29 = (LivingEntity)entity;
                                    if (!_livEnt29.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                        break label668;
                                    }
                                }

                                dis = 36.0;
                            }

                            _center = new Vec3(x, y, z);
                            Vec3 final_center = _center;
                            _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(dis / 2.0), (e) -> {
                                return true;
                            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                                return _entcnd.distanceToSqr(final_center);
                            })).toList();
                            var51 = _entfound.iterator();

                            label661:
                            while(true) {
                                do {
                                    do {
                                        if (!var51.hasNext()) {
                                            break label661;
                                        }

                                        _ent = (Entity)var51.next();
                                    } while(entity == _ent);

                                    if (_ent instanceof Projectile) {
                                        Projectile _projEnt = (Projectile)_ent;
                                        var68 = _projEnt.getDeltaMovement().length();
                                    } else {
                                        var68 = 0.0;
                                    }

                                    if (var68 > 0.0 && !entity.getStringUUID().equals(_ent.getStringUUID())) {
                                        logic_avoid = true;
                                        logic_guard = true;
                                        break label661;
                                    }
                                } while(_ent.getPersistentData().getDouble("skill") == 0.0 && !_ent.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))));

                                if (_ent.getPersistentData().getDouble("Damage") > 0.0 && LogicAttackProcedure.execute(world, entity, _ent)) {
                                    logic_avoid = true;
                                    logic_guard = true;
                                    break;
                                }
                            }
                        }

                        if (!logic_guard) {
                            dis = 16.0;
                            if (entity instanceof UroTakakoEntity) {
                                dis = 32.0;
                            }

                            _center = new Vec3(x, y, z);
                            Vec3 final_center1 = _center;
                            _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(dis / 2.0), (e) -> {
                                return true;
                            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                                return _entcnd.distanceToSqr(final_center1);
                            })).toList();
                            var51 = _entfound.iterator();

                            label638:
                            while(true) {
                                do {
                                    do {
                                        do {
                                            if (!var51.hasNext()) {
                                                break label638;
                                            }

                                            _ent = (Entity)var51.next();
                                        } while(entity == _ent);
                                    } while(_ent.getPersistentData().getDouble("skill") == 0.0);
                                } while(!(_ent.getPersistentData().getDouble("Damage") > 0.0) && !_ent.getPersistentData().getBoolean("PRESS_Z"));

                                if (LogicAttackProcedure.execute(world, entity, _ent)) {
                                    logic_avoid = true;
                                    logic_guard = true;
                                    break;
                                }
                            }
                        }

                        if (logic_avoid) {
                            label714: {
                                if (entity.getPersistentData().getDouble("skill") != 0.0) {
                                    logic_avoid = false;
                                }

                                if (entity instanceof LivingEntity) {
                                    _livEnt29 = (LivingEntity)entity;
                                    if (_livEnt29.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                        label611: {
                                            if (entity instanceof LivingEntity) {
                                                _livEnt = (LivingEntity)entity;
                                                if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                                    var66 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getDuration();
                                                    break label611;
                                                }
                                            }

                                            var66 = 0;
                                        }

                                        if (var66 < 6) {
                                            logic_avoid = false;
                                        }
                                        break label714;
                                    }
                                }

                                logic_avoid = false;
                            }
                        }

                        if (entity.getPersistentData().getBoolean("CursedSpirit") && entity instanceof LivingEntity) {
                            _livEnt29 = (LivingEntity)entity;
                            if (_livEnt29.hasEffect((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                                logic_avoid = true;
                            }
                        }
                    }

                    logic_heal_cancel = logic_heal_cancel || logic_guard;
                    if (!logic_avoid) {
                        if (distance < 2.0) {
                            logic_avoid = true;
                        }

                        label597: {
                            if (entity instanceof LivingEntity) {
                                _livEnt29 = (LivingEntity)entity;
                                if (_livEnt29.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                    var66 = _livEnt29.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getDuration();
                                    break label597;
                                }
                            }

                            var66 = 0;
                        }

                        if ((var66 > 10 || entity.getPersistentData().getDouble("cnt_x") < 0.0) && entity instanceof LivingEntity) {
                            _livEnt = (LivingEntity)entity;
                            if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                if (distance < 6.0) {
                                    logic_avoid = true;
                                }

                                if (distance < 24.0) {
                                    if (entity instanceof Mob) {
                                        _mobEnt = (Mob)entity;
                                        var10000 = _mobEnt.getTarget();
                                    } else {
                                        var10000 = null;
                                    }

                                    if (var10000.getPersistentData().getDouble("skill") != 0.0) {
                                        if (entity instanceof Mob) {
                                            _mobEnt = (Mob)entity;
                                            var10000 = _mobEnt.getTarget();
                                        } else {
                                            var10000 = null;
                                        }

                                        if (var10000.getPersistentData().getDouble("skill") > -900.0) {
                                            logic_avoid = true;
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:no_guard")))) {
                        logic_guard = false;
                    }

                    logic_heal_cancel = logic_heal_cancel || logic_avoid;
                } else {
                    logic_heal_cancel = false;
                }
            }

            LivingEntity _entity;
            if (logic_guard) {
                StartGuardProcedure.execute(world, entity);
                entity.setShiftKeyDown(true);
                if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:can_use_domain_amplification")))) {
                    label716: {
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var10000 = _mobEnt.getTarget();
                        } else {
                            var10000 = null;
                        }

                        if (var10000 instanceof LivingEntity) {
                            if (entity instanceof Mob) {
                                _mobEnt = (Mob)entity;
                                var10000 = _mobEnt.getTarget();
                            } else {
                                var10000 = null;
                            }

                            if (var10000.getPersistentData().getBoolean("attack")) {
                                break label716;
                            }
                        }

                        if (!entity.level().isClientSide() && entity.getServer() != null) {
                            CommandSourceStack var10001;
                            float var10002;
                            Commands var73;
                            label568: {
                                var73 = entity.getServer().getCommands();
                                var10001 = new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity);
                                if (entity instanceof LivingEntity) {
                                    _entity = (LivingEntity)entity;
                                    if (_entity.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                        var10002 = (float)_entity.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                        break label568;
                                    }
                                }

                                var10002 = 0.0F;
                            }

                            var73.performPrefixedCommand(var10001, "effect give @s jujutsucraft:domain_amplification 1 " + Math.round(var10002 + 4) + " false");
                        }
                    }
                }
            } else {
                entity.setShiftKeyDown(false);
            }

            if (logic_avoid && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:no_guard")))) {
                if (entity.onGround() && entity.getPersistentData().getDouble("cnt_target") > 6.0) {
                    entity.getPersistentData().putBoolean("PRESS_S", true);
                    WhenBackStepProcedure.execute(world, entity);
                    entity.getPersistentData().putBoolean("PRESS_S", false);
                }

                if (entity instanceof LivingEntity) {
                    _livEnt29 = (LivingEntity)entity;
                    if (_livEnt29.hasEffect((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get())) {
                        entity.getPersistentData().putDouble("mode_fly", (double)(Math.random() < 0.5 ? -2 : -3));
                    }
                }
            }

            if (test && (logic_avoid || Math.random() < 0.2) && GetDistanceProcedure.execute(world, entity) > 8.0 && entity instanceof LivingEntity) {
                _livEnt29 = (LivingEntity)entity;
                if (_livEnt29.hasEffect((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get())) {
                    KeySpaceOnKeyPressedProcedure.execute(world, x, y, z, entity);
                }
            }

            float var74;
            if (entity instanceof LivingEntity) {
                _livEnt29 = (LivingEntity)entity;
                var74 = _livEnt29.getMaxHealth();
            } else {
                var74 = -1.0F;
            }

            label750: {
                limit = (double)(var74 >= 800.0F ? 400 : 200);
                if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:can_use_reverse_cursed_technique")))) {
                    if (!(entity instanceof GojoSatoruSchoolDaysEntity)) {
                        break label750;
                    }

                    GojoSatoruSchoolDaysEntity _datEntL60 = (GojoSatoruSchoolDaysEntity)entity;
                    if (!(Boolean)_datEntL60.getEntityData().get(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                        break label750;
                    }
                }

                output = entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:can_use_reverse_cursed_technique_output")));
                float var65;
                if (!logic_heal_cancel) {
                    if (distance < 8.0) {
                        label720: {
                            logic_heal_cancel = true;
                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity)entity;
                                var74 = _livEnt.getHealth();
                            } else {
                                var74 = -1.0F;
                            }

                            var68 = (double)var74;
                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity)entity;
                                var65 = _livEnt.getMaxHealth();
                            } else {
                                var65 = -1.0F;
                            }

                            if (var68 <= (double)var65 * 0.5) {
                                logic_heal_cancel = false;
                            }

                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity)entity;
                                if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                    break label720;
                                }
                            }

                            label539: {
                                if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                        var66 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                                        break label539;
                                    }
                                }

                                var66 = 0;
                            }

                            if (var66 >= 1) {
                                logic_heal_cancel = false;
                            }
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var74 = _livEnt.getHealth();
                    } else {
                        var74 = -1.0F;
                    }

                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var65 = _livEnt.getMaxHealth();
                    } else {
                        var65 = -1.0F;
                    }

                    if (var74 >= var65) {
                        logic_heal_cancel = true;
                    }
                }

                if (entity.getPersistentData().getDouble("cnt_reverse_lim") + 1.0 >= limit) {
                    logic_heal_cancel = true;
                    output = false;
                }

                if (output) {
                    output = false;
                    if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:cant_combat"))) || entity.getPersistentData().getDouble("cnt_target") <= 6.0) {
                        dis = (double)(entity.getBbWidth() * 1.0F);
                        using = false;
                        Vec3 _center = new Vec3((double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ());
                        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(dis * 3.0 / 2.0), (e) -> {
                            return true;
                        }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                            return _entcnd.distanceToSqr(_center);
                        })).toList();
                        Iterator var58 = _entfound.iterator();

                        while(var58.hasNext()) {
                            Entity entityiterator = (Entity)var58.next();
                            if (entityiterator instanceof LivingEntity && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living"))) && entityiterator.isAlive() && entity != entityiterator) {
                                using = false;
                                if (LogicAttackProcedure.execute(world, entity, entityiterator)) {
                                    if (entityiterator.getPersistentData().getBoolean("CursedSpirit")) {
                                        using = true;
                                    }
                                } else if (!entityiterator.getPersistentData().getBoolean("CursedSpirit")) {
                                    if (entityiterator instanceof LivingEntity) {
                                        _livEnt = (LivingEntity)entityiterator;
                                        var74 = _livEnt.getHealth();
                                    } else {
                                        var74 = -1.0F;
                                    }

                                    if (entityiterator instanceof LivingEntity) {
                                       _livEnt = (LivingEntity)entityiterator;
                                        var65 = _livEnt.getMaxHealth();
                                    } else {
                                        var65 = -1.0F;
                                    }

                                    if (var74 < var65) {
                                        using = true;
                                    }
                                }

                                if (using) {
                                    output = true;
                                    logic_heal_cancel = false;
                                    break;
                                }
                            }
                        }
                    }
                }

                if (logic_heal_cancel) {
                    logic_heal = false;
                } else {
                    logic_heal = true;
                    if (output) {
                        entity.getPersistentData().putDouble("cnt_reverse_test", Math.max(entity.getPersistentData().getDouble("cnt_reverse_test"), 100.0));
                    }
                }

                entity.getPersistentData().putDouble("cnt_reverse_test", entity.getPersistentData().getDouble("cnt_reverse_test") + 1.0);
                if (logic_heal) {
                    if (entity.getPersistentData().getDouble("cnt_reverse_test") > 100.0) {
                        label744: {
                            entity.getPersistentData().putDouble("cnt_reverse_test", 0.0);
                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity)entity;
                                if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                                    break label744;
                                }
                            }

                            if (!entity.getPersistentData().getBoolean("PRESS_M")) {
                                if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    if (!_livEnt.level().isClientSide()) {
                                        _livEnt.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 18, 9, false, false));
                                    }
                                }

                                entity.getPersistentData().putDouble("cnt_reverse", 15.0);
                                KeyReverseCursedTechniqueOnKeyPressedProcedure.execute(entity);
                            }
                        }
                    }
                } else if (!target) {
                    entity.getPersistentData().putDouble("cnt_reverse_lim", Math.max(entity.getPersistentData().getDouble("cnt_reverse_lim") - 0.1, 0.0));
                }

                if (entity.getPersistentData().getBoolean("PRESS_M")) {
                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                            entity.getPersistentData().putDouble("cnt_reverse_lim", entity.getPersistentData().getDouble("cnt_reverse_lim") + 1.0);
                        }
                    }

                    entity.getPersistentData().putDouble("cnt_reverse", Math.max(entity.getPersistentData().getDouble("cnt_reverse") - 1.0, 0.0));
                    if (!logic_heal) {
                        label502: {
                            if (!(entity.getPersistentData().getDouble("cnt_reverse") <= 0.0) && !(entity.getPersistentData().getDouble("cnt_reverse_lim") >= limit)) {
                                if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    var74 = _livEnt.getHealth();
                                } else {
                                    var74 = -1.0F;
                                }

                                if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    var65 = _livEnt.getMaxHealth();
                                } else {
                                    var65 = -1.0F;
                                }

                                if (!(var74 >= var65) || output) {
                                    break label502;
                                }
                            }

                            entity.getPersistentData().putDouble("cnt_reverse", 0.0);
                            KeyReverseCursedTechniqueOnKeyReleasedProcedure.execute(entity);
                        }
                    }
                }
            }

            if (target && entity.getPersistentData().getDouble("skill") == 0.0) {
                entity.getPersistentData().putDouble("cnt_weapon", entity.getPersistentData().getDouble("cnt_weapon") + 1.0);
                if (entity.getPersistentData().getDouble("cnt_weapon") > 200.0) {
                    label725: {
                        entity.getPersistentData().putDouble("cnt_weapon", 0.0);
                        ItemStack var75;
                        if (entity instanceof LivingEntity) {
                            _livEnt29 = (LivingEntity)entity;
                            var75 = _livEnt29.getMainHandItem();
                        } else {
                            var75 = ItemStack.EMPTY;
                        }

                        label726: {
                            ItemStack var70;
                            ItemCooldowns var76;
                            if (var75.getItem() == JujutsucraftModItems.SUPREME_MARTIAL_SOLUTION.get()) {
                                if (!(entity instanceof Player)) {
                                    break label726;
                                }

                                Player _plrCldCheck115 = (Player)entity;
                                var76 = _plrCldCheck115.getCooldowns();
                                if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    var70 = _livEnt.getMainHandItem();
                                } else {
                                    var70 = ItemStack.EMPTY;
                                }

                                if (!var76.isOnCooldown(var70.getItem())) {
                                    break label726;
                                }
                            }

                            if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity)entity;
                                var75 = _entity.getOffhandItem();
                            } else {
                                var75 = ItemStack.EMPTY;
                            }

                            if (var75.getItem() != JujutsucraftModItems.SUPREME_MARTIAL_SOLUTION.get()) {
                                break label725;
                            }

                            if (entity instanceof Player) {
                                Player _plrCldCheck119 = (Player)entity;
                                var76 = _plrCldCheck119.getCooldowns();
                                if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    var70 = _livEnt.getOffhandItem();
                                } else {
                                    var70 = ItemStack.EMPTY;
                                }

                                if (var76.isOnCooldown(var70.getItem())) {
                                    break label725;
                                }
                            }
                        }

                        if (distance > 8.0) {
                            SupremeMartialSolutionRightClickedInAirProcedure.execute(world, entity);
                        } else {
                            entity.getPersistentData().putDouble("cnt_weapon", 160.0);
                        }
                    }
                }
            }

            if (test && Math.random() < 1.0 && entity.isInWaterOrBubble() && entity.isSprinting() && entity instanceof LivingEntity) {
                _livEnt29 = (LivingEntity)entity;
                if (_livEnt29.getAttributes().hasAttribute((Attribute)ForgeMod.SWIM_SPEED.get())) {
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                    } else {
                        var10000 = null;
                    }

                    double var72;
                    if (var10000 instanceof LivingEntity) {
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var10000 = _mobEnt.getTarget();
                        } else {
                            var10000 = null;
                        }

                        var68 = var10000.getX();
                        LivingEntity var71;
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var71 = _mobEnt.getTarget();
                        } else {
                            var71 = null;
                        }

                        var72 = var71.getY();
                        LivingEntity var67;
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var67 = _mobEnt.getTarget();
                        } else {
                            var67 = null;
                        }

                        var72 += (double)var67.getBbHeight() * 0.5;
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var67 = _mobEnt.getTarget();
                        } else {
                            var67 = null;
                        }

                        RotateEntityProcedure.execute(var68, var72, var67.getZ(), entity);
                        if (entity.getAirSupply() < 4) {
                            entity.setYRot(entity.getYRot());
                            entity.setXRot(-90.0F);
                            entity.setYBodyRot(entity.getYRot());
                            entity.setYHeadRot(entity.getYRot());
                            entity.yRotO = entity.getYRot();
                            entity.xRotO = entity.getXRot();
                            if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity)entity;
                                _entity.yBodyRotO = _entity.getYRot();
                                _entity.yHeadRotO = _entity.getYRot();
                            }
                        } else {
                            fix = entity.getY();

                            for(int index0 = 0; index0 < (int)Math.round(Math.ceil((double)entity.getBbHeight())); ++index0) {
                                if (!(world.getBlockState(BlockPos.containing(entity.getX(), fix, entity.getZ())).getBlock() instanceof LiquidBlock)) {
                                    _ent = entity;
                                    _ent.setYRot(entity.getYRot());
                                    _ent.setXRot((float)Math.max((double)entity.getXRot(), 22.5));
                                    _ent.setYBodyRot(_ent.getYRot());
                                    _ent.setYHeadRot(_ent.getYRot());
                                    _ent.yRotO = _ent.getYRot();
                                    _ent.xRotO = _ent.getXRot();
                                    if (_ent instanceof LivingEntity) {
                                        _entity = (LivingEntity) _ent;
                                        _entity.yBodyRotO = _entity.getYRot();
                                        _entity.yHeadRotO = _entity.getYRot();
                                    }
                                    break;
                                }

                                ++fix;
                            }
                        }
                    }

                    if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(1.0 + (double)entity.getBbWidth() * 0.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getType() != HitResult.Type.BLOCK) {
                        fix = 1.0;
                        if (entity instanceof LivingEntity) {
                            _livEnt = (LivingEntity)entity;
                            if (_livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                                int var69;
                                label449: {
                                    if (entity instanceof LivingEntity) {
                                        _livEnt = (LivingEntity)entity;
                                        if (_livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                                            var69 = _livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier();
                                            break label449;
                                        }
                                    }

                                    var69 = 0;
                                }

                                fix = Math.max(fix - 0.15 * (double)(var69 + 1), 0.0);
                            }
                        }

                        label440: {
                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity)entity;
                                if (_livEnt.getAttributes().hasAttribute((Attribute)ForgeMod.SWIM_SPEED.get())) {
                                    var72 = _livEnt.getAttribute((Attribute)ForgeMod.SWIM_SPEED.get()).getValue();
                                    break label440;
                                }
                            }

                            var72 = 0.0;
                        }

                        fix *= Math.min(Math.max(var72, 0.0), 4.0);
                        speed = 0.75 * fix;
                        x_power = entity.getDeltaMovement().x() + entity.getLookAngle().x * speed;
                        y_power = entity.getDeltaMovement().y() + entity.getLookAngle().y * speed;
                        z_power = entity.getDeltaMovement().z() + entity.getLookAngle().z * speed;
                        x_power = x_power < 0.0 ? Math.min(entity.getDeltaMovement().x(), Math.max(x_power, speed * -1.0)) : Math.max(entity.getDeltaMovement().x(), Math.min(x_power, speed * 1.0));
                        y_power = y_power < 0.0 ? Math.min(entity.getDeltaMovement().y(), Math.max(y_power, speed * -1.0)) : Math.max(entity.getDeltaMovement().y(), Math.min(y_power, speed * 1.0));
                        z_power = z_power < 0.0 ? Math.min(entity.getDeltaMovement().z(), Math.max(z_power, speed * -1.0)) : Math.max(entity.getDeltaMovement().z(), Math.min(z_power, speed * 1.0));
                        entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
                    }
                }
            }

        }
    }
}

