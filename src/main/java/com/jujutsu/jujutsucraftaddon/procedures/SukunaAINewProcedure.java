package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.DismantleEntity;
import com.jujutsu.jujutsucraftaddon.entity.DismantleVariantEntity;
import com.jujutsu.jujutsucraftaddon.entity.ErroEntity;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class SukunaAINewProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
        if (sourceentity == null)
            return;
        if (Math.random() < (1) / ((float) 200)) {
            if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).getAmplifier() : 0) >= 5) {
                if (!sourceentity.onGround()) {
                    if (sourceentity instanceof ErroEntity) {
                        ((ErroEntity) sourceentity).setAnimation("animation.dismantle_backwards");
                    }
                } else {
                    if (sourceentity instanceof ErroEntity) {
                        ((ErroEntity) sourceentity).setAnimation("animation.dismantle_maximum3");
                    }
                }
                int horizontalRadiusSphere = (Mth.nextInt(RandomSource.create(), 1, 5) * 2) - 1;
                int verticalRadiusSphere = (Mth.nextInt(RandomSource.create(), 1, 5) * 2) - 1;
                int yIterationsSphere = verticalRadiusSphere;
                for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
                    for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
                        for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
                            double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
                                    + (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
                            if (distanceSq <= 1.0) {
                                if (world instanceof ServerLevel projectileLevel) {
                                    Projectile _entityToSpawn = new Object() {
                                        public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                                            AbstractArrow entityToSpawn = new DismantleEntity(JujutsucraftaddonModEntities.DISMANTLE.get(), level);
                                            entityToSpawn.setOwner(shooter);
                                            entityToSpawn.setBaseDamage(damage);
                                            entityToSpawn.setKnockback(knockback);
                                            entityToSpawn.setSilent(true);
                                            entityToSpawn.setPierceLevel(piercing);
                                            return entityToSpawn;
                                        }
                                    }.getArrow(projectileLevel, sourceentity, (float) (10 * Mth.nextInt(RandomSource.create(), 1, 5)), 3, (byte) 1);
                                    _entityToSpawn.setPos(x + xi, sourceentity.getEyeY(), z + zi);
                                    _entityToSpawn.shoot(sourceentity.getLookAngle().x, sourceentity.getLookAngle().y, sourceentity.getLookAngle().z, 10, 0);
                                    projectileLevel.addFreshEntity(_entityToSpawn);
                                }
                                if (world instanceof Level _level) {
                                    if (!_level.isClientSide()) {
                                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:kai")), SoundSource.NEUTRAL, 1, 1);
                                    } else {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:kai")), SoundSource.NEUTRAL, 1, 1, false);
                                    }
                                }
                                if (world instanceof Level _level) {
                                    if (!_level.isClientSide()) {
                                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:dismantle")), SoundSource.NEUTRAL, 1, 1);
                                    } else {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:dismantle")), SoundSource.NEUTRAL, 1, 1, false);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if (Math.random() < (1) / ((float) 100)) {
            if (!sourceentity.onGround()) {
                if (sourceentity instanceof ErroEntity) {
                    ((ErroEntity) sourceentity).setAnimation("animation.dismantle_backwards");
                }
            } else {
                if (sourceentity instanceof ErroEntity) {
                    ((ErroEntity) sourceentity).setAnimation("animation.rapid_dismantle");
                }
            }
            if (sourceentity.onGround()) {
                if (Math.random() < (1) / ((float) 50)) {
                    int horizontalRadiusSphere = Mth.nextInt(RandomSource.create(), 1, 3) - 1;
                    int verticalRadiusSphere = Mth.nextInt(RandomSource.create(), 1, 3) - 1;
                    int yIterationsSphere = verticalRadiusSphere;
                    for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
                        for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
                            for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
                                double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
                                        + (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
                                if (distanceSq <= 1.0) {
                                    if (world instanceof ServerLevel projectileLevel) {
                                        Projectile _entityToSpawn = new Object() {
                                            public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                                                AbstractArrow entityToSpawn = new DismantleEntity(JujutsucraftaddonModEntities.DISMANTLE.get(), level);
                                                entityToSpawn.setOwner(shooter);
                                                entityToSpawn.setBaseDamage(damage);
                                                entityToSpawn.setKnockback(knockback);
                                                entityToSpawn.setSilent(true);
                                                entityToSpawn.setPierceLevel(piercing);
                                                return entityToSpawn;
                                            }
                                        }.getArrow(projectileLevel, sourceentity, (float) (10 * Mth.nextInt(RandomSource.create(), 1, 5)), 3, (byte) 1);
                                        _entityToSpawn.setPos(x + xi, sourceentity.getEyeY(), z + zi);
                                        _entityToSpawn.shoot(sourceentity.getLookAngle().x, sourceentity.getLookAngle().y, sourceentity.getLookAngle().z, 10, 0);
                                        projectileLevel.addFreshEntity(_entityToSpawn);
                                    }
                                    if (world instanceof Level _level) {
                                        if (!_level.isClientSide()) {
                                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:dismantle")), SoundSource.NEUTRAL, 1, 1);
                                        } else {
                                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:dismantle")), SoundSource.NEUTRAL, 1, 1, false);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    {
                        Entity _shootFrom = sourceentity;
                        Level projectileLevel = _shootFrom.level();
                        if (!projectileLevel.isClientSide()) {
                            Projectile _entityToSpawn = new Object() {
                                public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                                    AbstractArrow entityToSpawn = new DismantleEntity(JujutsucraftaddonModEntities.DISMANTLE.get(), level);
                                    entityToSpawn.setOwner(shooter);
                                    entityToSpawn.setBaseDamage(damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    entityToSpawn.setPierceLevel(piercing);
                                    return entityToSpawn;
                                }
                            }.getArrow(projectileLevel, sourceentity, (float) (10 * Mth.nextInt(RandomSource.create(), 1, 5)), 3, (byte) 1);
                            _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                            _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 10, 0);
                            projectileLevel.addFreshEntity(_entityToSpawn);
                        }
                    }
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:dismantle")), SoundSource.NEUTRAL, 1, 1);
                        } else {
                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:dismantle")), SoundSource.NEUTRAL, 1, 1, false);
                        }
                    }
                }
            } else {
                if (Math.random() < (1) / ((float) 50)) {
                    int horizontalRadiusSphere = Mth.nextInt(RandomSource.create(), 1, 3) - 1;
                    int verticalRadiusSphere = Mth.nextInt(RandomSource.create(), 1, 3) - 1;
                    int yIterationsSphere = verticalRadiusSphere;
                    for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
                        for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
                            for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
                                double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
                                        + (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
                                if (distanceSq <= 1.0) {
                                    if (world instanceof ServerLevel projectileLevel) {
                                        Projectile _entityToSpawn = new Object() {
                                            public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                                                AbstractArrow entityToSpawn = new DismantleVariantEntity(JujutsucraftaddonModEntities.DISMANTLE_VARIANT.get(), level);
                                                entityToSpawn.setOwner(shooter);
                                                entityToSpawn.setBaseDamage(damage);
                                                entityToSpawn.setKnockback(knockback);
                                                entityToSpawn.setSilent(true);
                                                entityToSpawn.setPierceLevel(piercing);
                                                return entityToSpawn;
                                            }
                                        }.getArrow(projectileLevel, sourceentity, (float) (10 * Mth.nextInt(RandomSource.create(), 1, 5)), 3, (byte) 1);
                                        _entityToSpawn.setPos(x + xi, sourceentity.getEyeY(), z + zi);
                                        _entityToSpawn.shoot(sourceentity.getLookAngle().x, sourceentity.getLookAngle().y, sourceentity.getLookAngle().z, 10, 0);
                                        projectileLevel.addFreshEntity(_entityToSpawn);
                                    }
                                    if (world instanceof Level _level) {
                                        if (!_level.isClientSide()) {
                                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:kai")), SoundSource.NEUTRAL, 1, 1);
                                        } else {
                                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:kai")), SoundSource.NEUTRAL, 1, 1, false);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    {
                        Entity _shootFrom = sourceentity;
                        Level projectileLevel = _shootFrom.level();
                        if (!projectileLevel.isClientSide()) {
                            Projectile _entityToSpawn = new Object() {
                                public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                                    AbstractArrow entityToSpawn = new DismantleVariantEntity(JujutsucraftaddonModEntities.DISMANTLE_VARIANT.get(), level);
                                    entityToSpawn.setOwner(shooter);
                                    entityToSpawn.setBaseDamage(damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    entityToSpawn.setPierceLevel(piercing);
                                    return entityToSpawn;
                                }
                            }.getArrow(projectileLevel, sourceentity, (float) (10 * Mth.nextInt(RandomSource.create(), 1, 5)), 3, (byte) 1);
                            _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                            _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 10, 0);
                            projectileLevel.addFreshEntity(_entityToSpawn);
                        }
                    }
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:kai")), SoundSource.NEUTRAL, 1, 1);
                        } else {
                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:kai")), SoundSource.NEUTRAL, 1, 1, false);
                        }
                    }
                }
            }
        }
    }
}
