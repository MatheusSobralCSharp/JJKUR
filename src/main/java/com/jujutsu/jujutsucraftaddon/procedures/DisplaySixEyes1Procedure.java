package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;

public class DisplaySixEyes1Procedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (world.getEntitiesOfClass(LivingEntity.class,
                        AABB.ofSize(
                                new Vec3((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
                                4, 4, 4),
                        e -> true).stream().sorted(new Object() {
                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                    }
                }.compareDistOf((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
                .findFirst().orElse(null) instanceof LivingEntity) {
            if (!(world.getEntitiesOfClass(LivingEntity.class,
                            AABB.ofSize(
                                    new Vec3((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                                            (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
                                            (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
                                    4, 4, 4),
                            e -> true).stream().sorted(new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }.compareDistOf((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                            (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
                            (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
                    .findFirst().orElse(null) == entity)) {
                if ((((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(
                                new Vec3((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
                                4, 4, 4), e -> true).stream().sorted(new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }.compareDistOf(
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
                        .findFirst().orElse(null)) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) > 0) {
                    {
                        String _setval = "Power: " + (((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())), 4,
                                        4, 4), e -> true).stream().sorted(new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                }.compareDistOf(
                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos()
                                                .getX()),
                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos()
                                                .getY()),
                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos()
                                                .getZ())))
                                .findFirst().orElse(null)) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0);
                        entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.DataSixEyesOne = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                }
                if (!(world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(
                                new Vec3((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
                                4, 4, 4), e -> true).stream().sorted(new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }.compareDistOf(
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                                (entity.level().clip(
                                        new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
                        .findFirst().orElse(null) instanceof Player
                        || world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())), 4,
                                4, 4), e -> true).stream().sorted(new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }.compareDistOf(
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos()
                                        .getX()),
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos()
                                        .getY()),
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos()
                                        .getZ())))
                        .findFirst().orElse(null) instanceof ServerPlayer)) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
                                                    (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                                                    (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
                                                    (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
                                            4, 4, 4), e -> true).stream().sorted(new Object() {
                                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                        }
                                    }.compareDistOf(
                                            (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos()
                                                    .getX()),
                                            (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos()
                                                    .getY()),
                                            (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos()
                                                    .getZ())))
                                    .findFirst().orElse(null).saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("skill");
                        }
                    }.getValue() > 10) {
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 1600, 1607)) {
                            {
                                String _setval = "Technique: " + "Mahorga CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 200, 220)) {
                            {
                                String _setval = "Technique: " + "Gojo CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 2100, 2102)) {
                            {
                                String _setval = "Technique: " + "Itadori CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 600, 620)) {
                            {
                                String _setval = "Technique: " + "Fushiguro CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 300, 320)) {
                            {
                                String _setval = "Technique: " + "Inumaki CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), -100, -96)) {
                            {
                                String _setval = "Technique: " + "Maki CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 500, 520)) {
                            {
                                String _setval = "Technique: " + "Okkotsu CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 2900, 2920)) {
                            {
                                String _setval = "Technique: " + "Hakari CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 2000, 2020)) {
                            {
                                String _setval = "Technique: " + "Todo CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 1900, 1920)) {
                            {
                                String _setval = "Technique: " + "Naoya CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 2200, 2220)) {
                            {
                                String _setval = "Technique: " + "Jinichi CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 2600, 2620)) {
                            {
                                String _setval = "Technique: " + "Ogi CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 1300, 1320)) {
                            {
                                String _setval = "Technique: " + "Nanami CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 1100, 1120)) {
                            {
                                String _setval = "Technique: " + "Meimei CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 900, 920)) {
                            {
                                String _setval = "Technique: " + "Tsukumo CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 1800, 1820)) {
                            {
                                String _setval = "Technique: " + "Geto CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 3100, 3105)) {
                            {
                                String _setval = "Technique: " + "Kusakabe CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 2700, 2720)) {
                            {
                                String _setval = "Technique: " + "Higuruma CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 1200, 1220)) {
                            {
                                String _setval = "Technique: " + "Ishigori CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 700, 715)) {
                            {
                                String _setval = "Technique: " + "Kashimo CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 1700, 1715)) {
                            {
                                String _setval = "Technique: " + "Takaba CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 2800, 2820)) {
                            {
                                String _setval = "Technique: " + "Angel CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 3000, 3005)) {
                            {
                                String _setval = "Technique: " + "Miguel CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 100, 120)) {
                            {
                                String _setval = "Technique: " + "Sukuna CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 2400, 2420)) {
                            {
                                String _setval = "Technique: " + "Uraume CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 800, 820)) {
                            {
                                String _setval = "Technique: " + "Dagon CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 1400, 1420)) {
                            {
                                String _setval = "Technique: " + "Hanami CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 1500, 1520)) {
                            {
                                String _setval = "Technique: " + "Mahito CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 400, 420)) {
                            {
                                String _setval = "Technique: " + "Jogo CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 1000, 1020)) {
                            {
                                String _setval = "Technique: " + "Choso CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                world.getEntitiesOfClass(LivingEntity.class,
                                                AABB.ofSize(new Vec3(
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getX()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getY()),
                                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                        .getBlockPos().getZ())),
                                                        4, 4, 4),
                                                e -> true).stream().sorted(new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }.compareDistOf(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                        .getBlockPos().getZ())))
                                        .findFirst().orElse(null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == Mth.nextInt(RandomSource.create(), 2300, 2320)) {
                            {
                                String _setval = "Technique: " + "Kurourushi CT";
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.Technique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        }
                    }
                } else if (world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(
                                new Vec3((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
                                4, 4, 4), e -> true).stream().sorted(new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }.compareDistOf(
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                                (entity.level().clip(
                                        new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
                        .findFirst().orElse(null) instanceof Player
                        || world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())), 4,
                                4, 4), e -> true).stream().sorted(new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }.compareDistOf(
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos()
                                        .getX()),
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos()
                                        .getY()),
                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos()
                                        .getZ())))
                        .findFirst().orElse(null) instanceof ServerPlayer) {
                    {
                        String _setval = (world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
                                                (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())), 4,
                                        4, 4), e -> true).stream().sorted(new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                }.compareDistOf(
                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos()
                                                .getX()),
                                        (entity.level().clip(
                                                new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos()
                                                .getZ())))
                                .findFirst().orElse(null).getDisplayName().getString() + " Technique: ")
                                + (((Entity) world.getEntitiesOfClass(LivingEntity.class,
                                        AABB.ofSize(new Vec3(
                                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                .getBlockPos().getX()),
                                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                .getBlockPos().getY()),
                                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                                .getBlockPos().getZ())),
                                                4, 4, 4),
                                        e -> true).stream().sorted(new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                    }
                                }.compareDistOf(
                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                .getBlockPos().getX()),
                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                .getBlockPos().getY()),
                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
                                                .getBlockPos().getZ())))
                                .findFirst().orElse(null)).getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName;
                        entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.Technique = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                }
            }
        }
    }
}
