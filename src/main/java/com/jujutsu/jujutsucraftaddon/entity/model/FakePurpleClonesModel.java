package com.jujutsu.jujutsucraftaddon.entity.model;

import com.jujutsu.jujutsucraftaddon.entity.FakePurpleClonesEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import software.bernie.geckolib.model.GeoModel;

public class FakePurpleClonesModel extends GeoModel<FakePurpleClonesEntity> {
    public FakePurpleClonesModel() {
    }

    @Override
    public ResourceLocation getAnimationResource(FakePurpleClonesEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "animations/human2.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(FakePurpleClonesEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "geo/human1.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FakePurpleClonesEntity entity) {
        LivingEntity livingEntity = entity.getOwner();
        if (entity.getOwnerUUID() == null) {
            return new ResourceLocation("jujutsucraftaddon:textures/entities/pmcskin3d-steve.png");
        }
        EntityRenderDispatcher entityRenderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
        EntityRenderer<? super LivingEntity> livingRenderer = entityRenderDispatcher.getRenderer(livingEntity);
        return livingRenderer.getTextureLocation(livingEntity);
    }
}
