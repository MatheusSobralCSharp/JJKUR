package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class Vow1Procedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).VowPower < 30) {
            {
                double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).VowPower + 2;
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.VowPower = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, Mth.nextInt(RandomSource.create(), 6000, 12000),
                        (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) * 2, false, false));
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal(
                                "Self-imposed restrictions that are potentially harmful to the creator, such as willingly limiting the amount of cursed energy they can use for a period of time, can increase the amount of the user's cursed energy and of their cursed techniques."),
                        false);
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal(
                                "As a product of negative emotions, cursed energy responds to the desires of its individual user. As a result, the user can increase the power of their cursed energy by stating a self-imposed \"cursed restriction\" that creates riskier conditions to use their abilities. For example, by divulging one's cursed technique, it creates more risk for them, making their cursed energy swell in response to its user's resolve"),
                        false);
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("The penalty of breaking a binding vow with oneself is the loss of whatever was gained through the contract"), false);
        } else {
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("You Can't Do More Vows Per Reset"), false);
        }
        if (entity instanceof Player _player)
            _player.closeContainer();
    }
}
