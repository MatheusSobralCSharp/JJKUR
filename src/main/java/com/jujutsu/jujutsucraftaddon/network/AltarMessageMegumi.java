package com.jujutsu.jujutsucraftaddon.network;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.procedures.RemoveCE;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KeyStartTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraft.procedures.StartCursedTechniqueProcedure;
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
public class AltarMessageMegumi {
    int page;

    // Constructor
    public AltarMessageMegumi(int page) {
        this.page = page;
    }

    // Decoder
    public AltarMessageMegumi(FriendlyByteBuf buffer) {
        this.page = buffer.readInt();
    }

    // Encoder
    public static void buffer(AltarMessageMegumi message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.page);
    }

    // Handler
    public static void handler(AltarMessageMegumi message, Supplier<NetworkEvent.Context> contextSupplier) {
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
        if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique2 == 6 && entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCursePower >= 500) {
            if (entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
                    && ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sorcerer_grade_special"))).isDone()) {
                if (page == 0) {
                    entity.getPersistentData().putDouble("skill", 607);
                    StartCursedTechniqueProcedure.execute(world, x, y, z, entity);
                    if (!entity.level().isClientSide()) {
                        entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 120));
                    }
                } else if (page == 1) {
                    entity.getPersistentData().putDouble("skill", 608);
                    KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                    if (!entity.level().isClientSide()) {
                        entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 120));
                    }
                } else if (page == 2) {
                    entity.getPersistentData().putDouble("skill", 609);
                    KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                    if (!entity.level().isClientSide()) {
                        entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 120));
                    }
                } else if (page == 3) {
                    entity.getPersistentData().putDouble("skill", 610);
                    KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                    if (!entity.level().isClientSide()) {
                        entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 120));
                    }
                } else if (page == 4) {
                    entity.getPersistentData().putDouble("skill", 611.0);
                    KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                    if (!entity.level().isClientSide()) {
                        entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 120));
                    }
                } else if (page == 5) {
                    entity.getPersistentData().putDouble("skill", 612.0);
                    KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                    if (!entity.level().isClientSide()) {
                        entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 120));
                    }
                } else if (page == 6) {
                    entity.getPersistentData().putDouble("skill", 613.0);
                    KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                    if (!entity.level().isClientSide()) {
                        entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 120));
                    }
                } else if (page == 7) {
                    entity.getPersistentData().putDouble("skill", 614.0);
                    KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                    if (!entity.level().isClientSide()) {
                        entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 120));
                    }
                } else if (page == 8) {
                    entity.getPersistentData().putDouble("skill", 615.0);
                    KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                    if (!entity.level().isClientSide()) {
                        entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 120));
                    }
                } else if (page == 9) {
                    if (entity.getPersistentData().getDouble("TenShadowsTechnique13") > -1) {
                        entity.getPersistentData().putDouble("skill", 617.0);
                        KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                    }
                    if (!entity.level().isClientSide()) {
                        entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 120));
                    }
                } else if (page == 10) {
                    if (entity.getPersistentData().getDouble("TenShadowsTechnique14") > -1) {
                        entity.getPersistentData().putDouble("skill", 618.0);
                        KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                    }
                    if (!entity.level().isClientSide()) {
                        entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 120));
                    }
                } else if (page == 11) {
                    entity.getPersistentData().putDouble("skill", 1007.0);
                    KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                    if (!entity.level().isClientSide()) {
                        entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 120));
                    }
                } else if (page == 12) {
                    entity.getPersistentData().putDouble("skill", 608);
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerSelectCurseTechniqueName = (Component.translatable("entity.jujutsucraft.nue_totality").getString());
                        capability.syncPlayerVariables(entity);
                    });
                    KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                    if (!entity.level().isClientSide()) {
                        entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 120));
                    }
                }

                RemoveCE.execute(entity, world);
            }
        }

    }
    // Registrando o Packet
    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        JujutsucraftaddonMod.addNetworkMessage(AltarMessageMegumi.class, AltarMessageMegumi::buffer, AltarMessageMegumi::new, AltarMessageMegumi::handler);
    }
}
