package com.jujutsu.jujutsucraftaddon.archived;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade06Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade08Entity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.BlockAndItemGeoLayer;

import javax.annotation.Nullable;

public class GenericItemLayerJJK<T extends LivingEntity & GeoAnimatable> extends BlockAndItemGeoLayer<T> {
    private final GeoEntityRenderer<T> renderer;

    public GenericItemLayerJJK(GeoEntityRenderer<T> renderer) {
        super(renderer);
        this.renderer = renderer;
    }

    @Nullable
    protected ItemStack getStackForBone(GeoBone bone, T animatable) {
        ItemStack mainHandItem = animatable.getMainHandItem();
        ItemStack offhandItem = animatable.getOffhandItem();
        switch (bone.getName()) {
            case "itemMainHand":
                return mainHandItem;
            case "itemOffHand":
                return offhandItem;
            case "itemMainHand2":
            case "itemMainHand3":
                return mainHandItem;
            case "itemOffHand2":
            case "itemOffHand3":
                return offhandItem;
            default:
                return null;
        }
    }

    protected ItemDisplayContext getTransformTypeForStack(GeoBone bone, ItemStack stack, T animatable) {
        switch (bone.getName()) {
            case "itemOffHand":
            case "itemMainHand":
                return ItemDisplayContext.THIRD_PERSON_RIGHT_HAND;
            case "itemOffHand2":
            case "itemOffHand3":
            case "itemMainHand2":
            case "itemMainHand3":
                return ItemDisplayContext.THIRD_PERSON_RIGHT_HAND;
            default:
                return ItemDisplayContext.NONE;
        }
    }

    protected void renderStackForBone(PoseStack poseStack, GeoBone bone, ItemStack stack, T animatable, MultiBufferSource bufferSource, float partialTick, int packedLight, int packedOverlay) {
        ItemStack mainHandItem = animatable.getMainHandItem();
        ItemStack offhandItem = animatable.getOffhandItem();
        if (stack == mainHandItem || stack == offhandItem) {
            float scaleFactor = 1.0F;
            if (animatable instanceof CursedSpiritGrade06Entity) {
                scaleFactor = 2.75F;
            }

            if (animatable instanceof CursedSpiritGrade08Entity) {
                scaleFactor = 1.5F;
            }

            poseStack.scale(scaleFactor, scaleFactor, scaleFactor);
            poseStack.mulPose(Axis.XP.rotationDegrees(-90.0F));
            if (stack.getItem() instanceof ShieldItem) {
                poseStack.translate(0.0, 0.0, stack == mainHandItem ? -0.25 : 0.25);
                if (stack == offhandItem) {
                    poseStack.mulPose(Axis.ZP.rotationDegrees(180.0F));
                }
            }
        }

        super.renderStackForBone(poseStack, bone, stack, animatable, bufferSource, partialTick, packedLight, packedOverlay);
    }
}
