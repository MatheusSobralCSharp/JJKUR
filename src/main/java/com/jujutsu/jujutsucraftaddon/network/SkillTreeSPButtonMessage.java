package com.jujutsu.jujutsucraftaddon.network;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.procedures.*;
import com.jujutsu.jujutsucraftaddon.world.inventory.SkillTreeSPMenu;
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
public class SkillTreeSPButtonMessage {
    private final int buttonID, x, y, z;

    public SkillTreeSPButtonMessage(FriendlyByteBuf buffer) {
        this.buttonID = buffer.readInt();
        this.x = buffer.readInt();
        this.y = buffer.readInt();
        this.z = buffer.readInt();
    }

    public SkillTreeSPButtonMessage(int buttonID, int x, int y, int z) {
        this.buttonID = buttonID;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static void buffer(SkillTreeSPButtonMessage message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.buttonID);
        buffer.writeInt(message.x);
        buffer.writeInt(message.y);
        buffer.writeInt(message.z);
    }

    public static void handler(SkillTreeSPButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
        HashMap guistate = SkillTreeSPMenu.guistate;
        // security measure to prevent arbitrary chunk generation
        if (!world.hasChunkAt(new BlockPos(x, y, z)))
            return;
        if (buttonID == 0) {

            HealthProcedure.execute(world, x, y, z, entity);
        }
        if (buttonID == 1) {

            CEProcedure.execute(world, x, y, z, entity);
        }
        if (buttonID == 2) {

            SpeedProcedure.execute(world, x, y, z, entity);
        }
        if (buttonID == 3) {

            StartTrainProcedure.execute(entity);
        }
        if (buttonID == 4) {

            SpawnYujiAndYutaProcedure.execute(world, x, y, z, entity);
        }
        if (buttonID == 5) {

            OpenTabProcedure.execute(world, x, y, z, entity);
        }
        if (buttonID == 6) {

            RebirthMadeProcedure.execute(world, x, y, z, entity);
        }
        if (buttonID == 7) {

            HabilityWheelKeyOnKeyPressed12Procedure.execute(world, x, y, z, entity);
        }
        if (buttonID == 8) {

            MeditationOnKeyPressedProcedure.execute(world, x, y, z, entity);
        }
    }

    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        JujutsucraftaddonMod.addNetworkMessage(SkillTreeSPButtonMessage.class, SkillTreeSPButtonMessage::buffer, SkillTreeSPButtonMessage::new, SkillTreeSPButtonMessage::handler);
    }
}
