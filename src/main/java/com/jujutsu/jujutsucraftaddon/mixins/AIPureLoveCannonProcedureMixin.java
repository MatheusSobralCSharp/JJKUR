package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraft.entity.CrowEntity;
import net.mcreator.jujutsucraft.entity.PureLoveCannonEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.procedures.*;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;

@Mixin(value = AIPureLoveCannonProcedure.class, priority = -10000)
public abstract class AIPureLoveCannonProcedureMixin {

    /**
     * @author Sat
     * @reason None
     */
    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            Entity entity_a = null;
            boolean logic_attack = false;
            boolean type = false;
            boolean reChange = false;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double rad = 0.0;
            double tsuki7_mode = 0.0;
            double range = 0.0;
            double cnt1_local = 0.0;
            double rad_now = 0.0;
            double dis = 0.0;
            double cnt2 = 0.0;
            double NUM1 = 0.0;
            double damage = 0.0;
            double CNT6 = 0.0;
            double picth = 0.0;
            double yaw = 0.0;
            ServerLevel _level;
            if (world instanceof ServerLevel) {
                _level = (ServerLevel) world;
                _level.sendParticles(JujutsucraftModParticleTypes.PARTICLE_FIRE_SPARK.get(), x, y, z, 1, 1.0, 1.0, 1.0, 2.0);
            }

