package com.jujutsu.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.FushiguroTojiBugEntity;
import net.mcreator.jujutsucraft.procedures.AttackTackleProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = AttackTackleProcedure.class, priority = -10000)
public abstract class AttackContinueMixin {
    @Inject(method = "execute", at = @At("HEAD"), remap = false)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        if (entity instanceof FushiguroTojiBugEntity) {
            if (!((((FushiguroTojiBugEntity) entity).animationprocedure).equals("playfulrush"))) {
                ((FushiguroTojiBugEntity) entity).setAnimation("playfulrush");
            }
        }

    }
}
