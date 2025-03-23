package com.jujutsu.jujutsucraftaddon.item.model;

import com.jujutsu.jujutsucraftaddon.item.YuunItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class YuunItemModel extends GeoModel<YuunItem> {
    @Override
    public ResourceLocation getAnimationResource(YuunItem animatable) {
        return new ResourceLocation("jujutsucraftaddon", "animations/yuundark.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(YuunItem animatable) {
        return new ResourceLocation("jujutsucraftaddon", "geo/yuundark.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(YuunItem animatable) {
        return new ResourceLocation("jujutsucraftaddon", "textures/item/playful_cloud.png");
    }
}
