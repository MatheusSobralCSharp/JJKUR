package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class NozarashiLivingEntityIsHitWithToolProcedure {
    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, ItemStack itemstack) {
        if (entity == null || sourceentity == null)
            return;
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANTI_HEAL.get(), 120, 1, false, false));
        if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 120,
                    (sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) + 1, false, false));
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 120, 254, false, false));
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.POISON, 120, 100, false, false));
        if (sourceentity instanceof LivingEntity _entity)
            _entity.setHealth((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 20);
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.NEUTRALIZATION.get(), 120,
                    (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier() : 0) + 1, false, false));
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 120,
                    (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getAmplifier() : 0) + 1, false, false));
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 120,
                    (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get()).getAmplifier() : 0) + 1,
                    false, false));
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 120,
                    (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getAmplifier() : 0) + 1, false,
                    false));
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_SIMPLE_DOMAIN.get(), 120,
                    (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_SIMPLE_DOMAIN.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_SIMPLE_DOMAIN.get()).getAmplifier() : 0)
                            + 1,
                    false, false));
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.UNSTABLE.get(), 120,
                    (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.UNSTABLE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.UNSTABLE.get()).getAmplifier() : 0) + 1, false, false));
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.FATIGUE.get(), 120,
                    (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.FATIGUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.FATIGUE.get()).getAmplifier() : 0) + 1, false, false));
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CANCEL_CURSED_TECHNIQUE.get(), 120,
                    (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CANCEL_CURSED_TECHNIQUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.CANCEL_CURSED_TECHNIQUE.get()).getAmplifier() : 0) + 1,
                    false, false));
        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower >= 500) {
            {
                Entity _ent = entity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                            _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run jjc_cursepower -500 @s");
                }
            }
        }
        if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo_no_move")))) {
            if (!entity.level().isClientSide())
                entity.discard();
        } else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
            if (!entity.level().isClientSide())
                entity.discard();
        }
        if (itemstack.getItem() == JujutsucraftaddonModItems.NOZARASHI.get()) {
            if (!((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Zaraki")) {
                if (Math.random() <= 0.2) {
                    if (itemstack.getOrCreateTag().getDouble("Shikai") < 99) {
                        itemstack.getOrCreateTag().putDouble("Shikai", (itemstack.getOrCreateTag().getDouble("Shikai") + 1));
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal(("Shikai: " + itemstack.getOrCreateTag().getDouble("Shikai") + "%")), false);
                    } else if (itemstack.getOrCreateTag().getDouble("Shikai") == 99) {
                        itemstack.getOrCreateTag().putDouble("Shikai", (itemstack.getOrCreateTag().getDouble("Shikai") + 1));
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Fully Awakened Shikai, Right Click For Awakening"), false);
                    }
                }
            } else {
                if (itemstack.getOrCreateTag().getDouble("Shikai") < 99) {
                    itemstack.getOrCreateTag().putDouble("Shikai", (itemstack.getOrCreateTag().getDouble("Shikai") + 1));
                    if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal(("Shikai: " + itemstack.getOrCreateTag().getDouble("Shikai") + "%")), false);
                } else if (itemstack.getOrCreateTag().getDouble("Shikai") == 99) {
                    itemstack.getOrCreateTag().putDouble("Shikai", (itemstack.getOrCreateTag().getDouble("Shikai") + 1));
                    if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("Fully Awakened Shikai, Right Click For Awakening"), false);
                }
            }
        } else if (itemstack.getItem() == JujutsucraftaddonModItems.NOZARASHI_SHIKAI.get()) {
            if (!((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Zaraki")) {
                if (Math.random() <= 0.2) {
                    if (itemstack.getOrCreateTag().getDouble("Bankai") < 99) {
                        itemstack.getOrCreateTag().putDouble("Bankai", (itemstack.getOrCreateTag().getDouble("Bankai") + 1));
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal(("Bankai: " + itemstack.getOrCreateTag().getDouble("Shikai") + "%")), false);
                    } else if (itemstack.getOrCreateTag().getDouble("Bankai") == 99) {
                        itemstack.getOrCreateTag().putDouble("Bankai", (itemstack.getOrCreateTag().getDouble("Bankai") + 1));
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("..."), false);
                    }
                }
            } else {
                if (itemstack.getOrCreateTag().getDouble("Bankai") < 99) {
                    itemstack.getOrCreateTag().putDouble("Bankai", (itemstack.getOrCreateTag().getDouble("Bankai") + 1));
                    if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal(("Bankai: " + itemstack.getOrCreateTag().getDouble("Shikai") + "%")), false);
                } else if (itemstack.getOrCreateTag().getDouble("Bankai") == 99) {
                    itemstack.getOrCreateTag().putDouble("Bankai", (itemstack.getOrCreateTag().getDouble("Bankai") + 1));
                    if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("..."), false);
                }
            }
        }
    }
}
