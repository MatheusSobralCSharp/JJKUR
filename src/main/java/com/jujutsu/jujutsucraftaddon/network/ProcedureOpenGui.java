package com.jujutsu.jujutsucraftaddon.network;

import com.jujutsu.jujutsucraftaddon.client.screens.AltarSelectorScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;

public class ProcedureOpenGui {
    private static boolean guiOpened = false; // Tracks if GUI has been opened
    public static void execute(Entity entity) {
        if (entity == null)
            return;

        if (Minecraft.getInstance() != null) {
            Minecraft.getInstance().execute(() -> {
                // Open GUI only if it hasn't been opened yet
                if (!guiOpened && Minecraft.getInstance().screen == null) {
                    Minecraft.getInstance().setScreen(new AltarSelectorScreen());
                    guiOpened = true; // Set the flag to true
                }
            });
        }
    }
}
