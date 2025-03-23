package com.jujutsu.jujutsucraftaddon.mixins;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.mcreator.jujutsucraft.client.screens.OverlayDefaultOverlay;
import net.mcreator.jujutsucraft.procedures.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.event.RenderGuiEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = OverlayDefaultOverlay.class, priority = -1000)
public class OverlayDefaultOverlayMixin {
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
        if (OverlayHaveTechniqueProcedure.execute(entity)) {
            event.getGuiGraphics().blit(new ResourceLocation("jujutsucraft:textures/screens/icon_magic.png"), w / 2 + -200, h / 2 + 104, 0.0F, 0.0F, 16, 16, 16, 16);
            if (LogicCooldownProcedure.execute(entity)) {
                event.getGuiGraphics().blit(new ResourceLocation("jujutsucraft:textures/screens/icon_cooldown.png"), w / 2 + -200, h / 2 + 104, 0.0F, 0.0F, 16, 16, 16, 16);
            }

            event.getGuiGraphics().blit(new ResourceLocation("jujutsucraft:textures/screens/icon_punch.png"), w / 2 + -214, h / 2 + 104, 0.0F, 0.0F, 16, 16, 16, 16);
            if (LogicCooldownCombatProcedure.execute(entity)) {
                event.getGuiGraphics().blit(new ResourceLocation("jujutsucraft:textures/screens/icon_cooldown.png"), w / 2 + -213, h / 2 + 104, 0.0F, 0.0F, 16, 16, 16, 16);
            }

            if (OverlayDomainSkillProcedure.execute(entity)) {
                event.getGuiGraphics().blit(new ResourceLocation("jujutsucraft:textures/screens/icon_domain_expansion2.png"), w / 2 + -216, h / 2 + 82, 0.0F, 0.0F, 32, 32, 32, 32);
            }

            if (OverlayCursedSkillProcedure.execute(entity)) {
                event.getGuiGraphics().blit(new ResourceLocation("jujutsucraft:textures/screens/icon_magic.png"), w / 2 + -215, h / 2 + 82, 0.0F, 0.0F, 32, 32, 32, 32);
            }

            if (OverlayDefaultSkillProcedure.execute(entity)) {
                event.getGuiGraphics().blit(new ResourceLocation("jujutsucraft:textures/screens/icon_default.png"), w / 2 + -216, h / 2 + 82, 0.0F, 0.0F, 32, 32, 32, 32);
            }

            if (OverlayPhysicalSkillProcedure.execute(entity)) {
                event.getGuiGraphics().blit(new ResourceLocation("jujutsucraft:textures/screens/icon_punch.png"), w / 2 + -216, h / 2 + 82, 0.0F, 0.0F, 32, 32, 32, 32);
            }

            if (OverlayPassiveProcedure.execute(entity)) {
                event.getGuiGraphics().blit(new ResourceLocation("jujutsucraft:textures/screens/icon_passive.png"), w / 2 + -216, h / 2 + 82, 0.0F, 0.0F, 32, 32, 32, 32);
            }

            if (OverlayCooldown2Procedure.execute(entity)) {
                event.getGuiGraphics().blit(new ResourceLocation("jujutsucraft:textures/screens/cooldown.png"), w / 2 + -211, h / 2 + 86, 0.0F, 0.0F, 24, 24, 24, 24);
            }

            event.getGuiGraphics().drawString(Minecraft.getInstance().font, OCursePowerProcedure.execute(entity), w / 2 + -180, h / 2 + 86, -205, false);
            event.getGuiGraphics().drawString(Minecraft.getInstance().font, OTechniqueNameProcedure.execute(entity), w / 2 + -180, h / 2 + 95, -205, false);
            event.getGuiGraphics().drawString(Minecraft.getInstance().font, OCostProcedure.execute(entity), w / 2 + -180, h / 2 + 104, -205, false);
            if (OverlayCooldown2TimerProcedure.execute(entity)) {
                event.getGuiGraphics().drawString(Minecraft.getInstance().font, OCoolTimeSelectingProcedure.execute(entity), w / 2 + -203, h / 2 + 95, -205, false);
            }

            if (LogicCooldownCombatProcedure.execute(entity)) {
                event.getGuiGraphics().drawString(Minecraft.getInstance().font, OCoolTimeCombatProcedure.execute(entity), w / 2 + -208, h / 2 + 107, -205, false);
            }

            if (LogicCooldownMagicOnlyProcedure.execute(entity)) {
                event.getGuiGraphics().drawString(Minecraft.getInstance().font, OCoolTimeProcedure.execute(entity), w / 2 + -194, h / 2 + 107, -205, false);
            }
        }

        RenderSystem.depthMask(true);
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }
}
