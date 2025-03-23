package com.jujutsu.jujutsucraftaddon.block;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModFluids;
import com.jujutsu.jujutsucraftaddon.procedures.YokuMobplayerCollidesBlockProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class YokuBlock extends LiquidBlock {
    public YokuBlock() {
        super(() -> JujutsucraftaddonModFluids.YOKU.get(), Properties.of().mapColor(MapColor.WATER).strength(100f).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).noCollission().noLootTable().liquid()
                .pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
    }

    @Override
    public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
        super.entityInside(blockstate, world, pos, entity);
        YokuMobplayerCollidesBlockProcedure.execute(world, entity);
    }
}
