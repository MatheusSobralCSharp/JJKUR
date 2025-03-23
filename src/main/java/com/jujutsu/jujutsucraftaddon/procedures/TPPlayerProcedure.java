package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class TPPlayerProcedure {
    public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
        if (entity == null)
            return;
        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 2) {
            if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(JujutsucraftaddonModMobEffects.COOLDOWN_TP.get()))) {
                {
                    Entity _ent = entity;
                    _ent.teleportTo(((new Object() {
                        public Entity getEntity() {
                            try {
                                return EntityArgument.getEntity(arguments, "Player");
                            } catch (CommandSyntaxException e) {
                                e.printStackTrace();
                                return null;
                            }
                        }
                    }.getEntity()).getX()), ((new Object() {
                        public Entity getEntity() {
                            try {
                                return EntityArgument.getEntity(arguments, "Player");
                            } catch (CommandSyntaxException e) {
                                e.printStackTrace();
                                return null;
                            }
                        }
                    }.getEntity()).getY()), ((new Object() {
                        public Entity getEntity() {
                            try {
                                return EntityArgument.getEntity(arguments, "Player");
                            } catch (CommandSyntaxException e) {
                                e.printStackTrace();
                                return null;
                            }
                        }
                    }.getEntity()).getZ()));
                    if (_ent instanceof ServerPlayer _serverPlayer)
                        _serverPlayer.connection.teleport(((new Object() {
                            public Entity getEntity() {
                                try {
                                    return EntityArgument.getEntity(arguments, "Player");
                                } catch (CommandSyntaxException e) {
                                    e.printStackTrace();
                                    return null;
                                }
                            }
                        }.getEntity()).getX()), ((new Object() {
                            public Entity getEntity() {
                                try {
                                    return EntityArgument.getEntity(arguments, "Player");
                                } catch (CommandSyntaxException e) {
                                    e.printStackTrace();
                                    return null;
                                }
                            }
                        }.getEntity()).getY()), ((new Object() {
                            public Entity getEntity() {
                                try {
                                    return EntityArgument.getEntity(arguments, "Player");
                                } catch (CommandSyntaxException e) {
                                    e.printStackTrace();
                                    return null;
                                }
                            }
                        }.getEntity()).getZ()), _ent.getYRot(), _ent.getXRot());
                }
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Teleported"), false);
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
                    _player.displayClientMessage(Component.literal("You Sense Someone Behind You.."), false);
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.COOLDOWN_TP.get(), 1200 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_GOJO_TP)), 1, false, false));
            } else {
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("\u00A79\u00A7lMugen on Cooldown"), false);
            }
        }
    }
}
