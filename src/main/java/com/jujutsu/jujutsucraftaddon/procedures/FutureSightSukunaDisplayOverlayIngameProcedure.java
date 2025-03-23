package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class FutureSightSukunaDisplayOverlayIngameProcedure {
    public static boolean execute(Entity entity) {
        if (entity == null)
            return false;
        return (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).FutureSightNumber == Mth.nextInt(RandomSource.create(), 105, 107);
    }
}
