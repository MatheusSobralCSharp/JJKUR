package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KeyChangeTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraft.procedures.PlayerTickSecondTechniqueProcedure;
import net.mcreator.jujutsucraft.procedures.ReturnInsideItemProcedure;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PlayerTickSecondTechniqueProcedure.class, priority = -10000)
public abstract class PlayerSecondTechniqueMixin {
    public PlayerSecondTechniqueMixin() {
    }

    /**
     * @author Satushi
     * @reason Changes How Second Technique Works
     */


    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();
        if (entity != null) {
            double old_select = 0.0;
            double old_technique = 0.0;
            boolean changeTechnique = false;
            boolean switched = false;
            boolean old_second = false;
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
                LivingEntity _livEnt = (LivingEntity)entity;
                var10000 = _livEnt.getMainHandItem();
            } else {
                var10000 = ItemStack.EMPTY;
            }

            label88: {
                double _setval;
                if (var10000.getItem() == JujutsucraftModItems.LOUDSPEAKER.get()) {
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                    } else {
                        var10000 = ItemStack.EMPTY;
                    }

                    if (!var10000.getOrCreateTag().getBoolean("Used")) {
                        label87: {
                            if (entity instanceof Player) {
                                Player _plrCldCheck5 = (Player)entity;
                                ItemCooldowns var24 = _plrCldCheck5.getCooldowns();
                                ItemStack var10001;
                                if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var10001 = _livEnt.getMainHandItem();
                                } else {
                                    var10001 = ItemStack.EMPTY;
                                }

                                if (var24.isOnCooldown(var10001.getItem())) {
                                    break label87;
                                }
                            }

                            boolean _setval5 = true;
                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                capability.SecondTechnique = _setval5;
                                capability.syncPlayerVariables(entity);
                            });
                            if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 3.0) {
                                _setval = 3.0;
                                double final_setval2 = _setval;
                                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                    capability.PlayerCurseTechnique2 = final_setval2;
                                    capability.syncPlayerVariables(entity);
                                });
                                changeTechnique = true;
                            }
                            break label88;
                        }
                    }
                }

                if (entity instanceof LivingEntity) {
                    LivingEntity _livEnt6 = (LivingEntity)entity;
                    if (_livEnt6.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 1.0) {
                            _setval = 1.0;
                            double final_setval = _setval;
                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                capability.PlayerCurseTechnique2 = final_setval;
                                capability.syncPlayerVariables(entity);
                            });
                             boolean _setval3 = true;
                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                capability.SecondTechnique = _setval3;
                                capability.syncPlayerVariables(entity);
                            });
                            changeTechnique = true;
                        }

                        if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 21.0) {
                            boolean _setval4 = true;
                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                capability.SecondTechnique = _setval4;
                                capability.syncPlayerVariables(entity);
                            });
                        }
                        break label88;
                    }


                    if (entity instanceof LivingEntity _livEnt4) {
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SecondAllowed) {
                            if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique2 != (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SecondTechnique) {
                                _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SecondTechnique;
                                double final_setval = _setval;
                                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                    capability.PlayerCurseTechnique2 = final_setval;
                                    capability.syncPlayerVariables(entity);
                                });
                                boolean _setval3 = true;
                                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                    capability.SecondTechnique = _setval3;
                                    capability.syncPlayerVariables(entity);
                                });
                                changeTechnique = true;
                            }
                            break label88;
                        }
                    }

                }

                if (ReturnInsideItemProcedure.execute(entity).getItem() == JujutsucraftModItems.DEATH_PAINTING.get() && ReturnInsideItemProcedure.execute(entity).getCount() >= 9) {
                    if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 10.0) {
                        _setval = 10.0;
                        double final_setval5 = _setval;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                            capability.PlayerCurseTechnique2 = final_setval5;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                } else {
                    boolean _setval2 = false;
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.SecondTechnique = _setval2;
                        capability.syncPlayerVariables(entity);
                    });
                    if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique) {
                        _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
                        double final_setval4 = _setval;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                            capability.PlayerCurseTechnique2 = final_setval4;
                            capability.syncPlayerVariables(entity);
                        });
                        changeTechnique = true;
                    }
                }
            }

            if (changeTechnique) {
                Entity _ent = entity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel)_ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound ui.button.click master @s");
                }

                boolean _setval = true;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                    capability.noChangeTechnique = _setval;
                    capability.syncPlayerVariables(entity);
                });
                KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            }

        }
    }
}
