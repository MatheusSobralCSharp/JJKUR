package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class OutLinerEffectStartedappliedProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        ServerLevel _level;
        if (world.isClientSide()) {
            if (Minecraft.getInstance().gameRenderer.currentEffect() == null) {
                Minecraft.getInstance().gameRenderer.loadEffect(new ResourceLocation("jujutsucraftaddon:shaders/blackandwhiteweak.json"));
            }
        }
    }
}
