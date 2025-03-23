package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.entity.VeilEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class VeilPlayerCollidesWithThisEntityProcedure {
    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        String endtext = "";
        double repeats = 0;
        if (entity instanceof VeilEntity _datEntL0 && _datEntL0.getEntityData().get(VeilEntity.DATA_flag)) {
            if (sourceentity.getPersistentData().getDouble("cnt_FLAG") < 6000) {
                if (!(new Object() {
                    public String getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getString("OWNER_UUID");
                    }
                }.getValue()).equals(new Object() {
                    public String getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        sourceentity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getString("OWNER_UUID");
                    }
                }.getValue())) {
                    if (!(new Object() {
                        public String getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getString("OWNER_UUID");
                        }
                    }.getValue()).equals(sourceentity.getStringUUID())) {
                        Player _player;
                        if (sourceentity.getPersistentData().getDouble("cnt_FLAG") < 6000.0) {
                            {
                                sourceentity.getPersistentData().putDouble("cnt_FLAG", sourceentity.getPersistentData().getDouble("cnt_FLAG") + 1.0);
                                endtext = "§0CAPTURING FLAG";
                            }
                            repeats = (double) Math.round((6000.0 - sourceentity.getPersistentData().getDouble("cnt_FLAG")) * 0.25);
                            for (int index0 = 0; index0 < (int) repeats; ++index0) {
                                endtext = "§0■" + endtext + "§0■";
                            }
                            if (sourceentity instanceof Player) {
                                _player = (Player) sourceentity;
                                if (!_player.level().isClientSide()) {
                                    _player.displayClientMessage(Component.literal(endtext), true);
                                }
                            }
                        }
                        if (sourceentity.getPersistentData().getDouble("cnt_FLAG") == 6000.0) {
                            {
                                Entity _ent;
                                if (sourceentity instanceof Player) {
                                    _player = (Player) sourceentity;
                                    if (!_player.level().isClientSide()) {
                                        _player.displayClientMessage(Component.literal(""), true);
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (sourceentity.getPersistentData().getDouble("cnt_FLAG") >= 6000) {
                if (world instanceof ServerLevel) {
                    for (Entity entityiterator : ((ServerLevel) world).getAllEntities()) {
                        if (entityiterator != null)
                            continue;
                        if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.REWARD.get(), 20, 1, false, false));
                        if ((new Object() {
                            public String getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entityiterator.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getString("OWNER_UUID");
                            }
                        }.getValue()).equals(sourceentity.getStringUUID())) {
                            if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.REWARD.get(), 20, 1, false, false));
                            if (entityiterator instanceof Player _player && !_player.level().isClientSide())
                                _player.displayClientMessage(Component.literal("You WONNNN"), false);
                            if (entityiterator instanceof LivingEntity _entity)
                                _entity.removeEffect(JujutsucraftaddonModMobEffects.TEAM_BATTLE.get());
                        } else {
                            if (entityiterator instanceof Player _player && !_player.level().isClientSide())
                                _player.displayClientMessage(Component.literal("You LOSE"), false);
                            if (entityiterator instanceof LivingEntity _entity)
                                _entity.removeEffect(JujutsucraftaddonModMobEffects.TEAM_BATTLE.get());
                        }
                        sourceentity.getPersistentData().putDouble("cnt_FLAG", 0);
                        entityiterator.getPersistentData().putDouble("cnt_FLAG", 0);
                        if (entityiterator instanceof VeilEntity) {
                            if (entityiterator instanceof VeilEntity _datEntL18 && _datEntL18.getEntityData().get(VeilEntity.DATA_flag)) {
                                if (!entityiterator.level().isClientSide())
                                    entityiterator.discard();
                            }
                        }
                        if (!entity.level().isClientSide())
                            entity.discard();
                    }
                }
            }
        }
    }
}
