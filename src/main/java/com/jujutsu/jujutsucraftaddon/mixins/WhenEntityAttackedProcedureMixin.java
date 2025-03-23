package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModEnchantments;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import com.jujutsu.jujutsucraftaddon.procedures.AnimationDodgeProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.SukunaAttackAnimationsProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.SwapTodoTarget;
import net.mcreator.jujutsucraft.entity.*;
import net.mcreator.jujutsucraft.init.JujutsucraftModGameRules;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.*;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import software.bernie.geckolib.animatable.GeoEntity;

import java.util.UUID;
import java.util.function.BiFunction;

@Mixin(value = WhenEntityTakesDamageProcedure.class, priority = -10000)
public abstract class WhenEntityAttackedProcedureMixin {
    public WhenEntityAttackedProcedureMixin() {
    }

    /**
     * @author Satushi
     * @reason Change The Logic from attacks in jujutsucraft + add animations for attacks ( also that gives the mahoraga adaptation too )
     */

    @Inject(at = @At("HEAD"), method = "execute(Lnet/minecraftforge/eventbus/api/Event;Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/damagesource/DamageSource;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/entity/Entity;D)V", remap = false, cancellable = true)
    private static void execute(Event event, LevelAccessor world, DamageSource damagesource, Entity entity, Entity immediatesourceentity, Entity sourceentity, double amount, CallbackInfo ci) {
        ci.cancel();

        if (damagesource != null && entity != null && sourceentity != null) {
            String STR1 = "";
            ItemStack item_A = ItemStack.EMPTY;
            double DamagePoint = 0.0;
            double MAX_CURSE_POWER = 0.0;
            double NUM1 = 0.0;
            double NUM2 = 0.0;
            boolean cancel = false;
            boolean mahorage = false;
            boolean logic_a = false;
            Entity entity_a = null;
            ItemStack mainHandItem = ItemStack.EMPTY;
            boolean use_curse = false;
            boolean changeDamage = false;
            boolean guard = false;
            double old_diffence2 = 0.0;
            double Damage_amount = 0.0;
            double old_diffence = 0.0;
            LivingEntity _livEnt122;
            LivingEntity _livingEntity;

            if (!damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("forge:animation")))) {


                SukunaAttackAnimationsProcedure.execute(sourceentity, entity, world);

                if (sourceentity instanceof FushiguroTojiBugEntity && amount >= 100) {
                    if (!((((FushiguroTojiBugEntity) sourceentity).animationprocedure).equals("playful" + Mth.nextInt(RandomSource.create(), 1, 4)))) {
                        ((FushiguroTojiBugEntity) sourceentity).setAnimation("playful" + Mth.nextInt(RandomSource.create(), 1, 4));
                    }
                }

                if (sourceentity instanceof FushiguroTojiEntity && amount >= 100 && ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftModItems.PLAYFUL_CLOUD.get())) {
                    if (!((((FushiguroTojiEntity) sourceentity).animationprocedure).equals("playful" + Mth.nextInt(RandomSource.create(), 1, 4)))) {
                        ((FushiguroTojiEntity) sourceentity).setAnimation("playful" + Mth.nextInt(RandomSource.create(), 1, 4));
                    }
                }




