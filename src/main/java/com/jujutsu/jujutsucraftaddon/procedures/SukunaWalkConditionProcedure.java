package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;

public class SukunaWalkConditionProcedure {
    public static boolean execute(Entity entity) {
        if (entity == null)
            return false;
        return entity.getDeltaMovement().z() > 0 || entity.getDeltaMovement().y() > 0 || entity.getDeltaMovement().x() == 0;
    }
}
