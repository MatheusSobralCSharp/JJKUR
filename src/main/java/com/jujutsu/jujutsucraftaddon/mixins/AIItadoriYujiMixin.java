package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.entity.CloneEntity;
import com.jujutsu.jujutsucraftaddon.entity.FakeClonesEntity;
import com.jujutsu.jujutsucraftaddon.entity.FakePurpleClonesEntity;
import com.jujutsu.jujutsucraftaddon.entity.ItadoriShinjukuEntity;
import net.mcreator.jujutsucraft.entity.ItadoriYujiEntity;
import net.mcreator.jujutsucraft.entity.ItadoriYujiShibuyaEntity;
import net.mcreator.jujutsucraft.entity.ItadoriYujiShinjukuEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.*;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
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
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = AIItadoriYujiProcedure.class, priority = -10000)
public class AIItadoriYujiMixin {

    @Inject(method = "execute", at = @At("HEAD"), remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();
        if (entity != null) {
            double rnd = 0.0;
            double lv_st = 0.0;
            double lv_df = 0.0;
            double distance = 0.0;
            double tick = 0.0;
            if (entity.isAlive()) {
                AIActiveProcedure.execute(world, x, y, z, entity);
                if (entity instanceof ItadoriYujiShinjukuEntity || entity instanceof ItadoriShinjukuEntity) {
                    lv_st = 18.0;
                    lv_df = 3.0;
                } else if (entity instanceof ItadoriYujiShibuyaEntity || entity instanceof CloneEntity || entity instanceof FakeClonesEntity || entity instanceof FakePurpleClonesEntity) {
                    lv_st = 10.0;
                    lv_df = 3.0;
                } else {
                    lv_st = 7.0;
                    lv_df = 2.0;
                }

                LivingEntity _livEnt8;
                LivingEntity _entity;
                label213: {
                    if (entity instanceof LivingEntity) {
                        _livEnt8 = (LivingEntity)entity;
                        if (_livEnt8.hasEffect(MobEffects.DAMAGE_BOOST)) {
                            break label213;
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, Integer.MAX_VALUE, (int)lv_st, false, false));
                        }
                    }
                }

                label208: {
                    if (entity instanceof LivingEntity) {
                        _livEnt8 = (LivingEntity)entity;
                        if (_livEnt8.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                            break label208;
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, Integer.MAX_VALUE, (int)lv_df, false, false));
                        }
                    }
                }

                LivingEntity _livEnt42;
                if (entity instanceof ItadoriYujiEntity) {
                    label227: {
                        ItemStack var10000;
                        Player _player;
                        if (entity instanceof LivingEntity) {
                            _livEnt8 = (LivingEntity)entity;
                            if (_livEnt8.hasEffect(MobEffects.INVISIBILITY)) {
                                if (entity instanceof LivingEntity) {
                                    _entity = (LivingEntity)entity;
                                    var10000 = _entity.getItemBySlot(EquipmentSlot.HEAD);
                                } else {
                                    var10000 = ItemStack.EMPTY;
                                }

                                if (var10000.getItem() != JujutsucraftModItems.ITADORI_YUJI_PAPER_HELMET.get()) {
                                    _entity = (LivingEntity) entity;
                                    if (!_entity.level().isClientSide() && _entity.getServer() != null) {
                                        _entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _entity.position(), _entity.getRotationVector(), _entity.level() instanceof ServerLevel ? (ServerLevel)_entity.level() : null, 4, _entity.getName().getString(), _entity.getDisplayName(), _entity.level().getServer(), _entity), "effect give @s invisibility 1000000 0 true");
                                    }

                                    _entity = (LivingEntity) entity;
                                    if (_entity instanceof Player) {
                                        _player = (Player)_entity;
                                        _player.getInventory().armor.set(3, new ItemStack((ItemLike)JujutsucraftModItems.ITADORI_YUJI_PAPER_HELMET.get()));
                                        _player.getInventory().setChanged();
                                    } else if (_entity instanceof LivingEntity) {
                                        _livEnt42 = (LivingEntity)_entity;
                                        _livEnt42.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.ITADORI_YUJI_PAPER_HELMET.get()));
                                    }

                                    _entity = (LivingEntity) entity;
                                    if (_entity instanceof Player) {
                                        _player = (Player)_entity;
                                        _player.getInventory().armor.set(2, ItemStack.EMPTY);
                                        _player.getInventory().setChanged();
                                    } else if (_entity instanceof LivingEntity) {
                                        _livEnt42 = (LivingEntity)_entity;
                                        _livEnt42.setItemSlot(EquipmentSlot.CHEST, ItemStack.EMPTY);
                                    }
                                    if (_entity instanceof Player) {
                                        _player = (Player)_entity;
                                        _player.getInventory().armor.set(1, ItemStack.EMPTY);
                                        _player.getInventory().setChanged();
                                    } else if (_entity instanceof LivingEntity) {
                                        _livEnt42 = (LivingEntity)_entity;
                                        _livEnt42.setItemSlot(EquipmentSlot.LEGS, ItemStack.EMPTY);
                                    }

                                    _entity = (LivingEntity) entity;
                                    if (_entity instanceof Player) {
                                        _player = (Player)_entity;
                                        _player.getInventory().armor.set(0, ItemStack.EMPTY);
                                        _player.getInventory().setChanged();
                                    } else if (_entity instanceof LivingEntity) {
                                        _livEnt42 = (LivingEntity)_entity;
                                        _livEnt42.setItemSlot(EquipmentSlot.FEET, ItemStack.EMPTY);
                                    }

                                    ItemStack _setstack;
                                    if (entity instanceof LivingEntity) {
                                        _entity = (LivingEntity)entity;
                                        _setstack = ItemStack.EMPTY.copy();
                                        _setstack.setCount(1);
                                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                        if (_entity instanceof Player) {
                                            _player = (Player)_entity;
                                            _player.getInventory().setChanged();
                                        }
                                    }

                                    if (entity instanceof LivingEntity) {
                                        _entity = (LivingEntity)entity;
                                        _setstack = ItemStack.EMPTY.copy();
                                        _setstack.setCount(1);
                                        _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
                                        if (_entity instanceof Player) {
                                            _player = (Player)_entity;
                                            _player.getInventory().setChanged();
                                        }
                                    }
                                }
                                break label227;
                            }
                        }

                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity)entity;
                            var10000 = _entity.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                            var10000 = ItemStack.EMPTY;
                        }

                        if (var10000.getItem() == JujutsucraftModItems.ITADORI_YUJI_PAPER_HELMET.get()) {
                            _entity = (LivingEntity) entity;
                            if (_entity instanceof Player) {
                                _player = (Player)_entity;
                                _player.getInventory().armor.set(3, ItemStack.EMPTY);
                                _player.getInventory().setChanged();
                            } else if (_entity instanceof LivingEntity) {
                                _livEnt42 = (LivingEntity)_entity;
                                _livEnt42.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
                            }
                        }
                    }
                }

                LivingEntity var23;
                if (entity instanceof Mob) {
                    Mob _mobEnt = (Mob)entity;
                    var23 = _mobEnt.getTarget();
                } else {
                    var23 = null;
                }

                if (var23 instanceof LivingEntity) {
                    entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                    if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                        label192: {
                            entity.getPersistentData().putDouble("cnt_x", 0.0);
                            distance = GetDistanceProcedure.execute(world, entity);
                            if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity)entity;
                                if (_entity.hasEffect((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                    break label192;
                                }
                            }

                            if (distance < 6.0 && Math.random() < 0.2) {
                                rnd = 2105.0;
                                tick = 25.0;
                            }
                        }

                        if (LogicStartProcedure.execute(entity) && entity instanceof ItadoriYujiShinjukuEntity || entity instanceof ItadoriShinjukuEntity) {
                            if (distance < 6.0 && Math.random() < 0.1) {
                                rnd = 2108.0;
                                tick = 100.0;
                            }

                            if (distance > 12.0 && Math.random() < 0.1) {
                                rnd = 2113.0;
                                tick = 100.0;
                            }

                            if (distance < 8.0 && Math.random() < 0.1) {
                                rnd = 2114.0;
                                tick = 50.0;
                            }
                        }

                        label225: {
                            if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity)entity;
                                if (_entity.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                    break label225;
                                }
                            }

                            if (entity instanceof ItadoriYujiShibuyaEntity || entity instanceof ItadoriYujiShinjukuEntity || entity instanceof ItadoriShinjukuEntity) {
                                float var25;
                                if (entity instanceof LivingEntity) {
                                    _entity = (LivingEntity)entity;
                                    var25 = _entity.getHealth();
                                } else {
                                    var25 = -1.0F;
                                }

                                double var26 = (double)var25;
                                float var10001;
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var10001 = _livEnt.getMaxHealth();
                                } else {
                                    var10001 = -1.0F;
                                }

                                if (var26 < (double)var10001 * 0.75 || entity.getPersistentData().getDouble("cnt_target") > 1200.0) {
                                    label232: {
                                        if (entity instanceof LivingEntity) {
                                            _livEnt42 = (LivingEntity)entity;
                                            if (_livEnt42.hasEffect((MobEffect)JujutsucraftModMobEffects.DEEP_CONCENTRATION.get())) {
                                                break label232;
                                            }
                                        }

                                        rnd = 2118.0;
                                        tick = 50.0;
                                    }
                                }
                            }
                        }

                        if (rnd > 0.0) {
                            ResetCounterProcedure.execute(entity);
                            entity.getPersistentData().putDouble("skill", (double)Math.round(rnd));
                            if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity)entity;
                                if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                                }
                            }

                            if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity)entity;
                                if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick / 2, 0, false, false));
                                }
                            }
                        } else {
                            CalculateAttackProcedure.execute(world, x, y, z, entity);
                        }
                    }
                } else {
                    entity.getPersistentData().putDouble("cnt_x", 0.0);
                }
            }

        }
    }
}
