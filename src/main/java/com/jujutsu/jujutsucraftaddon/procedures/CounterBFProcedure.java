package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CounterBFProcedure {
    public static void execute(LevelAccessor world, Entity sourceentity) {
        if (sourceentity == null)
            return;
        if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 > 0) {
            double repeats = 0.0;
            String endtext = "";
            if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BrainDamage != 5) {
                LivingEntity _livEnt9;
                Player _player;
                if (sourceentity.getPersistentData().getDouble("cnt_bf") < 50.0) {
                    {
                        sourceentity.getPersistentData().putDouble("cnt_bf", sourceentity.getPersistentData().getDouble("cnt_bf")
                                + 0.1 * sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).blackflashmastery);
                        endtext = "§4KOKUSEN!!";
                    }
                    repeats = (double) Math.round((50.0 - sourceentity.getPersistentData().getDouble("cnt_bf")) * 0.25);
                    for (int index0 = 0; index0 < (int) repeats; ++index0) {
                        endtext = "§4■" + endtext + "§4■";
                    }
                    if (sourceentity instanceof Player) {
                        _player = (Player) sourceentity;
                        if (!_player.level().isClientSide()) {
                            _player.displayClientMessage(Component.literal(endtext), true);
                        }
                    }
                }
                if (sourceentity.getPersistentData().getDouble("cnt_bf") == 50.0) {
                    {
                        Entity _ent;
                        if (sourceentity instanceof LivingEntity) {
                            _livEnt9 = (LivingEntity) sourceentity;
                            if (_livEnt9.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                            }
                            if (sourceentity instanceof Player) {
                                _player = (Player) sourceentity;
                                if (!_player.level().isClientSide()) {
                                    _player.displayClientMessage(Component.literal(""), true);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
