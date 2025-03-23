package com.jujutsu.jujutsucraftaddon.item.model;

import com.jujutsu.jujutsucraftaddon.item.Artifact5Item;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class Artifact5ItemModel extends GeoModel<Artifact5Item> {
    @Override
    public ResourceLocation getAnimationResource(Artifact5Item animatable) {
        return new ResourceLocation("jujutsucraftaddon", "animations/artifact.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(Artifact5Item animatable) {
        return new ResourceLocation("jujutsucraftaddon", "geo/artifact.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Artifact5Item animatable) {
        return new ResourceLocation("jujutsucraftaddon", "textures/item/amuleto4.png");
    }
}
