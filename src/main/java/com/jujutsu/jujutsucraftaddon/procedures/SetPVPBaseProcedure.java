package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class SetPVPBaseProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        JujutsucraftaddonModVariables.MapVariables.get(world).X = entity.getX();
        JujutsucraftaddonModVariables.MapVariables.get(world).syncData(world);
        JujutsucraftaddonModVariables.MapVariables.get(world).Y = entity.getY() + 1;
        JujutsucraftaddonModVariables.MapVariables.get(world).syncData(world);
        JujutsucraftaddonModVariables.MapVariables.get(world).Z = entity.getZ();
        JujutsucraftaddonModVariables.MapVariables.get(world).syncData(world);
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal(("PVP Base Set At: " + ("X: " + JujutsucraftaddonModVariables.MapVariables.get(world).X) + ("Y: " + JujutsucraftaddonModVariables.MapVariables.get(world).Y)
                    + ("Z: " + JujutsucraftaddonModVariables.MapVariables.get(world).Z))), false);
    }
}
