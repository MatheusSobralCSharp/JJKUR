package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.AngellEntity;
import com.jujutsu.jujutsucraftaddon.entity.HakariEntity;
import com.jujutsu.jujutsucraftaddon.entity.KashimoFemboyEntity;
import com.jujutsu.jujutsucraftaddon.entity.YutaCullingGamesEntity;
import net.mcreator.jujutsucraft.procedures.AIKashimoHajimeProcedure;
import net.mcreator.jujutsucraft.procedures.AIOkkotsuProcedure;
import net.mcreator.jujutsucraft.procedures.LocateRikaProcedure;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class AngellOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;

        if (world instanceof ServerLevel) {
            if (entity instanceof HakariEntity) {
                HakariOnInitialEntitySpawnProcedure.execute(entity);
                net.mcreator.jujutsucraft.procedures.AIHakariProcedure.execute(world, x, y, z, entity);
            } else if (entity instanceof AngellEntity) {
                AngellOnInitialEntitySpawnProcedure.execute(entity);
            } else if (entity instanceof YutaCullingGamesEntity) {
                YutaCullingSpawnProcedure.execute(entity);
                if (!LocateRikaProcedure.execute(world, entity)) {
                    AIOkkotsuProcedure.execute(world, x, y, z, entity);
                }
            } else if (entity instanceof KashimoFemboyEntity) {
                AIKashimoHajimeProcedure.execute(world, x, y, z, entity);
            }
        }
    }

}
