package com.jujutsu.jujutsucraftaddon.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class FutureSightEffectMobEffect extends MobEffect {
    public FutureSightEffectMobEffect() {
        super(MobEffectCategory.BENEFICIAL, -1);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
