package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class RCTMasteryKeyOnKeyPressedProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_AUTO_RCT)) {
            if (entity instanceof ServerPlayer _plr1 && _plr1.level() instanceof ServerLevel
                    && _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:reverse_cursed_mastery"))).isDone()) {
                if (!entity.isShiftKeyDown()) {
                    if (!(entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTMasteryOn) {
                        {
                            boolean _setval = true;
                            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.RCTMasteryOn = _setval;
                                capability.syncPlayerVariables(entity);
                            });
                        }
                        if (entity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal((Component.translatable("dialoguearct").getString() + ": On")), false);
                        if (entity instanceof Player _player)
                            _player.closeContainer();
                    } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTMasteryOn) {
                        {
                            boolean _setval = false;
                            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.RCTMasteryOn = _setval;
                                capability.syncPlayerVariables(entity);
                            });
                        }
                        if (entity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal((Component.translatable("dialoguearct").getString() + ": Off")), false);
                        if (entity instanceof Player _player)
                            _player.closeContainer();
                    }
                }
            }
        }
    }
}
