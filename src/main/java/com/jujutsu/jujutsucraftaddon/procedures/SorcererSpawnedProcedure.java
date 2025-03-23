package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.MakiPreparation2Entity;
import com.jujutsu.jujutsucraftaddon.entity.MakiPreparationEntity;
import net.mcreator.jujutsucraft.procedures.AIZeninMakiProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class SorcererSpawnedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof MakiPreparationEntity) {
            AIZeninMakiProcedure.execute(world, x, y, z, entity);
        } else if (entity instanceof MakiPreparation2Entity) {
            AIZeninMakiProcedure.execute(world, x, y, z, entity);
        }

    }
}
