package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class RedGojoProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        double x_pos = 0;
        double y_pos = 0;
        double z_pos = 0;
        double pitch = 0;
        double yaw = 0;
        entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
        entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
        entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
        entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
        yaw = Math.toRadians(entity.getYRot() + 90.0F);
        pitch = Math.toRadians(entity.getXRot());
        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel <= 3) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.RED.get().spawn(_serverLevel,
                        BlockPos.containing(
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
                        MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
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
                    (entitytospawn).getPersistentData().putDouble("skill", 207);
                    (entitytospawn).getPersistentData().putDouble("cnt6", 6);
                    (entitytospawn).getPersistentData().putBoolean("Player", true);
                    (entitytospawn).getPersistentData().putBoolean("flag_start", true);
                    (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                    (entitytospawn).getPersistentData().putString("PlayerName", (entity.getStringUUID()));
                    ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(10);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(
                                new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
                    (entitytospawn).setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z())));
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.RED.get().spawn(_serverLevel,
                        BlockPos.containing(
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
                        MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
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
                    (entitytospawn).getPersistentData().putDouble("skill", 207);
                    (entitytospawn).getPersistentData().putDouble("cnt6", 6);
                    ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(10);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 10000,
                                ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier() : 0)
                                        + 2,
                                false, false));
                    (entitytospawn).getPersistentData().putBoolean("PRES_Z", true);
                    (entitytospawn).getPersistentData().putBoolean("Player", true);
                    (entitytospawn).getPersistentData().putBoolean("flag_start", true);
                    (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                    (entitytospawn).getPersistentData().putString("PlayerName", (entity.getStringUUID()));
                    ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(10);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(
                                new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
                    (entitytospawn).setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z())));
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.RED.get().spawn(_serverLevel,
                        BlockPos.containing(
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
                        MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
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
                    (entitytospawn).getPersistentData().putDouble("skill", 207);
                    (entitytospawn).getPersistentData().putDouble("cnt6", 6);
                    (entitytospawn).getPersistentData().putBoolean("Player", true);
                    (entitytospawn).getPersistentData().putBoolean("flag_start", true);
                    (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                    (entitytospawn).getPersistentData().putString("PlayerName", (entity.getStringUUID()));
                    ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(10);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 10000,
                                ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier() : 0)
                                        + 2,
                                false, false));
                    (entitytospawn).getPersistentData().putBoolean("PRESS_Z", true);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(
                                new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
                    (entitytospawn).setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z())));
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.RED.get().spawn(_serverLevel,
                        BlockPos.containing(
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
                        MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
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
                    (entitytospawn).getPersistentData().putDouble("skill", 207);
                    (entitytospawn).getPersistentData().putDouble("cnt6", 6);
                    (entitytospawn).getPersistentData().putBoolean("Player", true);
                    (entitytospawn).getPersistentData().putBoolean("flag_start", true);
                    (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                    (entitytospawn).getPersistentData().putBoolean("PRESS_Z", true);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 10000,
                                ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier() : 0)
                                        + 2,
                                false, false));
                    (entitytospawn).getPersistentData().putString("PlayerName", (entity.getStringUUID()));
                    ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(10);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(
                                new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
                    (entitytospawn).setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z())));
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.RED.get().spawn(_serverLevel,
                        BlockPos.containing(
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
                        MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
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
                    (entitytospawn).getPersistentData().putDouble("skill", 207);
                    (entitytospawn).getPersistentData().putDouble("cnt6", 6);
                    (entitytospawn).getPersistentData().putBoolean("Player", true);
                    (entitytospawn).getPersistentData().putBoolean("flag_start", true);
                    (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                    (entitytospawn).getPersistentData().putString("PlayerName", (entity.getStringUUID()));
                    ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(10);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(
                                new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
                    (entitytospawn).getPersistentData().putBoolean("PRESS_Z", true);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 10000,
                                ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier() : 0)
                                        + 2,
                                false, false));
                    (entitytospawn).setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z())));
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.RED.get().spawn(_serverLevel,
                        BlockPos.containing(
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
                        MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
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
                    (entitytospawn).getPersistentData().putDouble("skill", 207);
                    (entitytospawn).getPersistentData().putDouble("cnt6", 6);
                    (entitytospawn).getPersistentData().putBoolean("Player", true);
                    (entitytospawn).getPersistentData().putBoolean("PRESS_Z", true);
                    (entitytospawn).getPersistentData().putBoolean("flag_start", true);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 10000,
                                ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier() : 0)
                                        + 2,
                                false, false));
                    (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                    (entitytospawn).getPersistentData().putString("PlayerName", (entity.getStringUUID()));
                    ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(10);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(
                                new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
                    (entitytospawn).setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z())));
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        }
    }
}
