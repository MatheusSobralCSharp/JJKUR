package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;

public class AdjuchaOnEntityTickUpdateProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        double Grow = 0;
        double TrackZ = 0;
        double TrackY = 0;
        double TrackX = 0;
        double timer = 0;
        AdjuchaBasedProcedure.execute(entity);
    }
}
