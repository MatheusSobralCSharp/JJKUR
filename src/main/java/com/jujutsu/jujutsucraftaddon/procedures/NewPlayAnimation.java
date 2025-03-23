package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.LogicSwordProcedure;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class NewPlayAnimation {
    public static void execute(@Nullable Event event, LevelAccessor world, DamageSource damagesource, Entity entity) {
        if (damagesource != null && entity != null) {
            if (damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:start_animation"))) && entity instanceof Player) {
                boolean sword = false;
                Entity entiry_a;
                String STR1 = "";
                entiry_a = entity;
                double NUM2 = 0.0;
                double NUM3 = 0.0;
                double rnd = 0.0;
                double NUM1 = 0.0;
                ModifierLayer animation;
                AbstractClientPlayer player;
                if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                    // Ab Animations
                    if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.ANIM_1.get())) {
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "ab1player"))));
                        }
                        if (event != null && event.isCancelable()) {
                            event.setCanceled(true);
                        } else if (event != null && event.hasResult()) {
                            event.setResult(Event.Result.DENY);
                        }

                    } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.ANIM_2.get())) {
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "ab2player"))));
                        }
                        if (event != null && event.isCancelable()) {
                            event.setCanceled(true);
                        } else if (event != null && event.hasResult()) {
                            event.setResult(Event.Result.DENY);
                        }

                    } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.MURASAKI_EFFECT.get()) && (!(((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.SOKA_MONA.get())))) {
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "murasaki"))));
                        }
                    } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.WORLD_GOJO.get())) {
                        if ((entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel >= 4) {
                            player = (AbstractClientPlayer) entiry_a;
                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                            if (animation != null) {
                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "murasaki2"))));
                            }
                        }

                    } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.ANIM_3.get())) {
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "ab3player"))));
                        }
                        if (event != null && event.isCancelable()) {
                            event.setCanceled(true);
                        } else if (event != null && event.hasResult()) {
                            event.setResult(Event.Result.DENY);
                        }

                    } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.ANIM_4.get())) {
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "ab4player"))));
                        }
                        if (event != null && event.isCancelable()) {
                            event.setCanceled(true);
                        } else if (event != null && event.hasResult()) {
                            event.setResult(Event.Result.DENY);
                        }

                    } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.DODGE.get())) {
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null && !animation.isActive()) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("dodge" + Mth.nextInt(RandomSource.create(), 1, 21))))));
                        }
                        if (event != null && event.isCancelable()) {
                            event.setCanceled(true);
                        } else if (event != null && event.hasResult()) {
                            event.setResult(Event.Result.DENY);
                        }

                    } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.JACKPOT.get())) {
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null && !animation.isActive()) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "tucadonca"))));
                        }
                        if (event != null && event.isCancelable()) {
                            event.setCanceled(true);
                        } else if (event != null && event.hasResult()) {
                            event.setResult(Event.Result.DENY);
                        }

                    } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.SOKA_MONA.get())) {
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null && !animation.isActive()) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "soka"))));
                        }
                        if (event != null && event.isCancelable()) {
                            event.setCanceled(true);
                        } else if (event != null && event.hasResult()) {
                            event.setResult(Event.Result.DENY);
                        }

                    } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.COUNTER.get())) {
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null && !animation.isActive()) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("counterhr" + Mth.nextInt(RandomSource.create(), 1, 7))))));
                        }
                        if (event != null && event.isCancelable()) {
                            event.setCanceled(true);
                        } else if (event != null && event.hasResult()) {
                            event.setResult(Event.Result.DENY);
                        }

                    } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.ANIMATION_HEIAN.get())) {
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null && !animation.isActive()) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "heianform"))));
                        }
                        if (event != null && event.isCancelable()) {
                            event.setCanceled(true);
                        } else if (event != null && event.hasResult()) {
                            event.setResult(Event.Result.DENY);
                        }

                    } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.WORLD_CUT.get())) {
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Moveset == 2
                                || (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Moveset == 3) {
                            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel <= 3) {
                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                if (animation != null && !animation.isActive()) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "rapiddismantle"))));
                                }
                                return;
                            } else {


                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                if (animation != null && !animation.isActive()) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "maximum3"))));
                                }
                                return;

                            }

                        } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Moveset == 1) {
                            if (world.isClientSide()) {
                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                if (animation != null && !animation.isActive()) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "spiderwebanim"))));
                                }
                                return;
                            }

                        } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Moveset == 4) {
                            if (world.isClientSide()) {
                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                if (animation != null && !animation.isActive()) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("worldslash" + Mth.nextInt(RandomSource.create(), 1, 4))))));
                                }
                                return;
                            }
                        }

                        if (event != null && event.isCancelable()) {
                            event.setCanceled(true);
                        } else if (event != null && event.hasResult()) {
                            event.setResult(Event.Result.DENY);
                        }

                    } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.ANIMATION_TWO.get())) {
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationYuzuki >= 1
                                && (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationYuzuki < 20) {
                            if (world.isClientSide()) {
                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                if (animation != null && !animation.isActive()) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "swordnpc"))));
                                }
                            }


                            {
                                double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationYuzuki + 1;
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.AnimationYuzuki = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationYuzuki >= 20) {
                            {
                                double _setval = 0;
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.AnimationYuzuki = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        }
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense == 1) {
                            if (world.isClientSide()) {
                                if (entity instanceof AbstractClientPlayer) {
                                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                    if (animation != null) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "defensesword4"))));
                                    }
                                }
                            }

                            {
                                double _setval = 0;
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.AnimationDefense = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense == 2) {
                            if (world.isClientSide()) {

                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                if (animation != null) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "defensesword3"))));
                                }

                            }

                            {
                                double _setval = 0;
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.AnimationDefense = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense == 3) {
                            if (world.isClientSide()) {
                                if (entity instanceof AbstractClientPlayer) {
                                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                    if (animation != null) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "defensesword2"))));
                                    }
                                }
                            }

                            {
                                double _setval = 0;
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.AnimationDefense = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        }
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense >= 4
                                && (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense < 24) {
                            if (world.isClientSide()) {
                                if (entity instanceof AbstractClientPlayer) {
                                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                    if (animation != null && !animation.isActive()) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "red"))));
                                    }
                                }
                            }

                            {
                                double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense + 1;
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.AnimationDefense = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense == 24) {
                            {
                                double _setval = 0;
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.AnimationDefense = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense >= 106
                                && (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense < 116) {
                            if (world.isClientSide()) {
                                if (entity instanceof AbstractClientPlayer) {
                                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                    if (animation != null && !animation.isActive()) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "cleaveweb"))));
                                    }
                                }
                            }

                            {
                                double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense + 1;
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.AnimationDefense = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense == 116) {
                            {
                                double _setval = 0;
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.AnimationDefense = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        }
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense >= 99
                                && (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense < 109) {
                            if (world.isClientSide()) {
                                if (entity instanceof AbstractClientPlayer) {
                                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                    if (animation != null && !animation.isActive()) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "barragekick"))));
                                    }
                                }
                            }

                            {
                                double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense + 1;
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.AnimationDefense = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense == 109) {
                            {
                                double _setval = 0;
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.AnimationDefense = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        }

                        if (event != null && event.isCancelable()) {
                            event.setCanceled(true);
                        } else if (event != null && event.hasResult()) {
                            event.setResult(Event.Result.DENY);
                        }

                    }
                }


                if (!(((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.ANIMATION.get())) || (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.SOKA_MONA.get())) || (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.ANIMATION_TWO.get())) || (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.ANIMATION_HEIAN.get()) || ((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.JACKPOT.get()) || ((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.DODGE.get()) || ((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.WORLD_CUT.get()))) {
                    LivingEntity _livingEntity36;
                    double var10000;
                    label1452:
                    {
                        entiry_a = entity;
                        if (entity instanceof LivingEntity) {
                            _livingEntity36 = (LivingEntity) entity;
                            if (_livingEntity36.getAttributes().hasAttribute((Attribute) JujutsucraftModAttributes.ANIMATION_1.get())) {
                                var10000 = _livingEntity36.getAttribute((Attribute) JujutsucraftModAttributes.ANIMATION_1.get()).getBaseValue();
                                break label1452;
                            }
                        }

                        var10000 = 0.0;
                    }

                    label1447:
                    {
                        NUM1 = var10000;
                        if (entity instanceof LivingEntity) {
                            _livingEntity36 = (LivingEntity) entity;
                            if (_livingEntity36.getAttributes().hasAttribute((Attribute) JujutsucraftModAttributes.ANIMATION_2.get())) {
                                var10000 = _livingEntity36.getAttribute((Attribute) JujutsucraftModAttributes.ANIMATION_2.get()).getBaseValue();
                                break label1447;
                            }
                        }

                        var10000 = 0.0;
                    }
                    LivingEntity _livingEntity6;
                    String animation_name = "";
                    NUM2 = var10000;
                    NUM1 += (double) (NUM1 <= -50.0 && NUM1 >= -100.0 ? 100 : 0);
                    NUM3 = NUM1 >= 0.0 ? NUM1 % 100.0 : 100.0;
                    sword = LogicSwordProcedure.execute(entiry_a);
                    STR1 = Math.random() > 0.5 ? "right" : "left";
                    if (NUM3 >= 0.0 && NUM3 <= 4.0) {
                        if (sword && NUM2 > 0.0) {
                            if (NUM2 != 1.0 && NUM2 != 2.0 && NUM2 != 3.0) {
                                if (NUM2 == 4.0 || NUM2 == 5.0 || NUM2 == 6.0) {
                                    STR1 = "left";
                                }
                            } else {
                                STR1 = "right";
                            }
                        }

                        String var26;
                        if (NUM3 != 0.0 && NUM3 != 2.0 && NUM3 != 3.0) {
                            if (NUM3 == 1.0) {
                                if (sword) {
                                    animation_name = "sword_to_right";
                                } else {
                                    var26 = Math.random() > 0.75 ? "punch_" : "kick_";
                                    animation_name = var26 + STR1;
                                }
                            } else if (NUM3 == 4.0) {
                                animation_name = sword ? "sword_overhead" : "punch_overhead";
                            }
                        } else if (NUM2 != 0.0 && !(NUM2 >= 100.0)) {
                            if (sword) {
                                rnd = Math.ceil(Math.random() * 3.0);
                                animation_name = rnd == 1.0 ? "sword_overhead" : "sword_to_" + STR1;
                            } else {
                                animation_name = "punch_" + STR1;
                            }
                        } else if (sword) {
                            animation_name = "sword_to_" + STR1;
                        } else {
                            var26 = Math.random() > 0.5 ? "kick_" : "punch_";
                            animation_name = var26 + STR1;
                        }
                    } else if (NUM3 == 20.0) {
                        if (NUM1 == 220.0) {
                            animation_name = "red";
                        } else {
                            animation_name = "domain_expansion1";
                        }
                    } else if (NUM1 < 0.0) {
                        if (NUM1 >= -10.0) {
                            if (NUM1 == -1.0) {
                                animation_name = "backstep";
                            } else if (NUM1 == -2.0) {
                                animation_name = "death";
                            } else if (NUM1 == -3.0) {
                                animation_name = "right_arm_up";
                            } else if (NUM1 == -4.0) {
                                animation_name = "both_arm_front";
                            } else if (NUM1 == -5.0) {
                                animation_name = "sword_to_right";
                            }

                            if (NUM1 == -6.0) {
                                animation_name = "kick_" + STR1;
                            } else if (NUM1 == -7.0) {
                                animation_name = "punch_" + STR1;
                            } else if (NUM1 == -8.0) {
                                if (NUM2 == 0.0) {
                                    if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 100) {
                                        animation_name = "rotation";
                                    }
                                } else if (NUM2 == 1.0) {
                                    if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 100) {
                                        animation_name = "rotation2";
                                    }
                                } else if (NUM2 == 2.0) {
                                    animation_name = "ragnaraku2";
                                }
                            } else if (NUM1 == -9.0) {
                                animation_name = "guard";
                            } else if (NUM1 == -10.0) {
                                animation_name = "fall1";
                            }
                        } else if (NUM1 >= -15.0) {
                            animation_name = "dance" + Math.round(NUM1 + 16.0);
                        } else if (NUM1 >= -20.0) {
                            if (NUM1 == -16.0) {
                                animation_name = NUM2 == 0.0 ? "simple_domain1" : "simple_domain2";
                            } else if (NUM1 == -17.0) {
                                animation_name = "clap";
                            } else if (NUM1 == -18.0) {
                                animation_name = "fly";
                            }
                        }
                    } else {
                        if (NUM1 == 107.0) {
                            animation_name = "open";
                        } else if (NUM1 == 207.0) {
                            animation_name = "red";
                        } else if (NUM1 == 618.0) {
                            animation_name = "ten_shadows_technique_mahoraga";
                        }

                        if (NUM1 == 1706.0) {
                            animation_name = "kick_flying";
                        } else if (NUM1 == 1715.0) {
                            animation_name = "wifi";
                        } else if (NUM1 == 2015.0) {
                            animation_name = "plus_ultra";
                        }
                    }

                    if (!animation_name.isEmpty()) {
                        if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                            AbstractClientPlayer player1 = (AbstractClientPlayer) entiry_a;
                            ModifierLayer<IAnimation> animation1 = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player1).get(new ResourceLocation("jujutsucraft", "player_animation"));
                            if (animation1 != null) {
                                animation1.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", animation_name))));
                            }
                        }

