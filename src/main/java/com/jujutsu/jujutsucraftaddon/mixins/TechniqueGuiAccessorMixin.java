package com.jujutsu.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.client.gui.SelectTechniqueScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.HashMap;

@Mixin(SelectTechniqueScreen.class)
public interface TechniqueGuiAccessorMixin {
    @Accessor(
            value = "world",
            remap = false
    )
    Level getWorld();

    @Accessor(
            value = "x",
            remap = false
    )
    int getX();

    @Accessor(
            value = "y",
            remap = false
    )
    int getY();

    @Accessor(
            value = "z",
            remap = false
    )
    int getZ();

    @Accessor(
            value = "entity",
            remap = false
    )
    Player getEntity();

    @Accessor(
            value = "guistate",
            remap = false
    )
    HashMap<String, Object> getGuistate();

    @Accessor(
            value = "textstate",
            remap = false
    )
    HashMap<String, String> textstate();


    @Accessor(
            value = "cursed_spirit",
            remap = false
    )
    static Checkbox getCursedSpirit() {
        throw new UnsupportedOperationException();
    }

}
