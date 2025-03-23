package com.jujutsu.jujutsucraftaddon;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = "jujutuscraftaddon", bus = Mod.EventBusSubscriber.Bus.MOD)
public class WaveEffect {
    public static void createShockwave(Level world, BlockPos center, int maxRadius, int damage) {
        if (world == null)
            return;

        for (int radius = 2; radius <= maxRadius; radius++) {
            for (BlockPos pos : getRing(center, radius)) {
                //Replace "YourMod" with the actual Mod class, in my case it's "BoltzyBreezeMod"
                JujutsucraftaddonMod.queueServerWork(radius * 4, () -> {
                    //Some Particles
                    if (world instanceof ServerLevel _level)
                        _level.getServer().getCommands().performPrefixedCommand(
                                new CommandSourceStack(CommandSource.NULL, new Vec3(pos.getX() + 0.5, (pos.getY() + 1.1), pos.getZ() + 0.5), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                                ("/particle sweep_attack ~ ~ ~ 0 0 0 1 0 normal"));
                    // Displace the block at the current position
                    if (world.getBlockState(pos).getBlock() != Blocks.AIR && world.getBlockState(pos).getBlock() != Blocks.BEDROCK && !world.getBlockState(pos).is(BlockTags.create(new ResourceLocation("jujutsucraft:barrier")))) {
                        if (!((world.getBlockState(pos)).getBlock() == Blocks.WATER) && !world.isEmptyBlock(pos)) {
                            if (world instanceof ServerLevel _level) {
                                String blockName = ForgeRegistries.BLOCKS.getKey(world.getBlockState(pos).getBlock()).toString();
                                String command = String.format(
                                        "/summon falling_block ~ ~1 ~ {BlockState:{Name:\"%s\"},Time:1,Motion:[0.0,0.2,0.0]}",
                                        blockName
                                );

                                _level.getServer().getCommands().performPrefixedCommand(
                                        new CommandSourceStack(
                                                CommandSource.NULL,
                                                new Vec3(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5),
                                                Vec2.ZERO,
                                                _level,
                                                4,
                                                "",
                                                Component.literal(""),
                                                _level.getServer(),
                                                null
                                        ).withSuppressedOutput(),
                                        command
                                );
                            }
                            if (world instanceof ServerLevel _level)
                                _level.getServer().getCommands().performPrefixedCommand(
                                        new CommandSourceStack(CommandSource.NULL, new Vec3(pos.getX() + 0.5, (pos.getY()), pos.getZ() + 0.5), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                                        ("/fill ~ ~ ~ ~ ~ ~ air replace"));
                        }
                    }
                    // Damage entities within the current position
                    AABB aabb = new AABB(pos).inflate(5);
                    for (Entity entity : world.getEntitiesOfClass(LivingEntity.class, aabb)) {
                        if (entity instanceof Player _player) {
                            continue;
                        }
                        entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FALL)), damage);
                        entity.setDeltaMovement(entity.getDeltaMovement().x(), 1.1, entity.getDeltaMovement().z);

                        if (entity instanceof LivingEntity entity2)
                            entity2.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 40, 0, false, false)); // 200 ticks = 10 seconds, amplifier = 0
                        if (entity instanceof LivingEntity entity2)
                            entity2.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get(), 40, 0, false, false)); // 200 ticks = 10 seconds, amplifier = 0


                    }
                });
            }
        }


    }

    // Helper method to get a ring of blocks at a specific radius
    private static Iterable<BlockPos> getRing(BlockPos center, int radius) {
        List<BlockPos> positions = new ArrayList<>();
        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {
                if (Math.sqrt(dx * dx + dz * dz) >= radius - 0.5 && Math.sqrt(dx * dx + dz * dz) <= radius + 0.5) {
                    positions.add(center.offset(dx, 0, dz));
                }
            }
        }
        return positions;
    }
}