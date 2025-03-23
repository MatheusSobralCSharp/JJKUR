package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import java.util.List;

public class RikaSpawnedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
        if (sourceentity == null)
            return;
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (!(entityiterator == sourceentity)) {
                    if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals("jujutsucraft:rika_2") && (new Object() {
                        public String getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entityiterator.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getString("OWNER_UUID");
                        }
                    }.getValue()).equals(sourceentity.getStringUUID())) {
                        if (!(entityiterator instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(MobEffects.REGENERATION))) {
                            if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100000, 2, false, false));
                        }
                        if (!(new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("friend_num_worker");
                            }
                        }.getValue() == new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entityiterator.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("friend_num_worker");
                            }
                        }.getValue())) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                entityiterator.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex = new CompoundTag();
                                        sourceentity.saveWithoutId(dataIndex);
                                        return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                    }
                                }.getValue()));
                                entityiterator.load(dataIndex);
                            }
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                entityiterator.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex = new CompoundTag();
                                        sourceentity.saveWithoutId(dataIndex);
                                        return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                    }
                                }.getValue()));
                                entityiterator.load(dataIndex);
                            }
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                entityiterator.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex = new CompoundTag();
                                        sourceentity.saveWithoutId(dataIndex);
                                        return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                    }
                                }.getValue()));
                                entityiterator.load(dataIndex);
                            }
                        }
                    }
                }
            }
        }
    }
}
