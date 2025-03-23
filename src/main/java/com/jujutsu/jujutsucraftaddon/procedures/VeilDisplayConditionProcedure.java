package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.VeilEntity;
import net.minecraft.world.entity.Entity;

public class VeilDisplayConditionProcedure {
    public static boolean execute(Entity entity) {
        if (entity == null)
            return false;
        return (entity instanceof VeilEntity _datEntI ? _datEntI.getEntityData().get(VeilEntity.DATA_FlagColor) : 0) == 1;
    }
}
