package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.procedures.DisplayOverlayProcedure;
import net.mcreator.jujutsucraft.procedures.PhysicalGiftedEffectOnEffectActiveTickProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PhysicalGiftedEffectOnEffectActiveTickProcedure.class)
public abstract class PhysicalGiftedMixin {
    public PhysicalGiftedMixin() {
    }

    /**
     * @author Satushi
     * @reason Add The Gojo Vision to HR
     */

    @Inject(method = "execute", at = @At("HEAD"), remap = false)
    private static void execute(LevelAccessor world, Entity entity, CallbackInfo ci) {
        DisplayOverlayProcedure.execute(world, entity);
    }
}
