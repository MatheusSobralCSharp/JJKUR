package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.entity.BlueEntityEntity;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import java.util.List;

public class RedEntityOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(300 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (entityiterator instanceof BlueEntityEntity) {
                    if (entity instanceof Mob _entity)
                        _entity.getNavigation().moveTo((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 480);
                    if (ModList.get().isLoaded("jjkueffects")) {
                        {
                            Entity _ent = entity;
                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                        _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "particle jjkueffects:blue_2 ~ ~-2 ~ 0 0 0 1 1 force");
                            }
                        }
                        if (entityiterator instanceof BlueEntityEntity animatable)
                            animatable.setTexture("none");
                    }
                }
            }
        }
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entityiterator.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("blue");
                    }
                }.getValue() == 1) {
                    if (!entity.level().isClientSide())
                        entity.discard();
                    entity.getPersistentData().putDouble("NameRanged", Math.random());
                    JujutsucraftaddonMod.queueServerWork(60, () -> {
                        {
                            Entity _ent = entity;
                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                _ent.getServer().getCommands().performPrefixedCommand(
                                        new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
                                                _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                        ("execute as @s at @s unless entity @e[nbt={ForgeData:{purple:2d}},distance=..300] run summon jujutsucraft:purple ~ ~ ~ {ForgeData:{BlockDamage:0.0d,BlockRange:0.0d,COOLDOWN_TICKS:10.0d,Damage:378000d,DomainAttack:0b,ExtinctionBlock:0b,attack:0b,NameRanged_ranged:"
                                                + (entity.getPersistentData().getDouble("NameRanged") + ",cnt1:0.0d,cnt3:0.0d,cnt6:" + (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_PURPLE_RANGE)) + ".0d,OWNER_UUID:"
                                                + entity.getStringUUID()
                                                + ",cnt_brokenBrain:0.0d,Full:1.0d,Name_Ranged:0.821,cnt_target:0.0d,effect:0.0d,effectConfirm:0.0d,explode:1b,ignore:0b,knockback:0.0d,noEffect:0b,noParticle:0b,projectile_type:0.0d,skill:215.0d,swing:0b},Attributes:[{Name:\"minecraft:generic.max_health\",Base:20000.0d}],ActiveEffects:[{Id:5,Amplifier:20,Duration:-1,ShowParticles:false}]}")));
                            }
                        }
                    });
                    if (ModList.get().isLoaded("jjkueffects")) {
                        if (world instanceof ServerLevel _level)
                            _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                                    "particle jjkueffects:red_and_blue_2");
                    }
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:purplexplode")), SoundSource.NEUTRAL, 5, 1);
                        } else {
                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:purplexplode")), SoundSource.NEUTRAL, 5, 1, false);
                        }
                    }
                    if (!entityiterator.level().isClientSide())
                        entityiterator.discard();
                }
            }
        }
        {
            Entity _ent = entity;
            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                        _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "particle jjkueffects:blue_2 ~ ~-2 ~ 0 0 0 1 1 force");
            }
        }
        entity.noPhysics = true;
    }
}
