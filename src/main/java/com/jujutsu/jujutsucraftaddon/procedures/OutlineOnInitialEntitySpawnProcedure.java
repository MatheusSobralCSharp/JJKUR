package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;

public class OutlineOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        String block = "";
        String old_block = "";
        entity.getPersistentData().putDouble("Tag1", 20);
    }
}
