package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.procedures.MythicalBeastAmberEffectEffectStartedappliedProcedure;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = MythicalBeastAmberEffectEffectStartedappliedProcedure.class)
public abstract class MythicalBeastAmberStartMixin {
    /**
     * Changing Mythical Beast Amber Effect to buff Kashimo Clan
     */

    @ModifyConstant(
            method = "execute",
            constant = @Constant(doubleValue = 1.2),
            remap = false
    )
    private static double injection(double constant, Entity entity) {
        JujutsucraftaddonModVariables.PlayerVariables variables = entity.getCapability(
                JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null
        ).orElse(null);

        if (variables == null) {
            return constant;
        }

        switch (variables.Subrace) {
            case "Perfect Vessel":
                return variables.Clans.equals("Kashimo") ? constant * 1.15 : constant * 1.20;

            default:
                return variables.Clans.equals("Kashimo") ? constant * 1.1 : constant;
        }
    }
}
