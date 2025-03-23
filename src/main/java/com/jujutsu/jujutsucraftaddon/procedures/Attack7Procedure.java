package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.ErroEntity;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.living.LivingChangeTargetEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class Attack7Procedure {
    @SubscribeEvent
    public static void onEntitySetsAttackTarget(LivingChangeTargetEvent event) {
        execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getOriginalTarget(), event.getEntity());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        execute(null, world, x, y, z, entity, sourceentity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if (entity.isAlive()) {
            if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_MOB_OSTS)) {
                Attack8Procedure.execute(world, x, y, z, entity, sourceentity);
            }
            if (sourceentity.getPersistentData().getDouble("NoAttac1") == 1) {
                sourceentity.getPersistentData().putDouble("cnt_target", 0);
            }
            TargetProcedure.execute(world, x, y, z, entity, sourceentity);
        }

        if (sourceentity instanceof ErroEntity) {
            if (!((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                if (sourceentity.getPersistentData().getDouble("skill") != 107) {
                    if (Math.random() < (1) / ((float) 2)) {
                        SukunaAINewProcedure.execute(world, x, y, z, sourceentity);
                    }
                }
            }
        }
    }
}
