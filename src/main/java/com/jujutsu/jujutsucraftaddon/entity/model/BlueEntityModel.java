package com.jujutsu.jujutsucraftaddon.entity.model;

import com.jujutsu.jujutsucraftaddon.entity.BlueEntityEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.ModList;
import software.bernie.geckolib.model.GeoModel;

public class BlueEntityModel extends GeoModel<BlueEntityEntity> {
    @Override
    public ResourceLocation getAnimationResource(BlueEntityEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "animations/hollow.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(BlueEntityEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "geo/hollow.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BlueEntityEntity entity) {
        if (ModList.get().isLoaded("jjkueffects")) {
             return new ResourceLocation("jujutsucraftaddon:textures/entities/ejntity.png");
        } else {
            return new ResourceLocation("jujutsucraftaddon:textures/entities/blue.png");
        }
    }

}
