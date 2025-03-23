package com.jujutsu.jujutsucraftaddon.item.model;

import com.jujutsu.jujutsucraftaddon.item.ArmoryItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ArmoryModel extends GeoModel<ArmoryItem> {
    @Override
    public ResourceLocation getAnimationResource(ArmoryItem object) {
        return new ResourceLocation("jujutsucraftaddon", "animations/inventory_curse.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(ArmoryItem object) {
        return new ResourceLocation("jujutsucraftaddon", "geo/inventory_curse.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ArmoryItem object) {
        return new ResourceLocation("jujutsucraftaddon", "textures/item/cursedspirit_armoury.png");
    }
}
