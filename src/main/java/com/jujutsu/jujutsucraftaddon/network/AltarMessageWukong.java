package com.jujutsu.jujutsucraftaddon.network;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.abilities.*;
import com.jujutsu.jujutsucraftaddon.procedures.CloneChanger;
import com.jujutsu.jujutsucraftaddon.procedures.DismantleCutProcedure;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KeyStartTechniqueOnKeyPressedProcedure;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AltarMessageWukong {
    int page;
    private static final Map<UUID, Integer> pressCounter = new HashMap<>();
    // Constructor
    public AltarMessageWukong(int page) {
        this.page = page;
    }

    // Decoder
    public AltarMessageWukong(FriendlyByteBuf buffer) {
        this.page = buffer.readInt();
    }

    // Encoder
    public static void buffer(AltarMessageWukong message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.page);
    }

    // Handler
    public static void handler(AltarMessageWukong message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayer serverPlayer = context.getSender(); // Get the sender

            if (serverPlayer == null) return;

            ServerLevel serverLevel = serverPlayer.server.getLevel(serverPlayer.level().dimension()); // Ensure correct world
            if (serverLevel == null) return;

            // Retrieve the correct player using UUID
            Player targetPlayer = serverLevel.getPlayerByUUID(context.getSender().getUUID());
            if (targetPlayer == null) return;

            // Call ShortCutAction instead of old pressAction

            int currentCount = pressCounter.getOrDefault(context.getSender().getUUID(), 0);

            // Increment counter
            currentCount++;

            if (currentCount >= 9) {
                // Execute the action when the counter reaches 5
                pressAction(targetPlayer, message.page);

                // Reset the counter
                pressCounter.put(context.getSender().getUUID(), 0);
            } else {
                // Update counter
                pressCounter.put(context.getSender().getUUID(), currentCount);
            }
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


        if (entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
                && ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sorcerer_grade_special"))).isDone()) {
            if (page == 0) {
                entity.getPersistentData().putDouble("skill", -99);
                entity.getPersistentData().putBoolean("PRESS_Z", true);
                entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 60, 3, false, false));
            } else if (page == 1) {
                entity.getPersistentData().putDouble("skill", -98);
                entity.getPersistentData().putBoolean("PRESS_Z", true);
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.PlayerSelectCurseTechniqueName = (Component.translatable("jujutsu.technique.attack3").getString());
                    capability.syncPlayerVariables(entity);
                });
                KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            } else if (page == 2) {
                entity.getPersistentData().putBoolean("PRESS_Z", true);
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.PlayerSelectCurseTechniqueName = (Component.translatable("jujutsu.technique.attack5").getString());
                    capability.syncPlayerVariables(entity);
                });
                KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);

            } else if (page == 3) {
                entity.getPersistentData().putBoolean("PRESS_Z", true);
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.PlayerSelectCurseTechniqueName = (Component.translatable("jujutsu.technique.attack4").getString());
                    capability.syncPlayerVariables(entity);
                });
                KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);

            } else if (page == 4) {
                CloneChanger.execute(world, x, y, z, entity);
            } else if (page == 5) {
                EarthWallAbility.createEarthWall(entity);
            }  else if (page == 6) {
                FireBlastAbility.createFireBlast(entity);
            } else if (page == 7) {
                WaterSurgeAbility.createWaterSurge(entity);
            } else if (page == 8) {
                BoomerangAbility.throwBoomerang(entity);
            } else if (page == 9) {
                DismantleCutProcedure.execute(world, entity);
            } else if (page == 10) {
                if (entity instanceof ServerPlayer serverPlayer) {
                    MinecraftServer server = serverPlayer.server;
                    SongOfTimeAbility.activateSongOfTime(server, serverPlayer);
                }
            } else if (page == 11) {
                if (entity instanceof ServerPlayer serverPlayer) {
                    MinecraftServer server = serverPlayer.server;
                    SongOfTimeAbility.activateSongOfSnow(server, serverPlayer);
                }
            } else if (page == 12) {
                if (entity instanceof ServerPlayer serverPlayer) {
                    MinecraftServer server = serverPlayer.server;
                    SongOfTimeAbility.activateSongOfStorms(server, serverPlayer);
                }
            } else if (page == 13) {
                if (entity instanceof ServerPlayer serverPlayer) {
                    MinecraftServer server = serverPlayer.server;
                    SongOfTimeAbility.activateSunsSong(server, serverPlayer);
                }
            }
        }


    }

    // Registrando o Packet
    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        JujutsucraftaddonMod.addNetworkMessage(AltarMessageWukong.class, AltarMessageWukong::buffer, AltarMessageWukong::new, AltarMessageWukong::handler);
    }
}