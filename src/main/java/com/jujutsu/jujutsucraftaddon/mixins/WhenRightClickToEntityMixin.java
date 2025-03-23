package com.jujutsu.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.*;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.ReturnInsideItemProcedure;
import net.mcreator.jujutsucraft.procedures.WhenRightClickToEntityProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = WhenRightClickToEntityProcedure.class, priority = -10000)
public abstract class WhenRightClickToEntityMixin {
    public WhenRightClickToEntityMixin() {
    }

    /**
     * @author Satushi
     * @reason Adds The Spider Web Cleave to Sukuna Entity
     */

    @Inject(method = "execute(Lnet/minecraftforge/eventbus/api/Event;Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/entity/Entity;)V", at = @At("HEAD"), remap = false, cancellable = true)
    private static void execute(Event event, LevelAccessor world, Entity entity, Entity sourceentity, CallbackInfo ci) {
        ci.cancel();
        if (entity != null && sourceentity != null) {
            double T1 = 0.0;
            double T2 = 0.0;
            boolean right_clicked = false;
            T1 = ((JujutsucraftModVariables.PlayerVariables) sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
            T2 = ((JujutsucraftModVariables.PlayerVariables) sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
            LivingEntity _livEnt22;
            LivingEntity _entity;
            if (sourceentity instanceof LivingEntity) {
                _livEnt22 = (LivingEntity) sourceentity;
                if (_livEnt22.hasEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get()) && ReturnInsideItemProcedure.execute(sourceentity).getItem() == JujutsucraftModItems.SUKUNA_FINGER.get()) {
                    right_clicked = false;
                    ServerLevel _level;
                    Entity entityToSpawn;
                    if (!(entity instanceof ItadoriYujiEntity) && !(entity instanceof ItadoriYujiShibuyaEntity)) {
                        if (entity instanceof FushiguroMegumiEntity || entity instanceof FushiguroMegumiShibuyaEntity) {
                            right_clicked = true;
                            if (world instanceof ServerLevel) {
                                _level = (ServerLevel) world;
                                entityToSpawn = ((EntityType) JujutsucraftModEntities.SUKUNA_FUSHIGURO.get()).spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                                if (entityToSpawn != null) {
                                    entityToSpawn.setYRot(entity.getYRot());
                                    entityToSpawn.setYBodyRot(entity.getYRot());
                                    entityToSpawn.setYHeadRot(entity.getYRot());
                                    entityToSpawn.setXRot(entity.getXRot());
                                    {
                                        Entity _entity1 = entityToSpawn;
                                        if (_entity1 instanceof Player _player) {
                                            _player.getInventory().armor.set(3, new ItemStack(JujutsucraftModItems.HAIR_FUSHIGURO_MEGUMI_HELMET.get()));
                                            _player.getInventory().setChanged();
                                        } else if (_entity1 instanceof LivingEntity _living) {
                                            _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(JujutsucraftModItems.HAIR_FUSHIGURO_MEGUMI_HELMET.get()));
                                        }
                                        if (_entity1 instanceof Player _player) {
                                            _player.getInventory().armor.set(2, new ItemStack(JujutsucraftModItems.UNIFORM_NORMAL_CHESTPLATE.get()));
                                            _player.getInventory().setChanged();
                                        } else if (_entity1 instanceof LivingEntity _living) {
                                            _living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(JujutsucraftModItems.UNIFORM_NORMAL_CHESTPLATE.get()));
                                        }
                                        if (_entity1 instanceof Player _player) {
                                            _player.getInventory().armor.set(1, new ItemStack(JujutsucraftModItems.UNIFORM_NORMAL_LEGGINGS.get()));
                                            _player.getInventory().setChanged();
                                        } else if (_entity1 instanceof LivingEntity _living) {
                                            _living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(JujutsucraftModItems.UNIFORM_NORMAL_LEGGINGS.get()));
                                        }
                                        if (_entity1 instanceof Player _player) {
                                            _player.getInventory().armor.set(0, new ItemStack(JujutsucraftModItems.UNIFORM_NORMAL_BOOTS.get()));
                                            _player.getInventory().setChanged();
                                        } else if (_entity1 instanceof LivingEntity _living) {
                                            _living.setItemSlot(EquipmentSlot.FEET, new ItemStack(JujutsucraftModItems.UNIFORM_NORMAL_BOOTS.get()));
                                        }


                                    }

                                }
                            }
                        }
                    } else {
                        right_clicked = true;
                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel) world;
                            entityToSpawn = ((EntityType) JujutsucraftModEntities.SUKUNA.get()).spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
                            if (entityToSpawn != null) {
                                entityToSpawn.setYRot(entity.getYRot());
                                entityToSpawn.setYBodyRot(entity.getYRot());
                                entityToSpawn.setYHeadRot(entity.getYRot());
                                entityToSpawn.setXRot(entity.getXRot());
                            }
                        }
                    }

