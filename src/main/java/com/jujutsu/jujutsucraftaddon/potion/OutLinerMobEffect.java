package com.jujutsu.jujutsucraftaddon.potion;

import com.jujutsu.jujutsucraftaddon.procedures.OutLinerEffectExpiresProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.OutLinerEffectStartedappliedProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.OutLinerOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class OutLinerMobEffect extends MobEffect {
    public OutLinerMobEffect() {
        super(MobEffectCategory.BENEFICIAL, -1);
    }

    @Override
    public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
        super.addAttributeModifiers(entity, attributeMap, amplifier);
        OutLinerEffectStartedappliedProcedure.execute(entity.level(), entity);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        OutLinerOnEffectActiveTickProcedure.execute(entity.level(), entity);
    }

    @Override
    public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
        super.removeAttributeModifiers(entity, attributeMap, amplifier);
        OutLinerEffectExpiresProcedure.execute(entity.level(), entity);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
