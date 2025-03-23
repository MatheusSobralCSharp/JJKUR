package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import com.mojang.blaze3d.shaders.FogShape;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.RenderFogProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.eventbus.api.Event;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.mcreator.jujutsucraft.procedures.RenderFogProcedure.setDistance;
import static net.mcreator.jujutsucraft.procedures.RenderFogProcedure.setShape;

@Mixin(value = RenderFogProcedure.class, priority = -1000)
public class RenderFogMixin {
    @Inject(
            method = {"execute(Lnet/minecraftforge/eventbus/api/Event;Lnet/minecraft/world/entity/Entity;)V"},
            at = {@At("HEAD")},
            cancellable = true,
            remap = false
    )
    private static void execute(Event event, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            double var10000;
            double color;
            double distance;
            label61:
            {
                color = 0.0;
                distance = 0.0;
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEnt0 = (LivingEntity) entity;
                    if (_livEnt0.hasEffect((MobEffect) JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        var10000 = entity.getPersistentData().getDouble("skill_domain") + 10.0;
                        break label61;
                    }
                }

                if (entity instanceof LivingEntity) {
                    LivingEntity _livEnt = (LivingEntity) entity;
                    if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                        var10000 = (double) _livEnt.getEffect((MobEffect) JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                        break label61;
                    }
                }

                var10000 = 0.0;
            }
            LevelAccessor world = entity.level();
            color = var10000;
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).fog) {
                if (color > 10.0) {
                    color -= 10.0;
                    if (color != 1.0 && color != 18.0) {
                        distance = 48.0;
                    } else {
                        distance = 64.0;
                    }

                    if (color == 1.0 || color == 18.0 || color == 4.0 || color == 26.0 || color == 43.0 || color == 6.0 || color == 11.0 || color == 23.0 || color == 25.0 || color == 24.0) {
                        setDistance(0.0F, (float) distance);
                        setShape(FogShape.SPHERE);
                    }
                }
            }

        }
    }
}
