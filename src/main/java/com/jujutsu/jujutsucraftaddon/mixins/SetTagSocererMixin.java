package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.entity.FushiguroTojiBugEntity;
import net.mcreator.jujutsucraft.entity.FushiguroTojiEntity;
import net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity;
import net.mcreator.jujutsucraft.entity.SukunaPerfectEntity;
import net.mcreator.jujutsucraft.procedures.SetTagProcedure;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Comparator;
import java.util.List;


@Mixin(value = SetTagProcedure.class, priority = -10000)
public class SetTagSocererMixin {

    @Inject(at = @At("HEAD"), method = "execute", remap = false)
    private static void execute(LevelAccessor world, Entity entity, CallbackInfo ci) {
        if (entity != null) {

            if (entity instanceof SukunaFushiguroEntity _datEntL0 && !_datEntL0.getEntityData().get(SukunaFushiguroEntity.DATA_perfect_mode)) {
                _datEntL0.setItemSlot(EquipmentSlot.CHEST, new ItemStack((ItemLike) JujutsucraftaddonModItems.SUKUNA_COAT_BLACK.get()));
            }

            if (entity instanceof SukunaPerfectEntity) {
                if (!((((SukunaPerfectEntity) entity).animationprocedure).equals("heianform"))) {
                    ((SukunaPerfectEntity) entity).setAnimation("heianform");

                    if (entity instanceof LivingEntity _entity6 && !_entity6.level().isClientSide())
                        _entity6.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANIMATION_HEIAN.get(), 40, 1, false, false));

                    {
                        final Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());
                        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                        for (Entity entityiterator : _entfound) {
                            {
                                Entity _ent = entity;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                            _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "particle jjkueffects:red_awakening_2 ~ ~-1 ~ 0 0 0 1 1 force");
                                }
                            }

                            if (entityiterator instanceof Player _player && !_player.level().isClientSide())
                                _player.displayClientMessage(Component.literal("Like a Calamity, The Strongest Sorcerer from History, Awakens"), false);
                        }

                    }
                }
            }
            if (entity instanceof FushiguroTojiBugEntity) {
                if (!((((FushiguroTojiBugEntity) entity).animationprocedure).equals("tojiawakening"))) {
                    ((FushiguroTojiBugEntity) entity).setAnimation("tojiawakening");
                }
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 2, false, false));

                {
                    final Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                    for (Entity entityiterator : _entfound) {
                        if (entityiterator != entity) {
                            if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.QUAKE.get(), 380, 1,
                                        false, false));
                            if (entityiterator instanceof Player _player && !_player.level().isClientSide())
                                _player.displayClientMessage(Component.literal("The One Who Left It All Behind... And His Overwhelming Intensity!"), false);
                        }
                    }

                }

            } else if (entity instanceof FushiguroTojiEntity) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 2, false, false));
            }
        }
    }
}

