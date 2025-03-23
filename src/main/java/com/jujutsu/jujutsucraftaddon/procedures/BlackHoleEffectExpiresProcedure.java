package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;

public class BlackHoleEffectExpiresProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (!entity.level().isClientSide())
            entity.discard();
    }
}
