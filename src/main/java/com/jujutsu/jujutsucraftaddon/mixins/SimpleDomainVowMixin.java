package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.entity.UiUiEntity;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.LogicSimpleDomainProcedure;
import net.mcreator.jujutsucraft.procedures.SimpleDomainEffectStartedappliedProcedure;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Comparator;
import java.util.List;


@Mixin(value = SimpleDomainEffectStartedappliedProcedure.class, priority = -10000)
public abstract class SimpleDomainVowMixin {
    public SimpleDomainVowMixin() {
    }

    /**
     * @author Satushi
     * @reason Change Simple Domain Logic To Upgrade Range
     */

    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            double x_pos;
            double y_pos;
            double z_pos;
            double num1;
            double num2;
            int var10000;
            label46: {
                x_pos = 0.0;
                y_pos = 0.0;
                z_pos = 0.0;
                num1 = 0.0;
                num2 = 0.0;
                double num3 = 0.0;
                double pitch = 0.0;
                double yaw = 0.0;
                double tick = 0.0;
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEnt = (LivingEntity)entity;
                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                        var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getAmplifier();
                        break label46;
                    }
                }

                var10000 = 0;
            }

            if (var10000 > 0 && LogicSimpleDomainProcedure.execute()) {
                int var10002;
                double var30;
                label38: {
                    num1 = Math.toRadians(Math.random() * 360.0);
                    var30 = (double)entity.getBbWidth();
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                            var10002 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getDuration();
                            break label38;
                        }
                    }

                    var10002 = 0;
                }

                num2 = var30 + 0.025 * (double)var10002;
                num2 = Math.min(num2, entity.getPersistentData().getDouble("skill") == 3105.0 ? 16.0 : 4.0);
                double num3 = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SimpleDomainLevel;
                for(int index0 = 0; index0 < 72; ++index0) {
                    if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SimpleDomainLevel >= 3.0) {
                        x_pos = x + Math.sin(num1) * num2 * num3;
                        y_pos = y;
                        z_pos = z + Math.cos(num1) * num2 * num3;
                        if (!((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Effects)) {
                            if (world instanceof ServerLevel) {
                                {
                                    ServerLevel _level = (ServerLevel) world;
                                    _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "particle dust 0.749 0.984 1.000 1 ~ ~ ~ 0 0 0 1 1 force");
                                }
                            }
                        } else {
                            if (Math.random() < (1) / ((float) 20)) {
                                {
                                    Entity _ent = entity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                                _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "particle jjkueffects:simple_domain_2");
                                    }
                                }
                            }

                        }


                        num1 += Math.toRadians(Math.random() * 10.0);
                    } else {
                        x_pos = x + Math.sin(num1) * num2;
                        y_pos = y;
                        z_pos = z + Math.cos(num1) * num2;
                        if (!((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Effects)) {
                            if (world instanceof ServerLevel) {
                                {
                                    ServerLevel _level = (ServerLevel) world;
                                    _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "particle dust 0.749 0.984 1.000 1 ~ ~ ~ 0 0 0 1 1 force");
                                }
                            }
                        } else {
                            if (Math.random() < (1) / ((float) 20)) {
                                {
                                    Entity _ent = entity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                                _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "particle jjkueffects:simple_domain");
                                    }
                                }
                            }

                        }

                        num1 += Math.toRadians(Math.random() * 10.0);
                    }
                }
            }

            if (entity instanceof ServerPlayer _plr22 && _plr22.level() instanceof ServerLevel
                    && _plr22.getAdvancements().getOrStartProgress(_plr22.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:perfect_simple_domain"))).isDone()) {
                final Vec3 _center2 = new Vec3(x, y, z);
                List<Entity> _entfound2 = world.getEntitiesOfClass(Entity.class, new AABB(_center2, _center2).inflate(7 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center2))).toList();
                for (Entity entityiterator : _entfound2) {
                    if (!(entityiterator == entity)) {
                        if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo_no_move")))) {
                            if (Math.random() <= 0.1) {
                                if (!entityiterator.level().isClientSide())
                                    entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))),
                                            Mth.nextInt(RandomSource.create(), 10, 50));
                            }
                        } else if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                            if (Math.random() <= 0.1) {
                                if (!entityiterator.level().isClientSide())
                                    entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))),
                                            Mth.nextInt(RandomSource.create(), 10, 50));
                            }
                        }
                    }
                }
            }


            if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 11) {
                {
                    final Vec3 _center = new Vec3(x, y, z);
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                    for (Entity entityiterator : _entfound) {
                        if (entityiterator instanceof UiUiEntity) {
                            if ((entityiterator.getPersistentData().getString("OWNER_UUID")).equals(entity.getStringUUID())) {
                                {
                                    Entity _ent = entityiterator;
                                    _ent.teleportTo(x, y, z);
                                    if (_ent instanceof ServerPlayer _serverPlayer)
                                        _serverPlayer.connection.teleport(x, y, z, _ent.getYRot(), _ent.getXRot());
                                }
                                if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get(), 400,
                                            (entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getAmplifier() : 0)
                                                    + 3,
                                            false, false));
                            }
                        }
                    }
                }

            }

            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SimpleQuest >= 0.0) {
                if (entity.getPersistentData().getDouble("cnt_simpledomain") <= 10000.0) {
                    {
                        entity.getPersistentData().putDouble("cnt_simpledomain", entity.getPersistentData().getDouble("cnt_simpledomain") + 1.0);
                    }
                } else if (entity.getPersistentData().getDouble("cnt_simpledomain") >= 10000.0) {
                    if (entity instanceof ServerPlayer _player) {
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:perfect_simple_domain"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                            for (String criteria : _ap.getRemainingCriteria())
                                _player.getAdvancements().award(_adv, criteria);
                        }
                    }

                    {
                        double _setval = 3;
                        entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.SimpleDomainLevel = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }

                    {
                        double _setval = 5;
                        entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.SimpleQuest = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }

                }

            }
        }
    }
}