package com.jujutsu.jujutsucraftaddon.procedures;

public class LockOnCapability {
    private int targetEntityId = -1; // Stores the locked target

    public int getTargetEntityId() {
        return targetEntityId;
    }

    public void setTargetEntityId(int entityId) {
        this.targetEntityId = entityId;
    }
}