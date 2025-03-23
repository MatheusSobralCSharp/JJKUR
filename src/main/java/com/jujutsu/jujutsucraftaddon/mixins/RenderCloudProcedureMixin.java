package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.RenderCloudProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.eventbus.api.Event;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.mcreator.jujutsucraft.procedures.RenderCloudProcedure.renderClouds;

@Mixin(value = RenderCloudProcedure.class, priority = -1000)
public class RenderCloudProcedureMixin {
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
            label36: {
                color = 0.0;
                double distance = 0.0;
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEnt0 = (LivingEntity)entity;
                    if (_livEnt0.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        var10000 = entity.getPersistentData().getDouble("skill_domain") + 10.0;
                        break label36;
                    }
                }

                if (entity instanceof LivingEntity) {
                    LivingEntity _livEnt = (LivingEntity)entity;
                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                        var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                        break label36;
                    }
                }

                var10000 = 0.0;
            }

            color = var10000;
            if (color > 10.0) {
                color -= 10.0;
                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).fog) {
                    if (color == 1.0 || color == 18.0) {
                        renderClouds(Minecraft.getInstance().options.getCloudsType(), 192.0, -1.0, 0.0, -2143289344);
                    }
                }
            }

        }
    }
}
