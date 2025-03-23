package com.jujutsu.jujutsucraftaddon.procedures;

import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CounterOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        boolean sword = false;
        Entity entiry_a;
        String STR1 = "";
        entiry_a = entity;
        double NUM2 = 0.0;
        double NUM3 = 0.0;
        double rnd = 0.0;
        double NUM1 = 0.0;
        ModifierLayer animation;
        AbstractClientPlayer player;
        if (world.isClientSide() && entiry_a instanceof Player) {
            player = (AbstractClientPlayer) entiry_a;
            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
            if (animation != null && !animation.isActive()) {
                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("counterhr" + Mth.nextInt(RandomSource.create(), 1, 7))))));
            }
        }
    }
}
