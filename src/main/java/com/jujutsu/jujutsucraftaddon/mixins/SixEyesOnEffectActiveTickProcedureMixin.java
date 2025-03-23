package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import com.jujutsu.jujutsucraftaddon.procedures.DisplayOverlayProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.GojoMoveBlueProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.NoSixEyesGojoProcedure;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.SixEyesOnEffectActiveTickProcedure;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(value = SixEyesOnEffectActiveTickProcedure.class, priority = -10000)
public abstract class SixEyesOnEffectActiveTickProcedureMixin {

    /*
     * Give six eyes users the new conditions for allow them to use gojo new things
     *
     */

    @Inject(method = "execute", at = @At("TAIL"), remap = false)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo cir) {
        if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_GOJO_ONLY_SIX_EYES)) {
            if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SIX_EYES.get())) {
                NoSixEyesGojoProcedure.execute(world, entity);
            }
        }
        DisplayOverlayProcedure.execute(world, entity);
        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2) {
            if (entity instanceof ServerPlayer _plr20 && _plr20.level() instanceof ServerLevel
                    && _plr20.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr20.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:gojo_training_part_1")))).isDone()) {
                GojoMoveBlueProcedure.execute(world, x, y, z, entity);
            }
            if (entity instanceof ServerPlayer _plr21 && _plr21.level() instanceof ServerLevel
                    && _plr21.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr21.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:gojo_training_part_3")))).isDone()) {
            }
        }
    }
}
