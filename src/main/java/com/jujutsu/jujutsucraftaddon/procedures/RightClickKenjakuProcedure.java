package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RightClickKenjakuProcedure {
    @SubscribeEvent
    public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;
        execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getTarget(), event.getEntity());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        execute(null, world, x, y, z, entity, sourceentity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).IsVessel) {
            if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:kenjaku")) {
                if (sourceentity instanceof Player _playerHasItem && _playerHasItem.getInventory().contains(new ItemStack(JujutsucraftaddonModItems.CURSED_WOMB.get()))) {
                    if (Math.random() <= 0.01) {
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Now you are a Hybrid"), false);
                        {
                            boolean _setval = true;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.IsCursedSpirit = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                        {
                            boolean _setval = true;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.IsJujutsuSorcerer = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                        {
                            boolean _setval = false;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.IsVessel = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                        {
                            String _setval = "Hybrid";
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.Subrace = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                    }
                    if (sourceentity instanceof Player _player) {
                        ItemStack _stktoremove = new ItemStack(JujutsucraftaddonModItems.CURSED_WOMB.get());
                        _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                    }
                }
            } else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:sukuna") || (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:sukuna_fushiguro")
                    || (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:sukuna_perfect")) {
                if ((ForgeRegistries.ITEMS.getKey((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:sukuna_finger")) {
                    if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_CAN_TAME_SUKUNA)) {
                        if (Math.random() <= 0.1) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex = new CompoundTag();
                                        sourceentity.saveWithoutId(dataIndex);
                                        return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                    }
                                }.getValue()));
                                entity.load(dataIndex);
                            }
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex = new CompoundTag();
                                        sourceentity.saveWithoutId(dataIndex);
                                        return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                    }
                                }.getValue()));
                                entity.load(dataIndex);
                            }
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex = new CompoundTag();
                                        sourceentity.saveWithoutId(dataIndex);
                                        return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                    }
                                }.getValue()));
                                entity.load(dataIndex);
                            }
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                                entity.load(dataIndex);
                            }
                            if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                                _player.displayClientMessage(Component.literal(("\"I will join your side and kill everyone that you wan't, " + sourceentity.getDisplayName().getString())), false);
                        }
                        if (sourceentity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player)
                                _player.getInventory().setChanged();
                        }
                    }
                }
            }
        }
        RightClickBuffProcedure.execute(world, x, y, z, entity, sourceentity);
        YutaRingLivingEntityIsHitWithItemProcedure.execute(world, entity, sourceentity);
        YagaDollNew2Procedure.execute(world, x, y, z, entity, sourceentity);
    }
}
