package com.jujutsu.jujutsucraftaddon.item.model;

import com.jujutsu.jujutsucraftaddon.item.RedCapeItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RedCapeModel extends GeoModel<RedCapeItem> {
    @Override
    public ResourceLocation getAnimationResource(RedCapeItem object) {
        return new ResourceLocation("jujutsucraftaddon", "animations/decisive2.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(RedCapeItem object) {
        return new ResourceLocation("jujutsucraftaddon", "geo/decisive2.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RedCapeItem object) {
        return new ResourceLocation("jujutsucraftaddon", "textures/item/text25.png");
    }
}
