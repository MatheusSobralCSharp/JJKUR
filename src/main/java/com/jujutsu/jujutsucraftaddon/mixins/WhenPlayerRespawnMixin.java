package com.jujutsu.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.PlayerSetProfessionProcedure;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PlayerSetProfessionProcedure.class, priority = -10000)
public abstract class WhenPlayerRespawnMixin {
    public WhenPlayerRespawnMixin() {
    }

    /**
     * @author Satsuhi
     * @reason Changes and Some Fixes
     */
    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            if (entity.isAlive()) {
                entity.getPersistentData().putBoolean("JujutsuSorcerer", false);
                entity.getPersistentData().putBoolean("CurseUser", false);
                entity.getPersistentData().putBoolean("CursedSpirit", false);
                if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerProfession == -2.0) {
                    entity.getPersistentData().putBoolean("CursedSpirit", true);
                    entity.getPersistentData().putBoolean("CurseUser", true);
                } else if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerProfession == -1.0) {
                    entity.getPersistentData().putDouble("CursedSpirit", 1.0);
                } else if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerProfession == 1.0) {
                    entity.getPersistentData().putBoolean("CurseUser", true);
                } else {
                    entity.getPersistentData().putBoolean("JujutsuSorcerer", true);
                }

                if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 0.0) {
                    entity.getPersistentData().putBoolean("NonSorcerer", true);
                } else {
                    entity.getPersistentData().putBoolean("NonSorcerer", false);
                }

                if (entity instanceof LivingEntity) {
                    LivingEntity _livingEntity10 = (LivingEntity)entity;
                    if (_livingEntity10.getAttributes().hasAttribute((Attribute) JujutsucraftModAttributes.PROFESSION.get())) {
                        _livingEntity10.getAttribute((Attribute)JujutsucraftModAttributes.PROFESSION.get()).setBaseValue(((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique);
                    }
                }
            }
        }
    }
}