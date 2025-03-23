package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class WorldCutOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Moveset == 2
                || (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Moveset == 3) {
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel <= 3) {
                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CustceneDone < 3) {
                    ResourceKey<DamageType> damageTypeKey = ResourceKey.create(
                            Registries.DAMAGE_TYPE,
                            new ResourceLocation("jujutsucraft:start_animation")
                    );

                    DamageSource damageSource = new DamageSource(
                            world.registryAccess()
                                    .registryOrThrow(Registries.DAMAGE_TYPE)
                                    .getHolderOrThrow(damageTypeKey)
                    );

                    entity.hurt(damageSource, 1.0F);

                    {
                        double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CustceneDone + 1;
                        entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.CustceneDone = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                }

            } else {
                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CustceneDone < 3) {
                    ResourceKey<DamageType> damageTypeKey = ResourceKey.create(
                            Registries.DAMAGE_TYPE,
                            new ResourceLocation("jujutsucraft:start_animation")
                    );

                    DamageSource damageSource = new DamageSource(
                            world.registryAccess()
                                    .registryOrThrow(Registries.DAMAGE_TYPE)
                                    .getHolderOrThrow(damageTypeKey)
                    );

                    entity.hurt(damageSource, 1.0F);

                    {
                        double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CustceneDone + 1;
                        entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.CustceneDone = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                }
            }
        } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Moveset == 1) {
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CustceneDone < 3) {
                ResourceKey<DamageType> damageTypeKey = ResourceKey.create(
                        Registries.DAMAGE_TYPE,
                        new ResourceLocation("jujutsucraft:start_animation")
                );

                DamageSource damageSource = new DamageSource(
                        world.registryAccess()
                                .registryOrThrow(Registries.DAMAGE_TYPE)
                                .getHolderOrThrow(damageTypeKey)
                );

                entity.hurt(damageSource, 1.0F);

                {
                    double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CustceneDone + 1;
                    entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.CustceneDone = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
            }
        } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Moveset == 4) {
            WorldSlashVariantsProcedure.execute(world, x, y, z, entity);
        }
        WorldCutEffectStartedappliedProcedure.execute(entity);
    }
}
