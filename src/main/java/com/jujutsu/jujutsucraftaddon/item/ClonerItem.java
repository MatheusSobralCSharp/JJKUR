package com.jujutsu.jujutsucraftaddon.item;

import com.jujutsu.jujutsucraftaddon.procedures.SpawnCloneProcedure;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class ClonerItem extends Item {
    public ClonerItem() {
        super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        SpawnCloneProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
        return ar;
    }
}
