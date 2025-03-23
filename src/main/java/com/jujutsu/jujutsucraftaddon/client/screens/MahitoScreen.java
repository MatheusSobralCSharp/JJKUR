package com.jujutsu.jujutsucraftaddon.client.screens;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModKeyMappings;
import com.jujutsu.jujutsucraftaddon.network.AltarMessageMahito;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

import java.util.ArrayList;
import java.util.List;

public class MahitoScreen extends Screen {
    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation("jujutsucraftaddon", "textures/gui/background.png");
    private static final int RADIUS_IN = 50;
    private static final int RADIUS_OUT = RADIUS_IN * 2;
    private static final int MAX_ITEMS = 24;
    private int hover;
    private static int page;
    private final List<List<AltarOption>> pages = new ArrayList<>();
    private int hovered = -1;

    public MahitoScreen() {
        super(Component.literal("Skill List"));
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    protected void init() {
        super.init();

        this.pages.clear();
        List<MahitoScreen.AltarOption> options = this.getOptions();

        int count = options.size() / MAX_ITEMS;
        for (int i = 0; i < count; i++) {
            this.pages.add(options.subList(i * MAX_ITEMS, (i + 1) * MAX_ITEMS));
        }

        int remainder = options.size() % MAX_ITEMS;
        if (remainder > 0) {
            this.pages.add(options.subList(count * MAX_ITEMS, count * MAX_ITEMS + remainder));
        }

        if (page >= this.pages.size()) {
            page = 0;
        }
        if (this.pages.isEmpty()) {
            this.onClose();
        }

    }


    private List<MahitoScreen.AltarOption> getOptions() {
        List<MahitoScreen.AltarOption> options = new ArrayList<>();
        options.add(new AltarOption(Component.translatable("jujutsu.technique.attack2").getString()));
        options.add(new AltarOption(Component.translatable("jujutsu.technique.attack3").getString()));
        options.add(new AltarOption(Component.translatable("jujutsu.technique.attack5").getString()));
        options.add(new AltarOption(Component.translatable("jujutsu.technique.attack4").getString()));
        options.add(new AltarOption(Component.translatable("jujutsu.technique.mahito_body_repel2").getString()));
        options.add(new AltarOption(Component.translatable("jujutsu.technique.attack8").getString()));
        options.add(new AltarOption(Component.translatable("jujutsu.technique.mahito7").getString()));
        options.add(new AltarOption("Clone"));
        return options;
    }

    @Override
    public boolean keyReleased(int pKeyCode, int pScanCode, int pModifiers) {
        if (pKeyCode == JujutsucraftaddonModKeyMappings.ALTAR_SELECTOR.getKey().getValue()) {
            this.onClose();
        }
        return super.keyReleased(pKeyCode, pScanCode, pModifiers);
    }


    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        super.render(guiGraphics, mouseX, mouseY, delta);

        int centerX = this.width / 2;
        int centerY = this.height / 2;

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        guiGraphics.pose().pushPose();

        // Continue rendering segments and other elements
        RenderSystem.setShader(GameRenderer::getPositionColorShader);

        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder buffer = tesselator.getBuilder();

        // Draw the segments using drawSlice
        buffer.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
        for (int i = 0; i < this.getCurrent().size(); i++) {
            float startAngle = this.getAngleFor(i - 0.5F);
            float endAngle = this.getAngleFor(i + 0.5F);


            MahitoScreen.AltarOption item = this.getCurrent().get(i);
            int white = toRGB24(255, 255, 255, 150);
            int black = toRGB24(75, 0, 130, 150);

            int color;

            if (this.hovered > 0) {
                color = this.hovered == i ? black : white;
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new AltarMessageMahito(this.hovered));
                AltarMessageMahito.pressAction(Minecraft.getInstance().player, this.hovered);
                this.getCurrent().get(this.hovered).onSelect();
                this.onClose();
            } else {
                color = this.hovered == i ? white : black;
            }
            this.drawTexturedCircle(guiGraphics.pose(), buffer, centerX, centerY, startAngle, endAngle, color);
        }

        tesselator.end();
        RenderSystem.disableBlend();
        guiGraphics.pose().popPose();

