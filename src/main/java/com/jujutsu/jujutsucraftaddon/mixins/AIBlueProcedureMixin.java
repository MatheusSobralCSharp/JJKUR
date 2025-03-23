package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.procedures.SetCustomizedProcedure;
import net.mcreator.jujutsucraft.entity.BlackHoleEntity;
import net.mcreator.jujutsucraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModGameRules;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.*;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.GameType;
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
import java.util.UUID;
import java.util.function.BiFunction;

@Mixin(value = AIBlueProcedure.class, priority = -10000)
public abstract class AIBlueProcedureMixin {

    /**
     * @author Satushi
     * @reason Changes
     * This is for give blue one special effect used for gojo new skills and stuff for buff black hole
     */

    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            ItemStack old_health = ItemStack.EMPTY;
            boolean logic_a = false;
            boolean logic_b = false;
            boolean player = false;
            Entity entity_a = null;
            double z_pos = 0.0;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double rad = 0.0;
            double rad_now = 0.0;
            double dis = 0.0;
            double yaw = 0.0;
            double z_knockback = 0.0;
            double y_knockback = 0.0;
            double x_knockback = 0.0;
            double CNT6 = 0.0;
            double power_attenuation = 0.0;
            double range = 0.0;
            AIBlueRedProcedure.execute(world, entity);
            if (LogicOwnerExistProcedure.execute(world, entity)) {
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
            }

