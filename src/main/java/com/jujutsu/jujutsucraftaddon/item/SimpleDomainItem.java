package com.jujutsu.jujutsucraftaddon.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class SimpleDomainItem extends Item {
    public SimpleDomainItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.COMMON));
    }
}
