package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class RespawnedOneEffectExpiresProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof LivingEntity) {
            ConcorrentSpawnProcedure.execute(entity, world, x, y, z);
            world.addParticle(JujutsucraftaddonModParticleTypes.THUNDER_BLACK.get(), x, y, z, 0, 1, 0);
        }
    }
}
