package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.entity.BlueEntity;
import net.mcreator.jujutsucraft.entity.GojoSatoruEntity;
import net.mcreator.jujutsucraft.entity.PurpleEntity;
import net.mcreator.jujutsucraft.entity.RedEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.*;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
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

@Mixin(value = HollowPurpleProcedure.class, priority = -10000)
public abstract class HollowPurpleMixin {

    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            boolean logic_a = false;
            double rnd = 0.0;
            double z_pos = 0.0;
            double dis = 0.0;
            double y_pos = 0.0;
            double x_pos = 0.0;
            double HP = 0.0;
            double rad = 0.0;
            double rad_now = 0.0;
            double yaw = 0.0;
            double pitch = 0.0;
            double x_pos2 = 0.0;
            double y_pos2 = 0.0;
            double z_pos2 = 0.0;
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            LivingEntity _entity;
            if (entity instanceof LivingEntity) {
                _entity = (LivingEntity) entity;
                if (!_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int) entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
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

            double var54;
            if (var10000 instanceof LivingEntity) {
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                var54 = var10000.getX();
                LivingEntity var10001;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10001 = _mobEnt.getTarget();
                } else {
                    var10001 = null;
                }

                double var55 = var10001.getY();
                LivingEntity var10002;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10002 = _mobEnt.getTarget();
                } else {
                    var10002 = null;
                }

