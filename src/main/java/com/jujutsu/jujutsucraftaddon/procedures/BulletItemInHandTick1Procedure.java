package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class BulletItemInHandTick1Procedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        double speed = 0;
        double spread = 0;
        speed = 0.1;
        spread = 1;
        if (world instanceof ServerLevel _level)
            _level.sendParticles(JujutsucraftaddonModParticleTypes.BLOOD_RED.get(), (entity.getX()), (entity.getY() + entity.getEyeHeight()), (entity.getZ()), 0,
                    (entity.getLookAngle().x * speed + Mth.nextDouble(RandomSource.create(), spread * (-1), spread)), (entity.getLookAngle().y * speed + Mth.nextDouble(RandomSource.create(), spread * (-1), spread)),
                    (entity.getLookAngle().z * speed + Mth.nextDouble(RandomSource.create(), spread * (-1), spread)), 1);
    }
}
