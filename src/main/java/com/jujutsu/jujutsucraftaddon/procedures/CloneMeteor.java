package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.procedures.KeyStartTechniqueOnKeyPressedProcedure;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;

public class CloneMeteor {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
                    if (world instanceof ServerLevel _level) {
                        _level.sendParticles(JujutsucraftModParticleTypes.PARTICLE_BIG_SMOKE.get(), entityiterator.getX(), entityiterator.getY() + 1.0, entityiterator.getZ(), 3, 0.5, 1.0, 0.5, 0.0);
                    }
                    entityiterator.getPersistentData().putDouble("skill", 415.0);
                    KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entityiterator);
                }
            }
        }
        entity.getPersistentData().putDouble("skill", 0);
    }

}
