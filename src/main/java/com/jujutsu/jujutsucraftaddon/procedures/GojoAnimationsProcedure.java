package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class GojoAnimationsProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (entity.getPersistentData().getDouble("PRESS_Z") == 1 && entity.getPersistentData().getDouble("skill") == 215) {
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain) {
                if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(JujutsucraftaddonModMobEffects.GOJO_IMBUED_POWER.get())) {

                }
            }
        }
        if (entity.getPersistentData().getDouble("PRESS_Z") == 1 && entity.getPersistentData().getDouble("skill") == 215 && entity.getPersistentData().getDouble("cnt1") >= 0) {
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).soka == 0) {
                if (!(entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain) {
                    {
                        Entity _ent = entity;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                    _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run stopsound @s * jujutsucraft:electric_shock");
                        }
                    }

                    if (entity instanceof ServerPlayer _plr12 && _plr12.level() instanceof ServerLevel
                            && _plr12.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr12.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:gojo_training_part_3")))).isDone()) {
                        if (entity.getPersistentData().getDouble("cnt6") > 5) {
                            if (entity.getPersistentData().getDouble("cnt6") <= 50) {
                                entity.getPersistentData().putDouble("cnt6", (entity.getPersistentData().getDouble("cnt6") + 1));
                            }
                        }
                    }
                }
            }
        }
        if (entity.getPersistentData().getDouble("PRESS_Z") == 215) {
            if (!(entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain) {
                if (!entity.isShiftKeyDown()) {
                    if (entity.getPersistentData().getDouble("cnt6") == 1) {
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).gojosund != 1) {
                            {
                                double _setval = 1;
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.gojosund = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        }
                    }
                }
            }
        }
        if (entity.getPersistentData().getDouble("PRESS_Z") == 1 && entity.getPersistentData().getDouble("skill") == 206 && entity.getPersistentData().getDouble("cnt1") >= 0) {
            if (!(entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain) {
                if (entity.isShiftKeyDown()) {

                    if (entity instanceof ServerPlayer _plr25 && _plr25.level() instanceof ServerLevel
                            && _plr25.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr25.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:gojo_training_part_3")))).isDone()) {
                        if (entity.getPersistentData().getDouble("cnt6") > 5) {
                            if (entity.getPersistentData().getDouble("cnt6") <= 10) {
                                entity.getPersistentData().putDouble("cnt6", (entity.getPersistentData().getDouble("cnt6") + 1));
                            }
                        }
                    }
                }
            }
            if (entity.getPersistentData().getDouble("PRESS_Z") == 1 && entity.getPersistentData().getDouble("skill") == 206 && entity.getPersistentData().getDouble("cnt1") == 1) {
                if (!(entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain) {
                    if (entity.isShiftKeyDown()) {
                        if (!(entity instanceof LivingEntity _livEnt34 && _livEnt34.hasEffect(JujutsucraftaddonModMobEffects.GOJO_BLUE_ANIM.get()))) {
                            if (world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:maximumblu"))), SoundSource.NEUTRAL, 1, 1);
                                } else {
                                    _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:maximumblu"))), SoundSource.NEUTRAL, 1, 1, false);
                                }
                            }
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.GOJO_BLUE_ANIM.get(), 100, 1, false, false));
                        }
                    }
                }
            }
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).gojosund == 1
                    && (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).gojosund < 2) {
                {
                    double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).gojosund + 1;
                    entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.gojosund = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
                {
                    double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).gojosund + 1;
                    entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.gojosund = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
                {
                    double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).gojosund + 1;
                    entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.gojosund = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
                {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                _ent.getName().getString(), _ent.getDisplayName(), Objects.requireNonNull(_ent.level().getServer()), _ent), "execute as @s run stopsound @s");
                    }
                }
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:satorugojo"))), SoundSource.NEUTRAL, 1, 1);
                    } else {
                        _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:satorugojo"))), SoundSource.NEUTRAL, 1, 1, false);
                    }
                }
            }
        }
    }
}