            if (entity instanceof BlackHoleEntity) {
                if (entity.getPersistentData().getDouble("Ult") == 0) {
                    if (((LivingEntity) entity).getAttribute(JujutsucraftModAttributes.SIZE.get()).getBaseValue() < 64.0) {
                        ((LivingEntity) entity).getAttribute(JujutsucraftModAttributes.SIZE.get()).setBaseValue(Math.min(((LivingEntity) entity).getAttribute(JujutsucraftModAttributes.SIZE.get()).getBaseValue() + 0.8, 64.0));
                    }
                } else {
                    if (((LivingEntity) entity).getAttribute(JujutsucraftModAttributes.SIZE.get()).getBaseValue() < 120.0) {
                        ((LivingEntity) entity).getAttribute(JujutsucraftModAttributes.SIZE.get()).setBaseValue(Math.min(((LivingEntity) entity).getAttribute(JujutsucraftModAttributes.SIZE.get()).getBaseValue() + 0.8, 64.0));
                    }
                }

                dis = ((LivingEntity) entity).getAttribute(JujutsucraftModAttributes.SIZE.get()).getBaseValue() * 10.0;
                ServerLevel _level;
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel) world;
                    _level.sendParticles(ParticleTypes.SQUID_INK, x, y, z, (int) dis, dis * 0.05, dis * 0.05, dis * 0.05, 1.0 + dis * 0.02);
                }

                if (world instanceof ServerLevel) {
                    _level = (ServerLevel) world;
                    _level.sendParticles(ParticleTypes.DRAGON_BREATH, x, y, z, (int) dis, dis * 0.05, dis * 0.05, dis * 0.05, 1.0 + dis * 0.02);
                }

                if (entity_a instanceof LivingEntity) {
                    entity_a.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                    entity_a.teleportTo(x, y, z);
                    if (entity_a instanceof ServerPlayer _serverPlayer) {
                        _serverPlayer.connection.teleport(x, y, z, entity_a.getYRot(), entity_a.getXRot());
                    }
                }
            }

            LivingEntity _entity;
            Player _plr;
            if (entity.getPersistentData().getBoolean("flag_start")) {
                if (entity.getPersistentData().getBoolean("circle")) {
                    if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && entity_a instanceof LivingEntity && entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged")) {
                        RotateEntityProcedure.execute(entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(0.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity_a)).getBlockPos().getX(), entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(0.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity_a)).getBlockPos().getY(), entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(0.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity_a)).getBlockPos().getZ(), entity);
                    }

                    entity.setYRot(entity.getYRot() + 90.0F);
                    entity.setXRot(entity.getXRot());
                    entity.setYBodyRot(entity.getYRot());
                    entity.setYHeadRot(entity.getYRot());
                    entity.yRotO = entity.getYRot();
                    entity.xRotO = entity.getXRot();
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity) entity;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                    }

                    entity.getPersistentData().putBoolean("free", true);
                    GetPowerForwardProcedure.execute(entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(24.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(24.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(24.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ(), entity);
                    entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 0.4, entity.getPersistentData().getDouble("y_power") * 0.4, entity.getPersistentData().getDouble("z_power") * 0.4));
                } else {
                    entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 0.0, entity.getPersistentData().getDouble("y_power") * 0.0, entity.getPersistentData().getDouble("z_power") * 0.0));
                }

                CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
                entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
                Level _level;
                if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
                    entity.getPersistentData().putDouble("cnt2", 1.0);
                    if (world instanceof Level) {
                        _level = (Level) world;
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float) (1.5 + CNT6), 1.0F);
                        } else {
                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float) (1.5 + CNT6), 1.0F, false);
                        }
                    }

                    if (world instanceof Level) {
                        _level = (Level) world;
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float) (1.5 + CNT6), 0.5F);
                        } else {
                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float) (1.5 + CNT6), 0.5F, false);
                        }
                    }

                    entity.getPersistentData().putDouble("cnt_bullet_hit", 15.0);
                    BulletDomainHit2Procedure.execute(world, entity);
                }

                x_pos = entity.getX();
                y_pos = entity.getY();
                z_pos = entity.getZ();
                if (entity.getPersistentData().getDouble("cnt1") % 2.0 == 1.0) {
                    int var10000;
                    label362:
                    {
                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity) entity;
                            if (_entity.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                var10000 = _entity.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                break label362;
                            }
                        }

                        var10000 = 0;
                    }


                    if (entity.getPersistentData().getDouble("Ult") == 0) {
                        range = (double) Math.min(var10000, 30) * 0.0333;
                        entity.getPersistentData().putDouble("BlockRange", Math.min(7.0 * CNT6, entity.getPersistentData().getDouble("cnt1") * 0.5));
                        entity.getPersistentData().putDouble("BlockDamage", 3.5 * (range + 0.01) * CNT6);
                        entity.getPersistentData().putBoolean("noParticle", entity instanceof BlackHoleEntity);
                        BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                        entity.getPersistentData().putDouble("BlockRange", Math.min(9.0 * CNT6, entity.getPersistentData().getDouble("cnt1")));
                        entity.getPersistentData().putDouble("BlockDamage", 1.5 * (range + 0.01) * CNT6);
                        entity.getPersistentData().putBoolean("noParticle", entity instanceof BlackHoleEntity);
                        BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                    } else {
                        range = (double) Math.min(var10000, 30) * 0.0333 * 2;
                        entity.getPersistentData().putDouble("BlockRange", Math.min(7.0 * CNT6, entity.getPersistentData().getDouble("cnt1") * 0.5) * 2);
                        entity.getPersistentData().putDouble("BlockDamage", 3.5 * (range + 0.01) * CNT6 * 2);
                        entity.getPersistentData().putBoolean("noParticle", entity instanceof BlackHoleEntity);
                        BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                        entity.getPersistentData().putDouble("BlockRange", Math.min(9.0 * CNT6, entity.getPersistentData().getDouble("cnt1")) * 2);
                        entity.getPersistentData().putDouble("BlockDamage", 1.5 * (range + 0.01) * CNT6 * 2);
                        entity.getPersistentData().putBoolean("noParticle", entity instanceof BlackHoleEntity);
                        BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                    }
                }

                power_attenuation = 1.0;
                logic_b = false;

                label354:
                for (int index0 = 0; index0 < 5; ++index0) {
                    entity.getPersistentData().putDouble("Range", Math.min(45.0 * power_attenuation * CNT6, 75.0));
                    entity.getPersistentData().putDouble("knockback", Math.max(-5.0 * (1.2 - power_attenuation) * CNT6, -8.0));
                    Vec3 _center = new Vec3(x, y, z);
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(entity.getPersistentData().getDouble("Range") / 2.0), (e) -> {
                        return true;
                    }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                        return _entcnd.distanceToSqr(_center);
                    })).toList();
                    Iterator var42 = _entfound.iterator();

                    while (true) {
                        Entity entityiterator;
                        LivingEntity _livEnt116;
                        do {
                            while (true) {
                                do {
                                    do {
                                        if (!var42.hasNext()) {
                                            entity.getPersistentData().putDouble("knockback", 0.0);
                                            power_attenuation *= 0.75;
                                            continue label354;
                                        }

                                        entityiterator = (Entity) var42.next();
                                    } while (entity == entityiterator);

                                    logic_a = true;
                                    if (entityiterator instanceof Player) {
                                        if (entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique != 16.0 && entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique2 != 16.0) {
                                            continue;
                                        }
                                    } else if (!(entityiterator instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity)) {
                                        continue;
                                    }

                                    ItemStack var63;
                                    if (entityiterator instanceof LivingEntity _entGetArmor) {
                                        var63 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                                    } else {
                                        var63 = ItemStack.EMPTY;
                                    }

                                    old_health = var63;
                                    if (entityiterator instanceof Player) {
                                        _plr = (Player) entityiterator;
                                        if (_plr.getCooldowns().isOnCooldown(old_health.getItem())) {
                                            continue;
                                        }
                                    }

                                    if (old_health.getItem() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || old_health.getItem() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                                        CompoundTag var64 = old_health.getOrCreateTag();
                                        CompoundTag var10001 = entity.getPersistentData();
                                        if (var64.getDouble("skill" + Math.round(var10001.getDouble("skill"))) >= 100.0) {
                                            logic_a = false;
                                        }
                                    }
                                } while (!logic_a);

                                player = entityiterator instanceof Player;
                                x_knockback = entityiterator.getX() - entity.getX();
                                y_knockback = entityiterator.getY() - entity.getY();
                                z_knockback = entityiterator.getZ() - entity.getZ();
                                dis = Math.sqrt(Math.pow(x_knockback, 2.0) + Math.pow(y_knockback, 2.0) + Math.pow(z_knockback, 2.0));
                                if (dis < (double) Math.max(entity.getBbWidth(), 1.0F) && entity.getPersistentData().getDouble("NameRanged_ranged") != entityiterator.getPersistentData().getDouble("NameRanged")) {
                                    if (!(entityiterator instanceof LivingEntity) && !entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                        entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel) entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "kill @s");
                                    }

                                    if (!entityiterator.isAlive() && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living")))) {
                                        if ((double) entityiterator.getBbHeight() > 0.25) {
                                            if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                                entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel) entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "scale add pehkui:height -0.025 @s");
                                            }

                                            logic_b = true;
                                        }

                                        if ((double) entityiterator.getBbWidth() > 0.25) {
                                            if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                                entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel) entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "scale add pehkui:width -0.025 @s");
                                            }

                                            logic_b = true;
                                        }
                                    }

                                    x_knockback = 0.0;
                                    y_knockback = 0.0;
                                    z_knockback = 0.0;
                                } else {
                                    x_knockback = x_knockback / dis * entity.getPersistentData().getDouble("knockback");
                                    y_knockback = y_knockback / dis * entity.getPersistentData().getDouble("knockback");
                                    z_knockback = z_knockback / dis * entity.getPersistentData().getDouble("knockback");
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
                                if (player) {
                                    if (entity_a == entityiterator) {
                                        if (entityiterator.isShiftKeyDown()) {
                                            continue;
                                        }
                                    } else if (!world.getLevelData().getGameRules().getBoolean(JujutsucraftModGameRules.JUJUTSUPVP)) {
                                        continue;
                                    }

                                    if (entityiterator instanceof Player) {
                                        _plr = (Player) entityiterator;
                                        if (_plr.getAbilities().instabuild) {
                                            continue;
                                        }
                                    }

                                    if (!((new Object() {
                                        public boolean checkGamemode(Entity _ent) {
                                            if (_ent instanceof ServerPlayer _serverPlayer) {
                                                return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
                                            } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
                                                return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
                                            } else {
                                                return false;
                                            }
                                        }
                                    })).checkGamemode(entityiterator)) {
                                        break;
                                    }
                                } else if (entity.getPersistentData().getDouble("NameRanged_ranged") != entityiterator.getPersistentData().getDouble("NameRanged")) {
                                    break;
                                }
                            }

                            if (!(entity_a instanceof LivingEntity) || entity_a != entityiterator || !(entity_a instanceof LivingEntity)) {
                                break;
                            }

                            _livEnt116 = (LivingEntity) entity_a;
                        } while (_livEnt116.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()));
                        EntityVectorProcedure.execute(entityiterator, x_knockback, Math.min(y_knockback, 1.5), z_knockback);
                    }
                }

                entity.getPersistentData().putDouble("Damage", 9.0 * CNT6);
                entity.getPersistentData().putDouble("Range", 4.0 * CNT6);
                RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                entity.getPersistentData().putDouble("Damage", 0.5 * CNT6);
                entity.getPersistentData().putDouble("Range", Math.min(45.0 * CNT6, 75.0));
                Vec3 _center = new Vec3(x_pos, y_pos, z_pos);
                List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(entity.getPersistentData().getDouble("Range") / 2.0), (e) -> {
                    return true;
                }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                    return _entcnd.distanceToSqr(_center);
                })).toList();
                Iterator var54 = _entfound.iterator();

                while (var54.hasNext()) {
                    Entity entityiterator = (Entity) var54.next();
                    if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                        entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) entity.getPersistentData().getDouble("Damage"));
                    }
                }

                if (logic_b && world instanceof Level) {
                    _level = (Level) world;
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 0.25F, 1.0F);
                    } else {
                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 0.25F, 1.0F, false);
                    }
                }

                if (entity.getPersistentData().getBoolean("circle")) {
                    if (entity.getPersistentData().getDouble("cnt1") > 120.0 && !entity.level().isClientSide()) {
                        entity.discard();
                    }
                } else if (entity.getPersistentData().getDouble("cnt1") > 60.0 * (1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1)) {
                    if (entity instanceof BlackHoleEntity && entity_a instanceof LivingEntity) {
                        label392:
                        {
                            entity_a.getPersistentData().putDouble("skill", 0.0);
                            if (entity_a instanceof LivingEntity) {
                                _entity = (LivingEntity) entity_a;
                                _entity.removeEffect(JujutsucraftModMobEffects.STAR_RAGE.get());
                            }

                            if (entity_a instanceof Player && entity_a instanceof Player) {
                                _plr = (Player) entity_a;
                                if (_plr.getAbilities().instabuild) {
                                    break label392;
                                }
                            }

                            if (!entity_a.level().isClientSide() && entity_a.getServer() != null) {
                                entity_a.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity_a.position(), entity_a.getRotationVector(), entity_a.level() instanceof ServerLevel ? (ServerLevel) entity_a.level() : null, 4, entity_a.getName().getString(), entity_a.getDisplayName(), entity_a.level().getServer(), entity_a), "kill @s");
                            }
                        }
                    }

                    if (!entity.level().isClientSide()) {
                        entity.discard();
                    }
                }
            }

            if (!entity.isAlive()) {
                if (entity instanceof BlackHoleEntity && entity_a instanceof LivingEntity) {
                    label394:
                    {
                        entity_a.getPersistentData().putDouble("skill", 0.0);
                        if (entity_a instanceof LivingEntity) {
                            _entity = (LivingEntity) entity_a;
                            _entity.removeEffect(JujutsucraftModMobEffects.STAR_RAGE.get());
                        }

                        if (entity_a instanceof Player && entity_a instanceof Player) {
                            _plr = (Player) entity_a;
                            if (_plr.getAbilities().instabuild) {
                                break label394;
                            }
                        }

                        if (!entity_a.level().isClientSide() && entity_a.getServer() != null) {
                            entity_a.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity_a.position(), entity_a.getRotationVector(), entity_a.level() instanceof ServerLevel ? (ServerLevel) entity_a.level() : null, 4, entity_a.getName().getString(), entity_a.getDisplayName(), entity_a.level().getServer(), entity_a), "kill @s");
                        }
                    }
                }

                if (!entity.level().isClientSide()) {
                    entity.discard();
                }
            }

            SetCustomizedProcedure.execute(world, x, y, z, entity);

        }
    }

}
