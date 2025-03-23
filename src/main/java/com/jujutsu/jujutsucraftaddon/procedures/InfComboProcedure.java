package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class InfComboProcedure {
    public static void execute(LevelAccessor world, Entity sourceentity) {
        DivergentProcedure.execute(world, sourceentity.getX(), sourceentity.getY(), sourceentity.getZ(), sourceentity);
    }
}
