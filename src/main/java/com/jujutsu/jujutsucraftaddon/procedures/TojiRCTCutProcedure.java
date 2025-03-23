package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class TojiRCTCutProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if (!((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
            if ((ForgeRegistries.ITEMS.getKey((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:inverted_spear_of_heaven")) {
                if (Math.random() <= 0.1) {
                    if (!(entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(JujutsucraftaddonModMobEffects.RCT_CUT.get()))) {
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.RCT_CUT.get(), 60, 1, false, false));
                    }
                }
            } else if ((ForgeRegistries.ITEMS.getKey((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:playful_cloud")) {
                if (Math.random() <= 0.05) {
                    entity.setDeltaMovement(new Vec3((1 * Math.cos((sourceentity.getYRot() + 90) * (Math.PI / 180))), 0, (1 * Math.sin((sourceentity.getYRot() + 90) * (Math.PI / 180)))));
                    if (world instanceof Level _level && !_level.isClientSide()) {
                        _level.explode(sourceentity, x, y, z, 4, false, Level.ExplosionInteraction.MOB);
                    }
                }
            } else if ((ForgeRegistries.ITEMS.getKey((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:dragon_bone")) {
                if (Math.random() <= 0.05) {
                    entity.setDeltaMovement(new Vec3((1 * Math.cos((sourceentity.getYRot() + 90) * (Math.PI / 180))), 0, (1 * Math.sin((sourceentity.getYRot() + 90) * (Math.PI / 180)))));
                    if (world instanceof Level _level && !_level.isClientSide()) {
                        _level.explode(sourceentity, (entity.getX()), (entity.getY()), (entity.getZ()), 4, false, Level.ExplosionInteraction.MOB);
                    }
                }
            }
        } else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
            if (Math.random() <= 0.05) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 1, false, false));
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(
                            new MobEffectInstance(MobEffects.CONFUSION, 20, (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.CONFUSION) ? _livEnt.getEffect(MobEffects.CONFUSION).getAmplifier() : 0) + 1, false, false));
                entity.setDeltaMovement(new Vec3((1 * Math.cos((sourceentity.getYRot() + 90) * (Math.PI / 180))), 0, (1 * Math.sin((sourceentity.getYRot() + 90) * (Math.PI / 180)))));
            }
        }
        if (Math.random() <= 0.01) {
            if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60,
                        (sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) + 1, false, false));
        }
        if (Math.random() <= 0.1) {
            if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20, 3, false, false));
        }
    }
}
