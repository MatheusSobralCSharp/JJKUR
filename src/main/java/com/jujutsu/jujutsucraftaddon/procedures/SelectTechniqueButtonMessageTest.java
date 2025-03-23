package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import net.mcreator.jujutsucraft.world.inventory.SelectTechniqueMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Supplier;

public class SelectTechniqueButtonMessageTest {
    private final int buttonID;
    private final int x;
    private final int y;
    private final int z;
    private HashMap<String, String> textstate;

    public SelectTechniqueButtonMessageTest(FriendlyByteBuf buffer) {
        this.buttonID = buffer.readInt();
        this.x = buffer.readInt();
        this.y = buffer.readInt();
        this.z = buffer.readInt();
        this.textstate = readTextState(buffer);
    }

    public SelectTechniqueButtonMessageTest(int buttonID, int x, int y, int z, HashMap<String, String> textstate) {
        this.buttonID = buttonID;
        this.x = x;
        this.y = y;
        this.z = z;
        this.textstate = textstate;
    }

    public static void buffer(SelectTechniqueButtonMessageTest message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.buttonID);
        buffer.writeInt(message.x);
        buffer.writeInt(message.y);
        buffer.writeInt(message.z);
        writeTextState(message.textstate, buffer);
    }

    public static void handler(SelectTechniqueButtonMessageTest message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = (NetworkEvent.Context)contextSupplier.get();
        context.enqueueWork(() -> {
            Player entity = context.getSender();
            int buttonID = message.buttonID;
            int x = message.x;
            int y = message.y;
            int z = message.z;
            HashMap<String, String> textstate = message.textstate;
            handleButtonAction(entity, buttonID, x, y, z, textstate);
        });
        context.setPacketHandled(true);
    }


    public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z, HashMap<String, String> textstate) {
        Level world = entity.level();
        HashMap guistate = SelectTechniqueMenu.guistate;
        Iterator var8 = textstate.entrySet().iterator();

        while(var8.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry)var8.next();
            String key = (String)entry.getKey();
            String value = (String)entry.getValue();
            guistate.put(key, value);
        }

        if (world.hasChunkAt(new BlockPos(x, y, z))) {
            if (buttonID == 100) {
                SelectWukongProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
            }

            if (buttonID == 101) {
                SelectJinWooProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
            }

        }
    }

    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        JujutsucraftaddonMod.addNetworkMessage(SelectTechniqueButtonMessageTest.class, SelectTechniqueButtonMessageTest::buffer, SelectTechniqueButtonMessageTest::new, SelectTechniqueButtonMessageTest::handler);
    }

    public static void writeTextState(HashMap<String, String> map, FriendlyByteBuf buffer) {
        buffer.writeInt(map.size());
        Iterator var2 = map.entrySet().iterator();

        while(var2.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry)var2.next();
            buffer.writeComponent(Component.literal((String)entry.getKey()));
            buffer.writeComponent(Component.literal((String)entry.getValue()));
        }

    }

    public static HashMap<String, String> readTextState(FriendlyByteBuf buffer) {
        int size = buffer.readInt();
        HashMap<String, String> map = new HashMap();

        for(int i = 0; i < size; ++i) {
            String key = buffer.readComponent().getString();
            String value = buffer.readComponent().getString();
            map.put(key, value);
        }

        return map;
    }
}
