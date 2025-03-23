
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.jujutsu.jujutsucraftaddon.init;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.block.entity.CurtainBlockBlockEntity;
import com.jujutsu.jujutsucraftaddon.block.entity.SnowDomainBlockEntity;
import com.jujutsu.jujutsucraftaddon.block.entity.VeilBlockBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JujutsucraftaddonModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, JujutsucraftaddonMod.MODID);
    public static final RegistryObject<BlockEntityType<?>> VEIL_BLOCK = register("veil_block", JujutsucraftaddonModBlocks.VEIL_BLOCK, VeilBlockBlockEntity::new);
    public static final RegistryObject<BlockEntityType<?>> SNOW_DOMAIN = register("snow_domain", JujutsucraftaddonModBlocks.SNOW_DOMAIN, SnowDomainBlockEntity::new);
    public static final RegistryObject<BlockEntityType<?>> CURTAIN_BLOCK = register("curtain_block", JujutsucraftaddonModBlocks.CURTAIN_BLOCK, CurtainBlockBlockEntity::new);

    // Start of user code block custom block entities
    // End of user code block custom block entities
    private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
        return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
    }
}
