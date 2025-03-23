package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

import java.util.ArrayList;

public class LeaveTeamProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        double rnd_1 = 0;
        if (!((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Team).equals("")) {
            rnd_1 = Math.random();
            {
                double _setval = rnd_1;
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.friend_num = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
            for (Entity entityiterator : new ArrayList<>(world.players())) {
                if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Team)
                        .equals((entityiterator.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Team)) {
                    if (entityiterator instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " Left the Team")), false);
                }
            }
            {
                String _setval = "";
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Team = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        } else {
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("You don't Have a Team"), false);
        }
    }
}
