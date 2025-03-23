package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;

public class WorldSlashKeyOnKeyReleasedProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        boolean found = false;
        double sx = 0;
        double sy = 0;
        double sz = 0;
        {
            CompoundTag dataIndex = new CompoundTag();
            entity.saveWithoutId(dataIndex);
            dataIndex.getCompound("ForgeData").putBoolean("PRESS_ULT", false);
            entity.load(dataIndex);
        }
        {
            Entity _ent = entity;
            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                        _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "stopsound @s *");
            }
        }
        {
            CompoundTag dataIndex = new CompoundTag();
            entity.saveWithoutId(dataIndex);
            dataIndex.getCompound("ForgeData").putDouble("cnt_ult", 0);
            entity.load(dataIndex);
        }
    }
}
