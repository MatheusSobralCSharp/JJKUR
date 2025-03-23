package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.ErroEntity;
import com.jujutsu.jujutsucraftaddon.entity.ErrorEntity;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
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

public class SukunaSpawningEffectStartedappliedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_SUKUNA_POSSESSION_ENABLED)) {
            if (!(entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:enchained"))).isDone())) {
                if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount() <= 19.0) {
                    if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount() < 2.0) {
                        if (world instanceof ServerLevel _serverLevel) {
                            LevelAccessor _worldorig = world;
                            world = _serverLevel.getServer().getLevel(entity.level().dimension());
                            if (world != null) {
                                Entity entitytospawn = JujutsucraftaddonModEntities.ERRO.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
                                if (entitytospawn != null) {
                                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                    if ((entitytospawn) instanceof ErroEntity _datEntSetS)
                                        _datEntSetS.setOwnerUUID(entity.getUUID());
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA.get(), 6000, 1, false, false));
                                    (entitytospawn).setCustomName(Component.literal((entity.getDisplayName().getString())));
                                    if ((entitytospawn) instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(Attributes.ARMOR))
                                        _livingEntity8.getAttribute(Attributes.ARMOR).setBaseValue(30);
                                    if ((entitytospawn) instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                                        _livingEntity10.getAttribute(Attributes.MAX_HEALTH).setBaseValue(600);
                                    if ((entitytospawn) instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK))
                                        _livingEntity13.getAttribute(Attributes.ATTACK_KNOCKBACK).setBaseValue(
                                                (entity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK) ? _livingEntity11.getAttribute(Attributes.ATTACK_KNOCKBACK).getBaseValue() : 0));
                                    if ((entitytospawn) instanceof LivingEntity _livingEntity16 && _livingEntity16.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
                                        _livingEntity16.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(
                                                (entity instanceof LivingEntity _livingEntity14 && _livingEntity14.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity14.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0));
                                    if ((entitytospawn) instanceof LivingEntity _livingEntity19 && _livingEntity19.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
                                        _livingEntity19.getAttribute(Attributes.KNOCKBACK_RESISTANCE)
                                                .setBaseValue((entity instanceof LivingEntity _livingEntity17 && _livingEntity17.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)
                                                        ? _livingEntity17.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue()
                                                        : 0));
                                    if ((entitytospawn) instanceof LivingEntity _livingEntity21 && _livingEntity21.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
                                        _livingEntity21.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.5);
                                    if ((entitytospawn) instanceof LivingEntity _livingEntity23 && _livingEntity23.getAttributes().hasAttribute(Attributes.FOLLOW_RANGE))
                                        _livingEntity23.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(254);
                                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.SUKUNA_EFFECT.get(), (-1),
                                                ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())
                                                        ? _livEnt.getEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).getAmplifier()
                                                        : 0) + 4,
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
                                    {
                                        CompoundTag dataIndex = new CompoundTag();
                                        (entitytospawn).saveWithoutId(dataIndex);
                                        dataIndex.getCompound("ForgeData").putDouble("Demon", 2);
                                        (entitytospawn).load(dataIndex);
                                    }
                                    (entitytospawn).getPersistentData().putDouble("Demon", 2);
                                    (entitytospawn).getPersistentData().putDouble("Tagged", (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
                                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA_CUTSCENE_1.get(), 600, 1, false, false));
                                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA_SOUND_1.get(), 300, 1, false, false));
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
                                        dataIndex.getCompound("ForgeData").putDouble("Tagged",
                                                (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
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
                        if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount() > 6.0) {
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
                                            if ((entitytospawn) instanceof ErroEntity _datEntSetS)
                                                _datEntSetS.setOwnerUUID(entity.getUUID());
                                            (entitytospawn).setCustomName(Component.literal((entity.getDisplayName().getString())));
                                            if ((entitytospawn) instanceof LivingEntity _livingEntity83 && _livingEntity83.getAttributes().hasAttribute(Attributes.ARMOR))
                                                _livingEntity83.getAttribute(Attributes.ARMOR).setBaseValue(30);
                                            if ((entitytospawn) instanceof LivingEntity _livingEntity85 && _livingEntity85.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                                                _livingEntity85.getAttribute(Attributes.MAX_HEALTH).setBaseValue(600);
                                            if ((entitytospawn) instanceof LivingEntity _livingEntity88 && _livingEntity88.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK))
                                                _livingEntity88.getAttribute(Attributes.ATTACK_KNOCKBACK)
                                                        .setBaseValue((entity instanceof LivingEntity _livingEntity86 && _livingEntity86.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK)
                                                                ? _livingEntity86.getAttribute(Attributes.ATTACK_KNOCKBACK).getBaseValue()
                                                                : 0));
                                            if ((entitytospawn) instanceof LivingEntity _livingEntity91 && _livingEntity91.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
                                                _livingEntity91.getAttribute(Attributes.ATTACK_DAMAGE)
                                                        .setBaseValue((entity instanceof LivingEntity _livingEntity89 && _livingEntity89.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)
                                                                ? _livingEntity89.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue()
                                                                : 0));
                                            if ((entitytospawn) instanceof LivingEntity _livingEntity94 && _livingEntity94.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
                                                _livingEntity94.getAttribute(Attributes.KNOCKBACK_RESISTANCE)
                                                        .setBaseValue((entity instanceof LivingEntity _livingEntity92 && _livingEntity92.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)
                                                                ? _livingEntity92.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue()
                                                                : 0));
                                            if ((entitytospawn) instanceof LivingEntity _livingEntity96 && _livingEntity96.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
                                                _livingEntity96.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.5);
                                            if ((entitytospawn) instanceof LivingEntity _livingEntity98 && _livingEntity98.getAttributes().hasAttribute(Attributes.FOLLOW_RANGE))
                                                _livingEntity98.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(254);
                                            if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.SUKUNA_EFFECT.get(), (-1),
                                                        ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())
                                                                ? _livEnt.getEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).getAmplifier()
                                                                : 0) + 6,
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
                                            (entitytospawn).getPersistentData().putDouble("Tagged",
                                                    (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
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
                                                dataIndex.getCompound("ForgeData").putDouble("Tagged",
                                                        (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
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
                                            if ((entitytospawn) instanceof ErroEntity _datEntSetS)
                                                _datEntSetS.setOwnerUUID(entity.getUUID());
                                            (entitytospawn).setCustomName(Component.literal((entity.getDisplayName().getString())));
                                            if (world instanceof Level _level) {
                                                if (!_level.isClientSide()) {
                                                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunaheart")), SoundSource.NEUTRAL, 3, 1);
                                                } else {
                                                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunaheart")), SoundSource.NEUTRAL, 3, 1, false);
                                                }
                                            }
                                            if ((entitytospawn) instanceof LivingEntity _livingEntity157 && _livingEntity157.getAttributes().hasAttribute(Attributes.ARMOR))
                                                _livingEntity157.getAttribute(Attributes.ARMOR).setBaseValue(30);
                                            if ((entitytospawn) instanceof LivingEntity _livingEntity159 && _livingEntity159.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                                                _livingEntity159.getAttribute(Attributes.MAX_HEALTH).setBaseValue(600);
                                            if ((entitytospawn) instanceof LivingEntity _livingEntity162 && _livingEntity162.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK))
                                                _livingEntity162.getAttribute(Attributes.ATTACK_KNOCKBACK)
                                                        .setBaseValue((entity instanceof LivingEntity _livingEntity160 && _livingEntity160.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK)
                                                                ? _livingEntity160.getAttribute(Attributes.ATTACK_KNOCKBACK).getBaseValue()
                                                                : 0));
                                            if ((entitytospawn) instanceof LivingEntity _livingEntity165 && _livingEntity165.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
                                                _livingEntity165.getAttribute(Attributes.ATTACK_DAMAGE)
                                                        .setBaseValue((entity instanceof LivingEntity _livingEntity163 && _livingEntity163.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)
                                                                ? _livingEntity163.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue()
                                                                : 0));
                                            if ((entitytospawn) instanceof LivingEntity _livingEntity168 && _livingEntity168.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
                                                _livingEntity168.getAttribute(Attributes.KNOCKBACK_RESISTANCE)
                                                        .setBaseValue((entity instanceof LivingEntity _livingEntity166 && _livingEntity166.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)
                                                                ? _livingEntity166.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue()
                                                                : 0));
                                            if ((entitytospawn) instanceof LivingEntity _livingEntity170 && _livingEntity170.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
                                                _livingEntity170.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.5);
                                            if ((entitytospawn) instanceof LivingEntity _livingEntity172 && _livingEntity172.getAttributes().hasAttribute(Attributes.FOLLOW_RANGE))
                                                _livingEntity172.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(254);
                                            if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.SUKUNA_EFFECT.get(), (-1),
                                                        ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())
                                                                ? _livEnt.getEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).getAmplifier()
                                                                : 0) + 6,
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
                                            (entitytospawn).getPersistentData().putDouble("Tagged",
                                                    (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
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
                                                dataIndex.getCompound("ForgeData").putDouble("Tagged",
                                                        (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
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
                                        if ((entitytospawn) instanceof ErroEntity _datEntSetS)
                                            _datEntSetS.setOwnerUUID(entity.getUUID());
                                        (entitytospawn).setCustomName(Component.literal((entity.getDisplayName().getString())));
                                        if ((entitytospawn) instanceof LivingEntity _livingEntity232 && _livingEntity232.getAttributes().hasAttribute(Attributes.ARMOR))
                                            _livingEntity232.getAttribute(Attributes.ARMOR).setBaseValue(30);
                                        if ((entitytospawn) instanceof LivingEntity _livingEntity234 && _livingEntity234.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                                            _livingEntity234.getAttribute(Attributes.MAX_HEALTH).setBaseValue(600);
                                        if ((entitytospawn) instanceof LivingEntity _livingEntity237 && _livingEntity237.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK))
                                            _livingEntity237.getAttribute(Attributes.ATTACK_KNOCKBACK)
                                                    .setBaseValue((entity instanceof LivingEntity _livingEntity235 && _livingEntity235.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK)
                                                            ? _livingEntity235.getAttribute(Attributes.ATTACK_KNOCKBACK).getBaseValue()
                                                            : 0));
                                        if ((entitytospawn) instanceof LivingEntity _livingEntity240 && _livingEntity240.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
                                            _livingEntity240.getAttribute(Attributes.ATTACK_DAMAGE)
                                                    .setBaseValue((entity instanceof LivingEntity _livingEntity238 && _livingEntity238.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)
                                                            ? _livingEntity238.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue()
                                                            : 0));
                                        if ((entitytospawn) instanceof LivingEntity _livingEntity243 && _livingEntity243.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
                                            _livingEntity243.getAttribute(Attributes.KNOCKBACK_RESISTANCE)
                                                    .setBaseValue((entity instanceof LivingEntity _livingEntity241 && _livingEntity241.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)
                                                            ? _livingEntity241.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue()
                                                            : 0));
                                        if ((entitytospawn) instanceof LivingEntity _livingEntity245 && _livingEntity245.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
                                            _livingEntity245.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.5);
                                        if ((entitytospawn) instanceof LivingEntity _livingEntity247 && _livingEntity247.getAttributes().hasAttribute(Attributes.FOLLOW_RANGE))
                                            _livingEntity247.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(254);
                                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                            _entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 60, 1, false, false));
                                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA_CUTSCENE_3.get(), 60, 1, false, false));
                                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.SUKUNA_EFFECT.get(), (-1),
                                                    ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())
                                                            ? _livEnt.getEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).getAmplifier()
                                                            : 0) + 16,
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
                                        (entitytospawn).getPersistentData().putDouble("Tagged",
                                                (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
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
                                            dataIndex.getCompound("ForgeData").putDouble("Tagged",
                                                    (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
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
                } else {
                    if (world instanceof ServerLevel _serverLevel) {
                        LevelAccessor _worldorig = world;
                        world = _serverLevel.getServer().getLevel(entity.level().dimension());
                        if (world != null) {
                            Entity entitytospawn = JujutsucraftaddonModEntities.ERROR.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
                            if (entitytospawn != null) {
                                entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                if ((entitytospawn) instanceof ErrorEntity _datEntSetS)
                                    _datEntSetS.setOwnerUUID(entity.getUUID());
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA.get(), -1, 1, false, false));
                                (entitytospawn).setCustomName(Component.literal((entity.getDisplayName().getString())));
                                if ((entitytospawn) instanceof LivingEntity _livingEntity304 && _livingEntity304.getAttributes().hasAttribute(Attributes.ARMOR))
                                    _livingEntity304.getAttribute(Attributes.ARMOR).setBaseValue(30);
                                if ((entitytospawn) instanceof LivingEntity _livingEntity306 && _livingEntity306.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                                    _livingEntity306.getAttribute(Attributes.MAX_HEALTH).setBaseValue(1000);
                                if ((entitytospawn) instanceof LivingEntity _livingEntity309 && _livingEntity309.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK))
                                    _livingEntity309.getAttribute(Attributes.ATTACK_KNOCKBACK).setBaseValue(
                                            (entity instanceof LivingEntity _livingEntity307 && _livingEntity307.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK) ? _livingEntity307.getAttribute(Attributes.ATTACK_KNOCKBACK).getBaseValue() : 0));
                                if ((entitytospawn) instanceof LivingEntity _livingEntity312 && _livingEntity312.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
                                    _livingEntity312.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(
                                            ((entity instanceof LivingEntity _livingEntity310 && _livingEntity310.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity310.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0) * 3));
                                if ((entitytospawn) instanceof LivingEntity _livingEntity315 && _livingEntity315.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
                                    _livingEntity315.getAttribute(Attributes.KNOCKBACK_RESISTANCE)
                                            .setBaseValue((entity instanceof LivingEntity _livingEntity313 && _livingEntity313.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)
                                                    ? _livingEntity313.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue()
                                                    : 0));
                                if ((entitytospawn) instanceof LivingEntity _livingEntity317 && _livingEntity317.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
                                    _livingEntity317.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.5);
                                if ((entitytospawn) instanceof LivingEntity _livingEntity319 && _livingEntity319.getAttributes().hasAttribute(Attributes.FOLLOW_RANGE))
                                    _livingEntity319.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(254);
                                if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.SUKUNA_EFFECT.get(), (-1),
                                            ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).getAmplifier() : 0)
                                                    + 19,
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
                                if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.HEIAN_FORM.get(), -1, 0, false, false));
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
                                        _player.getInventory().armor.set(2, new ItemStack(JujutsucraftaddonModItems.SUKUNA_ARMOR_THREE_CHESTPLATE.get()));
                                        _player.getInventory().setChanged();
                                    } else if (_entity instanceof LivingEntity _living) {
                                        _living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(JujutsucraftaddonModItems.SUKUNA_ARMOR_THREE_CHESTPLATE.get()));
                                    }
                                }
                                {
                                    Entity _entity = (entitytospawn);
                                    if (_entity instanceof Player _player) {
                                        _player.getInventory().armor.set(3, new ItemStack(JujutsucraftaddonModItems.SUKUNA_ARMOR_THREE_HELMET.get()));
                                        _player.getInventory().setChanged();
                                    } else if (_entity instanceof LivingEntity _living) {
                                        _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(JujutsucraftaddonModItems.SUKUNA_ARMOR_THREE_HELMET.get()));
                                    }
                                }
                                (entitytospawn).getPersistentData().putDouble("Demon", 2);
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
    }
}
