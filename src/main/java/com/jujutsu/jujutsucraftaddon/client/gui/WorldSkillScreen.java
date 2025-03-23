package com.jujutsu.jujutsucraftaddon.client.gui;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.network.WorldSkillButtonMessage;
import com.jujutsu.jujutsucraftaddon.world.inventory.WorldSkillMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.HashMap;

public class WorldSkillScreen extends AbstractContainerScreen<WorldSkillMenu> {
    private final static HashMap<String, Object> guistate = WorldSkillMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    ImageButton imagebutton_barrierlessmiddle;
    ImageButton imagebutton_artcleftno;
    ImageButton imagebutton_nosimple;
    ImageButton imagebutton_extensiondownrightno;
    ImageButton imagebutton_norightoutput;
    ImageButton imagebutton_barrierless1;

    public WorldSkillScreen(WorldSkillMenu container, Inventory inventory, Component text) {
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
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
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
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.world_skill.label_rct_output"), 141, 96, -65536, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.world_skill.label_rct_mastery"), 3, 108, -65536, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.world_skill.label_barrierless"), 69, 152, -16777216, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.world_skill.label_rct_burnout"), 69, 68, -65536, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.world_skill.label_simple_domain"), 2, 183, -10158081, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.world_skill.label_extension_technique"), 99, 186, -4980573, false);
    }

    @Override
    public void init() {
        super.init();
        imagebutton_barrierlessmiddle = new ImageButton(this.leftPos + 63, this.topPos + 3, 64, 64, 0, 0, 64, new ResourceLocation("jujutsucraftaddon:textures/screens/atlas/imagebutton_barrierlessmiddle.png"), 64, 128, e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new WorldSkillButtonMessage(0, x, y, z));
                WorldSkillButtonMessage.handleButtonAction(entity, 0, x, y, z);
            }
        });
        guistate.put("button:imagebutton_barrierlessmiddle", imagebutton_barrierlessmiddle);
        this.addRenderableWidget(imagebutton_barrierlessmiddle);
        imagebutton_artcleftno = new ImageButton(this.leftPos, this.topPos + 44, 64, 64, 0, 0, 64, new ResourceLocation("jujutsucraftaddon:textures/screens/atlas/imagebutton_artcleftno.png"), 64, 128, e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new WorldSkillButtonMessage(1, x, y, z));
                WorldSkillButtonMessage.handleButtonAction(entity, 1, x, y, z);
            }
        });
        guistate.put("button:imagebutton_artcleftno", imagebutton_artcleftno);
        this.addRenderableWidget(imagebutton_artcleftno);
        imagebutton_nosimple = new ImageButton(this.leftPos + 2, this.topPos + 132, 64, 64, 0, 0, 64, new ResourceLocation("jujutsucraftaddon:textures/screens/atlas/imagebutton_nosimple.png"), 64, 128, e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new WorldSkillButtonMessage(2, x, y, z));
                WorldSkillButtonMessage.handleButtonAction(entity, 2, x, y, z);
            }
        });
        guistate.put("button:imagebutton_nosimple", imagebutton_nosimple);
        this.addRenderableWidget(imagebutton_nosimple);
        imagebutton_extensiondownrightno = new ImageButton(this.leftPos + 131, this.topPos + 124, 64, 64, 0, 0, 64, new ResourceLocation("jujutsucraftaddon:textures/screens/atlas/imagebutton_extensiondownrightno.png"), 64, 128, e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new WorldSkillButtonMessage(3, x, y, z));
                WorldSkillButtonMessage.handleButtonAction(entity, 3, x, y, z);
            }
        });
        guistate.put("button:imagebutton_extensiondownrightno", imagebutton_extensiondownrightno);
        this.addRenderableWidget(imagebutton_extensiondownrightno);
        imagebutton_norightoutput = new ImageButton(this.leftPos + 132, this.topPos + 30, 64, 64, 0, 0, 64, new ResourceLocation("jujutsucraftaddon:textures/screens/atlas/imagebutton_norightoutput.png"), 64, 128, e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new WorldSkillButtonMessage(4, x, y, z));
                WorldSkillButtonMessage.handleButtonAction(entity, 4, x, y, z);
            }
        });
        guistate.put("button:imagebutton_norightoutput", imagebutton_norightoutput);
        this.addRenderableWidget(imagebutton_norightoutput);
        imagebutton_barrierless1 = new ImageButton(this.leftPos + 66, this.topPos + 82, 64, 64, 0, 0, 64, new ResourceLocation("jujutsucraftaddon:textures/screens/atlas/imagebutton_barrierless1.png"), 64, 128, e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new WorldSkillButtonMessage(5, x, y, z));
                WorldSkillButtonMessage.handleButtonAction(entity, 5, x, y, z);
            }
        });
        guistate.put("button:imagebutton_barrierless1", imagebutton_barrierless1);
        this.addRenderableWidget(imagebutton_barrierless1);
    }
}
