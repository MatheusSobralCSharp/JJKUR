package com.jujutsu.jujutsucraftaddon.potion;

import com.jujutsu.jujutsucraftaddon.procedures.IfPlayerHasSukunaProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.SukunaEffectExpiresProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.SukunaEffectStartedappliedProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class SukunaMobEffect extends MobEffect {
    public SukunaMobEffect() {
        super(MobEffectCategory.BENEFICIAL, -1);
    }

    @Override
    public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
        super.addAttributeModifiers(entity, attributeMap, amplifier);
        SukunaEffectStartedappliedProcedure.execute(entity);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        IfPlayerHasSukunaProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
    }

    @Override
    public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
        super.removeAttributeModifiers(entity, attributeMap, amplifier);
        SukunaEffectExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
