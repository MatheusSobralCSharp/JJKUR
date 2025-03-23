package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;

public class KashimoDefenseProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (Math.random() <= 0.5) {
            {
                final Vec3 _center = new Vec3(x, y, z);
                List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                for (Entity entityiterator : _entfound) {
                    if ((entityiterator.getPersistentData().getString("OWNER_UUID")).equals(entity.getStringUUID())) {
                        if (!((entityiterator instanceof LivingEntity) && ((LivingEntity) entityiterator).hasEffect(JujutsucraftModMobEffects.ZONE.get()))) {
                            entityiterator.getPersistentData().putDouble("skill", 710);
                            entityiterator.getPersistentData().putDouble("PRESS_Z", 1);
                            if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (-1), 2, false, false));
                        } else {
                            entityiterator.getPersistentData().putDouble("skill", 705);
                            entityiterator.getPersistentData().putDouble("PRESS_Z", 1);
                            if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (-1), 2, false, false));
                        }
                    }
                }
            }
        }
        if (Math.random() <= 0.2) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.GUARD.get(), 20,
                        (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.GUARD.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.GUARD.get()).getAmplifier() : 0) + 1, false, false));
        }
    }
}
