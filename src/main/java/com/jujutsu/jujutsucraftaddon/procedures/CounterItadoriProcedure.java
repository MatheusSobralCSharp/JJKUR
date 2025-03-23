package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CounterItadoriProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity != null) {
            double repeats = 0.0;
            String endtext = "";
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BrainDamage != 5) {
                if (entity instanceof LivingEntity _entity && !_entity.hasEffect(JujutsucraftaddonModMobEffects.BERSERK.get()))
                {
                    LivingEntity _livEnt9;
                    Player _player;
                    if (entity.getPersistentData().getDouble("cnt_t") < 20.0) {
                        {
                            entity.getPersistentData().putDouble("cnt_t", entity.getPersistentData().getDouble("cnt_t") + 1.0);
                            endtext = "§0BERSERK MODE";
                        }

                        repeats = (double) Math.round((20.0 - entity.getPersistentData().getDouble("cnt_t")) * 0.25);

                        for (int index0 = 0; index0 < (int) repeats; ++index0) {
                            endtext = "§0■" + endtext + "§0■";
                        }

                        if (entity instanceof Player) {
                            _player = (Player) entity;
                            if (!_player.level().isClientSide()) {
                                _player.displayClientMessage(Component.literal(endtext), true);
                            }
                        }
                    }

                    if (entity.getPersistentData().getDouble("cnt_t") == 20.0) {
                        {
                            Entity _ent;
                            if (entity instanceof LivingEntity) {
                                _livEnt9 = (LivingEntity) entity;
                                if (_livEnt9.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {

                                }

                                if (entity instanceof Player) {
                                    _player = (Player) entity;
                                    if (!_player.level().isClientSide()) {
                                        _player.displayClientMessage(Component.literal(""), true);
                                    }
                                }
                            }
                            if (entity instanceof LivingEntity _entity1 && !_entity1.level().isClientSide())
                                _entity1.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BERSERK.get(), 6200, 1, false, false));
                            entity.getPersistentData().putDouble("cnt_t", 0.0);
                        }

                    }
                }

            }
        }
    }
}
