package com.jujutsu.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KeySimpleDomainOnKeyPressedProcedure;
import net.mcreator.jujutsucraft.procedures.KeySimpleDomainOnKeyReleasedProcedure;
import net.mcreator.jujutsucraft.procedures.LogicSimpleDomainProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = KeySimpleDomainOnKeyPressedProcedure.class, priority = -10000)
public abstract class SimpleDomainKeyMixin {

    /**
     * @author Satushi
     * @reason Execution of Simple Domain Animation
     */

    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            boolean number;
            boolean on;
            boolean falling_blossom;
            double cost;
            double strength;
            int var10000;
            double num1;
            double num2;
            LivingEntity _livEnt;
            LivingEntity _entity;
            label356:
            {
                number = false;
                on = false;
                falling_blossom = false;
                double timer = 0.0;
                cost = 0.0;
                strength = 0.0;
                num1 = 0.0;
                num2 = 0.0;
                if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity) entity;
                    if (_entity.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        label351:
                        {
                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity) entity;
                                if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label351;
                                }
                            }

                            var10000 = 0;
                        }

                        var10000 += 2;
                        break label356;
                    }
                }

                var10000 = 1;
            }

            strength = (double) var10000;
            LivingEntity _livEnt28;
            if (entity instanceof Player) {
                number = (((new Object() {
                    public boolean checkGamemode(Entity _ent) {
                        if (_ent instanceof ServerPlayer _serverPlayer) {
                            return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                        } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
                            return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
                        } else {
                            return false;
                        }
                    }
                })).checkGamemode(entity));
                cost = 50.0;
                if (entity instanceof LivingEntity) {
                    _livEnt = (LivingEntity) entity;
                    if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.SIX_EYES.get())) {
                        int var10002;
                        label342:
                        {
                            if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity) entity;
                                if (_entity.hasEffect((MobEffect) JujutsucraftModMobEffects.SIX_EYES.get())) {
                                    var10002 = _entity.getEffect((MobEffect) JujutsucraftModMobEffects.SIX_EYES.get()).getAmplifier();
                                    break label342;
                                }
                            }

                            var10002 = 0;
                        }

                        cost = (double) Math.round(cost * Math.pow(0.5, (double) (var10002 + 1)));
                    }
                }
            } else {
                boolean var36;
                if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:can_use_falling_blossom_emotion")))) {
                    if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:can_use_simple_domain")))) {
                        label390:
                        {
                            if (entity instanceof LivingEntity) {
                                _livEnt28 = (LivingEntity) entity;
                                if (_livEnt28.hasEffect((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME_SIMPLE_DOMAIN.get())) {
                                    label379:
                                    {
                                        if (entity instanceof LivingEntity) {
                                            _entity = (LivingEntity) entity;
                                            if (_entity.hasEffect((MobEffect) JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                                                label328:
                                                {
                                                    if (entity instanceof LivingEntity) {
                                                        _livEnt = (LivingEntity) entity;
                                                        if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                                                            var10000 = _livEnt.getEffect((MobEffect) JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getAmplifier();
                                                            break label328;
                                                        }
                                                    }

                                                    var10000 = 0;
                                                }

                                                if (var10000 > 0) {
                                                    break label379;
                                                }
                                            }
                                        }

                                        var36 = true;
                                        break label390;
                                    }
                                }
                            }

                            var36 = false;
                        }
                    } else {
                        var36 = true;
                    }

                    falling_blossom = var36;
                }

                label391:
                {
                    if (!falling_blossom) {
                        label380:
                        {
                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity) entity;
                                if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get())) {
                                    break label380;
                                }
                            }

                            var36 = false;
                            break label391;
                        }
                    }

                    var36 = true;
                }

                falling_blossom = var36;
            }

            label411:
            {
                if (entity instanceof Player) {
                    if (entity.isShiftKeyDown() && entity instanceof ServerPlayer) {
                        ServerPlayer _plr14 = (ServerPlayer) entity;
                        if (_plr14.level() instanceof ServerLevel && _plr14.getAdvancements().getOrStartProgress(_plr14.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:mastery_falling_blossom_emotion"))).isDone() && ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer > 50.0) {
                            break label411;
                        }
                    }
                } else if (falling_blossom) {
                    break label411;
                }

                label293:
                {
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity) entity;
                        if (_entity.hasEffect((MobEffect) JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                            var10000 = _entity.getEffect((MobEffect) JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getAmplifier();
                            break label293;
                        }
                    }

                    var10000 = 0;
                }

                String var10001;
                LivingEntity _livEnt45;
                LivingEntity _livingEntity48;
                Player _player;
                Entity _ent;
                boolean var37;
                if (var10000 > 0) {
                    if (entity instanceof LivingEntity) {
                        _livEnt45 = (LivingEntity) entity;
                        _livEnt45.removeEffect((MobEffect) JujutsucraftModMobEffects.SIMPLE_DOMAIN.get());
                    }

                    if (entity instanceof Player) {
                        _player = (Player) entity;
                        if (!_player.level().isClientSide()) {
                            label218:
                            {
                                var10001 = Component.translatable("effect.simple_domain").getString();
                                if (entity instanceof LivingEntity) {
                                    _livingEntity48 = (LivingEntity) entity;
                                    if (_livingEntity48.hasEffect((MobEffect) JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                                        var37 = true;
                                        break label218;
                                    }
                                }

                                var37 = false;
                            }

                            _player.displayClientMessage(Component.literal(var10001 + ": " + var37), false);
                        }
                    }

                    _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound ui.button.click master @s");
                    }
                } else {
                    label368:
                    {
                        if (entity instanceof LivingEntity) {
                            _livEnt28 = (LivingEntity) entity;
                            if (_livEnt28.hasEffect((MobEffect) JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                                break label368;
                            }
                        }

                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEnt29 = (LivingEntity) entity;
                            if (_livEnt29.hasEffect((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME_SIMPLE_DOMAIN.get())) {
                                break label368;
                            }
                        }

                        if (LogicSimpleDomainProcedure.execute()) {
                            if (!(entity instanceof Player)) {
                                on = entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:can_use_simple_domain")));
                            } else {
                                label274:
                                {
                                    if (entity instanceof ServerPlayer) {
                                        ServerPlayer _plr31 = (ServerPlayer) entity;
                                        if (_plr31.level() instanceof ServerLevel && _plr31.getAdvancements().getOrStartProgress(_plr31.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:mastery_simple_domain"))).isDone()) {
                                            if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer > 50.0 && (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower >= cost || number)) {
                                                if (!number) {
                                                    double _setval = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - cost;
                                                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                                        capability.PlayerCursePower = _setval;
                                                        capability.syncPlayerVariables(entity);
                                                    });
                                                }

                                                on = true;
                                            } else if (entity instanceof Player) {
                                                _player = (Player) entity;
                                            }
                                            break label274;
                                        }
                                    }

                                    if (entity instanceof Player) {
                                        _player = (Player) entity;
                                        if (!_player.level().isClientSide()) {
                                            _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.not_mastered").getString()), false);
                                        }
                                    }
                                }

                                _ent = entity;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound ui.button.click master @s");
                                }
                            }

                            if (on) {
                                if (entity instanceof LivingEntity) {
                                    _livEnt45 = (LivingEntity) entity;
                                    if (!_livEnt45.level().isClientSide()) {
                                        _livEnt45.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.SIMPLE_DOMAIN.get(), (int) (100.0 + strength * 20.0), (int) strength, true, true));
                                    }
                                }

                                if (entity instanceof LivingEntity) {
                                    _livEnt45 = (LivingEntity) entity;
                                    if (!_livEnt45.level().isClientSide()) {
                                        _livEnt45.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 30, false, false));
                                    }
                                }

                                if (entity instanceof Player) {
                                    _player = (Player) entity;
                                    if (!_player.level().isClientSide()) {
                                        label252:
                                        {
                                            var10001 = Component.translatable("effect.simple_domain").getString();
                                            if (entity instanceof LivingEntity) {
                                                _livingEntity48 = (LivingEntity) entity;
                                                if (_livingEntity48.hasEffect((MobEffect) JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                                                    var37 = true;
                                                    break label252;
                                                }
                                            }

                                            var37 = false;
                                        }

                                        _player.displayClientMessage(Component.literal(var10001 + ": " + var37), false);
                                    }
                                }

                                if (entity instanceof LivingEntity) {
                                    _livEnt45 = (LivingEntity) entity;
                                    if (_livEnt45.getAttributes().hasAttribute((Attribute) JujutsucraftModAttributes.ANIMATION_1.get())) {
                                        _livEnt45.getAttribute((Attribute) JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-16.0);
                                    }
                                }

                                label397:
                                {
                                    num1 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
                                    num2 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
                                    if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:can_use_hollow_wicker_basket")))) {
                                        label387:
                                        {
                                            if (entity instanceof LivingEntity) {
                                                _livEnt45 = (LivingEntity) entity;
                                                if (_livEnt45.hasEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                                    break label387;
                                                }
                                            }

                                            if (!(entity instanceof Player) || num1 != 1.0 && num2 != 1.0 && num1 != 7.0 && num2 != 7.0 && num1 != 12.0 && num2 != 12.0 && num1 != 24.0 && num2 != 24.0) {
                                                if (entity instanceof LivingEntity) {
                                                    _livingEntity48 = (LivingEntity) entity;
                                                    if (_livingEntity48.getAttributes().hasAttribute((Attribute) JujutsucraftModAttributes.ANIMATION_2.get())) {
                                                        _livingEntity48.getAttribute((Attribute) JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                                                    }
                                                }
                                                break label397;
                                            }
                                        }
                                    }

                                    if (entity instanceof LivingEntity) {
                                        _livingEntity48 = (LivingEntity) entity;
                                        if (_livingEntity48.getAttributes().hasAttribute((Attribute) JujutsucraftModAttributes.ANIMATION_2.get())) {
                                            _livingEntity48.getAttribute((Attribute) JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(1.0);
                                        }
                                    }
                                }

                                PlayAnimationProcedure.execute(world, entity);
                            }

                            return;
                        }
                    }

                    if (entity instanceof Player) {
                        return;
                    }
                }

                return;
            }

            if (entity instanceof Player) {
                on = true;
            } else {
                label388:
                {
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity) entity;
                        if (_entity.hasEffect((MobEffect) JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get())) {
                            on = false;
                            KeySimpleDomainOnKeyReleasedProcedure.execute(entity);
                            break label388;
                        }
                    }

                    on = true;
                }
            }

            if (on) {
                if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity) entity;
                    if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get(), Integer.MAX_VALUE, (int) strength, true, true));
                    }
                }

                if (entity instanceof Player) {
                    Player _player = (Player) entity;
                    if (!_player.level().isClientSide()) {
                        _player.displayClientMessage(Component.literal("§l" + Component.translatable("effect.jujutsucraft.falling_blossom_emotion").getString()), false);
                    }
                }

                if (world instanceof Level) {
                    Level _level = (Level) world;
                    if (!_level.isClientSide()) {
                        _level.playSound((Player) null, BlockPos.containing(x, y, z), (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:frame_set")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                    } else {
                        _level.playLocalSound(x, y, z, (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:frame_set")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                    }
                }

                if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity) entity;
                    if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 30, false, false));
                    }
                }
            }
        }
    }
}
