package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import java.util.List;

public class WorldSlashProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        double timer = 0;
        if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_OVERPOWERED_STUFF)) {
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).WorldSlash) {
                if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:sukuna_body_chestplate")
                        || (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftaddonModMobEffects.BINDING_VOW.get()) ? _livEnt.getEffect(JujutsucraftaddonModMobEffects.BINDING_VOW.get()).getAmplifier() : 0) <= 4
                        || (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.SUKUNA_ARMOR_THREE_CHESTPLATE.get()) {
                    if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
                            .equals(Component.translatable("jujutsu.technique.dismantle").getString())) {
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.PlayerSelectCurseTechniqueName = (Component.translatable("dialoguews").getString());
                            capability.syncPlayerVariables(entity);
                        });
                    }
                    if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
                            .equals(Component.translatable("jujutsu.technique.open").getString())) {
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.PlayerSelectCurseTechniqueName = (Component.translatable("dialoguekamino").getString());
                            capability.syncPlayerVariables(entity);
                        });
                    }
                    if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel >= 5) {
                        if (entity.getPersistentData().getDouble("PRESS_Z") == 1) {
                            if (entity.getPersistentData().getDouble("skill") == 107) {
                                if (entity.getPersistentData().getDouble("cnt6") >= 5) {
                                    if (entity.getPersistentData().getDouble("cnt6") <= 30) {
                                        entity.getPersistentData().putDouble("cnt6", (entity.getPersistentData().getDouble("cnt6") + 1));
                                    }
                                }
                            }
                            if (entity.getPersistentData().getDouble("skill") == 105) {
                                if (entity.getPersistentData().getDouble("cnt6") >= 5) {
                                    if (entity.getPersistentData().getDouble("cnt6") <= 50) {
                                        entity.getPersistentData().putDouble("cnt6", (entity.getPersistentData().getDouble("cnt6") + 1));
                                    }
                                    if (entity.getPersistentData().getDouble("cnt6") >= 50) {
                                        if (!(entity.getPersistentData().getDouble("brokenBrain") == 2)) {
                                            entity.getPersistentData().putDouble("brokenBrain", 2);
                                        }
                                        {
                                            final Vec3 _center = new Vec3(x, y, z);
                                            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                                                    .toList();
                                            for (Entity entityiterator : _entfound) {
                                                if (!(entityiterator == entity)) {
                                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                                        _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1200, 254, false, false));
                                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 254, false, false));
                                                    if (entityiterator instanceof LivingEntity _entity)
                                                        _entity.removeEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get());
                                                    if (entityiterator instanceof LivingEntity _entity)
                                                        _entity.removeEffect(JujutsucraftModMobEffects.INFINITY_EFFECT.get());
                                                    if (entityiterator instanceof LivingEntity _entity)
                                                        _entity.removeEffect(JujutsucraftModMobEffects.INFINITY_EFFECT.get());
                                                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.NEUTRALIZATION.get(), 100000,
                                                                (entity instanceof LivingEntity && ((LivingEntity) entityiterator).hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get())
                                                                        ? ((LivingEntity) entityiterator).getEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier()
                                                                        : 0) + 255,
                                                                false, true));
                                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.UNSTABLE.get(), 10000,
                                                                (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.UNSTABLE.get())
                                                                        ? _livEnt.getEffect(JujutsucraftModMobEffects.UNSTABLE.get()).getAmplifier()
                                                                        : 0) + 2,
                                                                false, false));
                                                    if (entityiterator instanceof LivingEntity _entity)
                                                        _entity.removeEffect(MobEffects.DAMAGE_RESISTANCE);
                                                    if (entityiterator instanceof LivingEntity _entity)
                                                        _entity.removeEffect(MobEffects.DAMAGE_RESISTANCE);
                                                    {
                                                        double _setval = 1;
                                                        entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                                            capability.OutputLevel = _setval;
                                                            capability.syncPlayerVariables(entity);
                                                        });
                                                    }
                                                    {
                                                        boolean _setval = false;
                                                        entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                                            capability.WorldSlash = _setval;
                                                            capability.syncPlayerVariables(entity);
                                                        });
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (entity.getPersistentData().getDouble("PRESS_Z") == 0) {
                            if (entity.getPersistentData().getDouble("cnt6") >= 5) {
                                if (entity.getPersistentData().getDouble("cnt6") >= 30) {
                                    {
                                        Entity _ent = entity;
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                            _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                    "execute as @s run effect give @s jujutsucraft:unstable 150 2 true");
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
