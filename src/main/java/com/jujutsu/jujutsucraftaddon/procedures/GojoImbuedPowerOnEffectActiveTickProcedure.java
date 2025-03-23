package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import java.util.List;

public class GojoImbuedPowerOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        double timer2 = 0;
        double sev = 0;
        double sevx = 0;
        double sevy = 0;
        double sevz = 0;
        double tedx = 0;
        double tedy = 0;
        double tedz = 0;
        double sevx2 = 0;
        double sevy2 = 0;
        double sevz2 = 0;
        double a = 0;
        double ted = 0;
        double sev2 = 0;
        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2) {
            if (!(entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain) {
                if (entity instanceof ServerPlayer _plr1 && _plr1.level() instanceof ServerLevel
                        && _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:gojo_training_part_3"))).isDone()) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("PRESS_Z");
                        }
                    }.getValue() == 1) {
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == 207) {
                            if (entity.isShiftKeyDown()) {
                                if (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex = new CompoundTag();
                                        entity.saveWithoutId(dataIndex);
                                        return dataIndex.getCompound("ForgeData").getDouble("cnt6");
                                    }
                                }.getValue() >= 1) {
                                    {
                                        final Vec3 _center = new Vec3(x, y, z);
                                        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                                                .toList();
                                        for (Entity entityiterator : _entfound) {
                                            if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals("jujutsucraft:red")) {
                                                if ((new Object() {
                                                    public String getValue() {
                                                        CompoundTag dataIndex = new CompoundTag();
                                                        entityiterator.saveWithoutId(dataIndex);
                                                        return dataIndex.getCompound("ForgeData").getString("OWNER_UUID");
                                                    }
                                                }.getValue()).equals(entity.getStringUUID())) {
                                                    if (!(entityiterator instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(JujutsucraftaddonModMobEffects.RED_EFFECT.get()))) {
                                                        if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.RED_EFFECT.get(), 400, 1, false, false));
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
            } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain) {
                if (entity instanceof ServerPlayer _plr12 && _plr12.level() instanceof ServerLevel
                        && _plr12.getAdvancements().getOrStartProgress(_plr12.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:gojo_training_part_4"))).isDone()) {
                    if (!entity.isShiftKeyDown()) {
                        if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
                                .equals(Component.translatable("jujutsu.technique.purple").getString())) {
                            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel >= 4) {
                                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.PlayerSelectCurseTechniqueName = (Component.translatable("dialoguepurple").getString());
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        }
                    }
                    if (entity.isShiftKeyDown()) {
                        if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
                                .equals(Component.translatable("jujutsu.technique.blue").getString())
                                || ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
                                .equals(Component.translatable("dialoguepurple").getString())) {
                            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel >= 5) {
                                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.PlayerSelectCurseTechniqueName = (Component.translatable("dialogueun").getString());
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        }
                    }
                }
                if (entity instanceof ServerPlayer _plr25 && _plr25.level() instanceof ServerLevel
                        && _plr25.getAdvancements().getOrStartProgress(_plr25.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:gojo_training_part_3"))).isDone()) {
                    if (entity.isShiftKeyDown()) {
                        if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
                                .equals(Component.translatable("jujutsu.technique.blue").getString())) {
                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.PlayerSelectCurseTechniqueName = (Component.translatable("dialogueblue").getString());
                                capability.syncPlayerVariables(entity);
                            });
                        }
                    }
                }
            }
        }
    }
}
