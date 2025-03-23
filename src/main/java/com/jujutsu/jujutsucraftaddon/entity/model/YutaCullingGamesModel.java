package com.jujutsu.jujutsucraftaddon.entity.model;

import com.jujutsu.jujutsucraftaddon.entity.YutaCullingGamesEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
public class YutaCullingGamesModel extends GeoModel<YutaCullingGamesEntity> {
    public YutaCullingGamesModel() {
    }

    @Override
    public ResourceLocation getAnimationResource(YutaCullingGamesEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "animations/human1.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(YutaCullingGamesEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "geo/human1.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(YutaCullingGamesEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "textures/entities/yutaskin" + ".png");
    }
}
