package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;

public class VeilEntityDiesProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        int horizontalRadiusSphere = (int) (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TemporaryVeilsSize");
            }
        }.getValue() * 1.2) - 1;
        int verticalRadiusSphere = (int) (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TemporaryVeilsSize");
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
                        }
                    }
                }
            }
        }
    }
}
