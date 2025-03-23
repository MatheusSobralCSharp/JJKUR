package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.procedures.CustomCursedTechniqueChangerRightclickedProcedureProcedure;
import net.mcreator.jujutsucraft.network.SelectTechniqueButtonMessage;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;

@Mixin(value = SelectTechniqueButtonMessage.class, priority = -10000)
public abstract class SelectedProcedureMixin {

    /**
     * @author Satushi
     * @reason Handle Actions of the Selection Techniques
     */


    @Inject(
            method = {"handleButtonAction"},
            at = {@At("RETURN")},
            remap = false
    )
    private static void onHandleButtonAction(Player entity, int buttonID, int x, int y, int z, HashMap<String, String> textstate, CallbackInfo ci) {
        Level world = entity.level();
        if (buttonID == 1000) {
            CustomCursedTechniqueChangerRightclickedProcedureProcedure.execute(world, x, y, z, entity);
        }

    }
}


