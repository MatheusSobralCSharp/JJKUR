package com.jujutsu.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.AIDomainExpansionEntityProcedure;
import net.mcreator.jujutsucraft.procedures.JujutsuBarrierUpdateTickProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = AIDomainExpansionEntityProcedure.class, priority = -10000)
public abstract class AIDomainExpansionEntityProcedureMixin {

    /**
     * @author Satushi
     * @reason Adding Domain Expansion Entity the logic to change the radius + fix some bugs with barrier creation
     */

    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            BlockState blockstate1 = Blocks.AIR.defaultBlockState();
            String outside = "";
            String inside = "";
            String floor = "";
            String old_block = "";
            boolean logic_a = false;
            boolean failed = false;
            boolean noBarrier = false;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double range = 0.0;
            double dis = 0.0;
            double loop_num = 0.0;
            double x_dis = 0.0;
            double y_dis = 0.0;
            double z_dis = 0.0;
            double domain_num = 0.0;
            double cnt1 = 0.0;
            double y_floor = 0.0;
            double x_dis_p = 0.0;
            double y_dis_p = 0.0;
            double z_dis_p = 0.0;
            double cnt2 = 0.0;
            double dis_p = 0.0;
            range = (double) Math.round(entity.getPersistentData().getDouble("DomainExpansionSizer") + 3.0);
            entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            Entity _ent = entity;
            _ent.teleportTo(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"));
            if (_ent instanceof ServerPlayer _serverPlayer) {
                _serverPlayer.connection.teleport(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"), _ent.getYRot(), _ent.getXRot());
            }

            LivingEntity _livEnt12;
            if (entity instanceof LivingEntity) {
                _livEnt12 = (LivingEntity) entity;
                if (!_livEnt12.level().isClientSide()) {
                    _livEnt12.addEffect(new MobEffectInstance(MobEffects.GLOWING, 60, 0, false, false));
                }
            }

            if (!entity.getPersistentData().getBoolean("Break")) {
                label88:
                {
                    if (entity instanceof LivingEntity) {
                        _livEnt12 = (LivingEntity) entity;
                        if (_livEnt12.hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                            break label88;
                        }
                    }

                    entity.getPersistentData().putDouble("cnt_life2", entity.getPersistentData().getDouble("cnt_life2") + 1.0);
                    if (entity.getPersistentData().getDouble("cnt_life2") > Math.max(60.0, range * 2.0 + 5.0)) {
                        entity.getPersistentData().putBoolean("Break", true);
                    }
                }

                if (entity instanceof LivingEntity) {
                    _livEnt12 = (LivingEntity) entity;
                    if (_livEnt12.hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                        entity.getPersistentData().putBoolean("Break", false);
                        entity.getPersistentData().putDouble("cnt_life2", 0.0);
                    }
                }
            }

            if (entity.getPersistentData().getBoolean("Break")) {
                entity.getPersistentData().putDouble("cnt_break", entity.getPersistentData().getDouble("cnt_break") + 1.0);
                loop_num = (double) Math.round(range * 2.0 + 1.0);
                cnt2 = entity.getPersistentData().getDouble("cnt_break");
                y_floor = (double) (Math.round(y) - 1L);
                x_pos = (double) Math.round(x) - range;

                for (int index0 = 0; index0 < (int) loop_num; ++index0) {
                    x_dis = Math.pow(x_pos - (double) Math.round(x), 2.0);
                    x_dis_p = Math.pow(x_pos - (double) Math.round((float) Math.round(x)), 2.0);
                    if (Math.sqrt(x_dis_p) <= cnt2) {
                        y_pos = (double) Math.round(y) - range;

                        for (int index1 = 0; index1 < (int) loop_num; ++index1) {
                            y_dis = Math.pow(y_pos - (double) Math.round(y), 2.0);
                            y_dis_p = Math.pow(y_pos - (double) Math.round(y), 2.0);
                            if (Math.sqrt(y_dis_p) <= cnt2 && y_pos >= -64.0 && y_pos <= 319.0) {
                                z_pos = (double) Math.round(z) - range;

                                for (int index2 = 0; index2 < (int) loop_num; ++index2) {
                                    z_dis = Math.pow(z_pos - (double) Math.round(z), 2.0);
                                    z_dis_p = Math.pow(z_pos - (double) Math.round(z), 2.0);
                                    if (Math.sqrt(z_dis_p) <= cnt2) {
                                        dis_p = Math.sqrt(x_dis_p + y_dis_p + z_dis_p);
                                        if (dis_p <= cnt2 + 0.0 && dis_p >= cnt2 - 1.0) {
                                            dis = Math.sqrt(x_dis + z_dis + y_dis);
                                            if (dis < range + 1.0) {
                                                blockstate1 = world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos));
                                                if (blockstate1.is(BlockTags.create(new ResourceLocation("jujutsucraft:barrier")))) {
                                                    JujutsuBarrierUpdateTickProcedure.execute(world, x_pos, y_pos, z_pos);
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

                if (entity.getPersistentData().getDouble("cnt_break") >= (double) Math.round(range * 2.0 + 2.0) && !entity.level().isClientSide()) {
                    entity.discard();
                }
            }

        }
    }
}
