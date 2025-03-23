package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;

public class ClonesAIGeneralProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof CloneEntity || entity instanceof FakeClonesEntity) {
            if (entity.getPersistentData().getDouble("Tagged") > 0) {
                if (entity.getPersistentData().getDouble("skill") == 0) {
                    if (Math.random() <= 0.5) {
                        if (entity.getPersistentData().getDouble("brokenBrain") <= 1) {
                            if (entity.getPersistentData().getDouble("skill_domain") == 0) {
                                {
                                    final Vec3 _center = new Vec3(x, y, z);
                                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                                            .toList();
                                    for (Entity entityiterator : _entfound) {
                                        if (entityiterator == entity) {
                                            entity.getPersistentData().putDouble("skill", (100 * new Object() {
                                                public double getValue() {
                                                    CompoundTag dataIndex = new CompoundTag();
                                                    entity.saveWithoutId(dataIndex);
                                                    return dataIndex.getCompound("ForgeData").getDouble("Tagged");
                                                }
                                            }.getValue() + Mth.nextInt(RandomSource.create(), 0, 20)));
                                        } else {
                                            entity.getPersistentData().putDouble("skill", (100 * new Object() {
                                                public double getValue() {
                                                    CompoundTag dataIndex = new CompoundTag();
                                                    entity.saveWithoutId(dataIndex);
                                                    return dataIndex.getCompound("ForgeData").getDouble("Tagged");
                                                }
                                            }.getValue() + Mth.nextInt(RandomSource.create(), 0, 19)));
                                        }
                                    }
                                }
                            } else {
                                entity.getPersistentData().putDouble("skill", (100 * new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex = new CompoundTag();
                                        entity.saveWithoutId(dataIndex);
                                        return dataIndex.getCompound("ForgeData").getDouble("Tagged");
                                    }
                                }.getValue() + Mth.nextInt(RandomSource.create(), 0, 19)));
                            }
                        } else {
                            entity.getPersistentData().putDouble("skill", (100 * new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("Tagged");
                                }
                            }.getValue() + Mth.nextInt(RandomSource.create(), 0, 19)));
                        }
                    }
                }
            } else {
                ClonesDongProcedure.execute(entity);
                if (entity.getPersistentData().getDouble("skill") == 0) {
                    if (Math.random() <= 0.5) {
                        if (entity.getPersistentData().getDouble("brokenBrain") <= 1) {
                            if (entity.getPersistentData().getDouble("skill_domain") == 0) {
                                {
                                    final Vec3 _center = new Vec3(x, y, z);
                                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                                            .toList();
                                    for (Entity entityiterator : _entfound) {
                                        if (Math.random() <= 0.5) {
                                            if (entityiterator == entity) {
                                                entity.getPersistentData().putDouble("skill", (100 + Mth.nextInt(RandomSource.create(), 0, 20)));
                                            } else {
                                                entity.getPersistentData().putDouble("skill", (100 + Mth.nextInt(RandomSource.create(), 0, 19)));
                                            }
                                        } else {
                                            if (entityiterator == entity) {
                                                entity.getPersistentData().putDouble("skill", (600 + Mth.nextInt(RandomSource.create(), 0, 20)));
                                            } else {
                                                entity.getPersistentData().putDouble("skill", (600 + Mth.nextInt(RandomSource.create(), 0, 19)));
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (Math.random() <= 0.5) {
                                    entity.getPersistentData().putDouble("skill", (100 + Mth.nextInt(RandomSource.create(), 0, 19)));
                                } else {
                                    entity.getPersistentData().putDouble("skill", (600 + Mth.nextInt(RandomSource.create(), 0, 19)));
                                }
                            }
                        } else {
                            if (Math.random() <= 0.5) {
                                entity.getPersistentData().putDouble("skill", (100 + Mth.nextInt(RandomSource.create(), 0, 19)));
                            } else {
                                entity.getPersistentData().putDouble("skill", (600 + Mth.nextInt(RandomSource.create(), 0, 19)));
                            }
                        }
                    }
                }
            }
        }
        if (entity instanceof UiUiEntity) {
            if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == null)) {
                if (entity.getPersistentData().getDouble("skill") == 0) {
                    if (Math.random() <= 0.5) {
                        if (entity.getPersistentData().getDouble("brokenBrain") <= 1) {
                            if (entity.getPersistentData().getDouble("skill_domain") == 0) {
                                {
                                    final Vec3 _center = new Vec3(x, y, z);
                                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                                            .toList();
                                    for (Entity entityiterator : _entfound) {
                                        if (entityiterator == entity) {
                                            entity.getPersistentData().putDouble("skill", (100 * new Object() {
                                                public double getValue() {
                                                    CompoundTag dataIndex = new CompoundTag();
                                                    entity.saveWithoutId(dataIndex);
                                                    return dataIndex.getCompound("ForgeData").getDouble("Tagged");
                                                }
                                            }.getValue() + Mth.nextInt(RandomSource.create(), 0, 3)));
                                        } else {
                                            entity.getPersistentData().putDouble("skill", (100 * new Object() {
                                                public double getValue() {
                                                    CompoundTag dataIndex = new CompoundTag();
                                                    entity.saveWithoutId(dataIndex);
                                                    return dataIndex.getCompound("ForgeData").getDouble("Tagged");
                                                }
                                            }.getValue() + Mth.nextInt(RandomSource.create(), 0, 3)));
                                        }
                                    }
                                }
                            } else {
                                entity.getPersistentData().putDouble("skill", (100 * new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex = new CompoundTag();
                                        entity.saveWithoutId(dataIndex);
                                        return dataIndex.getCompound("ForgeData").getDouble("Tagged");
                                    }
                                }.getValue() + Mth.nextInt(RandomSource.create(), 0, 3)));
                            }
                        } else {
                            entity.getPersistentData().putDouble("skill", (100 * new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("Tagged");
                                }
                            }.getValue() + Mth.nextInt(RandomSource.create(), 0, 3)));
                        }
                    }
                }
            }
        }
        if (entity instanceof Shadow1Entity || entity instanceof IgrisEntity) {
            if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == null)) {
                if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SPEED) ? _livEnt.getEffect(MobEffects.MOVEMENT_SPEED).getAmplifier() : 0) < 10) {
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 10, false, false));
                }
                if (entity.getPersistentData().getDouble("skill") == 0) {
                    if (Math.random() <= 0.5) {
                        if (entity.getPersistentData().getDouble("brokenBrain") <= 1) {
                            if (entity.getPersistentData().getDouble("skill_domain") == 0) {
                                {
                                    final Vec3 _center = new Vec3(x, y, z);
                                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                                            .toList();
                                    for (Entity entityiterator : _entfound) {
                                        if (entityiterator == entity) {
                                            entity.getPersistentData().putDouble("skill", (100 * 16 + Mth.nextInt(RandomSource.create(), 0, 19)));
                                        } else {
                                            entity.getPersistentData().putDouble("skill", (100 * 16 + Mth.nextInt(RandomSource.create(), 0, 19)));
                                        }
                                    }
                                }
                            } else {
                                entity.getPersistentData().putDouble("skill", (100 * 16 + Mth.nextInt(RandomSource.create(), 0, 19)));
                            }
                        } else {
                            entity.getPersistentData().putDouble("skill", (100 * 16 + Mth.nextInt(RandomSource.create(), 0, 19)));
                        }
                    }
                }
            }
        } else if (entity instanceof CentipedeEntity) {
            if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == null)) {
                if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SPEED) ? _livEnt.getEffect(MobEffects.MOVEMENT_SPEED).getAmplifier() : 0) < 10) {
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 10, false, false));
                }
                if (entity.getPersistentData().getDouble("skill") == 0) {
                    if (Math.random() <= 0.5) {
                        if (entity.getPersistentData().getDouble("brokenBrain") <= 1) {
                            if (entity.getPersistentData().getDouble("skill_domain") == 0) {
                                {
                                    final Vec3 _center = new Vec3(x, y, z);
                                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                                            .toList();
                                    for (Entity entityiterator : _entfound) {
                                        if (entityiterator == entity) {
                                            entity.getPersistentData().putDouble("skill", (100 * 4 + Mth.nextInt(RandomSource.create(), 0, 19)));
                                        } else {
                                            entity.getPersistentData().putDouble("skill", (100 * 4 + Mth.nextInt(RandomSource.create(), 0, 19)));
                                        }
                                    }
                                }
                            } else {
                                entity.getPersistentData().putDouble("skill", (100 * 4 + Mth.nextInt(RandomSource.create(), 0, 19)));
                            }
                        } else {
                            entity.getPersistentData().putDouble("skill", (100 * 4 + Mth.nextInt(RandomSource.create(), 0, 19)));
                        }
                    }
                }
            }
        }
        if (entity instanceof ErroEntity) {
            if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SPEED) ? _livEnt.getEffect(MobEffects.MOVEMENT_SPEED).getAmplifier() : 0) < 10) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 10, false, false));
            }
            if (entity.getPersistentData().getDouble("skill") == 0) {
                if (Math.random() <= 0.5) {
                    if (entity.getPersistentData().getDouble("brokenBrain") <= 1) {
                        if (entity.getPersistentData().getDouble("Tagged") != 21) {
                            if (entity.getPersistentData().getDouble("skill_domain") == 0) {
                                {
                                    final Vec3 _center = new Vec3(x, y, z);
                                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                                            .toList();
                                    for (Entity entityiterator : _entfound) {
                                        if (entityiterator == entity) {
                                            entity.getPersistentData().putDouble("skill", (100 + Mth.nextInt(RandomSource.create(), 0, 20)));
                                        } else {
                                            entity.getPersistentData().putDouble("skill", (100 + Mth.nextInt(RandomSource.create(), 0, 19)));
                                        }
                                    }
                                }
                            } else {
                                if (Math.random() <= 0.5) {
                                    entity.getPersistentData().putDouble("skill", (100 + Mth.nextInt(RandomSource.create(), 0, 19)));
                                } else {
                                    entity.getPersistentData().putDouble("skill", (100 * new Object() {
                                        public double getValue() {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            return dataIndex.getCompound("ForgeData").getDouble("Tagged");
                                        }
                                    }.getValue() + Mth.nextInt(RandomSource.create(), 0, 19)));
                                }
                            }
                        } else {
                            entity.getPersistentData().putDouble("skill", (100 + Mth.nextInt(RandomSource.create(), 1, 7)));
                        }
                    } else {
                        entity.getPersistentData().putDouble("skill", (100 + Mth.nextInt(RandomSource.create(), 0, 19)));
                    }
                }
            }
        }
    }
}
