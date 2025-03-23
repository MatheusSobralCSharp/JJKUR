package com.jujutsu.jujutsucraftaddon.entity.model;

import com.jujutsu.jujutsucraftaddon.entity.PartialRikaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PartialRikaModel extends GeoModel<PartialRikaEntity> {
    @Override
    public ResourceLocation getAnimationResource(PartialRikaEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "animations/rika3.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(PartialRikaEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "geo/rika3.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PartialRikaEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "textures/entities/rika2.png");
    }

}
