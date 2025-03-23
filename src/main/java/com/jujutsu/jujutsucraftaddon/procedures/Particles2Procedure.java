package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class Particles2Procedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (Math.random() < 0.01) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_5.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.KAI_5.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_9.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HORIZONTAL_SLASH_2.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
        } else if (Math.random() > 0.01 && Math.random() < 0.1) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_6.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.KAI_6.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_7.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HORIZONTAL_SLASH.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
        } else if (Math.random() > 0.1 && Math.random() < 0.3) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_5.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.KAI_5.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_9.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HORIZONTAL_SLASH_2.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
        } else if (Math.random() > 0.3 && Math.random() < 0.5) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_10.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.KAI_10.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_8.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HORIZONTAL_SLASH_BLACK.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HORIZONTAL_KAI.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
        } else if (Math.random() > 0.5 && Math.random() < 1) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.KAI_6.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_6.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_7.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HORIZONTAL_SLASH.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
        }
        if (Math.random() < 0.01) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_5.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.KAI_5.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_9.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HORIZONTAL_SLASH_2.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
        } else if (Math.random() > 0.01 && Math.random() < 0.1) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_6.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.KAI_6.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_7.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HORIZONTAL_SLASH.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
        } else if (Math.random() > 0.1 && Math.random() < 0.3) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_5.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.KAI_5.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_9.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HORIZONTAL_SLASH_2.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
        } else if (Math.random() > 0.3 && Math.random() < 0.5) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_10.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.KAI_10.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_8.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HORIZONTAL_SLASH_BLACK.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HORIZONTAL_KAI.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
        } else if (Math.random() > 0.5 && Math.random() < 1) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.KAI_6.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_6.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_7.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HORIZONTAL_SLASH.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
        }
        if (Math.random() < 0.01) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_5.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.KAI_5.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_9.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HORIZONTAL_SLASH_2.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
        } else if (Math.random() > 0.01 && Math.random() < 0.1) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_6.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.KAI_6.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_7.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HORIZONTAL_SLASH.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
        } else if (Math.random() > 0.1 && Math.random() < 0.3) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_5.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.KAI_5.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_9.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HORIZONTAL_SLASH_2.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
        } else if (Math.random() > 0.3 && Math.random() < 0.5) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_10.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.KAI_10.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_8.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HORIZONTAL_SLASH_BLACK.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HORIZONTAL_KAI.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
        } else if (Math.random() > 0.5 && Math.random() < 1) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.KAI_6.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_6.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI_7.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.HORIZONTAL_SLASH.get(), (entity.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35),
                        (entity.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), (entity.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 35), 0, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 4);
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("skill_domain");
            }
        }.getValue() == 0) {
            if (entity instanceof LivingEntity _entity)
                _entity.removeEffect(JujutsucraftaddonModMobEffects.SHRINE_EFFECT.get());
        }
    }
}
