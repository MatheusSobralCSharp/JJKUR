package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.entity.RabbitEscapeEntity;
import net.mcreator.jujutsucraft.entity.UraumeEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModGameRules;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.LogicAttackTargetStartProcedure;
import net.mcreator.jujutsucraft.procedures.ReturnInsideItemProcedure;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.scores.Scoreboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.UUID;
import java.util.function.BiFunction;

@Mixin(value = LogicAttackTargetStartProcedure.class, priority = -10000)
public abstract class LogicAttackTargetStartMixin {

    @Inject(at = @At("RETURN"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, Entity entity, CallbackInfoReturnable<Boolean> cir) {
        if (entity == null) {
            cir.setReturnValue(false);
        } else if (entity instanceof LivingEntity _entity && !_entity.hasEffect(JujutsucraftaddonModMobEffects.QUAKE.get())) {
            boolean logic_a = false;
            Entity event_owner = null;
            Entity target_owner = null;
            Entity entity_a = null;
            logic_a = true;
            LivingEntity var10000;
            if (entity instanceof Mob) {
                Mob _mobEnt = (Mob)entity;
                var10000 = _mobEnt.getTarget();
            } else {
                var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
                Mob _mobEnt;
                LivingEntity var10001;
                double var32;
                if (entity.getPersistentData().getDouble("friend_num") != 0.0) {
                    var32 = entity.getPersistentData().getDouble("friend_num");
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10001 = _mobEnt.getTarget();
                    } else {
                        var10001 = null;
                    }

                    if (var32 == var10001.getPersistentData().getDouble("friend_num")) {
                        cir.setReturnValue(false);
                    }
                }

                String var33 = entity.getPersistentData().getString("TARGET_UUID");
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10001 = _mobEnt.getTarget();
                } else {
                    var10001 = null;
                }

                if (var33.equals(var10001.getStringUUID())) {
                    cir.setReturnValue(true);
                }

                event_owner = entity;

                int index1;
                for(index1 = 0; index1 < 100 && !event_owner.getPersistentData().getString("OWNER_UUID").isEmpty(); ++index1) {
                    entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
                        public Entity apply(LevelAccessor levelAccessor, String uuid) {
                            if (levelAccessor instanceof ServerLevel serverLevel) {
                                try {
                                    return serverLevel.getEntity(UUID.fromString(uuid));
                                } catch (Exception var5) {
                                }
                            }

                            return null;
                        }
                    }).apply(world, event_owner.getPersistentData().getString("OWNER_UUID"));
                    if (!(entity_a instanceof LivingEntity)) {
                        break;
                    }

                    event_owner = entity_a;
                }

                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                target_owner = var10000;

