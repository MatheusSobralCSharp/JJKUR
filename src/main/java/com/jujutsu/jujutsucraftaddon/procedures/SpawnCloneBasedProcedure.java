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

public class SpawnCloneBasedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (Math.random() <= 0.3) {
            if (world instanceof ServerLevel _serverLevel) {
                LevelAccessor _worldorig = world;
                world = _serverLevel.getServer().getLevel(entity.level().dimension());
                if (world != null) {
                    Entity entitytospawn = JujutsucraftaddonModEntities.CLONE.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
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
                        if ((entitytospawn) instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK))
                            _livingEntity11.getAttribute(Attributes.ATTACK_KNOCKBACK).setBaseValue(
                                    (entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK) ? _livingEntity9.getAttribute(Attributes.ATTACK_KNOCKBACK).getBaseValue() : 0));
                        if ((entitytospawn) instanceof LivingEntity _livingEntity14 && _livingEntity14.getAttributes().hasAttribute(Attributes.ARMOR))
                            _livingEntity14.getAttribute(Attributes.ARMOR)
                                    .setBaseValue((entity instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(Attributes.ARMOR) ? _livingEntity12.getAttribute(Attributes.ARMOR).getBaseValue() : 0));
                        if ((entitytospawn) instanceof LivingEntity _livingEntity17 && _livingEntity17.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS))
                            _livingEntity17.getAttribute(Attributes.ARMOR_TOUGHNESS).setBaseValue(
                                    (entity instanceof LivingEntity _livingEntity15 && _livingEntity15.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS) ? _livingEntity15.getAttribute(Attributes.ARMOR_TOUGHNESS).getBaseValue() : 0));
                        if ((entitytospawn) instanceof LivingEntity _livingEntity20 && _livingEntity20.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
                            _livingEntity20.getAttribute(Attributes.ATTACK_DAMAGE)
                                    .setBaseValue((entity instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity18.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0));
                        if ((entitytospawn) instanceof LivingEntity _livingEntity23 && _livingEntity23.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                            _livingEntity23.getAttribute(Attributes.MAX_HEALTH).setBaseValue(
                                    ((entity instanceof LivingEntity _livingEntity21 && _livingEntity21.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity21.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) * 60));
                        if ((entitytospawn) instanceof LivingEntity _livingEntity25 && _livingEntity25.getAttributes().hasAttribute(Attributes.FOLLOW_RANGE))
                            _livingEntity25.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(256);
                        if ((entitytospawn) instanceof LivingEntity _livingEntity28 && _livingEntity28.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
                            _livingEntity28.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(
                                    (entity instanceof LivingEntity _livingEntity26 && _livingEntity26.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE) ? _livingEntity26.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue() : 0));
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
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 1, false, false));
    }
}
