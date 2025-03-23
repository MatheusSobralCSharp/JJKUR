package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class SunWukongDefense {
    public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        double cooldown1 = 0;
        if (itemstack.getOrCreateTag().getDouble("Regen") == 0) {
            if (entity instanceof LivingEntity _entity1 && !_entity1.level().isClientSide())
                _entity1.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get(), 60, 4, false, false));
            if (entity instanceof LivingEntity _entity1 && !_entity1.level().isClientSide())
                _entity1.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 4, false, false));
            itemstack.getOrCreateTag().putDouble("Regen", 300);
        } else {
            itemstack.getOrCreateTag().putDouble("Regen", (itemstack.getOrCreateTag().getDouble("Regen") - 1));
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("RikaRing");
            }
        }.getValue() == 0) {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("RikaRing", 1);
                entity.load(dataIndex);
            }
        }

    }
}
