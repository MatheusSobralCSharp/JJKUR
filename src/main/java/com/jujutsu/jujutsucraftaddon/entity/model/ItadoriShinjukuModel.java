package com.jujutsu.jujutsucraftaddon.entity.model;

import com.jujutsu.jujutsucraftaddon.entity.ItadoriShinjukuEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ItadoriShinjukuModel extends GeoModel<ItadoriShinjukuEntity> {
    public ItadoriShinjukuModel() {
    }

    @Override
    public ResourceLocation getAnimationResource(ItadoriShinjukuEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "animations/human1.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(ItadoriShinjukuEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "geo/human1.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ItadoriShinjukuEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "textures/entities/itadorishinjukuskin" + ".png");
    }
}
