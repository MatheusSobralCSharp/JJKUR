package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

public class SummonShikigamiProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (world instanceof ServerLevel _serverLevel) {
            Entity entitytospawn = JujutsucraftModEntities.JUDGEMAN.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
            CompoundTag dataIndex4 = new CompoundTag();
            (entitytospawn).saveWithoutId(dataIndex4);
            dataIndex4.getCompound("ForgeData").putBoolean("ShikigamiLevel", true);
            (entitytospawn).load(dataIndex4);
            ((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(2000);
        }
    }
}
