package com.jujutsu.jujutsucraftaddon.abilities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber(modid = "jujutsucraftaddon")
public class SongOfTimeAbility {

    private static final Map<LivingEntity, PlayerState> playerStates = new HashMap<>();
    private static final Map<BlockPos, BlockState> worldStates = new HashMap<>();
    private static long savedTime;

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END && event.getServer().getTickCount() % 200 == 0) { // Every 5 seconds
            saveState(event.getServer());
        }
    }

    private static void saveState(net.minecraft.server.MinecraftServer server) {
        savedTime = server.overworld().getDayTime();
        for (ServerPlayer player : server.getPlayerList().getPlayers()) {
            playerStates.put(player, new PlayerState(player));
        }

        for (ServerLevel level : server.getAllLevels()) {
            for (Entity entity : level.getAllEntities()) {
                if (entity instanceof LivingEntity livingEntity) {
                    playerStates.put(livingEntity, new PlayerState(livingEntity));
                }
            }
        }
    }

    private static void playOcarinaAnimation(ServerPlayer player) {
        player.swing(player.getUsedItemHand(), true);
        for (int i = 0; i < 20; i++) {
            player.level().addParticle(ParticleTypes.NOTE, player.getX(), player.getY() + 2.0, player.getZ(), Math.random(), 1.0, Math.random());
        }
    }

    public static void activateSongOfTime(net.minecraft.server.MinecraftServer server, ServerPlayer player) {
        playOcarinaAnimation(player);
        for (ServerPlayer p : server.getPlayerList().getPlayers()) {
            if (playerStates.containsKey(p)) {
                PlayerState state = playerStates.get(p);
                Vec3 startPos = p.position();
                Vec3 endPos = new Vec3(state.x, state.y, state.z);
                for (int i = 0; i <= 20; i++) { // Move over 1 second
                    Vec3 interpolated = startPos.lerp(endPos, i / 20.0);
                    // Set the position directly without using teleportTo (avoid movement desync)
                    p.setPos(interpolated.x, interpolated.y, interpolated.z);

                    // Optional: Add a small delay between updates to simulate smooth movement
                    // Use server tick updates instead of Thread.sleep (avoid using sleep in the main thread)
                    server.execute(() -> {
                        // Delay logic can be added here with tick-based actions
                    });
                }

                // Restore effects
                p.removeAllEffects(); // Remove current effects to prevent stacking
                for (MobEffectInstance effect : state.effects) {
                    p.addEffect(new MobEffectInstance(effect));
                }

                p.getInventory().clearContent();
                for (int i = 0; i < state.inventory.size(); i++) {
                    p.getInventory().setItem(i, state.inventory.get(i).copy());
                }

                if (p instanceof LivingEntity) {
                    ((LivingEntity) p).setHealth(state.health);
                }

                CompoundTag nbt = state.nbtData.copy();
                p.load(nbt);
            }
        }

        final Vec3 _center = new Vec3(player.getX(), player.getY(), player.getZ());
        LevelAccessor world = player.level();
        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(300), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();


        for (Entity p : _entfound) {
            if (playerStates.containsKey(p)) {
                PlayerState state = playerStates.get(p);
                Vec3 startPos = p.position();
                Vec3 endPos = new Vec3(state.x, state.y, state.z);
                for (int i = 0; i <= 20; i++) { // Move over 1 second
                    Vec3 interpolated = startPos.lerp(endPos, i / 20.0);
                    // Set the position directly without using teleportTo (avoid movement desync)
                    p.setPos(interpolated.x, interpolated.y, interpolated.z);

                    // Optional: Add a small delay between updates to simulate smooth movement
                    // Use server tick updates instead of Thread.sleep (avoid using sleep in the main thread)
                    server.execute(() -> {
                        // Delay logic can be added here with tick-based actions
                    });
                }


                if (p instanceof LivingEntity) {
                    ((LivingEntity) p).setHealth(state.health);

                    ((LivingEntity) p).removeAllEffects(); // Remove current effects to prevent stacking
                    for (MobEffectInstance effect : state.effects) {
                        ((LivingEntity) p).addEffect(new MobEffectInstance(effect));
                    }

                    if (p instanceof LivingEntity) {
                        ((LivingEntity) p).setHealth(state.health);
                    }

                    CompoundTag nbt = state.nbtData.copy();
                    p.load(nbt);
                }

            }
        }

        server.overworld().setDayTime(savedTime);
    }

    public static void activateSongOfStorms(net.minecraft.server.MinecraftServer server, ServerPlayer player) {
        playOcarinaAnimation(player);
        server.overworld().setWeatherParameters(0, 6000, true, true); // Start storm for 5 minutes
    }

    public static void activateSongOfSnow(net.minecraft.server.MinecraftServer server, ServerPlayer player) {
        playOcarinaAnimation(player);
        server.overworld().setWeatherParameters(0, 6000, true, false); // Start storm for 5 minutes
    }

    public static void activateEponasSong(ServerPlayer player) {
        playOcarinaAnimation(player);
        Horse horse = EntityType.HORSE.create(player.level());
        horse.setPos(player.getX(), player.getY(), player.getZ());
        horse.setTamed(true);
        horse.setOwnerUUID(player.getUUID());
        horse.setCustomName(player.getName());
        horse.setSpeed(0.3375F);
        player.level().addFreshEntity(horse);
        player.startRiding(horse);
    }

    public static void activateSunsSong(net.minecraft.server.MinecraftServer server, ServerPlayer player) {
        playOcarinaAnimation(player);
        long time = server.overworld().getDayTime();
        server.overworld().setDayTime(time < 12000 ? 18000 : 0); // Switch day/night
    }

    public static void activateSongOfHealing(ServerPlayer player) {
        playOcarinaAnimation(player);
        player.setHealth(player.getMaxHealth());
        player.removeAllEffects();
    }

    public static void activateBoleroOfFire(ServerPlayer player) {
        playOcarinaAnimation(player);
        player.setSecondsOnFire(5);
    }

    public static void activateSerenadeOfWater(ServerPlayer player) {
        playOcarinaAnimation(player);
        player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 6000, 1));
        player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 6000, 1));
    }

    public static void activateNocturneOfShadow(ServerPlayer player) {
        playOcarinaAnimation(player);
        player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 6000, 1));
    }

    private static class PlayerState {
        private final double x, y, z;
        private final float health;
        private final CompoundTag nbtData;
        private final List<MobEffectInstance> effects;
        private final List<ItemStack> inventory;

        public PlayerState(LivingEntity player) {
            this.x = player.getX();
            this.y = player.getY();
            this.z = player.getZ();
            this.health = player.getHealth();

            // Store NBT data
            this.nbtData = new CompoundTag();
            player.save(nbtData);

            // Store active effects
            this.effects = player.getActiveEffects().stream()
                    .map(effect -> new MobEffectInstance(effect)) // Copy the effect
                    .collect(Collectors.toList());

            // Store inventory if the player is an instance of Player
            if (player instanceof Player p) {
                this.inventory = p.getInventory().items.stream()
                        .map(ItemStack::copy) // Copy items to prevent modifications
                        .collect(Collectors.toList());
            } else {
                this.inventory = List.of(); // Empty list if not a Player
            }
        }
    }
}