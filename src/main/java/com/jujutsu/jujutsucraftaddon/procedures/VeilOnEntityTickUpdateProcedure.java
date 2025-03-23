package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;

public class VeilOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        double X = 0;
        double Y = 0;
        double Z = 0;
        Direction direction = Direction.NORTH;
        String oldblock = "";
        String old_block = "";
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("VeilTemporaryTimer");
            }
        }.getValue() == 0) {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("VeilTemporarySize");
                }
            }.getValue() > 0) {
                int horizontalRadiusSphere = (int) (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("VeilTemporarySize");
                    }
                }.getValue() * 1.2) - 1;
                int verticalRadiusSphere = (int) (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("VeilTemporarySize");
                    }
                }.getValue() * 1.2) - 1;
                int yIterationsSphere = verticalRadiusSphere;
                for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
                    for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
                        for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
                            double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
                                    + (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
                            if (distanceSq <= 1.0) {
                                if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == JujutsucraftaddonModBlocks.VEIL_BLOCK.get()) {
                                    {
                                        BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
                                        BlockState _bs = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(((new Object() {
                                            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                                                BlockEntity blockEntity = world.getBlockEntity(pos);
                                                if (blockEntity != null)
                                                    return blockEntity.getPersistentData().getString(tag);
                                                return "";
                                            }
                                        }.getValue(world, BlockPos.containing(x + xi, y + i, z + zi), "oldblock"))).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState();
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
                                    {
                                        Direction _dir = direction;
                                        BlockPos _pos = BlockPos.containing(x + xi, y + i, z + zi);
                                        BlockState _bs = world.getBlockState(_pos);
                                        Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
                                        if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
                                            world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
                                        } else {
                                            _property = _bs.getBlock().getStateDefinition().getProperty("axis");
                                            if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
                                                world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
                                        }
                                    }
                                }
                                if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == JujutsucraftaddonModBlocks.CURTAIN_BLOCK.get()) {
                                    {
                                        BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
                                        BlockState _bs = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(((new Object() {
                                            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                                                BlockEntity blockEntity = world.getBlockEntity(pos);
                                                if (blockEntity != null)
                                                    return blockEntity.getPersistentData().getString(tag);
                                                return "";
                                            }
                                        }.getValue(world, BlockPos.containing(x + xi, y + i, z + zi), "oldblock"))).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState();
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
                                    {
                                        Direction _dir = direction;
                                        BlockPos _pos = BlockPos.containing(x + xi, y + i, z + zi);
                                        BlockState _bs = world.getBlockState(_pos);
                                        Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
                                        if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
                                            world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
                                        } else {
                                            _property = _bs.getBlock().getStateDefinition().getProperty("axis");
                                            if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
                                                world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
                                        }
                                    }
                                }
                                if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == Blocks.BLUE_ICE) {
                                    {
                                        BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
                                        BlockState _bs = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(((new Object() {
                                            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                                                BlockEntity blockEntity = world.getBlockEntity(pos);
                                                if (blockEntity != null)
                                                    return blockEntity.getPersistentData().getString(tag);
                                                return "";
                                            }
                                        }.getValue(world, BlockPos.containing(x + xi, y + i, z + zi), "oldblock"))).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState();
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
                                    {
                                        Direction _dir = direction;
                                        BlockPos _pos = BlockPos.containing(x + xi, y + i, z + zi);
                                        BlockState _bs = world.getBlockState(_pos);
                                        Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
                                        if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
                                            world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
                                        } else {
                                            _property = _bs.getBlock().getStateDefinition().getProperty("axis");
                                            if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
                                                world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
                                        }
                                    }
                                }
                                if (!entity.level().isClientSide())
                                    entity.discard();
                            }
                        }
                    }
                }
            }
        } else {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("VeilTemporaryTimer", (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("VeilTemporaryTimer");
                    }
                }.getValue() - 1));
                entity.load(dataIndex);
            }
        }
    }
}
