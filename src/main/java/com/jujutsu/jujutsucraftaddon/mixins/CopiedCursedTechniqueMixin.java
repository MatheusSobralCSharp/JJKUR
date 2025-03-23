package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.CopiedCursedTechniqueRightclickedProcedure;
import net.mcreator.jujutsucraft.procedures.StartCursedTechniqueProcedure;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = CopiedCursedTechniqueRightclickedProcedure.class, priority = -10000)
public abstract class CopiedCursedTechniqueMixin {

    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack, CallbackInfo ci) {
        ci.cancel();
        if (entity != null) {
            if (itemstack.getOrCreateTag().getDouble("skill") > 0.0) {
                Player _player;
                if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 5.0 && ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 5.0) {
                    if (entity instanceof Player) {
                        _player = (Player) entity;
                        if (!_player.level().isClientSide()) {
                            _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.dont_use").getString()), true);
                        }
                    }
                } else if (entity.getPersistentData().getDouble("skill") == 0.0) {
                    if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique == 5 && entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).InfusedDomain) {
                        if (itemstack.getOrCreateTag().getDouble("skill") > 0) {
                            {
                                double _setval = ((int) (itemstack.getOrCreateTag().getDouble("skill") / 100));
                                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.PlayerCurseTechnique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                            {
                                double _setval = ((int) (itemstack.getOrCreateTag().getDouble("skill") / 100));
                                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.PlayerCurseTechnique2 = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }

                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 6000, 0, false, false));

                            if (entity instanceof Player _player2) {
                                ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
                                _player2.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player2.inventoryMenu.getCraftSlots());
                            }
                        }

                    }
                    itemstack.getOrCreateTag().putBoolean("used_item", true);
                    StartCursedTechniqueProcedure.execute(world, x, y, z, entity);
                    if (entity.getPersistentData().getDouble("skill") > 0.0) {
                        entity.getPersistentData().putBoolean("PRESS_Z", true);
                        if (entity instanceof Player) {
                            _player = (Player) entity;
                            if (!_player.level().isClientSide()) {
                                _player.displayClientMessage(Component.literal(itemstack.getDisplayName().getString()), true);
                            }
                        }

                        if (itemstack.getItem() == JujutsucraftModItems.COPIED_CURSED_TECHNIQUE.get()) {
                            if (entity instanceof Player) {
                                _player = (Player) entity;
                                _player.getCooldowns().addCooldown(itemstack.getItem(), 10);
                            }
                        } else {
                            if (entity instanceof Player) {
                                _player = (Player) entity;
                                _player.getCooldowns().addCooldown(itemstack.getItem(), 10);
                            }

                            itemstack.getOrCreateTag().putBoolean("Used", true);
                        }
                    }

                    itemstack.getOrCreateTag().putBoolean("used_item", false);
                } else {
                    entity.getPersistentData().putBoolean("PRESS_Z", false);
                }
            }


        }

    }
}
