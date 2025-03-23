package com.jujutsu.jujutsucraftaddon.entity.model;

import com.jujutsu.jujutsucraftaddon.entity.IgrisEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class IgrisModel extends GeoModel<IgrisEntity> {
    @Override
    public ResourceLocation getAnimationResource(IgrisEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "animations/igris.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(IgrisEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "geo/igris.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IgrisEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "textures/entities/" + entity.getTexture() + ".png");
    }

}
