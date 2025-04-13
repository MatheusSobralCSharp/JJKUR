package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.client.screens.GreatScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;


public class OpenMastery {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        Minecraft.getInstance().execute(() -> {
            if (Minecraft.getInstance().screen == null) {
                Minecraft.getInstance().setScreen(new GreatScreen());
            }
        });
    }
}
