package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;

public class UroSneakyOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (!(entityiterator == entity)) {
                    if (!(entityiterator instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MobEffects.BLINDNESS))) {
                        if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 254, false, false));
                    }
                    entityiterator.getPersistentData().putDouble("cnt_x", 0);
                    entityiterator.getPersistentData().putDouble("cnt_target", 0);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        entityiterator.saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("cnt_target", 0);
                        entityiterator.load(dataIndex);
                    }
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        entityiterator.saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("cnt_x", 0);
                        entityiterator.load(dataIndex);
                    }
                }
            }
        }
    }
}
