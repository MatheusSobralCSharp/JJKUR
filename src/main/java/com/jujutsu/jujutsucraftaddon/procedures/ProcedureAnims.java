package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class ProcedureAnims {
    public static void execute(LevelAccessor world, Entity entity) {
        Entity entiry_a = null;
        entiry_a = entity;
        LivingEntity _livEnt;
        ItemStack var10000;
        ModifierLayer animation;
        LivingEntity _living;
        AbstractClientPlayer player;

        if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
            // Ab Animations
            if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.ANIM_1.get())) {
                player = (AbstractClientPlayer) entiry_a;
                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                if (animation != null) {
                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "ab1player"))));
                }
                return;
            } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.ANIM_2.get())) {
                player = (AbstractClientPlayer) entiry_a;
                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                if (animation != null) {
                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "ab2player"))));
                }
                return;
            } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.MURASAKI_EFFECT.get()) && (!(((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.SOKA_MONA.get())))) {
                player = (AbstractClientPlayer) entiry_a;
                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                if (animation != null) {
                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "murasaki"))));
                }
                return;
            } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.WORLD_GOJO.get())) {
                if ((entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel >= 4) {
                    player = (AbstractClientPlayer) entiry_a;
                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                    if (animation != null) {
                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "murasaki2"))));
                    }
                }
                return;
            } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.ANIM_3.get())) {
                player = (AbstractClientPlayer) entiry_a;
                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                if (animation != null) {
                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "ab3player"))));
                }
                return;
            } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.ANIM_4.get())) {
                player = (AbstractClientPlayer) entiry_a;
                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                if (animation != null) {
                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "ab4player"))));
                }
                return;
            } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.DODGE.get())) {
                player = (AbstractClientPlayer) entiry_a;
                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                if (animation != null && !animation.isActive()) {
                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("dodge" + Mth.nextInt(RandomSource.create(), 1, 21))))));
                }
                return;
            } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.JACKPOT.get())) {
                player = (AbstractClientPlayer) entiry_a;
                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                if (animation != null && !animation.isActive()) {
                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "tucadonca"))));
                }
                return;
            } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.SOKA_MONA.get())) {
                player = (AbstractClientPlayer) entiry_a;
                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                if (animation != null && !animation.isActive()) {
                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "soka"))));
                }
                return;
            } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.COUNTER.get())) {
                player = (AbstractClientPlayer) entiry_a;
                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                if (animation != null && !animation.isActive()) {
                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("counterhr" + Mth.nextInt(RandomSource.create(), 1, 7))))));
                }
                return;
            } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.ANIMATION_HEIAN.get())) {
                player = (AbstractClientPlayer) entiry_a;
                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                if (animation != null && !animation.isActive()) {
                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "heianform"))));
                }
                return;
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
            }

            if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.ANIMATION.get())) {
                if ((entiry_a.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 1) {
                    player = (AbstractClientPlayer) entiry_a;
                    if (!((ForgeRegistries.ITEMS.getKey((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("kusakabe"))) {
                        if (!((ForgeRegistries.ITEMS.getKey((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("nyoi"))) {
                            if (!((ForgeRegistries.ITEMS.getKey((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:split_soul_katana")
                                    || (ForgeRegistries.ITEMS.getKey((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:playful_cloud"))) {
                                if (Math.random() < 0.3 && Math.random() > 0.1) {
                                    if ((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
                                            || (entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get()
                                            || (entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()) {
                                        if (world.isClientSide()) {
                                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                            if (animation != null && !animation.isActive()) {
                                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("attack" + Mth.nextInt(RandomSource.create(), 2, 39))))));
                                            }

                                        }
                                    } else if (!((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()
                                            || (entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get())) {
                                        if (world.isClientSide()) {

                                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                            if (animation != null && !animation.isActive()) {
                                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("sword" + Mth.nextInt(RandomSource.create(), 1, 10))))));
                                            }

                                        }

                                    }
                                } else if (Math.random() < 0.5 && Math.random() > 0.3) {
                                    if ((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
                                            || (entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get()
                                            || (entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()) {
                                        if (world.isClientSide()) {

                                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                            if (animation != null && !animation.isActive()) {
                                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("attack" + Mth.nextInt(RandomSource.create(), 2, 39))))));
                                            }
                                        }

                                    } else if (!((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()
                                            || (entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get())) {
                                        if (world.isClientSide()) {

                                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                            if (animation != null && !animation.isActive()) {
                                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("sword" + Mth.nextInt(RandomSource.create(), 10, 24))))));
                                            }

                                        }
                                    }
                                } else if (Math.random() < 0.7 && Math.random() > 0.5) {
                                    if ((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
                                            || (entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get()
                                            || (entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()) {
                                        if (world.isClientSide()) {
                                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                            if (animation != null && !animation.isActive()) {
                                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("attack" + Mth.nextInt(RandomSource.create(), 2, 39))))));
                                            }

                                        }

                                    } else if (!((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()
                                            || (entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get())) {
                                        if (world.isClientSide()) {

                                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                            if (animation != null && !animation.isActive()) {
                                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("sword" + Mth.nextInt(RandomSource.create(), 1, 24))))));
                                            }

                                        }
                                    }
                                }
                            } else if ((ForgeRegistries.ITEMS.getKey((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:split_soul_katana")) {
                                if (Math.random() < 0.3 && Math.random() > 0.1) {
                                    if (world.isClientSide()) {

                                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                        if (animation != null && !animation.isActive()) {
                                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("soul" + Mth.nextInt(RandomSource.create(), 1, 5))))));
                                        }

                                    }

                                } else if (Math.random() < 0.5 && Math.random() > 0.3) {
                                    if (world.isClientSide()) {

                                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                        if (animation != null && !animation.isActive()) {
                                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("soul" + Mth.nextInt(RandomSource.create(), 1, 5))))));
                                        }

                                    }

                                } else if (Math.random() < 0.7 && Math.random() > 0.5) {
                                    if (world.isClientSide()) {

                                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                        if (animation != null && !animation.isActive()) {
                                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("soul" + Mth.nextInt(RandomSource.create(), 1, 5))))));
                                        }

                                    }

                                }
                            } else if ((ForgeRegistries.ITEMS.getKey((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:playful_cloud")) {
                                if (world.isClientSide()) {

                                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                    if (animation != null && !animation.isActive()) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("ab" + Mth.nextInt(RandomSource.create(), 1, 5) + "player")))));
                                    }

                                }


                            }
                        } else {
                            if (world.isClientSide()) {

                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                if (animation != null && !animation.isActive()) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("nyoi" + Mth.nextInt(RandomSource.create(), 1, 9))))));
                                }

                            }
                        }
                    } else {
                        if (world.isClientSide()) {

                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                            if (animation != null && !animation.isActive()) {
                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("kusa" + Mth.nextInt(RandomSource.create(), 1, 6))))));
                            }

                        }
                    }
                } else {
                    if (world.isClientSide()) {
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null && !animation.isActive()) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("sukuna" + Mth.nextInt(RandomSource.create(), 1, 26))))));
                        }

                    }
                }
            }
        }
    }

}
