package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class PVPProcedure {
    public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
        if (entity == null)
            return;
        String team = "";
        if (BoolArgumentType.getBool(arguments, "Team")) {
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).PVP && ((new Object() {
                public Entity getEntity() {
                    try {
                        return EntityArgument.getEntity(arguments, "Player");
                    } catch (CommandSyntaxException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }.getEntity()).getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).PVP) {
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal(("Invited: " + new Object() {
                        public Entity getEntity() {
                            try {
                                return EntityArgument.getEntity(arguments, "Player");
                            } catch (CommandSyntaxException e) {
                                e.printStackTrace();
                                return null;
                            }
                        }
                    }.getEntity() + " Team To PVP")), false);
                if ((new Object() {
                    public Entity getEntity() {
                        try {
                            return EntityArgument.getEntity(arguments, "Player");
                        } catch (CommandSyntaxException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
                }.getEntity()) instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal((entity + " Invited Your Team" + "To PVP")), false);
                {
                    Entity _ent = entity;
                    _ent.teleportTo(JujutsucraftaddonModVariables.MapVariables.get(world).X, JujutsucraftaddonModVariables.MapVariables.get(world).Y, JujutsucraftaddonModVariables.MapVariables.get(world).Z);
                    if (_ent instanceof ServerPlayer _serverPlayer)
                        _serverPlayer.connection.teleport(JujutsucraftaddonModVariables.MapVariables.get(world).X, JujutsucraftaddonModVariables.MapVariables.get(world).Y, JujutsucraftaddonModVariables.MapVariables.get(world).Z, _ent.getYRot(),
                                _ent.getXRot());
                }
                {
                    Entity _ent = (new Object() {
                        public Entity getEntity() {
                            try {
                                return EntityArgument.getEntity(arguments, "Player");
                            } catch (CommandSyntaxException e) {
                                e.printStackTrace();
                                return null;
                            }
                        }
                    }.getEntity());
                    _ent.teleportTo(JujutsucraftaddonModVariables.MapVariables.get(world).X1, JujutsucraftaddonModVariables.MapVariables.get(world).Y1, JujutsucraftaddonModVariables.MapVariables.get(world).Z1);
                    if (_ent instanceof ServerPlayer _serverPlayer)
                        _serverPlayer.connection.teleport(JujutsucraftaddonModVariables.MapVariables.get(world).X1, JujutsucraftaddonModVariables.MapVariables.get(world).Y1, JujutsucraftaddonModVariables.MapVariables.get(world).Z1, _ent.getYRot(),
                                _ent.getXRot());
                }
                if (world instanceof ServerLevel) {
                    for (Entity entityiterator : ((ServerLevel) world).getAllEntities()) {
                        if (entityiterator != null)
                            continue;
                        if (((new Object() {
                            public Entity getEntity() {
                                try {
                                    return EntityArgument.getEntity(arguments, "Player");
                                } catch (CommandSyntaxException e) {
                                    e.printStackTrace();
                                    return null;
                                }
                            }
                        }.getEntity()).getStringUUID()).equals(new Object() {
                            public String getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entityiterator.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getString("OWNER_UUID");
                            }
                        }.getValue())) {
                            if (entityiterator instanceof Player _player && !_player.level().isClientSide())
                                _player.displayClientMessage(Component.literal(("Your Leader Called: " + entity + " Team To PVP")), false);
                            if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BATTLE.get(), -1, 1, false, false));
                            {
                                Entity _ent = entityiterator;
                                _ent.teleportTo(JujutsucraftaddonModVariables.MapVariables.get(world).X1, JujutsucraftaddonModVariables.MapVariables.get(world).Y1, JujutsucraftaddonModVariables.MapVariables.get(world).Z1);
                                if (_ent instanceof ServerPlayer _serverPlayer)
                                    _serverPlayer.connection.teleport(JujutsucraftaddonModVariables.MapVariables.get(world).X1, JujutsucraftaddonModVariables.MapVariables.get(world).Y1, JujutsucraftaddonModVariables.MapVariables.get(world).Z1,
                                            _ent.getYRot(), _ent.getXRot());
                            }
                            {
                                String _setval = entity.getStringUUID();
                                entityiterator.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.UUIDBattle = _setval;
                                    capability.syncPlayerVariables(entityiterator);
                                });
                            }
                        }
                        if ((entity.getStringUUID()).equals(new Object() {
                            public String getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entityiterator.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getString("OWNER_UUID");
                            }
                        }.getValue())) {
                            if (entityiterator instanceof Player _player && !_player.level().isClientSide())
                                _player.displayClientMessage(Component.literal(("Your Leader Called: " + new Object() {
                                    public Entity getEntity() {
                                        try {
                                            return EntityArgument.getEntity(arguments, "Player");
                                        } catch (CommandSyntaxException e) {
                                            e.printStackTrace();
                                            return null;
                                        }
                                    }
                                }.getEntity() + " Team To PVP")), false);
                            if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BATTLE.get(), -1, 1, false, false));
                            {
                                Entity _ent = entityiterator;
                                _ent.teleportTo(JujutsucraftaddonModVariables.MapVariables.get(world).X, JujutsucraftaddonModVariables.MapVariables.get(world).Y, JujutsucraftaddonModVariables.MapVariables.get(world).Z);
                                if (_ent instanceof ServerPlayer _serverPlayer)
                                    _serverPlayer.connection.teleport(JujutsucraftaddonModVariables.MapVariables.get(world).X, JujutsucraftaddonModVariables.MapVariables.get(world).Y, JujutsucraftaddonModVariables.MapVariables.get(world).Z,
                                            _ent.getYRot(), _ent.getXRot());
                            }
                            {
                                String _setval = (new Object() {
                                    public Entity getEntity() {
                                        try {
                                            return EntityArgument.getEntity(arguments, "Player");
                                        } catch (CommandSyntaxException e) {
                                            e.printStackTrace();
                                            return null;
                                        }
                                    }
                                }.getEntity()).getStringUUID();
                                entityiterator.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.UUIDBattle = _setval;
                                    capability.syncPlayerVariables(entityiterator);
                                });
                            }
                        }
                    }
                }
            }
        } else if (!BoolArgumentType.getBool(arguments, "Team")) {
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).PVP && ((new Object() {
                public Entity getEntity() {
                    try {
                        return EntityArgument.getEntity(arguments, "Player");
                    } catch (CommandSyntaxException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }.getEntity()).getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).PVP) {
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal(("Invited: " + new Object() {
                        public Entity getEntity() {
                            try {
                                return EntityArgument.getEntity(arguments, "Player");
                            } catch (CommandSyntaxException e) {
                                e.printStackTrace();
                                return null;
                            }
                        }
                    }.getEntity() + " To PVP")), false);
                if ((new Object() {
                    public Entity getEntity() {
                        try {
                            return EntityArgument.getEntity(arguments, "Player");
                        } catch (CommandSyntaxException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
                }.getEntity()) instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal((entity + " Invited You" + "To PVP")), false);
                {
                    String _setval = entity.getStringUUID();
                    (new Object() {
                        public Entity getEntity() {
                            try {
                                return EntityArgument.getEntity(arguments, "Player");
                            } catch (CommandSyntaxException e) {
                                e.printStackTrace();
                                return null;
                            }
                        }
                    }.getEntity()).getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.UUIDBattle = _setval;
                        capability.syncPlayerVariables((new Object() {
                            public Entity getEntity() {
                                try {
                                    return EntityArgument.getEntity(arguments, "Player");
                                } catch (CommandSyntaxException e) {
                                    e.printStackTrace();
                                    return null;
                                }
                            }
                        }.getEntity()));
                    });
                }
                {
                    String _setval = (new Object() {
                        public Entity getEntity() {
                            try {
                                return EntityArgument.getEntity(arguments, "Player");
                            } catch (CommandSyntaxException e) {
                                e.printStackTrace();
                                return null;
                            }
                        }
                    }.getEntity()).getStringUUID();
                    entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.UUIDBattle = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BATTLE.get(), -1, 1, false, false));
                if ((new Object() {
                    public Entity getEntity() {
                        try {
                            return EntityArgument.getEntity(arguments, "Player");
                        } catch (CommandSyntaxException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
                }.getEntity()) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BATTLE.get(), -1, 1, false, false));
                {
                    Entity _ent = entity;
                    _ent.teleportTo(JujutsucraftaddonModVariables.MapVariables.get(world).X, JujutsucraftaddonModVariables.MapVariables.get(world).Y, JujutsucraftaddonModVariables.MapVariables.get(world).Z);
                    if (_ent instanceof ServerPlayer _serverPlayer)
                        _serverPlayer.connection.teleport(JujutsucraftaddonModVariables.MapVariables.get(world).X, JujutsucraftaddonModVariables.MapVariables.get(world).Y, JujutsucraftaddonModVariables.MapVariables.get(world).Z, _ent.getYRot(),
                                _ent.getXRot());
                }
                {
                    Entity _ent = (new Object() {
                        public Entity getEntity() {
                            try {
                                return EntityArgument.getEntity(arguments, "Player");
                            } catch (CommandSyntaxException e) {
                                e.printStackTrace();
                                return null;
                            }
                        }
                    }.getEntity());
                    _ent.teleportTo(JujutsucraftaddonModVariables.MapVariables.get(world).X1, JujutsucraftaddonModVariables.MapVariables.get(world).Y1, JujutsucraftaddonModVariables.MapVariables.get(world).Z1);
                    if (_ent instanceof ServerPlayer _serverPlayer)
                        _serverPlayer.connection.teleport(JujutsucraftaddonModVariables.MapVariables.get(world).X1, JujutsucraftaddonModVariables.MapVariables.get(world).Y1, JujutsucraftaddonModVariables.MapVariables.get(world).Z1, _ent.getYRot(),
                                _ent.getXRot());
                }
            }
        }
    }
}
