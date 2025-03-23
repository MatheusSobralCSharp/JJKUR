package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class SpawnJogoatProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 2) {
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH == 0) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.JOGO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                            _livingEntity10.getAttribute(Attributes.MAX_HEALTH).setBaseValue(
                                    (((entitytospawn) instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity8.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) * 3));
                        (entitytospawn).getPersistentData().putDouble("GH", 1);
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putDouble("GH", 1);
                            (entitytospawn).load(dataIndex);
                        }
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
                            _entity.setTarget(_ent);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Beat Jogoat!"), false);
                if (entity instanceof Player _player)
                    _player.closeContainer();
            } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH == 1) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.JOGO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof LivingEntity _livingEntity33 && _livingEntity33.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                            _livingEntity33.getAttribute(Attributes.MAX_HEALTH).setBaseValue(
                                    (((entitytospawn) instanceof LivingEntity _livingEntity31 && _livingEntity31.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity31.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) * 3));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
                            _entity.setTarget(_ent);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.HANAMI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        (entitytospawn).getPersistentData().putDouble("GH", 1);
                        if ((entitytospawn) instanceof LivingEntity _livingEntity52 && _livingEntity52.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                            _livingEntity52.getAttribute(Attributes.MAX_HEALTH).setBaseValue(
                                    (((entitytospawn) instanceof LivingEntity _livingEntity50 && _livingEntity50.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity50.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) * 3));
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putDouble("GH", 1);
                            (entitytospawn).load(dataIndex);
                        }
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
                            _entity.setTarget(_ent);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.MAHITO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof LivingEntity _livingEntity71 && _livingEntity71.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                            _livingEntity71.getAttribute(Attributes.MAX_HEALTH).setBaseValue(
                                    (((entitytospawn) instanceof LivingEntity _livingEntity69 && _livingEntity69.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity69.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) * 3));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
                            _entity.setTarget(_ent);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.CHOSO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof LivingEntity _livingEntity88 && _livingEntity88.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                            _livingEntity88.getAttribute(Attributes.MAX_HEALTH).setBaseValue(
                                    (((entitytospawn) instanceof LivingEntity _livingEntity86 && _livingEntity86.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity86.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) * 3));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
                            _entity.setTarget(_ent);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Smash Hanami In The Wall"), false);
                if (entity instanceof Player _player)
                    _player.closeContainer();
            } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH == 2) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.KENJAKU.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        (entitytospawn).getPersistentData().putDouble("GH", 1);
                        if ((entitytospawn) instanceof LivingEntity _livingEntity109 && _livingEntity109.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                            _livingEntity109.getAttribute(Attributes.MAX_HEALTH).setBaseValue(
                                    (((entitytospawn) instanceof LivingEntity _livingEntity107 && _livingEntity107.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity107.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) * 3));
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putDouble("GH", 1);
                            (entitytospawn).load(dataIndex);
                        }
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
                            _entity.setTarget(_ent);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Beat That Jin-Itadori Wife"), false);
                if (entity instanceof Player _player)
                    _player.closeContainer();
            } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH == 3) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.ITADORI_YUJI_SHINJUKU.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof LivingEntity _livingEntity130 && _livingEntity130.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                            _livingEntity130.getAttribute(Attributes.MAX_HEALTH).setBaseValue(
                                    (((entitytospawn) instanceof LivingEntity _livingEntity128 && _livingEntity128.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity128.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) * 3));
                        (entitytospawn).getPersistentData().putDouble("GH", 1);
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putDouble("GH", 1);
                            (entitytospawn).load(dataIndex);
                        }
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
                            _entity.setTarget(_ent);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.OKKOTSU_YUTA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof LivingEntity _livingEntity151 && _livingEntity151.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                            _livingEntity151.getAttribute(Attributes.MAX_HEALTH).setBaseValue(
                                    (((entitytospawn) instanceof LivingEntity _livingEntity149 && _livingEntity149.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity149.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) * 3));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
                            _entity.setTarget(_ent);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Train Your Pupils"), false);
                if (entity instanceof Player _player)
                    _player.closeContainer();
            } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH == 4) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.SUKUNA_FUSHIGURO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putDouble("GH", 1);
                            (entitytospawn).load(dataIndex);
                        }
                        (entitytospawn).getPersistentData().putDouble("GH", 1);
                        if ((entitytospawn) instanceof LivingEntity _livingEntity174 && _livingEntity174.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                            _livingEntity174.getAttribute(Attributes.MAX_HEALTH).setBaseValue(
                                    (((entitytospawn) instanceof LivingEntity _livingEntity172 && _livingEntity172.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity172.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) * 3));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
                            _entity.setTarget(_ent);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("12/24"), false);
                if (entity instanceof Player _player)
                    _player.closeContainer();
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 1) {
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 0) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.CURSED_SPIRIT_GRADE_01.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 3, false, false));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof LivingEntity _livingEntity196 && _livingEntity196.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                            _livingEntity196.getAttribute(Attributes.MAX_HEALTH).setBaseValue(
                                    (((entitytospawn) instanceof LivingEntity _livingEntity194 && _livingEntity194.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity194.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) * 3));
                        (entitytospawn).getPersistentData().putDouble("GH", 1);
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putDouble("GH", 1);
                            (entitytospawn).load(dataIndex);
                        }
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
                            _entity.setTarget(_ent);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Give This Weak Curse a \"Showtime\""), false);
                if (entity instanceof Player _player)
                    _player.closeContainer();
            } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 1) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.JOGO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof LivingEntity _livingEntity219 && _livingEntity219.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                            _livingEntity219.getAttribute(Attributes.MAX_HEALTH).setBaseValue(
                                    (((entitytospawn) instanceof LivingEntity _livingEntity217 && _livingEntity217.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity217.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) * 3));
                        (entitytospawn).getPersistentData().putDouble("GH", 1);
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putDouble("GH", 1);
                            (entitytospawn).load(dataIndex);
                        }
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
                            _entity.setTarget(_ent);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Who Is That Curse?"), false);
                if (entity instanceof Player _player)
                    _player.closeContainer();
            } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 2) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.EIGHT_HANDLED_SWROD_DIVERGENT_SILA_DIVINE_GENERAL_MAHORAGA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof LivingEntity _livingEntity242 && _livingEntity242.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                            _livingEntity242.getAttribute(Attributes.MAX_HEALTH).setBaseValue(
                                    (((entitytospawn) instanceof LivingEntity _livingEntity240 && _livingEntity240.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity240.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) * 2));
                        (entitytospawn).getPersistentData().putDouble("GH", 1);
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putDouble("GH", 1);
                            (entitytospawn).load(dataIndex);
                        }
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
                            _entity.setTarget(_ent);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Take Care Of Mahoraga And Give Him a Beat"), false);
                if (entity instanceof Player _player)
                    _player.closeContainer();
            } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 3) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.ITADORI_YUJI_SHINJUKU.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof LivingEntity _livingEntity265 && _livingEntity265.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                            _livingEntity265.getAttribute(Attributes.MAX_HEALTH).setBaseValue(
                                    (((entitytospawn) instanceof LivingEntity _livingEntity263 && _livingEntity263.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity263.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) * 3));
                        (entitytospawn).getPersistentData().putDouble("GH", 1);
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putDouble("GH", 1);
                            (entitytospawn).load(dataIndex);
                        }
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
                            _entity.setTarget(_ent);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.ZENIN_MAKI_CULLING_GAME.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof LivingEntity _livingEntity286 && _livingEntity286.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                            _livingEntity286.getAttribute(Attributes.MAX_HEALTH).setBaseValue(
                                    (((entitytospawn) instanceof LivingEntity _livingEntity284 && _livingEntity284.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity284.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) * 3));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
                            _entity.setTarget(_ent);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Beat Those Two Brats"), false);
                if (entity instanceof Player _player)
                    _player.closeContainer();
            } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 4) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.YOROZU.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putDouble("GH", 1);
                            (entitytospawn).load(dataIndex);
                        }
                        (entitytospawn).getPersistentData().putDouble("GH", 1);
                        if ((entitytospawn) instanceof LivingEntity _livingEntity309 && _livingEntity309.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                            _livingEntity309.getAttribute(Attributes.MAX_HEALTH).setBaseValue(
                                    (((entitytospawn) instanceof LivingEntity _livingEntity307 && _livingEntity307.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity307.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) * 3));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
                            _entity.setTarget(_ent);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Time For A Test-Drive"), false);
                if (entity instanceof Player _player)
                    _player.closeContainer();
            } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 5) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.GOJO_SATORU.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putDouble("GH", 1);
                            (entitytospawn).load(dataIndex);
                        }
                        (entitytospawn).getPersistentData().putDouble("GH", 1);
                        if ((entitytospawn) instanceof LivingEntity _livingEntity332 && _livingEntity332.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                            _livingEntity332.getAttribute(Attributes.MAX_HEALTH).setBaseValue(
                                    (((entitytospawn) instanceof LivingEntity _livingEntity330 && _livingEntity330.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity330.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) * 3));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
                            _entity.setTarget(_ent);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
                {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("IsMahoraga", 1);
                    entity.load(dataIndex);
                }
                {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "mahoraga");
                    }
                }
                {
                    Entity _entity = entity;
                    if (_entity instanceof Player _player) {
                        _player.getInventory().armor.set(3, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:mahoraga_wheel_helmet"))));
                        _player.getInventory().setChanged();
                    } else if (_entity instanceof LivingEntity _living) {
                        _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:mahoraga_wheel_helmet"))));
                    }
                }
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Arrogant, Gojo Satoru"), false);
            } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 6) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.KASHIMO_HAJIME.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putDouble("GH", 1);
                            (entitytospawn).load(dataIndex);
                        }
                        (entitytospawn).getPersistentData().putDouble("GH", 1);
                        if ((entitytospawn) instanceof LivingEntity _livingEntity358 && _livingEntity358.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                            _livingEntity358.getAttribute(Attributes.MAX_HEALTH).setBaseValue(
                                    (((entitytospawn) instanceof LivingEntity _livingEntity356 && _livingEntity356.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity356.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) * 3));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
                            _entity.setTarget(_ent);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Don't Disappoint Me"), false);
            }
        }
    }
}
