package com.jujutsu.jujutsucraftaddon.item.model;

import com.jujutsu.jujutsucraftaddon.item.KiryuuOutfitItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class KiryuuArmorModel extends GeoModel<KiryuuOutfitItem> {
    @Override
    public ResourceLocation getAnimationResource(KiryuuOutfitItem object) {
        return new ResourceLocation("jujutsucraftaddon", "animations/kiryuoutfit.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(KiryuuOutfitItem object) {
        return new ResourceLocation("jujutsucraftaddon", "geo/kiryuoutfit.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KiryuuOutfitItem object) {
        return new ResourceLocation("jujutsucraftaddon", "textures/item/kiryuufit.png");
    }
}
