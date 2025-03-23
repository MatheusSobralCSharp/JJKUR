package com.jujutsu.jujutsucraftaddon.archived;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public class ArchiveStyles {
    private void onPlayerAttack(CallbackInfoReturnable<Boolean> cir) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player != null && mc.level != null && mc.level.isClientSide()) {
            ModifierLayer animation;
            Entity entiry_a;
            entiry_a = mc.player;
            AbstractClientPlayer player = mc.player;
            LevelAccessor world = mc.level;
            if (mc.level.isClientSide() && entiry_a != null) {
                if ((entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Run == 1) {
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

                                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                            if (animation != null && !animation.isActive()) {
                                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("attack" + Mth.nextInt(RandomSource.create(), 2, 39))))));
                                            }
                                            return;

                                        } else if (!((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()
                                                || (entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get())) {


                                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                            if (animation != null && !animation.isActive()) {
                                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("sword" + Mth.nextInt(RandomSource.create(), 1, 10))))));
                                            }
                                            return;


                                        }
                                    } else if (Math.random() < 0.5 && Math.random() > 0.3) {
                                        if ((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
                                                || (entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get()
                                                || (entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()) {

                                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                            if (animation != null && !animation.isActive()) {
                                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("attack" + Mth.nextInt(RandomSource.create(), 2, 39))))));
                                            }
                                            return;


                                        } else if (!((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()
                                                || (entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get())) {


                                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                            if (animation != null && !animation.isActive()) {
                                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("sword" + Mth.nextInt(RandomSource.create(), 10, 24))))));
                                            }


                                        }
                                    } else if (Math.random() < 0.7 && Math.random() > 0.5) {
                                        if ((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
                                                || (entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get()
                                                || (entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()) {

                                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                            if (animation != null && !animation.isActive()) {
                                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("attack" + Mth.nextInt(RandomSource.create(), 2, 39))))));
                                            }
                                            return;


                                        } else if (!((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()
                                                || (entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get())) {


                                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                            if (animation != null && !animation.isActive()) {
                                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("sword" + Mth.nextInt(RandomSource.create(), 1, 24))))));
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


                                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                        if (animation != null && !animation.isActive()) {
                                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("soul" + Mth.nextInt(RandomSource.create(), 1, 5))))));
                                        }


                                    } else if (Math.random() < 0.7 && Math.random() > 0.5) {

                                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                        if (animation != null && !animation.isActive()) {
                                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("soul" + Mth.nextInt(RandomSource.create(), 1, 5))))));
                                        }


                                    }
                                } else if ((ForgeRegistries.ITEMS.getKey((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:playful_cloud")) {


                                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                    if (animation != null && !animation.isActive()) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("ab" + Mth.nextInt(RandomSource.create(), 1, 5) + "player")))));
                                    }


                                }
                            } else {


                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                if (animation != null && !animation.isActive()) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("nyoi" + Mth.nextInt(RandomSource.create(), 1, 9))))));
                                }


                            }
                        } else {


                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                            if (animation != null && !animation.isActive()) {
                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("kusa" + Mth.nextInt(RandomSource.create(), 1, 6))))));
                            }


                        }
                    } else {

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