//                        if (!world.isClientSide() && entiry_a instanceof Player && world instanceof ServerLevel) {
//                            ServerLevel srvLvl_ = (ServerLevel) world;
//                            List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
//                            synchronized (connections) {
//                                Iterator<Connection> iterator = connections.iterator();
//
//                                while (iterator.hasNext()) {
//                                    Connection connection = (Connection) iterator.next();
//                                    if (!connection.isConnecting() && connection.isConnected()) {
//                                        JujutsucraftMod.PACKET_HANDLER.sendTo(new SetupAnimationsProcedure.JujutsucraftModAnimationMessage(Component.literal(animation_name), entiry_a.getId(), true), connection, NetworkDirection.PLAY_TO_CLIENT);
//                                    }
//                                }
//                            }
//                        }
                    }
                }

                if (entity instanceof LivingEntity _livingEntity6) {
                    if (_livingEntity6.getAttributes().hasAttribute((Attribute) JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity6.getAttribute((Attribute) JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(0.0);
                    }
                }

                if (entity instanceof LivingEntity _livingEntity6) {
                    if (_livingEntity6.getAttributes().hasAttribute((Attribute) JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity6.getAttribute((Attribute) JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                    }
                }

                if (event != null && event.isCancelable()) {
                    event.setCanceled(true);
                } else if (event != null && event.hasResult()) {
                    event.setResult(Event.Result.DENY);
                }
            }
        }
    }
}

