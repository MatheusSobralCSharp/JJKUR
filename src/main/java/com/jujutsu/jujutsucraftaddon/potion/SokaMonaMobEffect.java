package com.jujutsu.jujutsucraftaddon.potion;

import com.jujutsu.jujutsucraftaddon.procedures.SokaMonaEffectExpiresProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.SokaMonaEffectStartedappliedProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.SokaMonaOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class SokaMonaMobEffect extends MobEffect {
    public SokaMonaMobEffect() {
        super(MobEffectCategory.BENEFICIAL, -1);
    }

    @Override
    public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
        super.addAttributeModifiers(entity, attributeMap, amplifier);
        SokaMonaEffectStartedappliedProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getY(), entity);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        SokaMonaOnEffectActiveTickProcedure.execute(entity.level(), entity);
    }

    @Override
    public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
        super.removeAttributeModifiers(entity, attributeMap, amplifier);
        SokaMonaEffectExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getY(), entity);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
