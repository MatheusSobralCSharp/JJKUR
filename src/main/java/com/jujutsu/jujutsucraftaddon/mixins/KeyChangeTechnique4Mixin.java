package com.jujutsu.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = KeyChangeTechniqueOnKeyPressed4Procedure.class)
public class KeyChangeTechnique4Mixin {
    @Inject(
            method = {"execute"},
            at = {@At("HEAD")},
            cancellable = true,
            remap = false
    )
    private static void onExecute(LevelAccessor world, double x, double y, double z, Entity entity, double playerCT, double playerSelect, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            String name = "";
            String STR1 = "";
            boolean reChange = false;
            boolean p_passive = false;
            boolean p_physical = false;
            double cost = 0.0;
            double old_select = 0.0;
            double PlayerCurseTechnique = 0.0;
            double NUM1 = 0.0;
            double NUM2 = 0.0;
            double p_skill1 = 0.0;
            double p_selectNumber = 0.0;
            p_skill1 = playerCT;
            p_selectNumber = playerSelect;
            if (p_skill1 >= 50.0) {
                name = "-----";

                for (int index0 = 0; index0 < 25; ++index0) {
                    p_passive = false;
                    p_physical = false;
                    if (p_skill1 == 100.0)  {
                        if (p_selectNumber == 3.0) {
                            name = Component.literal("佛陀 Break").getString();
                            cost = 50.0;
                        } else if (p_selectNumber == 4.0) {
                            name = Component.literal("斗战胜佛 Palm").getString();
                            cost = 20.0;
                        } else if (p_selectNumber == 5.0) {
                            name = Component.literal("孫悟空 Clones").getString();
                            cost = 150.0;
                        } else if (p_selectNumber == 6.0) {
                            name = Component.literal("孫悟空 Wrath").getString();
                            cost = 250.0;
                        } else if (p_selectNumber == 7.0) {
                            name = Component.literal("佛陀 Counter").getString();
                            cost = 350.0;
                        } else if (p_selectNumber == 8.0) {
                            name = Component.literal("孫悟空 Meteor").getString();
                            cost = 800.0;
                        } else if (p_selectNumber == 9.0) {
                            name = Component.literal("斗战胜佛 Armor").getString();
                            cost = 1000.0;
                        } else if (p_selectNumber == 20.0) {
                            name = Component.translatable("effect.domain_expansion").getString();
                            cost = 1250.0;
                        }
                    }

                    if (p_selectNumber >= 0.0 && p_selectNumber <= 2.0) {
                        name = Component.translatable("jujutsu.technique.attack" + Math.round(p_selectNumber + 1.0)).getString();
                        p_physical = true;
                        cost = 0.0;
                    } else if (p_selectNumber == 21.0) {
                        name = Component.translatable("jujutsu.technique.cancel_domain").getString();
                        p_physical = true;
                        p_passive = true;
                        cost = 0.0;
                    }

                    if (!name.equals("-----")) {
                        if (!ChangeTechniqueTestProcedure.execute(world, x, y, z, entity, p_skill1, p_selectNumber)) {
                            break;
                        }

                        name = "-----";
                    }

                    p_selectNumber += (double) (entity.isShiftKeyDown() ? -1 : 1);
                    if (p_selectNumber < 0.0) {
                        p_selectNumber = 21.0;
                    } else if (p_selectNumber > 21.0) {
                        p_selectNumber = 0.0;
                    }
                }

                TechniqueDecideProcedure.execute(entity, p_passive, p_physical, cost, p_skill1, p_selectNumber, name);
            } else if (p_skill1 <= 50.0) {
                name = "-----";

                for (int index0 = 0; index0 < 25; ++index0) {
                    p_passive = false;
                    p_physical = false;
                    if (p_skill1 == 31.0) {
                        if (p_selectNumber == 5.0) {
                            p_physical = true;
                            name = Component.translatable("jujutsu.technique.kusakabe1").getString();
                            cost = 200.0;
                        }
                    } else if (p_skill1 == 32.0) {
                        if (p_selectNumber == 5.0) {
                            name = Component.translatable("jujutsu.technique.chojuro1").getString();
                            cost = 120.0;
                        } else if (p_selectNumber == 9.0) {
                            name = Component.translatable("jujutsu.technique.chojuro2").getString();
                            cost = 350.0;
                        } else if (p_selectNumber == 20.0) {
                            name = Component.translatable("effect.domain_expansion").getString();
                            cost = 1000.0;
                        }
                    } else if (p_skill1 == 33.0) {
                        if (p_selectNumber == 20.0) {
                            name = Component.translatable("effect.domain_expansion").getString();
                            cost = 1000.0;
                        }
                    } else if (p_skill1 == 34.0) {
                        if (p_selectNumber == 5.0) {
                        }

                        if (p_selectNumber == 6.0) {
                            name = Component.translatable("jujutsu.technique.kugisaki2").getString();
                            cost = 100.0;
                        } else {
                            if (p_selectNumber == 7.0) {
                            }

                            if (p_selectNumber == 20.0) {
                                name = Component.translatable("effect.domain_expansion").getString();
                                cost = 1000.0;
                            }
                        }
                    } else if (p_skill1 == 35.0) {
                        if (p_selectNumber == 5.0) {
                            name = Component.translatable("entity.jujutsucraft.moon_dregs").getString();
                            cost = 250.0;
                        } else if (p_selectNumber == 20.0) {
                            name = Component.translatable("effect.domain_expansion").getString();
                            cost = 1250.0;
                        }
                    } else if (p_skill1 == 36.0) {
                        if (p_selectNumber == 5.0) {
                            name = Component.translatable("jujutsu.technique.nishimiya1").getString();
                            cost = 50.0;
                        } else if (p_selectNumber == 6.0) {
                            name = Component.translatable("jujutsu.technique.nishimiya2").getString();
                            cost = 120.0;
                        } else if (p_selectNumber == 10.0) {
                            name = Component.translatable("jujutsu.technique.nishimiya3").getString();
                            cost = 400.0;
                        } else if (p_selectNumber == 20.0) {
                            name = Component.translatable("effect.domain_expansion").getString();
                            cost = 1250.0;
                        }
                    } else if (p_skill1 == 37.0) {
                        if (p_selectNumber == 5.0) {
                            name = Component.translatable("entity.jujutsucraft.shikigami_heterocephalus_glaber").getString();
                            cost = 500.0;
                        } else if (p_selectNumber == 6.0) {
                            name = Component.translatable("entity.jujutsucraft.shikigami_pterosaur").getString();
                            cost = 500.0;
                        } else if (p_selectNumber == 10.0) {
                            p_passive = true;
                            p_physical = true;
                            name = Component.translatable("jujutsu.technique.cancel").getString();
                            cost = 0.0;
                        }
                    } else if (p_skill1 == 38.0) {
                        if (p_selectNumber == 10.0) {
                            name = Component.translatable("jujutsu.technique.uro10").getString();
                            cost = 200.0;
                        } else if (p_selectNumber == 20.0) {
                            name = Component.translatable("effect.domain_expansion").getString();
                            cost = 1000.0;
                        }
                    } else if (p_skill1 == 39.0) {
                        if (p_selectNumber == 5.0) {
                            p_physical = true;
                            name = Component.translatable("jujutsu.technique.attack7").getString();
                            cost = 50.0;
                        } else if (p_selectNumber == 6.0) {
                            p_physical = true;
                            name = Component.translatable("jujutsu.technique.attack6").getString();
                            cost = 50.0;
                        } else if (p_selectNumber == 7.0) {
                            p_physical = true;
                            name = Component.translatable("jujutsu.technique.attack4").getString();
                            cost = 50.0;
                        }

                        if (p_selectNumber == 8.0) {
                            cost = 10.0;
                            name = Component.translatable("jujutsu.technique.yorozu9").getString();
                        } else if (p_selectNumber == 9.0) {
                            cost = 25.0;
                            name = Component.translatable("jujutsu.technique.yorozu10").getString();
                        } else {
                            String var10000;
                            if (p_selectNumber == 12.0) {
                                if (LocateLiquidMetalProcedure.execute(world, entity)) {
                                    p_physical = true;
                                    var10000 = Component.translatable("jujutsu.technique.yorozu8").getString();
                                    name = var10000 + ": " + Component.translatable("jujutsu.message.cancel").getString();
                                    cost = 0.0;
                                } else {
                                    name = Component.translatable("jujutsu.technique.yorozu8").getString();
                                    cost = 400.0;
                                }
                            } else if (p_selectNumber == 14.0) {
                                label189:
                                {
                                    if (entity instanceof LivingEntity) {
                                        LivingEntity _livEnt28 = (LivingEntity) entity;
                                        if (_livEnt28.hasEffect((MobEffect) JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get())) {
                                            p_physical = true;
                                            var10000 = Component.translatable("item.jujutsucraft.insect_armor_chestplate").getString();
                                            name = var10000 + ": " + Component.translatable("jujutsu.message.cancel").getString();
                                            cost = 0.0;
                                            break label189;
                                        }
                                    }

                                    name = Component.translatable("item.jujutsucraft.insect_armor_chestplate").getString();
                                    cost = 1200.0;
                                }
                            } else if (p_selectNumber == 15.0) {
                                if (LocateTrueSphereProcedure.execute(world, entity)) {
                                    p_physical = true;
                                    var10000 = Component.translatable("entity.jujutsucraft.true_sphere").getString();
                                    name = var10000 + ": " + Component.translatable("jujutsu.message.cancel").getString();
                                    cost = 0.0;
                                } else {
                                    name = Component.translatable("entity.jujutsucraft.true_sphere").getString();
                                    cost = 1500.0;
                                }
                            } else if (p_selectNumber == 20.0) {
                                name = Component.translatable("jujutsu.technique.yorozu20").getString();
                                cost = 1000.0;
                            }
                        }
                    } else if (p_skill1 == 40.0) {
                        if (p_selectNumber == 5.0) {
                            name = Component.translatable("jujutsu.technique.ino1").getString();
                            cost = 150.0;
                        } else if (p_selectNumber == 6.0) {
                            p_passive = true;
                            name = Component.translatable("jujutsu.technique.ino2").getString();
                            cost = 250.0;
                        } else if (p_selectNumber == 7.0) {
                            p_passive = true;
                            name = Component.translatable("jujutsu.technique.ino3").getString();
                            cost = 250.0;
                        } else if (p_selectNumber == 8.0) {
                            name = Component.translatable("jujutsu.technique.ino4").getString();
                            cost = 800.0;
                        } else if (p_selectNumber == 20.0) {
                            name = Component.translatable("effect.domain_expansion").getString();
                            cost = 1250.0;
                        }
                    } else if (p_skill1 == 41.0) {
                        if (p_selectNumber == 5.0) {
                            name = Component.translatable("jujutsu.technique.kaori2").getString();
                            cost = 75.0;
                        } else if (p_selectNumber == 10.0) {
                            name = Component.translatable("jujutsu.technique.kaori1").getString();
                            cost = 150.0;
                        } else if (p_selectNumber == 20.0) {
                            name = Component.translatable("effect.domain_expansion").getString();
                            cost = 1250.0;
                        }
                    } else if (p_skill1 == 43.0) {
                        if (p_selectNumber == 3.0) {
                            p_physical = true;
                            name = Component.translatable("jujutsu.technique.attack7").getString();
                            cost = 50.0;
                        } else if (p_selectNumber == 5.0) {
                            name = Component.translatable("entity.jujutsucraft.rozetsu_shikigami").getString();
                            cost = 200.0;
                        } else if (p_selectNumber == 6.0) {
                            name = Component.translatable("entity.jujutsucraft.rozetsu_shikigami_vessel").getString();
                            cost = 250.0;
                        } else if (p_selectNumber == 7.0) {
                            name = Component.translatable("entity.jujutsucraft.rozetsu_shikigami_vessel_2").getString();
                            cost = 400.0;
                        } else if (p_selectNumber == 20.0) {
                            name = Component.translatable("jujutsu.technique.rozetsu_domain").getString();
                            cost = 1250.0;
                        }
                    }

                    if (p_selectNumber >= 0.0 && p_selectNumber <= 2.0) {
                        name = Component.translatable("jujutsu.technique.attack" + Math.round(p_selectNumber + 1.0)).getString();
                        p_physical = true;
                        cost = 0.0;
                    } else if (p_selectNumber == 21.0) {
                        name = Component.translatable("jujutsu.technique.cancel_domain").getString();
                        p_physical = true;
                        p_passive = true;
                        cost = 0.0;
                    }

                    if (!name.equals("-----")) {
                        if (!ChangeTechniqueTestProcedure.execute(world, x, y, z, entity, p_skill1, p_selectNumber)) {
                            break;
                        }

                        name = "-----";
                    }

                    p_selectNumber += (double) (entity.isShiftKeyDown() ? -1 : 1);
                    if (p_selectNumber < 0.0) {
                        p_selectNumber = 21.0;
                    } else if (p_selectNumber > 21.0) {
                        p_selectNumber = 0.0;
                    }
                }

                TechniqueDecideProcedure.execute(entity, p_passive, p_physical, cost, p_skill1, p_selectNumber, name);
            }

        }
    }
}
