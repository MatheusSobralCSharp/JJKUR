package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;

public class TsukumoExtensionProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        double cooldown = 0;
        if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Attack")) {
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.PlayerSelectCurseTechniqueName = "Mass Punch";
                capability.syncPlayerVariables(entity);
            });
        } else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Mass Punch")) {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex3 = new CompoundTag();
                    entity.saveWithoutId(dataIndex3);
                    return dataIndex3.getCompound("ForgeData").getDouble("skill");
                }
            }.getValue() > 0) {
                Tsukumo1Procedure.execute(world, x, y, z, entity);
            }
        }
        if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Knockback Attack")) {
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.PlayerSelectCurseTechniqueName = "Mass Ground Breaker";
                capability.syncPlayerVariables(entity);
            });
        } else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Mass Ground Breaker")) {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex7 = new CompoundTag();
                    entity.saveWithoutId(dataIndex7);
                    return dataIndex7.getCompound("ForgeData").getDouble("skill");
                }
            }.getValue() > 0) {
                {
                    final Vec3 _center = new Vec3(x, y, z);
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                    for (Entity entityiterator : _entfound) {
                        if (!(entity == entityiterator)) {
                            if (cooldown == 0) {
                                if (world instanceof Level _level && !_level.isClientSide())
                                    _level.explode(null, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 7, Level.ExplosionInteraction.MOB);
                                cooldown = 40;
                            } else if (cooldown > 0) {
                                cooldown = cooldown - 1;
                            }
                        }
                    }
                }
                entity.setInvulnerable(true);
            } else if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex15 = new CompoundTag();
                    entity.saveWithoutId(dataIndex15);
                    return dataIndex15.getCompound("ForgeData").getDouble("skill");
                }
            }.getValue() == 0) {
                entity.setInvulnerable(false);
            }
        }
        if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Barrage Attack")) {
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.PlayerSelectCurseTechniqueName = "Mass Black Hole Barrage";
                capability.syncPlayerVariables(entity);
            });
        } else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Mass Black Hole Barrage")) {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex20 = new CompoundTag();
                    entity.saveWithoutId(dataIndex20);
                    return dataIndex20.getCompound("ForgeData").getDouble("skill");
                }
            }.getValue() > 0) {
                Tsukumo2Procedure.execute(world, x, y, z, entity);
            }
        }
    }
}