        // Render text
        renderText(guiGraphics, centerX, centerY);
    }

    private void drawTexturedCircle(PoseStack poseStack, BufferBuilder buffer, float centerX, float centerY, float startAngle, float endAngle, int color) {
        float angle = endAngle - startAngle;
        float precision = 2.5F / 360.0F;
        int sections = Math.max(1, Mth.ceil(angle / precision));

        angle = endAngle - startAngle;

        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = color & 0xFF;
        int a = (color >> 24) & 0xFF;

        float slice = angle / sections;

        for (int i = 0; i < sections; i++) {
            float angle1 = startAngle + i * slice;
            float angle2 = startAngle + (i + 1) * slice;

            float x1 = centerX + RADIUS_IN * (float) Math.cos(angle1);
            float y1 = centerY + RADIUS_IN * (float) Math.sin(angle1);
            float x2 = centerX + RADIUS_OUT * (float) Math.cos(angle1);
            float y2 = centerY + RADIUS_OUT * (float) Math.sin(angle1);
            float x3 = centerX + RADIUS_OUT * (float) Math.cos(angle2);
            float y3 = centerY + RADIUS_OUT * (float) Math.sin(angle2);
            float x4 = centerX + RADIUS_IN * (float) Math.cos(angle2);
            float y4 = centerY + RADIUS_IN * (float) Math.sin(angle2);

            Matrix4f matrix4f = poseStack.last().pose();
            buffer.vertex(matrix4f, x2, y2, 0.0F).color(r, g, b, a).endVertex();
            buffer.vertex(matrix4f, x1, y1, 0.0F).color(r, g, b, a).endVertex();
            buffer.vertex(matrix4f, x4, y4, 0.0F).color(r, g, b, a).endVertex();
            buffer.vertex(matrix4f, x3, y3, 0.0F).color(r, g, b, a).endVertex();
        }
    }

    private static int toRGB24(int r, int g, int b, int a) {
        return (a << 24) | (r << 16) | (g << 8) | b;
    }


    private void renderText(@NotNull GuiGraphics guiGraphics, int centerX, int centerY) {
        float radius = (RADIUS_IN + RADIUS_OUT) / 2.0F; // Midpoint radius for text positioning
        for (int i = 0; i < this.getCurrent().size(); i++) {
            float angle = getAngleFor(i); // Get the angle for each option
            int x = (int) (centerX + radius * Math.cos(angle)); // Use consistent radius
            int y = (int) (centerY + radius * Math.sin(angle)); // Use consistent radius
            int color = (this.hovered == i) ? 0xFFFFFF : 0x888888; // White for hovered, gray for others
            guiGraphics.drawCenteredString(this.font, this.getCurrent().get(i).name, x, y, color);
        }
    }


    private List<? extends MahitoScreen.AltarOption> getCurrent() {
        return this.pages.get(page);
    }


    private float getAngleFor(float index) {
        return (index / this.getCurrent().size()) * Mth.TWO_PI - (Mth.PI / 2);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (this.hovered >= 0) {
            JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new AltarMessageMahito(this.hovered));

            AltarMessageMahito.pressAction(Minecraft.getInstance().player, this.hovered);
            this.getCurrent().get(this.hovered).onSelect();
            this.onClose();
            return true;
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public void onClose() {
        super.onClose();

        if (this.hovered == -1) return;

        List<? extends MahitoScreen.AltarOption> items = this.pages.get(page);

        if (this.hovered >= items.size()) return;

        MahitoScreen.AltarOption item = items.get(this.hovered);
        item.onSelect();
    }


    @Override
    public void mouseMoved(double pMouseX, double pMouseY) {
        super.mouseMoved(pMouseX, pMouseY);

        int centerX = this.width / 2;
        int centerY = this.height / 2;

        double mouseAngle = Math.atan2(pMouseY - centerY, pMouseX - centerX);
        double mousePos = Math.sqrt(Math.pow(pMouseX - centerX, 2.0D) + Math.pow(pMouseY - centerY, 2.0D));

        if (!this.getCurrent().isEmpty()) {
            float startAngle = this.getAngleFor(-0.5F);
            float endAngle = this.getAngleFor(this.getCurrent().size() - 0.5F);

            while (mouseAngle < startAngle) {
                mouseAngle += Mth.TWO_PI;
            }
            while (mouseAngle >= endAngle) {
                mouseAngle -= Mth.TWO_PI;
            }

            this.hovered = -1;

            for (int i = 0; i < this.getCurrent().size(); i++) {
                float currentStart = this.getAngleFor(i - 0.5F);
                float currentEnd = this.getAngleFor(i + 0.5F);

                if (mouseAngle >= currentStart && mouseAngle < currentEnd && mousePos >= RADIUS_IN && mousePos < RADIUS_OUT) {
                    this.hovered = i;
                    break;
                }
            }

            if (mousePos < RADIUS_OUT) return;

            if (this.pages.size() > 1) {
                if (this.pages.size() - 1 > page) {
                    if (pMouseX > (double) this.width / 2 && pMouseX < this.width && pMouseY > 0 && pMouseY < this.height) {
                        if (++this.hover == 20) {
                            page++;
                        }
                        if (this.hover == 3 * 20) {
                            this.hover = 0;
                        }
                        return;
                    }
                }
                if (page > 0) {
                    if (pMouseX > 0 && pMouseX < (double) this.width / 2 && pMouseY > 0 && pMouseY < this.height) {
                        if (++this.hover == 20) {
                            page--;
                        }
                        if (this.hover == 3 * 20) {
                            this.hover = 0;
                        }
                        return;
                    }
                }
                if (this.hover > 0) this.hover = 0;
            }
        }
    }

    private static class AltarOption {
        final String name;

        AltarOption(String name) {
            this.name = name;
        }

        void onSelect() {

        }
    }
}


