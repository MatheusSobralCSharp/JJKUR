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
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class NishimiyaReleaseProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (world instanceof ServerLevel _serverLevel) {
            Entity entitytospawn = JujutsucraftModEntities.ENTITY_TORNADO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entitytospawn != null) {
                entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                (entitytospawn).getPersistentData().putString("OWNER_UUID", (entity.getStringUUID()));
                ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(10);
                (entitytospawn).getPersistentData().putDouble("cnt6", 60);
                (entitytospawn).getPersistentData().putDouble("skill", 3610);
                (entitytospawn).getPersistentData().putDouble("NameRanged_ranged", Math.random());
                (entitytospawn).getPersistentData().putDouble("friend_num", Math.random());
                (entitytospawn).getPersistentData().putDouble("x_power", (entity.getLookAngle().x * 6));
                (entitytospawn).getPersistentData().putDouble("y_power", (entity.getLookAngle().y * 6));
                (entitytospawn).getPersistentData().putDouble("z_power", (entity.getLookAngle().z * 6));
                if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(
                            new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
                _serverLevel.addFreshEntity(entitytospawn);
            }
        }
    }
}
