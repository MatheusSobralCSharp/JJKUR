package com.jujutsu.jujutsucraftaddon.mixins;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.mcreator.jujutsucraft.client.screens.OverlayBackstepOverlay;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.event.RenderGuiEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = OverlayBackstepOverlay.class,  priority = -1000)
public class OverlayBackstepOverlayMixin {
    @Inject(
            method = {"eventHandler"},
            at = {@At("HEAD")},
            cancellable = true,
            remap = false
    )
    private static void eventHandler(RenderGuiEvent.Pre event, CallbackInfo ci) {
        ci.cancel();

        int w = event.getWindow().getGuiScaledWidth();
        int h = event.getWindow().getGuiScaledHeight();
        Level world = null;
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;
        Player entity = Minecraft.getInstance().player;
        if (entity != null) {
            world = entity.level();
            x = entity.getX();
            y = entity.getY();
            z = entity.getZ();
        }
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
////        if (OverlayHaveTechniqueProcedure.execute(entity)) {
////            if (OFlyDispProcedure.execute(entity)) {
////                event.getGuiGraphics().blit(new ResourceLocation("jujutsucraft:textures/screens/icon_fly.png"), w / 2 + 0, h / 2 + 55, 0.0F, 0.0F, 16, 16, 16, 16);
////            }
////
////            if (ODoubleJumpDispProcedure.execute(entity)) {
////                event.getGuiGraphics().blit(new ResourceLocation("jujutsucraft:textures/screens/icon_double_jump.png"), w / 2 + 0, h / 2 + 64, 0.0F, 0.0F, 16, 16, 16, 16);
////            }
////
////            event.getGuiGraphics().blit(new ResourceLocation("jujutsucraft:textures/screens/icon_backstep.png"), w / 2 + 0, h / 2 + 73, 0.0F, 0.0F, 16, 16, 16, 16);
////            event.getGuiGraphics().drawString(Minecraft.getInstance().font, OBackstepProcedure.execute(entity), w / 2 + 14, h / 2 + 77, -1, false);
////            if (OFlyDispProcedure.execute(entity)) {
////                event.getGuiGraphics().drawString(Minecraft.getInstance().font, OFlyProcedure.execute(entity), w / 2 + 14, h / 2 + 59, -1, false);
////            }
////
////            if (ODoubleJumpDispProcedure.execute(entity)) {
////                event.getGuiGraphics().drawString(Minecraft.getInstance().font, ODoubleJumpProcedure.execute(entity), w / 2 + 14, h / 2 + 68, -1, false);
////            }
////        }
//
        RenderSystem.depthMask(true);
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }
}
