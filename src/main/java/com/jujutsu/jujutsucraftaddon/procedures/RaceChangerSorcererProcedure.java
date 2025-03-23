package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import com.jujutsu.jujutsucraftaddon.world.inventory.RaceChangeMenu;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class RaceChangerSorcererProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        {
            CompoundTag dataIndex = new CompoundTag();
            entity.saveWithoutId(dataIndex);
            dataIndex.getCompound("ForgeData").putBoolean("JujutsuSorcerer", true);
            entity.load(dataIndex);
        }
        {
            CompoundTag dataIndex = new CompoundTag();
            entity.saveWithoutId(dataIndex);
            dataIndex.getCompound("ForgeData").putBoolean("CurseUser", false);
            entity.load(dataIndex);
        }
        {
            CompoundTag dataIndex = new CompoundTag();
            entity.saveWithoutId(dataIndex);
            dataIndex.getCompound("ForgeData").putBoolean("CursedSpirit", false);
            entity.load(dataIndex);
        }
        {
            boolean _setval = true;
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.IsJujutsuSorcerer = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
        {
            boolean _setval = false;
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.IsCursedSpirit = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
        {
            boolean _setval = false;
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.IsVessel = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
        {
            double _setval = 0;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.PlayerProfession = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
        if (entity instanceof Player _player) {
            ItemStack _stktoremove = new ItemStack(JujutsucraftaddonModItems.RACE_CHANGER.get());
            _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
        }
        if (entity instanceof Player _plr5 && _plr5.containerMenu instanceof RaceChangeMenu) {
            if (entity instanceof Player _player)
                _player.closeContainer();
        }
    }
}
