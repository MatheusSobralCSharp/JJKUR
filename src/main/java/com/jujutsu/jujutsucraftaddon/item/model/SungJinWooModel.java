package com.jujutsu.jujutsucraftaddon.item.model;

import com.jujutsu.jujutsucraftaddon.item.SungJinWooItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SungJinWooModel extends GeoModel<SungJinWooItem> {
    @Override
    public ResourceLocation getAnimationResource(SungJinWooItem object) {
        return new ResourceLocation("jujutsucraftaddon", "animations/decisive2.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(SungJinWooItem object) {
        return new ResourceLocation("jujutsucraftaddon", "geo/decisive2.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SungJinWooItem object) {
        return new ResourceLocation("jujutsucraftaddon", "textures/item/sungjin.png");
    }
}
