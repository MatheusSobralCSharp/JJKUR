package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.RainbowTextUtil;
import com.jujutsu.jujutsucraftaddon.entity.*;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KeySimpleDomainOnKeyPressedProcedure;
import net.mcreator.jujutsucraft.procedures.StartGuardProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Mod.EventBusSubscriber
public class AttackPlayerProcedure {
    @SubscribeEvent
    public static void onEntityAttacked(LivingHurtEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getEntity(), event.getSource().getEntity(), event.getAmount());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity, double amount) {
        execute(null, world, x, y, z, damagesource, entity, sourceentity, amount);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity, double amount) {
        if (damagesource == null || entity == null || sourceentity == null)
            return;
        boolean mahoraga = false;
        ResourceLocation entityTypeKey = ForgeRegistries.ENTITY_TYPES.getKey(entity.getType());
        if (entityTypeKey == null || entityTypeKey.toString().startsWith("jujutsucraft")) {
            if (!(damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:start_animation"))))) {
                if (entity instanceof LivingEntity && (!((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()))) {
                    if (!((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                        if (Math.random() < (1) / ((float) 100)) {
                            StartGuardProcedure.execute(world, entity);
                        }
                    }
                }
            }
        }
        if (!(damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:start_animation"))))) {
            if ((ForgeRegistries.ITEMS.getKey((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:knife")) {
                if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Majima")) {
                    if (sourceentity instanceof LivingEntity _ent && !_ent.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                        if (Math.random() < (1) / ((float) 10)) {
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 40, 1, false, false));
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 40, 1, false, false));
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANTI_HEAL.get(), 40, 1, false, false));
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ATTACKED.get(), 60, 1, false, false));
                        }
                    }
                }
            }

            if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Kiryu")) {
                if (entity instanceof LivingEntity _ent && _ent.hasEffect(JujutsucraftaddonModMobEffects.COUNTER.get())) {
                    sourceentity.hurt(damagesource, (float) amount * 2);
                    CounterProcedureProcedure.execute(world, damagesource, entity, sourceentity);
                    if (event != null && event.isCancelable()) {
                        event.setCanceled(true);
                    } else if (event != null && event.hasResult()) {
                        event.setResult(Event.Result.DENY);
                    }
                }
            }


            if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Kiryu")) {
                if (Math.random() < (1) / ((float) 30)) {
                    entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))), (float) amount * 2);
                } else if (Math.random() < (1) / ((float) 20)) {
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.RCT_CUT.get(), 60, 1, false, false));
                } else {
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.FATIGUE_BLACK_FLASH.get(), 120, 1, false, false));
                }
            }

            if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Kiryu")) {
                if (Math.random() < (1) / ((float) 30)) {
                    InfComboProcedure.execute(world, sourceentity);
                }
            }


            if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Kiryu")) {
                if (sourceentity instanceof LivingEntity _ent && !_ent.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                    if (Math.random() < (1) / ((float) 10)) {
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 40, 1, false, false));
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 40, 1, false, false));
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANTI_HEAL.get(), 120, 1, false, false));
                    }
                }
            }


            if (entity instanceof LivingEntity) {
                CeLevelProcedure.execute(world, sourceentity);
                if (entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(JujutsucraftaddonModMobEffects.DAMAGE.get())) {
                    if (entity instanceof Player _playerHasItem && _playerHasItem.getInventory().contains(new ItemStack(JujutsucraftaddonModItems.ARTIFACT_5.get()))) {
                        entity.getPersistentData().putDouble("DamageFinal", (entity.getPersistentData().getDouble("DamageFinal") + amount));
                    }
                }
                if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 7) {
                    if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain) {
                        KashimoDefenseProcedure.execute(world, x, y, z, entity);
                    }
                }
                if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 30) {
                    if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain) {
                        MiguelAttackedProcedure.execute(world, entity, sourceentity);
                    }
                }
                if (entity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(JujutsucraftaddonModMobEffects.COUNTER.get())) {
                    CounterProcedureProcedure.execute(world, damagesource, entity, sourceentity);
                    if (event != null && event.isCancelable()) {
                        event.setCanceled(true);
                    } else if (event != null && event.hasResult()) {
                        event.setResult(Event.Result.DENY);
                    }
                }

                if (!((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()))) {
                    if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain) {
                        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 6) {
                            MegumiHitProcedure.execute(world, entity, sourceentity);
                        }
                    }
                    if ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())
                            ? ((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).getAmplifier()
                            : 0) >= 19) {
                        if (!(entity instanceof ServerPlayer _plr14 && _plr14.level() instanceof ServerLevel
                                && _plr14.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr14.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:world_slash_advancement")))).isDone()) && entity instanceof ServerPlayer _plr15
                                && _plr15.level() instanceof ServerLevel && _plr15.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr15.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:cleave_web_advancement")))).isDone()) {
                            WorldSlashQuestProcedure.execute(world, entity);
                        }
                    }
                    if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BrainDamage == 5) {
                        BrainEffectTwoProcedure.execute(world, entity);
                    }
                    if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_SUKUNA_POSSESSION_ENABLED)) {
                        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 6
                                || (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 21) {
                            if (Math.random() <= 0.05) {
                                if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.getCount() >= 1.0) {
                                    if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) <= (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SUKUNA_HEALTH_POSSESSION))) {
                                        SukunaKeybindOnKeyPressedProcedure.execute(entity);
                                    }
                                }
                            }
                        }
                    }
                    if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 5) {
                        ChangeMimicryProcedure.execute(entity, sourceentity);
                    }
                    if (entity instanceof LivingEntity && !((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
                            if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != -1) {
                                if (entity instanceof LivingEntity && !((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                                    if (!((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Death Painting")) {
                                        if (amount > 5) {
                                            LimbssProcedure.execute(world, entity, amount);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_LIMB_LOSS)) {
                        if (!(new Object() {
                            public boolean checkGamemode(Entity _ent) {
                                if (_ent instanceof ServerPlayer _serverPlayer) {
                                    return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                                } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
                                    return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                            && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
                                }
                                return false;
                            }
                        }.checkGamemode(entity))) {
                            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Limb > 0) {
                                if (!(entity instanceof LivingEntity _livEnt28 && _livEnt28.hasEffect(JujutsucraftaddonModMobEffects.LIMBS_EFFECT.get()))) {
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.LIMBS_EFFECT.get(), -1, 1, false, false));
                                }
                            }
                        }
                    }
                    if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                        if (entity instanceof LivingEntity && !((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CEShield == 3) {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get(), 20,
                                            (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get())
                                                    ? ((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get()).getAmplifier()
                                                    : 0) + 1,
                                            false, false));
                            } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CEShield == 4) {
                                KeySimpleDomainOnKeyPressedProcedure.execute(world, x, y, z, entity);
                            }
                        }
                    }
                    if (entity.getPersistentData().getDouble("brokenBrain") == 2) {
                        if (!(entity instanceof LivingEntity _livEnt34 && _livEnt34.hasEffect(MobEffects.CONFUSION))) {
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 60, 245, false, false));
                        }
                    }
                }
                if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Disaster Curses")) {
                    ((LivingHurtEvent) event).setAmount(((float) (amount / 1.2)));
                }
                if (entity instanceof LivingEntity _livEnt37 && _livEnt37.hasEffect(JujutsucraftaddonModMobEffects.BERSERK.get())) {
                    if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == -1) {
                        ((LivingHurtEvent) event).setAmount(((float) (amount / 1.1)));
                    }
                }
                if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
                    if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_BLACK_FLASH_REWORKED)) {
                        CounterBFProcedure.execute(world, sourceentity);
                    }
                }
                if (entity instanceof LivingEntity _livEnt41 && _livEnt41.hasEffect(JujutsucraftaddonModMobEffects.TRAINING.get())) {
                    if (amount > 150) {
                        TrainingFailedProcedure.execute(world, x, y, z, entity);
                    }
                }
                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain) {
                    if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 20) {
                        if (!(entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get()))
                                && !(entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()))
                                && !(entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()))) {
                            MegumiProcedure.execute(world, x, y, z, entity, sourceentity, amount);
                        }
                    }
                }
                if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                    if (!((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()))) {
                        LineSukunaProcedure.execute(world, x, y, z, sourceentity);
                    }
                }
                if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:gojo_satoru")) {
                    if (!((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()))) {
                        LineGojoProcedure.execute(world, x, y, z, sourceentity);
                    }
                }
                if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 5) {
                    if (entity instanceof ServerPlayer _plr51 && _plr51.level() instanceof ServerLevel
                            && _plr51.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr51.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:sorcerer_strongest_of_modern")))).isDone()) {
                        if (entity instanceof LivingEntity && !((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                            if (!((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()))) {
                                YutaCondition2Procedure.execute(world, x, y, z, entity);
                            }
                        }
                    }
                }

                if ((damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_combat"))) || (damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))))) {
                    if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CEShield == 2) {
                        if (!entity.level().isClientSide() && entity.getServer() != null) {
                            CommandSourceStack var10001;
                            float var10002;
                            Commands var73;
                            label568:
                            {
                                var73 = entity.getServer().getCommands();
                                var10001 = new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity);
                                if (entity instanceof LivingEntity _entity) {
                                    if (_entity.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                        var10002 = (float) _entity.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                        break label568;
                                    }
                                }

                                var10002 = 0.0F;
                            }

                            var73.performPrefixedCommand(var10001, "effect give @s jujutsucraft:domain_amplification 1 " + Math.round(var10002) + " false");
                        }
                    }
                }

                if ((damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_combat"))) || (damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))))) {
                    if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CEShield == 1 && entity instanceof LivingEntity _li3 && !_li3.hasEffect(JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel > 0) {
                            if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower > 100) {
                                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.PlayerCursePower = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower
                                            - 150 / (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel);
                                    capability.syncPlayerVariables(entity);
                                });
                                ((LivingHurtEvent) event).setAmount(((float) (amount / 2)));
                                double distance_power = 2.0;
                                if (entity instanceof LivingEntity _liv && _liv.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                    if (world instanceof ServerLevel _level) {
                                        _level.sendParticles((SimpleParticleType) JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_RED.get(), entity.getX(), entity.getY(), entity.getZ(), (int) Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), distance_power, 0.0, distance_power, Math.min(distance_power * 0.1, 1.5));
                                    }
                                } else if (entity instanceof LivingEntity _liv && _liv.hasEffect(JujutsucraftModMobEffects.JACKPOT.get())) {
                                    if (world instanceof ServerLevel _level) {
                                        _level.sendParticles((SimpleParticleType) JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_GREEN.get(), entity.getX(), entity.getY(), entity.getZ(), (int) Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), distance_power, 0.0, distance_power, Math.min(distance_power * 0.1, 1.5));
                                    }
                                } else if (world instanceof ServerLevel _level) {
                                    _level.sendParticles((SimpleParticleType) JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), entity.getX(), entity.getY(), entity.getZ(), (int) Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), distance_power, 0.0, distance_power, Math.min(distance_power * 0.1, 1.5));
                                }
                            }
                        }
                    }
                }

                if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 16.0 || ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 16.0 || ((JujutsucraftaddonModVariables.PlayerVariables) entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mahoraga == 1.0) {
                    mahoraga = true;
                } else if ((entity instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity) || (entity instanceof IgrisEntity) || (entity instanceof Shadow1Entity)) {
                    mahoraga = true;
                }

                if (mahoraga) {
                    if (!(damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_combat"))) || (damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))))) {
                        if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) < 49) {
                            if (Math.random() < (1) / ((float) 100)) {
                                (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putDouble(("" + damagesource),
                                        ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) + 1));
                                if (entity instanceof Player _player && !_player.level().isClientSide())
                                    _player.displayClientMessage(
                                            Component.literal(("Adapting: " + (((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource))) + "%"))),
                                            false);
                            }
                        } else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) == 49) {
                            (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putDouble(("" + damagesource),
                                    ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) + 1));
                            if (entity instanceof Player _player) {
                                RainbowTextUtil.sendRainbowMessage(_player, "Mahoraga Adapted To: " + damagesource);
                                RainbowTextUtil.sendRainbowMessage(_player, "50% Of Damage Reduction");
                            }
                        }
                        double defense1 = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource));
                        double amount2 = amount * (1 - (defense1 / 100));
                        ((LivingHurtEvent) event).setAmount(((float) amount2));
                    } else if (damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_combat")))) {
                        if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) < 24) {
                            if (Math.random() < (1) / ((float) 100)) {
                                (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putDouble(("" + damagesource),
                                        ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) + 1));
                                if (entity instanceof Player _player && !_player.level().isClientSide())
                                    _player.displayClientMessage(
                                            Component.literal(("Adaptation: " + (((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource))) + "%"))),
                                            false);
                            }
                        } else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) == 24) {
                            (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putDouble(("" + damagesource),
                                    ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) + 1));
                            if (entity instanceof Player _player) {
                                RainbowTextUtil.sendRainbowMessage(_player, "Mahoraga Adapted To: Jujutsu Damage");
                                RainbowTextUtil.sendRainbowMessage(_player, "25% Of Jujutsu Damage Reduction");
                            }
                        }
                        double defense1 = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource));
                        double amount2 = amount * (1 - (defense1 / 100));
                        ((LivingHurtEvent) event).setAmount(((float) amount2));
                    } else if (damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))) {
                        if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) < 24) {
                            if (Math.random() < (1) / ((float) 100)) {
                                (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putDouble(("" + damagesource),
                                        ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) + 1));
                                if (entity instanceof Player _player && !_player.level().isClientSide())
                                    _player.displayClientMessage(
                                            Component.literal(("Adapting: " + (((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource))) + "%"))),
                                            false);
                            }
                        } else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) == 24) {
                            (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putDouble(("" + damagesource),
                                    ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) + 1));
                            if (entity instanceof Player _player) {
                                RainbowTextUtil.sendRainbowMessage(_player, "Mahoraga Adapted To: True Damage");
                                RainbowTextUtil.sendRainbowMessage(_player, "25% Of True Damage Reduction");
                            }
                        }
                        double defense = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource));
                        double amount1 = amount * (1 - (defense / 100));
                        ((LivingHurtEvent) event).setAmount(((float) amount1));
                    }
                }


                if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 16) {
                    MahoragaAdaptedProcedure.execute(world, damagesource, entity);
                    if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) > 50) {
                        if (event != null && event.isCancelable()) {
                            event.setCanceled(true);
                        } else if (event != null && event.hasResult()) {
                            event.setResult(Event.Result.DENY);
                        }
                    }
                }
                if (sourceentity instanceof CloneEntity || sourceentity instanceof FakeClonesEntity || sourceentity instanceof FakePurpleClonesEntity) {
                    if (sourceentity instanceof LivingEntity _entity)
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                }
                if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                    {
                        final Vec3 _center = new Vec3(x, y, z);
                        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                        for (Entity entityiterator : _entfound) {
                            if (entityiterator instanceof UiUiEntity) {
                                if ((entityiterator.getPersistentData().getString("OWNER_UUID")).equals(entity.getStringUUID())) {
                                    {
                                        Entity _ent = entityiterator;
                                        _ent.teleportTo(x, y, z);
                                        if (_ent instanceof ServerPlayer _serverPlayer)
                                            _serverPlayer.connection.teleport(x, y, z, _ent.getYRot(), _ent.getXRot());
                                    }
                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get(), 400,
                                                (entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())
                                                        ? _livEnt.getEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getAmplifier()
                                                        : 0) + 3,
                                                false, false));
                                }
                            }
                        }
                    }
                }
                if (sourceentity instanceof LivingEntity _livEnt72 && _livEnt72.hasEffect(JujutsucraftaddonModMobEffects.BERSERK.get())) {
                    if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.YUUN.get()) {
                        ((LivingHurtEvent) event).setAmount(((float) (amount * 2)));
                    }
                }
                if (entity.getPersistentData().getDouble("IsMahoraga") == 1
                        && (Objects.requireNonNull(ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem())).toString()).contains("mahoraga")) {
                    MahoragaLogicProcedure.execute(world, entity, sourceentity);
                }
                if (!(entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()))) {
                    // || ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("Thunder Blitz") && (sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 7)
                    if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.WUKONG_STAFF.get()) {
                        SummonCloneProcedure.execute(world, x, y, z, sourceentity);
                    }
                }
                if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_WUKONG_BGM)) {
                    if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) > 19) {
                        if (entity.getPersistentData().getDouble("Wukong") == 0) {
                            if (world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:wukongtheme"))), SoundSource.MASTER, 1, 1);
                                } else {
                                    _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:wukongtheme"))), SoundSource.MASTER, 1, 1, false);
                                }
                            }
                            entity.getPersistentData().putDouble("Wukong", 1);
                        }
                    }
                }
                if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_NPC_FISTS)) {
                    if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).startsWith("jujutsucraft")) {
                        NpcFistsProcedure.execute(world, entity, sourceentity);
                    }
                }
                if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:eight_handled_swrod_divergent_sila_divine_general_mahoraga")) {
                    if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("skill" + new java.text.DecimalFormat("##.##").format(new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("skill");
                        }
                    }.getValue()))) >= 100) {
                        if (!(new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble(("adapted" + new java.text.DecimalFormat("##.##").format(new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex = new CompoundTag();
                                        sourceentity.saveWithoutId(dataIndex);
                                        return dataIndex.getCompound("ForgeData").getDouble("skill");
                                    }
                                }.getValue())));
                            }
                        }.getValue() == 1)) {
                            ((LivingEntity) entity).getAttribute(Objects.requireNonNull(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))))
                                    .setBaseValue((((LivingEntity) entity).getAttribute(Objects.requireNonNull(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))).getBaseValue() + 0.5));
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble(("adapted" + new java.text.DecimalFormat("##.##").format(new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex = new CompoundTag();
                                        sourceentity.saveWithoutId(dataIndex);
                                        return dataIndex.getCompound("ForgeData").getDouble("skill");
                                    }
                                }.getValue())), 1);
                                entity.load(dataIndex);
                            }
                        }
                    }
                }


            }
        }
    }
}
