package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class BlackHoleSpawnProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (world instanceof ServerLevel _serverLevel) {
            Entity entitytospawn = JujutsucraftModEntities.BLACK_HOLE.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entitytospawn != null) {
                entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                (entitytospawn).getPersistentData().putDouble("cnt6", 30);
                (entitytospawn).getPersistentData().putDouble("skill", 915);
                (entitytospawn).getPersistentData().putDouble("Ult", 1);
                (entitytospawn).getPersistentData().putDouble("NameRanged_ranged", Math.random());
                (entitytospawn).getPersistentData().putDouble("friend_num", Math.random());
                (entitytospawn).getPersistentData().putBoolean("circle", true);
                (entitytospawn).getPersistentData().putBoolean("flag_start", true);
                (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                if ((entitytospawn) instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                    _livingEntity18.getAttribute(Attributes.MAX_HEALTH).setBaseValue(600);
                if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(
                            new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
                if ((entitytospawn) instanceof LivingEntity _entity)
                    _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(8);
                _serverLevel.addFreshEntity(entitytospawn);
            }
        }
    }
}
