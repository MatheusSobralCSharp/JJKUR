package com.jujutsu.jujutsucraftaddon.entity.model;

import com.jujutsu.jujutsucraftaddon.entity.CloneEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import software.bernie.geckolib.model.GeoModel;

public class CloneModel extends GeoModel<CloneEntity> {
    public CloneModel() {
    }

    @Override
    public ResourceLocation getAnimationResource(CloneEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "animations/human2.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(CloneEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "geo/human1.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CloneEntity entity) {

        String shadowTexturePath = entity.getEntityData().get(CloneEntity.DATA_Testing).toLowerCase();

        if (!shadowTexturePath.isEmpty()) {
            return new ResourceLocation(shadowTexturePath);
        }

        LivingEntity livingEntity = entity.getOwner();
        if (entity.getOwnerUUID() == null) {
            return new ResourceLocation("jujutsucraftaddon:textures/entities/pmcskin3d-steve.png");
        }

        EntityRenderDispatcher entityRenderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
        EntityRenderer<? super LivingEntity> livingRenderer = entityRenderDispatcher.getRenderer(livingEntity);
        return livingRenderer.getTextureLocation(livingEntity);
    }
}
