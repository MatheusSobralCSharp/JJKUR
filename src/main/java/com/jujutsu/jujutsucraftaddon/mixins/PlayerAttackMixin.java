package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import com.jujutsu.jujutsucraftaddon.network.PacketEffects;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
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
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Minecraft.class)
public class PlayerAttackMixin {
    @Inject(method = "startAttack", at = @At("HEAD"))
    private void onPlayerAttack(CallbackInfoReturnable<Boolean> cir) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player != null && mc.level != null) {
            ModifierLayer animation;
            Entity entiry_a;
            entiry_a = mc.player;
            AbstractClientPlayer player = mc.player;
            LevelAccessor world = mc.level;
            if (((ForgeRegistries.ITEMS.getKey((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("knife")))  {
                if ((entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans.contains("Majima")) {
                    if (Math.random() < (1) / ((float) 40)) {
                        JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(4, entiry_a.getUUID()));
                        JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(0, entiry_a.getUUID()));
                    }
                }
            }

            if ((entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Run == 1) {
                if (entiry_a instanceof LivingEntity _livEnt2 && _livEnt2.getMainHandItem().isEmpty()) {
                    if ((entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Style == 0) {
                        int lastIndex = (int) (entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AttackAnimation;
                        lastIndex = lastIndex >= 4 ? 1 : lastIndex + 1;
                        {
                            int finalLastIndex = lastIndex;
                            entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.AttackAnimation = finalLastIndex;
                                capability.syncPlayerVariables(entiry_a);
                            });
                        }
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null) {
                            animation.setAnimation(new KeyframeAnimationPlayer(
                                    PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "basicstyle" + lastIndex))
                            ));
                        }
                        if (Math.random() < (1) / ((float) 5)) {
                            JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(8, entiry_a.getUUID()));
                        }
                        JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(0, entiry_a.getUUID()));
                    }
                    if ((entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Style == 1) {
                        int lastIndex = (int) (entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AttackAnimation;
                        lastIndex = lastIndex >= 5 ? 1 : lastIndex + 1;
                        if (Math.random() < (1) / ((float) 20)) {
                            player = (AbstractClientPlayer) entiry_a;
                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                            if (animation != null) {
                                animation.setAnimation(new KeyframeAnimationPlayer(
                                        PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "gojostylebarrage"))
                                ));
                            }
                            JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(9, entiry_a.getUUID()));
                            JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(0, entiry_a.getUUID()));
                        } else {
                            {
                                int finalLastIndex = lastIndex;
                                entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.AttackAnimation = finalLastIndex;
                                    capability.syncPlayerVariables(entiry_a);
                                });
                            }
                            player = (AbstractClientPlayer) entiry_a;
                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                            if (animation != null) {
                                animation.setAnimation(new KeyframeAnimationPlayer(
                                        PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "gojostyle" + lastIndex))
                                ));
                            }
                            if (Math.random() < (1) / ((float) 5)) {
                                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(8, entiry_a.getUUID()));
                            }
                            JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(0, entiry_a.getUUID()));
                        }
                    }
                    if ((entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Style == 2) {
                        int lastIndex = (int) (entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AttackAnimation;
                        lastIndex = lastIndex >= 6 ? 1 : lastIndex + 1;
                        if (Math.random() < (1) / ((float) 20)) {
                            player = (AbstractClientPlayer) entiry_a;
                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                            if (animation != null) {
                                animation.setAnimation(new KeyframeAnimationPlayer(
                                        PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "yujistylecombo"))
                                ));
                            }
                            JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(9, entiry_a.getUUID()));
                            JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(0, entiry_a.getUUID()));
                        } else if (Math.random() < (1) / ((float) 15)) {
                            player = (AbstractClientPlayer) entiry_a;
                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                            if (animation != null) {
                                animation.setAnimation(new KeyframeAnimationPlayer(
                                        PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "yujistylemanjikick"))
                                ));
                            }
                            JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(9, entiry_a.getUUID()));
                            JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(0, entiry_a.getUUID()));
                        } else {
                            {
                                int finalLastIndex = lastIndex;
                                entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.AttackAnimation = finalLastIndex;
                                    capability.syncPlayerVariables(entiry_a);
                                });
                            }
                            player = (AbstractClientPlayer) entiry_a;
                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                            if (animation != null) {
                                animation.setAnimation(new KeyframeAnimationPlayer(
                                        PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "yujistyle" + lastIndex))
                                ));
                            }
                            if (Math.random() < (1) / ((float) 5)) {
                                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(8, entiry_a.getUUID()));
                            }
                            JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(0, entiry_a.getUUID()));

                        }
                    }
                    if ((entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Style == 3) {
                        int lastIndex = (int) (entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AttackAnimation;
                        lastIndex = lastIndex >= 5 ? 1 : lastIndex + 1;
                        {
                            int finalLastIndex = lastIndex;
                            entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.AttackAnimation = finalLastIndex;
                                capability.syncPlayerVariables(entiry_a);
                            });
                        }
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null) {
                            animation.setAnimation(new KeyframeAnimationPlayer(
                                    PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "kashimo" + lastIndex))
                            ));
                        }
                        if (Math.random() < (1) / ((float) 5)) {
                            JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(8, entiry_a.getUUID()));
                        }
                        JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(0, entiry_a.getUUID()));
                    }
                    if ((entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Style == 4) {
                        int lastIndex = (int) (entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AttackAnimation;
                        lastIndex = lastIndex >= 5 ? 1 : lastIndex + 1;
                        {
                            int finalLastIndex = lastIndex;
                            entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.AttackAnimation = finalLastIndex;
                                capability.syncPlayerVariables(entiry_a);
                            });
                        }
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null) {
                            animation.setAnimation(new KeyframeAnimationPlayer(
                                    PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "jogo" + lastIndex))
                            ));
                        }
                        if (Math.random() < (1) / ((float) 5)) {
                            JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(8, entiry_a.getUUID()));
                        }
                        JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(0, entiry_a.getUUID()));
                    }
                    if ((entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Style == 5) {
                        int lastIndex = (int) (entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AttackAnimation;
                        lastIndex = lastIndex >= 5 ? 1 : lastIndex + 1;
                        if (Math.random() < (1) / ((float) 20)) {
                            JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(5, entiry_a.getUUID()));
                        } else if (Math.random() < (1) / ((float) 15)) {
                            JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(6, entiry_a.getUUID()));
                        }
                        {
                            int finalLastIndex = lastIndex;
                            entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.AttackAnimation = finalLastIndex;
                                capability.syncPlayerVariables(entiry_a);
                            });
                        }
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null) {
                            animation.setAnimation(new KeyframeAnimationPlayer(
                                    PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "maki" + lastIndex))
                            ));
                        }
                        if (Math.random() < (1) / ((float) 5)) {
                            JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(8, entiry_a.getUUID()));
                        }
                        JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(0, entiry_a.getUUID()));
                    }
                    if ((entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Style == 6) {
                        int lastIndex = (int) (entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AttackAnimation;
                        lastIndex = lastIndex >= 5 ? 1 : lastIndex + 1;
                        {
                            int finalLastIndex = lastIndex;
                            entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.AttackAnimation = finalLastIndex;
                                capability.syncPlayerVariables(entiry_a);
                            });
                        }
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("sukuna" + Mth.nextInt(RandomSource.create(), 1, 26))))));
                        }
                        if (Math.random() < (1) / ((float) 5)) {
                            JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(8, entiry_a.getUUID()));
                        }
                        JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(0, entiry_a.getUUID()));
                    }
                    if ((entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Style == 7) {
                        int lastIndex = (int) (entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AttackAnimation;
                        lastIndex = lastIndex >= 5 ? 1 : lastIndex + 1;
                        if (Math.random() < (1) / ((float) 100)) {
                            JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(1, entiry_a.getUUID()));
                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                            if (animation != null) {
                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("itadorifistkoku")))));
                            }
                        } else {
                            {
                                int finalLastIndex = lastIndex;
                                entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.AttackAnimation = finalLastIndex;
                                    capability.syncPlayerVariables(entiry_a);
                                });
                            }
                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                            if (animation != null) {
                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("itadorifist" + lastIndex)))));
                            }
                            if (Math.random() < (1) / ((float) 5)) {
                                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(8, entiry_a.getUUID()));
                            }
                            JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(0, entiry_a.getUUID()));
                        }
                    }
                } else if (((ForgeRegistries.ITEMS.getKey((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("nyoi"))) {
                    int lastIndex = (int) (entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AttackAnimation;
                    lastIndex = lastIndex >= 9 ? 1 : lastIndex + 1;
                    if (Math.random() < (1) / ((float) 40)) {
                        JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(2, entiry_a.getUUID()));
                    }
                    {
                        int finalLastIndex = lastIndex;
                        entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.AttackAnimation = finalLastIndex;
                            capability.syncPlayerVariables(entiry_a);
                        });
                    }
                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                    if (animation != null) {
                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("nyoi" + lastIndex)))));
                    }
                    JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(0, entiry_a.getUUID()));
                } else if (((ForgeRegistries.ITEMS.getKey((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("hiten"))) {
                    int lastIndex = (int) (entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AttackAnimation;
                    lastIndex = lastIndex >= 5 ? 1 : lastIndex + 1;
                    {
                        int finalLastIndex = lastIndex;
                        entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.AttackAnimation = finalLastIndex;
                            capability.syncPlayerVariables(entiry_a);
                        });
                    }
                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                    if (animation != null) {
                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("hiten" + lastIndex)))));
                    }
                    JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(0, entiry_a.getUUID()));
                } else if (((ForgeRegistries.ITEMS.getKey((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("sword_of_extermination"))) {
                    int lastIndex = (int) (entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AttackAnimation;
                    lastIndex = lastIndex >= 5 ? 1 : lastIndex + 1;
                    if (Math.random() < (1) / ((float) 50)) {
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null) {
                            animation.setAnimation(new KeyframeAnimationPlayer(
                                    PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "exterminationswordslice"))
                            ));
                        }
                        JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(4, entiry_a.getUUID()));
                        JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(0, entiry_a.getUUID()));
                    } else {
                        {
                            int finalLastIndex = lastIndex;
                            entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.AttackAnimation = finalLastIndex;
                                capability.syncPlayerVariables(entiry_a);
                            });
                        }
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("exterminationsword" + lastIndex)))));
                        }
                        JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(0, entiry_a.getUUID()));
                    }
                } else if (((ForgeRegistries.ITEMS.getKey((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("inverted_spear_of_heaven"))) {
                    int lastIndex = (int) (entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AttackAnimation;
                    lastIndex = lastIndex >= 5 ? 1 : lastIndex + 1;
                    if (Math.random() < (1) / ((float) 50)) {
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null) {
                            animation.setAnimation(new KeyframeAnimationPlayer(
                                    PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "invertedcut"))
                            ));
                        }
                        JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(3, entiry_a.getUUID()));
                    } else {
                        {
                            int finalLastIndex = lastIndex;
                            entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.AttackAnimation = finalLastIndex;
                                capability.syncPlayerVariables(entiry_a);
                            });
                        }
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("inverted" + lastIndex)))));
                        }
                        JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(0, entiry_a.getUUID()));
                    }
                } else if (((ForgeRegistries.ITEMS.getKey((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("supreme_martial_solution"))) {
                    int lastIndex = (int) (entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AttackAnimation;
                    lastIndex = lastIndex >= 4 ? 1 : lastIndex + 1;
                    if (Math.random() < (1) / ((float) 40)) {
                        JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(2, entiry_a.getUUID()));
                    }
                    {
                        int finalLastIndex = lastIndex;
                        entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.AttackAnimation = finalLastIndex;
                            capability.syncPlayerVariables(entiry_a);
                        });
                    }
                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                    if (animation != null) {
                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("kamutoke" + lastIndex)))));
                    }
                    JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(0, entiry_a.getUUID()));
                } else if (((ForgeRegistries.ITEMS.getKey((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("itadori_arm")) || ((ForgeRegistries.ITEMS.getKey((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("itadori_arms"))) {
                    int lastIndex = (int) (entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AttackAnimation;
                    lastIndex = lastIndex >= 5 ? 1 : lastIndex + 1;
                    if (Math.random() < (1) / ((float) 100) && ((entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Style == 7)) {
                        JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(1, entiry_a.getUUID()));
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("itadorifistkoku")))));
                        }
                    } else {
                        {
                            int finalLastIndex = lastIndex;
                            entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.AttackAnimation = finalLastIndex;
                                capability.syncPlayerVariables(entiry_a);
                            });
                        }
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("itadorifist" + lastIndex)))));
                        }
                        JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(0, entiry_a.getUUID()));
                    }
                } else if (((ForgeRegistries.ITEMS.getKey((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("itadori_arm")) || ((ForgeRegistries.ITEMS.getKey((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("split"))) {
                    int lastIndex = (int) (entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AttackAnimation;
                    lastIndex = lastIndex >= 5 ? 1 : lastIndex + 1;
                    {
                        int finalLastIndex = lastIndex;
                        entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.AttackAnimation = finalLastIndex;
                            capability.syncPlayerVariables(entiry_a);
                        });
                    }
                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                    if (animation != null) {
                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("split" + lastIndex)))));
                    }
                    JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(0, entiry_a.getUUID()));

                } else if (((ForgeRegistries.ITEMS.getKey((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("playful"))) {
                    int lastIndex = (int) (entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AttackAnimation;
                    lastIndex = lastIndex >= 5 ? 1 : lastIndex + 1;
                    {
                        int finalLastIndex = lastIndex;
                        entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.AttackAnimation = finalLastIndex;
                            capability.syncPlayerVariables(entiry_a);
                        });
                    }
                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                    if (animation != null && !animation.isActive()) {
                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("ab" + Mth.nextInt(RandomSource.create(), 1, 5) + "player")))));
                    }
                    JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(0, entiry_a.getUUID()));

                } else {
                    if (Math.random() < (1) / ((float) 40) && ((entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Style == 5)) {
                        JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(7, entiry_a.getUUID()));
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "swordultimate"))));
                        }

                    } else {
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null && !animation.isActive()) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("sword" + Mth.nextInt(RandomSource.create(), 1, 24))))));
                        }

                        JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PacketEffects(0, entiry_a.getUUID()));
                    }
                }
            }
        }

    }
}
