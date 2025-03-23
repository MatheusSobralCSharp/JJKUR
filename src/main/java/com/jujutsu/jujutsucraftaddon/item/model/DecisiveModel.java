package com.jujutsu.jujutsucraftaddon.item.model;

import com.jujutsu.jujutsucraftaddon.item.DecisiveItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DecisiveModel extends GeoModel<DecisiveItem> {
    @Override
    public ResourceLocation getAnimationResource(DecisiveItem object) {
        return new ResourceLocation("jujutsucraftaddon", "animations/decisive.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(DecisiveItem object) {
        return new ResourceLocation("jujutsucraftaddon", "geo/decisive.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DecisiveItem object) {
        return new ResourceLocation("jujutsucraftaddon", "textures/item/text2.png");
    }
}
