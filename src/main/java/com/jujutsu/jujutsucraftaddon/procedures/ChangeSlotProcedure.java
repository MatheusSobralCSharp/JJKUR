package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;

import java.util.concurrent.atomic.AtomicReference;

public class ChangeSlotProcedure {
    public static void execute(LevelAccessor world, int slotIndex, ItemStack itemStack, Entity entity) {
        if (entity == null || !(entity instanceof Player player))
            return;


        AtomicReference<IItemHandler> itemHandlerRef = new AtomicReference<>();
        AtomicReference<ItemStack> copiedItemStackRef = new AtomicReference<>();

        // Get the item handler capability from the entity
        entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(itemHandlerRef::set);

        if (itemHandlerRef.get() != null && !itemStack.isEmpty()) {
            // Copy the provided item stack and preserve its NBT data
            ItemStack copiedItemStack = itemStack.copy();
            CompoundTag nbtData = itemStack.getTag(); // Get the NBT data of the provided item stack

            if (nbtData != null) {
                copiedItemStack.setTag(nbtData.copy()); // Copy and set the NBT data to the copied stack
            }

            copiedItemStackRef.set(copiedItemStack);

            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .ifPresent(capability -> {
                        ItemStack currentStack = copiedItemStackRef.get();

                        // Update the appropriate slot based on the index
                        switch (slotIndex) {
                            case 1 -> capability.slot1 = currentStack;
                            case 2 -> capability.slot2 = currentStack;
                            case 3 -> capability.slot3 = currentStack;
                            case 4 -> capability.slot4 = currentStack;
                            case 5 -> capability.slot5 = currentStack;
                            case 6 -> capability.slot6 = currentStack;
                            case 7 -> capability.slot7 = currentStack;
                            case 8 -> capability.slot8 = currentStack;
                            case 9 -> capability.slot9 = currentStack;
                            case 10 -> capability.slot10 = currentStack;
                            case 11 -> capability.slot11 = currentStack;
                            case 12 -> capability.slot12 = currentStack;
                            case 13 -> capability.slot13 = currentStack;
                            case 14 -> capability.slot14 = currentStack;
                            case 15 -> capability.slot15 = currentStack;
                            case 16 -> capability.slot16 = currentStack;
                            case 17 -> capability.slot17 = currentStack;
                        }

                        // Sync player variables to save the changes
                        capability.syncPlayerVariables(entity);
                    });
        } else {
            System.err.println("Item handler not found or provided item stack is empty.");
        }

    }
}
