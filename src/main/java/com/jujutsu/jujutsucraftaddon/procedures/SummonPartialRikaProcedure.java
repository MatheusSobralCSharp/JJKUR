package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.PartialRikaEntity;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaCullingGameEntity;
import net.mcreator.jujutsucraft.entity.Rika2Entity;
import net.mcreator.jujutsucraft.entity.RikaEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;

public class SummonPartialRikaProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity != null) {
            double dis = 0.0;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double yaw = 0.0;
            double picth = 0.0;
            double yaw2 = 0.0;
            double pitch2 = 0.0;
            double HP = 0.0;
            boolean logic_a = false;
            boolean pitch = false;
            boolean summon = false;
            boolean noControl = false;
            Entity entity_rika = null;
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            boolean var10000;
            ServerPlayer _serverPlayer;
            int var45;
            if (entity instanceof Player) {
                label360:
                {
                    if (entity instanceof ServerPlayer) {
                        _serverPlayer = (ServerPlayer) entity;
                        if (_serverPlayer.level() instanceof ServerLevel && _serverPlayer.getAdvancements().getOrStartProgress(_serverPlayer.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:skill_rika_control"))).isDone()) {
                            var10000 = false;
                            break label360;
                        }
                    }

                    var10000 = true;
                }
            } else {
                label355:
                {
                    if (!(entity instanceof Player)) {
                        label352:
                        {
                            if (entity instanceof LivingEntity _livEnt) {
                                if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var45 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label352;
                                }
                            }

                            var45 = 0;
                        }

                        if (var45 < 10) {
                            var10000 = true;
                            break label355;
                        }
                    }

                    var10000 = false;
                }
            }

