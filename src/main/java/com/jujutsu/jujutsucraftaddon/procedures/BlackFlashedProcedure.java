package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.ItadoriShinjukuEntity;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class BlackFlashedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null || !(world instanceof ServerLevel serverLevel))
            return;
        if (world instanceof Level _level) {
            if (!_level.isClientSide()) {
                _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:kokusennnn"))), SoundSource.NEUTRAL, 1, 1);
            } else {
                _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:kokusennnn"))), SoundSource.NEUTRAL, 1, 1, false);
            }
        }
        if (!((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.ZONE.get()))) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.ZONE.get(), 6000, 0, false, false));

        } else if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.ZONE.get())) {
            if (!(entity instanceof ItadoriShinjukuEntity)) {
                ResourceLocation entityTypeKey = ForgeRegistries.ENTITY_TYPES.getKey(entity.getType());
                assert entityTypeKey != null;
                if (entityTypeKey.toString().startsWith("jujutsucraft")) {
                    if (serverLevel.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_ZONE_STACK)) {
                        if ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.ZONE.get()) ? Objects.requireNonNull(((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.ZONE.get())).getAmplifier() : 0) <= (serverLevel.getLevelData()
                                .getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_ZONE_STACK_CAP))) {
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.ZONE.get(), 1200,
                                        (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.ZONE.get()) ? Objects.requireNonNull(((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.ZONE.get())).getAmplifier() : 0) + 1,
                                        false, false));
                        }
                    }
                    if (Math.random() < (1) / ((float) 5)) {
                        entity.getPersistentData().putDouble("cnt_reverse_lim", 0);
                    }
                } else {
                    if (Math.random() < (1) / ((float) 2)) {
                        if (serverLevel.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_ZONE_STACK)) {
                            if ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.ZONE.get()) ? Objects.requireNonNull(((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.ZONE.get())).getAmplifier() : 0) <= (serverLevel.getLevelData()
                                    .getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_ZONE_STACK_CAP))) {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.ZONE.get(), 600,
                                            (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.ZONE.get()) ? Objects.requireNonNull(((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.ZONE.get())).getAmplifier() : 0) + 1,
                                            false, false));
                            }
                        }
                    }

                }
            }

            if (Math.random() <= 0.05) {
                CompoundTag dataIndex8 = new CompoundTag();
                entity.saveWithoutId(dataIndex8);
                dataIndex8.getCompound("ForgeData").putDouble("brokenBrain", 0);
                entity.load(dataIndex8);
            } else if (Math.random() <= 0.1) {
                if (entity instanceof LivingEntity _entity)
                    _entity.removeEffect(JujutsucraftModMobEffects.UNSTABLE.get());
            } else if (Math.random() <= 0.2) {
                if (entity.getPersistentData().getBoolean("JujutsuSorcerer")) {
                    if (entity instanceof LivingEntity _entity)
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get(), 40, 2, false, false));
                }
                if (entity instanceof LivingEntity _entity)
                    _entity.removeEffect(MobEffects.WEAKNESS);
                if (entity instanceof LivingEntity _entity)
                    _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
            } else if (Math.random() <= 0.3) {
                if (entity instanceof LivingEntity _entity)
                    _entity.removeEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get());
            }
        }
        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel < 5) {

            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Vow2 < 2) {
                {
                    double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel + 1;
                    entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.OutputLevel = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
            } else {
                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel < 5) {
                    {
                        double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel + 1;
                        entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.OutputLevel = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }

                }
            }
        } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel >= 5) {
            if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Profession).equals("Warrior")) {
                if (!(entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(JujutsucraftaddonModMobEffects.ONE_HUNDRED_AND_TWENTY.get()))) {
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ONE_HUNDRED_AND_TWENTY.get(), 1200, 1, false, false));

                    {
                        Entity _ent = entity;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                    _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run title @s subtitle {\"text\":\"They Have Brought Out...\",\"color\":\"aqua\",\"bold\":true}");
                        }
                    }
                    {
                        Entity _ent = entity;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                    _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), (("execute as @s run title @s title {\"text\":\"" + "120%") + "\",\"color\":\"aqua\",\"bold\":true}"));
                        }
                    }
                }
            } else if (!((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Profession).equals("Warrior")) {
                {
                    double _setval = 1;
                    entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.OutputLevel = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
            }

        }
        if (entity instanceof ServerPlayer _plr16 && _plr16.level() instanceof ServerLevel
                && _plr16.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr16.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:mastery_black_flash")))).isDone()) {
            ItadoriClan2Procedure.execute(world, entity);
        }
        if (!(entity instanceof ServerPlayer _plr17 && _plr17.level() instanceof ServerLevel
                && _plr17.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr17.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:mastery_black_flash")))).isDone())) {
            if (Math.random() < 0.005) {
                {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(
                                new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
                                        _ent.level().getServer(), _ent),
                                "execute if entity @s[advancements={jujutsucraft:black_flash=true}] as @s[advancements={jujutsucraft:black_flash=true}] run advancement grant @s only jujutsucraftaddon:rampage");
                    }
                }
            }
        } else if (entity instanceof ServerPlayer _plr19 && _plr19.level() instanceof ServerLevel
                && _plr19.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr19.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:mastery_black_flash")))).isDone()) {
            {
                Entity _ent = entity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    _ent.getServer().getCommands().performPrefixedCommand(
                            new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
                                    Objects.requireNonNull(_ent.level().getServer()), _ent),
                            "execute if entity @s[advancements={jujutsucraft:black_flash=true}] as @s[advancements={jujutsucraft:black_flash=true}] run advancement grant @s only jujutsucraftaddon:rampage");
                }
            }
        }
        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 15) {
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:kokusenmahito"))), SoundSource.NEUTRAL, 1, 1);
                } else {
                    _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:kokusenmahito"))), SoundSource.NEUTRAL, 1, 1, false);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 21) {
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:kokusen"))), SoundSource.NEUTRAL, 1, 1);
                } else {
                    _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:kokusen"))), SoundSource.NEUTRAL, 1, 1, false);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 20) {
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:kokusentodo"))), SoundSource.NEUTRAL, 1, 1);
                } else {
                    _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:kokusentodo"))), SoundSource.NEUTRAL, 1, 1, false);
                }
            }
        }
        if (entity instanceof ServerPlayer _plr27 && _plr27.level() instanceof ServerLevel
                && _plr27.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr27.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:rampage")))).isDone()) {
            if (!world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_NO_BLACK_FLASH_CUTSCENE)) {
                if (!(entity instanceof LivingEntity _livEnt29 && _livEnt29.hasEffect(JujutsucraftaddonModMobEffects.KOKUSEN_EFFECT_TWO.get()))) {
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.KOKUSEN_EFFECT_TWO.get(), 300, 1, false, false));
                }
                if (!((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Kokusen == 1)) {
                    if (world.isClientSide()) {
                        if (entity instanceof AbstractClientPlayer player) {
                            var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                            if (animation != null && !animation.isActive()) {
                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("punch" + Mth.nextInt(RandomSource.create(), 1, 10))))));
                            }
                        }
                    }
                    {
                        double _setval = 1;
                        entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.Kokusen = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                    {
                        Entity _ent = entity;
                        _ent.teleportTo((entity.getX()), (entity.getY() + 1), (entity.getZ()));
                        if (_ent instanceof ServerPlayer _serverPlayer)
                            _serverPlayer.connection.teleport((entity.getX()), (entity.getY() + 1), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
                    }
                    CompoundTag dataIndex37 = new CompoundTag();
                    entity.saveWithoutId(dataIndex37);
                    dataIndex37.getCompound("ForgeData").putDouble("Kokusen", 1);
                    entity.load(dataIndex37);
                }
            } else if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_NO_BLACK_FLASH_CUTSCENE)) {

            }
            {
                Entity _ent = entity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                            _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run advancement revoke @s only jujutsucraftaddon:rampage");
                }
            }
        }
        if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(JujutsucraftaddonModMobEffects.FATIGUE_BLACK_FLASH.get()))) {
            if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 21) {
                if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 20) {
                    {
                        double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower + 150);
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.PlayerCursePower = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }

                }
            }
        }


    }
}