package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class CounterProcedureProcedure {
    public static void execute(
            LevelAccessor world,
            DamageSource damagesource,
            Entity entity,
            Entity sourceentity
    ) {
        if (
                damagesource == null ||
                        entity == null ||
                        sourceentity == null
        ) return;
        if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftaddonModMobEffects.COUNTER_CD.get()))) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.COUNTER_ANIMATION.get(), 10, 254, false, false));
            if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 254, false, false));
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 254, false, false));
            {
                Entity _ent = entity;
                _ent.teleportTo((sourceentity.getX() + Mth.nextInt(RandomSource.create(), -2, 2)), (sourceentity.getY() + 1), (sourceentity.getZ() + Mth.nextInt(RandomSource.create(), 0, 1)));
                if (_ent instanceof ServerPlayer _serverPlayer)
                    _serverPlayer.connection.teleport((sourceentity.getX() + Mth.nextInt(RandomSource.create(), -2, 2)), (sourceentity.getY() + 1), (sourceentity.getZ() + Mth.nextInt(RandomSource.create(), 0, 1)), _ent.getYRot(), _ent.getXRot());
            }
            sourceentity.setDeltaMovement(new Vec3((10 * Math.cos((entity.getYRot() + 90) * (Math.PI / 180))), (-100), (10 * Math.sin((entity.getYRot() + 90) * (Math.PI / 180)))));
            if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20, (sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WEAKNESS) ?
                        _livEnt.getEffect(MobEffects.WEAKNESS).getAmplifier() : 0) + 1, false, false));
            if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, (sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) ?
                        _livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier() : 0) + 1, false, false));
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), (sourceentity.getX() + Mth.nextInt(RandomSource.create(), -2, 2)), (sourceentity.getY() + 1), (sourceentity.getZ()), 2, 0, 0, 0, 1);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.PUNCH.get(), (sourceentity.getX() + Mth.nextInt(RandomSource.create(), -2, 2)), (sourceentity.getY() + Mth.nextInt(RandomSource.create(), 1, 2)), (sourceentity.getZ() + Mth.nextInt(RandomSource.create(), -1, 1)), 1, 0, 0, 0, 1);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.PUNCH.get(), (sourceentity.getX() + Mth.nextInt(RandomSource.create(), -2, 2)), (sourceentity.getY() + Mth.nextInt(RandomSource.create(), 1, 2)), (sourceentity.getZ() + Mth.nextInt(RandomSource.create(), -1, 1)), 1, 0, 0, 0, 1);
            if (!(((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Gojo") || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Sukuna") || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Kiryu") || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Majima"))) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.COUNTER_CD.get(), 1200, 1, false, false));
            } else if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Gojo") || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Sukuna") || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Kiryu") || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Majima")) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.COUNTER_CD.get(), 300, 1, false, false));
            }
        }
    }
}
