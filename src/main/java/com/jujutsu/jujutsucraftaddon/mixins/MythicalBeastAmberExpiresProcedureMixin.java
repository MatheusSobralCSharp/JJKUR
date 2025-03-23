package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.JujutsucraftMod;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.MythicalBeastAmberEffectEffectExpiresProcedure;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = MythicalBeastAmberEffectEffectExpiresProcedure.class, priority = -10000)
public abstract class MythicalBeastAmberExpiresProcedureMixin {

    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, Entity entity, double amplifier, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            double num_level = 0.0;
            num_level = amplifier + 1.0;
            if (num_level > 0.0) {
                ((LivingEntity) entity).getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(((LivingEntity) entity).getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() - num_level * 1.2);
            }
            JujutsucraftMod.queueServerWork(1, () -> {
                if (entity instanceof LivingEntity _livEnt2) {
                    if (_livEnt2.hasEffect(JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get())) {
                        return;
                    }
                }

                Entity _ent = entity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "clear @s jujutsucraft:mythical_beast_amber_head");
                }

                if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Kashimo")) {
                    if (Math.random() < (1) / ((float) 2)) {
                        if (entity instanceof LivingEntity _entity) {
                            _entity.setHealth(0.0F);
                        }

                        entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 1.0F);
                    }
                } else {
                    if (entity instanceof LivingEntity _entity) {
                        _entity.setHealth(0.0F);
                    }

                    entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 1.0F);
                }

            });
        }
    }
}
