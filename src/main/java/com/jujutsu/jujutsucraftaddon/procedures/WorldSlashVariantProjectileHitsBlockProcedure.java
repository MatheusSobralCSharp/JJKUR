package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class WorldSlashVariantProjectileHitsBlockProcedure {
    public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity) {
        if (entity == null || immediatesourceentity == null || !(world instanceof ServerLevel serverLevel))
            return;

        if (world instanceof ServerLevel) {
            if (immediatesourceentity instanceof Projectile) {
                if (serverLevel.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
                    Vec3 currentPos = new Vec3(immediatesourceentity.getBlockX(), immediatesourceentity.getBlockY(), immediatesourceentity.getBlockZ());
                    Level level = immediatesourceentity.level();
                    // Set how far forward the particle should affect blocks
                    int forwardRange = 30; // Modify this value to increase or decrease the range
                    for (int i = 0; i < forwardRange; i++) {
                        // Calculate direction based on the source entity's rotation
                        double radians = Math.toRadians(immediatesourceentity.getYRot() + 90);
                        double xOffset = Math.cos(radians) * i; // Cosine for the x direction
                        double zOffset = Math.sin(radians) * i; // Sine for the z direction
                        Vec3 nextPos = currentPos.add(xOffset, // Calculated x-direction
                                0, // Keep the same y-level
                                zOffset // Calculated z-direction
                        );
                        BlockPos blockPos = new BlockPos((int) (nextPos.x + 1), (int) nextPos.y, (int) (nextPos.z + 1));
                        // Break blocks at the current and below positions
                        for (int yOffset = 0; yOffset <= 2; yOffset++) { // Iterate over current and 2 blocks below
                            BlockPos posToCheck = blockPos.below(yOffset);
                            BlockState blockState = level.getBlockState(posToCheck);
                            Block block = blockState.getBlock();
                            // Ensure the block isn't bedrock, barrier, or other unbreakable block
                            if (block != Blocks.BEDROCK && block != Blocks.BARRIER) {
                                level.removeBlock(posToCheck, false);
                                // Optionally, spawn particles or play a sound on block break
                                level.levelEvent(2001, posToCheck, Block.getId(blockState)); // Block break event
                            }
                        }
                    }
                    {
                        Entity _ent = immediatesourceentity;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                    _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "particle jjkueffects:de ~ ~ ~ 0 0 0 1 1 force");
                        }
                    }
                    if (!immediatesourceentity.level().isClientSide())
                        immediatesourceentity.discard();
                }
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.FATIGUE.get(), 20,
                            (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.FATIGUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.FATIGUE.get()).getAmplifier() : 0), false, false));
            }
        }
    }
}
