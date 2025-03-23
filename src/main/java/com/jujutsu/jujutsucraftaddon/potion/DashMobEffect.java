package com.jujutsu.jujutsucraftaddon.potion;

import com.jujutsu.jujutsucraftaddon.procedures.DashEffectExpiresProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.DashEffectStartedappliedProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.DashOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class DashMobEffect extends MobEffect {
    public DashMobEffect() {
        super(MobEffectCategory.NEUTRAL, -1);
    }

    @Override
    public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
        super.addAttributeModifiers(entity, attributeMap, amplifier);
        DashEffectStartedappliedProcedure.execute(entity);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        DashOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
    }

    @Override
    public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
        super.removeAttributeModifiers(entity, attributeMap, amplifier);
        DashEffectExpiresProcedure.execute(entity);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
