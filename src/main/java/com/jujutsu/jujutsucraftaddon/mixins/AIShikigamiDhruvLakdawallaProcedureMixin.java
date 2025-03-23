package com.jujutsu.jujutsucraftaddon.mixins;


import net.mcreator.jujutsucraft.entity.ShikigamiHeterocephalusGlaberEntity;
import net.mcreator.jujutsucraft.entity.ShikigamiPterosaurEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModBlocks;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.*;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;
import java.util.function.BiFunction;

@Mixin(value = AIShikigamiDhruvLakdawallaProcedure.class, priority = -10000)
public abstract class AIShikigamiDhruvLakdawallaProcedureMixin {

    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            Entity owner_uuid = null;
            double rnd = 0.0;
            double tick = 0.0;
            double NUM2 = 0.0;
            double NUM1 = 0.0;
            double distance = 0.0;
            double level = 0.0;
            double level_strength = 0.0;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            boolean logicStart = false;
            boolean placed = false;
            LivingEntity _livEnt;
            if (entity.isAlive()) {
                if (entity instanceof LivingEntity) {
                    _livEnt = (LivingEntity) entity;
                    if (!_livEnt.level().isClientSide()) {
                        _livEnt.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 10, 9, false, false));
                    }
                }

                LivingEntity _entity;
                ServerLevel _level2;
                if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                    AIActiveProcedure.execute(world, x, y, z, entity);
                    if (entity instanceof ShikigamiPterosaurEntity) {
                        AIActiveFlyingProcedure.execute(world, entity);
                    } else if (entity instanceof ShikigamiHeterocephalusGlaberEntity && ((LivingEntity) entity).getAttribute(JujutsucraftModAttributes.SIZE.get()).getBaseValue() < 6.0) {
                        ((LivingEntity) entity).getAttribute(JujutsucraftModAttributes.SIZE.get()).setBaseValue(Math.min(((LivingEntity) entity).getAttribute(JujutsucraftModAttributes.SIZE.get()).getBaseValue() + 0.1, 6.0));
                        entity.setMaxUpStep((float) ((double) entity.getStepHeight() + 0.01));
                    }

                    label236:
                    {
                        NUM1 = (double) (2L + Math.round(entity.getPersistentData().getDouble("Strength") * 0.5));
                        NUM2 = (double) Math.round(Math.floor(Math.min((NUM1 + ((LivingEntity) entity).getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() * 3.0) / 4.0, 3.0)));
                        if (entity instanceof LivingEntity) {
                            _livEnt = (LivingEntity) entity;
                            if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                break label236;
                            }
                        }

                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity) entity;
                            if (!_entity.level().isClientSide()) {
                                _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, Integer.MAX_VALUE, (int) NUM1, false, false));
                            }
                        }
                    }

                    int var10000;
                    label231:
                    {
                        if (entity instanceof LivingEntity) {
                            _livEnt = (LivingEntity) entity;
                            if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                                var10000 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                                break label231;
                            }
                        }

                        var10000 = 0;
                    }

                    if ((double) var10000 < NUM2 && entity instanceof LivingEntity) {
                        _entity = (LivingEntity) entity;
                        if (!_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, Integer.MAX_VALUE, (int) NUM2, false, false));
                        }
                    }
                } else if (entity.getPersistentData().getDouble("mode") == 0.0 || entity.getPersistentData().getDouble("skill") <= 0.0) {
                    if (world instanceof ServerLevel) {
                        _level2 = (ServerLevel) world;
                        _level2.sendParticles(ParticleTypes.SQUID_INK, entity.getX(), entity.getY() + (double) entity.getBbHeight() * 0.5, entity.getZ(), 10, 0.25, 0.25, 0.25, 0.0);
                    }

                    if (!entity.level().isClientSide()) {
                        entity.discard();
                    }
                }

                if (entity.getPersistentData().getDouble("mode") == 1.0) {
                    AttackTackleFlyingProcedure.execute(world, x, y, z, entity);
                    entity.getPersistentData().putDouble("cnt_x", -100.0);
                    if (entity.getPersistentData().getDouble("skill") == 0.0) {
                        if (entity.getPersistentData().getDouble("continue") > 0.0) {
                            entity.getPersistentData().putDouble("continue", entity.getPersistentData().getDouble("continue") - 1.0);
                            entity.getPersistentData().putDouble("skill", 1.0);
                            entity.getPersistentData().putDouble("mode", 1.0);
                        }

                        ResetCounterProcedure.execute(entity);
                    }
                } else if (entity.getPersistentData().getDouble("mode") > 20.0) {
//                    AIAttackProcedure.execute(world, x, y, z, entity);
                } else {
                    LivingEntity var35;
                    if (entity instanceof Mob _mobEnt) {
                        var35 = _mobEnt.getTarget();
                    } else {
                        var35 = null;
                    }

                    if (var35 instanceof LivingEntity) {
                        entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                        if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                            entity.getPersistentData().putDouble("cnt_x", 0.0);
                            ResetCounterProcedure.execute(entity);
                            distance = GetDistanceProcedure.execute(world, entity);
                            logicStart = LogicStartProcedure.execute(entity);
                            if (entity instanceof ShikigamiPterosaurEntity) {
                                rnd = 0.0;
                            } else if (entity instanceof ShikigamiHeterocephalusGlaberEntity) {
                                label212:
                                {
                                    if (entity instanceof LivingEntity) {
                                        _entity = (LivingEntity) entity;
                                        if (_entity.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                            break label212;
                                        }
                                    }

                                    if (distance < 15.0 && Math.random() < 0.5) {
                                        rnd = 2204.0;
                                        level = 1.0;
                                        tick = 25.0;
                                    }
                                }
                            }

                            if (rnd > 0.0) {
                                entity.getPersistentData().putDouble("skill", (double) Math.round(rnd));
                                if (entity instanceof LivingEntity) {
                                    _entity = (LivingEntity) entity;
                                    if (!_entity.level().isClientSide()) {
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                                    }
                                }

                                if (level > 0.0) {
                                    if (entity instanceof LivingEntity) {
                                        _entity = (LivingEntity) entity;
                                        if (!_entity.level().isClientSide()) {
                                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int) tick, 0, false, false));
                                        }
                                    }
                                } else if (entity instanceof LivingEntity) {
                                    _entity = (LivingEntity) entity;
                                    if (!_entity.level().isClientSide()) {
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int) tick, 0, false, false));
                                    }
                                }
                            } else if (entity instanceof ShikigamiPterosaurEntity) {
                                entity.getPersistentData().putDouble("cnt_x", -50.0);
                                entity.getPersistentData().putDouble("mode", 1.0);
                                entity.getPersistentData().putDouble("skill", 1.0);
                                entity.getPersistentData().putDouble("continue", Math.random() < 0.75 ? 1 : 0);
                            } else {
                                CalculateAttackProcedure.execute(world, x, y, z, entity);
                            }
                        }
                    } else {
                        entity.getPersistentData().putDouble("cnt_x", 0.0);
                    }
                }

                if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                    placed = true;
                } else if (entity.getPersistentData().getDouble("skill") > 0.0) {
                    if (GetDistanceNearestEnemyProcedure.execute(world, x, y, z, entity) < 15.0) {
                        placed = true;
                    }
                } else if (entity.getPersistentData().getDouble("skill") == 0.0 && Math.random() < 0.1) {
                    placed = true;
                }


                if (placed) {
                    x_pos = x + (Math.random() - 0.5) * (double) entity.getBbWidth() * 0.5;
                    y_pos = y + Math.random() * (double) entity.getBbWidth() * 0.5;
                    z_pos = z + (Math.random() - 0.5) * (double) entity.getBbWidth() * 0.5;

                    double x_pos2 = x + (Mth.nextInt(RandomSource.create(), -5, 5) - 0.5) * (double) entity.getBbWidth() * 0.5;
                    double y_pos2 = y + (Mth.nextInt(RandomSource.create(), -3, 3)) * (double) entity.getBbWidth() * 0.5;
                    double z_pos2 = z + (Mth.nextInt(RandomSource.create(), -5, 5) - 0.5) * (double) entity.getBbWidth() * 0.5;

                    if (world instanceof ServerLevel) {
                        _level2 = (ServerLevel) world;
                        _level2.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos2, y_pos2, z_pos2), Vec2.ZERO, _level2, 4, "", Component.literal(""), _level2.getServer(), null)).withSuppressedOutput(), "setblock ~ ~ ~ jujutsucraft:domain keep");
                    }

                    if (world instanceof ServerLevel) {
                        _level2 = (ServerLevel) world;
                        _level2.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos2, y_pos2, z_pos2), Vec2.ZERO, _level2, 4, "", Component.literal(""), _level2.getServer(), null)).withSuppressedOutput(), "setblock ~ ~ ~ jujutsucraft:domain keep");
                    }

                    if (world instanceof ServerLevel) {
                        _level2 = (ServerLevel) world;
                        _level2.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos2, y_pos2, z_pos2), Vec2.ZERO, _level2, 4, "", Component.literal(""), _level2.getServer(), null)).withSuppressedOutput(), "setblock ~ ~ ~ jujutsucraft:domain keep");
                    }


                    if (world instanceof ServerLevel) {
                        _level2 = (ServerLevel) world;
                        _level2.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level2, 4, "", Component.literal(""), _level2.getServer(), null)).withSuppressedOutput(), "setblock ~ ~ ~ jujutsucraft:domain keep");
                        _level2.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level2, 4, "", Component.literal(""), _level2.getServer(), null)).withSuppressedOutput(), "setblock ~1 ~ ~ jujutsucraft:domain keep");
                        _level2.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level2, 4, "", Component.literal(""), _level2.getServer(), null)).withSuppressedOutput(), "setblock ~ ~ ~1 jujutsucraft:domain keep");
                        _level2.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level2, 4, "", Component.literal(""), _level2.getServer(), null)).withSuppressedOutput(), "setblock ~ ~1 ~ jujutsucraft:domain keep");
                        _level2.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level2, 4, "", Component.literal(""), _level2.getServer(), null)).withSuppressedOutput(), "setblock ~ ~ ~-1 jujutsucraft:domain keep");
                        _level2.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level2, 4, "", Component.literal(""), _level2.getServer(), null)).withSuppressedOutput(), "setblock ~-1 ~ ~ jujutsucraft:domain keep");
                        _level2.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level2, 4, "", Component.literal(""), _level2.getServer(), null)).withSuppressedOutput(), "setblock ~ ~-1 ~ jujutsucraft:domain keep");
                    }

                    if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).getBlock() == JujutsucraftModBlocks.DOMAIN.get()) {
                        BlockState _bs;
                        Level _level;
                        BlockPos _bp;
                        BlockEntity _blockEntity;
                        if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && (new BiFunction<LevelAccessor, String, Entity>() {
                            public Entity apply(LevelAccessor levelAccessor, String uuid) {
                                if (levelAccessor instanceof ServerLevel serverLevel) {
                                    try {
                                        return serverLevel.getEntity(UUID.fromString(uuid));
                                    } catch (Exception var5) {
                                    }
                                }

                                return null;
                            }
                        }).apply(world, entity.getPersistentData().getString("OWNER_UUID")) instanceof LivingEntity) {
                            if (!world.isClientSide()) {
                                _bp = BlockPos.containing(x_pos, y_pos, z_pos);
                                _blockEntity = world.getBlockEntity(_bp);
                                _bs = world.getBlockState(_bp);
                                if (_blockEntity != null) {
                                    _blockEntity.getPersistentData().putString("OWNER_UUID", entity.getPersistentData().getString("OWNER_UUID"));
                                }

                                if (world instanceof Level) {
                                    _level = (Level) world;
                                    _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                                }
                            }
                        } else if (!world.isClientSide()) {
                            _bp = BlockPos.containing(x_pos, y_pos, z_pos);
                            _blockEntity = world.getBlockEntity(_bp);
                            _bs = world.getBlockState(_bp);
                            if (_blockEntity != null) {
                                _blockEntity.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                            }

                            if (world instanceof Level) {
                                _level = (Level) world;
                                _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                            }
                        }
                    }
                }
            }

            if (entity.getPersistentData().getBoolean("Shikigami")) {
                owner_uuid = (new BiFunction<LevelAccessor, String, Entity>() {
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
                Entity _ent;
                if (owner_uuid instanceof LivingEntity) {
                    if (!owner_uuid.isAlive()) {
                        _ent = entity;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill @s");
                        }
                    }
                } else {
                    _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill @s");
                    }
                }

                if (owner_uuid instanceof LivingEntity) {
                    _livEnt = (LivingEntity) owner_uuid;
                    if (_livEnt.hasEffect(JujutsucraftModMobEffects.UNSTABLE.get())) {
                        Entity _ent2 = entity;
                        if (!_ent2.level().isClientSide() && _ent2.getServer() != null) {
                            _ent2.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent2.position(), _ent2.getRotationVector(), _ent2.level() instanceof ServerLevel ? (ServerLevel) _ent2.level() : null, 4, _ent2.getName().getString(), _ent2.getDisplayName(), _ent2.level().getServer(), _ent2), "kill @s");
                        }

                        if (!entity.level().isClientSide()) {
                            entity.discard();
                        }
                    }
                }
            }

        }
    }
}
