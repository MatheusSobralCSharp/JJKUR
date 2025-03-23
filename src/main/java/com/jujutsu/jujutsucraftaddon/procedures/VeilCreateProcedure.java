package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.VeilEntity;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModBlocks;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;

public class VeilCreateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        String oldblock = "";
        double X = 0;
        double Y = 0;
        double Z = 0;
        Direction direction = Direction.NORTH;
        if (!(new Object() {
            public boolean getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getBoolean("VeilEnabled");
            }
        }.getValue())) {
            X = entity.getX();
            Y = entity.getY();
            Z = entity.getZ();
            int horizontalRadiusSphere = Math.round(40) - 1;
            int verticalRadiusSphere = Math.round(40) - 1;
            int yIterationsSphere = verticalRadiusSphere;
            for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
                for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
                    for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
                        double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
                                + (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
                        if (distanceSq <= 1.0) {
                            if (Math.sqrt(Math.pow(X - x + xi, 2) + Math.pow(Y - y + i, 2) + Math.pow(Z - z + zi, 2)) >= 40 - 3) {
                                oldblock = ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock()).toString();
                                direction = new Object() {
                                    public Direction getDirection(BlockState _bs) {
                                        Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                                        if (_prop instanceof DirectionProperty _dp)
                                            return _bs.getValue(_dp);
                                        _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                        return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
                                                ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
                                                : Direction.NORTH;
                                    }
                                }.getDirection((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))));
                                if (world instanceof ServerLevel _origLevel) {
                                    LevelAccessor _worldorig = world;
                                    world = _origLevel.getServer().getLevel(entity.level().dimension());
                                    if (world != null) {
                                        if (world instanceof ServerLevel _level) {
                                            {
                                                BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
                                                BlockState _bs = JujutsucraftaddonModBlocks.CURTAIN_BLOCK.get().defaultBlockState();
                                                BlockState _bso = world.getBlockState(_bp);
                                                for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                                                    Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                                    if (_property != null && _bs.getValue(_property) != null)
                                                        try {
                                                            _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                                                        } catch (Exception e) {
                                                        }
                                                }
                                                BlockEntity _be = world.getBlockEntity(_bp);
                                                CompoundTag _bnbt = null;
                                                if (_be != null) {
                                                    _bnbt = _be.saveWithFullMetadata();
                                                    _be.setRemoved();
                                                }
                                                world.setBlock(_bp, _bs, 3);
                                                if (_bnbt != null) {
                                                    _be = world.getBlockEntity(_bp);
                                                    if (_be != null) {
                                                        try {
                                                            _be.load(_bnbt);
                                                        } catch (Exception ignored) {
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    world = _worldorig;
                                }
                                if (!world.isClientSide()) {
                                    BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
                                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                                    BlockState _bs = world.getBlockState(_bp);
                                    if (_blockEntity != null)
                                        _blockEntity.getPersistentData().putString("direction", ("" + direction));
                                    if (world instanceof Level _level)
                                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                                }
                                if (!world.isClientSide()) {
                                    BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
                                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                                    BlockState _bs = world.getBlockState(_bp);
                                    if (_blockEntity != null)
                                        _blockEntity.getPersistentData().putString("oldblock", oldblock);
                                    if (world instanceof Level _level)
                                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                                }
                                if (!world.isClientSide()) {
                                    BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
                                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                                    BlockState _bs = world.getBlockState(_bp);
                                    if (_blockEntity != null)
                                        _blockEntity.getPersistentData().putString("ownerUUID", (entity.getStringUUID()));
                                    if (world instanceof Level _level)
                                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                                }
                                if (!world.isClientSide()) {
                                    BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
                                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                                    BlockState _bs = world.getBlockState(_bp);
                                    if (_blockEntity != null)
                                        _blockEntity.getPersistentData().putBoolean("pass", false);
                                    if (world instanceof Level _level)
                                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                                }
                            }
                        }
                    }
                }
            }
            if (world.getEntitiesOfClass(VeilEntity.class, AABB.ofSize(new Vec3(x, y, z), 30, 30, 30), e -> true).isEmpty()) {
                if (world instanceof ServerLevel _origLevel) {
                    LevelAccessor _worldorig = world;
                    world = _origLevel.getServer().getLevel(entity.level().dimension());
                    if (world != null) {
                        if (world instanceof ServerLevel _serverLevel) {
                            Entity entitytospawn = JujutsucraftaddonModEntities.VEIL.get().create(_serverLevel, null, null, BlockPos.containing(X, Y, Z), MobSpawnType.MOB_SUMMONED, false, false);
                            if (entitytospawn != null) {
                                entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                (entitytospawn).getPersistentData().putDouble("VeilTemporaryTimer",
                                        Math.round((((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CE") * 60) / 5000) * 20));
                                (entitytospawn).getPersistentData().putDouble("VeilTemporarySize", Math.round(40));
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    (entitytospawn).saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                                    (entitytospawn).load(dataIndex);
                                }
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putString("VeilUUID", ((entitytospawn).getStringUUID()));
                                    entity.load(dataIndex);
                                }
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putBoolean("VeilEnabled", true);
                                    entity.load(dataIndex);
                                }
                                _serverLevel.addFreshEntity(entitytospawn);
                            }
                        }
                    }
                    world = _worldorig;
                }
            }
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("Veil Creating...."), false);
            if (entity instanceof Player _player) {
                ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
                _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
            }
        }
    }
}
