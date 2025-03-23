package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;

public class HidingOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        double speed = 0;
        double spread = 0;
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(120 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (!(entity == entityiterator)) {
                    if ((new Object() {
                        public String getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entityiterator.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getString("OWNER_UUID");
                        }
                    }.getValue()).equals(entity.getStringUUID())) {
                        if ((new Object() {
                            public String getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entityiterator.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getString("OWNER_UUID");
                            }
                        }.getValue()).equals(entity.getStringUUID())) {
                            {
                                Entity _ent = entity;
                                _ent.setYRot(entityiterator.getYRot());
                                _ent.setXRot(entityiterator.getXRot());
                                _ent.setYBodyRot(_ent.getYRot());
                                _ent.setYHeadRot(_ent.getYRot());
                                _ent.yRotO = _ent.getYRot();
                                _ent.xRotO = _ent.getXRot();
                                if (_ent instanceof LivingEntity _entity) {
                                    _entity.yBodyRotO = _entity.getYRot();
                                    _entity.yHeadRotO = _entity.getYRot();
                                }
                            }
                            {
                                Entity _ent = entity;
                                _ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()));
                                if (_ent instanceof ServerPlayer _serverPlayer)
                                    _serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
                            }
                        }
                    }
                }
            }
        }
    }
}
