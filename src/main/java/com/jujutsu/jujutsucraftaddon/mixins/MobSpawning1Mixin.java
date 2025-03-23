package com.jujutsu.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.procedures.SpawnLevel1Procedure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(SpawnLevel1Procedure.class)
public abstract class MobSpawning1Mixin {
    public MobSpawning1Mixin() {
    }

    @ModifyConstant(
            method = "execute",
            constant = @Constant(doubleValue = 1.0),
            remap = false
    )
    private static double modifyMobSpawnChance(double constant) {
        return constant / 2;
    }

}
