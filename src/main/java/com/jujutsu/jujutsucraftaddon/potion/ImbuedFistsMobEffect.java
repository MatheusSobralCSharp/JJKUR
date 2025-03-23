package com.jujutsu.jujutsucraftaddon.potion;

import com.jujutsu.jujutsucraftaddon.procedures.ImbuedFistsEffectExpiresProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.ImbuedFistsOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ImbuedFistsMobEffect extends MobEffect {
    public ImbuedFistsMobEffect() {
        super(MobEffectCategory.BENEFICIAL, -1);
        this.addAttributeModifier(Attributes.ATTACK_DAMAGE, "ba6f5e07-d3d2-3f9c-b289-ace60cf6b1ef", 0.2, AttributeModifier.Operation.ADDITION);
    }

    @Override
    public List<ItemStack> getCurativeItems() {
        ArrayList<ItemStack> cures = new ArrayList<ItemStack>();
        return cures;
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        ImbuedFistsOnEffectActiveTickProcedure.execute(entity.level(), entity);
    }

    @Override
    public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
        super.removeAttributeModifiers(entity, attributeMap, amplifier);
        ImbuedFistsEffectExpiresProcedure.execute(entity);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
