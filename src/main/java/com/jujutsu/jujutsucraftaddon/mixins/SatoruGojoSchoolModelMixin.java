package com.jujutsu.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.GojoSatoruSchoolDaysEntity;
import net.mcreator.jujutsucraft.entity.model.GojoSatoruSchoolDaysModel;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = GojoSatoruSchoolDaysModel.class, priority = -10000)
public abstract class SatoruGojoSchoolModelMixin {
    public SatoruGojoSchoolModelMixin() {
    }

    /**
     * @author Satushi
     * @reason Change Rika Default Model Location
     */


    @Inject(method = "getAnimationResource*", at = @At("RETURN"), cancellable = true, remap = false)
    private void getAnimationResource(GojoSatoruSchoolDaysEntity entity, CallbackInfoReturnable<ResourceLocation> cir) {
        ResourceLocation modifiedLocation = new ResourceLocation("jujutsucraftaddon", "animations/human2.animation.json");
        cir.setReturnValue(modifiedLocation);
    }
}