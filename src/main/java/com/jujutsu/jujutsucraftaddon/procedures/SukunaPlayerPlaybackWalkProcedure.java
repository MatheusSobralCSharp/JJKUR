package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;

public class SukunaPlayerPlaybackWalkProcedure {
    public static boolean execute(Entity entity) {
        if (entity == null)
            return false;
        return entity.getDeltaMovement().z() == 0 && entity.getDeltaMovement().x() == 0 && entity.getDeltaMovement().y() == 0;
    }
}
