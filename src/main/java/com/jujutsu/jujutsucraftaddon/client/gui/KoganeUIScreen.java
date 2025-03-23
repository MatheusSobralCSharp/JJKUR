package com.jujutsu.jujutsucraftaddon.client.gui;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.network.KoganeUIButtonMessage;
import com.jujutsu.jujutsucraftaddon.world.inventory.KoganeUIMenu;
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

public class KoganeUIScreen extends AbstractContainerScreen<KoganeUIMenu> {
    private final static HashMap<String, Object> guistate = KoganeUIMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    Button button_random_rule;
    Button button_random_player_punishment;
    Button button_summon_sukuna_fushiguro;

    public KoganeUIScreen(KoganeUIMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

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

        guiGraphics.blit(new ResourceLocation("jujutsucraftaddon:textures/screens/kogane_showing_player_data2.png"), this.leftPos + -28, this.topPos + -30, 0, 0, 225, 225, 225, 225);

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
        button_random_rule = Button.builder(Component.translatable("gui.jujutsucraftaddon.kogane_ui.button_random_rule"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new KoganeUIButtonMessage(0, x, y, z));
                KoganeUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
            }
        }).bounds(this.leftPos + 44, this.topPos + 25, 82, 20).build();
        guistate.put("button:button_random_rule", button_random_rule);
        this.addRenderableWidget(button_random_rule);
        button_random_player_punishment = Button.builder(Component.translatable("gui.jujutsucraftaddon.kogane_ui.button_random_player_punishment"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new KoganeUIButtonMessage(1, x, y, z));
                KoganeUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
            }
        }).bounds(this.leftPos + 13, this.topPos + 63, 150, 20).build();
        guistate.put("button:button_random_player_punishment", button_random_player_punishment);
        this.addRenderableWidget(button_random_player_punishment);
        button_summon_sukuna_fushiguro = Button.builder(Component.translatable("gui.jujutsucraftaddon.kogane_ui.button_summon_sukuna_fushiguro"), e -> {
        }).bounds(this.leftPos + 17, this.topPos + 102, 145, 20).build();
        guistate.put("button:button_summon_sukuna_fushiguro", button_summon_sukuna_fushiguro);
        this.addRenderableWidget(button_summon_sukuna_fushiguro);
    }
}
