package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.entity.DomainExpansionEntityEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModBlocks;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.DomainExpansionBattleProcedure;
import net.mcreator.jujutsucraft.procedures.GetDomainBlockProcedure;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Mixin(value = DomainExpansionBattleProcedure.class, priority = -10000)
public abstract class DomainExpansionBattleProcedureMixin {
    /**
     * @author Satushi
     * @reason Changing Domain Variable Active
     */
    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            boolean logic_a;
            boolean failed;
            boolean noBarrier;
            Entity entity_a;
            double x_dis;
            double x_dis_p;
            double cnt2;
            double var10000;
            double range;
            double x_pos;
            double z_dis;
            double domain_num;
            double z_pos;
            double dis_p;
            double dis;
            double loop_num;
            double y_floor;
            double y_dis_p;
            double y_pos;
            double y_dis;
            double z_dis_p;
            double close_type;
            double speed;
            String inside;
            String outside;
            String old_block;
            String floor;
            String cnt_type;
            BlockState blockstate1;
            LivingEntity _livEnt30;
            label414:
            {
                logic_a = false;
                failed = false;
                noBarrier = false;
                entity_a = null;
                x_dis = 0.0;
                x_dis_p = 0.0;
                cnt2 = 0.0;
                range = 0.0;
                x_pos = 0.0;
                z_dis = 0.0;
                domain_num = 0.0;
                z_pos = 0.0;
                dis_p = 0.0;
                dis = 0.0;
                loop_num = 0.0;
                y_floor = 0.0;
                y_dis_p = 0.0;
                y_pos = 0.0;
                y_dis = 0.0;
                z_dis_p = 0.0;
                close_type = 0.0;
                speed = 0.0;
                inside = "";
                outside = "";
                old_block = "";
                floor = "";
                cnt_type = "";
                blockstate1 = Blocks.AIR.defaultBlockState();
                BlockState blockstate2 = Blocks.AIR.defaultBlockState();
                domain_num = entity.getPersistentData().getDouble("skill_domain") > 0.0 ? entity.getPersistentData().getDouble("skill_domain") : entity.getPersistentData().getDouble("select");
                if (entity instanceof LivingEntity _livEnt3) {
                    if (_livEnt3.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        if (entity instanceof LivingEntity) {
                            _livEnt30 = (LivingEntity) entity;
                            if (_livEnt30.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                var10000 = _livEnt30.getEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                break label414;
                            }
                        }

                        var10000 = 0.0;
                        break label414;
                    }
                }

                var10000 = entity.getPersistentData().getDouble("cnt2");
            }

            close_type = var10000;
            GetDomainBlockProcedure.execute(entity);
            outside = entity.getPersistentData().getString("domain_outside");
            inside = entity.getPersistentData().getString("domain_inside");
            floor = entity.getPersistentData().getString("domain_floor");
            noBarrier = close_type > 0.0;
            failed = entity.getPersistentData().getBoolean("Failed") && !entity.getPersistentData().getBoolean("Cover");
            int index5;
            int index4;
            if (failed && entity instanceof LivingEntity) {
                _livEnt30 = (LivingEntity) entity;
                if (_livEnt30.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                    range = 5.0;
                    x_pos = (double) Math.round(x - range);

                    for (index4 = 0; index4 < (int) Math.round(range * 2.0); ++index4) {
                        x_dis = Math.pow((double) Math.round(x) - x_pos, 2.0);
                        y_pos = (double) Math.round(y - range);

                        for (index5 = 0; index5 < (int) Math.round(range * 2.0); ++index5) {
                            y_dis = Math.pow((double) Math.round(y) - y_pos, 2.0);
                            z_pos = (double) Math.round(z - range);

                            for (int index2 = 0; index2 < (int) Math.round(range * 2.0); ++index2) {
                                z_dis = Math.pow((double) Math.round(z) - z_pos, 2.0);
                                if (Math.random() < 0.1) {
                                    blockstate1 = world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos));
                                    if (blockstate1.is(BlockTags.create(new ResourceLocation("jujutsucraft:barrier"))) && blockstate1.getBlock() != JujutsucraftModBlocks.IN_BARRIER.get() && blockstate1.getBlock() != JujutsucraftModBlocks.JUJUTSU_BARRIER.get()) {
                                        outside = ("" + blockstate1).replace("}", "").replace("Block{", "");
                                        if (!floor.equals(outside)) {
                                            logic_a = true;
                                            old_block = ((new Object() {
                                                public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                                                    BlockEntity blockEntity = world.getBlockEntity(pos);
                                                    return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
                                                }
                                            })).getValue(world, BlockPos.containing(x_pos, y_pos, z_pos), "old_block");
                                            if (world instanceof ServerLevel _level) {
                                                _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "setblock ~ ~ ~ " + floor);
                                            }

                                            if (!world.isClientSide()) {
                                                BlockPos _bp = BlockPos.containing(x_pos, y_pos, z_pos);
                                                BlockEntity _blockEntity = world.getBlockEntity(_bp);
                                                BlockState _bs = world.getBlockState(_bp);
                                                if (_blockEntity != null) {
                                                    _blockEntity.getPersistentData().putString("old_block", old_block);
                                                }

                                                if (world instanceof Level _level) {
                                                    _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                                                }
                                            }

                                            if (Math.random() < 0.01) {
                                                world.levelEvent(2001, BlockPos.containing(x_pos, y_pos, z_pos), Block.getId(blockstate1));
                                            }
                                            break;
                                        }
                                    }
                                }

                                ++z_pos;
                            }

