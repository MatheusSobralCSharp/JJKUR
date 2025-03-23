package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class ShortCutAction {
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
                case 0 -> PassiveKeybindOnKeyPressedProcedure.execute(world, x, y, z, entity);
                case 1 -> CursedFistsKeybindOnKeyPressedProcedure.execute(world, entity);
                case 2 -> OpenMastery.execute(world, entity);
                case 3 -> DomainExpansionOnKeyPressedProcedure.execute(world, x, y, z, entity);
                case 4 -> DomainTypeOnKeyPressedProcedure.execute(entity);
            }
        }

    }
}
