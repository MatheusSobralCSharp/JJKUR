package com.jujutsu.jujutsucraftaddon.client.screens;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class JujutsuMenuScreen extends Screen {
    public static final int WINDOW_WIDTH = 252;
    public static final int WINDOW_HEIGHT = 140;
    public static final int WINDOW_INSIDE_WIDTH = 234;
    public static final int WINDOW_INSIDE_HEIGHT = 113;
    public static final int BACKGROUND_TILE_WIDTH = 16;
    public static final int BACKGROUND_TILE_HEIGHT = 16;
    private static final ResourceLocation WINDOW = new ResourceLocation("textures/gui/advancements/window.png");
    private static final int WINDOW_INSIDE_X = 9;
    private static final int WINDOW_INSIDE_Y = 18;
    private static int tabPage, maxPages;
    private final List<JJKTab> tabs = new ArrayList<>();
    @Nullable
    private JJKTab selectedTab;
    private boolean isScrolling;

    public JujutsuMenuScreen() {
        super(Component.empty());
    }

    @Override
    public void renderBackground(@NotNull GuiGraphics pGuiGraphics) {

    }

    private void setSelectedTab(@NotNull JJKTab tab) {
        if (this.selectedTab != null) {
            for (GuiEventListener widget : this.selectedTab.getRenderables()) {
                this.removeWidget(widget);
            }
            this.selectedTab.removeWidgets();
        }
        this.selectedTab = tab;
        this.selectedTab.addWidgets();
    }

    public void removeWidgets() {
        if (this.selectedTab != null) {
            for (GuiEventListener widget : this.selectedTab.getRenderables()) {
                this.removeWidget(widget);
            }
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.selectedTab != null) {
            this.selectedTab.tick();
        }
    }

    @Override
    public <T extends GuiEventListener & Renderable & NarratableEntry> @NotNull T addRenderableWidget(@NotNull T pWidget) {
        return super.addRenderableWidget(pWidget);
    }

    @Override
    protected void init() {
        this.tabs.clear();
        this.selectedTab = null;

        this.tabs.add(new AbilityTab(this.minecraft, this, JJKTabType.ABOVE, 0, 0));

        this.setSelectedTab(this.tabs.get(0));

        if (this.tabs.size() > JJKTabType.MAX_TABS) {
            int guiLeft = (this.width - WINDOW_WIDTH) / 2;
            int guiTop = (this.height - WINDOW_HEIGHT) / 2;
            this.addRenderableWidget(Button.builder(Component.literal("<"), b -> tabPage = Math.max(tabPage - 1, 0))
                    .pos(guiLeft, guiTop - 50).size(20, 20).build());
            this.addRenderableWidget(Button.builder(Component.literal(">"), b -> tabPage = Math.min(tabPage + 1, maxPages))
                    .pos(guiLeft + WINDOW_WIDTH - 20, guiTop - 50).size(20, 20).build());
            maxPages = this.tabs.size() / JJKTabType.MAX_TABS;
        }

    }

    @Override
    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
        if (this.selectedTab != null) {
            int i = (this.width - WINDOW_WIDTH) / 2;
            int j = (this.height - WINDOW_HEIGHT) / 2;
            this.selectedTab.mouseClicked(pMouseX - i - WINDOW_INSIDE_X, pMouseY - j - WINDOW_INSIDE_Y, pButton);
        }

        if (pButton == 0) {
            int i = (this.width - WINDOW_WIDTH) / 2;
            int j = (this.height - WINDOW_HEIGHT) / 2;

            for (JJKTab tab : this.tabs) {
                if (tab.getPage() == tabPage && tab.isMouseOver(i, j, pMouseX, pMouseY)) {
                    this.setSelectedTab(tab);
                    break;
                }
            }
        }
        return super.mouseClicked(pMouseX, pMouseY, pButton);
    }

    @Override
    public boolean mouseReleased(double pMouseX, double pMouseY, int pButton) {
        if (this.selectedTab != null) {
            int i = (this.width - WINDOW_WIDTH) / 2;
            int j = (this.height - WINDOW_HEIGHT) / 2;
            this.selectedTab.mouseReleased(pMouseX - i - 9, pMouseY - j - 18, pButton);
        }
        return super.mouseReleased(pMouseX, pMouseY, pButton);
    }

    @Override
    public boolean keyPressed(int pKeyCode, int pScanCode, int pModifiers) {
        if (this.selectedTab != null) {
            this.selectedTab.keyPressed(pKeyCode, pScanCode, pModifiers);
        }
        return super.keyPressed(pKeyCode, pScanCode, pModifiers);
    }

    @Override
    public void render(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        int i = (this.width - WINDOW_WIDTH) / 2;
        int j = (this.height - WINDOW_HEIGHT) / 2;

        if (maxPages != 0) {
            Component page = Component.literal(String.format("%d / %d", tabPage + 1, maxPages + 1));
            int width = this.font.width(page);
            pGuiGraphics.drawString(this.font, page.getVisualOrderText(), i + (WINDOW_WIDTH / 2) - (width / 2), j - 44, -1);
        }
        this.renderInside(pGuiGraphics, i, j);
        this.renderWindow(pGuiGraphics, i, j);
        this.renderTooltips(pGuiGraphics, pMouseX, pMouseY, i, j);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
    }

    private void renderInside(GuiGraphics graphics, int offsetX, int offsetY) {
        if (this.selectedTab != null) {
            this.selectedTab.drawContents(graphics, offsetX + WINDOW_INSIDE_X, offsetY + WINDOW_INSIDE_Y);
        }
    }

    public void renderWindow(GuiGraphics graphics, int offsetX, int offsetY) {
        RenderSystem.enableBlend();
        graphics.blit(WINDOW, offsetX, offsetY, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        for (JJKTab tab : this.tabs) {
            if (tab.getPage() == tabPage) {
                tab.drawTab(graphics, offsetX, offsetY, tab == this.selectedTab);
            }
        }

        for (JJKTab tab : this.tabs) {
            if (tab.getPage() == tabPage) {
                tab.drawIcon(graphics, offsetX, offsetY);
            }
        }
    }

    private void renderTooltips(GuiGraphics graphics, int mouseX, int mouseY, int offsetX, int offsetY) {
        if (this.selectedTab != null) {
            this.selectedTab.drawTooltips(graphics, mouseX, mouseY, offsetX, offsetY);
        }

        for (com.jujutsu.jujutsucraftaddon.client.screens.JJKTab JJKTab : this.tabs) {
            if (JJKTab.getPage() == tabPage && JJKTab.isMouseOver(offsetX, offsetY, mouseX, mouseY)) {
                graphics.renderTooltip(this.font, JJKTab.getTitle(), mouseX, mouseY);
            }
        }
    }

    @Override
    public boolean mouseDragged(double pMouseX, double pMouseY, int pButton, double pDragX, double pDragY) {
        if (pButton != InputConstants.MOUSE_BUTTON_LEFT) {
            this.isScrolling = false;
            return false;
        } else {
            if (!this.isScrolling) {
                this.isScrolling = true;
            } else if (this.selectedTab != null) {
                this.selectedTab.scroll(pDragX, pDragY);
            }
            return true;
        }
    }

}