package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import java.util.List;

public class DeerBuffedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (Math.random() < (1) / ((float) 300)) {
                    if ((entity.getPersistentData().getString("OWNER_UUID")).equals(entityiterator.getStringUUID())) {
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get(), 100,
                                    (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())
                                            ? _livEnt.getEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get()).getAmplifier()
                                            : 0) + 2,
                                    false, false));
                    }
                }
                if (!(entity.getPersistentData().getString("OWNER_UUID")).equals(entityiterator.getStringUUID())) {
                    if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                        if (!(ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).contains("purple")) {
                            if (!(ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).contains("blue")) {
                                if (!(ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).contains("red")) {
                                    if (!(ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).contains("flame")) {
                                        if (!(ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).contains("meteor")) {
                                            if (!(ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).contains("true_sphere")) {
                                                if (!(ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).contains("entity_jacobs_ladder")) {
                                                    if (!(ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).contains("black_hole")) {
                                                        if (world instanceof ServerLevel _level)
                                                            _level.sendParticles(ParticleTypes.CRIT, x, y, z, 0, 0, 0, 0, 1);
                                                        if (!entityiterator.level().isClientSide())
                                                            entityiterator.discard();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
