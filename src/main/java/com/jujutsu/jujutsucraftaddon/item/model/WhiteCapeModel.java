package com.jujutsu.jujutsucraftaddon.item.model;

import com.jujutsu.jujutsucraftaddon.item.WhiteCapeItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class WhiteCapeModel extends GeoModel<WhiteCapeItem> {
    @Override
    public ResourceLocation getAnimationResource(WhiteCapeItem object) {
        return new ResourceLocation("jujutsucraftaddon", "animations/decisive2.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(WhiteCapeItem object) {
        return new ResourceLocation("jujutsucraftaddon", "geo/decisive2.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WhiteCapeItem object) {
        return new ResourceLocation("jujutsucraftaddon", "textures/item/text23.png");
    }
}
