package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class SaveProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (Math.random() < 0.007) {
            {
                ItemStack _setval = new ItemStack(JujutsucraftaddonModItems.SWORD_OKKOTSU.get());
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.slot0 = _setval.copy();
                    capability.syncPlayerVariables(entity);
                });
            }
        } else if (Math.random() < 0.01 && Math.random() > 0.007) {
            {
                ItemStack _setval = new ItemStack(JujutsucraftaddonModItems.WARSTAFF.get());
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.slot0 = _setval.copy();
                    capability.syncPlayerVariables(entity);
                });
            }
        } else if (Math.random() > 0.01 && Math.random() < 0.5) {
            {
                ItemStack _setval = new ItemStack(JujutsucraftaddonModItems.STEEL_ARM.get());
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.slot0 = _setval.copy();
                    capability.syncPlayerVariables(entity);
                });
            }
        } else if (Math.random() > 0.5) {
            {
                ItemStack _setval = new ItemStack(JujutsucraftaddonModItems.SWORD_OKKOTSU_TWO.get());
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.slot0 = _setval.copy();
                    capability.syncPlayerVariables(entity);
                });
            }
        }

//        if (entity instanceof Player _plr0 && _plr0.containerMenu instanceof YutaStorageMenu) {
//            if (entity instanceof Player player) {
//                // Ensure the container is valid and extract all slots up to index 18
//                if (player.containerMenu instanceof Supplier<?> supplier) {
//                    Object container = supplier.get();
//                    if (container instanceof Map<?, ?> slots) {
//                        // Iterate through slots 1 to 17 (adjust index as needed)
//                        for (int i = 1; i <= 17; i++) {
//                            if (slots.get(i) instanceof Slot slot) {
//                                ItemStack itemStack = slot.getItem();
//
//                                // Debug log for extracted item stack
//                                if (itemStack.isEmpty()) {
//                                    System.out.println("Slot " + i + " is empty.");
//                                } else {
//                                    System.out.println("Storing ItemStack from Slot " + i + ": " + itemStack);
//                                }
//
//                                // Update capability variable dynamically
//                                final int index = i; // Effectively final for lambda
//                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null)
//                                        .ifPresent(capability -> {
//                                            switch (index) {
//                                                case 1 -> capability.slot1 = itemStack.copy();
//                                                case 2 -> capability.slot2 = itemStack.copy();
//                                                case 3 -> capability.slot3 = itemStack.copy();
//                                                case 4 -> capability.slot4 = itemStack.copy();
//                                                case 5 -> capability.slot5 = itemStack.copy();
//                                                case 6 -> capability.slot6 = itemStack.copy();
//                                                case 7 -> capability.slot7 = itemStack.copy();
//                                                case 8 -> capability.slot8 = itemStack.copy();
//                                                case 9 -> capability.slot9 = itemStack.copy();
//                                                case 10 -> capability.slot10 = itemStack.copy();
//                                                case 11 -> capability.slot11 = itemStack.copy();
//                                                case 12 -> capability.slot12 = itemStack.copy();
//                                                case 13 -> capability.slot13 = itemStack.copy();
//                                                case 14 -> capability.slot14 = itemStack.copy();
//                                                case 15 -> capability.slot15 = itemStack.copy();
//                                                case 16 -> capability.slot16 = itemStack.copy();
//                                                case 17 -> capability.slot17 = itemStack.copy();
//                                            }
//                                            capability.syncPlayerVariables(entity);
//                                        });
//                            }
//                        }
//                    }
//                }
//            }
//        }

        {
            boolean _setval = true;
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.save = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
    }
}
