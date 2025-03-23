package com.jujutsu.jujutsucraftaddon.mixins;


import net.mcreator.jujutsucraft.procedures.WhenEntitySpawnsProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.eventbus.api.Event;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(value = WhenEntitySpawnsProcedure.class, priority = -10000)
public abstract class WhenRespawnedMixin {
    public WhenRespawnedMixin() {
    }

    /**
     * @author Satushi
     * @reason Testing
     */
    @Inject(at = @At("HEAD"), method = "execute(Lnet/minecraftforge/eventbus/api/Event;Lnet/minecraft/world/entity/Entity;)V", remap = false, cancellable = true)
    private static void execute(Event event, Entity entity, CallbackInfo ci) {
        ci.cancel();
    }
}
