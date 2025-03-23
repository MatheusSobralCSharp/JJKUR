package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;

import java.util.Objects;

public class PassiveKeybindOnKeyReleasedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        NahProcedure.execute(world, x, y, z, entity);
        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 1) {
            if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(JujutsucraftaddonModMobEffects.WORLD_CUT.get()))) {
                if (entity instanceof ServerPlayer && entity.level() instanceof ServerLevel
                        && (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount() >= 15.0)) {
                    if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Sukuna")) {
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel > 0) {
                            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Moveset > 0) {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.WORLD_CUT.get(), 40, 1, false, false));
                                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Moveset == 4) {
                                    if (world.isClientSide()) {
                                        if (entity instanceof AbstractClientPlayer player) {
                                            var animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                            if (animation != null && !animation.isActive()) {
                                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("worldslash" + Mth.nextInt(RandomSource.create(), 1, 4))))));
                                            }
                                        }
                                    }
                                }
                            }
                        } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel == 0) {
                            if (new Object() {
                                public boolean checkGamemode(Entity _ent) {
                                    if (_ent instanceof ServerPlayer _serverPlayer) {
                                        return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
                                    } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
                                        return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                                && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
                                    }
                                    return false;
                                }
                            }.checkGamemode(entity)) {
                                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 60) {
                                    if (new Object() {
                                        public double getValue() {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            return dataIndex.getCompound("ForgeData").getDouble("brokenBrain");
                                        }
                                    }.getValue() == 2) {
                                        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower <= 300) {
                                            if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                                if (entity instanceof ServerPlayer _plr11 && _plr11.level() instanceof ServerLevel
                                                        && _plr11.getAdvancements().getOrStartProgress(_plr11.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:world_slash_advancement"))).isDone()) {
                                                    if (entity instanceof ServerPlayer _plr12 && _plr12.level() instanceof ServerLevel
                                                            && _plr12.getAdvancements().getOrStartProgress(_plr12.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:enchained"))).isDone()
                                                            && entity instanceof ServerPlayer _plr13 && _plr13.level() instanceof ServerLevel
                                                            && _plr13.getAdvancements().getOrStartProgress(_plr13.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:grade_yin_yang"))).isDone()
                                                            && entity instanceof ServerPlayer _plr14 && _plr14.level() instanceof ServerLevel
                                                            && _plr14.getAdvancements().getOrStartProgress(_plr14.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:ultimate_power"))).isDone()) {
                                                        if (entity instanceof ServerPlayer _plr15 && _plr15.level() instanceof ServerLevel
                                                                && _plr15.getAdvancements().getOrStartProgress(_plr15.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:barrierless_domain_perfected"))).isDone()) {
                                                            if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount() >= 19.0) {
                                                                if (!(entity instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(JujutsucraftaddonModMobEffects.HEIAN_FORM.get()))) {
                                                                    if (world.isClientSide()) {
                                                                        if (entity instanceof AbstractClientPlayer player) {
                                                                            var animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                                                            if (animation != null && !animation.isActive()) {
                                                                                animation.setAnimation(new KeyframeAnimationPlayer(Objects.requireNonNull(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "heianform")))));
                                                                            }
                                                                        }
                                                                    }
                                                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                                                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.HEIAN_FORM.get(), -1, 1, false, false));
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                    if (entity instanceof ServerPlayer _plr20 && _plr20.level() instanceof ServerLevel
                                            && _plr20.getAdvancements().getOrStartProgress(_plr20.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:world_slash_advancement"))).isDone()) {
                                        if (entity instanceof ServerPlayer _plr21 && _plr21.level() instanceof ServerLevel
                                                && _plr21.getAdvancements().getOrStartProgress(_plr21.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:enchained"))).isDone() && entity instanceof ServerPlayer _plr22
                                                && _plr22.level() instanceof ServerLevel && _plr22.getAdvancements().getOrStartProgress(_plr22.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:grade_yin_yang"))).isDone()
                                                && entity instanceof ServerPlayer _plr23 && _plr23.level() instanceof ServerLevel
                                                && _plr23.getAdvancements().getOrStartProgress(_plr23.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:ultimate_power"))).isDone()) {
                                            if (entity instanceof ServerPlayer _plr24 && _plr24.level() instanceof ServerLevel
                                                    && _plr24.getAdvancements().getOrStartProgress(_plr24.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:barrierless_domain_perfected"))).isDone()) {
                                                if (entity instanceof ServerPlayer && entity.level() instanceof ServerLevel && (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount() >= 19.0)) {
                                                    if (!(entity instanceof LivingEntity _livEnt26 && _livEnt26.hasEffect(JujutsucraftaddonModMobEffects.HEIAN_FORM.get()))) {
                                                        if (world.isClientSide()) {
                                                            if (entity instanceof AbstractClientPlayer player) {
                                                                var animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                                                if (animation != null && !animation.isActive()) {
                                                                    animation.setAnimation(new KeyframeAnimationPlayer(Objects.requireNonNull(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "heianform")))));
                                                                }
                                                            }
                                                        }
                                                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.HEIAN_FORM.get(), -1, 1, false, false));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 2) {
            if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Gojo")) {
                if (!(entity instanceof LivingEntity _livEnt29 && _livEnt29.hasEffect(JujutsucraftaddonModMobEffects.WORLD_GOJO.get()))) {
                    if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SIX_EYES.get())) {
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel > 0) {
                            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Moveset == 2) {
                                if (!entity.isShiftKeyDown()) {
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.WORLD_GOJO.get(), 60, 1, false, false));
                                    if (world.isClientSide()) {
                                        if (entity instanceof AbstractClientPlayer player) {
                                            var animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                            if (animation != null && !animation.isActive()) {
                                                animation.setAnimation(new KeyframeAnimationPlayer(Objects.requireNonNull(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("redskill" + Mth.nextInt(RandomSource.create(), 2, 4)))))));
                                            }
                                        }
                                    }
                                } else {
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.WORLD_GOJO.get(), 60, 1, false, false));
                                    if (world.isClientSide()) {
                                        if (entity instanceof AbstractClientPlayer player) {
                                            var animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                            if (animation != null && !animation.isActive()) {
                                                animation.setAnimation(new KeyframeAnimationPlayer(Objects.requireNonNull(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "redunlimited")))));
                                            }
                                        }
                                    }

                                }
                            } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Moveset == 4) {
                                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel >= 4) {
                                    if (world.isClientSide()) {
                                        if (entity instanceof AbstractClientPlayer player) {
                                            var animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                            if (animation != null && !animation.isActive()) {
                                                animation.setAnimation(new KeyframeAnimationPlayer(Objects.requireNonNull(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "murasaki2")))));
                                            }
                                        }
                                    }


                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.WORLD_GOJO.get(), 240, 1, false, false));
                                    UnlimitedPurpleProcedure.execute(world, x, y, z, entity);
                                }
                            } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Moveset == 1) {
                                if (!entity.isShiftKeyDown()) {
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.WORLD_GOJO.get(), 20, 1, false, false));
                                    if (world.isClientSide()) {
                                        if (entity instanceof AbstractClientPlayer player) {
                                            var animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                            if (animation != null && !animation.isActive()) {
                                                animation.setAnimation(new KeyframeAnimationPlayer(Objects.requireNonNull(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("blue" + Mth.nextInt(RandomSource.create(), 1, 2)))))));
                                            }
                                        }
                                    }

                                } else {
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.WORLD_GOJO.get(), 40, 1, false, false));
                                    if (world.isClientSide()) {
                                        if (entity instanceof AbstractClientPlayer player) {
                                            var animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                            if (animation != null && !animation.isActive()) {
                                                animation.setAnimation(new KeyframeAnimationPlayer(Objects.requireNonNull(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "blueenchanted")))));
                                            }
                                        }
                                    }

                                }
                            } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Moveset == 5) {
                                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel >= 4) {
                                    if (world.isClientSide()) {
                                        if (entity instanceof AbstractClientPlayer player) {
                                            var animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                            if (animation != null && !animation.isActive()) {
                                                animation.setAnimation(new KeyframeAnimationPlayer(Objects.requireNonNull(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "bluebarrage")))));
                                            }
                                        }
                                    }

                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.WORLD_GOJO.get(), 30, 1, false, false));
                                }
                            } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Moveset == 3) {
                                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel >= 4) {
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.WORLD_GOJO.get(), 240, 1, false, false));
                                    if (world.isClientSide()) {
                                        if (entity instanceof AbstractClientPlayer player) {
                                            var animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                            if (animation != null && !animation.isActive()) {
                                                animation.setAnimation(new KeyframeAnimationPlayer(Objects.requireNonNull(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "murasaki")))));
                                            }
                                        }

                                    }
                                    {
                                        Entity _ent = entity;
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "particle jjkueffects:red_and_blue ~ ~1 ~ 0 0 0 1 1 force");
                                        }
                                    }
                                    if (!(entity instanceof LivingEntity _livEnt50 && _livEnt50.hasEffect(JujutsucraftaddonModMobEffects.MURASAKI_EFFECT.get()))) {
                                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MURASAKI_EFFECT.get(), 240, 1, false, false));

                                    }
                                }
                            } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel == 0) {
                                if (new Object() {
                                    public boolean checkGamemode(Entity _ent) {
                                        if (_ent instanceof ServerPlayer _serverPlayer) {
                                            return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
                                        } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
                                            return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                                    && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
                                        }
                                        return false;
                                    }
                                }.checkGamemode(entity)) {
                                    if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 60) {
                                        if (new Object() {
                                            public double getValue() {
                                                CompoundTag dataIndex = new CompoundTag();
                                                entity.saveWithoutId(dataIndex);
                                                return dataIndex.getCompound("ForgeData").getDouble("brokenBrain");
                                            }
                                        }.getValue() == 2) {
                                            if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower <= 300) {
                                                if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SIX_EYES.get())) {
                                                    if (entity instanceof ServerPlayer _plr57 && _plr57.level() instanceof ServerLevel
                                                            && _plr57.getAdvancements().getOrStartProgress(_plr57.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:gojo_training_part_4"))).isDone()
                                                            && entity instanceof ServerPlayer _plr58 && _plr58.level() instanceof ServerLevel
                                                            && _plr58.getAdvancements().getOrStartProgress(_plr58.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:grade_yin_yang"))).isDone()
                                                            && entity instanceof ServerPlayer _plr59 && _plr59.level() instanceof ServerLevel
                                                            && _plr59.getAdvancements().getOrStartProgress(_plr59.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:last_hope"))).isDone()) {
                                                        if (entity instanceof ServerPlayer _plr60 && _plr60.level() instanceof ServerLevel
                                                                && _plr60.getAdvancements().getOrStartProgress(_plr60.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:barrierless_domain_perfected"))).isDone()) {
                                                            if (!(entity instanceof LivingEntity _livEnt61 && _livEnt61.hasEffect(JujutsucraftaddonModMobEffects.GOJO_AWAKENING_1.get()))) {
                                                                if (world.isClientSide()) {
                                                                    if (entity instanceof AbstractClientPlayer player) {
                                                                        var animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                                                        if (animation != null && !animation.isActive()) {
                                                                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "awakeninggojo"))));
                                                                        }
                                                                    }
                                                                }
                                                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                                                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.GOJO_AWAKENING_1.get(), -1, 1, false, false));
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SIX_EYES.get())) {
                                        if (entity instanceof ServerPlayer _plr65 && _plr65.level() instanceof ServerLevel
                                                && _plr65.getAdvancements().getOrStartProgress(_plr65.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:gojo_training_part_4"))).isDone()
                                                && entity instanceof ServerPlayer _plr66 && _plr66.level() instanceof ServerLevel
                                                && _plr66.getAdvancements().getOrStartProgress(_plr66.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:grade_yin_yang"))).isDone() && entity instanceof ServerPlayer _plr67
                                                && _plr67.level() instanceof ServerLevel && _plr67.getAdvancements().getOrStartProgress(_plr67.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:last_hope"))).isDone()) {
                                            if (entity instanceof ServerPlayer _plr68 && _plr68.level() instanceof ServerLevel
                                                    && _plr68.getAdvancements().getOrStartProgress(_plr68.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:barrierless_domain_perfected"))).isDone()) {
                                                if (!(entity instanceof LivingEntity _livEnt69 && _livEnt69.hasEffect(JujutsucraftaddonModMobEffects.GOJO_AWAKENING_1.get()))) {
                                                    if (world.isClientSide()) {
                                                        if (entity instanceof AbstractClientPlayer player) {
                                                            var animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                                            if (animation != null && !animation.isActive()) {
                                                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "awakeninggojo"))));
                                                            }
                                                        }
                                                    }
                                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.GOJO_AWAKENING_1.get(), -1, 1, false, false));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
