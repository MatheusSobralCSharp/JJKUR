package com.jujutsu.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.KeyReverseCursedTechniqueOnKeyReleasedProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = KeyReverseCursedTechniqueOnKeyReleasedProcedure.class, priority = -10000)
public abstract class KeyReverseCursedTechniqueOnKeyReleasedProcedureMixin {
    public KeyReverseCursedTechniqueOnKeyReleasedProcedureMixin() {
    }

    /**
     * @author Sat
     * @reason Adds reverse cursed technique some logic at the release of the key
     */

    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            if (entity instanceof LivingEntity _entity) {
                _entity.removeEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get());
            }
            entity.getPersistentData().putBoolean("PRESS_BURNOUT", false);
            entity.getPersistentData().putDouble("cnt_v", 0);
            entity.getPersistentData().putBoolean("PRESS_M", false);
        }
    }
}
