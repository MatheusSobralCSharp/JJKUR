package com.jujutsu.jujutsucraftaddon.client.screens;

import com.jujutsu.jujutsucraftaddon.procedures.FutureSightSukunaDisplayOverlayIngameProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class FutureSightSukunaOverlay {
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void eventHandler(RenderGuiEvent.Pre event) {
        int w = event.getWindow().getGuiScaledWidth();
        int h = event.getWindow().getGuiScaledHeight();
        Level world = null;
        double x = 0;
        double y = 0;
        double z = 0;
        Player entity = Minecraft.getInstance().player;
        if (entity != null) {
            world = entity.level();
            x = entity.getX();
            y = entity.getY();
            z = entity.getZ();
        }
        if (FutureSightSukunaDisplayOverlayIngameProcedure.execute(entity)) {
            event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.jujutsucraftaddon.future_sight_sukuna.label_tes"), w / 2 + 120, h / 2 + 21, -16711681, false);
            event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.jujutsucraftaddon.future_sight_sukuna.label_someone_is_aiming_a_cursed_techn"), w / 2 + -18, h / 2 + 41, -65536, false);
        }
    }
}
