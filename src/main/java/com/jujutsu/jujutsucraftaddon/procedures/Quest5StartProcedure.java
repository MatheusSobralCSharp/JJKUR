package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class Quest5StartProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("Satoru Gojo: Ten Seconds. Come On Back After Ten Seconds."), false);
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("Itadori Yuji: I Dunno About This.."), false);
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("Satoru Gojo: Don't Worry! I'm Crazy Strong."), false);
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("Satoru Gojo: Megumi Hold On To This Will Ya?"), false);
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("Fushiguro Megumi: What's This?"), false);
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("Satoru Gojo: Kikufuku Mochi"), false);
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("Fushiguro Megumi: \"This Guy Went To Buy Souvenirs!\""), false);
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("Satoru Gojo: It's Not A Souvenir. That's For Me To Eat On The Bullet Train Home."), false);
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("Fushiguro Megumi: Behind You!"), false);
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("Satoru Gojo: I've Got A Student Watching, So..."), false);
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("Satoru Gojo: ...I Hope You Don't Mind If I Show Off A Little. "), false);
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("Ryomen Sukuna: \"He's Unbelievably Fast! No, It's Not Just That...\""), false);
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("Ryomen Sukuna: It Doesn't Matter What Era Is. You Guys Are Always a Pain!"), false);
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("Ryomen Sukuna: You Stupid Jujutsu Sorcerer!"), false);
        if (world instanceof ServerLevel _serverLevel) {
            Entity entitytospawn = JujutsucraftModEntities.GOJO_SATORU.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entitytospawn != null) {
                entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                {
                    CompoundTag dataIndex = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putString("OWNER_UUID", ((entitytospawn).getStringUUID()));
                    (entitytospawn).load(dataIndex);
                }
                if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 29, false, false));
                if ((entitytospawn) instanceof LivingEntity _entity)
                    _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                {
                    CompoundTag dataIndex = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex);
                }
                {
                    CompoundTag dataIndex = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("brokenBrain", 2);
                    (entitytospawn).load(dataIndex);
                }
                {
                    CompoundTag dataIndex = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex);
                }
                {
                    Entity _entity = (entitytospawn);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().armor.set(3, new ItemStack(JujutsucraftModItems.UNIFORM_GOJO_HELMET.get()));
                        _player.getInventory().setChanged();
                    } else if (_entity instanceof LivingEntity _living) {
                        _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(JujutsucraftModItems.UNIFORM_GOJO_HELMET.get()));
                    }
                }
                for (int index0 = 0; index0 < 20; index0++) {
                    if (world instanceof ServerLevel _level)
                        _level.sendParticles(JujutsucraftaddonModParticleTypes.THUNDER_BLACK.get(), x, y, (z + 5), 3, 3, 3, 3, 1);
                }
                _serverLevel.addFreshEntity(entitytospawn);
            }
        }
        if (world instanceof ServerLevel _serverLevel) {
            Entity entitytospawn = JujutsucraftModEntities.SUKUNA.get().spawn(_serverLevel, BlockPos.containing(x, y, (z + 5)), MobSpawnType.MOB_SUMMONED);
            if (entitytospawn != null) {
                entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                if ((entitytospawn) instanceof LivingEntity _entity)
                    _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 29, false, false));
                {
                    CompoundTag dataIndex = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("brokenBrain", 2);
                    (entitytospawn).load(dataIndex);
                }
                {
                    Entity _entity = (entitytospawn);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().armor.set(2, ItemStack.EMPTY);
                        _player.getInventory().setChanged();
                    } else if (_entity instanceof LivingEntity _living) {
                        _living.setItemSlot(EquipmentSlot.CHEST, ItemStack.EMPTY);
                    }
                }
                if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 2, false, false));
                for (int index1 = 0; index1 < 20; index1++) {
                    if (world instanceof ServerLevel _level)
                        _level.sendParticles(JujutsucraftaddonModParticleTypes.BLOOD_RED.get(), x, y, (z + 5), 3, 3, 3, 3, 1);
                }
                _serverLevel.addFreshEntity(entitytospawn);
            }
        }
        {
            double _setval = 6;
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.History = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
        if (entity instanceof Player _player)
            _player.closeContainer();
    }
}
