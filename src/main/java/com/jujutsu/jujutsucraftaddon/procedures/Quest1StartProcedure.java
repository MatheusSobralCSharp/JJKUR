package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class Quest1StartProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("Fushiguro Toji: I was hoping to finish you off with that strike. Must be getting rusty."), false);
        if (world instanceof ServerLevel _serverLevel) {
            LevelAccessor _worldorig = world;
            world = _serverLevel.getServer().getLevel(entity.level().dimension());
            if (world != null) {
                Entity entitytospawn = JujutsucraftaddonModEntities.GOJO_SCHOOL.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z + 5), MobSpawnType.MOB_SUMMONED, false, false);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putString("OWNER_UUID", ((entitytospawn).getStringUUID()));
                        (entitytospawn).load(dataIndex);
                    }
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Quest", 1);
                        (entitytospawn).load(dataIndex);
                    }
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
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
            world = _worldorig;
        }
        if (world instanceof ServerLevel _serverLevel) {
            Entity entitytospawn = JujutsucraftModEntities.GETO_SUGURU.get().spawn(_serverLevel, BlockPos.containing(x, y, (z + 5)), MobSpawnType.MOB_SUMMONED);
            if (entitytospawn != null) {
                entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                {
                    CompoundTag dataIndex = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putString("OWNER_UUID", ((entitytospawn).getStringUUID()));
                    (entitytospawn).load(dataIndex);
                }
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
                _serverLevel.addFreshEntity(entitytospawn);
            }
        }
        if (world instanceof ServerLevel _serverLevel) {
            Entity entitytospawn = JujutsucraftModEntities.FUSHIGURO_TOJI.get().spawn(_serverLevel, BlockPos.containing(x, y, (z + 5)), MobSpawnType.MOB_SUMMONED);
            if (entitytospawn != null) {
                entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                {
                    CompoundTag dataIndex = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("TojiQuest", 1);
                    (entitytospawn).load(dataIndex);
                }
                if (world instanceof ServerLevel _level)
                    _level.sendParticles(ParticleTypes.SQUID_INK, x, y, (z + 5), 3, 3, 3, 3, 1);
                _serverLevel.addFreshEntity(entitytospawn);
            }
        }
        {
            double _setval = 1;
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.History = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
        if (entity instanceof Player _player)
            _player.closeContainer();
    }
}
