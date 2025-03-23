package com.jujutsu.jujutsucraftaddon.potion;

import com.jujutsu.jujutsucraftaddon.procedures.HidingEffectExpiresProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.HidingEffectStartedappliedProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.HidingOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class HidingMobEffect extends MobEffect {
    public HidingMobEffect() {
        super(MobEffectCategory.BENEFICIAL, -1);
    }

    @Override
    public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
        super.addAttributeModifiers(entity, attributeMap, amplifier);
        HidingEffectStartedappliedProcedure.execute(entity.level(),entity);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        HidingOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
    }

    @Override
    public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
        super.removeAttributeModifiers(entity, attributeMap, amplifier);
        HidingEffectExpiresProcedure.execute(entity);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
