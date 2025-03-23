package com.jujutsu.jujutsucraftaddon.network;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.procedures.*;
import com.jujutsu.jujutsucraftaddon.world.inventory.KenjakuBodySwapMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

import java.util.HashMap;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class KenjakuBodySwapButtonMessage {
    private final int buttonID, x, y, z;

    public KenjakuBodySwapButtonMessage(FriendlyByteBuf buffer) {
        this.buttonID = buffer.readInt();
        this.x = buffer.readInt();
        this.y = buffer.readInt();
        this.z = buffer.readInt();
    }

    public KenjakuBodySwapButtonMessage(int buttonID, int x, int y, int z) {
        this.buttonID = buttonID;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static void buffer(KenjakuBodySwapButtonMessage message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.buttonID);
        buffer.writeInt(message.x);
        buffer.writeInt(message.y);
        buffer.writeInt(message.z);
    }

    public static void handler(KenjakuBodySwapButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            Player entity = context.getSender();
            int buttonID = message.buttonID;
            int x = message.x;
            int y = message.y;
            int z = message.z;
            handleButtonAction(entity, buttonID, x, y, z);
        });
        context.setPacketHandled(true);
    }

    public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
        Level world = entity.level();
        HashMap guistate = KenjakuBodySwapMenu.guistate;
        // security measure to prevent arbitrary chunk generation
        if (!world.hasChunkAt(new BlockPos(x, y, z)))
            return;
        if (buttonID == 0) {

            KenjakuCTClickProcedure.execute(world, entity);
        }
        if (buttonID == 1) {

            CTSet1Procedure.execute(world, entity);
        }
        if (buttonID == 2) {

            CTSet2Procedure.execute(world, entity);
        }
        if (buttonID == 3) {

            CTNameClicked2Procedure.execute(entity);
        }
        if (buttonID == 4) {

            CTNameClicked1Procedure.execute(entity);
        }
        if (buttonID == 5) {

            Body1Procedure.execute(entity);
        }
        if (buttonID == 6) {

            Body2Procedure.execute(entity);
        }
        if (buttonID == 7) {

            Body3Procedure.execute(entity);
        }
        if (buttonID == 8) {

            RemoveUserProcedure.execute(entity);
        }
    }

    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        JujutsucraftaddonMod.addNetworkMessage(KenjakuBodySwapButtonMessage.class, KenjakuBodySwapButtonMessage::buffer, KenjakuBodySwapButtonMessage::new, KenjakuBodySwapButtonMessage::handler);
    }
}
