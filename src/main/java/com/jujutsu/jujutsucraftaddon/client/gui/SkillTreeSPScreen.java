package com.jujutsu.jujutsucraftaddon.client.gui;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.network.SkillTreeSPButtonMessage;
import com.jujutsu.jujutsucraftaddon.procedures.*;
import com.jujutsu.jujutsucraftaddon.world.inventory.SkillTreeSPMenu;
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

public class SkillTreeSPScreen extends AbstractContainerScreen<SkillTreeSPMenu> {
    private final static HashMap<String, Object> guistate = SkillTreeSPMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    Button button_empty;
    Button button_empty1;
    Button button_empty2;
    Button button_fight_your_spirit;
    Button button_rct_mastery_quest;
    Button button_unlock_extension;
    Button button_rebirth;
    Button button_binding_vows;
    Button button_meditation;

    public SkillTreeSPScreen(SkillTreeSPMenu container, Inventory inventory, Component text) {
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
        if (mouseX > leftPos + 127 && mouseX < leftPos + 151 && mouseY > topPos + 235 && mouseY < topPos + 259)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.tooltip_changes_your_health_attribute"), mouseX, mouseY);
        if (mouseX > leftPos + 127 && mouseX < leftPos + 151 && mouseY > topPos + 271 && mouseY < topPos + 295)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.tooltip_changes_your_ce_cursed_energ"), mouseX, mouseY);
        if (mouseX > leftPos + 126 && mouseX < leftPos + 150 && mouseY > topPos + 306 && mouseY < topPos + 330)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.tooltip_doubles_your_base_speed"), mouseX, mouseY);
        if (mouseX > leftPos + 363 && mouseX < leftPos + 387 && mouseY > topPos + 275 && mouseY < topPos + 299)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.tooltip_meditate_agressive_with_your_spi"), mouseX, mouseY);
        if (mouseX > leftPos + 363 && mouseX < leftPos + 387 && mouseY > topPos + 306 && mouseY < topPos + 330)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.tooltip_for_unlock_extension_just_click"), mouseX, mouseY);
        if (ReturnSecretProcedure.execute(entity))
            if (mouseX > leftPos + 367 && mouseX < leftPos + 391 && mouseY > topPos + 199 && mouseY < topPos + 223)
                guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.tooltip_start_rct_mastery_quest"), mouseX, mouseY);
        if (mouseX > leftPos + 58 && mouseX < leftPos + 82 && mouseY > topPos + 207 && mouseY < topPos + 231)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.tooltip_prestige_your_character"), mouseX, mouseY);
        if (mouseX > leftPos + 232 && mouseX < leftPos + 256 && mouseY > topPos + 271 && mouseY < topPos + 295)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.tooltip_display_binding_vows_menu"), mouseX, mouseY);
        if (mouseX > leftPos + 232 && mouseX < leftPos + 256 && mouseY > topPos + 302 && mouseY < topPos + 326)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.tooltip_start_meditationuse_again_for_s"), mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        guiGraphics.blit(new ResourceLocation("jujutsucraftaddon:textures/screens/healer.png"), this.leftPos + 125, this.topPos + 204, 0, 0, 32, 32, 32, 32);

        guiGraphics.blit(new ResourceLocation("jujutsucraftaddon:textures/screens/teste3.png"), this.leftPos + 101, this.topPos + 224, 0, 0, 82, 46, 82, 46);

        guiGraphics.blit(new ResourceLocation("jujutsucraftaddon:textures/screens/ce.png"), this.leftPos + 101, this.topPos + 260, 0, 0, 82, 46, 82, 46);

        guiGraphics.blit(new ResourceLocation("jujutsucraftaddon:textures/screens/speed.png"), this.leftPos + 100, this.topPos + 295, 0, 0, 82, 46, 82, 46);

        guiGraphics.blit(new ResourceLocation("jujutsucraftaddon:textures/screens/sukunaspirit.png"), this.leftPos + 347, this.topPos + 217, 0, 0, 60, 60, 60, 60);

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

                ReturnSkillPointsProcedure.execute(entity), 320, 350, -16711690, false);
        guiGraphics.drawString(this.font,

                ReturnBurnoutExpProcedure.execute(entity), 42, 157, -4325121, false);
        if (ReturnSecret2Procedure.execute(entity))
            guiGraphics.drawString(this.font,

                    ReturnAmountProcedure.execute(entity), 104, 351, -65536, false);
        guiGraphics.drawString(this.font,

                ReturnBarrierlessExpProcedure.execute(entity), 41, 180, -12139777, false);
        guiGraphics.drawString(this.font,

                ReturnSimpleProcedure.execute(entity), 43, 138, -3342337, false);
    }

    @Override
    public void init() {
        super.init();
        button_empty = Button.builder(Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.button_empty"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new SkillTreeSPButtonMessage(0, x, y, z));
                SkillTreeSPButtonMessage.handleButtonAction(entity, 0, x, y, z);
            }
        }).bounds(this.leftPos + 69, this.topPos + 238, 30, 20).build();
        guistate.put("button:button_empty", button_empty);
        this.addRenderableWidget(button_empty);
        button_empty1 = Button.builder(Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.button_empty1"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new SkillTreeSPButtonMessage(1, x, y, z));
                SkillTreeSPButtonMessage.handleButtonAction(entity, 1, x, y, z);
            }
        }).bounds(this.leftPos + 69, this.topPos + 273, 30, 20).build();
        guistate.put("button:button_empty1", button_empty1);
        this.addRenderableWidget(button_empty1);
        button_empty2 = Button.builder(Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.button_empty2"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new SkillTreeSPButtonMessage(2, x, y, z));
                SkillTreeSPButtonMessage.handleButtonAction(entity, 2, x, y, z);
            }
        }).bounds(this.leftPos + 69, this.topPos + 309, 30, 20).build();
        guistate.put("button:button_empty2", button_empty2);
        this.addRenderableWidget(button_empty2);
        button_fight_your_spirit = Button.builder(Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.button_fight_your_spirit"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new SkillTreeSPButtonMessage(3, x, y, z));
                SkillTreeSPButtonMessage.handleButtonAction(entity, 3, x, y, z);
            }
        }).bounds(this.leftPos + 322, this.topPos + 277, 113, 20).build();
        guistate.put("button:button_fight_your_spirit", button_fight_your_spirit);
        this.addRenderableWidget(button_fight_your_spirit);
        button_rct_mastery_quest = Button.builder(Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.button_rct_mastery_quest"), e -> {
            if (ReturnSecretProcedure.execute(entity)) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new SkillTreeSPButtonMessage(4, x, y, z));
                SkillTreeSPButtonMessage.handleButtonAction(entity, 4, x, y, z);
            }
        }).bounds(this.leftPos + 325, this.topPos + 201, 113, 20).build(builder -> new Button(builder) {
            @Override
            public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
                this.visible = ReturnSecretProcedure.execute(entity);
                super.renderWidget(guiGraphics, gx, gy, ticks);
            }
        });
        guistate.put("button:button_rct_mastery_quest", button_rct_mastery_quest);
        this.addRenderableWidget(button_rct_mastery_quest);
        button_unlock_extension = Button.builder(Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.button_unlock_extension"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new SkillTreeSPButtonMessage(5, x, y, z));
                SkillTreeSPButtonMessage.handleButtonAction(entity, 5, x, y, z);
            }
        }).bounds(this.leftPos + 323, this.topPos + 307, 108, 20).build();
        guistate.put("button:button_unlock_extension", button_unlock_extension);
        this.addRenderableWidget(button_unlock_extension);
        button_rebirth = Button.builder(Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.button_rebirth"), e -> {
            if (ReturnRebirthProcedure.execute(world, entity)) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new SkillTreeSPButtonMessage(6, x, y, z));
                SkillTreeSPButtonMessage.handleButtonAction(entity, 6, x, y, z);
            }
        }).bounds(this.leftPos + 41, this.topPos + 210, 61, 20).build(builder -> new Button(builder) {
            @Override
            public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
                this.visible = ReturnRebirthProcedure.execute(world, entity);
                super.renderWidget(guiGraphics, gx, gy, ticks);
            }
        });
        guistate.put("button:button_rebirth", button_rebirth);
        this.addRenderableWidget(button_rebirth);
        button_binding_vows = Button.builder(Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.button_binding_vows"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new SkillTreeSPButtonMessage(7, x, y, z));
                SkillTreeSPButtonMessage.handleButtonAction(entity, 7, x, y, z);
            }
        }).bounds(this.leftPos + 203, this.topPos + 273, 87, 20).build();
        guistate.put("button:button_binding_vows", button_binding_vows);
        this.addRenderableWidget(button_binding_vows);
        button_meditation = Button.builder(Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.button_meditation"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new SkillTreeSPButtonMessage(8, x, y, z));
                SkillTreeSPButtonMessage.handleButtonAction(entity, 8, x, y, z);
            }
        }).bounds(this.leftPos + 207, this.topPos + 304, 77, 20).build();
        guistate.put("button:button_meditation", button_meditation);
        this.addRenderableWidget(button_meditation);
    }
}
