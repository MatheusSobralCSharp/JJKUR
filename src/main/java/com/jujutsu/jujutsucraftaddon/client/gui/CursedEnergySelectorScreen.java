package com.jujutsu.jujutsucraftaddon.client.gui;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.network.CursedEnergySelectorButtonMessage;
import com.jujutsu.jujutsucraftaddon.procedures.ReturnYorozuProcedure;
import com.jujutsu.jujutsucraftaddon.world.inventory.CursedEnergySelectorMenu;
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

public class CursedEnergySelectorScreen extends AbstractContainerScreen<CursedEnergySelectorMenu> {
    private final static HashMap<String, Object> guistate = CursedEnergySelectorMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    Button button_imbue_with_negative_energy;
    Button button_imbue_with_positive_energy;
    Button button_infuse_ce;
    Button button_hp_regen_ce;
    Button button_stealing_ce;
    Button button_unbreakable_ce;
    Button button_infinity_bow_ce;
    Button button_vision_ce;
    Button button_random_enchantment_ce;

    public CursedEnergySelectorScreen(CursedEnergySelectorMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 400;
        this.imageHeight = 220;
    }

    private static final ResourceLocation texture = new ResourceLocation("jujutsucraftaddon:textures/screens/cursed_energy_selector.png");

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
        if (ReturnYorozuProcedure.execute(entity))
            if (mouseX > leftPos + 193 && mouseX < leftPos + 217 && mouseY > topPos + 132 && mouseY < topPos + 156)
                guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.cursed_energy_selector.tooltip_infuse_ce_with_weapon_but_inste"), mouseX, mouseY);
        if (ReturnYorozuProcedure.execute(entity))
            if (mouseX > leftPos + 64 && mouseX < leftPos + 88 && mouseY > topPos + 95 && mouseY < topPos + 119)
                guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.cursed_energy_selector.tooltip_that_enchantment_will_give_you_r"), mouseX, mouseY);
        if (ReturnYorozuProcedure.execute(entity))
            if (mouseX > leftPos + 192 && mouseX < leftPos + 216 && mouseY > topPos + 167 && mouseY < topPos + 191)
                guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.cursed_energy_selector.tooltip_your_weapon_will_steal_ce_and_gi"), mouseX, mouseY);
        if (ReturnYorozuProcedure.execute(entity))
            if (mouseX > leftPos + 63 && mouseX < leftPos + 87 && mouseY > topPos + 169 && mouseY < topPos + 193)
                guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.cursed_energy_selector.tooltip_sp_cost_500_use_cursed_energy"), mouseX, mouseY);
        if (mouseX > leftPos + 75 && mouseX < leftPos + 99 && mouseY > topPos + 19 && mouseY < topPos + 43)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.cursed_energy_selector.tooltip_this_give_your_weapon_negative_c"), mouseX, mouseY);
        if (mouseX > leftPos + 74 && mouseX < leftPos + 98 && mouseY > topPos + 56 && mouseY < topPos + 80)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.cursed_energy_selector.tooltip_this_give_your_weapon_positive_c"), mouseX, mouseY);
        if (ReturnYorozuProcedure.execute(entity))
            if (mouseX > leftPos + 195 && mouseX < leftPos + 219 && mouseY > topPos + 95 && mouseY < topPos + 119)
                guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.cursed_energy_selector.tooltip_sp_cost_100_infinity_ce_give"), mouseX, mouseY);
        if (ReturnYorozuProcedure.execute(entity))
            if (mouseX > leftPos + 64 && mouseX < leftPos + 88 && mouseY > topPos + 134 && mouseY < topPos + 158)
                guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.cursed_energy_selector.tooltip_vision_ce"), mouseX, mouseY);
        if (ReturnYorozuProcedure.execute(entity))
            if (mouseX > leftPos + 261 && mouseX < leftPos + 285 && mouseY > topPos + 19 && mouseY < topPos + 43)
                guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.cursed_energy_selector.tooltip_sp_cost_0_gives_random_enchant"), mouseX, mouseY);
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
        button_imbue_with_negative_energy = Button.builder(Component.translatable("gui.jujutsucraftaddon.cursed_energy_selector.button_imbue_with_negative_energy"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new CursedEnergySelectorButtonMessage(0, x, y, z));
                CursedEnergySelectorButtonMessage.handleButtonAction(entity, 0, x, y, z);
            }
        }).bounds(this.leftPos + 14, this.topPos + 21, 160, 20).build();
        guistate.put("button:button_imbue_with_negative_energy", button_imbue_with_negative_energy);
        this.addRenderableWidget(button_imbue_with_negative_energy);
        button_imbue_with_positive_energy = Button.builder(Component.translatable("gui.jujutsucraftaddon.cursed_energy_selector.button_imbue_with_positive_energy"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new CursedEnergySelectorButtonMessage(1, x, y, z));
                CursedEnergySelectorButtonMessage.handleButtonAction(entity, 1, x, y, z);
            }
        }).bounds(this.leftPos + 15, this.topPos + 58, 160, 20).build();
        guistate.put("button:button_imbue_with_positive_energy", button_imbue_with_positive_energy);
        this.addRenderableWidget(button_imbue_with_positive_energy);
        button_infuse_ce = Button.builder(Component.translatable("gui.jujutsucraftaddon.cursed_energy_selector.button_infuse_ce"), e -> {
            if (ReturnYorozuProcedure.execute(entity)) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new CursedEnergySelectorButtonMessage(2, x, y, z));
                CursedEnergySelectorButtonMessage.handleButtonAction(entity, 2, x, y, z);
            }
        }).bounds(this.leftPos + 169, this.topPos + 134, 72, 20).build(builder -> new Button(builder) {
            @Override
            public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
                this.visible = ReturnYorozuProcedure.execute(entity);
                super.renderWidget(guiGraphics, gx, gy, ticks);
            }
        });
        guistate.put("button:button_infuse_ce", button_infuse_ce);
        this.addRenderableWidget(button_infuse_ce);
        button_hp_regen_ce = Button.builder(Component.translatable("gui.jujutsucraftaddon.cursed_energy_selector.button_hp_regen_ce"), e -> {
            if (ReturnYorozuProcedure.execute(entity)) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new CursedEnergySelectorButtonMessage(3, x, y, z));
                CursedEnergySelectorButtonMessage.handleButtonAction(entity, 3, x, y, z);
            }
        }).bounds(this.leftPos + 38, this.topPos + 98, 82, 20).build(builder -> new Button(builder) {
            @Override
            public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
                this.visible = ReturnYorozuProcedure.execute(entity);
                super.renderWidget(guiGraphics, gx, gy, ticks);
            }
        });
        guistate.put("button:button_hp_regen_ce", button_hp_regen_ce);
        this.addRenderableWidget(button_hp_regen_ce);
        button_stealing_ce = Button.builder(Component.translatable("gui.jujutsucraftaddon.cursed_energy_selector.button_stealing_ce"), e -> {
            if (ReturnYorozuProcedure.execute(entity)) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new CursedEnergySelectorButtonMessage(4, x, y, z));
                CursedEnergySelectorButtonMessage.handleButtonAction(entity, 4, x, y, z);
            }
        }).bounds(this.leftPos + 163, this.topPos + 170, 82, 20).build(builder -> new Button(builder) {
            @Override
            public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
                this.visible = ReturnYorozuProcedure.execute(entity);
                super.renderWidget(guiGraphics, gx, gy, ticks);
            }
        });
        guistate.put("button:button_stealing_ce", button_stealing_ce);
        this.addRenderableWidget(button_stealing_ce);
        button_unbreakable_ce = Button.builder(Component.translatable("gui.jujutsucraftaddon.cursed_energy_selector.button_unbreakable_ce"), e -> {
            if (ReturnYorozuProcedure.execute(entity)) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new CursedEnergySelectorButtonMessage(5, x, y, z));
                CursedEnergySelectorButtonMessage.handleButtonAction(entity, 5, x, y, z);
            }
        }).bounds(this.leftPos + 29, this.topPos + 170, 98, 20).build(builder -> new Button(builder) {
            @Override
            public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
                this.visible = ReturnYorozuProcedure.execute(entity);
                super.renderWidget(guiGraphics, gx, gy, ticks);
            }
        });
        guistate.put("button:button_unbreakable_ce", button_unbreakable_ce);
        this.addRenderableWidget(button_unbreakable_ce);
        button_infinity_bow_ce = Button.builder(Component.translatable("gui.jujutsucraftaddon.cursed_energy_selector.button_infinity_bow_ce"), e -> {
            if (ReturnYorozuProcedure.execute(entity)) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new CursedEnergySelectorButtonMessage(6, x, y, z));
                CursedEnergySelectorButtonMessage.handleButtonAction(entity, 6, x, y, z);
            }
        }).bounds(this.leftPos + 156, this.topPos + 98, 103, 20).build(builder -> new Button(builder) {
            @Override
            public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
                this.visible = ReturnYorozuProcedure.execute(entity);
                super.renderWidget(guiGraphics, gx, gy, ticks);
            }
        });
        guistate.put("button:button_infinity_bow_ce", button_infinity_bow_ce);
        this.addRenderableWidget(button_infinity_bow_ce);
        button_vision_ce = Button.builder(Component.translatable("gui.jujutsucraftaddon.cursed_energy_selector.button_vision_ce"), e -> {
        }).bounds(this.leftPos + 43, this.topPos + 134, 72, 20).build(builder -> new Button(builder) {
            @Override
            public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
                this.visible = ReturnYorozuProcedure.execute(entity);
                super.renderWidget(guiGraphics, gx, gy, ticks);
            }
        });
        guistate.put("button:button_vision_ce", button_vision_ce);
        this.addRenderableWidget(button_vision_ce);
        button_random_enchantment_ce = Button.builder(Component.translatable("gui.jujutsucraftaddon.cursed_energy_selector.button_random_enchantment_ce"), e -> {
            if (ReturnYorozuProcedure.execute(entity)) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new CursedEnergySelectorButtonMessage(8, x, y, z));
                CursedEnergySelectorButtonMessage.handleButtonAction(entity, 8, x, y, z);
            }
        }).bounds(this.leftPos + 208, this.topPos + 21, 134, 20).build(builder -> new Button(builder) {
            @Override
            public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
                this.visible = ReturnYorozuProcedure.execute(entity);
                super.renderWidget(guiGraphics, gx, gy, ticks);
            }
        });
        guistate.put("button:button_random_enchantment_ce", button_random_enchantment_ce);
        this.addRenderableWidget(button_random_enchantment_ce);
    }
}
