package com.jujutsu.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.procedures.SetupAnimationsProcedure;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = SetupAnimationsProcedure.JujutsucraftModAnimationMessage.class, remap = false)
public interface PacketAccessorMixin {
    @Accessor("animation")
    Component getAnimation();

    @Accessor("target")
    int getTarget();

    @Accessor("override")
    boolean isOverride();

    @Accessor("animation")
    void setAnimation(Component animation);

    @Accessor("target")
    void setTarget(int target);

    @Accessor("override")
    void setOverride(boolean override);


}
