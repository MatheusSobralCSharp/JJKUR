package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.entity.FushiguroTojiEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;

public class SixEyesCutProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (!(entity instanceof FushiguroTojiEntity)) {
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.PlayerSelectCurseTechniqueName = "Six Eyes Cut";
                capability.syncPlayerVariables(entity);
            });
        }

        if (entity.getPersistentData().getDouble("friend_num") == 0) {
            entity.getPersistentData().putDouble("friend_num", Math.random());
        }

        if (entity instanceof FushiguroTojiEntity) {
            {
                if (!(entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(JujutsucraftaddonModMobEffects.COOLDOWN_TOJI.get()))) {
                    {
                        final Vec3 _center = new Vec3(x, y, z);
                        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(120 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                        for (Entity entityiterator : _entfound) {
                            if (!(entityiterator == entity)) {
                                for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 20, 25); index0++) {
                                    if (world instanceof ServerLevel _serverLevel) {
                                        Entity entitytospawn = JujutsucraftModEntities.CURSED_SPIRIT_GRADE_33.get().spawn(_serverLevel, BlockPos.containing((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())),
                                                MobSpawnType.MOB_SUMMONED);
                                        if (entitytospawn != null) {
                                            entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                        }
                                        CompoundTag dataIndex20 = new CompoundTag();
                                        (entitytospawn).saveWithoutId(dataIndex20);
                                        dataIndex20.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                                        (entitytospawn).load(dataIndex20);

                                        CompoundTag dataIndex30 = new CompoundTag();
                                        (entityiterator).saveWithoutId(dataIndex30);
                                        dataIndex30.getCompound("ForgeData").putDouble("cnt_x", 0);
                                        (entityiterator).load(dataIndex30);

                                        if (entityiterator instanceof Mob) {
                                            try {
                                                ((Mob) entityiterator).setTarget(null);
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }


                                        CompoundTag dataIndex27 = new CompoundTag();
                                        (entitytospawn).saveWithoutId(dataIndex27);
                                        dataIndex27.getCompound("ForgeData").putString("owner_name_data", String.valueOf((entity.getDisplayName())));
                                        (entitytospawn).load(dataIndex27);

                                        CompoundTag dataIndex21 = new CompoundTag();
                                        (entitytospawn).saveWithoutId(dataIndex21);
                                        dataIndex21.getCompound("ForgeData").putDouble("friend_num", (entity.getPersistentData().getDouble("friend_num")));
                                        (entitytospawn).load(dataIndex21);

                                        CompoundTag dataIndex26 = new CompoundTag();
                                        (entitytospawn).saveWithoutId(dataIndex26);
                                        dataIndex26.getCompound("ForgeData").putDouble("friend_num_worker", (entity.getPersistentData().getDouble("friend_num")));
                                        (entitytospawn).load(dataIndex26);

                                        CompoundTag dataIndex22 = new CompoundTag();
                                        (entitytospawn).saveWithoutId(dataIndex22);
                                        dataIndex22.getCompound("ForgeData").putBoolean("CursedSpirit", true);
                                        (entitytospawn).load(dataIndex22);
                                        CompoundTag dataIndex24 = new CompoundTag();
                                        (entitytospawn).saveWithoutId(dataIndex24);
                                        dataIndex24.getCompound("ForgeData").putBoolean("jjkChara", true);
                                        (entitytospawn).load(dataIndex24);


                                        if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                            _entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 120, 1, false, false));

                                        if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                            _entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 120, 1, false, false));


                                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.COOLDOWN_TOJI.get(), 40, 1, false, false));

                                    }
                                }
                                break;
                            }
                        }
                    }

                }
            }
        } else if (!(entity instanceof FushiguroTojiEntity)) {
            if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Six Eyes Cut")) {
                {
                    if (!(entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(JujutsucraftaddonModMobEffects.COOLDOWN_TOJI.get()))) {
                        {
                            final Vec3 _center = new Vec3(x, y, z);
                            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                            for (Entity entityiterator : _entfound) {
                                if (!(entityiterator == entity)) {
                                    for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 20, 25); index0++) {
                                        if (world instanceof ServerLevel _serverLevel) {
                                            Entity entitytospawn = JujutsucraftModEntities.CURSED_SPIRIT_GRADE_33.get().spawn(_serverLevel, BlockPos.containing((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())),
                                                    MobSpawnType.MOB_SUMMONED);
                                            if (entitytospawn != null) {
                                                entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                            }
                                            CompoundTag dataIndex20 = new CompoundTag();
                                            (entitytospawn).saveWithoutId(dataIndex20);
                                            dataIndex20.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                                            (entitytospawn).load(dataIndex20);

                                            CompoundTag dataIndex30 = new CompoundTag();
                                            (entityiterator).saveWithoutId(dataIndex30);
                                            dataIndex30.getCompound("ForgeData").putDouble("cnt_x", 0);
                                            (entityiterator).load(dataIndex30);

                                            if (entityiterator instanceof Mob) {
                                                try {
                                                    ((Mob) entityiterator).setTarget(null);
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                            }


                                            CompoundTag dataIndex27 = new CompoundTag();
                                            (entitytospawn).saveWithoutId(dataIndex27);
                                            dataIndex27.getCompound("ForgeData").putString("owner_name_data", String.valueOf((entity.getDisplayName())));
                                            (entitytospawn).load(dataIndex27);

                                            CompoundTag dataIndex21 = new CompoundTag();
                                            (entitytospawn).saveWithoutId(dataIndex21);
                                            dataIndex21.getCompound("ForgeData").putDouble("friend_num", (entity.getPersistentData().getDouble("friend_num")));
                                            (entitytospawn).load(dataIndex21);

                                            CompoundTag dataIndex26 = new CompoundTag();
                                            (entitytospawn).saveWithoutId(dataIndex26);
                                            dataIndex26.getCompound("ForgeData").putDouble("friend_num_worker", (entity.getPersistentData().getDouble("friend_num")));
                                            (entitytospawn).load(dataIndex26);

                                            CompoundTag dataIndex22 = new CompoundTag();
                                            (entitytospawn).saveWithoutId(dataIndex22);
                                            dataIndex22.getCompound("ForgeData").putBoolean("CursedSpirit", true);
                                            (entitytospawn).load(dataIndex22);
                                            CompoundTag dataIndex24 = new CompoundTag();
                                            (entitytospawn).saveWithoutId(dataIndex24);
                                            dataIndex24.getCompound("ForgeData").putBoolean("jjkChara", true);
                                            (entitytospawn).load(dataIndex24);


                                            if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                                _entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 120, 1, false, false));

                                            if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                                _entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 120, 1, false, false));

                                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.COOLDOWN_TOJI.get(), 80, 1, false, false));

                                        }
                                    }
                                    break;
                                }
                            }
                        }

                    }
                }

            }
        }
    }
}
