package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.entity.ErrorEntity;
import com.jujutsu.jujutsucraftaddon.entity.ItadoriShinjukuEntity;
import com.jujutsu.jujutsucraftaddon.entity.SukunaMangaEntity;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.procedures.TenShadowsRegisterProcedure;
import net.mcreator.jujutsucraft.entity.*;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.*;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
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
import java.util.List;

@Mixin(value = AISukunaProcedure.class, priority = -10000)
public abstract class SukunaAIBuffMixin {
    public SukunaAIBuffMixin() {
    }

    /**
     * @author Satushi
     * @reason Adds The Spider Web Cleave to Sukuna Entity
     */

    @Inject(method = "execute", at = @At("HEAD"), remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();
        if (entity != null) {
            ItemStack item_head = ItemStack.EMPTY;
            double rnd = 0.0;
            double tick = 0.0;
            double NUM_SUM = 0.0;
            double distance = 0.0;
            boolean domain = false;
            boolean infinity = false;
            boolean fushiguro_body = false;
            boolean mahoraga_exist = false;
            boolean vsMahoraga = false;
            boolean flag_megumiTechnique = false;
            boolean gojosatoru = false;

            if (entity.isAlive()) {
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
                AIActiveProcedure.execute(world, x, y, z, entity);
                fushiguro_body = entity instanceof SukunaFushiguroEntity || entity instanceof SukunaMangaEntity || entity instanceof com.jujutsu.jujutsucraftaddon.entity.SukunaFushiguroEntity;
                ItemStack var10000;
                LivingEntity _livEnt15;
                if (entity instanceof LivingEntity) {
                    _livEnt15 = (LivingEntity) entity;
                    var10000 = _livEnt15.getItemBySlot(EquipmentSlot.HEAD);
                } else {
                    var10000 = ItemStack.EMPTY;
                }

                if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == JujutsucraftModItems.UNIFORM_NORMAL_CHESTPLATE.get().asItem()) {
                    if (Math.random() < (1) / ((float) 3600)) {
                        {
                            Entity _entity = entity;
                            if (_entity instanceof Player _player) {
                                _player.getInventory().armor.set(2, ItemStack.EMPTY);
                                _player.getInventory().setChanged();
                            } else if (_entity instanceof LivingEntity _living) {
                                _living.setItemSlot(EquipmentSlot.CHEST, ItemStack.EMPTY);
                            }
                        }
                    }
                }

                if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == JujutsucraftModItems.HAIR_FUSHIGURO_MEGUMI_HELMET.get().asItem()) {
                    if (Math.random() < (1) / ((float) 1200)) {
                        {
                            Entity _entity = entity;
                            if (_entity instanceof Player _player) {
                                _player.getInventory().armor.set(3, ItemStack.EMPTY);
                                _player.getInventory().setChanged();
                            } else if (_entity instanceof LivingEntity _living) {
                                _living.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
                            }
                        }
                    }
                }


                item_head = var10000.copy();
                if (fushiguro_body && !entity.getPersistentData().getBoolean("flag_start")) {
                    entity.getPersistentData().putBoolean("flag_start", true);
                    rnd = 4.0;
                    TenShadowsRegisterProcedure.execute(entity);

                    for (int index0 = 0; index0 < 7; ++index0) {
                        entity.getPersistentData().putDouble("TenShadowsTechnique" + Math.round(rnd), 1.0);
                        ++rnd;
                    }

                    entity.getPersistentData().putDouble("TenShadowsTechnique1", -2.0);
                    entity.getPersistentData().putDouble("TenShadowsTechnique5", -2.0);
                    entity.getPersistentData().putDouble("TenShadowsTechnique14", 1.0);
                }


                SukunaFushiguroEntity _datEntL88;
                LivingEntity _livEnt109;
                label723:
                {
                    if (entity instanceof LivingEntity) {
                        _livEnt15 = (LivingEntity) entity;
                        if (_livEnt15.hasEffect(MobEffects.DAMAGE_BOOST)) {
                            break label723;
                        }
                    }

                    label768:
                    {
                        if (!(entity instanceof SukunaPerfectEntity) && (!(entity instanceof ErrorEntity))) {
                            label748:
                            {
                                if (entity instanceof SukunaFushiguroEntity) {
                                    _datEntL88 = (SukunaFushiguroEntity) entity;
                                    if ((Boolean) _datEntL88.getEntityData().get(SukunaFushiguroEntity.DATA_perfect_mode)) {
                                        break label748;
                                    }
                                }

                                if (fushiguro_body) {
                                    rnd = 30.0;
                                } else {
                                    rnd = 25.0;
                                }
                                break label768;
                            }
                        }

                        rnd = 35.0;
                        entity.getPersistentData().putDouble("KnockbackFix", 1.0);
                    }

                    if (entity instanceof LivingEntity) {
                        _livEnt109 = (LivingEntity) entity;
                        if (!_livEnt109.level().isClientSide()) {
                            _livEnt109.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, Integer.MAX_VALUE, (int) Math.round(rnd), false, false));
                        }
                    }

