package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;

public class GegeProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        {
            CompoundTag dataIndex = new CompoundTag();
            entity.saveWithoutId(dataIndex);
            dataIndex.getCompound("ForgeData").putBoolean("UseCursedTechnique", true);
            entity.load(dataIndex);
        }
        {
            CompoundTag dataIndex = new CompoundTag();
            entity.saveWithoutId(dataIndex);
            dataIndex.getCompound("ForgeData").putBoolean("CurseUser", true);
            entity.load(dataIndex);
        }
    }
}
