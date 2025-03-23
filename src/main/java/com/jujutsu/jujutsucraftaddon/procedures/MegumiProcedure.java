package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import java.util.List;

public class MegumiProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, double amount) {
        if (entity == null || sourceentity == null)
            return;
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (Math.random() <= 0.5) {
                    if (!(entityiterator == sourceentity)) {
                        {
                            Entity _ent = entity;
                            _ent.teleportTo((sourceentity.getX()), (entity.getY()), (sourceentity.getZ() + Mth.nextInt(RandomSource.create(), -1, 1)));
                            if (_ent instanceof ServerPlayer _serverPlayer)
                                _serverPlayer.connection.teleport((sourceentity.getX()), (entity.getY()), (sourceentity.getZ() + Mth.nextInt(RandomSource.create(), -1, 1)), _ent.getYRot(), _ent.getXRot());
                        }
                        {
                            Entity _ent = sourceentity;
                            _ent.teleportTo((entityiterator.getX()), (sourceentity.getY()), (entityiterator.getZ()));
                            if (_ent instanceof ServerPlayer _serverPlayer)
                                _serverPlayer.connection.teleport((entityiterator.getX()), (sourceentity.getY()), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
                        }
                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:clap")), SoundSource.NEUTRAL, 1, 1);
                            } else {
                                _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:clap")), SoundSource.NEUTRAL, 1, 1, false);
                            }
                        }
                    }
                }
            }
        }
        if (Math.random() <= 0.01) {
            entity.getPersistentData().putDouble("Roulette", 2);
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("This Now Allows Him To Activate His Swapping Technique Roughly Fifty Times In A Single Second"), false);
        } else if (Math.random() <= 0.02) {
            entity.getPersistentData().putDouble("Roulette", 1);
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("Having Replaced His Left Arm, Changed The Activation Condition Of His Technique From Applause, To The Collision Between The Wooden Box And The Metal Teeth Of The Vibraslap"), false);
        }
        if (entity.getPersistentData().getDouble("Roulette") == 1) {
            for (int index0 = 0; index0 < 50; index0++) {
                {
                    Entity _ent = sourceentity;
                    _ent.teleportTo((entity.getX()), (entity.getY()), (entity.getZ()));
                    if (_ent instanceof ServerPlayer _serverPlayer)
                        _serverPlayer.connection.teleport((entity.getX()), (entity.getY()), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
                }
                {
                    Entity _ent = entity;
                    _ent.teleportTo((sourceentity.getX()), (entity.getY()), (sourceentity.getZ()));
                    if (_ent instanceof ServerPlayer _serverPlayer)
                        _serverPlayer.connection.teleport((sourceentity.getX()), (entity.getY()), (sourceentity.getZ()), _ent.getYRot(), _ent.getXRot());
                }
                sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))), (float) amount);
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:vibraslap")), SoundSource.NEUTRAL, 1, 1);
                    } else {
                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:vibraslap")), SoundSource.NEUTRAL, 1, 1, false);
                    }
                }
                entity.getPersistentData().putDouble("Roulette", 0);
            }
        } else if (entity.getPersistentData().getDouble("Roulette") == 2) {
            for (int index1 = 0; index1 < 25; index1++) {
                {
                    Entity _ent = sourceentity;
                    _ent.teleportTo((entity.getX()), (entity.getY()), (entity.getZ()));
                    if (_ent instanceof ServerPlayer _serverPlayer)
                        _serverPlayer.connection.teleport((entity.getX()), (entity.getY()), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
                }
                {
                    Entity _ent = entity;
                    _ent.teleportTo((sourceentity.getX()), (entity.getY()), (sourceentity.getZ()));
                    if (_ent instanceof ServerPlayer _serverPlayer)
                        _serverPlayer.connection.teleport((sourceentity.getX()), (entity.getY()), (sourceentity.getZ()), _ent.getYRot(), _ent.getXRot());
                }
                sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))), (float) amount);
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:vibraslap")), SoundSource.NEUTRAL, 1, 1);
                    } else {
                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:vibraslap")), SoundSource.NEUTRAL, 1, 1, false);
                    }
                }
                entity.getPersistentData().putDouble("Roulette", 0);
            }
        }
    }
}
