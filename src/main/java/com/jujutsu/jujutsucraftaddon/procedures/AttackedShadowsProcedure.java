package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.IgrisEntity;
import com.jujutsu.jujutsucraftaddon.entity.Shadow1Entity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class AttackedShadowsProcedure {
    public static void execute(double x, double y, double z, Entity sourceentity) {
        if (sourceentity == null)
            return;
        double r = 0;
        double curve = 0;
        double deg = 0;
        double yoff = 0;
        if (sourceentity instanceof Shadow1Entity || sourceentity instanceof IgrisEntity) {
            deg = sourceentity.getYRot() - 90;
            r = 1;
            curve = Mth.nextDouble(RandomSource.create(), -10, 10);
            for (int index0 = 0; index0 < 5; index0++) {
                for (int index1 = 0; index1 < 11; index1++) {
                    if (r == 2 || r == 3) {
                        yoff = Math.sin(Math.toRadians(deg)) * curve;
                        {
                            Entity _ent = sourceentity;
                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                _ent.getServer().getCommands().performPrefixedCommand(
                                        new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
                                                _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                        ("particle minecraft:dust 1 0 0 1 " + ((x - r * Math.sin(Math.toRadians(deg))) + " ") + ((y + 1 + yoff) + " ") + ((z + r * Math.cos(Math.toRadians(deg))) + " ") + ((-0.1) * Math.sin(Math.toRadians(deg)) + " ")
                                                + (0 + " ") + (0.1 * Math.cos(Math.toRadians(deg)) + " ") + "1 1 normal"));
                            }
                        }
                        {
                            Entity _ent = sourceentity;
                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                _ent.getServer().getCommands().performPrefixedCommand(
                                        new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
                                                _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                        ("particle minecraft:dust 1 0 0 1 " + ((x - r * Math.sin(Math.toRadians(deg))) + " ") + ((y + 1 + yoff) + " ") + ((z + r * Math.cos(Math.toRadians(deg))) + " ") + ((-0.1) * Math.sin(Math.toRadians(deg)) + " ")
                                                + (0 + " ") + (0.1 * Math.cos(Math.toRadians(deg)) + " ") + "1 1 normal"));
                            }
                        }
                        {
                            Entity _ent = sourceentity;
                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                _ent.getServer().getCommands().performPrefixedCommand(
                                        new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
                                                _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                        ("particle minecraft:dust 1 0 0 1 " + ((x - r * Math.sin(Math.toRadians(deg))) + " ") + ((y + 1 + yoff) + " ") + ((z + r * Math.cos(Math.toRadians(deg))) + " ") + ((-0.1) * Math.sin(Math.toRadians(deg)) + " ")
                                                + (0 + " ") + (0.1 * Math.cos(Math.toRadians(deg)) + " ") + "1 1 normal"));
                            }
                        }
                    }
                    deg = deg + 18;
                }
                if (r == 2 || r == 4) {
                    deg = sourceentity.getYRot() - 81;
                } else {
                    deg = sourceentity.getYRot() - 90;
                }
                r = r + 1;
            }
        }
    }
}
