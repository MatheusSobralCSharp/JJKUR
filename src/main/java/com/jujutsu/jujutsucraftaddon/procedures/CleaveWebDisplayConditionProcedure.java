package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.CleaveWebEntity;
import net.minecraft.world.entity.Entity;

public class CleaveWebDisplayConditionProcedure {
    public static boolean execute(Entity entity) {
        if (entity == null)
            return false;
        return (entity instanceof CleaveWebEntity _datEntI ? _datEntI.getEntityData().get(CleaveWebEntity.DATA_b) : 0) == 1;
    }
}
