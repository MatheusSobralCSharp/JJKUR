package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.CloneEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;

public class CloneChanger {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
                    if (!(entityiterator instanceof CloneEntity _datEntL1 && _datEntL1.getEntityData().get(CloneEntity.ATTACK_MODE))) {
                        if (entity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Offensive Mode"), false);
                        if (entityiterator instanceof CloneEntity _datEntSetL)
                            _datEntSetL.getEntityData().set(CloneEntity.ATTACK_MODE, true);
                    } else {
                        if (entity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Skill Mode"), false);
                        if (entityiterator instanceof CloneEntity _datEntSetL)
                            _datEntSetL.getEntityData().set(CloneEntity.ATTACK_MODE, false);
                    }
                }
            }
        }
    }

}
