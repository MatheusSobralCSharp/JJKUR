package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.entity.Rika2Entity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;


public class YutaConditionProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
        if (sourceentity == null)
            return;
        if (Math.random() <= 0.08) {
            if (world.getEntitiesOfClass(Rika2Entity.class, AABB.ofSize(new Vec3(x, y, z), 30, 30, 30), e -> true).isEmpty()) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.RIKA_2.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        CompoundTag dataIndex3 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex3);
                        dataIndex3.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                        (entitytospawn).load(dataIndex3);
                        CompoundTag dataIndex6 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex6);
                        dataIndex6.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex5 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex5);
                                return dataIndex5.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex6);
                        CompoundTag dataIndex9 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex9);
                        dataIndex9.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex8 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex8);
                                return dataIndex8.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex9);
                        CompoundTag dataIndex12 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex12);
                        dataIndex12.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex11 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex11);
                                return dataIndex11.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex12);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 100, 1, false, false));
                    }
                }
            }
            if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("RIKA!!"), false);
        }
    }
}
