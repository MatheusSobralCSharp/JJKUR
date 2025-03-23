package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;

public class Tsukumo1Procedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("skill");
            }
        }.getValue() > 0) {
            {
                final Vec3 _center = new Vec3(x, y, z);
                List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                for (Entity entityiterator : _entfound) {
                    if (!(entity == entityiterator)) {
                        {
                            Entity _ent = entityiterator;
                            _ent.teleportTo(x, (y + 1), z);
                            if (_ent instanceof ServerPlayer _serverPlayer)
                                _serverPlayer.connection.teleport(x, (y + 1), z, _ent.getYRot(), _ent.getXRot());
                        }
                    }
                }
            }
        }
    }
}
