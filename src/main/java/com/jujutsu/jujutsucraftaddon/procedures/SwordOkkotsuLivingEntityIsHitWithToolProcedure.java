package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class SwordOkkotsuLivingEntityIsHitWithToolProcedure {
    public static void execute(Entity entity, Entity sourceentity, ItemStack itemstack) {
        if (entity == null || sourceentity == null)
            return;
        if (entity instanceof LivingEntity) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 5, false, false));
        }
        if (entity.getPersistentData().getDouble("skill") >= 2) {
            itemstack.getOrCreateTag().putDouble("skill", (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("skill");
                }
            }.getValue()));
            sourceentity.getPersistentData().putDouble("skill", (itemstack.getOrCreateTag().getDouble("skill")));
            sourceentity.getPersistentData().putDouble("PRESS_Z", 1);
            {
                Entity _ent = sourceentity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                            _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique");
                }
            }
            if (JujutsucraftaddonModItems.SWORD_OKKOTSU.get() == JujutsucraftaddonModItems.SWORD_OKKOTSU.get()) {
                if (sourceentity instanceof Player _player)
                    _player.getCooldowns().addCooldown(itemstack.getItem(), 600);
            }
        }
    }
}