                // Normal Player Attack Animations
                if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Run == 1) {
                    if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        if (!(sourceentity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(JujutsucraftaddonModMobEffects.ANIMATION.get()))) {
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANIMATION.get(), 10, 1, false, false));
                        }

                }

                if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 20) {
                    if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower >= 1000) {
                        if (Math.random() < (1) / ((float) 60)) {
                            SwapTodoTarget.execute(entity, world, sourceentity);
                            AnimationDodgeProcedure.execute(world, entity);
                            if (event != null && event.isCancelable()) {
                                event.setCanceled(true);
                            } else if (event != null && event.hasResult()) {
                                event.setResult(Event.Result.DENY);
                            }
                        }
                    }
                } else if (entity instanceof TodoAoiEntity) {
                    if (Math.random() < (1) / ((float) 60)) {
                        SwapTodoTarget.execute(entity, world, sourceentity);
                        if (event != null && event.isCancelable()) {
                            event.setCanceled(true);
                        } else if (event != null && event.hasResult()) {
                            event.setResult(Event.Result.DENY);
                        }
                    }
                }


                // Ultra Instinct
                if (EnchantmentHelper.getItemEnchantmentLevel(JujutsucraftaddonModEnchantments.ULTRA_INSTINCT.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)) != 0) {
                    if (Math.random() < ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getEnchantmentLevel(JujutsucraftaddonModEnchantments.ULTRA_INSTINCT.get())) / ((float) 100)) {
                        AnimationDodgeProcedure.execute(world, entity);
                        if (event != null && event.isCancelable()) {
                            event.setCanceled(true);
                        } else if (event != null && event.hasResult()) {
                            event.setResult(Event.Result.DENY);
                        }
                    }
                }

                // Itadori Awakening Buff
                if (sourceentity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftaddonModMobEffects.ITADORI_AWAKENING.get())) {
                    if (Math.random() < (1) / ((float) 60)) {
                        sourceentity.getPersistentData().putDouble("skill", 3810.0);
                        sourceentity.getPersistentData().putDouble("cnt6", 4.0);
                        if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 60, 1, false, false));
                        double yaw = Math.toRadians(sourceentity.getYRot() + 90.0F);
                        double pitch = Math.toRadians(sourceentity.getXRot());
                        sourceentity.getPersistentData().putDouble("x_pos", entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (double) (2.0F + entity.getBbWidth()));
                        sourceentity.getPersistentData().putDouble("y_pos", entity.getY() + (double) entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * (double) (2.0F + entity.getBbWidth()));
                        sourceentity.getPersistentData().putDouble("z_pos", entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (double) (2.0F + entity.getBbWidth()));
                        if (!(sourceentity instanceof LivingEntity _livEnt01 && _livEnt01.hasEffect(JujutsucraftaddonModMobEffects.KOKUSEN_N.get()))) {
                            if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.KOKUSEN_N.get(), 20, 1, false, false));
                        }
                    }
                }

                // Uro Buff
                if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 38) {
                    if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Fujiwara")) {
                        if (Math.random() < (1) / ((float) 50)) {
                            entity.getPersistentData().putDouble("skill", 3810.0);
                            entity.getPersistentData().putDouble("cnt6", 4.0);
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 60, 1, false, false));
                            double yaw = Math.toRadians(entity.getYRot() + 90.0F);
                            double pitch = Math.toRadians(entity.getXRot());
                            entity.getPersistentData().putDouble("x_pos", entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (double) (2.0F + entity.getBbWidth()));
                            entity.getPersistentData().putDouble("y_pos", entity.getY() + (double) entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * (double) (2.0F + entity.getBbWidth()));
                            entity.getPersistentData().putDouble("z_pos", entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (double) (2.0F + entity.getBbWidth()));
                            AnimationDodgeProcedure.execute(world, entity);
                            if (event != null && event.isCancelable()) {
                                event.setCanceled(true);
                            } else if (event != null && event.hasResult()) {
                                event.setResult(Event.Result.DENY);
                            }
                        }
                    } else {
                        if (Math.random() < (1) / ((float) 120)) {
                            entity.getPersistentData().putDouble("skill", 3810.0);
                            entity.getPersistentData().putDouble("cnt6", 4.0);
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 60, 1, false, false));
                            double yaw = Math.toRadians(entity.getYRot() + 90.0F);
                            double pitch = Math.toRadians(entity.getXRot());
                            entity.getPersistentData().putDouble("x_pos", entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (double) (2.0F + entity.getBbWidth()));
                            entity.getPersistentData().putDouble("y_pos", entity.getY() + (double) entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * (double) (2.0F + entity.getBbWidth()));
                            entity.getPersistentData().putDouble("z_pos", entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (double) (2.0F + entity.getBbWidth()));
                            AnimationDodgeProcedure.execute(world, entity);
                            if (event != null && event.isCancelable()) {
                                event.setCanceled(true);
                            } else if (event != null && event.hasResult()) {
                                event.setResult(Event.Result.DENY);
                            }
                        }
                    }
                }

                // Rejected Zenin and Toji Buff
                if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == -1) {
                    if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower == 0) {
                        if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Rejected Zenin")) {
                            if (Math.random() < (1) / ((float) 40)) {
                                AnimationDodgeProcedure.execute(world, entity);
                                if (event != null && event.isCancelable()) {
                                    event.setCanceled(true);
                                } else if (event != null && event.hasResult()) {
                                    event.setResult(Event.Result.DENY);
                                }
                            }
                        } else {
                            if (Math.random() < (1) / ((float) 80)) {
                                AnimationDodgeProcedure.execute(world, entity);
                                if (event != null && event.isCancelable()) {
                                    event.setCanceled(true);
                                } else if (event != null && event.hasResult()) {
                                    event.setResult(Event.Result.DENY);
                                }
                            }
                        }
                    }
                }

                if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.WUKONG_SET_BOOTS.get().asItem()) {
                    if (Math.random() < (1) / ((float) 100)) {
                        if (!(entity instanceof GeoEntity)) {
                            AnimationDodgeProcedure.execute(world, entity);
                            if (event != null && event.isCancelable()) {
                                event.setCanceled(true);
                            } else if (event != null && event.hasResult()) {
                                event.setResult(Event.Result.DENY);
                            }
                        }
                    }
                }

                if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.WUKONG_SET_CHESTPLATE.get().asItem()) {
                    if (Math.random() < (1) / ((float) 20)) {
                        sourceentity.hurt(damagesource, (float) amount / 10);
                    }
                }

                int var10000;
                LivingEntity _livEnt;
                if (sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && !sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo_no_move"))) && LogicStartPassiveProcedure.execute(entity)) {
                    label585:
                    {
                        NUM1 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
                        NUM2 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
                        if (NUM1 == 38.0 || NUM2 == 38.0 || entity instanceof UroTakakoEntity) {
                            label583:
                            {
                                if (entity instanceof LivingEntity) {
                                    _livEnt122 = (LivingEntity) entity;
                                    if (_livEnt122.hasEffect((MobEffect) JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                        break label583;
                                    }
                                }

                                if (sourceentity.getBbWidth() + sourceentity.getBbHeight() <= (entity.getBbWidth() + entity.getBbHeight()) * 4.0F && entity instanceof LivingEntity) {
                                    _livingEntity = (LivingEntity) entity;
                                    if (_livingEntity.hasEffect((MobEffect) JujutsucraftModMobEffects.GUARD.get())) {
                                        cancel = true;
                                    }
                                }
                            }
                        }

                        if (entity instanceof LivingEntity) {
                            _livEnt122 = (LivingEntity) entity;
                            if (_livEnt122.hasEffect((MobEffect) JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                break label585;
                            }
                        }

                        if (entity instanceof LivingEntity) {
                            _livingEntity = (LivingEntity) entity;
                            if (_livingEntity.hasEffect((MobEffect) JujutsucraftModMobEffects.PRAYER_SONG.get())) {
                                label520:
                                {
                                    if (entity instanceof LivingEntity) {
                                        _livEnt = (LivingEntity) entity;
                                        if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.GUARD.get())) {
                                            var10000 = _livEnt.getEffect((MobEffect) JujutsucraftModMobEffects.GUARD.get()).getAmplifier();
                                            break label520;
                                        }
                                    }

                                    var10000 = 0;
                                }

                                if (var10000 > 0) {
                                    cancel = true;
                                }
                            }
                        }
                    }
                }

                if (cancel) {
                    if (event != null && event.isCancelable()) {
                        event.setCanceled(true);
                    } else if (event != null && event.hasResult()) {
                        event.setResult(Event.Result.DENY);
                    }
                } else if (!damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("forge:curse"))) && !damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("forge:combat")))) {
                    cancel = false;
                    Mob _mobEnt;
                    LivingEntity var42;
                    if (sourceentity instanceof Mob) {
                        _mobEnt = (Mob) sourceentity;
                        var42 = _mobEnt.getTarget();
                    } else {
                        var42 = null;
                    }

                    LivingEntity var10001;
                    if (var42 instanceof LivingEntity) {
                        if (sourceentity instanceof Mob) {
                            _mobEnt = (Mob) sourceentity;
                            var42 = _mobEnt.getTarget();
                        } else {
                            var42 = null;
                        }

                        if (entity instanceof Mob) {
                            _mobEnt = (Mob) entity;
                            var10001 = _mobEnt.getTarget();
                        } else {
                            var10001 = null;
                        }

                        if (var42 == var10001) {
                            cancel = true;
                        }
                    }

                    if (!cancel) {
                        label571:
                        {
                            label550:
                            {
                                if (entity instanceof TamableAnimal) {
                                    TamableAnimal _tamEnt = (TamableAnimal) entity;
                                    if (_tamEnt.isTame()) {
                                        break label550;
                                    }
                                }

                                if (!(sourceentity instanceof TamableAnimal)) {
                                    break label571;
                                }

                                TamableAnimal _tamEnt = (TamableAnimal) sourceentity;
                                if (!_tamEnt.isTame()) {
                                    break label571;
                                }
                            }

                            if (entity instanceof TamableAnimal) {
                                TamableAnimal _tamEnt = (TamableAnimal) entity;
                                var42 = _tamEnt.getOwner();
                            } else {
                                var42 = null;
                            }

                            if (var42 != sourceentity) {
                                if (sourceentity instanceof TamableAnimal) {
                                    TamableAnimal _tamEnt = (TamableAnimal) sourceentity;
                                    var42 = _tamEnt.getOwner();
                                } else {
                                    var42 = null;
                                }

                                if (var42 != entity) {
                                    if (entity instanceof TamableAnimal) {
                                        TamableAnimal _tamEnt = (TamableAnimal) entity;
                                        var42 = _tamEnt.getOwner();
                                    } else {
                                        var42 = null;
                                    }

                                    if (sourceentity instanceof TamableAnimal) {
                                        TamableAnimal _tamEnt = (TamableAnimal) sourceentity;
                                        var10001 = _tamEnt.getOwner();
                                    } else {
                                        var10001 = null;
                                    }

                                    if (var42 != var10001) {
                                        break label571;
                                    }
                                }
                            }

                            cancel = true;
                        }
                    }

                    if (!world.getLevelData().getGameRules().getBoolean(JujutsucraftModGameRules.JUJUTSUPVP) && (sourceentity instanceof Player || sourceentity.getPersistentData().getBoolean("Player")) && (entity instanceof Player || entity.getPersistentData().getBoolean("Player"))) {
                        label588:
                        {
                            label553:
                            {
                                cancel = true;
                                if (entity instanceof LivingEntity) {
                                    _livEnt122 = (LivingEntity) entity;
                                    if (_livEnt122.hasEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                        break label553;
                                    }
                                }

                                if (!(sourceentity instanceof LivingEntity)) {
                                    break label588;
                                }

                                _livingEntity = (LivingEntity) sourceentity;
                                if (!_livingEntity.hasEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                    break label588;
                                }
                            }

                            cancel = false;
                        }
                    }

                    if (entity instanceof Mob) {
                        _mobEnt = (Mob) entity;
                        var42 = _mobEnt.getTarget();
                    } else {
                        var42 = null;
                    }

                    label591:
                    {
                        if (var42 != sourceentity || !(entity.getPersistentData().getDouble("cnt_target") > 6.0)) {
                            if (sourceentity instanceof Mob) {
                                _mobEnt = (Mob) sourceentity;
                                var42 = _mobEnt.getTarget();
                            } else {
                                var42 = null;
                            }

                            if (var42 != entity || !(sourceentity.getPersistentData().getDouble("cnt_target") > 6.0)) {
                                break label591;
                            }
                        }

                        cancel = false;
                    }

                    if (!cancel) {
                        if (sourceentity.getPersistentData().getDouble("friend_num") != 0.0 && sourceentity.getPersistentData().getDouble("friend_num") == entity.getPersistentData().getDouble("friend_num")) {
                            cancel = true;
                        }

                        if (damagesource.is(DamageTypes.MOB_ATTACK) || damagesource.is(DamageTypes.PLAYER_ATTACK)) {
                            label584:
                            {
                                label557:
                                {
                                    if (sourceentity instanceof LivingEntity) {
                                        _livEnt122 = (LivingEntity) sourceentity;
                                        if (_livEnt122.hasEffect((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()) && sourceentity instanceof LivingEntity) {
                                            _livingEntity = (LivingEntity) sourceentity;
                                            if (_livingEntity.hasEffect((MobEffect) JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                                                break label557;
                                            }
                                        }
                                    }

                                    label434:
                                    {
                                        if (sourceentity instanceof LivingEntity) {
                                            _livEnt = (LivingEntity) sourceentity;
                                            if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                                var10000 = _livEnt.getEffect((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getAmplifier();
                                                break label434;
                                            }
                                        }

                                        var10000 = 0;
                                    }

                                    if (var10000 <= 0 && !(sourceentity.getPersistentData().getDouble("skill") <= -999.0)) {
                                        break label584;
                                    }
                                }

                                cancel = true;
                            }
                        }

                        label426:
                        {
                            if (entity instanceof LivingEntity) {
                                _livEnt122 = (LivingEntity) entity;
                                if (_livEnt122.hasEffect((MobEffect) JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                    break label426;
                                }
                            }

                            if (entity instanceof LivingEntity) {
                                _livingEntity = (LivingEntity) entity;
                                if (_livingEntity.hasEffect((MobEffect) JujutsucraftModMobEffects.PRAYER_SONG.get())) {
                                    label419:
                                    {
                                        if (entity instanceof LivingEntity) {
                                            _livEnt = (LivingEntity) entity;
                                            if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.GUARD.get())) {
                                                var10000 = _livEnt.getEffect((MobEffect) JujutsucraftModMobEffects.GUARD.get()).getAmplifier();
                                                break label419;
                                            }
                                        }

                                        var10000 = 0;
                                    }

                                    if (var10000 > 0) {
                                        cancel = true;
                                    } else if (Math.random() < (1) / ((float) 120)) {
                                        cancel = true;
                                    }
                                }
                            }
                        }

                        if (immediatesourceentity instanceof BulletBallProjectileEntity) {
                            cancel = true;
                        }

                        if (entity instanceof DomainExpansionEntityEntity) {
                            cancel = true;
                        }
                    }

                    if (cancel) {
                        if (event != null && event.isCancelable()) {
                            event.setCanceled(true);
                        } else if (event != null && event.hasResult()) {
                            event.setResult(Event.Result.DENY);
                        }
                    } else {
                        double var43;
                        if (immediatesourceentity instanceof Projectile) {
                            Projectile _projEnt = (Projectile) immediatesourceentity;
                            var43 = _projEnt.getDeltaMovement().length();
                        } else {
                            var43 = 0.0;
                        }

                        if (var43 == 0.0) {
                            logic_a = sourceentity.getPersistentData().getBoolean("attack");
                            sourceentity.getPersistentData().putBoolean("attack", true);
                            CursedToolsAbilityProcedure.execute(sourceentity, entity);
                            sourceentity.getPersistentData().putBoolean("attack", logic_a);
                        }
                    }
                }
            }

            if (!cancel) {
                Damage_amount = amount;
                if (!damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("forge:animation"))) && !damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("forge:combat"))) && (!ModList.get().isLoaded("minepiece") || !entity.getPersistentData().getBoolean("skipDamage"))) {
                    if (!sourceentity.getPersistentData().getString("OWNER_UUID").isEmpty()) {
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
                        }).apply(world, sourceentity.getPersistentData().getString("OWNER_UUID"));
                    }

                    if (!(entity_a instanceof LivingEntity)) {
                        entity_a = sourceentity;
                    }

                    CounterProcedure.execute(entity);
                    ItemStack var44;
                    if (sourceentity instanceof LivingEntity) {
                        _livEnt122 = (LivingEntity) sourceentity;
                        var44 = _livEnt122.getMainHandItem();
                    } else {
                        var44 = ItemStack.EMPTY;
                    }

                    SetAttributeMainhandProcedure.execute(var44);
                    if (sourceentity instanceof LivingEntity) {
                        _livEnt122 = (LivingEntity) sourceentity;
                        var44 = _livEnt122.getMainHandItem();
                    } else {
                        var44 = ItemStack.EMPTY;
                    }

                    mainHandItem = var44.copy();
                    if (damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("forge:curse")))) {
                        if (mainHandItem.getItem() != ItemStack.EMPTY.getItem() && mainHandItem.getOrCreateTag().contains("CursePower") && mainHandItem.getOrCreateTag().getDouble("CursePower") != 0.0) {
                            use_curse = true;
                        }
                    } else {
                        label574:
                        {
                            if (!damagesource.is(DamageTypes.MOB_PROJECTILE)) {
                                if (mainHandItem.is(ItemTags.create(new ResourceLocation("forge:cursed_tool")))) {
                                    if (mainHandItem.getItem() == JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
                                        Damage_amount = 1.0;
                                        changeDamage = true;
                                    }

                                    if (mainHandItem.getItem() == JujutsucraftModItems.FESTER_LIFE_BLADE.get()) {
                                        changeDamage = true;
                                    }

                                    if (mainHandItem.getItem() == JujutsucraftModItems.PLAYFUL_CLOUD.get()) {
                                        Damage_amount *= 1.25;
                                        changeDamage = true;
                                    }
                                }

                                EffectAttackProcedure.execute(world, entity, sourceentity);
                                if (mainHandItem.getItem() != ItemStack.EMPTY.getItem() && mainHandItem.getOrCreateTag().contains("CursePower")) {
                                    if (mainHandItem.getOrCreateTag().getDouble("CursePower") > 0.0) {
                                        Damage_amount *= 1.0 + Math.abs(mainHandItem.getOrCreateTag().getDouble("CursePower")) * 0.02;
                                        changeDamage = true;
                                        use_curse = true;
                                    } else if (mainHandItem.getOrCreateTag().getDouble("CursePower") < 0.0 && entity.getPersistentData().getBoolean("CursedSpirit")) {
                                        label384:
                                        {
                                            if (mainHandItem.getItem() == JujutsucraftModItems.SWORD_OF_EXTERMINATION.get() && sourceentity instanceof Player) {
                                                Player _plrCldCheck84 = (Player) sourceentity;
                                                if (_plrCldCheck84.getCooldowns().isOnCooldown(mainHandItem.getItem())) {
                                                    break label384;
                                                }
                                            }

                                            Damage_amount *= 1.0 + Math.abs(mainHandItem.getOrCreateTag().getDouble("CursePower")) * 0.2;
                                        }

                                        changeDamage = true;
                                        use_curse = true;
                                    }
                                }
                            }

                            if (entity.getPersistentData().getDouble("skill") == 0.0) {
                                label377:
                                {
                                    if (entity instanceof LivingEntity) {
                                        _livEnt122 = (LivingEntity) entity;
                                        if (_livEnt122.hasEffect((MobEffect) JujutsucraftModMobEffects.GUARD.get())) {
                                            break label377;
                                        }
                                    }

                                    if (!entity.getPersistentData().getBoolean("guard")) {
                                        break label574;
                                    }
                                }
                            }

                            if (entity.getPersistentData().getDouble("Damage") > 0.0 && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && entity != sourceentity) {
                                Damage_amount = Math.max(Damage_amount - entity.getPersistentData().getDouble("Damage"), 0.0);
                                changeDamage = true;
                                guard = true;
                            }
                        }
                    }

                    if (entity.getPersistentData().getBoolean("CursedSpirit") && !use_curse) {
                        label576:
                        {
                            if (sourceentity instanceof Player) {
                                if (!(((JujutsucraftModVariables.PlayerVariables) sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer < 100.0) || LogicUseMinePieceProcedure.execute(sourceentity)) {
                                    break label576;
                                }
                            } else if (!sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:no_curse_power")))) {
                                break label576;
                            }

                            Damage_amount = 0.0;
                            changeDamage = true;
                        }
                    }

                    label562:
                    {
                        if (entity instanceof Player) {
                            if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 15.0 && ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 15.0) {
                                break label562;
                            }
                        } else if (!(entity instanceof MahitoEntity)) {
                            break label562;
                        }

                        if (entity instanceof LivingEntity) {
                            _livEnt122 = (LivingEntity) entity;
                            if (_livEnt122.hasEffect((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get())) {
                                break label562;
                            }
                        }

                        if (entity instanceof LivingEntity) {
                            _livingEntity = (LivingEntity) entity;
                            if (_livingEntity.hasEffect((MobEffect) JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                                break label562;
                            }
                        }

                        if (entity_a instanceof Player) {
                            if (entity_a instanceof ServerPlayer) {
                                ServerPlayer _plr105 = (ServerPlayer) entity_a;
                                if (_plr105.level() instanceof ServerLevel && _plr105.getAdvancements().getOrStartProgress(_plr105.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:observation_of_the_soul"))).isDone()) {
                                    break label562;
                                }
                            }
                        } else if (entity_a.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:soul_perception")))) {
                            break label562;
                        }

                        if (!sourceentity.getPersistentData().getBoolean("ignore")) {
                            Damage_amount *= 0.5;
                            changeDamage = true;
                        }
                    }

                    if (sourceentity.getPersistentData().getBoolean("ignore")) {
                        changeDamage = true;
                    }

                    if (entity instanceof Player && (entity_a.getPersistentData().getBoolean("jjkChara") || entity_a instanceof Player)) {
                        Damage_amount *= GetDifficultyLevelProcedure.execute(world);
                        changeDamage = true;
                    }

                    if (changeDamage) {
                        if (sourceentity.getPersistentData().getBoolean("ignore") && entity instanceof LivingEntity) {
                            _livEnt122 = (LivingEntity) entity;
                            if (!_livEnt122.level().isClientSide()) {
                                _livEnt122.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.IGNORE_GUARD.get(), 1, 0, false, false));
                            }
                        }

                        if (Damage_amount > 0.0) {
                            if (ModList.get().isLoaded("minepiece")) {
                                entity.getPersistentData().putBoolean("skipDamage", true);
                                entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse"))), entity_a), (float) Damage_amount);
                                entity.getPersistentData().putBoolean("skipDamage", false);
                            } else {
                                entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_combat"))), entity_a), (float) Damage_amount);
                            }
                        }

                        if (!damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("forge:curse")))) {
                            label578:
                            {
                                if (entity instanceof LivingEntity) {
                                    _livEnt122 = (LivingEntity) entity;
                                    if (_livEnt122.hasEffect((MobEffect) JujutsucraftModMobEffects.DAMAGE_EFFECT.get())) {
                                        break label578;
                                    }
                                }

                                if (entity instanceof LivingEntity) {
                                    _livingEntity = (LivingEntity) entity;
                                    if (!_livingEntity.level().isClientSide()) {
                                        _livingEntity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.DAMAGE_EFFECT.get(), 3, 0, false, false));
                                    }
                                }

                                if (entity instanceof LivingEntity) {
                                    _livingEntity = (LivingEntity) entity;
                                    if (!_livingEntity.level().isClientSide()) {
                                        _livingEntity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME_GUARD.get(), 10, 0, false, false));
                                    }
                                }

                                if (entity instanceof LivingEntity) {
                                    _livingEntity = (LivingEntity) entity;
                                    _livingEntity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.DAMAGE_EFFECT.get(), 3, 0, false, false));
                                }

                                if (entity instanceof LivingEntity) {
                                    _livingEntity = (LivingEntity) entity;
                                    _livingEntity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME_GUARD.get(), 10, 0, false, false));
                                }

                                if (guard) {
                                    GuardEffectProcedureProcedure.execute(world, entity.getX() + (double) entity.getBbWidth() * (Math.random() - 0.5), entity.getY() + (double) entity.getBbHeight() * Math.random(), entity.getZ() + (double) entity.getBbWidth() * (Math.random() - 0.5), sourceentity, entity);
                                }

                                DamageEffectProcedureProcedure.execute(world, sourceentity, entity, amount);
                            }
                        }

                        if (event != null && event.isCancelable()) {
                            event.setCanceled(true);
                        } else if (event != null && event.hasResult()) {
                            event.setResult(Event.Result.DENY);
                        }
                    }
                }
            }

        }
    }
}
