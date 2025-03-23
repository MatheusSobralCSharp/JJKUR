package com.jujutsu.jujutsucraftaddon.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class TestItem2Item extends Item {
    public TestItem2Item() {
        super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}
