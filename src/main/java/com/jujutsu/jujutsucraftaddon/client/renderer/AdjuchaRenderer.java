package com.jujutsu.jujutsucraftaddon.client.renderer;

import com.jujutsu.jujutsucraftaddon.entity.AdjuchaEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

public class AdjuchaRenderer extends HumanoidMobRenderer<AdjuchaEntity, HumanoidModel<AdjuchaEntity>> {
    public AdjuchaRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel<AdjuchaEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
    }

    @Override
    protected void scale(AdjuchaEntity entity, PoseStack poseStack, float f) {
        poseStack.scale(1.5f, 1.5f, 1.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(AdjuchaEntity entity) {
        return new ResourceLocation("jujutsucraftaddon:textures/entities/adjuchafinal.png");
    }
}
