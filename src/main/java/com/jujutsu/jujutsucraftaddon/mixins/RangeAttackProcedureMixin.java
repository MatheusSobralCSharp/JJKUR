package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.entity.ItadoriShinjukuEntity;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import com.jujutsu.jujutsucraftaddon.procedures.BFMasteryProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.BlackFlashNerfedProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.BlackFlashedProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.ItadoriClan2Procedure;
import net.mcreator.jujutsucraft.entity.*;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.RangeAttackProcedure;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(value = RangeAttackProcedure.class, priority = -10000)
public abstract class RangeAttackProcedureMixin {

    /**
     * @author Satushi
     * @reason Change Black Flash Chances and Logic
     */

    @ModifyConstant(
            method = "execute",
            constant = @Constant(doubleValue = 0.998),
            remap = false
    )
    private static double injection(double constant, LevelAccessor world, double x, double y, double z, Entity entity) {
        boolean gojosatoru = false;
        boolean sukuna = false;
        if (entity instanceof ItadoriShinjukuEntity || entity instanceof ItadoriYujiShinjukuEntity) {
            if (((LivingEntity) entity).getHealth() <= ((LivingEntity) entity).getMaxHealth() / 4) {
                if (Math.random() < (1) / ((float) 20)) {
                    return 0.001;
                }
            } else if (((LivingEntity) entity).getHealth() <= ((LivingEntity) entity).getMaxHealth() / 3) {
                if (Math.random() < (1) / ((float) 25)) {
                    return 0.001;
                }
            } else {
                if (Math.random() < (1) / ((float) 100)) {
                    return 0.001;
                }
            }
        }
        Mob _mobEnt;
        LivingEntity var47;
        if (entity instanceof Mob) {
            _mobEnt = (Mob) entity;
            var47 = _mobEnt.getTarget();
        } else {
            var47 = null;
        }

        if (var47 != null) {
            if (var47 instanceof GojoSatoruEntity || var47 instanceof GojoSatoruSchoolDaysEntity || var47.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique == 2) {
                gojosatoru = true;
            }
        }

        if (var47 != null) {
            if (var47 instanceof SukunaFushiguroEntity || var47.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                sukuna = true;
            }
        }

        if (entity instanceof SukunaPerfectEntity || entity instanceof GojoSatoruEntity || entity instanceof OkkotsuYutaCullingGameEntity || entity instanceof NanamiKentoEntity || entity instanceof GojoSatoruSchoolDaysEntity || entity instanceof SukunaEntity || entity instanceof SukunaFushiguroEntity) {
            if (((LivingEntity) entity).getHealth() <= ((LivingEntity) entity).getMaxHealth() / 2) {
                if (entity instanceof SukunaPerfectEntity) {
                    if (Math.random() < (1) / ((float) 20)) {
                        return 0.001;
                    }
                } else if (entity instanceof SukunaFushiguroEntity _liv && _liv.getEntityData().get(SukunaFushiguroEntity.DATA_perfect_mode)) {
                    if (Math.random() < (1) / ((float) 20)) {
                        return 0.001;
                    }
                } else if (entity instanceof SukunaFushiguroEntity) {
                    if (var47 != null) {
                        if (gojosatoru) {
                            return constant;
                        } else if (Math.random() < (1) / ((float) 50)) {
                            return 0.001;
                        }
                    }
                } else if (entity instanceof GojoSatoruEntity) {
                    if (sukuna) {
                        return constant;
                    } else {
                        if (Math.random() < (1) / ((float) 100)) {
                            return 0.001;
                        }
                    }
                } else if (entity instanceof OkkotsuYutaCullingGameEntity) {
                    if (Math.random() < (1) / ((float) 300)) {
                        return 0.001;
                    }
                } else {
                    if (Math.random() < (1) / ((float) 50)) {
                        return 0.001;
                    }
                }
            } else if (entity instanceof GojoSatoruEntity) {
                if (var47 != null) {
                    if (sukuna) {
                        return constant;
                    } else if (Math.random() < (1) / ((float) 200)) {
                       return 0.001;
                    }
                }
            } else if (entity instanceof SukunaFushiguroEntity) {
                if (var47 != null) {
                    if (gojosatoru) {
                        return constant;
                    } else if (Math.random() < (1) / ((float) 150)) {
                        return 0.001;
                    }
                }
            }  else if (entity instanceof NanamiKentoEntity) {
                if (Math.random() < (1) / ((float) 100)) {
                    return 0.001;
                }
            } else if (entity instanceof OkkotsuYutaCullingGameEntity) {
                if (Math.random() < (1) / ((float) 400)) {
                    return 0.001;
                }
            } else if (Math.random() < (1) / ((float) 150)) {
                return 0.001;
            }

        }

        if (!Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString().startsWith("jujutsucraft")) {
            if (Math.random() < ((float) (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).BFChance)) / ((float) 1000)) {
                if ((world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_BLACK_FLASH_REWORKED))) {
                    if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(JujutsucraftaddonModMobEffects.FATIGUE_BLACK_FLASH.get()))) {
                        if (entity.getPersistentData().getDouble("cnt_bf") >= 50.0) {
                            return 0.001;
                        }
                    }
                } else {
                    if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(JujutsucraftaddonModMobEffects.FATIGUE_BLACK_FLASH.get()))) {
                        return 0.001;
                    }
                }
            }
        }

        return constant;
    }


    @Inject(method = "execute",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/Entity;getCapability(Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;",
                    ordinal = 4),
            remap = false)
    private static void injectProcedure(LevelAccessor world, double x, double y, double z, Entity
            entity, CallbackInfo ci) {
        if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString().startsWith("jujutsucraft")) {
            BlackFlashedProcedure.execute(world, x, y, z, entity);
            return;
        }

        if (!(Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString()).startsWith("jujutsucraft")) {
            if ((world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_BLACK_FLASH_REWORKED))) {
                if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(JujutsucraftaddonModMobEffects.FATIGUE_BLACK_FLASH.get()))) {
                    if (entity.getPersistentData().getDouble("cnt_bf") >= 50.0) {
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
                            BlackFlashedProcedure.execute(world, x, y, z, entity);
                            BFMasteryProcedure.execute(world, entity);
                            entity.getPersistentData().putDouble("cnt_bf", 0);
                            ItadoriClan2Procedure.execute(world, entity);
                            BlackFlashNerfedProcedure.execute(world, entity);
                            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).ImpactFramesVariable == 0) {
                                if (!(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(JujutsucraftaddonModMobEffects.OUT_LINER.get()))) {
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.OUT_LINER.get(), Mth.nextInt(RandomSource.create(), 10, 15), 1, false, false));

                                }
                            }
                        }
                    }
                }
            } else {
                if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(JujutsucraftaddonModMobEffects.FATIGUE_BLACK_FLASH.get()))) {
                    if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
                        BlackFlashedProcedure.execute(world, x, y, z, entity);
                        BFMasteryProcedure.execute(world, entity);
                        ItadoriClan2Procedure.execute(world, entity);
                        BlackFlashNerfedProcedure.execute(world, entity);
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).ImpactFramesVariable == 0) {
                            if (!(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(JujutsucraftaddonModMobEffects.OUT_LINER.get()))) {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.OUT_LINER.get(), Mth.nextInt(RandomSource.create(), 10, 15), 1, false, false));

                            }
                        }
                    }
                }
                entity.getPersistentData().putDouble("cnt_bf", 0);
            }
        }
    }
}
