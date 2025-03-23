package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import java.util.List;

public class MovingRedProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        double Grow = 0;
        double TrackZ = 0;
        double TrackY = 0;
        double TrackX = 0;
        if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("Tatical Mode")) {
            if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Cursed Technique Reversal: Red")) {
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.PlayerSelectCurseTechniqueName = "Moving Reversal: Red";
                    capability.syncPlayerVariables(entity);
                });
            }
            if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Cursed Technique Lapse: Blue")) {
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.PlayerSelectCurseTechniqueName = "Cursed Technique Moving Lapse: Blue";
                    capability.syncPlayerVariables(entity);
                });
            }
            if (!(entity == null)) {
                TrackX = entity.getX()
                        - entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(25)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
                TrackY = entity.getY()
                        - entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(25)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
                TrackZ = entity.getZ()
                        - entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(25)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
                Grow = 1;
                {
                    final Vec3 _center = new Vec3((entity.getX() - TrackX * Grow), ((entity.getY() + entity.getBbHeight() * 0.75) - TrackY * Grow), (entity.getZ() - TrackZ * Grow));
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                    for (Entity entityiterator : _entfound) {
                        if (!(entity == entityiterator)) {
                            if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals("jujutsucraft:red")) {
                                if ((new Object() {
                                    public String getValue() {
                                        CompoundTag dataIndex = new CompoundTag();
                                        entityiterator.saveWithoutId(dataIndex);
                                        return dataIndex.getCompound("ForgeData").getString("OWNER_UUID");
                                    }
                                }.getValue()).equals(entity.getStringUUID())) {
                                    {
                                        Entity _ent = entityiterator;
                                        _ent.teleportTo((entity.getX() - TrackX * Grow), ((entity.getY() + entity.getBbHeight() * 0.75) - TrackY * Grow), (entity.getZ() - TrackZ * Grow));
                                        if (_ent instanceof ServerPlayer _serverPlayer)
                                            _serverPlayer.connection.teleport((entity.getX() - TrackX * Grow), ((entity.getY() + entity.getBbHeight() * 0.75) - TrackY * Grow), (entity.getZ() - TrackZ * Grow), _ent.getYRot(), _ent.getXRot());
                                    }
                                    if (!((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SIX_EYES.get()))) {
                                        {
                                            Entity _ent = entity;
                                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                                _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                        "execute as @s run jjc_cursepower -10 @s");
                                            }
                                        }
                                    } else if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SIX_EYES.get())) {
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
                {
                    final Vec3 _center = new Vec3((entity.getX() - TrackX * Grow), ((entity.getY() + entity.getBbHeight() * 0.75) - TrackY * Grow), (entity.getZ() - TrackZ * Grow));
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                    for (Entity entityiterator : _entfound) {
                        if (!(entity == entityiterator)) {
                            if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals("jujutsucraft:blue")) {
                                if ((new Object() {
                                    public String getValue() {
                                        CompoundTag dataIndex = new CompoundTag();
                                        entityiterator.saveWithoutId(dataIndex);
                                        return dataIndex.getCompound("ForgeData").getString("OWNER_UUID");
                                    }
                                }.getValue()).equals(entity.getStringUUID())) {
                                    {
                                        Entity _ent = entityiterator;
                                        _ent.teleportTo((entity.getX() - TrackX * Grow), ((entity.getY() + entity.getBbHeight() * 0.75) - TrackY * Grow), (entity.getZ() - TrackZ * Grow));
                                        if (_ent instanceof ServerPlayer _serverPlayer)
                                            _serverPlayer.connection.teleport((entity.getX() - TrackX * Grow), ((entity.getY() + entity.getBbHeight() * 0.75) - TrackY * Grow), (entity.getZ() - TrackZ * Grow), _ent.getYRot(), _ent.getXRot());
                                    }
                                    if (!((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SIX_EYES.get()))) {
                                        {
                                            Entity _ent = entity;
                                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                                _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                        "execute as @s run jjc_cursepower -10 @s");
                                            }
                                        }
                                    } else if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SIX_EYES.get())) {
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
