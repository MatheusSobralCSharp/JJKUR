package com.jujutsu.jujutsucraftaddon.fluid;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModBlocks;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModFluidTypes;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModFluids;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public abstract class YokuFluid extends ForgeFlowingFluid {
    public static final Properties PROPERTIES = new Properties(() -> JujutsucraftaddonModFluidTypes.YOKU_TYPE.get(), () -> JujutsucraftaddonModFluids.YOKU.get(), () -> JujutsucraftaddonModFluids.FLOWING_YOKU.get())
            .explosionResistance(100f).bucket(() -> JujutsucraftaddonModItems.YOKU_BUCKET.get()).block(() -> (LiquidBlock) JujutsucraftaddonModBlocks.YOKU.get());

    private YokuFluid() {
        super(PROPERTIES);
    }

    public static class Source extends YokuFluid {
        public int getAmount(FluidState state) {
            return 8;
        }

        public boolean isSource(FluidState state) {
            return true;
        }
    }

    public static class Flowing extends YokuFluid {
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }

        public boolean isSource(FluidState state) {
            return false;
        }
    }
}
