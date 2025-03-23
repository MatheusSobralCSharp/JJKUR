package com.jujutsu.jujutsucraftaddon.client.renderer;

import com.jujutsu.jujutsucraftaddon.entity.KashimoFemboyEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

public class KashimoFemboyRenderer extends HumanoidMobRenderer<KashimoFemboyEntity, HumanoidModel<KashimoFemboyEntity>> {
    public KashimoFemboyRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel<KashimoFemboyEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
    }

    @Override
    public ResourceLocation getTextureLocation(KashimoFemboyEntity entity) {
        return new ResourceLocation("jujutsucraftaddon:textures/entities/6qwlpvo.png");
    }
}
