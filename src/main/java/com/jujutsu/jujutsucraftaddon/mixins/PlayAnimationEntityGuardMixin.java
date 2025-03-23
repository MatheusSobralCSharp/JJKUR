package com.jujutsu.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.LogicSwordProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationEntityGuardProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import software.bernie.geckolib.animatable.GeoEntity;

@Mixin(value = PlayAnimationEntityGuardProcedure.class, priority = -10000)
public abstract class PlayAnimationEntityGuardMixin {

    /**
     * @author Satushi
     * @reason Changes playing Animations
     */

    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, Entity entityiterator, CallbackInfo ci) {
        ci.cancel();
        boolean sword = false;
        if (entityiterator != null) {
            Entity entity_a = null;
            entity_a = entityiterator;
            if (entity_a instanceof LivingEntity) {
                LivingEntity _livEnt0 = (LivingEntity)entity_a;
                if (_livEnt0.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                    return;
                }
            }

            if (entity_a.getPersistentData().getDouble("skill") == 0.0) {
                sword = LogicSwordProcedure.execute(entity_a);
                LivingEntity _livingEntity8;
                if (!(entity_a instanceof Player) && !(entity_a instanceof GeoEntity)) {
                    if (entity_a instanceof LivingEntity) {
                        _livingEntity8 = (LivingEntity)entity_a;
                        _livingEntity8.swing(InteractionHand.MAIN_HAND, true);
                    }
                } else {
                    if (entity_a instanceof Player && entity_a instanceof LivingEntity) {
                        _livingEntity8 = (LivingEntity)entity_a;
                        _livingEntity8.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if (sword) {
                        if (entity_a instanceof LivingEntity) {
                            _livingEntity8 = (LivingEntity)entity_a;
                            if (_livingEntity8.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                                _livingEntity8.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(100.0);
                            }
                        }

                        if (entity_a instanceof LivingEntity) {
                            _livingEntity8 = (LivingEntity)entity_a;
                            if (_livingEntity8.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                                _livingEntity8.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue((double) Mth.nextInt(RandomSource.create(), 0, 100));
                            }
                        }
                    } else if (entity_a instanceof LivingEntity) {
                        _livingEntity8 = (LivingEntity)entity_a;
                        if (_livingEntity8.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                            _livingEntity8.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-9.0);
                        }
                    }

                    PlayAnimationProcedure.execute(world, entity_a);
                }
            }

        }
    }
}
