package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class NuhUhRightclickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (world instanceof ServerLevel _serverLevel) {
            Entity entitytospawn = JujutsucraftModEntities.SUKUNA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entitytospawn != null) {
                entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                (entitytospawn).getPersistentData().putDouble("friend_num", (entity.getPersistentData().getDouble("friend_num")));
                (entitytospawn).getPersistentData().putDouble("friend_num2", (entity.getPersistentData().getDouble("friend_num")));
                (entitytospawn).getPersistentData().putDouble("friend_num_worker", (entity.getPersistentData().getDouble("friend_num")));
                (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                _serverLevel.addFreshEntity(entitytospawn);
            }
        }
        if (world instanceof ServerLevel _serverLevel) {
            Entity entitytospawn = JujutsucraftModEntities.SUKUNA_PERFECT.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entitytospawn != null) {
                entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                (entitytospawn).getPersistentData().putDouble("friend_num", (entity.getPersistentData().getDouble("friend_num")));
                (entitytospawn).getPersistentData().putDouble("friend_num2", (entity.getPersistentData().getDouble("friend_num")));
                (entitytospawn).getPersistentData().putDouble("friend_num_worker", (entity.getPersistentData().getDouble("friend_num")));
                (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                _serverLevel.addFreshEntity(entitytospawn);
            }
        }
        if (world instanceof ServerLevel _serverLevel) {
            Entity entitytospawn = JujutsucraftModEntities.SUKUNA_FUSHIGURO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entitytospawn != null) {
                entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                (entitytospawn).getPersistentData().putDouble("friend_num", (entity.getPersistentData().getDouble("friend_num")));
                (entitytospawn).getPersistentData().putDouble("friend_num2", (entity.getPersistentData().getDouble("friend_num")));
                (entitytospawn).getPersistentData().putDouble("friend_num_worker", (entity.getPersistentData().getDouble("friend_num")));
                (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                _serverLevel.addFreshEntity(entitytospawn);
            }
        }
        if (world instanceof ServerLevel _serverLevel) {
            Entity entitytospawn = JujutsucraftModEntities.FUSHIGURO_TOJI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entitytospawn != null) {
                entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                (entitytospawn).getPersistentData().putDouble("friend_num", (entity.getPersistentData().getDouble("friend_num")));
                (entitytospawn).getPersistentData().putDouble("friend_num2", (entity.getPersistentData().getDouble("friend_num")));
                (entitytospawn).getPersistentData().putDouble("friend_num_worker", (entity.getPersistentData().getDouble("friend_num")));
                (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                _serverLevel.addFreshEntity(entitytospawn);
            }
        }
        if (world instanceof ServerLevel _serverLevel) {
            Entity entitytospawn = JujutsucraftModEntities.FUSHIGURO_TOJI_BUG.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entitytospawn != null) {
                entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                (entitytospawn).getPersistentData().putDouble("friend_num", (entity.getPersistentData().getDouble("friend_num")));
                (entitytospawn).getPersistentData().putDouble("friend_num2", (entity.getPersistentData().getDouble("friend_num")));
                (entitytospawn).getPersistentData().putDouble("friend_num_worker", (entity.getPersistentData().getDouble("friend_num")));
                (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                _serverLevel.addFreshEntity(entitytospawn);
            }
        }
        if (world instanceof ServerLevel _serverLevel) {
            Entity entitytospawn = JujutsucraftModEntities.GOJO_SATORU.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entitytospawn != null) {
                entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                (entitytospawn).getPersistentData().putDouble("friend_num", (entity.getPersistentData().getDouble("friend_num")));
                (entitytospawn).getPersistentData().putDouble("friend_num2", (entity.getPersistentData().getDouble("friend_num")));
                (entitytospawn).getPersistentData().putDouble("friend_num_worker", (entity.getPersistentData().getDouble("friend_num")));
                (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                _serverLevel.addFreshEntity(entitytospawn);
            }
        }
        if (world instanceof ServerLevel _serverLevel) {
            Entity entitytospawn = JujutsucraftModEntities.OKKOTSU_YUTA_CULLING_GAME.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entitytospawn != null) {
                entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                (entitytospawn).getPersistentData().putDouble("friend_num", (entity.getPersistentData().getDouble("friend_num")));
                (entitytospawn).getPersistentData().putDouble("friend_num2", (entity.getPersistentData().getDouble("friend_num")));
                (entitytospawn).getPersistentData().putDouble("friend_num_worker", (entity.getPersistentData().getDouble("friend_num")));
                (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                _serverLevel.addFreshEntity(entitytospawn);
            }
        }
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("We Are The Nah i'd Win"), false);
    }
}
