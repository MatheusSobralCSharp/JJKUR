package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;

public class TrainingOnEffectActiveTickProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        entity.getPersistentData().putDouble("Timer", (entity.getPersistentData().getDouble("Timer") - 1));
    }
}
