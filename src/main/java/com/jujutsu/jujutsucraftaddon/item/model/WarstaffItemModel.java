package com.jujutsu.jujutsucraftaddon.item.model;

import com.jujutsu.jujutsucraftaddon.item.WarstaffItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class WarstaffItemModel extends GeoModel<WarstaffItem> {
    @Override
    public ResourceLocation getAnimationResource(WarstaffItem animatable) {
        return new ResourceLocation("jujutsucraftaddon", "animations/g_warstaff.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(WarstaffItem animatable) {
        return new ResourceLocation("jujutsucraftaddon", "geo/g_warstaff.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WarstaffItem animatable) {
        return new ResourceLocation("jujutsucraftaddon", "textures/item/texture_36.png");
    }
}
