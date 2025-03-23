package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;

public class CleaveWebOnInitialEntitySpawnProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("UseCursedTechnique");
            }
        }.getValue() == 0) {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("UseCursedTechnique", 1);
                entity.load(dataIndex);
            }
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 254, false, false));
        }
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if ((new Object() {
                    public boolean getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entityiterator.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getBoolean("FlagSukuna");
                    }
                }.getValue())) {
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entityiterator.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        entity.load(dataIndex);
                    }
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entityiterator.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        entity.load(dataIndex);
                    }
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entityiterator.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        entity.load(dataIndex);
                    }
                    if (entity instanceof TamableAnimal _toTame && entityiterator instanceof Player _owner)
                        _toTame.tame(_owner);
                    if (entityiterator instanceof TamableAnimal _toTame && entity instanceof Player _owner)
                        _toTame.tame(_owner);
                }
            }
        }
    }
}
