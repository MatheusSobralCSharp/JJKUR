package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.MakiPreparation2Entity;
import com.jujutsu.jujutsucraftaddon.entity.MakiPreparationEntity;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.mcreator.jujutsucraft.procedures.AIGojoSchoolDaysProcedure;
import net.mcreator.jujutsucraft.procedures.AIZeninMakiProcedure;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class GojoMangaOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (entity.getPersistentData().getDouble("UseCursedTechnique") == 0) {
            entity.getPersistentData().putDouble("UseCursedTechnique", 0);
        }
        if (entity.getPersistentData().getDouble("JujutsuSorcerer") == 0) {
            entity.getPersistentData().putDouble("JujutsuSorcerer", 0);
        }
        if (entity instanceof MakiPreparationEntity) {
            AIZeninMakiProcedure.execute(world, x, y, z, entity);
        } else if (entity instanceof MakiPreparation2Entity) {
            if (Math.random() < (1) / ((float) 1000000)) {
                if (world instanceof ServerLevel _level)
                    _level.sendParticles(JujutsucraftaddonModParticleTypes.CURSE_POWER_BLUE_DARK.get(), x, (y - 134), z, 0, 3, 3, 3, 1);
            }
        }
        AIGojoSchoolDaysProcedure.execute(world, x, y, z, entity);
    }
}
