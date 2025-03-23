package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class ArtifactRightclickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        double repeats = 0;
        String endtext = "";
        if (entity.isShiftKeyDown()) {
            if (itemstack.getOrCreateTag().getDouble("Mode") == 0 || itemstack.getOrCreateTag().getDouble("Mode") == 3) {
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Absorb Mode"), true);
                itemstack.getOrCreateTag().putDouble("Mode", 1);
                itemstack.getOrCreateTag().putBoolean("Absorb", true);
            } else if (itemstack.getOrCreateTag().getDouble("Mode") == 1) {
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Fill Mode"), true);
                itemstack.getOrCreateTag().putDouble("Mode", 2);
                itemstack.getOrCreateTag().putBoolean("Absorb", false);
            } else if (itemstack.getOrCreateTag().getDouble("Mode") == 2) {
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Curtain Mode"), true);
                itemstack.getOrCreateTag().putDouble("Mode", 3);
            }
        } else {
            if (itemstack.getOrCreateTag().getDouble("Mode") == 2) {
                {
                    double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower + itemstack.getOrCreateTag().getDouble("CE"));
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerCursePower = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
                if (entity instanceof Player _player) {
                    ItemStack _stktoremove = itemstack;
                    _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                }
            }
            if (itemstack.getOrCreateTag().getDouble("Mode") == 3) {
                VeilCreateProcedure.execute(world, x, y, z, entity);
            }
        }
    }
}
