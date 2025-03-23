package com.jujutsu.jujutsucraftaddon;

import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Objects;

@OnlyIn(Dist.CLIENT)
public class OverlayTextureNoOverlay implements AutoCloseable {
    private static final int SIZE = 16;
    public static final int NO_WHITE_U = 0;
    public static final int RED_OVERLAY_V = 3;
    public static final int WHITE_OVERLAY_V = 10;
    public static final int NO_OVERLAY = pack(10, 40);
    private final DynamicTexture texture = new DynamicTexture(16, 16, false);
    public OverlayTextureNoOverlay() {
        NativeImage $$0 = this.texture.getPixels();

        for(int $$1 = 0; $$1 < 16; ++$$1) {
            for(int $$2 = 0; $$2 < 16; ++$$2) {
                if ($$1 < 8) {
                    $$0.setPixelRGBA($$2, $$1, -1308622593);
                } else {
                    int $$3 = (int)((1.0F - (float)$$2 / 15.0F * 0.75F) * 255.0F);
                    $$0.setPixelRGBA($$2, $$1, $$3 << 24 | 16777215);
                }
            }
        }

        RenderSystem.activeTexture(33985);
        this.texture.bind();
        $$0.upload(0, 0, 0, 0, 0, $$0.getWidth(), $$0.getHeight(), false, true, false, false);
        RenderSystem.activeTexture(33984);
    }

    public void close() {
        this.texture.close();
    }

    public void setupOverlayColor() {
        DynamicTexture var10000 = this.texture;
        Objects.requireNonNull(var10000);
        RenderSystem.setupOverlayColor(var10000::getId, 16);
    }

    public static int u(float p_118089_) {
        return (int)(p_118089_ * 15.0F);
    }

    public static int v(boolean p_118097_) {
        return p_118097_ ? 3 : 10;
    }

    public static int pack(int p_118094_, int p_118095_) {
        return p_118094_ | p_118095_ << 16;
    }

    public static int pack(float p_118091_, boolean p_118092_) {
        return pack(u(p_118091_), v(p_118092_));
    }

    public void teardownOverlayColor() {
        RenderSystem.teardownOverlayColor();
    }
}
