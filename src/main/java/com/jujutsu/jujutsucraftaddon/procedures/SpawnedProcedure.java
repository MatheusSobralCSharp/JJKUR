package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.mojang.util.UUIDTypeAdapter;
import net.mcreator.jujutsucraft.entity.*;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.SizeByNBTProcedure;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Mod.EventBusSubscriber
public class SpawnedProcedure {
    @SubscribeEvent
    public static void onEntitySpawned(EntityJoinLevelEvent event) {
        execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (!(entity instanceof LivingEntity livingEntity))
            return;

        if (world instanceof ServerLevel serverLevel) {
            if (serverLevel.getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_NO_VANILLA)) {
                if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:vanilla_mob")))) {
                    cancelEvent(event);
                }
            }
        }

        if ((entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:ten_shadows_technique")))) && !(entity instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity)) {
            if (!(((new Object() {
                public Entity get(LevelAccessor _world, String _uuid) {
                    try {
                        if (_world instanceof ServerLevel _serverLevel) {
                            return _serverLevel.getEntity(UUIDTypeAdapter.fromString(_uuid));
                        }
                    } catch (Exception _e) {
                    }
                    return null;
                }
            }).get(world, (entity.getPersistentData().getString("OWNER_UUID")))) == null)) {
                if (((new Object() {
                    public Entity get(LevelAccessor _world, String _uuid) {
                        try {
                            if (_world instanceof ServerLevel _serverLevel) {
                                return _serverLevel.getEntity(UUIDTypeAdapter.fromString(_uuid));
                            }
                        } catch (Exception _e) {
                        }
                        return null;
                    }
                }).get(world, (entity.getPersistentData().getString("OWNER_UUID")))) instanceof SukunaFushiguroEntity) {
                    ((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
                            .setBaseValue((((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() * 2));
                    if (entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                        _livingEntity9.getAttribute(Attributes.MAX_HEALTH)
                                .setBaseValue(((entity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity8.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) * 2));
                    if (entity instanceof LivingEntity _entity)
                        _entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                    if (entity instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(Attributes.ARMOR))
                        _livingEntity12.getAttribute(Attributes.ARMOR)
                                .setBaseValue(((entity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(Attributes.ARMOR) ? _livingEntity11.getAttribute(Attributes.ARMOR).getBaseValue() : 0) + 2));
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
                                (int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) + 4), false, false));
                }
            }

        }

        ResourceLocation entityTypeKey = ForgeRegistries.ENTITY_TYPES.getKey(entity.getType());
        if (entityTypeKey == null || !entityTypeKey.toString().startsWith("jujutsucraft"))
            return;

        if (entity instanceof TodoAoiEntity || entity instanceof HigurumaHiromiEntity || entity instanceof MiguelEntity || entity instanceof MiguelDancerEntity) {
            LivingEntity livingEntity2 = (LivingEntity) entity;
            AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
            maxHealthAttr.setBaseValue(900);
            AttributeInstance maxHealthAttr1 = livingEntity2.getAttribute(Attributes.ARMOR);
            maxHealthAttr1.setBaseValue(30);
            if (entity instanceof TodoAoiEntity) {
                AttributeInstance maxHealthAttr2 = livingEntity2.getAttribute(Attributes.ARMOR_TOUGHNESS);
                maxHealthAttr2.setBaseValue(20);
            } else {
                AttributeInstance maxHealthAttr2 = livingEntity2.getAttribute(Attributes.ARMOR_TOUGHNESS);
                maxHealthAttr2.setBaseValue(10);
            }
            livingEntity2.setHealth(livingEntity2.getMaxHealth());
        }

        if (entity instanceof PurpleEntity) {
            if (entity.getPersistentData().getDouble("Full") == 1) {
                {
                    final Vec3 _center = new Vec3(x, y, z);
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(300 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                    for (Entity entityiterator : _entfound) {
                        if (!(entityiterator == entity)) {
                            if (entityiterator instanceof GojoSatoruEntity || entityiterator instanceof SukunaFushiguroEntity) {
                                if (entityiterator instanceof LivingEntity _ent) {
                                    _ent.setHealth(_ent.getMaxHealth());
                                }

                                if (entityiterator instanceof SukunaFushiguroEntity) {
                                    if (entityiterator instanceof SukunaFushiguroEntity _entity1) {
                                        if (!_entity1.level().isClientSide()) {
                                            _entity1.addEffect(new MobEffectInstance((MobEffect) JujutsucraftaddonModMobEffects.BINDING_VOW_COOLDOWN.get(), (int) 1200, 0, false, false));
                                        }
                                    }
                                    if (entityiterator instanceof SukunaFushiguroEntity _datEntL5 && !_datEntL5.getEntityData().get(SukunaFushiguroEntity.DATA_world_cut)) {
                                        _datEntL5.getEntityData().set(SukunaFushiguroEntity.DATA_world_cut, true);
                                    }
                                    entityiterator.getPersistentData().putDouble("skill", 105);
                                    entityiterator.getPersistentData().putDouble("cnt6", 20);
                                    if (entityiterator instanceof LivingEntity _entity) {
                                        if (!_entity.level().isClientSide()) {
                                            _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int) 100, 0, false, false));
                                            _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        handleMahoragaLogic(world, x, y, z, entity);

        if (!entity.getPersistentData().getString("OWNER_UUID").isEmpty()) {
            return;
        }



        if (entity instanceof RedEntity redEntity) {
            Pose pose = redEntity.getPose();
            redEntity.getDimensions(pose).scale((float) SizeByNBTProcedure.execute(entity));
        }

        boolean isServerSide = !livingEntity.level().isClientSide();

        if (isServerSide) {
            livingEntity.addEffect(new MobEffectInstance(
                    JujutsucraftaddonModMobEffects.RESPAWNED_JUJUTSU.get(), 20, 1, false, false
            ));
        }

        MobSpawnType spawnType = entity instanceof PathfinderMob ? ((PathfinderMob) entity).getSpawnType() : null;
        if (spawnType != null) {
            handleEntitySpawnLogic(event, world, entity, spawnType, entityTypeKey);
        }

    }

    private static void handleEntitySpawnLogic(Event event, LevelAccessor world, Entity entity, MobSpawnType
            spawnType, ResourceLocation entityTypeKey) {
        String spawnTypeName = spawnType.toString();
        boolean isCommandSpawn = "COMMAND".equals(spawnTypeName);

        if (!isCommandSpawn) {
            cancelEventIfRuleMet(event, world, JujutsucraftaddonModGameRules.JJKU_NO_STEVENSON, entity instanceof StevensonScreenEntity);
            cancelEventIfRuleMet(event, world, JujutsucraftaddonModGameRules.JJKU_NO_ARMORY_SPIRIT, entity instanceof CursedSpiritGrade37Entity);
            cancelEventIfChanceFails(event, world, entity, spawnTypeName, JujutsucraftaddonModGameRules.JJKU_SUKUNA_RATE, SukunaEntity.class, SukunaFushiguroEntity.class, SukunaPerfectEntity.class);
            cancelEventIfChanceFails(event, world, entity, spawnTypeName, JujutsucraftaddonModGameRules.JJKU_GOJO_RATE, GojoSatoruSchoolDaysEntity.class, GojoSatoruEntity.class);
            cancelEventIfChanceFails(event, world, entity, spawnTypeName, JujutsucraftaddonModGameRules.JJKU_TOJI_RATE, FushiguroTojiEntity.class, FushiguroTojiBugEntity.class);
            cancelEventIfPersistentData(event, world, entity, "CursedSpirit", JujutsucraftaddonModGameRules.JJKU_CURSED_SPIRIT_RATE, spawnTypeName);
            cancelEventIfPersistentData(event, world, entity, "CurseUser", JujutsucraftaddonModGameRules.JJKU_CURSE_USERS_RATE, spawnTypeName);
            cancelEventIfPersistentData(event, world, entity, "JujutsuSorcerer", JujutsucraftaddonModGameRules.JJKU_SORCERERS_RATE, spawnTypeName);
        }

        handleBuffModification(world, entity);
    }

    private static void handleBuffModification(LevelAccessor world, Entity entity) {
        if (entity.getPersistentData().getDouble("CursedSpirit") == 1
                || entity.getPersistentData().getDouble("CurseUser") == 1
                || entity.getPersistentData().getDouble("JujutsuSorcerer") == 1) {

            CompoundTag forgeData = entity.getPersistentData().getCompound("ForgeData");
            if (forgeData.getDouble("buff") != 1) {
                LivingEntity livingEntity = (LivingEntity) entity;
                AttributeInstance maxHealthAttr = livingEntity.getAttribute(Attributes.MAX_HEALTH);
                if (maxHealthAttr != null) {
                    double gameDifficulty = world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DIFFICULTY);
                    double newMaxHealth = 100.0 / gameDifficulty * maxHealthAttr.getBaseValue();
                    maxHealthAttr.setBaseValue(newMaxHealth);
                    livingEntity.setHealth(livingEntity.getMaxHealth());
                }
                forgeData.putDouble("buff", 1);
                entity.getPersistentData().put("ForgeData", forgeData);
            }
        }
    }

    private static void handleMahoragaLogic(LevelAccessor world, double x, double y, double z, Entity entity) {
        KenjakuDomainSummoningProcedure.execute(world, x, y, z, entity);
        if (entity.getPersistentData().getDouble("Mahoraga") == 1
                && entity instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity
                && entity instanceof LivingEntity livingEntity
                && !livingEntity.level().isClientSide()) {
            livingEntity.addEffect(new MobEffectInstance(
                    JujutsucraftaddonModMobEffects.MAHO_EFFECTO.get(), 40, 1, false, false
            ));
        }
    }


    private static void cancelEventIfRuleMet(Event event, LevelAccessor
            world, GameRules.Key<GameRules.BooleanValue> rule, boolean condition) {
        if (world.getLevelData().getGameRules().getBoolean(rule) && condition) {
            cancelEvent(event);
        }
    }

    private static void cancelEventIfChanceFails(Event event, LevelAccessor world, Entity entity, String
            spawnTypeName, GameRules.Key<GameRules.IntegerValue> rule, Class<?>... entityClasses) {
        if (Arrays.stream(entityClasses).anyMatch(clazz -> clazz.isInstance(entity))
                && Math.random() >= 0.01 * world.getLevelData().getGameRules().getInt(rule)) {
            if (entity.getPersistentData().getString("OWNER_UUID").isEmpty()) {
                if (entity.getPersistentData().getDouble("friend_num") == 0) {
                    if (entity.getPersistentData().getDouble("Spirit") == 0) {
                        cancelEvent(event);
                    }
                }
            }
        }
    }

    private static void cancelEventIfPersistentData(Event event, LevelAccessor world, Entity entity, String
            key, GameRules.Key<GameRules.IntegerValue> rule, String spawnTypeName) {
        if (entity.getPersistentData().getDouble(key) == 1
                && Math.random() >= 0.01 * world.getLevelData().getGameRules().getInt(rule)) {
            if (entity.getPersistentData().getString("OWNER_UUID").isEmpty()) {
                if (entity.getPersistentData().getDouble("friend_num") == 0) {
                    if (entity.getPersistentData().getDouble("Spirit") == 0) {
                        cancelEvent(event);
                    }
                }
            }
        }
    }

    private static void cancelEvent(Event event) {
        if (event != null) {
            if (event.isCancelable()) {
                event.setCanceled(true);
            } else if (event.hasResult()) {
                event.setResult(Event.Result.DENY);
            }
        }
    }


}
