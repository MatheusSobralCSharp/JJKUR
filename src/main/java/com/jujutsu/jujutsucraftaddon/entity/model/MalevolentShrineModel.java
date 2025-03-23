package com.jujutsu.jujutsucraftaddon.entity.model;

import com.jujutsu.jujutsucraftaddon.entity.MalevolentShrineEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MalevolentShrineModel extends GeoModel<MalevolentShrineEntity> {
    @Override
    public ResourceLocation getAnimationResource(MalevolentShrineEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "animations/malevolent_shrine_incomplete.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(MalevolentShrineEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "geo/malevolent_shrine_incomplete.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MalevolentShrineEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "textures/entities/" + entity.getTexture() + ".png");
    }

}
