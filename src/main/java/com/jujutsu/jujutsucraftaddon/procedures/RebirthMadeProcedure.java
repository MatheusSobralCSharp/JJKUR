package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class RebirthMadeProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;

        if (!(entity instanceof ServerPlayer _plr1 && _plr1.level() instanceof ServerLevel
                && _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:grade_yin_yang"))).isDone())) {
            if (entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel
                    && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:grade_ryomen_sage"))).isDone()) {
                if (entity instanceof ServerPlayer _player) {
                    Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:grade_yin_yang"));
                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                    if (!_ap.isDone()) {
                        for (String criteria : _ap.getRemainingCriteria())
                            _player.getAdvancements().award(_adv, criteria);
                    }
                }
                if (entity instanceof Player _player) {
                    ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.RACE_CHANGER.get()).copy();
                    _setstack.setCount(20);
                    ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                }
                if (entity instanceof Player _player) {
                    ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.CLAN_CHANGER.get()).copy();
                    _setstack.setCount(20);
                    ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                }
                if (entity instanceof Player _player) {
                    ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.RANDOM_CT_CHANGER.get()).copy();
                    _setstack.setCount(20);
                    ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                }
            } else if (entity instanceof ServerPlayer _plr5 && _plr5.level() instanceof ServerLevel
                    && _plr5.getAdvancements().getOrStartProgress(_plr5.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:grade_wu"))).isDone()) {
                if (entity instanceof ServerPlayer _player) {
                    Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:grade_ryomen_sage"));
                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                    if (!_ap.isDone()) {
                        for (String criteria : _ap.getRemainingCriteria())
                            _player.getAdvancements().award(_adv, criteria);
                    }
                }
                if (entity instanceof Player _player) {
                    ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.RANDOM_CT_CHANGER.get()).copy();
                    _setstack.setCount(12);
                    ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                }
                if (entity instanceof Player _player) {
                    ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.CLAN_CHANGER.get()).copy();
                    _setstack.setCount(12);
                    ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                }
                if (entity instanceof Player _player) {
                    ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.RACE_CHANGER.get()).copy();
                    _setstack.setCount(12);
                    ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                }
            }
            if (!(entity instanceof ServerPlayer _plr10 && _plr10.level() instanceof ServerLevel
                    && _plr10.getAdvancements().getOrStartProgress(_plr10.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:grade_wu"))).isDone())) {
                if (entity instanceof ServerPlayer _player) {
                    Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:grade_wu"));
                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                    if (!_ap.isDone()) {
                        for (String criteria : _ap.getRemainingCriteria())
                            _player.getAdvancements().award(_adv, criteria);
                    }
                }
                if (entity instanceof Player _player) {
                    ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.RANDOM_CT_CHANGER.get()).copy();
                    _setstack.setCount(9);
                    ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                }
                if (entity instanceof Player _player) {
                    ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.CLAN_CHANGER.get()).copy();
                    _setstack.setCount(9);
                    ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                }
                if (entity instanceof Player _player) {
                    ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.RACE_CHANGER.get()).copy();
                    _setstack.setCount(9);
                    ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                }
            }
            {
                Entity _ent = entity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                            _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "advancement revoke @s only jujutsucraftaddon:special_grade_one");
                }
            }
            {
                Entity _ent = entity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                            _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "advancement revoke @s only jujutsucraftaddon:strong_sorcerer_grade");
                }
            }
            {
                Entity _ent = entity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                            _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "advancement revoke @s only jujutsucraftaddon:sorcerer_strongest_of_history");
                }
            }
            {
                Entity _ent = entity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                            _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "advancement revoke @s only jujutsucraftaddon:sorcerer_strongest_of_modern");
                }
            }
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:congratulations")), SoundSource.NEUTRAL, 1, 1);
                } else {
                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:congratulations")), SoundSource.NEUTRAL, 1, 1, false);
                }
            }
            {
                double _setval = 0;
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.CursedLevel = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
            if (entity instanceof Player _player)
                _player.closeContainer();
        }
    }
}
