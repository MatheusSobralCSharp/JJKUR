package com.jujutsu.jujutsucraftaddon.client.gui;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.network.EnchantYorozuButtonMessage;
import com.jujutsu.jujutsucraftaddon.world.inventory.EnchantYorozuMenu;
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

public class EnchantYorozuScreen extends AbstractContainerScreen<EnchantYorozuMenu> {
    private final static HashMap<String, Object> guistate = EnchantYorozuMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    Button button_sharpness;
    Button button_looting;
    Button button_fire_aspect;
    Button button_lure;

    public EnchantYorozuScreen(EnchantYorozuMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 200;
        this.imageHeight = 200;
    }

    private static final ResourceLocation texture = new ResourceLocation("jujutsucraftaddon:textures/screens/enchant_yorozu.png");

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
    }

    @Override
    public void init() {
        super.init();
        button_sharpness = Button.builder(Component.translatable("gui.jujutsucraftaddon.enchant_yorozu.button_sharpness"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new EnchantYorozuButtonMessage(0, x, y, z));
                EnchantYorozuButtonMessage.handleButtonAction(entity, 0, x, y, z);
            }
        }).bounds(this.leftPos + 61, this.topPos + 25, 72, 20).build();
        guistate.put("button:button_sharpness", button_sharpness);
        this.addRenderableWidget(button_sharpness);
        button_looting = Button.builder(Component.translatable("gui.jujutsucraftaddon.enchant_yorozu.button_looting"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new EnchantYorozuButtonMessage(1, x, y, z));
                EnchantYorozuButtonMessage.handleButtonAction(entity, 1, x, y, z);
            }
        }).bounds(this.leftPos + 68, this.topPos + 64, 61, 20).build();
        guistate.put("button:button_looting", button_looting);
        this.addRenderableWidget(button_looting);
        button_fire_aspect = Button.builder(Component.translatable("gui.jujutsucraftaddon.enchant_yorozu.button_fire_aspect"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new EnchantYorozuButtonMessage(2, x, y, z));
                EnchantYorozuButtonMessage.handleButtonAction(entity, 2, x, y, z);
            }
        }).bounds(this.leftPos + 58, this.topPos + 107, 82, 20).build();
        guistate.put("button:button_fire_aspect", button_fire_aspect);
        this.addRenderableWidget(button_fire_aspect);
        button_lure = Button.builder(Component.translatable("gui.jujutsucraftaddon.enchant_yorozu.button_lure"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new EnchantYorozuButtonMessage(3, x, y, z));
                EnchantYorozuButtonMessage.handleButtonAction(entity, 3, x, y, z);
            }
        }).bounds(this.leftPos + 72, this.topPos + 145, 46, 20).build();
        guistate.put("button:button_lure", button_lure);
        this.addRenderableWidget(button_lure);
    }
}
