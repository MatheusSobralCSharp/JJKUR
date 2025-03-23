package com.jujutsu.jujutsucraftaddon.item.model;

import com.jujutsu.jujutsucraftaddon.item.ArtifactItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ArtifactItemModel extends GeoModel<ArtifactItem> {
    @Override
    public ResourceLocation getAnimationResource(ArtifactItem animatable) {
        return new ResourceLocation("jujutsucraftaddon", "animations/artifact.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(ArtifactItem animatable) {
        return new ResourceLocation("jujutsucraftaddon", "geo/artifact.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ArtifactItem animatable) {
        return new ResourceLocation("jujutsucraftaddon", "textures/item/amuleto.png");
    }
}
