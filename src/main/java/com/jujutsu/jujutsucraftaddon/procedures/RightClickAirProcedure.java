package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.DismantleEntity;
import com.jujutsu.jujutsucraftaddon.entity.WorldSlashVariantEntity;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.RangeAttackProcedure;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class RightClickAirProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 1) {
            if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("Dismantle")) {
                if(((JujutsucraftModVariables.PlayerVariables) sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount() >= 5.0) {
                    if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower > 50) {
                        if (Math.random() < (1) / ((float) 10)) {
                            if (!(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(JujutsucraftaddonModMobEffects.WORLD_SLASH_EFFECT.get()))) {
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
                                        }.getArrow(projectileLevel, sourceentity, 5, 3, (byte) 1);
                                        _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                                        _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 10, 0);
                                        projectileLevel.addFreshEntity(_entityToSpawn);
                                    }
                                }
                                {
                                    double _setval = ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 50);
                                    sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                        capability.PlayerCursePower = _setval;
                                        capability.syncPlayerVariables(sourceentity);
                                    });
                                }
                            } else {
                                {
                                    Entity _shootFrom = sourceentity;
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
                                        }.getArrow(projectileLevel, sourceentity, 5, 3, (byte) 1);
                                        _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                                        _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 10, 0);
                                        projectileLevel.addFreshEntity(_entityToSpawn);
                                    }
                                }
                                {
                                    double _setval = ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 50);
                                    sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                        capability.PlayerCursePower = _setval;
                                        capability.syncPlayerVariables(sourceentity);
                                    });
                                }
                            }
                        }
                    }
                }
            } else if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("Cleave")) {
                if (((JujutsucraftModVariables.PlayerVariables) sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount() >= 15.0) {
                    if (Math.random() < (1) / ((float) 50)) {
                        if (world instanceof ServerLevel _serverLevel) {
                            LevelAccessor _worldorig = world;
                            world = _serverLevel.getServer().getLevel(entity.level().dimension());
                            if (world != null) {
                                Entity entitytospawn = JujutsucraftaddonModEntities.CLEAVE_WEB.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
                                if (entitytospawn != null) {
                                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                    {
                                        CompoundTag dataIndex = new CompoundTag();
                                        (entitytospawn).saveWithoutId(dataIndex);
                                        dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                                        (entitytospawn).load(dataIndex);
                                    }
                                    {
                                        CompoundTag dataIndex = new CompoundTag();
                                        (entitytospawn).saveWithoutId(dataIndex);
                                        dataIndex.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                                            public double getValue() {
                                                CompoundTag dataIndex = new CompoundTag();
                                                sourceentity.saveWithoutId(dataIndex);
                                                return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                            }
                                        }.getValue()));
                                        (entitytospawn).load(dataIndex);
                                    }
                                    {
                                        CompoundTag dataIndex = new CompoundTag();
                                        entity.saveWithoutId(dataIndex);
                                        dataIndex.putString("Owner", (sourceentity.getStringUUID()));
                                        entity.load(dataIndex);
                                    }
                                    _serverLevel.addFreshEntity(entitytospawn);
                                }
                            }
                            world = _worldorig;
                        }
                        {
                            double _setval = ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 200);
                            sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.PlayerCursePower = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                    } else if (Math.random() < (1) / ((float) 10)) {
                        {
                            Entity _ent = sourceentity;
                            _ent.teleportTo((entity.getX()), (y + 1), (entity.getZ() + Mth.nextDouble(RandomSource.create(), -2, 2)));
                            if (_ent instanceof ServerPlayer _serverPlayer)
                                _serverPlayer.connection.teleport((entity.getX()), (y + 1), (entity.getZ() + Mth.nextDouble(RandomSource.create(), -2, 2)), _ent.getYRot(), _ent.getXRot());
                        }
                        sourceentity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entity.getX()), (entity.getY() + 1), (entity.getZ())));
                        sourceentity.getPersistentData().putDouble("Damage", 6 + Mth.nextInt(RandomSource.create(), 1, 2) * 3);
                        sourceentity.getPersistentData().putDouble("Range", entity.getBbWidth() + 10.0F);
                        sourceentity.getPersistentData().putDouble("effect", 2.0);
                        sourceentity.getPersistentData().putDouble("knockback", 0.25);
                        sourceentity.getPersistentData().putDouble("projectile_type", 1.0);
                        sourceentity.getPersistentData().putBoolean("onlyRanged", true);
                        RangeAttackProcedure.execute(world, sourceentity.getX(), sourceentity.getY() + (double) sourceentity.getBbHeight() * 0.5, sourceentity.getZ(), sourceentity);
                        sourceentity.getPersistentData().putBoolean("onlyRanged", false);
                        {
                            double _setval = ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 50);
                            sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.PlayerCursePower = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                    }
                }
            }
        }
    }
}
