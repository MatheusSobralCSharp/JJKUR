package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import com.jujutsu.jujutsucraftaddon.procedures.RctOutputProcedure;
import net.mcreator.jujutsucraft.procedures.ReverseCursedTechniqueOnEffectActiveTickProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(
        value = ReverseCursedTechniqueOnEffectActiveTickProcedure.class,
        remap = false
)
public abstract class RCTActiveMixin {
    public RCTActiveMixin() {
    }

    /**
     * @author Satushi
     * @reason Changing the value of RCT Fatigue Rate with a gamerule lines: 37 to 42. Add a procedure for play, lines: 47 to 51
     */

    @ModifyConstant(
            method = {"execute"},
            constant = {@Constant(
                    intValue = 20
            )},
            remap = false
    )
    private static int injection0(int value, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (world != null) {
            int valueNew = world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_FATIGUE_RATE);
            if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Profession).equals("Healer")) {
                return valueNew / 2;
            }
            return valueNew;
        } else {
            return value;
        }
    }


    @Inject(method = "execute", at = @At("HEAD"), remap = false)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        if (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).RCTOutputActive) {
            RctOutputProcedure.execute(world, entity);
        }
    }
}
