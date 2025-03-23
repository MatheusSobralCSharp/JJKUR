package com.jujutsu.jujutsucraftaddon;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.player.Player;

import java.awt.Color;

public class RainbowTextUtil {
    public static void sendRainbowMessage(Player player, String message) {
        if (!player.level().isClientSide()) {
            MutableComponent rainbowMessage = Component.empty();
            long time = System.currentTimeMillis();
            float baseHue = (time % 5000L) / 5000.0f; // Full cycle every 5 seconds

            for (int i = 0; i < message.length(); i++) {
                float hue = (baseHue + (i * 0.1f)) % 1.0f; // Shift hue for each letter
                int rgb = Color.HSBtoRGB(hue, 1.0f, 1.0f);
                TextColor textColor = TextColor.fromRgb(rgb);

                rainbowMessage.append(Component.literal(String.valueOf(message.charAt(i)))
                        .setStyle(Style.EMPTY.withColor(textColor)));
            }

            player.displayClientMessage(rainbowMessage, false);
        }
    }
}
