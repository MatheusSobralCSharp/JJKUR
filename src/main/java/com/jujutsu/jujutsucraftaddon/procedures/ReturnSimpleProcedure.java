package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;

public class ReturnSimpleProcedure {
    public static String execute(Entity entity) {
        if (entity == null)
            return "";
        return "Your Simple Domain EXP: " + entity.getPersistentData().getDouble("cnt_simpledomain") + " You Need: 6000 for Unlock Mastery Simple Domain";
    }
}
