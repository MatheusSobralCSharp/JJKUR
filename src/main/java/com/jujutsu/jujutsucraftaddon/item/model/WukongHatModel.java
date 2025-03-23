package com.jujutsu.jujutsucraftaddon.item.model;

import com.jujutsu.jujutsucraftaddon.item.WukongItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class WukongHatModel extends GeoModel<WukongItem> {
    @Override
    public ResourceLocation getAnimationResource(WukongItem object) {
        return new ResourceLocation("jujutsucraftaddon", "animations/wukonghat.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(WukongItem object) {
        return new ResourceLocation("jujutsucraftaddon", "geo/wukonghat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WukongItem object) {
        return new ResourceLocation("jujutsucraftaddon", "textures/item/wukonghat.png");
    }
}