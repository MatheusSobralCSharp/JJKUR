package com.jujutsu.jujutsucraftaddon.item.model;

import com.jujutsu.jujutsucraftaddon.item.MugiwaraItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MugiwaraModel extends GeoModel<MugiwaraItem> {
    @Override
    public ResourceLocation getAnimationResource(MugiwaraItem object) {
        return new ResourceLocation("jujutsucraftaddon", "animations/straw_hat.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(MugiwaraItem object) {
        return new ResourceLocation("jujutsucraftaddon", "geo/straw_hat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MugiwaraItem object) {
        return new ResourceLocation("jujutsucraftaddon", "textures/item/straw_hat_armor_textures.png");
    }
}
