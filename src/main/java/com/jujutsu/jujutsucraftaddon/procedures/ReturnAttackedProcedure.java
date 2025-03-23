package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class ReturnAttackedProcedure {
    public static boolean execute(Entity entity) {
        if (entity == null)
            return false;
        return entity instanceof LivingEntity _entity && _entity.swinging;
    }
}
