package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.entity.Rika2Entity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;


public class RikaSpawnedTwoProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
        if (sourceentity == null)
            return;
        if (world.getEntitiesOfClass(Rika2Entity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.RIKA_2.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                }
                CompoundTag dataIndex3 = new CompoundTag();
                (entitytospawn).saveWithoutId(dataIndex3);
                dataIndex3.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                (entitytospawn).load(dataIndex3);
                CompoundTag dataIndex5 = new CompoundTag();
                (entitytospawn).saveWithoutId(dataIndex5);
                dataIndex5.getCompound("ForgeData").putBoolean("Player", true);
                (entitytospawn).load(dataIndex5);
                CompoundTag dataIndex7 = new CompoundTag();
                (entitytospawn).saveWithoutId(dataIndex7);
                dataIndex7.getCompound("ForgeData").putBoolean("CursedSpirit", true);
                (entitytospawn).load(dataIndex7);
                CompoundTag dataIndex9 = new CompoundTag();
                (entitytospawn).saveWithoutId(dataIndex9);
                dataIndex9.getCompound("ForgeData").putBoolean("JujutsuSorcerer", true);
                (entitytospawn).load(dataIndex9);
                ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(4);
            }
        }
    }
}
