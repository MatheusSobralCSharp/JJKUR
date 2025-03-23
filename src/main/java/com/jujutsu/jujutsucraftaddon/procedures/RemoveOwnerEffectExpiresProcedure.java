package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;

public class RemoveOwnerEffectExpiresProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        {
            CompoundTag dataIndex = new CompoundTag();
            entity.saveWithoutId(dataIndex);
            dataIndex.putString("Owner", "");
            entity.load(dataIndex);
        }
    }
}
