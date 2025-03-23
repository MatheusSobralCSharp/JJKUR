package com.jujutsu.jujutsucraftaddon.entity.model;

import com.jujutsu.jujutsucraftaddon.entity.RedEntityEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.ModList;
import software.bernie.geckolib.model.GeoModel;

public class RedEntityModel extends GeoModel<RedEntityEntity> {
    @Override
    public ResourceLocation getAnimationResource(RedEntityEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "animations/hollow.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(RedEntityEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "geo/hollow.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RedEntityEntity entity) {
        if (ModList.get().isLoaded("jjkueffects")) {
            return new ResourceLocation("jujutsucraftaddon:textures/entities/ejntity.png");
        } else {
            return new ResourceLocation("jujutsucraftaddon:textures/entities/red.png");
        }
    }

}
