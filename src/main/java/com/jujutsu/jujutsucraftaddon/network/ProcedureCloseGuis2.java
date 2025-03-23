package com.jujutsu.jujutsucraftaddon.network;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class ProcedureCloseGuis2 {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof Player _player)
            _player.closeContainer();
        if (Minecraft.getInstance().player != null && Minecraft.getInstance().level.isClientSide) {
                Minecraft.getInstance().setScreen(null);
        }
    }
}
