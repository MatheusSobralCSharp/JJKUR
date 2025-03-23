package com.jujutsu.jujutsucraftaddon.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class CooldownItadoriMobEffect extends MobEffect {
    public CooldownItadoriMobEffect() {
        super(MobEffectCategory.BENEFICIAL, -1);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
