package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.procedures.CursedTechniqueWukong;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.*;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = CursedTechniqueOnPotionActiveTick3Procedure.class, priority = -10000)
public class CursedTechniqueOnPotionActiveTick3ProcedureMixin {
    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();
        if (entity != null) {
            double skill = 0.0;
            skill = (double)Math.round(entity.getPersistentData().getDouble("skill") - 2000.0);
            LivingEntity _entity;
            if (skill >= 8000.0) {
                CursedTechniqueWukong.execute(world, x, y, z, entity);
            } else if (skill >= 2000.0) {
                if (skill >= 2300.0) {
                    CursedTechniqueRozetsuProcedure.execute(world, x, y, z, entity);
                } else if (skill >= 2200.0) {
                    CursedTechniqueCombatProcedure.execute(world, x, y, z, entity);
                } else if (skill >= 2100.0) {
                    CursedTechniqueKaoriProcedure.execute(world, x, y, z, entity);
                } else if (skill >= 2000.0) {
                    CursedTechniqueInoProcedure.execute(world, x, y, z, entity);
                } else if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity)entity;
                    _entity.removeEffect((MobEffect) JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                }
            } else if (skill >= 1500.0) {
                if (skill >= 1900.0) {
                    CursedTechniqueYorozuProcedure.execute(world, x, y, z, entity);
                } else if (skill >= 1800.0) {
                    CursedTechniqueTakakoUroProcedure.execute(world, x, y, z, entity);
                } else if (skill >= 1700.0) {
                    CursedTechniqueDhruvProcedure.execute(world, x, y, z, entity);
                } else if (skill >= 1600.0) {
                    CursedTechniqueNishimiyaProcedure.execute(world, x, y, z, entity);
                } else if (skill >= 1500.0) {
                    CursedTechniqueJunpeProcedure.execute(world, x, y, z, entity);
                } else if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity)entity;
                    _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                }
            } else if (skill >= 1000.0) {
                if (skill >= 1400.0) {
                    CursedTechniqueKugisakiProcedure.execute(world, x, y, z, entity);
                } else if (skill >= 1300.0) {
                    CursedTechniqueYagaProcedure.execute(world, x, y, z, entity);
                } else if (skill >= 1200.0) {
                    CursedTechniqueChojuroProcedure.execute(world, x, y, z, entity);
                } else if (skill >= 1100.0) {
                    CursedTechniqueKusakabeProcedure.execute(world, x, y, z, entity);
                } else if (skill >= 1000.0) {
                    CursedTechniqueMiguelProcedure.execute(world, x, y, z, entity);
                } else if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity)entity;
                    _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                }
            } else if (skill >= 500.0) {
                if (skill >= 900.0) {
                    CursedTechniqueHakariProcedure.execute(world, x, y, z, entity);
                } else if (skill >= 800.0) {
                    CursedTechniqueAngelProcedure.execute(world, x, y, z, entity);
                } else if (skill >= 700.0) {
                    CursedTechniqueHigurumaProcedure.execute(world, x, y, z, entity);
                } else if (skill >= 600.0) {
                    CursedTechniqueOgiProcedure.execute(world, x, y, z, entity);
                } else if (skill >= 500.0) {
                    CursedTechniqueSmallpoxDeityProcedure.execute(world, x, y, z, entity);
                } else if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity)entity;
                    _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                }
            } else if (skill >= 400.0) {
                CursedTechniqueUraumeProcedure.execute(world, x, y, z, entity);
            } else if (skill >= 300.0) {
                CursedTechniqueKurourushiProcedure.execute(world, x, y, z, entity);
            } else if (skill >= 200.0) {
                CursedTechniqueJjnichiProcedure.execute(world, x, y, z, entity);
            } else if (skill >= 100.0) {
                CursedTechniqueItadoriProcedure.execute(world, x, y, z, entity);
            } else if (skill >= 0.0) {
                CursedTechniqueTodoProcedure.execute(world, x, y, z, entity);
            } else if (entity instanceof LivingEntity) {
                _entity = (LivingEntity)entity;
                _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }

        }
    }
}
