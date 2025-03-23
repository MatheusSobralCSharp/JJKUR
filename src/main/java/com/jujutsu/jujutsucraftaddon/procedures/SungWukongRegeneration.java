package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.CloneEntity;
import com.jujutsu.jujutsucraftaddon.entity.FakeClonesEntity;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class SungWukongRegeneration {
    public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        double cooldown1 = 0;
        if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Wukong") || entity instanceof FakeClonesEntity || entity instanceof CloneEntity) {
            if (itemstack.getOrCreateTag().getDouble("Regen") == 0) {
                {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run jjc_cursepower 1000 @s");
                    }
                }

                if (entity instanceof LivingEntity _entity1 && !_entity1.level().isClientSide())
                    _entity1.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.ZONE.get(), 60, 1, false, false));
                if (entity instanceof LivingEntity _entity1 && !_entity1.level().isClientSide())
                    _entity1.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 5, false, false));
                if (entity instanceof LivingEntity _entity1 && !_entity1.level().isClientSide())
                    _entity1.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 60, 5, false, false));
                if (entity instanceof LivingEntity _entity1 && !_entity1.level().isClientSide())
                    _entity1.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 5, false, false));
                itemstack.getOrCreateTag().putDouble("Regen", 200);
            } else {
                itemstack.getOrCreateTag().putDouble("Regen", (itemstack.getOrCreateTag().getDouble("Regen") - 1));
            }
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("RikaRing");
                }
            }.getValue() == 0) {
                {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("RikaRing", 1);
                    entity.load(dataIndex);
                }
            }

        }
    }
}
