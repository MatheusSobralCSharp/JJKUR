package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.PartialRikaEntity;
import net.mcreator.jujutsucraft.entity.*;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.procedures.SetTagProcedure;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class SetTagPartial {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity != null) {
            double NUM1 = 0.0;
            double size = 0.0;
            SetTagProcedure.execute(world, entity);
            entity.getPersistentData().putBoolean("CursedSpirit", true);
            if (entity instanceof CursedSpiritGrade16Entity) {
                Entity _ent = entity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "data merge entity @s {Silent:1b}");
                }
            }

            if (entity instanceof CursedSpiritGrade21Entity || entity instanceof CursedSpiritGrade22Entity || entity instanceof CursedSpiritGrade23Entity || entity instanceof CursedSpiritGrade25Entity || entity instanceof CursedSpiritGrade26Entity || entity instanceof CursedSpiritGrade27Entity || entity instanceof CursedSpiritGrade28Entity || entity instanceof CursedSpiritGrade13Entity) {
                entity.setMaxUpStep(entity.getStepHeight() * 2.0F);
            }

            if (entity instanceof PartialRikaEntity) {
                ((LivingEntity) entity).getAttribute(JujutsucraftModAttributes.SIZE.get()).setBaseValue(3);
            }

        }
    }
}
