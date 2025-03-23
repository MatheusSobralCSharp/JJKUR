package com.jujutsu.jujutsucraftaddon.network;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.procedures.RemoveCE;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KeyStartTechniqueOnKeyPressedProcedure;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
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
public class AltarMessageUraume {
    int page;

    // Constructor
    public AltarMessageUraume(int page) {
        this.page = page;
    }

    // Decoder
    public AltarMessageUraume(FriendlyByteBuf buffer) {
        this.page = buffer.readInt();
    }

    // Encoder
    public static void buffer(AltarMessageUraume message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.page);
    }

    // Handler
    public static void handler(AltarMessageUraume message, Supplier<NetworkEvent.Context> contextSupplier) {
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


        if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique2 == 24 && entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCursePower >= 500) {
            if (entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
                    && ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sorcerer_grade_special"))).isDone()) {
                if (page == 0) {
                    entity.getPersistentData().putDouble("skill", -99);
                    entity.getPersistentData().putBoolean("PRESS_Z", true);
                    entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 60, 3, false, false));
                } else if (page == 1) {
                    entity.getPersistentData().putDouble("skill", 2405);
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerSelectCurseTechniqueName = Component.translatable("jujutsu.technique.uraume_5").getString();
                        capability.syncPlayerVariables(entity);
                    });
                    KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                    entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 20));
                    if (!entity.level().isClientSide()) {
                        entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 120));
                    }
                } else if (page == 2) {
                    entity.getPersistentData().putDouble("skill", 2406);
                    KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerSelectCurseTechniqueName = Component.translatable("jujutsu.technique.uraume_6").getString();
                        capability.syncPlayerVariables(entity);
                    });
                    entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 100));
                    if (!entity.level().isClientSide()) {
                        entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 120));
                    }
                } else if (page == 3) {
                    entity.getPersistentData().putDouble("skill", 2408);
                    KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerSelectCurseTechniqueName = Component.translatable("jujutsu.technique.uraume_8").getString();
                        capability.syncPlayerVariables(entity);
                    });
                    entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 20));
                    if (!entity.level().isClientSide()) {
                        entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 120));
                    }
                } else if (page == 4) {
                    entity.getPersistentData().putDouble("skill", 2409);
                    KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerSelectCurseTechniqueName = Component.translatable("jujutsu.technique.uraume_9").getString();
                        ;
                        capability.syncPlayerVariables(entity);
                    });
                    entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 20));
                    if (!entity.level().isClientSide()) {
                        entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 120));
                    }
                }
            }
            RemoveCE.execute(entity, world);
        }
    }
    // Registrando o Packet
    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        JujutsucraftaddonMod.addNetworkMessage(AltarMessageUraume.class, AltarMessageUraume::buffer, AltarMessageUraume::new, AltarMessageUraume::handler);
    }
}