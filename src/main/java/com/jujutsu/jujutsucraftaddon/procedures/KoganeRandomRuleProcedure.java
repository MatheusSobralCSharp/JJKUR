package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class KoganeRandomRuleProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (Math.random() <= 0.01) {
            world.getLevelData().getGameRules().getRule(JujutsucraftaddonModGameRules.JJKU_ZONE_STACK).set(true, world.getServer());
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("Zone Stack Enabled"), false);
        } else if (Math.random() <= 0.02) {
            world.getLevelData().getGameRules().getRule(JujutsucraftaddonModGameRules.JJKU_OVERPOWERED_STUFF).set(false, world.getServer());
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("Extensions Disabled"), false);
        } else if (Math.random() <= 0.03) {
            world.getLevelData().getGameRules().getRule(JujutsucraftaddonModGameRules.JJKU_LIMB_LOSS).set(true, world.getServer());
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("Limb Loss Enabled"), false);
        } else if (Math.random() <= 0.04) {
            world.getLevelData().getGameRules().getRule(JujutsucraftaddonModGameRules.JJKU_SUKUNA_POSSESSION_ENABLED).set(true, world.getServer());
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("Sukuna Possession Enabled"), false);
        } else if (Math.random() <= 0.05) {
            world.getLevelData().getGameRules().getRule(JujutsucraftaddonModGameRules.JJKU_KENJAKU_LIMIT).set(true, world.getServer());
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("Kenjaku Limit Disabled"), false);
        } else if (Math.random() <= 0.06) {
            world.getLevelData().getGameRules().getRule(JujutsucraftaddonModGameRules.JJKU_NO_OPEN_FOR_SUKUNA).set(true, world.getServer());
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("Barrierless Domain Disabled"), false);
        } else if (Math.random() <= 0.07) {
            world.getLevelData().getGameRules().getRule(JujutsucraftaddonModGameRules.JJKU_CURSED_SPIRIT_REGEN)
                    .set((world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_CURSED_SPIRIT_REGEN)) + Mth.nextInt(RandomSource.create(), 0, 2), world.getServer());
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("Increased Cursed Spirit Regen"), false);
        } else if (Math.random() <= 0.08) {
            world.getLevelData().getGameRules().getRule(JujutsucraftaddonModGameRules.JJKU_DIFFICULTY)
                    .set((world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DIFFICULTY)) - Mth.nextInt(RandomSource.create(), 1, 10), world.getServer());
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("Increased Difficulty"), false);
        } else if (Math.random() <= 0.09) {
            world.getLevelData().getGameRules().getRule(JujutsucraftaddonModGameRules.JJKU_LIMB_LOSS_SPEED)
                    .set((world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_LIMB_LOSS_SPEED)) + Mth.nextInt(RandomSource.create(), 1, 10), world.getServer());
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("Increased Limbs Loss Speed"), false);
        } else if (Math.random() <= 0.1) {
            world.getLevelData().getGameRules().getRule(JujutsucraftaddonModGameRules.JJKU_DROP_RATE).set((world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) + Mth.nextInt(RandomSource.create(), 1, 10),
                    world.getServer());
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("Increased Drop Rate"), false);
        }
    }
}
