package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModGameRules;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KeyChangeTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraft.procedures.LogicStartPassiveProcedure;
import net.mcreator.jujutsucraft.procedures.LogicStartProcedure;
import net.mcreator.jujutsucraft.procedures.ResetCounterProcedure;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;

import java.util.Iterator;

public class ModifiedStartCurseTechnique {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            String STR1 = "";
            boolean logic_a = false;
            boolean CREATIVE = false;
            boolean item_use = false;
            boolean noUseCursePower = false;
            ItemStack item_a = ItemStack.EMPTY;
            double Level = 0.0;
            double Tick = 0.0;
            double NUM1 = 0.0;
            double skill = 0.0;
            double T1 = 0.0;
            double S1 = 0.0;
            double T2 = 0.0;
            double cost = 0.0;
            ItemStack var10000;
            LivingEntity _livEnt11;
            if (entity instanceof LivingEntity) {
                _livEnt11 = (LivingEntity) entity;
                var10000 = _livEnt11.getMainHandItem();
            } else {
                var10000 = ItemStack.EMPTY;
            }

            LivingEntity _livEnt12;
            LivingEntity _livEnt13;
            if (var10000.getOrCreateTag().getBoolean("used_item")) {
                if (entity instanceof LivingEntity) {
                    _livEnt13 = (LivingEntity) entity;
                    var10000 = _livEnt13.getMainHandItem();
                } else {
                    var10000 = ItemStack.EMPTY;
                }

                item_a = var10000;
                item_use = true;
            } else {
                if (entity instanceof LivingEntity) {
                    _livEnt12 = (LivingEntity) entity;
                    var10000 = _livEnt12.getOffhandItem();
                } else {
                    var10000 = ItemStack.EMPTY;
                }

                if (var10000.getOrCreateTag().getBoolean("used_item")) {
                    if (entity instanceof LivingEntity) {
                        _livEnt13 = (LivingEntity) entity;
                        var10000 = _livEnt13.getOffhandItem();
                    } else {
                        var10000 = ItemStack.EMPTY;
                    }

                    item_a = var10000;
                    item_use = true;
                }
            }

