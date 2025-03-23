package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class RCTCutOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex0 = new CompoundTag();
                entity.saveWithoutId(dataIndex0);
                return dataIndex0.getCompound("ForgeData").getDouble("PRESS_M");
            }
        }.getValue() == 1) {
            CompoundTag dataIndex1 = new CompoundTag();
            entity.saveWithoutId(dataIndex1);
            dataIndex1.getCompound("ForgeData").putDouble("PRESS_M", 0);
            entity.load(dataIndex1);
        }
        if (entity instanceof LivingEntity _entity)
            _entity.removeEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get());
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 254, false, false));
    }
}