                var55 += (double) var10002.getBbHeight() * 0.5;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10002 = _mobEnt.getTarget();
                } else {
                    var10002 = null;
                }

                RotateEntityProcedure.execute(var54, var55, var10002.getZ(), entity);
            }

            entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
            entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
            entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
            if (!(entity instanceof Player) && entity instanceof LivingEntity) {
                _entity = (LivingEntity) entity;
                if (!_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 15, 9, false, false));
                }
            }

            Entity entityiterator;
            ServerLevel _level;
            Vec3 _center;
            List _entfound;
            Iterator var45;
            Commands var56;
            int var57;
            CommandSourceStack var59;
            long var60;
            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
                if (entity instanceof GojoSatoruEntity && (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_CHESTPLATE.get().asItem()){
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        if (_entity.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                            _entity.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(20010.0);
                        }
                    }

                    {
                        Entity _ent = entity;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                    "particle jjkueffects:red_and_blue ~ ~1 ~ 0 0 0 1 1 force");
                        }
                    }

                    if (!(entity instanceof LivingEntity _livEnt50 && _livEnt50.hasEffect(JujutsucraftaddonModMobEffects.MURASAKI_EFFECT.get()))) {
                        if (entity instanceof LivingEntity _entity8 && !_entity8.level().isClientSide())
                            _entity8.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MURASAKI_EFFECT.get(), 240, 1, false, false));

                    }

                    if (entity instanceof LivingEntity _entity4 && !_entity4.level().isClientSide())
                        _entity4.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.WORLD_GOJO.get(), 240, 1, false, false));

                    PlayAnimationProcedure.execute(world, entity);
                }

                if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity) entity;
                    if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 15, 9, false, false));
                    }
                }

                label317:
                {
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity) entity;
                        if (_entity.hasEffect(MobEffects.DAMAGE_BOOST)) {
                            var57 = _entity.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                            break label317;
                        }
                    }

                    var57 = 0;
                }

                HP = 40 + var57 * 20;
                pitch = Math.toRadians(entity.getXRot());
                yaw = Math.toRadians(entity.getYRot() + 90.0F - 40.0F);
                x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (1.5 + (double) entity.getBbWidth());
                y_pos = entity.getY() + (double) entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * (1.5 + (double) entity.getBbWidth());
                z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (1.5 + (double) entity.getBbWidth());
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel) world;
                    var56 = _level.getServer().getCommands();
                    var59 = (new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput();
                    var60 = Math.round(HP);
                    var56.performPrefixedCommand(var59, "summon jujutsucraft:red ~ ~ ~ {Invulnerable:1b,Health:" + var60 + "f,Attributes:[{Name:generic.max_health,Base:" + Math.round(HP) + "}],Rotation:[" + entity.getYRot() + "F," + entity.getXRot() + "F]}");
                }

                _center = new Vec3(x_pos, y_pos, z_pos);
                Vec3 final_center = _center;
                _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> {
                    return true;
                }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                    return _entcnd.distanceToSqr(final_center);
                })).toList();
                var45 = _entfound.iterator();

                while (var45.hasNext()) {
                    entityiterator = (Entity) var45.next();
                    if (entityiterator instanceof RedEntity && entityiterator.getPersistentData().getDouble("NameRanged_ranged") == 0.0) {
                        SetRangedAmmoProcedure.execute(entity, entityiterator);
                        entityiterator.getPersistentData().putBoolean("flag_purple", true);
                        break;
                    }
                }


                yaw = Math.toRadians(entity.getYRot() + 90.0F + 40.0F);
                x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (1.5 + (double) entity.getBbWidth());
                y_pos = entity.getY() + (double) entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * (1.5 + (double) entity.getBbWidth());
                z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (1.5 + (double) entity.getBbWidth());
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel) world;
                    var56 = _level.getServer().getCommands();
                    var59 = (new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput();
                    var60 = Math.round(HP);
                    var56.performPrefixedCommand(var59, "summon jujutsucraft:blue ~ ~ ~ {Invulnerable:1b,Health:" + var60 + "f,Attributes:[{Name:generic.max_health,Base:" + Math.round(HP) + "}],Rotation:[" + entity.getYRot() + "F," + entity.getXRot() + "F]}");
                }

                _center = new Vec3(x_pos, y_pos, z_pos);
                Vec3 final_center1 = _center;
                _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> {
                    return true;
                }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                    return _entcnd.distanceToSqr(final_center1);
                })).toList();
                var45 = _entfound.iterator();

                while (var45.hasNext()) {
                    entityiterator = (Entity) var45.next();
                    if (entityiterator instanceof BlueEntity && entityiterator.getPersistentData().getDouble("NameRanged_ranged") == 0.0) {
                        SetRangedAmmoProcedure.execute(entity, entityiterator);
                        entityiterator.getPersistentData().putBoolean("flag_purple", true);
                        break;
                    }
                }
            } else {
                if (entity.getPersistentData().getDouble("cnt1") <= 20.0) {
                    if (!(entity instanceof GojoSatoruEntity)){
                        if (entity instanceof LivingEntity _liv && !_liv.hasEffect(JujutsucraftaddonModMobEffects.MURASAKI_EFFECT.get())) {
                            _entity = (LivingEntity)entity;
                            if (_entity.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                                _entity.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(20.0);
                            }
                            PlayAnimationProcedure.execute(world, entity);
                        }
                    }

                }
                if (entity.getPersistentData().getDouble("cnt1") <= 10.0) {
                    _center = new Vec3(x, y, z);
                    Vec3 final_center2 = _center;
                    _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(8.0), (e) -> {
                        return true;
                    }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                        return _entcnd.distanceToSqr(final_center2);
                    })).toList();
                    var45 = _entfound.iterator();

                    while (var45.hasNext()) {
                        entityiterator = (Entity) var45.next();
                        if (entity != entityiterator && entity.getPersistentData().getDouble("NameRanged") == entityiterator.getPersistentData().getDouble("NameRanged_ranged") && entityiterator.getPersistentData().getBoolean("flag_purple")) {
                            logic_a = true;
                            if (entityiterator instanceof RedEntity) {
                                yaw = Math.toRadians((double) (entity.getYRot() + 90.0F) + Math.max(40.0 - entity.getPersistentData().getDouble("cnt1") * 4.0, 0.0));
                            } else if (entityiterator instanceof BlueEntity) {
                                yaw = Math.toRadians((double) (entity.getYRot() + 90.0F) + Math.max(40.0 - entity.getPersistentData().getDouble("cnt1") * 4.0, 0.0));
                            } else {
                                logic_a = false;
                            }

                            if (logic_a) {
                                pitch = Math.toRadians(entity.getXRot());
                                x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (1.5 + (double) entity.getBbWidth());
                                y_pos = entity.getY() + (double) entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * (1.5 + (double) entity.getBbWidth());
                                z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (1.5 + (double) entity.getBbWidth());
                                Entity _ent = entityiterator;
                                _ent.teleportTo(x_pos, y_pos, z_pos);
                                if (_ent instanceof ServerPlayer _serverPlayer) {
                                    _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, _ent.getYRot(), _ent.getXRot());
                                }
                            }
                        }
                    }

                    if (entity.getPersistentData().getDouble("cnt1") == 10.0) {
                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel) world;
                            _level.sendParticles(ParticleTypes.FLASH, x_pos, y_pos, z_pos, 5, 0.25, 0.25, 0.25, 0.0);
                        }

                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel) world;
                            _level.sendParticles(ParticleTypes.FLASH, x_pos2, y_pos2, z_pos2, 5, 0.25, 0.25, 0.25, 0.0);
                        }
                    }
                } else if (entity.getPersistentData().getDouble("cnt1") <= 20.0) {
                    if (entity.getPersistentData().getDouble("cnt1") >= 19.0) {
                        Level _level2;
                        if (Math.random() < 0.1 && world instanceof Level) {
                            _level2 = (Level) world;
                            if (!(entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(JujutsucraftaddonModMobEffects.MURASAKI_EFFECT.get()))) {
                                if (!_level2.isClientSide()) {
                                    _level2.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                } else {
                                    _level2.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                }
                            }
                        }

                        if (entity instanceof Mob) {
                            _mobEnt = (Mob) entity;
                            var10000 = _mobEnt.getTarget();
                        } else {
                            var10000 = null;
                        }

                        if (var10000 instanceof LivingEntity) {
                            if (!(entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(JujutsucraftaddonModMobEffects.MURASAKI_EFFECT.get()))) {
                                entity.getPersistentData().putBoolean("PRESS_Z", false);
                            }
                            if (GetDistanceNearestEnemyProcedure.execute(world, x, y, z, entity) > 12.0) {
                                label335:
                                {
                                    if (entity instanceof Mob) {
                                        _mobEnt = (Mob) entity;
                                        var10000 = _mobEnt.getTarget();
                                    } else {
                                        var10000 = null;
                                    }

                                    if (var10000.getPersistentData().getDouble("skill") != 0.0) {
                                        label336:
                                        {
                                            if (entity instanceof Mob) {
                                                _mobEnt = (Mob) entity;
                                                var10000 = _mobEnt.getTarget();
                                            } else {
                                                var10000 = null;
                                            }

                                            if (var10000.getPersistentData().getDouble("skill") != 0.0) {
                                                if (entity instanceof Mob _mobEnt2) {
                                                    var10000 = _mobEnt2.getTarget();
                                                } else {
                                                    var10000 = null;
                                                }

                                                if (var10000.getPersistentData().getBoolean("attack")) {
                                                    break label336;
                                                }
                                            }

                                            if (entity instanceof Mob _mobEnt3) {
                                                var10000 = _mobEnt3.getTarget();
                                            } else {
                                                var10000 = null;
                                            }

                                            if (var10000.getPersistentData().getDouble("Damage") != 0.0) {
                                                break label335;
                                            }
                                        }
                                    }

                                    if (entity instanceof Mob _mobEnt4) {
                                        var10000 = _mobEnt4.getTarget();
                                    } else {
                                        var10000 = null;
                                    }

                                    if (var10000 != entity) {
                                        entity.getPersistentData().putBoolean("PRESS_Z", true);
                                    }
                                }
                            }

                            if (!(entity instanceof GojoSatoruEntity)) {
                                if (!(entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(JujutsucraftaddonModMobEffects.MURASAKI_EFFECT.get()))) {
                                    entity.getPersistentData().putBoolean("PRESS_Z", false);
                                }
                            }
                            if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_CHESTPLATE.get().asItem()) {
                                if (entity.getPersistentData().getDouble("cnt6") >= 5.0 ) {
                                    if (!(entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(JujutsucraftaddonModMobEffects.MURASAKI_EFFECT.get()))) {
                                        entity.getPersistentData().putBoolean("PRESS_Z", false);
                                    }
                                }
                            } else {
                                if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                                    if (!(entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(JujutsucraftaddonModMobEffects.MURASAKI_EFFECT.get()))) {
                                        entity.getPersistentData().putBoolean("PRESS_Z", false);
                                    }
                                }
                            }
                        }

                        if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                            entity.getPersistentData().putDouble("cnt1", 19.0);
                            if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity) entity;
                                if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 9, 5, false, false));
                                }
                            }

                            yaw = Math.toRadians(entity.getYRot() + 90.0F);
                            pitch = Math.toRadians(entity.getXRot());
                            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (1.5 + (double) entity.getBbWidth());
                            y_pos = entity.getY() + (double) entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * (1.5 + (double) entity.getBbWidth());
                            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (1.5 + (double) entity.getBbWidth());
                            if (!(entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(JujutsucraftaddonModMobEffects.MURASAKI_EFFECT.get()))) {
                                if (world instanceof ServerLevel) {
                                    _level = (ServerLevel) world;
                                    _level.sendParticles(JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), x_pos, y_pos, z_pos, (int) (1.0 + entity.getPersistentData().getDouble("cnt6")), 0.25, 0.25, 0.25, 1.0);
                                }
                            }


                            if (entity.getPersistentData().getDouble("cnt6") < 4.0) {
                                entity.getPersistentData().putDouble("cnt5", entity.getPersistentData().getDouble("cnt5") + 1.0);
                                if (entity.getPersistentData().getDouble("cnt5") > 20.0) {
                                    entity.getPersistentData().putDouble("cnt5", 0.0);
                                    entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 1.0);
                                    if (entity instanceof Player _player) {
                                        if (!_player.level().isClientSide()) {
                                            CompoundTag var61 = entity.getPersistentData();
                                            _player.displayClientMessage(Component.literal("§l\"" + Component.translatable("chant.jujutsucraft.purple" + Math.round(var61.getDouble("cnt6"))).getString() + "\""), false);
                                        }
                                    }

                                    if (entity instanceof Player) {
                                        double _setval = entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCursePowerChange - 50.0;
                                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                                            capability.PlayerCursePowerChange = _setval;
                                            capability.syncPlayerVariables(entity);
                                        });
                                    }
                                }
                            } else if (entity.getPersistentData().getDouble("cnt6") < 6.0) {
                                entity.getPersistentData().putDouble("cnt6", 6.0);
                                if (world instanceof Level) {
                                    _level2 = (Level) world;
                                    if (!_level2.isClientSide()) {
                                        _level2.explode(null, x_pos, y_pos, z_pos, 0.0F, Level.ExplosionInteraction.NONE);
                                    }
                                }

                                if (world instanceof ServerLevel) {
                                    _level = (ServerLevel) world;
                                    _level.sendParticles(ParticleTypes.FLASH, x_pos, y_pos, z_pos, 10, 0.25, 0.25, 0.25, 1.5);
                                }

                                if (!(entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(JujutsucraftaddonModMobEffects.MURASAKI_EFFECT.get()))) {
                                    if (world instanceof Level) {
                                        _level2 = (Level) world;
                                        if (!_level2.isClientSide()) {
                                            _level2.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                        } else {
                                            _level2.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                     if (entity instanceof LivingEntity _liv && !_liv.hasEffect(JujutsucraftaddonModMobEffects.MURASAKI_EFFECT.get())) {
                         if (entity instanceof LivingEntity) {
                             _entity = (LivingEntity) entity;
                             if (_entity.getAttributes().hasAttribute((Attribute) JujutsucraftModAttributes.ANIMATION_1.get())) {
                                 _entity.getAttribute((Attribute) JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(107.0);
                             }
                         }

                         PlayAnimationProcedure.execute(world, entity);
                     }
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 9, 20, false, false));
                        }
                    }

                    if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
                        label289:
                        {
                            entity.getPersistentData().putDouble("cnt2", 1.0);
                            yaw = Math.toRadians(entity.getYRot() + 90.0F);
                            pitch = Math.toRadians(entity.getXRot());
                            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (1.5 + (double) entity.getBbWidth());
                            y_pos = entity.getY() + (double) entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * (1.5 + (double) entity.getBbWidth());
                            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (1.5 + (double) entity.getBbWidth());
                            if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity) entity;
                                if (_entity.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var57 = _entity.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label289;
                                }
                            }

                            var57 = 0;
                        }

                        HP = 400 + var57 * 40;
                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel) world;
                            var56 = _level.getServer().getCommands();
                            var59 = (new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput();
                            var60 = Math.round(HP);
                            var56.performPrefixedCommand(var59, "summon jujutsucraft:purple ~ ~ ~ {Health:" + var60 + "f,Attributes:[{Name:generic.max_health,Base:" + Math.round(HP) + "}],Rotation:[" + entity.getYRot() + "F," + entity.getXRot() + "F]}");
                        }

                        _center = new Vec3(x_pos, y_pos, z_pos);
                        Vec3 final_center3 = _center;
                        _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> {
                            return true;
                        }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                            return _entcnd.distanceToSqr(final_center3);
                        })).toList();
                        var45 = _entfound.iterator();

                        while (var45.hasNext()) {
                            entityiterator = (Entity) var45.next();
                            if (entityiterator instanceof PurpleEntity && entityiterator.getPersistentData().getDouble("NameRanged_ranged") == 0.0) {
                                SetRangedAmmoProcedure.execute(entity, entityiterator);
                                ((LivingEntity) entityiterator).getAttribute(JujutsucraftModAttributes.SIZE.get()).setBaseValue(8.0 * (0.5 + entity.getPersistentData().getDouble("cnt6") * 0.2));
                                entityiterator.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6"));
                                if (entity instanceof Player) {
                                    if (entity.getPersistentData().getDouble("cnt6") >= 6.0) {
                                        entityiterator.getPersistentData().putBoolean("explode", entity.isShiftKeyDown());
                                    }
                                } else {
                                    float var63;
                                    if (entity instanceof LivingEntity _livEnt) {
                                        var63 = _livEnt.getHealth();
                                    } else {
                                        var63 = -1.0F;
                                    }

                                    var54 = var63;
                                    float var62;
                                    if (entity instanceof LivingEntity _livEnt) {
                                        var62 = _livEnt.getMaxHealth();
                                    } else {
                                        var62 = -1.0F;
                                    }

                                    if (var54 < (double) var62 * 0.4) {
                                        entityiterator.getPersistentData().putBoolean("explode", entity instanceof GojoSatoruEntity _entity7 && !_entity7.hasEffect(JujutsucraftaddonModMobEffects.WORLD_GOJO.get()));
                                    }
                                }
                                break;
                            }
                        }
                    }

                    if (entity.getPersistentData().getDouble("cnt1") > 40.0) {
                        entity.getPersistentData().putDouble("skill", 0.0);
                    }
                }
            }

        }
    }

}
