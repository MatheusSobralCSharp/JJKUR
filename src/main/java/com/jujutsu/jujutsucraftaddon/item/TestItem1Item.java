package com.jujutsu.jujutsucraftaddon.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class TestItem1Item extends Item {
    public TestItem1Item() {
        super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}
