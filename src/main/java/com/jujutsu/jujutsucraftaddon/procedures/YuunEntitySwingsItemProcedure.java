package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.item.YuunItem;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class YuunEntitySwingsItemProcedure {
    public static void execute(Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        double number = 0;
        itemstack.getOrCreateTag().putDouble("Test", (Mth.nextInt(RandomSource.create(), 1, 4)));
        if (itemstack.getOrCreateTag().getDouble("Test") > 0) {
            {
                Entity _ent = entity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                    _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                            ("effect give @s jujutsucraftaddon:anim_" + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("Test")) + " 1 1 true"));
                }
            }
            if (itemstack.getItem() instanceof YuunItem)
                itemstack.getOrCreateTag().putString("geckoAnim", ("ab" + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("Test"))));
            itemstack.getOrCreateTag().putDouble("Test", 0);
        }
        itemstack.getOrCreateTag().putDouble("CursePower", (Mth.nextInt(RandomSource.create(), 1, 10)));
    }
}
