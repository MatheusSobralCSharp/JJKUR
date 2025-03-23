package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.*;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.AISukunaProcedure;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CloneOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        double r = 0;
        double curve = 0;
        double deg = 0;
        double yoff = 0;
        if (entity instanceof CloneEntity || entity instanceof FakeClonesEntity || entity instanceof FakePurpleClonesEntity) {
            CloneEntityProcedureProcedure.execute(world, entity);
            if (Math.random() <= 0.01) {
                TenShadowsRegisterProcedure.execute(entity);
            }
        }
        if (entity instanceof ErroEntity || entity instanceof ErrorEntity) {
            if (!(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(MobEffects.DAMAGE_RESISTANCE))) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 29, false, false));
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 3, false, false));
            }
            AISukunaProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
            CloneEntityProcedureProcedure.execute(world, entity);
            TenShadowsRegisterProcedure.execute(entity);
            RindingTargetProcedure.execute(entity);
            if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
                for (Entity entityiterator : new ArrayList<>(world.players())) {
                    if (entityiterator instanceof Player _playerHasItem && _playerHasItem.getInventory().contains(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:sukuna_finger"))))) {
                        {
                            Entity _ent = entityiterator;
                            _ent.teleportTo((entity.getX()), (entity.getY() + y), (entity.getZ()));
                            if (_ent instanceof ServerPlayer _serverPlayer)
                                _serverPlayer.connection.teleport((entity.getX()), (entity.getY() + y), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
                        }
                        if (entity instanceof Mob _entity && entityiterator instanceof LivingEntity _ent)
                            _entity.setTarget(_ent);
                        if (entityiterator instanceof Player _player) {
                            ItemStack _stktoremove = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:sukuna_finger")));
                            _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                        }
                    }
                }
                if (entity.getPersistentData().getDouble("Timer12") == 0) {
                    List<Entity> players = new ArrayList<>(world.players()); // Get all players
                    if (!players.isEmpty()) {
                        // Pick a random player
                        Entity targetPlayer = players.get(world.getRandom().nextInt(players.size()));
                        // Teleport the entity to the random player's location
                        entity.teleportTo(targetPlayer.getX(), targetPlayer.getY() + 3, targetPlayer.getZ());
                        if (entity instanceof ServerPlayer serverPlayer) {
                            if (!serverPlayer.hasEffect(JujutsucraftaddonModMobEffects.SUKUNA.get())) {
                                serverPlayer.connection.teleport(targetPlayer.getX(), targetPlayer.getY() + 3, targetPlayer.getZ(), entity.getYRot(), entity.getXRot());
                            }
                        }
                        // If the target player has the Sukuna effect, display a message
                        if (targetPlayer instanceof LivingEntity livingEntity && livingEntity.hasEffect(JujutsucraftaddonModMobEffects.SUKUNA.get())) {
                            if (targetPlayer instanceof Player player && !player.level().isClientSide()) {
                                player.displayClientMessage(Component.literal("Sukuna Is Searching For Someone..."), false);
                            }
                        }
                    }
                    entity.getPersistentData().putDouble("Timer12", 1200);
                    entity.getPersistentData().putDouble("Timer12", 1200);
                } else {
                    if (entity.getPersistentData().getDouble("Timer12") > 0) {
                        entity.getPersistentData().putDouble("Timer12", (entity.getPersistentData().getDouble("Timer12") - 1));
                    }
                }
            }
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get(), 60,
                            (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())
                                    ? _livEnt.getEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get()).getAmplifier()
                                    : 0) + 1,
                            false, false));
            }
        }
        if (entity instanceof Shadow1Entity || entity instanceof IgrisEntity) {
            {
                final Vec3 _center = new Vec3(x, y, z);
                List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                for (Entity entityiterator : _entfound) {
                    if (!(entityiterator == entity)) {
                        if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo_no_move")))) {
                            if (!entityiterator.level().isClientSide())
                                entityiterator.discard();
                            deg = entity.getYRot() - 90;
                            r = 1;
                            curve = Mth.nextDouble(RandomSource.create(), -10, 10);
                            for (int index0 = 0; index0 < 5; index0++) {
                                for (int index1 = 0; index1 < 11; index1++) {
                                    if (r == 2 || r == 3) {
                                        yoff = Math.sin(Math.toRadians(deg)) * curve;
                                        {
                                            Entity _ent = entity;
                                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                                _ent.getServer().getCommands().performPrefixedCommand(
                                                        new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
                                                                _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                        ("particle minecraft:dust 1 0 0 1 " + ((x - r * Math.sin(Math.toRadians(deg))) + " ") + ((y + 1 + yoff) + " ") + ((z + r * Math.cos(Math.toRadians(deg))) + " ")
                                                                + ((-0.1) * Math.sin(Math.toRadians(deg)) + " ") + (0 + " ") + (0.1 * Math.cos(Math.toRadians(deg)) + " ") + "1 1 normal"));
                                            }
                                        }
                                        {
                                            Entity _ent = entity;
                                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                                _ent.getServer().getCommands().performPrefixedCommand(
                                                        new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
                                                                _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                        ("particle minecraft:dust 1 0 0 1 " + ((x - r * Math.sin(Math.toRadians(deg))) + " ") + ((y + 1 + yoff) + " ") + ((z + r * Math.cos(Math.toRadians(deg))) + " ")
                                                                + ((-0.1) * Math.sin(Math.toRadians(deg)) + " ") + (0 + " ") + (0.1 * Math.cos(Math.toRadians(deg)) + " ") + "1 1 normal"));
                                            }
                                        }
                                        {
                                            Entity _ent = entity;
                                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                                _ent.getServer().getCommands().performPrefixedCommand(
                                                        new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
                                                                _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                        ("particle minecraft:dust 1 0 0 1 " + ((x - r * Math.sin(Math.toRadians(deg))) + " ") + ((y + 1 + yoff) + " ") + ((z + r * Math.cos(Math.toRadians(deg))) + " ")
                                                                + ((-0.1) * Math.sin(Math.toRadians(deg)) + " ") + (0 + " ") + (0.1 * Math.cos(Math.toRadians(deg)) + " ") + "1 1 normal"));
                                            }
                                        }
                                    }
                                    deg = deg + 18;
                                }
                                if (r == 2 || r == 4) {
                                    deg = entity.getYRot() - 81;
                                } else {
                                    deg = entity.getYRot() - 90;
                                }
                                r = r + 1;
                            }
                        } else if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                            if (!entityiterator.level().isClientSide())
                                entityiterator.discard();
                            deg = entity.getYRot() - 90;
                            r = 1;
                            curve = Mth.nextDouble(RandomSource.create(), -10, 10);
                            for (int index2 = 0; index2 < 5; index2++) {
                                for (int index3 = 0; index3 < 11; index3++) {
                                    if (r == 2 || r == 3) {
                                        yoff = Math.sin(Math.toRadians(deg)) * curve;
                                        {
                                            Entity _ent = entity;
                                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                                _ent.getServer().getCommands().performPrefixedCommand(
                                                        new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
                                                                _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                        ("particle minecraft:dust 1 0 0 1 " + ((x - r * Math.sin(Math.toRadians(deg))) + " ") + ((y + 1 + yoff) + " ") + ((z + r * Math.cos(Math.toRadians(deg))) + " ")
                                                                + ((-0.1) * Math.sin(Math.toRadians(deg)) + " ") + (0 + " ") + (0.1 * Math.cos(Math.toRadians(deg)) + " ") + "1 1 normal"));
                                            }
                                        }
                                        {
                                            Entity _ent = entity;
                                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                                _ent.getServer().getCommands().performPrefixedCommand(
                                                        new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
                                                                _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                        ("particle minecraft:dust 1 0 0 1 " + ((x - r * Math.sin(Math.toRadians(deg))) + " ") + ((y + 1 + yoff) + " ") + ((z + r * Math.cos(Math.toRadians(deg))) + " ")
                                                                + ((-0.1) * Math.sin(Math.toRadians(deg)) + " ") + (0 + " ") + (0.1 * Math.cos(Math.toRadians(deg)) + " ") + "1 1 normal"));
                                            }
                                        }
                                        {
                                            Entity _ent = entity;
                                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                                _ent.getServer().getCommands().performPrefixedCommand(
                                                        new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
                                                                _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                        ("particle minecraft:dust 1 0 0 1 " + ((x - r * Math.sin(Math.toRadians(deg))) + " ") + ((y + 1 + yoff) + " ") + ((z + r * Math.cos(Math.toRadians(deg))) + " ")
                                                                + ((-0.1) * Math.sin(Math.toRadians(deg)) + " ") + (0 + " ") + (0.1 * Math.cos(Math.toRadians(deg)) + " ") + "1 1 normal"));
                                            }
                                        }
                                    }
                                    deg = deg + 18;
                                }
                                if (r == 2 || r == 4) {
                                    deg = entity.getYRot() - 81;
                                } else {
                                    deg = entity.getYRot() - 90;
                                }
                                r = r + 1;
                            }
                        }
                    }
                }
            }
            if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == null)) {
                if (Math.random() <= 0.01) {
                    if ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get(), 40,
                                ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())
                                        ? _livEnt.getEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get()).getAmplifier()
                                        : 0) + 3,
                                false, false));
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 10, false, false));
                    if ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("Beru Gaved You Health"), false);
                }
            }
        }
        if (entity instanceof Shadow1Entity || entity instanceof IgrisEntity || entity instanceof CentipedeEntity) {
            if (!(entity instanceof LivingEntity _livEnt60 && _livEnt60.hasEffect(MobEffects.DAMAGE_BOOST))) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 19, false, false));
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 3, false, false));
            }
        }
    }
}
