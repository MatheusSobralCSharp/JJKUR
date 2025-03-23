package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;

public class BloodHitProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        double speed = 0;
        double spread = 0;
        double Grow = 0;
        double TrackZ = 0;
        double TrackY = 0;
        double TrackX = 0;
        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower > 500) {
            if (!(entity == null)) {
                TrackX = entity.getX()
                        - entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(25)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
                TrackY = entity.getY()
                        - entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(25)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
                TrackZ = entity.getZ()
                        - entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(25)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
                Grow = 1;
                for (int index0 = 0; index0 < 20; index0++) {
                    if (world instanceof ServerLevel _level)
                        _level.sendParticles(JujutsucraftaddonModParticleTypes.BLOOD_RED.get(), (entity.getX() - TrackX * Grow), ((entity.getY() + entity.getBbHeight() * 0.75) - TrackY * Grow), (entity.getZ() - TrackZ * Grow),
                                5, 0.15, 0.15, 0.15, 0);
                    Grow = Grow - 0.05;
                }
                {
                    final Vec3 _center = new Vec3((entity.getX() - TrackX * Grow), ((entity.getY() + entity.getBbHeight() * 0.75) - TrackY * Grow), (entity.getZ() - TrackZ * Grow));
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                    for (Entity entityiterator : _entfound) {
                        if (!(entityiterator == entity)) {
                            if (!(entity instanceof LivingEntity _livEnt18 && _livEnt18.hasEffect(JujutsucraftaddonModMobEffects.DEATH_PAINTING_STACK.get()))) {
                                entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))), 20);
                                if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get(), 40,
                                            (entity instanceof LivingEntity && ((LivingEntity) entityiterator).hasEffect(JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get())
                                                    ? ((LivingEntity) entityiterator).getEffect(JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get()).getAmplifier()
                                                    : 0) + 4,
                                            false, true));

                                if (Math.random() < (1) / ((float) 200)) {
                                    if (!((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Death Painting")) {
                                        {
                                            Entity _ent = entity;
                                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                                _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                        "execute as @s run jjc_cursepower -10 @s");
                                            }
                                        }
                                    } else if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Death Painting")) {
                                        {
                                            Entity _ent = entity;
                                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                                _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                        "execute as @s run jjc_cursepower -5 @s");
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (Math.random() < (1) / ((float) 200)) {
                                    entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))), 40);
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get(), 40,
                                                (entity instanceof LivingEntity && ((LivingEntity) entityiterator).hasEffect(JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get())
                                                        ? ((LivingEntity) entityiterator).getEffect(JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get()).getAmplifier()
                                                        : 0) + 6,
                                                false, true));
                                    if (!((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Death Painting")) {
                                        {
                                            Entity _ent = entity;
                                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                                _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                        "execute as @s run jjc_cursepower -10 @s");
                                            }
                                        }
                                    } else if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Death Painting")) {
                                        {
                                            Entity _ent = entity;
                                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                                _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                        "execute as @s run jjc_cursepower -5 @s");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
