package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.WaveEffect;
import com.jujutsu.jujutsucraftaddon.entity.IgrisEntity;
import com.jujutsu.jujutsucraftaddon.entity.Shadow1Entity;
import com.jujutsu.jujutsucraftaddon.init.*;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
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

@Mod.EventBusSubscriber
public class CursedEnchantsAttackProcedure {
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
        if (damagesource == null || entity == null || sourceentity == null || !(world instanceof ServerLevel serverLevel))
            return;

        if (!(damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:start_animation"))))) {
            if (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).Clans.equals("Kenjaku")) {
                if (entity instanceof LivingEntity) {
                    if (((LivingEntity) entity).getHealth() <= (((LivingEntity) entity).getMaxHealth() / 5)) {
                        entity.getPersistentData().putBoolean("CursedSpirit", true);
                    }
                }
            }
            if (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).Run == 1) {
                if (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).Style == 1) {
                    ((LivingHurtEvent) event).setAmount(((float) (amount * 1.2)));
                }

                if (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).Style == 2) {
                    ((LivingHurtEvent) event).setAmount(((float) (amount * 1.15)));
                }

                if (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).Style == 5) {
                    ((LivingHurtEvent) event).setAmount(((float) (amount * 1.3)));
                }

                if (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).Style == 6) {
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.RCT_CUT.get(), 40, 1, false, false));
                }

                if (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).Style == 3) {
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.POISON, 40, 5, false, false));
                }

                if (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).Style == 4) {
                    entity.setSecondsOnFire(4);
                }
            }

            if (serverLevel.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_AIR_COMBAT)) {
                if (!(sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && _livEnt.hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get()))) {
                    if (sourceentity.onGround()) {
                        if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType())).toString().startsWith("jujutsucraft")) {
                            if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) >= 19) {
                                if (Math.random() < (1) / ((float) serverLevel.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_AIR_COMBAT_RATE))) {
                                    BlockPos center = new BlockPos((int) x, (int) y - 1, (int) z);
                                    WaveEffect.createShockwave((ServerLevel) world, center, Mth.nextInt(RandomSource.create(), 5, 20), 20);
                                }
                            }
                        } else {
                            if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) >= 19) {
                                if (Math.random() < (1) / ((float) serverLevel.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_AIR_COMBAT_RATE))) {
                                    BlockPos center = new BlockPos((int) x, (int) y - 1, (int) z);
                                    WaveEffect.createShockwave((ServerLevel) world, center, Mth.nextInt(RandomSource.create(), 5, 20), 20);
                                }
                            }
                        }
                    } else if (!sourceentity.onGround()) {
                        if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType())).toString().startsWith("jujutsucraft")) {
                            if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) >= 19) {
                                if (Math.random() < (1) / ((float) serverLevel.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_AIR_COMBAT_RATE) / 2)) {
                                    BlockPos center = new BlockPos((int) x, (int) y - 1, (int) z);
                                    WaveEffect.createShockwave((ServerLevel) world, center, Mth.nextInt(RandomSource.create(), 5, 20), 20);
                                }
                            }
                        } else {
                            if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) >= 19) {
                                if (Math.random() < (1) / ((float) serverLevel.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_AIR_COMBAT_RATE) / 2)) {
                                    BlockPos center = new BlockPos((int) x, (int) y - 1, (int) z);
                                    WaveEffect.createShockwave((ServerLevel) world, center, Mth.nextInt(RandomSource.create(), 5, 20), 20);
                                }
                            }
                        }
                    }
                }
            }


            if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 7 || (sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 29) {
                ((LivingHurtEvent) event).setAmount(((float) (amount * 1.2)));
            }

            if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Trait.equals("The Fallen One")) {
                ((LivingHurtEvent) event).setAmount(((float) (amount * 1.35)));
            }

            if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Trait.equals("The Honored One")) {
                ((LivingHurtEvent) event).setAmount(((float) (amount * 1.25)));
            }

            if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).contains("rabbit")) {
                RabbitDarkness2Procedure.execute(entity);
            }
            if (EnchantmentHelper.getItemEnchantmentLevel(JujutsucraftaddonModEnchantments.CE_STEALING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
                if (Math.random() < (1) / ((float) 30)) {
                    {
                        double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(JujutsucraftaddonModEnchantments.CE_STEALING.get()));
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.PlayerCursePower = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                    {
                        double _setval = ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower + (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(JujutsucraftaddonModEnchantments.CE_STEALING.get()));
                        sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.PlayerCursePower = _setval;
                            capability.syncPlayerVariables(sourceentity);
                        });
                    }
                }
            }
            if (entity instanceof LivingEntity _livEnt15 && _livEnt15.hasEffect(JujutsucraftaddonModMobEffects.LA_DANSA.get())) {
                if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.FATIGUE.get(), (40 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.FATIGUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.FATIGUE.get()).getDuration() : 0)), (sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.FATIGUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.FATIGUE.get()).getAmplifier() : 0) + 1, false, false));
                if (Math.random() < (1) / ((float) 10)) {
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) + 1, false, false));
                    if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, (sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WEAKNESS) ? _livEnt.getEffect(MobEffects.WEAKNESS).getAmplifier() : 0) + 1, false, false));
                }
                {
                    double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower + 1);
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerCursePower = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
                {
                    double _setval = ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 1);
                    sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerCursePower = _setval;
                        capability.syncPlayerVariables(sourceentity);
                    });
                }
            }
            if (EnchantmentHelper.getItemEnchantmentLevel(JujutsucraftaddonModEnchantments.GOD_OF_DESTRUCTION.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)) != 0) {
                if (Math.random() < ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getEnchantmentLevel(JujutsucraftaddonModEnchantments.GOD_OF_DESTRUCTION.get())) / ((float) 100)) {
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) + 1, false, true));
                    if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1200, (sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) ? _livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier() : 0) + 1, false, true));
                    if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1200, (sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WEAKNESS) ? _livEnt.getEffect(MobEffects.WEAKNESS).getAmplifier() : 0) + 1, false, true));
                    ((LivingHurtEvent) event).setAmount(((float) (amount / 2)));
                }
            }
            if (EnchantmentHelper.getItemEnchantmentLevel(JujutsucraftaddonModEnchantments.FULL_COUNTER.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)) != 0) {
                sourceentity.hurt(damagesource, (float) (amount * (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getEnchantmentLevel(JujutsucraftaddonModEnchantments.FULL_COUNTER.get())));
                ((LivingHurtEvent) event).setAmount(((float) (amount / 1.2)));
            }
            if (entity instanceof LivingEntity _livEnt45 && _livEnt45.hasEffect(JujutsucraftaddonModMobEffects.YOROZU.get())) {
                YorozuzuAttackProcedure.execute(world, x, y, z, entity);
                ((LivingHurtEvent) event).setAmount(((float) (amount / 1.2)));
            }
            if (sourceentity instanceof LivingEntity _livEnt47 && _livEnt47.hasEffect(JujutsucraftaddonModMobEffects.YOROZU.get())) {
                YorozuDefenseProcedure.execute(world, x, y, z, entity, sourceentity);
            }
            if (!((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()))) {
                if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                    SlashProcedureProcedure.execute(world, entity, sourceentity, amount);
                }
                if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_OST_PLAYER)) {
                    SongsProcedure.execute(world, x, y, z, entity, sourceentity);
                }
                if (sourceentity instanceof ServerPlayer _plr51 && _plr51.level() instanceof ServerLevel && _plr51.getAdvancements().getOrStartProgress(_plr51.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:cursed_fists"))).isDone() && (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain) {
                    if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        FistSukunaProcedure.execute(world, sourceentity);
                    } else if (!((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()))) {
                        FistsProcedureProcedure.execute(world, x, y, z, entity, sourceentity);
                    }
                }
                if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 5) {
                    if (sourceentity instanceof LivingEntity && !((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                        if (sourceentity instanceof ServerPlayer _plr56 && _plr56.level() instanceof ServerLevel && _plr56.getAdvancements().getOrStartProgress(_plr56.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:sorcerer_strongest_of_modern"))).isDone()) {
                            YutaConditionProcedure.execute(world, x, y, z, sourceentity);
                        }
                    }
                }
                if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain) {
                    WhenHitPlayerProcedure.execute(world, x, y, z, entity, sourceentity);
                    if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 10) {
                        ChosoExtensionProcedure.execute(world, entity, sourceentity);
                    } else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 15) {
                        CutRCTProcedure.execute(world, entity);
                    } else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 24) {
                        if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Uraume")) {
                            WhenHitUraumeProcedure.execute(world, entity);
                        }
                    }
                }
                if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain) {
                    if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 27) {
                        ConfiscationAndGuiltyProcedure.execute(world, entity, sourceentity);
                    } else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 26) {
                        entity.setSecondsOnFire(15);
                        (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).setDamageValue((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getDamageValue() - 1);
                    } else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 6) {
                        if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.ZONE.get())) {
                            if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel >= 3) {
                                if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 20) {
                                    SummonAllShadowsProcedure.execute(world, x, y, z, entity, sourceentity);
                                    {
                                        double _setval = 0;
                                        sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                            capability.OutputLevel = _setval;
                                            capability.syncPlayerVariables(sourceentity);
                                        });
                                    }
                                }
                            }
                        }
                    } else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == -1) {
                        TojiRCTCutProcedure.execute(world, x, y, z, entity, sourceentity);
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BLACK_FLASH_CUT.get(), 60, 1, false, false));
                        ((LivingHurtEvent) event).setAmount(((float) (amount + Mth.nextInt(RandomSource.create(), 1, 10))));
                    }
                }
                if (!((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()))) {

                }
                if (((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).contains(Component.translatable("dialoguesoul2").getString()) || ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).contains(Component.translatable("dialoguesoul1").getString())) {
                    if (sourceentity instanceof LivingEntity && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) || sourceentity instanceof LivingEntity _livEnt81 && _livEnt81.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                        if (Math.random() <= 0.5) {
                            if (world instanceof ServerLevel _level)
                                _level.sendParticles(JujutsucraftaddonModParticleTypes.HAITI.get(), x, y, z, 1, 1, 1, 1, 1);
                        } else {
                            if (world instanceof ServerLevel _level)
                                _level.sendParticles(JujutsucraftaddonModParticleTypes.KAI.get(), x, y, z, 1, 1, 1, 1, 1);
                        }
                        ((LivingHurtEvent) event).setAmount(((float) (amount * 1.2)));
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.FATIGUE.get(), (120 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.FATIGUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.FATIGUE.get()).getDuration() : 0)), (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.FATIGUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.FATIGUE.get()).getAmplifier() : 0) + 1, false, true));
                    }
                }
                if (sourceentity.getPersistentData().getDouble("Kyoka") == 5) {
                    if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.KYOKA.get()) {
                        SpawnCloneDefensiveProcedure.execute(world, x, y, z, entity);
                        {
                            Entity _ent = entity;
                            _ent.teleportTo((entity.getX()), (entity.getY()), (sourceentity.getZ() + Mth.nextInt(RandomSource.create(), -10, 10)));
                            if (_ent instanceof ServerPlayer _serverPlayer)
                                _serverPlayer.connection.teleport((entity.getX()), (entity.getY()), (sourceentity.getZ() + Mth.nextInt(RandomSource.create(), -10, 10)), _ent.getYRot(), _ent.getXRot());
                        }
                        sourceentity.hurt(damagesource, (float) amount);
                        if (event != null && event.isCancelable()) {
                            event.setCanceled(true);
                        } else if (event != null && event.hasResult()) {
                            event.setResult(Event.Result.DENY);
                        }
                    }
                }
                if (sourceentity.getPersistentData().getDouble("Jogoat") == 1) {
                    RemoveNegativeStatusProcedure.execute(world, sourceentity);
                }
                if (!sourceentity.getPersistentData().getBoolean("CursedSpirit")) {
                    ProfessionAttackProcedure.execute(world, x, y, z, damagesource, entity, sourceentity, amount);
                }
                if (entity.getPersistentData().getBoolean("CursedSpirit") && !entity.getPersistentData().getBoolean("CurseUser")) {
                    Mahito3Procedure.execute(world, damagesource, entity, sourceentity, amount);
                }
                if (!(entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get()))) {
                    if (!(entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()))) {
                        if (!(entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()))) {
                            if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 19 && (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain) {
                                if (Math.random() <= 0.1) {
                                    SpawnFakeCloneProcedure.execute(world, x, y, z, entity);
                                    {
                                        Entity _ent = entity;
                                        _ent.teleportTo(x, y, (z + Mth.nextInt(RandomSource.create(), 1, 4)));
                                        if (_ent instanceof ServerPlayer _serverPlayer)
                                            _serverPlayer.connection.teleport(x, y, (z + Mth.nextInt(RandomSource.create(), 1, 4)), _ent.getYRot(), _ent.getXRot());
                                    }
                                    if (event != null && event.isCancelable()) {
                                        event.setCanceled(true);
                                    } else if (event != null && event.hasResult()) {
                                        event.setResult(Event.Result.DENY);
                                    }
                                }
                            }
                        }
                    }
                }
                if (sourceentity instanceof IgrisEntity || sourceentity instanceof Shadow1Entity) {
                    AttackedShadowsProcedure.execute(x, y, z, sourceentity);
                }
                if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Wukong")) {
                    WukongProcedure.execute(world, entity, sourceentity);
                }
                if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Wukong")) {
                    {
                        final Vec3 _center = new Vec3(x, y, z);
                        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                        for (Entity entityiterator : _entfound) {
                            if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo_no_move")))) {
                                if (!entityiterator.level().isClientSide()) entityiterator.discard();
                                if (event != null && event.isCancelable()) {
                                    event.setCanceled(true);
                                } else if (event != null && event.hasResult()) {
                                    event.setResult(Event.Result.DENY);
                                }
                            } else if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                                if (!entityiterator.level().isClientSide()) entityiterator.discard();
                                if (event != null && event.isCancelable()) {
                                    event.setCanceled(true);
                                } else if (event != null && event.hasResult()) {
                                    event.setResult(Event.Result.DENY);
                                }
                            }
                        }
                    }
                    sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))), (float) amount);
                    ((LivingHurtEvent) event).setAmount(((float) (amount / 2)));
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 120, (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) + 1, false, false));
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get(), 60, (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get()) ? ((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get()).getAmplifier() : 0) + 1, false, false));
                }
                if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Sung")) {
                    sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))), (float) amount);
                    ((LivingHurtEvent) event).setAmount(((float) (amount / 2)));
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 4, false, false));
                }
                if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Sung")) {
                    {
                        double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower / 1.1);
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.PlayerCursePower = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 120, (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WEAKNESS) ? _livEnt.getEffect(MobEffects.WEAKNESS).getAmplifier() : 0) + 1, false, false));
                }
                if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).IsVessel) {
                    if (!(sourceentity instanceof LivingEntity && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()))) {
                        if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 24 || (sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 12 || (sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 39 || (sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 7 || (sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 38) {
                            if (Math.random() <= 0.03) {
                                {
                                    double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 5);
                                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                        capability.PlayerCursePower = _setval;
                                        capability.syncPlayerVariables(entity);
                                    });
                                }
                                {
                                    double _setval = ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower + 5);
                                    sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                        capability.PlayerCursePower = _setval;
                                        capability.syncPlayerVariables(sourceentity);
                                    });
                                }
                            }
                            if (Math.random() <= 0.4) {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 0, false, false));
                            }
                            if (Math.random() <= 0.4) {
                                ((LivingHurtEvent) event).setAmount(((float) (amount * 1.2)));
                            }
                        }
                    }
                }
                if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Rejected Zenin")) {
                    if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == -1) {
                        ((LivingHurtEvent) event).setAmount(((float) (amount * 1.3)));
                        if (Math.random() <= 0.1) {
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.FATIGUE.get(), 60, (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.FATIGUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.FATIGUE.get()).getAmplifier() : 0) + 1, false, false));
                        }
                        if (Math.random() <= 0.1) {
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WEAKNESS) ? _livEnt.getEffect(MobEffects.WEAKNESS).getAmplifier() : 0) + 1, false, false));
                        }
                    }
                }
                if (!(sourceentity instanceof LivingEntity && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()))) {
                    if (sourceentity instanceof LivingEntity && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 1) {
                            if (Math.random() < (1) / ((float) 20)) {
                                DestroyBlocksProcedure.execute(world, x, y, z, entity, sourceentity);
                            } else {
                                RightClickAirProcedure.execute(world, x, y, z, entity, sourceentity);
                            }
                        }
                        if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 1) {
                            if (Math.random() < (1) / ((float) 20)) {
                                DestroyBlocksProcedure.execute(world, x, y, z, entity, sourceentity);
                            } else {
                                RightClickAirProcedure.execute(world, x, y, z, entity, sourceentity);
                            }
                        }
                    }
                }
                if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 7) {
                    if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("Thunder God")) {
                        if (Math.random() < (1) / ((float) 25)) {
                            if (world instanceof ServerLevel _serverLevel) {
                                LevelAccessor _worldorig = world;
                                world = _serverLevel.getServer().getLevel(entity.level().dimension());
                                if (world != null) {
                                    Entity entitytospawn = EntityType.LIGHTNING_BOLT.create(_serverLevel, null, null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED, false, false);
                                    if (entitytospawn != null) {
                                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                        entity.hurt(damagesource, (float) (amount + 40));
                                        _serverLevel.addFreshEntity(entitytospawn);
                                    }
                                }
                                world = _worldorig;
                            }
                            if (world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.WEATHER, 1, 2);
                                } else {
                                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.WEATHER, 1, 2, false);
                                }
                            }
                            if (world instanceof ServerLevel _level)
                                _level.sendParticles(JujutsucraftaddonModParticleTypes.THUNDER_WHITE.get(), (entity.getX()), (entity.getY() + 1), (entity.getZ()), 1, 0, 0, 0, 1);
                        } else if (Math.random() < (1) / ((float) 10)) {
                            if (world instanceof ServerLevel _level)
                                _level.sendParticles(JujutsucraftaddonModParticleTypes.THUNDER_BLACK.get(), (entity.getX()), (entity.getY() + 1), (entity.getZ()), 1, 0, 0, 0, 1);
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.FATIGUE.get(), 40, (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.FATIGUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.FATIGUE.get()).getAmplifier() : 0), false, false));
                        }
                    }
                }
                if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 6) {
                    if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("Shikigami Defensive")) {
                        if (Math.random() < (1) / ((float) 5)) {
                            MegumiHitProcedure.execute(world, entity, sourceentity);
                        }
                    }
                }
                if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 6) {
                    if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("Shikigami Offensive")) {
                        MegumiHit3Procedure.execute(world, entity, sourceentity);
                    }
                }
                if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 2) {
                    if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("Combat Mode")) {
                        TeleportAttackProcedure.execute(entity, sourceentity);
                    }
                }
                if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 31) {
                    if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("New Shadow Style: Offensive")) {
                        if (Math.random() < (1) / ((float) 10)) {
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get(), 40, (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getAmplifier() : 0), false, false));
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 40, (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getAmplifier() : 0), false, false));
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CANCEL_CURSED_TECHNIQUE.get(), 40, (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CANCEL_CURSED_TECHNIQUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.CANCEL_CURSED_TECHNIQUE.get()).getAmplifier() : 0), false, false));
                        }
                    }
                }
                if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 39) {
                    if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:insect_armor_chestplate")) {
                        YororozuAttackNerfedProcedure.execute(world, x, y, z, entity);
                    }
                }
                if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 39) {
                    if ((ForgeRegistries.ITEMS.getKey((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:insect_armor_chestplate")) {
                        YorozuAttackProcedure.execute(world, x, y, z, sourceentity);
                    }
                }
                if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 31) {
                    if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("New Shadow Style: Defensive")) {
                        if (sourceentity instanceof LivingEntity && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                            if (Math.random() < (1) / ((float) 2)) {
                                if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()))) {
                                    if (entity instanceof LivingEntity _entity)
                                        _entity.removeEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_SIMPLE_DOMAIN.get());
                                }
                            }
                        }
                        if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
                            if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get()))) {
                                if (Math.random() < (1) / ((float) 5)) {
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.GUARD.get(), 40, (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.GUARD.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.GUARD.get()).getAmplifier() : 0) + 3, false, false));
                                }
                            }
                        }
                    }
                }
                Completed10Procedure.execute(world, entity, sourceentity);
            } else if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                if (!(sourceentity instanceof LivingEntity _livEnt191 && _livEnt191.hasEffect(JujutsucraftaddonModMobEffects.SHRINE_EFFECT.get()))) {
                    if (sourceentity.getPersistentData().getDouble("skill_domain") == 1) {
                        if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SHRINE_EFFECT.get(), -1, 1, false, false));
                    }
                }
            }
            if (sourceentity instanceof LivingEntity _livEnt194 && _livEnt194.hasEffect(JujutsucraftaddonModMobEffects.MEDITATION_STATE.get())) {
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("Spirit");
                    }
                }.getValue() == 1 || entity.getPersistentData().getDouble("Spirit") == 1) {
                    if (amount < 400) {
                        {
                            double _setval = (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).PointsSpirit + amount;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.PointsSpirit = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                        if (entity instanceof LivingEntity _entity)
                            _entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + amount));
                    } else {
                        if (entity instanceof LivingEntity _entity)
                            _entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + amount));
                        if (event != null && event.isCancelable()) {
                            event.setCanceled(true);
                        } else if (event != null && event.hasResult()) {
                            event.setResult(Event.Result.DENY);
                        }
                    }
                }
            }
            if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Rejected Zenin")) {
                if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == -1) {
                    CounterItadoriProcedure.execute(world, entity);
                }
            }
            if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Tsukumo")) {
                if (!(entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.STAR_RAGE.get()))) {
                    if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.STAR_RAGE.get())) {
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.STAR_RAGE.get(), 60, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.STAR_RAGE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.STAR_RAGE.get()).getAmplifier() : 0, false, false));
                    }
                }
            }
            if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Tsukumo") || ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Kashimo") || ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Hakari")) {
                ((LivingHurtEvent) event).setAmount(((float) (amount * 1.2)));
            }
            if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Moveset == 3) {
                DismantleM1sCutProcedure.execute(world, entity, sourceentity);
            }
            if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Perfect Vessel")) {
                if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 7 || (sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 37 || (sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 12 || (sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 21 || (sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 28 || (sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 38 || (sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 23) {
                    ((LivingHurtEvent) event).setAmount(((float) (amount * 1.2)));
                }
            }
            if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Tengen")) {
                entity.setInvulnerable(true);
                if (event != null && event.isCancelable()) {
                    event.setCanceled(true);
                } else if (event != null && event.hasResult()) {
                    event.setResult(Event.Result.DENY);
                }
            }
            if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Tengen")) {
                if (event != null && event.isCancelable()) {
                    event.setCanceled(true);
                } else if (event != null && event.hasResult()) {
                    event.setResult(Event.Result.DENY);
                }
            }
        }
    }
}
