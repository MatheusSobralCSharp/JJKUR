package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.entity.ItadoriShinjukuEntity;
import com.jujutsu.jujutsucraftaddon.entity.MalevolentShrineEntity;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.entity.EntityMalevolentShrineEntity;
import net.mcreator.jujutsucraft.entity.EntityTreeEntity;
import net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity;
import net.mcreator.jujutsucraft.entity.SukunaPerfectEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.DomainExpansionCreateBarrierProcedure;
import net.mcreator.jujutsucraft.procedures.MalevolentShrineProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.RotateEntityProcedure;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
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

@Mixin(value = MalevolentShrineProcedure.class, priority = -10000)
public abstract class MalevolentShrine2Mixin {
    /**
     * @author Satushi
     * @reason Change Shrine
     */
    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            double x_pos;
            double y_pos;
            double z_pos;
            double var10000;
            int var10001;
            double dis;
            double pitch;
            double yaw;
            boolean logic_a = false;
            boolean failed = false;
            boolean logic_attack = false;
            Entity entity_a = null;
            double range = 0.0;
            double num1 = 0.0;
            double num2 = 0.0;
            double num3 = 0.0;
            double x_center = 0.0;
            double z_center = 0.0;
            double y_center = 0.0;
            LivingEntity _entity;
            label134:
            {
                x_pos = 0.0;
                y_pos = 0.0;
                z_pos = 0.0;
                dis = 0.0;
                pitch = 0.0;
                yaw = 0.0;
                entity_a = null;
                Entity entity_ = null;
                var10000 = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
                if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity) entity;
                    if (_entity.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        var10001 = _entity.getEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                        break label134;
                    }
                }

                var10001 = 0;
            }

            dis = var10000 * (double) (var10001 > 0 ? 6 : 2);
            double dis2 = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
            entity.getPersistentData().putDouble("select", 1.0);
            DomainExpansionCreateBarrierProcedure.execute(world, x, y, z, entity);
            if (entity.getPersistentData().getDouble("cnt1") > 0.0 && entity.getPersistentData().getDouble("cnt1") == 34.0) {
                if (entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:enchained"))).isDone()
                        && entity instanceof ServerPlayer _plr1 && _plr1.level() instanceof ServerLevel
                        && _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:soul_research"))).isDone() && (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Itadori")) || entity instanceof ItadoriShinjukuEntity) {
                    if (entity.getPersistentData().getDouble("NameRanged") == 0.0) {
                        entity.getPersistentData().putDouble("NameRanged", Math.random());
                    }

                    for (int index0 = 0; index0 < 12; ++index0) {
                        num1 = Math.toRadians(Math.random() * 720.0);

                        int index2;
                        for (index2 = 0; index2 < 32; ++index2) {
                            num2 = Math.random();
                            if (num2 > 0.5) {
                                num2 *= dis2 - 4.0;
                                break;
                            }
                        }

                        x_pos = entity.getPersistentData().getDouble("x_pos_doma") + Math.sin(num1) * num2;
                        y_pos = entity.getPersistentData().getDouble("y_pos_doma") + 1.0;
                        z_pos = entity.getPersistentData().getDouble("z_pos_doma") + Math.cos(num1) * num2;

                        for (index2 = 0; index2 < 16; ++index2) {
                            if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                                ++y_pos;
                            } else if (!world.getBlockState(BlockPos.containing(x_pos, y_pos - 1.0, z_pos)).canOcclude()) {
                                --y_pos;
                            } else if (!world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude() && world.getBlockState(BlockPos.containing(x_pos, y_pos - 1.0, z_pos)).canOcclude()) {
                                y_pos = Math.floor(y_pos);
                                break;
                            }
                        }

                        if (world instanceof ServerLevel _level) {
                            Commands var100002 = _level.getServer().getCommands();
                            CommandSourceStack var10003 = (new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput();
                            double var10002 = Math.random() * 360.0;
                            var100002.performPrefixedCommand(var10003, "summon jujutsucraft:entity_tree ~ ~ ~ {NoAI:1b,Invulnerable:1b,Rotation:[" + var10002 + "F," + (Math.random() - 0.5) * 30.0 + "F]}");
                        }

                        if (!world.getEntitiesOfClass(EntityTreeEntity.class, AABB.ofSize(new Vec3(x_pos, y_pos, z_pos), 1.0, 1.0, 1.0), (e) -> {
                            return true;
                        }).isEmpty()) {
                            entity_a = world.getEntitiesOfClass(EntityTreeEntity.class, AABB.ofSize(new Vec3(x_pos, y_pos, z_pos), 1.0, 1.0, 1.0), (e) -> {
                                return true;
                            }).stream().sorted(((new Object() {
                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble((_entcnd) -> {
                                        return _entcnd.distanceToSqr(_x, _y, _z);
                                    });
                                }
                            })).compareDistOf(x_pos, y_pos, z_pos)).findFirst().orElse(null);
                            entity_a.getPersistentData().putDouble("NameRanged_ranged", entity.getPersistentData().getDouble("NameRanged"));
                            entity_a.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                            ((LivingEntity) entity_a).getAttribute(JujutsucraftModAttributes.SIZE.get()).setBaseValue(2.0 + Math.random());
                        }
                    }

                } else {
                    Level _level;
                    if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity) entity;
                            _entity.swing(InteractionHand.MAIN_HAND, true);
                        }

                        Vec3 _center = new Vec3(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"));
                        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(dis / 2.0), (e) -> {
                            return true;
                        }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                            return _entcnd.distanceToSqr(_center);
                        })).toList();
                        Iterator var29 = _entfound.iterator();

                        while (var29.hasNext()) {
                            Entity entityiterator = (Entity) var29.next();
                            if (entityiterator instanceof LivingEntity) {
                                Entity _ent = entityiterator;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "effect give @s blindness 2 0 true");
                                }
                            }
                        }

                        if (world instanceof Level) {
                            _level = (Level) world;
                            if (!_level.isClientSide()) {
                                _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:wind_chime")), SoundSource.NEUTRAL, 3.0F, 1.0F);
                            } else {
                                _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:wind_chime")), SoundSource.NEUTRAL, 3.0F, 1.0F, false);
                            }
                        }

                        if (world instanceof Level) {
                            _level = (Level) world;
                            if (!_level.isClientSide()) {
                                _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:slow_motion_end")), SoundSource.NEUTRAL, 3.0F, 1.0F);
                            } else {
                                _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:slow_motion_end")), SoundSource.NEUTRAL, 3.0F, 1.0F, false);
                            }
                        }
                    }

                    if (entity.getPersistentData().getDouble("cnt1") > 33.0 && entity.getPersistentData().getDouble("cnt1") == 34.0) {
                        yaw = entity.getYRot();
                        pitch = entity.getXRot();
                        RotateEntityProcedure.execute(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"), entity);
                        entity.setYRot(entity.getYRot());
                        entity.setXRot(0.0F);
                        entity.setYBodyRot(entity.getYRot());
                        entity.setYHeadRot(entity.getYRot());
                        entity.yRotO = entity.getYRot();
                        entity.xRotO = entity.getXRot();
                        LivingEntity _entity2;
                        if (entity instanceof LivingEntity) {
                            _entity2 = (LivingEntity) entity;
                            _entity2.yBodyRotO = _entity2.getYRot();
                            _entity2.yHeadRotO = _entity2.getYRot();
                        }

                        if (!entity.level().isClientSide() && entity.getServer() != null) {
                            entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "effect give @s slowness 1 10 true");
                        }

                        entity.getPersistentData().putDouble("x_pos", entity.getPersistentData().getDouble("x_pos_doma"));
                        entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos_doma"));
                        entity.getPersistentData().putDouble("z_pos", entity.getPersistentData().getDouble("z_pos_doma"));

                        for (int index0 = 0; index0 < 100 && !world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos") - 1.0, entity.getPersistentData().getDouble("z_pos"))).canOcclude(); ++index0) {
                            entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") - 1.0);
                            if (entity.getPersistentData().getDouble("y_pos") <= 0.0) {
                                entity.getPersistentData().putDouble("y_pos", 0.0);
                                break;
                            }
                        }

                        x_pos = entity.getPersistentData().getDouble("x_pos_doma") - Math.cos(Math.toRadians(entity.getYRot() + 90.0F)) * Math.cos(Math.toRadians(0.0)) * (JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius - 5.0);
                        y_pos = entity.getPersistentData().getDouble("y_pos");
                        z_pos = entity.getPersistentData().getDouble("z_pos_doma") - Math.sin(Math.toRadians(entity.getYRot() + 90.0F)) * Math.cos(Math.toRadians(0.0)) * (JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius - 5.0);

                        if (world instanceof ServerLevel) {
                            if (entity instanceof SukunaPerfectEntity || entity instanceof LivingEntity _liv && _liv.hasEffect(JujutsucraftaddonModMobEffects.HEIAN_FORM.get()) || (entity instanceof SukunaFushiguroEntity _fushi && _fushi.getEntityData().get(SukunaFushiguroEntity.DATA_perfect_mode))) {
                                if (world instanceof ServerLevel _level2) {
                                    Commands var32 = _level2.getServer().getCommands();
                                    CommandSourceStack var33 = (new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level2, 4, "", Component.literal(""), _level2.getServer(), null)).withSuppressedOutput();
                                    int var10002 = entity.getDirection() != Direction.NORTH && entity.getDirection() != Direction.SOUTH ? 90 : 0;
                                    var32.performPrefixedCommand(var33, "summon jujutsucraftaddon:malevolent_shrine ~ ~ ~ {Invulnerable:1b,Rotation:[" + var10002 + "F,0F]}");
                                }

                            } else if (world instanceof ServerLevel _level2) {
                                Commands var32 = _level2.getServer().getCommands();
                                CommandSourceStack var33 = (new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level2, 4, "", Component.literal(""), _level2.getServer(), null)).withSuppressedOutput();
                                int var10002 = entity.getDirection() != Direction.NORTH && entity.getDirection() != Direction.SOUTH ? 90 : 0;
                                var32.performPrefixedCommand(var33, "summon jujutsucraft:entity_malevolent_shrine ~ ~ ~ {Invulnerable:1b,Rotation:[" + var10002 + "F,0F]}");
                            }

                            if (entity.getPersistentData().getDouble("NameRanged") == 0.0) {
                                entity.getPersistentData().putDouble("NameRanged", Math.random());
                            }

                            if (!world.getEntitiesOfClass(EntityMalevolentShrineEntity.class, AABB.ofSize(new Vec3(x_pos, y_pos, z_pos), 1.0, 1.0, 1.0), (e) -> {
                                return true;
                            }).isEmpty()) {
                                entity_a = world.getEntitiesOfClass(EntityMalevolentShrineEntity.class, AABB.ofSize(new Vec3(x_pos, y_pos, z_pos), 1.0, 1.0, 1.0), (e) -> {
                                    return true;
                                }).stream().sorted(((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                        return Comparator.comparingDouble((_entcnd) -> {
                                            return _entcnd.distanceToSqr(_x, _y, _z);
                                        });
                                    }
                                })).compareDistOf(x_pos, y_pos, z_pos)).findFirst().orElse(null);
                                entity_a.getPersistentData().putDouble("NameRanged_ranged", entity.getPersistentData().getDouble("NameRanged"));
                                entity_a.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());

                            }

                            if (!world.getEntitiesOfClass(MalevolentShrineEntity.class, AABB.ofSize(new Vec3(x_pos, y_pos, z_pos), 1.0, 1.0, 1.0), (e) -> {
                                return true;
                            }).isEmpty()) {
                                entity_a = world.getEntitiesOfClass(MalevolentShrineEntity.class, AABB.ofSize(new Vec3(x_pos, y_pos, z_pos), 1.0, 1.0, 1.0), (e) -> {
                                    return true;
                                }).stream().sorted(((new Object() {
                                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                        return Comparator.comparingDouble((_entcnd) -> {
                                            return _entcnd.distanceToSqr(_x, _y, _z);
                                        });
                                    }
                                })).compareDistOf(x_pos, y_pos, z_pos)).findFirst().orElse(null);
                                entity_a.getPersistentData().putDouble("NameRanged_ranged", entity.getPersistentData().getDouble("NameRanged"));
                                entity_a.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                            }

                            if (world instanceof Level) {
                                _level = (Level) world;
                                if (!_level.isClientSide()) {
                                    _level.playSound(null, BlockPos.containing(x_pos, y_pos, z_pos), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:piano_horror")), SoundSource.NEUTRAL, 3.0F, 0.75F);
                                } else {
                                    _level.playLocalSound(x_pos, y_pos, z_pos, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:piano_horror")), SoundSource.NEUTRAL, 3.0F, 0.75F, false);
                                }
                            }

                            entity.getPersistentData().putDouble("y_pos_doma", y_pos + 1.0);
                            entity.setYRot((float) yaw);
                            entity.setXRot((float) pitch);
                            entity.setYBodyRot(entity.getYRot());
                            entity.setYHeadRot(entity.getYRot());
                            entity.yRotO = entity.getYRot();
                            entity.xRotO = entity.getXRot();
                            if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity) entity;
                                _entity.yBodyRotO = _entity.getYRot();
                                _entity.yHeadRotO = _entity.getYRot();
                            }
                        }
                    }
                }
            }
            PlayAnimationProcedure.execute(world, entity);
        }
    }
}
