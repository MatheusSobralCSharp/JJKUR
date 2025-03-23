package com.jujutsu.jujutsucraftaddon.client.gui;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.network.ElementsButtonMessage;
import com.jujutsu.jujutsucraftaddon.procedures.ConditionProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.ReturnElementProcedure;
import com.jujutsu.jujutsucraftaddon.world.inventory.ElementsMenu;
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

public class ElementsScreen extends AbstractContainerScreen<ElementsMenu> {
    private final static HashMap<String, Object> guistate = ElementsMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    Button button_select;
    Button button_select1;
    Button button_select2;
    Button button_select3;
    Button button_select4;

    public ElementsScreen(ElementsMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 500;
        this.imageHeight = 500;
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

        guiGraphics.blit(new ResourceLocation("jujutsucraftaddon:textures/screens/lightningicon.png"), this.leftPos + 66, this.topPos + 139, 0, 0, 60, 60, 60, 60);

        guiGraphics.blit(new ResourceLocation("jujutsucraftaddon:textures/screens/fireicon.png"), this.leftPos + 222, this.topPos + 138, 0, 0, 60, 60, 60, 60);

        guiGraphics.blit(new ResourceLocation("jujutsucraftaddon:textures/screens/earthicon.png"), this.leftPos + 372, this.topPos + 139, 0, 0, 60, 60, 60, 60);

        guiGraphics.blit(new ResourceLocation("jujutsucraftaddon:textures/screens/watericon.png"), this.leftPos + 142, this.topPos + 252, 0, 0, 60, 60, 60, 60);

        guiGraphics.blit(new ResourceLocation("jujutsucraftaddon:textures/screens/windicon.png"), this.leftPos + 294, this.topPos + 253, 0, 0, 60, 60, 60, 60);

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
        guiGraphics.drawString(this.font,

                ReturnElementProcedure.execute(entity), 212, 331, -12829636, false);
    }

    @Override
    public void init() {
        super.init();
        button_select = Button.builder(Component.translatable("gui.jujutsucraftaddon.elements.button_select"), e -> {
            if (ConditionProcedure.execute(entity)) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new ElementsButtonMessage(0, x, y, z));
                ElementsButtonMessage.handleButtonAction(entity, 0, x, y, z);
            }
        }).bounds(this.leftPos + 67, this.topPos + 210, 56, 20).build(builder -> new Button(builder) {
            @Override
            public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
                this.visible = ConditionProcedure.execute(entity);
                super.renderWidget(guiGraphics, gx, gy, ticks);
            }
        });
        guistate.put("button:button_select", button_select);
        this.addRenderableWidget(button_select);
        button_select1 = Button.builder(Component.translatable("gui.jujutsucraftaddon.elements.button_select1"), e -> {
            if (ConditionProcedure.execute(entity)) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new ElementsButtonMessage(1, x, y, z));
                ElementsButtonMessage.handleButtonAction(entity, 1, x, y, z);
            }
        }).bounds(this.leftPos + 224, this.topPos + 210, 56, 20).build(builder -> new Button(builder) {
            @Override
            public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
                this.visible = ConditionProcedure.execute(entity);
                super.renderWidget(guiGraphics, gx, gy, ticks);
            }
        });
        guistate.put("button:button_select1", button_select1);
        this.addRenderableWidget(button_select1);
        button_select2 = Button.builder(Component.translatable("gui.jujutsucraftaddon.elements.button_select2"), e -> {
            if (ConditionProcedure.execute(entity)) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new ElementsButtonMessage(2, x, y, z));
                ElementsButtonMessage.handleButtonAction(entity, 2, x, y, z);
            }
        }).bounds(this.leftPos + 373, this.topPos + 210, 56, 20).build(builder -> new Button(builder) {
            @Override
            public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
                this.visible = ConditionProcedure.execute(entity);
                super.renderWidget(guiGraphics, gx, gy, ticks);
            }
        });
        guistate.put("button:button_select2", button_select2);
        this.addRenderableWidget(button_select2);
        button_select3 = Button.builder(Component.translatable("gui.jujutsucraftaddon.elements.button_select3"), e -> {
            if (ConditionProcedure.execute(entity)) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new ElementsButtonMessage(3, x, y, z));
                ElementsButtonMessage.handleButtonAction(entity, 3, x, y, z);
            }
        }).bounds(this.leftPos + 144, this.topPos + 323, 56, 20).build(builder -> new Button(builder) {
            @Override
            public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
                this.visible = ConditionProcedure.execute(entity);
                super.renderWidget(guiGraphics, gx, gy, ticks);
            }
        });
        guistate.put("button:button_select3", button_select3);
        this.addRenderableWidget(button_select3);
        button_select4 = Button.builder(Component.translatable("gui.jujutsucraftaddon.elements.button_select4"), e -> {
            if (ConditionProcedure.execute(entity)) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new ElementsButtonMessage(4, x, y, z));
                ElementsButtonMessage.handleButtonAction(entity, 4, x, y, z);
            }
        }).bounds(this.leftPos + 296, this.topPos + 323, 56, 20).build(builder -> new Button(builder) {
            @Override
            public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
                this.visible = ConditionProcedure.execute(entity);
                super.renderWidget(guiGraphics, gx, gy, ticks);
            }
        });
        guistate.put("button:button_select4", button_select4);
        this.addRenderableWidget(button_select4);
    }
}
