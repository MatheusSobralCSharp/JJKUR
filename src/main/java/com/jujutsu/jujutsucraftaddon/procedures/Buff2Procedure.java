package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import java.util.List;

public class Buff2Procedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        boolean megumi = false;
        boolean geto = false;
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if ((new Object() {
                    public String getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entityiterator.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getString("OWNER_UUID");
                    }
                }.getValue()).equals(entity.getStringUUID()) || (entityiterator.getPersistentData().getString("OWNER_UUID")).equals(entity.getStringUUID())) {
                    if (!(new Object() {
                        public boolean getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entityiterator.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getBoolean("Buffed");
                        }
                    }.getValue())) {
                        if (entityiterator instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                            _livingEntity6.getAttribute(Attributes.MAX_HEALTH).setBaseValue(
                                    ((entityiterator instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity5.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) * 5));
                        if (entityiterator instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
                            _livingEntity8.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(
                                    ((entityiterator instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity7.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0) * 3.5));
                        if (entityiterator instanceof LivingEntity _entity)
                            _entity.setHealth(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        ((LivingEntity) entityiterator).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
                                .setBaseValue((((LivingEntity) entityiterator).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() * 2));
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            entityiterator.saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putBoolean("Buffed", true);
                            entityiterator.load(dataIndex);
                        }
                    }
                }
            }
        }
    }
}
