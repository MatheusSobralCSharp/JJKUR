package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;

public class Target2Procedure {
    public static boolean execute(Entity entity) {
        if (entity == null)
            return false;
        return !((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null);
    }
}
