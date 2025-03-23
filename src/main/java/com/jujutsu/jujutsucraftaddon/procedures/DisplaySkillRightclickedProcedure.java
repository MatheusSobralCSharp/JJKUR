package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class DisplaySkillRightclickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (entity.isShiftKeyDown()) {
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal(("Your skill number is: " + new java.text.DecimalFormat("##.##").format(new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("skill");
                    }
                }.getValue()))), false);
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(
                        Component.literal(("Your skill number is: " + (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique)), false);
        } else {
            DisplaySkillIdProcedure.execute(world, x, y, z, entity);
        }
    }
}
