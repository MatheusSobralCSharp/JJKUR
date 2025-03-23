package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.procedures.ConcorrentSpawnProcedure;
import net.mcreator.jujutsucraft.procedures.WhenPlayerJointheWorldProcedure;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = WhenPlayerJointheWorldProcedure.class, priority = -10000)
public abstract class WhenPlayerJointheWorldProcedureMixin {

    /**
     * @author Satushi
     * @reason Remove and Fix some stuff when joined
     */


    @Inject(at = @At("HEAD"), method = "execute(Lnet/minecraftforge/eventbus/api/Event;Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)V", remap = false, cancellable = true)
    private static void execute(Event event, LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();
        if (entity != null) {
            if (entity.isAlive()) {
                ResourceLocation entityTypeKey = ForgeRegistries.ENTITY_TYPES.getKey(entity.getType());
                if (entityTypeKey == null || !entityTypeKey.toString().startsWith("jujutsucraft")) {
                    ConcorrentSpawnProcedure.execute(entity, world, x, y, z);
                }

            }
        }
    }
}
