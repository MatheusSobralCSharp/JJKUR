package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.entity.IgrisEntity;
import com.jujutsu.jujutsucraftaddon.entity.Shadow1Entity;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.entity.*;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.EffectAttackProcedure;
import net.mcreator.jujutsucraft.procedures.EffectCharactorProcedure;
import net.mcreator.jujutsucraft.procedures.LocateRikaProcedure;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;

@Mixin(value = EffectCharactorProcedure.class, priority = -10000)
public abstract class EffectCharactorProcedureMixin {
    /**
     * @author Satushi
     * @reason Fixing/Changes
     */
    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, Entity entity, Entity entityiterator, CallbackInfo ci) {
        ci.cancel();

        if (entity != null && entityiterator != null) {
            ItemStack item_A = ItemStack.EMPTY;
            String STR1 = "";
            boolean cursed_technique = false;
            boolean logic_start = false;
            boolean logic_a = false;
            Entity entity_a = null;
            Entity entity_b = null;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double NUM1 = 0.0;
            double old_cool = 0.0;
            entity_a = entityiterator;
            int index0;
            if (entity_a instanceof LivingEntity) {
                label496:
                {
                    LivingEntity _entGetArmor;
                    label457:
                    {
                        int var10000;
                        label442:
                        {
                            cursed_technique = entity.getPersistentData().getDouble("skill") > 100.0 && !entity.getPersistentData().getBoolean("attack");
                            x_pos = entity_a.getX();
                            y_pos = entity_a.getY() + (double) entity_a.getBbHeight() * 0.5;
                            z_pos = entity_a.getZ();
                            if (entity instanceof EntityWaterEntity) {
                                if (entity instanceof EntityWaterEntity) {
                                    EntityWaterEntity _datEntI = (EntityWaterEntity) entity;
                                    var10000 = (Integer) _datEntI.getEntityData().get(EntityWaterEntity.DATA_type);
                                } else {
                                    var10000 = 0;
                                }

                                if (var10000 == 0) {
                                    break label442;
                                }
                            }

                            if (!(entity instanceof EntityWater2Entity)) {
                                break label457;
                            }
                        }

                        label458:
                        {
                            if (entity_a instanceof Player) {
                                if (((JujutsucraftModVariables.PlayerVariables) entity_a.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 10.0 || ((JujutsucraftModVariables.PlayerVariables) entity_a.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 10.0) {
                                    break label458;
                                }
                            } else if (entity_a instanceof ChosoEntity || entity_a instanceof EsoEntity || entity_a instanceof KamoNoritoshiEntity) {
                                break label458;
                            }

                            label423:
                            {
                                if (entity_a instanceof EntityWaterEntity) {
                                    if (entity_a instanceof EntityWaterEntity) {
                                        EntityWaterEntity _datEntI = (EntityWaterEntity) entity_a;
                                        var10000 = (Integer) _datEntI.getEntityData().get(EntityWaterEntity.DATA_type);
                                    } else {
                                        var10000 = 0;
                                    }

                                    if (var10000 == 2) {
                                        break label423;
                                    }
                                }

                                if (!(entity_a instanceof BloodBallEntity) && !(entity_a instanceof SlicingExorcismEntity)) {
                                    break label457;
                                }
                            }

                            Entity _ent = entity_a;
                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill @s");
                            }

                            if (!entity_a.level().isClientSide()) {
                                entity_a.discard();
                            }
                            break label457;
                        }

                        old_cool = entity_a.getPersistentData().getDouble("COOLDOWN_TICKS");
                        if (entity_a instanceof LivingEntity) {
                            _entGetArmor = (LivingEntity) entity_a;
                            if (!_entGetArmor.level().isClientSide()) {
                                _entGetArmor.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 60, 0, false, false));
                            }
                        }

                        entity_a.getPersistentData().putDouble("COOLDOWN_TICKS", old_cool);
                    }

                    if (entity.getPersistentData().getBoolean("attack")) {
                        EffectAttackProcedure.execute(world, entity_a, entity);
                    }

                    Player _player;
                    ItemStack var49;
                    CompoundTag var51;
                    if (cursed_technique && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:no_cursed_technique"))) && entity.getPersistentData().getDouble("skill") != 705.0) {
                        label473:
                        {
                            if (entity_a instanceof Player) {
                                if (((JujutsucraftModVariables.PlayerVariables) entity_a.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 5.0 && ((JujutsucraftModVariables.PlayerVariables) entity_a.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 5.0) {
                                    break label473;
                                }
                            } else if (!(entity_a instanceof OkkotsuYutaEntity) && !(entity_a instanceof OkkotsuYutaCullingGameEntity)) {
                                break label473;
                            }

                            if (LocateRikaProcedure.execute(world, entity_a)) {
                                Iterator var23;
                                String criteria;
                                ServerPlayer _player2;
                                Advancement _adv;
                                AdvancementProgress _ap;
                                if (entity.getPersistentData().getDouble("skill") >= 305.0 && entity.getPersistentData().getDouble("skill") < 320.0) {
                                    if (entity_a instanceof ServerPlayer) {
                                        _player2 = (ServerPlayer) entity_a;
                                        _adv = _player2.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:skill_copy_cursed_speech"));
                                        _ap = _player2.getAdvancements().getOrStartProgress(_adv);
                                        if (!_ap.isDone()) {
                                            var23 = _ap.getRemainingCriteria().iterator();

                                            while (var23.hasNext()) {
                                                criteria = (String) var23.next();
                                                _player2.getAdvancements().award(_adv, criteria);
                                            }
                                        }
                                    }
                                } else if (entity.getPersistentData().getDouble("skill") != 3810.0 || !(entity_a instanceof Player) && !(entity_a instanceof OkkotsuYutaCullingGameEntity)) {
                                    LivingEntity _livEnt;
                                    if (entity_a instanceof Player) {
                                        logic_a = true;
                                        AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
                                        LazyOptional<IItemHandler> var48 = entity_a.getCapability(ForgeCapabilities.ITEM_HANDLER, null);
                                        var48.ifPresent(_iitemhandlerref::set);
                                        if (_iitemhandlerref.get() != null) {
                                            for (int _idx = 0; _idx < ((IItemHandler) _iitemhandlerref.get()).getSlots(); ++_idx) {
                                                ItemStack itemstackiterator = ((IItemHandler) _iitemhandlerref.get()).getStackInSlot(_idx).copy();
                                                if (itemstackiterator.getItem() == JujutsucraftModItems.COPIED_CURSED_TECHNIQUE.get() && itemstackiterator.getOrCreateTag().getDouble("skill") == entity.getPersistentData().getDouble("skill")) {
                                                    if (itemstackiterator.getCount() < 10 && entity_a instanceof Player) {
                                                        _player = (Player) entity_a;
                                                        ItemStack _setstack = itemstackiterator.copy();
                                                        _setstack.setCount(1);
                                                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                                                    }

                                                    logic_a = false;
                                                    break;
                                                }
                                            }
                                        }

                                        item_A = (new ItemStack((ItemLike) JujutsucraftModItems.COPIED_CURSED_TECHNIQUE.get())).copy();
                                        item_A.setDamageValue(item_A.getMaxDamage() - 1);
                                    } else {
                                        logic_a = false;
                                        NUM1 = 0.0;

                                        for (index0 = 0; index0 < 4; ++index0) {
                                            if (entity_a instanceof LivingEntity) {
                                                _entGetArmor = (LivingEntity) entity_a;
                                                var49 = _entGetArmor.getItemBySlot(EquipmentSlot.byTypeAndIndex(EquipmentSlot.Type.ARMOR, (int) NUM1));
                                            } else {
                                                var49 = ItemStack.EMPTY;
                                            }

                                            item_A = var49;
                                            if (item_A.getOrCreateTag().getDouble("skill") == 0.0 || item_A.getOrCreateTag().getDouble("skill") == entity.getPersistentData().getDouble("skill")) {
                                                logic_a = true;
                                                break;
                                            }

                                            ++NUM1;
                                            if (NUM1 > 3.0) {
                                                NUM1 = 0.0;
                                            }
                                        }

                                        if (!logic_a) {
                                            logic_a = true;
                                            NUM1 = Math.floor(Math.random() * 4.0);
                                            if (entity_a instanceof LivingEntity) {
                                                _livEnt = (LivingEntity) entity_a;
                                                var49 = _livEnt.getItemBySlot(EquipmentSlot.byTypeAndIndex(EquipmentSlot.Type.ARMOR, (int) NUM1));
                                            } else {
                                                var49 = ItemStack.EMPTY;
                                            }

                                            item_A = var49;
                                        }
                                    }

                                    if (logic_a) {
                                        double var10002;
                                        label375:
                                        {
                                            entity_b = entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) ? (new BiFunction<LevelAccessor, String, Entity>() {
                                                public Entity apply(LevelAccessor levelAccessor, String uuid) {
                                                    if (levelAccessor instanceof ServerLevel serverLevel) {
                                                        try {
                                                            return serverLevel.getEntity(UUID.fromString(uuid));
                                                        } catch (Exception var5) {
                                                        }
                                                    }

                                                    return null;
                                                }
                                            }).apply(world, entity.getPersistentData().getString("OWNER_UUID")) : entity;
                                            entity_b = entity_b instanceof LivingEntity ? entity_b : entity;
                                            item_A.getOrCreateTag().putDouble("skill", entity.getPersistentData().getDouble("skill"));
                                            item_A.getOrCreateTag().putDouble("effect", entity.getPersistentData().getDouble("effect"));
                                            var51 = item_A.getOrCreateTag();
                                            if (entity instanceof LivingEntity) {
                                                _livEnt = (LivingEntity) entity;
                                                if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                                    var10002 = (double) _livEnt.getEffect((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getDuration();
                                                    break label375;
                                                }
                                            }

                                            var10002 = 0.0;
                                        }

                                        var51.putDouble("COOLDOWN_TICKS", (double) Math.round(Math.max(Math.max(var10002, entity.getPersistentData().getDouble("COOLDOWN_TICKS")) * 2.0, 50.0)));
                                        if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                                            item_A.getOrCreateTag().putString("SHIKIGAMI_NAME", ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString());
                                            var51 = item_A.getOrCreateTag();
                                            if (entity instanceof LivingEntity) {
                                                _livEnt = (LivingEntity) entity;
                                                var10002 = (double) _livEnt.getMaxHealth();
                                            } else {
                                                var10002 = -1.0;
                                            }

                                            var51.putDouble("SHIKIGAMI_HP", var10002);
                                        }

                                        if (entity_a instanceof Player) {
                                            String var10001 = entity_b.getDisplayName().getString();
                                            item_A.setHoverName(Component.literal(var10001 + Component.translatable("jujutsu.message.cursed_technique").getString() + " (" + Component.translatable("jujutsu.overlay.cost").getString() + ": " + Math.round(item_A.getOrCreateTag().getDouble("COOLDOWN_TICKS")) + ")"));
                                            if (entity_a instanceof Player) {
                                                _player = (Player) entity_a;
                                                ItemStack _setstack = item_A.copy();
                                                _setstack.setCount(1);
                                                ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                                            }
                                        }
                                    }
                                } else if (entity_a instanceof ServerPlayer) {
                                    _player2 = (ServerPlayer) entity_a;
                                    _adv = _player2.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:skill_copy_takako_uro"));
                                    _ap = _player2.getAdvancements().getOrStartProgress(_adv);
                                    if (!_ap.isDone()) {
                                        var23 = _ap.getRemainingCriteria().iterator();

                                        while (var23.hasNext()) {
                                            criteria = (String) var23.next();
                                            _player2.getAdvancements().award(_adv, criteria);
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (entity.getPersistentData().getDouble("skill") == 2815.0 && entity_a.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && !entity_a.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:no_cursed_technique"))) && !entity_a.isAlive() && !entity_a.level().isClientSide()) {
                        entity_a.discard();
                    }

                    ItemStack var47;
                    ItemCooldowns var52;
                    label467:
                    {
                        if (entity_a instanceof Player) {
                            _player = (Player) entity_a;
                            var52 = _player.getCooldowns();
                            if (entity_a instanceof LivingEntity) {
                                _entGetArmor = (LivingEntity) entity_a;
                                var47 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                            } else {
                                var47 = ItemStack.EMPTY;
                            }

                            if (var52.isOnCooldown(var47.getItem())) {
                                break label467;
                            }
                        }

                        if (entity_a instanceof LivingEntity) {
                            _entGetArmor = (LivingEntity) entity_a;
                            var49 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                            var49 = ItemStack.EMPTY;
                        }

                        if (var49.getItem() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                            if (entity_a instanceof LivingEntity) {
                                _entGetArmor = (LivingEntity) entity_a;
                                var49 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                            } else {
                                var49 = ItemStack.EMPTY;
                            }

                            if (var49.getItem() != JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                                break label467;
                            }
                        }

                        logic_start = false;
                        if (cursed_technique) {
                            var51 = entity.getPersistentData();
                            STR1 = "skill" + Math.round(var51.getDouble("skill"));
                            logic_start = true;
                        } else if (entity.getPersistentData().getDouble("skill_domain") != 0.0) {
                            var51 = entity.getPersistentData();
                            STR1 = "domain" + Math.round(var51.getDouble("skill_domain"));
                            logic_start = true;
                        }

                        if (logic_start) {
                            if (entity_a instanceof LivingEntity) {
                                _entGetArmor = (LivingEntity) entity_a;
                                var49 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                            } else {
                                var49 = ItemStack.EMPTY;
                            }

                            if (var49.getOrCreateTag().getDouble(STR1) == 0.0) {
                                label481:
                                {
                                    NUM1 = 1.0;
                                    int index1 = 0;

                                    while (true) {
                                        if (index1 >= 800) {
                                            break label481;
                                        }

                                        if (entity_a instanceof LivingEntity) {
                                            _entGetArmor = (LivingEntity) entity_a;
                                            var49 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                                        } else {
                                            var49 = ItemStack.EMPTY;
                                        }

                                        if (var49.getOrCreateTag().getString("DATA" + Math.round(NUM1)).equals("")) {
                                            break;
                                        }

                                        if (entity_a instanceof LivingEntity) {
                                            _entGetArmor = (LivingEntity) entity_a;
                                            var49 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                                        } else {
                                            var49 = ItemStack.EMPTY;
                                        }

                                        if (var49.getOrCreateTag().getString("DATA" + Math.round(NUM1)).equals(STR1)) {
                                            break;
                                        }

                                        ++NUM1;
                                        ++index1;
                                    }
                                    if (entity_a instanceof LivingEntity) {
                                        _entGetArmor = (LivingEntity) entity_a;
                                        var49 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                                    } else {
                                        var49 = ItemStack.EMPTY;
                                    }

                                    var49.getOrCreateTag().putString("DATA" + Math.round(NUM1), STR1);
                                    if (entity_a instanceof LivingEntity) {
                                        _entGetArmor = (LivingEntity) entity_a;
                                        var49 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                                    } else {
                                        var49 = ItemStack.EMPTY;
                                    }

                                    var49.getOrCreateTag().putDouble(STR1, 1.0);
                                    if (entity_a instanceof Player) {
                                        _player = (Player) entity_a;
                                        if (!_player.level().isClientSide()) {
                                            _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.adaptation_start").getString()), false);
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (entity instanceof Player) {
                        _player = (Player) entity;
                        var52 = _player.getCooldowns();
                        if (entity instanceof LivingEntity) {
                            _entGetArmor = (LivingEntity) entity;
                            var47 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                            var47 = ItemStack.EMPTY;
                        }

                        if (var52.isOnCooldown(var47.getItem())) {
                            break label496;
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _entGetArmor = (LivingEntity) entity;
                        var49 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                    } else {
                        var49 = ItemStack.EMPTY;
                    }

                    if (var49.getItem() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                        if (entity instanceof LivingEntity) {
                            _entGetArmor = (LivingEntity) entity;
                            var49 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                            var49 = ItemStack.EMPTY;
                        }

                        if (var49.getItem() != JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                            break label496;
                        }
                    }

                    if (entity instanceof Player) {
                        if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 16.0 && ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 16.0 && ((JujutsucraftaddonModVariables.PlayerVariables) entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mahoraga != 1.0) {
                            break label496;
                        }
                    } else if  (!((entity instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity) || (entity instanceof IgrisEntity) || (entity instanceof Shadow1Entity))) {
                        break label496;
                    }

                    if (entity_a.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                        if (entity instanceof LivingEntity) {
                            _entGetArmor = (LivingEntity) entity;
                            var49 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                            var49 = ItemStack.EMPTY;
                        }

                        var51 = var49.getOrCreateTag();
                        CompoundTag var50 = entity_a.getPersistentData();
                        if (var51.getDouble("skill" + Math.round(var50.getDouble("skill"))) >= 100.0 && !entity_a.level().isClientSide() && entity_a.getServer() != null) {
                            entity_a.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity_a.position(), entity_a.getRotationVector(), entity_a.level() instanceof ServerLevel ? (ServerLevel) entity_a.level() : null, 4, entity_a.getName().getString(), entity_a.getDisplayName(), entity_a.level().getServer(), entity_a), "kill @s");
                        }
                    }
                }
            }

            if (!entity_a.isAlive() && entity_a instanceof Player && !(entity instanceof Player)) {
                entity_b = entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) ? (new BiFunction<LevelAccessor, String, Entity>() {
                    public Entity apply(LevelAccessor levelAccessor, String uuid) {
                        if (levelAccessor instanceof ServerLevel serverLevel) {
                            try {
                                return serverLevel.getEntity(UUID.fromString(uuid));
                            } catch (Exception var5) {
                            }
                        }

                        return null;
                    }
                }).apply(world, entity.getPersistentData().getString("OWNER_UUID")) : entity;
                entity_b = entity_b instanceof LivingEntity ? entity_b : entity;
                if (!(entity_b instanceof Player)) {
                    NUM1 = 1.0;

                    for (index0 = 0; index0 < 128; ++index0) {
                        STR1 = "pName" + Math.round(NUM1);
                        if (entity_b.getPersistentData().getString(STR1).equals("")) {
                            entity_b.getPersistentData().putString(STR1, entity_a.getDisplayName().getString());
                            break;
                        }

                        ++NUM1;
                    }
                }
            }

        }
    }
}
