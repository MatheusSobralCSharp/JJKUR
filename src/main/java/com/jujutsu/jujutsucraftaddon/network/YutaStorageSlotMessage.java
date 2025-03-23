package com.jujutsu.jujutsucraftaddon.network;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.procedures.ChangeSlotProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.ClearSlotProcedure;
import com.jujutsu.jujutsucraftaddon.world.inventory.YutaStorageMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class YutaStorageSlotMessage {
    private final int slotID, x, y, z, changeType, meta;

    public YutaStorageSlotMessage(int slotID, int x, int y, int z, int changeType, int meta) {
        this.slotID = slotID;
        this.x = x;
        this.y = y;
        this.z = z;
        this.changeType = changeType;
        this.meta = meta;
    }

    public YutaStorageSlotMessage(FriendlyByteBuf buffer) {
        this.slotID = buffer.readInt();
        this.x = buffer.readInt();
        this.y = buffer.readInt();
        this.z = buffer.readInt();
        this.changeType = buffer.readInt();
        this.meta = buffer.readInt();
    }

    public static void buffer(YutaStorageSlotMessage message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.slotID);
        buffer.writeInt(message.x);
        buffer.writeInt(message.y);
        buffer.writeInt(message.z);
        buffer.writeInt(message.changeType);
        buffer.writeInt(message.meta);
    }

    public static void handler(YutaStorageSlotMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            Player entity = context.getSender();
            int slotID = message.slotID;
            int changeType = message.changeType;
            int meta = message.meta;
            int x = message.x;
            int y = message.y;
            int z = message.z;
            handleSlotAction(entity, slotID, changeType, meta, x, y, z);
        });
        context.setPacketHandled(true);
    }

    public static void handleSlotAction(Player entity, int slot, int changeType, int meta, int x, int y, int z) {
        Level world = entity.level();
        HashMap guistate = YutaStorageMenu.guistate;
        ItemStack itemStack = ItemStack.EMPTY;

        // Retrieve the item from the specified slot
        if (entity.containerMenu instanceof Supplier<?> supplier && supplier.get() instanceof Map<?, ?> slots) {
            if (slots.containsKey(slot)) {
                itemStack = ((Slot) slots.get(slot)).getItem().copy(); // Ensure full copy, including tags
            }
        }
        // security measure to prevent arbitrary chunk generation
        if (!world.hasChunkAt(new BlockPos(x, y, z)))
            return;

        switch (slot) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                if (changeType == 0) {
                    ChangeSlotProcedure.execute(world, slot, itemStack, entity);
                } else if (changeType == 1) {
                    ClearSlotProcedure.execute(world, slot, entity);
                }
                break;
            default:
                // Handle other cases if necessary
                break;
        }
    }

    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        JujutsucraftaddonMod.addNetworkMessage(YutaStorageSlotMessage.class, YutaStorageSlotMessage::buffer, YutaStorageSlotMessage::new, YutaStorageSlotMessage::handler);
    }
}
