package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import java.util.List;

public class KenjakuDomainSummoningProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (!(entity.getPersistentData().getString("OWNER_UUID")).equals("")) {
            {
                final Vec3 _center = new Vec3(x, y, z);
                List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                for (Entity entityiterator : _entfound) {
                    if (!(entityiterator == entity)) {
                        if (entityiterator.isShiftKeyDown()) {
                            if (((entityiterator.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Kenjaku")) {
                                if ((entity.getPersistentData().getString("OWNER_UUID")).equals(entityiterator.getStringUUID())) {
                                    if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:hanami")) {
                                        {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            dataIndex.getCompound("ForgeData").putDouble("skill", 1420);
                                            entity.load(dataIndex);
                                        }
                                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 1000,
                                                    (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())
                                                            ? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier()
                                                            : 0) + 1,
                                                    false, false));
                                        {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 1);
                                            entity.load(dataIndex);
                                        }
                                    } else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:cursed_spirit_grade_05")) {
                                        {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            dataIndex.getCompound("ForgeData").putDouble("skill", 2520);
                                            entity.load(dataIndex);
                                        }
                                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 1000,
                                                    (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())
                                                            ? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier()
                                                            : 0) + 1,
                                                    false, false));
                                        {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 1);
                                            entity.load(dataIndex);
                                        }
                                    } else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:dagon_2")) {
                                        {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            dataIndex.getCompound("ForgeData").putDouble("skill", 820);
                                            entity.load(dataIndex);
                                        }
                                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 1000,
                                                    (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())
                                                            ? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier()
                                                            : 0) + 1,
                                                    false, false));
                                        {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 1);
                                            entity.load(dataIndex);
                                        }
                                    } else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:mahito")) {
                                        {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            dataIndex.getCompound("ForgeData").putDouble("skill", 1520);
                                            entity.load(dataIndex);
                                        }
                                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 1000,
                                                    (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())
                                                            ? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier()
                                                            : 0) + 1,
                                                    false, false));
                                        {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 1);
                                            entity.load(dataIndex);
                                        }
                                    } else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:jogo")) {
                                        {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            dataIndex.getCompound("ForgeData").putDouble("skill", 420);
                                            entity.load(dataIndex);
                                        }
                                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 1000,
                                                    (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())
                                                            ? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier()
                                                            : 0) + 1,
                                                    false, false));
                                        {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 1);
                                            entity.load(dataIndex);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
