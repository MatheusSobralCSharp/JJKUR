package com.jujutsu.jujutsucraftaddon.mixins;


import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraft.entity.MeteorEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.procedures.BlockDestroyAllDirectionProcedure;
import net.mcreator.jujutsucraft.procedures.MaximumMeteorProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.SetRangedAmmoProcedure;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.item.ItemStack;
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

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Mixin(value = MaximumMeteorProcedure.class, priority = 3000)
public abstract class MaximumMeteorMixin {
    public MaximumMeteorMixin() {
    }

    /**
     * @author Sat
     * @reason Testing
     */
    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            ItemStack old_health = ItemStack.EMPTY;
            Entity entity_a = null;
            boolean logic_a = false;
            boolean pitch = false;
            boolean logic_b = false;
            boolean player = false;
            double dis = 0.0;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double yaw = 0.0;
            double picth = 0.0;
            double yaw2 = 0.0;
            double pitch2 = 0.0;
            double HP = 0.0;
            double num2 = 0.0;
            double num3 = 0.0;
            double num1 = 0.0;
            double x_power = 0.0;
            double y_power = 0.0;
            double z_power = 0.0;
            double xp2 = 0.0;
            double yp2 = 0.0;
            double zp2 = 0.0;
            double power_attenuation = 0.0;
            double x_knockback = 0.0;
            double CNT6 = 0.0;
            double rad = 0.0;
            double rad_now = 0.0;
            double z_knockback = 0.0;
            double y_knockback = 0.0;
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            entity.fallDistance = 0.0F;
            ServerLevel _level;
            int index1;
            Entity entityiterator;
            int index0;
            List _entfound;
            Vec3 _center;
            Iterator var75;
            if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
                if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
                    entity.getPersistentData().putDouble("cnt3", 1.0);
                    entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 3.0, entity.getDeltaMovement().z()));
                    if (world instanceof ServerLevel) {
                        _level = (ServerLevel) world;
                        _level.sendParticles(ParticleTypes.CLOUD, x, y, z, 20, 0.0, 0.0, 0.0, 1.0);
                    }

                    PlayAnimationProcedure.execute(world, entity);
                }

                if (entity.getDeltaMovement().y() < 0.1 || entity.getPersistentData().getDouble("cnt1") > 30.0) {
                    entity.getPersistentData().putDouble("cnt2", 1.0);
                    if (world instanceof Level _level2) {
                        if (!_level2.isClientSide()) {
                            _level2.playSound(null, BlockPos.containing(x_pos, y_pos, z_pos), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                        } else {
                            _level2.playLocalSound(x_pos, y_pos, z_pos, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                        }
                    }
                }

                entity.getPersistentData().putDouble("BlockRange", 12.0 * ((world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DESTRUCTION_LEVEL))));
                entity.getPersistentData().putDouble("BlockDamage", 8.0 * ((world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DESTRUCTION_LEVEL))));
                entity.getPersistentData().putBoolean("noParticle", true);
                BlockDestroyAllDirectionProcedure.execute(world, x, y + entity.getDeltaMovement().y(), z, entity);
                entity.getPersistentData().putDouble("BlockRange", 12.0 * ((world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DESTRUCTION_LEVEL))));
                entity.getPersistentData().putDouble("BlockDamage", 8.0 * ((world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DESTRUCTION_LEVEL))));
                entity.getPersistentData().putBoolean("noParticle", true);
                BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
                if (entity.getPersistentData().getDouble("cnt1") > 0.0) {
                    x_pos = entity.getPersistentData().getDouble("old_x");
                    y_pos = entity.getPersistentData().getDouble("old_y");
                    z_pos = entity.getPersistentData().getDouble("old_z");
                    x_power = x_pos - x;
                    y_power = y_pos - y;
                    z_power = z_pos - z;
                    Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
                    num1 = Math.toRadians(entity.getPersistentData().getDouble("cnt3"));
                    num2 = Math.min(8.0, entity.getPersistentData().getDouble("cnt1"));
                    dis = Math.min(1.5, entity.getPersistentData().getDouble("cnt1") / 15.0);

                    for (index0 = 0; index0 < 12; ++index0) {
                        x_pos += x_power / 12.0;
                        y_pos += y_power / 12.0;
                        z_pos += z_power / 12.0;

                        for (index1 = 0; index1 < 2; ++index1) {
                            logic_a = !logic_a;
                            if (logic_a) {
                                xp2 = x_pos + Math.sin(num1) * num2;
                                yp2 = y_pos;
                                zp2 = z_pos + Math.cos(num1) * num2;
                            } else {
                                xp2 = x_pos - Math.sin(num1) * num2;
                                yp2 = y_pos;
                                zp2 = z_pos - Math.cos(num1) * num2;
                            }

                            if (world instanceof ServerLevel) {
                                _level = (ServerLevel) world;
                                _level.sendParticles(ParticleTypes.FLAME, xp2, yp2, zp2, 3, dis, dis, dis, dis * 0.1);
                            }

                            if (world instanceof ServerLevel) {
                                _level = (ServerLevel) world;
                                _level.sendParticles(JujutsucraftModParticleTypes.PARTICLE_MAGMA.get(), xp2, yp2, zp2, 3, dis, dis, dis, dis * 0.1);
                            }
                        }

                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel) world;
                            _level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, 2, dis, dis, dis, dis * 0.1);
                        }

                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel) world;
                            _level.sendParticles(JujutsucraftModParticleTypes.PARTICLE_MAGMA.get(), x_pos, y_pos, z_pos, 2, dis, dis, dis, dis * 0.1);
                        }

                        num1 += Math.toRadians(Math.random() * 10.0);
                    }

                    entity.getPersistentData().putDouble("cnt3", Math.toDegrees(num1));
                    entity.getPersistentData().putDouble("old_x", x);
                    entity.getPersistentData().putDouble("old_y", y);
                    entity.getPersistentData().putDouble("old_z", z);
                }
            } else {
                entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
                x_pos = x;
                y_pos = y - 5.0;
                z_pos = z;
                dis = Math.min(entity.getPersistentData().getDouble("cnt2") * 0.1, 1.5);
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel) world;
                    _level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, 25, dis, dis, dis, dis * 0.1);
                }

                num1 = Math.toRadians(entity.getPersistentData().getDouble("cnt3"));
                num2 = Math.min(8.0, entity.getPersistentData().getDouble("cnt2"));
                dis = Math.min(1.5, entity.getPersistentData().getDouble("cnt2") / 8.0);

                for (index0 = 0; index0 < 12; ++index0) {
                    for (index1 = 0; index1 < 2; ++index1) {
                        logic_a = !logic_a;
                        if (logic_a) {
                            xp2 = x_pos + Math.sin(num1) * num2;
                            yp2 = y_pos;
                            zp2 = z_pos + Math.cos(num1) * num2;
                        } else {
                            xp2 = x_pos - Math.sin(num1) * num2;
                            yp2 = y_pos;
                            zp2 = z_pos - Math.cos(num1) * num2;
                        }

                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel) world;
                            _level.sendParticles(ParticleTypes.FLAME, xp2, yp2, zp2, 3, dis, dis, dis, dis * 0.1);
                        }

                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel) world;
                            _level.sendParticles(JujutsucraftModParticleTypes.PARTICLE_MAGMA.get(), xp2, yp2, zp2, 3, dis, dis, dis, dis * 0.1);
                        }
                    }

                    num1 += Math.toRadians(Math.random() * 10.0);
                }

                entity.getPersistentData().putDouble("cnt3", Math.toDegrees(num1));
                entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 0.0, entity.getDeltaMovement().z()));
                if (entity.getPersistentData().getDouble("cnt2") > 30.0) {
                    LivingEntity _livEnt;
                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity) entity;
                        _livEnt.swing(InteractionHand.MAIN_HAND, true);
                    }

                    int var10001;
                    label178:
                    {
                        x_pos = x;
                        y_pos = y + Math.random() * 0.1;
                        z_pos = z;
                        if (entity instanceof LivingEntity) {
                            _livEnt = (LivingEntity) entity;
                            if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                break label178;
                            }
                        }

                        var10001 = 0;
                    }

                    HP = 400 + var10001 * 40;
                    if (world instanceof ServerLevel) {
                        _level = (ServerLevel) world;
                        Commands var10000 = _level.getServer().getCommands();
                        CommandSourceStack var68 = (new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput();
                        long var10002 = Math.round(HP);
                        var10000.performPrefixedCommand(var68, "summon jujutsucraft:meteor ~ ~ ~ {Health:" + var10002 + "f,Attributes:[{Name:generic.max_health,Base:" + Math.round(HP) + "}],Rotation:[" + entity.getYRot() + "F," + entity.getXRot() + "F]}");
                    }

                    _center = new Vec3(x_pos, y_pos, z_pos);
                    Vec3 final_center = _center;
                    _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(5.0), (e) -> {
                        return true;
                    }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                        return _entcnd.distanceToSqr(final_center);
                    })).toList();
                    var75 = _entfound.iterator();

                    while (var75.hasNext()) {
                        entityiterator = (Entity) var75.next();
                        if (entityiterator instanceof MeteorEntity && entityiterator.getPersistentData().getDouble("NameRanged_ranged") == 0.0) {
                            SetRangedAmmoProcedure.execute(entity, entityiterator);
                            entity.startRiding(entityiterator);
                            break;
                        }
                    }

                    if (world instanceof Level _level2) {
                        if (!_level2.isClientSide()) {
                            _level2.playSound(null, BlockPos.containing(x_pos, y_pos, z_pos), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 15.0F, 0.5F);
                        } else {
                            _level2.playLocalSound(x_pos, y_pos, z_pos, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 15.0F, 0.5F, false);
                        }
                    }

                    entity.getPersistentData().putDouble("skill", 0.0);
                }
            }

            if (entity.getPersistentData().getDouble("skill") > 0.0) {
                CNT6 = 1.0;
                power_attenuation = 1.0;
                logic_b = false;
                _center = new Vec3(x_pos, y_pos, z_pos);
                Vec3 final_center1 = _center;
                _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(22.5), (e) -> {
                    return true;
                }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                    return _entcnd.distanceToSqr(final_center1);
                })).toList();
                var75 = _entfound.iterator();

                while (true) {
                    do {
                        if (!var75.hasNext()) {
                            return;
                        }

                        entityiterator = (Entity) var75.next();
                    } while (!(entityiterator instanceof FallingBlockEntity) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:no_living"))));

                    x_knockback = entityiterator.getX() - entity.getX();
                    y_knockback = entityiterator.getY() - entity.getY();
                    z_knockback = entityiterator.getZ() - entity.getZ();
                    dis = Math.sqrt(Math.pow(x_knockback, 2.0) + Math.pow(y_knockback, 2.0) + Math.pow(z_knockback, 2.0));
                    if (dis != 0.0) {
                        x_knockback = x_knockback / dis * -2.4;
                        y_knockback = y_knockback / dis * -2.4;
                        z_knockback = z_knockback / dis * -2.4;
                        if (!(x_knockback * 1.1 < entityiterator.getDeltaMovement().x()) && !(x_knockback * 0.9 > entityiterator.getDeltaMovement().x())) {
                            x_knockback = entityiterator.getDeltaMovement().x();
                        } else {
                            x_knockback = entityiterator.getDeltaMovement().x() + x_knockback * 0.05;
                        }

                        if (!(y_knockback * 1.1 < entityiterator.getDeltaMovement().y()) && !(y_knockback * 0.9 > entityiterator.getDeltaMovement().y())) {
                            y_knockback = entityiterator.getDeltaMovement().y();
                        } else {
                            y_knockback = entityiterator.getDeltaMovement().y() + y_knockback * 0.05;
                        }

                        if (!(z_knockback * 1.1 < entityiterator.getDeltaMovement().z()) && !(z_knockback * 0.9 > entityiterator.getDeltaMovement().z())) {
                            z_knockback = entityiterator.getDeltaMovement().z();
                        } else {
                            z_knockback = entityiterator.getDeltaMovement().z() + z_knockback * 0.05;
                        }

                        if (entityiterator.onGround()) {
                            y_knockback = Math.max(y_knockback, 0.5 * (1.2 - power_attenuation) * CNT6);
                        }
                    }

                    entityiterator.setDeltaMovement(new Vec3(x_knockback, y_knockback, z_knockback));
                }
            }
        }
    }
}
