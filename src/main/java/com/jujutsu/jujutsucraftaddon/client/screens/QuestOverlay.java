package com.jujutsu.jujutsucraftaddon.client.screens;

import com.jujutsu.jujutsucraftaddon.procedures.ReturnActiveProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.ReturnDescProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.ReturnQuestProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class QuestOverlay {
    @SubscribeEvent(priority = EventPriority.NORMAL)
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
        if (ReturnActiveProcedure.execute(entity)) {
            event.getGuiGraphics().drawString(Minecraft.getInstance().font,

                    ReturnDescProcedure.execute(entity), w / 2 + -203, h / 2 + -93, -16776960, false);
            event.getGuiGraphics().drawString(Minecraft.getInstance().font,

                    ReturnQuestProcedure.execute(entity), w / 2 + -202, h / 2 + -108, -16777215, false);
        }
    }
}
