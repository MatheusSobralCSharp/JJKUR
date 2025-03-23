package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;


public class TodoHitProcedure2Procedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if (Math.random() <= 0.005) {
            if (entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel
                    && _plr0.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:sorcerer_strongest_of_modern")))).isDone()) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftaddonModEntities.ITADORI_SHINJUKU.get().spawn(_serverLevel, BlockPos.containing((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ())), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    }
                    CompoundTag dataIndex1 = new CompoundTag();
                    assert entitytospawn != null;
                    (entitytospawn).saveWithoutId(dataIndex1);
                    dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                    (entitytospawn).load(dataIndex1);
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
                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 200, 1));
                    {
                        Entity _ent = entity;
                        _ent.teleportTo((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()));
                        if (_ent instanceof ServerPlayer _serverPlayer)
                            _serverPlayer.connection.teleport((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), _ent.getYRot(), _ent.getXRot());
                    }
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:clap"))), SoundSource.NEUTRAL, 1, 1);
                        } else {
                            _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:clap"))), SoundSource.NEUTRAL, 1, 1, false);
                        }
                    }
                    if (entity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("MY BROTHERRR"), false);
                }
            } else if (!(entity instanceof ServerPlayer _plr15 && _plr15.level() instanceof ServerLevel
                    && _plr15.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr15.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:sorcerer_strongest_of_modern")))).isDone())) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.ITADORI_YUJI_SHIBUYA.get().spawn(_serverLevel, BlockPos.containing((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ())), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    }
                    CompoundTag dataIndex1 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex1);
                    dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                    (entitytospawn).load(dataIndex1);
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
                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 200, 1));
                    {
                        Entity _ent = entity;
                        _ent.teleportTo((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()));
                        if (_ent instanceof ServerPlayer _serverPlayer)
                            _serverPlayer.connection.teleport((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), _ent.getYRot(), _ent.getXRot());
                    }
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:clap"))), SoundSource.NEUTRAL, 1, 1);
                        } else {
                            _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:clap"))), SoundSource.NEUTRAL, 1, 1, false);
                        }
                    }
                    if (entity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("MY BROTHERRR"), false);
                }
            }
        }
    }
}
