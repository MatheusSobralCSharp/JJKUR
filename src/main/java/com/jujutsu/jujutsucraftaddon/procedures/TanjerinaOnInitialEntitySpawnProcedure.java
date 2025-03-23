package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class TanjerinaOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 3, false, false));
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 1, false, false));
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 31, false, false));
        if (entity instanceof LivingEntity _entity) {
            ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.SWORD_JIN_WOO.get()).copy();
            _setstack.setCount(1);
            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
            if (_entity instanceof Player _player)
                _player.getInventory().setChanged();
        }
        if (entity instanceof LivingEntity _entity) {
            ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.SWORD_JIN_WOO_TWO.get()).copy();
            _setstack.setCount(1);
            _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
            if (_entity instanceof Player _player)
                _player.getInventory().setChanged();
        }
    }
}
