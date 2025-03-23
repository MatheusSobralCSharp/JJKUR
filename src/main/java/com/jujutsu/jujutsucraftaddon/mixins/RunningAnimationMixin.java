package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.PlayerAnimHandler;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({PlayerModel.class})

/**
 * @author Satushi
 * @reason Used for make th posestack running loop
 */


public class RunningAnimationMixin<T extends LivingEntity> extends HumanoidModel<T> {
    public RunningAnimationMixin(ModelPart p_170677_) {
        super(p_170677_, RenderType::entityTranslucent);
    }

    @Inject(
            method = {"setupAnim(Lnet/minecraft/world/entity/LivingEntity;FFFFF)V"},
            at = {@At("HEAD")}
    )
    public void setupAnimPre(T player, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {
        if (player.isAlive()) {
            PlayerAnimHandler.preSprintingAnim(player, (PlayerModel<T>) (Object) this);
        }

    }

    @Inject(
            method = {"setupAnim(Lnet/minecraft/world/entity/LivingEntity;FFFFF)V"},
            at = {@At(
                    value = "INVOKE",
                    shift = At.Shift.AFTER,
                    target = "Lnet/minecraft/client/model/HumanoidModel;setupAnim(Lnet/minecraft/world/entity/LivingEntity;FFFFF)V"
            )}
    )
    public void setupAnim(T player, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {
        if (player.isAlive()) {
            if (limbSwing != 0.0F || ageInTicks != 0.0F || netHeadYaw != 0.0F || headPitch != 0.0F) {
                PlayerAnimHandler.sprintingAnim(player, (PlayerModel<T>) (Object) this);
                this.hat.copyFrom(this.head);
            }
        }
    }

}
