package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;

public class UraumeChargeProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        double sx = 0;
        double sy = 0;
        double sz = 0;
        double xRadius = 0;
        double loop = 0;
        double zRadius = 0;
        double particleAmount = 0;
        sx = -6;
        for (int index0 = 0; index0 < 6; index0++) {
            sy = -3;
            for (int index1 = 0; index1 < 6; index1++) {
                sz = -6;
                for (int index2 = 0; index2 < 6; index2++) {
                    if (!((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.BEDROCK)) {
                        if (world instanceof ServerLevel _level)
                            _level.sendParticles(ParticleTypes.SNOWFLAKE, (x + sx), (y - 2), (z + sz), 0, 0, 0, 0, 1);
                        if (world instanceof ServerLevel _level)
                            _level.sendParticles(JujutsucraftModParticleTypes.PARTICLE_ICE.get(), (x + sx), (y + sy), (z + sz), 1, 0, 0, 0, 1);
                    }
                    sz = sz + 1;
                }
                sy = sy + 1;
            }
            sx = sx + 1;
        }
        loop = 0;
        particleAmount = 120;
        xRadius = 10;
        zRadius = 10;
        while (loop < particleAmount) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(ParticleTypes.SNOWFLAKE, (x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), y, (z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 1, 0, 0.05, 0, 1);
            loop = loop + 1;
        }
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (!(entityiterator == entity)) {
                    entityiterator.setTicksFrozen(40);
                }
            }
        }
    }
}
