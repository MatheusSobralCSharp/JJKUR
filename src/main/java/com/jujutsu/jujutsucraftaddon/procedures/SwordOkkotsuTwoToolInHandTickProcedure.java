package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class SwordOkkotsuTwoToolInHandTickProcedure {
    public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("Passive Copy Mode")) {
            if (itemstack.getOrCreateTag().getDouble("skill") > 0) {
                if (itemstack.getOrCreateTag().getDouble("CT") == 0) {
                    itemstack.getOrCreateTag().putDouble("CT", Math.floor(itemstack.getOrCreateTag().getDouble("skill") / 100));
                } else {
                    if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != itemstack.getOrCreateTag().getDouble("CT")) {
                        {
                            double _setval = (itemstack.getOrCreateTag().getDouble("CT"));
                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.PlayerCurseTechnique2 = _setval;
                                capability.syncPlayerVariables(entity);
                            });
                        }
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 300, 1, false, false));
                        if (entity instanceof Player _player) {
                            ItemStack _stktoremove = itemstack;
                            _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                        }
                    }
                }
            }
        }
    }
}
