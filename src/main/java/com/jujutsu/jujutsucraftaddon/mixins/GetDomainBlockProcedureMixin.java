package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.entity.ItadoriShinjukuEntity;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.GetDomainBlockProcedure;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GetDomainBlockProcedure.class, priority = -10000)
public abstract class GetDomainBlockProcedureMixin {

    /**
     * @author Satushi
     * @reason Adds the domain block of itadori's domain and let it work
     */

    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            double var10000;
            String outside;
            String inside;
            String floor;
            double domain_num;
            double close_type;
            label133:
            {
                boolean noBarrier = false;
                outside = "";
                inside = "";
                floor = "";
                domain_num = 0.0;
                close_type = 0.0;
                domain_num = entity.getPersistentData().getDouble("select") > 0.0 ? entity.getPersistentData().getDouble("select") : entity.getPersistentData().getDouble("skill_domain");
                if (entity instanceof LivingEntity _livEnt3) {
                    if (_livEnt3.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        if (entity instanceof LivingEntity _livEnt) {
                            if (_livEnt.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                var10000 = _livEnt.getEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                break label133;
                            }
                        }

                        var10000 = 0.0;
                        break label133;
                    }
                }

                var10000 = entity.getPersistentData().getDouble("cnt2");
            }

            close_type = var10000;
            outside = "jujutsucraft:jujutsu_barrier";
            inside = "jujutsucraft:block_universe";
            floor = "jujutsucraft:block_universe";
            if (domain_num <= 10.0) {
                if (domain_num == 1.0) {
                    if ((((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Death Painting") && ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Itadori") && (entity instanceof ServerPlayer _plr25 && _plr25.level() instanceof ServerLevel
                            && _plr25.getAdvancements().getOrStartProgress(_plr25.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:soul_research"))).isDone() && entity instanceof ServerPlayer _plr26
                            && _plr26.level() instanceof ServerLevel && _plr26.getAdvancements().getOrStartProgress(_plr26.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:enchained"))).isDone())) || entity instanceof ItadoriShinjukuEntity) {

                        inside = "jujutsucraftaddon:snow_domain";
                        floor = "jujutsucraftaddon:snow_domain";
                        outside = "jujutsucraftaddon:snow_domain";

                    } else {
                        inside = "jujutsucraft:domain_bone";
                        floor = "jujutsucraft:block_red";
                        outside = "jujutsucraft:jujutsu_barrier";
                    }
                } else if (domain_num == 2.0) {
                    inside = "jujutsucraft:block_universe";
                    floor = "jujutsucraft:block_universe";
                } else if (domain_num == 3.0) {
                    inside = "jujutsucraft:domain_blue_sky";
                } else if (domain_num == 4.0) {
                    inside = "jujutsucraft:coffinofthe_ironmountain_1";
                    floor = "jujutsucraft:coffinofthe_ironmountain_2";
                } else if (domain_num == 5.0) {
                    floor = "jujutsucraft:block_gravel";
                } else if (domain_num == 6.0) {
                    inside = "jujutsucraft:block_universe";
                    floor = "jujutsucraft:block_universe";
                } else if (domain_num == 7.0) {
                    inside = "jujutsucraft:domain_cloud";
                    floor = "jujutsucraft:domain_cloud";
                } else if (domain_num == 8.0) {
                    inside = "jujutsucraft:domain_blue_sky";
                    floor = "jujutsucraft:domain_sand";
                } else if (domain_num == 9.0) {
                    floor = "jujutsucraft:domain_sand";
                } else if (domain_num == 10.0) {
                    inside = "jujutsucraft:domain_blood";
                    floor = "jujutsucraft:domain_blood";
                }
            } else if (domain_num <= 20.0) {
                if (domain_num == 11.0) {
                    inside = "jujutsucraft:domain_cloud";
                    floor = "jujutsucraft:domain_podzol";
                } else if (domain_num == 12.0) {
                    inside = "jujutsucraft:block_red";
                    floor = "jujutsucraft:domain_sand";
                } else if (domain_num == 13.0) {
                    floor = "jujutsucraft:domain_stone_bricks";
                } else if (domain_num == 14.0) {
                    inside = "jujutsucraft:domain_blue_sky";
                    floor = "jujutsucraft:domain_flower";
                } else if (domain_num == 15.0) {
                    inside = "jujutsucraft:domain_bone";
                } else if (domain_num == 16.0) {
                    inside = "jujutsucraft:block_universe";
                } else if (domain_num == 18.0) {
                    inside = "jujutsucraft:domain_blood";
                    floor = "jujutsucraft:block_red";
                } else if (domain_num == 20.0) {
                    inside = "jujutsucraft:domain_flower";
                    floor = "jujutsucraft:domain_blue_sky";
                }
            } else if (domain_num <= 30.0) {
                if (domain_num == 21.0) {
                    inside = "jujutsucraft:domain_blue_sky";
                    floor = "jujutsucraft:domain_grass";
                } else if (domain_num == 22.0) {
                    floor = "jujutsucraft:block_universe";
                } else if (domain_num == 23.0) {
                    inside = "jujutsucraft:domain_bone";
                    floor = "jujutsucraft:block_red";
                } else if (domain_num == 24.0) {
                    inside = "jujutsucraft:domain_ice";
                    floor = "jujutsucraft:domain_ice";
                } else if (domain_num == 25.0) {
                    floor = "jujutsucraft:block_gravel";
                } else if (domain_num == 26.0) {
                    floor = "jujutsucraft:block_gravel";
                } else if (domain_num == 27.0) {
                    floor = "jujutsucraft:domain_planks";
                } else if (domain_num == 28.0) {
                    inside = "jujutsucraft:domain_blue_sky";
                    floor = "jujutsucraft:domain_cloud";
                } else if (domain_num == 29.0) {
                    inside = "jujutsucraft:domain_white";
                    floor = "jujutsucraft:domain_white";
                }
            } else if (domain_num <= 40.0) {
                if (domain_num == 32.0) {
                    inside = "jujutsucraft:domain_sand";
                    floor = "jujutsucraft:domain_sand";
                } else if (domain_num == 33.0) {
                    inside = "jujutsucraft:block_red";
                    floor = "jujutsucraft:domain_planks";
                } else if (domain_num == 34.0) {
                    floor = "jujutsucraft:domain_podzol";
                } else if (domain_num == 35.0) {
                    inside = "jujutsucraft:domain_blood";
                    floor = "jujutsucraft:domain_sand";
                } else if (domain_num == 36.0) {
                    floor = "jujutsucraft:domain_cloud";
                } else if (domain_num == 37.0) {
                    floor = "jujutsucraft:block_red";
                } else if (domain_num == 38.0) {
                    inside = "jujutsucraft:domain_blue_sky";
                    floor = "jujutsucraft:domain_blue_sky";
                } else if (domain_num == 39.0) {
                    inside = "jujutsucraft:domain_white";
                    floor = "jujutsucraft:domain_white";
                } else if (domain_num == 40.0) {
                    floor = "jujutsucraft:domain_dark_stone";
                }
            } else if (domain_num <= 50.0 && domain_num == 43.0) {
                floor = "jujutsucraft:domain_dark_stone";
                inside = "jujutsucraft:domain_dark_stone";
            } else if (domain_num >= 50.0) {
                floor = "jujutsucraft:block_universe";
                inside = "jujutsucraft:block_universe";
            }

            if (close_type > 0.0) {
                if (!entity.getPersistentData().getBoolean("Failed")) {
                    outside = "minecraft:air";
                    inside = "minecraft:air";
                    floor = "minecraft:air";
                } else {
                    outside = "";
                    inside = "";
                }
            } else if (close_type < 0.0 && !entity.getPersistentData().getBoolean("Failed") && !entity.getPersistentData().getBoolean("Cover")) {
                outside = "";
                inside = "";
            }

            entity.getPersistentData().putString("domain_outside", outside);
            entity.getPersistentData().putString("domain_inside", inside);
            entity.getPersistentData().putString("domain_floor", floor);
        }
    }
}
