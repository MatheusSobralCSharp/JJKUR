package com.jujutsu.jujutsucraftaddon.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class AngelItem extends Item {
    public AngelItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.COMMON));
    }
}
