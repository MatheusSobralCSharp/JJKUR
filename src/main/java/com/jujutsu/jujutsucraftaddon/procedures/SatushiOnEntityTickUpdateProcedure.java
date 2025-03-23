package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class SatushiOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        SatushiOnInitialEntitySpawnProcedure.execute(entity);
        SukunaMangaRCTProcedure.execute(world, entity);
        HusseinDongOnEntityTickUpdateProcedure.execute(entity);
    }
}
