package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class JJKUFrienddProcedure {
    public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
        if (entity == null)
            return;
        try {
            for (Entity entityiterator : EntityArgument.getEntities(arguments, "Friend")) {
                {
                    CompoundTag dataIndex = new CompoundTag();
                    entityiterator.saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                    entityiterator.load(dataIndex);
                }
                {
                    CompoundTag dataIndex = new CompoundTag();
                    entityiterator.saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    entityiterator.load(dataIndex);
                }
                {
                    CompoundTag dataIndex = new CompoundTag();
                    entityiterator.saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("friend_num2");
                        }
                    }.getValue()));
                    entityiterator.load(dataIndex);
                }
                {
                    CompoundTag dataIndex = new CompoundTag();
                    entityiterator.saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("friend_num_worker");
                        }
                    }.getValue()));
                    entityiterator.load(dataIndex);
                }
                {
                    String _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).TeamName;
                    entityiterator.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.TeamName = _setval;
                        capability.syncPlayerVariables(entityiterator);
                    });
                }
                if (entityiterator instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal(("Now you are in: " + entity.getDisplayName().getString() + " Team")), false);
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal(("\"Successful Invited: " + entityiterator.getDisplayName().getString())), false);
            }
        } catch (CommandSyntaxException e) {
            e.printStackTrace();
        }
    }
}
