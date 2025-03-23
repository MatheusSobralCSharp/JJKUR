package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class ChosoExtensionProcedure {
    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        double Grow = 0;
        double TrackZ = 0;
        double TrackY = 0;
        double TrackX = 0;
        if (!(ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).startsWith("jujutsucraft")) {
            if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 10) {
                if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("skill");
                        }
                    }.getValue() == 0 && new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("skill_domain");
                        }
                    }.getValue() == 0) {
                        if (Math.random() < 0.06) {
                            TrackX = sourceentity.getX() - entity.getX();
                            TrackY = sourceentity.getY() - entity.getY() + sourceentity.getBbHeight() * 0.75 - entity.getBbHeight() * 0.75;
                            TrackZ = sourceentity.getZ() - entity.getZ();
                            Grow = 1;
                            for (int index0 = 0; index0 < 20; index0++) {
                                if (world instanceof ServerLevel _level)
                                    _level.sendParticles(JujutsucraftaddonModParticleTypes.BLOOD_RED.get(), (entity.getX() + TrackX * Grow), (entity.getY() + entity.getBbHeight() * 0.75 + TrackY * Grow),
                                            (entity.getZ() + TrackZ * Grow), 5, 0.15, 0.15, 0.15, 0);
                                Grow = Grow - 0.05;
                            }
                            if (world instanceof Level _level && !_level.isClientSide())
                                _level.explode(null, (entity.getX()), (entity.getY() + 1), (entity.getZ()), 4, Level.ExplosionInteraction.NONE);
                            {
                                Entity _ent = entity;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                            4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cancel_cursed_technique 2 1 true");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
