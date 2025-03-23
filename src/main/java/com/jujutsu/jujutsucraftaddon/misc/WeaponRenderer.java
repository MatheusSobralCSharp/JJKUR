package com.jujutsu.jujutsucraftaddon.misc;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class WeaponRenderer extends BlockEntityWithoutLevelRenderer {
    public WeaponRenderer() {
       super(null, null);
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext displayContext, PoseStack poseStack,
                             MultiBufferSource buffer, int light, int overlay) {
        long time = System.currentTimeMillis();

        // Read NBT Tags
        CompoundTag tag = stack.getTag();
        float baseScale = 0.5f; // Small size by default (out of combat)

        if (tag != null && tag.contains("InCombat") && tag.getBoolean("InCombat")) {
            baseScale = 1.0f; // Normal size when in combat
        }

        // 🔥 Pulse effect (only when large)
        float pulse = tag != null && tag.getBoolean("InCombat") ? (0.1f * Mth.sin(time / 500.0f) + 1.0f) : 1.0f;
        float scale = baseScale * pulse;

        // 🔄 Rotation effect
        float rotation = (time % 5000L) / 5000.0f * 360.0f;

        // 🌟 Glow effect (when in combat)
        int glowOverlay = tag != null && tag.getBoolean("InCombat") ? overlay | 0xF000F0 : overlay;

        // 🎨 Apply transformations
        poseStack.pushPose();
        poseStack.scale(scale, scale, scale);
        poseStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(rotation));

        // 🎨 Render item normally
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        BakedModel model = itemRenderer.getModel(stack, null, null, 0);
        itemRenderer.render(stack, displayContext, false, poseStack, buffer, light, glowOverlay, model);

        poseStack.popPose();
    }
}
