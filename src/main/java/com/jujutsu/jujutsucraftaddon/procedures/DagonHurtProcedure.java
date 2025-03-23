package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class DagonHurtProcedure {
    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        double xRadius = 0;
        double loop = 0;
        double zRadius = 0;
        double particleAmount = 0;
        double yRadius = 0;
        double masterRadius = 0;
        double Grow = 0;
        double TrackZ = 0;
        double TrackY = 0;
        double TrackX = 0;
        if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:rika") || (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:rika_2")) {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("skill");
                }
            }.getValue() == 0 && new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("skill_domain");
                }
            }.getValue() == 0) {
                if (Math.random() < 0.005) {
                    TrackX = sourceentity.getX() - entity.getX();
                    TrackY = sourceentity.getY() - entity.getY() + sourceentity.getBbHeight() * 0.75 - entity.getBbHeight() * 0.75;
                    TrackZ = sourceentity.getZ() - entity.getZ();
                    Grow = 1;
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1000, 254, false, false));
                    if (world instanceof Level _level && !_level.isClientSide())
                        _level.explode(null, (sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), 5, Level.ExplosionInteraction.TNT);
                    for (int index0 = 0; index0 < 20; index0++) {
                        if (world instanceof ServerLevel _level)
                            _level.sendParticles(ParticleTypes.WITCH, (entity.getX() + TrackX * Grow), (entity.getY() + entity.getBbHeight() * 0.75 + TrackY * Grow), (entity.getZ() + TrackZ * Grow), 5, 0.15, 0.15, 0.15, 0);
                        Grow = Grow - 0.05;
                    }
                }
            }
        }
    }
}
