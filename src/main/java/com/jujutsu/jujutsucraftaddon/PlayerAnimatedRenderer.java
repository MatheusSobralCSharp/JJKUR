package com.jujutsu.jujutsucraftaddon;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import dev.kosmx.playerAnim.api.TransformType;
import dev.kosmx.playerAnim.core.util.Vec3f;
import dev.kosmx.playerAnim.impl.IAnimatedPlayer;
import dev.kosmx.playerAnim.impl.animation.AnimationApplier;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.ModList;

@OnlyIn(Dist.CLIENT)
public class PlayerAnimatedRenderer extends LivingEntityRenderer<AbstractClientPlayer, EntityModel<AbstractClientPlayer>> {
    private final ResourceLocation PLAYER_SKIN;

    public PlayerAnimatedRenderer(EntityRendererProvider.Context context, ResourceLocation skin, EntityModel<AbstractClientPlayer> model) {
        super(context, model, 0.5F);
        this.PLAYER_SKIN = skin;
    }

    @Override
    protected RenderType getRenderType(AbstractClientPlayer player, boolean p_115323_, boolean p_115324_, boolean p_115325_) {
        return RenderType.entityTranslucent(this.getTextureLocation(player));
    }

    @Override
    public ResourceLocation getTextureLocation(AbstractClientPlayer entity) {
        return this.PLAYER_SKIN;
    }

    @Override
    public void render(AbstractClientPlayer entity, float entityYaw, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int packedLight) {
        try {
            super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);
        } catch (Exception e) {
            matrixStack.popPose();
        }
    }

    @Override
    public Vec3 getRenderOffset(AbstractClientPlayer player, float partialTicks) {
        return player.isCrouching() ? new Vec3(0.0, -0.125, 0.0) : super.getRenderOffset(player, partialTicks);
    }

    @Override
    protected void setupRotations(AbstractClientPlayer player, PoseStack poseStack, float ageInTicks, float rotationYaw, float partialTicks) {
        float f = player.getSwimAmount(partialTicks);
        if (player.isFallFlying()) {
            super.setupRotations(player, poseStack, ageInTicks, rotationYaw, partialTicks);
            float f3 = (float) player.getFallFlyingTicks() + partialTicks;
            float f2 = Mth.clamp(f3 * f3 / 100.0F, 0.0F, 1.0F);
            if (!player.isAutoSpinAttack()) {
                poseStack.mulPose(Axis.XP.rotationDegrees(f2 * (-90.0F - player.getViewXRot(partialTicks))));
            }
        } else if (f > 0.0F) {
            super.setupRotations(player, poseStack, ageInTicks, rotationYaw, partialTicks);
            float f3 = player.isInWater() ? -90.0F : -90.0F - player.getViewXRot(partialTicks);
            float f2 = Mth.lerp(f, 0.0F, f3);
            poseStack.mulPose(Axis.XP.rotationDegrees(f2));
            if (player.isVisuallySwimming()) {
                poseStack.translate(0.0F, -1.0F, 0.3F);
            }
        } else {
            super.setupRotations(player, poseStack, ageInTicks, rotationYaw, partialTicks);
        }

        if (ModList.get().isLoaded("playeranimator")) {
            IAnimatedPlayer animatedPlayer = (IAnimatedPlayer) player;
            AnimationApplier animationPlayer = animatedPlayer.playerAnimator_getAnimation();
            animationPlayer.setTickDelta(partialTicks);
            if (animationPlayer.isActive()) {
                Vec3f position = animationPlayer.get3DTransform("body", TransformType.POSITION, Vec3f.ZERO);
                poseStack.translate(position.getX(), position.getY() + 0.7, position.getZ());
                Vec3f rotation = animationPlayer.get3DTransform("body", TransformType.ROTATION, Vec3f.ZERO);
                poseStack.mulPose(Axis.ZP.rotationDegrees(rotation.getZ()));
                poseStack.mulPose(Axis.YP.rotationDegrees(rotation.getY()));
                poseStack.mulPose(Axis.XP.rotationDegrees(rotation.getX()));
                poseStack.translate(0.0, -0.7, 0.0);
            }
        }
    }
}