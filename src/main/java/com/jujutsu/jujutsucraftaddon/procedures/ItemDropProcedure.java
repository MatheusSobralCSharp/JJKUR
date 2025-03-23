package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ItemDropProcedure {
    @SubscribeEvent
    public static void onGemDropped(ItemTossEvent event) {
        execute(event, event.getPlayer(), event.getEntity().getItem());
    }

    public static void execute(Entity entity, ItemStack itemstack) {
        execute(null, entity, itemstack);
    }

    private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        if (itemstack.getItem() == JujutsucraftaddonModItems.YUTA_RING.get()) {
            if (entity instanceof Player _player) {
                ItemStack _stktoremove = new ItemStack(JujutsucraftaddonModItems.YUTA_RING.get());
                _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
            }
            if (event != null && event.isCancelable()) {
                event.setCanceled(true);
            } else if (event != null && event.hasResult()) {
                event.setResult(Event.Result.DENY);
            }
        }
    }
}
