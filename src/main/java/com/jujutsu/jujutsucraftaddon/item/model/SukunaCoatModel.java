package com.jujutsu.jujutsucraftaddon.item.model;

import com.jujutsu.jujutsucraftaddon.item.SukunaCoatItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SukunaCoatModel extends GeoModel<SukunaCoatItem> {
    @Override
    public ResourceLocation getAnimationResource(SukunaCoatItem object) {
        return new ResourceLocation("jujutsucraftaddon", "animations/sukunacoat.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(SukunaCoatItem object) {
        return new ResourceLocation("jujutsucraftaddon", "geo/sukunacoat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SukunaCoatItem object) {
        return new ResourceLocation("jujutsucraftaddon", "textures/item/sukunacoat.png");
    }
}
