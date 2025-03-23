package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class SukunaShirtlessProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        {
            CompoundTag dataIndex = new CompoundTag();
            entity.saveWithoutId(dataIndex);
            dataIndex.getCompound("ForgeData").putBoolean("UseCursedTechnique", true);
            entity.load(dataIndex);
        }
        {
            CompoundTag dataIndex = new CompoundTag();
            entity.saveWithoutId(dataIndex);
            dataIndex.getCompound("ForgeData").putBoolean("CurseUser", true);
            entity.load(dataIndex);
        }
        {
            CompoundTag dataIndex = new CompoundTag();
            entity.saveWithoutId(dataIndex);
            dataIndex.getCompound("ForgeData").putBoolean("FlagSukuna", true);
            entity.load(dataIndex);
        }
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 17, false, false));
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, -1, 3, false, false));
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 3, false, false));
        {
            Entity _ent = entity;
            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                        _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run item replace entity @s armor.feet with jujutsucraft:uniform_normal_boots");
            }
        }
        {
            Entity _ent = entity;
            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                        _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run item replace entity @s armor.legs with jujutsucraft:uniform_itadori_leggings");
            }
        }
    }
}
