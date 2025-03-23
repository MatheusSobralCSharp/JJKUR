package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ExpiredOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (world.isClientSide()) {
            Minecraft.getInstance().gameRenderer.shutdownEffect();
            Minecraft.getInstance().gameRenderer.shutdownEffect();
            Minecraft.getInstance().gameRenderer.shutdownEffect();
            Minecraft.getInstance().gameRenderer.shutdownEffect();
            Minecraft.getInstance().gameRenderer.shutdownEffect();
        }
    }
}
