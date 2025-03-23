package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.DismantleEntity;
import com.jujutsu.jujutsucraftaddon.entity.DismantleVariantEntity;
import com.jujutsu.jujutsucraftaddon.entity.WorldSlashFinalEntity;
import com.jujutsu.jujutsucraftaddon.entity.WorldSlashVariantEntity;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class PassiveSukunaProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftaddonModMobEffects.WORLD_SLASH_EFFECT.get()))) {
            if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("Dismantle")) {
                if (entity.onGround()) {
                    if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower > 100) {
                        if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount() >= 5.0) {
                            if (Math.random() < (1) / ((float) 25)) {
                                int horizontalRadiusSphere = (int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel) - 1;
                                int verticalRadiusSphere = (int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel) - 1;
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
                                                            (float) (10 * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel), 0, (byte) 1);
                                                    _entityToSpawn.setPos(x + xi, entity.getEyeY(), z + zi);
                                                    _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 10, 0);
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
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANIMATION.get(), 1, 1, false, false));
                                {
                                    double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 50);
                                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                        capability.PlayerCursePower = _setval;
                                        capability.syncPlayerVariables(entity);
                                    });
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
                                        }.getArrow(projectileLevel, entity,
                                                (float) (10 * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel), 0, (byte) 1);
                                        _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                                        _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 10, 0);
                                        projectileLevel.addFreshEntity(_entityToSpawn);
                                    }
                                }
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANIMATION.get(), 1, 1, false, false));
                                {
                                    double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 50);
                                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                        capability.PlayerCursePower = _setval;
                                        capability.syncPlayerVariables(entity);
                                    });
                                }
                            }
                        }
                    }
                } else {
                    if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower > 100) {
                        if (world.isClientSide()) {
                            if (entity instanceof AbstractClientPlayer player) {
                                var animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                if (animation != null && !animation.isActive()) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("dismantleback" + Mth.nextInt(RandomSource.create(), 1, 2))))));
                                }
                            }
                        }
                        if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount() >= 5.0) {
                            if (Math.random() < (1) / ((float) 25)) {
                                int horizontalRadiusSphere = (int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel) - 1;
                                int verticalRadiusSphere = (int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel) - 1;
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
                                                    }.getArrow(projectileLevel, entity,
                                                            (float) (10 * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel), 0, (byte) 1);
                                                    _entityToSpawn.setPos(x + xi, entity.getEyeY(), z + zi);
                                                    _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 10, 0);
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
                                {
                                    double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 50);
                                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                        capability.PlayerCursePower = _setval;
                                        capability.syncPlayerVariables(entity);
                                    });
                                }
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANIMATION.get(), 1, 1, false, false));
                            } else {
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
                                        }.getArrow(projectileLevel, entity,
                                                (float) (10 * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel), 0, (byte) 1);
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
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANIMATION.get(), 1, 1, false, false));
                                {
                                    double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 50);
                                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                        capability.PlayerCursePower = _setval;
                                        capability.syncPlayerVariables(entity);
                                    });
                                }
                            }
                        }
                    }
                }
            } else if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("Cleave")) {
                if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower > 500) {
                    if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount() >= 14.0){
                        if (!entity.onGround()) {
                            if (world.isClientSide()) {
                                if (entity instanceof AbstractClientPlayer player) {
                                    var animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                    if (animation != null && !animation.isActive()) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "dismantleback2"))));
                                    }
                                }
                            }

                        }
                        int horizontalRadiusSphere = (int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel * 2) - 1;
                        int verticalRadiusSphere = (int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel * 2) - 1;
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
                                            }.getArrow(projectileLevel, entity,
                                                    (float) (10 * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel), 0, (byte) 1);
                                            _entityToSpawn.setPos(x + xi, entity.getEyeY(), z + zi);
                                            _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 10, 0);
                                            projectileLevel.addFreshEntity(_entityToSpawn);
                                        }
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
                                                    (float) (10 * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel), 0, (byte) 1);
                                            _entityToSpawn.setPos(x + xi, entity.getEyeY(), z + zi);
                                            _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 10, 0);
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
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANIMATION.get(), 1, 1, false, false));
                        {
                            double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 500);
                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.PlayerCursePower = _setval;
                                capability.syncPlayerVariables(entity);
                            });
                        }
                    }
                }
            }
        } else {
            if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:sukuna_body_chestplate")
                    || (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.SUKUNA_ARMOR_THREE_CHESTPLATE.get()) {
                if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("Dismantle")) {
                    if (entity.onGround()) {
                        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower > 100) {
                            if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount() >= 5.0) {
                                if (Math.random() < (1) / ((float) 25)) {
                                    int horizontalRadiusSphere = (int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel) - 1;
                                    int verticalRadiusSphere = (int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel) - 1;
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
                                                                (float) (10 * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel), 0,
                                                                (byte) 1);
                                                        _entityToSpawn.setPos(x + xi, entity.getEyeY(), z + zi);
                                                        _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 10, 0);
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
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANIMATION.get(), 1, 1, false, false));
                                    {
                                        double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 50);
                                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                            capability.PlayerCursePower = _setval;
                                            capability.syncPlayerVariables(entity);
                                        });
                                    }
                                } else {
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
                                            }.getArrow(projectileLevel, entity,
                                                    (float) (10 * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel), 0, (byte) 1);
                                            _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                                            _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 10, 0);
                                            projectileLevel.addFreshEntity(_entityToSpawn);
                                        }
                                    }
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANIMATION.get(), 1, 1, false, false));
                                    {
                                        double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 50);
                                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                            capability.PlayerCursePower = _setval;
                                            capability.syncPlayerVariables(entity);
                                        });
                                    }
                                }
                            }
                        }
                    } else {
                        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower > 100) {
                            if (world.isClientSide()) {
                                if (entity instanceof AbstractClientPlayer player) {
                                    var animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                    if (animation != null && !animation.isActive()) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("dismantleback" + Mth.nextInt(RandomSource.create(), 1, 2))))));
                                    }
                                }
                            }
                            if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount() >= 5.0) {
                                if (Math.random() < (1) / ((float) 25)) {
                                    int horizontalRadiusSphere = (int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel) - 1;
                                    int verticalRadiusSphere = (int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel) - 1;
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
                                                                (float) (10 * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel), 0,
                                                                (byte) 1);
                                                        _entityToSpawn.setPos(x + xi, entity.getEyeY(), z + zi);
                                                        _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 10, 0);
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
                                    {
                                        double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 50);
                                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                            capability.PlayerCursePower = _setval;
                                            capability.syncPlayerVariables(entity);
                                        });
                                    }
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANIMATION.get(), 1, 1, false, false));
                                } else {
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
                                            }.getArrow(projectileLevel, entity,
                                                    (float) (10 * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel), 0, (byte) 1);
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
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANIMATION.get(), 1, 1, false, false));
                                    {
                                        double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 50);
                                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                            capability.PlayerCursePower = _setval;
                                            capability.syncPlayerVariables(entity);
                                        });
                                    }
                                }
                            }
                        }
                    }
                } else if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("Cleave")) {
                    if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower > 500) {
                        if (entity instanceof ServerPlayer && entity.level() instanceof ServerLevel
                                && (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount() >= 14.0)) {
                            if (!entity.onGround()) {
                                if (world.isClientSide()) {
                                    if (entity instanceof AbstractClientPlayer player) {
                                        var animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                        if (animation != null && !animation.isActive()) {
                                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "dismantleback2"))));
                                        }
                                    }
                                }
                            }
                            int horizontalRadiusSphere = (int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel * 2) - 1;
                            int verticalRadiusSphere = (int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel * 2) - 1;
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
                                                        (float) (10 * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel), 0, (byte) 1);
                                                _entityToSpawn.setPos(x + xi, entity.getEyeY(), z + zi);
                                                _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 10, 0);
                                                projectileLevel.addFreshEntity(_entityToSpawn);
                                            }
                                            if (world instanceof ServerLevel projectileLevel) {
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
                                                }.getArrow(projectileLevel, entity,
                                                        (float) (10 * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel), 0, (byte) 1);
                                                _entityToSpawn.setPos(x + xi, entity.getEyeY(), z + zi);
                                                _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 10, 0);
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
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANIMATION.get(), 1, 1, false, false));
                            {
                                double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 500);
                                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.PlayerCursePower = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        }
                    }
                }
            }
        }
    }
}
