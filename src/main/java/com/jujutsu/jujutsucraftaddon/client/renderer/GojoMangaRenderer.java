package com.jujutsu.jujutsucraftaddon.client.renderer;

import com.jujutsu.jujutsucraftaddon.entity.GojoMangaEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

public class GojoMangaRenderer extends HumanoidMobRenderer<GojoMangaEntity, HumanoidModel<GojoMangaEntity>> {
    public GojoMangaRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel<GojoMangaEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.6f);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
    }

    @Override
    public ResourceLocation getTextureLocation(GojoMangaEntity entity) {
        return new ResourceLocation("jujutsucraftaddon:textures/entities/gojoun.png");
    }
}
