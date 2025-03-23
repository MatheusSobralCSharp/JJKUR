package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import java.util.List;

public class TakabaExtensionTwoProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
                .equals(Component.translatable("jujutsu.technique.attack1").getString())) {
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.PlayerSelectCurseTechniqueName = "HAHAHAHA";
                capability.syncPlayerVariables(entity);
            });
        } else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("HAHAHAHA")) {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("skill");
                }
            }.getValue() > 0) {
                {
                    final Vec3 _center = new Vec3(x, y, z);
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                    for (Entity entityiterator : _entfound) {
                        if (!(entity == entityiterator)) {
                            if (!(entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(JujutsucraftaddonModMobEffects.C_DTAKABA.get()))) {
                                if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_TAKABA_REMOVE_ARMOR)) {
                                    {
                                        Entity _ent = entityiterator;
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "item replace entity @s armor.chest with jujutsucraft:clothes_kirara_chestplate");
                                        }
                                    }
                                    {
                                        Entity _ent = entityiterator;
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "item replace entity @s armor.head with jujutsucraft:clothes_kirara_helmet");
                                        }
                                    }
                                    {
                                        Entity _ent = entityiterator;
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "item replace entity @s armor.legs with jujutsucraft:clothes_uraume_leggings");
                                        }
                                    }
                                }
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.C_DTAKABA.get(), 300, 1, false, false));
                            }
                        }
                    }
                }
            }
        }
        if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
                .equals(Component.translatable("jujutsu.technique.attack2").getString())) {
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.PlayerSelectCurseTechniqueName = "Comedy";
                capability.syncPlayerVariables(entity);
            });
        } else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Comedy")) {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("skill");
                }
            }.getValue() > 0) {
                {
                    final Vec3 _center = new Vec3(x, y, z);
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                    for (Entity entityiterator : _entfound) {
                        if (!(entity == entityiterator)) {
                            if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals("jujutsucraft:kenjaku")
                                    || (ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals("jujutsucraft:okkotsu_yuta_culling_game")) {
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entityiterator.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                                        public double getValue() {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                        }
                                    }.getValue()));
                                    entityiterator.load(dataIndex);
                                }
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entityiterator.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                                        public double getValue() {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                        }
                                    }.getValue()));
                                    entityiterator.load(dataIndex);
                                }
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entityiterator.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
                                        public double getValue() {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                        }
                                    }.getValue()));
                                    entityiterator.load(dataIndex);
                                }
                            }
                            if (!(entity instanceof LivingEntity _livEnt27 && _livEnt27.hasEffect(JujutsucraftaddonModMobEffects.CD_TAKABA_2.get()))) {
                                {
                                    Entity _ent = entityiterator;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                        _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                "execute as @s run effect give @s jujutsucraft:unstable 100");
                                    }
                                }
                                {
                                    Entity _ent = entity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(
                                                new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
                                                        _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                ("execute as @s run summon jujutsucraft:okkotsu_yuta_culling_game ~ ~ ~ {ForgeData:{OWNER_UUID:\"" + (entity.getStringUUID() + "\"}}")));
                                    }
                                }
                                {
                                    Entity _ent = entity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands()
                                                .performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                                                _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                        ("execute as @s run summon jujutsucraft:kenjaku ~ ~ ~ {ForgeData:{OWNER_UUID:\"" + (entity.getStringUUID() + "\"}}")));
                                    }
                                }
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.CD_TAKABA_2.get(), 2400, 1, false, false));
                            }
                        }
                    }
                }
            }
        }
        if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
                .equals(Component.translatable("jujutsu.technique.attack3").getString())) {
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.PlayerSelectCurseTechniqueName = "Nuh uh";
                capability.syncPlayerVariables(entity);
            });
        } else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Nuh uh")) {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("skill");
                }
            }.getValue() > 0) {
                if (!(entity instanceof LivingEntity _livEnt40 && _livEnt40.hasEffect(JujutsucraftaddonModMobEffects.CD_TAKABA_2.get()))) {
                    entity.setInvulnerable(true);
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.C_DTAKABA.get(), 600, 1, false, false));
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.CD_TAKABA_2.get(), 2000, 1, false, false));
                }
            }
        }
    }
}