                    if (right_clicked) {
                        if (sourceentity instanceof LivingEntity) {
                            _entity = (LivingEntity) sourceentity;
                            _entity.swing(InteractionHand.MAIN_HAND, true);
                        }

                        if (sourceentity instanceof LivingEntity) {
                            _entity = (LivingEntity) sourceentity;
                            _entity.removeEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get());
                        }

                        ItemStack _setval = ItemStack.EMPTY;
                        sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                            capability.BodyItem = _setval.copy();
                            capability.syncPlayerVariables(sourceentity);
                        });
                        if (!entity.level().isClientSide()) {
                            entity.discard();
                        }
                    }
                }
            }

            if (!right_clicked) {
                if (sourceentity instanceof LivingEntity) {
                    _livEnt22 = (LivingEntity) sourceentity;
                    if (_livEnt22.hasEffect((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get())) {
                        return;
                    }
                }

                if (sourceentity instanceof LivingEntity) {
                    _entity = (LivingEntity) sourceentity;
                    if (_entity.hasEffect((MobEffect) JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                        return;
                    }
                }

                if (sourceentity instanceof LivingEntity) {
                    LivingEntity _livEnt24 = (LivingEntity) sourceentity;
                    if (_livEnt24.hasEffect((MobEffect) JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get())) {
                        return;
                    }
                }

                if (!(entity instanceof DomainExpansionEntityEntity)) {
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt26 = (LivingEntity) entity;
                        if (_livEnt26.hasEffect((MobEffect) JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                            return;
                        }
                    }

                    if ((T1 == 19.0 || T2 == 19.0) && !(entity instanceof FrameEntity) && !(entity instanceof EntityProjectionSorceryEntity) && entity.getPersistentData().getDouble("select") == 0.0) {
                        label155:
                        {
                            if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity) entity;
                                if (_entity.hasEffect((MobEffect) JujutsucraftModMobEffects.PROJECTION_SORCERY.get())) {
                                    break label155;
                                }
                            }

                            if (((JujutsucraftModVariables.PlayerVariables) sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower + ((JujutsucraftModVariables.PlayerVariables) sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange >= 40.0) {
                                double _setval = ((JujutsucraftModVariables.PlayerVariables) sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 40.0;
                                sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                    capability.PlayerCursePowerChange = _setval;
                                    capability.syncPlayerVariables(sourceentity);
                                });
                                if (entity instanceof LivingEntity) {
                                    _entity = (LivingEntity) entity;
                                    if (!_entity.level().isClientSide()) {
                                        _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.PROJECTION_SORCERY.get(), 50, 0, false, false));
                                    }
                                }

                                if (sourceentity instanceof LivingEntity) {
                                    _entity = (LivingEntity) sourceentity;
                                    _entity.swing(InteractionHand.MAIN_HAND, true);
                                }
                            }
                        }
                    }

                    if ((T1 == 24.0 || T2 == 24.0) && entity.getPercentFrozen() * 100.0F < 5.0F && ((JujutsucraftModVariables.PlayerVariables) sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower + ((JujutsucraftModVariables.PlayerVariables) sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange >= 40.0) {
                        double _setval = ((JujutsucraftModVariables.PlayerVariables) sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 40.0;
                        sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                            capability.PlayerCursePowerChange = _setval;
                            capability.syncPlayerVariables(sourceentity);
                        });
                        if (world instanceof Level) {
                            Level _level = (Level) world;
                            if (!_level.isClientSide()) {
                                _level.playSound((Player) null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:ice_generate")), SoundSource.NEUTRAL, 0.5F, 1.0F);
                            } else {
                                _level.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:ice_generate")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
                            }
                        }

                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity) entity;
                            if (!_entity.level().isClientSide()) {
                                _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 5, false, false));
                            }
                        }

                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity) entity;
                            if (!_entity.level().isClientSide()) {
                                _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 1, false, false));
                            }
                        }

                        entity.setTicksFrozen(100);
                        if (sourceentity instanceof LivingEntity) {
                            _entity = (LivingEntity) sourceentity;
                            _entity.swing(InteractionHand.MAIN_HAND, true);
                        }
                    }
                }
            }

        }
    }
}