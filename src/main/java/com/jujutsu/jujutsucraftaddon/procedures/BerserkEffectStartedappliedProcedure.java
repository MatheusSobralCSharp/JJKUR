package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.animatable.GeoEntity;

public class BerserkEffectStartedappliedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        entity.getPersistentData().putDouble("cnt_t", 0);


        if (!(entity instanceof GeoEntity)) {
            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:tojivsdagonvsyujivsmahito")), SoundSource.MUSIC, 1, 1);
                } else {
                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:tojivsdagonvsyujivsmahito")), SoundSource.MUSIC, 1, 1, false);
                }
            }
            if (world instanceof ServerLevel) {
                if (entity instanceof LivingEntity _livingEntity) {
                    MobEffectInstance currentEffect = _livingEntity.getEffect(MobEffects.DAMAGE_BOOST); // Check if the entity already has Strength
                    int newAmplifier = 0; // Default amplifier if no effect exists

                    if (currentEffect != null) {
                        // Increment the current amplifier by 1
                        newAmplifier = currentEffect.getAmplifier() + 21;
                    }

                    // Reapply the Strength effect with the new amplifier
                    _livingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, newAmplifier, false, false));
                    _livingEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 3600, 3, false, false));
                }
            }
        }
    }
}
