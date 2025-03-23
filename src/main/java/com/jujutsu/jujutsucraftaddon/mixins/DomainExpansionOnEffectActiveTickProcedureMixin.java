package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.entity.*;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.DomainActiveProcedure;
import net.mcreator.jujutsucraft.procedures.DomainExpansionBattleProcedure;
import net.mcreator.jujutsucraft.procedures.DomainExpansionOnEffectActiveTickProcedure;
import net.mcreator.jujutsucraft.procedures.EffectCharactorProcedure;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
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

@Mixin(value = DomainExpansionOnEffectActiveTickProcedure.class, priority = -10000)
public abstract class DomainExpansionOnEffectActiveTickProcedureMixin {
    public DomainExpansionOnEffectActiveTickProcedureMixin() {
    }

    /**
     * @author Satushi
     * @reason Fixes Domain Barrier Size
     */
    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {

        ci.cancel();

        if (entity != null) {
            // Gives Domain Nerf Effect
            if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_DOMAIN_NERF)) {
                if (!(entity instanceof LivingEntity _livEnt24 && _livEnt24.hasEffect(JujutsucraftaddonModMobEffects.DOMAIN_BREAK.get()))) {
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.DOMAIN_BREAK.get(), -1, 1, false, false));
                }
            }

            double range = 0.0;
            double level = 0.0;
            double tick = 0.0;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double tick_1 = 0.0;
            double tick_2 = 0.0;
            double distance = 0.0;
            double old_skill = 0.0;
            double domainPower1 = 0.0;
            double domainPower2 = 0.0;
            double str_lv = 0.0;
            boolean failed = false;
            boolean logic_a = false;
            boolean logic_b = false;
            boolean noClosing = false;
            boolean update1 = false;
            boolean old_failed = false;
            boolean use_old = false;
            LivingEntity _livEnt157;
            if (entity.isAlive()) {
                double var10000;
                label572:
                {
                    if (entity instanceof LivingEntity) {
                        _livEnt157 = (LivingEntity) entity;
                        if (_livEnt157.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                            var10000 = _livEnt157.getEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                            break label572;
                        }
                    }

                    var10000 = 0.0;
                }

                int var67;
                label567:
                {
                    tick_1 = var10000;
                    if (entity instanceof LivingEntity) {
                        _livEnt157 = (LivingEntity) entity;
                        if (_livEnt157.hasEffect(MobEffects.DAMAGE_BOOST)) {
                            var67 = _livEnt157.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                            break label567;
                        }
                    }

                    var67 = 0;
                }

                str_lv = var67 + 10;
                if (entity.getPersistentData().getDouble("select") != 27.0 && entity.getPersistentData().getDouble("skill_domain") != 27.0) {
                    if (entity.getPersistentData().getDouble("select") == 29.0 || entity.getPersistentData().getDouble("skill_domain") == 29.0) {
                        str_lv *= 2.0;
                    }
                } else {
                    str_lv *= 1.5;
                }

                if (entity.getPersistentData().getDouble("skill_domain") == 0.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                    entity.getPersistentData().putDouble("skill_domain", entity.getPersistentData().getDouble("select"));
                    entity.getPersistentData().putDouble("select", 0.0);
                    update1 = true;
                }

                if (entity.getPersistentData().getDouble("skill_domain") > 0.0) {
                    if (!update1) {
                        DomainActiveProcedure.execute(world, x, y, z, entity);
                    }

                    int var10001;
                    label551:
                    {
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BarrierlessDomain) {
                            var10000 = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RadiusDomain;
                        } else {
                            var10000 = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
                        }

                        if (entity instanceof LivingEntity) {
                            _livEnt157 = (LivingEntity) entity;
                            if (_livEnt157.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                var10001 = _livEnt157.getEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                break label551;
                            }
                        }

                        var10001 = 0;
                    }

                    range = var10000 * (double) (var10001 > 0 ? 18 : 2);
                }

                old_skill = entity.getPersistentData().getDouble("skill");
                entity.getPersistentData().putDouble("skill", 0.0);
                LivingEntity _livEnt64;
                LivingEntity _entity;
                if (tick_1 % 10.0 == 0.0 || update1) {
                    logic_a = false;
                    Vec3 _center = new Vec3(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"));
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(range / 2.0), (e) -> {
                        return true;
                    }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                        return _entcnd.distanceToSqr(_center);
                    })).toList();
                    Iterator var43 = _entfound.iterator();

                    label542:
                    while (true) {
                        while (true) {
                            Entity entityiterator;
                            do {
                                if (!var43.hasNext()) {
                                    if (logic_a || !(entity.getPersistentData().getDouble("skill_domain") > 0.0)) {
                                        break label542;
                                    }

                                    label510:
                                    {
                                        if (entity instanceof LivingEntity) {
                                            _livEnt157 = (LivingEntity) entity;
                                            if (_livEnt157.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                var67 = _livEnt157.getEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                                break label510;
                                            }
                                        }

                                        var67 = 0;
                                    }

                                    if (var67 == 0 && entity instanceof LivingEntity) {
                                        _entity = (LivingEntity) entity;
                                        _entity.removeEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                                    }
                                    break label542;
                                }

                                entityiterator = (Entity) var43.next();
                                distance = Math.sqrt(Math.pow(entity.getPersistentData().getDouble("x_pos_doma") - entityiterator.getX(), 2.0) + Math.pow(entity.getPersistentData().getDouble("y_pos_doma") - (entityiterator.getY() + (double) entityiterator.getBbHeight() * 0.5), 2.0) + Math.pow(entity.getPersistentData().getDouble("z_pos_doma") - entityiterator.getZ(), 2.0));
                            } while (!(distance < range * 0.5));

                            if (entity == entityiterator) {
                                logic_a = true;
                            } else {
                                LivingEntity _livEnt32;
                                label537:
                                {
                                    if (entityiterator instanceof LivingEntity) {
                                        _livEnt32 = (LivingEntity) entityiterator;
                                        if (_livEnt32.hasEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                                            label532:
                                            {
                                                if (entityiterator instanceof LivingEntity) {
                                                    _livEnt64 = (LivingEntity) entityiterator;
                                                    if (_livEnt64.hasEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                                                        var10000 = _livEnt64.getEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getAmplifier();
                                                        break label532;
                                                    }
                                                }

                                                var10000 = 0.0;
                                            }

                                            label527:
                                            {
                                                level = var10000;
                                                if (entityiterator instanceof LivingEntity) {
                                                    _livEnt64 = (LivingEntity) entityiterator;
                                                    if (_livEnt64.hasEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                                                        var10000 = _livEnt64.getEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getDuration();
                                                        break label527;
                                                    }
                                                }

                                                var10000 = 0.0;
                                            }

                                            tick = var10000;
                                            tick -= (double) Math.round(Math.sqrt(str_lv + 1.0) * 10.0);
                                            if (entityiterator instanceof LivingEntity) {
                                                _livEnt64 = (LivingEntity) entityiterator;
                                                _livEnt64.removeEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get());
                                            }

                                            if (level >= 0.0 && entityiterator instanceof LivingEntity) {
                                                _livEnt64 = (LivingEntity) entityiterator;
                                                if (!_livEnt64.level().isClientSide()) {
                                                    _livEnt64.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get(), (int) tick, (int) level, true, true));
                                                }
                                            }
                                            break label537;
                                        }
                                    }

                                    if (tick_1 % 20.0 == 0.0) {
                                        EffectCharactorProcedure.execute(world, entity, entityiterator);
                                    }
                                }

                                if (entityiterator instanceof LivingEntity) {
                                    _livEnt32 = (LivingEntity) entityiterator;
                                    if (_livEnt32.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                        continue;
                                    }
                                }

                                if (entityiterator.getPersistentData().getDouble("select") == 0.0 && entityiterator instanceof LivingEntity) {
                                    _livEnt64 = (LivingEntity) entityiterator;
                                    if (!_livEnt64.level().isClientSide()) {
                                        _livEnt64.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.NEUTRALIZATION.get(), 20, (int) (entity.getPersistentData().getDouble("skill_domain") + 10.0), false, false));
                                    }
                                }
                            }
                        }
                    }
                }

                var10000 = entity.getPersistentData().getDouble("oldHealth");
                float var68;
                if (entity instanceof LivingEntity) {
                    _livEnt157 = (LivingEntity) entity;
                    var68 = _livEnt157.getHealth();
                } else {
                    var68 = -1.0F;
                }

                double var10002;
                LivingEntity _livEnt;
                CompoundTag var74;
                if (var10000 != (double) var68) {
                    var10000 = entity.getPersistentData().getDouble("oldHealth");
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity) entity;
                        var68 = _entity.getHealth();
                    } else {
                        var68 = -1.0F;
                    }

                    if (var10000 > (double) var68) {
                        var74 = entity.getPersistentData();
                        var10002 = entity.getPersistentData().getDouble("totalDamage") + entity.getPersistentData().getDouble("oldHealth");
                        float var10003;
                        if (entity instanceof LivingEntity) {
                            _livEnt = (LivingEntity) entity;
                            var10003 = _livEnt.getHealth();
                        } else {
                            var10003 = -1.0F;
                        }

                        var74.putDouble("totalDamage", var10002 - (double) var10003);
                    } else {
                        var74 = entity.getPersistentData();
                        var10002 = entity.getPersistentData().getDouble("totalDamage");
                        double var70 = entity.getPersistentData().getDouble("oldHealth");
                        float var10004;
                        if (entity instanceof LivingEntity) {
                            _livEnt = (LivingEntity) entity;
                            var10004 = _livEnt.getHealth();
                        } else {
                            var10004 = -1.0F;
                        }

                        var74.putDouble("totalDamage", var10002 + (var70 - (double) var10004) * 0.5);
                    }
                }

                var74 = entity.getPersistentData();
                if (entity instanceof LivingEntity) {
                    _livEnt157 = (LivingEntity) entity;
                    var10002 = _livEnt157.getHealth();
                } else {
                    var10002 = -1.0;
                }

                var74.putDouble("oldHealth", var10002);
                if ((tick_1 % 20.0 == 0.0 || update1) && entity.getPersistentData().getDouble("select") == 0.0) {
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity) entity;
                        var68 = _entity.getMaxHealth();
                    } else {
                        var68 = -1.0F;
                    }

                    double var72 = Math.max((double) Math.max(var68, 1.0F) - Math.max(entity.getPersistentData().getDouble("totalDamage"), 0.0) * 2.0, 0.0);
                    float var69;
                    if (entity instanceof LivingEntity) {
                        _livEnt157 = (LivingEntity) entity;
                        var69 = _livEnt157.getMaxHealth();
                    } else {
                        var69 = -1.0F;
                    }

                    domainPower1 = str_lv * (var72 / (double) Math.max(var69, 1.0F)) * Math.min(Math.min(tick_1, 1200.0) / 2400.0 + 0.5, 1.0);
                    failed = false;
                    logic_a = false;
                    logic_b = false;

                    for (int index0 = 0; index0 < 2; ++index0) {
                        Vec3 _center = new Vec3(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"));
                        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(range / 2.0), (e) -> {
                            return true;
                        }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                            return _entcnd.distanceToSqr(_center);
                        })).toList();
                        Iterator var63 = _entfound.iterator();

                        label484:
                        while (true) {
                            while (true) {
                                Entity entityiterator;
                                do {
                                    do {
                                        do {
                                            if (!var63.hasNext()) {
                                                break label484;
                                            }

                                            label373:
                                            {
                                                entityiterator = (Entity) var63.next();
                                                if (entity instanceof LivingEntity) {
                                                    _livEnt = (LivingEntity) entity;
                                                    if (_livEnt.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                        var67 = _livEnt.getEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                                        break label373;
                                                    }
                                                }

                                                var67 = 0;
                                            }

                                            boolean var77;
                                            label383:
                                            {
                                                if (var67 > 0) {
                                                    label380:
                                                    {
                                                        if (entityiterator instanceof LivingEntity) {
                                                            _livEnt64 = (LivingEntity) entityiterator;
                                                            if (_livEnt64.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                                var67 = _livEnt64.getEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                                                break label380;
                                                            }
                                                        }

                                                        var67 = 0;
                                                    }

                                                    if (var67 == 0) {
                                                        var77 = true;
                                                        break label383;
                                                    }
                                                }

                                                var77 = false;
                                            }

                                            noClosing = var77;
                                        } while (entity == entityiterator);

                                        if (entityiterator instanceof LivingEntity) {
                                            _livEnt64 = (LivingEntity) entityiterator;
                                            if (_livEnt64.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                break;
                                            }
                                        }
                                    } while (entityiterator.getPersistentData().getDouble("select") == 0.0);

                                    distance = Math.sqrt(Math.pow(entity.getPersistentData().getDouble("x_pos_doma") - entityiterator.getX(), 2.0) + Math.pow(entity.getPersistentData().getDouble("y_pos_doma") - (entityiterator.getY() + (double) entityiterator.getBbHeight() * 0.5), 2.0) + Math.pow(entity.getPersistentData().getDouble("z_pos_doma") - entityiterator.getZ(), 2.0));
                                } while (!(distance < range * 0.5));

                                label403:
                                {
                                    if (entityiterator instanceof LivingEntity) {
                                        _livEnt = (LivingEntity) entityiterator;
                                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                            var67 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                            break label403;
                                        }
                                    }

                                    var67 = 0;
                                }

                                domainPower2 = var67 + 10;
                                if (entityiterator.getPersistentData().getDouble("select") != 27.0 && entityiterator.getPersistentData().getDouble("skill_domain") != 27.0) {
                                    if (entityiterator.getPersistentData().getDouble("select") == 29.0 || entityiterator.getPersistentData().getDouble("skill_domain") == 29.0) {
                                        domainPower2 *= 2.0;
                                    }
                                } else {
                                    domainPower2 *= 1.5;
                                }

                                LivingEntity _livEnt84;
                                if (entityiterator.getPersistentData().getDouble("select") != 0.0) {
                                    tick_2 = 1200.0;
                                } else {
                                    label419:
                                    {
                                        if (entityiterator instanceof LivingEntity) {
                                            _livEnt = (LivingEntity) entityiterator;
                                            if (_livEnt.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                var10000 = _livEnt.getEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                                                break label419;
                                            }
                                        }

                                        var10000 = 0.0;
                                    }

                                    tick_2 = var10000;
                                    if (entityiterator instanceof LivingEntity) {
                                        _livEnt84 = (LivingEntity) entityiterator;
                                        var68 = _livEnt84.getMaxHealth();
                                    } else {
                                        var68 = -1.0F;
                                    }

                                    var72 = Math.max((double) Math.max(var68, 1.0F) - Math.max(entityiterator.getPersistentData().getDouble("totalDamage"), 0.0) * 2.0, 0.0);
                                    if (entityiterator instanceof LivingEntity) {
                                        _livEnt = (LivingEntity) entityiterator;
                                        var69 = _livEnt.getMaxHealth();
                                    } else {
                                        var69 = -1.0F;
                                    }

                                    domainPower2 = domainPower2 * (var72 / (double) Math.max(var69, 1.0F)) * Math.min(Math.min(tick_2, 1200.0) / 2400.0 + 0.5, 1.0);
                                }

                                LivingEntity _livEnt90;
                                label473:
                                {
                                    if (!(domainPower1 - domainPower2 >= 10.0)) {
                                        if (!logic_a) {
                                            break label473;
                                        }

                                        label469:
                                        {
                                            if (entityiterator instanceof LivingEntity) {
                                                _livEnt = (LivingEntity) entityiterator;
                                                if (_livEnt.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                    var67 = _livEnt.getEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                                    break label469;
                                                }
                                            }

                                            var67 = 0;
                                        }

                                        if (var67 > 0) {
                                            break label473;
                                        }
                                    }

                                    if (entityiterator instanceof LivingEntity) {
                                        _livEnt84 = (LivingEntity) entityiterator;
                                        if (_livEnt84.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                            label481:
                                            {
                                                failed = false;
                                                logic_b = true;
                                                entityiterator.getPersistentData().putBoolean("Failed", false);
                                                entityiterator.getPersistentData().putBoolean("DomainDefeated", !noClosing);
                                                if (entityiterator instanceof LivingEntity) {
                                                    _livEnt90 = (LivingEntity) entityiterator;
                                                    if (_livEnt90.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                        break label481;
                                                    }
                                                }

                                                if (entityiterator instanceof LivingEntity _entity2) {
                                                    if (!_entity2.level().isClientSide()) {
                                                        _entity2.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get(), 5, 0, false, false));
                                                    }
                                                }
                                            }

                                            if (entityiterator instanceof LivingEntity) {
                                                _livEnt90 = (LivingEntity) entityiterator;
                                                _livEnt90.removeEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                                            }
                                            continue;
                                        }
                                    }
                                }

                                if (noClosing) {
                                    label460:
                                    {
                                        if (tick_1 <= tick_2) {
                                            if (!(tick_2 < 1000.0)) {
                                                break label460;
                                            }
                                        } else if (!(tick_1 < 1000.0)) {
                                            break label460;
                                        }

                                        if (entityiterator instanceof LivingEntity) {
                                            _livEnt90 = (LivingEntity) entityiterator;
                                            if (_livEnt90.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                label452:
                                                {
                                                    label592:
                                                    {
                                                        logic_a = true;
                                                        if (entityiterator instanceof Player) {
                                                            if (entityiterator instanceof ServerPlayer _plr92) {
                                                                if (_plr92.level() instanceof ServerLevel && _plr92.getAdvancements().getOrStartProgress(_plr92.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:anti_open_barrier_type_domain"))).isDone()) {
                                                                    break label592;
                                                                }
                                                            }
                                                        } else if (entityiterator.getPersistentData().getDouble("cnt_learn_domain") > 0.0) {
                                                            break label592;
                                                        }

                                                        if (entityiterator instanceof LivingEntity _livEnt94) {
                                                            if (_livEnt94.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                                                break label592;
                                                            }
                                                        }

                                                        if (!(entityiterator instanceof GojoSatoruEntity) && !(entityiterator instanceof HigurumaHiromiEntity) && !(entityiterator instanceof OkkotsuYutaEntity) && !(entityiterator instanceof OkkotsuYutaCullingGameEntity) && !(entityiterator instanceof KenjakuEntity)) {
                                                            if (!(entityiterator instanceof Player) || !(entityiterator instanceof ServerPlayer _player)) {
                                                                break label452;
                                                            }

                                                            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:anti_open_barrier_type_domain"));
                                                            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                                            if (_ap.isDone()) {
                                                                break label452;
                                                            }

                                                            Iterator var55 = _ap.getRemainingCriteria().iterator();

                                                            while (true) {
                                                                if (!var55.hasNext()) {
                                                                    break label452;
                                                                }

                                                                String criteria = (String) var55.next();
                                                                _player.getAdvancements().award(_adv, criteria);
                                                            }
                                                        }

                                                        entityiterator.getPersistentData().putDouble("cnt_learn_domain", 1.0);
                                                        break label452;
                                                    }

                                                    logic_a = false;
                                                }

                                                if (logic_a) {
                                                    break label484;
                                                }
                                            }
                                        }
                                    }
                                }

                                if (!logic_b) {

                                    if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BarrierlessDomain) {
                                        if (distance < (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RadiusDomain) {
                                            entity.getPersistentData().putBoolean("Failed", true);
                                        } else {
                                            use_old = true;
                                            old_failed = entity.getPersistentData().getBoolean("Failed");
                                            entity.getPersistentData().putBoolean("Failed", true);
                                        }

                                        failed = true;
                                    } else {
                                        if (distance < JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius) {
                                            entity.getPersistentData().putBoolean("Failed", true);
                                        } else {
                                            use_old = true;
                                            old_failed = entity.getPersistentData().getBoolean("Failed");
                                            entity.getPersistentData().putBoolean("Failed", true);
                                        }

                                        failed = true;
                                    }
                                }
                            }
                        }

                        if (!logic_a) {
                            break;
                        }
                    }
                } else {
                    failed = true;
                }

                entity.getPersistentData().putDouble("skill", old_skill);
                if (!entity.getPersistentData().getBoolean("Failed") && !entity.getPersistentData().getBoolean("Cover")) {
                    label333:
                    {
                        if (entity instanceof LivingEntity) {
                            _livEnt157 = (LivingEntity) entity;
                            if (_livEnt157.hasEffect(JujutsucraftModMobEffects.ZONE.get())) {
                                var67 = _livEnt157.getEffect(JujutsucraftModMobEffects.ZONE.get()).getDuration();
                                break label333;
                            }
                        }

                        var67 = 0;
                    }

                    if (var67 < 10 && entity instanceof LivingEntity) {
                        _entity = (LivingEntity) entity;
                        if (!_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.ZONE.get(), 10, 0, false, false));
                        }
                    }
                } else {
                    if (!failed && !entity.getPersistentData().getBoolean("Cover")) {
                        label608:
                        {
                            distance = Math.sqrt(Math.pow(entity.getPersistentData().getDouble("x_pos_doma") - entity.getX(), 2.0) + Math.pow(entity.getPersistentData().getDouble("y_pos_doma") - (entity.getY() + (double) entity.getBbHeight() * 0.5), 2.0) + Math.pow(entity.getPersistentData().getDouble("z_pos_doma") - entity.getZ(), 2.0));
                            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BarrierlessDomain) {
                                if (!(distance < (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RadiusDomain)) {
                                    label353:
                                    {
                                        if (entity instanceof LivingEntity) {
                                            _livEnt157 = (LivingEntity) entity;
                                            if (_livEnt157.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                var67 = _livEnt157.getEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                                break label353;
                                            }
                                        }

                                        var67 = 0;
                                    }

                                    if (var67 == 0) {
                                        if (entity instanceof LivingEntity) {
                                            _entity = (LivingEntity) entity;
                                            _entity.removeEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                                        }
                                        break label608;
                                    }
                                }
                            } else {
                                if (!(distance < JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius)) {
                                    label353:
                                    {
                                        if (entity instanceof LivingEntity) {
                                            _livEnt157 = (LivingEntity) entity;
                                            if (_livEnt157.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                var67 = _livEnt157.getEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                                break label353;
                                            }
                                        }

                                        var67 = 0;
                                    }

                                    if (var67 == 0) {
                                        if (entity instanceof LivingEntity) {
                                            _entity = (LivingEntity) entity;
                                            _entity.removeEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                                        }
                                        break label608;
                                    }
                                }
                            }

                            entity.getPersistentData().putDouble("cnt_cover", 1.0);
                            old_failed = false;
                            entity.getPersistentData().putBoolean("Failed", false);
                            entity.getPersistentData().putBoolean("Cover", true);
                            if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity) entity;
                                if (!_entity.level().isClientSide()) {
                                    int var10005;
                                    MobEffect var71;
                                    int var73;
                                    MobEffectInstance var75;
                                    label344:
                                    {
                                        var71 = JujutsucraftModMobEffects.DOMAIN_EXPANSION.get();
                                        var73 = (int) (tick_1 + 100.0);
                                        if (entity instanceof LivingEntity) {
                                            _livEnt = (LivingEntity) entity;
                                            if (_livEnt.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                var10005 = _livEnt.getEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                                break label344;
                                            }
                                        }

                                        var10005 = 0;
                                    }

                                    var75 = new MobEffectInstance(var71, var73, var10005, true, false);
                                    _entity.addEffect(var75);
                                }
                            }

                            entity.getPersistentData().putDouble("x_pos_doma2", Math.round((float) entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()));
                            entity.getPersistentData().putDouble("y_pos_doma2", Math.round((float) entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()));
                            entity.getPersistentData().putDouble("z_pos_doma2", Math.round((float) entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
                        }
                    }

                    if (entity.getPersistentData().getBoolean("Cover")) {
                        x_pos = entity.getPersistentData().getDouble("x_pos_doma");
                        y_pos = entity.getPersistentData().getDouble("y_pos_doma");
                        z_pos = entity.getPersistentData().getDouble("z_pos_doma");
                    } else {
                        x_pos = entity.getX();
                        y_pos = entity.getY();
                        z_pos = entity.getZ();
                    }

                    old_skill = entity.getPersistentData().getDouble("cnt1");
                    entity.getPersistentData().putDouble("cnt1", 0.0);
                    DomainExpansionBattleProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                    entity.getPersistentData().putDouble("cnt1", old_skill);
                    if (use_old) {
                        entity.getPersistentData().putBoolean("Failed", old_failed);
                    }

                    if (entity.getPersistentData().getBoolean("Cover")) {
                        entity.getPersistentData().putDouble("cnt_cover", entity.getPersistentData().getDouble("cnt_cover") + 1.0);

                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BarrierlessDomain) {
                            if (entity.getPersistentData().getDouble("cnt_cover") > (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RadiusDomain * 2.0 + 1.0) {
                                entity.getPersistentData().putBoolean("Cover", false);
                            }
                        } else {
                            if (entity.getPersistentData().getDouble("cnt_cover") > JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0 + 1.0) {
                                entity.getPersistentData().putBoolean("Cover", false);
                            }
                        }
                    }
                }

                if (!entity.getPersistentData().getBoolean("Cover")) {
                    if (entity instanceof Player) {
                        double _setval = entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCursePowerChange - 1.0;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                            capability.PlayerCursePowerChange = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                        if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCursePower + entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCursePowerChange <= 0.0 && entity instanceof LivingEntity) {
                            _livEnt157 = (LivingEntity) entity;
                            _livEnt157.removeEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                        }
                    } else if (entity.getPersistentData().getDouble("cnt_target") > 5.0) {
                        entity.getPersistentData().putDouble("cnt_domain_cancel", 0.0);
                    } else {
                        short var76;
                        label324:
                        {
                            entity.getPersistentData().putDouble("cnt_domain_cancel", entity.getPersistentData().getDouble("cnt_domain_cancel") + 1.0);
                            var10000 = entity.getPersistentData().getDouble("cnt_domain_cancel");
                            if (entity instanceof LivingEntity) {
                                _livEnt157 = (LivingEntity) entity;
                                if (_livEnt157.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                    var76 = 600;
                                    break label324;
                                }
                            }

                            var76 = 100;
                        }

                        if (var10000 > (double) var76 && entity instanceof LivingEntity) {
                            _entity = (LivingEntity) entity;
                            _entity.removeEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                        }
                    }
                }
            } else if (entity instanceof LivingEntity) {
                _livEnt157 = (LivingEntity) entity;
                _livEnt157.removeEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
            }

        }
    }
}
