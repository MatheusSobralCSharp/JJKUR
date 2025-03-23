package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;

public class BurnoutKeyOnKeyReleasedProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        entity.getPersistentData().putBoolean("PRESS_BURNOUT", false);
        entity.getPersistentData().putDouble("cnt_v", 0);
    }
}
