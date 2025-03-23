package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;

public class Artifact3RightclickedProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        VowClearProcedure.execute(entity);
    }
}
