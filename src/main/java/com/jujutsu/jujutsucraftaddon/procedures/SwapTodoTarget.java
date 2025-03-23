package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;

public class SwapTodoTarget {
    public static void execute(Entity entity, LevelAccessor world, Entity sourceentity) {
        if (entity == null || world == null) return;
        {
            final Vec3 _center = new Vec3(
                    (entity.getX()),
                    (entity.getY()),
                    (entity.getZ()));
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (!(entity == sourceentity)) {
                    if (!sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living")))) {
                        if (world instanceof ServerLevel _serverLevel) {
                            if (sourceentity instanceof ServerPlayer _player) {
                                if (entity.isShiftKeyDown()) {
                                    {
                                        Entity _ent = entity;
                                        _ent.teleportTo((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()));
                                        if (_ent instanceof ServerPlayer _serverPlayer)
                                            _serverPlayer.connection.teleport((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), _ent.getYRot(), _ent.getXRot());
                                    }
                                } else {
                                    if (sourceentity.getZ() != entity.getZ()) {
                                        double beforeloc = sourceentity.getX();
                                        double beforeloc3 = sourceentity.getY();
                                        double beforeloc2 = sourceentity.getZ();
                                        entity.getPersistentData().putDouble("4", beforeloc);
                                        entity.getPersistentData().putDouble("5", beforeloc3);
                                        entity.getPersistentData().putDouble("6", beforeloc2);
                                        {
                                            Entity _ent = sourceentity;
                                            _ent.teleportTo((entity.getX()), (entity.getY()), (entity.getZ()));
                                            if (_ent instanceof ServerPlayer _serverPlayer)
                                                _serverPlayer.connection.teleport((entity.getX()), (entity.getY()), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
                                        }

                                    } else {
                                        {
                                            Entity _ent = entity;
                                            _ent.teleportTo(entity.getPersistentData().getDouble("4"), entity.getPersistentData().getDouble("5"), entity.getPersistentData().getDouble("6"));
                                            if (_ent instanceof ServerPlayer _serverPlayer)
                                                _serverPlayer.connection.teleport(entity.getPersistentData().getDouble("4"), entity.getPersistentData().getDouble("5"), entity.getPersistentData().getDouble("6"), _ent.getYRot(), _ent.getXRot());
                                        }
                                    }

                                }

                            }
                        }

                        {
                            double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 50);
                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.PlayerCursePower = _setval;
                                capability.syncPlayerVariables(entity);
                            });
                        }

                        break;
                    }
                }
            }
        }
    }
}
