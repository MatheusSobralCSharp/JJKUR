package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public class PlayerRendererNameTagMixin {

    @Inject(
            method = "getDisplayName",
            at = @At("RETURN"),
            cancellable = true
    )
    private void onGetName(CallbackInfoReturnable<Component> cir) {
        Player player = (Player) (Object) this;

        player.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            if ("Kenjaku".equals(capability.Clans)) {
                String tag = capability.tag1;
                if (tag != null) {
                    switch (tag) {
                        case "One":
                            if (capability.SkinName1 != null && !capability.SkinName1.isEmpty()) {
                                cir.setReturnValue(Component.literal(capability.SkinName1));
                            }
                            break;
                        case "Two":
                            if (capability.SkinName2 != null && !capability.SkinName2.isEmpty()) {
                                cir.setReturnValue(Component.literal(capability.SkinName2));
                            }
                            break;
                        case "Three":
                            if (capability.SkinName3 != null && !capability.SkinName3.isEmpty()) {
                                cir.setReturnValue(Component.literal(capability.SkinName3));
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        });
    }
}
