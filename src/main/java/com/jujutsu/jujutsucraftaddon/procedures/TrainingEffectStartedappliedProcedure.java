package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;

public class TrainingEffectStartedappliedProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        entity.getPersistentData().putDouble("Timer", 5000);
    }
}
