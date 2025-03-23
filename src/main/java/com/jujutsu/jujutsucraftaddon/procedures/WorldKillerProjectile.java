package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.DismantleEntity;
import com.jujutsu.jujutsucraftaddon.entity.DismantleVariantEntity;
import com.jujutsu.jujutsucraftaddon.entity.WorldSlashFinalEntity;
import com.jujutsu.jujutsucraftaddon.entity.WorldSlashVariantEntity;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraft.entity.SukunaEntity;
import net.mcreator.jujutsucraft.entity.SukunaPerfectEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class WorldKillerProjectile {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof SukunaEntity || entity instanceof net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity) {
            if (Math.random() < (1) / ((float) 10)) {
                int horizontalRadiusSphere = (int) (Mth.nextInt(RandomSource.create(), 1, 3));
                int verticalRadiusSphere = (int) horizontalRadiusSphere;
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
                                    }.getArrow(projectileLevel, entity,
                                            (float) (10 * (Mth.nextInt(RandomSource.create(), 1, 5))), 0, (byte) 1);
                                    _entityToSpawn.setPos(x + xi, entity.getEyeY(), z + zi);
                                    _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 10, 0);
                                    projectileLevel.addFreshEntity(_entityToSpawn);
                                }
                            }
                        }
                    }
                }
            } else {
                {
                    Entity _shootFrom = entity;
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
                        }.getArrow(projectileLevel, entity, (float)  (10 * (Mth.nextInt(RandomSource.create(), 1, 5))), 0,
                                (byte) 1);
                        _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                        _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 10, 0);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }
                }
                {
                    Entity _shootFrom = entity;
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
                        }.getArrow(projectileLevel, entity, (float)  (10 * (Mth.nextInt(RandomSource.create(), 1, 5))), 0,
                                (byte) 1);
                        _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                        _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 10, 0);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }
                }
                {
                    Entity _shootFrom = entity;
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
                        }.getArrow(projectileLevel, entity, (float)  (10 * (Mth.nextInt(RandomSource.create(), 1, 5))), 0,
                                (byte) 1);
                        _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                        _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 10, 0);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }
                }
                {
                    Entity _shootFrom = entity;
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
                        }.getArrow(projectileLevel, entity, (float)  (10 * (Mth.nextInt(RandomSource.create(), 1, 5))), 0,
                                (byte) 1);
                        _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                        _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 10, 0);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }
                }
            }
        } else if (entity instanceof SukunaPerfectEntity) {
            if (Math.random() < (1) / ((float) 10)) {
                {
                    int horizontalRadiusSphere = (int) (Mth.nextInt(RandomSource.create(), 1, 3));
                    int verticalRadiusSphere = (int) horizontalRadiusSphere;
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
                                                AbstractArrow entityToSpawn = new WorldSlashVariantEntity(JujutsucraftaddonModEntities.WORLD_SLASH_VARIANT.get(), level);
                                                entityToSpawn.setOwner(shooter);
                                                entityToSpawn.setBaseDamage(damage);
                                                entityToSpawn.setKnockback(knockback);
                                                entityToSpawn.setSilent(true);
                                                entityToSpawn.setPierceLevel(piercing);
                                                return entityToSpawn;
                                            }
                                        }.getArrow(projectileLevel, entity,
                                                (float) (10 * (Mth.nextInt(RandomSource.create(), 1, 5))), 0, (byte) 1);
                                        _entityToSpawn.setPos(x + xi, entity.getEyeY(), z + zi);
                                        _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 10, 0);
                                        projectileLevel.addFreshEntity(_entityToSpawn);
                                    }
                                }
                            }
                        }
                    }
                }

            }else {
                {
                    Entity _shootFrom = entity;
                    Level projectileLevel = _shootFrom.level();
                    if (!projectileLevel.isClientSide()) {
                        Projectile _entityToSpawn = new Object() {
                            public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                                AbstractArrow entityToSpawn = new WorldSlashFinalEntity(JujutsucraftaddonModEntities.WORLD_SLASH_FINAL.get(), level);
                                entityToSpawn.setOwner(shooter);
                                entityToSpawn.setBaseDamage(damage);
                                entityToSpawn.setKnockback(knockback);
                                entityToSpawn.setSilent(true);
                                entityToSpawn.setPierceLevel(piercing);
                                return entityToSpawn;
                            }
                        }.getArrow(projectileLevel, entity, (float) (10 * (Mth.nextInt(RandomSource.create(), 1, 5))), 0,
                                (byte) 1);
                        _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                        _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 10, 0);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }
                }
                {
                    Entity _shootFrom = entity;
                    Level projectileLevel = _shootFrom.level();
                    if (!projectileLevel.isClientSide()) {
                        Projectile _entityToSpawn = new Object() {
                            public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                                AbstractArrow entityToSpawn = new WorldSlashVariantEntity(JujutsucraftaddonModEntities.WORLD_SLASH_VARIANT.get(), level);
                                entityToSpawn.setOwner(shooter);
                                entityToSpawn.setBaseDamage(damage);
                                entityToSpawn.setKnockback(knockback);
                                entityToSpawn.setSilent(true);
                                entityToSpawn.setPierceLevel(piercing);
                                return entityToSpawn;
                            }
                        }.getArrow(projectileLevel, entity, (float) (10 * (Mth.nextInt(RandomSource.create(), 1, 5))), 0,
                                (byte) 1);
                        _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                        _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 10, 0);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }
                }
                {
                    Entity _shootFrom = entity;
                    Level projectileLevel = _shootFrom.level();
                    if (!projectileLevel.isClientSide()) {
                        Projectile _entityToSpawn = new Object() {
                            public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                                AbstractArrow entityToSpawn = new WorldSlashFinalEntity(JujutsucraftaddonModEntities.WORLD_SLASH_FINAL.get(), level);
                                entityToSpawn.setOwner(shooter);
                                entityToSpawn.setBaseDamage(damage);
                                entityToSpawn.setKnockback(knockback);
                                entityToSpawn.setSilent(true);
                                entityToSpawn.setPierceLevel(piercing);
                                return entityToSpawn;
                            }
                        }.getArrow(projectileLevel, entity, (float) (10 * (Mth.nextInt(RandomSource.create(), 1, 5))), 0,
                                (byte) 1);
                        _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                        _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 10, 0);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }
                }
                {
                    Entity _shootFrom = entity;
                    Level projectileLevel = _shootFrom.level();
                    if (!projectileLevel.isClientSide()) {
                        Projectile _entityToSpawn = new Object() {
                            public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                                AbstractArrow entityToSpawn = new WorldSlashVariantEntity(JujutsucraftaddonModEntities.WORLD_SLASH_VARIANT.get(), level);
                                entityToSpawn.setOwner(shooter);
                                entityToSpawn.setBaseDamage(damage);
                                entityToSpawn.setKnockback(knockback);
                                entityToSpawn.setSilent(true);
                                entityToSpawn.setPierceLevel(piercing);
                                return entityToSpawn;
                            }
                        }.getArrow(projectileLevel, entity, (float) (10 * (Mth.nextInt(RandomSource.create(), 1, 5))), 0,
                                (byte) 1);
                        _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                        _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 10, 0);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }
                }
            }
        }

    }
}