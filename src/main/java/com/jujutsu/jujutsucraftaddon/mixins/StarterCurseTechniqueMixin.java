package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.CursedTechniqueStarterRightClickedInAirProcedure;
import net.mcreator.jujutsucraft.procedures.KeyChangeTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraft.procedures.StartCursedTechniqueProcedure;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
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

@Mixin(value = CursedTechniqueStarterRightClickedInAirProcedure.class, priority = -10000)
public abstract class StarterCurseTechniqueMixin {
    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack, CallbackInfo ci) {
        ci.cancel();
        if (entity != null) {
            double old_select = 0.0;
            double old_technique = 0.0;
            boolean old_second = false;
            Entity _ent;
            Player _player;
            if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique) == 5 || world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_EXTRACTOR_ALLOW)) {
                if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique == 5 && entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).InfusedDomain) {
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                        capability.PlayerCurseTechnique = itemstack.getOrCreateTag().getDouble("TechniqueNumber1");
                        capability.syncPlayerVariables(entity);
                    });

                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                        capability.PlayerCurseTechnique2 = itemstack.getOrCreateTag().getDouble("TechniqueNumber1");
                        capability.syncPlayerVariables(entity);
                    });

                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 6000, 0, false, false));

                    if (entity instanceof Player _player2) {
                        ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
                        _player2.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player2.inventoryMenu.getCraftSlots());
                    }
                }

                if (itemstack.getOrCreateTag().getString("TechniqueName").equals("")) {
                    itemstack.setHoverName(Component.literal(((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName));
                    itemstack.getOrCreateTag().putString("TechniqueName", ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName);
                    itemstack.getOrCreateTag().putDouble("TechniqueNumber1", ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique);
                    itemstack.getOrCreateTag().putDouble("TechniqueNumber2", ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique);
                    _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound ui.button.click master @s");
                    }

                    if (entity instanceof Player) {
                        _player = (Player) entity;
                        if (!_player.level().isClientSide()) {
                            _player.displayClientMessage(Component.literal(itemstack.getDisplayName().getString()), true);
                        }
                    }

                    if (entity instanceof Player) {
                        _player = (Player) entity;
                        _player.getCooldowns().addCooldown(itemstack.getItem(), 5);
                    }
                } else if (itemstack.getOrCreateTag().getDouble("TechniqueNumber1") == ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique || itemstack.getOrCreateTag().getDouble("TechniqueNumber1") == ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2) {
                    if (entity.getPersistentData().getDouble("skill") == 0.0) {
                        _ent = entity;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound ui.button.click master @s");
                        }

                        old_second = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).SecondTechnique;
                        old_technique = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
                        old_select = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique;
                        double _setval = itemstack.getOrCreateTag().getDouble("TechniqueNumber1");
                        double final_setval = _setval;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                            capability.PlayerCurseTechnique = final_setval;
                            capability.syncPlayerVariables(entity);
                        });
                        _setval = itemstack.getOrCreateTag().getDouble("TechniqueNumber2");
                        double final_setval1 = _setval;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                            capability.PlayerSelectCurseTechnique = final_setval1;
                            capability.syncPlayerVariables(entity);
                        });
                        StartCursedTechniqueProcedure.execute(world, x, y, z, entity);
                        boolean _setval8 = old_second;
                        boolean final_setval2 = _setval8;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                            capability.SecondTechnique = final_setval2;
                            capability.syncPlayerVariables(entity);
                        });
                        double _setval2 = old_technique;
                        double final_setval3 = _setval2;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                            capability.PlayerCurseTechnique = final_setval3;
                            capability.syncPlayerVariables(entity);
                        });

                        double _setval3 = old_select;
                        double final_setval4 = _setval3;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                            capability.PlayerSelectCurseTechnique = final_setval4;
                            capability.syncPlayerVariables(entity);
                        });
                        boolean _setval0 = true;
                        boolean final_setval5 = _setval0;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                            capability.noChangeTechnique = final_setval5;
                            capability.syncPlayerVariables(entity);
                        });
                        KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                        entity.getPersistentData().putBoolean("PRESS_Z", true);
                        if (entity instanceof Player) {
                            _player = (Player) entity;
                            if (!_player.level().isClientSide()) {
                                _player.displayClientMessage(Component.literal(itemstack.getDisplayName().getString()), true);
                            }
                        }

                        if (entity instanceof Player) {
                            _player = (Player) entity;
                            _player.getCooldowns().addCooldown(itemstack.getItem(), 5);
                        }
                    } else {
                        entity.getPersistentData().putBoolean("PRESS_Z", false);
                    }
                }

            }
        }
    }
}
