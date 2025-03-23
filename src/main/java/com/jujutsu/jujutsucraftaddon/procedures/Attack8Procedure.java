package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.entity.*;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Attack8Procedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if (entity instanceof LivingEntity) {
            if ((Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString()).startsWith("jujutsucraft")) {
                if ((Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString()).equals("jujutsucraft:eight_handled_swrod_divergent_sila_divine_general_mahoraga")) {
                    {
                        final Vec3 _center = new Vec3(x, y, z);
                        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                        for (Entity entityiterator : _entfound) {
                            if (entityiterator instanceof Monster) {
                                if (sourceentity.getPersistentData().getDouble("Fight") == 0) {
                                    if (entityiterator instanceof SukunaEntity) {
                                        if (world instanceof Level _level) {
                                            if (!_level.isClientSide()) {
                                                _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavsmaho")), SoundSource.MUSIC, 1, 1);
                                            } else {
                                                _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavsmaho")), SoundSource.MUSIC, 1, 1, false);
                                            }
                                        }
                                        sourceentity.getPersistentData().putDouble("Fight", 1);
                                    }
                                }
                            }
                        }
                    }
                } else if (sourceentity instanceof FushiguroTojiEntity) {
                    if (sourceentity.getPersistentData().getDouble("Fight") == 0) {
                        if (entity instanceof GetoSuguruEntity) {
                            if (world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:getovstoji")), SoundSource.MUSIC, 1, 1);
                                } else {
                                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:getovstoji")), SoundSource.MUSIC, 1, 1, false);
                                }
                            }
                            sourceentity.getPersistentData().putDouble("Fight", 1);
                        }
                    }
                    if (sourceentity.getPersistentData().getDouble("Fight") == 0) {
                        if (entity instanceof GojoSatoruSchoolDaysEntity) {
                            if (world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:gojovstoji")), SoundSource.MUSIC, 1, 1);
                                } else {
                                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:gojovstoji")), SoundSource.MUSIC, 1, 1, false);
                                }
                            }
                            sourceentity.getPersistentData().putDouble("Fight", 1);
                        }
                    }
                } else if (sourceentity instanceof NanamiKentoEntity) {
                    if (sourceentity.getPersistentData().getDouble("Fight") == 0) {
                        if (entity instanceof MahitoEntity) {
                            if (world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:nanami")), SoundSource.MUSIC, 1, 1);
                                } else {
                                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:nanami")), SoundSource.MUSIC, 1, 1, false);
                                }
                            }
                            sourceentity.getPersistentData().putDouble("Fight", 1);
                        }
                    }
                } else if (sourceentity instanceof ItadoriYujiShibuyaEntity) {
                    if (sourceentity.getPersistentData().getDouble("Fight") == 0) {
                        if (entity instanceof MahitoEntity) {
                            if (world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:itadorivsmahito")), SoundSource.MUSIC, 1, 1);
                                } else {
                                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:itadorivsmahito")), SoundSource.MUSIC, 1, 1, false);
                                }
                            }
                            sourceentity.getPersistentData().putDouble("Fight", 1);
                        }
                    }
                } else if (sourceentity instanceof ItadoriYujiShibuyaEntity) {
                    if (sourceentity.getPersistentData().getDouble("Fight") == 0) {
                        if (entity instanceof ChosoEntity) {
                            if (world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:chosovsyuuuji")), SoundSource.MUSIC, 1, 1);
                                } else {
                                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:chosovsyuuuji")), SoundSource.MUSIC, 1, 1, false);
                                }
                            }
                            sourceentity.getPersistentData().putDouble("Fight", 1);
                        }
                    }
                } else if (sourceentity instanceof FushiguroTojiBugEntity) {
                    if (sourceentity.getPersistentData().getDouble("Fight") == 0) {
                        if (entity instanceof DagonEntity) {
                            if (world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:tojivsdagonvsyujivsmahito")), SoundSource.MUSIC, 1, 1);
                                } else {
                                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:tojivsdagonvsyujivsmahito")), SoundSource.MUSIC, 1, 1, false);
                                }
                            }
                            sourceentity.getPersistentData().putDouble("Fight", 1);
                        }
                    }
                } else if (sourceentity instanceof SukunaEntity) {
                    if (sourceentity.getPersistentData().getDouble("Fight") == 0) {
                        if (entity instanceof JogoEntity) {
                            if (world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavsjogo")), SoundSource.MUSIC, 1, 1);
                                } else {
                                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavsjogo")), SoundSource.MUSIC, 1, 1, false);
                                }
                            }
                            sourceentity.getPersistentData().putDouble("Fight", 1);
                        }
                    }
                } else if (sourceentity instanceof OkkotsuYutaEntity) {
                    if (sourceentity.getPersistentData().getDouble("Fight") == 0) {
                        if (entity instanceof GetoSuguruCurseUserEntity) {
                            if (world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:yutavsgeto")), SoundSource.MUSIC, 1, 1);
                                } else {
                                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:yutavsgeto")), SoundSource.MUSIC, 1, 1, false);
                                }
                            }
                            sourceentity.getPersistentData().putDouble("Fight", 1);
                        }
                    }
                }
            }
        }
    }
}
