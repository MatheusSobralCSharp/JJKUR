package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class SpawnCloneDefensiveProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 15) {
            if (world instanceof ServerLevel _serverLevel) {
                LevelAccessor _worldorig = world;
                world = _serverLevel.getServer().getLevel(entity.level().dimension());
                if (world != null) {
                    Entity entitytospawn = JujutsucraftaddonModEntities.FAKE_CLONES.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                            (entitytospawn).load(dataIndex);
                        }
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.putString("Owner", (entity.getStringUUID()));
                            (entitytospawn).load(dataIndex);
                        }
                        (entitytospawn).setCustomName(Component.literal((entity.getDisplayName().getString())));
                        if ((entitytospawn) instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK))
                            _livingEntity12.getAttribute(Attributes.ATTACK_KNOCKBACK).setBaseValue(
                                    (entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK) ? _livingEntity10.getAttribute(Attributes.ATTACK_KNOCKBACK).getBaseValue() : 0));
                        if ((entitytospawn) instanceof LivingEntity _livingEntity15 && _livingEntity15.getAttributes().hasAttribute(Attributes.ARMOR))
                            _livingEntity15.getAttribute(Attributes.ARMOR)
                                    .setBaseValue((entity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(Attributes.ARMOR) ? _livingEntity13.getAttribute(Attributes.ARMOR).getBaseValue() : 0));
                        if ((entitytospawn) instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS))
                            _livingEntity18.getAttribute(Attributes.ARMOR_TOUGHNESS).setBaseValue(
                                    (entity instanceof LivingEntity _livingEntity16 && _livingEntity16.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS) ? _livingEntity16.getAttribute(Attributes.ARMOR_TOUGHNESS).getBaseValue() : 0));
                        if ((entitytospawn) instanceof LivingEntity _livingEntity21 && _livingEntity21.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
                            _livingEntity21.getAttribute(Attributes.ATTACK_DAMAGE)
                                    .setBaseValue((entity instanceof LivingEntity _livingEntity19 && _livingEntity19.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity19.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0));
                        if ((entitytospawn) instanceof LivingEntity _livingEntity24 && _livingEntity24.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                            _livingEntity24.getAttribute(Attributes.MAX_HEALTH).setBaseValue(
                                    ((entity instanceof LivingEntity _livingEntity22 && _livingEntity22.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity22.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) * 60));
                        if ((entitytospawn) instanceof LivingEntity _livingEntity26 && _livingEntity26.getAttributes().hasAttribute(Attributes.FOLLOW_RANGE))
                            _livingEntity26.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(256);
                        if ((entitytospawn) instanceof LivingEntity _livingEntity29 && _livingEntity29.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
                            _livingEntity29.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(
                                    (entity instanceof LivingEntity _livingEntity27 && _livingEntity27.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE) ? _livingEntity27.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue() : 0));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof LivingEntity _entity) {
                            ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player)
                                _player.getInventory().setChanged();
                        }
                        {
                            Entity _entity = (entitytospawn);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().armor.set(0, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
                                _player.getInventory().setChanged();
                            } else if (_entity instanceof LivingEntity _living) {
                                _living.setItemSlot(EquipmentSlot.FEET, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
                            }
                        }
                        {
                            Entity _entity = (entitytospawn);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().armor.set(1, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
                                _player.getInventory().setChanged();
                            } else if (_entity instanceof LivingEntity _living) {
                                _living.setItemSlot(EquipmentSlot.LEGS, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
                            }
                        }
                        {
                            Entity _entity = (entitytospawn);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().armor.set(2, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY));
                                _player.getInventory().setChanged();
                            } else if (_entity instanceof LivingEntity _living) {
                                _living.setItemSlot(EquipmentSlot.CHEST, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY));
                            }
                        }
                        {
                            Entity _entity = (entitytospawn);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().armor.set(3, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY));
                                _player.getInventory().setChanged();
                            } else if (_entity instanceof LivingEntity _living) {
                                _living.setItemSlot(EquipmentSlot.HEAD, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY));
                            }
                        }
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 60, 245, false, true));
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 245, false, true));
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                }
                            }.getValue()));
                            (entitytospawn).load(dataIndex);
                        }
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                }
                            }.getValue()));
                            (entitytospawn).load(dataIndex);
                        }
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putDouble("Tagged", (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique);
                            (entitytospawn).load(dataIndex);
                        }
                        (entitytospawn).getPersistentData().putDouble("Tagged", (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique);
                        (entitytospawn).getPersistentData().putString("Owner", (entity.getStringUUID()));
                        (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                        if ((entitytospawn) instanceof TamableAnimal _toTame && entity instanceof Player _owner)
                            _toTame.tame(_owner);
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putBoolean("UseCursedTechnique", true);
                            (entitytospawn).load(dataIndex);
                        }
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putBoolean("JujutsuSorcerer", (new Object() {
                                public boolean getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getBoolean("JujutsuSorcerer");
                                }
                            }.getValue()));
                            (entitytospawn).load(dataIndex);
                        }
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putBoolean("CursedSpirit", (new Object() {
                                public boolean getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getBoolean("CursedSpirit");
                                }
                            }.getValue()));
                            (entitytospawn).load(dataIndex);
                        }
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putBoolean("CurseUser", (new Object() {
                                public boolean getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getBoolean("CurseUser");
                                }
                            }.getValue()));
                            (entitytospawn).load(dataIndex);
                        }
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
                world = _worldorig;
            }
        } else {
            if (world instanceof ServerLevel _serverLevel) {
                LevelAccessor _worldorig = world;
                world = _serverLevel.getServer().getLevel(entity.level().dimension());
                if (world != null) {
                    Entity entitytospawn = JujutsucraftaddonModEntities.FAKE_CLONES.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                            (entitytospawn).load(dataIndex);
                        }
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.putString("Owner", (entity.getStringUUID()));
                            (entitytospawn).load(dataIndex);
                        }
                        (entitytospawn).setCustomName(Component.literal((entity.getDisplayName().getString())));
                        if ((entitytospawn) instanceof LivingEntity _livingEntity96 && _livingEntity96.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK))
                            _livingEntity96.getAttribute(Attributes.ATTACK_KNOCKBACK).setBaseValue(
                                    (entity instanceof LivingEntity _livingEntity94 && _livingEntity94.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK) ? _livingEntity94.getAttribute(Attributes.ATTACK_KNOCKBACK).getBaseValue() : 0));
                        if ((entitytospawn) instanceof LivingEntity _livingEntity99 && _livingEntity99.getAttributes().hasAttribute(Attributes.ARMOR))
                            _livingEntity99.getAttribute(Attributes.ARMOR)
                                    .setBaseValue((entity instanceof LivingEntity _livingEntity97 && _livingEntity97.getAttributes().hasAttribute(Attributes.ARMOR) ? _livingEntity97.getAttribute(Attributes.ARMOR).getBaseValue() : 0));
                        if ((entitytospawn) instanceof LivingEntity _livingEntity102 && _livingEntity102.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS))
                            _livingEntity102.getAttribute(Attributes.ARMOR_TOUGHNESS).setBaseValue(
                                    (entity instanceof LivingEntity _livingEntity100 && _livingEntity100.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS) ? _livingEntity100.getAttribute(Attributes.ARMOR_TOUGHNESS).getBaseValue() : 0));
                        if ((entitytospawn) instanceof LivingEntity _livingEntity105 && _livingEntity105.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
                            _livingEntity105.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(
                                    (entity instanceof LivingEntity _livingEntity103 && _livingEntity103.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity103.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0));
                        if ((entitytospawn) instanceof LivingEntity _livingEntity108 && _livingEntity108.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                            _livingEntity108.getAttribute(Attributes.MAX_HEALTH).setBaseValue(
                                    ((entity instanceof LivingEntity _livingEntity106 && _livingEntity106.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity106.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) * 60));
                        if ((entitytospawn) instanceof LivingEntity _livingEntity110 && _livingEntity110.getAttributes().hasAttribute(Attributes.FOLLOW_RANGE))
                            _livingEntity110.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(256);
                        if ((entitytospawn) instanceof LivingEntity _livingEntity113 && _livingEntity113.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
                            _livingEntity113.getAttribute(Attributes.KNOCKBACK_RESISTANCE)
                                    .setBaseValue((entity instanceof LivingEntity _livingEntity111 && _livingEntity111.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)
                                            ? _livingEntity111.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue()
                                            : 0));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof LivingEntity _entity) {
                            ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player)
                                _player.getInventory().setChanged();
                        }
                        {
                            Entity _entity = (entitytospawn);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().armor.set(0, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
                                _player.getInventory().setChanged();
                            } else if (_entity instanceof LivingEntity _living) {
                                _living.setItemSlot(EquipmentSlot.FEET, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
                            }
                        }
                        {
                            Entity _entity = (entitytospawn);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().armor.set(1, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
                                _player.getInventory().setChanged();
                            } else if (_entity instanceof LivingEntity _living) {
                                _living.setItemSlot(EquipmentSlot.LEGS, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
                            }
                        }
                        {
                            Entity _entity = (entitytospawn);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().armor.set(2, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY));
                                _player.getInventory().setChanged();
                            } else if (_entity instanceof LivingEntity _living) {
                                _living.setItemSlot(EquipmentSlot.CHEST, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY));
                            }
                        }
                        {
                            Entity _entity = (entitytospawn);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().armor.set(3, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY));
                                _player.getInventory().setChanged();
                            } else if (_entity instanceof LivingEntity _living) {
                                _living.setItemSlot(EquipmentSlot.HEAD, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY));
                            }
                        }
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 60, 245, false, true));
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 245, false, true));
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                }
                            }.getValue()));
                            (entitytospawn).load(dataIndex);
                        }
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                }
                            }.getValue()));
                            (entitytospawn).load(dataIndex);
                        }
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putDouble("Tagged", (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique);
                            (entitytospawn).load(dataIndex);
                        }
                        (entitytospawn).getPersistentData().putDouble("Tagged", (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique);
                        (entitytospawn).getPersistentData().putString("Owner", (entity.getStringUUID()));
                        (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                        if ((entitytospawn) instanceof TamableAnimal _toTame && entity instanceof Player _owner)
                            _toTame.tame(_owner);
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putBoolean("UseCursedTechnique", true);
                            (entitytospawn).load(dataIndex);
                        }
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putBoolean("JujutsuSorcerer", (new Object() {
                                public boolean getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getBoolean("JujutsuSorcerer");
                                }
                            }.getValue()));
                            (entitytospawn).load(dataIndex);
                        }
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putBoolean("CursedSpirit", (new Object() {
                                public boolean getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getBoolean("CursedSpirit");
                                }
                            }.getValue()));
                            (entitytospawn).load(dataIndex);
                        }
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putBoolean("CurseUser", (new Object() {
                                public boolean getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getBoolean("CurseUser");
                                }
                            }.getValue()));
                            (entitytospawn).load(dataIndex);
                        }
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
                world = _worldorig;
            }
        }
    }
}
