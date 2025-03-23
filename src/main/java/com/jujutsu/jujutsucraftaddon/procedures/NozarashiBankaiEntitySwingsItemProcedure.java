package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;

public class NozarashiBankaiEntitySwingsItemProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        double r = 0;
        double curve = 0;
        double deg = 0;
        double yoff = 0;
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (!(entityiterator == entity)) {
                    if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo_no_move")))) {
                        if (!entityiterator.level().isClientSide())
                            entityiterator.discard();
                        if (world instanceof ServerLevel _level)
                            _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI.get(), (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 1, 0, 0, 0, 1);
                    } else if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                        if (!entityiterator.level().isClientSide())
                            entityiterator.discard();
                        if (world instanceof ServerLevel _level)
                            _level.sendParticles(JujutsucraftaddonModParticleTypes.KAI.get(), (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 1, 0, 0, 0, 1);
                    }
                }
            }
        }
        if (itemstack.getOrCreateTag().getDouble("Range") < 5) {
            itemstack.getOrCreateTag().putDouble("Range", 5);
            itemstack.getOrCreateTag().putDouble("Reach", 5);
            itemstack.getOrCreateTag().putDouble("Knockback", 5);
        }
        itemstack.getOrCreateTag().putDouble("CursePower", (Mth.nextInt(RandomSource.create(), -10, 10)));
        deg = entity.getYRot() - 90;
        r = 1;
        curve = Mth.nextDouble(RandomSource.create(), -10, 10);
        for (int index0 = 0; index0 < 5; index0++) {
            for (int index1 = 0; index1 < 11; index1++) {
                if (r == 2 || r == 3) {
                    yoff = Math.sin(Math.toRadians(deg)) * curve;
                    world.addParticle(ParticleTypes.LARGE_SMOKE, (x - r * Math.sin(Math.toRadians(deg))), (y + 1 + yoff), (z + r * Math.cos(Math.toRadians(deg))), ((-0.1) * Math.sin(Math.toRadians(deg))), 0, (0.1 * Math.cos(Math.toRadians(deg))));
                }
                deg = deg + 18;
            }
            if (r == 2 || r == 4) {
                deg = entity.getYRot() - 81;
            } else {
                deg = entity.getYRot() - 90;
            }
            r = r + 1;
        }
    }
}
