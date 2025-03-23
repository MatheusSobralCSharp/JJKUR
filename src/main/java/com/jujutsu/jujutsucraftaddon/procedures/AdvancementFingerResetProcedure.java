package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AdvancementFingerResetProcedure {
    @SubscribeEvent
    public static void onAdvancement(AdvancementEvent event) {
        execute(event, event.getEntity().level(), event.getAdvancement());
    }

    public static void execute(LevelAccessor world, Advancement advancement) {
        execute(null, world, advancement);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, Advancement advancement) {
        if (advancement == null)
            return;
        if (world instanceof Level _lvl0 && _lvl0.getServer() != null && _lvl0.getServer().getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:enchained")).equals(advancement)) {
            JujutsucraftaddonModVariables.MapVariables.get(world).Sukuna = 0;
            JujutsucraftaddonModVariables.MapVariables.get(world).syncData(world);
        }
    }
}
