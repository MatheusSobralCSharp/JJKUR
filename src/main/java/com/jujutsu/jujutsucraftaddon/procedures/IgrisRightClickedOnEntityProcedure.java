package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.IgrisEntity;
import com.jujutsu.jujutsucraftaddon.entity.Shadow1Entity;
import net.minecraft.world.entity.Entity;

public class IgrisRightClickedOnEntityProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof IgrisEntity) {
            ((IgrisEntity) entity).setAnimation("kneel");
        }
        if (entity instanceof Shadow1Entity) {
            ((Shadow1Entity) entity).setAnimation("kneel");
        }
    }
}
