package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class DomainTimeEffectStartedappliedProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = 22;
        JujutsucraftModVariables.MapVariables.get(world).syncData(world);
        entity.getPersistentData().putDouble("cnt2", 0);
    }
}
