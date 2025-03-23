package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.ModList;

public class DismantleParticles2Procedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (ModList.get().isLoaded("jjkueffects")) {
            if (world instanceof ServerLevel _level)
                _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                        "particle jjkueffects:dismantle ~ ~ ~ 0 0 0 1 1 force");
        } else {
            if (Math.random() <= 0.2) {
                if (world instanceof ServerLevel _level)
                    _level.sendParticles(JujutsucraftaddonModParticleTypes.HORIZONTAL_SLASH_BLACK.get(), x, y, z, 0, 0, 0, 0, 2);
            } else if (Math.random() <= 0.4) {
                if (world instanceof ServerLevel _level)
                    _level.sendParticles(JujutsucraftaddonModParticleTypes.KAI_10.get(), x, y, z, 0, 0, 0, 0, 2);
            } else if (Math.random() <= 0.6) {
                if (world instanceof ServerLevel _level)
                    _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_10.get(), x, y, z, 0, 0, 0, 0, 2);
            } else if (Math.random() <= 0.8) {
                if (world instanceof ServerLevel _level)
                    _level.sendParticles(JujutsucraftaddonModParticleTypes.VERTICAL_HAITI.get(), x, y, z, 0, 0, 0, 0, 2);
            }
        }
    }
}
