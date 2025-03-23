package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.PartialRikaEntity;
import net.mcreator.jujutsucraft.entity.Rika2Entity;
import net.mcreator.jujutsucraft.entity.RikaEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

import java.util.UUID;
import java.util.function.BiFunction;

public class LocatePartialSource {
    public static boolean execute(LevelAccessor world, Entity sourceentity) {
        if (sourceentity == null) {
            return false;
        } else {
            boolean logic_a = false;
            boolean pitch = false;
            double dis = 0.0;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double yaw = 0.0;
            double picth = 0.0;
            double yaw2 = 0.0;
            double pitch2 = 0.0;
            double HP = 0.0;
            Entity entity_rika = null;
            logic_a = false;
            if (sourceentity.getPersistentData().getDouble("friend_num") != 0.0) {
                entity_rika = (new BiFunction<LevelAccessor, String, Entity>() {
                    public Entity apply(LevelAccessor levelAccessor, String uuid) {
                        if (levelAccessor instanceof ServerLevel serverLevel) {
                            try {
                                return serverLevel.getEntity(UUID.fromString(uuid));
                            } catch (Exception var5) {
                            }
                        }

                        return null;
                    }
                }).apply(world, sourceentity.getPersistentData().getString("RIKA_UUID"));
                if ((entity_rika instanceof RikaEntity || entity_rika instanceof Rika2Entity || entity_rika instanceof PartialRikaEntity) && sourceentity.getPersistentData().getDouble("friend_num") == entity_rika.getPersistentData().getDouble("friend_num")) {
                    logic_a = true;
                }
            }

            return logic_a;
        }

    }


}
