package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class Vow2Procedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        {
            double _setval = 30;
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.Output = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BINDING_VOW.get(), 3000, 0, false, false));
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
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("You Feel Your Body Immense Stronger"), false);
        {
            double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Vow2 + 1;
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.Vow2 = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
        if (entity instanceof Player _player)
            _player.closeContainer();
    }
}
