package com.jujutsu.jujutsucraftaddon.client.gui;

import com.jujutsu.jujutsucraftaddon.world.inventory.EvidenceGUIMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.HashMap;

public class EvidenceGUIScreen extends AbstractContainerScreen<EvidenceGUIMenu> {
    private final static HashMap<String, Object> guistate = EvidenceGUIMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    Button button_yes;
    Button button_no;

    public EvidenceGUIScreen(EvidenceGUIMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    private static final ResourceLocation texture = new ResourceLocation("jujutsucraftaddon:textures/screens/evidence_gui.png");

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
        RenderSystem.disableBlend();
    }

    @Override
    public boolean keyPressed(int key, int b, int c) {
        if (key == 256) {
            this.minecraft.player.closeContainer();
            return true;
        }
        return super.keyPressed(key, b, c);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.evidence_gui.label_summon_shikigami"), 40, 19, -6225920, false);
    }

    @Override
    public void init() {
        super.init();
        button_yes = Button.builder(Component.translatable("gui.jujutsucraftaddon.evidence_gui.button_yes"), e -> {
        }).bounds(this.leftPos + 20, this.topPos + 112, 40, 20).build();
        guistate.put("button:button_yes", button_yes);
        this.addRenderableWidget(button_yes);
        button_no = Button.builder(Component.translatable("gui.jujutsucraftaddon.evidence_gui.button_no"), e -> {
        }).bounds(this.leftPos + 120, this.topPos + 112, 35, 20).build();
        guistate.put("button:button_no", button_no);
        this.addRenderableWidget(button_no);
    }
}
