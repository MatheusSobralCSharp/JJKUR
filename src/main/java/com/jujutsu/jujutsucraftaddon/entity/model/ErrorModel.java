package com.jujutsu.jujutsucraftaddon.entity.model;

import com.jujutsu.jujutsucraftaddon.entity.ErrorEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import software.bernie.geckolib.model.GeoModel;

public class ErrorModel extends GeoModel<ErrorEntity> {
    @Override
    public ResourceLocation getAnimationResource(ErrorEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "animations/human.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(ErrorEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "geo/human.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ErrorEntity entity) {
        if (entity.getOwnerUUID() != null) {
            LivingEntity livingEntity = entity.getOwner();
            if (livingEntity != null) {
                EntityRenderDispatcher entityRenderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
                EntityRenderer<? super LivingEntity> livingRenderer = entityRenderDispatcher.getRenderer(livingEntity);
                return livingRenderer.getTextureLocation(livingEntity);
            }
        }

        return new ResourceLocation("jujutsucraftaddon", "textures/entities/" + entity.getClass().getSimpleName().toLowerCase() + ".png");
    }
}
