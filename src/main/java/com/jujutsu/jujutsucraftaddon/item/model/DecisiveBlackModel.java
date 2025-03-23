package com.jujutsu.jujutsucraftaddon.item.model;

import com.jujutsu.jujutsucraftaddon.item.DecisiveBlackItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DecisiveBlackModel extends GeoModel<DecisiveBlackItem> {
    @Override
    public ResourceLocation getAnimationResource(DecisiveBlackItem object) {
        return new ResourceLocation("jujutsucraftaddon", "animations/decisive.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(DecisiveBlackItem object) {
        return new ResourceLocation("jujutsucraftaddon", "geo/decisive.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DecisiveBlackItem object) {
        return new ResourceLocation("jujutsucraftaddon", "textures/item/darktext.png");
    }
}
