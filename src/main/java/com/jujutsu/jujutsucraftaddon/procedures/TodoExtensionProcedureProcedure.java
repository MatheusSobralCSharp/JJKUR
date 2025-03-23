package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class TodoExtensionProcedureProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.ZONE.get())) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.TAKADA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    (entitytospawn).getPersistentData().putBoolean("ShikigamiLevel", true);
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COMEDIAN.get(), 1,
                                (int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COMEDIAN.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.COMEDIAN.get()).getAmplifier() : 0)
                                        + (entity.getPersistentData().getDouble("friend_num"))),
                                false, false));
                    (entitytospawn).getPersistentData().putDouble("friend_num", (entity.getPersistentData().getDouble("friend_num")));
                    (entitytospawn).getPersistentData().putDouble("friend_num2", (entity.getPersistentData().getDouble("friend_num")));
                    (entitytospawn).getPersistentData().putDouble("friend_num_worker", (entity.getPersistentData().getDouble("friend_num")));
                    (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.ITADORI_YUJI_SHIBUYA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
                Entity entitytospawn = JujutsucraftModEntities.ITADORI_YUJI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
                Entity entitytospawn = JujutsucraftModEntities.ITADORI_YUJI_SHINJUKU.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
                _player.displayClientMessage(Component.literal("WE ARE THE EXEPCTION"), false);
            if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("WE ARE THE EXEPCTION"), false);
        }
    }
}
