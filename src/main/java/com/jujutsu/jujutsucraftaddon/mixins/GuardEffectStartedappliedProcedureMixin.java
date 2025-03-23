package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.StartGuardProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import software.bernie.geckolib.animatable.GeoEntity;


@Mixin(value = StartGuardProcedure.class, priority = -10000)
public abstract class GuardEffectStartedappliedProcedureMixin {

    /**
     * @author Satushi
     * @reason Changes the guard + remove the sukuna slash guard when the effect start for balance reasons
     */
    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, Entity entity, CallbackInfo ci) {
        ci.cancel();
        if (entity != null) {
            double animation_num = 0.0;
            double tick = 0.0;
            if (entity instanceof LivingEntity _12 && !_12.hasEffect(JujutsucraftaddonModMobEffects.SOKA_MONA.get())) {
                if (!(entity instanceof Player) || !((new Object() {
                    public boolean checkGamemode(Entity _ent) {
                        if (_ent instanceof ServerPlayer _serverPlayer) {
                            return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                        } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
                            return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
                        } else {
                            return false;
                        }
                    }
                })).checkGamemode(entity) && !((new Object() {
                    public boolean checkGamemode(Entity _ent) {
                        if (_ent instanceof ServerPlayer _serverPlayer) {
                            return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
                        } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
                            return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
                        } else {
                            return false;
                        }
                    }
                })).checkGamemode(entity)) {
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt3 = (LivingEntity) entity;
                        if (_livEnt3.hasEffect((MobEffect) JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                            return;
                        }
                    }

                    if (entity.getPersistentData().getDouble("skill") == 0.0) {
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEnt5 = (LivingEntity) entity;
                            if (_livEnt5.hasEffect((MobEffect) JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get()) && entity.getPersistentData().getBoolean("PRESS_M")) {
                                return;
                            }
                        }

                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEnt7 = (LivingEntity) entity;
                            if (_livEnt7.hasEffect((MobEffect) JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get())) {
                                return;
                            }
                        }

                        LivingEntity _entity;
                        label93:
                        {
                            if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity) entity;
                                if (_entity.hasEffect((MobEffect) JujutsucraftModMobEffects.DAMAGE_EFFECT.get())) {
                                    break label93;
                                }
                            }

                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEnt9 = (LivingEntity) entity;
                                if (_livEnt9.hasEffect((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME_GUARD.get())) {
                                    break label93;
                                }
                            }
                            label62:
                            {
                                if (entity instanceof LivingEntity) {
                                    _entity = (LivingEntity) entity;
                                    if (_entity.hasEffect((MobEffect) JujutsucraftModMobEffects.PRAYER_SONG.get())) {
                                        tick = 15.0;
                                        animation_num = (double) Math.round(-15.0 + Math.ceil(Math.random() * 4.0));
                                        break label62;
                                    }
                                }

                                tick = 10.0;
                                if (entity instanceof GeoEntity) {
                                    animation_num = -9.0;
                                }
                            }

                            if (animation_num > 0.0) {
                                if (entity instanceof LivingEntity) {
                                    _entity = (LivingEntity) entity;
                                    if (_entity.getAttributes().hasAttribute((Attribute) JujutsucraftModAttributes.ANIMATION_1.get())) {
                                        _entity.getAttribute((Attribute) JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(animation_num);
                                    }
                                }

                                PlayAnimationProcedure.execute(world, entity);
                            }

                            if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity) entity;
                                if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.GUARD.get(), (int) tick, 1, false, false));
                                }
                            }
                        }

                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity) entity;
                            if (!_entity.level().isClientSide()) {
                                _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME_GUARD.get(), 20, 0, false, false));
                            }
                        }

                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity) entity;
                            if (!_entity.level().isClientSide()) {
                                _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.GUARD.get(), 10, 0, false, false));
                            }
                        }
                    }
                }
            }

        }

    }
}
