package com.jujutsu.jujutsucraftaddon.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class ItemTest2Item extends Item {
    public ItemTest2Item() {
        super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}
