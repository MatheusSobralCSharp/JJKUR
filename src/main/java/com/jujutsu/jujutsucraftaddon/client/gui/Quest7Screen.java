package com.jujutsu.jujutsucraftaddon.client.gui;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.network.Quest7ButtonMessage;
import com.jujutsu.jujutsucraftaddon.world.inventory.Quest7Menu;
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

public class Quest7Screen extends AbstractContainerScreen<Quest7Menu> {
    private final static HashMap<String, Object> guistate = Quest7Menu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    Button button_continue;
    Button button_reset;

    public Quest7Screen(Quest7Menu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    private static final ResourceLocation texture = new ResourceLocation("jujutsucraftaddon:textures/screens/quest_7.png");

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
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.quest_7.label_history_mode"), 44, 15, -12829636, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.quest_7.label_chapter_1_hidden_inventory_arc"), 16, 35, -12829636, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.quest_7.label_beat_toji_with_geto_and_gojo"), 31, 55, -12829636, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.quest_7.label_miguel_vs_gojo"), 41, 76, -12829636, false);
    }

    @Override
    public void init() {
        super.init();
        button_continue = Button.builder(Component.translatable("gui.jujutsucraftaddon.quest_7.button_continue"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new Quest7ButtonMessage(0, x, y, z));
                Quest7ButtonMessage.handleButtonAction(entity, 0, x, y, z);
            }
        }).bounds(this.leftPos + 51, this.topPos + 100, 67, 20).build();
        guistate.put("button:button_continue", button_continue);
        this.addRenderableWidget(button_continue);
        button_reset = Button.builder(Component.translatable("gui.jujutsucraftaddon.quest_7.button_reset"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new Quest7ButtonMessage(1, x, y, z));
                Quest7ButtonMessage.handleButtonAction(entity, 1, x, y, z);
            }
        }).bounds(this.leftPos + 58, this.topPos + 128, 51, 20).build();
        guistate.put("button:button_reset", button_reset);
        this.addRenderableWidget(button_reset);
    }
}
