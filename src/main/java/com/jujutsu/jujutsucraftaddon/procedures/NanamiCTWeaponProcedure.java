package com.jujutsu.jujutsucraftaddon.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

public class NanamiCTWeaponProcedure {
    public static void execute(Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if (sourceentity instanceof Player || sourceentity instanceof ServerPlayer) {
            if ((ForgeRegistries.ITEMS.getKey((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:weapon_nanami")) {
                {
                    CompoundTag dataIndex = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 1);
                    sourceentity.load(dataIndex);
                }
                {
                    CompoundTag dataIndex = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("skill", 1305);
                    sourceentity.load(dataIndex);
                }
                {
                    Entity _ent = sourceentity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique");
                    }
                }
                if (sourceentity instanceof Player _player)
                    _player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 100);
            }
        }
    }
}
