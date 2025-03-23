package com.jujutsu.jujutsucraftaddon.item.model;

import com.jujutsu.jujutsucraftaddon.item.VergilItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class VergilModel extends GeoModel<VergilItem> {
    @Override
    public ResourceLocation getAnimationResource(VergilItem object) {
        return new ResourceLocation("jujutsucraftaddon", "animations/jacket.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(VergilItem object) {
        return new ResourceLocation("jujutsucraftaddon", "geo/jacket.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(VergilItem object) {
        return new ResourceLocation("jujutsucraftaddon", "textures/item/yamato1.6.png");
    }
}
