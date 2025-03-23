package com.jujutsu.jujutsucraftaddon.procedures;


import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class MasteryAction {
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
                case 0 -> ExtensionDomainKeyOnPressedProcedure.execute(world, entity);
                case 1 -> RCTMasteryKeyOnKeyPressedProcedure.execute(world, entity);
                case 2 -> RCTBurnoutKeyProcedure.execute(entity);
                case 3 -> RCTOutputKeyOnKeyPressedProcedure.execute(entity);
                case 4 -> BarrierlessKeyOnKeyPressedProcedure.execute(world, entity);
            }
        }

    }
}