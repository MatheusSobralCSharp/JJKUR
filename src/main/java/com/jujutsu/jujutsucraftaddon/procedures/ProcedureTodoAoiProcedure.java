package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.ItadoriShinjukuEntity;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.entity.ItadoriYujiShibuyaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Objects;

public class ProcedureTodoAoiProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain) {
            if (entity.isShiftKeyDown()) {
                if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
                        .equals(Component.translatable("jujutsu.technique.boogie_woogie").getString())) {
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerSelectCurseTechniqueName = "Clap";
                        capability.syncPlayerVariables(entity);
                    });
                }
                if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
                        .equals(Component.translatable("jujutsu.technique.todo_ultra").getString())) {
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerSelectCurseTechniqueName = "We Are The Exception";
                        capability.syncPlayerVariables(entity);
                    });
                }
            }
            if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("We Are The Exception")) {
                if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                    if (!((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()))) {
                        if (!(entity instanceof ServerPlayer _plr19 && _plr19.level() instanceof ServerLevel
                                && _plr19.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr19.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:strong_sorcerer_grade")))).isDone())) {
                            if (entity instanceof ServerPlayer && entity.level() instanceof ServerLevel
                                    && ((ServerPlayer) entity).getAdvancements().getOrStartProgress(Objects.requireNonNull(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sorcerer_grade_special")))).isDone()) {
                                if (!world.getEntitiesOfClass(ItadoriYujiShibuyaEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty()) {
                                    if (world instanceof ServerLevel _serverLevel) {
                                        Entity entitytospawn = JujutsucraftModEntities.ITADORI_YUJI_SHIBUYA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                                        if (entitytospawn != null) {
                                            entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                            {
                                                CompoundTag dataIndex = new CompoundTag();
                                                (entitytospawn).saveWithoutId(dataIndex);
                                                dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                                                (entitytospawn).load(dataIndex);
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
                                                dataIndex.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
                                                    public double getValue() {
                                                        CompoundTag dataIndex = new CompoundTag();
                                                        entity.saveWithoutId(dataIndex);
                                                        return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                                    }
                                                }.getValue()));
                                                (entitytospawn).load(dataIndex);
                                            }
                                            _serverLevel.addFreshEntity(entitytospawn);
                                        }
                                    }
                                }
                            }
                        } else if (entity instanceof ServerPlayer _plr34 && _plr34.level() instanceof ServerLevel
                                && _plr34.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr34.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:strong_sorcerer_grade")))).isDone()) {
                            if (world.getEntitiesOfClass(ItadoriShinjukuEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty()) {
                                if (world instanceof ServerLevel _serverLevel) {
                                    LevelAccessor _worldorig = world;
                                    world = _serverLevel.getServer().getLevel(entity.level().dimension());
                                    if (world != null) {
                                        Entity entitytospawn = JujutsucraftaddonModEntities.ITADORI_SHINJUKU.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
                                        if (entitytospawn != null) {
                                            entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                            {
                                                CompoundTag dataIndex = new CompoundTag();
                                                (entitytospawn).saveWithoutId(dataIndex);
                                                dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                                                (entitytospawn).load(dataIndex);
                                            }
                                            {
                                                CompoundTag dataIndex = new CompoundTag();
                                                (entitytospawn).saveWithoutId(dataIndex);
                                                dataIndex.getCompound("ForgeData").putString("Owner", (entity.getStringUUID()));
                                                (entitytospawn).load(dataIndex);
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
                                                dataIndex.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
                                                    public double getValue() {
                                                        CompoundTag dataIndex = new CompoundTag();
                                                        entity.saveWithoutId(dataIndex);
                                                        return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                                    }
                                                }.getValue()));
                                                (entitytospawn).load(dataIndex);
                                            }
                                            _serverLevel.addFreshEntity(entitytospawn);
                                        }
                                    }
                                    world = _worldorig;
                                }
                            }
                        }
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 1200, 1, false, false));
                    }
                }
            }
        }
    }
}
