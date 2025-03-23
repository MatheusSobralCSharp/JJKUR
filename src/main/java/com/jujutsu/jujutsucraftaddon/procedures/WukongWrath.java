package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;

public class WukongWrath {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (!(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)) {
                    if (entityiterator != entity && entityiterator instanceof LivingEntity _entity){
                        MobEffectInstance currentEffect = _entity.getEffect(MobEffects.WEAKNESS);
                        int currentAmplifier = 0;

                        // If the Weakness effect exists, get its current amplifier and increment it by 1
                        if (currentEffect != null && currentEffect.getAmplifier() < 50) {
                            currentAmplifier = currentEffect.getAmplifier() + 1;
                        }


                         _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1200, currentAmplifier));


                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 60, 0));
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.UNSTABLE.get(), 60, 0));
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.FATIGUE.get(), 1200, 0));

                        if (world instanceof Level _level && !_level.isClientSide()) {
                            _level.explode(_entity, _entity.getX(), _entity.getY(), _entity.getZ(), 4, true, Level.ExplosionInteraction.TNT);
                        }


                        if (Math.random() < (1) / ((float) 2)) {
                            _entity.removeEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                        }
                    }

                }
            }
        }
    }

}
