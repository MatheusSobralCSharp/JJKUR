package com.jujutsu.jujutsucraftaddon.item.model;

import com.jujutsu.jujutsucraftaddon.item.KimonoWhiteItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class KimonoWhiteModel extends GeoModel<KimonoWhiteItem> {
    @Override
    public ResourceLocation getAnimationResource(KimonoWhiteItem object) {
        return new ResourceLocation("jujutsucraftaddon", "animations/kimonoblack.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(KimonoWhiteItem object) {
        return new ResourceLocation("jujutsucraftaddon", "geo/kimonoblack.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KimonoWhiteItem object) {
        return new ResourceLocation("jujutsucraftaddon", "textures/item/kimonowhite.png");
    }
}
