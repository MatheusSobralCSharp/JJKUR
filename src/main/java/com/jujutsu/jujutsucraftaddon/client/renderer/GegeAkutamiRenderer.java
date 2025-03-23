package com.jujutsu.jujutsucraftaddon.client.renderer;

import com.jujutsu.jujutsucraftaddon.entity.GegeAkutamiEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

public class GegeAkutamiRenderer extends HumanoidMobRenderer<GegeAkutamiEntity, HumanoidModel<GegeAkutamiEntity>> {
    public GegeAkutamiRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel<GegeAkutamiEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
    }

    @Override
    public ResourceLocation getTextureLocation(GegeAkutamiEntity entity) {
        return new ResourceLocation("jujutsucraftaddon:textures/entities/download_1.png");
    }
}
