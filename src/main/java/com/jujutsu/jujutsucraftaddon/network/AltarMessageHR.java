package com.jujutsu.jujutsucraftaddon.network;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.WaveEffect;
import com.jujutsu.jujutsucraftaddon.procedures.SixEyesCutProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.SplitSoulTojiProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.TojiInvertedProcedure;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KeyStartTechniqueOnKeyPressedProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AltarMessageHR {
    int page;

    // Constructor
    public AltarMessageHR(int page) {
        this.page = page;
    }

    // Decoder
    public AltarMessageHR(FriendlyByteBuf buffer) {
        this.page = buffer.readInt();
    }

    // Encoder
    public static void buffer(AltarMessageHR message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.page);
    }

    // Handler
    public static void handler(AltarMessageHR message, Supplier<NetworkEvent.Context> contextSupplier) {
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
        if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique2 == -1 && entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCursePower == 0) {
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
                    TojiInvertedProcedure.execute(world, x, y, z, entity);
                } else if (page == 5) {
                    SixEyesCutProcedure.execute(world, x, y, z, entity);
                } else if (page == 6) {
                    SplitSoulTojiProcedure.execute(world, x, y, z, entity);
                } else if (page == 7) {
                    if (!((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()) && !((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()) && !((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.UNSTABLE.get())) {
                        BlockPos center = new BlockPos((int) x, (int) y - 1, (int) z);
                        WaveEffect.createShockwave((ServerLevel) world, center, Mth.nextInt(RandomSource.create(), 5, 20), 20);
                    }
                } else if (page == 8) {
                    if (!((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()) &&
                            !((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()) &&
                            !((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.UNSTABLE.get())) {
                        MobEffectInstance regenerationEffect = entity.getEffect(MobEffects.REGENERATION);
                        if (regenerationEffect != null && regenerationEffect.getAmplifier() < 3) {
                            entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 40, 3, false, false));
                        }
                    }
                }
            }
        }

    }
    // Registrando o Packet
    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        JujutsucraftaddonMod.addNetworkMessage(AltarMessageHR.class, AltarMessageHR::buffer, AltarMessageHR::new, AltarMessageHR::handler);
    }
}