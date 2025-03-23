package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.ErroEntity;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
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
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SukunaKeybindOnKeyPressed1Procedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;


        if (!(entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:enchained"))).isDone())) {
            if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(JujutsucraftaddonModMobEffects.SUKUNA.get()))) {
                if (Math.random() <= 0.1) {
                    if (entity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("Sukuna: What An Annoying Brat "), false);
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavc1")), SoundSource.NEUTRAL, 1, 1);
                        } else {
                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavc1")), SoundSource.NEUTRAL, 1, 1, false);
                        }
                    }
                } else if (Math.random() <= 0.2) {
                    if (entity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("Sukuna: Idiot."), false);
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavc2")), SoundSource.NEUTRAL, 1, 1);
                        } else {
                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavc2")), SoundSource.NEUTRAL, 1, 1, false);
                        }
                    }
                } else if (Math.random() <= 0.3) {
                    if (entity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("Sukuna: If You'll accept my conditions, I'll help you and bring us back to life"), false);
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavc3")), SoundSource.NEUTRAL, 1, 1);
                        } else {
                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavc3")), SoundSource.NEUTRAL, 1, 1, false);
                        }
                    }
                } else if (Math.random() <= 0.4) {
                    if (entity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("Sukuna: Brat "), false);
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavc4")), SoundSource.NEUTRAL, 1, 1);
                        } else {
                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavc4")), SoundSource.NEUTRAL, 1, 1, false);
                        }
                    }
                } else if (Math.random() <= 0.5) {
                    if (entity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("Sukuna: Man, you're boring "), false);
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavc5")), SoundSource.NEUTRAL, 1, 1);
                        } else {
                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavc5")), SoundSource.NEUTRAL, 1, 1, false);
                        }
                    }
                }
            } else {
                if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount() < 7.0)  {
                    if (Math.random() <= 0.3) {
                        if (entity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("CONTAIN SUKUNA"), false);
                        ContainProcedure.execute(world, x, y, z, entity);
                    }
                }
            }
            if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount() < 7.0) {
                if (Math.random() <= 0.05 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SUKUNA_POSSESSION_RATE))) {
                    SukunaKeybindOnKeyPressedProcedure.execute(entity);
                }
            } else {
                if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount() >= 15.0) {
                    {
                        final Vec3 _center = new Vec3(x, y, z);
                        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                        for (Entity entityiterator : _entfound) {
                            if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals("jujutsucraft:fushiguro_megumi_shibuya")) {
                                SukunaKeybindOnKeyPressedProcedure.execute(entity);
                            }
                        }
                    }
                } else {
                    if (Math.random() <= 0.01 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SUKUNA_POSSESSION_RATE))) {
                        SukunaKeybindOnKeyPressedProcedure.execute(entity);
                    }
                }
            }
            for (Entity entityiterator : new ArrayList<>(world.players())) {
                if (entityiterator instanceof Player _playerHasItem && _playerHasItem.getInventory().contains(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:sukuna_finger"))))) {
                    {
                        Entity _ent = entityiterator;
                        _ent.teleportTo((entity.getX()), (entity.getY() + y), (entity.getZ()));
                        if (_ent instanceof ServerPlayer _serverPlayer)
                            _serverPlayer.connection.teleport((entity.getX()), (entity.getY() + y), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
                    }
                    if (entityiterator instanceof Player _player) {
                        ItemStack _stktoremove = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:sukuna_finger")));
                        _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                    }
                    SukunaKeybindOnKeyPressedProcedure.execute(entity);
                }
            }
            {
                final Vec3 _center = new Vec3(x, y, z);
                List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                for (Entity entityiterator : _entfound) {
                    if (!(entityiterator == entity)) {
                        if (entityiterator instanceof ServerPlayer _plr30 && _plr30.level() instanceof ServerLevel
                                && _plr30.getAdvancements().getOrStartProgress(_plr30.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:welcome_to_jujutsu_plus"))).isDone()) {
                            if ((entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 6) {
                                if (Math.random() <= 0.05) {
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA.get(), -1, 1, false, false));
                                    if (world instanceof ServerLevel _serverLevel) {
                                        LevelAccessor _worldorig = world;
                                        world = _serverLevel.getServer().getLevel(entity.level().dimension());
                                        if (world != null) {
                                            Entity entitytospawn = JujutsucraftaddonModEntities.ERRO.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
                                            if (entitytospawn != null) {
                                                entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                                (entitytospawn).setCustomName(Component.literal((entityiterator.getDisplayName().getString())));
                                                if ((entitytospawn) instanceof ErroEntity _datEntSetS)
                                                    _datEntSetS.setOwnerUUID(entityiterator.getUUID());
                                                if ((entitytospawn) instanceof LivingEntity _livingEntity37 && _livingEntity37.getAttributes().hasAttribute(Attributes.ARMOR))
                                                    _livingEntity37.getAttribute(Attributes.ARMOR).setBaseValue(30);
                                                if ((entitytospawn) instanceof LivingEntity _livingEntity40 && _livingEntity40.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                                                    _livingEntity40.getAttribute(Attributes.MAX_HEALTH)
                                                            .setBaseValue(((entityiterator instanceof LivingEntity _livingEntity38 && _livingEntity38.getAttributes().hasAttribute(Attributes.MAX_HEALTH)
                                                                    ? _livingEntity38.getAttribute(Attributes.MAX_HEALTH).getBaseValue()
                                                                    : 0) * 30));
                                                if ((entitytospawn) instanceof LivingEntity _livingEntity43 && _livingEntity43.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK))
                                                    _livingEntity43.getAttribute(Attributes.ATTACK_KNOCKBACK)
                                                            .setBaseValue((entityiterator instanceof LivingEntity _livingEntity41 && _livingEntity41.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK)
                                                                    ? _livingEntity41.getAttribute(Attributes.ATTACK_KNOCKBACK).getBaseValue()
                                                                    : 0));
                                                if ((entitytospawn) instanceof LivingEntity _livingEntity46 && _livingEntity46.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
                                                    _livingEntity46.getAttribute(Attributes.ATTACK_DAMAGE)
                                                            .setBaseValue((entityiterator instanceof LivingEntity _livingEntity44 && _livingEntity44.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)
                                                                    ? _livingEntity44.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue()
                                                                    : 0));
                                                if ((entitytospawn) instanceof LivingEntity _livingEntity49 && _livingEntity49.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
                                                    _livingEntity49.getAttribute(Attributes.KNOCKBACK_RESISTANCE)
                                                            .setBaseValue((entityiterator instanceof LivingEntity _livingEntity47 && _livingEntity47.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)
                                                                    ? _livingEntity47.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue()
                                                                    : 0));
                                                if ((entitytospawn) instanceof LivingEntity _livingEntity51 && _livingEntity51.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
                                                    _livingEntity51.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.5);
                                                if ((entitytospawn) instanceof LivingEntity _livingEntity53 && _livingEntity53.getAttributes().hasAttribute(Attributes.FOLLOW_RANGE))
                                                    _livingEntity53.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(254);
                                                if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                                    _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.SUKUNA_EFFECT.get(), (-1),
                                                            ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())
                                                                    ? _livEnt.getEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).getAmplifier()
                                                                    : 0) + 15,
                                                            false, false));
                                                if ((entitytospawn) instanceof LivingEntity _entity)
                                                    _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                                                {
                                                    CompoundTag dataIndex = new CompoundTag();
                                                    (entitytospawn).saveWithoutId(dataIndex);
                                                    dataIndex.putString("Owner", (entityiterator.getStringUUID()));
                                                    (entitytospawn).load(dataIndex);
                                                }
                                                (entitytospawn).getPersistentData().putString("Owner", (entityiterator.getStringUUID()));
                                                if ((entitytospawn) instanceof LivingEntity _entity) {
                                                    ItemStack _setstack = (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
                                                    _setstack.setCount(1);
                                                    _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                                    if (_entity instanceof Player _player)
                                                        _player.getInventory().setChanged();
                                                }
                                                {
                                                    Entity _entity = (entitytospawn);
                                                    if (_entity instanceof Player _player) {
                                                        _player.getInventory().armor.set(0, (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
                                                        _player.getInventory().setChanged();
                                                    } else if (_entity instanceof LivingEntity _living) {
                                                        _living.setItemSlot(EquipmentSlot.FEET, (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
                                                    }
                                                }
                                                {
                                                    Entity _entity = (entitytospawn);
                                                    if (_entity instanceof Player _player) {
                                                        _player.getInventory().armor.set(1, (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
                                                        _player.getInventory().setChanged();
                                                    } else if (_entity instanceof LivingEntity _living) {
                                                        _living.setItemSlot(EquipmentSlot.LEGS, (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
                                                    }
                                                }
                                                {
                                                    Entity _entity = (entitytospawn);
                                                    if (_entity instanceof Player _player) {
                                                        _player.getInventory().armor.set(2, (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY));
                                                        _player.getInventory().setChanged();
                                                    } else if (_entity instanceof LivingEntity _living) {
                                                        _living.setItemSlot(EquipmentSlot.CHEST, (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY));
                                                    }
                                                }
                                                {
                                                    Entity _entity = (entitytospawn);
                                                    if (_entity instanceof Player _player) {
                                                        _player.getInventory().armor.set(3, (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY));
                                                        _player.getInventory().setChanged();
                                                    } else if (_entity instanceof LivingEntity _living) {
                                                        _living.setItemSlot(EquipmentSlot.HEAD, (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY));
                                                    }
                                                }
                                                {
                                                    CompoundTag dataIndex = new CompoundTag();
                                                    (entitytospawn).saveWithoutId(dataIndex);
                                                    dataIndex.getCompound("ForgeData").putDouble("Demon", 1);
                                                    (entitytospawn).load(dataIndex);
                                                }
                                                (entitytospawn).getPersistentData().putDouble("God", 1);
                                                (entitytospawn).getPersistentData().putDouble("Demon", 1);
                                                (entitytospawn).getPersistentData().putDouble("Tagged",
                                                        (entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
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
                                                            entityiterator.saveWithoutId(dataIndex);
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
                                                            entityiterator.saveWithoutId(dataIndex);
                                                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                                        }
                                                    }.getValue()));
                                                    (entitytospawn).load(dataIndex);
                                                }
                                                {
                                                    CompoundTag dataIndex = new CompoundTag();
                                                    (entitytospawn).saveWithoutId(dataIndex);
                                                    dataIndex.getCompound("ForgeData").putDouble("Tagged",
                                                            (entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
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
                            } else if ((entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 6) {
                                if (Math.random() <= 0.4) {
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA.get(), 6000, 1, false, false));
                                    if (world instanceof ServerLevel _serverLevel) {
                                        LevelAccessor _worldorig = world;
                                        world = _serverLevel.getServer().getLevel(entity.level().dimension());
                                        if (world != null) {
                                            Entity entitytospawn = JujutsucraftaddonModEntities.ERRO.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
                                            if (entitytospawn != null) {
                                                entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                                (entitytospawn).setCustomName(Component.literal((entityiterator.getDisplayName().getString())));
                                                if ((entitytospawn) instanceof ErroEntity _datEntSetS)
                                                    _datEntSetS.setOwnerUUID(entityiterator.getUUID());
                                                if ((entitytospawn) instanceof LivingEntity _livingEntity114 && _livingEntity114.getAttributes().hasAttribute(Attributes.ARMOR))
                                                    _livingEntity114.getAttribute(Attributes.ARMOR).setBaseValue(30);
                                                if ((entitytospawn) instanceof LivingEntity _livingEntity117 && _livingEntity117.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                                                    _livingEntity117.getAttribute(Attributes.MAX_HEALTH)
                                                            .setBaseValue(((entityiterator instanceof LivingEntity _livingEntity115 && _livingEntity115.getAttributes().hasAttribute(Attributes.MAX_HEALTH)
                                                                    ? _livingEntity115.getAttribute(Attributes.MAX_HEALTH).getBaseValue()
                                                                    : 0) * 30));
                                                if ((entitytospawn) instanceof LivingEntity _livingEntity120 && _livingEntity120.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK))
                                                    _livingEntity120.getAttribute(Attributes.ATTACK_KNOCKBACK)
                                                            .setBaseValue((entityiterator instanceof LivingEntity _livingEntity118 && _livingEntity118.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK)
                                                                    ? _livingEntity118.getAttribute(Attributes.ATTACK_KNOCKBACK).getBaseValue()
                                                                    : 0));
                                                if ((entitytospawn) instanceof LivingEntity _livingEntity123 && _livingEntity123.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
                                                    _livingEntity123.getAttribute(Attributes.ATTACK_DAMAGE)
                                                            .setBaseValue((entityiterator instanceof LivingEntity _livingEntity121 && _livingEntity121.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)
                                                                    ? _livingEntity121.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue()
                                                                    : 0));
                                                if ((entitytospawn) instanceof LivingEntity _livingEntity126 && _livingEntity126.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
                                                    _livingEntity126.getAttribute(Attributes.KNOCKBACK_RESISTANCE)
                                                            .setBaseValue((entityiterator instanceof LivingEntity _livingEntity124 && _livingEntity124.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)
                                                                    ? _livingEntity124.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue()
                                                                    : 0));
                                                if ((entitytospawn) instanceof LivingEntity _livingEntity128 && _livingEntity128.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
                                                    _livingEntity128.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.4);
                                                if ((entitytospawn) instanceof LivingEntity _livingEntity130 && _livingEntity130.getAttributes().hasAttribute(Attributes.FOLLOW_RANGE))
                                                    _livingEntity130.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(254);
                                                if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                                    _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.SUKUNA_EFFECT.get(), (-1),
                                                            ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())
                                                                    ? _livEnt.getEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).getAmplifier()
                                                                    : 0) + 15,
                                                            false, false));
                                                if ((entitytospawn) instanceof LivingEntity _entity)
                                                    _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                                                {
                                                    CompoundTag dataIndex = new CompoundTag();
                                                    (entitytospawn).saveWithoutId(dataIndex);
                                                    dataIndex.putString("Owner", (entityiterator.getStringUUID()));
                                                    (entitytospawn).load(dataIndex);
                                                }
                                                (entitytospawn).getPersistentData().putString("Owner", (entityiterator.getStringUUID()));
                                                if ((entitytospawn) instanceof LivingEntity _entity) {
                                                    ItemStack _setstack = (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
                                                    _setstack.setCount(1);
                                                    _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                                    if (_entity instanceof Player _player)
                                                        _player.getInventory().setChanged();
                                                }
                                                {
                                                    Entity _entity = (entitytospawn);
                                                    if (_entity instanceof Player _player) {
                                                        _player.getInventory().armor.set(0, (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
                                                        _player.getInventory().setChanged();
                                                    } else if (_entity instanceof LivingEntity _living) {
                                                        _living.setItemSlot(EquipmentSlot.FEET, (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
                                                    }
                                                }
                                                {
                                                    Entity _entity = (entitytospawn);
                                                    if (_entity instanceof Player _player) {
                                                        _player.getInventory().armor.set(1, (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
                                                        _player.getInventory().setChanged();
                                                    } else if (_entity instanceof LivingEntity _living) {
                                                        _living.setItemSlot(EquipmentSlot.LEGS, (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
                                                    }
                                                }
                                                {
                                                    Entity _entity = (entitytospawn);
                                                    if (_entity instanceof Player _player) {
                                                        _player.getInventory().armor.set(2, (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY));
                                                        _player.getInventory().setChanged();
                                                    } else if (_entity instanceof LivingEntity _living) {
                                                        _living.setItemSlot(EquipmentSlot.CHEST, (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY));
                                                    }
                                                }
                                                {
                                                    Entity _entity = (entitytospawn);
                                                    if (_entity instanceof Player _player) {
                                                        _player.getInventory().armor.set(3, (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY));
                                                        _player.getInventory().setChanged();
                                                    } else if (_entity instanceof LivingEntity _living) {
                                                        _living.setItemSlot(EquipmentSlot.HEAD, (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY));
                                                    }
                                                }
                                                {
                                                    CompoundTag dataIndex = new CompoundTag();
                                                    (entitytospawn).saveWithoutId(dataIndex);
                                                    dataIndex.getCompound("ForgeData").putDouble("Demon", 2);
                                                    (entitytospawn).load(dataIndex);
                                                }
                                                (entitytospawn).getPersistentData().putDouble("God", 1);
                                                (entitytospawn).getPersistentData().putDouble("Tagged",
                                                        (entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
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
                                                            entityiterator.saveWithoutId(dataIndex);
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
                                                            entityiterator.saveWithoutId(dataIndex);
                                                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                                        }
                                                    }.getValue()));
                                                    (entitytospawn).load(dataIndex);
                                                }
                                                {
                                                    CompoundTag dataIndex = new CompoundTag();
                                                    (entitytospawn).saveWithoutId(dataIndex);
                                                    dataIndex.getCompound("ForgeData").putDouble("Tagged",
                                                            (entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
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
            }
        }
    }
}
