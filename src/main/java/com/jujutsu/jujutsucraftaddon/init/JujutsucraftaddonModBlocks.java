
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.jujutsu.jujutsucraftaddon.init;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.block.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JujutsucraftaddonModBlocks {
    public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, JujutsucraftaddonMod.MODID);
    public static final RegistryObject<Block> NO_DOMAIN = REGISTRY.register("no_domain", () -> new NoDomainBlock());
    public static final RegistryObject<Block> VEIL_BLOCK = REGISTRY.register("veil_block", () -> new VeilBlockBlock());
    public static final RegistryObject<Block> YOKU = REGISTRY.register("yoku", () -> new YokuBlock());
    public static final RegistryObject<Block> SNOW_DOMAIN = REGISTRY.register("snow_domain", () -> new SnowDomainBlock());
    public static final RegistryObject<Block> CURTAIN_BLOCK = REGISTRY.register("curtain_block", () -> new CurtainBlockBlock());
    // Start of user code block custom blocks
    // End of user code block custom blocks
}
