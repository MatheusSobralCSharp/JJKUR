package com.jujutsu.jujutsucraftaddon.client.renderer;

import com.jujutsu.jujutsucraftaddon.entity.YutaCullingGamesEntity;
import com.jujutsu.jujutsucraftaddon.entity.model.YutaCullingGamesModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.jujutsucraft.GenericArmorLayer;
import net.mcreator.jujutsucraft.GenericItemLayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.DynamicGeoEntityRenderer;

public class YutaCullingGamesRenderer extends DynamicGeoEntityRenderer<YutaCullingGamesEntity> {
    public YutaCullingGamesRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new YutaCullingGamesModel());
        this.shadowRadius = 0.5F;
        this.addRenderLayer(new GenericArmorLayer(this));
        this.addRenderLayer(new GenericItemLayer(this));
    }

    @Override
    public RenderType getRenderType(YutaCullingGamesEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(this.getTextureLocation(animatable));
    }

    @Override
    public void preRender(PoseStack poseStack, YutaCullingGamesEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        float scale = 1.0F;
        this.scaleHeight = scale;
        this.scaleWidth = scale;
        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    protected float getDeathMaxRotation(YutaCullingGamesEntity entityLivingBaseIn) {
        return 0.0F;
    }
}
