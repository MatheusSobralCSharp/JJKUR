package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.entity.YutaCullingGamesEntity;
import net.mcreator.jujutsucraft.entity.*;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.*;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = AIOkkotsuProcedure.class, priority = -10000)
public abstract class AIOkkotsuMixin {

    /**
     * @author Satushi
     * @reason Adds The Spider Web Cleave to Sukuna Entity
     */

    @Inject(method = "execute", at = @At("HEAD"), remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            ItemStack ITEM1 = ItemStack.EMPTY;
            double rnd = 0.0;
            double tick = 0.0;
            double NUM_COPY = 0.0;
            double copyNum = 0.0;
            double distance = 0.0;
            double level_strength = 0.0;
            double level_resistance = 0.0;
            double level_physical_gifted = 0.0;
            boolean StrongEnemy = false;
            boolean PureLoveCannon = false;
            boolean use_copy = false;
            boolean domain = false;
            boolean awaked = false;
            boolean logicLocateRika = false;
            boolean canUseCopy = false;
            if (entity.isAlive()) {
                LivingEntity _livEnt;
                label607:
                {
                    AIActiveProcedure.execute(world, x, y, z, entity);
                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity) entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                            break label607;
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity) entity;
                        if (!_livEnt.level().isClientSide()) {
                            _livEnt.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, Integer.MAX_VALUE, (entity instanceof OkkotsuYutaCullingGameEntity || entity instanceof YutaCullingGamesEntity) ? 20 : 18, false, false));
                        }
                    }
                }

                label602:
                {
                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity) entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                            break label602;
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity) entity;
                        if (!_livEnt.level().isClientSide()) {
                            _livEnt.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 3, false, false));
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

                LivingEntity _entGetArmor;
                Entity _ent;
                CompoundTag _nbtTag;
                ItemStack var55;
                if (var10000 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") > 6.0) {
                    entity.getPersistentData().putDouble("cnt_rika", 0.0);
                    entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                    if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                        boolean var60;
                        label635:
                        {
                            entity.getPersistentData().putDouble("cnt_x", 0.0);
                            logicLocateRika = LocateRikaProcedure.execute(world, entity);
                            if (!logicLocateRika) {
                                label634:
                                {
                                    if (entity instanceof LivingEntity) {
                                        _livEnt = (LivingEntity) entity;
                                        if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().getBoolean("Failed")) {
                                            break label634;
                                        }
                                    }

                                    var60 = false;
                                    break label635;
                                }
                            }

                            var60 = true;
                        }

                        canUseCopy = var60;
                        Mob _mobEnt;
                        if (entity instanceof OkkotsuYutaCullingGameEntity || entity instanceof YutaCullingGamesEntity) {
                            CompoundTag var62 = entity.getPersistentData();
                            float var10002;
                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity) entity;
                                var10002 = _livEnt.getHealth();
                            } else {
                                var10002 = -1.0F;
                            }

                            double var57 = (double) var10002;
                            float var10003;
                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity) entity;
                                var10003 = _livEnt.getMaxHealth();
                            } else {
                                var10003 = -1.0F;
                            }

                            boolean var64;
                            label578:
                            {
                                label617:
                                {
                                    LivingEntity var42;
                                    if (!(var57 < (double) var10003 * 0.5)) {
                                        LivingEntity var58;
                                        if (entity instanceof Mob) {
                                            _mobEnt = (Mob) entity;
                                            var58 = _mobEnt.getTarget();
                                        } else {
                                            var58 = null;
                                        }

                                        if (!(var58 instanceof SukunaPerfectEntity)) {
                                            if (entity instanceof Mob) {
                                                _mobEnt = (Mob) entity;
                                                var58 = _mobEnt.getTarget();
                                            } else {
                                                var58 = null;
                                            }

                                            if (!(var58 instanceof SukunaFushiguroEntity)) {
                                                break label617;
                                            }
                                        }

                                        if (entity instanceof Mob) {
                                            _mobEnt = (Mob) entity;
                                            var58 = _mobEnt.getTarget();
                                        } else {
                                            var58 = null;
                                        }

                                        var42 = var58;
                                        if (!(var42 instanceof LivingEntity)) {
                                            break label617;
                                        }

                                        _entGetArmor = (LivingEntity) var42;
                                        if (!_entGetArmor.hasEffect((MobEffect) JujutsucraftModMobEffects.BRAIN_DAMAGE.get()) || !(entity.getPersistentData().getDouble("cnt_target") >= 100.0)) {
                                            break label617;
                                        }
                                    }

                                    int var63;
                                    label562:
                                    {
                                        if (entity instanceof LivingEntity) {
                                            _entGetArmor = (LivingEntity) entity;
                                            if (_entGetArmor.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                                var63 = _entGetArmor.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                                break label562;
                                            }
                                        }

                                        var63 = 0;
                                    }

                                    var63 -= 10;
                                    LivingEntity var59;
                                    if (entity instanceof Mob) {
                                        _mobEnt = (Mob) entity;
                                        var59 = _mobEnt.getTarget();
                                    } else {
                                        var59 = null;
                                    }

                                    int var61;
                                    label556:
                                    {
                                        var42 = var59;
                                        if (var42 instanceof LivingEntity) {
                                            _livEnt = (LivingEntity) var42;
                                            if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                                var61 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                                break label556;
                                            }
                                        }

                                        var61 = 0;
                                    }

                                    if (var63 <= var61) {
                                        var64 = true;
                                        break label578;
                                    }
                                }

                                var64 = false;
                            }

                            var62.putBoolean("flag_domain", var64);
                            domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                        }

                        if (entity instanceof Mob) {
                            _mobEnt = (Mob) entity;
                            var10000 = _mobEnt.getTarget();
                        } else {
                            var10000 = null;
                        }

                        _livEnt = var10000;
                        if (_livEnt instanceof Mob) {
                            _mobEnt = (Mob) _livEnt;
                            var10000 = _mobEnt.getTarget();
                        } else {
                            var10000 = null;
                        }

                        label548:
                        {
                            if (!(var10000 instanceof RikaEntity)) {
                                if (entity instanceof Mob) {
                                    _mobEnt = (Mob) entity;
                                    var10000 = _mobEnt.getTarget();
                                } else {
                                    var10000 = null;
                                }

                                _livEnt = var10000;
                                if (_livEnt instanceof Mob) {
                                    _mobEnt = (Mob) _livEnt;
                                    var10000 = _mobEnt.getTarget();
                                } else {
                                    var10000 = null;
                                }

                                if (!(var10000 instanceof Rika2Entity)) {
                                    break label548;
                                }
                            }

                            if (logicLocateRika) {
                                entity.getPersistentData().putDouble("cnt1", 20.0);
                                TechniqueRika2Procedure.execute(world, x, y, z, entity);
                            }
                        }

                        double var66;
                        if (entity instanceof OkkotsuYutaEntity) {
                            label540:
                            {
                                label539:
                                {
                                    if (LocateRikaProcedure.execute(world, entity)) {
                                        float var65;
                                        if (entity instanceof LivingEntity) {
                                            _livEnt = (LivingEntity) entity;
                                            var65 = _livEnt.getHealth();
                                        } else {
                                            var65 = -1.0F;
                                        }

                                        var66 = (double) var65;
                                        float var10001;
                                        if (entity instanceof LivingEntity) {
                                            _livEnt = (LivingEntity) entity;
                                            var10001 = _livEnt.getMaxHealth();
                                        } else {
                                            var10001 = -1.0F;
                                        }

                                        if (var66 <= (double) var10001 * 0.2) {
                                            break label539;
                                        }

                                        if (entity instanceof Mob) {
                                            _mobEnt = (Mob) entity;
                                            var10000 = _mobEnt.getTarget();
                                        } else {
                                            var10000 = null;
                                        }

                                        if (var10000.getPersistentData().getDouble("skill") % 100.0 == 15.0) {
                                            if (entity instanceof Mob) {
                                                _mobEnt = (Mob) entity;
                                                var10000 = _mobEnt.getTarget();
                                            } else {
                                                var10000 = null;
                                            }

                                            if (var10000.getPersistentData().getDouble("skill") != 1815.0) {
                                                break label539;
                                            }

                                            if (entity instanceof Mob) {
                                                _mobEnt = (Mob) entity;
                                                var10000 = _mobEnt.getTarget();
                                            } else {
                                                var10000 = null;
                                            }

                                            if (var10000.getPersistentData().getDouble("cnt9") >= 20.0) {
                                                if (entity instanceof Mob) {
                                                    _mobEnt = (Mob) entity;
                                                    var10000 = _mobEnt.getTarget();
                                                } else {
                                                    var10000 = null;
                                                }

                                                if (var10000.getPersistentData().getDouble("cnt9") <= 25.0) {
                                                    break label539;
                                                }
                                            }
                                        }
                                    }

                                    var60 = false;
                                    break label540;
                                }

                                var60 = true;
                            }

                            PureLoveCannon = var60;
                        }

                        if (entity instanceof Mob) {
                            _mobEnt = (Mob) entity;
                            var10000 = _mobEnt.getTarget();
                        } else {
                            var10000 = null;
                        }

                        int var67;
                        label521:
                        {
                            _entGetArmor = var10000;
                            if (_entGetArmor instanceof LivingEntity) {
                                _entGetArmor = (LivingEntity) _entGetArmor;
                                if (_entGetArmor.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var67 = _entGetArmor.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label521;
                                }
                            }

                            var67 = 0;
                        }

                        int var56;
                        label516:
                        {
                            var66 = (double) var67;
                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity) entity;
                                if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var56 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label516;
                                }
                            }

                            var56 = 0;
                        }

                        StrongEnemy = var66 >= (double) var56 * 0.5 || entity.getPersistentData().getDouble("cnt_target") > 600.0;
                        ResetCounterProcedure.execute(entity);
                        rnd = 0.0;
                        if (LogicStartProcedure.execute(entity) || domain) {
                            if (domain) {
                                entity.getPersistentData().putBoolean("flag_domain", false);
                                rnd = 20.0;
                                tick = 20.0;
                            } else if ((logicLocateRika || !StrongEnemy) && !PureLoveCannon) {
                                if (Math.random() > 0.75) {
                                    rnd = 10.0;
                                    tick = 75.0;
                                } else if (!AIDomainLogicProcedure.execute(world, x, y, z, entity) && Math.random() > 0.95 && (entity instanceof OkkotsuYutaCullingGameEntity || entity instanceof YutaCullingGamesEntity) && StrongEnemy) {
                                    rnd = 20.0;
                                    tick = 20.0;
                                } else if (Math.random() > 0.8) {
                                    distance = GetDistanceProcedure.execute(world, entity);

                                    for (int index0 = 0; index0 < 256; ++index0) {
                                        rnd = (double) Math.round(Math.random() * 10.0);
                                        if (rnd == 3.0) {
                                            tick = 20.0;
                                            if (!(distance < 6.0)) {
                                                break;
                                            }
                                        } else if (rnd == 5.0) {
                                            tick = 250.0;
                                            if (canUseCopy && !(Math.random() < 0.5)) {
                                                break;
                                            }
                                        } else if (rnd == 6.0) {
                                            tick = 150.0;
                                            if (entity instanceof OkkotsuYutaCullingGameEntity || entity instanceof YutaCullingGamesEntity && canUseCopy && !(distance < 6.0)) {
                                                break;
                                            }
                                        } else if (rnd == 7.0) {
                                            tick = 100.0;
                                            if (entity instanceof OkkotsuYutaCullingGameEntity || entity instanceof YutaCullingGamesEntity && canUseCopy && !(distance > 6.0)) {
                                                break;
                                            }
                                        } else if (rnd == 10.0) {
                                            tick = 10.0;
                                            if (!(Math.random() < 0.5)) {
                                                break;
                                            }
                                        }
                                    }
                                } else if (entity instanceof OkkotsuYutaCullingGameEntity || entity instanceof YutaCullingGamesEntity && Math.random() > 0.8 && GetDistanceProcedure.execute(world, entity) < 4.0 && canUseCopy) {
                                    use_copy = true;
                                    rnd = 106.0;
                                    tick = 50.0;
                                } else {
                                    label656:
                                    {
                                        if (entity instanceof OkkotsuYutaEntity) {
                                            if (entity instanceof Mob) {
                                                _mobEnt = (Mob) entity;
                                                var10000 = _mobEnt.getTarget();
                                            } else {
                                                var10000 = null;
                                            }

                                            if (var10000 instanceof GetoSuguruCurseUserEntity) {
                                                break label656;
                                            }
                                        }

                                        if (canUseCopy) {
                                            use_copy = false;
                                            NUM_COPY = Math.floor(Math.random() * 4.0);

                                            for (int index1 = 0; index1 < 4; ++index1) {
                                                if (entity instanceof LivingEntity) {
                                                    _entGetArmor = (LivingEntity) entity;
                                                    var55 = _entGetArmor.getItemBySlot(EquipmentSlot.byTypeAndIndex(EquipmentSlot.Type.ARMOR, (int) NUM_COPY));
                                                } else {
                                                    var55 = ItemStack.EMPTY;
                                                }

                                                ITEM1 = var55.copy();
                                                if (ITEM1.getOrCreateTag().getDouble("skill") > 0.0) {
                                                    use_copy = true;
                                                    rnd = ITEM1.getOrCreateTag().getDouble("skill");
                                                    tick = ITEM1.getOrCreateTag().getDouble("COOLDOWN_TICKS");
                                                    break;
                                                }

                                                ++NUM_COPY;
                                                if (NUM_COPY > 3.0) {
                                                    NUM_COPY = 0.0;
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity) entity;
                                    if (!_livEnt.level().isClientSide()) {
                                        _livEnt.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 19, false, false));
                                    }
                                }

                                if (PureLoveCannon) {
                                    rnd = 15.0;
                                    tick = 500.0;
                                } else {
                                    rnd = 10.0;
                                    tick = 75.0;
                                }
                            }
                        }

                        if (rnd > 0.0) {
                            entity.getPersistentData().putDouble("skill", (double) Math.round(use_copy ? rnd : 500.0 + rnd));
                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity) entity;
                                if (!_livEnt.level().isClientSide()) {
                                    _livEnt.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                                }
                            }

                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity) entity;
                                if (!_livEnt.level().isClientSide()) {
                                    _livEnt.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int) tick / 2, 0, false, false));
                                }
                            }

                            if (rnd == 15.0) {
                                if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity) entity;
                                    var55 = _livEnt.getMainHandItem();
                                } else {
                                    var55 = ItemStack.EMPTY;
                                }

                                if (var55.getItem() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()) {
                                    if (entity instanceof LivingEntity) {
                                        _entGetArmor = (LivingEntity) entity;
                                        var55 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                                    } else {
                                        var55 = ItemStack.EMPTY;
                                    }

                                    if (var55.getItem() == ItemStack.EMPTY.getItem()) {
                                        _ent = entity;
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "item replace entity @s armor.head with jujutsucraft:sword_okkotsu_yuta");
                                        }

                                        if (entity instanceof LivingEntity) {
                                            _entGetArmor = (LivingEntity) entity;
                                            var55 = _entGetArmor.getMainHandItem();
                                        } else {
                                            var55 = ItemStack.EMPTY;
                                        }

                                        _nbtTag = var55.getTag();
                                        if (_nbtTag != null) {
                                            if (entity instanceof LivingEntity) {
                                                _entGetArmor = (LivingEntity) entity;
                                                var55 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                                            } else {
                                                var55 = ItemStack.EMPTY;
                                            }

                                            var55.setTag(_nbtTag.copy());
                                        }

                                        _ent = entity;
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "item replace entity @s weapon.mainhand with air");
                                        }
                                    }
                                }
                            }
                        } else if (PureLoveCannon) {
                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity) entity;
                                if (!_livEnt.level().isClientSide()) {
                                    _livEnt.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 19, false, false));
                                }
                            }

                            entity.getPersistentData().putDouble("cnt_x", 5.0);
                        } else {
                            CalculateAttackProcedure.execute(world, x, y, z, entity);
                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity) entity;
                                var55 = _livEnt.getMainHandItem();
                            } else {
                                var55 = ItemStack.EMPTY;
                            }

                            if (var55.getItem() == ItemStack.EMPTY.getItem()) {
                                if (entity instanceof LivingEntity) {
                                    _entGetArmor = (LivingEntity) entity;
                                    var55 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                                } else {
                                    var55 = ItemStack.EMPTY;
                                }

                                if (var55.getItem() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()) {
                                    _ent = entity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "item replace entity @s weapon.mainhand with jujutsucraft:sword_okkotsu_yuta");
                                    }

                                    if (entity instanceof LivingEntity) {
                                        _entGetArmor = (LivingEntity) entity;
                                        var55 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                                    } else {
                                        var55 = ItemStack.EMPTY;
                                    }

                                    _nbtTag = var55.getTag();
                                    if (_nbtTag != null) {
                                        if (entity instanceof LivingEntity) {
                                            _entGetArmor = (LivingEntity) entity;
                                            var55 = _entGetArmor.getMainHandItem();
                                        } else {
                                            var55 = ItemStack.EMPTY;
                                        }

                                        var55.setTag(_nbtTag.copy());
                                    }

                                    _ent = entity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "item replace entity @s armor.head with air");
                                    }
                                }
                            }
                        }
                    }
                } else {
                    entity.getPersistentData().putDouble("cnt_x", 0.0);
                    entity.getPersistentData().putDouble("cnt_rika", entity.getPersistentData().getDouble("cnt_rika") + 1.0);
                    if (entity.getPersistentData().getDouble("cnt_rika") % 200.0 == 190.0) {
                        if (LocateRikaProcedure.execute(world, entity)) {
                            entity.getPersistentData().putDouble("cnt1", 20.0);
                            TechniqueRika2Procedure.execute(world, x, y, z, entity);
                        }

                        if (entity instanceof LivingEntity) {
                            _livEnt = (LivingEntity) entity;
                            var55 = _livEnt.getMainHandItem();
                        } else {
                            var55 = ItemStack.EMPTY;
                        }

                        if (var55.getItem() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()) {
                            if (entity instanceof LivingEntity) {
                                _entGetArmor = (LivingEntity) entity;
                                var55 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                            } else {
                                var55 = ItemStack.EMPTY;
                            }

                            if (var55.getItem() == ItemStack.EMPTY.getItem()) {
                                _ent = entity;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "item replace entity @s armor.head with jujutsucraft:sword_okkotsu_yuta");
                                }

                                if (entity instanceof LivingEntity) {
                                    _entGetArmor = (LivingEntity) entity;
                                    var55 = _entGetArmor.getMainHandItem();
                                } else {
                                    var55 = ItemStack.EMPTY;
                                }

                                _nbtTag = var55.getTag();
                                if (_nbtTag != null) {
                                    if (entity instanceof LivingEntity) {
                                        _entGetArmor = (LivingEntity) entity;
                                        var55 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                                    } else {
                                        var55 = ItemStack.EMPTY;
                                    }

                                    var55.setTag(_nbtTag.copy());
                                }

                                _ent = entity;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "item replace entity @s weapon.mainhand with air");
                                }
                            }
                        }
                    }
                }

                if (entity.getPersistentData().getDouble("skill") == 0.0) {
                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity) entity;
                        var55 = _livEnt.getMainHandItem();
                    } else {
                        var55 = ItemStack.EMPTY;
                    }

                    if (var55.getItem() == JujutsucraftModItems.LOUDSPEAKER.get() && !entity.level().isClientSide() && entity.getServer() != null) {
                        entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s weapon.mainhand with air");
                    }
                }
            }

        }
    }
}