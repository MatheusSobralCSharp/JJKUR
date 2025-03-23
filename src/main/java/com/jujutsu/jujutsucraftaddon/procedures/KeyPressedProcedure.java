package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class KeyPressedProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:enchained"))).isDone()
                && entity instanceof ServerPlayer _plr1 && _plr1.level() instanceof ServerLevel
                && _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:soul_research"))).isDone()) {
            if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Itadori")) {
                if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Death Painting")) {
                    if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel <= 3) {
                        if ((entity.getPersistentData().getString("Mode")).equals("Blood") || (entity.getPersistentData().getString("Mode")).equals("")) {
                            if (entity instanceof Player _player && !_player.level().isClientSide())
                                _player.displayClientMessage(Component.literal("\u00A7c\u00A7n\u00A7lItadori"), false);
                            {
                                double _setval = 21;
                                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.PlayerCurseTechnique2 = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putString("Mode", "Itadori");
                                entity.load(dataIndex);
                            }
                        } else if ((entity.getPersistentData().getString("Mode")).equals("Itadori")) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putString("Mode", "Blood");
                                entity.load(dataIndex);
                            }
                            {
                                double _setval = 10;
                                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.PlayerCurseTechnique2 = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                            if (entity instanceof Player _player && !_player.level().isClientSide())
                                _player.displayClientMessage(Component.literal("\u00A74\u00A7n\u00A7lBlood"), false);
                        }
                    } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel > 3) {
                        if ((entity.getPersistentData().getString("Mode")).equals("Shrine") || (entity.getPersistentData().getString("Mode")).equals("")) {
                            if (entity instanceof Player _player && !_player.level().isClientSide())
                                _player.displayClientMessage(Component.literal("\u00A7c\u00A7n\u00A7lItadori"), false);
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putString("Mode", "Itadori");
                                entity.load(dataIndex);
                            }
                            {
                                double _setval = 21;
                                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.PlayerCurseTechnique2 = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if ((entity.getPersistentData().getString("Mode")).equals("Itadori")) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putString("Mode", "Shrine");
                                entity.load(dataIndex);
                            }
                            {
                                double _setval = 1;
                                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.PlayerCurseTechnique2 = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                            if (entity instanceof Player _player && !_player.level().isClientSide())
                                _player.displayClientMessage(Component.literal("\u00A71\u00A7n\u00A7lSoul Shrine"), false);
                        }
                    }
                }
            }
        }
    }
}
