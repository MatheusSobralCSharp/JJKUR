package com.jujutsu.jujutsucraftaddon.potion;

import com.jujutsu.jujutsucraftaddon.procedures.GojoAwakening1EffectExpiresProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.HeianOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class GojoAwakening1MobEffect extends MobEffect {
    public GojoAwakening1MobEffect() {
        super(MobEffectCategory.BENEFICIAL, -1);
        this.addAttributeModifier(Attributes.ARMOR, "80959a42-0026-35df-b2b6-01985b3279cf", 5, AttributeModifier.Operation.ADDITION);
        this.addAttributeModifier(Attributes.ATTACK_DAMAGE, "430748f4-e2ac-3b32-9104-da796c8af03c", 2, AttributeModifier.Operation.ADDITION);
    }

    @Override
    public List<ItemStack> getCurativeItems() {
        ArrayList<ItemStack> cures = new ArrayList<ItemStack>();
        return cures;
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        HeianOnEffectActiveTickProcedure.execute(entity);
    }

    @Override
    public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
        super.removeAttributeModifiers(entity, attributeMap, amplifier);
        GojoAwakening1EffectExpiresProcedure.execute(entity);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
