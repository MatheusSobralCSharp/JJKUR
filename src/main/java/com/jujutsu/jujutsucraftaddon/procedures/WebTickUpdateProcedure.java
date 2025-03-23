package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.entity.CleaveWebEntity;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.BlockDestroyAllDirectionProcedure;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import java.util.List;

public class WebTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        boolean found = false;
        double sx = 0;
        double sy = 0;
        double sz = 0;
        if (entity instanceof CleaveWebEntity) {
            if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
                world.destroyBlock(BlockPos.containing(entity.getX() + Mth.nextDouble(RandomSource.create(), -10, 10), entity.getY() + Mth.nextInt(RandomSource.create(), 0, 1), entity.getZ() + Mth.nextDouble(RandomSource.create(), -3, 3)), false);
                world.destroyBlock(BlockPos.containing(entity.getX() + Mth.nextDouble(RandomSource.create(), -10, 10), entity.getY() + 1, entity.getZ() + Mth.nextDouble(RandomSource.create(), -10, 10)), false);
                world.destroyBlock(BlockPos.containing(x, entity.getY() + 1, z), false);
                world.destroyBlock(BlockPos.containing(entity.getX() + Mth.nextDouble(RandomSource.create(), -10, 3), entity.getY() + 1, entity.getZ() + Mth.nextDouble(RandomSource.create(), -10, 10)), false);
                world.destroyBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), false);
                world.destroyBlock(BlockPos.containing(x, entity.getY(), z), false);
                world.destroyBlock(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), false);
            }
            {
                final Vec3 _center = new Vec3(x, y, z);
                List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                for (Entity entityiterator : _entfound) {
                    if (!(entityiterator == entity)) {
                        if (!(new Object() {
                            public String getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getString("OWNER_UUID");
                            }
                        }.getValue()).equals(entityiterator.getStringUUID())) {
                            if (!(entityiterator instanceof LivingEntity && ((LivingEntity) entityiterator).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()))) {
                                if (world instanceof ServerLevel _level)
                                    _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI.get(), (entityiterator.getX()), (entityiterator.getY() + Mth.nextDouble(RandomSource.create(), 0, 2)), (entityiterator.getZ()), 1,
                                            0, 0, 0, 1);
                                if (Math.random() <= 0.01) {
                                    if (world instanceof Level _level) {
                                        if (!_level.isClientSide()) {
                                            _level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:swordsweeep")),
                                                    SoundSource.NEUTRAL, 1, 1);
                                        } else {
                                            _level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:swordsweeep")),
                                                    SoundSource.NEUTRAL, 1, 1, false);
                                        }
                                    }
                                }
                                entityiterator.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
                                if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60,
                                            (entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WEAKNESS) ? _livEnt.getEffect(MobEffects.WEAKNESS).getAmplifier() : 0) + 1, false, false));
                                if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 60,
                                            (entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.CONFUSION) ? _livEnt.getEffect(MobEffects.CONFUSION).getAmplifier() : 0) + 1, false, false));
                                if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(MobEffects.POISON, 60,
                                            (entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.CONFUSION) ? _livEnt.getEffect(MobEffects.CONFUSION).getAmplifier() : 0) + 1, false, false));
                                if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60,
                                            (entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) ? _livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier() : 0) + 1, false, false));
                                {
                                    Entity _ent = entityiterator;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                        _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                "execute as @s run effect give @s jujutsucraft:cancel_cursed_technique 2 2 true");
                                    }
                                }
                                JujutsucraftaddonMod.queueServerWork(100, () -> {
                                    if (!entity.level().isClientSide())
                                        entity.discard();
                                });
                            }
                        }
                    }
                }
            }
            if ((entity instanceof CleaveWebEntity _datEntI ? _datEntI.getEntityData().get(CleaveWebEntity.DATA_b) : 0) == 1) {
                BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
            }
        }
    }
}
