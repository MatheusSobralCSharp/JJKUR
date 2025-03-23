package com.jujutsu.jujutsucraftaddon.item.model;

import com.jujutsu.jujutsucraftaddon.item.WukongStaffItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class WukongStaffItemModel extends GeoModel<WukongStaffItem> {
    @Override
    public ResourceLocation getAnimationResource(WukongStaffItem animatable) {
        return new ResourceLocation("jujutsucraftaddon", "animations/wukongstaff.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(WukongStaffItem animatable) {
        return new ResourceLocation("jujutsucraftaddon", "geo/wukongstaff.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WukongStaffItem animatable) {
        return new ResourceLocation("jujutsucraftaddon", "textures/item/playful_cloud.png");
    }
}
