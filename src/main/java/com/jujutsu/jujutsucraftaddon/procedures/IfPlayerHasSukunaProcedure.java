package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.ErroEntity;
import com.jujutsu.jujutsucraftaddon.entity.ErrorEntity;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import java.util.List;

public class IfPlayerHasSukunaProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null || world == null)
            return;

        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound){
                if (Math.random() < (1) / ((float) 100)) {
                    if (entityiterator instanceof ErroEntity || entityiterator instanceof ErrorEntity) {
                        if ((new Object() {
                            public String getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entityiterator.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getString("Owner");
                            }
                        }.getValue()).equals(entity.getStringUUID())) {
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entityiterator.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("Demon");
                                }
                            }.getValue() >= 1) {
                                {
                                    Entity _ent = entity;
                                    _ent.teleportTo((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()));
                                    if (_ent instanceof ServerPlayer _serverPlayer)
                                        _serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
                                }
                                {
                                    Entity _ent = entity;
                                    _ent.setYRot(entityiterator.getYRot());
                                    _ent.setXRot(entityiterator.getXRot());
                                    _ent.setYBodyRot(_ent.getYRot());
                                    _ent.setYHeadRot(_ent.getYRot());
                                    _ent.yRotO = _ent.getYRot();
                                    _ent.xRotO = _ent.getXRot();
                                    if (_ent instanceof LivingEntity _entity) {
                                        _entity.yBodyRotO = _entity.getYRot();
                                        _entity.yHeadRotO = _entity.getYRot();
                                    }
                                }
                                {
                                    Entity _ent = entity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                        _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                ("spectate " + (entityiterator.getStringUUID()).toLowerCase()));
                                    }
                                }
                                FatigueOnEffectActiveTickProcedure.execute(entity);
                            }
                        }
                    }
                }
            }
        }
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals("jujutsucraft:fushiguro_megumi_shibuya")) {
                    if (!(entity instanceof ServerPlayer _plr16 && _plr16.level() instanceof ServerLevel
                            && _plr16.getAdvancements().getOrStartProgress(_plr16.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:enchained"))).isDone())) {
                        if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount() >= 15.0) {
                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                capability.BodyItem.setCount(1); // Set the count to 1
                                capability.syncPlayerVariables(entity); // Sync the changes
                            });

                            {
                                Entity _ent = entity;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                            4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run title @s title {\"text\":\"Enchained!!!\",\"color\":\"dark_red\",\"bold\":true}");
                                }
                            }
                            if (!entityiterator.level().isClientSide())
                                entityiterator.discard();
                            {
                                Entity _ent = entity;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(
                                            new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
                                                    _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                            "execute run summon jujutsucraftaddon:sukuna_fushiguro ~ ~ ~ {ArmorItems:[{id:\"jujutsucraft:uniform_normal_chestplate\",Count:1b},{id:\"jujutsucraft:uniform_normal_leggings\",Count:1b}]}");
                                }
                            }
                            if (entity instanceof ServerPlayer _player)
                                _player.setGameMode(GameType.SURVIVAL);
                            if (entity instanceof ServerPlayer _player) {
                                Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:enchained"));
                                AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                if (!_ap.isDone()) {
                                    for (String criteria : _ap.getRemainingCriteria())
                                        _player.getAdvancements().award(_adv, criteria);
                                }
                            }
                            if (entity instanceof LivingEntity _entity)
                                _entity.removeEffect(JujutsucraftaddonModMobEffects.SUKUNA.get());
                        }
                    }
                }
            }
        }
    }
}
