package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class KusakabeSlashesProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        String oldblock = "";
        double r = 0;
        double curve = 0;
        double deg = 0;
        double yoff = 0;
        double X = 0;
        double Y = 0;
        double Z = 0;
        Direction direction = Direction.NORTH;
        if (Math.random() < (1) / ((float) 5)) {
            deg = entity.getYRot() + 90;
        } else {
            deg = entity.getYRot() - 90;
        }
        r = 1;
        curve = Mth.nextDouble(RandomSource.create(), -10, 10);
        for (int index0 = 0; index0 < 5; index0++) {
            for (int index1 = 0; index1 < 11; index1++) {
                if (r == 2 || r == 3) {
                    yoff = Math.sin(Math.toRadians(deg)) * curve;
                    if (Math.random() < (1) / ((float) 5)) {
                        world.addParticle(JujutsucraftaddonModParticleTypes.HAITI.get(), (x - r * Math.sin(Math.toRadians(deg))), (y + yoff), (z + r * Math.cos(Math.toRadians(deg))), ((-0.1) * Math.sin(Math.toRadians(deg))), 0,
                                (0.1 * Math.cos(Math.toRadians(deg))));
                    } else {
                        world.addParticle(JujutsucraftaddonModParticleTypes.KAI.get(), (x - r * Math.sin(Math.toRadians(deg))), (y + yoff), (z + r * Math.cos(Math.toRadians(deg))), ((-0.1) * Math.sin(Math.toRadians(deg))), 0,
                                (0.1 * Math.cos(Math.toRadians(deg))));
                    }
                }
                deg = deg + 18;
            }
            if (r == 2 || r == 4) {
                deg = entity.getYRot() - 81;
            } else {
                deg = entity.getYRot() - 90;
            }
            r = r + 1;
        }
    }
}
