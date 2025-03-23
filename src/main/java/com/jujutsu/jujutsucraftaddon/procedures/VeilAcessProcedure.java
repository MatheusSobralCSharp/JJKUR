package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class VeilAcessProcedure {
    public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
        if (entity == null)
            return;
        if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.ENABLE_SUKUNA_PVP)) {
            {
                CompoundTag dataIndex = new CompoundTag();
                (new Object() {
                    public Entity getEntity() {
                        try {
                            return EntityArgument.getEntity(arguments, "Player");
                        } catch (CommandSyntaxException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
                }.getEntity()).saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putString("VeilUUID", (new Object() {
                    public String getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getString("VeilUUID");
                    }
                }.getValue()));
                (new Object() {
                    public Entity getEntity() {
                        try {
                            return EntityArgument.getEntity(arguments, "Player");
                        } catch (CommandSyntaxException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
                }.getEntity()).load(dataIndex);
            }
            if ((new Object() {
                public Entity getEntity() {
                    try {
                        return EntityArgument.getEntity(arguments, "Player");
                    } catch (CommandSyntaxException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }.getEntity()) instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal(("You're Now Allowed To Join in: " + entity.getDisplayName().getString() + " Veil")), false);
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal(("You Allowed: " + (new Object() {
                    public Entity getEntity() {
                        try {
                            return EntityArgument.getEntity(arguments, "Player");
                        } catch (CommandSyntaxException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
                }.getEntity()).getDisplayName().getString() + " To Join Your Veil")), false);
        }
    }
}
