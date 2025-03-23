package com.jujutsu.jujutsucraftaddon.client.gui;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.network.SkillTreeButtonMessage;
import com.jujutsu.jujutsucraftaddon.procedures.Level1Quest1Procedure;
import com.jujutsu.jujutsucraftaddon.procedures.Level2ReqProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.Level3ReqProcedure;
import com.jujutsu.jujutsucraftaddon.world.inventory.SkillTreeMenu;
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

public class SkillTreeScreen extends AbstractContainerScreen<SkillTreeMenu> {
    private final static HashMap<String, Object> guistate = SkillTreeMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    Button button_unlock_level_1;
    Button button_unlock_level_2;
    Button button_unlock_level_3;

    public SkillTreeScreen(SkillTreeMenu container, Inventory inventory, Component text) {
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

        guiGraphics.blit(new ResourceLocation("jujutsucraftaddon:textures/screens/fistlevel1.png"), this.leftPos + 78, this.topPos + 219, 0, 0, 60, 60, 60, 60);

        guiGraphics.blit(new ResourceLocation("jujutsucraftaddon:textures/screens/fistlevel2.png"), this.leftPos + 213, this.topPos + 218, 0, 0, 60, 60, 60, 60);

        guiGraphics.blit(new ResourceLocation("jujutsucraftaddon:textures/screens/120.2.png"), this.leftPos + 345, this.topPos + 217, 0, 0, 60, 60, 60, 60);

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
        button_unlock_level_1 = Button.builder(Component.translatable("gui.jujutsucraftaddon.skill_tree.button_unlock_level_1"), e -> {
            if (Level1Quest1Procedure.execute(entity)) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new SkillTreeButtonMessage(0, x, y, z));
                SkillTreeButtonMessage.handleButtonAction(entity, 0, x, y, z);
            }
        }).bounds(this.leftPos + 58, this.topPos + 289, 98, 20).build(builder -> new Button(builder) {
            @Override
            public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
                this.visible = Level1Quest1Procedure.execute(entity);
                super.renderWidget(guiGraphics, gx, gy, ticks);
            }
        });
        guistate.put("button:button_unlock_level_1", button_unlock_level_1);
        this.addRenderableWidget(button_unlock_level_1);
        button_unlock_level_2 = Button.builder(Component.translatable("gui.jujutsucraftaddon.skill_tree.button_unlock_level_2"), e -> {
            if (Level2ReqProcedure.execute(entity)) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new SkillTreeButtonMessage(1, x, y, z));
                SkillTreeButtonMessage.handleButtonAction(entity, 1, x, y, z);
            }
        }).bounds(this.leftPos + 192, this.topPos + 289, 98, 20).build(builder -> new Button(builder) {
            @Override
            public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
                this.visible = Level2ReqProcedure.execute(entity);
                super.renderWidget(guiGraphics, gx, gy, ticks);
            }
        });
        guistate.put("button:button_unlock_level_2", button_unlock_level_2);
        this.addRenderableWidget(button_unlock_level_2);
        button_unlock_level_3 = Button.builder(Component.translatable("gui.jujutsucraftaddon.skill_tree.button_unlock_level_3"), e -> {
            if (Level3ReqProcedure.execute(entity)) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new SkillTreeButtonMessage(2, x, y, z));
                SkillTreeButtonMessage.handleButtonAction(entity, 2, x, y, z);
            }
        }).bounds(this.leftPos + 325, this.topPos + 289, 98, 20).build(builder -> new Button(builder) {
            @Override
            public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
                this.visible = Level3ReqProcedure.execute(entity);
                super.renderWidget(guiGraphics, gx, gy, ticks);
            }
        });
        guistate.put("button:button_unlock_level_3", button_unlock_level_3);
        this.addRenderableWidget(button_unlock_level_3);
    }
}
