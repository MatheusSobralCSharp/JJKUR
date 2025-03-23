package com.jujutsu.jujutsucraftaddon.entity.model;

import com.jujutsu.jujutsucraftaddon.entity.Shadow1Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class Shadow1Model extends GeoModel<Shadow1Entity> {
    @Override
    public ResourceLocation getAnimationResource(Shadow1Entity entity) {
        return new ResourceLocation("jujutsucraftaddon", "animations/ant_king_dark.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(Shadow1Entity entity) {
        return new ResourceLocation("jujutsucraftaddon", "geo/ant_king_dark.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Shadow1Entity entity) {
        return new ResourceLocation("jujutsucraftaddon", "textures/entities/" + entity.getTexture() + ".png");
    }

}
