package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;
import java.util.function.Supplier;

public class ReadProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
            ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot0).copy();
            _setstack.setCount(1);
            ((Slot) _slots.get(0)).set(_setstack);
            _player.containerMenu.broadcastChanges();
        }
//        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
//            ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot1).copy();
//            _setstack.setCount(1);
//
//            ((Slot) _slots.get(1)).set(_setstack);
//            _player.containerMenu.broadcastChanges();
//        }
//        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
//            ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot2).copy();
//            _setstack.setCount(1);
//
//            ((Slot) _slots.get(2)).set(_setstack);
//            _player.containerMenu.broadcastChanges();
//        }
//        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
//            ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot3).copy();
//            _setstack.setCount(1);
//            ((Slot) _slots.get(3)).set(_setstack);
//            _player.containerMenu.broadcastChanges();
//        }
//        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
//            ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot4).copy();
//            _setstack.setCount(1);
//            ((Slot) _slots.get(4)).set(_setstack);
//            _player.containerMenu.broadcastChanges();
//        }
//        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
//            ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot5).copy();
//            _setstack.setCount(1);
//            ((Slot) _slots.get(5)).set(_setstack);
//            _player.containerMenu.broadcastChanges();
//        }
//        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
//            ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot6).copy();
//            _setstack.setCount(1);
//
//            ((Slot) _slots.get(6)).set(_setstack);
//            _player.containerMenu.broadcastChanges();
//        }
//        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
//            ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot7).copy();
//            _setstack.setCount(1);
//
//            ((Slot) _slots.get(7)).set(_setstack);
//            _player.containerMenu.broadcastChanges();
//        }
//        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
//            ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot8).copy();
//            _setstack.setCount(1);
//
//            ((Slot) _slots.get(8)).set(_setstack);
//            _player.containerMenu.broadcastChanges();
//        }
//        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
//            ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot9).copy();
//            _setstack.setCount(1);
//
//            ((Slot) _slots.get(9)).set(_setstack);
//            _player.containerMenu.broadcastChanges();
//        }
//        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
//            ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot10).copy();
//            _setstack.setCount(1);
//
//            ((Slot) _slots.get(10)).set(_setstack);
//            _player.containerMenu.broadcastChanges();
//        }
//        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
//            ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot11).copy();
//            _setstack.setCount(1);
//
//            ((Slot) _slots.get(11)).set(_setstack);
//            _player.containerMenu.broadcastChanges();
//        }
//        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
//            ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot12).copy();
//            _setstack.setCount(1);
//
//            ((Slot) _slots.get(12)).set(_setstack);
//            _player.containerMenu.broadcastChanges();
//        }
//        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
//            ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot13).copy();
//            _setstack.setCount(1);
//
//            ((Slot) _slots.get(13)).set(_setstack);
//            _player.containerMenu.broadcastChanges();
//        }
//        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
//            ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot14).copy();
//            _setstack.setCount(1);
//
//            ((Slot) _slots.get(14)).set(_setstack);
//            _player.containerMenu.broadcastChanges();
//        }
//        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
//            ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot15).copy();
//            _setstack.setCount(1);
//
//            ((Slot) _slots.get(15)).set(_setstack);
//            _player.containerMenu.broadcastChanges();
//        }
//        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
//            ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot16).copy();
//            _setstack.setCount(1);
//
//            ((Slot) _slots.get(16)).set(_setstack);
//            _player.containerMenu.broadcastChanges();
//        }
//        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
//            ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot17).copy();
//            _setstack.setCount(1);
//
//            ((Slot) _slots.get(17)).set(_setstack);
//            _player.containerMenu.broadcastChanges();
//        }
        if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Okkotsu")) {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("RikaRing");
                }
            }.getValue() == 0) {
                if (!(entity instanceof Player _playerHasItem && _playerHasItem.getInventory().contains(new ItemStack(JujutsucraftaddonModItems.YUTA_RING.get())))) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.YUTA_RING.get()).copy();
                        _setstack.setCount(1);
                        ((Slot) _slots.get(18)).set(_setstack);
                        _player.containerMenu.broadcastChanges();
                    }
                }
            } else if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("RikaRing");
                }
            }.getValue() == 1) {
                if (entity instanceof Player _playerHasItem && _playerHasItem.getInventory().contains(new ItemStack(JujutsucraftaddonModItems.YUTA_RING.get()))) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                        _setstack.setCount(1);
                        ((Slot) _slots.get(18)).set(_setstack);
                        _player.containerMenu.broadcastChanges();
                    }
                }
            }
        } else {
            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                _setstack.setCount(1);
                ((Slot) _slots.get(18)).set(_setstack);
                _player.containerMenu.broadcastChanges();
            }
        }
    }
}
