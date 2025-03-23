package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class QuestOutput1Procedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
        if (sourceentity == null)
            return;
        boolean hasFullStack = false;
        if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).QuestOutput == 0) {
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:shokovoice2")), SoundSource.NEUTRAL, 1, 1);
                } else {
                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:shokovoice2")), SoundSource.NEUTRAL, 1, 1, false);
                }
            }
            if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal((Component.translatable("dialoguevcshoko1").getString())), false);
            {
                String _setval = Component.translatable("dialoguequestrct").getString() + "#1";
                sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.QuestActive = _setval;
                    capability.syncPlayerVariables(sourceentity);
                });
            }
            {
                String _setval = "Heal 100 Jujutsu Sorcerers With Medicine" + Component.translatable("dialoguequestrct1").getString();
                sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Description = _setval;
                    capability.syncPlayerVariables(sourceentity);
                });
            }
            {
                double _setval = 1;
                sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Healed = _setval;
                    capability.syncPlayerVariables(sourceentity);
                });
            }
            {
                double _setval = 1;
                sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.QuestOutput = _setval;
                    capability.syncPlayerVariables(sourceentity);
                });
            }
        } else if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).QuestOutput == 2) {
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:shokovoice2")), SoundSource.NEUTRAL, 1, 1);
                } else {
                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:shokovoice2")), SoundSource.NEUTRAL, 1, 1, false);
                }
            }
            if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal((Component.translatable("dialoguevcshoko2").getString())), false);
            if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal((Component.translatable("dialoguequestrct").getString())), false);
            {
                String _setval = Component.translatable("dialoguequestrct").getString() + "#3";
                sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.QuestActive = _setval;
                    capability.syncPlayerVariables(sourceentity);
                });
            }
            {
                String _setval = "Heal 100 Jujutsu Sorcerers With Medicine" + Component.translatable("dialoguequestrct2").getString();
                sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Description = _setval;
                    capability.syncPlayerVariables(sourceentity);
                });
            }
            {
                double _setval = 3;
                sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.QuestOutput = _setval;
                    capability.syncPlayerVariables(sourceentity);
                });
            }
        } else if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).QuestOutput == 3) {
            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.WHITE_WOOL && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem().getCount() : 0) == 64) {
                hasFullStack = true;
            }
            if (hasFullStack) {
                if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Congratulations! You Did it!"), false);
                if (sourceentity instanceof ServerPlayer _player) {
                    Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:reverse_cursed_output"));
                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                    if (!_ap.isDone()) {
                        for (String criteria : _ap.getRemainingCriteria())
                            _player.getAdvancements().award(_adv, criteria);
                    }
                }
                {
                    String _setval = "";
                    sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.QuestActive = _setval;
                        capability.syncPlayerVariables(sourceentity);
                    });
                }
                {
                    String _setval = "";
                    sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.Description = _setval;
                        capability.syncPlayerVariables(sourceentity);
                    });
                }
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:shokovoice2")), SoundSource.NEUTRAL, 1, 1);
                    } else {
                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:shokovoice2")), SoundSource.NEUTRAL, 1, 1, false);
                    }
                }
                {
                    double _setval = 4;
                    sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.QuestOutput = _setval;
                        capability.syncPlayerVariables(sourceentity);
                    });
                }
            }
        } else if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).QuestOutput <= 4
                && (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).QuestOutput > 0) {
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:shokovoice2")), SoundSource.NEUTRAL, 1, 1);
                } else {
                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:shokovoice2")), SoundSource.NEUTRAL, 1, 1, false);
                }
            }
            if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("Baka! You Already Have This Quest Active or Done"), false);
        }
        if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mastery == 2) {
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:shokovoice2")), SoundSource.NEUTRAL, 1, 1);
                } else {
                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:shokovoice2")), SoundSource.NEUTRAL, 1, 1, false);
                }
            }
            if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal((Component.translatable("dialoguevcshoko3").getString())), false);
            {
                String _setval = Component.translatable("dialoguequestrct").getString() + "#3";
                sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.QuestActive = _setval;
                    capability.syncPlayerVariables(sourceentity);
                });
            }
            {
                String _setval = Component.translatable("dialoguequestrct3").getString();
                sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Description = _setval;
                    capability.syncPlayerVariables(sourceentity);
                });
            }
            {
                double _setval = 3;
                sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Mastery = _setval;
                    capability.syncPlayerVariables(sourceentity);
                });
            }
        }
    }
}
