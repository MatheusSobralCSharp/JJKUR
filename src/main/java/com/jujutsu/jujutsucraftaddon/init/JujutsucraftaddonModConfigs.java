package com.jujutsu.jujutsucraftaddon.init;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.configuration.JogoatConfiguration;
import com.jujutsu.jujutsucraftaddon.configuration.JujutsuClanRatesConfiguration;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;

@Mod.EventBusSubscriber(modid = JujutsucraftaddonMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class JujutsucraftaddonModConfigs {
    @SubscribeEvent
    public static void register(FMLConstructModEvent event) {
        event.enqueueWork(() -> {
            ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, JogoatConfiguration.SPEC, "Jujutsu Rates.toml");
            ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, JujutsuClanRatesConfiguration.SPEC, "Jujutsu Clan Rates.toml");
        });
    }
}
