package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

public class SummonPanda2Procedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if (sourceentity instanceof ServerPlayer && sourceentity.level() instanceof ServerLevel
                && ((ServerPlayer) sourceentity).getAdvancements().getOrStartProgress(((ServerPlayer) sourceentity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sorcerer_grade_special"))).isDone()) {
            if (!entity.level().isClientSide())
                entity.discard();
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.PANDA_NORMAL.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                }
                CompoundTag dataIndex1 = new CompoundTag();
                (entitytospawn).saveWithoutId(dataIndex1);
                dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                (entitytospawn).load(dataIndex1);
                CompoundTag dataIndex3 = new CompoundTag();
                (entitytospawn).saveWithoutId(dataIndex3);
                dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex2 = new CompoundTag();
                        sourceentity.saveWithoutId(dataIndex2);
                        return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
                    }
                }.getValue()));
                (entitytospawn).load(dataIndex3);
            }
        }
    }
}
