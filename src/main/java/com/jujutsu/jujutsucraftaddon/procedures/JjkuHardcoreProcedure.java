package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.LevelAccessor;

public class JjkuHardcoreProcedure {
    public static void execute(LevelAccessor world, Entity sourceentity) {
        if (sourceentity == null)
            return;
        if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_HARDCORE_MODE)) {
            if (sourceentity instanceof Monster) {
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex2 = new CompoundTag();
                        sourceentity.saveWithoutId(dataIndex2);
                        return dataIndex2.getCompound("ForgeData").getDouble("CursedSpirit");
                    }
                }.getValue() == 1 || new Object() {
                    public double getValue() {
                        CompoundTag dataIndex3 = new CompoundTag();
                        sourceentity.saveWithoutId(dataIndex3);
                        return dataIndex3.getCompound("ForgeData").getDouble("CurseUser");
                    }
                }.getValue() == 1 || new Object() {
                    public double getValue() {
                        CompoundTag dataIndex4 = new CompoundTag();
                        sourceentity.saveWithoutId(dataIndex4);
                        return dataIndex4.getCompound("ForgeData").getDouble("JujutsuSorcerer");
                    }
                }.getValue() == 1) {
                    if (sourceentity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                        if (Math.random() <= 0.1) {
                            if (sourceentity instanceof LivingEntity _entity)
                                _entity.removeEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get());
                        }
                    }
                }
            }
        }
    }
}