                    if (entity instanceof LivingEntity && (!(entity instanceof ItadoriShinjukuEntity))) {
                        _livEnt109 = (LivingEntity) entity;
                        if (!_livEnt109.level().isClientSide()) {
                            _livEnt109.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get(), Integer.MAX_VALUE, (int) Math.round(Math.min(Math.max(rnd - 11.0, 0.0), 19.0)), false, false));
                        }
                    }
                }

                label688:
                {
                    if (entity instanceof LivingEntity) {
                        _livEnt15 = (LivingEntity) entity;
                        if (_livEnt15.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                            break label688;
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _livEnt109 = (LivingEntity) entity;
                        if (!_livEnt109.level().isClientSide()) {
                            _livEnt109.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 3, false, false));
                        }
                    }
                }

                Mob _mobEnt;
                LivingEntity var47;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var47 = _mobEnt.getTarget();
                } else {
                    var47 = null;
                }

                if (var47 != null) {
                    if (var47 instanceof GojoSatoruEntity || var47 instanceof GojoSatoruSchoolDaysEntity || var47.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique == 2) {
                        gojosatoru = true;
                    }
                }

                if (entity instanceof SukunaFushiguroEntity _entity && gojosatoru) {
                    if (!_entity.level().isClientSide()) {
                        if (entity instanceof LivingEntity _entity2 && !_entity2.hasEffect(JujutsucraftaddonModMobEffects.BINDING_VOW_COOLDOWN.get())) {
                            _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftaddonModMobEffects.BINDING_VOW_COOLDOWN.get(), (int) 3000, 0, false, false));
                        }
                    }
                }

                LivingEntity _entity;
                LivingEntity _livEnt122;
                LivingEntity _living;
                if (var47 instanceof JogoEntity && entity.getPersistentData().getDouble("cnt_target") > 6.0) {
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob) entity;
                        var47 = _mobEnt.getTarget();
                    } else {
                        var47 = null;
                    }

                    if (var47.getPersistentData().getDouble("skill") == 415.0) {
                        if (!entity.getPersistentData().getBoolean("flag2")) {
                            entity.getPersistentData().putBoolean("flag2", true);
                        }

                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity) entity;
                            if (!_entity.level().isClientSide()) {
                                _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 10, 0, false, false));
                            }
                        }

                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity) entity;
                            if (!_entity.level().isClientSide()) {
                                _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 10, 0, false, false));
                            }
                        }
                    } else if (entity.getPersistentData().getBoolean("flag2")) {
                        if (GetDistanceProcedure.execute(world, entity) < 32.0) {
                            if (GetDistanceProcedure.execute(world, entity) < 6.0 && entity.onGround()) {
                                if (entity instanceof LivingEntity) {
                                    _entity = (LivingEntity) entity;
                                    _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                                }

                                entity.getPersistentData().putBoolean("PRESS_S", true);
                                WhenBackStepProcedure.execute(world, entity);
                                entity.getPersistentData().putBoolean("PRESS_S", false);
                            }

                            if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity) entity;
                                _entity.removeEffect(MobEffects.MOVEMENT_SPEED);
                            }

                            if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity) entity;
                                if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
                                }
                            }

                            if (entity instanceof Mob) {
                                _mobEnt = (Mob) entity;
                                var47 = _mobEnt.getTarget();
                            } else {
                                var47 = null;
                            }

                            _living = var47;
                            if (_living instanceof LivingEntity) {
                                _livEnt122 = (LivingEntity) _living;
                                _livEnt122.removeEffect(MobEffects.MOVEMENT_SPEED);
                            }

                            if (entity instanceof Mob) {
                                _mobEnt = (Mob) entity;
                                var47 = _mobEnt.getTarget();
                            } else {
                                var47 = null;
                            }

                            _living = var47;
                            if (_living instanceof LivingEntity) {
                                _livEnt122 = (LivingEntity) _living;
                                if (!_livEnt122.level().isClientSide()) {
                                    _livEnt122.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
                                }
                            }

                            if (entity instanceof Mob) {
                                _mobEnt = (Mob) entity;
                                var47 = _mobEnt.getTarget();
                            } else {
                                var47 = null;
                            }

                            _living = var47;
                            if (_living instanceof LivingEntity) {
                                _livEnt122 = (LivingEntity) _living;
                                if (!_livEnt122.level().isClientSide()) {
                                    _livEnt122.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 10, 0, false, false));
                                }
                            }
                        }

                        if (entity instanceof Mob) {
                            _mobEnt = (Mob) entity;
                            var47 = _mobEnt.getTarget();
                        } else {
                            var47 = null;
                        }

                        if (var47.isPassenger()) {
                            if (entity instanceof Mob) {
                                _mobEnt = (Mob) entity;
                                var47 = _mobEnt.getTarget();
                            } else {
                                var47 = null;
                            }

                            if (var47.getVehicle() instanceof MeteorEntity) {
                                if (entity instanceof LivingEntity) {
                                    _living = (LivingEntity) entity;
                                    if (!_living.level().isClientSide()) {
                                        _living.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 10, 0, false, false));
                                    }
                                }

                                if (entity instanceof LivingEntity) {
                                    _living = (LivingEntity) entity;
                                    if (!_living.level().isClientSide()) {
                                        _living.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 10, 0, false, false));
                                    }
                                }
                            }
                        }
                    }
                }

                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var47 = _mobEnt.getTarget();
                } else {
                    var47 = null;
                }

                if (var47 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") > 6.0) {
                    float var10001;
                    LivingEntity _livEnt;
                    float var50;
                    double var51;
                    if (fushiguro_body) {
                        label749:
                        {
                            if (entity instanceof SukunaFushiguroEntity) {
                                _datEntL88 = (SukunaFushiguroEntity) entity;
                                if ((Boolean) _datEntL88.getEntityData().get(SukunaFushiguroEntity.DATA_perfect_mode)) {
                                    break label749;
                                }
                            }

                            if (entity instanceof Mob) {
                                _mobEnt = (Mob) entity;
                                var47 = _mobEnt.getTarget();
                            } else {
                                var47 = null;
                            }

                            if (!(var47 instanceof GojoSatoruEntity)) {
                                if (entity instanceof LivingEntity) {
                                    _livEnt122 = (LivingEntity) entity;
                                    var50 = _livEnt122.getHealth();
                                } else {
                                    var50 = -1.0F;
                                }

                                var51 = (double) var50;
                                if (entity instanceof LivingEntity) {
                                    _living = (LivingEntity) entity;
                                    var10001 = _living.getMaxHealth();
                                } else {
                                    var10001 = -1.0F;
                                }

                                if (var51 <= (double) var10001 * 0.3 && !var47.hasEffect(JujutsucraftaddonModMobEffects.BINDING_VOW_COOLDOWN.get())) {
                                    if (entity instanceof LivingEntity _liv1 && !_liv1.hasEffect(JujutsucraftaddonModMobEffects.BINDING_VOW_COOLDOWN.get())){
                                        SukunaFushiguroEntity animatable;
                                        if (entity instanceof SukunaFushiguroEntity) {
                                            animatable = (SukunaFushiguroEntity) entity;
                                            animatable.getEntityData().set(SukunaFushiguroEntity.DATA_perfect_mode, true);
                                        }

                                        if (entity instanceof SukunaFushiguroEntity) {
                                            animatable = (SukunaFushiguroEntity) entity;
                                            animatable.setTexture("sukuna_perfect");
                                        }

                                        if (entity instanceof SukunaFushiguroEntity) {
                                            if (!((((SukunaFushiguroEntity) entity).animationprocedure).equals("heianform"))) {
                                                ((SukunaFushiguroEntity) entity).setAnimation("heianform");
                                            }
                                        }
                                        if (entity instanceof SukunaFushiguroEntity) {
                                            if (entity instanceof LivingEntity _entity6 && !_entity6.level().isClientSide())
                                                _entity6.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANIMATION_HEIAN.get(), 40, 1, false, false));

                                            {
                                                final Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());
                                                List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                                                for (Entity entityiterator : _entfound) {

                                                    {
                                                        Entity _ent = entity;
                                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                                                    _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "particle jjkueffects:red_awakening_2 ~ ~-1 ~ 0 0 0 1 1 force");
                                                        }
                                                    }

                                                    if (entityiterator instanceof Player _player && !_player.level().isClientSide())
                                                        _player.displayClientMessage(Component.literal("Like a Calamity, The Strongest Sorcerer from History, Awakens"), false);
                                                }

                                            }
                                        }

                                        if (entity instanceof LivingEntity) {
                                            _livEnt = (LivingEntity) entity;
                                            if (!_livEnt.level().isClientSide()) {
                                                _livEnt.addEffect(new MobEffectInstance(MobEffects.HEAL, 10, 10, false, false));
                                            }
                                        }

                                        if (!entity.level().isClientSide() && entity.getServer() != null) {
                                            entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s weapon.offhand with jujutsucraft:supreme_martial_solution");
                                        }

                                        if (!entity.level().isClientSide() && entity.getServer() != null) {
                                            entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s armor.chest with jujutsucraft:sukuna_body_chestplate");
                                        }

                                        if (entity instanceof LivingEntity) {
                                            _livEnt = (LivingEntity) entity;
                                            _livEnt.removeEffect(MobEffects.DAMAGE_BOOST);
                                        }

                                        entity.getPersistentData().putDouble("cnt_reverse_lim", 0.0);
                                        entity.getPersistentData().putDouble("skill", 1.0);
                                        ReturnShadowProcedure.execute(world, x, y, z, entity);
                                        entity.getPersistentData().putDouble("skill", 0.0);
                                        if (item_head.getItem() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                                            if (entity instanceof Player) {
                                                Player _player = (Player) entity;
                                                _player.getInventory().armor.set(3, ItemStack.EMPTY);
                                                _player.getInventory().setChanged();
                                            } else if (entity instanceof LivingEntity) {
                                                _livEnt = (LivingEntity) entity;
                                                _livEnt.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (entity instanceof Mob) {
                        _mobEnt = (Mob) entity;
                        var47 = _mobEnt.getTarget();
                    } else {
                        var47 = null;
                    }

                    boolean var52;
                    label667:
                    {
                        _livEnt122 = var47;
                        if (_livEnt122 instanceof LivingEntity) {
                            _livEnt109 = (LivingEntity) _livEnt122;
                            if (_livEnt109.hasEffect((MobEffect) JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                                var52 = true;
                                break label667;
                            }
                        }

                        var52 = false;
                    }
                    infinity = var52;
                    entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                    entity.getPersistentData().putDouble("cnt_rest", 0.0);
                    if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                        label779:
                        {
                            mahoraga_exist = entity.getPersistentData().getDouble("TenShadowsTechnique14") == -1.0;
                            if (entity instanceof Mob) {
                                _mobEnt = (Mob) entity;
                                var47 = _mobEnt.getTarget();
                            } else {
                                var47 = null;
                            }

                            vsMahoraga = var47 instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
                            distance = GetDistanceProcedure.execute(world, entity);
                            if (vsMahoraga && entity.getPersistentData().getDouble("cnt_target") >= 2400.0 && entity.getPersistentData().getDouble("cnt_target") <= 3600.0) {
                                entity.getPersistentData().putBoolean("flag_domain", true);
                            }

                            domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity) && !mahoraga_exist;
                            ResetCounterProcedure.execute(entity);
                            if (fushiguro_body) {
                                label654:
                                {
                                    if (entity instanceof SukunaFushiguroEntity) {
                                        _datEntL88 = (SukunaFushiguroEntity) entity;
                                        if ((Boolean) _datEntL88.getEntityData().get(SukunaFushiguroEntity.DATA_perfect_mode)) {
                                            break label654;
                                        }
                                    }

                                    if (entity.getPersistentData().getDouble("cnt_target") > 200.0 && gojosatoru && entity.getPersistentData().getDouble("TenShadowsTechnique14") >= 1.0 && item_head.getItem() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                                        if (entity instanceof Player) {
                                            Player _player = (Player) entity;
                                            _player.getInventory().armor.set(3, new ItemStack((ItemLike) JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()));
                                            _player.getInventory().setChanged();
                                        } else if (entity instanceof LivingEntity) {
                                            _living = (LivingEntity) entity;
                                            _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike) JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()));
                                            _living = (LivingEntity) entity;
                                            _living.setItemSlot(EquipmentSlot.CHEST, new ItemStack((ItemLike) JujutsucraftModItems.CLOTHES_SUKUNA_FUSHIGURO_CHESTPLATE.get()));
                                        }
                                    } else if (entity.getPersistentData().getDouble("cnt_target") > 200.0 && var47 instanceof YorozuEntity && entity.getPersistentData().getDouble("TenShadowsTechnique14") >= 1.0 && item_head.getItem() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                                        if (entity instanceof Player) {
                                            Player _player = (Player) entity;
                                            _player.getInventory().armor.set(3, new ItemStack((ItemLike) JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()));
                                            _player.getInventory().setChanged();
                                        } else if (entity instanceof LivingEntity _liv1 && _liv1.getHealth() <= _liv1.getMaxHealth() / 1.1) {
                                            _living = (LivingEntity) entity;
                                            _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike) JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()));

                                        }
                                    } else if (entity.getPersistentData().getDouble("cnt_target") > 200.0 && entity.getPersistentData().getDouble("TenShadowsTechnique14") >= 1.0 && item_head.getItem() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                                       if (entity instanceof LivingEntity _liv1 && _liv1.getHealth() <= _liv1.getMaxHealth() / 1.1) {
                                           _living = (LivingEntity) entity;
                                           _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike) JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()));
                                       }
                                    }

                                }
                            }

                            label649:
                            {
                                label648:
                                {
                                    if (!entity.getPersistentData().getBoolean("flag1") && entity instanceof LivingEntity) {
                                        _livEnt109 = (LivingEntity) entity;
                                        if (_livEnt109.hasEffect((MobEffect) JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                            break label648;
                                        }
                                    }

                                    if (!entity.getPersistentData().getBoolean("flag2")) {
                                        break label649;
                                    }
                                }

                                if (distance < 48.0 && entity instanceof LivingEntity) {
                                    _entity = (LivingEntity) entity;
                                    if (!_entity.level().isClientSide()) {
                                        _entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 20, 0, false, false));
                                    }
                                }
                            }

                            int var54;
                            label770:
                            {
                                if (fushiguro_body) {
                                    label784:
                                    {
                                        if (entity instanceof SukunaFushiguroEntity) {
                                            _datEntL88 = (SukunaFushiguroEntity) entity;
                                            if ((Boolean) _datEntL88.getEntityData().get(SukunaFushiguroEntity.DATA_perfect_mode)) {
                                                break label784;
                                            }
                                        }

                                        boolean var49;
                                        CompoundTag var53;
                                        label629:
                                        {
                                            entity.getPersistentData().putBoolean("flag_mahoraga", entity.getPersistentData().getDouble("TenShadowsTechnique14") > 0.0);
                                            var53 = entity.getPersistentData();
                                            if (entity.getPersistentData().getBoolean("flag_mahoraga")) {
                                                float var10002;
                                                if (entity instanceof LivingEntity) {
                                                    _livEnt122 = (LivingEntity) entity;
                                                    var10002 = _livEnt122.getHealth();
                                                } else {
                                                    var10002 = -1.0F;
                                                }

                                                double var48 = (double) var10002;
                                                float var10003;
                                                if (entity instanceof LivingEntity) {
                                                    _entity = (LivingEntity) entity;
                                                    var10003 = _entity.getMaxHealth();
                                                } else {
                                                    var10003 = -1.0F;
                                                }

                                                if (var48 < (double) var10003 * 0.6 || item_head.getOrCreateTag().getDouble("skill205") >= 100.0 && infinity) {
                                                    var49 = true;
                                                    break label629;
                                                }
                                            }

                                            var49 = false;
                                        }

                                        var53.putBoolean("flag_mahoraga", var49);
                                        if (entity instanceof LivingEntity) {
                                            _entity = (LivingEntity) entity;
                                            var50 = _entity.getHealth();
                                        } else {
                                            var50 = -1.0F;
                                        }

                                        var51 = (double) var50;
                                        if (entity instanceof LivingEntity) {
                                            _livEnt122 = (LivingEntity) entity;
                                            var10001 = _livEnt122.getMaxHealth();
                                        } else {
                                            var10001 = -1.0F;
                                        }

                                        if (var51 > (double) var10001 * 0.6) {
                                            if (entity instanceof Mob) {
                                                _mobEnt = (Mob) entity;
                                                var47 = _mobEnt.getTarget();
                                            } else {
                                                var47 = null;
                                            }

                                            if (var47 instanceof GojoSatoruEntity) {
                                                label615:
                                                {
                                                    if (entity instanceof LivingEntity) {
                                                        _livEnt = (LivingEntity) entity;
                                                        if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                                                            var54 = _livEnt.getEffect((MobEffect) JujutsucraftModMobEffects.BRAIN_DAMAGE.get()).getAmplifier();
                                                            break label615;
                                                        }
                                                    }

                                                    var54 = 0;
                                                }

                                                if (var54 < 1) {
                                                    entity.getPersistentData().putBoolean("flag_mahoraga", false);
                                                }
                                            }
                                        }
                                        break label770;
                                    }
                                }

                                entity.getPersistentData().putBoolean("flag_mahoraga", false);
                            }

                            label771:
                            {
                                if (fushiguro_body) {
                                    label757:
                                    {
                                        if (entity instanceof SukunaFushiguroEntity) {
                                            SukunaFushiguroEntity _datEntL103 = (SukunaFushiguroEntity) entity;
                                            if ((Boolean) _datEntL103.getEntityData().get(SukunaFushiguroEntity.DATA_perfect_mode)) {
                                                break label757;
                                            }
                                        }

                                        label782:
                                        {
                                            if (entity.getPersistentData().getBoolean("flag_mahoraga") || Math.random() < 0.2 && !infinity) {
                                                label781:
                                                {
                                                    if (entity instanceof LivingEntity) {
                                                        _livEnt109 = (LivingEntity) entity;
                                                        if (_livEnt109.hasEffect((MobEffect) JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                            break label781;
                                                        }
                                                    }

                                                    if (!domain && entity.getPersistentData().getDouble("TenShadowsTechnique14") >= 1.0) {
                                                        break label782;
                                                    }
                                                }
                                            }

                                            if (!entity.getPersistentData().getBoolean("flag_agito") || !(entity.getPersistentData().getDouble("TenShadowsTechnique13") >= 0.0)) {
                                                var52 = false;
                                                break label771;
                                            }
                                        }

                                        var52 = true;
                                        break label771;
                                    }
                                }

                                var52 = false;
                            }

                            label582:
                            {
                                flag_megumiTechnique = var52;
                                if (LogicStartProcedure.execute(entity)) {
                                    if (Math.random() > (double) (infinity ? 1 : 0) && distance < 48.0) {
                                        break label582;
                                    }

                                    if (entity instanceof LivingEntity) {
                                        _livEnt109 = (LivingEntity) entity;
                                        if (_livEnt109.hasEffect(MobEffects.HUNGER)) {
                                            break label582;
                                        }
                                    }

                                    if (flag_megumiTechnique) {
                                        break label582;
                                    }
                                }

                                if (!domain) {
                                    entity.getPersistentData().putDouble("cnt_x", 0.0);
                                    CalculateAttackProcedure.execute(world, x, y, z, entity);
                                    break label779;
                                }
                            }

                            if (flag_megumiTechnique) {
                                AIFushiguroMegumiProcedure.execute(world, x, y, z, entity);
                            } else {
                                entity.getPersistentData().putDouble("cnt_x", 0.0);
                                if (domain) {
                                    rnd = 20.0;
                                    tick = 20.0;
                                } else {
                                    if (entity.getPersistentData().getBoolean("flag2")) {
                                        if (entity instanceof Mob) {
                                            _mobEnt = (Mob) entity;
                                            var47 = _mobEnt.getTarget();
                                        } else {
                                            var47 = null;
                                        }

                                        label517:
                                        {
                                            _entity = var47;
                                            if (_entity instanceof LivingEntity) {
                                                _livEnt = (LivingEntity) _entity;
                                                if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                                    var54 = _livEnt.getEffect((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getDuration();
                                                    break label517;
                                                }
                                            }

                                            var54 = 0;
                                        }

                                        if (var54 <= 20) {
                                            if (entity instanceof Mob) {
                                                _mobEnt = (Mob) entity;
                                                var47 = _mobEnt.getTarget();
                                            } else {
                                                var47 = null;
                                            }

                                            label510:
                                            {
                                                _entity = var47;
                                                if (_entity instanceof LivingEntity) {
                                                    _livEnt = (LivingEntity) _entity;
                                                    if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get())) {
                                                        var54 = _livEnt.getEffect((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get()).getDuration();
                                                        break label510;
                                                    }
                                                }

                                                var54 = 0;
                                            }

                                            if (var54 <= 20) {
                                                entity.getPersistentData().putBoolean("flag2", false);
                                                rnd = 7.0;
                                                tick = 250.0;
                                                if (entity instanceof LivingEntity) {
                                                    _entity = (LivingEntity) entity;
                                                    _entity.removeEffect((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME.get());
                                                }

                                                if (entity instanceof LivingEntity) {
                                                    _entity = (LivingEntity) entity;
                                                    _entity.removeEffect((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get());
                                                }
                                            }
                                        }
                                    } else {
                                        label741:
                                        {
                                            if (!entity.getPersistentData().getBoolean("flag1")) {
                                                if (entity instanceof Mob) {
                                                    _mobEnt = (Mob) entity;
                                                    var47 = _mobEnt.getTarget();
                                                } else {
                                                    var47 = null;
                                                }

                                                if (!(var47 instanceof GojoSatoruEntity) && entity instanceof LivingEntity) {
                                                    _livEnt122 = (LivingEntity) entity;
                                                    if (_livEnt122.hasEffect((MobEffect) JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().getBoolean("Failed")) {
                                                        entity.getPersistentData().putBoolean("flag1", true);
                                                        rnd = 7.0;
                                                        tick = 250.0;
                                                        break label741;
                                                    }
                                                }
                                            }

                                            for (int index1 = 0; index1 < 256; ++index1) {
                                                rnd = (double) Mth.nextInt(RandomSource.create(), 5, 8);
                                                if (rnd == 8.0) {
                                                    rnd = 20.0;
                                                }

                                                if (rnd == 5.0) {
                                                    tick = 50.0;
                                                    break;
                                                }

                                                if (rnd == 6.0) {
                                                    tick = 100.0;
                                                    if (!(Math.random() < 0.5) && !infinity && !vsMahoraga) {
                                                        if (entity instanceof Mob) {
                                                            _mobEnt = (Mob) entity;
                                                            var47 = _mobEnt.getTarget();
                                                        } else {
                                                            var47 = null;
                                                        }

                                                        if (!(var47 instanceof GojoSatoruEntity)) {
                                                            if (entity instanceof Mob) {
                                                                _mobEnt = (Mob) entity;
                                                                var47 = _mobEnt.getTarget();
                                                            } else {
                                                                var47 = null;
                                                            }

                                                            if (!(var47 instanceof JogoEntity) && !(distance > 4.0)) {
                                                                break;
                                                            }
                                                        }
                                                    }
                                                } else if (rnd == 7.0) {
                                                    tick = 250.0;
                                                    if (!infinity) {
                                                        if (entity instanceof Mob) {
                                                            _mobEnt = (Mob) entity;
                                                            var47 = _mobEnt.getTarget();
                                                        } else {
                                                            var47 = null;
                                                        }

                                                        if (!(var47 instanceof GojoSatoruEntity)) {
                                                            if (entity instanceof Mob) {
                                                                _mobEnt = (Mob) entity;
                                                                var47 = _mobEnt.getTarget();
                                                            } else {
                                                                var47 = null;
                                                            }

                                                            if (!(var47 instanceof JogoEntity) && !(entity.getPersistentData().getDouble("cnt_target") <= 1200.0) && (!vsMahoraga || entity.getPersistentData().getBoolean("flag1")) && !(Math.random() < 0.9) && !(distance < 8.0)) {
                                                                break;
                                                            }
                                                        }
                                                    }
                                                } else if (rnd == 20.0) {
                                                    tick = 20.0;
                                                    if (!mahoraga_exist && !AIDomainLogicProcedure.execute(world, x, y, z, entity)) {
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                                if (!(rnd > 0.0)) {
                                    CalculateAttackProcedure.execute(world, x, y, z, entity);
                                } else {
                                    if (rnd == 20.0) {
                                        label503:
                                        {
                                            if (entity instanceof LivingEntity) {
                                                _entity = (LivingEntity) entity;
                                                if (_entity.hasEffect((MobEffect) JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                                                    break label503;
                                                }
                                            }

                                            entity.getPersistentData().putDouble("skill", 1.0);
                                            ReturnShadowProcedure.execute(world, x, y, z, entity);
                                        }
                                    }

                                    if (mahoraga_exist && rnd == 7.0) {
                                        tick = 100.0;
                                        entity.getPersistentData().putDouble("skill", 1007.0);
                                    } else {
                                        if (entity instanceof SukunaFushiguroEntity) {
                                            if (gojosatoru || entity instanceof LivingEntity _liv && _liv.getHealth() <= _liv.getMaxHealth() / 2 || entity instanceof SukunaFushiguroEntity _liv2 && _liv2.getEntityData().get(SukunaFushiguroEntity.DATA_perfect_mode)) {
                                                if (entity instanceof LivingEntity _entity1) {
                                                    if (_entity1.hasEffect((MobEffect) JujutsucraftaddonModMobEffects.BINDING_VOW_COOLDOWN.get()) && (entity.getPersistentData().getDouble("TenShadowsTechnique14") == -2.0)) {
                                                        if (rnd == 5) {
                                                            entity.getPersistentData().putDouble("cnt6", 30);
                                                            entity.getPersistentData().putBoolean("flag_dismantle", true);
                                                        }
                                                        entity.getPersistentData().putDouble("skill", 100.0 + rnd);
                                                    } else {
                                                        entity.getPersistentData().putDouble("skill", 100.0 + rnd);
                                                    }
                                                }
                                            } else if (var47 instanceof YorozuEntity || entity instanceof SukunaFushiguroEntity _liv && !_liv.getEntityData().get(SukunaFushiguroEntity.DATA_perfect_mode)) {
                                                if (domain) {
                                                    entity.getPersistentData().putDouble("skill", 620.0);
                                                } else if (entity instanceof LivingEntity _liv && _liv.getHealth() <= _liv.getMaxHealth() / 1.5 && item_head.getItem() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                                                    entity.getPersistentData().putDouble("skill", 618.0);
                                                } else {
                                                    if (Math.random() < (1) / ((float) 20)) {
                                                        TenShadowsRegisterProcedure.execute(entity);
                                                        entity.getPersistentData().putDouble("skill", 600 + Mth.nextInt(RandomSource.create(), 7, 14));
                                                    } else if (Math.random() < (1) / ((float) 10)) {
                                                        entity.getPersistentData().putDouble("skill", 1007.0);
                                                    } else {
                                                        entity.getPersistentData().putDouble("skill", Mth.nextInt(RandomSource.create(), -97, -96));
                                                    }
                                                }
                                            }
                                        } else {
                                            entity.getPersistentData().putDouble("skill", 100.0 + rnd);
                                        }
                                    }

                                    if (entity instanceof LivingEntity) {
                                        _entity = (LivingEntity) entity;
                                        if (!_entity.level().isClientSide()) {
                                            _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int) tick / 2, 0, false, false));
                                        }
                                    }

                                    if (entity instanceof LivingEntity) {
                                        _entity = (LivingEntity) entity;
                                        if (!_entity.level().isClientSide()) {
                                            _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _livEnt109 = (LivingEntity) entity;
                        if (_livEnt109.hasEffect((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get())) {
                            entity.getPersistentData().putBoolean("flag1", false);
                        }
                    }
                } else {
                    entity.getPersistentData().putBoolean("flag2", false);
                    entity.getPersistentData().putDouble("cnt_x", 0.0);
                    entity.getPersistentData().putDouble("cnt_rest", entity.getPersistentData().getDouble("cnt_rest") + 1.0);
                    if (entity.getPersistentData().getDouble("cnt_rest") > 120.0) {
                        entity.getPersistentData().putDouble("cnt_rest", 0.0);
                        entity.getPersistentData().putDouble("skill", 1.0);
                        ReturnShadowProcedure.execute(world, x, y, z, entity);
                        entity.getPersistentData().putDouble("skill", 0.0);
                    }
                }
            }
        }
    }
}