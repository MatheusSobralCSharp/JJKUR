package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.VeilEntity;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ProcedureUraumeProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        boolean Pass = false;
        String oldblock = "";
        double X = 0;
        double Y = 0;
        double Z = 0;
        Direction direction = Direction.NORTH;
        if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.WATER || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.WATER) {
            {
                BlockPos _bp = BlockPos.containing(x, y - 1, z);
                BlockState _bs = Blocks.ICE.defaultBlockState();
                BlockState _bso = world.getBlockState(_bp);
                for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                    Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                    if (_property != null && _bs.getValue(_property) != null)
                        try {
                            _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                        } catch (Exception e) {
                        }
                }
                world.setBlock(_bp, _bs, 3);
            }
        }
        if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
                .equals(Component.translatable("jujutsu.technique.attack1").getString())) {
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.PlayerSelectCurseTechniqueName = "Ice Shield";
                capability.syncPlayerVariables(entity);
            });
        }
        if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Frost Calm")
                || ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Frozen")) {
            if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("cnt6");
                    }
                }.getValue() < 75) {
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("cnt6", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("cnt6");
                            }
                        }.getValue() + 1));
                        entity.load(dataIndex);
                    }
                }
            }
        }
        if (entity.isShiftKeyDown()) {
            if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
                    .equals(Component.translatable("jujutsu.technique.attack2").getString())) {
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.PlayerSelectCurseTechniqueName = "Ice Age";
                    capability.syncPlayerVariables(entity);
                });
            }
            if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Ice Age")) {
                if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                    {
                        final Vec3 _center = new Vec3(x, y, z);
                        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                        for (Entity entityiterator : _entfound) {
                            if (!((entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 24)) {
                                {
                                    Entity _ent = entity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                        _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                "execute as @s unless predicate jujutsucraftaddon:effects/orca/sixeyes run jjc_cursepower -100 @s");
                                    }
                                }
                                {
                                    Entity _ent = entity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                        _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                "execute as @s run effect give @s jujutsucraft:cooldown_time_combat 3 0 true");
                                    }
                                }
                                if (world instanceof Level _level) {
                                    if (!_level.isClientSide()) {
                                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.hurt_freeze")), SoundSource.NEUTRAL, 1, 1);
                                    } else {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.hurt_freeze")), SoundSource.NEUTRAL, 1, 1, false);
                                    }
                                }
                                for (int index0 = 0; index0 < 15; index0++) {
                                    {
                                        BlockPos _bp = BlockPos.containing(entityiterator.getX() + Mth.nextInt(RandomSource.create(), -5, 5), entityiterator.getY() + Mth.nextInt(RandomSource.create(), 0, 2),
                                                entityiterator.getZ() + Mth.nextInt(RandomSource.create(), -5, 5));
                                        BlockState _bs = Blocks.ICE.defaultBlockState();
                                        BlockState _bso = world.getBlockState(_bp);
                                        for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                                            Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                                            if (_property != null && _bs.getValue(_property) != null)
                                                try {
                                                    _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                                                } catch (Exception e) {
                                                }
                                        }
                                        world.setBlock(_bp, _bs, 3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if (!entity.isShiftKeyDown()) {
            if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Ice Shield")) {
                    X = entity.getX();
                    Y = entity.getY();
                    Z = entity.getZ();
                    int horizontalRadiusSphere = Math.round(8) - 1;
                    int verticalRadiusSphere = Math.round(8) - 1;
                    int yIterationsSphere = verticalRadiusSphere;
                    for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
                        for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
                            for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
                                double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
                                        + (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
                                if (distanceSq <= 1.0) {
                                    {
                                        final Vec3 _center = new Vec3(x, y, z);
                                        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                                                .toList();
                                        for (Entity entityiterator : _entfound) {
                                            if (!(entityiterator == entity)) {
                                                if (world instanceof ServerLevel _level)
                                                    _level.sendParticles(JujutsucraftaddonModParticleTypes.ICE.get(), x, y, z, 1, 3, 3, 3, 1);
                                            }
                                        }
                                    }
                                    {
                                        Entity _ent = entity;
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "execute as @s run effect clear @s jujutsucraft:cursed_technique");
                                        }
                                    }
                                    {
                                        Entity _ent = entity;
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "execute as @s run jjc_cursepower -1 @s");
                                        }
                                    }
                                    {
                                        Entity _ent = entity;
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "execute as @s run effect give @s jujutsucraft:cooldown_time_combat 10 0 true");
                                        }
                                    }
                                    if (world.getEntitiesOfClass(VeilEntity.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty()) {
                                        if (Math.sqrt(Math.pow(X - x + xi, 2) + Math.pow(Y - y + i, 2) + Math.pow(Z - z + zi, 2)) >= 3) {
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
                                            {
                                                BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
                                                BlockState _bs = Blocks.BLUE_ICE.defaultBlockState();
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
                                                    _blockEntity.getPersistentData().putBoolean("PassThrough", Pass);
                                                if (world instanceof Level _level)
                                                    _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                                            }
                                        }
                                        if (world instanceof ServerLevel _serverLevel) {
                                            LevelAccessor _worldorig = world;
                                            world = _serverLevel.getServer().getLevel(entity.level().dimension());
                                            if (world != null) {
                                                Entity entitytospawn = JujutsucraftaddonModEntities.VEIL.get().create(_serverLevel, null, null, BlockPos.containing(X, Y, Z), MobSpawnType.MOB_SUMMONED, false, false);
                                                if (entitytospawn != null) {
                                                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                                    (entitytospawn).getPersistentData().putDouble("TemporaryVeilsSize", Math.round(8));
                                                    (entitytospawn).getPersistentData().putDouble("TemporaryVeilsTimer", (60 * 20));
                                                    (entitytospawn).getPersistentData().putString("ownerUUID", (entity.getStringUUID()));
                                                    entity.getPersistentData().putString("TemporaryVeilUUID", ((entitytospawn).getStringUUID()));
                                                    _serverLevel.addFreshEntity(entitytospawn);
                                                }
                                            }
                                            world = _worldorig;
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
