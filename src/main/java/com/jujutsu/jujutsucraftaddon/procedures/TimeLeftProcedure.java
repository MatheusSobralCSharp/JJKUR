package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.world.entity.Entity;

public class TimeLeftProcedure {
    public static String execute(Entity entity) {
        if (entity == null)
            return "";
        return "Time Left: " + new java.text.DecimalFormat("##.##").format((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).TimeLeft / 20);
    }
}
