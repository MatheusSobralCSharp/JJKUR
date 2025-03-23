package com.jujutsu.jujutsucraftaddon.init;

import com.jujutsu.jujutsucraftaddon.item.*;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import software.bernie.geckolib.animatable.GeoItem;

@Mod.EventBusSubscriber
public class ItemAnimationFactory {
    @SubscribeEvent
    public static void animatedItems(TickEvent.PlayerTickEvent event) {
        String animation = "";
        ItemStack mainhandItem = event.player.getMainHandItem().copy();
        ItemStack offhandItem = event.player.getOffhandItem().copy();
        if (event.phase == TickEvent.Phase.START && (mainhandItem.getItem() instanceof GeoItem || offhandItem.getItem() instanceof GeoItem)) {
            if (mainhandItem.getItem() instanceof WarstaffItem animatable) {
                animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
                if (!animation.isEmpty()) {
                    event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
                    if (event.player.level().isClientSide()) {
                        ((WarstaffItem) event.player.getMainHandItem().getItem()).animationprocedure = animation;
                    }
                }
            }
            if (offhandItem.getItem() instanceof WarstaffItem animatable) {
                animation = offhandItem.getOrCreateTag().getString("geckoAnim");
                if (!animation.isEmpty()) {
                    event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
                    if (event.player.level().isClientSide()) {
                        ((WarstaffItem) event.player.getOffhandItem().getItem()).animationprocedure = animation;
                    }
                }
            }
            if (mainhandItem.getItem() instanceof YuunItem animatable) {
                animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
                if (!animation.isEmpty()) {
                    event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
                    if (event.player.level().isClientSide()) {
                        ((YuunItem) event.player.getMainHandItem().getItem()).animationprocedure = animation;
                    }
                }
            }
            if (offhandItem.getItem() instanceof YuunItem animatable) {
                animation = offhandItem.getOrCreateTag().getString("geckoAnim");
                if (!animation.isEmpty()) {
                    event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
                    if (event.player.level().isClientSide()) {
                        ((YuunItem) event.player.getOffhandItem().getItem()).animationprocedure = animation;
                    }
                }
            }
            if (mainhandItem.getItem() instanceof WukongStaffItem animatable) {
                animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
                if (!animation.isEmpty()) {
                    event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
                    if (event.player.level().isClientSide()) {
                        ((WukongStaffItem) event.player.getMainHandItem().getItem()).animationprocedure = animation;
                    }
                }
            }
            if (offhandItem.getItem() instanceof WukongStaffItem animatable) {
                animation = offhandItem.getOrCreateTag().getString("geckoAnim");
                if (!animation.isEmpty()) {
                    event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
                    if (event.player.level().isClientSide()) {
                        ((WukongStaffItem) event.player.getOffhandItem().getItem()).animationprocedure = animation;
                    }
                }
            }
            if (mainhandItem.getItem() instanceof ArtifactItem animatable) {
                animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
                if (!animation.isEmpty()) {
                    event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
                    if (event.player.level().isClientSide()) {
                        ((ArtifactItem) event.player.getMainHandItem().getItem()).animationprocedure = animation;
                    }
                }
            }
            if (offhandItem.getItem() instanceof ArtifactItem animatable) {
                animation = offhandItem.getOrCreateTag().getString("geckoAnim");
                if (!animation.isEmpty()) {
                    event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
                    if (event.player.level().isClientSide()) {
                        ((ArtifactItem) event.player.getOffhandItem().getItem()).animationprocedure = animation;
                    }
                }
            }
            if (mainhandItem.getItem() instanceof Artifact2Item animatable) {
                animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
                if (!animation.isEmpty()) {
                    event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
                    if (event.player.level().isClientSide()) {
                        ((Artifact2Item) event.player.getMainHandItem().getItem()).animationprocedure = animation;
                    }
                }
            }
            if (offhandItem.getItem() instanceof Artifact2Item animatable) {
                animation = offhandItem.getOrCreateTag().getString("geckoAnim");
                if (!animation.isEmpty()) {
                    event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
                    if (event.player.level().isClientSide()) {
                        ((Artifact2Item) event.player.getOffhandItem().getItem()).animationprocedure = animation;
                    }
                }
            }
            if (mainhandItem.getItem() instanceof Artifact3Item animatable) {
                animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
                if (!animation.isEmpty()) {
                    event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
                    if (event.player.level().isClientSide()) {
                        ((Artifact3Item) event.player.getMainHandItem().getItem()).animationprocedure = animation;
                    }
                }
            }
            if (offhandItem.getItem() instanceof Artifact3Item animatable) {
                animation = offhandItem.getOrCreateTag().getString("geckoAnim");
                if (!animation.isEmpty()) {
                    event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
                    if (event.player.level().isClientSide()) {
                        ((Artifact3Item) event.player.getOffhandItem().getItem()).animationprocedure = animation;
                    }
                }
            }
            if (mainhandItem.getItem() instanceof Artifact4Item animatable) {
                animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
                if (!animation.isEmpty()) {
                    event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
                    if (event.player.level().isClientSide()) {
                        ((Artifact4Item) event.player.getMainHandItem().getItem()).animationprocedure = animation;
                    }
                }
            }
            if (offhandItem.getItem() instanceof Artifact4Item animatable) {
                animation = offhandItem.getOrCreateTag().getString("geckoAnim");
                if (!animation.isEmpty()) {
                    event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
                    if (event.player.level().isClientSide()) {
                        ((Artifact4Item) event.player.getOffhandItem().getItem()).animationprocedure = animation;
                    }
                }
            }
            if (mainhandItem.getItem() instanceof Artifact5Item animatable) {
                animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
                if (!animation.isEmpty()) {
                    event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
                    if (event.player.level().isClientSide()) {
                        ((Artifact5Item) event.player.getMainHandItem().getItem()).animationprocedure = animation;
                    }
                }
            }
            if (offhandItem.getItem() instanceof Artifact5Item animatable) {
                animation = offhandItem.getOrCreateTag().getString("geckoAnim");
                if (!animation.isEmpty()) {
                    event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
                    if (event.player.level().isClientSide()) {
                        ((Artifact5Item) event.player.getOffhandItem().getItem()).animationprocedure = animation;
                    }
                }
            }
        }
    }
}
