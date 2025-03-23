package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.WhenPlayerJumpProcedure;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.Event;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = WhenPlayerJumpProcedure.class, priority = -10000)
public class WhenEntityJumpMixin {

    @Inject(at = @At("HEAD"), method = "execute(Lnet/minecraftforge/eventbus/api/Event;Lnet/minecraft/world/entity/Entity;)V", remap = false)
    private static void execute(Event event, Entity entity, CallbackInfo ci) {
        if (entity == null)
            return;
        if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.WUKONG_SET_LEGGINGS.get().asItem()) {
            if (entity instanceof LivingEntity _entity1 && !_entity1.level().isClientSide())
                _entity1.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get(), 120, 4, false, false));
        }

        if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.WUKONG_SET_BOOTS.get().asItem()) {
            if (entity instanceof LivingEntity _entity1 && !_entity1.level().isClientSide())
                _entity1.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 60, 4, false, false));
        }
    }
}
