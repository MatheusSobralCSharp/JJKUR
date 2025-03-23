package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class SummonTodo {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity instanceof LivingEntity entity2 && entity2.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
            return;
        }

        if (entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel
                && _plr0.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:sorcerer_strongest_of_modern")))).isDone()) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftaddonModEntities.ITADORI_SHINJUKU.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entity.getPersistentData().putDouble("friend_num", Math.random());
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    CompoundTag dataIndex1 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex1);
                    dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                    (entitytospawn).load(dataIndex1);
                    CompoundTag dataIndex45 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex45);
                    dataIndex45.getCompound("ForgeData").putString("Owner", (entity.getStringUUID()));
                    (entitytospawn).load(dataIndex45);
                    entitytospawn.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                    entitytospawn.getPersistentData().putString("Owner", entity.getStringUUID());
                    entitytospawn.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                    CompoundTag dataIndex3 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex3);
                    dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex2 = new CompoundTag();
                            entity.saveWithoutId(dataIndex2);
                            return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex3);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 300, 1, false, false));
                    {
                        Entity _ent = entity;
                        _ent.teleportTo((entity.getX()), (entity.getY()), (entity.getZ()));
                        if (_ent instanceof ServerPlayer _serverPlayer)
                            _serverPlayer.connection.teleport((entity.getX()), (entity.getY()), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
                    }
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:clap"))), SoundSource.NEUTRAL, 1, 1);
                        } else {
                            _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:clap"))), SoundSource.NEUTRAL, 1, 1, false);
                        }
                    }
                    if (entity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("Brother!"), false);
                }
            }
        } else if ((entity instanceof ServerPlayer _plr15 && _plr15.level() instanceof ServerLevel
                && _plr15.getAdvancements().getOrStartProgress((_plr15.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sorcerer_grade_special")))).isDone())) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.ITADORI_YUJI_SHIBUYA.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entity.getPersistentData().putDouble("friend_num", Math.random());
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    CompoundTag dataIndex1 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex1);
                    dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                    (entitytospawn).load(dataIndex1);
                    CompoundTag dataIndex3 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex3);
                    entitytospawn.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                    entitytospawn.getPersistentData().putString("Owner", entity.getStringUUID());
                    entitytospawn.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                    dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex2 = new CompoundTag();
                            entity.saveWithoutId(dataIndex2);
                            return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex3);

                    if ((entitytospawn) instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                        _livingEntity2.getAttribute(Attributes.MAX_HEALTH).setBaseValue(600);
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);


                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 300, 1, false, false));
                    {
                        Entity _ent = entity;
                        _ent.teleportTo((entity.getX()), (entity.getY()), (entity.getZ()));
                        if (_ent instanceof ServerPlayer _serverPlayer)
                            _serverPlayer.connection.teleport((entity.getX()), (entity.getY()), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
                    }
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:clap"))), SoundSource.NEUTRAL, 1, 1);
                        } else {
                            _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:clap"))), SoundSource.NEUTRAL, 1, 1, false);
                        }
                    }
                    if (entity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("My BROTHER"), false);
                }
            }
        }
        if ((entity) instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 300, 1, false, false));
    }
}

