package com.jujutsu.jujutsucraftaddon.client.gui;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.network.ProfessionGUIButtonMessage;
import com.jujutsu.jujutsucraftaddon.world.inventory.ProfessionGUIMenu;
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

public class ProfessionGUIScreen extends AbstractContainerScreen<ProfessionGUIMenu> {
    private final static HashMap<String, Object> guistate = ProfessionGUIMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    Button button_healer;
    Button button_blacksmith;
    Button button_warrior;
    Button button_jujutsu_sage;

    public ProfessionGUIScreen(ProfessionGUIMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 200;
        this.imageHeight = 200;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
        if (this.button_healer != null && this.button_healer.isMouseOver(mouseX, mouseY)) {
            guiGraphics.renderTooltip(this.font, Component.literal("Immunity to Anti-Heal, Fatigue Rate Reduced"), mouseX, mouseY);
        }
        if (this.button_blacksmith != null && this.button_blacksmith.isMouseOver(mouseX, mouseY)) {
            guiGraphics.renderTooltip(this.font, Component.literal("Each Element Gives Special Buffs, Can Enchant More Weapons"), mouseX, mouseY);
        }
        if (this.button_warrior != null && this.button_warrior.isMouseOver(mouseX, mouseY)) {
            guiGraphics.renderTooltip(this.font, Component.literal("Apply Anti-Healing, 120% Mode, Damage Buffed"), mouseX, mouseY);
        }
        if (this.button_jujutsu_sage != null && this.button_jujutsu_sage.isMouseOver(mouseX, mouseY)) {
            guiGraphics.renderTooltip(this.font, Component.literal("50% Less Cooldown, More Drop Luck, Progression More Faster"), mouseX, mouseY);
        }
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        guiGraphics.blit(new ResourceLocation("jujutsucraftaddon:textures/screens/shokoanime1.png"), this.leftPos + 24, this.topPos + 2, 0, 0, 60, 60, 60, 60);

        guiGraphics.blit(new ResourceLocation("jujutsucraftaddon:textures/screens/sage.png"), this.leftPos + 125, this.topPos + 3, 0, 0, 60, 60, 60, 60);

        guiGraphics.blit(new ResourceLocation("jujutsucraftaddon:textures/screens/warrior.png"), this.leftPos + 122, this.topPos + 88, 0, 0, 60, 60, 60, 60);

        guiGraphics.blit(new ResourceLocation("jujutsucraftaddon:textures/screens/blacksmith.png"), this.leftPos + 24, this.topPos + 87, 0, 0, 60, 60, 60, 60);

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
        button_healer = Button.builder(Component.translatable("gui.jujutsucraftaddon.profession_gui.button_healer"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new ProfessionGUIButtonMessage(0, x, y, z));
                ProfessionGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
            }
        }).bounds(this.leftPos + 26, this.topPos + 60, 56, 20).build();
        guistate.put("button:button_healer", button_healer);
        this.addRenderableWidget(button_healer);
        button_blacksmith = Button.builder(Component.translatable("gui.jujutsucraftaddon.profession_gui.button_blacksmith"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new ProfessionGUIButtonMessage(1, x, y, z));
                ProfessionGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
            }
        }).bounds(this.leftPos + 15, this.topPos + 147, 77, 20).build();
        guistate.put("button:button_blacksmith", button_blacksmith);
        this.addRenderableWidget(button_blacksmith);
        button_warrior = Button.builder(Component.translatable("gui.jujutsucraftaddon.profession_gui.button_warrior"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new ProfessionGUIButtonMessage(2, x, y, z));
                ProfessionGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
            }
        }).bounds(this.leftPos + 122, this.topPos + 147, 61, 20).build();
        guistate.put("button:button_warrior", button_warrior);
        this.addRenderableWidget(button_warrior);
        button_jujutsu_sage = Button.builder(Component.translatable("gui.jujutsucraftaddon.profession_gui.button_jujutsu_sage"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new ProfessionGUIButtonMessage(3, x, y, z));
                ProfessionGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
            }
        }).bounds(this.leftPos + 111, this.topPos + 63, 87, 20).build();
        guistate.put("button:button_jujutsu_sage", button_jujutsu_sage);
        this.addRenderableWidget(button_jujutsu_sage);
    }
}
