package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class Tsukumo2Procedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex0 = new CompoundTag();
                entity.saveWithoutId(dataIndex0);
                return dataIndex0.getCompound("ForgeData").getDouble("skill");
            }
        }.getValue() > 0) {

        }
    }
}
