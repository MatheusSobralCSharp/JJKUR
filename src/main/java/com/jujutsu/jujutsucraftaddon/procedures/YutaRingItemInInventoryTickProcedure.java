package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class YutaRingItemInInventoryTickProcedure {
    public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        double cooldown1 = 0;
        if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Okkotsu")) {
            if (itemstack.getOrCreateTag().getDouble("Regen") == 0) {
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Rika Sent You Energy"), false);
                {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run jjc_cursepower 300 @s");
                    }
                }
                itemstack.getOrCreateTag().putDouble("Regen", 400);
            } else {
                itemstack.getOrCreateTag().putDouble("Regen", (itemstack.getOrCreateTag().getDouble("Regen") - 1));
            }
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("RikaRing");
                }
            }.getValue() == 0) {
                {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("RikaRing", 1);
                    entity.load(dataIndex);
                }
            }
        }
    }
}
