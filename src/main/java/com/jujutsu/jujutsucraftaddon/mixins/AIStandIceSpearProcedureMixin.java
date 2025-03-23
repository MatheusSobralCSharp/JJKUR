package com.jujutsu.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.IceSpearEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.procedures.*;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = AIStandIceSpearProcedure.class, priority = -10000)
public abstract class AIStandIceSpearProcedureMixin {

    /**
     * @author Satushi
     * @reason Changes Ice Spear Damage to buff it
     */

    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double speed = 0.0;
            if (entity.getPersistentData().getDouble("move") == 1.0) {
                if (entity instanceof IceSpearEntity) {
                    ((IceSpearEntity) entity).setAnimation("spin");
                }

                AIStandIceSpear2Procedure.execute(world, x, y, z, entity);
            } else {
                if (entity instanceof IceSpearEntity) {
                    ((IceSpearEntity) entity).setAnimation("idle_stand");
                }

                entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
                if (entity.onGround()) {
                    entity.setDeltaMovement(new Vec3(0.0, entity.getDeltaMovement().y(), 0.0));
                    if (entity.getPersistentData().getDouble("cnt2") > 10.0) {
                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.explode(null, x, y, z, 0.0F, Level.ExplosionInteraction.NONE);
                            }
                        }

                        ServerLevel _level;
                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel) world;
                            _level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 8, 0.2, 0.2, 0.2, 0.2);
                        }

                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel) world;
                            _level.sendParticles(JujutsucraftModParticleTypes.PARTICLE_ICE.get(), x, y, z, 4, 0.2, 0.2, 0.2, 0.2);
                        }

                        if (((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() < 100) {
                            entity.getPersistentData().putDouble("Damage", 40.0);
                            entity.getPersistentData().putDouble("Range", 5.0 * ReturnEntitySizeProcedure.execute(entity));
                            entity.getPersistentData().putDouble("knockback", 0.5);
                            entity.getPersistentData().putDouble("effect", 14.0);
                            RangeAttackProcedure.execute(world, x, y, z, entity);
                            entity.getPersistentData().putDouble("BlockRange", 2.0);
                            entity.getPersistentData().putDouble("BlockDamage", 4.0);
                            BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
                        } else {
                            entity.getPersistentData().putDouble("skill", 2606.0);
                            entity.getPersistentData().putDouble("Damage", 60.0);
                            entity.getPersistentData().putDouble("Range", 5.0 * ReturnEntitySizeProcedure.execute(entity));
                            entity.getPersistentData().putDouble("knockback", 0.5);
                            entity.getPersistentData().putDouble("effect", 14.0);
                            RangeAttackProcedure.execute(world, x, y, z, entity);
                            entity.getPersistentData().putDouble("BlockRange", 2.0 * ReturnEntitySizeProcedure.execute(entity));
                            entity.getPersistentData().putDouble("BlockDamage", 6.0);
                            BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
                        }
                    }

                    entity.getPersistentData().putDouble("cnt2", 0.0);
                } else {
                    entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
                    if (entity.getPersistentData().getDouble("cnt2") > 10.0) {
                        BulletDomainHit2Procedure.execute(world, entity);
                        entity.getPersistentData().putDouble("Damage", 20.0);
                        entity.getPersistentData().putDouble("Range", 5.0 * ReturnEntitySizeProcedure.execute(entity));
                        entity.getPersistentData().putDouble("knockback", 0.5);
                        entity.getPersistentData().putDouble("effect", 14.0);
                        RangeAttackProcedure.execute(world, x, entity.getY() + (double) entity.getBbHeight() * 0.5, z, entity);
                    }
                }

                if (!entity.isAlive() || entity.getPersistentData().getDouble("cnt1") > 200.0) {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill @s");
                    }
                }
            }

        }
    }
}