            if (world instanceof ServerLevel) {
                _level = (ServerLevel) world;
                _level.sendParticles(JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), x, y, z, 6, 1.0, 1.0, 1.0, 1.0);
            }
            if (world instanceof ServerLevel) {
                if (entity instanceof PureLoveCannonEntity _datEntL2) {
                    if (_datEntL2.getEntityData().get(PureLoveCannonEntity.DATA_move)) {
                        entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
                        if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
                            if (entity.getPersistentData().getDouble("cnt1") > 12.0) {
                                if (entity.getPersistentData().getDouble("cnt1") == 13.0) {
                                    if (world instanceof ServerLevel) {
                                        _level = (ServerLevel) world;
                                        if (!_level.isClientSide()) {
                                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.75F);
                                        } else {
                                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.75F, false);
                                        }
                                    }

                                    if (world instanceof ServerLevel) {
                                        _level = (ServerLevel) world;
                                        if (!_level.isClientSide()) {
                                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                                        } else {
                                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                                        }
                                    }

                                    if (world instanceof ServerLevel) {
                                        _level = (ServerLevel) world;
                                        _level.sendParticles(ParticleTypes.CLOUD, x, y, z, 20, 0.3, 0.3, 0.3, 2.0);
                                    }

                                    if (world instanceof ServerLevel) {
                                        _level = (ServerLevel) world;
                                        _level.sendParticles(ParticleTypes.EXPLOSION, x, y, z, 40, 1.0, 1.0, 1.0, 0.5);
                                    }
                                }

                                if (world instanceof ServerLevel) {
                                    _level = (ServerLevel) world;
                                    _level.sendParticles(ParticleTypes.EXPLOSION, x, y, z, 10, 1.0, 1.0, 1.0, 0.5);
                                }

                                if (world instanceof ServerLevel) {
                                    _level = (ServerLevel) world;
                                    _level.sendParticles(ParticleTypes.CLOUD, x, y, z, 20, 1.0, 1.0, 1.0, 0.5);
                                }
                            }

                            if (Math.sqrt(Math.pow(entity.getDeltaMovement().x(), 2.0) + Math.pow(entity.getDeltaMovement().y(), 2.0) + Math.pow(entity.getDeltaMovement().z(), 2.0)) < 0.5 && entity.getPersistentData().getDouble("cnt1") > 12.0 || entity.getPersistentData().getDouble("cnt1") > 50.0 || !entity.isAlive()) {
                                entity.getPersistentData().putDouble("cnt2", 1.0);
                            }

                            if (entity.getPersistentData().getDouble("cnt2") > 0.0) {
                                entity.getPersistentData().putDouble("x_pos", entity.getX());
                                entity.getPersistentData().putDouble("y_pos", entity.getY());
                                entity.getPersistentData().putDouble("z_pos", entity.getZ());
                                if (!entity.getPersistentData().getBoolean("flag_start")) {
                                    entity.getPersistentData().putBoolean("flag_start", true);
                                }
                            }

                            if (entity.getPersistentData().getDouble("cnt1") > 10.0) {
                                if (!entity.getPersistentData().getBoolean("Stop")) {
                                    entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 0.5, entity.getPersistentData().getDouble("y_power") * 0.5, entity.getPersistentData().getDouble("z_power") * 0.5));
                                    BulletDomainHit2Procedure.execute(world, entity);
                                } else {
                                    entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                                    entity.getPersistentData().putBoolean("Stop", true);
                                }
                            } else {
                                entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                            }

                            entity.getPersistentData().putDouble("Damage", 52.0);
                            entity.getPersistentData().putDouble("Range", 12.0 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_RIKA_PURE_LOVE)));
                            entity.getPersistentData().putDouble("knockback", 2.0);
                            entity.getPersistentData().putDouble("effectConfirm", 2.0);
                            RangeAttackProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
                        } else {
                            entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
                            x_pos = entity.getPersistentData().getDouble("x_pos");
                            y_pos = entity.getPersistentData().getDouble("y_pos") + (entity.getPersistentData().getDouble("cnt2") - 2.0) * 2.0;
                            z_pos = entity.getPersistentData().getDouble("z_pos");
                            if (world instanceof ServerLevel) {
                                _level = (ServerLevel) world;
                                _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "particle jujutsucraft:particle_thunder_blue ~ ~ ~ 8 8 8 2 150 force");
                            }

                            if (world instanceof ServerLevel) {
                                _level = (ServerLevel) world;
                                _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "particle minecraft:explosion ~ ~ ~ 8 8 8 1 150 force");
                            }

                            if (entity.getPersistentData().getDouble("cnt2") < 15.0) {
                                entity.getPersistentData().putDouble("Damage", 52.0);
                                entity.getPersistentData().putDouble("Range", 24.0 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_RIKA_PURE_LOVE) * ReturnEntitySizeProcedure.execute(entity)));
                                entity.getPersistentData().putDouble("knockback", 2.0);
                                entity.getPersistentData().putDouble("effectConfirm", 2.0);
                                RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                                if (world instanceof ServerLevel) {
                                    _level = (ServerLevel) world;
                                    if (!_level.isClientSide()) {
                                        _level.playSound(null, BlockPos.containing(x_pos, y_pos, z_pos), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                                    } else {
                                        _level.playLocalSound(x_pos, y_pos, z_pos, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                                    }
                                }

                                if (world instanceof ServerLevel) {
                                    _level = (ServerLevel) world;
                                    if (!_level.isClientSide()) {
                                        _level.playSound(null, BlockPos.containing(x_pos, y_pos, z_pos), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 0.5F);
                                    } else {
                                        _level.playLocalSound(x_pos, y_pos, z_pos, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 0.5F, false);
                                    }
                                }
                            }

                            if (entity.getPersistentData().getDouble("cnt2") < 3.0) {
                                entity.getPersistentData().putDouble("BlockRange", 24.0 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_RIKA_PURE_LOVE)));
                                entity.getPersistentData().putDouble("BlockDamage", 18.0 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_RIKA_PURE_LOVE)));
                                entity.getPersistentData().putBoolean("noParticle", true);
                                BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                                if (world instanceof ServerLevel) {
                                    _level = (ServerLevel) world;
                                    if (!_level.isClientSide()) {
                                        _level.playSound(null, BlockPos.containing(x_pos, y_pos, z_pos), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                                    } else {
                                        _level.playLocalSound(x_pos, y_pos, z_pos, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                                    }
                                }

                                if (world instanceof ServerLevel) {
                                    _level = (ServerLevel) world;
                                    if (!_level.isClientSide()) {
                                        _level.playSound(null, BlockPos.containing(x_pos, y_pos, z_pos), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 0.75F);
                                    } else {
                                        _level.playLocalSound(x_pos, y_pos, z_pos, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 5.0F, 0.75F, false);
                                    }
                                }
                            }
                        }

                        if (entity.getPersistentData().getDouble("cnt2") > 30.0 && !entity.level().isClientSide()) {
                            entity.discard();
                        }

                        return;
                    }
                }

                logic_attack = false;
                entity.getPersistentData().putBoolean("Stop", false);
                if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
                    entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
                        public Entity apply(LevelAccessor levelAccessor, String uuid) {
                            if (levelAccessor instanceof ServerLevel serverLevel) {
                                try {
                                    return serverLevel.getEntity(UUID.fromString(uuid));
                                } catch (Exception var5) {
                                }
                            }

                            return null;
                        }
                    }).apply(world, entity.getPersistentData().getString("OWNER_UUID"));
                    if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged") && entity_a.getPersistentData().getDouble("skill") != 0.0 && entity_a.getPersistentData().getDouble("cnt1") < 80.0) {
                        logic_attack = true;
                        Entity _ent = entity;
                        _ent.teleportTo(entity_a.getPersistentData().getDouble("x_pos"), entity_a.getPersistentData().getDouble("y_pos"), entity_a.getPersistentData().getDouble("z_pos"));
                        if (_ent instanceof ServerPlayer _serverPlayer) {
                            _serverPlayer.connection.teleport(entity_a.getPersistentData().getDouble("x_pos"), entity_a.getPersistentData().getDouble("y_pos"), entity_a.getPersistentData().getDouble("z_pos"), _ent.getYRot(), _ent.getXRot());
                        }

                        _ent = entity;
                        _ent.setYRot(entity_a.getYRot());
                        _ent.setXRot(0.0F);
                        _ent.setYBodyRot(_ent.getYRot());
                        _ent.setYHeadRot(_ent.getYRot());
                        _ent.yRotO = _ent.getYRot();
                        _ent.xRotO = _ent.getXRot();
                        if (_ent instanceof LivingEntity _entity) {
                            _entity.yBodyRotO = _entity.getYRot();
                            _entity.yHeadRotO = _entity.getYRot();
                        }

                        entity.getPersistentData().putDouble("x_power", entity_a.getPersistentData().getDouble("x_power"));
                        entity.getPersistentData().putDouble("y_power", entity_a.getPersistentData().getDouble("y_power"));
                        entity.getPersistentData().putDouble("z_power", entity_a.getPersistentData().getDouble("z_power"));
                    }
                }

                if (Math.random() < 0.05 && world instanceof ServerLevel) {
                    _level = (ServerLevel) world;
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 2.0F, (float) (0.5 + Math.random()));
                    } else {
                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 2.0F, (float) (0.5 + Math.random()), false);
                    }
                }

                if (Math.random() < 0.5 && world instanceof ServerLevel) {
                    _level = (ServerLevel) world;
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                    } else {
                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                    }
                }

                entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                entity.getPersistentData().putBoolean("Stop", false);
                entity.getPersistentData().putDouble("cnt1", 0.0);
                entity.getPersistentData().putDouble("cnt2", 0.0);
                NUM1 = -200.0 - Math.random();
                if ((!logic_attack || !entity.isAlive()) && world instanceof ServerLevel) {
                    _level = (ServerLevel) world;
                    Entity entityToSpawn = ((EntityType) JujutsucraftModEntities.CROW.get()).spawn(_level, BlockPos.containing(entity.getX(), NUM1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    }
                }

                reChange = false;
                Vec3 _center = new Vec3(entity.getX(), NUM1, entity.getZ());
                List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> {
                    return true;
                }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                    return _entcnd.distanceToSqr(_center);
                })).toList();
                Iterator var45 = _entfound.iterator();

                while (var45.hasNext()) {
                    Entity entityiterator = (Entity) var45.next();
                    if (entityiterator instanceof CrowEntity && entityiterator.isAlive()) {
                        Entity _ent = entityiterator;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill @s");
                        }

                        if (!entityiterator.level().isClientSide()) {
                            entityiterator.discard();
                        }

                        reChange = true;
                        break;
                    }
                }

                if (reChange && entity instanceof PureLoveCannonEntity _datEntSetL) {
                    _datEntSetL.getEntityData().set(PureLoveCannonEntity.DATA_move, true);
                }

            }

        }
    }
}
