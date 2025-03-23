package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class ArmoryOrCopyOnKeyReleasedProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ARMORY_CHESTPLATE.get()
                || (ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:cursed_spirit_armoury_chestplate")) {
            if (Math.random() >= 0.9 && Math.random() <= 1) {
                if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot0)
                        .is(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade4")))
                        || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot0)
                        .is(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade1")))
                        || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot0)
                        .is(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade2")))
                        || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot0)
                        .is(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade3")))
                        || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot0)
                        .is(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade0")))
                        || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot0)
                        .is(ItemTags.create(new ResourceLocation("has_technique_tools")))) {
                    if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
                        if (!(((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot0).getItem() == ItemStack.EMPTY.getItem())) {
                            if (entity instanceof LivingEntity _entity) {
                                ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot0).copy();
                                _setstack.setCount(1);
                                _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                if (_entity instanceof Player _player)
                                    _player.getInventory().setChanged();
                            }
                            {
                                ItemStack _setval = ItemStack.EMPTY;
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.InventoryArmorySlot0 = _setval.copy();
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        }
                    } else if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
                        if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
                            if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot4).getItem() == ItemStack.EMPTY.getItem()) {
                                {
                                    ItemStack _setval = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
                                    entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                        capability.InventoryArmorySlot4 = _setval.copy();
                                        capability.syncPlayerVariables(entity);
                                    });
                                }
                            }
                        }
                        if (entity instanceof LivingEntity _entity) {
                            ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot0).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player)
                                _player.getInventory().setChanged();
                        }
                    }
                }
            } else if (Math.random() >= 0.6 && Math.random() <= 0.8) {
                if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot1)
                        .is(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade4")))
                        || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot1)
                        .is(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade1")))
                        || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot1)
                        .is(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade2")))
                        || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot1)
                        .is(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade3")))
                        || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot1)
                        .is(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade0")))
                        || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot1)
                        .is(ItemTags.create(new ResourceLocation("has_technique_tools")))) {
                    if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
                        if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot0).getItem() == ItemStack.EMPTY.getItem()) {
                            {
                                ItemStack _setval = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.InventoryArmorySlot0 = _setval.copy();
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        }
                    }
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot1).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player)
                            _player.getInventory().setChanged();
                    }
                }
            } else {
                if (Math.random() >= 0.4 && Math.random() <= 0.5) {
                    if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot2)
                            .is(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade4")))
                            || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot2)
                            .is(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade1")))
                            || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot2)
                            .is(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade2")))
                            || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot2)
                            .is(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade3")))
                            || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot2)
                            .is(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade0")))
                            || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot2)
                            .is(ItemTags.create(new ResourceLocation("has_technique_tools")))) {
                        if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
                            if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot1).getItem() == ItemStack.EMPTY.getItem()) {
                                {
                                    ItemStack _setval = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
                                    entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                        capability.InventoryArmorySlot1 = _setval.copy();
                                        capability.syncPlayerVariables(entity);
                                    });
                                }
                            }
                        }
                        if (entity instanceof LivingEntity _entity) {
                            ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot2).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player)
                                _player.getInventory().setChanged();
                        }
                    }
                } else {
                    if (Math.random() >= 0.2 && Math.random() <= 0.3) {
                        if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot3)
                                .is(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade4")))
                                || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot3)
                                .is(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade1")))
                                || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot3)
                                .is(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade2")))
                                || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot3)
                                .is(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade3")))
                                || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot3)
                                .is(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade0")))
                                || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot3)
                                .is(ItemTags.create(new ResourceLocation("has_technique_tools")))) {
                            if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
                                if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot2).getItem() == ItemStack.EMPTY.getItem()) {
                                    {
                                        ItemStack _setval = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
                                        entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                            capability.InventoryArmorySlot2 = _setval.copy();
                                            capability.syncPlayerVariables(entity);
                                        });
                                    }
                                }
                            }
                            if (entity instanceof LivingEntity _entity) {
                                ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot3).copy();
                                _setstack.setCount(1);
                                _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                if (_entity instanceof Player _player)
                                    _player.getInventory().setChanged();
                            }
                        }
                    } else if (Math.random() >= 0.1 && Math.random() <= 0.2) {
                        if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot4)
                                .is(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade4")))
                                || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot4)
                                .is(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade1")))
                                || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot4)
                                .is(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade2")))
                                || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot4)
                                .is(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade3")))
                                || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot4)
                                .is(ItemTags.create(new ResourceLocation("jujutsucraft:cursed_tool_grade0")))
                                || ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot4)
                                .is(ItemTags.create(new ResourceLocation("has_technique_tools")))) {
                            if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
                                if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot3).getItem() == ItemStack.EMPTY.getItem()) {
                                    {
                                        ItemStack _setval = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
                                        entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                            capability.InventoryArmorySlot3 = _setval.copy();
                                            capability.syncPlayerVariables(entity);
                                        });
                                    }
                                }
                            }
                            if (entity instanceof LivingEntity _entity) {
                                ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InventoryArmorySlot4).copy();
                                _setstack.setCount(1);
                                _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                if (_entity instanceof Player _player)
                                    _player.getInventory().setChanged();
                            }
                        }
                    }
                }
            }
        } else if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ARMORY_CHESTPLATE.get())
                && (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 5) {
            if (Math.random() >= 0.9 && Math.random() < 1) {
                if ((ForgeRegistries.ITEMS.getKey(((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot1).getItem()).toString())
                        .equals("jujutsucraft:cursed_technique_starter")) {
                    {
                        ItemStack _setval = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
                        entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.slot0 = _setval.copy();
                            capability.syncPlayerVariables(entity);
                        });
                    }
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot1).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player)
                            _player.getInventory().setChanged();
                    }
                }
            } else if (Math.random() >= 0.8 && Math.random() < 0.9) {
                if ((ForgeRegistries.ITEMS.getKey(((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot2).getItem()).toString())
                        .equals("jujutsucraft:cursed_technique_starter")) {
                    {
                        ItemStack _setval = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
                        entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.slot1 = _setval.copy();
                            capability.syncPlayerVariables(entity);
                        });
                    }
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot2).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player)
                            _player.getInventory().setChanged();
                    }
                }
            } else if (Math.random() > 0.7 && Math.random() < 0.8) {
                if ((ForgeRegistries.ITEMS.getKey(((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot3).getItem()).toString())
                        .equals("jujutsucraft:cursed_technique_starter")) {
                    {
                        ItemStack _setval = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
                        entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.slot2 = _setval.copy();
                            capability.syncPlayerVariables(entity);
                        });
                    }
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot3).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player)
                            _player.getInventory().setChanged();
                    }
                }
            } else if (Math.random() > 0.6 && Math.random() < 0.7) {
                if ((ForgeRegistries.ITEMS.getKey(((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot4).getItem()).toString())
                        .equals("jujutsucraft:cursed_technique_starter")) {
                    {
                        ItemStack _setval = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
                        entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.slot3 = _setval.copy();
                            capability.syncPlayerVariables(entity);
                        });
                    }
                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot4).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player)
                            _player.getInventory().setChanged();
                    }
                }
            } else {
                if (Math.random() > 0.5 && Math.random() < 0.6) {
                    if ((ForgeRegistries.ITEMS.getKey(((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot5).getItem()).toString())
                            .equals("jujutsucraft:cursed_technique_starter")) {
                        {
                            ItemStack _setval = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
                            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.slot4 = _setval.copy();
                                capability.syncPlayerVariables(entity);
                            });
                        }
                        if (entity instanceof LivingEntity _entity) {
                            ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot5).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player)
                                _player.getInventory().setChanged();
                        }
                    }
                } else {
                    if (Math.random() >= 0.4 && Math.random() < 0.5) {
                        if ((ForgeRegistries.ITEMS.getKey(((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot6).getItem()).toString())
                                .equals("jujutsucraft:cursed_technique_starter")) {
                            {
                                ItemStack _setval = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.slot5 = _setval.copy();
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                            if (entity instanceof LivingEntity _entity) {
                                ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot6).copy();
                                _setstack.setCount(1);
                                _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                if (_entity instanceof Player _player)
                                    _player.getInventory().setChanged();
                            }
                        }
                    } else if (Math.random() >= 0.3 && Math.random() < 0.4) {
                        if ((ForgeRegistries.ITEMS.getKey(((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot7).getItem()).toString())
                                .equals("jujutsucraft:cursed_technique_starter")) {
                            {
                                ItemStack _setval = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.slot6 = _setval.copy();
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                            if (entity instanceof LivingEntity _entity) {
                                ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot7).copy();
                                _setstack.setCount(1);
                                _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                if (_entity instanceof Player _player)
                                    _player.getInventory().setChanged();
                            }
                        }
                    } else if (Math.random() >= 0.1 && Math.random() < 0.2) {
                        if ((ForgeRegistries.ITEMS.getKey(((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot8).getItem()).toString())
                                .equals("jujutsucraft:cursed_technique_starter")) {
                            {
                                ItemStack _setval = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.slot7 = _setval.copy();
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                            if (entity instanceof LivingEntity _entity) {
                                ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot8).copy();
                                _setstack.setCount(1);
                                _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                if (_entity instanceof Player _player)
                                    _player.getInventory().setChanged();
                            }
                        }
                    } else if (Math.random() >= 0.05 && Math.random() < 0.1) {
                        if ((ForgeRegistries.ITEMS.getKey(((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot9).getItem()).toString())
                                .equals("jujutsucraft:cursed_technique_starter")) {
                            {
                                ItemStack _setval = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.slot8 = _setval.copy();
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                            if (entity instanceof LivingEntity _entity) {
                                ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot9).copy();
                                _setstack.setCount(1);
                                _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                if (_entity instanceof Player _player)
                                    _player.getInventory().setChanged();
                            }
                        }
                    } else if (Math.random() >= 0.01 && Math.random() < 0.05) {
                        if ((ForgeRegistries.ITEMS.getKey(((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot10).getItem()).toString())
                                .equals("jujutsucraft:cursed_technique_starter")) {
                            {
                                ItemStack _setval = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.slot9 = _setval.copy();
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                            if (entity instanceof LivingEntity _entity) {
                                ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).slot10).copy();
                                _setstack.setCount(1);
                                _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                if (_entity instanceof Player _player)
                                    _player.getInventory().setChanged();
                            }
                        }
                    }
                }
            }
        }
    }
}
