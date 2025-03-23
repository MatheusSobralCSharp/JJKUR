package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.procedures.UnlimitedPurpleProcedure;
import net.mcreator.jujutsucraft.entity.GojoSatoruEntity;
import net.mcreator.jujutsucraft.entity.GojoSatoruSchoolDaysEntity;
import net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.*;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Comparator;

@Mixin(value = AIGojoSchoolDaysProcedure.class, priority = -10000)
public abstract class AISatoruGojoProcedureMixin {
    /**
     * @author Satushi
     * @reason Changes Black Flash Entity Particles
     */

    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();
        if (entity != null) {
            boolean adult = false;
            boolean defense = false;
            boolean domain = false;
            boolean simple = false;
            boolean purple = false;
            boolean red = false;
            boolean target_sukuna = false;
            Entity target_entity = null;
            double rnd = 0.0;
            double strlv = 0.0;
            double tick = 0.0;
            double health = 0.0;
            double z_pos = 0.0;
            double num1 = 0.0;
            double distance = 0.0;
            if (entity.isAlive() && entity instanceof LivingEntity _liv && !_liv.hasEffect(JujutsucraftaddonModMobEffects.BINDING_VOW_COOLDOWN.get())) {
                BlockPos belowPos = entity.blockPosition().below();
                FluidState fluidStateBelow = entity.level().getFluidState(belowPos);
                boolean isJustAboveWater = ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ()))).getBlock() instanceof LiquidBlock);
                if (isJustAboveWater && !entity.isInWater()) {
                    if (entity.getDeltaMovement().y() <= 0) {
                        entity.setDeltaMovement(entity.getDeltaMovement().multiply(1.0, 0.0, 1.0));
                        entity.setOnGround(true);
                        entity.setPos(entity.getX(), belowPos.getY() + 1.0, entity.getZ());

                    }
                }
                float var10001;
                LivingEntity _entity;
                LivingEntity _livEnt;
                if (entity instanceof GojoSatoruSchoolDaysEntity && entity instanceof GojoSatoruSchoolDaysEntity) {
                    GojoSatoruSchoolDaysEntity _datEntL2 = (GojoSatoruSchoolDaysEntity)entity;
                    if ((Boolean)_datEntL2.getEntityData().get(GojoSatoruSchoolDaysEntity.DATA_dying)) {
                        entity.getPersistentData().putDouble("cnt_target", 0.0);
                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity)entity;
                            if (!_entity.level().isClientSide()) {
                                _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 99, false, false));
                            }
                        }

                        if (!((GojoSatoruSchoolDaysEntity)entity).animationprocedure.equals("death") && entity instanceof GojoSatoruSchoolDaysEntity) {
                            ((GojoSatoruSchoolDaysEntity)entity).setAnimation("death");
                        }

                        entity.getPersistentData().putDouble("cnt_dying", entity.getPersistentData().getDouble("cnt_dying") + 1.0);
                        if (entity.getPersistentData().getDouble("cnt_dying") > 200.0) {
                            GojoSatoruSchoolDaysEntity _datEntSetL;
                            if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                _datEntSetL = (GojoSatoruSchoolDaysEntity)entity;
                                _datEntSetL.getEntityData().set(GojoSatoruSchoolDaysEntity.DATA_awaking, true);
                            }

                            if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                _datEntSetL = (GojoSatoruSchoolDaysEntity)entity;
                                _datEntSetL.getEntityData().set(GojoSatoruSchoolDaysEntity.DATA_dying, false);
                            }

                            if (!entity.level().isClientSide() && entity.getServer() != null) {
                                entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "data merge entity @s {Invulnerable:0b}");
                            }

                            if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity)entity;
                                _entity.removeEffect(MobEffects.DAMAGE_BOOST);
                            }

                            if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity)entity;
                                _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get());
                            }

                            if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity)entity;
                                _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get());
                            }

                            if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity)entity;
                                if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    var10001 = _livEnt.getMaxHealth();
                                } else {
                                    var10001 = -1.0F;
                                }

                                _entity.setHealth(var10001);
                            }

                            AnimationResetProcedure.execute(entity);
                            entity.getPersistentData().putDouble("cnt_x", 0.0);
                            ResetCounterProcedure.execute(entity);
                        }

                        return;
                    }
                }
                if (entity instanceof  LivingEntity _12 &&  !_12.hasEffect(JujutsucraftaddonModMobEffects.SOKA_MONA.get())) {
                    AIActiveProcedure.execute(world, x, y, z, entity);
                }
                entity.getPersistentData().putBoolean("infinity", true);
                WhenPlayerActiveTickInfinityProcedure.execute(entity);
                LivingEntity var10000;
                Mob _mobEnt;
                if (entity.getPersistentData().getBoolean("GojoNoUseInfinity")) {
                    if (entity.getPersistentData().getDouble("cnt_target") > 50.0) {
                        entity.getPersistentData().putBoolean("GojoNoUseInfinity", false);
                    } else if (entity.getPersistentData().getDouble("cnt_target") > 3.0) {
                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity)entity;
                            if (!_entity.level().isClientSide()) {
                                _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 9, false, false));
                            }
                        }
                    } else {
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var10000 = _mobEnt.getTarget();
                        } else {
                            var10000 = null;
                        }

                        if (!(var10000 instanceof LivingEntity) && !world.getEntitiesOfClass(SukunaFushiguroEntity.class, AABB.ofSize(new Vec3(x, y, z), 256.0, 256.0, 256.0), (e) -> {
                            return true;
                        }).isEmpty()) {
                            target_entity = (Entity)world.getEntitiesOfClass(SukunaFushiguroEntity.class, AABB.ofSize(new Vec3(x, y, z), 256.0, 256.0, 256.0), (e) -> {
                                return true;
                            }).stream().sorted(((new Object() {
                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble((_entcnd) -> {
                                        return _entcnd.distanceToSqr(_x, _y, _z);
                                    });
                                }
                            })).compareDistOf(x, y, z)).findFirst().orElse(null);
                            if (entity instanceof Mob) {
                                _mobEnt = (Mob)entity;
                                if (target_entity instanceof LivingEntity) {
                                    _entity = (LivingEntity)target_entity;
                                    _mobEnt.setTarget(_entity);
                                }
                            }
                        }
                    }
                }

                adult = entity instanceof GojoSatoruEntity;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                GojoSatoruSchoolDaysEntity _datEntL85;
                label658: {
                    target_sukuna = var10000 instanceof SukunaFushiguroEntity;
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        if (_entity.hasEffect(MobEffects.DAMAGE_BOOST)) {
                            break label658;
                        }
                    }

                    if (entity instanceof GojoSatoruSchoolDaysEntity && entity instanceof GojoSatoruSchoolDaysEntity) {
                        _datEntL85 = (GojoSatoruSchoolDaysEntity)entity;
                        if ((Boolean)_datEntL85.getEntityData().get(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                            if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity)entity;
                                if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, Integer.MAX_VALUE, 26, false, false));
                                }
                            }

                            if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity)entity;
                                if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, Integer.MAX_VALUE, 26, false, false));
                                }
                            }
                            break label658;
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, Integer.MAX_VALUE, adult ? 29 : 20, false, false));
                        }
                    }
                }

                label632: {
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        if (_entity.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                            break label632;
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        if (!_livEnt.level().isClientSide()) {
                            _livEnt.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 3, false, false));
                        }
                    }
                }

                label627: {
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        if (_entity.hasEffect((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get())) {
                            break label627;
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        if (!_livEnt.level().isClientSide()) {
                            _livEnt.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get(), Integer.MAX_VALUE, 4, false, false));
                        }
                    }
                }

                if (entity instanceof GojoSatoruEntity) {
                    GojoSatoruEntity _datEntL43 = (GojoSatoruEntity)entity;
                    if ((Boolean)_datEntL43.getEntityData().get(GojoSatoruEntity.DATA_ghost)) {
                        if (entity instanceof LivingEntity) {
                            _livEnt = (LivingEntity)entity;
                            if (!_livEnt.level().isClientSide()) {
                                _livEnt.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 1, false, false));
                            }
                        }

                        if (entity instanceof LivingEntity) {
                            _livEnt = (LivingEntity)entity;
                            if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()) && !entity.level().isClientSide() && entity.getServer() != null) {
                                entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
                            }
                        }
                    }
                }

                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                if (var10000 instanceof LivingEntity) {
                    LivingEntity _living;
                    LivingEntity _livEnt81;
                    if (entity.getPersistentData().getDouble("cnt_target") > 150.0 && target_sukuna) {
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var10000 = _mobEnt.getTarget();
                        } else {
                            var10000 = null;
                        }

                        _living = var10000;
                        if (_living instanceof Mob) {
                            _mobEnt = (Mob)_living;
                            var10000 = _mobEnt.getTarget();
                        } else {
                            var10000 = null;
                        }

                        if (!(var10000 instanceof LivingEntity)) {
                            if (entity instanceof Mob) {
                               Mob _entity2 = (Mob)entity;
                                var10000 = _entity2.getTarget();
                            } else {
                                var10000 = null;
                            }

                            Entity target_entity2 = var10000;
                            if (target_entity2 instanceof Mob) {
                                Mob _entity3 = (Mob)target_entity2;
                                if (entity instanceof LivingEntity) {
                                    _livEnt81 = (LivingEntity)entity;
                                    _entity3.setTarget(_livEnt81);
                                }
                            }
                        }
                    }

                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                    } else {
                        var10000 = null;
                    }

                    _living = var10000;
                    ItemStack var62;
                    if (_living instanceof LivingEntity) {
                        _livEnt = (LivingEntity)_living;
                        var62 = _livEnt.getMainHandItem();
                    } else {
                        var62 = ItemStack.EMPTY;
                    }

                    defense = var62.getItem() == JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get();
                    domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity) && adult;
                    entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                    if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                        entity.getPersistentData().putDouble("cnt_x", 0.0);
                        if (!entity.getPersistentData().getBoolean("GojoNoUseInfinity") && target_sukuna) {
                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity)entity;
                                var62 = _livEnt.getItemBySlot(EquipmentSlot.CHEST);
                            } else {
                                var62 = ItemStack.EMPTY;
                            }

                            if (var62.getItem() == JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_CHESTPLATE.get()) {
                                Player _player;
                                if (entity instanceof Player) {
                                    _player = (Player)entity;
                                    _player.getInventory().armor.set(3, ItemStack.EMPTY);
                                    _player.getInventory().setChanged();
                                } else if (entity instanceof LivingEntity) {
                                    _livEnt81 = (LivingEntity)entity;
                                    _livEnt81.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
                                }

                                if (entity instanceof Player) {
                                    _player = (Player)entity;
                                    _player.getInventory().armor.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_CHESTPLATE.get()));
                                    _player.getInventory().setChanged();
                                } else if (entity instanceof LivingEntity) {
                                    _livEnt81 = (LivingEntity)entity;
                                    _livEnt81.setItemSlot(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_CHESTPLATE.get()));
                                }

                                if (entity instanceof Player) {
                                    _player = (Player)entity;
                                    _player.getInventory().armor.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_LEGGINGS.get()));
                                    _player.getInventory().setChanged();
                                } else if (entity instanceof LivingEntity) {
                                    _livEnt81 = (LivingEntity)entity;
                                    _livEnt81.setItemSlot(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_LEGGINGS.get()));
                                }
                            }
                        }

                        ResetCounterProcedure.execute(entity);
                        distance = GetDistanceProcedure.execute(world, entity);
                        float var63;
                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity)entity;
                            var63 = _entity.getHealth();
                        } else {
                            var63 = -1.0F;
                        }

                        if (entity instanceof LivingEntity) {
                            _livEnt = (LivingEntity)entity;
                            var10001 = _livEnt.getMaxHealth();
                        } else {
                            var10001 = -1.0F;
                        }

                        label715: {
                            health = (double)(var63 / var10001);
                            if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                if (!(entity instanceof GojoSatoruSchoolDaysEntity)) {
                                    break label715;
                                }

                                _datEntL85 = (GojoSatoruSchoolDaysEntity)entity;
                                if (!(Boolean)_datEntL85.getEntityData().get(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                                    break label715;
                                }
                            }

                            purple = entity.getPersistentData().getBoolean("GojoNoUseInfinity") && distance > 32.0;
                            if (!entity.getPersistentData().getBoolean("flag1") && health < 0.3 && (!adult || distance < 32.0)) {
                                if (entity instanceof LivingEntity) {
                                    _entity = (LivingEntity)entity;
                                    if (!_entity.level().isClientSide()) {
                                        _entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 20, 0, false, false));
                                    }
                                }

                                purple = true;
                            }
                        }

                        LivingEntity _livEnt105;
                        int var64;
                        if (!domain) {
                            label686: {
                                if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                    if (!(entity instanceof GojoSatoruSchoolDaysEntity)) {
                                        break label686;
                                    }

                                    _datEntL85 = (GojoSatoruSchoolDaysEntity)entity;
                                    if (!(Boolean)_datEntL85.getEntityData().get(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                                        break label686;
                                    }
                                }

                                if (distance < 24.0) {
                                    if (entity instanceof Mob) {
                                        _mobEnt = (Mob)entity;
                                        var10000 = _mobEnt.getTarget();
                                    } else {
                                        var10000 = null;
                                    }

                                    LivingEntity var36 = var10000;
                                    if (var36 instanceof LivingEntity) {
                                        _living = (LivingEntity)var36;
                                        if (_living.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                            label689: {
                                                if (entity instanceof LivingEntity) {
                                                    _livEnt81 = (LivingEntity)entity;
                                                    if (_livEnt81.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                        break label689;
                                                    }
                                                }

                                                if (entity instanceof Mob) {
                                                    Mob _mobEnt6 = (Mob)entity;
                                                    var10000 = _mobEnt6.getTarget();
                                                } else {
                                                    var10000 = null;
                                                }

                                                label578: {
                                                    _livEnt105 = var10000;
                                                    if (_livEnt105 instanceof LivingEntity) {
                                                        _livEnt = (LivingEntity)_livEnt105;
                                                        if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                            var64 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                                                            break label578;
                                                        }
                                                    }

                                                    var64 = 0;
                                                }

                                                if (var64 <= 600) {
                                                    red = true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        label665: {
                            label560: {
                                if (LogicStartProcedure.execute(entity)) {
                                    if (Math.random() > (defense ? 0.3 : 0.5)) {
                                        break label560;
                                    }

                                    if (purple || red) {
                                        if (!(entity instanceof GojoSatoruSchoolDaysEntity)) {
                                            break label560;
                                        }

                                        if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                            _datEntL85 = (GojoSatoruSchoolDaysEntity)entity;
                                            if ((Boolean)_datEntL85.getEntityData().get(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                                                break label560;
                                            }
                                        }
                                    }
                                }

                                if (!domain && entity instanceof LivingEntity e1 && !e1.hasEffect(JujutsucraftaddonModMobEffects.SOKA_MONA.get())) {
                                    CalculateAttackProcedure.execute(world, x, y, z, entity);
                                    break label665;
                                }
                            }

                            if (domain) {
                                rnd = 20.0;
                                tick = 20.0;
                            } else {
                                label702: {
                                    if (!entity.getPersistentData().getBoolean("flag2")) {
                                        label692: {
                                            if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                                if (!(entity instanceof GojoSatoruSchoolDaysEntity)) {
                                                    break label692;
                                                }

                                                GojoSatoruSchoolDaysEntity _datEntL88 = (GojoSatoruSchoolDaysEntity)entity;
                                                if (!(Boolean)_datEntL88.getEntityData().get(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                                                    break label692;
                                                }
                                            } else if (!(health < 0.5) || !(distance < 16.0)) {
                                                break label692;
                                            }

                                            entity.getPersistentData().putBoolean("flag2", true);
                                            rnd = 7.0;
                                            tick = 250.0;
                                            break label702;
                                        }
                                    }

                                    if (!entity.getPersistentData().getBoolean("flag1")) {
                                        label693: {
                                            if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                                if (!(entity instanceof GojoSatoruSchoolDaysEntity)) {
                                                    break label693;
                                                }

                                                GojoSatoruSchoolDaysEntity _datEntL92 = (GojoSatoruSchoolDaysEntity)entity;
                                                if (!(Boolean)_datEntL92.getEntityData().get(GojoSatoruSchoolDaysEntity.DATA_awaking) || !(health < 0.5)) {
                                                    break label693;
                                                }
                                            } else if (!(health < 0.3) || !(distance < 40.0)) {
                                                break label693;
                                            }


                                            if (entity instanceof GojoSatoruEntity _3 && _3.hasEffect(MobEffects.SLOW_FALLING)) {
                                                break label702;
                                            }

                                            entity.getPersistentData().putBoolean("flag1", true);
                                            if (entity instanceof GojoSatoruEntity _gojo && !_gojo.hasEffect(MobEffects.SLOW_FALLING)) {
                                                if (!((((GojoSatoruEntity) entity).animationprocedure).equals("murasaki2"))) {
                                                    ((GojoSatoruEntity) entity).setAnimation("murasaki2");
                                                }
                                                if (entity instanceof LivingEntity _entity4 && !_entity4.level().isClientSide())
                                                    _entity4.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.WORLD_GOJO.get(), 240, 1, false, false));
                                                UnlimitedPurpleProcedure.execute(world, x, y, z, entity);
                                                break label702;
                                            }

                                            rnd = 15.0;
                                            tick = 500.0;
                                            break label702;
                                        }
                                    }

                                    label703: {
                                        if (red) {
                                            if (!(entity instanceof GojoSatoruSchoolDaysEntity)) {
                                                break label703;
                                            }

                                            if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                                GojoSatoruSchoolDaysEntity _datEntL95 = (GojoSatoruSchoolDaysEntity)entity;
                                                if ((Boolean)_datEntL95.getEntityData().get(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                                                    break label703;
                                                }
                                            }
                                        }

                                        if (purple) {
                                            label694: {
                                                if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                                    if (!(entity instanceof GojoSatoruSchoolDaysEntity)) {
                                                        break label694;
                                                    }

                                                    GojoSatoruSchoolDaysEntity _datEntL97 = (GojoSatoruSchoolDaysEntity)entity;
                                                    if (!(Boolean)_datEntL97.getEntityData().get(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                                                        break label694;
                                                    }
                                                }

                                                entity.getPersistentData().putBoolean("GojoNoUseInfinity", false);
                                                rnd = 15.0;
                                                tick = 500.0;
                                                break label702;
                                            }
                                        }

                                        num1 = 0.0;
                                        int index0 = 0;

                                        while(true) {
                                            if (index0 >= 128) {
                                                break label702;
                                            }

                                            ++num1;
                                            if (num1 > 96.0) {
                                                rnd = 0.0;
                                                break label702;
                                            }

                                            label674: {
                                                rnd = (double)Math.round(4.0 + Math.random() * 16.0);
                                                if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                                    label675: {
                                                        if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                                            GojoSatoruSchoolDaysEntity _datEntL100 = (GojoSatoruSchoolDaysEntity)entity;
                                                            if ((Boolean)_datEntL100.getEntityData().get(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                                                                break label675;
                                                            }
                                                        }

                                                        if (rnd == 7.0 || rnd == 15.0) {
                                                            break label674;
                                                        }
                                                    }
                                                }

                                                if (rnd == 6.0) {
                                                    label468: {
                                                        tick = 100.0;
                                                        if (entity instanceof LivingEntity) {
                                                            _livEnt105 = (LivingEntity)entity;
                                                            if (_livEnt105.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                                                var64 = _livEnt105.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                                                                break label468;
                                                            }
                                                        }

                                                        var64 = 0;
                                                    }

                                                    if (var64 <= 0) {
                                                        break label702;
                                                    }
                                                } else if (rnd == 7.0) {
                                                    tick = 250.0;
                                                    if (!(Math.random() > 0.5) && !(distance > 16.0)) {
                                                        label474: {
                                                            if (entity instanceof LivingEntity) {
                                                                _livEnt105 = (LivingEntity)entity;
                                                                if (_livEnt105.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                                                    var64 = _livEnt105.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                                                                    break label474;
                                                                }
                                                            }

                                                            var64 = 0;
                                                        }

                                                        if (var64 <= 0) {
                                                            if (!(entity instanceof LivingEntity)) {
                                                                break label702;
                                                            }

                                                            _livEnt105 = (LivingEntity)entity;
                                                            if (!_livEnt105.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                                break label702;
                                                            }
                                                        }
                                                    }
                                                } else if (rnd == 15.0) {
                                                    tick = 500.0;
                                                    if (!target_sukuna && !(distance < 8.0)) {
                                                        label482: {
                                                            if (entity instanceof LivingEntity) {
                                                                _livEnt105 = (LivingEntity)entity;
                                                                if (_livEnt105.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                                                    var64 = _livEnt105.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                                                                    break label482;
                                                                }
                                                            }

                                                            var64 = 0;
                                                        }

                                                        if (var64 <= 0 && !(Math.random() > 0.1)) {
                                                            if (!(entity instanceof LivingEntity)) {
                                                                break label702;
                                                            }

                                                            _livEnt105 = (LivingEntity)entity;
                                                            if (!_livEnt105.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                                break label702;
                                                            }
                                                        }
                                                    }
                                                } else if (rnd == 20.0) {
                                                    tick = 20.0;
                                                    if (adult && !AIDomainLogicProcedure.execute(world, x, y, z, entity)) {
                                                        if (entity instanceof Mob) {
                                                            Mob _mobEnt8 = (Mob)entity;
                                                            var10000 = _mobEnt8.getTarget();
                                                        } else {
                                                            var10000 = null;
                                                        }

                                                        LivingEntity var40 = var10000;
                                                        if (!(var40 instanceof LivingEntity)) {
                                                            break label702;
                                                        }

                                                        LivingEntity _livEnt107 = (LivingEntity)var40;
                                                        if (!_livEnt107.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get()) || LogicConfilmDomainProcedure.execute(world, x, y, z, entity)) {
                                                            break label702;
                                                        }
                                                    }
                                                }
                                            }

                                            ++index0;
                                        }
                                    }

                                    rnd = 7.0;
                                    tick = 250.0;
                                }
                            }
                            if (entity instanceof LivingEntity e1 && !e1.hasEffect(JujutsucraftaddonModMobEffects.SOKA_MONA.get())) {
                                if (rnd > 0.0) {
                                    entity.getPersistentData().putDouble("skill", (double) Math.round(200.0 + rnd));
                                    if (entity instanceof LivingEntity) {
                                        _entity = (LivingEntity) entity;
                                        if (!_entity.level().isClientSide()) {
                                            _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                                        }
                                    }

                                    if (entity instanceof LivingEntity) {
                                        _entity = (LivingEntity) entity;
                                        if (!_entity.level().isClientSide()) {
                                            _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int) tick, 0, false, false));
                                        }
                                    }
                                } else {
                                    CalculateAttackProcedure.execute(world, x, y, z, entity);
                                }
                            }
                        }

                        if (rnd == 20.0) {
                            if (entity instanceof Player) {
                                Player _player = (Player)entity;
                                _player.getInventory().armor.set(3, ItemStack.EMPTY);
                                _player.getInventory().setChanged();
                            } else if (entity instanceof LivingEntity) {
                                _living = (LivingEntity)entity;
                                _living.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
                            }
                        }
                    }
                } else {
                    entity.getPersistentData().putDouble("cnt_x", 0.0);
                    if (health >= 0.5) {
                        entity.getPersistentData().putBoolean("flag2", false);
                    }

                    if (health >= 0.3) {
                        entity.getPersistentData().putBoolean("flag1", false);
                    }
                }
            }

        }
    }
}
