package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import java.util.List;

public class ProcedureGetoProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (!(entityiterator == entity)) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entityiterator.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("CursedSpirit");
                        }
                    }.getValue() == 1 && (new Object() {
                        public String getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entityiterator.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getString("OWNER_UUID");
                        }
                    }.getValue()).equals(entity.getStringUUID()) && !(new Object() {
                        public boolean getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entityiterator.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getBoolean("Buffed");
                        }
                    }.getValue())) {
                        ((LivingEntity) entityiterator).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
                                .setBaseValue((((LivingEntity) entityiterator).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() * 2));
                        if (entityiterator instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
                            _livingEntity8.getAttribute(Attributes.MAX_HEALTH).setBaseValue(
                                    ((entityiterator instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity7.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) * 5));
                        {
                            Entity _ent = entityiterator;
                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                        _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s unless predicate jujutsucraftaddon:effects/orca/sixeyes run jjc_cursepower -500 @s");
                            }
                        }
                        if (entityiterator instanceof LivingEntity _entity)
                            _entity.setHealth(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
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
