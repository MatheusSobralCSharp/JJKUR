package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class RikaAIBuffedProcedure {
    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        double Grow = 0;
        double timer = 0;
        double TrackZ = 0;
        double TrackY = 0;
        double TrackX = 0;
        if ((new Object() {
            public boolean getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getBoolean("Final");
            }
        }.getValue())) {
            if (Math.random() <= 0.01) {
                if (!(entity == null)) {
                    TrackX = entity.getX() - sourceentity.getX();
                    TrackY = entity.getY() - sourceentity.getY() + entity.getBbHeight() * 0.75 - sourceentity.getBbHeight() * 0.75;
                    TrackZ = entity.getZ() - sourceentity.getZ();
                    Grow = 1;
                    entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))), 50);
                    for (int index0 = 0; index0 < 25; index0++) {
                        if (world instanceof ServerLevel _level)
                            _level.sendParticles(ParticleTypes.WITCH, (sourceentity.getX() + TrackX * Grow), (sourceentity.getY() + sourceentity.getBbHeight() * 0.75 + TrackY * Grow), (sourceentity.getZ() + TrackZ * Grow), 5, 0.15, 0.15, 0.15, 0);
                        if (world instanceof ServerLevel _level)
                            _level.sendParticles(ParticleTypes.EXPLOSION, (sourceentity.getX() + TrackX * Grow), (sourceentity.getY() + sourceentity.getBbHeight() * 0.75 + TrackY * Grow), (sourceentity.getZ() + TrackZ * Grow), 5, 0.15, 0.15, 0.15,
                                    0);
                        Grow = Grow - 0.05;
                    }
                }
            }
            if (Math.random() <= 0.005) {
                {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect clear @s jujutsucraft:cooldown_time");
                    }
                }
                {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect clear @s jujutsucraft:cooldown_time_combat");
                    }
                }
            }
        }
        if ((new Object() {
            public boolean getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getBoolean("Buffed2");
            }
        }.getValue())) {
            if (Math.random() <= 0.02) {
                if (!(entity == null)) {
                    TrackX = entity.getX() - sourceentity.getX();
                    TrackY = entity.getY() - sourceentity.getY() + entity.getBbHeight() * 0.75 - sourceentity.getBbHeight() * 0.75;
                    TrackZ = entity.getZ() - sourceentity.getZ();
                    Grow = 1;
                    entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))), 50);
                    for (int index1 = 0; index1 < 25; index1++) {
                        if (world instanceof ServerLevel _level)
                            _level.sendParticles(ParticleTypes.WITCH, (sourceentity.getX() + TrackX * Grow), (sourceentity.getY() + sourceentity.getBbHeight() * 0.75 + TrackY * Grow), (sourceentity.getZ() + TrackZ * Grow), 5, 0.15, 0.15, 0.15, 0);
                        if (world instanceof ServerLevel _level)
                            _level.sendParticles(ParticleTypes.EXPLOSION, (sourceentity.getX() + TrackX * Grow), (sourceentity.getY() + sourceentity.getBbHeight() * 0.75 + TrackY * Grow), (sourceentity.getZ() + TrackZ * Grow), 5, 0.15, 0.15, 0.15,
                                    0);
                        Grow = Grow - 0.05;
                    }
                }
            }
            if (Math.random() <= 0.01) {
                {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect clear @s jujutsucraft:cooldown_time");
                    }
                }
                {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect clear @s jujutsucraft:cooldown_time_combat");
                    }
                }
            }
        }
    }
}
