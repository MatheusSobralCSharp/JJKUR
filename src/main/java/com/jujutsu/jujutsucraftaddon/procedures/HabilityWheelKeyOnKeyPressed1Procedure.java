package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class HabilityWheelKeyOnKeyPressed1Procedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("Selectore");
            }
        }.getValue() == 0) {
            if (entity.isShiftKeyDown()) {
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Reverse Cursed Technique Burnout: Selected"), false);
                {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("Selectore", 1);
                    entity.load(dataIndex);
                }
            }
        } else if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("Selectore");
            }
        }.getValue() == 1) {
            if (!entity.isShiftKeyDown()) {
                RCTBurnoutKeyProcedure.execute(entity);
            } else if (entity.isShiftKeyDown()) {
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Domain Expansion Barrierless: Selected"), false);
                {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("Selectore", 2);
                    entity.load(dataIndex);
                }
            }
        } else if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("Selectore");
            }
        }.getValue() == 2) {
            if (!entity.isShiftKeyDown()) {
                BarrierlessKeyOnKeyPressedProcedure.execute(world, entity);
            } else if (entity.isShiftKeyDown()) {
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Reverse Cursed Mastery: Selected"), false);
                {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("Selectore", 3);
                    entity.load(dataIndex);
                }
            }
        } else if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("Selectore");
            }
        }.getValue() == 3) {
            if (!entity.isShiftKeyDown()) {
                RCTMasteryKeyOnKeyPressedProcedure.execute(world, entity);
            } else if (entity.isShiftKeyDown()) {
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Reverse Cursed Technique Output: Selected"), false);
                {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("Selectore", 4);
                    entity.load(dataIndex);
                }
            }
        } else if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("Selectore");
            }
        }.getValue() == 4) {
            if (!entity.isShiftKeyDown()) {
                RCTOutputKeyOnKeyPressedProcedure.execute(entity);
            } else if (entity.isShiftKeyDown()) {
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Extension Cursed Technique: Selected"), false);
                {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("Selectore", 5);
                    entity.load(dataIndex);
                }
            }
        } else if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("Selectore");
            }
        }.getValue() == 5) {
            if (!entity.isShiftKeyDown()) {
                ExtensionDomainKeyOnPressedProcedure.execute(world, entity);
            } else if (entity.isShiftKeyDown()) {
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Simple Domain Technique: Selected"), false);
                {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("Selectore", 6);
                    entity.load(dataIndex);
                }
            }
        } else if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("Selectore");
            }
        }.getValue() == 6) {
            if (!entity.isShiftKeyDown()) {
                SimpleDomainKeyOnKeyPressedProcedure.execute(entity);
            } else if (entity.isShiftKeyDown()) {
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Reverse Cursed Technique Output: Selected"), false);
                {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("Selectore", 0);
                    entity.load(dataIndex);
                }
            }
        }
    }
}
