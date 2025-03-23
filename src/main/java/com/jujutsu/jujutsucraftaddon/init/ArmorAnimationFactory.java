package com.jujutsu.jujutsucraftaddon.init;

import com.jujutsu.jujutsucraftaddon.item.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import software.bernie.geckolib.animatable.GeoItem;

@Mod.EventBusSubscriber
public class ArmorAnimationFactory {
    @SubscribeEvent
    public static void animatedArmors(TickEvent.PlayerTickEvent event) {
        String animation = "";
        if (event.phase == TickEvent.Phase.END) {
            if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() != (ItemStack.EMPTY).getItem() && event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof GeoItem) {
                if (!event.player.getItemBySlot(EquipmentSlot.HEAD).getOrCreateTag().getString("geckoAnim").equals("")) {
                    animation = event.player.getItemBySlot(EquipmentSlot.HEAD).getOrCreateTag().getString("geckoAnim");
                    event.player.getItemBySlot(EquipmentSlot.HEAD).getOrCreateTag().putString("geckoAnim", "");
                    if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof DecisiveItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof KiryuuOutfitItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof SukunaCoatItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof WukongItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof ArmoryItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof DecisiveBlackItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof SungJinWooItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof WhiteCapeItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof RedCapeItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof PurpleCapeItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof KimonoBlackItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof KimonoWhiteItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof MugiwaraItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof GojoItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof VergilItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof SukunaRobeItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                }
            }
            if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() != (ItemStack.EMPTY).getItem() && event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof GeoItem) {
                if (!event.player.getItemBySlot(EquipmentSlot.CHEST).getOrCreateTag().getString("geckoAnim").equals("")) {
                    animation = event.player.getItemBySlot(EquipmentSlot.CHEST).getOrCreateTag().getString("geckoAnim");
                    event.player.getItemBySlot(EquipmentSlot.CHEST).getOrCreateTag().putString("geckoAnim", "");
                    if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof DecisiveItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof ArmoryItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof SukunaCoatItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof DecisiveBlackItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof SungJinWooItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof WhiteCapeItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof KiryuuOutfitItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof RedCapeItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof PurpleCapeItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof KimonoBlackItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof KimonoWhiteItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof MugiwaraItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof GojoItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof VergilItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof SukunaRobeItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                }
            }
            if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() != (ItemStack.EMPTY).getItem() && event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof GeoItem) {
                if (!event.player.getItemBySlot(EquipmentSlot.LEGS).getOrCreateTag().getString("geckoAnim").equals("")) {
                    animation = event.player.getItemBySlot(EquipmentSlot.LEGS).getOrCreateTag().getString("geckoAnim");
                    event.player.getItemBySlot(EquipmentSlot.LEGS).getOrCreateTag().putString("geckoAnim", "");
                    if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof DecisiveItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof ArmoryItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof DecisiveBlackItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof SungJinWooItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof KiryuuOutfitItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof SukunaCoatItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof WhiteCapeItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof RedCapeItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof PurpleCapeItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof KimonoBlackItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof KimonoWhiteItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof MugiwaraItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof GojoItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof VergilItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof SukunaRobeItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                }
            }
            if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() != (ItemStack.EMPTY).getItem() && event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof GeoItem) {
                if (!event.player.getItemBySlot(EquipmentSlot.FEET).getOrCreateTag().getString("geckoAnim").equals("")) {
                    animation = event.player.getItemBySlot(EquipmentSlot.FEET).getOrCreateTag().getString("geckoAnim");
                    event.player.getItemBySlot(EquipmentSlot.FEET).getOrCreateTag().putString("geckoAnim", "");
                    if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof DecisiveItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof ArmoryItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof DecisiveBlackItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof SukunaCoatItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof SungJinWooItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof KiryuuOutfitItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof WhiteCapeItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RedCapeItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof PurpleCapeItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof KimonoBlackItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof KimonoWhiteItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof MugiwaraItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof GojoItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof VergilItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                    if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof SukunaRobeItem animatable && event.player.level().isClientSide())
                        animatable.animationprocedure = animation;
                }
            }
        }
    }
}
