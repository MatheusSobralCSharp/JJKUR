package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class SwapVibraslap {
    public static void execute(Entity entity, LevelAccessor world, double radius) {
        if (entity == null || world == null) return;
        for (int i = 0; i < 99; i++) {
            SwapTodo.execute(entity, world, radius);
        }
    }
}