package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;

public class ConditionFollowProcedure {
    public static boolean execute(Entity entity) {
        if (entity == null)
            return false;
        return entity.getPersistentData().getDouble("Follow") == 1;
    }
}
