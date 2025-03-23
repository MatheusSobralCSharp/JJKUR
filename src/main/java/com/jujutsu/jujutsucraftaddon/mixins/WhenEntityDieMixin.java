package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.entity.SukunaFushiguroEntity;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModGameRules;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.BeatEnemyProcedure;
import net.mcreator.jujutsucraft.procedures.BeatJujutsuSorcererProcedure;
import net.mcreator.jujutsucraft.procedures.BeatOtherProcedure;
import net.mcreator.jujutsucraft.procedures.WhenEntityDieProcedure;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Mixin(value = WhenEntityDieProcedure.class, priority = -10000)
public abstract class WhenEntityDieMixin {
    public WhenEntityDieMixin() {
    }

    /**
     * @author Satushi
     * @reason Yes
     */
    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            double fame = 0.0;
            double fame_base = 0.0;
            double EntityType = 0.0;
            double level_strength = 0.0;
            double FameGrade = 0.0;
            double difficulty = 0.0;
            double NUM1 = 0.0;
            boolean killCurse = false;
            boolean logic_a = false;
            String target_jp = "";
            String message = "";
            String MVP_Message = "";
            String str1 = "";
            if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && !entity.getPersistentData().getBoolean("Shikigami")) {
                if (entity instanceof SukunaFushiguroEntity) {
                    if (Math.random() < (1) / ((float) 1000)) {
                        if (world instanceof ServerLevel _level) {
                            ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(JujutsucraftaddonModItems.SUKUNA_COAT_BLACK.get()));
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity(entityToSpawn);
                        }
                    }
                }

                LivingEntity var10000;
                if (entity instanceof Player) {
                    Vec3 _center = new Vec3(x, y, z);
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(40.0), (e) -> {
                        return true;
                    }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                        return _entcnd.distanceToSqr(_center);
                    })).toList();
                    Iterator var30 = _entfound.iterator();

                    label482:
                    while(true) {
                        while(true) {
                            Entity entityiterator;
                            do {
                                if (!var30.hasNext()) {
                                    break label482;
                                }

                                entityiterator = (Entity)var30.next();
                                if (entityiterator instanceof Mob) {
                                    Mob _mobEnt = (Mob)entityiterator;
                                    var10000 = _mobEnt.getTarget();
                                } else {
                                    var10000 = null;
                                }
                            } while(var10000 != entity);

                            NUM1 = 1.0;

                            for(int index0 = 0; index0 < 128; ++index0) {
                                str1 = "pName" + Math.round(NUM1);
                                if (entityiterator.getPersistentData().getString(str1).equals("")) {
                                    entityiterator.getPersistentData().putString(str1, entity.getDisplayName().getString());
                                    break;
                                }

                                ++NUM1;
                            }
                        }
                    }
                }

                if (entity instanceof Mob) {
                    Mob _mobEnt = (Mob)entity;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                if (var10000 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") > 3.0) {
                    double var69;
                    label458: {
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEnt = (LivingEntity)entity;
                            if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                var69 = (double)_livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                break label458;
                            }
                        }

                        var69 = 0.0;
                    }

                    level_strength = var69;
                    fame_base = Math.pow(level_strength + 1.0, 2.0) + 1.0;
                    if (entity.getPersistentData().getBoolean("CursedSpirit")) {
                        target_jp = Component.translatable("jujutsu.message.kill1").getString();
                        killCurse = true;
                    } else if (entity.getPersistentData().getBoolean("CurseUser")) {
                        target_jp = Component.translatable("jujutsu.message.kill2").getString();
                    } else if (entity.getPersistentData().getBoolean("jjkChara")) {
                        target_jp = Component.translatable("jujutsu.message.kill3").getString();
                    } else {
                        target_jp = "";
                    }

                    if (!target_jp.equals("")) {
                        Vec3 _center = new Vec3(x, y, z);
                        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(32.0), (e) -> {
                            return true;
                        }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                            return _entcnd.distanceToSqr(_center);
                        })).toList();
                        Iterator var54 = _entfound.iterator();

                        while(true) {
                            ServerPlayer _player;
                            Advancement _adv;
                            AdvancementProgress _ap;
                            Iterator var66;
                            String criteria;
                            do {
                                Entity entityiterator;
                                do {
                                    while(true) {
                                        do {
                                            do {
                                                do {
                                                    LivingEntity _livEnt22;
                                                    do {
                                                        Player _plr;
                                                        do {
                                                            do {
                                                                do {
                                                                    if (!var54.hasNext()) {
                                                                        return;
                                                                    }

                                                                    entityiterator = (Entity)var54.next();
                                                                } while(!(entityiterator instanceof Player));

                                                                if (!(entityiterator instanceof Player)) {
                                                                    break;
                                                                }

                                                                _plr = (Player)entityiterator;
                                                            } while(_plr.getAbilities().instabuild);
                                                        } while(((new Object() {
                                                            public boolean checkGamemode(Entity _ent) {
                                                                if (_ent instanceof ServerPlayer _serverPlayer) {
                                                                    return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
                                                                } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
                                                                    return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
                                                                } else {
                                                                    return false;
                                                                }
                                                            }
                                                        })).checkGamemode(entityiterator));

                                                        if (!(entityiterator instanceof LivingEntity)) {
                                                            break;
                                                        }

                                                        _livEnt22 = (LivingEntity)entityiterator;
                                                    } while(manageSukunaPlayerOrNo(_livEnt22));

                                                    if (entityiterator.getPersistentData().getBoolean("JujutsuSorcerer")) {
                                                        if (entity instanceof Mob) {
                                                            Mob _mobEnt = (Mob)entity;
                                                            var10000 = _mobEnt.getTarget();
                                                        } else {
                                                            var10000 = null;
                                                        }

                                                        if (var10000.getPersistentData().getBoolean("JujutsuSorcerer")) {
                                                            break;
                                                        }
                                                    }

                                                    if (entityiterator.getPersistentData().getBoolean("CurseUser")) {
                                                        if (entity instanceof Mob) {
                                                            Mob _mobEnt = (Mob)entity;
                                                            var10000 = _mobEnt.getTarget();
                                                        } else {
                                                            var10000 = null;
                                                        }

                                                        if (var10000.getPersistentData().getBoolean("CurseUser")) {
                                                            break;
                                                        }
                                                    }

                                                    if (entityiterator.getPersistentData().getBoolean("CursedSpirit")) {
                                                        if (entity instanceof Mob) {
                                                            Mob _mobEnt = (Mob)entity;
                                                            var10000 = _mobEnt.getTarget();
                                                        } else {
                                                            var10000 = null;
                                                        }

                                                        if (var10000.getPersistentData().getBoolean("CursedSpirit")) {
                                                            break;
                                                        }
                                                    }

                                                    if (entity instanceof Mob) {
                                                        Mob _mobEnt = (Mob)entity;
                                                        var10000 = _mobEnt.getTarget();
                                                    } else {
                                                        var10000 = null;
                                                    }

                                                    if (var10000 instanceof Player) {
                                                        break;
                                                    }

                                                    if (entity instanceof Mob) {
                                                        Mob _mobEnt = (Mob)entity;
                                                        var10000 = _mobEnt.getTarget();
                                                    } else {
                                                        var10000 = null;
                                                    }
                                                } while(!var10000.getPersistentData().getBoolean("Player"));

                                                logic_a = true;
                                                NUM1 = 1.0;

                                                for(int index1 = 0; index1 < 128; ++index1) {
                                                    str1 = entity.getPersistentData().getString("pName" + Math.round(NUM1));
                                                    if (str1.equals("")) {
                                                        break;
                                                    }

                                                    if (str1.equals(entityiterator.getDisplayName().getString())) {
                                                        logic_a = false;
                                                        break;
                                                    }

                                                    ++NUM1;
                                                }

                                                if (entity.getPersistentData().getDouble("friend_num") != 0.0 && entity.getPersistentData().getDouble("friend_num") == entityiterator.getPersistentData().getDouble("friend_num")) {
                                                    logic_a = false;
                                                }
                                            } while(!logic_a);

                                            if (entity instanceof Mob) {
                                                Mob _mobEnt = (Mob)entity;
                                                var10000 = _mobEnt.getTarget();
                                            } else {
                                                var10000 = null;
                                            }

                                            label504: {
                                                if (var10000 != entityiterator) {
                                                    if (entity instanceof Mob) {
                                                        Mob _mobEnt = (Mob)entity;
                                                        var10000 = _mobEnt.getTarget();
                                                    } else {
                                                        var10000 = null;
                                                    }

                                                    if (!(var10000 instanceof Player)) {
                                                        if (entity instanceof Mob) {
                                                            Mob _mobEnt = (Mob)entity;
                                                            var10000 = _mobEnt.getTarget();
                                                        } else {
                                                            var10000 = null;
                                                        }

                                                        if (!var10000.getPersistentData().getBoolean("Player")) {
                                                            if (entity instanceof Mob) {
                                                                Mob _mobEnt = (Mob)entity;
                                                                var10000 = _mobEnt.getTarget();
                                                            } else {
                                                                var10000 = null;
                                                            }

                                                            if (var10000.getPersistentData().getDouble("friend_num") == 0.0) {
                                                                break label504;
                                                            }

                                                            if (entity instanceof Mob) {
                                                                Mob _mobEnt = (Mob)entity;
                                                                var10000 = _mobEnt.getTarget();
                                                            } else {
                                                                var10000 = null;
                                                            }

                                                            if (var10000.getPersistentData().getDouble("friend_num") != entityiterator.getPersistentData().getDouble("friend_num")) {
                                                                break label504;
                                                            }
                                                        }
                                                    }
                                                }

                                                MVP_Message = "[MVP]";
                                                fame = fame_base;
                                                double _setval = Math.max(((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerExperience, level_strength);
                                                Entity finalEntityiterator1 = entityiterator;
                                                entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                                    capability.PlayerExperience = _setval;
                                                    capability.syncPlayerVariables(finalEntityiterator1);
                                                });
                                                if (killCurse) {

                                                    Iterator var48;
                                                    if (level_strength >= 10.0) {
                                                        if (entityiterator instanceof ServerPlayer) {
                                                            _player = (ServerPlayer)entityiterator;
                                                            _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:fame_special"));
                                                            _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                                            if (!_ap.isDone()) {
                                                                var48 = _ap.getRemainingCriteria().iterator();

                                                                while(var48.hasNext()) {
                                                                    criteria = (String)var48.next();
                                                                    _player.getAdvancements().award(_adv, criteria);
                                                                }
                                                            }
                                                        }
                                                    } else if (level_strength >= 8.0) {
                                                        if (entityiterator instanceof ServerPlayer) {
                                                            _player = (ServerPlayer)entityiterator;
                                                            _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:fame_1"));
                                                            _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                                            if (!_ap.isDone()) {
                                                                var48 = _ap.getRemainingCriteria().iterator();

                                                                while(var48.hasNext()) {
                                                                    criteria = (String)var48.next();
                                                                    _player.getAdvancements().award(_adv, criteria);
                                                                }
                                                            }
                                                        }
                                                    } else if (level_strength >= 5.0) {
                                                        if (entityiterator instanceof ServerPlayer) {
                                                            _player = (ServerPlayer)entityiterator;
                                                            _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:fame_2"));
                                                            _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                                            if (!_ap.isDone()) {
                                                                var48 = _ap.getRemainingCriteria().iterator();

                                                                while(var48.hasNext()) {
                                                                    criteria = (String)var48.next();
                                                                    _player.getAdvancements().award(_adv, criteria);
                                                                }
                                                            }
                                                        }
                                                    } else if (level_strength >= 1.0) {
                                                        if (entityiterator instanceof ServerPlayer) {
                                                            _player = (ServerPlayer)entityiterator;
                                                            _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:fame_3"));
                                                            _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                                            if (!_ap.isDone()) {
                                                                var48 = _ap.getRemainingCriteria().iterator();

                                                                while(var48.hasNext()) {
                                                                    criteria = (String)var48.next();
                                                                    _player.getAdvancements().award(_adv, criteria);
                                                                }
                                                            }
                                                        }
                                                    } else if (entityiterator instanceof ServerPlayer) {
                                                        _player = (ServerPlayer)entityiterator;
                                                        _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:fame_4"));
                                                        _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                                        if (!_ap.isDone()) {
                                                            var48 = _ap.getRemainingCriteria().iterator();

                                                            while(var48.hasNext()) {
                                                                criteria = (String)var48.next();
                                                                _player.getAdvancements().award(_adv, criteria);
                                                            }
                                                        }
                                                    }
                                                }

                                                BeatJujutsuSorcererProcedure.execute(entity, entityiterator);
                                                BeatEnemyProcedure.execute(entity, entityiterator);
                                                BeatOtherProcedure.execute(entity, entityiterator);
                                                continue;
                                            }

                                            MVP_Message = "";
                                            fame = (double)Math.round(fame_base / 10.0);
                                        } while(!world.getLevelData().getGameRules().getBoolean(JujutsucraftModGameRules.JUJUTSU_GAIN_FAME));

                                        double _setval = ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerFame + fame;
                                        Entity finalEntityiterator = entityiterator;
                                        entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                            capability.PlayerFame = _setval;
                                            capability.syncPlayerVariables(finalEntityiterator);
                                        });
                                        message = target_jp.replace("[point]", "§l" + Math.round(fame) + "§r");
                                        if (entityiterator instanceof Player) {
                                            Player _player1 = (Player)entityiterator;
                                            if (!_player1.level().isClientSide()) {
                                                _player1.displayClientMessage(Component.literal(MVP_Message + message), false);
                                            }
                                        }

                                        label506: {
                                            if (entityiterator instanceof ServerPlayer) {
                                                _player = (ServerPlayer)entityiterator;
                                                if (_player.level() instanceof ServerLevel && _player.getAdvancements().getOrStartProgress(_player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:fame_special"))).isDone()) {
                                                    FameGrade = 10.0;
                                                    break label506;
                                                }
                                            }

                                            if (entityiterator instanceof ServerPlayer) {
                                                ServerPlayer _plr60 = (ServerPlayer)entityiterator;
                                                if (_plr60.level() instanceof ServerLevel && _plr60.getAdvancements().getOrStartProgress(_plr60.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:fame_1"))).isDone()) {
                                                    FameGrade = 8.0;
                                                    break label506;
                                                }
                                            }

                                            if (entityiterator instanceof ServerPlayer) {
                                                ServerPlayer _plr61 = (ServerPlayer)entityiterator;
                                                if (_plr61.level() instanceof ServerLevel && _plr61.getAdvancements().getOrStartProgress(_plr61.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:fame_2"))).isDone()) {
                                                    FameGrade = 6.0;
                                                    break label506;
                                                }
                                            }

                                            if (entityiterator instanceof ServerPlayer) {
                                                ServerPlayer _plr62 = (ServerPlayer)entityiterator;
                                                if (_plr62.level() instanceof ServerLevel && _plr62.getAdvancements().getOrStartProgress(_plr62.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:fame_3"))).isDone()) {
                                                    FameGrade = 4.0;
                                                }
                                            }
                                        }

                                        difficulty = (double)world.getLevelData().getGameRules().getInt(JujutsucraftModGameRules.JUJUTSUUPGRADEDIFFICULTY);
                                        if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerFame >= 4000.0 * difficulty && FameGrade >= 10.0) {
                                            break;
                                        }

                                        if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerFame >= 2750.0 * difficulty && FameGrade >= 8.0) {
                                            if (entityiterator instanceof ServerPlayer) {
                                                _player = (ServerPlayer)entityiterator;
                                                _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sorcerer_grade_1"));
                                                _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                                if (!_ap.isDone()) {
                                                    var66 = _ap.getRemainingCriteria().iterator();

                                                    while(var66.hasNext()) {
                                                        criteria = (String)var66.next();
                                                        _player.getAdvancements().award(_adv, criteria);
                                                    }
                                                }
                                            }
                                        } else if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerFame >= 1750.0 * difficulty) {
                                            if (entityiterator instanceof ServerPlayer) {
                                                _player = (ServerPlayer)entityiterator;
                                                _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sorcerer_grade_1_semi"));
                                                _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                                if (!_ap.isDone()) {
                                                    var66 = _ap.getRemainingCriteria().iterator();

                                                    while(var66.hasNext()) {
                                                        criteria = (String)var66.next();
                                                        _player.getAdvancements().award(_adv, criteria);
                                                    }
                                                }
                                            }
                                        } else if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerFame >= 1000.0 * difficulty && FameGrade >= 6.0) {
                                            if (entityiterator instanceof ServerPlayer) {
                                                _player = (ServerPlayer)entityiterator;
                                                _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sorcerer_grade_2"));
                                                _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                                if (!_ap.isDone()) {
                                                    var66 = _ap.getRemainingCriteria().iterator();

                                                    while(var66.hasNext()) {
                                                        criteria = (String)var66.next();
                                                        _player.getAdvancements().award(_adv, criteria);
                                                    }
                                                }
                                            }
                                        } else if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerFame >= 500.0 * difficulty) {
                                            if (entityiterator instanceof ServerPlayer) {
                                                _player = (ServerPlayer)entityiterator;
                                                _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sorcerer_grade_2_semi"));
                                                _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                                if (!_ap.isDone()) {
                                                    var66 = _ap.getRemainingCriteria().iterator();

                                                    while(var66.hasNext()) {
                                                        criteria = (String)var66.next();
                                                        _player.getAdvancements().award(_adv, criteria);
                                                    }
                                                }
                                            }
                                        } else if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerFame >= 200.0 * difficulty && FameGrade >= 4.0) {
                                            if (entityiterator instanceof ServerPlayer) {
                                                _player = (ServerPlayer)entityiterator;
                                                _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sorcerer_grade_3"));
                                                _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                                if (!_ap.isDone()) {
                                                    var66 = _ap.getRemainingCriteria().iterator();

                                                    while(var66.hasNext()) {
                                                        criteria = (String)var66.next();
                                                        _player.getAdvancements().award(_adv, criteria);
                                                    }
                                                }
                                            }
                                        } else if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerFame >= 50.0 * difficulty && entityiterator instanceof ServerPlayer) {
                                            _player = (ServerPlayer)entityiterator;
                                            _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sorcerer_grade_4"));
                                            _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                            if (!_ap.isDone()) {
                                                var66 = _ap.getRemainingCriteria().iterator();

                                                while(var66.hasNext()) {
                                                    criteria = (String)var66.next();
                                                    _player.getAdvancements().award(_adv, criteria);
                                                }
                                            }
                                        }
                                    }
                                } while(!(entityiterator instanceof ServerPlayer));

                                _player = (ServerPlayer)entityiterator;
                                _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sorcerer_grade_special"));
                                _ap = _player.getAdvancements().getOrStartProgress(_adv);
                            } while(_ap.isDone());

                            var66 = _ap.getRemainingCriteria().iterator();

                            while(var66.hasNext()) {
                                criteria = (String)var66.next();
                                _player.getAdvancements().award(_adv, criteria);
                            }
                        }
                    }
                }
            }

        }
    }

    private static boolean manageSukunaPlayerOrNo(LivingEntity entity) {
        Level world = entity.level();
        boolean b = entity.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get());
        return b ? !world.getServer().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_CAN_SUKUNA_GET_ADVANCEMENTS) : b;
    }
}
