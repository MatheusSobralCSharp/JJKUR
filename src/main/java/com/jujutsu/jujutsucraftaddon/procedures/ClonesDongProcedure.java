package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class ClonesDongProcedure {
    public static void execute(Entity sourceentity) {
        if (sourceentity == null)
            return;
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("UseCursedTechnique");
            }
        }.getValue() != 1) {
            {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("UseCursedTechnique", 1);
                sourceentity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("CT");
            }
        }.getValue() < 1) {
            {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("CT", 1);
                sourceentity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("JujutsuSorcerer");
            }
        }.getValue() != 1) {
            {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("JujutsuSorcerer", 1);
                sourceentity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique1");
            }
        }.getValue() != 1) {
            {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique1", 1);
                sourceentity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique3");
            }
        }.getValue() != 1) {
            {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique3", 1);
                sourceentity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique7");
            }
        }.getValue() != 1) {
            {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique7", 1);
                sourceentity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique8");
            }
        }.getValue() != 1) {
            {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique8", 1);
                sourceentity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique9");
            }
        }.getValue() != 1) {
            {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique9", 1);
                sourceentity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique11");
            }
        }.getValue() != 1) {
            {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique11", 1);
                sourceentity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique12");
            }
        }.getValue() != 1) {
            {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique12", 1);
                sourceentity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique13");
            }
        }.getValue() != 1) {
            {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique13", 1);
                sourceentity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique10");
            }
        }.getValue() != 1) {
            {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique10", 1);
                sourceentity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique14");
            }
        }.getValue() != 1) {
            {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique14", 1);
                sourceentity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique4");
            }
        }.getValue() != 1) {
            {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique4", 1);
                sourceentity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique6");
            }
        }.getValue() != 1) {
            {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique6", 1);
                sourceentity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique7");
            }
        }.getValue() != 1) {
            {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique7", 1);
                sourceentity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique8");
            }
        }.getValue() != 1) {
            {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique8", 1);
                sourceentity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique9");
            }
        }.getValue() != 1) {
            {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique9", 1);
                sourceentity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique5");
            }
        }.getValue() != 1) {
            {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique5", 1);
                sourceentity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique1");
            }
        }.getValue() != 1) {
            {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique1", 1);
                sourceentity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique2");
            }
        }.getValue() != 1) {
            {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique2", 1);
                sourceentity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique3");
            }
        }.getValue() != 1) {
            {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique3", 1);
                sourceentity.load(dataIndex);
            }
        }
        if (Math.random() <= 0.005) {
            if (sourceentity instanceof LivingEntity _entity)
                _entity.swing(InteractionHand.MAIN_HAND, true);
        }
    }
}
