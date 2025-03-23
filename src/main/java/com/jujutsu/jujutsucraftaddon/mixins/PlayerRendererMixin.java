package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = PlayerRenderer.class, priority = -10000)
public abstract class PlayerRendererMixin {

    /**
     * @author Satushi
     * @reason Changes Name Tag for Kenjaku Players
     */


    @ModifyVariable(
            method = "renderNameTag(Lnet/minecraft/client/player/AbstractClientPlayer;Lnet/minecraft/network/chat/Component;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V",
            at = @At("HEAD"),
            argsOnly = true,
            ordinal = 0
    )
    private Component modifyNameTag(Component component, AbstractClientPlayer abstractClientPlayer) {
        final Component[] modifiedComponent = {component};

        if (abstractClientPlayer.isAlive()) {
            abstractClientPlayer.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                if ("Kenjaku".equals(capability.Clans)) {
                    String tag = capability.tag1;
                    if (tag != null) {
                        String skinName = switch (tag) {
                            case "One" -> capability.SkinName1;
                            case "Two" -> capability.SkinName2;
                            case "Three" -> capability.SkinName3;
                            default -> null;
                        };
                        if (skinName != null && !skinName.isEmpty()) {
                            modifiedComponent[0] = Component.literal(skinName);
                        }
                    }
                }
            });

            // If capability is missing, log a warning
            if (!abstractClientPlayer.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).isPresent()) {
                JujutsucraftaddonMod.LOGGER.warn("PLAYER_VARIABLES_CAPABILITY is not present for player: " + abstractClientPlayer.getName().getString());
            }
        }

        return modifiedComponent[0];
    }
}
