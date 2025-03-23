package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class SukunaKeybindPressed2Procedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount() < 6.0)  {
            if (Math.random() <= 0.5) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA.get(), Mth.nextInt(RandomSource.create(), 3000, 6000), 1, false, false));
                if (world instanceof ServerLevel _serverLevel) {
                    LevelAccessor _worldorig = world;
                    world = _serverLevel.getServer().getLevel(entity.level().dimension());
                    if (world != null) {
                        Entity entitytospawn = JujutsucraftaddonModEntities.ERRO.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entitytospawn != null) {
                            entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                            (entitytospawn).setCustomName(Component.literal((entity.getDisplayName().getString())));
                            if ((entitytospawn) instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(Attributes.ARMOR))
                                _livingEntity7.getAttribute(Attributes.ARMOR).setBaseValue(30);
                            if ((entitytospawn) instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                                _livingEntity9.getAttribute(Attributes.MAX_HEALTH).setBaseValue(600);
                            if ((entitytospawn) instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK))
                                _livingEntity12.getAttribute(Attributes.ATTACK_KNOCKBACK).setBaseValue(
                                        (entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK) ? _livingEntity10.getAttribute(Attributes.ATTACK_KNOCKBACK).getBaseValue() : 0));
                            if ((entitytospawn) instanceof LivingEntity _livingEntity15 && _livingEntity15.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
                                _livingEntity15.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(
                                        (entity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity13.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0));
                            if ((entitytospawn) instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
                                _livingEntity18.getAttribute(Attributes.KNOCKBACK_RESISTANCE)
                                        .setBaseValue((entity instanceof LivingEntity _livingEntity16 && _livingEntity16.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)
                                                ? _livingEntity16.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue()
                                                : 0));
                            if ((entitytospawn) instanceof LivingEntity _livingEntity20 && _livingEntity20.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
                                _livingEntity20.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.5);
                            if ((entitytospawn) instanceof LivingEntity _livingEntity22 && _livingEntity22.getAttributes().hasAttribute(Attributes.FOLLOW_RANGE))
                                _livingEntity22.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(254);
                            if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.SUKUNA_EFFECT.get(), (-1),
                                        ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).getAmplifier() : 0)
                                                + 6,
                                        false, false));
                            if ((entitytospawn) instanceof LivingEntity _entity)
                                _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                (entitytospawn).saveWithoutId(dataIndex);
                                dataIndex.putString("Owner", (entity.getStringUUID()));
                                (entitytospawn).load(dataIndex);
                            }
                            (entitytospawn).getPersistentData().putString("Owner", (entity.getStringUUID()));
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
                            (entitytospawn).getPersistentData().putDouble("Demon", 1);
                            (entitytospawn).getPersistentData().putDouble("God", 1);
                            (entitytospawn).getPersistentData().putDouble("Tagged", (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
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
                            if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA_CUTSCENE_3.get(), 60, 1, false, false));
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 60, 1, false, false));
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                (entitytospawn).saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("Tagged", (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
                                (entitytospawn).load(dataIndex);
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
                                dataIndex.getCompound("ForgeData").putBoolean("CurseUser", true);
                                (entitytospawn).load(dataIndex);
                            }
                            _serverLevel.addFreshEntity(entitytospawn);
                        }
                    }
                    world = _worldorig;
                }
            } else {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA.get(), Mth.nextInt(RandomSource.create(), 4000, 6000), 1, false, false));
                if (world instanceof ServerLevel _serverLevel) {
                    LevelAccessor _worldorig = world;
                    world = _serverLevel.getServer().getLevel(entity.level().dimension());
                    if (world != null) {
                        Entity entitytospawn = JujutsucraftaddonModEntities.ERRO.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entitytospawn != null) {
                            entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                            (entitytospawn).setCustomName(Component.literal((entity.getDisplayName().getString())));
                            if (world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunaheart")), SoundSource.NEUTRAL, 3, 1);
                                } else {
                                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunaheart")), SoundSource.NEUTRAL, 3, 1, false);
                                }
                            }
                            if ((entitytospawn) instanceof LivingEntity _livingEntity81 && _livingEntity81.getAttributes().hasAttribute(Attributes.ARMOR))
                                _livingEntity81.getAttribute(Attributes.ARMOR).setBaseValue(30);
                            if ((entitytospawn) instanceof LivingEntity _livingEntity83 && _livingEntity83.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                                _livingEntity83.getAttribute(Attributes.MAX_HEALTH).setBaseValue(600);
                            if ((entitytospawn) instanceof LivingEntity _livingEntity86 && _livingEntity86.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK))
                                _livingEntity86.getAttribute(Attributes.ATTACK_KNOCKBACK).setBaseValue(
                                        (entity instanceof LivingEntity _livingEntity84 && _livingEntity84.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK) ? _livingEntity84.getAttribute(Attributes.ATTACK_KNOCKBACK).getBaseValue() : 0));
                            if ((entitytospawn) instanceof LivingEntity _livingEntity89 && _livingEntity89.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
                                _livingEntity89.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(
                                        (entity instanceof LivingEntity _livingEntity87 && _livingEntity87.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity87.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0));
                            if ((entitytospawn) instanceof LivingEntity _livingEntity92 && _livingEntity92.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
                                _livingEntity92.getAttribute(Attributes.KNOCKBACK_RESISTANCE)
                                        .setBaseValue((entity instanceof LivingEntity _livingEntity90 && _livingEntity90.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)
                                                ? _livingEntity90.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue()
                                                : 0));
                            if ((entitytospawn) instanceof LivingEntity _livingEntity94 && _livingEntity94.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
                                _livingEntity94.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.5);
                            if ((entitytospawn) instanceof LivingEntity _livingEntity96 && _livingEntity96.getAttributes().hasAttribute(Attributes.FOLLOW_RANGE))
                                _livingEntity96.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(254);
                            if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.SUKUNA_EFFECT.get(), (-1),
                                        ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).getAmplifier() : 0)
                                                + 6,
                                        false, false));
                            if ((entitytospawn) instanceof LivingEntity _entity)
                                _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 60, 1, false, false));
                            if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA_HEARY.get(), 60, 1, false, false));
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                (entitytospawn).saveWithoutId(dataIndex);
                                dataIndex.putString("Owner", (entity.getStringUUID()));
                                (entitytospawn).load(dataIndex);
                            }
                            (entitytospawn).getPersistentData().putString("Owner", (entity.getStringUUID()));
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
                            (entitytospawn).getPersistentData().putDouble("Demon", 1);
                            (entitytospawn).getPersistentData().putDouble("DeathCount", 1);
                            (entitytospawn).getPersistentData().putDouble("God", 1);
                            (entitytospawn).getPersistentData().putDouble("Tagged", (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
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
                                dataIndex.getCompound("ForgeData").putDouble("Tagged", (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
                                (entitytospawn).load(dataIndex);
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
                                dataIndex.getCompound("ForgeData").putBoolean("CurseUser", true);
                                (entitytospawn).load(dataIndex);
                            }
                            _serverLevel.addFreshEntity(entitytospawn);
                        }
                    }
                    world = _worldorig;
                }
            }
        } else {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA.get(), Mth.nextInt(RandomSource.create(), 6000, 18000), 1, false, false));
            if (world instanceof ServerLevel _serverLevel) {
                LevelAccessor _worldorig = world;
                world = _serverLevel.getServer().getLevel(entity.level().dimension());
                if (world != null) {
                    Entity entitytospawn = JujutsucraftaddonModEntities.ERRO.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        (entitytospawn).setCustomName(Component.literal((entity.getDisplayName().getString())));
                        if ((entitytospawn) instanceof LivingEntity _livingEntity156 && _livingEntity156.getAttributes().hasAttribute(Attributes.ARMOR))
                            _livingEntity156.getAttribute(Attributes.ARMOR).setBaseValue(30);
                        if ((entitytospawn) instanceof LivingEntity _livingEntity158 && _livingEntity158.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                            _livingEntity158.getAttribute(Attributes.MAX_HEALTH).setBaseValue(600);
                        if ((entitytospawn) instanceof LivingEntity _livingEntity161 && _livingEntity161.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK))
                            _livingEntity161.getAttribute(Attributes.ATTACK_KNOCKBACK).setBaseValue(
                                    (entity instanceof LivingEntity _livingEntity159 && _livingEntity159.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK) ? _livingEntity159.getAttribute(Attributes.ATTACK_KNOCKBACK).getBaseValue() : 0));
                        if ((entitytospawn) instanceof LivingEntity _livingEntity164 && _livingEntity164.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
                            _livingEntity164.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(
                                    (entity instanceof LivingEntity _livingEntity162 && _livingEntity162.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity162.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0));
                        if ((entitytospawn) instanceof LivingEntity _livingEntity167 && _livingEntity167.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
                            _livingEntity167.getAttribute(Attributes.KNOCKBACK_RESISTANCE)
                                    .setBaseValue((entity instanceof LivingEntity _livingEntity165 && _livingEntity165.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)
                                            ? _livingEntity165.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue()
                                            : 0));
                        if ((entitytospawn) instanceof LivingEntity _livingEntity169 && _livingEntity169.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
                            _livingEntity169.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.5);
                        if ((entitytospawn) instanceof LivingEntity _livingEntity171 && _livingEntity171.getAttributes().hasAttribute(Attributes.FOLLOW_RANGE))
                            _livingEntity171.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(254);
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 60, 1, false, false));
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA_CUTSCENE_3.get(), 60, 1, false, false));
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.SUKUNA_EFFECT.get(), (-1),
                                    ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).getAmplifier() : 0)
                                            + 16,
                                    false, false));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.putString("Owner", (entity.getStringUUID()));
                            (entitytospawn).load(dataIndex);
                        }
                        (entitytospawn).getPersistentData().putString("Owner", (entity.getStringUUID()));
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
                        (entitytospawn).getPersistentData().putDouble("Demon", 1);
                        (entitytospawn).getPersistentData().putDouble("God", 1);
                        (entitytospawn).getPersistentData().putDouble("Tagged", (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
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
                            dataIndex.getCompound("ForgeData").putDouble("Tagged", (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
                            (entitytospawn).load(dataIndex);
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
                            dataIndex.getCompound("ForgeData").putBoolean("CurseUser", true);
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
