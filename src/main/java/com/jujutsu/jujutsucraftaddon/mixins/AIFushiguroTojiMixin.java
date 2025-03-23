package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import com.jujutsu.jujutsucraftaddon.procedures.DomainBreakerTojiProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.SixEyesCutProcedure;
import net.mcreator.jujutsucraft.entity.FushiguroTojiBugEntity;
import net.mcreator.jujutsucraft.entity.FushiguroTojiEntity;
import net.mcreator.jujutsucraft.entity.GojoSatoruEntity;
import net.mcreator.jujutsucraft.entity.GojoSatoruSchoolDaysEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.AIActiveProcedure;
import net.mcreator.jujutsucraft.procedures.AIFushiguroTojiProcedure;
import net.mcreator.jujutsucraft.procedures.CalculateAttackProcedure;
import net.mcreator.jujutsucraft.procedures.ResetCounterProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
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
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = AIFushiguroTojiProcedure.class, priority = -10000)
public class AIFushiguroTojiMixin {

    @Inject(method = "execute", at = @At("HEAD"), remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();
        if (entity != null) {
            ItemStack setItemA = ItemStack.EMPTY;
            boolean StrongEnemy = false;
            boolean awaked = false;
            double rnd = 0.0;
            double level_strength = 0.0;
            double level_resistance = 0.0;
            double level_physical_gifted = 0.0;
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
                LivingEntity _livEnt5;
                LivingEntity _entGetArmor;
                label221:
                {
                    if (entity instanceof  LivingEntity _12 &&  !_12.hasEffect(JujutsucraftaddonModMobEffects.QUAKE.get())) {
                        AIActiveProcedure.execute(world, x, y, z, entity);
                    }
                    if (entity instanceof LivingEntity) {
                        _livEnt5 = (LivingEntity) entity;
                        if (_livEnt5.hasEffect(MobEffects.DAMAGE_BOOST)) {
                            break label221;
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _entGetArmor = (LivingEntity) entity;
                        if (!_entGetArmor.level().isClientSide()) {
                            _entGetArmor.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, Integer.MAX_VALUE, 29, false, false));
                        }
                    }
                }

                label216:
                {
                    if (entity instanceof LivingEntity) {
                        _livEnt5 = (LivingEntity) entity;
                        if (_livEnt5.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                            break label216;
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _entGetArmor = (LivingEntity) entity;
                        if (!_entGetArmor.level().isClientSide()) {
                            _entGetArmor.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 3, false, false));
                        }
                    }
                }

                label211:
                {
                    if (entity instanceof LivingEntity) {
                        _livEnt5 = (LivingEntity) entity;
                        if (_livEnt5.hasEffect((MobEffect) JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                            break label211;
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _entGetArmor = (LivingEntity) entity;
                        if (!_entGetArmor.level().isClientSide()) {
                            _entGetArmor.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get(), Integer.MAX_VALUE, 4, false, false));
                        }
                    }
                }

