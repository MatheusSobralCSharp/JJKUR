package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;

public class HWBOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        entity.getPersistentData().putDouble("Tag1", 1.5);
        entity.getPersistentData().putDouble("Tag2", 0);
        entity.getPersistentData().putDouble("Tag3", 90);
        for (int index0 = 0; index0 < 30; index0++) {
            for (int index1 = 0; index1 < 16; index1++) {
                world.addParticle(JujutsucraftaddonModParticleTypes.BLUEE.get(),
                        (x - entity.getPersistentData().getDouble("Tag1") * Math.cos(Math.toRadians(entity.getPersistentData().getDouble("Tag3"))) * Math.sin(Math.toRadians(entity.getPersistentData().getDouble("Tag2")))),
                        ((y + 1) - 1.5 * Math.sin(Math.toRadians(entity.getPersistentData().getDouble("Tag3")))),
                        (z + entity.getPersistentData().getDouble("Tag1") * Math.cos(Math.toRadians(entity.getPersistentData().getDouble("Tag3"))) * Math.cos(Math.toRadians(entity.getPersistentData().getDouble("Tag2")))), 0, 0, 0);
                entity.getPersistentData().putDouble("Tag3", (entity.getPersistentData().getDouble("Tag3") + 12));
            }
            entity.getPersistentData().putDouble("Tag3", 90);
            entity.getPersistentData().putDouble("Tag2", (entity.getPersistentData().getDouble("Tag2") + 12));
        }
        {
            final Vec3 _center = new Vec3(x, (y + 1), z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (!(entityiterator == entity)) {
                    entityiterator.setDeltaMovement(new Vec3(((-1.5) * entityiterator.getDeltaMovement().x()), ((-1.5) * entityiterator.getDeltaMovement().y()), ((-1.5) * entityiterator.getDeltaMovement().z())));
                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1, false, false));
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entityiterator.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("CursedSpirit");
                        }
                    }.getValue() == 1) {
                        entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))), 100);
                        if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                            if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get(), 20,
                                        (entity instanceof LivingEntity && ((LivingEntity) entityiterator).hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())
                                                ? ((LivingEntity) entityiterator).getEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get()).getAmplifier()
                                                : 0)
                                                + (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())
                                                ? ((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get()).getAmplifier()
                                                : 0),
                                        false, false));
                        }
                    } else {
                        entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))), 25);
                    }
                }
            }
        }
    }
}
