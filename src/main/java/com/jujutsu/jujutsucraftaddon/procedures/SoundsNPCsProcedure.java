package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import java.util.List;

public class SoundsNPCsProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_MOB_OSTS)) {
            if (sourceentity instanceof Monster) {
                if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).startsWith("jujutsucraft")) {
                    if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:eight_handled_swrod_divergent_sila_divine_general_mahoraga")) {
                        {
                            final Vec3 _center = new Vec3(x, y, z);
                            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                            for (Entity entityiterator : _entfound) {
                                if (entityiterator instanceof Monster) {
                                    if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals("jujutsucraft:sukuna")) {
                                        if (new Object() {
                                            public double getValue() {
                                                CompoundTag dataIndex = new CompoundTag();
                                                sourceentity.saveWithoutId(dataIndex);
                                                return dataIndex.getCompound("ForgeData").getDouble("Fight");
                                            }
                                        }.getValue() == 0) {
                                            if (world instanceof Level _level) {
                                                if (_level.isClientSide()) {
                                                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavsmaho")), SoundSource.NEUTRAL, 1, 1, false);
                                                }
                                            }
                                            {
                                                CompoundTag dataIndex = new CompoundTag();
                                                sourceentity.saveWithoutId(dataIndex);
                                                dataIndex.getCompound("ForgeData").putDouble("Fight", 1);
                                                sourceentity.load(dataIndex);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:fushiguro_toji")) {
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("Fight");
                            }
                        }.getValue() == 0) {
                            if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:geto_suguru")) {
                                if (world instanceof Level _level) {
                                    if (_level.isClientSide()) {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:getovstoji")), SoundSource.NEUTRAL, 1, 1, false);
                                    }
                                }
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("Fight", 1);
                                    sourceentity.load(dataIndex);
                                }
                            }
                        }
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("Fight");
                            }
                        }.getValue() == 0) {
                            if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:gojo_satoru_school_days")) {
                                if (world instanceof Level _level) {
                                    if (_level.isClientSide()) {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:gojovstoji")), SoundSource.NEUTRAL, 1, 1, false);
                                    }
                                }
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("Fight", 1);
                                    sourceentity.load(dataIndex);
                                }
                            }
                        }
                    } else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:sukuna_fushiguro")) {
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("Fight");
                            }
                        }.getValue() == 0) {
                            if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:gojo_satoru")) {
                                if (world instanceof Level _level) {
                                    if (_level.isClientSide()) {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:judas")), SoundSource.NEUTRAL, 1, 1, false);
                                    }
                                }
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("Fight", 1);
                                    sourceentity.load(dataIndex);
                                }
                            }
                        }
                    } else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:nanami_kento")) {
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("Fight");
                            }
                        }.getValue() == 0) {
                            if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:mahito")) {
                                if (world instanceof Level _level) {
                                    if (_level.isClientSide()) {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:nanami")), SoundSource.NEUTRAL, 1, 1, false);
                                    }
                                }
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("Fight", 1);
                                    sourceentity.load(dataIndex);
                                }
                            }
                        }
                    } else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:itadori_yuji_shibuya")) {
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("Fight");
                            }
                        }.getValue() == 0) {
                            if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:mahito")) {
                                if (world instanceof Level _level) {
                                    if (_level.isClientSide()) {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:itadorivsmahito")), SoundSource.NEUTRAL, 1, 1, false);
                                    }
                                }
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("Fight", 1);
                                    sourceentity.load(dataIndex);
                                }
                            }
                        }
                    } else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:itadori_yuji_shibuya")) {
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("Fight");
                            }
                        }.getValue() == 0) {
                            if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:choso")) {
                                if (world instanceof Level _level) {
                                    if (_level.isClientSide()) {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:chosovsyuuuji")), SoundSource.NEUTRAL, 1, 1, false);
                                    }
                                }
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("Fight", 1);
                                    sourceentity.load(dataIndex);
                                }
                            }
                        }
                    } else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:fushiguro_toji_bug")) {
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("Fight");
                            }
                        }.getValue() == 0) {
                            if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:dagon_2")) {
                                if (world instanceof Level _level) {
                                    if (_level.isClientSide()) {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:tojivsdagonvsyujivsmahito")), SoundSource.NEUTRAL, 1, 1, false);
                                    }
                                }
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("Fight", 1);
                                    sourceentity.load(dataIndex);
                                }
                            }
                        }
                    } else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:sukuna")) {
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("Fight");
                            }
                        }.getValue() == 0) {
                            if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:jogo")) {
                                if (world instanceof Level _level) {
                                    if (_level.isClientSide()) {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavsjogo")), SoundSource.NEUTRAL, 1, 1, false);
                                    }
                                }
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("Fight", 1);
                                    sourceentity.load(dataIndex);
                                }
                            }
                        }
                    } else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:okkotsu_yuta")) {
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("Fight");
                            }
                        }.getValue() == 0) {
                            if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:geto_suguru_curse_user")) {
                                if (world instanceof Level _level) {
                                    if (_level.isClientSide()) {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:yutavsgeto")), SoundSource.NEUTRAL, 1, 1, false);
                                    }
                                }
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("Fight", 1);
                                    sourceentity.load(dataIndex);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