                LivingEntity var10000;
                if (entity instanceof Mob) {
                    Mob _mobEnt = (Mob) entity;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                if (var10000 instanceof LivingEntity) {
                    entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                    if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0 && entity instanceof LivingEntity _1 && !_1.hasEffect(JujutsucraftaddonModMobEffects.QUAKE.get())) {
                        if (var10000.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get())) {
                            DomainBreakerTojiProcedure.execute(world, x, y, z, entity);
                        }

                        if ((entity instanceof LivingEntity _entGetArmor1 ? _entGetArmor1.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == JujutsucraftModItems.CURSED_SPIRIT_ARMOURY_CHESTPLATE.get()) {
                            if (Math.random() < (1) / ((float) 90)) {
                                SixEyesCutProcedure.execute(world, x, y, z, entity);
                            }
                        }

                        if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftModItems.PLAYFUL_CLOUD.get() && entity instanceof FushiguroTojiBugEntity) {
                            if (Math.random() < (1) / ((float) 80)) {
                                if (var10000 != null) {
                                    {
                                        Entity _ent = entity;
                                        _ent.teleportTo((var10000.getX()), (var10000.getY() + 1), (var10000.getZ() - 1));
                                        if (_ent instanceof ServerPlayer _serverPlayer)
                                            _serverPlayer.connection.teleport((var10000.getX()), (var10000.getY() + 1), (var10000.getZ() - 1), _ent.getYRot(), _ent.getXRot());
                                    }
                                    if (world instanceof ServerLevel _level)
                                        _level.sendParticles(JujutsucraftaddonModParticleTypes.BLOOD_RED.get(), (var10000.getX()), (var10000.getY()), (var10000.getZ()), 2, 0, 0, 0, 1);
                                    if (!var10000.level().isClientSide())
                                        var10000.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.RCT_CUT.get(), 60, 1, false, false));
                                    if (!var10000.level().isClientSide())
                                        var10000.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 1, false, false));
                                    if (!var10000.level().isClientSide())
                                        var10000.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.UNSTABLE.get(), 60, 1, false, false));
                                    var10000.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))),
                                            40);
                                }
                            }

                        }

                        if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftModItems.SPLIT_SOUL_KATANA.get()) {
                            if (Math.random() < (1) / ((float) 80)) {
                                if (var10000 != null) {
                                    if (entity instanceof FushiguroTojiEntity) {
                                        if (!((((FushiguroTojiEntity) entity).animationprocedure).equals("splitsoulpierce"))) {
                                            ((FushiguroTojiEntity) entity).setAnimation("splitsoulpierce");
                                        }
                                    }
                                    {
                                        Entity _ent = entity;
                                        _ent.teleportTo((var10000.getX()), (var10000.getY() + 1), (var10000.getZ() - 1));
                                        if (_ent instanceof ServerPlayer _serverPlayer)
                                            _serverPlayer.connection.teleport((var10000.getX()), (var10000.getY() + 1), (var10000.getZ() - 1), _ent.getYRot(), _ent.getXRot());
                                    }
                                    if (world instanceof ServerLevel _level)
                                        _level.sendParticles(JujutsucraftaddonModParticleTypes.BLOOD_RED.get(), (var10000.getX()), (var10000.getY()), (var10000.getZ()), 2, 0, 0, 0, 1);
                                    if (!var10000.level().isClientSide())
                                        var10000.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.RCT_CUT.get(), 60, 1, false, false));
                                    if (!var10000.level().isClientSide())
                                        var10000.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 1, false, false));
                                    if (!var10000.level().isClientSide())
                                        var10000.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.UNSTABLE.get(), 60, 1, false, false));
                                    var10000.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))),
                                            40);
                                }
                            }

                        }
                        entity.getPersistentData().putDouble("cnt_x", 5.0);
                        ResetCounterProcedure.execute(entity);
                        CalculateAttackProcedure.execute(world, x, y, z, entity);
                        if (entity instanceof FushiguroTojiEntity) {
                            LivingEntity _livEnt37;
                            if (!entity.getPersistentData().getBoolean("Armoury")) {
                                entity.getPersistentData().putBoolean("Armoury", true);
                                if (entity instanceof Player) {
                                    Player _player = (Player) entity;
                                    _player.getInventory().armor.set(2, new ItemStack((ItemLike) JujutsucraftModItems.CURSED_SPIRIT_ARMOURY_CHESTPLATE.get()));
                                    _player.getInventory().setChanged();
                                } else if (entity instanceof LivingEntity) {
                                    _livEnt37 = (LivingEntity) entity;
                                    _livEnt37.setItemSlot(EquipmentSlot.CHEST, new ItemStack((ItemLike) JujutsucraftModItems.CURSED_SPIRIT_ARMOURY_CHESTPLATE.get()));
                                }

                                entity.getPersistentData().putBoolean("HasWeapon1", true);
                                entity.getPersistentData().putBoolean("HasWeapon2", true);
                                entity.getPersistentData().putBoolean("HasWeapon3", true);
                            }

                            if (entity.getPersistentData().getDouble("skill") != 0.0) {
                                ItemStack var29;
                                if (entity instanceof LivingEntity) {
                                    _entGetArmor = (LivingEntity) entity;
                                    var29 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                                } else {
                                    var29 = ItemStack.EMPTY;
                                }

                                if (var29.getItem() == JujutsucraftModItems.CURSED_SPIRIT_ARMOURY_CHESTPLATE.get()) {
                                    ItemStack var10002;
                                    CompoundTag var30;
                                    boolean var31;
                                    LivingEntity _entity;
                                    label197:
                                    {
                                        var30 = entity.getPersistentData();
                                        if (!entity.getPersistentData().getBoolean("HasWeapon1")) {
                                            if (entity instanceof LivingEntity) {
                                                _entity = (LivingEntity) entity;
                                                var10002 = _entity.getMainHandItem();
                                            } else {
                                                var10002 = ItemStack.EMPTY;
                                            }

                                            if (var10002.getItem() != JujutsucraftModItems.PLAYFUL_CLOUD.get()) {
                                                var31 = false;
                                                break label197;
                                            }
                                        }

                                        var31 = true;
                                    }

                                    label191:
                                    {
                                        var30.putBoolean("HasWeapon1", var31);
                                        var30 = entity.getPersistentData();
                                        if (!entity.getPersistentData().getBoolean("HasWeapon2")) {
                                            if (entity instanceof LivingEntity) {
                                                _entity = (LivingEntity) entity;
                                                var10002 = _entity.getMainHandItem();
                                            } else {
                                                var10002 = ItemStack.EMPTY;
                                            }

                                            if (var10002.getItem() != JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get()) {
                                                var31 = false;
                                                break label191;
                                            }
                                        }

                                        var31 = true;
                                    }

                                    label185:
                                    {
                                        var30.putBoolean("HasWeapon2", var31);
                                        var30 = entity.getPersistentData();
                                        if (!entity.getPersistentData().getBoolean("HasWeapon3")) {
                                            if (entity instanceof LivingEntity) {
                                                _entity = (LivingEntity) entity;
                                                var10002 = _entity.getMainHandItem();
                                            } else {
                                                var10002 = ItemStack.EMPTY;
                                            }

                                            if (var10002.getItem() != JujutsucraftModItems.SPLIT_SOUL_KATANA.get()) {
                                                var31 = false;
                                                break label185;
                                            }
                                        }

                                        var31 = true;
                                    }

                                    var30.putBoolean("HasWeapon3", var31);
                                    if (entity instanceof Mob) {
                                        Mob _mobEnt = (Mob) entity;
                                        var10000 = _mobEnt.getTarget();
                                    } else {
                                        var10000 = null;
                                    }

                                    label229:
                                    {
                                        LivingEntity _livEnt;
                                        label230:
                                        {
                                            _livEnt = var10000;
                                            if (_livEnt instanceof LivingEntity) {
                                                _livEnt37 = (LivingEntity) _livEnt;
                                                if (_livEnt37.hasEffect((MobEffect) JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                                                    break label230;
                                                }
                                            }

                                            if (entity instanceof Mob) {
                                                Mob _mobEnt = (Mob) entity;
                                                var10000 = _mobEnt.getTarget();
                                            } else {
                                                var10000 = null;
                                            }

                                            if (!(var10000 instanceof GojoSatoruSchoolDaysEntity)) {
                                                if (entity instanceof Mob) {
                                                    Mob _mobEnt = (Mob) entity;
                                                    var10000 = _mobEnt.getTarget();
                                                } else {
                                                    var10000 = null;
                                                }

                                                if (!(var10000 instanceof GojoSatoruEntity)) {
                                                    setItemA = ItemStack.EMPTY.copy();
                                                    int index0 = 0;

                                                    while (true) {
                                                        if (index0 >= 16) {
                                                            break label229;
                                                        }

                                                        label165:
                                                        {
                                                            rnd = Math.ceil(Math.random() * 3.0);
                                                            if (rnd == 1.0) {
                                                                if (entity.getPersistentData().getBoolean("HasWeapon1")) {
                                                                    entity.getPersistentData().putBoolean("HasWeapon1", false);
                                                                    setItemA = (new ItemStack((ItemLike) JujutsucraftModItems.PLAYFUL_CLOUD.get())).copy();
                                                                }
                                                            } else if (rnd == 2.0) {
                                                                if (entity instanceof Mob) {
                                                                    Mob _mobEnt = (Mob) entity;
                                                                    var10000 = _mobEnt.getTarget();
                                                                } else {
                                                                    var10000 = null;
                                                                }

                                                                if (var10000.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:no_curse_power")))) {
                                                                    break label165;
                                                                }

                                                                if (entity instanceof Mob) {
                                                                    Mob _mobEnt = (Mob) entity;
                                                                    var10000 = _mobEnt.getTarget();
                                                                } else {
                                                                    var10000 = null;
                                                                }

                                                                if (var10000 instanceof Player) {
                                                                    if (entity instanceof Mob) {
                                                                        Mob _mobEnt = (Mob) entity;
                                                                        var10000 = _mobEnt.getTarget();
                                                                    } else {
                                                                        var10000 = null;
                                                                    }

                                                                    if (((JujutsucraftModVariables.PlayerVariables) var10000.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer < 100.0) {
                                                                        break label165;
                                                                    }
                                                                }

                                                                if (entity.getPersistentData().getBoolean("HasWeapon2")) {
                                                                    entity.getPersistentData().putBoolean("HasWeapon2", false);
                                                                    setItemA = (new ItemStack((ItemLike) JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get())).copy();
                                                                }
                                                            } else if (rnd == 3.0 && entity.getPersistentData().getBoolean("HasWeapon3")) {
                                                                entity.getPersistentData().putBoolean("HasWeapon3", false);
                                                                setItemA = (new ItemStack((ItemLike) JujutsucraftModItems.SPLIT_SOUL_KATANA.get())).copy();
                                                            }

                                                            if (setItemA.getItem() != ItemStack.EMPTY.getItem()) {
                                                                break label229;
                                                            }
                                                        }

                                                        ++index0;
                                                    }
                                                }
                                            }
                                        }

                                        if (entity instanceof LivingEntity) {
                                            _livEnt = (LivingEntity) entity;
                                            var29 = _livEnt.getMainHandItem();
                                        } else {
                                            var29 = ItemStack.EMPTY;
                                        }

                                        if (var29.getItem() != JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get() && entity.getPersistentData().getBoolean("HasWeapon2")) {
                                            entity.getPersistentData().putBoolean("HasWeapon2", false);
                                        }

                                        setItemA = (new ItemStack((ItemLike) JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get())).copy();
                                    }

                                    if (setItemA.getItem() != ItemStack.EMPTY.getItem() && entity instanceof LivingEntity) {
                                        _entity = (LivingEntity) entity;
                                        ItemStack _setstack = setItemA.copy();
                                        _setstack.setCount(1);
                                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                        if (_entity instanceof Player) {
                                            Player _player = (Player) _entity;
                                            _player.getInventory().setChanged();
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    entity.getPersistentData().putDouble("cnt_x", 0.0);
                }
            }

        }
    }
}
