package com.jujutsu.jujutsucraftaddon.client.gui;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.network.KenjakuBodySwapButtonMessage;
import com.jujutsu.jujutsucraftaddon.procedures.*;
import com.jujutsu.jujutsucraftaddon.world.inventory.KenjakuBodySwapMenu;
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

public class KenjakuBodySwapScreen extends AbstractContainerScreen<KenjakuBodySwapMenu> {
    private final static HashMap<String, Object> guistate = KenjakuBodySwapMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    Button button_select;
    Button button_select1;
    Button button_select2;
    Button button_x;
    Button button_x1;
    Button button_clear_body_1;
    Button button_clear_body_2;
    Button button_clear_body_3;
    Button button_clear_user;

    public KenjakuBodySwapScreen(KenjakuBodySwapMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 300;
        this.imageHeight = 166;
    }

    private static final ResourceLocation texture = new ResourceLocation("jujutsucraftaddon:textures/screens/kenjaku_body_swap.png");

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
        if (ConditionReturnProcedure.execute(entity))
            guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.kenjaku_body_swap.label_geto_ct"), 24, 17, -12829636, false);
        guiGraphics.drawString(this.font,

                CTNamesProcedure.execute(entity), 23, 48, -12829636, false);
        guiGraphics.drawString(this.font,

                CTNames2Procedure.execute(entity), 21, 81, -12829636, false);
    }

    @Override
    public void init() {
        super.init();
        button_select = Button.builder(Component.translatable("gui.jujutsucraftaddon.kenjaku_body_swap.button_select"), e -> {
            if (ConditionReturnProcedure.execute(entity)) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new KenjakuBodySwapButtonMessage(0, x, y, z));
                KenjakuBodySwapButtonMessage.handleButtonAction(entity, 0, x, y, z);
            }
        }).bounds(this.leftPos + 82, this.topPos + 13, 56, 20).build(builder -> new Button(builder) {
            @Override
            public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
                this.visible = ConditionReturnProcedure.execute(entity);
                super.renderWidget(guiGraphics, gx, gy, ticks);
            }
        });
        guistate.put("button:button_select", button_select);
        this.addRenderableWidget(button_select);
        button_select1 = Button.builder(Component.translatable("gui.jujutsucraftaddon.kenjaku_body_swap.button_select1"), e -> {
            if (Condition1Procedure.execute(entity)) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new KenjakuBodySwapButtonMessage(1, x, y, z));
                KenjakuBodySwapButtonMessage.handleButtonAction(entity, 1, x, y, z);
            }
        }).bounds(this.leftPos + 82, this.topPos + 43, 56, 20).build(builder -> new Button(builder) {
            @Override
            public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
                this.visible = Condition1Procedure.execute(entity);
                super.renderWidget(guiGraphics, gx, gy, ticks);
            }
        });
        guistate.put("button:button_select1", button_select1);
        this.addRenderableWidget(button_select1);
        button_select2 = Button.builder(Component.translatable("gui.jujutsucraftaddon.kenjaku_body_swap.button_select2"), e -> {
            if (Condition2Procedure.execute(entity)) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new KenjakuBodySwapButtonMessage(2, x, y, z));
                KenjakuBodySwapButtonMessage.handleButtonAction(entity, 2, x, y, z);
            }
        }).bounds(this.leftPos + 82, this.topPos + 76, 56, 20).build(builder -> new Button(builder) {
            @Override
            public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
                this.visible = Condition2Procedure.execute(entity);
                super.renderWidget(guiGraphics, gx, gy, ticks);
            }
        });
        guistate.put("button:button_select2", button_select2);
        this.addRenderableWidget(button_select2);
        button_x = Button.builder(Component.translatable("gui.jujutsucraftaddon.kenjaku_body_swap.button_x"), e -> {
            if (Condition2Procedure.execute(entity)) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new KenjakuBodySwapButtonMessage(3, x, y, z));
                KenjakuBodySwapButtonMessage.handleButtonAction(entity, 3, x, y, z);
            }
        }).bounds(this.leftPos + 145, this.topPos + 75, 30, 20).build(builder -> new Button(builder) {
            @Override
            public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
                this.visible = Condition2Procedure.execute(entity);
                super.renderWidget(guiGraphics, gx, gy, ticks);
            }
        });
        guistate.put("button:button_x", button_x);
        this.addRenderableWidget(button_x);
        button_x1 = Button.builder(Component.translatable("gui.jujutsucraftaddon.kenjaku_body_swap.button_x1"), e -> {
            if (Condition1Procedure.execute(entity)) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new KenjakuBodySwapButtonMessage(4, x, y, z));
                KenjakuBodySwapButtonMessage.handleButtonAction(entity, 4, x, y, z);
            }
        }).bounds(this.leftPos + 144, this.topPos + 43, 30, 20).build(builder -> new Button(builder) {
            @Override
            public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
                this.visible = Condition1Procedure.execute(entity);
                super.renderWidget(guiGraphics, gx, gy, ticks);
            }
        });
        guistate.put("button:button_x1", button_x1);
        this.addRenderableWidget(button_x1);
        button_clear_body_1 = Button.builder(Component.translatable("gui.jujutsucraftaddon.kenjaku_body_swap.button_clear_body_1"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new KenjakuBodySwapButtonMessage(5, x, y, z));
                KenjakuBodySwapButtonMessage.handleButtonAction(entity, 5, x, y, z);
            }
        }).bounds(this.leftPos + 202, this.topPos + 40, 87, 20).build();
        guistate.put("button:button_clear_body_1", button_clear_body_1);
        this.addRenderableWidget(button_clear_body_1);
        button_clear_body_2 = Button.builder(Component.translatable("gui.jujutsucraftaddon.kenjaku_body_swap.button_clear_body_2"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new KenjakuBodySwapButtonMessage(6, x, y, z));
                KenjakuBodySwapButtonMessage.handleButtonAction(entity, 6, x, y, z);
            }
        }).bounds(this.leftPos + 202, this.topPos + 68, 87, 20).build();
        guistate.put("button:button_clear_body_2", button_clear_body_2);
        this.addRenderableWidget(button_clear_body_2);
        button_clear_body_3 = Button.builder(Component.translatable("gui.jujutsucraftaddon.kenjaku_body_swap.button_clear_body_3"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new KenjakuBodySwapButtonMessage(7, x, y, z));
                KenjakuBodySwapButtonMessage.handleButtonAction(entity, 7, x, y, z);
            }
        }).bounds(this.leftPos + 202, this.topPos + 96, 87, 20).build();
        guistate.put("button:button_clear_body_3", button_clear_body_3);
        this.addRenderableWidget(button_clear_body_3);
        button_clear_user = Button.builder(Component.translatable("gui.jujutsucraftaddon.kenjaku_body_swap.button_clear_user"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new KenjakuBodySwapButtonMessage(8, x, y, z));
                KenjakuBodySwapButtonMessage.handleButtonAction(entity, 8, x, y, z);
            }
        }).bounds(this.leftPos + 207, this.topPos + 9, 77, 20).build();
        guistate.put("button:button_clear_user", button_clear_user);
        this.addRenderableWidget(button_clear_user);
    }
}
