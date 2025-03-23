package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class MobTamerLivingEntityIsHitWithItemProcedure {
    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if (!(entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt && _tamIsTamedBy.isOwnedBy(_livEnt))) {
            CompoundTag dataIndex1 = new CompoundTag();
            entity.saveWithoutId(dataIndex1);
            dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
            entity.load(dataIndex1);
            CompoundTag dataIndex3 = new CompoundTag();
            entity.saveWithoutId(dataIndex3);
            dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                public double getValue() {
                    CompoundTag dataIndex2 = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex2);
                    return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
                }
            }.getValue()));
            entity.load(dataIndex3);
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal(("Mob Tamed: " + entity.getDisplayName().getString())), false);
        }
    }
}
