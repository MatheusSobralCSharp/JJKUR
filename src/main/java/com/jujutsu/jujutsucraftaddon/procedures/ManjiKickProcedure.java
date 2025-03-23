package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.RangeAttackProcedure;
import net.mcreator.jujutsucraft.procedures.RotateEntityProcedure;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class ManjiKickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        boolean logic_a = false;
        boolean SUCCESS = false;
        double x_pos = 0.0;
        double y_pos = 0.0;
        double z_pos = 0.0;
        double yaw = 0.0;
        double picth = 0.0;
        double CNT6 = 0.0;
        double tick = 0.0;
        double x_power = 0.0;
        double y_power = 0.0;
        double z_power = 0.0;
        double dis = 0.0;
        double HP = 0.0;
        double rnd = 0.0;
        CNT6 = 10.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
        LivingEntity _entGetArmor;
        LivingEntity var10000;
        Mob _mobEnt;
        Level _level;

        for (int i = 0; i < 16; i++) {
            entity.getPersistentData().putDouble("skill", 2904);
            entity.getPersistentData().putDouble("cnt2", 1.0);
            entity.getPersistentData().putDouble("cnt7", 1.0);
            CompoundTag dataIndex7 = new CompoundTag();
            entity.saveWithoutId(dataIndex7);
            dataIndex7.getCompound("ForgeData").putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            entity.load(dataIndex7);
            if (world instanceof ServerLevel _server) {
                _server.sendParticles(ParticleTypes.CLOUD, x, y, z, 10, 0.1, 0.0, 0.1, 0.5);
            }

            if (world instanceof Level) {
                _level = (Level) world;
                if (!_level.isClientSide()) {
                    _level.explode(null, x, y, z, 0.0F, Level.ExplosionInteraction.NONE);
                }
            }

            if (entity instanceof Mob) {
                _mobEnt = (Mob) entity;
                var10000 = _mobEnt.getTarget();
            } else {
                var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                Level var46 = var10000.level();
                ClipContext var10001;
                LivingEntity var10003;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10003 = _mobEnt.getTarget();
                } else {
                    var10003 = null;
                }

                Vec3 var47 = var10003.getEyePosition(1.0F);
                LivingEntity var10004;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10004 = _mobEnt.getTarget();
                } else {
                    var10004 = null;
                }

                Vec3 var49 = var10004.getEyePosition(1.0F);
                LivingEntity var10005;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10005 = _mobEnt.getTarget();
                } else {
                    var10005 = null;
                }

                var49 = var49.add(var10005.getViewVector(1.0F).scale(0.0));
                ClipContext.Block var50 = ClipContext.Block.OUTLINE;
                ClipContext.Fluid var10006 = ClipContext.Fluid.NONE;
                LivingEntity var10007;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10007 = _mobEnt.getTarget();
                } else {
                    var10007 = null;
                }

                var10001 = new ClipContext(var47, var49, var50, var10006, var10007);
                x_pos = var46.clip(var10001).getBlockPos().getX();
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                var46 = var10000.level();
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10003 = _mobEnt.getTarget();
                } else {
                    var10003 = null;
                }

                var47 = var10003.getEyePosition(1.0F);
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10004 = _mobEnt.getTarget();
                } else {
                    var10004 = null;
                }

                var49 = var10004.getEyePosition(1.0F);
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10005 = _mobEnt.getTarget();
                } else {
                    var10005 = null;
                }

                var49 = var49.add(var10005.getViewVector(1.0F).scale(0.0));
                var50 = ClipContext.Block.OUTLINE;
                var10006 = ClipContext.Fluid.NONE;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10007 = _mobEnt.getTarget();
                } else {
                    var10007 = null;
                }

                var10001 = new ClipContext(var47, var49, var50, var10006, var10007);
                y_pos = var46.clip(var10001).getBlockPos().getY();
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                var46 = var10000.level();
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10003 = _mobEnt.getTarget();
                } else {
                    var10003 = null;
                }

                var47 = var10003.getEyePosition(1.0F);
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10004 = _mobEnt.getTarget();
                } else {
                    var10004 = null;
                }

                var49 = var10004.getEyePosition(1.0F);
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10005 = _mobEnt.getTarget();
                } else {
                    var10005 = null;
                }

                var49 = var49.add(var10005.getViewVector(1.0F).scale(0.0));
                var50 = ClipContext.Block.OUTLINE;
                var10006 = ClipContext.Fluid.NONE;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10007 = _mobEnt.getTarget();
                } else {
                    var10007 = null;
                }

                var10001 = new ClipContext(var47, var49, var50, var10006, var10007);
                z_pos = var46.clip(var10001).getBlockPos().getZ();
                RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);


                entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0 * CNT6);
                entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0 * CNT6);
                entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0 * CNT6);
                ItemStack var48;
                if (!(entity instanceof Player)) {
                    if (entity instanceof LivingEntity) {
                        _entGetArmor = (LivingEntity) entity;
                        var48 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                    } else {
                        var48 = ItemStack.EMPTY;
                    }

                    var48.getOrCreateTag().putDouble("P_ANIME1", 1706.0);
                }

                PlayAnimationProcedure.execute(world, entity);
                if (entity instanceof Player) {
                    if (entity instanceof LivingEntity) {
                        _entGetArmor = (LivingEntity) entity;
                        var48 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                    } else {
                        var48 = ItemStack.EMPTY;
                    }

                    var48.getOrCreateTag().putDouble("P_ANIME1", 1706.0);
                }
            }

            entity.getPersistentData().putDouble("cnt4", -1.0);
            x_pos = entity.getPersistentData().getDouble("old_x");
            y_pos = entity.getPersistentData().getDouble("old_y");
            z_pos = entity.getPersistentData().getDouble("old_z");
            x_power = x_pos - x;
            y_power = y_pos - y;
            z_power = z_pos - z;
            dis = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
            if (dis > 0.0) {
                x_power /= dis;
                y_power /= dis;
                z_power /= dis;
            }

            entity.getPersistentData().putDouble("x_knockback", entity.getPersistentData().getDouble("x_power") * 1.5);
            entity.getPersistentData().putDouble("y_knockback", 0.25);
            entity.getPersistentData().putDouble("z_knockback", entity.getPersistentData().getDouble("z_power") * 1.5);

            for (int index0 = 0; index0 < (int) Math.max(Math.ceil(dis), 1.0); ++index0) {
                entity.getPersistentData().putDouble("Damage", 12.0 * CNT6);
                entity.getPersistentData().putDouble("Range", 2.0F + entity.getBbHeight());
                entity.getPersistentData().putDouble("knockback", 1.0);
                entity.getPersistentData().putDouble("effect", 5.0);
                entity.getPersistentData().putBoolean("attack", true);
                RangeAttackProcedure.execute(world, x_pos, y_pos + (double) entity.getBbHeight() * 0.5, z_pos, entity);
                x_pos += x_power;
                y_pos += y_power;
                z_pos += z_power;
            }

            entity.getPersistentData().putDouble("old_x", x);
            entity.getPersistentData().putDouble("old_y", y);
            entity.getPersistentData().putDouble("old_z", z);
            entity.getPersistentData().putDouble("x_knockback", 0.0);
            entity.getPersistentData().putDouble("y_knockback", 0.0);
            entity.getPersistentData().putDouble("z_knockback", 0.0);
            entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power"), entity.getPersistentData().getDouble("cnt1") < 5.0 ? Math.max(entity.getPersistentData().getDouble("y_power"), 0.25) : entity.getPersistentData().getDouble("y_power"), entity.getPersistentData().getDouble("z_power")));
            if (entity.getPersistentData().getDouble("cnt1") > 9.0) {
                entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                if (entity.getPersistentData().getDouble("cnt1") > 16.0) {
                    entity.getPersistentData().putDouble("skill", 0.0);
                }
            }

            entity.getPersistentData().putBoolean("attack", true);

        }
    }
}
