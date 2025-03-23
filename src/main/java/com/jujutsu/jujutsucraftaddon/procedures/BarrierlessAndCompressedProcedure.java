package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class BarrierlessAndCompressedProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 1) {
            if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 1) {
                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).DomainType == 2) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("select");
                        }
                    }.getValue() > 0) {
                        if (entity.getPersistentData().getDouble("cnt3") >= 20) {
                            if (entity.getPersistentData().getDouble("cnt2") != 1) {
                                JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = 40;
                                JujutsucraftModVariables.MapVariables.get(world).syncData(world);
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("Range", 120);
                                    entity.load(dataIndex);
                                }
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("cnt2", 1);
                                    entity.load(dataIndex);
                                }
                                entity.getPersistentData().putDouble("Range", 120);
                                entity.getPersistentData().putDouble("cnt2", 1);
                            }
                        }
                    }
                } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).DomainType == 1) {
                    if (!((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()))) {
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("select");
                            }
                        }.getValue() > 0) {
                            JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = 12;
                            JujutsucraftModVariables.MapVariables.get(world).syncData(world);
                            if (!(new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("x_pos_doma");
                                }
                            }.getValue() == entity.getX())) {
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("x_pos_doma", (entity.getX()));
                                    entity.load(dataIndex);
                                }
                            }
                            if (!(new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("z_pos_doma");
                                }
                            }.getValue() == entity.getZ())) {
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("z_pos_doma", (entity.getZ()));
                                    entity.load(dataIndex);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
