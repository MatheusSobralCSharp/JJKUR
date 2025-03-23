package com.jujutsu.jujutsucraftaddon.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class TestItem extends Item {
    public TestItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.COMMON));
    }
}
