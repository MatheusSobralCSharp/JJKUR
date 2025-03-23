package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.entity.FlameArrowEntity;
import net.mcreator.jujutsucraft.entity.JogoEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.procedures.*;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import software.bernie.geckolib.animatable.GeoEntity;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Mixin(value = OpenProcedure.class, priority = -10000)
public abstract class OpenProcedureMixin {
    /**
     * @author Satushi
     * @reason Changes Black Flash Entity Particles
     */
    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            boolean rotate = false;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double HP = 0.0;
            double yaw = 0.0;
            double pitch = 0.0;
            double CNT6 = 0.0;
            double distance = 0.0;
            double rad1 = 0.0;
            double width = 0.0;
            double x_power = 0.0;
            double y_power = 0.0;
            double z_power = 0.0;
            double speed = 0.0;
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            LivingEntity _livEnt;
            if (entity instanceof LivingEntity) {
                _livEnt = (LivingEntity) entity;
                if (!_livEnt.level().isClientSide()) {
                    _livEnt.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
                }
            }


            LivingEntity var10000;
            Mob _mobEnt;
            if (entity instanceof Mob) {
                _mobEnt = (Mob) entity;
                var10000 = _mobEnt.getTarget();
            } else {
                var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                double var52 = var10000.getX();
                LivingEntity var10001;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10001 = _mobEnt.getTarget();
                } else {
                    var10001 = null;
                }

