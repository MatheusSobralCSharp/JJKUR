package com.jujutsu.jujutsucraftaddon.client.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Items;

public class AbilityTab extends JJKTab {
    private static final Component TITLE = Component.translatable("gui.jujutsukaisen.ability");

    private float fade;

    public AbilityTab(Minecraft minecraft, JujutsuMenuScreen screen, JJKTabType type, int index, int page) {
        super(minecraft, screen, type, index, page, Items.ENDER_PEARL.getDefaultInstance(), TITLE, true);
    }

    @Override
    public void drawContents(GuiGraphics pGuiGraphics, int pX, int pY) {
        super.drawContents(pGuiGraphics, pX, pY);

        if (this.minecraft.player == null) return;

        int i = (this.screen.width - JujutsuMenuScreen.WINDOW_WIDTH) / 2;
        int j = (this.screen.height - JujutsuMenuScreen.WINDOW_HEIGHT) / 2;

        int xOffset = i + (JujutsuMenuScreen.WINDOW_WIDTH - JujutsuMenuScreen.WINDOW_INSIDE_WIDTH);
        int yOffset = j + (JujutsuMenuScreen.WINDOW_HEIGHT - JujutsuMenuScreen.WINDOW_INSIDE_HEIGHT);

        pGuiGraphics.drawString(this.minecraft.font, Component.translatable("gui.jujutsukaisen.ability.points", 0),
                xOffset, yOffset, 16777215, true);
    }

    @Override
    protected void drawCustom(GuiGraphics graphics, int x, int y) {
        // No custom content to draw
    }

    @Override
    public void drawTooltips(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, int pOffsetX, int pOffsetY) {
        super.drawTooltips(pGuiGraphics, pMouseX, pMouseY, pOffsetX, pOffsetY);

        pGuiGraphics.pose().pushPose();
        pGuiGraphics.pose().translate((float) (pOffsetX + 9), (float) (pOffsetY + 18), 400.0F);
        RenderSystem.enableDepthTest();

        pGuiGraphics.pose().pushPose();
        pGuiGraphics.pose().translate(0.0D, 0.0D, -200.0D);
        pGuiGraphics.fill(0, 0, JujutsuMenuScreen.WINDOW_INSIDE_WIDTH, JujutsuMenuScreen.WINDOW_INSIDE_HEIGHT, Mth.floor(this.fade * 255.0F) << 24);

        this.fade = Mth.clamp(this.fade - 0.04F, 0.0F, 1.0F);

        RenderSystem.disableDepthTest();
        pGuiGraphics.pose().popPose();
    }

    @Override
    public void addWidgets() {
        // No widgets to add
    }

    @Override
    public void mouseClicked(double pMouseX, double pMouseY, int pButton) {
        // No mouse click behavior needed
    }
}
