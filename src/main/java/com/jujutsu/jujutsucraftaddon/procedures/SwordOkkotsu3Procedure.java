package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class SwordOkkotsu3Procedure {
    public static void execute(Entity entity, Entity sourceentity, ItemStack itemstack) {
        if (entity == null || sourceentity == null)
            return;
        if (entity instanceof LivingEntity) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 5, false, false));
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("skill");
            }
        }.getValue() >= 2) {
            itemstack.getOrCreateTag().putDouble("Copied", (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("skill");
                }
            }.getValue()));
            {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("skill", (itemstack.getOrCreateTag().getDouble("Copied")));
                sourceentity.load(dataIndex);
            }
            {
                CompoundTag dataIndex = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 1);
                sourceentity.load(dataIndex);
            }
            {
                Entity _ent = sourceentity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                            _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique");
                }
            }
            if (JujutsucraftaddonModItems.SWORD_OKKOTSU_THREE.get() == JujutsucraftaddonModItems.SWORD_OKKOTSU_THREE.get()) {
                itemstack.setHoverName(Component.literal((entity.getDisplayName().getString())));
                if (sourceentity instanceof Player _player)
                    _player.getCooldowns().addCooldown(itemstack.getItem(), 300);
            }
        }
    }
}
