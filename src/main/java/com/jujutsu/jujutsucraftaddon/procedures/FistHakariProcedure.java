package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class FistHakariProcedure {
    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if ((sourceentity.getDirection()) == Direction.NORTH) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.CURSED_POWER_HAKARI.get(), (sourceentity.getX() + 0.35), (sourceentity.getY() + 1), (sourceentity.getZ() - 0.2), 0, 0, 0, 0, 1);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.CURSED_POWER_HAKARI.get(), (sourceentity.getX() - 0.35), (sourceentity.getY() + 1), (sourceentity.getZ() - 0.2), 0, 0, 0, 0, 1);
        } else if ((sourceentity.getDirection()) == Direction.SOUTH) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.CURSED_POWER_HAKARI.get(), (sourceentity.getX() + 0.35), (sourceentity.getY() + 1), (sourceentity.getZ() - 0.2), 0, 0, 0, 0, 1);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.CURSED_POWER_HAKARI.get(), (sourceentity.getX() - 0.35), (sourceentity.getY() + 1), (sourceentity.getZ() - 0.2), 0, 0, 0, 0, 1);
        } else if ((sourceentity.getDirection()) == Direction.WEST) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.CURSED_POWER_HAKARI.get(), (sourceentity.getX()), (sourceentity.getY() + 1), (sourceentity.getZ() + 0.5), 0, 0, 0, 0, 1);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.CURSED_POWER_HAKARI.get(), (sourceentity.getX()), (sourceentity.getY() + 1), (sourceentity.getZ() - 0.5), 0, 0, 0, 0, 1);
        } else if ((sourceentity.getDirection()) == Direction.EAST) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.CURSED_POWER_HAKARI.get(), (sourceentity.getX()), (sourceentity.getY() + 1), (sourceentity.getZ() + 0.5), 0, 0, 0, 0, 1);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.CURSED_POWER_HAKARI.get(), (sourceentity.getX()), (sourceentity.getY() + 1), (sourceentity.getZ() - 0.5), 0, 0, 0, 0, 1);
        }
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 1, false, false));
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 20, 1, false, false));
        if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20, 3, false, false));
        {
            Entity _ent = entity;
            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                        _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run particle jujutsucraft:particle_curse_power_green ~ ~1 ~ 0 0 0 1 10 normal");
            }
        }
        entity.setDeltaMovement(new Vec3((1 * Math.cos((sourceentity.getYRot() + 90) * (Math.PI / 180))), 0, (1 * Math.sin((sourceentity.getYRot() + 90) * (Math.PI / 180)))));
    }
}
