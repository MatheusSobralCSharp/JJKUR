package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class Quest4StartProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("Suguru Geto: You're Furious Like You've Been Since You Were Born. Curse Power Must Be Filling You To The Brim"), false);
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("Suguru Geto: Your Physical Abilities Must Be Elevated, Your Five Senses Sharpened, And It Must Feel Like You Can Do Anything"), false);
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("Suguru Geto: Those Birds Aren't Enough For You. Let's Try Striking You Directly"), false);
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("Okkotsu Yuta: Match My Movements, Rika."), false);
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("Suguru Geto: Humans Stand At The Top Of The Food Chain. The Only Thing Above Them Is An Imaginary \"God\", Don't You Think It's Strange?"), false);
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("Suguru Geto: Us Shamans Exist Without Resorting To Imagination."), false);
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("Suguru Geto: In The End, Monkeys Are Just Trying To Look Away From Those Above Them."), false);
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("Okkotsu Yuta: Don't Say Childish Things, Like Wanting To Become God!!!"), false);
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("Suguru Geto: You're Missing The Point, Okkotsu!"), false);
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("Okkotsu Yuta: Tsk!"), false);
        if (world instanceof ServerLevel _serverLevel) {
            Entity entitytospawn = JujutsucraftModEntities.OKKOTSU_YUTA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
                    dataIndex.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex);
                }
                for (int index0 = 0; index0 < 20; index0++) {
                    if (world instanceof ServerLevel _level)
                        _level.sendParticles(JujutsucraftaddonModParticleTypes.THUNDER_BLACK.get(), x, y, (z + 5), 3, 3, 3, 3, 1);
                }
                _serverLevel.addFreshEntity(entitytospawn);
            }
        }
        if (world instanceof ServerLevel _serverLevel) {
            Entity entitytospawn = JujutsucraftModEntities.GETO_SUGURU_CURSE_USER.get().spawn(_serverLevel, BlockPos.containing(x, y, (z + 5)), MobSpawnType.MOB_SUMMONED);
            if (entitytospawn != null) {
                entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                if ((entitytospawn) instanceof LivingEntity _entity)
                    _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 29, false, false));
                if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 2, false, false));
                for (int index1 = 0; index1 < 20; index1++) {
                    if (world instanceof ServerLevel _level)
                        _level.sendParticles(ParticleTypes.SQUID_INK, x, y, (z + 5), 3, 3, 3, 3, 1);
                }
                _serverLevel.addFreshEntity(entitytospawn);
            }
        }
        {
            double _setval = 5;
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.History = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
        if (entity instanceof Player _player)
            _player.closeContainer();
    }
}
