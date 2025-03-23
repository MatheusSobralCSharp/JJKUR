package com.jujutsu.jujutsucraftaddon.client.renderer;

import com.jujutsu.jujutsucraftaddon.entity.UiUiEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

public class UiUiRenderer extends HumanoidMobRenderer<UiUiEntity, HumanoidModel<UiUiEntity>> {
    public UiUiRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel<UiUiEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
    }

    @Override
    protected void scale(UiUiEntity entity, PoseStack poseStack, float f) {
        poseStack.scale(0.75f, 0.75f, 0.75f);
    }

    @Override
    public ResourceLocation getTextureLocation(UiUiEntity entity) {
        return new ResourceLocation("jujutsucraftaddon:textures/entities/wjrecwv.png");
    }
}
