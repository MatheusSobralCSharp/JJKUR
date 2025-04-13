package com.jujutsu.jujutsucraftaddon.potion;

import com.jujutsu.jujutsucraftaddon.procedures.DeathPaintingStackEffectExpiresProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.DeathPaintingStackEffectStartedappliedProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class DeathPaintingStackMobEffect extends MobEffect {
    public DeathPaintingStackMobEffect() {
        super(MobEffectCategory.BENEFICIAL, -1);
        this.addAttributeModifier(Attributes.ATTACK_DAMAGE, "030a8d68-7999-3b04-96a3-64b805151712", 1.2, AttributeModifier.Operation.MULTIPLY_BASE);
        this.addAttributeModifier(Attributes.ARMOR, "610a19dd-733b-387f-b14a-2b978a177180", 1.2, AttributeModifier.Operation.MULTIPLY_BASE);
        this.addAttributeModifier(Attributes.ATTACK_SPEED, "ee8f143e-865b-3513-8557-19f3b7a34d1f", 1.2, AttributeModifier.Operation.MULTIPLY_BASE);
    }

    @Override
    public List<ItemStack> getCurativeItems() {
        ArrayList<ItemStack> cures = new ArrayList<ItemStack>();
        return cures;
    }

    @Override
    public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
        super.addAttributeModifiers(entity, attributeMap, amplifier);
        DeathPaintingStackEffectStartedappliedProcedure.execute(entity);
    }

    @Override
    public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
        super.removeAttributeModifiers(entity, attributeMap, amplifier);
        DeathPaintingStackEffectExpiresProcedure.execute(entity);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
