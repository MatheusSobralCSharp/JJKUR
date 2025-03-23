package com.jujutsu.jujutsucraftaddon.world.inventory;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMenus;
import com.jujutsu.jujutsucraftaddon.network.YutaStorageSlotMessage;
import com.jujutsu.jujutsucraftaddon.procedures.ExecuteProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.ReadProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.SaveProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@Mod.EventBusSubscriber
public class YutaStorageMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
    public final static HashMap<String, Object> guistate = new HashMap<>();
    public final Level world;
    public final Player entity;
    public int x, y, z;
    private ContainerLevelAccess access = ContainerLevelAccess.NULL;
    private IItemHandler internal;
    private final Map<Integer, Slot> customSlots = new HashMap<>();
    private boolean bound = false;
    private Supplier<Boolean> boundItemMatcher = null;
    private Entity boundEntity = null;
    private BlockEntity boundBlockEntity = null;


    public YutaStorageMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
        super(JujutsucraftaddonModMenus.YUTA_STORAGE.get(), id);
        this.entity = inv.player;
        this.world = inv.player.level();
        this.internal = new ItemStackHandler(19);
        BlockPos pos = null;
        if (extraData != null) {
            pos = extraData.readBlockPos();
            this.x = pos.getX();
            this.y = pos.getY();
            this.z = pos.getZ();
            access = ContainerLevelAccess.create(world, pos);
        }
        if (pos != null) {
            if (extraData.readableBytes() == 1) { // bound to item
                byte hand = extraData.readByte();
                ItemStack itemstack = hand == 0 ? this.entity.getMainHandItem() : this.entity.getOffhandItem();
                this.boundItemMatcher = () -> itemstack == (hand == 0 ? this.entity.getMainHandItem() : this.entity.getOffhandItem());
                itemstack.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                    this.internal = capability;
                    this.bound = true;
                });
            } else if (extraData.readableBytes() > 1) { // bound to entity
                extraData.readByte(); // drop padding
                boundEntity = world.getEntity(extraData.readVarInt());
                if (boundEntity != null)
                    boundEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                        this.internal = capability;
                        this.bound = true;
                    });
            } else { // might be bound to block
                boundBlockEntity = this.world.getBlockEntity(pos);
                if (boundBlockEntity != null)
                    boundBlockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
                        this.internal = capability;
                        this.bound = true;
                    });
            }
        }
        this.customSlots.put(0, this.addSlot(new SlotItemHandler(internal, 0, 93, 94) {
            private final int slot = 0;
            private final int x = YutaStorageMenu.this.x;
            private final int y = YutaStorageMenu.this.y;

            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }
        }));
        this.customSlots.put(1, this.addSlot(new SlotItemHandler(internal, 1, 11, 50) {
            private final int slot = 1;
            private final int x = YutaStorageMenu.this.x;
            private final int y = YutaStorageMenu.this.y;
            private ItemStack lastStack = ItemStack.EMPTY;

            @Override
            public boolean mayPlace(ItemStack stack) {
                return true;
            }

            @Override
            public void set(ItemStack stack) {
                super.set(stack);
                // Trigger logic when an item is placed in this slot
                if (!stack.isEmpty()) {
                    slotChanged(1, 0, 0); // Custom logic for item placement
                }
            }

            @Override
            public void onTake(Player entity, ItemStack stack) {
                super.onTake(entity, stack);
                if (!stack.isEmpty()) {
                    slotChanged(1, 1, 0);
                }
                lastStack = ItemStack.EMPTY; // Clear the tracked stack
            }

        }));
        this.customSlots.put(2, this.addSlot(new SlotItemHandler(internal, 2, 38, 50) {
            private final int slot = 2;
            private final int x = YutaStorageMenu.this.x;
            private final int y = YutaStorageMenu.this.y;
            private ItemStack lastStack = ItemStack.EMPTY;

            @Override
            public boolean mayPlace(ItemStack stack) {
                return true;
            }

            @Override
            public void set(ItemStack stack) {
                super.set(stack);
                // Trigger logic when an item is placed in this slot
                if (!stack.isEmpty()) {
                    slotChanged(2, 0, 0); // Custom logic for item placement
                }
            }

            @Override
            public void onTake(Player entity, ItemStack stack) {
                super.onTake(entity, stack);
                if (!stack.isEmpty()) {
                    slotChanged(2, 1, 0);
                }
                lastStack = ItemStack.EMPTY; // Clear the tracked stack
            }
        }));
        this.customSlots.put(3, this.addSlot(new SlotItemHandler(internal, 3, 11, 79) {
            private final int slot = 3;
            private final int x = YutaStorageMenu.this.x;
            private final int y = YutaStorageMenu.this.y;

            @Override
            public boolean mayPlace(ItemStack stack) {
                return true;
            }

            private ItemStack lastStack = ItemStack.EMPTY;


            @Override
            public void set(ItemStack stack) {
                super.set(stack);
                // Trigger logic when an item is placed in this slot
                if (!stack.isEmpty()) {
                    slotChanged(3, 0, 0); // Custom logic for item placement
                }
            }

            @Override
            public void onTake(Player entity, ItemStack stack) {
                super.onTake(entity, stack);
                if (!stack.isEmpty()) {
                    slotChanged(3, 1, 0);
                }
                lastStack = ItemStack.EMPTY; // Clear the tracked stack
            }
        }));
        this.customSlots.put(4, this.addSlot(new SlotItemHandler(internal, 4, 38, 79) {
            private final int slot = 4;
            private final int x = YutaStorageMenu.this.x;
            private final int y = YutaStorageMenu.this.y;

            @Override
            public boolean mayPlace(ItemStack stack) {
                return true;
            }

            private ItemStack lastStack = ItemStack.EMPTY;


            @Override
            public void set(ItemStack stack) {
                super.set(stack);
                // Trigger logic when an item is placed in this slot
                if (!stack.isEmpty()) {
                    slotChanged(4, 0, 0); // Custom logic for item placement
                }
            }

            @Override
            public void onTake(Player entity, ItemStack stack) {
                super.onTake(entity, stack);
                if (!stack.isEmpty()) {
                    slotChanged(4, 1, 0);
                }
                lastStack = ItemStack.EMPTY; // Clear the tracked stack
            }

        }));
        this.customSlots.put(5, this.addSlot(new SlotItemHandler(internal, 5, 119, 50) {
            private final int slot = 5;
            private final int x = YutaStorageMenu.this.x;
            private final int y = YutaStorageMenu.this.y;

            @Override
            public boolean mayPlace(ItemStack stack) {
                return true;
            }

            private ItemStack lastStack = ItemStack.EMPTY;


            @Override
            public void set(ItemStack stack) {
                super.set(stack);
                // Trigger logic when an item is placed in this slot
                if (!stack.isEmpty()) {
                    slotChanged(5, 0, 0); // Custom logic for item placement
                }
            }

            @Override
            public void onTake(Player entity, ItemStack stack) {
                super.onTake(entity, stack);
                if (!stack.isEmpty()) {
                    slotChanged(5, 1, 0);
                }
                lastStack = ItemStack.EMPTY; // Clear the tracked stack
            }


        }));
        this.customSlots.put(6, this.addSlot(new SlotItemHandler(internal, 6, 146, 50) {
            private final int slot = 6;
            private final int x = YutaStorageMenu.this.x;
            private final int y = YutaStorageMenu.this.y;

            @Override
            public boolean mayPlace(ItemStack stack) {
                return true;
            }

            private ItemStack lastStack = ItemStack.EMPTY;


            @Override
            public void set(ItemStack stack) {
                super.set(stack);
                // Trigger logic when an item is placed in this slot
                if (!stack.isEmpty()) {
                    slotChanged(6, 0, 0); // Custom logic for item placement
                }
            }

            @Override
            public void onTake(Player entity, ItemStack stack) {
                super.onTake(entity, stack);
                if (!stack.isEmpty()) {
                    slotChanged(6, 1, 0);
                }
                lastStack = ItemStack.EMPTY; // Clear the tracked stack
            }

        }));
        this.customSlots.put(7, this.addSlot(new SlotItemHandler(internal, 7, 119, 79) {
            private final int slot = 7;
            private final int x = YutaStorageMenu.this.x;
            private final int y = YutaStorageMenu.this.y;

            @Override
            public boolean mayPlace(ItemStack stack) {
                return true;
            }

            private ItemStack lastStack = ItemStack.EMPTY;


            @Override
            public void set(ItemStack stack) {
                super.set(stack);
                // Trigger logic when an item is placed in this slot
                if (!stack.isEmpty()) {
                    slotChanged(7, 0, 0); // Custom logic for item placement
                }
            }

            @Override
            public void onTake(Player entity, ItemStack stack) {
                super.onTake(entity, stack);
                if (!stack.isEmpty()) {
                    slotChanged(7, 1, 0);
                }
                lastStack = ItemStack.EMPTY; // Clear the tracked stack
            }


        }));
        this.customSlots.put(8, this.addSlot(new SlotItemHandler(internal, 8, 146, 79) {
            private final int slot = 8;
            private final int x = YutaStorageMenu.this.x;
            private final int y = YutaStorageMenu.this.y;

            @Override
            public boolean mayPlace(ItemStack stack) {
                return true;
            }

            private ItemStack lastStack = ItemStack.EMPTY;


            @Override
            public void set(ItemStack stack) {
                super.set(stack);
                // Trigger logic when an item is placed in this slot
                if (!stack.isEmpty()) {
                    slotChanged(8, 0, 0); // Custom logic for item placement
                }
            }

            @Override
            public void onTake(Player entity, ItemStack stack) {
                super.onTake(entity, stack);
                if (!stack.isEmpty()) {
                    slotChanged(8, 1, 0);
                }
                lastStack = ItemStack.EMPTY; // Clear the tracked stack
            }

        }));
        this.customSlots.put(9, this.addSlot(new SlotItemHandler(internal, 9, 65, 79) {
            private final int slot = 9;
            private final int x = YutaStorageMenu.this.x;
            private final int y = YutaStorageMenu.this.y;

            @Override
            public boolean mayPlace(ItemStack stack) {
                return true;
            }

            private ItemStack lastStack = ItemStack.EMPTY;


            @Override
            public void set(ItemStack stack) {
                super.set(stack);
                // Trigger logic when an item is placed in this slot
                if (!stack.isEmpty()) {
                    slotChanged(9, 0, 0); // Custom logic for item placement
                }
            }

            @Override
            public void onTake(Player entity, ItemStack stack) {
                super.onTake(entity, stack);
                if (!stack.isEmpty()) {
                    slotChanged(9, 1, 0);
                }
                lastStack = ItemStack.EMPTY; // Clear the tracked stack
            }


        }));
        this.customSlots.put(10, this.addSlot(new SlotItemHandler(internal, 10, 65, 50) {
            private final int slot = 10;
            private final int x = YutaStorageMenu.this.x;
            private final int y = YutaStorageMenu.this.y;

            @Override
            public boolean mayPlace(ItemStack stack) {
                return true;
            }

            private ItemStack lastStack = ItemStack.EMPTY;


            @Override
            public void set(ItemStack stack) {
                super.set(stack);
                // Trigger logic when an item is placed in this slot
                if (!stack.isEmpty()) {
                    slotChanged(10, 0, 0); // Custom logic for item placement
                }
            }

            @Override
            public void onTake(Player entity, ItemStack stack) {
                super.onTake(entity, stack);
                if (!stack.isEmpty()) {
                    slotChanged(10, 1, 0);
                }
                lastStack = ItemStack.EMPTY; // Clear the tracked stack
            }

        }));
        this.customSlots.put(11, this.addSlot(new SlotItemHandler(internal, 11, 173, 79) {
            private final int slot = 11;
            private final int x = YutaStorageMenu.this.x;
            private final int y = YutaStorageMenu.this.y;

            @Override
            public boolean mayPlace(ItemStack stack) {
                return true;
            }

            private ItemStack lastStack = ItemStack.EMPTY;


            @Override
            public void set(ItemStack stack) {
                super.set(stack);
                // Trigger logic when an item is placed in this slot
                if (!stack.isEmpty()) {
                    slotChanged(11, 0, 0); // Custom logic for item placement
                }
            }

            @Override
            public void onTake(Player entity, ItemStack stack) {
                super.onTake(entity, stack);
                if (!stack.isEmpty()) {
                    slotChanged(11, 1, 0);
                }
                lastStack = ItemStack.EMPTY; // Clear the tracked stack
            }


        }));
        this.customSlots.put(12, this.addSlot(new SlotItemHandler(internal, 12, 173, 50) {
            private final int slot = 12;
            private final int x = YutaStorageMenu.this.x;
            private final int y = YutaStorageMenu.this.y;

            @Override
            public boolean mayPlace(ItemStack stack) {
                return true;
            }
            private ItemStack lastStack = ItemStack.EMPTY;


            @Override
            public void set(ItemStack stack) {
                super.set(stack);
                // Trigger logic when an item is placed in this slot
                if (!stack.isEmpty()) {
                    slotChanged(12, 0, 0); // Custom logic for item placement
                }
            }

            @Override
            public void onTake(Player entity, ItemStack stack) {
                super.onTake(entity, stack);
                if (!stack.isEmpty()) {
                    slotChanged(12, 1, 0);
                }
                lastStack = ItemStack.EMPTY; // Clear the tracked stack
            }

        }));
        this.customSlots.put(13, this.addSlot(new SlotItemHandler(internal, 13, 173, 20) {
            private final int slot = 13;
            private final int x = YutaStorageMenu.this.x;
            private final int y = YutaStorageMenu.this.y;

            @Override
            public boolean mayPlace(ItemStack stack) {
                return true;
            }

            private ItemStack lastStack = ItemStack.EMPTY;


            @Override
            public void set(ItemStack stack) {
                super.set(stack);
                // Trigger logic when an item is placed in this slot
                if (!stack.isEmpty()) {
                    slotChanged(13, 0, 0); // Custom logic for item placement
                }
            }

            @Override
            public void onTake(Player entity, ItemStack stack) {
                super.onTake(entity, stack);
                if (!stack.isEmpty()) {
                    slotChanged(13, 1, 0);
                }
                lastStack = ItemStack.EMPTY; // Clear the tracked stack
            }


        }));
        this.customSlots.put(14, this.addSlot(new SlotItemHandler(internal, 14, 146, 20) {
            private final int slot = 14;
            private final int x = YutaStorageMenu.this.x;
            private final int y = YutaStorageMenu.this.y;

            @Override
            public boolean mayPlace(ItemStack stack) {
                return true;
            }
            private ItemStack lastStack = ItemStack.EMPTY;


            @Override
            public void set(ItemStack stack) {
                super.set(stack);
                // Trigger logic when an item is placed in this slot
                if (!stack.isEmpty()) {
                    slotChanged(14, 0, 0); // Custom logic for item placement
                }
            }

            @Override
            public void onTake(Player entity, ItemStack stack) {
                super.onTake(entity, stack);
                if (!stack.isEmpty()) {
                    slotChanged(14, 1, 0);
                }
                lastStack = ItemStack.EMPTY; // Clear the tracked stack
            }

        }));
        this.customSlots.put(15, this.addSlot(new SlotItemHandler(internal, 15, 119, 20) {
            private final int slot = 15;
            private final int x = YutaStorageMenu.this.x;
            private final int y = YutaStorageMenu.this.y;

            @Override
            public boolean mayPlace(ItemStack stack) {
                return true;
            }

            private ItemStack lastStack = ItemStack.EMPTY;


            @Override
            public void set(ItemStack stack) {
                super.set(stack);
                // Trigger logic when an item is placed in this slot
                if (!stack.isEmpty()) {
                    slotChanged(15, 0, 0); // Custom logic for item placement
                }
            }

            @Override
            public void onTake(Player entity, ItemStack stack) {
                super.onTake(entity, stack);
                if (!stack.isEmpty()) {
                    slotChanged(15, 1, 0);
                }
                lastStack = ItemStack.EMPTY; // Clear the tracked stack
            }
        }));
        this.customSlots.put(16, this.addSlot(new SlotItemHandler(internal, 16, 10, 21) {
            private final int slot = 16;
            private final int x = YutaStorageMenu.this.x;
            private final int y = YutaStorageMenu.this.y;

            @Override
            public boolean mayPlace(ItemStack stack) {
                return true;
            }
            private ItemStack lastStack = ItemStack.EMPTY;


            @Override
            public void set(ItemStack stack) {
                super.set(stack);
                // Trigger logic when an item is placed in this slot
                if (!stack.isEmpty()) {
                    slotChanged(16, 0, 0); // Custom logic for item placement
                }
            }

            @Override
            public void onTake(Player entity, ItemStack stack) {
                super.onTake(entity, stack);
                if (!stack.isEmpty()) {
                    slotChanged(16, 1, 0);
                }
                lastStack = ItemStack.EMPTY; // Clear the tracked stack
            }

        }));
        this.customSlots.put(17, this.addSlot(new SlotItemHandler(internal, 17, 38, 21) {
            private final int slot = 17;
            private final int x = YutaStorageMenu.this.x;
            private final int y = YutaStorageMenu.this.y;

            @Override
            public boolean mayPlace(ItemStack stack) {
                return true;
            }
            private ItemStack lastStack = ItemStack.EMPTY;


            @Override
            public void set(ItemStack stack) {
                super.set(stack);
                // Trigger logic when an item is placed in this slot
                if (!stack.isEmpty()) {
                    slotChanged(17, 0, 0); // Custom logic for item placement
                }
            }

            @Override
            public void onTake(Player entity, ItemStack stack) {
                super.onTake(entity, stack);
                if (!stack.isEmpty()) {
                    slotChanged(17, 1, 0);
                }
                lastStack = ItemStack.EMPTY; // Clear the tracked stack
            }
        }));
        this.customSlots.put(18, this.addSlot(new SlotItemHandler(internal, 18, 65, 21) {
            private final int slot = 18;
            private final int x = YutaStorageMenu.this.x;
            private final int y = YutaStorageMenu.this.y;

            @Override
            public boolean mayPlace(ItemStack stack) {
                return true;
            }

            private ItemStack lastStack = ItemStack.EMPTY;


            @Override
            public void set(ItemStack stack) {
                super.set(stack);
                // Trigger logic when an item is placed in this slot
                if (!stack.isEmpty()) {
                    slotChanged(18, 0, 0); // Custom logic for item placement
                }
            }

            @Override
            public void onTake(Player entity, ItemStack stack) {
                super.onTake(entity, stack);
                if (!stack.isEmpty()) {
                    slotChanged(18, 1, 0);
                }
                lastStack = ItemStack.EMPTY; // Clear the tracked stack
            }

        }));
        for (int si = 0; si < 3; ++si)
            for (int sj = 0; sj < 9; ++sj)
                this.addSlot(new Slot(inv, sj + (si + 1) * 9, 13 + 8 + sj * 18, 33 + 84 + si * 18));
        for (int si = 0; si < 9; ++si)
            this.addSlot(new Slot(inv, si, 13 + 8 + si * 18, 33 + 142));
        ReadProcedure.execute(entity);

    }

    @Override
    public boolean stillValid(Player player) {
        if (this.bound) {
            if (this.boundItemMatcher != null)
                return this.boundItemMatcher.get();
            else if (this.boundBlockEntity != null)
                return AbstractContainerMenu.stillValid(this.access, player, this.boundBlockEntity.getBlockState().getBlock());
            else if (this.boundEntity != null)
                return this.boundEntity.isAlive();
        }
        return true;
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index < 19) {
                if (!this.moveItemStackTo(itemstack1, 19, this.slots.size(), true))
                    return ItemStack.EMPTY;
                slot.onQuickCraft(itemstack1, itemstack);
            } else if (!this.moveItemStackTo(itemstack1, 0, 19, false)) {
                if (index < 19 + 27) {
                    if (!this.moveItemStackTo(itemstack1, 19 + 27, this.slots.size(), true))
                        return ItemStack.EMPTY;
                } else {
                    if (!this.moveItemStackTo(itemstack1, 19, 19 + 27, false))
                        return ItemStack.EMPTY;
                }
                return ItemStack.EMPTY;
            }


            if (itemstack1.getCount() == 0)
                slot.set(ItemStack.EMPTY);
            else
                slot.setChanged();

            if (itemstack1.getCount() == itemstack.getCount())
                return ItemStack.EMPTY;
            slot.onTake(playerIn, itemstack1);
        }
        return itemstack;
    }

    @Override
    protected boolean moveItemStackTo(ItemStack p_38904_, int p_38905_, int p_38906_, boolean p_38907_) {
        boolean flag = false;
        int i = p_38905_;
        if (p_38907_) {
            i = p_38906_ - 1;
        }
        if (p_38904_.isStackable()) {
            while (!p_38904_.isEmpty()) {
                if (p_38907_) {
                    if (i < p_38905_) {
                        break;
                    }
                } else if (i >= p_38906_) {
                    break;
                }
                Slot slot = this.slots.get(i);
                ItemStack itemstack = slot.getItem();
                if (slot.mayPlace(itemstack) && !itemstack.isEmpty() && ItemStack.isSameItemSameTags(p_38904_, itemstack)) {
                    int j = itemstack.getCount() + p_38904_.getCount();
                    int maxSize = Math.min(slot.getMaxStackSize(), p_38904_.getMaxStackSize());
                    if (j <= maxSize) {
                        p_38904_.setCount(0);
                        itemstack.setCount(j);
                        slot.set(itemstack);
                        flag = true;
                    } else if (itemstack.getCount() < maxSize) {
                        p_38904_.shrink(maxSize - itemstack.getCount());
                        itemstack.setCount(maxSize);
                        slot.set(itemstack);
                        flag = true;
                    }
                }

                if (p_38907_) {
                    --i;
                } else {
                    ++i;
                }
            }
        }
        if (!p_38904_.isEmpty()) {
            if (p_38907_) {
                i = p_38906_ - 1;
            } else {
                i = p_38905_;
            }
            while (true) {
                if (p_38907_) {
                    if (i < p_38905_) {
                        break;
                    }
                } else if (i >= p_38906_) {
                    break;
                }
                Slot slot1 = this.slots.get(i);
                ItemStack itemstack1 = slot1.getItem();
                if (itemstack1.isEmpty() && slot1.mayPlace(p_38904_)) {
                    if (p_38904_.getCount() > slot1.getMaxStackSize()) {
                        slot1.setByPlayer(p_38904_.split(slot1.getMaxStackSize()));
                    } else {
                        slot1.setByPlayer(p_38904_.split(p_38904_.getCount()));
                    }
                    slot1.setChanged();
                    flag = true;
                    break;
                }
                if (p_38907_) {
                    --i;
                } else {
                    ++i;
                }
            }
        }
        return flag;
    }

    @Override
    public void removed(Player playerIn) {
        super.removed(playerIn);
        SaveProcedure.execute(entity);
        if (!bound && playerIn instanceof ServerPlayer serverPlayer) {
            if (!serverPlayer.isAlive() || serverPlayer.hasDisconnected()) {
                for (int j = 0; j < internal.getSlots(); ++j) {
                    if (j == 0)
                        continue;
                    if (j == 1)
                        continue;
                    if (j == 2)
                        continue;
                    if (j == 3)
                        continue;
                    if (j == 4)
                        continue;
                    if (j == 5)
                        continue;
                    if (j == 6)
                        continue;
                    if (j == 7)
                        continue;
                    if (j == 8)
                        continue;
                    if (j == 9)
                        continue;
                    if (j == 10)
                        continue;
                    if (j == 11)
                        continue;
                    if (j == 12)
                        continue;
                    if (j == 13)
                        continue;
                    if (j == 14)
                        continue;
                    if (j == 15)
                        continue;
                    if (j == 16)
                        continue;
                    if (j == 17)
                        continue;
                    if (j == 18)
                        continue;
                    playerIn.drop(internal.extractItem(j, internal.getStackInSlot(j).getCount(), false), false);
                }
            } else {
                for (int i = 0; i < internal.getSlots(); ++i) {
                    if (i == 0)
                        continue;
                    if (i == 1)
                        continue;
                    if (i == 2)
                        continue;
                    if (i == 3)
                        continue;
                    if (i == 4)
                        continue;
                    if (i == 5)
                        continue;
                    if (i == 6)
                        continue;
                    if (i == 7)
                        continue;
                    if (i == 8)
                        continue;
                    if (i == 9)
                        continue;
                    if (i == 10)
                        continue;
                    if (i == 11)
                        continue;
                    if (i == 12)
                        continue;
                    if (i == 13)
                        continue;
                    if (i == 14)
                        continue;
                    if (i == 15)
                        continue;
                    if (i == 16)
                        continue;
                    if (i == 17)
                        continue;
                    if (i == 18)
                        continue;
                    playerIn.getInventory().placeItemBackInInventory(internal.extractItem(i, internal.getStackInSlot(i).getCount(), false));
                }
            }
        }
    }


    private void slotChanged(int slotid, int ctype, int meta) {
        if (this.world != null && this.world.isClientSide()) {
            JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new YutaStorageSlotMessage(slotid, x, y, z, ctype, meta));
            YutaStorageSlotMessage.handleSlotAction(entity, slotid, ctype, meta, x, y, z);
        }
    }


    public Map<Integer, Slot> get() {
        return customSlots;
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player entity = event.player;
        if (event.phase == TickEvent.Phase.END && entity.containerMenu instanceof YutaStorageMenu) {
            Level world = entity.level();
            double x = entity.getX();
            double y = entity.getY();
            double z = entity.getZ();
            ExecuteProcedure.execute(world, entity);
        }
    }
}
