package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class Artifact2RightclickedProcedure {
    public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        if (itemstack.getOrCreateTag().getDouble("CT") == 0) {
            itemstack.getOrCreateTag().putDouble("CT", (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
            itemstack.getOrCreateTag().putString("UUID", (entity.getStringUUID()));
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("Stored Success"), false);
        } else {
            if ((itemstack.getOrCreateTag().getString("UUID")).equals(entity.getStringUUID())) {
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.FlagSixEyes = false;
                    capability.syncPlayerVariables(entity);
                });
                if (entity instanceof LivingEntity _entity)
                    _entity.removeAllEffects();
                {
                    double _setval = (itemstack.getOrCreateTag().getDouble("CT"));
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerCurseTechnique = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
                {
                    double _setval = (itemstack.getOrCreateTag().getDouble("CT"));
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerCurseTechnique2 = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
                if (entity instanceof Player _player) {
                    ItemStack _stktoremove = itemstack;
                    _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                }
            } else {
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Only The Owner can do this"), false);
            }
        }
    }
}
