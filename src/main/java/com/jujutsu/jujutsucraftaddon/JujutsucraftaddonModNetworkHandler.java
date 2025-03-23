package com.jujutsu.jujutsucraftaddon;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;


public class JujutsucraftaddonModNetworkHandler {
    public static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(JujutsucraftaddonMod.MODID, "main_channel"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public static void registerMessages() {
        int packetId = 0;
        INSTANCE.registerMessage(packetId++, TextureSyncPacket.class, TextureSyncPacket::encode, TextureSyncPacket::decode, TextureSyncPacket::handle);
    }

    public SimpleChannel getChannel() {
        return INSTANCE;
    }


    public static void send(PacketDistributor.PacketTarget target, Object message) {
        INSTANCE.send(target, message);
    }

    public static void sendToServer(Object message) {
        INSTANCE.sendToServer(message);
    }

}