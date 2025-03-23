package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.procedures.CustomCursedTechniqueChangerRightclickedProcedureProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.SelectJinWooProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.SelectWukongProcedure;
import net.mcreator.jujutsucraft.network.SelectTechniqueButtonMessage;
import net.mcreator.jujutsucraft.world.inventory.SelectTechniqueMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Mixin(value = SelectTechniqueButtonMessage.class, priority = -10000)
public class SelectTechniqueButtonMessageMixin {
    @Inject(at = @At("TAIL"), method = "handleButtonAction", remap = false)
    private static void handleButtonAction(Player entity, int buttonID, int x, int y, int z, HashMap<String, String> textstate, CallbackInfo ci) {
        Level world = entity.level();
        HashMap guistate = SelectTechniqueMenu.guistate;
        Iterator var8 = textstate.entrySet().iterator();

        while (var8.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry) var8.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            guistate.put(key, value);
        }

        if (buttonID == 1000) {
            CustomCursedTechniqueChangerRightclickedProcedureProcedure.execute(world, x, y, z, entity);
        }

        if (buttonID == 100) {
            SelectWukongProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
        }

        if (buttonID == 101) {
            SelectJinWooProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
        }
    }
}
