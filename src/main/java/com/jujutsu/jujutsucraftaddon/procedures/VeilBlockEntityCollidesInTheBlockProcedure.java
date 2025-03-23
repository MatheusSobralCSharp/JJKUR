package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.VeilEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;

public class VeilBlockEntityCollidesInTheBlockProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if ((new Object() {
            public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity != null)
                    return blockEntity.getPersistentData().getBoolean(tag);
                return false;
            }
        }.getValue(world, BlockPos.containing(x, y, z), "pass"))) {
            {
                Entity _ent = entity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                            _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp ^ ^ ^1");
                }
            }
        } else if (!(new Object() {
            public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity != null)
                    return blockEntity.getPersistentData().getBoolean(tag);
                return false;
            }
        }.getValue(world, BlockPos.containing(x, y, z), "pass"))) {
            {
                final Vec3 _center = new Vec3(x, y, z);
                List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10000000 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                for (Entity entityiterator : _entfound) {
                    if (entityiterator instanceof VeilEntity) {
                        if ((new Object() {
                            public String getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getString("VeilUUID");
                            }
                        }.getValue()).equals(entityiterator.getStringUUID())) {
                            {
                                Entity _ent = entity;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                            4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp ^ ^ ^1");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
