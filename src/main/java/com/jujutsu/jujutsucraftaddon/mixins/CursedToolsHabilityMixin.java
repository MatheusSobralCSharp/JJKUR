package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.entity.IgrisEntity;
import com.jujutsu.jujutsucraftaddon.entity.Shadow1Entity;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.CursedToolsAbilityProcedure;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = CursedToolsAbilityProcedure.class, priority = -10000)
public abstract class CursedToolsHabilityMixin {
    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(Entity entity, Entity entityiterator, CallbackInfo ci) {
        ci.cancel();

        if (entity != null && entityiterator != null) {
            double NUM1 = 0.0;
            boolean logic_a = false;
            boolean mahorage = false;
            String STR1 = "";
            Entity entity_a = null;
            entity_a = entityiterator;
            if (entity_a instanceof LivingEntity) {
                Player _plrCldCheck17;
                LivingEntity _entGetArmor;
                LivingEntity _entity;
                LivingEntity _livEnt;
                ItemCooldowns var10000;
                ItemStack var10001;
                ItemStack var20;
                if (entity.getPersistentData().getBoolean("attack")) {
                    label287: {
                        if (entity instanceof Player) {
                            _plrCldCheck17 = (Player)entity;
                            var10000 = _plrCldCheck17.getCooldowns();
                            if (entity instanceof LivingEntity) {
                                _entGetArmor = (LivingEntity)entity;
                                var10001 = _entGetArmor.getMainHandItem();
                            } else {
                                var10001 = ItemStack.EMPTY;
                            }

                            if (var10000.isOnCooldown(var10001.getItem())) {
                                break label287;
                            }
                        }

                        if (entity instanceof LivingEntity) {
                            _entGetArmor = (LivingEntity)entity;
                            var20 = _entGetArmor.getMainHandItem();
                        } else {
                            var20 = ItemStack.EMPTY;
                        }

                        if (var20.is(ItemTags.create(new ResourceLocation("forge:cursed_tool")))) {
                            label288: {
                                if (entity instanceof LivingEntity) {
                                    _entGetArmor = (LivingEntity)entity;
                                    var20 = _entGetArmor.getMainHandItem();
                                } else {
                                    var20 = ItemStack.EMPTY;
                                }

                                if (var20.getItem() != JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get()) {
                                    if (entity instanceof LivingEntity) {
                                        _livEnt = (LivingEntity)entity;
                                        var20 = _livEnt.getMainHandItem();
                                    } else {
                                        var20 = ItemStack.EMPTY;
                                    }

                                    if (var20.getItem() != JujutsucraftModItems.BLACK_ROPE.get()) {
                                        break label288;
                                    }
                                }

                                if (entity_a instanceof LivingEntity) {
                                    _entity = (LivingEntity)entity_a;
                                    if (!_entity.level().isClientSide()) {
                                        _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.CANCEL_CURSED_TECHNIQUE.get(), 1, 0));
                                    }
                                }

                                if (entity_a instanceof LivingEntity) {
                                    _entity = (LivingEntity)entity_a;
                                    if (!_entity.level().isClientSide()) {
                                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get(), 10, 0));
                                    }
                                }

                                if (entity_a instanceof LivingEntity) {
                                    _entity = (LivingEntity)entity_a;
                                    _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
                                }

                                if (entity_a.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && entity_a instanceof LivingEntity) {
                                    _entity = (LivingEntity)entity_a;
                                    if (!_entity.level().isClientSide()) {
                                        MobEffect var10003;
                                        MobEffectInstance var21;
                                        int var10005;
                                        label261: {
                                            var10003 = MobEffects.WEAKNESS;
                                            if (entity_a instanceof LivingEntity) {
                                                _livEnt = (LivingEntity)entity_a;
                                                if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                                    var10005 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                                    break label261;
                                                }
                                            }

                                            var10005 = 0;
                                        }

                                        var21 = new MobEffectInstance(var10003, 10, var10005, false, false);
                                        _entity.addEffect(var21);
                                    }
                                }
                            }
                        }
                    }
                }

                if (entity instanceof Player) {
                    _plrCldCheck17 = (Player)entity;
                    var10000 = _plrCldCheck17.getCooldowns();
                    if (entity instanceof LivingEntity) {
                        _entGetArmor = (LivingEntity)entity;
                        var10001 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                    } else {
                        var10001 = ItemStack.EMPTY;
                    }

                    if (var10000.isOnCooldown(var10001.getItem())) {
                        return;
                    }
                }

                if (entity instanceof LivingEntity) {
                    _entGetArmor = (LivingEntity)entity;
                    var20 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                } else {
                    var20 = ItemStack.EMPTY;
                }

                if (var20.getItem() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                    if (entity instanceof LivingEntity) {
                        _entGetArmor = (LivingEntity)entity;
                        var20 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                    } else {
                        var20 = ItemStack.EMPTY;
                    }

                    if (var20.getItem() != JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                        return;
                    }
                }

                mahorage = entity instanceof Player ? entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique == 16.0 || (entity.getPersistentData().getDouble("IsMahoraga") == 1.0) || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mahoraga == 1) : entity instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity || entity instanceof IgrisEntity || entity instanceof Shadow1Entity;
                NUM1 = 0.0;
                STR1 = "";
                if (NUM1 == 0.0 && entity_a instanceof LivingEntity) {
                    _livEnt = (LivingEntity)entity_a;
                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get()) && entity.getPersistentData().getBoolean("attack")) {
                        STR1 = "skill205";
                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity)entity;
                            var20 = _entity.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                            var20 = ItemStack.EMPTY;
                        }

                        if (var20.getOrCreateTag().getDouble(STR1) == 0.0) {
                            NUM1 = 1.0;
                        } else {
                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity)entity;
                                var20 = _livEnt.getItemBySlot(EquipmentSlot.HEAD);
                            } else {
                                var20 = ItemStack.EMPTY;
                            }

                            if (var20.getOrCreateTag().getDouble(STR1) >= 100.0 && mahorage) {
                                STR1 = "";
                                if (entity_a instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity_a;
                                    if (!_livEnt.level().isClientSide()) {
                                        _livEnt.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get(), 1, 1));
                                    }
                                }

                                if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    _livEnt.removeEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
                                }
                            }
                        }
                    }
                }

                if (NUM1 == 0.0 && STR1.equals("") && mahorage) {
                    STR1 = "toLiving";
                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var20 = _livEnt.getItemBySlot(EquipmentSlot.HEAD);
                    } else {
                        var20 = ItemStack.EMPTY;
                    }

                    if (var20.getOrCreateTag().getDouble(STR1) == 0.0) {
                        NUM1 = 1.0;
                    } else {
                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity)entity;
                            var20 = _entity.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                            var20 = ItemStack.EMPTY;
                        }

                        if (var20.getOrCreateTag().getDouble(STR1) >= 100.0) {
                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity)entity;
                                var20 = _livEnt.getItemBySlot(EquipmentSlot.HEAD);
                            } else {
                                var20 = ItemStack.EMPTY;
                            }

                            NUM1 = (double)Math.round(Math.floor(var20.getOrCreateTag().getDouble(STR1) / 100.0) * 2.5);
                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity)entity;
                                var20 = _livEnt.getMainHandItem();
                            } else {
                                var20 = ItemStack.EMPTY;
                            }

                            if (var20.isEnchantable()) {
                                if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    var20 = _livEnt.getMainHandItem();
                                } else {
                                    var20 = ItemStack.EMPTY;
                                }

                                double var22;
                                CompoundTag var24;
                                label283: {
                                    var24 = var20.getOrCreateTag();
                                    ItemStack var23;
                                    if (entity_a.getPersistentData().getBoolean("CursedSpirit")) {
                                        ItemStack var10002;
                                        if (entity instanceof LivingEntity) {
                                            _livEnt = (LivingEntity) entity;
                                            var10002 = _livEnt.getMainHandItem();
                                        } else {
                                            var10002 = ItemStack.EMPTY;
                                        }

                                        if (var10002.getItem() == JujutsucraftModItems.SWORD_OF_EXTERMINATION.get()) {
                                            var22 = NUM1 * -1.0;
                                            if (entity instanceof LivingEntity) {
                                                _livEnt = (LivingEntity) entity;
                                                var23 = _livEnt.getMainHandItem();
                                            } else {
                                                var23 = ItemStack.EMPTY;
                                            }

                                            var22 = Math.min(var22, var23.getOrCreateTag().getDouble("CursePower"));
                                            break label283;
                                        }
                                    }

                                    if (entity instanceof LivingEntity) {
                                        _livEnt = (LivingEntity)entity;
                                        var23 = _livEnt.getMainHandItem();
                                    } else {
                                        var23 = ItemStack.EMPTY;
                                    }

                                    var22 = Math.max(NUM1, var23.getOrCreateTag().getDouble("CursePower"));
                                }

                                var24.putDouble("CursePower", var22);
                            }

                            NUM1 = 0.0;
                        }
                    }
                }

                if (NUM1 > 0.0) {
                    int index0 = 0;

                    label285: {
                        while(true) {
                            if (index0 >= 800) {
                                break label285;
                            }

                            if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity)entity;
                                var20 = _entity.getItemBySlot(EquipmentSlot.HEAD);
                            } else {
                                var20 = ItemStack.EMPTY;
                            }

                            if (var20.getOrCreateTag().getString("DATA" + Math.round(NUM1)).equals("")) {
                                break;
                            }

                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity)entity;
                                var20 = _livEnt.getItemBySlot(EquipmentSlot.HEAD);
                            } else {
                                var20 = ItemStack.EMPTY;
                            }

                            if (var20.getOrCreateTag().getString("DATA" + Math.round(NUM1)).equals(STR1)) {
                                break;
                            }

                            ++NUM1;
                            ++index0;
                        }

                        if (entity instanceof LivingEntity) {
                            _livEnt = (LivingEntity)entity;
                            var20 = _livEnt.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                            var20 = ItemStack.EMPTY;
                        }

                        var20.getOrCreateTag().putString("DATA" + Math.round(NUM1), STR1);
                        if (entity instanceof LivingEntity) {
                            _livEnt = (LivingEntity)entity;
                            var20 = _livEnt.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                            var20 = ItemStack.EMPTY;
                        }

                        var20.getOrCreateTag().putDouble(STR1, 1.0);
                    }

                    if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        if (!_player.level().isClientSide()) {
                            _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.adaptation_start").getString()), false);
                        }
                    }
                }
            }

        }
    }
}
