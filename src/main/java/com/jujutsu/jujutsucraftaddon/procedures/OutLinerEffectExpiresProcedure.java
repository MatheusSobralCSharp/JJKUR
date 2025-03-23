package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class OutLinerEffectExpiresProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (world.isClientSide()) {
            if (Minecraft.getInstance().gameRenderer.currentEffect() != null) {
                Minecraft.getInstance().gameRenderer.shutdownEffect();
                Minecraft.getInstance().gameRenderer.shutdownEffect();
                Minecraft.getInstance().gameRenderer.shutdownEffect();
                Minecraft.getInstance().gameRenderer.shutdownEffect();
                Minecraft.getInstance().gameRenderer.shutdownEffect();
                Minecraft.getInstance().gameRenderer.shutdownEffect();
            }
            Minecraft.getInstance().gameRenderer.shutdownEffect();
            Minecraft.getInstance().gameRenderer.shutdownEffect();
            Minecraft.getInstance().gameRenderer.shutdownEffect();
            Minecraft.getInstance().gameRenderer.shutdownEffect();
            Minecraft.getInstance().gameRenderer.shutdownEffect();
        }
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.EXPIRED.get(), 20, 1, false, false));
    }
}