                for(index1 = 0; index1 < 100 && !((Entity)target_owner).getPersistentData().getString("OWNER_UUID").isEmpty(); ++index1) {
                    entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
                        public Entity apply(LevelAccessor levelAccessor, String uuid) {
                            if (levelAccessor instanceof ServerLevel serverLevel) {
                                try {
                                    return serverLevel.getEntity(UUID.fromString(uuid));
                                } catch (Exception var5) {
                                }
                            }

                            return null;
                        }
                    }).apply(world, ((Entity)target_owner).getPersistentData().getString("OWNER_UUID"));
                    if (!(entity_a instanceof LivingEntity)) {
                        break;
                    }

                    target_owner = entity_a;
                }

                if ((event_owner instanceof Player || event_owner.getPersistentData().getBoolean("Player")) && (target_owner instanceof Player || ((Entity)target_owner).getPersistentData().getBoolean("Player"))) {
                    if (!world.getLevelData().getGameRules().getBoolean(JujutsucraftModGameRules.JUJUTSUPVP)) {
                        logic_a = false;
                    }
                } else if (!event_owner.getPersistentData().getBoolean("JujutsuSorcerer") && !entity.getPersistentData().getBoolean("JujutsuSorcerer")) {
                    if (!event_owner.getPersistentData().getBoolean("CursedSpirit") && !event_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:transfigured_human")))) {
                        if ((event_owner.getPersistentData().getBoolean("CurseUser") || entity.getPersistentData().getBoolean("CurseUser")) && !((Entity)target_owner).getPersistentData().getBoolean("JujutsuSorcerer") && !((Entity)target_owner).getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("curseuser"))) && !((Entity)target_owner).getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("cursedspirit")))) {
                            logic_a = false;
                        }
                    } else if (((Entity)target_owner).getPersistentData().getBoolean("CursedSpirit") || ((Entity)target_owner).getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:transfigured_human")))) {
                        logic_a = false;
                    }
                } else {
                    label448: {
                        if (!((Entity)target_owner).getPersistentData().getBoolean("JujutsuSorcerer")) {
                            if (entity instanceof Mob) {
                                _mobEnt = (Mob)entity;
                                var10000 = _mobEnt.getTarget();
                            } else {
                                var10000 = null;
                            }

                            if (!var10000.getPersistentData().getBoolean("JujutsuSorcerer")) {
                                break label448;
                            }
                        }

                        logic_a = false;
                    }
                }

                LivingEntity _livEnt55;
                LivingEntity var13;
                LivingEntity _livEnt51;
                label370: {
                    label430: {
                        if (event_owner instanceof LivingEntity) {
                            _livEnt51 = (LivingEntity)event_owner;
                            if (_livEnt51.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                break label430;
                            }
                        }

                        if (entity instanceof LivingEntity) {
                            _livEnt55 = (LivingEntity)entity;
                            if (_livEnt55.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                break label430;
                            }
                        }

                        if (target_owner instanceof LivingEntity) {
                            LivingEntity _livEnt39 = (LivingEntity)target_owner;
                            if (_livEnt39.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                break label430;
                            }
                        }

                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var10000 = _mobEnt.getTarget();
                        } else {
                            var10000 = null;
                        }

                        var13 = var10000;
                        if (!(var13 instanceof LivingEntity)) {
                            break label370;
                        }

                        LivingEntity _livEnt41 = (LivingEntity)var13;
                        if (!_livEnt41.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                            break label370;
                        }
                    }

                    logic_a = true;
                }

                if (event_owner instanceof UraumeEntity) {
                    label441: {
                        if (ReturnInsideItemProcedure.execute((Entity)target_owner).getItem() != JujutsucraftModItems.SUKUNA_FINGER.get()) {
                            if (!(target_owner instanceof LivingEntity)) {
                                break label441;
                            }

                            _livEnt51 = (LivingEntity)target_owner;
                            if (!_livEnt51.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                break label441;
                            }
                        }

                        logic_a = false;
                    }
                }

                if (event_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:death_painting")))) {
                    label442: {
                        if (target_owner instanceof Player) {
                            if (((JujutsucraftModVariables.PlayerVariables)((Entity)target_owner).getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 21.0 && ((JujutsucraftModVariables.PlayerVariables)((Entity)target_owner).getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 21.0) {
                                break label442;
                            }
                        } else if (!((Entity)target_owner).getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:death_painting")))) {
                            break label442;
                        }

                        logic_a = false;
                    }
                }

                label333: {
                    label433: {
                        label434: {
                            if (!event_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_1")))) {
                                if (!(event_owner instanceof Player) || !event_owner.getPersistentData().getBoolean("CurseUser")) {
                                    break label434;
                                }

                                if (event_owner instanceof LivingEntity) {
                                    _livEnt51 = (LivingEntity)event_owner;
                                    if (_livEnt51.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                        break label434;
                                    }
                                }
                            }

                            if (((Entity)target_owner).getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_1")))) {
                                break label433;
                            }

                            if (target_owner instanceof Player && ((Entity)target_owner).getPersistentData().getBoolean("CurseUser")) {
                                if (!(target_owner instanceof LivingEntity)) {
                                    break label433;
                                }

                                _livEnt55 = (LivingEntity)target_owner;
                                if (!_livEnt55.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                    break label433;
                                }
                            }
                        }

                        if ((!event_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_2"))) || !((Entity)target_owner).getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_2")))) && (!event_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_3"))) || !((Entity)target_owner).getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_3")))) && (!event_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_4"))) || !((Entity)target_owner).getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_4")))) && (!event_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_5"))) || !((Entity)target_owner).getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_5")))) && (!event_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:zenin"))) || !((Entity)target_owner).getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:zenin"))))) {
                            break label333;
                        }
                    }

                    logic_a = false;
                }

                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                LivingEntity _teamEnt = var10000;
                if (_teamEnt instanceof Mob) {
                    _mobEnt = (Mob)_teamEnt;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }


                if (var10000 instanceof LivingEntity) {
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                    } else {
                        var10000 = null;
                    }

                    if (var10000.getPersistentData().getDouble("cnt_target") > 6.0) {
                        if (entity.getPersistentData().getDouble("friend_num") != 0.0) {
                            var32 = entity.getPersistentData().getDouble("friend_num");
                            if (entity instanceof Mob) {
                                _mobEnt = (Mob)entity;
                                var10001 = _mobEnt.getTarget();
                            } else {
                                var10001 = null;
                            }

                            var13 = var10001;
                            if (var13 instanceof Mob) {
                                _mobEnt = (Mob)var13;
                                var10001 = _mobEnt.getTarget();
                            } else {
                                var10001 = null;
                            }

                            if (var32 == var10001.getPersistentData().getDouble("friend_num")) {
                                logic_a = true;
                            }
                        }

                        String var34;
                        Scoreboard var35;
                        label290: {
                            if (event_owner instanceof LivingEntity) {
                                _teamEnt = (LivingEntity)event_owner;
                                var35 = _teamEnt.level().getScoreboard();
                                if (_teamEnt instanceof Player) {
                                    Player _pl = (Player)_teamEnt;
                                    var34 = _pl.getGameProfile().getName();
                                } else {
                                    var34 = _teamEnt.getStringUUID();
                                }

                                if (var35.getPlayersTeam(var34) != null) {
                                    var35 = _teamEnt.level().getScoreboard();
                                    if (_teamEnt instanceof Player) {
                                        Player _pl = (Player)_teamEnt;
                                        var34 = _pl.getGameProfile().getName();
                                    } else {
                                        var34 = _teamEnt.getStringUUID();
                                    }

                                    var33 = var35.getPlayersTeam(var34).getName();
                                    break label290;
                                }
                            }

                            var33 = "";
                        }

                        if (!var33.isEmpty()) {
                            label283: {
                                if (event_owner instanceof LivingEntity) {
                                    LivingEntity _teamEnt2 = (LivingEntity)event_owner;
                                    var35 = _teamEnt2.level().getScoreboard();
                                    if (_teamEnt2 instanceof Player) {
                                        Player _pl = (Player)_teamEnt2;
                                        var34 = _pl.getGameProfile().getName();
                                    } else {
                                        var34 = _teamEnt2.getStringUUID();
                                    }

                                    if (var35.getPlayersTeam(var34) != null) {
                                        var35 = _teamEnt2.level().getScoreboard();
                                        if (_teamEnt2 instanceof Player) {
                                            Player _pl = (Player)_teamEnt2;
                                            var34 = _pl.getGameProfile().getName();
                                        } else {
                                            var34 = _teamEnt2.getStringUUID();
                                        }

                                        var33 = var35.getPlayersTeam(var34).getName();
                                        break label283;
                                    }
                                }

                                var33 = "";
                            }

                            if (entity instanceof Mob) {
                                _mobEnt = (Mob)entity;
                                var10001 = _mobEnt.getTarget();
                            } else {
                                var10001 = null;
                            }

                            LivingEntity var23 = var10001;
                            if (var23 instanceof Mob) {
                                _mobEnt = (Mob)var23;
                                var10001 = _mobEnt.getTarget();
                            } else {
                                var10001 = null;
                            }

                            label276: {
                                LivingEntity var22 = var10001;
                                if (var22 instanceof LivingEntity) {
                                    LivingEntity _teamEnt3 = (LivingEntity)var22;
                                    Scoreboard var36 = _teamEnt3.level().getScoreboard();
                                    String var10002;
                                    if (_teamEnt3 instanceof Player) {
                                        Player _pl = (Player)_teamEnt3;
                                        var10002 = _pl.getGameProfile().getName();
                                    } else {
                                        var10002 = _teamEnt3.getStringUUID();
                                    }

                                    if (var36.getPlayersTeam(var10002) != null) {
                                        var36 = _teamEnt3.level().getScoreboard();
                                        if (_teamEnt3 instanceof Player) {
                                            Player _pl = (Player)_teamEnt3;
                                            var10002 = _pl.getGameProfile().getName();
                                        } else {
                                            var10002 = _teamEnt3.getStringUUID();
                                        }

                                        var34 = var36.getPlayersTeam(var10002).getName();
                                        break label276;
                                    }
                                }

                                var34 = "";
                            }

                            if (var33.equals(var34)) {
                                logic_a = true;
                            }
                        }
                    }
                }

                if (event_owner == target_owner) {
                    logic_a = false;
                }

                if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:ten_shadows_technique"))) && !entity.getPersistentData().getBoolean("Ambush")) {
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                    } else {
                        var10000 = null;
                    }

                    if (!var10000.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:ten_shadows_technique")))) {
                        logic_a = true;
                    }

                    if (entity instanceof RabbitEscapeEntity) {
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var10000 = _mobEnt.getTarget();
                        } else {
                            var10000 = null;
                        }

                        if (var10000 instanceof RabbitEscapeEntity) {
                            logic_a = false;
                        }
                    }
                }

                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                _teamEnt = var10000;
                if (_teamEnt instanceof Mob) {
                    _mobEnt = (Mob)_teamEnt;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                if (var10000 instanceof LivingEntity) {
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                    } else {
                        var10000 = null;
                    }

                    if (var10000.getPersistentData().getDouble("cnt_target") > 6.0) {
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var10000 = _mobEnt.getTarget();
                        } else {
                            var10000 = null;
                        }

                        var13 = var10000;
                        if (var13 instanceof Mob) {
                            _mobEnt = (Mob)var13;
                            var10000 = _mobEnt.getTarget();
                        } else {
                            var10000 = null;
                        }

                        if (var10000 == entity) {
                            logic_a = true;
                        }
                    }
                }
            }

            cir.setReturnValue(logic_a);
        }
    }
}
