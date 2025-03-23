package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.item.VergilItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.animatable.GeoItem;

public class VergilChestplateTickEventProcedure {
    public static void execute(Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        if (entity.getPersistentData().getDouble("Vergil") == 1) {
            if (itemstack.getItem() instanceof VergilItem armor && armor instanceof GeoItem)
                itemstack.getOrCreateTag().putString("geckoAnim", "combat");
        }
    }
}
