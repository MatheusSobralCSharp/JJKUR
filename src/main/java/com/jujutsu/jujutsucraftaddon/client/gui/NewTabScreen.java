package com.jujutsu.jujutsucraftaddon.client.gui;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.network.AltarMessageSlider;
import com.jujutsu.jujutsucraftaddon.network.NewTabButtonMessage;
import com.jujutsu.jujutsucraftaddon.world.inventory.NewTabMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractSliderButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NewTabScreen extends AbstractContainerScreen<NewTabMenu> {
    private final static HashMap<String, Object> guistate = NewTabMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    Button button_unlock_extension;
    Button button_toggle_map_navigation;
    Button button_history_mode;
    Button button_cursed_weapon_menu;
    Button button_toggle_water_walking;
    Button button_profession_tree;
    Button button_toggle_music_ost;
    Button button_toggle_impact_frames;
    Button button_toggle_dash;
    Button button_toggle_combat_animations;
    Button button_history_mode_gojosukuna;
    Button button_fog;
    Button button_bar;

    public NewTabScreen(NewTabMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 350;
        this.imageHeight = 280;
    }

    private static final ResourceLocation texture = new ResourceLocation("jujutsucraftaddon:textures/screens/new_tab.png");

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
        if (mouseX > leftPos + 241 && mouseX < leftPos + 265 && mouseY > topPos + 20 && mouseY < topPos + 44)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.new_tab.tooltip_for_unlock_extension_just_click"), mouseX, mouseY);
        if (mouseX > leftPos + 72 && mouseX < leftPos + 96 && mouseY > topPos + 175 && mouseY < topPos + 199)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.new_tab.tooltip_toggle_overlay_map_navigation_fo"), mouseX, mouseY);
        if (mouseX > leftPos + 241 && mouseX < leftPos + 265 && mouseY > topPos + 111 && mouseY < topPos + 135)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.new_tab.tooltip_here_is_where_history_mode_quest"), mouseX, mouseY);
        if (mouseX > leftPos + 241 && mouseX < leftPos + 265 && mouseY > topPos + 50 && mouseY < topPos + 74)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.new_tab.tooltip_display_cursed_weapon_menu_encha"), mouseX, mouseY);
        if (mouseX > leftPos + 73 && mouseX < leftPos + 97 && mouseY > topPos + 112 && mouseY < topPos + 136)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.new_tab.tooltip_enable_or_disable_water_walking"), mouseX, mouseY);
        if (mouseX > leftPos + 241 && mouseX < leftPos + 265 && mouseY > topPos + 81 && mouseY < topPos + 105)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.new_tab.tooltip_display_your_profession_skill_tr"), mouseX, mouseY);
        if (mouseX > leftPos + 72 && mouseX < leftPos + 96 && mouseY > topPos + 144 && mouseY < topPos + 168)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.new_tab.tooltip_disable_jjk_songsosts_from_bein"), mouseX, mouseY);
        if (mouseX > leftPos + 73 && mouseX < leftPos + 97 && mouseY > topPos + 82 && mouseY < topPos + 106)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.new_tab.tooltip_disableenable_impact_frames"), mouseX, mouseY);
        if (mouseX > leftPos + 73 && mouseX < leftPos + 97 && mouseY > topPos + 51 && mouseY < topPos + 75)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.new_tab.tooltip_enabledisable_dashing"), mouseX, mouseY);
        if (mouseX > leftPos + 73 && mouseX < leftPos + 97 && mouseY > topPos + 21 && mouseY < topPos + 45)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.new_tab.tooltip_disable_or_enable_combat_animati"), mouseX, mouseY);
        if (mouseX > leftPos + 241 && mouseX < leftPos + 265 && mouseY > topPos + 140 && mouseY < topPos + 164)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.new_tab.tooltip_empty"), mouseX, mouseY);
    }

    private final List<Slider> sliders = new ArrayList<>();

    // Array of words to display on the sliders
    private static final String[] OPTIONS_1 = {"100%", "75%", "50%", "25%", "0%"};


    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        for (Slider slider : sliders) {
            if (slider.mouseClicked(mouseX, mouseY, button)) {
                slider.setFocused(true);
                return true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        for (int i = 0; i < sliders.size(); i++) {
        // Removes focus from all sliders
            Slider element = sliders.get(i);
            element.setFocused(false);
        }
        for (Slider slider : sliders) {
            if (slider.mouseReleased(mouseX, mouseY, button)) {
                return true;
            }
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        for (Slider slider : sliders) {
            if (slider.isFocused() && button == 0) {
                slider.updateSliderPosition(mouseX);
                return true;
            }
        }
        return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
    }

    // Slider class
    private static class Slider extends AbstractSliderButton {
        private final String[] options;
        private boolean dragging = false;
        String title;

        public Slider(int x, int y, int width, int height, Component title, String[] options) {
            super(x, y, width, height, title, 0.0);
            this.options = options;
            this.title = title.getString();
            updateMessage();
        }

        @Override
        protected void updateMessage() {
// Class that sets the slider value
            int index = (int) Math.round(this.value * (options.length - 1));
            this.setMessage(Component.literal(title + ": " + options[index]));
            JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new AltarMessageSlider(index));
            AltarMessageSlider.pressAction(Minecraft.getInstance().player, index);
        }

        @Override
        protected void applyValue() {
            // Debug class. Left it just in case
            //int index = (int) Math.round(this.value * (options.length - 1));
            //System.out.println(title + " Selected: " + options[index]);
        }

        @Override
        public boolean mouseClicked(double mouseX, double mouseY, int button) {
            if (isHoveredOrFocused() && button == 0) {
                this.dragging = true;
                updateSliderPosition(mouseX); // Update
                return true;
            }
            return false;
        }

        @Override
        public boolean mouseReleased(double mouseX, double mouseY, int button) {
            if (button == 0) {
                this.dragging = false;
                return true;
            }
            return false;
        }

        public void updateSliderPosition(double mouseX) {
            double relativeMouseX = mouseX - this.getX();
            this.value = Math.max(0.0, Math.min(1.0, relativeMouseX / (double) this.width));
            applyValue();
            updateMessage();
        }

        public void setIntSliderValue(int index) { // Custom code to set the slider value by the index of the options array from the code
            if (index >= 0 && index < options.length) {
                this.value = (double) index / (options.length - 1);
                applyValue();
                updateMessage();
            } else {
                System.out.println("Ошибка: Некорректный индекс для слайдера.");
            }
        }

        public void setStringSliderValue(String option) { // Custom code to set the slider value by the text in the options array from the code
            for (int i = 0; i < options.length; i++) {
                if (options[i].equals(option)) {
                    this.value = (double) i / (options.length - 1);
                    applyValue();
                    updateMessage();
                    return;
                }
            }
            System.out.println("Error: Option " + option + " not found in the options array.");
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
        button_unlock_extension = Button.builder(Component.translatable("gui.jujutsucraftaddon.new_tab.button_unlock_extension"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new NewTabButtonMessage(0, x, y, z));
                NewTabButtonMessage.handleButtonAction(entity, 0, x, y, z);
            }
        }).bounds(this.leftPos + 201, this.topPos + 23, 108, 20).build();
        guistate.put("button:button_unlock_extension", button_unlock_extension);
        this.addRenderableWidget(button_unlock_extension);
        button_toggle_map_navigation = Button.builder(Component.translatable("gui.jujutsucraftaddon.new_tab.button_toggle_map_navigation"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new NewTabButtonMessage(1, x, y, z));
                NewTabButtonMessage.handleButtonAction(entity, 1, x, y, z);
            }
        }).bounds(this.leftPos + 24, this.topPos + 176, 134, 20).build();
        guistate.put("button:button_toggle_map_navigation", button_toggle_map_navigation);
        this.addRenderableWidget(button_toggle_map_navigation);
        button_history_mode = Button.builder(Component.translatable("gui.jujutsucraftaddon.new_tab.button_history_mode"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new NewTabButtonMessage(2, x, y, z));
                NewTabButtonMessage.handleButtonAction(entity, 2, x, y, z);
            }
        }).bounds(this.leftPos + 210, this.topPos + 113, 87, 20).build();
        guistate.put("button:button_history_mode", button_history_mode);
        this.addRenderableWidget(button_history_mode);
        button_cursed_weapon_menu = Button.builder(Component.translatable("gui.jujutsucraftaddon.new_tab.button_cursed_weapon_menu"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new NewTabButtonMessage(3, x, y, z));
                NewTabButtonMessage.handleButtonAction(entity, 3, x, y, z);
            }
        }).bounds(this.leftPos + 197, this.topPos + 53, 119, 20).build();
        guistate.put("button:button_cursed_weapon_menu", button_cursed_weapon_menu);
        this.addRenderableWidget(button_cursed_weapon_menu);
        button_toggle_water_walking = Button.builder(Component.translatable("gui.jujutsucraftaddon.new_tab.button_toggle_water_walking"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new NewTabButtonMessage(4, x, y, z));
                NewTabButtonMessage.handleButtonAction(entity, 4, x, y, z);
            }
        }).bounds(this.leftPos + 27, this.topPos + 116, 129, 20).build();
        guistate.put("button:button_toggle_water_walking", button_toggle_water_walking);
        this.addRenderableWidget(button_toggle_water_walking);
        button_profession_tree = Button.builder(Component.translatable("gui.jujutsucraftaddon.new_tab.button_profession_tree"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new NewTabButtonMessage(5, x, y, z));
                NewTabButtonMessage.handleButtonAction(entity, 5, x, y, z);
            }
        }).bounds(this.leftPos + 202, this.topPos + 83, 103, 20).build();
        guistate.put("button:button_profession_tree", button_profession_tree);
        this.addRenderableWidget(button_profession_tree);
        button_toggle_music_ost = Button.builder(Component.translatable("gui.jujutsucraftaddon.new_tab.button_toggle_music_ost"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new NewTabButtonMessage(6, x, y, z));
                NewTabButtonMessage.handleButtonAction(entity, 6, x, y, z);
            }
        }).bounds(this.leftPos + 35, this.topPos + 147, 108, 20).build();
        guistate.put("button:button_toggle_music_ost", button_toggle_music_ost);
        this.addRenderableWidget(button_toggle_music_ost);
        button_toggle_impact_frames = Button.builder(Component.translatable("gui.jujutsucraftaddon.new_tab.button_toggle_impact_frames"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new NewTabButtonMessage(7, x, y, z));
                NewTabButtonMessage.handleButtonAction(entity, 7, x, y, z);
            }
        }).bounds(this.leftPos + 27, this.topPos + 84, 129, 20).build();
        guistate.put("button:button_toggle_impact_frames", button_toggle_impact_frames);
        this.addRenderableWidget(button_toggle_impact_frames);
        button_toggle_dash = Button.builder(Component.translatable("gui.jujutsucraftaddon.new_tab.button_toggle_dash"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new NewTabButtonMessage(8, x, y, z));
                NewTabButtonMessage.handleButtonAction(entity, 8, x, y, z);
            }
        }).bounds(this.leftPos + 47, this.topPos + 52, 82, 20).build();
        guistate.put("button:button_toggle_dash", button_toggle_dash);
        this.addRenderableWidget(button_toggle_dash);
        button_toggle_combat_animations = Button.builder(Component.translatable("gui.jujutsucraftaddon.new_tab.button_toggle_combat_animations"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new NewTabButtonMessage(9, x, y, z));
                NewTabButtonMessage.handleButtonAction(entity, 9, x, y, z);
            }
        }).bounds(this.leftPos + 17, this.topPos + 23, 150, 20).build();
        guistate.put("button:button_toggle_combat_animations", button_toggle_combat_animations);
        this.addRenderableWidget(button_toggle_combat_animations);
        button_history_mode_gojosukuna = Button.builder(Component.translatable("gui.jujutsucraftaddon.new_tab.button_history_mode_gojosukuna"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new NewTabButtonMessage(10, x, y, z));
                NewTabButtonMessage.handleButtonAction(entity, 10, x, y, z);
            }
        }).bounds(this.leftPos + 182, this.topPos + 142, 150, 20).build();
        guistate.put("button:button_history_mode_gojosukuna", button_history_mode_gojosukuna);
        this.addRenderableWidget(button_history_mode_gojosukuna);
        button_fog = Button.builder(Component.literal("Disable Fog"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new NewTabButtonMessage(11, x, y, z));
                NewTabButtonMessage.handleButtonAction(entity, 11, x, y, z);
            }
        }).bounds(this.leftPos + 182, this.topPos + 182, 150, 20).build();
        guistate.put("button:button_fog", button_fog);
        this.addRenderableWidget(button_fog);
        button_bar = Button.builder(Component.literal("Disable Kokusen Bar"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new NewTabButtonMessage(12, x, y, z));
                NewTabButtonMessage.handleButtonAction(entity, 12, x, y, z);
            }
        }).bounds(this.leftPos + 182, this.topPos + 202, 150, 20).build();
        guistate.put("button:button_bar", button_bar);
        this.addRenderableWidget(button_bar);

        // First slider
        Slider sliderNameOne = new Slider(this.leftPos + 182, this.topPos + 232, 150, 20, Component.literal("Speed Slider"), OPTIONS_1);
        sliders.add(sliderNameOne);
        this.addRenderableWidget(sliderNameOne);
    }
}
