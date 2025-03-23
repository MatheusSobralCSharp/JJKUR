package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraft.entity.BulletFlameProjectileEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = JogoFlame1Procedure.class, priority = -10000)
public abstract class JogoFlame1ProcedureMixin {
    /**
     * @author Satushi
     * @reason Changes in the Jogo Skills giving them a stronger buff
     */
    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            boolean logic_a = false;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double yaw = 0.0;
            double picth = 0.0;
            double damage = 0.0;
            double CNT6 = 0.0;
            double move_power = 0.0;
            double pitch_cal = 0.0;
            double yaw_cal = 0.0;
            double pitch = 0.0;
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            LivingEntity _entGetArmor;
            if (entity instanceof LivingEntity) {
                _entGetArmor = (LivingEntity) entity;
                if (!_entGetArmor.level().isClientSide()) {
                    _entGetArmor.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 5, false, false));
                }
            }

            yaw = Math.toRadians(entity.getYRot() + 90.0F);
            picth = Math.toRadians(entity.getXRot());
            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(picth) * (1.5 + (double) entity.getBbWidth());
            y_pos = entity.getY() + (double) entity.getBbHeight() * 0.75 + Math.sin(picth) * -1.0 * (1.5 + (double) entity.getBbWidth());
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(picth) * (1.5 + (double) entity.getBbWidth());
            LivingEntity var10000;
            Mob _mobEnt;
            Level _level;
            if (entity.getPersistentData().getDouble("cnt1") < 10.0) {
                if (entity instanceof LivingEntity) {
                    _entGetArmor = (LivingEntity) entity;
                    if (!_entGetArmor.level().isClientSide()) {
                        _entGetArmor.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int) entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
                    }
                }

                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                if (var10000 instanceof LivingEntity) {
                    entity.getPersistentData().putBoolean("PRESS_Z", false);
                    if (GetDistanceNearestEnemyProcedure.execute(world, x, y, z, entity) > 8.0) {
                        label227:
                        {
                            if (entity instanceof Mob) {
                                _mobEnt = (Mob) entity;
                                var10000 = _mobEnt.getTarget();
                            } else {
                                var10000 = null;
                            }

                            if (var10000.getPersistentData().getDouble("skill") != 0.0) {
                                label228:
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
                                            break label228;
                                        }
                                    }

                                    if (entity instanceof Mob) {
                                        _mobEnt = (Mob) entity;
                                        var10000 = _mobEnt.getTarget();
                                    } else {
                                        var10000 = null;
                                    }

                                    if (var10000.getPersistentData().getDouble("Damage") != 0.0) {
                                        break label227;
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

                    if (var10000.getPersistentData().getDouble("skill") == 107.0) {
                        entity.getPersistentData().putBoolean("PRESS_Z", true);
                    }

                    if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                        entity.getPersistentData().putBoolean("PRESS_Z", false);
                    }
                }

                if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                    entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 8.0));
                }

                if (entity.getPersistentData().getDouble("cnt1") >= 8.0) {
                    if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
                        entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
                        if (entity instanceof Player) {
                            double _setval = entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCursePowerChange - 2.0;
                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                                capability.PlayerCursePowerChange = _setval;
                                capability.syncPlayerVariables(entity);
                            });
                        }
                    } else {
                        entity.getPersistentData().putDouble("cnt6", 5.0);
                        if (entity.getPersistentData().getDouble("cnt7") == 0.0) {
                            entity.getPersistentData().putDouble("cnt7", 1.0);
                            if (world instanceof Level) {
                                _level = (Level) world;
                                if (!_level.isClientSide()) {
                                    _level.explode(null, x_pos, y_pos, z_pos, 0.0F, Level.ExplosionInteraction.NONE);
                                }
                            }
                        }
                    }

                    if (entity.getPersistentData().getDouble("cnt6") >= 5.0 && world instanceof ServerLevel) {
                        _level = (ServerLevel) world;
                        ((ServerLevel) _level).sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, 2, 0.1, 0.1, 0.1, 0.1);
                    }
                }
            }

            CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
            if (entity.getPersistentData().getDouble("cnt1") < 25.0 * CNT6 - 10.0) {
                ItemStack var37;
                if (!(entity instanceof Player)) {
                    if (entity instanceof LivingEntity) {
                        _entGetArmor = (LivingEntity) entity;
                        var37 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                    } else {
                        var37 = ItemStack.EMPTY;
                    }

                    var37.getOrCreateTag().putDouble("P_ANIME1", -4.0);
                    if (entity instanceof LivingEntity) {
                        _entGetArmor = (LivingEntity) entity;
                        var37 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                    } else {
                        var37 = ItemStack.EMPTY;
                    }

                    var37.getOrCreateTag().putDouble("P_ANIME2", 0.0);
                }
                
                if (entity instanceof LivingEntity _livingEntity50) {
                    if (_livingEntity50.getAttributes().hasAttribute((Attribute) JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity50.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-4.0);
                    }
                }

                PlayAnimationProcedure.execute(world, entity);
                if (entity instanceof Player) {
                    if (entity instanceof LivingEntity) {
                        _entGetArmor = (LivingEntity) entity;
                        var37 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                    } else {
                        var37 = ItemStack.EMPTY;
                    }

                    var37.getOrCreateTag().putDouble("P_ANIME1", -4.0);
                    if (entity instanceof LivingEntity) {
                        _entGetArmor = (LivingEntity) entity;
                        var37 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                    } else {
                        var37 = ItemStack.EMPTY;
                    }

                    var37.getOrCreateTag().putDouble("P_ANIME2", 0.0);
                }
            }

            if (entity.getPersistentData().getDouble("cnt1") < 10.0) {
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel) world;
                    ((ServerLevel) _level).sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, (int) (2.0 * CNT6), 0.1, 0.1, 0.1, 0.01 * CNT6);
                }

                if (world instanceof ServerLevel) {
                    _level = (ServerLevel) world;
                    ((ServerLevel) _level).sendParticles(ParticleTypes.DRAGON_BREATH, x_pos, y_pos, z_pos, (int) (2.0 * CNT6), 0.1, 0.1, 0.1, 0.01 * CNT6);
                }

                if (entity.getPersistentData().getDouble("cnt1") <= 8.0) {
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob) entity;
                        var10000 = _mobEnt.getTarget();
                    } else {
                        var10000 = null;
                    }

                    if (var10000 instanceof LivingEntity) {
                        CompoundTag var38 = entity.getPersistentData();
                        LivingEntity var10002;
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob) entity;
                            var10002 = _mobEnt.getTarget();
                        } else {
                            var10002 = null;
                        }

                        var38.putDouble("x_pos", var10002.getX());
                        var38 = entity.getPersistentData();
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob) entity;
                            var10002 = _mobEnt.getTarget();
                        } else {
                            var10002 = null;
                        }

                        double var36 = var10002.getY();
                        LivingEntity var10003;
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob) entity;
                            var10003 = _mobEnt.getTarget();
                        } else {
                            var10003 = null;
                        }

                        var38.putDouble("y_pos", var36 + (double) var10003.getBbHeight() * 0.8);
                        var38 = entity.getPersistentData();
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob) entity;
                            var10002 = _mobEnt.getTarget();
                        } else {
                            var10002 = null;
                        }

                        var38.putDouble("z_pos", var10002.getZ());
                    }
                }
            } else if (entity.getPersistentData().getDouble("cnt1") < 25.0 * CNT6) {
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                if (var10000 instanceof LivingEntity) {
                    RotateEntityProcedure.execute(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"), entity);
                }

                if (world instanceof Level) {
                    _level = (Level) world;
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                    } else {
                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                    }
                }

                if (world instanceof ServerLevel) {
                    _level = (ServerLevel) world;
                    ((ServerLevel) _level).sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, (int) (10.0 * CNT6), 0.1, 0.1, 0.1, 0.25 * CNT6);
                }

                entity.getPersistentData().putDouble("Damage", 1.5 * CNT6);
                DamageFixProcedure.execute(entity);
                damage = entity.getPersistentData().getDouble("Damage");
                yaw = entity.getYRot();
                picth = entity.getXRot();

                for (int index0 = 0; index0 < 4; ++index0) {
                    entity.setYRot((float) (yaw + (Math.random() - 0.5) * 6.0 * CNT6));
                    entity.setXRot((float) (picth + (Math.random() - 0.5) * 6.0 * CNT6));
                    entity.setYBodyRot(entity.getYRot());
                    entity.setYHeadRot(entity.getYRot());
                    entity.yRotO = entity.getYRot();
                    entity.xRotO = entity.getXRot();
                    if (entity instanceof LivingEntity _entity) {
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                    }

                    Level projectileLevel = entity.level();
                    if (!projectileLevel.isClientSide()) {
                        Projectile _entityToSpawn = ((new Object() {
                            public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                                AbstractArrow entityToSpawn = new BulletFlameProjectileEntity(JujutsucraftModEntities.BULLET_FLAME_PROJECTILE.get(), level);
                                entityToSpawn.setOwner(shooter);
                                entityToSpawn.setBaseDamage(damage);
                                entityToSpawn.setKnockback(knockback);
                                entityToSpawn.setSilent(true);
                                entityToSpawn.setPierceLevel(piercing);
                                entityToSpawn.setSecondsOnFire(100);
                                return entityToSpawn;
                            }
                        })).getArrow(projectileLevel, entity, (float) damage, 0, (byte) 100);
                        _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                        _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, (float) ((2.5 + Math.random() * 0.2) * CNT6), 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }
                }

                entity.setYRot((float) yaw);
                entity.setXRot((float) picth);
                entity.setYBodyRot(entity.getYRot());
                entity.setYHeadRot(entity.getYRot());
                entity.yRotO = entity.getYRot();
                entity.xRotO = entity.getXRot();
                if (entity instanceof LivingEntity _entity) {
                    _entity.yBodyRotO = _entity.getYRot();
                    _entity.yHeadRotO = _entity.getYRot();
                }

                entity.getPersistentData().putDouble("Damage", 15.0 * CNT6);
                entity.getPersistentData().putDouble("Range", 5.0 * CNT6 * ((world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DESTRUCTION_LEVEL))));
                entity.getPersistentData().putDouble("knockback", CNT6);
                entity.getPersistentData().putDouble("effect", 10.0);
                RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            } else if (entity.getPersistentData().getDouble("cnt1") > 25.0 * CNT6 + 10.0) {
                entity.getPersistentData().putDouble("skill", 0.0);
            }

        }
    }
}
