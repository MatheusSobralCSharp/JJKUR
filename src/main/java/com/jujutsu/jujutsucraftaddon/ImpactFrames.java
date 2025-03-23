package com.jujutsu.jujutsucraftaddon;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = "jujutuscraftaddon", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ImpactFrames {
    public static void execute(int times) {
        long ImpactFrameTime = times;
        long endTime = System.currentTimeMillis() + ImpactFrameTime;

        while (System.currentTimeMillis() < endTime) {

        }
    }

    public ImpactFrames() {
    }

    @SubscribeEvent
    public static void registerCommands(FMLCommonSetupEvent event) {}

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void clientLoad(FMLClientSetupEvent event) {
    }

    @Mod.EventBusSubscriber
    private static class EventsImpactFrames {
        @SubscribeEvent
        public static void serverLoad(ServerAboutToStartEvent event) {}
    }

    public static void init() {}
}
