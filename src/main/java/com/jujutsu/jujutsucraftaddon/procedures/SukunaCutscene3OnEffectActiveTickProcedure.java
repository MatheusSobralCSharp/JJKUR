package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.ErroEntity;
import net.minecraft.world.entity.Entity;

public class SukunaCutscene3OnEffectActiveTickProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof ErroEntity) {
            ((ErroEntity) entity).setAnimation("animation.sukuna.mode2");
        }
    }
}
