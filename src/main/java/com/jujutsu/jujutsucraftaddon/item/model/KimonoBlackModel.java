package com.jujutsu.jujutsucraftaddon.item.model;

import com.jujutsu.jujutsucraftaddon.item.KimonoBlackItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class KimonoBlackModel extends GeoModel<KimonoBlackItem> {
    @Override
    public ResourceLocation getAnimationResource(KimonoBlackItem object) {
        return new ResourceLocation("jujutsucraftaddon", "animations/kimonoblack.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(KimonoBlackItem object) {
        return new ResourceLocation("jujutsucraftaddon", "geo/kimonoblack.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KimonoBlackItem object) {
        return new ResourceLocation("jujutsucraftaddon", "textures/item/naobitooo.png");
    }
}