                            ++y_pos;
                            if (logic_a) {
                                break;
                            }
                        }

                        ++x_pos;
                        if (logic_a) {
                            break;
                        }
                    }
                }
            }

            if (!failed) {
                x_pos = entity.getPersistentData().getDouble("x_pos_doma");
                y_pos = entity.getPersistentData().getDouble("y_pos_doma");
                z_pos = entity.getPersistentData().getDouble("z_pos_doma");
                if (close_type <= 0.0 && (entity.getPersistentData().getDouble("cnt1") <= 1.0 || entity.getPersistentData().getDouble("cnt_cover") <= 1.0)) {
                    if (!world.getEntitiesOfClass(DomainExpansionEntityEntity.class, AABB.ofSize(new Vec3(x_pos, y_pos, z_pos), 0.1, 0.1, 0.1), (e) -> {
                        return true;
                    }).isEmpty()) {
                        entity_a = world.getEntitiesOfClass(DomainExpansionEntityEntity.class, AABB.ofSize(new Vec3(x_pos, y_pos, z_pos), 0.1, 0.1, 0.1), (e) -> {
                            return true;
                        }).stream().sorted(((new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble((_entcnd) -> {
                                    return _entcnd.distanceToSqr(_x, _y, _z);
                                });
                            }
                        })).compareDistOf(x_pos, y_pos, z_pos)).findFirst().orElse(null);
                        if (!entity_a.getPersistentData().getBoolean("Break") && !entity_a.level().isClientSide()) {
                            entity_a.discard();
                        }
                    }

                    if (world instanceof ServerLevel _level) {
                        Entity entityToSpawn = ((EntityType) JujutsucraftModEntities.DOMAIN_EXPANSION_ENTITY.get()).spawn(_level, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                            entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        }
                    }
                }

                speed = 1.0;
                if (domain_num == 29.0) {
                    speed = 10.0;
                } else if (entity instanceof LivingEntity) {
                    _livEnt30 = (LivingEntity) entity;
                    if (_livEnt30.hasEffect(JujutsucraftModMobEffects.ZONE.get())) {
                        speed = 3.0;
                    }
                }
                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BarrierlessDomain) {
                    range = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RadiusDomain;
                } else {
                    range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
                }
                loop_num = (double) Math.round(range * 2.0 + 1.0);
                cnt_type = entity.getPersistentData().getBoolean("Cover") ? "cnt_cover" : "cnt1";
                cnt2 = entity.getPersistentData().getDouble(cnt_type);
                cnt2 *= speed;
                if (cnt2 - speed + 1.0 <= loop_num) {
                    y_floor = entity.getPersistentData().getDouble("y_pos_doma") - 1.0;
                    x_pos = (double) Math.round(x) - range;

                    for (int index3 = 0; index3 < (int) loop_num; ++index3) {
                        x_dis = Math.pow(x_pos - (double) Math.round(x), 2.0);
                        x_dis_p = Math.pow(x_pos - (double) Math.round(entity.getPersistentData().getDouble("x_pos_doma2")), 2.0);
                        if (Math.sqrt(x_dis_p) <= cnt2) {
                            y_pos = (double) Math.round(y) - range;

                            for (index4 = 0; index4 < (int) loop_num; ++index4) {
                                y_dis = Math.pow(y_pos - (double) Math.round(y), 2.0);
                                y_dis_p = Math.pow(y_pos - (double) Math.round(entity.getPersistentData().getDouble("y_pos_doma2")), 2.0);
                                if (Math.sqrt(y_dis_p) <= cnt2 && y_pos >= -64.0 && y_pos <= 319.0) {
                                    z_pos = (double) Math.round(z) - range;

                                    for (index5 = 0; index5 < (int) loop_num; ++index5) {
                                        z_dis = Math.pow(z_pos - (double) Math.round(z), 2.0);
                                        z_dis_p = Math.pow(z_pos - (double) Math.round(entity.getPersistentData().getDouble("z_pos_doma2")), 2.0);
                                        if (Math.sqrt(z_dis_p) <= cnt2) {
                                            dis_p = Math.sqrt(x_dis_p + y_dis_p + z_dis_p);
                                            if (dis_p <= cnt2 + 0.0 && dis_p >= cnt2 - speed) {
                                                dis = Math.sqrt(x_dis + z_dis + y_dis);
                                                if (dis < range + 0.5) {
                                                    blockstate1 = world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos));
                                                    old_block = blockstate1.is(BlockTags.create(new ResourceLocation("jujutsucraft:barrier"))) ? ((new Object() {
                                                        public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                                                            BlockEntity blockEntity = world.getBlockEntity(pos);
                                                            return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
                                                        }
                                                    })).getValue(world, BlockPos.containing(x_pos, y_pos, z_pos), "old_block") : ("" + blockstate1).replace("}", "").replace("Block{", "");
                                                    ServerLevel _level;
                                                    if (noBarrier) {
                                                        if (entity.getPersistentData().getBoolean("Cover") && blockstate1.is(BlockTags.create(new ResourceLocation("jujutsucraft:barrier"))) && world instanceof ServerLevel) {
                                                            _level = (ServerLevel) world;
                                                            _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "setblock ~ ~ ~ " + (y_pos <= y_floor ? old_block : inside));
                                                        }
                                                    } else {
                                                        logic_a = false;
                                                        if (blockstate1.is(BlockTags.create(new ResourceLocation("jujutsucraft:barrier")))) {
                                                            logic_a = true;
                                                        } else if (y_pos > y_floor - 1.0) {
                                                            logic_a = true;
                                                        } else if (!world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                                                            logic_a = true;
                                                        } else if (world.getBlockState(BlockPos.containing(x_pos + 1.0, y_pos, z_pos)).canOcclude() && world.getBlockState(BlockPos.containing(x_pos - 1.0, y_pos, z_pos)).canOcclude()) {
                                                            if (world.getBlockState(BlockPos.containing(x_pos, y_pos + 1.0, z_pos)).canOcclude() && world.getBlockState(BlockPos.containing(x_pos, y_pos - 1.0, z_pos)).canOcclude()) {
                                                                if (!world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos + 1.0)).canOcclude() || !world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos - 1.0)).canOcclude()) {
                                                                    logic_a = true;
                                                                }
                                                            } else {
                                                                logic_a = true;
                                                            }
                                                        } else {
                                                            logic_a = true;
                                                        }

                                                        if (logic_a) {
                                                            if (dis < range + 0.0) {
                                                                if (dis >= range - 1.0) {
                                                                    if (world instanceof ServerLevel) {
                                                                        _level = (ServerLevel) world;
                                                                        _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "setblock ~ ~ ~ " + outside);
                                                                    }
                                                                } else if (dis >= range - 2.0) {
                                                                    if (domain_num == 1.0) {
                                                                        if (y_pos != y_floor && Math.abs(x_pos - (double) Math.round(x)) % 5.0 != 2.0) {
                                                                            if (world instanceof ServerLevel) {
                                                                                _level = (ServerLevel) world;
                                                                                _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "setblock ~ ~ ~ jujutsucraft:in_barrier");
                                                                            }
                                                                        } else if (world instanceof ServerLevel) {
                                                                            _level = (ServerLevel) world;
                                                                            _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "setblock ~ ~ ~ " + inside);
                                                                        }
                                                                    } else if (domain_num == 15.0) {
                                                                        if (y_pos != y_floor && Math.abs(x_pos - (double) Math.round(x)) % 5.0 != 2.0 && Math.abs(y_pos - (double) Math.round(y)) % 5.0 != 2.0 && Math.abs(z_pos - (double) Math.round(z)) % 5.0 != 4.0) {
                                                                            if (world instanceof ServerLevel) {
                                                                                _level = (ServerLevel) world;
                                                                                _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "setblock ~ ~ ~ jujutsucraft:in_barrier");
                                                                            }
                                                                        } else if (world instanceof ServerLevel) {
                                                                            _level = (ServerLevel) world;
                                                                            _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "setblock ~ ~ ~ " + inside);
                                                                        }
                                                                    } else if (world instanceof ServerLevel) {
                                                                        _level = (ServerLevel) world;
                                                                        _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "setblock ~ ~ ~ " + inside);
                                                                    }
                                                                } else if (y_pos <= y_floor) {
                                                                    if (y_pos >= y_floor - 4.0) {
                                                                        if (domain_num == 8.0) {
                                                                            if (dis_p < range * 0.675) {
                                                                                if (world instanceof ServerLevel) {
                                                                                    _level = (ServerLevel) world;
                                                                                    _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "setblock ~ ~ ~ jujutsucraft:domain_grass");
                                                                                }
                                                                            } else if (!(dis_p < range * 0.9) && !(y_pos < y_floor - 0.5)) {
                                                                                if (world instanceof ServerLevel) {
                                                                                    _level = (ServerLevel) world;
                                                                                    _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "setblock ~ ~ ~ jujutsucraft:domain_water");
                                                                                }
                                                                            } else if (world instanceof ServerLevel) {
                                                                                _level = (ServerLevel) world;
                                                                                _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "setblock ~ ~ ~ jujutsucraft:domain_sand");
                                                                            }
                                                                        } else if (domain_num == 27.0) {
                                                                            if (world instanceof ServerLevel) {
                                                                                _level = (ServerLevel) world;
                                                                                _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "setblock ~ ~ ~ " + (dis < range * 0.5 ? floor : "jujutsucraft:domain_stone_bricks"));
                                                                            }
                                                                        } else if (world instanceof ServerLevel) {
                                                                            _level = (ServerLevel) world;
                                                                            _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "setblock ~ ~ ~ " + floor);
                                                                        }
                                                                    } else {
                                                                        logic_a = false;
                                                                    }
                                                                } else if (!world.isEmptyBlock(BlockPos.containing(x_pos, y_pos, z_pos))) {
                                                                    if (close_type < 0.0 && !entity.getPersistentData().getBoolean("Cover") && !entity.getPersistentData().getBoolean("Failed")) {
                                                                        if (world instanceof ServerLevel) {
                                                                            _level = (ServerLevel) world;
                                                                            _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "setblock ~ ~ ~ " + floor);
                                                                        }
                                                                    } else if (world instanceof ServerLevel) {
                                                                        _level = (ServerLevel) world;
                                                                        _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "setblock ~ ~ ~ jujutsucraft:in_barrier");
                                                                    }
                                                                } else {
                                                                    logic_a = false;
                                                                }
                                                            } else {
                                                                logic_a = false;
                                                            }
                                                        }

                                                        if (y_pos <= y_floor || dis < range + 0.0 && dis >= range - 2.0) {
                                                            Vec3 _center = new Vec3(x_pos + 0.5, y_pos + 0.5, z_pos + 0.5);
                                                            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> {
                                                                return true;
                                                            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                                                                return _entcnd.distanceToSqr(_center);
                                                            })).toList();
                                                            Iterator var72 = _entfound.iterator();

                                                            while (var72.hasNext()) {
                                                                Entity entityiterator = (Entity) var72.next();
                                                                if (!entityiterator.isInvulnerable() && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living")))) {
                                                                    entityiterator.teleportTo(entityiterator.getX(), y_floor + 1.0, entityiterator.getZ());
                                                                    if (entityiterator instanceof ServerPlayer _serverPlayer) {
                                                                        _serverPlayer.connection.teleport(entityiterator.getX(), y_floor + 1.0, entityiterator.getZ(), entityiterator.getYRot(), entityiterator.getXRot());
                                                                    }
                                                                }
                                                            }
                                                        }

                                                        if (logic_a && world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).is(BlockTags.create(new ResourceLocation("jujutsucraft:barrier"))) && !world.isClientSide()) {
                                                            BlockPos _bp = BlockPos.containing(x_pos, y_pos, z_pos);
                                                            BlockEntity _blockEntity = world.getBlockEntity(_bp);
                                                            BlockState _bs = world.getBlockState(_bp);
                                                            if (_blockEntity != null) {
                                                                _blockEntity.getPersistentData().putString("old_block", old_block);
                                                            }

                                                            if (world instanceof Level _level2) {
                                                                _level2.sendBlockUpdated(_bp, _bs, _bs, 3);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }

                                        ++z_pos;
                                    }
                                }

                                ++y_pos;
                            }
                        }

                        ++x_pos;
                    }
                } else {
                    entity.getPersistentData().putDouble(cnt_type, entity.getPersistentData().getDouble(cnt_type) < 34.0 ? 34.0 : Math.max(entity.getPersistentData().getDouble(cnt_type), loop_num));
                }
            }

        }
    }
}
