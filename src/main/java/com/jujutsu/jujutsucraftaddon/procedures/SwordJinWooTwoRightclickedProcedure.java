package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.CloneEntity;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class SwordJinWooTwoRightclickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (world instanceof ServerLevel _serverLevel) {
            Entity entitytospawn = JujutsucraftaddonModEntities.CLONE.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entitytospawn != null) {
                entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                if ((entitytospawn) instanceof CloneEntity _datEntSetS)
                    _datEntSetS.getEntityData().set(CloneEntity.DATA_Testing, ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Shadow).toLowerCase());
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
                (entitytospawn).getPersistentData().putString("Owner", (entity.getStringUUID()));
                if ((entitytospawn) instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                    _livingEntity12.getAttribute(Attributes.MAX_HEALTH).setBaseValue(600);
                if ((entitytospawn) instanceof LivingEntity _livingEntity15 && _livingEntity15.getAttributes().hasAttribute(Attributes.ARMOR))
                    _livingEntity15.getAttribute(Attributes.ARMOR)
                            .setBaseValue(((entity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(Attributes.ARMOR) ? _livingEntity13.getAttribute(Attributes.ARMOR).getBaseValue() : 0) * 2));
                if ((entitytospawn) instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
                    _livingEntity18.getAttribute(Attributes.ATTACK_DAMAGE)
                            .setBaseValue(((entity instanceof LivingEntity _livingEntity16 && _livingEntity16.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity16.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0) * 2));
                if ((entitytospawn) instanceof LivingEntity _livingEntity21 && _livingEntity21.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK))
                    _livingEntity21.getAttribute(Attributes.ATTACK_KNOCKBACK)
                            .setBaseValue((entity instanceof LivingEntity _livingEntity19 && _livingEntity19.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK) ? _livingEntity19.getAttribute(Attributes.ATTACK_KNOCKBACK).getBaseValue() : 0));
                if ((entitytospawn) instanceof LivingEntity _livingEntity24 && _livingEntity24.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
                    _livingEntity24.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(
                            (entity instanceof LivingEntity _livingEntity22 && _livingEntity22.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE) ? _livingEntity22.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue() : 0));
                if ((entitytospawn) instanceof LivingEntity _livingEntity26 && _livingEntity26.getAttributes().hasAttribute(Attributes.FOLLOW_RANGE))
                    _livingEntity26.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(256);
                if ((entitytospawn) instanceof LivingEntity _livingEntity28 && _livingEntity28.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
                    _livingEntity28.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.4);
                (entitytospawn).setCustomName(Component.literal(((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).ShadowName)));
                if ((entitytospawn) instanceof LivingEntity _entity)
                    _entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                if ((entitytospawn) instanceof LivingEntity _entity) {
                    ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Armorslot5).copy();
                    _setstack.setCount(1);
                    _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                    if (_entity instanceof Player _player)
                        _player.getInventory().setChanged();
                }
                {
                    Entity _entity = (entitytospawn);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().armor.set(0, ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Armorslot1));
                        _player.getInventory().setChanged();
                    } else if (_entity instanceof LivingEntity _living) {
                        _living.setItemSlot(EquipmentSlot.FEET, ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Armorslot1));
                    }
                }
                {
                    Entity _entity = (entitytospawn);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().armor.set(1, ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Armorslot2));
                        _player.getInventory().setChanged();
                    } else if (_entity instanceof LivingEntity _living) {
                        _living.setItemSlot(EquipmentSlot.LEGS, ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Armorslot2));
                    }
                }
                {
                    Entity _entity = (entitytospawn);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().armor.set(2, ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Armorslot3));
                        _player.getInventory().setChanged();
                    } else if (_entity instanceof LivingEntity _living) {
                        _living.setItemSlot(EquipmentSlot.CHEST, ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Armorslot3));
                    }
                }
                {
                    Entity _entity = (entitytospawn);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().armor.set(3, ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Armorslot4));
                        _player.getInventory().setChanged();
                    } else if (_entity instanceof LivingEntity _living) {
                        _living.setItemSlot(EquipmentSlot.HEAD, ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Armorslot4));
                    }
                }
                {
                    CompoundTag dataIndex = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putBoolean("UseCursedTechnique", true);
                    (entitytospawn).load(dataIndex);
                }
                {
                    CompoundTag dataIndex = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putBoolean("Player", true);
                    (entitytospawn).load(dataIndex);
                }
                {
                    String _setval = "";
                    entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.ShadowName = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
                {
                    String _setval = "";
                    entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.Shadow = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
                _serverLevel.addFreshEntity(entitytospawn);
            }
        }
    }
}
