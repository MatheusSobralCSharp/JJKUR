package com.jujutsu.jujutsucraftaddon.network;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AltarMessageSlider {
    int page;

    // Constructor
    public AltarMessageSlider(int page) {
        this.page = page;
    }

    // Decoder
    public AltarMessageSlider(FriendlyByteBuf buffer) {
        this.page = buffer.readInt();
    }

    // Encoder
    public static void buffer(AltarMessageSlider message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.page);
    }

    // Handler
    public static void handler(AltarMessageSlider message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            pressAction(context.getSender(), message.page);
        });
        context.setPacketHandled(true);
    }

    // Action logic based on type and pressed time
    public static void pressAction(Player entity, int page) {
        Level world = entity.level();
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();

        // Check if the chunk is loaded
        if (!world.hasChunkAt(entity.blockPosition()))
            return;

        double speed = entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).TrueSpeed;
        if (page == 0) {

            entity.getAttribute((Attribute) Attributes.MOVEMENT_SPEED).setBaseValue(speed);


        } else if (page == 1) {

            entity.getAttribute((Attribute) Attributes.MOVEMENT_SPEED).setBaseValue(speed * 0.75);

        } else if (page == 2) {

            entity.getAttribute((Attribute) Attributes.MOVEMENT_SPEED).setBaseValue(speed * 0.5);

        } else if (page == 3) {

            entity.getAttribute((Attribute) Attributes.MOVEMENT_SPEED).setBaseValue(speed * 0.25);

        } else if (page == 4) {

            entity.getAttribute((Attribute) Attributes.MOVEMENT_SPEED).setBaseValue(speed * 0);

        }


    }

    // Registrando o Packet
    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        JujutsucraftaddonMod.addNetworkMessage(AltarMessageSlider.class, AltarMessageSlider::buffer, AltarMessageSlider::new, AltarMessageSlider::handler);
    }
}