package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class SpawnShadowsProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Sung")) {
            if (world instanceof ServerLevel _serverLevel) {
                LevelAccessor _worldorig = world;
                world = _serverLevel.getServer().getLevel(entity.level().dimension());
                if (world != null) {
                    Entity entitytospawn = JujutsucraftaddonModEntities.IGRIS.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                        (entitytospawn).getPersistentData().putString("Owner", (entity.getStringUUID()));
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putString("Owner", (entity.getStringUUID()));
                            (entitytospawn).load(dataIndex);
                        }
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                            (entitytospawn).load(dataIndex);
                        }
                        if ((entitytospawn) instanceof TamableAnimal _toTame && entity instanceof Player _owner)
                            _toTame.tame(_owner);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
                world = _worldorig;
            }
            if (world instanceof ServerLevel _serverLevel) {
                LevelAccessor _worldorig = world;
                world = _serverLevel.getServer().getLevel(entity.level().dimension());
                if (world != null) {
                    Entity entitytospawn = JujutsucraftaddonModEntities.CENTIPEDE.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                        (entitytospawn).getPersistentData().putString("Owner", (entity.getStringUUID()));
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putString("Owner", (entity.getStringUUID()));
                            (entitytospawn).load(dataIndex);
                        }
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                            (entitytospawn).load(dataIndex);
                        }
                        if ((entitytospawn) instanceof TamableAnimal _toTame && entity instanceof Player _owner)
                            _toTame.tame(_owner);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
                world = _worldorig;
            }
            if (world instanceof ServerLevel _serverLevel) {
                LevelAccessor _worldorig = world;
                world = _serverLevel.getServer().getLevel(entity.level().dimension());
                if (world != null) {
                    Entity entitytospawn = JujutsucraftaddonModEntities.SHADOW_1.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                        (entitytospawn).getPersistentData().putString("Owner", (entity.getStringUUID()));
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putString("Owner", (entity.getStringUUID()));
                            (entitytospawn).load(dataIndex);
                        }
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                            (entitytospawn).load(dataIndex);
                        }
                        if ((entitytospawn) instanceof TamableAnimal _toTame && entity instanceof Player _owner)
                            _toTame.tame(_owner);
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
                world = _worldorig;
            }
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("\u00A7l\u00A75Arise"), false);
        }
    }
}
