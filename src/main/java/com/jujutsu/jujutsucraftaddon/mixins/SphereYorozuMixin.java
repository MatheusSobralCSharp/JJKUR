package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraft.procedures.AITrueSphereProcedure;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = AITrueSphereProcedure.class)
public abstract class SphereYorozuMixin {
    public SphereYorozuMixin() {
    }

    /**
     * @author Satushi
     * @reason Changes Yorozu Sphere Size with the gamerule
     */

    @ModifyConstant(
            method = "execute",
            constant = @Constant(doubleValue = 15.0),
            remap = false
    )
    private static double injection0(double constant, LevelAccessor world) {
        if (world != null) {
            return world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_YOROZU_SPHERE_LIMIT);
        } else {
            return constant;
        }
    }
}


