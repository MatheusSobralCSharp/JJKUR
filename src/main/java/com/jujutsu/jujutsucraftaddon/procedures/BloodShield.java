package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;

public class BloodShield {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        double timerce = 0;
        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower > 400) {
            entity.getPersistentData().putDouble("Tag1", 1.5);
            entity.getPersistentData().putDouble("Tag2", 0);
            entity.getPersistentData().putDouble("Tag3", 90);
            if (world instanceof ServerLevel) {
                for (int index0 = 0; index0 < 30; index0++) {
                    for (int index1 = 0; index1 < 16; index1++) {
                        world.addParticle(JujutsucraftaddonModParticleTypes.BLOOD_RED.get(),
                                (x - entity.getPersistentData().getDouble("Tag1") * Math.cos(Math.toRadians(entity.getPersistentData().getDouble("Tag3"))) * Math.sin(Math.toRadians(entity.getPersistentData().getDouble("Tag2")))),
                                ((y + 1) - 1.5 * Math.sin(Math.toRadians(entity.getPersistentData().getDouble("Tag3")))),
                                (z + entity.getPersistentData().getDouble("Tag1") * Math.cos(Math.toRadians(entity.getPersistentData().getDouble("Tag3"))) * Math.cos(Math.toRadians(entity.getPersistentData().getDouble("Tag2")))), 0, 0, 0);
                        entity.getPersistentData().putDouble("Tag3", (entity.getPersistentData().getDouble("Tag3") + 12));
                    }
                    entity.getPersistentData().putDouble("Tag3", 90);
                    entity.getPersistentData().putDouble("Tag2", (entity.getPersistentData().getDouble("Tag2") + 12));
                }
            }

            {
                final Vec3 _center = new Vec3(x, (y + 1), z);
                List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                for (Entity entityiterator : _entfound) {
                    if (!(entityiterator == entity)) {
                        entityiterator.setDeltaMovement(new Vec3(((-1.5) * entityiterator.getDeltaMovement().x()), ((-1.5) * entityiterator.getDeltaMovement().y()), ((-1.5) * entityiterator.getDeltaMovement().z())));
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 254));
                        if (entityiterator instanceof LivingEntity _entity)
                            _entity.setHealth((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - Mth.nextInt(RandomSource.create(), 0, 1));
                    }
                }
            }
            if (Math.random() < (1) / ((float) 100)) {
                if (!((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Death Painting")) {
                    {
                        Entity _ent = entity;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                    4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run jjc_cursepower -100 @s");
                        }
                    }
                } else if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Death Painting")) {
                    {
                        Entity _ent = entity;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                    4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run jjc_cursepower -50 @s");
                        }
                    }
                }
            }
        }
    }
}
