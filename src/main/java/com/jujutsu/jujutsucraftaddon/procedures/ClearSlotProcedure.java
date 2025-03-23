package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import com.jujutsu.jujutsucraftaddon.world.inventory.YutaStorageMenu;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ClearSlotProcedure {
    public static void execute(LevelAccessor world, double test, Entity entity) {
        if (entity == null || !(entity instanceof Player player))
            return;
        if (entity instanceof Player _plr0 && _plr0.containerMenu instanceof YutaStorageMenu) {
            // Access guistate from YutaStorageMenu
            HashMap guistate = YutaStorageMenu.guistate;

            // Cast test value to integer for slot index
            int slotIndex = (int) test;

            // Retrieve the ItemStack from the specified slot using the ternary pattern
            ItemStack itemStack = (entity instanceof Player _plrSlotItem &&
                    _plrSlotItem.containerMenu instanceof Supplier<?> _splr &&
                    _splr.get() instanceof Map<?, ?> _slt && _slt.containsKey(slotIndex))
                    ? ((Slot) _slt.get(slotIndex)).getItem()
                    : ItemStack.EMPTY;

            System.out.println("Storing ItemStack from Slot " + slotIndex + ": " + itemStack);
            if (!itemStack.isEmpty()) {
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .ifPresent(capability -> {
                            // Switch-case to assign the itemStack to the correct slot
                            switch (slotIndex) {
                                case 1 -> capability.slot1 = ItemStack.EMPTY.copy();
                                case 2 -> capability.slot2 = ItemStack.EMPTY.copy();
                                case 3 -> capability.slot3 = ItemStack.EMPTY.copy();
                                case 4 -> capability.slot4 = ItemStack.EMPTY.copy();
                                case 5 -> capability.slot5 = ItemStack.EMPTY.copy();
                                case 6 -> capability.slot6 = ItemStack.EMPTY.copy();
                                case 7 -> capability.slot7 = ItemStack.EMPTY.copy();
                                case 8 -> capability.slot8 = ItemStack.EMPTY.copy();
                                case 9 -> capability.slot9 = ItemStack.EMPTY.copy();
                                case 10 -> capability.slot10 = ItemStack.EMPTY.copy();
                                case 11 -> capability.slot11 = ItemStack.EMPTY.copy();
                                case 12 -> capability.slot12 = ItemStack.EMPTY.copy();
                                case 13 -> capability.slot13 = ItemStack.EMPTY.copy();
                                case 14 -> capability.slot14 = ItemStack.EMPTY.copy();
                                case 15 -> capability.slot15 = ItemStack.EMPTY.copy();
                                case 16 -> capability.slot16 = ItemStack.EMPTY.copy();
                                case 17 -> capability.slot17 = ItemStack.EMPTY.copy();
                            }
                            // Sync player variables to save the changes
                            capability.syncPlayerVariables(entity);

                        });


            }
        }
    }
}
