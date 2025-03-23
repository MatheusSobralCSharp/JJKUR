package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;

public class ReturnBurnoutExpProcedure {
    public static String execute(Entity entity) {
        if (entity == null)
            return "";
        return Component.translatable("amount3").getString() + (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CooldownExp
                + Component.translatable("amount4").getString();
    }
}
