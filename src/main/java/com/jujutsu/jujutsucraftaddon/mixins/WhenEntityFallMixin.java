package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.entity.ItadoriShinjukuEntity;
import com.jujutsu.jujutsucraftaddon.entity.YutaCullingGamesEntity;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import com.jujutsu.jujutsucraftaddon.procedures.ReturnEnergyColorProcedure2;
import net.mcreator.jujutsucraft.entity.ItadoriYujiShinjukuEntity;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaCullingGameEntity;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.BlockDestroyAllDirectionProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.WhenEntityFallProcedure;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = WhenEntityFallProcedure.class, priority = -10000)
public class WhenEntityFallMixin {

    /**
     * @author Satushi
     * @reason Change Some Stuff in Respawn
     */

    @Inject(at = @At("HEAD"), method = "execute(Lnet/minecraftforge/eventbus/api/Event;Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/Entity;D)V", remap = false, cancellable = true)
    private static void execute(Event event, LevelAccessor world, Entity entity, double distance, CallbackInfo ci) {
        ci.cancel();
        if (entity != null) {
            double distance_power = 0.0;
            double curse_energy_color = 0.0;
            boolean logic_fall = false;
            distance_power = distance;
            distance_power -= 8.0;
            if (entity instanceof Player) {
                logic_fall = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerMAX >= 6000.0 && entity.isShiftKeyDown();
            } else {
                logic_fall = entity instanceof OkkotsuYutaEntity || entity instanceof OkkotsuYutaCullingGameEntity || entity instanceof YutaCullingGamesEntity || entity instanceof ItadoriShinjukuEntity || entity instanceof ItadoriYujiShinjukuEntity;
            }

            LivingEntity _livingEntity15;
            if (entity instanceof LivingEntity) {
                _livingEntity15 = (LivingEntity)entity;
                if (_livingEntity15.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                    logic_fall = logic_fall || !(entity instanceof Player) || entity.isShiftKeyDown();
                }
            }

            boolean var10000;
            label226: {
                if (!logic_fall) {
                    label223: {
                        if (entity instanceof LivingEntity) {
                            _livingEntity15 = (LivingEntity)entity;
                            if (_livingEntity15.hasEffect((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                                break label223;
                            }
                        }

                        var10000 = false;
                        break label226;
                    }
                }

                var10000 = true;
            }

            if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.WUKONG_SET_BOOTS.get().asItem()) {
               var10000 = true;
            }

            logic_fall = var10000;
            if (distance_power > 0.0) {
                distance_power = Math.sqrt(distance_power + 1.0);
                curse_energy_color = ReturnEnergyColorProcedure2.execute(entity);
                if (distance_power > 4.0 || curse_energy_color > 0.0) {
                    entity.getPersistentData().putDouble("BlockRange", Math.min(distance_power, 4.0) + (double)entity.getBbWidth());
                    entity.getPersistentData().putDouble("BlockDamage", (curse_energy_color > 0.0 ? 1.0 : 0.25) * distance_power);
                    BlockDestroyAllDirectionProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
                }

                if (entity instanceof LivingEntity) {
                    _livingEntity15 = (LivingEntity)entity;
                    if (!_livingEntity15.level().isClientSide()) {
                        _livingEntity15.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 15, 6, false, false));
                    }
                }

                if (entity instanceof LivingEntity) {
                    _livingEntity15 = (LivingEntity)entity;
                    if (_livingEntity15.getAttributes().hasAttribute((Attribute) JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity15.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-10.0);
                    }
                }

                PlayAnimationProcedure.execute(world, entity);
                if (logic_fall) {
                    ServerLevel _level;
                    if (curse_energy_color == 1.0) {
                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), entity.getX(), entity.getY(), entity.getZ(), (int)Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), distance_power, 0.0, distance_power, Math.min(distance_power * 0.1, 1.5));
                        }

                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), entity.getX(), entity.getY(), entity.getZ(), (int)Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), (double)entity.getBbWidth() * 0.25, 0.0, (double)entity.getBbWidth() * 0.25, 0.5 + Math.min(distance_power * 0.25, 1.5));
                        }
                    } else if (curse_energy_color == 2.0) {
                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_ORANGE.get(), entity.getX(), entity.getY(), entity.getZ(), (int)Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), distance_power, 0.0, distance_power, Math.min(distance_power * 0.1, 1.5));
                        }

                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_ORANGE.get(), entity.getX(), entity.getY(), entity.getZ(), (int)Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), (double)entity.getBbWidth() * 0.25, 0.0, (double)entity.getBbWidth() * 0.25, 0.5 + Math.min(distance_power * 0.25, 1.5));
                        }
                    } else if (curse_energy_color == 3.0) {
                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_RED.get(), entity.getX(), entity.getY(), entity.getZ(), (int)Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), distance_power, 0.0, distance_power, Math.min(distance_power * 0.1, 1.5));
                        }

                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_RED.get(), entity.getX(), entity.getY(), entity.getZ(), (int)Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), (double)entity.getBbWidth() * 0.25, 0.0, (double)entity.getBbWidth() * 0.25, 0.5 + Math.min(distance_power * 0.25, 1.5));
                        }
                    } else if (curse_energy_color == 4.0) {
                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_GREEN.get(), entity.getX(), entity.getY(), entity.getZ(), (int)Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), distance_power, 0.0, distance_power, Math.min(distance_power * 0.1, 1.5));
                        }

                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_GREEN.get(), entity.getX(), entity.getY(), entity.getZ(), (int)Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), (double)entity.getBbWidth() * 0.25, 0.0, (double)entity.getBbWidth() * 0.25, 0.5 + Math.min(distance_power * 0.25, 1.5));
                        }
                    } else {
                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles(ParticleTypes.CLOUD, entity.getX(), entity.getY(), entity.getZ(), (int)(Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0) * 0.25), distance_power, 0.0, distance_power, Math.min(distance_power * 0.1, 1.5));
                        }

                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles(ParticleTypes.EXPLOSION, entity.getX(), entity.getY(), entity.getZ(), (int)(Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0) * 0.25), (double)entity.getBbWidth() * 0.25, 0.0, (double)entity.getBbWidth() * 0.25, 0.5 + Math.min(distance_power * 0.25, 1.5));
                        }
                    }

                    Level _level2;
                    if (curse_energy_color > 0.0 && world instanceof Level) {
                        _level2 = (Level)world;
                        if (!_level2.isClientSide()) {
                            _level2.playSound((Player)null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, (float)(distance_power * 0.5), 1.0F);
                        } else {
                            _level2.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, (float)(distance_power * 0.5), 1.0F, false);
                        }
                    }

                    if (world instanceof Level) {
                        _level2 = (Level)world;
                        if (!_level2.isClientSide()) {
                            _level2.playSound((Player)null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)distance_power, 0.5F);
                        } else {
                            _level2.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)distance_power, 0.5F, false);
                        }
                    }

                    if (world instanceof Level) {
                        _level2 = (Level)world;
                        if (!_level2.isClientSide()) {
                            _level2.playSound((Player)null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)distance_power, 0.5F);
                        } else {
                            _level2.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)distance_power, 0.5F, false);
                        }
                    }

                    if (world instanceof Level) {
                        _level2 = (Level)world;
                        if (!_level2.isClientSide()) {
                            _level2.explode((Entity)null, entity.getX(), entity.getY(), entity.getZ(), 0.0F, Level.ExplosionInteraction.NONE);
                        }
                    }
                }
            }

            if (logic_fall) {
                {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "particle jjkueffects:ring_ground");
                    }
                }
                if (event != null && event.isCancelable()) {
                    event.setCanceled(true);
                } else if (event != null && event.hasResult()) {
                    event.setResult(Event.Result.DENY);
                }
            }

            int var10001;
            label171: {
                if (entity instanceof LivingEntity) {
                    _livingEntity15 = (LivingEntity)entity;
                    if (_livingEntity15.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        label166: {
                            if (entity instanceof LivingEntity) {
                                LivingEntity _livEnt = (LivingEntity)entity;
                                if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label166;
                                }
                            }

                            var10001 = 0;
                        }

                        var10001 += 5;
                        break label171;
                    }
                }

                var10001 = 0;
            }

            if (distance < (double)var10001) {
                if (event != null && event.isCancelable()) {
                    event.setCanceled(true);
                } else if (event != null && event.hasResult()) {
                    event.setResult(Event.Result.DENY);
                }
            }

        }
    }
}
