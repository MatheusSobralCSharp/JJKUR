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
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderArmEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "jujutsucraftaddon", value = Dist.CLIENT)
public class SkinChangeHandler {

    private static ResourceLocation getCustomTexture(Player player, JujutsucraftaddonModVariables.PlayerVariables vars) {
        String tag = vars.tag1;
        if ("One".equals(tag)) {
            return safeTexture(vars.MobTexture);
        } else if ("Two".equals(tag)) {
            return safeTexture(vars.MobTexture2);
        } else if ("Three".equals(tag)) {
            return safeTexture(vars.MobTexture3);
        }
        return null;
    }

    private static ResourceLocation safeTexture(String tex) {
        return tex != null && !tex.isEmpty() ? new ResourceLocation(tex) : null;
    }

    @SubscribeEvent
    public static void onRenderPlayer(RenderLivingEvent.Pre<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> event) {
        if (!(event.getEntity() instanceof AbstractClientPlayer player)) return;

        player.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(vars -> {
            ResourceLocation customTex = getCustomTexture(player, vars);
            if (customTex != null && event.getRenderer() instanceof PlayerRenderer playerRenderer) {
                PlayerModel<AbstractClientPlayer> model = playerRenderer.getModel();
                model.attackTime = 0;
                model.crouching = player.isCrouching();
                model.swimAmount = player.getSwimAmount(event.getPartialTick());
                model.setupAnim(player, 0, 0, 0, player.getYRot(), player.getXRot());

                MultiBufferSource buffer = event.getMultiBufferSource();
                PoseStack stack = event.getPoseStack();

                RenderType renderType = RenderType.entityTranslucentCull(customTex);
                model.renderToBuffer(stack, buffer.getBuffer(renderType), event.getPackedLight(), 0xF000F0, 1.0F, 1.0F, 1.0F, 1.0F);
            }
        });
    }

    @SubscribeEvent
    public static void onRenderArm(RenderArmEvent event) {
        Player player = event.getPlayer();

        player.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(vars -> {
            ResourceLocation texture = getCustomTexture(player, vars);
            if (texture == null) return;

            Minecraft mc = Minecraft.getInstance();
            PlayerModel<AbstractClientPlayer> model = new PlayerModel<>(mc.getEntityModels().bakeLayer(ModelLayers.PLAYER), false);

            model.attackTime = 0;
            model.crouching = player.isCrouching();
            model.swimAmount = 0.0F;
            model.setupAnim((AbstractClientPlayer) player, 0, 0, 0, 0, 0);

            PoseStack poseStack = event.getPoseStack();
            MultiBufferSource buffer = event.getMultiBufferSource();
            int packedLight = event.getPackedLight();
            HumanoidArm arm = event.getArm();

            if (arm == HumanoidArm.LEFT) {
                model.leftArm.render(poseStack, buffer.getBuffer(RenderType.entityTranslucentCull(texture)), packedLight, 0xF000F0);
            } else {
                model.rightArm.render(poseStack, buffer.getBuffer(RenderType.entityTranslucentCull(texture)), packedLight, 0xF000F0);
            }

            event.setCanceled(true); // Only cancel default if we rendered a valid arm.
        });
    }
}