            noControl = var10000;
            LivingEntity _entity;
            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
                Mob _mobEnt;
                LivingEntity var47;
                if (LocatePartialProcedure.execute(world, entity)) {
                    entity.getPersistentData().putDouble("cnt4", 1.0);
                } else {
                    entity.getPersistentData().putDouble("cnt4", 0.0);
                    entity.getPersistentData().putDouble("cnt2", 1.0);
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob) entity;
                        var47 = _mobEnt.getTarget();
                    } else {
                        var47 = null;
                    }

                    if (var47 instanceof LivingEntity) {
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob) entity;
                            var47 = _mobEnt.getTarget();
                        } else {
                            var47 = null;
                        }

                        label336:
                        {
                            _entity = var47;
                            if (_entity instanceof LivingEntity) {
                                LivingEntity _livEnt = _entity;
                                if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var45 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label336;
                                }
                            }

                            var45 = 0;
                        }

                        int var10001;
                        double var51;
                        label331:
                        {
                            var51 = var45;
                            if (entity instanceof LivingEntity _livEnt) {
                                if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label331;
                                }
                            }

                            var10001 = 0;
                        }

                        if (var51 <= (double) var10001 * 0.5) {
                            entity.getPersistentData().putDouble("cnt2", 0.0);
                        }
                    }

                    if (noControl || entity.isShiftKeyDown()) {
                        entity.getPersistentData().putDouble("cnt2", 0.0);
                    }
                }

                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var47 = _mobEnt.getTarget();
                } else {
                    var47 = null;
                }

                if (var47 instanceof LivingEntity) {
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob) entity;
                        var47 = _mobEnt.getTarget();
                    } else {
                        var47 = null;
                    }

                    Level var54 = var47.level();
                    ClipContext var46;
                    LivingEntity var10003;
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob) entity;
                        var10003 = _mobEnt.getTarget();
                    } else {
                        var10003 = null;
                    }

                    Vec3 var49 = var10003.getEyePosition(1.0F);
                    LivingEntity var10004;
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob) entity;
                        var10004 = _mobEnt.getTarget();
                    } else {
                        var10004 = null;
                    }

                    Vec3 var50 = var10004.getEyePosition(1.0F);
                    LivingEntity var10005;
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob) entity;
                        var10005 = _mobEnt.getTarget();
                    } else {
                        var10005 = null;
                    }

                    var50 = var50.add(var10005.getViewVector(1.0F).scale(-5.0));
                    ClipContext.Block var52 = ClipContext.Block.OUTLINE;
                    ClipContext.Fluid var10006 = ClipContext.Fluid.NONE;
                    LivingEntity var10007;
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob) entity;
                        var10007 = _mobEnt.getTarget();
                    } else {
                        var10007 = null;
                    }

                    var46 = new ClipContext(var49, var50, var52, var10006, var10007);
                    x_pos = var54.clip(var46).getBlockPos().getX();
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob) entity;
                        var47 = _mobEnt.getTarget();
                    } else {
                        var47 = null;
                    }

                    var54 = var47.level();
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob) entity;
                        var10003 = _mobEnt.getTarget();
                    } else {
                        var10003 = null;
                    }

                    var49 = var10003.getEyePosition(1.0F);
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob) entity;
                        var10004 = _mobEnt.getTarget();
                    } else {
                        var10004 = null;
                    }

                    var50 = var10004.getEyePosition(1.0F);
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob) entity;
                        var10005 = _mobEnt.getTarget();
                    } else {
                        var10005 = null;
                    }

                    var50 = var50.add(var10005.getViewVector(1.0F).scale(-5.0));
                    var52 = ClipContext.Block.OUTLINE;
                    var10006 = ClipContext.Fluid.NONE;
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob) entity;
                        var10007 = _mobEnt.getTarget();
                    } else {
                        var10007 = null;
                    }

                    var46 = new ClipContext(var49, var50, var52, var10006, var10007);
                    y_pos = var54.clip(var46).getBlockPos().getY();
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob) entity;
                        var47 = _mobEnt.getTarget();
                    } else {
                        var47 = null;
                    }

                    var54 = var47.level();
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob) entity;
                        var10003 = _mobEnt.getTarget();
                    } else {
                        var10003 = null;
                    }

                    var49 = var10003.getEyePosition(1.0F);
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob) entity;
                        var10004 = _mobEnt.getTarget();
                    } else {
                        var10004 = null;
                    }

                    var50 = var10004.getEyePosition(1.0F);
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob) entity;
                        var10005 = _mobEnt.getTarget();
                    } else {
                        var10005 = null;
                    }

                    var50 = var50.add(var10005.getViewVector(1.0F).scale(-5.0));
                    var52 = ClipContext.Block.OUTLINE;
                    var10006 = ClipContext.Fluid.NONE;
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob) entity;
                        var10007 = _mobEnt.getTarget();
                    } else {
                        var10007 = null;
                    }

                    var46 = new ClipContext(var49, var50, var52, var10006, var10007);
                    z_pos = var54.clip(var46).getBlockPos().getZ();
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob) entity;
                        var47 = _mobEnt.getTarget();
                    } else {
                        var47 = null;
                    }

                    yaw = var47.getYRot();
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob) entity;
                        var47 = _mobEnt.getTarget();
                    } else {
                        var47 = null;
                    }

                    picth = var47.getXRot();
                } else {
                    x_pos = entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(32.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
                    y_pos = entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(32.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
                    z_pos = entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(32.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
                    yaw = entity.getYRot() + 180.0F;
                    picth = entity.getXRot() * -1.0F;
                }

                entity.getPersistentData().putDouble("x_pos", x_pos);
                entity.getPersistentData().putDouble("y_pos", y_pos);
                entity.getPersistentData().putDouble("z_pos", z_pos);
                entity.getPersistentData().putDouble("yaw", entity.getYRot());
                entity.getPersistentData().putDouble("pitch", entity.getXRot());
            }

            summon = entity.getPersistentData().getDouble("cnt2") == 1.0;
            ServerLevel _level;
            if (entity.getPersistentData().getDouble("cnt4") == 1.0) {
                if (entity.getPersistentData().getDouble("friend_num") != 0.0) {
                    entity_rika = (new BiFunction<LevelAccessor, String, Entity>() {
                        public Entity apply(LevelAccessor levelAccessor, String uuid) {
                            if (levelAccessor instanceof ServerLevel serverLevel) {
                                try {
                                    return serverLevel.getEntity(UUID.fromString(uuid));
                                } catch (Exception var5) {
                                }
                            }

                            return null;
                        }
                    }).apply(world, entity.getPersistentData().getString("RIKA_UUID"));
                    if ((entity_rika instanceof RikaEntity || entity_rika instanceof Rika2Entity || entity_rika instanceof PartialRikaEntity) && entity.getPersistentData().getDouble("friend_num") == entity_rika.getPersistentData().getDouble("friend_num")) {
                        label370:
                        {
                            if (entity instanceof Player) {
                                if (!entity.isShiftKeyDown()) {
                                    break label370;
                                }
                            } else if (!(Math.random() < 0.5)) {
                                break label370;
                            }

                            if (world instanceof ServerLevel) {
                                _level = (ServerLevel) world;
                                _level.sendParticles(ParticleTypes.SQUID_INK, entity_rika.getX(), entity_rika.getY(), entity_rika.getZ(), 50, 1.0, 1.0, 1.0, 0.0);
                            }

                            entity_rika.setYRot((float) yaw);
                            entity_rika.setXRot((float) picth);
                            entity_rika.setYBodyRot(entity_rika.getYRot());
                            entity_rika.setYHeadRot(entity_rika.getYRot());
                            entity_rika.yRotO = entity_rika.getYRot();
                            entity_rika.xRotO = entity_rika.getXRot();
                            if (entity_rika instanceof LivingEntity _entity2) {
                                _entity2.yBodyRotO = _entity2.getYRot();
                                _entity2.yHeadRotO = _entity2.getYRot();
                            }

                            entity_rika.teleportTo(x_pos, y_pos, z_pos);
                            if (entity_rika instanceof ServerPlayer) {
                                _serverPlayer = (ServerPlayer) entity_rika;
                                _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entity_rika.getYRot(), entity_rika.getXRot());
                            }

                            if (world instanceof ServerLevel) {
                                _level = (ServerLevel) world;
                                _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 50, 1.0, 1.0, 1.0, 0.25);
                            }
                        }

                        entity_rika.getPersistentData().putBoolean("flag_attack", true);
                    }
                }

                entity.getPersistentData().putDouble("skill", 0.0);
            } else {
                Player _player;
                if (summon) {
                    if (entity instanceof Player) {
                        _player = (Player) entity;
                        if (!_player.level().isClientSide()) {
                            _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.technique.rika1").getString()), true);
                        }
                    }

                    if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
                        entity.getPersistentData().putDouble("x_pos", entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-6.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX());
                        entity.getPersistentData().putDouble("y_pos", (double) entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-6.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + Math.random() * 0.1);
                        entity.getPersistentData().putDouble("z_pos", entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-6.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ());
                        entity.getPersistentData().putDouble("yaw", entity.getYRot());
                        entity.getPersistentData().putDouble("pitch", 0.0);
                    }
                } else {
                    if (entity instanceof Player) {
                        _player = (Player) entity;
                        if (!_player.level().isClientSide()) {
                            _player.displayClientMessage(Component.literal(noControl ? Component.translatable("jujutsu.technique.rika4").getString() : Component.translatable("jujutsu.technique.rika3").getString()), true);
                        }
                    }

                    entity.getPersistentData().putDouble("cnt1", Math.max(entity.getPersistentData().getDouble("cnt1"), 5.0));
                }

                x_pos = entity.getPersistentData().getDouble("x_pos");
                y_pos = entity.getPersistentData().getDouble("y_pos");
                z_pos = entity.getPersistentData().getDouble("z_pos");
                yaw = entity.getPersistentData().getDouble("yaw");
                picth = entity.getPersistentData().getDouble("pitch");
                if (entity.getPersistentData().getDouble("cnt1") < 5.0) {
                    if (world instanceof ServerLevel) {
                        _level = (ServerLevel) world;
                        _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 25, 1.0, 1.0, 1.0, 0.25);
                    }
                } else {
                    if (entity.getPersistentData().getDouble("cnt1") == 5.0) {
                        if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
                            entity.getPersistentData().putDouble("friend_num", Math.random());
                        }

                        label293:
                        {
                            Entity entityToSpawn;
                            label292:
                            {
                                if (entity instanceof Player) {
                                    if (!(entity instanceof ServerPlayer _plr90)) {
                                        break label292;
                                    }

                                    if (!(_plr90.level() instanceof ServerLevel) || !_plr90.getAdvancements().getOrStartProgress(_plr90.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:skill_curseis_lifted"))).isDone()) {
                                        break label292;
                                    }
                                } else if (!(entity instanceof OkkotsuYutaCullingGameEntity)) {
                                    break label292;
                                }

                                if (world instanceof ServerLevel) {
                                    _level = (ServerLevel) world;
                                    entityToSpawn = ((EntityType) JujutsucraftaddonModEntities.PARTIAL_RIKA_ENTITY.get()).spawn(_level, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED);
                                    if (entityToSpawn != null) {
                                        entityToSpawn.setYRot((float) yaw);
                                        entityToSpawn.setYBodyRot((float) yaw);
                                        entityToSpawn.setYHeadRot((float) yaw);
                                        entityToSpawn.setXRot((float) picth);
                                        if (entityToSpawn instanceof LivingEntity livingEntity) {
                                            MobEffectInstance effectInstance = new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 200, 1); // Regeneration for 200 ticks, level 2
                                            livingEntity.addEffect(effectInstance);
                                        }
                                    }
                                }
                                break label293;
                            }

                            if (world instanceof ServerLevel) {
                                _level = (ServerLevel) world;
                                entityToSpawn = ((EntityType) JujutsucraftaddonModEntities.PARTIAL_RIKA_ENTITY.get()).spawn(_level, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED);
                                if (entityToSpawn != null) {
                                    entityToSpawn.setYRot((float) yaw);
                                    entityToSpawn.setYBodyRot((float) yaw);
                                    entityToSpawn.setYHeadRot((float) yaw);
                                    entityToSpawn.setXRot((float) picth);
                                    if (entityToSpawn instanceof LivingEntity livingEntity) {
                                        MobEffectInstance effectInstance = new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 120, 1); // Regeneration for 200 ticks, level 2
                                        livingEntity.addEffect(effectInstance);
                                    }
                                }
                            }
                        }

                        Vec3 _center = new Vec3(x_pos, y_pos, z_pos);
                        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> {
                            return true;
                        }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                            return _entcnd.distanceToSqr(_center);
                        })).toList();
                        Iterator var37 = _entfound.iterator();

                        label280:
                        while (true) {
                            Entity entityiterator;
                            do {
                                if (!var37.hasNext()) {
                                    break label280;
                                }

                                entityiterator = (Entity) var37.next();
                            } while (!(entityiterator instanceof RikaEntity) && !(entityiterator instanceof Rika2Entity) && !(entityiterator instanceof PartialRikaEntity));

                            if (entityiterator.getPersistentData().getDouble("friend_num") == 0.0) {
                                entity.getPersistentData().putString("RIKA_UUID", entityiterator.getStringUUID());
                                entityiterator.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                                entityiterator.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                                entityiterator.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                                if (entityiterator instanceof LivingEntity) {
                                    _entity = (LivingEntity) entityiterator;
                                    if (!_entity.level().isClientSide()) {
                                        MobEffectInstance var48;
                                        MobEffect var53;
                                        int var55;
                                        label267:
                                        {
                                            var53 = MobEffects.DAMAGE_BOOST;
                                            if (entity instanceof LivingEntity _livEnt) {
                                                if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                                    var55 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                                    break label267;
                                                }
                                            }

                                            var55 = 0;
                                        }

                                        var48 = new MobEffectInstance(var53, Integer.MAX_VALUE, Math.max(var55, 18), false, false);
                                        _entity.addEffect(var48);
                                    }
                                }

                                entityiterator.getPersistentData().putBoolean("JujutsuSorcerer", entity.getPersistentData().getBoolean("JujutsuSorcerer"));
                                entityiterator.getPersistentData().putBoolean("CurseUser", entity.getPersistentData().getBoolean("CurseUser"));
                                entityiterator.getPersistentData().putBoolean("Player", entity instanceof Player);
                                if (!summon) {
                                    entityiterator.getPersistentData().putDouble("skill", 11.0);
                                    dis = noControl ? 3.0 : 2.0;
                                    entityiterator.getPersistentData().putDouble("despawn_flag", dis);
                                }
                                break;
                            }
                        }

                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel) world;
                            _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 25, 1.0, 1.0, 1.0, 0.75);
                        }
                    } else if (entity.getPersistentData().getDouble("cnt1") < 10.0) {
                        if (summon) {
                            dis = (entity.getPersistentData().getDouble("cnt1") - 10.0) * 0.5;

                            for (int index0 = 0; index0 < 72; ++index0) {
                                yaw += Math.toRadians(10.0 * Math.random());
                                x_pos = entity.getPersistentData().getDouble("x_pos") + Math.sin(yaw) * dis;
                                y_pos = entity.getPersistentData().getDouble("y_pos");
                                z_pos = entity.getPersistentData().getDouble("z_pos") + Math.cos(yaw) * dis;
                                if (Math.random() < 0.5 && world instanceof ServerLevel) {
                                    _level = (ServerLevel) world;
                                    _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 1, 0.25, 0.25, 0.25, 0.25);
                                }
                            }
                        } else {
                            entity.getPersistentData().putDouble("skill", 0.0);
                        }
                    } else {
                        entity.getPersistentData().putDouble("skill", 0.0);
                    }
                }
            }

        }
    }
}
