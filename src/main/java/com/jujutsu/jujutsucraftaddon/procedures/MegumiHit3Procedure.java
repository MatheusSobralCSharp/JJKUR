package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class MegumiHit3Procedure {
    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if (Math.random() <= 0.02) {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique14");
                }
            }.getValue() < 0) {
                if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:mahoraga_wheel_helmet")) {
                    if (world instanceof ServerLevel _serverLevel) {
                        Entity entitytospawn = JujutsucraftModEntities.EIGHT_HANDLED_SWROD_DIVERGENT_SILA_DIVINE_GENERAL_MAHORAGA.get().spawn(_serverLevel, BlockPos.containing((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ())),
                                MobSpawnType.MOB_SUMMONED);
                        if (entitytospawn != null) {
                            entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                            CompoundTag dataIndex1 = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex1);
                            dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                            (entitytospawn).load(dataIndex1);
                            CompoundTag dataIndex3 = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex3);
                            dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex2 = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex2);
                                    return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
                                }
                            }.getValue()));
                            (entitytospawn).load(dataIndex3);
                            if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1, false, false));
                            ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
                            if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                                _player.displayClientMessage(Component.literal("MAHORAGA!!!"), false);
                            _serverLevel.addFreshEntity(entitytospawn);
                        }
                    }
                }
            }
        }
        if (Math.random() < (1) / ((float) 50)) {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique13");
                }
            }.getValue() < 0) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.MERGED_BEAST_AGITO.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        CompoundTag dataIndex1 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex1);
                        dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                        (entitytospawn).load(dataIndex1);
                        CompoundTag dataIndex3 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex3);
                        dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex2 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex2);
                                return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex3);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1, false, false));
                        ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Nue Kon - Kango Ju Agito..."), false);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
            }
        } else if (Math.random() < (1) / ((float) 45)) {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique4");
                }
            }.getValue() < 0) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.NUE.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        CompoundTag dataIndex1 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex1);
                        dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                        (entitytospawn).load(dataIndex1);
                        CompoundTag dataIndex3 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex3);
                        dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex2 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex2);
                                return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex3);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1, false, false));
                        ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(6);
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("NUE"), false);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
            }
        } else if (Math.random() < (1) / ((float) 40)) {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique10");
                }
            }.getValue() < 0) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.PIERCING_OX.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        CompoundTag dataIndex1 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex1);
                        dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                        (entitytospawn).load(dataIndex1);
                        CompoundTag dataIndex3 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex3);
                        dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex2 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex2);
                                return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex3);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1, false, false));
                        ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Kangyu.."), false);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
            }
        } else if (Math.random() < (1) / ((float) 35)) {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique6");
                }
            }.getValue() < 0) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.TOAD.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        CompoundTag dataIndex1 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex1);
                        dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                        (entitytospawn).load(dataIndex1);
                        CompoundTag dataIndex3 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex3);
                        dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex2 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex2);
                                return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex3);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1, false, false));
                        ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Gama.."), false);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
            }
        } else if (Math.random() < (1) / ((float) 30)) {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique8");
                }
            }.getValue() < 0) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.RABBIT_ESCAPE.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        CompoundTag dataIndex1 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex1);
                        dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                        (entitytospawn).load(dataIndex1);
                        CompoundTag dataIndex3 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex3);
                        dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex2 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex2);
                                return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex3);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1, false, false));
                        ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Datto"), false);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.RABBIT_ESCAPE.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        CompoundTag dataIndex1 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex1);
                        dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                        (entitytospawn).load(dataIndex1);
                        CompoundTag dataIndex3 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex3);
                        dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex2 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex2);
                                return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex3);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1, false, false));
                        ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
                        if (entity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Datto"), false);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.RABBIT_ESCAPE.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        CompoundTag dataIndex1 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex1);
                        dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                        (entitytospawn).load(dataIndex1);
                        CompoundTag dataIndex3 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex3);
                        dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex2 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex2);
                                return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex3);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1, false, false));
                        ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
                        if (entity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Datto"), false);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.RABBIT_ESCAPE.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        CompoundTag dataIndex1 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex1);
                        dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                        (entitytospawn).load(dataIndex1);
                        CompoundTag dataIndex3 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex3);
                        dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex2 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex2);
                                return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex3);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1, false, false));
                        ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
                        if (entity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Datto"), false);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.RABBIT_ESCAPE.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        CompoundTag dataIndex1 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex1);
                        dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                        (entitytospawn).load(dataIndex1);
                        CompoundTag dataIndex3 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex3);
                        dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex2 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex2);
                                return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex3);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1, false, false));
                        ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
                        if (entity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Datto"), false);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.RABBIT_ESCAPE.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        CompoundTag dataIndex1 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex1);
                        dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                        (entitytospawn).load(dataIndex1);
                        CompoundTag dataIndex3 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex3);
                        dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex2 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex2);
                                return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex3);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1, false, false));
                        ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
                        if (entity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Datto"), false);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
            }
        } else if (Math.random() < (1) / ((float) 27)) {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique11");
                }
            }.getValue() < 0) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.TIGER_FUNERAL.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        CompoundTag dataIndex1 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex1);
                        dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                        (entitytospawn).load(dataIndex1);
                        CompoundTag dataIndex3 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex3);
                        dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex2 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex2);
                                return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex3);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1, false, false));
                        ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
                        if (entity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal(" Koso!"), false);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
            }
        } else if (Math.random() < (1) / ((float) 25)) {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique5");
                }
            }.getValue() < 0) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.GREAT_SERPENT.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        CompoundTag dataIndex1 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex1);
                        dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                        (entitytospawn).load(dataIndex1);
                        CompoundTag dataIndex3 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex3);
                        dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex2 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex2);
                                return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex3);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1, false, false));
                        ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(6);
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Orochi"), false);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
            }
        } else if (Math.random() < (1) / ((float) 20)) {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique7");
                }
            }.getValue() < 0) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.MAX_ELEPHANT.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        CompoundTag dataIndex1 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex1);
                        dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                        (entitytospawn).load(dataIndex1);
                        CompoundTag dataIndex3 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex3);
                        dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex2 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex2);
                                return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex3);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1, false, false));
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putBoolean("flag_fall", true);
                            (entitytospawn).load(dataIndex);
                        }
                        ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(6);
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("BANSHO!"), false);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
            }
        } else if (Math.random() < (1) / ((float) 15)) {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique3");
                }
            }.getValue() < 0) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.DIVINE_DOG_TOTALITY.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        CompoundTag dataIndex1 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex1);
                        dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                        (entitytospawn).load(dataIndex1);
                        CompoundTag dataIndex3 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex3);
                        dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex2 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex2);
                                return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex3);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1, false, false));
                        ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Gyokuken Kon.."), false);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
            }
        } else if (Math.random() < (1) / ((float) 10)) {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique2");
                }
            }.getValue() < 0) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.DIVINE_DOG_WHITE.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        CompoundTag dataIndex1 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex1);
                        dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                        (entitytospawn).load(dataIndex1);
                        CompoundTag dataIndex3 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex3);
                        dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex2 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex2);
                                return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex3);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1, false, false));
                        ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Gyokuken.."), false);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
            }
        } else if (Math.random() < (1) / ((float) 5)) {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique1");
                }
            }.getValue() < 0) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.DIVINE_DOG_BLACK.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        CompoundTag dataIndex1 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex1);
                        dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                        (entitytospawn).load(dataIndex1);
                        CompoundTag dataIndex3 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex3);
                        dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex2 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex2);
                                return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex3);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1, false, false));
                        ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Gyokuken.."), false);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
            }
        }
    }
}
