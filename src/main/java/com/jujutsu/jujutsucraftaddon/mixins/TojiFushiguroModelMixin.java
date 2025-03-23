package com.jujutsu.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.FushiguroTojiBugEntity;
import net.mcreator.jujutsucraft.entity.model.FushiguroTojiBugModel;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = FushiguroTojiBugModel.class, priority = -10000)
public abstract class TojiFushiguroModelMixin {
    public TojiFushiguroModelMixin() {
    }

    /**
     * @author Satushi
     * @reason Change Rika Default Model Location
     */


    @Inject(method = "getAnimationResource*", at = @At("RETURN"), cancellable = true, remap = false)
    private void getAnimationResource(FushiguroTojiBugEntity entity, CallbackInfoReturnable<ResourceLocation> cir) {
        ResourceLocation modifiedLocation = new ResourceLocation("jujutsucraftaddon", "animations/human2.animation.json");
        cir.setReturnValue(modifiedLocation);
    }
}