package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import java.util.List;

public class AwakeEffectExpiresProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals("jujutsucraft:meteor")) {
                    if (world instanceof ServerLevel _level)
                        _level.sendParticles(ParticleTypes.LARGE_SMOKE, x, y, z, 50, 3, 3, 3, 1);
                    if (world instanceof ServerLevel _level)
                        _level.sendParticles(ParticleTypes.WHITE_ASH, x, y, z, 50, 3, 3, 3, 1);
                    if (world instanceof ServerLevel _level)
                        _level.sendParticles(ParticleTypes.ASH, x, y, z, 50, 3, 3, 3, 1);
                    if (world instanceof ServerLevel _level)
                        _level.sendParticles(JujutsucraftaddonModParticleTypes.SMOKE_WHITE.get(), x, y, z, 50, 3, 3, 3, 1);
                    if (world instanceof ServerLevel _level)
                        _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_8.get(), (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 50, 3, 3, 3, 1);
                    if (world instanceof ServerLevel _level)
                        _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_9.get(), (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 50, 3, 3, 3, 1);
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:swing3")), SoundSource.NEUTRAL, 1, 1);
                        } else {
                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:swing3")), SoundSource.NEUTRAL, 1, 1, false);
                        }
                    }
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:swing3")), SoundSource.NEUTRAL, 1, 1);
                        } else {
                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:swing3")), SoundSource.NEUTRAL, 1, 1, false);
                        }
                    }
                    if (!entityiterator.level().isClientSide())
                        entityiterator.discard();
                }
            }
        }
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.RESPAWNED.get(), 60, 1, false, false));
    }
}
