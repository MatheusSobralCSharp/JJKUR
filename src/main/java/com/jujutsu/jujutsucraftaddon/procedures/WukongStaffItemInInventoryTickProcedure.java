package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class WukongStaffItemInInventoryTickProcedure {
    public static void execute(Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        if (Math.random() <= 0.002) {
            if (itemstack.getOrCreateTag().getBoolean("Mode")) {
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("\u7985"), false);
                itemstack.getOrCreateTag().putBoolean("Mode", false);
            } else {
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("\u8DB3\u4E4B\u8E48\u4E4B\u3002\u5FFD"), false);
                itemstack.getOrCreateTag().putBoolean("Mode", true);
            }
        }
    }
}
