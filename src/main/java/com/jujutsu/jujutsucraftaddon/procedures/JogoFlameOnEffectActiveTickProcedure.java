package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import java.util.List;

public class JogoFlameOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex0 = new CompoundTag();
                entity.saveWithoutId(dataIndex0);
                return dataIndex0.getCompound("ForgeData").getDouble("cnt6");
            }
        }.getValue() > 0 && new Object() {
            public double getValue() {
                CompoundTag dataIndex1 = new CompoundTag();
                entity.saveWithoutId(dataIndex1);
                return dataIndex1.getCompound("ForgeData").getDouble("cnt6");
            }
        }.getValue() < 6) {
            CompoundTag dataIndex3 = new CompoundTag();
            entity.saveWithoutId(dataIndex3);
            dataIndex3.getCompound("ForgeData").putDouble("cnt6", (new Object() {
                public double getValue() {
                    CompoundTag dataIndex2 = new CompoundTag();
                    entity.saveWithoutId(dataIndex2);
                    return dataIndex2.getCompound("ForgeData").getDouble("cnt6");
                }
            }.getValue() + 1));
            entity.load(dataIndex3);
        }
        if (!(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(MobEffects.REGENERATION))) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 1, false, false));
        }
        if (!(entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(MobEffects.DIG_SPEED))) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, -1, 6, false, false));
        }
        if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Attack")) {
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel > 3) {
                if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                    {
                        final Vec3 _center = new Vec3(x, y, z);
                        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                        for (Entity entityiterator : _entfound) {
                            if (!(entityiterator == entity)) {
                                if ((entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == entity) {
                                    if (world instanceof ServerLevel _serverLevel) {
                                        Entity entitytospawn = JujutsucraftModEntities.METEOR.get().spawn(_serverLevel, BlockPos.containing((entityiterator.getX()), (entityiterator.getY() + 60), (entityiterator.getZ())),
                                                MobSpawnType.MOB_SUMMONED);
                                        if (entitytospawn != null) {
                                            entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                        }
                                        ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(30);
                                        CompoundTag dataIndex1 = new CompoundTag();
                                        (entitytospawn).saveWithoutId(dataIndex1);
                                        dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                                        (entitytospawn).load(dataIndex1);
                                        CompoundTag dataIndex3 = new CompoundTag();
                                        (entitytospawn).saveWithoutId(dataIndex3);
                                        dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                                            public double getValue() {
                                                CompoundTag dataIndex2 = new CompoundTag();
                                                entity.saveWithoutId(dataIndex2);
                                                return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
                                            }
                                        }.getValue()));
                                        (entitytospawn).load(dataIndex3);
                                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (-1), 1, false, false));
                                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 19, false, false));
                                    }
                                    if (world instanceof ServerLevel _serverLevel) {
                                        Entity entitytospawn = JujutsucraftModEntities.METEOR.get().spawn(_serverLevel, BlockPos.containing((entityiterator.getX()), (entityiterator.getY() + 40), (entityiterator.getZ())),
                                                MobSpawnType.MOB_SUMMONED);
                                        if (entitytospawn != null) {
                                            entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                        }
                                        ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(30);
                                        CompoundTag dataIndex1 = new CompoundTag();
                                        (entitytospawn).saveWithoutId(dataIndex1);
                                        dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                                        (entitytospawn).load(dataIndex1);
                                        CompoundTag dataIndex3 = new CompoundTag();
                                        (entitytospawn).saveWithoutId(dataIndex3);
                                        dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                                            public double getValue() {
                                                CompoundTag dataIndex2 = new CompoundTag();
                                                entity.saveWithoutId(dataIndex2);
                                                return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
                                            }
                                        }.getValue()));
                                        (entitytospawn).load(dataIndex3);
                                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 10, false, false));
                                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (-1), 1, false, false));
                                        {
                                            double _setval = 0;
                                            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                                capability.OutputLevel = _setval;
                                                capability.syncPlayerVariables(entity);
                                            });
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
