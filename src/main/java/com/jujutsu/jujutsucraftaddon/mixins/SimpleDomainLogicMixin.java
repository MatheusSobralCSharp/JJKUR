package com.jujutsu.jujutsucraftaddon.mixins;


import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import com.jujutsu.jujutsucraftaddon.procedures.YamatoToolInHandTickProcedure;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.ActiveTickConditionProcedure;
import net.mcreator.jujutsucraft.procedures.SimpleDomainEffectStartedappliedProcedure;
import net.mcreator.jujutsucraft.procedures.SimpleDomainOnEffectActiveTickProcedure;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Mixin(value = SimpleDomainOnEffectActiveTickProcedure.class, priority = -10000)
public abstract class SimpleDomainLogicMixin {
    public SimpleDomainLogicMixin() {
    }

    /**
     * @author Satushi
     * @reason Changing Simple Domain Tick Active and Radius
     */

    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            double z_pos;
            double num1;
            int var10000;
            double x_pos;
            double y_pos;
            double pitch;
            double yaw;
            double num2;
            label128:
            {
                boolean logic_infinity = false;
                z_pos = 0.0;
                double num3 = 0.0;
                double strength = 0.0;
                num1 = 0.0;
                x_pos = 0.0;
                y_pos = 0.0;
                pitch = 0.0;
                yaw = 0.0;
                num2 = 0.0;
                if (entity instanceof LivingEntity _livEnt) {
                    if (_livEnt.hasEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                        var10000 = _livEnt.getEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getAmplifier();
                        break label128;
                    }
                }

                var10000 = 0;
            }

            if (var10000 > 0) {
                LivingEntity _livEnt;
                label121:
                {
                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity) entity;
                        if (_livEnt.hasEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                            var10000 = _livEnt.getEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getDuration();
                            break label121;
                        }
                    }

                    var10000 = 0;
                }

                LivingEntity _livEnt7;
                if (var10000 % 5 == 1) {
                    if (entity instanceof Player) {
                        label113:
                        {
                            if (entity instanceof LivingEntity) {
                                _livEnt7 = (LivingEntity) entity;
                                if (_livEnt7.hasEffect(JujutsucraftModMobEffects.SIX_EYES.get())) {
                                    break label113;
                                }
                            }

                            double _setval = entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCursePowerChange - 1.0;
                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                                capability.PlayerCursePowerChange = _setval;
                                capability.syncPlayerVariables(entity);
                            });
                        }
                    }

                    SimpleDomainEffectStartedappliedProcedure.execute(world, x, y, z, entity);
                }

                if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 31) {
                    if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("New Shadow Style: Defensive")) {
                        YamatoToolInHandTickProcedure.execute(world, x, y, z, entity);
                    }
                }


                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SimpleDomainLevel <= 1.0) {
                    if (!ActiveTickConditionProcedure.execute(entity) && entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity) entity;
                        _livEnt.removeEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get());
                    }
                }

                label105:
                {
                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity) entity;
                        if (_livEnt.hasEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                            var10000 = _livEnt.getEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getDuration();
                            break label105;
                        }
                    }

                    var10000 = 0;
                }

                if (var10000 % 2 == 1) {
                    label138:
                    {
                        num1 = entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique;
                        num2 = entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique2;
                        if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:can_use_hollow_wicker_basket")))) {
                            label135:
                            {
                                if (entity instanceof LivingEntity) {
                                    _livEnt7 = (LivingEntity) entity;
                                    if (_livEnt7.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                        break label135;
                                    }
                                }

                                if (!(entity instanceof Player) || num1 != 1.0 && num2 != 1.0 && num1 != 7.0 && num2 != 7.0 && num1 != 12.0 && num2 != 12.0 && num1 != 24.0 && num2 != 24.0) {
                                    break label138;
                                }
                            }
                        }

                        yaw = Math.toRadians(entity.getYRot() + 90.0F);
                        pitch = Math.toRadians(entity.getXRot());
                        x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (double) (-1.0F - entity.getBbWidth());
                        y_pos = entity.getY() + (double) entity.getBbHeight() * 0.5;
                        z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (double) (-1.0F - entity.getBbWidth());
                        if (world instanceof ServerLevel _level) {
                            _level.sendParticles(JujutsucraftModParticleTypes.PARTICLE_HOLLOW_WICKER_BASKET.get(), x_pos, y_pos, z_pos, 0, 0.0, 0.0, 0.0, 0.0);
                        }
                    }
                }

                int var10002;
                double var33;
                label80:
                {
                    var33 = entity.getBbWidth();
                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity) entity;
                        if (_livEnt.hasEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                            var10002 = _livEnt.getEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getDuration();
                            break label80;
                        }
                    }

                    var10002 = 0;
                }

                num2 = var33 + 0.025 * (double) var10002;
                num2 = Math.min(num2, entity.getPersistentData().getDouble("skill") == 3105.0 ? 16.0 : 4.0);
                Vec3 _center = new Vec3(x, y, z);
                List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(num2 * 2.0 / 2.0), (e) -> {
                    return true;
                }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                    return _entcnd.distanceToSqr(_center);
                })).toList();
                Iterator var37 = _entfound.iterator();

                while (var37.hasNext()) {
                    Entity entityiterator = (Entity) var37.next();
                    if (entity != entityiterator && entity.getY() + (double) entity.getBbHeight() >= entityiterator.getY() && entity.getY() <= entityiterator.getY() + (double) entityiterator.getBbHeight()) {
                        if (entityiterator instanceof LivingEntity _entity) {
                            if (!_entity.level().isClientSide()) {
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get(), 5, 0, true, true));
                            }
                        }
                        break;
                    }
                }
            }

        }
    }
}