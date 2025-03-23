package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.procedures.RabbitDarknessProcedure;
import net.mcreator.jujutsucraft.entity.HoshiKiraraEntity;
import net.mcreator.jujutsucraft.entity.RabbitEscapeEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.DespawnTenShadowsTechniqueProcedure;
import net.mcreator.jujutsucraft.procedures.KeyChangeTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.SummonRabbitEscapeProcedure;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
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

@Mixin(value = SummonRabbitEscapeProcedure.class, priority = -10000)
public abstract class SummonRabbitEscapeProcedureMixin {
    /**
     * @author Satushi
     * @reason Adding Darkness to Rabbit Escape
     */
    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            boolean logic_a = false;
            boolean logic_b = false;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double yaw = 0.0;
            double picth = 0.0;
            double NUM_SUM = 0.0;
            double dis = 0.0;
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
                entity.getPersistentData().putDouble("cnt4", 0.025);
                DespawnTenShadowsTechniqueProcedure.execute(world, x, y, z, entity);
            }

            if (entity.getPersistentData().getDouble("cnt1") < 15.0) {
                PlayAnimationProcedure.execute(world, entity);
                ItemStack var10000;
                if (entity instanceof LivingEntity _entGetArmor) {
                    var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                } else {
                    var10000 = ItemStack.EMPTY;
                }

                var10000.getOrCreateTag().putDouble("P_ANIME1", 20.0);
            }

            if (entity.getPersistentData().getDouble("cnt1") > 5.0 && entity.getPersistentData().getDouble("cnt1") < 26.0) {
                yaw = entity.getYRot();
                picth = entity.getXRot();
                if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
                    entity.getPersistentData().putDouble("friend_num", Math.random());
                }

                for (int index0 = 0; index0 < 2; ++index0) {
                    Entity _ent = entity;
                    _ent.setYRot((float) (yaw + Math.random() * 180.0 - 90.0));
                    _ent.setXRot((float) (Math.random() * 22.5 - 11.25));
                    _ent.setYBodyRot(_ent.getYRot());
                    _ent.setYHeadRot(_ent.getYRot());
                    _ent.yRotO = _ent.getYRot();
                    _ent.xRotO = _ent.getXRot();
                    if (_ent instanceof LivingEntity _entity) {
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                    }

                    dis = 1.0 + Math.random() * 5.0;
                    x_pos = (double) entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + Math.random() - 0.5;
                    y_pos = (double) entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + Math.random() - 0.5;
                    z_pos = (double) entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + Math.random() - 0.5;
                    ServerLevel _level;
                    if (world instanceof ServerLevel) {
                        _level = (ServerLevel) world;
                        _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 10, 0.25, 0.25, 0.25, 0.0);
                    }

                    if (world instanceof Level _level2) {
                        if (!_level2.isClientSide()) {
                            _level2.playSound(null, BlockPos.containing(x_pos, y_pos, z_pos), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.pickup")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                        } else {
                            _level2.playLocalSound(x_pos, y_pos, z_pos, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.pickup")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                        }
                    }

                    if (world instanceof ServerLevel) {
                        _level = (ServerLevel) world;
                        Entity entityToSpawn = ((EntityType) JujutsucraftModEntities.RABBIT_ESCAPE.get()).spawn(_level, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                            entityToSpawn.setYRot((float) yaw);
                            entityToSpawn.setYBodyRot((float) yaw);
                            entityToSpawn.setYHeadRot((float) yaw);
                            entityToSpawn.setXRot((float) picth);
                        }
                    }

                    RabbitDarknessProcedure.execute(world, x, y, z);

                    Vec3 _center = new Vec3(x_pos, y_pos, z_pos);
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> {
                        return true;
                    }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                        return _entcnd.distanceToSqr(_center);
                    })).toList();
                    Iterator var27 = _entfound.iterator();

                    while (var27.hasNext()) {
                        Entity entityiterator = (Entity) var27.next();
                        if (entityiterator instanceof RabbitEscapeEntity && entityiterator.getPersistentData().getDouble("friend_num2") == 0.0) {
                            label135:
                            {
                                entityiterator.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                                entityiterator.getPersistentData().putDouble("friend_num2", entity.getPersistentData().getDouble("friend_num"));
                                if (entity.getPersistentData().getDouble("TenShadowsTechnique8") != 1.0) {
                                    label131:
                                    {
                                        if (entity instanceof ServerPlayer _plr27) {
                                            if (_plr27.level() instanceof ServerLevel && _plr27.getAdvancements().getOrStartProgress(_plr27.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:skill_rabbit_escape"))).isDone()) {
                                                break label131;
                                            }
                                        }

                                        entityiterator.getPersistentData().putString("TARGET_UUID", entity.getStringUUID());
                                        entityiterator.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                                        break label135;
                                    }
                                }

                                entityiterator.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                                entityiterator.getPersistentData().putBoolean("Ambush", true);
                                entityiterator.getPersistentData().putBoolean("Player", entity instanceof Player || entity.getPersistentData().getBoolean("Player"));
                                entityiterator.getPersistentData().putBoolean("JujutsuSorcerer", entity.getPersistentData().getBoolean("JujutsuSorcerer"));
                                entityiterator.getPersistentData().putBoolean("CurseUser", entity.getPersistentData().getBoolean("CurseUser"));
                            }

                            if (entity instanceof Player) {
                                entityiterator.getPersistentData().putDouble("BaseCursePower", Math.max(Math.floor(entity.getPersistentData().getDouble("cnt10") / 40.0), 1.0));
                            }
                            break;
                        }
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

                if (entity.getPersistentData().getDouble("cnt1") >= 25.0) {
                    entity.getPersistentData().putDouble("TenShadowsTechnique8", -1.0);
                    boolean _setval = true;
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                        capability.noChangeTechnique = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                    KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                }
            }

            if (entity.getPersistentData().getDouble("cnt1") > 35.0) {
                entity.getPersistentData().putDouble("skill", 0.0);
                Vec3 _center = new Vec3(x, y, z);
                List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(16.0), (e) -> {
                    return true;
                }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                    return _entcnd.distanceToSqr(_center);
                })).toList();
                Iterator var41 = _entfound.iterator();

                while (var41.hasNext()) {
                    Entity entityiterator = (Entity) var41.next();
                    if (entityiterator instanceof HoshiKiraraEntity) {
                        entityiterator.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(x, y, z));
                        if (world instanceof ServerLevel _level) {
                            _level.sendParticles(ParticleTypes.HEART, entityiterator.getX(), entityiterator.getY() + (double) entityiterator.getBbHeight(), entityiterator.getZ(), 1, 0.0, 0.0, 0.0, 0.0);
                        }
                    }
                }
            }

        }
    }
}
