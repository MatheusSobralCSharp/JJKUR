package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import com.jujutsu.jujutsucraftaddon.procedures.PlayGojoRed2Procedure;
import net.mcreator.jujutsucraft.entity.RedEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

@Mixin(value = TechniqueRedProcedure.class, priority = -10000)
public abstract class RedTechniqueMixin {
    public RedTechniqueMixin() {
    }

    /**
     * @author Satushi
     * @reason Changing Red
     */
    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();
        if (entity != null) {
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double HP = 0.0;
            double yaw = 0.0;
            double pitch = 0.0;
            boolean rotate = false;
            boolean logic_a = false;
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            LivingEntity var10000;
            Mob _mobEnt;
            if (entity instanceof Mob) {
                _mobEnt = (Mob)entity;
                var10000 = _mobEnt.getTarget();
            } else {
                var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                x_pos = var10000.getX();
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                double var29 = var10000.getY();
                LivingEntity var10001;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10001 = _mobEnt.getTarget();
                } else {
                    var10001 = null;
                }

                y_pos = var29 + (double)var10001.getBbHeight() * 0.5;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                z_pos = var10000.getZ();
                RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            }

            entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
            entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
            entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
            yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
            pitch = Math.toRadians((double)entity.getXRot());
            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (double)(1.0F + entity.getBbWidth());
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.9 + Math.sin(pitch) * -1.0 * (double)(1.0F + entity.getBbWidth());
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (double)(1.0F + entity.getBbWidth());
            LivingEntity _entity;
            Level _level;
            if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
                entity.getPersistentData().putDouble("cnt2", 1.0);
                if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity)entity;
                    if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
                    }
                }

                if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity)entity;
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                int var28;
                label220: {
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        if (_entity.hasEffect(MobEffects.DAMAGE_BOOST)) {
                            var28 = _entity.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                            break label220;
                        }
                    }

                    var28 = 0;
                }

                HP = (double)(40 + var28 * 20);
                if (world instanceof ServerLevel _level1) {
                    Entity entityinstance = ((EntityType) JujutsucraftModEntities.RED.get()).create(_level1, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                    if (entityinstance != null) {
                        entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                        SetRangedAmmoProcedure.execute(entity, entityinstance);
                        Entity _ent = entityinstance;
                        _ent.setYRot(entity.getYRot());
                        _ent.setXRot(entity.getXRot());
                        _ent.setYBodyRot(_ent.getYRot());
                        _ent.setYHeadRot(_ent.getYRot());
                        _ent.yRotO = _ent.getYRot();
                        _ent.xRotO = _ent.getXRot();
                        if (_ent instanceof LivingEntity) {
                            _entity = (LivingEntity) _ent;
                            _entity.yBodyRotO = _entity.getYRot();
                            _entity.yHeadRotO = _entity.getYRot();
                        }
                        if (entityinstance instanceof LivingEntity) {
                            _entity = (LivingEntity)entityinstance;
                            if (_entity.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                                _entity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                            }
                        }

                        if (entityinstance instanceof LivingEntity) {
                            _entity = (LivingEntity)entityinstance;
                            _entity.setHealth((float)HP);
                        }

                        _level1.addFreshEntity(entityinstance);
                    }
                }

                if (world instanceof Level) {
                    _level = (Level)world;
                    if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:slow_motion_end")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                    } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:slow_motion_end")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                    }
                }
            }

            if (entity instanceof LivingEntity) {
                _entity = (LivingEntity)entity;
                if (!_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
                }
            }

            if (entity instanceof LivingEntity) {
                _entity = (LivingEntity)entity;
                if (!_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 4, false, false));
                }
            }

            if (!(entity instanceof Player) && entity instanceof LivingEntity) {
                _entity = (LivingEntity)entity;
                if (!_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 15, 9, false, false));
                }
            }

            logic_a = false;
            Vec3 _center = new Vec3(x_pos, y_pos, z_pos);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(16.0), (e) -> {
                return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                return _entcnd.distanceToSqr(_center);
            })).toList();
            Iterator var40 = _entfound.iterator();

            while(var40.hasNext()) {
                Entity entityiterator = (Entity)var40.next();
                if (entityiterator instanceof RedEntity && entity.getPersistentData().getDouble("NameRanged") == entityiterator.getPersistentData().getDouble("NameRanged_ranged")) {
                    logic_a = true;
                    entityiterator.getPersistentData().putDouble("cnt6", Math.max(entityiterator.getPersistentData().getDouble("cnt6"), entity.getPersistentData().getDouble("cnt6")));
                    entityiterator.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), entity.getDeltaMovement().y(), entity.getDeltaMovement().z()));
                    Entity _ent = entityiterator;
                    _ent.teleportTo(x_pos, y_pos, z_pos);
                    if (_ent instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)_ent;
                        _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, _ent.getYRot(), _ent.getXRot());
                    }
                    break;
                }
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 20.0 && logic_a) {
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                if (var10000 instanceof LivingEntity) {
                    entity.getPersistentData().putBoolean("PRESS_Z", false);
                    if (GetDistanceNearestEnemyProcedure.execute(world, x, y, z, entity) > 8.0) {
                        label237: {
                            if (entity instanceof Mob) {
                                _mobEnt = (Mob)entity;
                                var10000 = _mobEnt.getTarget();
                            } else {
                                var10000 = null;
                            }

                            if (var10000.getPersistentData().getDouble("skill") != 0.0) {
                                label238: {
                                    if (entity instanceof Mob) {
                                        _mobEnt = (Mob)entity;
                                        var10000 = _mobEnt.getTarget();
                                    } else {
                                        var10000 = null;
                                    }

                                    if (var10000.getPersistentData().getDouble("skill") != 0.0) {
                                        if (entity instanceof Mob) {
                                            _mobEnt = (Mob)entity;
                                            var10000 = _mobEnt.getTarget();
                                        } else {
                                            var10000 = null;
                                        }

                                        if (var10000.getPersistentData().getBoolean("attack")) {
                                            break label238;
                                        }
                                    }

                                    if (entity instanceof Mob) {
                                        _mobEnt = (Mob)entity;
                                        var10000 = _mobEnt.getTarget();
                                    } else {
                                        var10000 = null;
                                    }

                                    if (var10000.getPersistentData().getDouble("Damage") != 0.0) {
                                        break label237;
                                    }
                                }
                            }

                            entity.getPersistentData().putBoolean("PRESS_Z", true);
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt73 = (LivingEntity)entity;
                        if (_livEnt73.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                            entity.getPersistentData().putBoolean("PRESS_Z", false);
                        }
                    }

                    if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                        entity.getPersistentData().putBoolean("PRESS_Z", false);
                    }
                }

                if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                    entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 20.0));
                    if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                        if (world instanceof ServerLevel _level2) {
                            _level2.sendParticles(ParticleTypes.ENCHANTED_HIT, x_pos, y_pos, z_pos, (int)(entity.getPersistentData().getDouble("cnt6") + 1.0), 0.25, 0.25, 0.25, 0.5);
                        }
                    } else if (world instanceof ServerLevel _level2) {
                        _level2.sendParticles(ParticleTypes.CRIT, x_pos, y_pos, z_pos, (int)(entity.getPersistentData().getDouble("cnt6") + 1.0), 0.25, 0.25, 0.25, 0.5);
                    }

                    if (entity.getPersistentData().getDouble("cnt6") < 3.0) {
                        entity.getPersistentData().putDouble("cnt5", entity.getPersistentData().getDouble("cnt5") + 1.0);
                        if (entity.getPersistentData().getDouble("cnt5") > 20.0) {
                            entity.getPersistentData().putDouble("cnt5", 0.0);
                            entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 1.0);
                            if (entity instanceof Player) {
                                Player _player = (Player)entity;
                                if (!_player.level().isClientSide()) {
                                    CompoundTag var30 = entity.getPersistentData();
                                    _player.displayClientMessage(Component.literal("§l\"" + Component.translatable("chant.jujutsucraft.red" + Math.round(var30.getDouble("cnt6"))).getString() + "\""), false);
                                }
                            }

                            double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 25.0;
                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                capability.PlayerCursePowerChange = _setval;
                                capability.syncPlayerVariables(entity);
                            });
                        }
                    } else if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
                        entity.getPersistentData().putDouble("cnt6", 5.0);
                        if (world instanceof Level) {
                            _level = (Level)world;
                            if (!_level.isClientSide()) {
                                _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, Level.ExplosionInteraction.NONE);
                            }
                        }

                        if (world instanceof ServerLevel _level2) {
                            _level2.sendParticles(ParticleTypes.ENCHANTED_HIT, x_pos, y_pos, z_pos, 20, 0.25, 0.25, 0.25, 1.5);
                        }

                        if (world instanceof Level) {
                            _level = (Level)world;
                            if (!_level.isClientSide()) {
                                _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                            } else {
                                _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                            }
                        }
                    }
                }
            }

            if (entity.getPersistentData().getDouble("cnt1") > 20.0) {
                entity.getPersistentData().putDouble("skill", 0.0);
            }

            if (entity.getPersistentData().getDouble("cnt1") > 20.0) {
                entity.getPersistentData().putDouble("skill", 0.0);
            }
            if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("Tatical Mode")) {
                PlayGojoRed2Procedure.execute(world, x, y, z, entity);
            } else {
                PlayAnimationProcedure.execute(world, entity);
            }
        }
    }
}
