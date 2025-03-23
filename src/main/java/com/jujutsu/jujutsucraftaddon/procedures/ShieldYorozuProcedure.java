package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ShieldYorozuProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        boolean found = false;
        String endtext = "";
        double sx = 0;
        double sy = 0;
        double sz = 0;
        double repeats = 0;
        double xRadius = 0;
        double loop = 0;
        double zRadius = 0;
        double particleAmount = 0;
        entity.getPersistentData().putDouble("Tag1", 1.5);
        entity.getPersistentData().putDouble("Tag2", 0);
        entity.getPersistentData().putDouble("Tag3", 90);
        for (int index0 = 0; index0 < 30; index0++) {
            for (int index1 = 0; index1 < 16; index1++) {
                if (world instanceof ServerLevel _level)
                    _level.sendParticles(JujutsucraftModParticleTypes.PARTICLE_LIQUID_METAL.get(),
                            (x - entity.getPersistentData().getDouble("Tag1") * Math.cos(Math.toRadians(entity.getPersistentData().getDouble("Tag3"))) * Math.sin(Math.toRadians(entity.getPersistentData().getDouble("Tag2")))),
                            ((y + 1) - 1.5 * Math.sin(Math.toRadians(entity.getPersistentData().getDouble("Tag3")))),
                            (z + entity.getPersistentData().getDouble("Tag1") * Math.cos(Math.toRadians(entity.getPersistentData().getDouble("Tag3"))) * Math.cos(Math.toRadians(entity.getPersistentData().getDouble("Tag2")))), 1, 0, 0, 0, 1);
                {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("Tag3", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("Tag3");
                        }
                    }.getValue() + 12));
                    entity.load(dataIndex);
                }
            }
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("Tag2", (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("Tag2");
                    }
                }.getValue() + 12));
                entity.load(dataIndex);
            }
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("Tag3", 90);
                entity.load(dataIndex);
            }
        }
        if (world instanceof ServerLevel _level)
            _level.sendParticles(ParticleTypes.SQUID_INK, x, (y - 2), z, 1, 0, 0, 0, 1);
    }
}
