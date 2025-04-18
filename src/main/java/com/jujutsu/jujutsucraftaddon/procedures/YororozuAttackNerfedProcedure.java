package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.TechniqueNeedleProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;

public class YororozuAttackNerfedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (Math.random() < (1) / ((float) 200)) {
            {
                final Vec3 _center = new Vec3(x, y, z);
                List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                for (Entity entityiterator : _entfound) {
                    if (!(entityiterator == entity)) {
                        if (world instanceof ServerLevel _serverLevel) {
                            Entity entitytospawn = JujutsucraftModEntities.NEEDLE.get().spawn(_serverLevel, BlockPos.containing((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), MobSpawnType.MOB_SUMMONED);
                            if (entitytospawn != null) {
                                entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    (entitytospawn).saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                                    (entitytospawn).load(dataIndex);
                                }
                                if ((entitytospawn) instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                                    _livingEntity9.getAttribute(Attributes.MAX_HEALTH).setBaseValue(500);
                                {
                                    Entity _ent = (entitytospawn);
                                    _ent.teleportTo((x + Mth.nextInt(RandomSource.create(), -2, 2)), y, z);
                                    if (_ent instanceof ServerPlayer _serverPlayer)
                                        _serverPlayer.connection.teleport((x + Mth.nextInt(RandomSource.create(), -2, 2)), y, z, _ent.getYRot(), _ent.getXRot());
                                }
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    (entitytospawn).saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                                        public double getValue() {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                        }
                                    }.getValue()));
                                    (entitytospawn).load(dataIndex);
                                }
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    (entitytospawn).saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                                        public double getValue() {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                        }
                                    }.getValue()));
                                    (entitytospawn).load(dataIndex);
                                }
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    (entitytospawn).saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("skill", 2909);
                                    (entitytospawn).load(dataIndex);
                                }
                                if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 10000,
                                            ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())
                                                    ? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier()
                                                    : 0),
                                            false, false));
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    (entitytospawn).saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("NameRanged_ranged", Math.random());
                                    (entitytospawn).load(dataIndex);
                                }
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    (entitytospawn).saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("NameRanged", Math.random());
                                    (entitytospawn).load(dataIndex);
                                }
                                if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 3, false, false));
                                if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
                                            entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
                                if ((entitytospawn) instanceof LivingEntity _entity)
                                    _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                                _serverLevel.addFreshEntity(entitytospawn);
                            }
                        }
                    }
                }
            }
            TechniqueNeedleProcedure.execute(world, x, y, z, entity);
        }
    }
}
