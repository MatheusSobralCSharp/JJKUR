package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.procedures.NewPlayAnimation;
import net.mcreator.jujutsucraft.procedures.PlayAnimationIfPossibleProcedure;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PlayAnimationIfPossibleProcedure.class, priority = -1000)
public abstract class PlayAnimationMixin {
    @Inject(method = "onEntityAttacked", at = @At("HEAD"), cancellable = true, remap = false)
    private static void onEntityAttackedMixin(LivingAttackEvent event, CallbackInfo ci) {
        if (event != null && event.getEntity() != null) {
            ci.cancel();

            NewPlayAnimation.execute(event, event.getEntity().level(), event.getSource(), event.getEntity());
        }
    }
}
