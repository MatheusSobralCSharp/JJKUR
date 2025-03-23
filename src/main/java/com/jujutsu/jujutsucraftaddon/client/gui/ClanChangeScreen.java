package com.jujutsu.jujutsucraftaddon.client.gui;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.network.ClanChangeButtonMessage;
import com.jujutsu.jujutsucraftaddon.procedures.ReturnClanSlot1Procedure;
import com.jujutsu.jujutsucraftaddon.procedures.ReturnClanSlot2Procedure;
import com.jujutsu.jujutsucraftaddon.procedures.ReturnClanSlot3Procedure;
import com.jujutsu.jujutsucraftaddon.world.inventory.ClanChangeMenu;
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

public class ClanChangeScreen extends AbstractContainerScreen<ClanChangeMenu> {
    private final static HashMap<String, Object> guistate = ClanChangeMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    Button button_incarnated_sorcerer;
    Button button_check_your_clan;
    Button button_store;
    Button button_equip;
    Button button_store1;
    Button button_equip1;
    Button button_store2;
    Button button_equip2;

    public ClanChangeScreen(ClanChangeMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 400;
        this.imageHeight = 200;
    }

    private static final ResourceLocation texture = new ResourceLocation("jujutsucraftaddon:textures/screens/clan_change.png");

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
        if (this.button_check_your_clan != null && this.button_check_your_clan.isMouseOver(mouseX, mouseY)) {
            guiGraphics.renderTooltip(this.font, Component.literal("Check Your Clan"), mouseX, mouseY);
        }
        if (this.button_incarnated_sorcerer != null && this.button_incarnated_sorcerer.isMouseOver(mouseX, mouseY)) {
            guiGraphics.renderTooltip(this.font, Component.literal("Spin Your Clan"), mouseX, mouseY);
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
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.clan_change.label_clan_slot_1"), 251, 18, -12829636, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.clan_change.label_clan_slot_2"), 251, 76, -12829636, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.clan_change.label_clan_slot_3"), 251, 129, -12829636, false);
        guiGraphics.drawString(this.font,

                ReturnClanSlot1Procedure.execute(entity), 315, 17, -12829636, false);
        guiGraphics.drawString(this.font,

                ReturnClanSlot2Procedure.execute(entity), 315, 76, -12829636, false);
        guiGraphics.drawString(this.font,

                ReturnClanSlot3Procedure.execute(entity), 315, 129, -12829636, false);
    }

    @Override
    public void init() {
        super.init();
        button_incarnated_sorcerer = Button.builder(Component.translatable("gui.jujutsucraftaddon.clan_change.button_incarnated_sorcerer"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new ClanChangeButtonMessage(0, x, y, z));
                ClanChangeButtonMessage.handleButtonAction(entity, 0, x, y, z);
            }
        }).bounds(this.leftPos + 19, this.topPos + 46, 124, 20).build();
        guistate.put("button:button_incarnated_sorcerer", button_incarnated_sorcerer);
        this.addRenderableWidget(button_incarnated_sorcerer);
        button_check_your_clan = Button.builder(Component.translatable("gui.jujutsucraftaddon.clan_change.button_check_your_clan"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new ClanChangeButtonMessage(1, x, y, z));
                ClanChangeButtonMessage.handleButtonAction(entity, 1, x, y, z);
            }
        }).bounds(this.leftPos + 29, this.topPos + 105, 103, 20).build();
        guistate.put("button:button_check_your_clan", button_check_your_clan);
        this.addRenderableWidget(button_check_your_clan);
        button_store = Button.builder(Component.translatable("gui.jujutsucraftaddon.clan_change.button_store"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new ClanChangeButtonMessage(2, x, y, z));
                ClanChangeButtonMessage.handleButtonAction(entity, 2, x, y, z);
            }
        }).bounds(this.leftPos + 252, this.topPos + 46, 51, 20).build();
        guistate.put("button:button_store", button_store);
        this.addRenderableWidget(button_store);
        button_equip = Button.builder(Component.translatable("gui.jujutsucraftaddon.clan_change.button_equip"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new ClanChangeButtonMessage(3, x, y, z));
                ClanChangeButtonMessage.handleButtonAction(entity, 3, x, y, z);
            }
        }).bounds(this.leftPos + 325, this.topPos + 46, 51, 20).build();
        guistate.put("button:button_equip", button_equip);
        this.addRenderableWidget(button_equip);
        button_store1 = Button.builder(Component.translatable("gui.jujutsucraftaddon.clan_change.button_store1"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new ClanChangeButtonMessage(4, x, y, z));
                ClanChangeButtonMessage.handleButtonAction(entity, 4, x, y, z);
            }
        }).bounds(this.leftPos + 252, this.topPos + 103, 51, 20).build();
        guistate.put("button:button_store1", button_store1);
        this.addRenderableWidget(button_store1);
        button_equip1 = Button.builder(Component.translatable("gui.jujutsucraftaddon.clan_change.button_equip1"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new ClanChangeButtonMessage(5, x, y, z));
                ClanChangeButtonMessage.handleButtonAction(entity, 5, x, y, z);
            }
        }).bounds(this.leftPos + 325, this.topPos + 103, 51, 20).build();
        guistate.put("button:button_equip1", button_equip1);
        this.addRenderableWidget(button_equip1);
        button_store2 = Button.builder(Component.translatable("gui.jujutsucraftaddon.clan_change.button_store2"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new ClanChangeButtonMessage(6, x, y, z));
                ClanChangeButtonMessage.handleButtonAction(entity, 6, x, y, z);
            }
        }).bounds(this.leftPos + 252, this.topPos + 155, 51, 20).build();
        guistate.put("button:button_store2", button_store2);
        this.addRenderableWidget(button_store2);
        button_equip2 = Button.builder(Component.translatable("gui.jujutsucraftaddon.clan_change.button_equip2"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new ClanChangeButtonMessage(7, x, y, z));
                ClanChangeButtonMessage.handleButtonAction(entity, 7, x, y, z);
            }
        }).bounds(this.leftPos + 324, this.topPos + 155, 51, 20).build();
        guistate.put("button:button_equip2", button_equip2);
        this.addRenderableWidget(button_equip2);
    }
}
