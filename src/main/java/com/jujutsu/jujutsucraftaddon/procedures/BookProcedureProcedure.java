package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class BookProcedureProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        {
            Entity _ent = entity;
            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                _ent.getServer().getCommands().performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
                                _ent.level().getServer(), _ent),
                        ("give @s minecraft:written_book{author:\"Satushi\",title:\"\u00A7f\u00A7lJujutsu Guide 2\",pages:[" + "'{\"text\":\"" + Component.translatable("dialogue11").getString() + "\"}','{\"text\":\""
                                + Component.translatable("dialogue12").getString() + "\"}','{\"text\":\"" + Component.translatable("dialogue13").getString() + "\"}','{\"text\":\"" + Component.translatable("dialogue14").getString() + "\"}']}"));
            }
        }
        {
            Entity _ent = entity;
            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                _ent.getServer().getCommands().performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
                                _ent.level().getServer(), _ent),
                        ("give @s minecraft:written_book{author:\"Satushi\",title:\"\u00A74\u00A7lJujutsu Guide\",pages:[" + "'{\"text\":\"" + Component.translatable("dialogue21").getString() + "\"}','{\"text\":\""
                                + Component.translatable("dialogue22").getString() + "\"}','{\"text\":\"" + Component.translatable("dialogue23").getString() + "\"}']}"));
            }
        }
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal((Component.translatable("dialoguebeg1").getString())), false);
        {
            Entity _ent = entity;
            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                _ent.getServer().getCommands()
                        .performPrefixedCommand(
                                new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
                                        _ent.level().getServer(), _ent),
                                "tellraw @s {\"text\":\"\u00A74\u00A7n\u00A7lTRELLO LINK\",\"bold\":true,\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://trello.com/b/n0ljEYBS/jujutsu-kaisen-ultimate\"}}");
            }
        }
        {
            Entity _ent = entity;
            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                        "tellraw @s {\"text\":\"\u00A79\u00A7n\u00A7lDISCORD LINK\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://discord.gg/SCmjWRQdZ8\"}}");
            }
        }
    }
}
