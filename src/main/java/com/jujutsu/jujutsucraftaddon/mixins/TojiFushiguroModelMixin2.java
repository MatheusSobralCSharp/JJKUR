package com.jujutsu.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.FushiguroTojiEntity;
import net.mcreator.jujutsucraft.entity.model.FushiguroTojiModel;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = FushiguroTojiModel.class, priority = -10000)
public abstract class TojiFushiguroModelMixin2 {
    public TojiFushiguroModelMixin2() {
    }

    /**
     * @author Satushi
     * @reason Change Rika Default Model Location
     */


    @Inject(method = "getAnimationResource*", at = @At("RETURN"), cancellable = true, remap = false)
    private void getAnimationResource(FushiguroTojiEntity entity, CallbackInfoReturnable<ResourceLocation> cir) {
        ResourceLocation modifiedLocation = new ResourceLocation("jujutsucraftaddon", "animations/human2.animation.json");
        cir.setReturnValue(modifiedLocation);
    }
}