                double var53 = var10001.getY();
                LivingEntity var10002;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10002 = _mobEnt.getTarget();
                } else {
                    var10002 = null;
                }

                var53 += (double) var10002.getBbHeight() * 0.5;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10002 = _mobEnt.getTarget();
                } else {
                    var10002 = null;
                }

                RotateEntityProcedure.execute(var52, var53, var10002.getZ(), entity);
            }

            entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
            entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
            entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
            yaw = Math.toRadians(entity.getYRot() + 90.0F);
            pitch = Math.toRadians(entity.getXRot());
            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (double) (1.0F + entity.getBbWidth());
            y_pos = entity.getY() + (double) entity.getBbHeight() * 0.6 + Math.sin(pitch) * -1.0 * (double) (1.0F + entity.getBbWidth());
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (double) (1.0F + entity.getBbWidth());
            entity.getPersistentData().putDouble("x_pos", x_pos);
            entity.getPersistentData().putDouble("y_pos", y_pos);
            entity.getPersistentData().putDouble("z_pos", z_pos);
            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
                if (entity instanceof LivingEntity) {
                    _livEnt = (LivingEntity) entity;
                    _livEnt.swing(InteractionHand.MAIN_HAND, true);
                }

                if (entity instanceof GeoEntity) {
                    if (!(entity instanceof LivingEntity _livEnt14 && _livEnt14.hasEffect(JujutsucraftaddonModMobEffects.FUGA.get()))) {
                        if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.FUGA.get(), 240, 1, false, false));
                        } else {
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.FUGA.get(), 100, 1, false, false));
                        }
                    }
                }

                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x_pos, y_pos, z_pos), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                    } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                    }
                }

                int var55;
                label258:
                {
                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity) entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                            var55 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                            break label258;
                        }
                    }

                    var55 = 0;
                }

                HP = 200 + var55 * 20 * 10;
                if (world instanceof ServerLevel _level) {
                    Commands var54 = _level.getServer().getCommands();
                    CommandSourceStack var56 = (new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput();
                    long var57 = Math.round(HP);
                    var54.performPrefixedCommand(var56, "summon jujutsucraft:flame_arrow ~ ~ ~ {Health:" + var57 + "f,Attributes:[{Name:generic.max_health,Base:" + Math.round(HP) + "}],Rotation:[" + entity.getYRot() + "F," + entity.getXRot() + "F]}");
                }

                Vec3 _center = new Vec3(x_pos, y_pos, z_pos);
                List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> {
                    return true;
                }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                    return _entcnd.distanceToSqr(_center);
                })).toList();
                Iterator var47 = _entfound.iterator();

                while (var47.hasNext()) {
                    Entity entityiterator = (Entity) var47.next();
                    if (entityiterator instanceof FlameArrowEntity && entityiterator.getPersistentData().getDouble("NameRanged_ranged") == 0.0) {
                        SetRangedAmmoProcedure.execute(entity, entityiterator);
                        Entity _ent = entityiterator;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "data merge entity @s {NoAI:1b}");
                        }
                        break;
                    }
                }
            } else {
                if (entity instanceof LivingEntity) {
                    _livEnt = (LivingEntity) entity;
                    if (!_livEnt.level().isClientSide()) {
                        _livEnt.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int) entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
                    }
                }

                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                if (var10000 instanceof LivingEntity) {
                    if (entity instanceof LivingEntity _livEnt3 && !_livEnt3.hasEffect(JujutsucraftaddonModMobEffects.FUGA.get())) {
                        entity.getPersistentData().putBoolean("PRESS_Z", false);
                    }
                    if (GetDistanceNearestEnemyProcedure.execute(world, x, y, z, entity) > 8.0) {
                        label274:
                        {
                            if (entity instanceof Mob) {
                                _mobEnt = (Mob) entity;
                                var10000 = _mobEnt.getTarget();
                            } else {
                                var10000 = null;
                            }

                            if (var10000.getPersistentData().getDouble("skill") != 0.0) {
                                label275:
                                {
                                    if (entity instanceof Mob) {
                                        _mobEnt = (Mob) entity;
                                        var10000 = _mobEnt.getTarget();
                                    } else {
                                        var10000 = null;
                                    }

                                    if (var10000.getPersistentData().getDouble("skill") != 0.0) {
                                        if (entity instanceof Mob) {
                                            _mobEnt = (Mob) entity;
                                            var10000 = _mobEnt.getTarget();
                                        } else {
                                            var10000 = null;
                                        }

                                        if (var10000.getPersistentData().getBoolean("attack")) {
                                            break label275;
                                        }
                                    }

                                    if (entity instanceof Mob) {
                                        _mobEnt = (Mob) entity;
                                        var10000 = _mobEnt.getTarget();
                                    } else {
                                        var10000 = null;
                                    }

                                    if (var10000.getPersistentData().getDouble("Damage") != 0.0) {
                                        break label274;
                                    }
                                }
                            }

                            entity.getPersistentData().putBoolean("PRESS_Z", true);
                        }
                    }

                    if (entity instanceof Mob) {
                        _mobEnt = (Mob) entity;
                        var10000 = _mobEnt.getTarget();
                    } else {
                        var10000 = null;
                    }

                    if (var10000 instanceof JogoEntity && entity.getPersistentData().getDouble("cnt6") < 5.0) {
                        entity.getPersistentData().putBoolean("PRESS_Z", true);
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob) entity;
                            var10000 = _mobEnt.getTarget();
                        } else {
                            var10000 = null;
                        }

                        if (var10000.getPersistentData().getDouble("skill") == 405.0) {
                            label276:
                            {
                                if (entity instanceof Mob) {
                                    _mobEnt = (Mob) entity;
                                    var10000 = _mobEnt.getTarget();
                                } else {
                                    var10000 = null;
                                }

                                if (!(var10000.getPersistentData().getDouble("cnt6") >= 5.0)) {
                                    if (entity instanceof Mob) {
                                        _mobEnt = (Mob) entity;
                                        var10000 = _mobEnt.getTarget();
                                    } else {
                                        var10000 = null;
                                    }

                                    if (var10000.getPersistentData().getBoolean("PRESS_Z")) {
                                        break label276;
                                    }
                                }
                                if (entity instanceof LivingEntity _livEnt3 && !_livEnt3.hasEffect(JujutsucraftaddonModMobEffects.FUGA.get())) {
                                    entity.getPersistentData().putBoolean("PRESS_Z", false);
                                }
                            }
                        }
                    }

                    if (entity instanceof Mob) {
                        _mobEnt = (Mob) entity;
                        var10000 = _mobEnt.getTarget();
                    } else {
                        var10000 = null;
                    }

                    if (var10000 instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity && entity.getPersistentData().getDouble("cnt6") < 5.0) {
                        entity.getPersistentData().putBoolean("PRESS_Z", true);
                    }
                    if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                        if (entity instanceof LivingEntity _livEnt3 && !_livEnt3.hasEffect(JujutsucraftaddonModMobEffects.FUGA.get())) {
                            entity.getPersistentData().putBoolean("PRESS_Z", false);
                        }
                    }
                }

                if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                    entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 30.0));
                    if (entity.getPersistentData().getDouble("cnt1") >= 30.0) {
                        entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
                        if ((entity instanceof LivingEntity _livEnt2 ? _livEnt2.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt2 ? _livEnt2.getMaxHealth() : -1) / 3) {
                            if (entity.getPersistentData().getDouble("cnt6") >= 30.0) {
                                entity.getPersistentData().putDouble("cnt6", 30.0);
                            }
                            {
                                final Vec3 _center = new Vec3(x, y, z);
                                List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                                for (Entity entityiterator : _entfound) {
                                    if ((entityiterator.getPersistentData().getString("OWNER_UUID")).equals(entity.getStringUUID())) {
                                        ((LivingEntity) entityiterator).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
                                                .setBaseValue((((LivingEntity) entityiterator).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() + 0.1));
                                    }
                                }
                            }
                        } else {
                            if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                                entity.getPersistentData().putDouble("cnt6", 5.0);
                            }
                        }
                    }
                }

                if (entity.getPersistentData().getDouble("cnt1") > 30.0) {
                    CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
                    entity.getPersistentData().putDouble("Damage", 17.5 * CNT6);
                    entity.getPersistentData().putDouble("Range", 12.0 * CNT6);
                    entity.getPersistentData().putDouble("projectile_type", 1.0);
                    entity.getPersistentData().putDouble("knockback", 0.5);
                    entity.getPersistentData().putDouble("effect", 3.0);
                    RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                    entity.getPersistentData().putDouble("skill", 0.0);
                }
            }

            CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.2;
            distance = Math.min(entity.getPersistentData().getDouble("cnt1") * 0.5, 4.0) * CNT6;
            int index2;
            if (Math.random() < 0.2) {
                for (index2 = 0; index2 < 4; ++index2) {
                    entity.getPersistentData().putDouble("BlockRange", distance);
                    entity.getPersistentData().putDouble("BlockDamage", 5.0 * CNT6);
                    entity.getPersistentData().putBoolean("noParticle", true);
                    BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos + distance, z_pos, entity);
                    rad1 = Math.toRadians(720.0 * Math.random());
                    width = distance * (Math.random() * 0.5 + 0.5);
                    x_pos = entity.getX() + Math.cos(rad1) * width;
                    z_pos = entity.getZ() + Math.sin(rad1) * width;
                }
            }

            y_pos = entity.getY();

            ServerLevel _level;
            for (index2 = 0; index2 < 36; ++index2) {
                rad1 += Math.toRadians(20.0 * Math.random());
                x_pos = entity.getX() + Math.cos(rad1) * distance;
                z_pos = entity.getZ() + Math.sin(rad1) * distance;
                if (Math.random() < 0.1 * CNT6) {
                    if (world instanceof ServerLevel) {
                        _level = (ServerLevel) world;
                        _level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, 1, distance * 0.05, distance * 0.05, distance * 0.05, speed);
                    }

                    if (Math.random() < 0.1 && entity.getPersistentData().getDouble("cnt6") > 2.5 && world instanceof ServerLevel) {
                        _level = (ServerLevel) world;
                        _level.sendParticles(JujutsucraftModParticleTypes.PARTICLE_MAGMA.get(), x_pos, y_pos, z_pos, 1, distance * 0.5, distance * 0.05, distance * 0.5, 0.05);
                    }
                }

                if (Math.random() < 0.005 * CNT6 && world instanceof ServerLevel) {
                    _level = (ServerLevel) world;
                    _level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x_pos, y_pos, z_pos, 1, distance * 0.05, distance * 0.05, distance * 0.05, speed);
                }

                if (Math.random() < 0.05 * CNT6 && world instanceof ServerLevel) {
                    _level = (ServerLevel) world;
                    _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, 1, distance * 0.05, distance * 0.05, distance * 0.05, speed);
                }
            }

            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (double) (1.0F + entity.getBbWidth());
            y_pos = entity.getY() + (double) entity.getBbHeight() * 0.6 + Math.sin(pitch) * -1.0 * (double) (1.0F + entity.getBbWidth());
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (double) (1.0F + entity.getBbWidth());
            x_power = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (0.9 + (double) entity.getBbWidth()) - x_pos;
            y_power = entity.getY() + (double) entity.getBbHeight() * 0.6 + Math.sin(pitch) * -1.0 * (0.9 + (double) entity.getBbWidth()) - y_pos;
            z_power = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (0.9 + (double) entity.getBbWidth()) - z_pos;
            distance = 0.0;

            for (index2 = 0; index2 < Math.round((1.0F + entity.getBbWidth()) * 3.0F * 10.0F); ++index2) {
                if (Math.random() < 0.05 && world instanceof ServerLevel) {
                    _level = (ServerLevel) world;
                    _level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, 1, distance, distance, distance, distance);
                }

                if (Math.random() < 0.0025 && world instanceof ServerLevel) {
                    _level = (ServerLevel) world;
                    _level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x_pos, y_pos, z_pos, 1, distance, distance, distance, distance);
                }

                x_pos += x_power;
                y_pos += y_power;
                z_pos += z_power;
                distance += 0.001;
            }


            PlayAnimationProcedure.execute(world, entity);
        }
    }
}
