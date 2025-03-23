package com.jujutsu.jujutsucraftaddon.abilities;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Mod.EventBusSubscriber(modid = "jujutsucraftaddon")
public class BoomerangAbility {
    private static final double SPEED = 1.5;       // Base speed of the boomerang
    private static final int MAX_DISTANCE = 20;   // Max travel distance before returning
    private static final float EXPLOSION_STRENGTH = 2.5F;
    private static final double ARC_CURVE = 0.3;  // How much the boomerang arcs
    private static final double ROTATION_SPEED = 40.0; // How fast the boomerang rotates

    private static final List<BoomerangInstance> activeBoomerangs = new ArrayList<>();

    public static void throwBoomerang(Player player) {
        if (player.level().isClientSide) return; // Server-side only

        ServerLevel serverLevel = (ServerLevel) player.level();
        ItemStack mainHandItem = player.getMainHandItem();

        if (mainHandItem.isEmpty()) return; // Don't throw if no item

        Vec3 startPos = player.position().add(0, player.getEyeHeight(), 0);
        Vec3 direction = player.getLookAngle().normalize().scale(SPEED);

        // Create the thrown item entity
        ItemEntity boomerang = new ItemEntity(serverLevel, startPos.x, startPos.y, startPos.z, mainHandItem.copy());
        boomerang.setNoPickUpDelay();
        boomerang.setDeltaMovement(direction);
        serverLevel.addFreshEntity(boomerang);

        // Remove item from player's hand
        player.setItemInHand(player.getUsedItemHand(), ItemStack.EMPTY);

        // Track the boomerang instance
        activeBoomerangs.add(new BoomerangInstance(player, boomerang, direction, 0));
    }

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Iterator<BoomerangInstance> iterator = activeBoomerangs.iterator();
            while (iterator.hasNext()) {
                BoomerangInstance instance = iterator.next();
                instance.tick();

                if (instance.isComplete()) {
                    iterator.remove();
                }
            }
        }
    }

    private static class BoomerangInstance {
        private final Player player;
        private final ItemEntity boomerang;
        private Vec3 velocity;
        private int ticksTraveled;
        private boolean returning = false;

        public BoomerangInstance(Player player, ItemEntity boomerang, Vec3 velocity, int ticksTraveled) {
            this.player = player;
            this.boomerang = boomerang;
            this.velocity = velocity;
            this.ticksTraveled = ticksTraveled;
        }

        public void tick() {
            if (!boomerang.isAlive()) return;

            ServerLevel level = (ServerLevel) player.level();
            Vec3 currentPos = boomerang.position();
            ticksTraveled++;

            // Apply spin effect
            boomerang.setYRot(boomerang.getYRot() + (float) ROTATION_SPEED);

            // Arc motion effect (boomerang curves slightly as it moves)
            double arcOffset = Math.sin(ticksTraveled * 0.2) * ARC_CURVE;
            Vec3 curvedVelocity = new Vec3(velocity.x + arcOffset, velocity.y, velocity.z);

            // Check if it should explode
            for (Entity entity : level.getEntities(null, new AABB(currentPos, currentPos).inflate(1))) {
                if (entity instanceof LivingEntity && entity != player) {
                    explodeWithoutDestroying(level, currentPos);
                    returnToPlayer();
                    return;
                }
            }

            // Check if max distance reached
            if (ticksTraveled >= MAX_DISTANCE && !returning) {
                returnToPlayer();
            }

            // Move boomerang
            if (!returning) {
                boomerang.setDeltaMovement(curvedVelocity);
            } else {
                Vec3 directionToPlayer = player.position().add(0, player.getEyeHeight(), 0).subtract(currentPos).normalize().scale(SPEED);
                boomerang.setDeltaMovement(directionToPlayer);
                if (boomerang.distanceTo(player) < 1.5) {
                    completeReturn();
                }
            }
        }

        private void explodeWithoutDestroying(ServerLevel level, Vec3 pos) {
            level.explode(null, pos.x, pos.y, pos.z, EXPLOSION_STRENGTH, ServerLevel.ExplosionInteraction.NONE);
        }

        private void returnToPlayer() {
            returning = true;
        }

        private void completeReturn() {
            if (player.getMainHandItem().isEmpty()) {
                player.setItemInHand(player.getUsedItemHand(), boomerang.getItem());
            } else {
                player.addItem(boomerang.getItem());
            }
            boomerang.discard();
        }

        public boolean isComplete() {
            return !boomerang.isAlive();
        }
    }
}
