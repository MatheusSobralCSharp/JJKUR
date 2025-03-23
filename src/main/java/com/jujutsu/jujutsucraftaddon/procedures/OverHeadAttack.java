package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KeyStartTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraft.procedures.KeyStartTechniqueOnKeyReleasedProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class OverHeadAttack {

    public static void execute(LevelAccessor world, Entity entity) {
        if (entity instanceof LivingEntity _entity) {
            entity.getPersistentData().putDouble("skill", 1504);
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.PlayerSelectCurseTechniqueName = (Component.translatable("jujutsu.technique.attack7").getString());
                capability.syncPlayerVariables(entity);
            });
            entity.getPersistentData().putDouble("cnt6", 5);
            KeyStartTechniqueOnKeyPressedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
            KeyStartTechniqueOnKeyReleasedProcedure.execute(entity);
        }
    }
}
