package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.entity.GojoSatoruSchoolDaysEntity;
import net.mcreator.jujutsucraft.procedures.KeyStartTechniqueOnKeyPressedProcedure;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.fml.ModList;

public class MurasakiEffectOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;

        if (((LivingEntity) entity).hasEffect(JujutsucraftaddonModMobEffects.SOKA_MONA.get())) {
           if (entity instanceof GojoSatoruSchoolDaysEntity) {
               if (!((((GojoSatoruSchoolDaysEntity) entity).animationprocedure).equals("soka"))) {
                   ((GojoSatoruSchoolDaysEntity) entity).setAnimation("soka");
               }
           }
           return;
        } else if (!(((LivingEntity) entity).hasEffect(JujutsucraftaddonModMobEffects.SOKA_MONA.get()))) {
            if (!ModList.get().isLoaded("jjkueffects")) {
                if (world instanceof ServerLevel _level)
                    _level.sendParticles(ParticleTypes.WITCH, x, (y + 1), z, 5, 1, 1, 1, 0.1);
            }

            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("cnt6");
                }
            }.getValue() <= 6) {
                {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("cnt6", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("cnt6");
                        }
                    }.getValue() + 1));
                    entity.load(dataIndex);
                }
            }
            {
                Entity _ent = entity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                            _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run stopsound @a * jujutsucraft:electric_shock");
                }
            }
            if (Math.random() < (1) / ((float) 20)) {
                {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "particle jjkueffects:aura_gojo_3 ~ ~ ~ 0 0 0 1 1 force");
                    }
                }
            }
            KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
        }
    }
}
