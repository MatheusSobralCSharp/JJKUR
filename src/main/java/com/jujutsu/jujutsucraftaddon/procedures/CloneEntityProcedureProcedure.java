package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.LevelAccessor;

public class CloneEntityProcedureProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == null)) {
            if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MobEffects.DAMAGE_BOOST))) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
                            (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0,
                            false, false));
            }
            if (!(entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(MobEffects.DAMAGE_RESISTANCE))) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1,
                            (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)
                                    ? _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier()
                                    : 0,
                            false, false));
            }
            if (!(entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(MobEffects.MOVEMENT_SPEED)) && (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _livEnt12
                    && _livEnt12.hasEffect(MobEffects.MOVEMENT_SPEED)) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20,
                            (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SPEED)
                                    ? _livEnt.getEffect(MobEffects.MOVEMENT_SPEED).getAmplifier()
                                    : 0,
                            false, false));
            }
            if (!(entity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(MobEffects.HEALTH_BOOST))) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, -1,
                            (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HEALTH_BOOST) ? _livEnt.getEffect(MobEffects.HEALTH_BOOST).getAmplifier() : 0,
                            false, false));
            }
//        } else if ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == null) {
//            CloneTestProcedure.execute(world, entity);
//        }
//        if (entity instanceof CloneEntity _datEntL0 && _datEntL0.getEntityData().get(CloneEntity.ATTACK_MODE) == true) {
//            return;
//        } else if (entity instanceof CloneEntity _datEntL0 && _datEntL0.getEntityData().get(CloneEntity.ATTACK_MODE) == false)  {
//            CloneEntityAIProcedure.execute(world, entity);
//        } else if (entity instanceof FakeClonesEntity) {
//            CloneEntityAIProcedure.execute(world, entity);
        }
    }
}
