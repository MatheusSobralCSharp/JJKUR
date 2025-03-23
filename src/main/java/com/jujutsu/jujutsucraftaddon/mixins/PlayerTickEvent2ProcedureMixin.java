package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.entity.PartialRikaEntity;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModEnchantments;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import com.jujutsu.jujutsucraftaddon.procedures.*;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KeyChangeTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraft.procedures.PlayerTickEvent2Procedure;
import net.mcreator.jujutsucraft.procedures.StartGuardProcedure;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import javax.annotation.Nullable;
import java.util.Objects;


@Mixin(value = PlayerTickEvent2Procedure.class, priority = -10000, remap = false)
public abstract class PlayerTickEvent2ProcedureMixin {
    public PlayerTickEvent2ProcedureMixin() {
    }


    /**
     * @author Satushi
     * @reason Changes Tick Event to be more optimized and less laggy + Add some jjku logic
     */

    @Overwrite
    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        boolean changeTechnique = false;
        double PlayerCT2 = 0.0;
        double PlayerCT1 = 0.0;
        String old_name = "";
        ResourceLocation entityTypeKey = ForgeRegistries.ENTITY_TYPES.getKey(entity.getType());
        assert entityTypeKey != null;
        if (entityTypeKey.toString().startsWith("jujutsucraft") && !(entity instanceof PartialRikaEntity)) {
            return;
        }
        if (entity.isAlive()) {
            PlayerCT1 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
            PlayerCT2 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
            boolean _setval;
            if (entity.isShiftKeyDown()) {
                StartGuardProcedure.execute(world, entity);
                if (entity instanceof LivingEntity) {
                    LivingEntity _entity = (LivingEntity) entity;
                    _entity.removeEffect(MobEffects.MOVEMENT_SPEED);
                }

                if (!((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).flag_shift) {
                    _setval = true;
                    boolean final_setval = _setval;
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                        capability.flag_shift = final_setval;
                        capability.syncPlayerVariables(entity);
                    });
                    changeTechnique = true;
                }
            } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).flag_shift) {
                _setval = false;
                boolean final_setval1 = _setval;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                    capability.flag_shift = final_setval1;
                    capability.syncPlayerVariables(entity);
                });
                changeTechnique = true;
            }

            if (changeTechnique && (PlayerCT1 == 6.0 || PlayerCT2 == 6.0)) {
                old_name = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName;
                _setval = true;
                boolean final_setval2 = _setval;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                    capability.noChangeTechnique = final_setval2;
                    capability.syncPlayerVariables(entity);
                });
                KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                if (!old_name.equals(((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)) {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound ui.button.click master @s");
                    }
                }
            }
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).water == 1) {
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
            }


            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BGM) {
                if (entity.level().getGameTime() % 7200 == 0) {
                    if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftaddonModMobEffects.MUSIC.get()))) {
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MUSIC.get(), 60, 1, false, false));
                    }
                }
            }

            if (entity.level().getGameTime() % 12000 == 0) {
                if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 6) {
                    if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_REGENERATE_SHIKIGAMI)) {
                        if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftaddonModMobEffects.REGENERATE_SHIKIGAMI.get()))) {
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.REGENERATE_SHIKIGAMI.get(), 60, 1, false, false));
                        }
                    }
                }
            }


            if (entity.level().getGameTime() % 7200 == 0) {
                if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_SUKUNA_POSSESSION_ENABLED)) {
                    if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount() >= 1.0) {
                        if (!(entity instanceof ServerPlayer _plr1 && _plr1.level() instanceof ServerLevel
                                && _plr1.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:enchained")))).isDone())) {
                            if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(JujutsucraftaddonModMobEffects.SUKUNA_VC.get()))) {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA_VC.get(), 60, 1, false, false));
                            }
                        }
                    }
                }
            }


            if (EnchantmentHelper.getItemEnchantmentLevel(JujutsucraftaddonModEnchantments.CE_HEALTH_REGENERATION.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)) != 0) {
                if (!(entity instanceof LivingEntity _livEnt30 && _livEnt30.hasEffect(MobEffects.REGENERATION))) {
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60,
                                (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getEnchantmentLevel(JujutsucraftaddonModEnchantments.CE_HEALTH_REGENERATION.get()), false, true));
                }
                {
                    double _setval5 = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 1);
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerCursePower = _setval5;
                        capability.syncPlayerVariables(entity);
                    });
                }
            }

            if (entity.getPersistentData().getBoolean("PRESS_BURNOUT")) {
                CounterBurnoutProcedure.execute(entity);
            }

            if (entity.getPersistentData().getBoolean("PRESS_ULT")) {
                UltimatesProcedure.execute(world, x, y, z, entity);
            }


            if (entity.getPersistentData().getBoolean("Meditation")) {
                MeditationPassiveProcedure.execute(world, entity);
            }

            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTMasteryOn) {
                AutoRCTNewProcedure.execute(entity);
            }

            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain) {
                ExtensionTickProcedure.execute(world, x, y, z, entity);
            }
        }
    }
}