            if (item_use) {
                item_a.getOrCreateTag().putBoolean("used_item", false);
                STR1 = item_a.getDisplayName().getString();
                skill = item_a.getOrCreateTag().getDouble("skill");
                cost = item_a.getOrCreateTag().getDouble("COOLDOWN_TICKS");
                if (item_a.getItem() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()) {
                    noUseCursePower = true;
                }
            } else {
                boolean _setval = true;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                    capability.noChangeTechnique = _setval;
                    capability.syncPlayerVariables(entity);
                });
                KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            }

            Player _player;
            label324:
            {
                if (item_use) {
                    label331:
                    {
                        if (entity instanceof LivingEntity) {
                            _livEnt11 = (LivingEntity) entity;
                            if (_livEnt11.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                                break label324;
                            }
                        }

                        label332:
                        {
                            if (entity instanceof LivingEntity) {
                                _livEnt12 = (LivingEntity) entity;
                                if (_livEnt12.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                    break label332;
                                }
                            }

                            if (!(entity instanceof LivingEntity)) {
                                break label331;
                            }

                            _livEnt13 = (LivingEntity) entity;
                            if (!_livEnt13.hasEffect(JujutsucraftModMobEffects.UNSTABLE.get())) {
                                break label331;
                            }
                        }

                        if (!noUseCursePower) {
                            break label324;
                        }
                    }
                } else if (!LogicStartProcedure.execute(entity)) {
                    break label324;
                }

                if (!((new Object() {
                    public boolean checkGamemode(Entity _ent) {
                        if (_ent instanceof ServerPlayer _serverPlayer) {
                            return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
                        } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
                            return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
                        } else {
                            return false;
                        }
                    }
                })).checkGamemode(entity)) {
                    CREATIVE = ((new Object() {
                        public boolean checkGamemode(Entity _ent) {
                            if (_ent instanceof ServerPlayer _serverPlayer) {
                                return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                            } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
                                return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
                            } else {
                                return false;
                            }
                        }
                    })).checkGamemode(entity);
                    if (noUseCursePower) {
                        NUM1 = entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCursePower - 0.0;
                    } else {
                        NUM1 = entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCursePower - (item_use ? cost : entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerSelectCurseTechniqueCost);
                    }

                    if (!(NUM1 >= 0.0) && !CREATIVE) {
                        if (entity instanceof Player) {
                            _player = (Player) entity;
                            if (!_player.level().isClientSide()) {
                                _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.dont_use").getString()), true);
                            }

                            return;
                        }

                        return;
                    } else {
                        double _setval;
                        if (!CREATIVE) {
                            _setval = NUM1;
                            double final_setval = _setval;
                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                                capability.PlayerCursePower = final_setval;
                                capability.syncPlayerVariables(entity);
                            });
                        }

                        if (item_use) {
                            T1 = (double) Math.round(Math.floor(skill / 100.0));
                            T2 = entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique2;
                            S1 = (double) Math.round(Math.floor(skill % 100.0));
                        } else {
                            STR1 = Component.translatable("jujutsu.technique.flying_kick").getString();
                            T1 = entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique;
                            T2 = entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique2;
                            S1 = entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerSelectCurseTechnique;
                        }

                        entity.getPersistentData().putDouble("skill", 2904);
                        ResetCounterProcedure.execute(entity);
                        LivingEntity _entity;
                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity) entity;
                            if (!_entity.level().isClientSide()) {
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                            }
                        }

                        if ((T1 != 2.0 || S1 != 5.0) && (T1 != 9.0 || S1 != 10.0) && (T1 != 18.0 || !(S1 >= 10.0) || !(S1 < 15.0)) && !CREATIVE) {
                            if (S1 == 20.0) {
                                Tick = 20.0;
                            } else {
                                Tick = Math.max((item_use ? cost : entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerSelectCurseTechniqueCostOrgin) / 2.0, 20.0);
                                if (STR1.equals(Component.translatable("jujutsu.technique.attack1").getString())) {
                                    Tick = 5.0;
                                } else if (STR1.equals(Component.translatable("jujutsu.technique.attack2").getString())) {
                                    Tick = 15.0;
                                } else if (STR1.equals(Component.translatable("jujutsu.technique.attack3").getString())) {
                                    Tick = 20.0;
                                } else {
                                    if (STR1.equals(Component.translatable("jujutsu.technique.attack4").getString())) {
                                        Tick = 100.0;
                                    } else if (STR1.equals(Component.translatable("jujutsu.technique.attack5").getString())) {
                                        Tick = 200.0;
                                    }

                                    if (!STR1.equals(Component.translatable("jujutsu.technique.attack6").getString()) && !STR1.equals(Component.translatable("jujutsu.technique.flying_kick").getString())) {
                                        if (STR1.equals(Component.translatable("jujutsu.technique.attack7").getString())) {
                                            Tick = 80.0;
                                        }
                                    } else {
                                        Tick = 60.0;
                                    }
                                }

                                if (T1 == 5.0 && S1 == 5.0) {
                                    Tick = 20.0;
                                }

                                if (T1 == 6.0 && S1 >= 5.0 && S1 < 20.0 && !STR1.equals(Component.translatable("jujutsu.technique.choso3").getString())) {
                                    Tick = 5.0;
                                }

                                if (T1 == 7.0 && (S1 == 5.0 || S1 == 10.0)) {
                                    Tick = 20.0;
                                }

                                if ((T1 == 19.0 || T2 == 19.0) && LogicStartPassiveProcedure.execute(entity) && S1 < 5.0) {
                                    Tick = 5.0;
                                }

                                if (T1 == 39.0 && S1 >= 8.0) {
                                    Tick = 20.0;
                                }
                            }
                        } else {
                            Tick = 1.0;
                        }

                        _setval = entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerTechniqueUsedNumber + (double) Math.round(Tick);
                        double final_setval1 = _setval;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                            capability.PlayerTechniqueUsedNumber = final_setval1;
                            capability.syncPlayerVariables(entity);
                        });
                        Advancement _adv;
                        AdvancementProgress _ap;
                        Iterator var36;
                        String criteria;
                        ServerPlayer _player2;
                        if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerTechniqueUsedNumber > (double) ((T1 != 27.0 && T2 != 27.0 ? 4000 : 2000) * (1 + world.getLevelData().getGameRules().getInt(JujutsucraftModGameRules.JUJUTSUUPGRADEDIFFICULTY) / 10)) && entity instanceof ServerPlayer) {
                            _player2 = (ServerPlayer) entity;
                            _adv = _player2.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:mastery_simple_domain"));
                            _ap = _player2.getAdvancements().getOrStartProgress(_adv);
                            if (!_ap.isDone()) {
                                var36 = _ap.getRemainingCriteria().iterator();

                                while (var36.hasNext()) {
                                    criteria = (String) var36.next();
                                    _player2.getAdvancements().award(_adv, criteria);
                                }
                            }
                        }

                        if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerTechniqueUsedNumber > (double) ((T1 != 27.0 && T2 != 27.0 ? 12000 : 100) * (1 + world.getLevelData().getGameRules().getInt(JujutsucraftModGameRules.JUJUTSUUPGRADEDIFFICULTY) / 10)) && entity instanceof ServerPlayer) {
                            _player2 = (ServerPlayer) entity;
                            _adv = _player2.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:mastery_domain_expansion"));
                            _ap = _player2.getAdvancements().getOrStartProgress(_adv);
                            if (!_ap.isDone()) {
                                var36 = _ap.getRemainingCriteria().iterator();

                                while (var36.hasNext()) {
                                    criteria = (String) var36.next();
                                    _player2.getAdvancements().award(_adv, criteria);
                                }
                            }
                        }

                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity) entity;
                            var10000 = _entity.getMainHandItem();
                        } else {
                            var10000 = ItemStack.EMPTY;
                        }

                        LivingEntity _livEnt;
                        if (var10000.getItem() == JujutsucraftModItems.LOUDSPEAKER.get()) {
                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity) entity;
                                var10000 = _livEnt.getMainHandItem();
                            } else {
                                var10000 = ItemStack.EMPTY;
                            }

                            var10000.getOrCreateTag().putBoolean("Used", true);
                        }

                        if (!noUseCursePower) {
                            if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PhysicalAttack && !item_use) {
                                if (entity instanceof LivingEntity) {
                                    _entity = (LivingEntity) entity;
                                    var10000 = _entity.getMainHandItem();
                                } else {
                                    var10000 = ItemStack.EMPTY;
                                }

                                if (var10000.getOrCreateTag().getDouble("Power") > 0.0) {
                                    ItemStack var10003;
                                    if (entity instanceof LivingEntity) {
                                        _livEnt = (LivingEntity) entity;
                                        var10003 = _livEnt.getMainHandItem();
                                    } else {
                                        var10003 = ItemStack.EMPTY;
                                    }

                                    Tick += 10.0 * (1.0 + var10003.getOrCreateTag().getDouble("Power") * 2.0);
                                }

                                if (entity instanceof LivingEntity) {
                                    _entity = (LivingEntity) entity;
                                    if (!_entity.level().isClientSide()) {
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int) Math.round(Tick), 0, false, false));
                                    }

                                    return;
                                }
                            } else if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity) entity;
                                if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int) Math.round(Tick), 0, false, false));
                                }

                                return;
                            }

                            return;
                        } else {
                            entity.getPersistentData().putDouble("COOLDOWN_TICKS", Math.max(entity.getPersistentData().getDouble("COOLDOWN_TICKS"), (double) Math.round(Tick)));
                            return;
                        }
                    }
                }
            }

            if (entity instanceof Player) {
                _player = (Player) entity;
                if (!_player.level().isClientSide()) {
                    _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.dont_use").getString()), true);
                }
            }

        }
    }
}
