package com.jujutsu.jujutsucraftaddon;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderArmEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.minecraft.client.renderer.texture.OverlayTexture.pack;

@Mod.EventBusSubscriber(modid = "jujutsucraftaddon", value = Dist.CLIENT)
public class SkinChangeHandler {


    // Render Skin
    @SubscribeEvent
    public static void onPlayerRender(RenderLivingEvent event) {
        RenderLivingEvent _evt = event;
        Minecraft mc = Minecraft.getInstance();
        EntityRenderDispatcher dis = Minecraft.getInstance().getEntityRenderDispatcher();
        EntityRendererProvider.Context context = new EntityRendererProvider.Context(dis, mc.getItemRenderer(), mc.getBlockRenderer(), dis.getItemInHandRenderer(), mc.getResourceManager(),
                mc.getEntityModels(), mc.font);
        Entity _evtEntity = _evt.getEntity();
        PlayerRenderer _pr = null;
        PoseStack poseStack = _evt.getPoseStack();

        if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof SkinCancel)) {
            ResourceLocation _texture = new ResourceLocation("jujutsucraftaddon:textures/entities/empty.png");
            SkinRenderer emptyRenderer = new SkinRenderer(context,
                    (_evtEntity instanceof AbstractClientPlayer ? ((AbstractClientPlayer) _evtEntity).getModelName().equals("slim") : false), _texture);
            _pr = emptyRenderer;
            emptyRenderer.clearLayers();
            emptyRenderer.render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(), _evt.getMultiBufferSource(), _evt.getPackedLight());
        }

        if (_evtEntity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).tag1.equals("One")) {
            if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof SkinCancel)) {
                if (_evt.getRenderer() instanceof LivingEntityRenderer && !(_evt.getRenderer() instanceof SkinCancel)) {
                    if (_evt instanceof RenderLivingEvent.Pre _pre) {
                        _pre.setCanceled(true);
                    }
                }
                EntityRenderDispatcher entityRenderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
                EntityRenderer<? super LivingEntity> livingRenderer = entityRenderDispatcher.getRenderer(_evt.getEntity());
                ResourceLocation resourceLocation = livingRenderer.getTextureLocation(_evt.getEntity());
                ResourceLocation _texture = resourceLocation;
                if (ResourceLocation.tryParse(_evtEntity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).MobTexture) != null) {
                    if (!(_evtEntity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).MobTexture).isEmpty()) {
                        _texture = new ResourceLocation(_evtEntity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).MobTexture);
                    }
                }
                new SkinRenderer(context, false, _texture)
                        .render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(), _evt.getMultiBufferSource(), _evt.getPackedLight());
            }
        } else if  (_evtEntity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).tag1.equals("Two")) {
            if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof SkinCancel)) {
                if (_evt.getRenderer() instanceof LivingEntityRenderer && !(_evt.getRenderer() instanceof SkinCancel)) {
                    if (_evt instanceof RenderLivingEvent.Pre _pre) {
                        _pre.setCanceled(true);
                    }
                }
                EntityRenderDispatcher entityRenderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
                EntityRenderer<? super LivingEntity> livingRenderer = entityRenderDispatcher.getRenderer(_evt.getEntity());
                ResourceLocation resourceLocation = livingRenderer.getTextureLocation(_evt.getEntity());
                ResourceLocation _texture = resourceLocation;
                if (ResourceLocation.tryParse(_evtEntity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).MobTexture2) != null) {
                    if (!(_evtEntity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).MobTexture2).isEmpty()) {
                        _texture = new ResourceLocation(_evtEntity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).MobTexture2);
                    }
                }
                new SkinRenderer(context, false, _texture)
                        .render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(), _evt.getMultiBufferSource(), _evt.getPackedLight());
            }

        } else if  (_evtEntity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).tag1.equals("Three")) {
            if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof SkinCancel)) {
                if (_evt.getRenderer() instanceof LivingEntityRenderer && !(_evt.getRenderer() instanceof SkinCancel)) {
                    if (_evt instanceof RenderLivingEvent.Pre _pre) {
                        _pre.setCanceled(true);
                    }
                }

                EntityRenderDispatcher entityRenderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
                EntityRenderer<? super LivingEntity> livingRenderer = entityRenderDispatcher.getRenderer(_evt.getEntity());
                ResourceLocation resourceLocation = livingRenderer.getTextureLocation(_evt.getEntity());
                ResourceLocation _texture = resourceLocation;
                if (ResourceLocation.tryParse(_evtEntity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).MobTexture3) != null) {
                    if (!(_evtEntity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).MobTexture3).isEmpty()) {
                        _texture = new ResourceLocation(_evtEntity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).MobTexture3);
                    }
                }
                new SkinRenderer(context, false, _texture)
                        .render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(), _evt.getMultiBufferSource(), _evt.getPackedLight());
            }
        }
    }


    // Render Arm
    @SubscribeEvent
    public static void onPlayerRender(RenderArmEvent event) {
        RenderArmEvent _evt = (RenderArmEvent) event;
        Minecraft mc = Minecraft.getInstance();
        EntityRenderDispatcher dis = mc.getEntityRenderDispatcher();
        Entity _evtEntity = _evt.getPlayer();
        PlayerRenderer playerRenderer = (PlayerRenderer) dis.getRenderer(_evt.getPlayer());
        EntityRendererProvider.Context context = new EntityRendererProvider.Context(dis, mc.getItemRenderer(), mc.getBlockRenderer(), dis.getItemInHandRenderer(), mc.getResourceManager(), mc.getEntityModels(), mc.font);
        MultiBufferSource bufferSource = _evt.getMultiBufferSource();
        int packedLight = _evt.getPackedLight();
        PoseStack poseStack = _evt.getPoseStack();
        PlayerModel<AbstractClientPlayer> playerModel = new PlayerModel<>(context.bakeLayer(ModelLayers.PLAYER), false);
        playerModel.attackTime = 0.0F;
        playerModel.crouching = false;
        playerModel.swimAmount = 0.0F;
        playerModel.setupAnim(_evt.getPlayer(), 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        playerModel.leftArm.xRot = 0.0F;
        playerModel.rightArm.xRot = 0.0F;
        HumanoidArm arm = _evt.getArm();
        if (_evtEntity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).tag1.equals("One")) {
            EntityRenderDispatcher entityRenderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
            EntityRenderer<? super LivingEntity> livingRenderer = entityRenderDispatcher.getRenderer(_evt.getPlayer());
            ResourceLocation resourceLocation = livingRenderer.getTextureLocation(_evt.getPlayer());
            ResourceLocation _texture = resourceLocation;
            if (ResourceLocation.tryParse(_evtEntity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).MobTexture) != null) {
                if (!(_evtEntity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).MobTexture).isEmpty()) {
                    _texture = new ResourceLocation(_evtEntity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).MobTexture);
                }
            }
            PlayerModel<AbstractClientPlayer> newModel = new PlayerModel<>(context.bakeLayer(false ? ModelLayers.PLAYER_SLIM : ModelLayers.PLAYER), false);
            newModel.leftArm.copyFrom(playerModel.leftArm);
            newModel.rightArm.copyFrom(playerModel.rightArm);
            if (arm == HumanoidArm.LEFT) {
                newModel.leftArm.render(_evt.getPoseStack(), bufferSource.getBuffer(RenderType.entityTranslucentCull(_texture)), packedLight, net.minecraft.client.renderer.texture.OverlayTexture.NO_OVERLAY);
            } else {
                newModel.rightArm.render(_evt.getPoseStack(), bufferSource.getBuffer(RenderType.entityTranslucentCull(_texture)), packedLight, net.minecraft.client.renderer.texture.OverlayTexture.NO_OVERLAY);
            }
            _evt.setCanceled(true);
        } else if  (_evtEntity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).tag1.equals("Two")) {
            EntityRenderDispatcher entityRenderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
            EntityRenderer<? super LivingEntity> livingRenderer = entityRenderDispatcher.getRenderer(_evt.getPlayer());
            ResourceLocation resourceLocation = livingRenderer.getTextureLocation(_evt.getPlayer());
            ResourceLocation _texture = resourceLocation;
            if (ResourceLocation.tryParse(_evtEntity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).MobTexture2) != null) {
                if (!(_evtEntity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).MobTexture2).isEmpty()) {
                    _texture = new ResourceLocation(_evtEntity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).MobTexture2);
                }
            }
            PlayerModel<AbstractClientPlayer> newModel = new PlayerModel<>(context.bakeLayer(false ? ModelLayers.PLAYER_SLIM : ModelLayers.PLAYER), false);
            newModel.leftArm.copyFrom(playerModel.leftArm);
            newModel.rightArm.copyFrom(playerModel.rightArm);
            if (arm == HumanoidArm.LEFT) {
                newModel.leftArm.render(_evt.getPoseStack(), bufferSource.getBuffer(RenderType.entityTranslucentCull(_texture)), packedLight, net.minecraft.client.renderer.texture.OverlayTexture.NO_OVERLAY);
            } else {
                newModel.rightArm.render(_evt.getPoseStack(), bufferSource.getBuffer(RenderType.entityTranslucentCull(_texture)), packedLight, net.minecraft.client.renderer.texture.OverlayTexture.NO_OVERLAY);
            }
            _evt.setCanceled(true);

        } else if  (_evtEntity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).tag1.equals("Three")) {
            EntityRenderDispatcher entityRenderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
            EntityRenderer<? super LivingEntity> livingRenderer = entityRenderDispatcher.getRenderer(_evt.getPlayer());
            ResourceLocation resourceLocation = livingRenderer.getTextureLocation(_evt.getPlayer());
            ResourceLocation _texture = resourceLocation;
            if (ResourceLocation.tryParse(_evtEntity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).MobTexture3) != null) {
                if (!(_evtEntity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).MobTexture3).isEmpty()) {
                    _texture = new ResourceLocation(_evtEntity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).MobTexture3);
                }
            }
            PlayerModel<AbstractClientPlayer> newModel = new PlayerModel<>(context.bakeLayer(false ? ModelLayers.PLAYER_SLIM : ModelLayers.PLAYER), false);
            newModel.leftArm.copyFrom(playerModel.leftArm);
            newModel.rightArm.copyFrom(playerModel.rightArm);
            if (arm == HumanoidArm.LEFT) {
                newModel.leftArm.render(_evt.getPoseStack(), bufferSource.getBuffer(RenderType.entityTranslucentCull(_texture)), packedLight, net.minecraft.client.renderer.texture.OverlayTexture.NO_OVERLAY);
            } else {
                newModel.rightArm.render(_evt.getPoseStack(), bufferSource.getBuffer(RenderType.entityTranslucentCull(_texture)), packedLight, net.minecraft.client.renderer.texture.OverlayTexture.NO_OVERLAY);
            }
            _evt.setCanceled(true);

        }
    }
}


