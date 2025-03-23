package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import com.jujutsu.jujutsucraftaddon.procedures.BurnoutKeyOnKeyPressedProcedure;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.DomainExpansionEffectExpiresProcedure;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = DomainExpansionEffectExpiresProcedure.class, priority = -10000)
public abstract class DomainExpansionEffectExpiresProcedureMixin {

    public DomainExpansionEffectExpiresProcedureMixin() {
    }

    /**
     * @author Sat
     * @reason Give one effect for fix the barrier in the end of domain
     */

    @Inject(
            method = "execute",
            at = @At("HEAD"),
            remap = false
    )
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {

        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()))) {
                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.DOMAIN_TIME.get(), 40, 1, false, false));
            }
        }

        if  ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BurnOutRCT) {
            BurnoutKeyOnKeyPressedProcedure.execute(entity);
        }
    }

}
