package com.jujutsu.jujutsucraftaddon.procedures;


import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EffectsAction {
    public static void execute(Player entity, int page) {
        Level world = entity.level();
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();

        // Check if the chunk is loaded
        if (!world.hasChunkAt(entity.blockPosition()))
            return;
        if (page >= 0) {
            switch (page) {
                case 0 -> entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 2, false, false));
                case 1 -> BlackFlashProcedure.execute(world, x, y, z, entity);
                case 2 -> NyoiSkillNerfed.execute(world, entity);
                case 3 -> CutProjectilesAround.execute(world, x, y, z, entity);
                case 4 -> DismantleCutNerfed.execute(world, entity);
                case 5 -> OverHeadAttack.execute(world, entity);
                case 6 -> FlyingKickAttack.execute(world, entity);
                case 7 -> SwordUltimate.execute(world, x, y, z, entity);
                case 8 -> M1sProcedure.execute(world, entity);
                case 9 -> BarrageProcedure.execute(world, entity);
            }
        }

    }
}