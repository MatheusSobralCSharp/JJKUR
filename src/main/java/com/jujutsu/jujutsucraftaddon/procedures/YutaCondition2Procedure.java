package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
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


public class YutaCondition2Procedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2) {
            if (Math.random() <= 0.2) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.RIKA_2.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                        CompoundTag dataIndex4 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex4);
                        dataIndex4.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                        (entitytospawn).load(dataIndex4);
                        CompoundTag dataIndex7 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex7);
                        dataIndex7.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex6 = new CompoundTag();
                                entity.saveWithoutId(dataIndex6);
                                return dataIndex6.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex7);
                        CompoundTag dataIndex10 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex10);
                        dataIndex10.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex9 = new CompoundTag();
                                entity.saveWithoutId(dataIndex9);
                                return dataIndex9.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex10);
                        CompoundTag dataIndex13 = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex13);
                        dataIndex13.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex12 = new CompoundTag();
                                entity.saveWithoutId(dataIndex12);
                                return dataIndex12.getCompound("ForgeData").getDouble("friend_num");
                            }
                        }.getValue()));
                        (entitytospawn).load(dataIndex13);
                        if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 100, 1, false, false));
                    }
                }
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Rika.."), false);
            }
        }
    }
}
