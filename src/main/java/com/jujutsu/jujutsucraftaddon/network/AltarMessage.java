package com.jujutsu.jujutsucraftaddon.network;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.procedures.OpenYutaStorageProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.RemoveCE;
import com.jujutsu.jujutsucraftaddon.procedures.SummonPartialRikaProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.YutaExtensionProcedure;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KeyStartTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraft.procedures.StartCursedTechniqueProcedure;
import net.mcreator.jujutsucraft.procedures.TechniqueRika1Procedure;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AltarMessage {
    int page;

    // Constructor
    public AltarMessage(int page) {
        this.page = page;
    }

    // Decoder
    public AltarMessage(FriendlyByteBuf buffer) {
        this.page = buffer.readInt();
    }

    // Encoder
    public static void buffer(AltarMessage message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.page);
    }

    // Handler
    public static void handler(AltarMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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

        // Ações feitas, cada page = um index, lembrando que começa por 0, não por 1
        if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique2 == 5 && entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCursePower >= 500) {
            if (entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
                    && ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sorcerer_grade_special"))).isDone()) {
                if (page == 1) {
                    entity.getPersistentData().putDouble("skill", 502);
                    StartCursedTechniqueProcedure.execute(world, x, y, z, entity);
                    RemoveCE.execute(entity, world);
                    if (!entity.level().isClientSide()) {
                        entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 120));
                    }
                } else if (page == 0) {
                    entity.getPersistentData().putDouble("skill", 510.0);
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerSelectCurseTechniqueName = "Rika Summon";
                        capability.syncPlayerVariables(entity);
                    });
                    KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                    TechniqueRika1Procedure.execute(world, entity);
                    RemoveCE.execute(entity, world);
                    if (!entity.level().isClientSide()) {
                        entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 120));
                    }
                } else if (page == 3) {
                    YutaExtensionProcedure.execute(world, entity);
                    if (!entity.level().isClientSide()) {
                        entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 120));
                    }
                } else if (page == 4) {
                    OpenYutaStorageProcedure.execute(world, x, y, z, entity);
                    if (!entity.level().isClientSide()) {
                        entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 120));
                    }
                } else if (page == 5) {
                    entity.getPersistentData().putDouble("skill", 515.0);
                    KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                    RemoveCE.execute(entity, world);
                    if (!entity.level().isClientSide()) {
                        entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 120));
                    }
                } else if (page == 2) {
                    entity.getPersistentData().putDouble("skill", 501.0);
                    StartCursedTechniqueProcedure.execute(world, x, y, z, entity);
                    SummonPartialRikaProcedure.execute(world, entity);
                    RemoveCE.execute(entity, world);
                    if (!entity.level().isClientSide()) {
                        entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 120));
                    }
                }
            }
        }
    }
    // Registrando o Packet
    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        JujutsucraftaddonMod.addNetworkMessage(AltarMessage.class, AltarMessage::buffer, AltarMessage::new, AltarMessage::handler);
    }
}