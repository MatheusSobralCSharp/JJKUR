package com.jujutsu.jujutsucraftaddon.procedures;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.world.level.LevelAccessor;

public class DomainSizeSetProcedure {
    public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
        JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = (DoubleArgumentType.getDouble(arguments, "DomainSize"));
        JujutsucraftModVariables.MapVariables.get(world).syncData(world);
    }
}
