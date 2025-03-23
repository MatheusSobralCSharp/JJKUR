package com.jujutsu.jujutsucraftaddon.client.renderer;

import com.jujutsu.jujutsucraftaddon.entity.VeilEntity;
import com.jujutsu.jujutsucraftaddon.procedures.VeilDisplayConditionProcedure;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class VeilRenderer extends HumanoidMobRenderer<VeilEntity, HumanoidModel<VeilEntity>> {
    public VeilRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel<VeilEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
        this.addLayer(new RenderLayer<VeilEntity, HumanoidModel<VeilEntity>>(this) {
            final ResourceLocation LAYER_TEXTURE = new ResourceLocation("jujutsucraftaddon:textures/entities/21.png");

            @Override
            public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, VeilEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
                Level world = entity.level();
                double x = entity.getX();
                double y = entity.getY();
                double z = entity.getZ();
                if (VeilDisplayConditionProcedure.execute(entity)) {
                    VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
                    this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
                }
            }
        });
        this.addLayer(new RenderLayer<VeilEntity, HumanoidModel<VeilEntity>>(this) {
            final ResourceLocation LAYER_TEXTURE = new ResourceLocation("jujutsucraftaddon:textures/entities/22.png");

            @Override
            public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, VeilEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
                Level world = entity.level();
                double x = entity.getX();
                double y = entity.getY();
                double z = entity.getZ();
                if (VeilDisplayConditionProcedure.execute(entity)) {
                    VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
                    this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
                }
            }
        });
    }

    @Override
    public ResourceLocation getTextureLocation(VeilEntity entity) {
        return new ResourceLocation("jujutsucraftaddon:textures/entities/ejntity.png");
    }
}
