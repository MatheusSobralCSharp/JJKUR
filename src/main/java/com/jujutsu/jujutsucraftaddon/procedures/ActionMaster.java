package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class ActionMaster {
    public static void execute(Player entity, int page) {
        Level world = entity.level();
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();

        // Check if the chunk is loaded
        if (!world.hasChunkAt(entity.blockPosition()))
            return;
        if (page >= 0) {
            switch (page) {
                case 0, 1, 2, 3, 4 -> SelectMastery.execute(world, entity, page);
            }
        }

    }
}