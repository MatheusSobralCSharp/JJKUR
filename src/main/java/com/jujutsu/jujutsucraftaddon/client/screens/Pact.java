package com.jujutsu.jujutsucraftaddon.client.screens;

import net.minecraft.network.chat.Component;

public class Pact {
    public Component getName() {
        return Component.translatable(String.format("pact.%s.%s"));
    }

    public Component getDescription() {
        return Component.translatable(String.format("pact.%s.%s.description"));
    }
}
