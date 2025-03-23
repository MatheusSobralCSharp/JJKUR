package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import java.util.List;

public class RabbitDarknessProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (!(ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).contains("rabbit")) {
                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 200, 1, false, false));
                    if (entityiterator instanceof Mob) {
                        try {
                            ((Mob) entityiterator).setTarget(null);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    entityiterator.getPersistentData().putDouble("cnt_x", 0);
                    entityiterator.getPersistentData().putDouble("cnt_target", 0);
                }
            }
        }
    }
}
