package com.jujutsu.jujutsucraftaddon.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class KokusenItem extends Item {
    public KokusenItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.COMMON));
    }
}
