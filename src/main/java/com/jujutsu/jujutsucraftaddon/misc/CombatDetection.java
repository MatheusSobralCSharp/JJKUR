package com.jujutsu.jujutsucraftaddon.misc;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Timer;
import java.util.TimerTask;

@Mod.EventBusSubscriber(modid = "jujutsucraftaddon")
public class CombatDetection {

    private static final long COMBAT_DURATION = 5000; // 5 seconds out of combat
    private static final Timer timer = new Timer();

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onPlayerAttack(LivingAttackEvent event) {
        if (event.getSource().getEntity() instanceof Player player) {
            for (ItemStack stack : player.getInventory().items) {
                if (stack.hasTag() && stack.getTag().contains("WeaponSize")) {
                    setCombatState(stack, true);
                }
            }

            // Schedule removal of combat state
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    for (ItemStack stack : player.getInventory().items) {
                        setCombatState(stack, false);
                    }
                }
            }, COMBAT_DURATION);
        }
    }

    private static void setCombatState(ItemStack stack, boolean inCombat) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putBoolean("InCombat", inCombat);
    }
}