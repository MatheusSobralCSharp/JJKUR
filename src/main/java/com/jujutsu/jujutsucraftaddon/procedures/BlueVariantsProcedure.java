package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class BlueVariantsProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel >= 5) {
            if (!entity.isShiftKeyDown()) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.BLUE.get().spawn(_serverLevel,
                            BlockPos.containing(
                                    (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                                    (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
                                    (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
                            MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BLUE_EFFECT.get(), -1, 1, false, false));
                        entity.getPersistentData().putDouble("NameRanged", Math.random());
                        entity.getPersistentData().putDouble("friend_num", Math.random());
                        (entitytospawn).getPersistentData().putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).getPersistentData().putDouble("NameRanged_ranged", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("NameRanged");
                            }
                        }.getValue()));
                        (entitytospawn).getPersistentData().putDouble("skill", 206);
                        (entitytospawn).getPersistentData().putDouble("cnt6", 5);
                        (entitytospawn).getPersistentData().putDouble("blue", 1);
                        (entitytospawn).getPersistentData().putBoolean("circle", true);
                        (entitytospawn).getPersistentData().putBoolean("Player", true);
                        (entitytospawn).getPersistentData().putBoolean("free", true);
                        (entitytospawn).getPersistentData().putBoolean("flag_start", true);
                        (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                        (entitytospawn).getPersistentData().putString("PlayerName", (entity.getStringUUID()));
                        ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(20);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0,
                                    false, false));
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
            } else {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.BLUE.get().spawn(_serverLevel, BlockPos.containing(x, (y + 30), z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BLUE_EFFECT.get(), -1, 1, false, false));
                        entity.getPersistentData().putDouble("NameRanged", Math.random());
                        entity.getPersistentData().putDouble("friend_num", Math.random());
                        (entitytospawn).getPersistentData().putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).getPersistentData().putDouble("NameRanged_ranged", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("NameRanged");
                            }
                        }.getValue()));
                        (entitytospawn).getPersistentData().putDouble("skill", 206);
                        (entitytospawn).getPersistentData().putDouble("cnt6", 5);
                        (entitytospawn).getPersistentData().putDouble("blue", 1);
                        (entitytospawn).getPersistentData().putBoolean("circle", false);
                        (entitytospawn).getPersistentData().putBoolean("Player", true);
                        (entitytospawn).getPersistentData().putBoolean("free", true);
                        (entitytospawn).getPersistentData().putBoolean("flag_start", true);
                        (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                        (entitytospawn).getPersistentData().putString("PlayerName", (entity.getStringUUID()));
                        ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(20);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0,
                                    false, false));
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
            }
        } else {
            if (!entity.isShiftKeyDown()) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.BLUE.get().spawn(_serverLevel,
                            BlockPos.containing(
                                    (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                                    (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
                                    (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
                            MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BLUE_EFFECT.get(), -1, 1, false, false));
                        entity.getPersistentData().putDouble("NameRanged", Math.random());
                        entity.getPersistentData().putDouble("friend_num", Math.random());
                        (entitytospawn).getPersistentData().putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).getPersistentData().putDouble("NameRanged_ranged", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("NameRanged");
                            }
                        }.getValue()));
                        (entitytospawn).getPersistentData().putDouble("skill", 206);
                        (entitytospawn).getPersistentData().putDouble("cnt6", 5);
                        (entitytospawn).getPersistentData().putBoolean("circle", true);
                        (entitytospawn).getPersistentData().putBoolean("Player", true);
                        (entitytospawn).getPersistentData().putBoolean("free", true);
                        (entitytospawn).getPersistentData().putBoolean("flag_start", true);
                        (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                        (entitytospawn).getPersistentData().putString("PlayerName", (entity.getStringUUID()));
                        ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(10);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0,
                                    false, false));
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
            } else {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.BLUE.get().spawn(_serverLevel, BlockPos.containing(x, (y + 30), z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BLUE_EFFECT.get(), -1, 1, false, false));
                        entity.getPersistentData().putDouble("NameRanged", Math.random());
                        entity.getPersistentData().putDouble("friend_num", Math.random());
                        (entitytospawn).getPersistentData().putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).getPersistentData().putDouble("NameRanged_ranged", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("NameRanged");
                            }
                        }.getValue()));
                        (entitytospawn).getPersistentData().putDouble("skill", 206);
                        (entitytospawn).getPersistentData().putDouble("cnt6", 5);
                        (entitytospawn).getPersistentData().putBoolean("circle", false);
                        (entitytospawn).getPersistentData().putBoolean("Player", true);
                        (entitytospawn).getPersistentData().putBoolean("free", true);
                        (entitytospawn).getPersistentData().putBoolean("flag_start", true);
                        (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                        (entitytospawn).getPersistentData().putString("PlayerName", (entity.getStringUUID()));
                        ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(10);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0,
                                    false, false));
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
            }
        }
    }
}
