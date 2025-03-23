package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class GojoKunaProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("Fight");
            }
        }.getValue() == 0) {
            if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:sukuna_fushiguro")) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:murasakii")), SoundSource.NEUTRAL, 1, 1);
                    } else {
                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:murasakii")), SoundSource.NEUTRAL, 1, 1, false);
                    }
                }
                {
                    CompoundTag dataIndex = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("Fight", 1);
                    sourceentity.load(dataIndex);
                }
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("skill");
            }
        }.getValue() == 215) {
            if (!(new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("cnt5");
                }
            }.getValue() == 50)) {
                {
                    CompoundTag dataIndex = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("cnt5", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("cnt5");
                        }
                    }.getValue() + 1));
                    sourceentity.load(dataIndex);
                }
                {
                    CompoundTag dataIndex = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 1);
                    sourceentity.load(dataIndex);
                }
            } else if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("cnt5");
                }
            }.getValue() == 50) {
                {
                    CompoundTag dataIndex = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 0);
                    sourceentity.load(dataIndex);
                }
            }
        }
    }
}
