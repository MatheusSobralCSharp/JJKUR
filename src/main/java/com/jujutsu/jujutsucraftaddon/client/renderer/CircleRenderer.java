package com.jujutsu.jujutsucraftaddon.client.renderer;

import com.jujutsu.jujutsucraftaddon.client.model.ModelSatushi;
import com.jujutsu.jujutsucraftaddon.entity.CircleEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CircleRenderer extends MobRenderer<CircleEntity, ModelSatushi<CircleEntity>> {
    public CircleRenderer(EntityRendererProvider.Context context) {
        super(context, new ModelSatushi<CircleEntity>(context.bakeLayer(ModelSatushi.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(CircleEntity entity) {
        return new ResourceLocation("jujutsucraftaddon:textures/entities/circletwo.png");
    }
}
