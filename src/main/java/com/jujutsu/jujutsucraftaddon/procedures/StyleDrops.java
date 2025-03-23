package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.ItadoriShinjukuEntity;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.entity.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class StyleDrops {
    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Style == 0) && (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Run == 1) {
            if (entity instanceof GojoSatoruEntity) {
                if (Math.random() < (1) / ((float) 200)) {
                    if (sourceentity instanceof Player _player) {
                        {
                            int finalLastIndex = 1;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.Style = finalLastIndex;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                        if (!_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Unlocked Gojo Style"), false);

                    }
                }
            } else if (entity instanceof ItadoriYujiShibuyaEntity) {
                if (Math.random() < (1) / ((float) 200)) {
                    if (sourceentity instanceof Player _player) {
                        {
                            int finalLastIndex = 2;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.Style = finalLastIndex;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                        if (!_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Unlocked Itadori Style"), false);

                    }
                }
            } else if (entity instanceof KashimoHajimeEntity) {
                if (Math.random() < (1) / ((float) 200)) {
                    if (sourceentity instanceof Player _player) {
                        {
                            int finalLastIndex = 3;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.Style = finalLastIndex;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                        if (!_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Unlocked Kashimo Style"), false);

                    }
                }
            } else if (entity instanceof JogoEntity) {
                if (Math.random() < (1) / ((float) 200)) {
                    if (sourceentity instanceof Player _player) {
                        {
                            int finalLastIndex = 4;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.Style = finalLastIndex;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                        if (!_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Unlocked Jogo Style"), false);

                    }
                }
            } else if (entity instanceof FushiguroTojiEntity || entity instanceof FushiguroTojiBugEntity || entity instanceof ZeninMakiCullingGameEntity) {
                if (Math.random() < (1) / ((float) 200)) {
                    if (sourceentity instanceof Player _player) {
                        {
                            int finalLastIndex = 5;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.Style = finalLastIndex;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                        if (!_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Unlocked Toji Style"), false);

                    }
                }
            } else if (entity instanceof SukunaEntity || entity instanceof SukunaFushiguroEntity) {
                if (Math.random() < (1) / ((float) 200)) {
                    if (sourceentity instanceof Player _player) {
                        {
                            int finalLastIndex = 6;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.Style = finalLastIndex;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                        if (!_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Unlocked Sukuna Style"), false);

                    }
                }
            } else if (entity instanceof ItadoriShinjukuEntity || entity instanceof ItadoriYujiShinjukuEntity) {
                if (Math.random() < (1) / ((float) 200)) {
                    if (sourceentity instanceof Player _player) {
                        {
                            int finalLastIndex = 7;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.Style = finalLastIndex;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                        if (!_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Unlocked Itadori Shinjuku Style"), false);

                    }
                }
            }
        }

    }
}
