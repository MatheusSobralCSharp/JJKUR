package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;

public class GetoReleaseProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 16) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.MERGED_BEAST_AGITO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(
                                new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 2, false, false));
                    (entitytospawn).getPersistentData().putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _livingEntity19 && _livingEntity19.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                        _livingEntity19.getAttribute(Attributes.MAX_HEALTH).setBaseValue(600);
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 12) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.KASHIMO_HAJIME.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(
                                new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 2, false, false));
                    (entitytospawn).getPersistentData().putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _livingEntity40 && _livingEntity40.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                        _livingEntity40.getAttribute(Attributes.MAX_HEALTH).setBaseValue(600);
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.URO_TAKAKO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                        (entitytospawn).load(dataIndex);
                    }
                    (entitytospawn).getPersistentData().putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(
                                new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 2, false, false));
                    if ((entitytospawn) instanceof LivingEntity _livingEntity60 && _livingEntity60.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                        _livingEntity60.getAttribute(Attributes.MAX_HEALTH).setBaseValue(600);
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.YOROZU.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(
                                new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
                    (entitytospawn).getPersistentData().putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 2, false, false));
                    if ((entitytospawn) instanceof LivingEntity _livingEntity80 && _livingEntity80.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                        _livingEntity80.getAttribute(Attributes.MAX_HEALTH).setBaseValue(600);
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 18) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.JOGO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(
                                new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
                    (entitytospawn).getPersistentData().putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 2, false, false));
                    if ((entitytospawn) instanceof LivingEntity _livingEntity101 && _livingEntity101.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                        _livingEntity101.getAttribute(Attributes.MAX_HEALTH).setBaseValue(600);
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.MAHITO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(
                                new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
                    (entitytospawn).getPersistentData().putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 2, false, false));
                    if ((entitytospawn) instanceof LivingEntity _livingEntity121 && _livingEntity121.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                        _livingEntity121.getAttribute(Attributes.MAX_HEALTH).setBaseValue(600);
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.DAGON.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(
                                new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
                    (entitytospawn).getPersistentData().putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 2, false, false));
                    if ((entitytospawn) instanceof LivingEntity _livingEntity141 && _livingEntity141.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                        _livingEntity141.getAttribute(Attributes.MAX_HEALTH).setBaseValue(600);
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.HANAMI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(
                                new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
                    (entitytospawn).getPersistentData().putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 2, false, false));
                    if ((entitytospawn) instanceof LivingEntity _livingEntity161 && _livingEntity161.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                        _livingEntity161.getAttribute(Attributes.MAX_HEALTH).setBaseValue(600);
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        }
    }
}
