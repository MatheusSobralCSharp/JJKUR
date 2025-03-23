package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.TextureSyncPacket;
import com.jujutsu.jujutsucraftaddon.entity.CloneEntity;
import com.jujutsu.jujutsucraftaddon.entity.YutaCullingGamesEntity;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.entity.*;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Mod.EventBusSubscriber
public class Die1Procedure {
    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        execute(null, world, x, y, z, entity, sourceentity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;

        StyleDrops.execute(world, entity, sourceentity);
        if (entity instanceof GojoSatoruSchoolDaysEntity _gojo && _gojo.getEntityData().get(GojoSatoruSchoolDaysEntity.DATA_awaking) && sourceentity instanceof FushiguroTojiEntity) {
            SokaProcedure.execute(entity);
            if (entity instanceof LivingEntity _ent) {
                _ent.setHealth(_ent.getMaxHealth());
            }

            if (sourceentity instanceof LivingEntity _ent1) {
                _ent1.setHealth(50);
            }

            if (sourceentity != entity) {
                if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.QUAKE.get(), 380, 1,
                            false, false));
                if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.removeEffect(MobEffects.REGENERATION);
            }
            if (event != null && event.isCancelable()) {
                event.setCanceled(true);
            } else if (event != null && event.hasResult()) {
                event.setResult(Event.Result.DENY);
            }
        }

        if (sourceentity instanceof net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity _entity && !_entity.getEntityData().get(net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity.DATA_perfect_mode)) {
            if (entity instanceof GojoSatoruEntity){
                if (entity instanceof LivingEntity _ent) {
                    _ent.setHealth(_ent.getMaxHealth());
                }

                if (!((((GojoSatoruEntity) entity).animationprocedure).equals("deathws"))) {
                    ((GojoSatoruEntity) entity).setAnimation("deathws");
                }

                if (entity instanceof GojoSatoruEntity _entity1) {
                    if (!_entity1.level().isClientSide()) {
                        _entity1.addEffect(new MobEffectInstance((MobEffect) JujutsucraftaddonModMobEffects.BINDING_VOW_COOLDOWN.get(), (int) 300, 0, false, false));
                    }
                }

                if (event != null && event.isCancelable()) {
                    event.setCanceled(true);
                } else if (event != null && event.hasResult()) {
                    event.setResult(Event.Result.DENY);
                }
            }

        }

        if (entity instanceof SukunaPerfectEntity || entity instanceof net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity || entity instanceof GojoSatoruEntity) {
            {
                final Vec3 _center = new Vec3(x, y, z);
                List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(300 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                for (Entity entityiterator : _entfound) {
                    if (!(entityiterator == entity)) {
                        if (entityiterator instanceof PurpleEntity) {
                            if (entity instanceof LivingEntity _ent) {
                                _ent.setHealth(_ent.getMaxHealth());
                            }


                            if (entity instanceof net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity) {
                                if (entity instanceof net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity _entity1) {
                                    if (!_entity1.level().isClientSide()) {
                                        _entity1.addEffect(new MobEffectInstance((MobEffect) JujutsucraftaddonModMobEffects.BINDING_VOW_COOLDOWN.get(), (int) 1200, 0, false, false));
                                    }
                                }
                                if (entity instanceof net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity _datEntL5 && !_datEntL5.getEntityData().get(net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity.DATA_world_cut)) {
                                    _datEntL5.getEntityData().set(net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity.DATA_world_cut, true);
                                }
//                                entity.getPersistentData().putDouble("skill", 105);
//                                entity.getPersistentData().putDouble("cnt6", 20);
//                                if (entity instanceof LivingEntity _entity) {
//                                    if (!_entity.level().isClientSide()) {
//                                        _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int) 100, 0, false, false));
//                                        _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
//                                    }
//                                }
                            }

                            if (event != null && event.isCancelable()) {
                                event.setCanceled(true);
                            } else if (event != null && event.hasResult()) {
                                event.setResult(Event.Result.DENY);
                            }
                        }
                    }
                }
            }

        }

        if (sourceentity instanceof SukunaPerfectEntity || sourceentity instanceof com.jujutsu.jujutsucraftaddon.entity.SukunaFushiguroEntity) {
            if (entity instanceof YutaCullingGamesEntity) {
                if (!entity.getPersistentData().contains("hasSpawnedGojo")) {
                    double yaw = entity.getPersistentData().getDouble("yaw");
                    double picth = entity.getPersistentData().getDouble("pitch");
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel) world;
                        Entity entityToSpawn = ((EntityType) JujutsucraftModEntities.GOJO_SATORU.get()).spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                            entityToSpawn.setYRot((float) yaw);
                            entityToSpawn.setYBodyRot((float) yaw);
                            entityToSpawn.setYHeadRot((float) yaw);
                            entityToSpawn.setXRot((float) picth);
                            if (entityToSpawn instanceof GojoSatoruEntity) {
                                GojoSatoruEntity _datEntSetL = (GojoSatoruEntity) entityToSpawn;
                                _datEntSetL.getEntityData().set(GojoSatoruEntity.DATA_ghost, true);
                                entityToSpawn.getPersistentData().putDouble("cnt_learn_domain", 1.0);
                            }
                        }
                    }
                    entity.getPersistentData().putBoolean("hasSpawnedGojo", true);
                }
            }
        }

        if (!world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_NO_POWER_PROGRESS)) {
            CursedLevelGainProcedure.execute(world, entity, sourceentity);
        }

        if (entity instanceof Player _playerHasItem && _playerHasItem.getInventory().contains(new ItemStack(JujutsucraftaddonModItems.ARTIFACT_4.get()))) {
            if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower >= 2000) {
                if (entity instanceof LivingEntity _entity)
                    _entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                {
                    double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 2000);
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerCursePower = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
                if (event != null && event.isCancelable()) {
                    event.setCanceled(true);
                } else if (event != null && event.hasResult()) {
                    event.setResult(Event.Result.DENY);
                }
            } else {
                if (entity instanceof Player _player) {
                    ItemStack _stktoremove = new ItemStack(JujutsucraftaddonModItems.ARTIFACT_4.get());
                    _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                }
            }
        }
        if (entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(JujutsucraftaddonModMobEffects.MANIFESTATION.get())) {
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.PlayerCurseTechnique2 = 5;
                capability.syncPlayerVariables(entity);
            });
        }
        if (sourceentity instanceof LivingEntity) {
            if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Kenjaku")
                    || ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Sung")) {
                if (entity instanceof LivingEntity) {
                    DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                        String mobTexture = TextureSyncPacket.sendTextureToServer((LivingEntity) entity);
                    });
                    {
                        ItemStack _setval = ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).copy());
                        sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.Armorslot1 = _setval.copy();
                            capability.syncPlayerVariables(sourceentity);
                        });
                    }
                    {
                        ItemStack _setval = ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).copy());
                        sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.Armorslot2 = _setval.copy();
                            capability.syncPlayerVariables(sourceentity);
                        });
                    }
                    {
                        ItemStack _setval = ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).copy());
                        sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.Armorslot3 = _setval.copy();
                            capability.syncPlayerVariables(sourceentity);
                        });
                    }
                    {
                        ItemStack _setval = ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).copy());
                        sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.Armorslot4 = _setval.copy();
                            capability.syncPlayerVariables(sourceentity);
                        });
                    }
                    {
                        ItemStack _setval = ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy());
                        sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.Armorslot5 = _setval.copy();
                            capability.syncPlayerVariables(sourceentity);
                        });
                    }
                }
            }
            if (sourceentity.getPersistentData().getDouble("Fight") == 1 || sourceentity.getPersistentData().getDouble("Wukong") == 1) {
                {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "stopsound @s");
                    }
                }
                sourceentity.getPersistentData().putDouble("Wukong", 0);
                sourceentity.getPersistentData().putDouble("Fight", 0);
            }
            if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Tengen")) {
                entity.setInvulnerable(true);
                if (entity instanceof LivingEntity _entity)
                    _entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                if (event != null && event.isCancelable()) {
                    event.setCanceled(true);
                } else if (event != null && event.hasResult()) {
                    event.setResult(Event.Result.DENY);
                }
            }
            if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
                if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_CULLING_GAMES)) {
                    {
                        double _setval = (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Points + 1;
                        sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.Points = _setval;
                            capability.syncPlayerVariables(sourceentity);
                        });
                    }
                }
            }
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Vow4 >= 1) {
                {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "clear");
                    }
                }
                {
                    double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CursedLevel
                            - (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Vow4 * 2000;
                    entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.CursedLevel = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
            }
            if (!((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()))) {
                if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Tengen")) {
                    if (event != null && event.isCancelable()) {
                        event.setCanceled(true);
                    } else if (event != null && event.hasResult()) {
                        event.setResult(Event.Result.DENY);
                    }
                }
                if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftaddonModMobEffects.BINDING_VOW.get()) ? _livEnt.getEffect(JujutsucraftaddonModMobEffects.BINDING_VOW.get()).getAmplifier() : 0) == 2) {
                    if (event != null && event.isCancelable()) {
                        event.setCanceled(true);
                    } else if (event != null && event.hasResult()) {
                        event.setResult(Event.Result.DENY);
                    }
                    if (entity instanceof LivingEntity _entity)
                        _entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1000, 0, false, false));
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 1000, 1, false, false));
                }
                if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 11) {
                    if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain) {
                        {
                            final Vec3 _center = new Vec3(x, y, z);
                            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                            for (Entity entityiterator : _entfound) {
                                if (!(entity == entityiterator)) {
                                    if ((Objects.requireNonNull(Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()))).toString()).equals("jujutsucraft:crow")) {
                                        if ((new Object() {
                                            public String getValue() {
                                                CompoundTag dataIndex = new CompoundTag();
                                                entityiterator.saveWithoutId(dataIndex);
                                                return dataIndex.getCompound("ForgeData").getString("FOLLOW_ID");
                                            }
                                        }.getValue()).equals(entity.getStringUUID())) {
                                            if (!entityiterator.level().isClientSide())
                                                entityiterator.discard();
                                            if (entity instanceof LivingEntity _entity)
                                                _entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                                            if (event != null && event.isCancelable()) {
                                                event.setCanceled(true);
                                            } else if (event != null && event.hasResult()) {
                                                event.setResult(Event.Result.DENY);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Gojo")) {
                    if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2) {
                        if (Math.random() <= 0.01) {
                            if (!(entity instanceof LivingEntity _livEnt48 && _livEnt48.hasEffect(JujutsucraftaddonModMobEffects.AWAKENING.get()))) {
                                SokaProcedure.execute(entity);
                                if (event != null && event.isCancelable()) {
                                    event.setCanceled(true);
                                } else if (event != null && event.hasResult()) {
                                    event.setResult(Event.Result.DENY);
                                }
                            }
                        }
                    }
                }
            }
            if (entity instanceof ItadoriYujiShibuyaEntity) {
                if (Math.random() >= 0.5) {
                    {
                        Entity _ent = entity;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                    _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute run summon jujutsucraft:sukuna ~ ~ ~");
                        }
                    }
                }
            } else if (sourceentity instanceof SukunaEntity && sourceentity.getPersistentData().getDouble("sukunacompanion") != 1) {
                if ((Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString()).equals("jujutsucraft:fushiguro_megumi_shibuya")) {
                    {
                        Entity _ent = entity;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            _ent.getServer().getCommands().performPrefixedCommand(
                                    new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
                                            _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                    "execute run summon jujutsucraftaddon:sukuna_fushiguro ~ ~ ~ {ArmorItems:[{id:\"jujutsucraft:uniform_normal_chestplate\",Count:1b},{id:\"jujutsucraft:uniform_normal_leggings\",Count:1b}]}");
                        }
                    }
                    {
                        Entity _ent = entity;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                    _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute run summon jujutsucraft:itadori_yuji_shibuya ~ ~ ~");
                        }
                    }
                    if (!sourceentity.level().isClientSide())
                        sourceentity.discard();
                }
            }
            if (!((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()))) {
                if ((Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString()).equals("jujutsucraft:itadori_yuji_shibuya")) {
                    if (Math.random() < 0.1) {
                        if (!(sourceentity instanceof ServerPlayer _plr57 && _plr57.level() instanceof ServerLevel
                                && _plr57.getAdvancements().getOrStartProgress(Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(_plr57.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:cursed_fists")))))).isDone())) {
                            if (sourceentity instanceof ServerPlayer _player) {
                                Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:cursed_fists"));
                                AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                if (!_ap.isDone()) {
                                    for (String criteria : _ap.getRemainingCriteria())
                                        _player.getAdvancements().award(_adv, criteria);
                                }
                            }
                        }
                    }
                    if (Math.random() < 0.1) {
                        if (!(sourceentity instanceof ServerPlayer _plr59 && _plr59.level() instanceof ServerLevel
                                && _plr59.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr59.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:mastery_black_flash")))).isDone())) {
                            if (sourceentity instanceof ServerPlayer _player) {
                                Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:mastery_black_flash"));
                                AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                if (!_ap.isDone()) {
                                    for (String criteria : _ap.getRemainingCriteria())
                                        _player.getAdvancements().award(_adv, criteria);
                                }
                            }
                        }
                    }
                } else if ((Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString()).equals("jujutsucraft:kusakabe_yatsuya")) {
                    if (!(sourceentity instanceof ServerPlayer _plr62 && _plr62.level() instanceof ServerLevel
                            && _plr62.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr62.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:perfect_simple_domain")))).isDone())) {
                        if (Math.random() < 0.1) {
                            if (sourceentity instanceof ServerPlayer _player) {
                                Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:perfect_simple_domain"));
                                AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                if (!_ap.isDone()) {
                                    for (String criteria : _ap.getRemainingCriteria())
                                        _player.getAdvancements().award(_adv, criteria);
                                }
                            }
                        }
                    }
                    if (!(sourceentity instanceof ServerPlayer _plr64 && _plr64.level() instanceof ServerLevel
                            && _plr64.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr64.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:kakucho_jutsushiki")))).isDone())) {
                        if (Math.random() < 0.1) {
                            if (sourceentity instanceof ServerPlayer _player) {
                                Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:kakucho_jutsushiki"));
                                AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                if (!_ap.isDone()) {
                                    for (String criteria : _ap.getRemainingCriteria())
                                        _player.getAdvancements().award(_adv, criteria);
                                }
                            }
                        }
                    }
                }
                if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("skill");
                        }
                    }.getValue() == 105) {
                        if ((Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString()).equals("jujutsucraft:gojo_satoru")) {
                            {
                                Entity _ent = sourceentity;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                    _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                            "execute as @s run item replace entity @s weapon.offhand with jujutsucraft:supreme_martial_solution");
                                }
                            }
                            if (world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:gojodeath"))), SoundSource.NEUTRAL, 1, 1);
                                } else {
                                    _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:gojodeath"))), SoundSource.NEUTRAL, 1, 1, false);
                                }
                            }
                        }
                    }
                    if (!(sourceentity instanceof ServerPlayer _plr71 && _plr71.level() instanceof ServerLevel
                            && _plr71.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr71.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:ultimate_power")))).isDone())) {
                        if (sourceentity instanceof ServerPlayer _plr72 && _plr72.level() instanceof ServerLevel
                                && _plr72.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr72.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:world_slash_advancement")))).isDone()) {
                            if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                if ((Objects.requireNonNull(ForgeRegistries.ITEMS.getKey((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem())).toString()).equals("jujutsucraft:supreme_martial_solution")) {
                                    if (new Object() {
                                        public double getValue() {
                                            CompoundTag dataIndex = new CompoundTag();
                                            sourceentity.saveWithoutId(dataIndex);
                                            return dataIndex.getCompound("ForgeData").getDouble("skill");
                                        }
                                    }.getValue() == 105) {
                                        if ((Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString()).equals("jujutsucraft:kashimo_hajime")) {
                                            {
                                                Entity _ent = sourceentity;
                                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                                    _ent.getServer().getCommands().performPrefixedCommand(
                                                            new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                                                    _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                            "execute as @s run item replace entity @s armor.chest with jujutsucraft:sukuna_body_chestplate");
                                                }
                                            }
                                            if (world instanceof Level _level) {
                                                if (!_level.isClientSide()) {
                                                    _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:laughsukuna"))), SoundSource.NEUTRAL, 1, 1);
                                                } else {
                                                    _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:laughsukuna"))), SoundSource.NEUTRAL, 1, 1, false);
                                                }
                                            }
                                            if (sourceentity instanceof ServerPlayer _player) {
                                                Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:ultimate_power"));
                                                AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                                if (!_ap.isDone()) {
                                                    for (String criteria : _ap.getRemainingCriteria())
                                                        _player.getAdvancements().award(_adv, criteria);
                                                }
                                            }
                                            {
                                                Entity _entity = sourceentity;
                                                if (_entity instanceof Player _player) {
                                                    _player.getInventory().armor.set(3, new ItemStack(JujutsucraftaddonModItems.SUKUNA_ARMOR_THREE_HELMET.get()));
                                                    _player.getInventory().setChanged();
                                                } else if (_entity instanceof LivingEntity _living) {
                                                    _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(JujutsucraftaddonModItems.SUKUNA_ARMOR_THREE_HELMET.get()));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2) {
                    QuestGojoProcedure.execute(entity, sourceentity);
                }
                if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 1) {
                    if ((Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString()).equals("jujutsucraft:fushiguro_toji")) {
                        {
                            double _setval = 2;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.History = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                    }
                }
                if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Profession).equals("Warrior")) {
                    ProfessionDeathProcedure.execute(entity, sourceentity);
                }
                if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Kenjaku")
                        || ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Okkotsu")) {
                    if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 18
                            || (sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 5
                            || (sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == (sourceentity
                            .getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).KenjakuCT1
                            || (sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == (entity
                            .getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).KenjakuCT2) {
                        BarrierLessoProcedure.execute(world, entity, sourceentity);
                    }
                }
                if (!world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_NO_DROPS)) {
                    DropItems3Procedure.execute(world, entity, sourceentity);
                }
            }
            if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_MOB_OSTS)) {
                if ((Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType())).toString()).equals("jujutsucraft:mahito")) {
                    if ((Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString()).equals("jujutsucraft:nanami_kento")) {
                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:nanamitheme"))), SoundSource.NEUTRAL, 1, 1);
                            } else {
                                _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:nanamitheme"))), SoundSource.NEUTRAL, 1, 1, false);
                            }
                        }
                    }
                }
            }
            if (entity instanceof CloneEntity) {
                {
                    final Vec3 _center = new Vec3(x, y, z);
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                    for (Entity entityiterator : _entfound) {
                        if (entityiterator instanceof LivingEntity _entity)
                            _entity.removeEffect(JujutsucraftaddonModMobEffects.CLONE_TICKED.get());
                    }
                }
            }
            if (entity instanceof ServerPlayer _plr97 && _plr97.level() instanceof ServerLevel
                    && _plr97.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr97.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:extension_technique")))).isDone()) {
                if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 19) {
                    if (entity.getPersistentData().getDouble("2nd") == 0) {
                        if (entity instanceof LivingEntity _entity)
                            _entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        entity.getPersistentData().putDouble("2nd", 1);
                        if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.QUAKE.get(), 120, 1, false, false));
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.NAOYA_AWAKENING.get(), 6000, 1, false, false));
                        if (event != null && event.isCancelable()) {
                            event.setCanceled(true);
                        } else if (event != null && event.hasResult()) {
                            event.setResult(Event.Result.DENY);
                        }
                    }
                }
            }
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH == 4) {
                if (sourceentity.getPersistentData().getDouble("GH") == 1) {
                    if (!(entity instanceof ServerPlayer _plr106 && _plr106.level() instanceof ServerLevel
                            && _plr106.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr106.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:last_hope")))).isDone())) {
                        if (event != null && event.isCancelable()) {
                            event.setCanceled(true);
                        } else if (event != null && event.hasResult()) {
                            event.setResult(Event.Result.DENY);
                        }
                        if (entity instanceof LivingEntity _entity)
                            _entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        if (entity instanceof ServerPlayer _player) {
                            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:gojo_training_part_4"));
                            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                            if (!_ap.isDone()) {
                                for (String criteria : _ap.getRemainingCriteria())
                                    _player.getAdvancements().award(_adv, criteria);
                            }
                        }
                        if (entity instanceof ServerPlayer _player) {
                            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:last_hope"));
                            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                            if (!_ap.isDone()) {
                                for (String criteria : _ap.getRemainingCriteria())
                                    _player.getAdvancements().award(_adv, criteria);
                            }
                        }
                    }
                }
            }
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("GH");
                }
            }.getValue() == 1) {
                if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 1) {
                    if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 0) {
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Annoying Curse"), false);
                        {
                            double _setval = (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH + 1;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.SH = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                    } else if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 1) {
                        if (sourceentity instanceof ServerPlayer _player) {
                            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:cleave_web_advancement"));
                            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                            if (!_ap.isDone()) {
                                for (String criteria : _ap.getRemainingCriteria())
                                    _player.getAdvancements().award(_adv, criteria);
                            }
                        }
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Stand Proud, You're Strong"), false);
                        {
                            double _setval = (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH + 1;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.SH = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                    } else if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 2) {
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Splendid Fushiguro Megumi"), false);
                        {
                            double _setval = (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH + 1;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.SH = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                    } else if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 3) {
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Take a Bath for Purify Your Soul"), false);
                        if (sourceentity instanceof ServerPlayer _serverPlayer)
                            _serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("jujutsucraftaddon:yoku_recipe")});
                        {
                            double _setval = (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH + 1;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.SH = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                    } else if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 4) {
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("What This Woman Is Doing Here?.."), false);
                        {
                            double _setval = (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH + 1;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.SH = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                    } else if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 5) {
                        if (sourceentity instanceof LivingEntity _livEnt120 && _livEnt120.hasEffect(JujutsucraftaddonModMobEffects.WORLD_SLASH_EFFECT.get())) {
                            if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                                _player.displayClientMessage(Component.literal("Gojo Satoru.."), false);
                            {
                                double _setval = (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH + 1;
                                sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.SH = _setval;
                                    capability.syncPlayerVariables(sourceentity);
                                });
                            }
                        }
                    } else if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 6) {
                        {
                            double _setval = (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH + 1;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.SH = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                        if (sourceentity instanceof ServerPlayer _player) {
                            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:ultimate_power"));
                            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                            if (!_ap.isDone()) {
                                for (String criteria : _ap.getRemainingCriteria())
                                    _player.getAdvancements().award(_adv, criteria);
                            }
                        }
                    }
                }
                if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 2) {
                    if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH == 0) {
                        if (sourceentity instanceof ServerPlayer _player) {
                            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:gojo_training_part_1"));
                            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                            if (!_ap.isDone()) {
                                for (String criteria : _ap.getRemainingCriteria())
                                    _player.getAdvancements().award(_adv, criteria);
                            }
                        }
                        {
                            double _setval = (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH + 1;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.GH = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                    } else if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH == 1) {
                        if (sourceentity instanceof ServerPlayer _player) {
                            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:gojo_training_part_2"));
                            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                            if (!_ap.isDone()) {
                                for (String criteria : _ap.getRemainingCriteria())
                                    _player.getAdvancements().award(_adv, criteria);
                            }
                        }
                        {
                            double _setval = (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH + 1;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.GH = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                    } else if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH == 2) {
                        {
                            double _setval = (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH + 1;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.GH = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                    } else if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH == 3) {
                        if (sourceentity instanceof ServerPlayer _player) {
                            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:gojo_training_part_3"));
                            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                            if (!_ap.isDone()) {
                                for (String criteria : _ap.getRemainingCriteria())
                                    _player.getAdvancements().award(_adv, criteria);
                            }
                        }
                        {
                            double _setval = (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH + 1;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.GH = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                    } else if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH == 4) {
                        {
                            double _setval = (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH + 1;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.GH = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                    }
                }
            }
            if (entity.getPersistentData().getDouble("RCTM") == 1) {
                if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mastery == 3) {
                    {
                        String _setval = "";
                        sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.QuestActive = _setval;
                            capability.syncPlayerVariables(sourceentity);
                        });
                    }
                    {
                        String _setval = "";
                        sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.Description = _setval;
                            capability.syncPlayerVariables(sourceentity);
                        });
                    }
                    if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("Now It's Done, Just Use More RCT for Unlock It, you can check in menu progression!"), false);
                    {
                        double _setval = 40000;
                        sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.RCTCount2 = _setval;
                            capability.syncPlayerVariables(sourceentity);
                        });
                    }
                    {
                        double _setval = 4;
                        sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.Mastery = _setval;
                            capability.syncPlayerVariables(sourceentity);
                        });
                    }
                }
            }
            if (entity.getPersistentData().getDouble("K1") == 1) {
                {
                    double _setval = 4;
                    sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.SimpleQuest = _setval;
                        capability.syncPlayerVariables(sourceentity);
                    });
                }
                {
                    String _setval = "Simple Domain Mastery Quest #4";
                    sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.QuestActive = _setval;
                        capability.syncPlayerVariables(sourceentity);
                    });
                }
                {
                    String _setval = "Use Simple Domain Till Unlock The Level 2";
                    sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.Description = _setval;
                        capability.syncPlayerVariables(sourceentity);
                    });
                }
            }
            if (entity.getPersistentData().getDouble("Jogoat") == 1) {
                if (sourceentity instanceof ServerPlayer _player) {
                    Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:jogoat_god"));
                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                    if (!_ap.isDone()) {
                        for (String criteria : _ap.getRemainingCriteria())
                            _player.getAdvancements().award(_adv, criteria);
                    }
                }
            }
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
                if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Tengen")) {
                    entity.setInvulnerable(true);
                    if (entity instanceof LivingEntity _entity)
                        _entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                    if (event != null && event.isCancelable()) {
                        event.setCanceled(true);
                    } else if (event != null && event.hasResult()) {
                        event.setResult(Event.Result.DENY);
                    }
                }
            }
            if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
                if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_CULLING_GAMES)) {
                    {
                        double _setval = (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Points + 1;
                        sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.Points = _setval;
                            capability.syncPlayerVariables(sourceentity);
                        });
                    }
                }
            }
            if (entity instanceof LivingEntity _livEnt136 && _livEnt136.hasEffect(JujutsucraftaddonModMobEffects.MANIFESTATION.get())) {
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.PlayerCurseTechnique2 = 5;
                    capability.syncPlayerVariables(entity);
                });
            }
            if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
                if (sourceentity.getPersistentData().getDouble("CursedSpirit") == 1) {
                    if (!(sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).IsVessel) {
                        if ((Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString()).equals("jujutsucraft:mahito") || (Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString()).equals("jujutsucraft:jogo")) {
                            if (Math.random() <= (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DROP_RATE)) * 0.00002) {
                                if (!((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Disaster Curses")) {
                                    if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                                        _player.displayClientMessage(Component.literal("You Now Awakened a new Level"), false);
                                    {
                                        String _setval = "Disaster Curses";
                                        sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                            capability.Subrace = _setval;
                                            capability.syncPlayerVariables(sourceentity);
                                        });
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (entity instanceof LivingEntity _livEnt143 && _livEnt143.hasEffect(JujutsucraftaddonModMobEffects.BATTLE.get())) {
                if (sourceentity instanceof LivingEntity _livEnt144 && _livEnt144.hasEffect(JujutsucraftaddonModMobEffects.BATTLE.get())) {
                    if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.REWARD.get(), 20, 1, false, false));
                    if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("You WON!!!!!!"), false);
                    if (entity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("You Lose"), false);
                    if (event != null && event.isCancelable()) {
                        event.setCanceled(true);
                    } else if (event != null && event.hasResult()) {
                        event.setResult(Event.Result.DENY);
                    }
                    if (sourceentity instanceof LivingEntity _entity)
                        _entity.removeEffect(JujutsucraftaddonModMobEffects.BATTLE.get());
                    if (entity instanceof LivingEntity _entity)
                        _entity.removeEffect(JujutsucraftaddonModMobEffects.BATTLE.get());
                }
            } else if (entity instanceof LivingEntity _livEnt150 && _livEnt150.hasEffect(JujutsucraftaddonModMobEffects.TEAM_BATTLE.get())) {
                if (entity instanceof LivingEntity _entity)
                    _entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                {
                    Entity _ent = entity;
                    _ent.teleportTo(JujutsucraftaddonModVariables.MapVariables.get(world).X1, JujutsucraftaddonModVariables.MapVariables.get(world).Y1, JujutsucraftaddonModVariables.MapVariables.get(world).Z1);
                    if (_ent instanceof ServerPlayer _serverPlayer)
                        _serverPlayer.connection.teleport(JujutsucraftaddonModVariables.MapVariables.get(world).X1, JujutsucraftaddonModVariables.MapVariables.get(world).Y1, JujutsucraftaddonModVariables.MapVariables.get(world).Z1,
                                _ent.getYRot(), _ent.getXRot());
                }
                if (event != null && event.isCancelable()) {
                    event.setCanceled(true);
                } else if (event != null && event.hasResult()) {
                    event.setResult(Event.Result.DENY);
                }
            }

        }
    }
}
