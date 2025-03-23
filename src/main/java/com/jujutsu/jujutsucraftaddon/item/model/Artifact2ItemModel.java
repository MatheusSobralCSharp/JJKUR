package com.jujutsu.jujutsucraftaddon.item.model;

import com.jujutsu.jujutsucraftaddon.item.Artifact2Item;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class Artifact2ItemModel extends GeoModel<Artifact2Item> {
    @Override
    public ResourceLocation getAnimationResource(Artifact2Item animatable) {
        return new ResourceLocation("jujutsucraftaddon", "animations/artifact.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(Artifact2Item animatable) {
        return new ResourceLocation("jujutsucraftaddon", "geo/artifact.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Artifact2Item animatable) {
        return new ResourceLocation("jujutsucraftaddon", "textures/item/amuleto2.png");
    }
}
