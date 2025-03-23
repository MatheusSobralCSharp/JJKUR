package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import com.jujutsu.jujutsucraftaddon.world.inventory.*;
import io.netty.buffer.Unpooled;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.network.NetworkHooks;

public class GojukunaProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 2) {
            if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Gojo")) {
                if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SIX_EYES.get())) {
                    if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH == 0) {
                        if (entity instanceof ServerPlayer _ent) {
                            BlockPos _bpos = BlockPos.containing(x, y, z);
                            NetworkHooks.openScreen(_ent, new MenuProvider() {
                                @Override
                                public Component getDisplayName() {
                                    return Component.literal("StoryModeGojo1");
                                }

                                @Override
                                public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                                    return new StoryModeGojo1Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                                }
                            }, _bpos);
                        }
                    } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH == 1) {
                        if (entity instanceof ServerPlayer _ent) {
                            BlockPos _bpos = BlockPos.containing(x, y, z);
                            NetworkHooks.openScreen(_ent, new MenuProvider() {
                                @Override
                                public Component getDisplayName() {
                                    return Component.literal("StoryModeGojo2");
                                }

                                @Override
                                public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                                    return new StoryModeGojo2Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                                }
                            }, _bpos);
                        }
                    } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH == 2) {
                        if (entity instanceof ServerPlayer _ent) {
                            BlockPos _bpos = BlockPos.containing(x, y, z);
                            NetworkHooks.openScreen(_ent, new MenuProvider() {
                                @Override
                                public Component getDisplayName() {
                                    return Component.literal("StoryModeGojo3");
                                }

                                @Override
                                public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                                    return new StoryModeGojo3Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                                }
                            }, _bpos);
                        }
                    } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH == 3) {
                        if (entity instanceof ServerPlayer _ent) {
                            BlockPos _bpos = BlockPos.containing(x, y, z);
                            NetworkHooks.openScreen(_ent, new MenuProvider() {
                                @Override
                                public Component getDisplayName() {
                                    return Component.literal("StoryModeGojo4");
                                }

                                @Override
                                public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                                    return new StoryModeGojo4Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                                }
                            }, _bpos);
                        }
                    } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH == 4) {
                        if (entity instanceof ServerPlayer _ent) {
                            BlockPos _bpos = BlockPos.containing(x, y, z);
                            NetworkHooks.openScreen(_ent, new MenuProvider() {
                                @Override
                                public Component getDisplayName() {
                                    return Component.literal("StoryModeGojo6");
                                }

                                @Override
                                public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                                    return new StoryModeGojo6Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                                }
                            }, _bpos);
                        }
                    }
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 1) {
            if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Sukuna")) {
                if ((((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount() >= 3.0)) {
                    if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 0) {
                        if (entity instanceof ServerPlayer _ent) {
                            BlockPos _bpos = BlockPos.containing(x, y, z);
                            NetworkHooks.openScreen(_ent, new MenuProvider() {
                                @Override
                                public Component getDisplayName() {
                                    return Component.literal("StoryModeSukuna1");
                                }

                                @Override
                                public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                                    return new StoryModeSukuna1Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                                }
                            }, _bpos);
                        }
                    } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 1) {
                        if (entity instanceof ServerPlayer _ent) {
                            BlockPos _bpos = BlockPos.containing(x, y, z);
                            NetworkHooks.openScreen(_ent, new MenuProvider() {
                                @Override
                                public Component getDisplayName() {
                                    return Component.literal("StoryModeSukuna2");
                                }

                                @Override
                                public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                                    return new StoryModeSukuna2Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                                }
                            }, _bpos);
                        }
                    } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 2) {
                        if (entity instanceof ServerPlayer _ent) {
                            BlockPos _bpos = BlockPos.containing(x, y, z);
                            NetworkHooks.openScreen(_ent, new MenuProvider() {
                                @Override
                                public Component getDisplayName() {
                                    return Component.literal("StoryModeSukuna3");
                                }

                                @Override
                                public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                                    return new StoryModeSukuna3Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                                }
                            }, _bpos);
                        }
                    } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 3) {
                        if (entity instanceof ServerPlayer _ent) {
                            BlockPos _bpos = BlockPos.containing(x, y, z);
                            NetworkHooks.openScreen(_ent, new MenuProvider() {
                                @Override
                                public Component getDisplayName() {
                                    return Component.literal("StoryModeSukuna4");
                                }

                                @Override
                                public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                                    return new StoryModeSukuna4Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                                }
                            }, _bpos);
                        }
                    } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 4) {
                        if (entity instanceof ServerPlayer _plr13 && _plr13.level() instanceof ServerLevel
                                && _plr13.getAdvancements().getOrStartProgress(_plr13.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:bath_ritual"))).isDone()) {
                            if (entity instanceof ServerPlayer _ent) {
                                BlockPos _bpos = BlockPos.containing(x, y, z);
                                NetworkHooks.openScreen(_ent, new MenuProvider() {
                                    @Override
                                    public Component getDisplayName() {
                                        return Component.literal("StoryModeSukuna5");
                                    }

                                    @Override
                                    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                                        return new StoryModeSukuna5Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                                    }
                                }, _bpos);
                            }
                        }
                    } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 5) {
                        if (entity instanceof ServerPlayer _plr15 && _plr15.level() instanceof ServerLevel
                                && _plr15.getAdvancements().getOrStartProgress(_plr15.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:bath_ritual"))).isDone()) {
                            if (entity instanceof ServerPlayer _ent) {
                                BlockPos _bpos = BlockPos.containing(x, y, z);
                                NetworkHooks.openScreen(_ent, new MenuProvider() {
                                    @Override
                                    public Component getDisplayName() {
                                        return Component.literal("StoryModeSukuna6");
                                    }

                                    @Override
                                    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                                        return new StoryModeSukuna6Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                                    }
                                }, _bpos);
                            }
                        }
                    } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 6) {
                        if (entity instanceof ServerPlayer _plr17 && _plr17.level() instanceof ServerLevel
                                && _plr17.getAdvancements().getOrStartProgress(_plr17.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:bath_ritual"))).isDone()) {
                            if (entity instanceof ServerPlayer _ent) {
                                BlockPos _bpos = BlockPos.containing(x, y, z);
                                NetworkHooks.openScreen(_ent, new MenuProvider() {
                                    @Override
                                    public Component getDisplayName() {
                                        return Component.literal("StoryModeSukuna7");
                                    }

                                    @Override
                                    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                                        return new StoryModeSukuna7Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                                    }
                                }, _bpos);
                            }
                        }
                    }
                }
            }
        }
    }
}
