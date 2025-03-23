package com.jujutsu.jujutsucraftaddon.network;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.WaveEffect;
import com.jujutsu.jujutsucraftaddon.procedures.RemoveCE;
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
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AltarMessageMahoraga {
    int page;

    // Constructor
    public AltarMessageMahoraga(int page) {
        this.page = page;
    }

    // Decoder
    public AltarMessageMahoraga(FriendlyByteBuf buffer) {
        this.page = buffer.readInt();
    }

    // Encoder
    public static void buffer(AltarMessageMahoraga message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.page);
    }

    // Handler
    public static void handler(AltarMessageMahoraga message, Supplier<NetworkEvent.Context> contextSupplier) {
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
        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique2 == 16 && entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCursePower >= 500)) {
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
                    if (!((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()) && !((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()) && !((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.UNSTABLE.get())) {
                        BlockPos center = new BlockPos((int) x, (int) y - 1, (int) z);
                        WaveEffect.createShockwave((ServerLevel) world, center, Mth.nextInt(RandomSource.create(), 5, 20), 20);
                    }
                } else if (page == 5) {
                    ItemStack headItem = entity.getItemBySlot(EquipmentSlot.HEAD);
                    if (entity.getHealth() <= entity.getMaxHealth() / 2) {
                        if (headItem.getOrCreateTag().getDouble("skill205") >= 1000.0) {
                            entity.getPersistentData().putDouble("skill", 1619.0F);
                            entity.getPersistentData().putDouble("cnt6", 45);
                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.PlayerSelectCurseTechniqueName = "Mahoraga: World Slash";
                                capability.syncPlayerVariables(entity);
                            });
                            KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                        }
                    }

                } else if (page == 6) {

                    MobEffectInstance regenerationEffect = entity.getEffect(JujutsucraftModMobEffects.GUARD.get());
                    if (regenerationEffect != null && regenerationEffect.getAmplifier() < 3) {
                        entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.GUARD.get(), 1200, 3, false, false));
                    }

                    RemoveCE.execute(entity, world);

                } else if (page == 7) {
                    MobEffectInstance regenerationEffect = entity.getEffect(JujutsucraftModMobEffects.ZONE.get());
                    if (regenerationEffect != null && regenerationEffect.getAmplifier() < 1) {
                        entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.ZONE.get(), 1200, 1, false, false));
                    }

                    RemoveCE.execute(entity, world);
                }
            }
        }

    }

    // Registrando o Packet
    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        JujutsucraftaddonMod.addNetworkMessage(AltarMessageMahoraga.class, AltarMessageMahoraga::buffer, AltarMessageMahoraga::new, AltarMessageMahoraga::handler);
    }
}