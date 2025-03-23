package com.jujutsu.jujutsucraftaddon.network;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.procedures.*;
import com.jujutsu.jujutsucraftaddon.world.inventory.NewTabMenu;
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
public class NewTabButtonMessage {
    private final int buttonID, x, y, z;

    public NewTabButtonMessage(FriendlyByteBuf buffer) {
        this.buttonID = buffer.readInt();
        this.x = buffer.readInt();
        this.y = buffer.readInt();
        this.z = buffer.readInt();
    }

    public NewTabButtonMessage(int buttonID, int x, int y, int z) {
        this.buttonID = buttonID;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static void buffer(NewTabButtonMessage message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.buttonID);
        buffer.writeInt(message.x);
        buffer.writeInt(message.y);
        buffer.writeInt(message.z);
    }

    public static void handler(NewTabButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
        HashMap guistate = NewTabMenu.guistate;
        // security measure to prevent arbitrary chunk generation
        if (!world.hasChunkAt(new BlockPos(x, y, z)))
            return;
        if (buttonID == 0) {

            UnlockExtensionProcedure.execute(world, x, y, z, entity);
        }
        if (buttonID == 1) {

            OverlayActiveOnKeyPressedProcedure.execute(entity);
        }
        if (buttonID == 2) {

            HistoryModeOnKeyPressedProcedure.execute(world, x, y, z, entity);
        }
        if (buttonID == 3) {

            CursedWeaponOnKeyPressedProcedure.execute(world, x, y, z, entity);
        }
        if (buttonID == 4) {

            WaterWalkingOnKeyPressedProcedure.execute(world, entity);
        }
        if (buttonID == 5) {

            ProgressionMenuOnKeyPressedProcedure.execute(world, x, y, z, entity);
        }
        if (buttonID == 6) {

            OstProcedure.execute(entity);
        }
        if (buttonID == 7) {

            FramesProcedure.execute(entity);
        }
        if (buttonID == 8) {

            DashTogglProcedure.execute(entity);
        }
        if (buttonID == 9) {

            DisableOrEnableAnimationsProcedure.execute(world, x, y, z, entity);
        }
        if (buttonID == 10) {

            GojukunaProcedure.execute(world, x, y, z, entity);
        }
        if (buttonID == 11) {

            FogToggle.execute(world, entity);
        }
        if (buttonID == 12) {

            BarToggle.execute(world, entity);
        }
    }

    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        JujutsucraftaddonMod.addNetworkMessage(NewTabButtonMessage.class, NewTabButtonMessage::buffer, NewTabButtonMessage::new, NewTabButtonMessage::handler);
    }
}
