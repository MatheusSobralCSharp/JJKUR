package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.entity.SlotEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.AISLOTProcedure;
import net.mcreator.jujutsucraft.procedures.LogicOwnerExistProcedure;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;

@Mixin(value = AISLOTProcedure.class, remap = false, priority = -10000)
public abstract class AISlotProcedureMixin {
    /**
     * @author Satushi
     * @reason Change Black Flash Chances and Logic
     */


    @Overwrite
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity != null) {
            String animation = "";
            boolean decide = false;
            boolean SUCCESS = false;
            boolean logic_a = false;
            Entity entity_a = null;
            Entity entity_1 = null;
            Entity entity_2 = null;
            Entity entity_3 = null;
            Entity entity_ = null;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double num1 = 0.0;
            double range = 0.0;
            double num2 = 0.0;
            double speed = 0.0;
            double num3 = 0.0;
            if (LogicOwnerExistProcedure.execute(world, entity)) {
                int var10000;
                LivingEntity _livEnt7;
                label701:
                {
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
                    range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
                    x_pos = entity.getX();
                    y_pos = entity.getY() + (double) entity.getBbHeight() * 0.5;
                    z_pos = entity.getZ();
                    if (entity instanceof LivingEntity) {
                        _livEnt7 = (LivingEntity) entity;
                        if (_livEnt7.hasEffect(MobEffects.MOVEMENT_SPEED)) {
                            var10000 = 2;
                            break label701;
                        }
                    }

                    var10000 = 1;
                }

                speed = var10000;
                if (entity_a instanceof LivingEntity) {
                    _livEnt7 = (LivingEntity) entity_a;
                    if (_livEnt7.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        if (!entity_a.getPersistentData().getBoolean("Failed")) {
                            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
                            entity_1 = (new BiFunction<LevelAccessor, String, Entity>() {
                                public Entity apply(LevelAccessor levelAccessor, String uuid) {
                                    if (levelAccessor instanceof ServerLevel serverLevel) {
                                        try {
                                            return serverLevel.getEntity(UUID.fromString(uuid));
                                        } catch (Exception var5) {
                                        }
                                    }

                                    return null;
                                }
                            }).apply(world, entity_a.getPersistentData().getString("SLOT1"));
                            entity_2 = (new BiFunction<LevelAccessor, String, Entity>() {
                                public Entity apply(LevelAccessor levelAccessor, String uuid) {
                                    if (levelAccessor instanceof ServerLevel serverLevel) {
                                        try {
                                            return serverLevel.getEntity(UUID.fromString(uuid));
                                        } catch (Exception var5) {
                                        }
                                    }

                                    return null;
                                }
                            }).apply(world, entity_a.getPersistentData().getString("SLOT2"));
                            entity_3 = (new BiFunction<LevelAccessor, String, Entity>() {
                                public Entity apply(LevelAccessor levelAccessor, String uuid) {
                                    if (levelAccessor instanceof ServerLevel serverLevel) {
                                        try {
                                            return serverLevel.getEntity(UUID.fromString(uuid));
                                        } catch (Exception var5) {
                                        }
                                    }

                                    return null;
                                }
                            }).apply(world, entity_a.getPersistentData().getString("SLOT3"));
                            if (!(entity_1 instanceof SlotEntity) && !entity.level().isClientSide()) {
                                entity.discard();
                            }

                            if (!(entity_2 instanceof SlotEntity) && !entity.level().isClientSide()) {
                                entity.discard();
                            }

                            if (!(entity_3 instanceof SlotEntity) && !entity.level().isClientSide()) {
                                entity.discard();
                            }

                            SlotEntity _datEntI;
                            if (entity instanceof SlotEntity) {
                                _datEntI = (SlotEntity) entity;
                                _datEntI.getEntityData().set(SlotEntity.DATA_ANIMATION_NAME, ((SlotEntity) entity).animationprocedure);
                            }

                            String var64;
                            if (entity instanceof SlotEntity) {
                                _datEntI = (SlotEntity) entity;
                                var64 = _datEntI.getEntityData().get(SlotEntity.DATA_ANIMATION_NAME);
                            } else {
                                var64 = "";
                            }

                            SlotEntity _datEntSetI;
                            ServerLevel _level;
                            if (!var64.contains("slot")) {
                                if (entity instanceof SlotEntity) {
                                    _datEntI = (SlotEntity) entity;
                                    var10000 = _datEntI.getEntityData().get(SlotEntity.DATA_SLOT_MODE);
                                } else {
                                    var10000 = 0;
                                }

                                if (var10000 == 1) {
                                    if (entity.getPersistentData().getDouble("cnt1") >= 20.0 / speed) {
                                        decide = true;
                                    }
                                } else {
                                    if (entity instanceof SlotEntity) {
                                        _datEntI = (SlotEntity) entity;
                                        var10000 = _datEntI.getEntityData().get(SlotEntity.DATA_SLOT_MODE);
                                    } else {
                                        var10000 = 0;
                                    }

                                    if (var10000 == 2) {
                                        if (entity.getPersistentData().getDouble("cnt1") >= 30.0 / speed) {
                                            decide = true;
                                        }
                                    } else {
                                        if (entity instanceof SlotEntity) {
                                            _datEntSetI = (SlotEntity) entity;
                                            var10000 = _datEntSetI.getEntityData().get(SlotEntity.DATA_SLOT_MODE);
                                        } else {
                                            var10000 = 0;
                                        }

                                        if (var10000 == 3) {
                                            if (entity.getPersistentData().getDouble("cnt1") >= 30.0 / speed) {
                                                if (world instanceof ServerLevel _level3) {
                                                    _level3.sendParticles(JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), x_pos, y_pos, z_pos, 5, 1.0, 2.0, 1.0, 0.5);
                                                }

                                                for (int index0 = 0; index0 < 72; ++index0) {
                                                    if (Math.random() < 0.2) {
                                                        if (entity.getPersistentData().getDouble("reach_action") == 1.0) {
                                                            if (world instanceof ServerLevel) {
                                                                _level = (ServerLevel) world;
                                                                _level.sendParticles(JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), entity_a.getPersistentData().getDouble("x_pos_doma") + Math.sin(num1) * (range * 0.5 - 4.0), y_pos + (Math.random() - 0.5) * 5.0, entity_a.getPersistentData().getDouble("z_pos_doma") + Math.cos(num1) * (range * 0.5 - 4.0), 1, 0.1, 0.1, 0.1, 0.0);
                                                            }
                                                        } else if (entity.getPersistentData().getDouble("reach_action") == 2.0 && world instanceof ServerLevel) {
                                                            _level = (ServerLevel) world;
                                                            _level.sendParticles(ParticleTypes.HAPPY_VILLAGER, entity_a.getPersistentData().getDouble("x_pos_doma") + Math.sin(num1) * (range * 0.5 - 4.0), y_pos + (Math.random() - 0.5) * 5.0, entity_a.getPersistentData().getDouble("z_pos_doma") + Math.cos(num1) * (range * 0.5 - 4.0), 1, 0.1, 0.1, 0.1, 0.0);
                                                        }
                                                    }

                                                    num1 += Math.toRadians(10.0 * Math.random());
                                                }
                                            }

                                            if (entity.getPersistentData().getDouble("cnt1") >= 60.0 / speed) {
                                                decide = true;
                                            }
                                        }
                                    }
                                }
                            }

                            EntityDataAccessor var10001;
                            int var10002;
                            LivingEntity _entity;
                            LivingEntity _livEnt;
                            int var65;
                            SynchedEntityData var73;
                            if (decide) {
                                if (world instanceof Level _level4) {
                                    _level4 = (Level) world;
                                    if (!_level4.isClientSide()) {
                                        _level4.playSound(null, BlockPos.containing(x_pos, y_pos, z_pos), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 5.0F, 2.0F);
                                    } else {
                                        _level4.playLocalSound(x_pos, y_pos, z_pos, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 5.0F, 2.0F, false);
                                    }
                                }

                                if (world instanceof Level) {
                                    _level = (ServerLevel) world;
                                    if (!_level.isClientSide()) {
                                        _level.playSound(null, BlockPos.containing(x_pos, y_pos, z_pos), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast_far")), SoundSource.NEUTRAL, 5.0F, 2.0F);
                                    } else {
                                        _level.playLocalSound(x_pos, y_pos, z_pos, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast_far")), SoundSource.NEUTRAL, 5.0F, 2.0F, false);
                                    }
                                }

                                if (world instanceof Level) {
                                    _level = (ServerLevel) world;
                                    if (!_level.isClientSide()) {
                                        _level.playSound(null, BlockPos.containing(x_pos, y_pos, z_pos), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                                    } else {
                                        _level.playLocalSound(x_pos, y_pos, z_pos, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                                    }
                                }

                                if (world instanceof Level) {
                                    _level = (ServerLevel) world;
                                    if (!_level.isClientSide()) {
                                        _level.playSound(null, BlockPos.containing(x_pos, y_pos, z_pos), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:gacon")), SoundSource.NEUTRAL, 5.0F, 2.0F);
                                    } else {
                                        _level.playLocalSound(x_pos, y_pos, z_pos, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:gacon")), SoundSource.NEUTRAL, 5.0F, 2.0F, false);
                                    }
                                }

                                if (world instanceof ServerLevel _level2) {
                                    _level2.sendParticles(ParticleTypes.END_ROD, x_pos, y_pos, z_pos, 25, 1.0, 2.0, 1.0, 0.05);
                                }

                                if (world instanceof ServerLevel _level2) {
                                    _level2.sendParticles(ParticleTypes.CRIT, x_pos, y_pos, z_pos, 25, 1.0, 2.0, 1.0, 0.05);
                                }

                                if (entity instanceof SlotEntity) {
                                    _datEntI = (SlotEntity) entity;
                                    var10000 = _datEntI.getEntityData().get(SlotEntity.DATA_SLOT_MODE);
                                } else {
                                    var10000 = 0;
                                }

                                if (var10000 == 1) {
                                    num1 = Math.random();
                                    if (Math.random() < 0.5) {
                                        if (num1 < 0.3) {
                                            num1 = 1.0;
                                        } else if (num1 < 0.6) {
                                            num1 = 3.0;
                                        } else if (num1 < 0.9) {
                                            num1 = 5.0;
                                        } else {
                                            num1 = 7.0;
                                        }
                                    } else if (num1 < 0.33) {
                                        num1 = 2.0;
                                    } else if (num1 < 0.66) {
                                        num1 = 4.0;
                                    } else {
                                        num1 = 6.0;
                                    }

                                    animation = "slot" + Math.round(num1);
                                    if (entity instanceof SlotEntity) {
                                        _datEntSetI = (SlotEntity) entity;
                                        _datEntSetI.getEntityData().set(SlotEntity.DATA_SLOT_NUM, (int) num1);
                                    }
                                } else {
                                    if (entity instanceof SlotEntity) {
                                        _datEntI = (SlotEntity) entity;
                                        var10000 = _datEntI.getEntityData().get(SlotEntity.DATA_SLOT_MODE);
                                    } else {
                                        var10000 = 0;
                                    }

                                    float var70;
                                    if (var10000 == 2) {
                                        label610:
                                        {
                                            if (entity_1 instanceof SlotEntity) {
                                                if (entity_1 instanceof SlotEntity) {
                                                    _datEntSetI = (SlotEntity) entity_1;
                                                    var10000 = _datEntSetI.getEntityData().get(SlotEntity.DATA_SLOT_NUM);
                                                } else {
                                                    var10000 = 0;
                                                }

                                                if (var10000 > 0) {
                                                    if (entity_1 instanceof SlotEntity) {
                                                        _datEntSetI = (SlotEntity) entity_1;
                                                        var70 = (float) _datEntSetI.getEntityData().get(SlotEntity.DATA_SLOT_NUM);
                                                    } else {
                                                        var70 = 0.0F;
                                                    }

                                                    animation = "slot" + Math.round(var70);
                                                    if (entity instanceof SlotEntity) {
                                                        _datEntSetI = (SlotEntity) entity;
                                                        var73 = _datEntSetI.getEntityData();
                                                        var10001 = SlotEntity.DATA_SLOT_NUM;
                                                        if (entity_1 instanceof SlotEntity) {
                                                            _datEntI = (SlotEntity) entity_1;
                                                            var10002 = _datEntI.getEntityData().get(SlotEntity.DATA_SLOT_NUM);
                                                        } else {
                                                            var10002 = 0;
                                                        }

                                                        var73.set(var10001, var10002);
                                                    }
                                                    break label610;
                                                }
                                            }

                                            num1 = Math.ceil(Math.random() * 7.0);
                                            animation = "slot" + Math.round(num1);
                                            if (entity instanceof SlotEntity) {
                                                _datEntSetI = (SlotEntity) entity;
                                                _datEntSetI.getEntityData().set(SlotEntity.DATA_SLOT_NUM, (int) num1);
                                            }
                                        }

                                        if (entity instanceof SlotEntity) {
                                            _datEntSetI = (SlotEntity) entity;
                                            var10000 = _datEntSetI.getEntityData().get(SlotEntity.DATA_SLOT_NUM);
                                        } else {
                                            var10000 = 0;
                                        }

                                        if (entity_1 instanceof SlotEntity) {
                                            _datEntSetI = (SlotEntity) entity_1;
                                            var65 = _datEntSetI.getEntityData().get(SlotEntity.DATA_SLOT_NUM);
                                        } else {
                                            var65 = 0;
                                        }

                                        if (var10000 == var65) {
                                            Vec3 _center = new Vec3(entity_a.getPersistentData().getDouble("x_pos_doma"), entity_a.getPersistentData().getDouble("y_pos_doma"), entity_a.getPersistentData().getDouble("z_pos_doma"));
                                            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(range / 2.0), (e) -> {
                                                return true;
                                            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                                                return _entcnd.distanceToSqr(_center);
                                            })).toList();
                                            Iterator var35 = _entfound.iterator();

                                            while (var35.hasNext()) {
                                                Entity entityiterator = (Entity) var35.next();
                                                Entity _ent = entityiterator;
                                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "title @s actionbar {\"text\":\"REACH\",\"color\":\"light_purple\",\"bold\":true}");
                                                }
                                            }

                                            if (Math.random() < 0.3) {
                                                entity_3.getPersistentData().putDouble("reach_action", 1.0);
                                                if (world instanceof Level) {
                                                    _level = (ServerLevel) world;
                                                    if (!_level.isClientSide()) {
                                                        _level.playSound(null, BlockPos.containing(entity_3.getX(), entity_3.getY() + (double) entity_3.getBbHeight() * 0.5, entity_3.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                                                    } else {
                                                        _level.playLocalSound(entity_3.getX(), entity_3.getY() + (double) entity_3.getBbHeight() * 0.5, entity_3.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                                                    }
                                                }

                                                if (world instanceof Level) {
                                                    _level = (ServerLevel) world;
                                                    if (!_level.isClientSide()) {
                                                        _level.playSound(null, BlockPos.containing(entity_3.getX(), entity_3.getY() + (double) entity_3.getBbHeight() * 0.5, entity_3.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                                                    } else {
                                                        _level.playLocalSound(entity_3.getX(), entity_3.getY() + (double) entity_3.getBbHeight() * 0.5, entity_3.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                                                    }
                                                }

                                                if (world instanceof ServerLevel _level4) {
                                                    _level4.sendParticles(JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), entity_3.getX(), entity_3.getY() + (double) entity_3.getBbHeight() * 0.5, entity_3.getZ(), 50, 2.0, 2.0, 2.0, 1.0);
                                                }
                                            } else {
                                                entity_3.getPersistentData().putDouble("reach_action", 2.0);
                                                if (world instanceof Level) {
                                                    _level = (ServerLevel) world;
                                                    if (!_level.isClientSide()) {
                                                        _level.playSound(null, BlockPos.containing(entity_3.getX(), entity_3.getY() + (double) entity_3.getBbHeight() * 0.5, entity_3.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                                                    } else {
                                                        _level.playLocalSound(entity_3.getX(), entity_3.getY() + (double) entity_3.getBbHeight() * 0.5, entity_3.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                                                    }
                                                }

                                                if (world instanceof Level) {
                                                    _level = (ServerLevel) world;
                                                    if (!_level.isClientSide()) {
                                                        _level.playSound(null, BlockPos.containing(entity_3.getX(), entity_3.getY() + (double) entity_3.getBbHeight() * 0.5, entity_3.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                                                    } else {
                                                        _level.playLocalSound(entity_3.getX(), entity_3.getY() + (double) entity_3.getBbHeight() * 0.5, entity_3.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                                                    }
                                                }

                                                if (world instanceof ServerLevel _level4) {
                                                    _level4.sendParticles(ParticleTypes.HAPPY_VILLAGER, entity_3.getX(), entity_3.getY() + (double) entity_3.getBbHeight() * 0.5, entity_3.getZ(), 50, 2.0, 2.0, 2.0, 1.0);
                                                }
                                            }
                                        }
                                    } else {
                                        if (entity instanceof SlotEntity) {
                                            _datEntI = (SlotEntity) entity;
                                            var10000 = _datEntI.getEntityData().get(SlotEntity.DATA_SLOT_MODE);
                                        } else {
                                            var10000 = 0;
                                        }

                                        if (var10000 == 3) {
                                            if (entity_1 instanceof SlotEntity) {
                                                if (entity_1 instanceof SlotEntity) {
                                                    _datEntSetI = (SlotEntity) entity_1;
                                                    var70 = (float) _datEntSetI.getEntityData().get(SlotEntity.DATA_SLOT_NUM);
                                                } else {
                                                    var70 = 0.0F;
                                                }

                                                num2 = Math.round(var70);
                                            }

                                            label646:
                                            {
                                                if (entity instanceof LivingEntity) {
                                                    _livEnt = (LivingEntity) entity;
                                                    if (_livEnt.hasEffect(MobEffects.UNLUCK)) {
                                                        var10000 = _livEnt.getEffect(MobEffects.UNLUCK).getAmplifier();
                                                        break label646;
                                                    }
                                                }

                                                var10000 = 0;
                                            }

                                            if (var10000 >= 9) {
                                                num1 = num2 - 1.0;
                                                if (num2 < 1.0) {
                                                    num1 = 7.0;
                                                }
                                            } else {
                                                label639:
                                                {
                                                    if (entity instanceof LivingEntity) {
                                                        _livEnt = (LivingEntity) entity;
                                                        if (_livEnt.hasEffect(MobEffects.LUCK)) {
                                                            var10000 = _livEnt.getEffect(MobEffects.LUCK).getAmplifier();
                                                            break label639;
                                                        }
                                                    }

                                                    var10000 = 0;
                                                }

                                                if (var10000 >= 9) {
                                                    num1 = num2;
                                                } else {
                                                    int index1 = 0;

                                                    while (true) {
                                                        label632:
                                                        {
                                                            if (entity instanceof LivingEntity) {
                                                                _livEnt = (LivingEntity) entity;
                                                                if (_livEnt.hasEffect(MobEffects.LUCK)) {
                                                                    label628:
                                                                    {
                                                                        if (entity instanceof LivingEntity) {
                                                                            _entity = (LivingEntity) entity;
                                                                            if (_entity.hasEffect(MobEffects.LUCK)) {
                                                                                var65 = _entity.getEffect(MobEffects.LUCK).getAmplifier();
                                                                                break label628;
                                                                            }
                                                                        }

                                                                        var65 = 0;
                                                                    }

                                                                    var65 = (var65 + 1) * 2;
                                                                    break label632;
                                                                }
                                                            }

                                                            var65 = 2;
                                                        }

                                                        if (index1 >= var65) {
                                                            break;
                                                        }

                                                        num1 = Math.ceil(Math.random() * 7.0);
                                                        if (num1 != num2) {
                                                            if (!(entity instanceof LivingEntity _livEnt103)) {
                                                                break;
                                                            }

                                                            if (!_livEnt103.hasEffect(MobEffects.LUCK)) {
                                                                break;
                                                            }
                                                        } else if (Math.random() < 0.35) {
                                                            break;
                                                        }

                                                        ++index1;
                                                    }
                                                }
                                            }

                                            animation = "slot" + Math.round(num1);
                                            if (entity instanceof SlotEntity) {
                                                _datEntSetI = (SlotEntity) entity;
                                                _datEntSetI.getEntityData().set(SlotEntity.DATA_SLOT_NUM, (int) num1);
                                            }
                                        }
                                    }
                                }

                                if (entity instanceof SlotEntity) {
                                    ((SlotEntity) entity).setAnimation(animation);
                                }
                            }

                            if (entity instanceof SlotEntity) {
                                _datEntI = (SlotEntity) entity;
                                var10000 = _datEntI.getEntityData().get(SlotEntity.DATA_SLOT_MODE);
                            } else {
                                var10000 = 0;
                            }

                            if (var10000 == 3 && entity.getPersistentData().getDouble("cnt1") == 80.0 / speed) {
                                num1 = 0.0;
                                SUCCESS = false;
                                if (entity_1 instanceof SlotEntity) {
                                    double var74;
                                    if (entity_1 instanceof SlotEntity) {
                                        _datEntI = (SlotEntity) entity_1;
                                        var74 = (double) _datEntI.getEntityData().get(SlotEntity.DATA_SLOT_NUM);
                                    } else {
                                        var74 = 0.0;
                                    }

                                    num1 = var74;
                                    SUCCESS = true;
                                }

                                if (SUCCESS) {
                                    SUCCESS = false;
                                    if (entity_2 instanceof SlotEntity) {
                                        if (entity_2 instanceof SlotEntity) {
                                            _datEntI = (SlotEntity) entity_2;
                                            var65 = _datEntI.getEntityData().get(SlotEntity.DATA_SLOT_NUM);
                                        } else {
                                            var65 = 0;
                                        }

                                        if (num1 == (double) var65) {
                                            SUCCESS = true;
                                        }
                                    }
                                }

                                if (SUCCESS) {
                                    SUCCESS = false;
                                    if (entity_3 instanceof SlotEntity) {
                                        if (entity_3 instanceof SlotEntity) {
                                            _datEntI = (SlotEntity) entity_3;
                                            var65 = _datEntI.getEntityData().get(SlotEntity.DATA_SLOT_NUM);
                                        } else {
                                            var65 = 0;
                                        }

                                        if (num1 == (double) var65) {
                                            SUCCESS = true;
                                        }
                                    }
                                }

                                if (SUCCESS) {
                                    if (world instanceof ServerLevel _level2) {
                                        if (!_level2.isClientSide()) {
                                            _level2.playSound(null, BlockPos.containing(x_pos, y_pos, z_pos), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:hakari1")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                                        } else {
                                            _level2.playLocalSound(x_pos, y_pos, z_pos, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:hakari1")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                                        }
                                    }

                                    entity_1.getPersistentData().putDouble("cnt2", 1.0);
                                    entity_2.getPersistentData().putDouble("cnt2", 1.0);
                                    entity_3.getPersistentData().putDouble("cnt2", 1.0);
                                }
                            }

                            MobEffect var10003;
                            int var10005;
                            MobEffectInstance var68;
                            if (entity.getPersistentData().getDouble("cnt2") > 0.0) {
                                entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
                                if (world instanceof ServerLevel) {
                                    _level = (ServerLevel) world;
                                    _level.sendParticles(ParticleTypes.END_ROD, x_pos, y_pos, z_pos, 10, 1.0, 1.0, 1.0, 0.5);
                                }

                                if (world instanceof ServerLevel) {
                                    _level = (ServerLevel) world;
                                    _level.sendParticles(ParticleTypes.FIREWORK, x_pos, y_pos, z_pos, 1, 1.0, 1.0, 1.0, 0.5);
                                }

                                if (entity instanceof SlotEntity) {
                                    _datEntI = (SlotEntity) entity;
                                    var10000 = _datEntI.getEntityData().get(SlotEntity.DATA_SLOT_MODE);
                                } else {
                                    var10000 = 0;
                                }

                                if (var10000 == 3 && entity_a instanceof LivingEntity) {
                                    _entity = (LivingEntity) entity_a;
                                    if (!_entity.level().isClientSide()) {
                                        label550:
                                        {
                                            var10003 = JujutsucraftModMobEffects.DOMAIN_EXPANSION.get();
                                            if (entity_a instanceof LivingEntity) {
                                                _entity = (LivingEntity) entity_a;
                                                if (_entity.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                    var10005 = _entity.getEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                                    break label550;
                                                }
                                            }

                                            var10005 = 0;
                                        }

                                        var68 = new MobEffectInstance(var10003, 1200, var10005, true, true);
                                        _entity.addEffect(var68);
                                    }
                                }

                                if (Math.random() < 0.05) {
                                    range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
                                    num1 = Math.toRadians(Math.random() * 360.0);
                                    num2 = Math.random() * range - range / 2.0;
                                    x_pos = entity_a.getPersistentData().getDouble("x_pos_doma") + Math.sin(num1) * num2;
                                    y_pos = entity_a.getPersistentData().getDouble("y_pos_doma") + 5.0;
                                    z_pos = entity_a.getPersistentData().getDouble("z_pos_doma") + Math.cos(num1) * num2;
                                    double var66;
                                    CommandSourceStack var69;
                                    Commands var75;
                                    if (Math.random() < 0.25) {
                                        if (world instanceof ServerLevel) {
                                            _level = (ServerLevel) world;
                                            var75 = _level.getServer().getCommands();
                                            var69 = (new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput();
                                            var66 = Math.random();
                                            var75.performPrefixedCommand(var69, "summon firework_rocket ~ ~ ~ {LifeTime:10,FireworksItem:{id:\"firework_rocket\",Count:1,tag:{Fireworks:{Explosions:[{Type:" + Math.round(var66 * 4.0) + ",Flicker:0b,Trail:0b,Colors:[I;16711680],FadeColors:[I;16711680]}]}}}}");
                                        }
                                    } else if (Math.random() < 0.25) {
                                        if (world instanceof ServerLevel) {
                                            _level = (ServerLevel) world;
                                            var75 = _level.getServer().getCommands();
                                            var69 = (new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput();
                                            var66 = Math.random();
                                            var75.performPrefixedCommand(var69, "summon firework_rocket ~ ~ ~ {LifeTime:10,FireworksItem:{id:\"firework_rocket\",Count:1,tag:{Fireworks:{Explosions:[{Type:" + Math.round(var66 * 4.0) + ",Flicker:0b,Trail:0b,Colors:[I;16774912],FadeColors:[I;16774912]}]}}}}");
                                        }
                                    } else if (Math.random() < 0.25) {
                                        if (world instanceof ServerLevel) {
                                            _level = (ServerLevel) world;
                                            var75 = _level.getServer().getCommands();
                                            var69 = (new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput();
                                            var66 = Math.random();
                                            var75.performPrefixedCommand(var69, "summon firework_rocket ~ ~ ~ {LifeTime:10,FireworksItem:{id:\"firework_rocket\",Count:1,tag:{Fireworks:{Explosions:[{Type:" + Math.round(var66 * 4.0) + ",Flicker:0b,Trail:0b,Colors:[I;43775],FadeColors:[I;43775]}]}}}}");
                                        }
                                    } else if (world instanceof ServerLevel) {
                                        _level = (ServerLevel) world;
                                        var75 = _level.getServer().getCommands();
                                        var69 = (new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput();
                                        var66 = Math.random();
                                        var75.performPrefixedCommand(var69, "summon firework_rocket ~ ~ ~ {LifeTime:10,FireworksItem:{id:\"firework_rocket\",Count:1,tag:{Fireworks:{Explosions:[{Type:" + Math.round(var66 * 4.0) + ",Flicker:0b,Trail:0b,Colors:[I;65442],FadeColors:[I;65442]}]}}}}");
                                    }
                                }

                                if (entity.getPersistentData().getDouble("cnt2") >= 50.0) {
                                    if (entity instanceof SlotEntity) {
                                        _datEntI = (SlotEntity) entity;
                                        var10000 = _datEntI.getEntityData().get(SlotEntity.DATA_SLOT_MODE);
                                    } else {
                                        var10000 = 0;
                                    }

                                    if (var10000 == 3) {
                                        if (entity instanceof SlotEntity) {
                                            _datEntI = (SlotEntity) entity;
                                            var10000 = _datEntI.getEntityData().get(SlotEntity.DATA_SLOT_NUM);
                                        } else {
                                            var10000 = 0;
                                        }

                                        if (var10000 % 2 == 1) {
                                            entity_a.getPersistentData().putDouble("mode_hakari", 2.0);
                                        } else if (Math.random() < 0.5) {
                                            entity_a.getPersistentData().putDouble("mode_hakari", 1.0);
                                        } else {
                                            entity_a.getPersistentData().putDouble("mode_hakari", 40.0);
                                        }

                                        if (entity_a instanceof LivingEntity) {
                                            _entity = (LivingEntity) entity_a;
                                            if (!_entity.level().isClientSide()) {
                                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.JACKPOT.get(), 5020, 0, true, true));
                                                if ((entity_a instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MobEffects.LUCK) ? _livEnt2.getEffect(MobEffects.LUCK).getAmplifier() : 0) == 4) {
                                                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.GOJO_AWAKENING.get(), 5020, 0, true, true));
                                                }
                                                _entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 5020, (entity_a instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MobEffects.LUCK) ? _livEnt2.getEffect(MobEffects.LUCK).getAmplifier() : 0) + 1, false, false));
                                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.JACKPOT.get(), 20, 0, true, true));
                                            }
                                        }

                                        if (entity_a instanceof LivingEntity) {
                                            _entity = (LivingEntity) entity_a;
                                            _entity.removeEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                                        }
                                    }

                                    if (!entity.level().isClientSide()) {
                                        entity.discard();
                                    }

                                    return;
                                }
                            } else if (entity.getPersistentData().getDouble("cnt1") >= Math.max(80.0 / speed, 50.0)) {
                                label590:
                                {
                                    if (entity instanceof LivingEntity) {
                                        _livEnt = (LivingEntity) entity;
                                        if (_livEnt.hasEffect(MobEffects.UNLUCK)) {
                                            var10000 = _livEnt.getEffect(MobEffects.UNLUCK).getAmplifier();
                                            break label590;
                                        }
                                    }

                                    var10000 = 0;
                                }

                                if (var10000 >= 9) {
                                    if (entity.getPersistentData().getDouble("cnt1") >= Math.max(100.0 / speed, 50.0)) {
                                        if (entity instanceof SlotEntity) {
                                            _datEntI = (SlotEntity) entity;
                                            var10000 = _datEntI.getEntityData().get(SlotEntity.DATA_SLOT_MODE);
                                        } else {
                                            var10000 = 0;
                                        }

                                        float var71;
                                        if (var10000 == 3 && entity_a.isAlive()) {
                                            if (world instanceof ServerLevel _level4) {
                                                if (!_level4.isClientSide()) {
                                                    _level4.playSound(null, BlockPos.containing(entity_a.getX(), entity_a.getY() + (double) entity_a.getBbHeight() * 0.5, entity_a.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                                } else {
                                                    _level4.playLocalSound(entity_a.getX(), entity_a.getY() + (double) entity_a.getBbHeight() * 0.5, entity_a.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                                }
                                            }

                                            ServerLevel _level3;
                                            if (world instanceof ServerLevel) {
                                                _level3 = (ServerLevel) world;
                                                _level3.sendParticles(JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS.get(), entity_a.getX(), entity_a.getY() + (double) entity_a.getBbHeight() * 0.5, entity_a.getZ(), 50, 2.0, 2.0, 2.0, 0.25);
                                            }

                                            if (world instanceof ServerLevel) {
                                                _level3 = (ServerLevel) world;
                                                _level3.sendParticles(JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS_SMALL.get(), entity_a.getX(), entity_a.getY() + (double) entity_a.getBbHeight() * 0.5, entity_a.getZ(), 50, 1.0, 1.0, 1.0, 0.25);
                                            }

                                            if (entity_a instanceof LivingEntity) {
                                                _entity = (LivingEntity) entity_a;
                                                if (entity_a instanceof LivingEntity) {
                                                    _livEnt = (LivingEntity) entity_a;
                                                    var71 = _livEnt.getHealth();
                                                } else {
                                                    var71 = -1.0F;
                                                }

                                                double var72 = var71;
                                                float var67;
                                                if (entity_a instanceof LivingEntity) {
                                                    _livEnt = (LivingEntity) entity_a;
                                                    var67 = _livEnt.getMaxHealth();
                                                } else {
                                                    var67 = -1.0F;
                                                }

                                                _entity.setHealth((float) (var72 + (double) var67 * 0.5));
                                            }
                                        }

                                        if (world instanceof ServerLevel) {
                                            _level = (ServerLevel) world;
                                            _level.sendParticles(JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS.get(), x_pos, y_pos, z_pos, 20, 1.0, 2.0, 1.0, 0.25);
                                        }

                                        if (world instanceof ServerLevel) {
                                            _level = (ServerLevel) world;
                                            _level.sendParticles(JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS_SMALL.get(), x_pos, y_pos, z_pos, 40, 1.0, 2.0, 1.0, 0.25);
                                        }

                                        x_pos = entity.getX();
                                        y_pos = entity.getY();
                                        z_pos = entity.getZ();
                                        if (world instanceof ServerLevel _level5) {
                                            if (!_level5.isClientSide()) {
                                                _level5.playSound(null, BlockPos.containing(x_pos, y_pos, z_pos), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                                            } else {
                                                _level5.playLocalSound(x_pos, y_pos, z_pos, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                                            }
                                        }

                                        if (world instanceof ServerLevel _level6) {
                                            if (!_level6.isClientSide()) {
                                                _level6.playSound(null, BlockPos.containing(x_pos, y_pos, z_pos), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:gacon")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                                            } else {
                                                _level6.playLocalSound(x_pos, y_pos, z_pos, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:gacon")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                                            }
                                        }

                                        if (world instanceof ServerLevel) {
                                            _level = (ServerLevel) world;
                                            _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "summon jujutsucraft:slot ~ ~ ~ {NoAI:1b,Invulnerable:1b,Rotation:[" + entity.getYRot() + "F,0F]}");
                                        }

                                        Vec3 _center = new Vec3(x_pos, y_pos, z_pos);
                                        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> {
                                            return true;
                                        }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                                            return _entcnd.distanceToSqr(_center);
                                        })).toList();
                                        Iterator var50 = _entfound.iterator();

                                        while (var50.hasNext()) {
                                            Entity entityiterator = (Entity) var50.next();
                                            if (entity != entityiterator && entityiterator instanceof SlotEntity) {
                                                entity_ = entityiterator;
                                                entity_.getPersistentData().putDouble("NameRanged_ranged", entity.getPersistentData().getDouble("NameRanged_ranged"));
                                                entity_.getPersistentData().putDouble("cnt1", -20.0);
                                                entity_.getPersistentData().putString("OWNER_UUID", entity.getPersistentData().getString("OWNER_UUID"));
                                                if (entity_ instanceof SlotEntity) {
                                                    _datEntI = (SlotEntity) entity_;
                                                    var73 = _datEntI.getEntityData();
                                                    var10001 = SlotEntity.DATA_SLOT_MODE;
                                                    if (entity instanceof SlotEntity _datEntI2) {
                                                        var10002 = _datEntI2.getEntityData().get(SlotEntity.DATA_SLOT_MODE);
                                                    } else {
                                                        var10002 = 0;
                                                    }

                                                    var73.set(var10001, var10002);
                                                }

                                                CompoundTag var76 = entity_a.getPersistentData();
                                                if (entity instanceof SlotEntity) {
                                                    _datEntI = (SlotEntity) entity;
                                                    var71 = (float) _datEntI.getEntityData().get(SlotEntity.DATA_SLOT_MODE);
                                                } else {
                                                    var71 = 0.0F;
                                                }

                                                label574:
                                                {
                                                    var76.putString("SLOT" + Math.round(var71), entity_.getStringUUID());
                                                    if (entity instanceof LivingEntity) {
                                                        _livEnt = (LivingEntity) entity;
                                                        if (_livEnt.hasEffect(MobEffects.UNLUCK)) {
                                                            var10000 = _livEnt.getEffect(MobEffects.UNLUCK).getAmplifier();
                                                            break label574;
                                                        }
                                                    }

                                                    var10000 = 0;
                                                }

                                                if (var10000 > 9) {
                                                    if (!(entity_ instanceof LivingEntity)) {
                                                        break;
                                                    }

                                                    _entity = (LivingEntity) entity_;
                                                    if (_entity.level().isClientSide()) {
                                                        break;
                                                    }

                                                    label566:
                                                    {
                                                        var10003 = MobEffects.UNLUCK;
                                                        if (entity instanceof LivingEntity) {
                                                            _livEnt = (LivingEntity) entity;
                                                            if (_livEnt.hasEffect(MobEffects.UNLUCK)) {
                                                                var10005 = _livEnt.getEffect(MobEffects.UNLUCK).getAmplifier();
                                                                break label566;
                                                            }
                                                        }

                                                        var10005 = 0;
                                                    }

                                                    var68 = new MobEffectInstance(var10003, Integer.MAX_VALUE, var10005 - 1, false, false);
                                                    _entity.addEffect(var68);
                                                    break;
                                                }

                                                if (entity_ instanceof LivingEntity) {
                                                    _entity = (LivingEntity) entity_;
                                                    if (!_entity.level().isClientSide()) {
                                                        _entity.addEffect(new MobEffectInstance(MobEffects.LUCK, Integer.MAX_VALUE, 9, false, false));
                                                    }
                                                }
                                                break;
                                            }
                                        }

                                        if (!entity.level().isClientSide()) {
                                            entity.discard();
                                        }

                                        return;
                                    }
                                } else {
                                    if (entity instanceof SlotEntity) {
                                        _datEntI = (SlotEntity) entity;
                                        var10000 = _datEntI.getEntityData().get(SlotEntity.DATA_SLOT_MODE);
                                    } else {
                                        var10000 = 0;
                                    }

                                    if (var10000 == 3 && entity_a.getPersistentData().getDouble("mode_hakari") > 10.0) {
                                        entity_a.getPersistentData().putDouble("mode_hakari", entity_a.getPersistentData().getDouble("mode_hakari") - 1.0);
                                        if (entity_a.getPersistentData().getDouble("mode_hakari") <= 10.0) {
                                            entity_a.getPersistentData().putDouble("mode_hakari", 0.0);
                                        }
                                    }

                                    if (!entity.level().isClientSide()) {
                                        entity.discard();
                                        return;
                                    }
                                }

                                return;
                            }

                            return;
                        }

                        return;
                    }
                }

                if (!entity.level().isClientSide()) {
                    entity.discard();
                }
            } else if (!entity.level().isClientSide()) {
                entity.discard();
            }

        }
    }
}


