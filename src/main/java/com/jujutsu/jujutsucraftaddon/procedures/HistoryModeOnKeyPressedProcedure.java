package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import com.jujutsu.jujutsucraftaddon.world.inventory.*;
import io.netty.buffer.Unpooled;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.network.NetworkHooks;

public class HistoryModeOnKeyPressedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_HISTORY_MODE)) {
            if (!entity.isShiftKeyDown()) {
                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History <= 1) {
                    if (entity instanceof ServerPlayer _ent) {
                        BlockPos _bpos = BlockPos.containing(x, y, z);
                        NetworkHooks.openScreen(_ent, new MenuProvider() {
                            @Override
                            public Component getDisplayName() {
                                return Component.literal("Quest1");
                            }

                            @Override
                            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                                return new Quest1Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                            }
                        }, _bpos);
                    }
                } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 2) {
                    if (entity instanceof ServerPlayer _ent) {
                        BlockPos _bpos = BlockPos.containing(x, y, z);
                        NetworkHooks.openScreen(_ent, new MenuProvider() {
                            @Override
                            public Component getDisplayName() {
                                return Component.literal("Quest2");
                            }

                            @Override
                            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                                return new Quest2Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                            }
                        }, _bpos);
                    }
                } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 3) {
                    if (entity instanceof ServerPlayer _ent) {
                        BlockPos _bpos = BlockPos.containing(x, y, z);
                        NetworkHooks.openScreen(_ent, new MenuProvider() {
                            @Override
                            public Component getDisplayName() {
                                return Component.literal("Quest3");
                            }

                            @Override
                            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                                return new Quest3Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                            }
                        }, _bpos);
                    }
                } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 4) {
                    if (entity instanceof ServerPlayer _ent) {
                        BlockPos _bpos = BlockPos.containing(x, y, z);
                        NetworkHooks.openScreen(_ent, new MenuProvider() {
                            @Override
                            public Component getDisplayName() {
                                return Component.literal("Quest4");
                            }

                            @Override
                            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                                return new Quest4Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                            }
                        }, _bpos);
                    }
                } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 5) {
                    if (entity instanceof ServerPlayer _ent) {
                        BlockPos _bpos = BlockPos.containing(x, y, z);
                        NetworkHooks.openScreen(_ent, new MenuProvider() {
                            @Override
                            public Component getDisplayName() {
                                return Component.literal("Quest5");
                            }

                            @Override
                            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                                return new Quest5Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                            }
                        }, _bpos);
                    }
                } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 6) {
                    if (entity instanceof ServerPlayer _ent) {
                        BlockPos _bpos = BlockPos.containing(x, y, z);
                        NetworkHooks.openScreen(_ent, new MenuProvider() {
                            @Override
                            public Component getDisplayName() {
                                return Component.literal("Quest6");
                            }

                            @Override
                            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                                return new Quest6Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                            }
                        }, _bpos);
                    }
                } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 7) {
                    if (entity instanceof ServerPlayer _ent) {
                        BlockPos _bpos = BlockPos.containing(x, y, z);
                        NetworkHooks.openScreen(_ent, new MenuProvider() {
                            @Override
                            public Component getDisplayName() {
                                return Component.literal("Quest7");
                            }

                            @Override
                            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                                return new Quest7Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                            }
                        }, _bpos);
                    }
                } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 8) {
                    if (entity instanceof ServerPlayer _ent) {
                        BlockPos _bpos = BlockPos.containing(x, y, z);
                        NetworkHooks.openScreen(_ent, new MenuProvider() {
                            @Override
                            public Component getDisplayName() {
                                return Component.literal("Quest8");
                            }

                            @Override
                            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                                return new Quest8Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                            }
                        }, _bpos);
                    }
                } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 9) {
                    if (entity instanceof ServerPlayer _ent) {
                        BlockPos _bpos = BlockPos.containing(x, y, z);
                        NetworkHooks.openScreen(_ent, new MenuProvider() {
                            @Override
                            public Component getDisplayName() {
                                return Component.literal("Quest9");
                            }

                            @Override
                            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                                return new Quest9Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                            }
                        }, _bpos);
                    }
                } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 10) {
                    if (entity instanceof ServerPlayer _ent) {
                        BlockPos _bpos = BlockPos.containing(x, y, z);
                        NetworkHooks.openScreen(_ent, new MenuProvider() {
                            @Override
                            public Component getDisplayName() {
                                return Component.literal("Quest10");
                            }

                            @Override
                            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                                return new Quest10Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                            }
                        }, _bpos);
                    }
                } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 11) {
                    if (entity instanceof ServerPlayer _ent) {
                        BlockPos _bpos = BlockPos.containing(x, y, z);
                        NetworkHooks.openScreen(_ent, new MenuProvider() {
                            @Override
                            public Component getDisplayName() {
                                return Component.literal("Quest11");
                            }

                            @Override
                            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                                return new Quest11Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                            }
                        }, _bpos);
                    }
                } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 12) {
                    if (entity instanceof ServerPlayer _ent) {
                        BlockPos _bpos = BlockPos.containing(x, y, z);
                        NetworkHooks.openScreen(_ent, new MenuProvider() {
                            @Override
                            public Component getDisplayName() {
                                return Component.literal("Quest12");
                            }

                            @Override
                            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                                return new Quest12Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                            }
                        }, _bpos);
                    }
                } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 13) {
                    if (entity instanceof ServerPlayer _ent) {
                        BlockPos _bpos = BlockPos.containing(x, y, z);
                        NetworkHooks.openScreen(_ent, new MenuProvider() {
                            @Override
                            public Component getDisplayName() {
                                return Component.literal("Quest13");
                            }

                            @Override
                            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                                return new Quest13Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                            }
                        }, _bpos);
                    }
                } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 14) {
                    if (entity instanceof ServerPlayer _ent) {
                        BlockPos _bpos = BlockPos.containing(x, y, z);
                        NetworkHooks.openScreen(_ent, new MenuProvider() {
                            @Override
                            public Component getDisplayName() {
                                return Component.literal("Quest14");
                            }

                            @Override
                            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                                return new Quest14Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                            }
                        }, _bpos);
                    }
                }
            }
        }
    }
}
