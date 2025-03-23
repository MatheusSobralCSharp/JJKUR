package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class AirCombatProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if (Math.random() <= 0.01) {
            if (!(sourceentity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MobEffects.SLOW_FALLING))) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:dash")), SoundSource.NEUTRAL, 1, 1);
                    } else {
                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:dash")), SoundSource.NEUTRAL, 1, 1, false);
                    }
                }
                {
                    Entity _ent = entity;
                    _ent.teleportTo((entity.getX()), (entity.getY() + 6), (entity.getZ()));
                    if (_ent instanceof ServerPlayer _serverPlayer)
                        _serverPlayer.connection.teleport((entity.getX()), (entity.getY() + 6), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
                }
                {
                    Entity _ent = sourceentity;
                    _ent.teleportTo((sourceentity.getX()), (sourceentity.getY() + 6), (sourceentity.getZ()));
                    if (_ent instanceof ServerPlayer _serverPlayer)
                        _serverPlayer.connection.teleport((sourceentity.getX()), (sourceentity.getY() + 6), (sourceentity.getZ()), _ent.getYRot(), _ent.getXRot());
                }
                {
                    Entity _ent = entity;
                    _ent.teleportTo((entity.getX()), (sourceentity.getY()), (entity.getZ()));
                    if (_ent instanceof ServerPlayer _serverPlayer)
                        _serverPlayer.connection.teleport((entity.getX()), (sourceentity.getY()), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
                }
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 100, 0, false, false));
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 100, 0, false, false));
                if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 100, 0, false, false));
                if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 100, 0, false, false));
            }
        }
    }
}
