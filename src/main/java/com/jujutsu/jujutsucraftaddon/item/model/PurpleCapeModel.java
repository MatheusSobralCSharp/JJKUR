package com.jujutsu.jujutsucraftaddon.item.model;

import com.jujutsu.jujutsucraftaddon.item.PurpleCapeItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PurpleCapeModel extends GeoModel<PurpleCapeItem> {
    @Override
    public ResourceLocation getAnimationResource(PurpleCapeItem object) {
        return new ResourceLocation("jujutsucraftaddon", "animations/decisive2.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(PurpleCapeItem object) {
        return new ResourceLocation("jujutsucraftaddon", "geo/decisive2.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PurpleCapeItem object) {
        return new ResourceLocation("jujutsucraftaddon", "textures/item/purplee.png");
    }
}
