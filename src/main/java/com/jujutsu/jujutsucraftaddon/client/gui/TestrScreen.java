package com.jujutsu.jujutsucraftaddon.client.gui;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.network.TestrButtonMessage;
import com.jujutsu.jujutsucraftaddon.world.inventory.TestrMenu;
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

public class TestrScreen extends AbstractContainerScreen<TestrMenu> {
    private final static HashMap<String, Object> guistate = TestrMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    Button button_select;
    Button button_select1;
    Button button_select2;
    Button button_select3;

    public TestrScreen(TestrMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 450;
        this.imageHeight = 400;
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

        guiGraphics.blit(new ResourceLocation("jujutsucraftaddon:textures/screens/health.png"), this.leftPos + 26, this.topPos + 106, 0, 0, 60, 90, 60, 90);

        guiGraphics.blit(new ResourceLocation("jujutsucraftaddon:textures/screens/technique.png"), this.leftPos + 96, this.topPos + 194, 0, 0, 60, 90, 60, 90);

        guiGraphics.blit(new ResourceLocation("jujutsucraftaddon:textures/screens/strength2.png"), this.leftPos + 194, this.topPos + 84, 0, 0, 60, 90, 60, 90);

        guiGraphics.blit(new ResourceLocation("jujutsucraftaddon:textures/screens/meditation2.png"), this.leftPos + 343, this.topPos + 198, 0, 0, 60, 90, 60, 90);

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
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.testr.label_gives_more_power_but_your_attac"), 253, 86, -12779521, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.testr.label_but_your_attacks_are_weaker_af"), 266, 111, -3997697, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.testr.label_scales_per_binding_vow"), 263, 125, -458752, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.testr.label_consequences"), 285, 98, -655360, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.testr.label_gives_more_health_and_defense"), 14, 91, -12779521, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.testr.label_consequences1"), 102, 112, -65536, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.testr.label_your_attacks_can_hurt_yourself"), 96, 128, -65536, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.testr.label_gives_temp_output"), 181, 199, -16711681, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.testr.label_gives_10000_cursed_levels"), 307, 142, -16711681, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.testr.label_you_cant_reach_120_anymore"), 164, 214, -16777216, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.testr.label_your_progression_get_slower"), 297, 154, -65536, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.testr.label_scales_per_binding_vow1"), 306, 181, -65536, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.testr.label_you_get_debuffed_per_each_respaw"), 158, 229, -65536, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.testr.label_weakness_respawn"), 93, 141, -65536, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.testr.label_each_hit_has_a_chance_of_do_2x_d"), 159, 246, -65536, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.testr.label_dying_clear_your_inv"), 315, 167, -65536, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.testr.label_scales_per_binding_vow2"), 181, 265, -65536, false);
    }

    @Override
    public void init() {
        super.init();
        button_select = Button.builder(Component.translatable("gui.jujutsucraftaddon.testr.button_select"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new TestrButtonMessage(0, x, y, z));
                TestrButtonMessage.handleButtonAction(entity, 0, x, y, z);
            }
        }).bounds(this.leftPos + 26, this.topPos + 198, 56, 20).build();
        guistate.put("button:button_select", button_select);
        this.addRenderableWidget(button_select);
        button_select1 = Button.builder(Component.translatable("gui.jujutsucraftaddon.testr.button_select1"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new TestrButtonMessage(1, x, y, z));
                TestrButtonMessage.handleButtonAction(entity, 1, x, y, z);
            }
        }).bounds(this.leftPos + 96, this.topPos + 287, 56, 20).build();
        guistate.put("button:button_select1", button_select1);
        this.addRenderableWidget(button_select1);
        button_select2 = Button.builder(Component.translatable("gui.jujutsucraftaddon.testr.button_select2"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new TestrButtonMessage(2, x, y, z));
                TestrButtonMessage.handleButtonAction(entity, 2, x, y, z);
            }
        }).bounds(this.leftPos + 194, this.topPos + 174, 56, 20).build();
        guistate.put("button:button_select2", button_select2);
        this.addRenderableWidget(button_select2);
        button_select3 = Button.builder(Component.translatable("gui.jujutsucraftaddon.testr.button_select3"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new TestrButtonMessage(3, x, y, z));
                TestrButtonMessage.handleButtonAction(entity, 3, x, y, z);
            }
        }).bounds(this.leftPos + 343, this.topPos + 290, 56, 20).build();
        guistate.put("button:button_select3", button_select3);
        this.addRenderableWidget(button_select3);
    }
}
