package com.jujutsu.jujutsucraftaddon.client.gui;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.network.RaceChangeButtonMessage;
import com.jujutsu.jujutsucraftaddon.world.inventory.RaceChangeMenu;
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

public class RaceChangeScreen extends AbstractContainerScreen<RaceChangeMenu> {
    private final static HashMap<String, Object> guistate = RaceChangeMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    Button button_cursed_spirit;
    Button button_jujutsu_sorcerer;
    Button button_incarnated_sorcerer;

    public RaceChangeScreen(RaceChangeMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 170;
        this.imageHeight = 170;
    }

    private static final ResourceLocation texture = new ResourceLocation("jujutsucraftaddon:textures/screens/race_change.png");

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
        if (button_jujutsu_sorcerer != null && button_jujutsu_sorcerer.isMouseOver(mouseX, mouseY)) {
            guiGraphics.renderTooltip(font, Component.literal("JujutsuSorcerer: Allows you progress everything and unlock secrets that other races can't"), mouseX, mouseY);
        }
        if (button_cursed_spirit != null && button_cursed_spirit.isMouseOver(mouseX, mouseY)) {
            guiGraphics.renderTooltip(font, Component.literal("CursedSpirits: Passive Regeneration, Less Cooldowns And More Resistance"), mouseX, mouseY);
        }
        if (button_incarnated_sorcerer != null && button_incarnated_sorcerer.isMouseOver(mouseX, mouseY)) {
            guiGraphics.renderTooltip(font, Component.literal("Cursed Vessels: More Attributes, Passives and Mix Both Races"), mouseX, mouseY);
        }
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
        button_cursed_spirit = Button.builder(Component.translatable("gui.jujutsucraftaddon.race_change.button_cursed_spirit"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new RaceChangeButtonMessage(0, x, y, z));
                RaceChangeButtonMessage.handleButtonAction(entity, 0, x, y, z);
            }
        }).bounds(this.leftPos + 36, this.topPos + 66, 93, 20).build();
        guistate.put("button:button_cursed_spirit", button_cursed_spirit);
        this.addRenderableWidget(button_cursed_spirit);
        button_jujutsu_sorcerer = Button.builder(Component.translatable("gui.jujutsucraftaddon.race_change.button_jujutsu_sorcerer"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new RaceChangeButtonMessage(1, x, y, z));
                RaceChangeButtonMessage.handleButtonAction(entity, 1, x, y, z);
            }
        }).bounds(this.leftPos + 28, this.topPos + 24, 108, 20).build();
        guistate.put("button:button_jujutsu_sorcerer", button_jujutsu_sorcerer);
        this.addRenderableWidget(button_jujutsu_sorcerer);
        button_incarnated_sorcerer = Button.builder(Component.translatable("gui.jujutsucraftaddon.race_change.button_incarnated_sorcerer"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new RaceChangeButtonMessage(2, x, y, z));
                RaceChangeButtonMessage.handleButtonAction(entity, 2, x, y, z);
            }
        }).bounds(this.leftPos + 19, this.topPos + 109, 124, 20).build();
        guistate.put("button:button_incarnated_sorcerer", button_incarnated_sorcerer);
        this.addRenderableWidget(button_incarnated_sorcerer);
    }
}
