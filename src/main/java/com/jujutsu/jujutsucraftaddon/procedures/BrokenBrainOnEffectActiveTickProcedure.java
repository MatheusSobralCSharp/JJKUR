package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;

public class BrokenBrainOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null || world == null)
            return;
        if (!(new Object() {
            public boolean checkGamemode(Entity _ent) {
                if (_ent instanceof ServerPlayer _serverPlayer) {
                    return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
                    return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
                }
                return false;
            }
        }.checkGamemode(entity))) {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("brokenBrain");
                }
            }.getValue() != 2) {
                {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("brokenBrain", 2);
                    entity.load(dataIndex);
                }
            }
        }
    }
}
