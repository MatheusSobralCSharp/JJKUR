package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.ErroEntity;
import com.jujutsu.jujutsucraftaddon.entity.ErrorEntity;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class LimbssProcedure {
    public static void execute(LevelAccessor world, Entity entity, double amount) {
        if (entity == null)
            return;
        if (!(entity instanceof ErrorEntity || entity instanceof ErroEntity)) {
            if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_LIMB_LOSS)) {
                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Limb == 0) {
                    if (Math.random() <= (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_LIMB_LOSS_SPEED)) * 0.001 * amount) {
                        {
                            double _setval = Mth.nextInt(RandomSource.create(), 1, 4);
                            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.Limb = _setval;
                                capability.syncPlayerVariables(entity);
                            });
                        }
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Limb == 4
                                || (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Limb == 2) {
                            if (entity instanceof Player _player && !_player.level().isClientSide())
                                _player.displayClientMessage(Component.literal("You lost a Leg"), false);
                            if (entity instanceof Player _player && !_player.level().isClientSide())
                                _player.displayClientMessage(Component.literal("You lost a Leg"), false);
                            if (!(entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(JujutsucraftaddonModMobEffects.LIMBS_EFFECT.get()))) {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.LIMBS_EFFECT.get(), 2400, 1, false, false));
                            }
                            if (world instanceof ServerLevel _level)
                                _level.sendParticles(JujutsucraftaddonModParticleTypes.BLOOD_RED.get(), (entity.getX()), (entity.getY() + 1), (entity.getZ() - 1), 1, 0, 0, 0, 1);
                            if (world instanceof ServerLevel _level)
                                _level.sendParticles(JujutsucraftaddonModParticleTypes.BLOOD_RED.get(), (entity.getX()), (entity.getY() + 1), (entity.getZ() + 1), 1, 0, 0, 0, 1);
                        }
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Limb == 1
                                || (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Limb == 3) {
                            if (entity instanceof Player _player && !_player.level().isClientSide())
                                _player.displayClientMessage(Component.literal("You lost an Arm"), false);
                            if (entity instanceof Player _player && !_player.level().isClientSide())
                                _player.displayClientMessage(Component.literal("You lost an Arm"), false);
                            if (!(entity instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(JujutsucraftaddonModMobEffects.LIMBS_EFFECT.get()))) {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.LIMBS_EFFECT.get(), 2400, 1, false, false));
                            }
                            if (world instanceof ServerLevel _level)
                                _level.sendParticles(JujutsucraftaddonModParticleTypes.BLOOD_RED.get(), (entity.getX() - 0.5), (entity.getY() + 0.85), (entity.getZ()), 1, 0, 0, 0, 1);
                            if (world instanceof ServerLevel _level)
                                _level.sendParticles(JujutsucraftaddonModParticleTypes.BLOOD_RED.get(), (entity.getX() + 0.5), (entity.getY() + 0.85), (entity.getZ()), 1, 0, 0, 0, 1);
                        }
                    }
                }
            }
        }
    }
}
