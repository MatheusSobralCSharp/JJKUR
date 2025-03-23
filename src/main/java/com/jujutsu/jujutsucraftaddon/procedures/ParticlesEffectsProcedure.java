package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class ParticlesEffectsProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        double r = 0;
        double curve = 0;
        double deg = 0;
        double yoff = 0;
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("skill_domain");
            }
        }.getValue() == 0) {
            if (entity instanceof LivingEntity _entity)
                _entity.removeEffect(JujutsucraftaddonModMobEffects.SHRINE_EFFECT.get());
        }
    }
}
