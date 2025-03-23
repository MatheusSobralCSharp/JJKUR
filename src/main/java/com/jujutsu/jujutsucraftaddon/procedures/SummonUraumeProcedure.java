package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class SummonUraumeProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2) {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("Started");
                }
            }.getValue() == 0) {
                if (world instanceof ServerLevel _serverLevel) {
                    LevelAccessor _worldorig = world;
                    world = _serverLevel.getServer().getLevel(entity.level().dimension());
                    if (world != null) {
                        Entity entitytospawn = JujutsucraftaddonModEntities.URAUME.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entitytospawn != null) {
                            entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                (entitytospawn).saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                                (entitytospawn).load(dataIndex);
                            }
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                (entitytospawn).saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex = new CompoundTag();
                                        sourceentity.saveWithoutId(dataIndex);
                                        return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                    }
                                }.getValue()));
                                (entitytospawn).load(dataIndex);
                            }
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                (entitytospawn).saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex = new CompoundTag();
                                        sourceentity.saveWithoutId(dataIndex);
                                        return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                    }
                                }.getValue()));
                                (entitytospawn).load(dataIndex);
                            }
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                (entitytospawn).saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex = new CompoundTag();
                                        sourceentity.saveWithoutId(dataIndex);
                                        return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                    }
                                }.getValue()));
                                (entitytospawn).load(dataIndex);
                            }
                            _serverLevel.addFreshEntity(entitytospawn);
                        }
                    }
                    world = _worldorig;
                }
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Uraume..."), false);
                {
                    CompoundTag dataIndex = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("Started", 1);
                    sourceentity.load(dataIndex);
                }
            }
        }
    }
}
