package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.item.YuunItem;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class WuStaffEntitySwingsItemProcedure {
    public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        itemstack.getOrCreateTag().putDouble("Test", (Mth.nextInt(RandomSource.create(), 1, 10)));
        if (itemstack.getOrCreateTag().getDouble("Test") > 0) {
            if (itemstack.getOrCreateTag().getBoolean("Mode")) {
                if (world.isClientSide()) {
                    if (entity instanceof AbstractClientPlayer player) {
                        var animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null && !animation.isActive()) {
                            animation.setAnimation(
                                    new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("wu" + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("Test")))))));
                        }
                    }
                }
            }
            {
                Entity _ent = entity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                            _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("playsound jujutsucraftaddon:wu" + itemstack.getOrCreateTag().getDouble("Test") + " master @s"));
                }
            }
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal(("playsound jujutsucraftaddon:wu" + itemstack.getOrCreateTag().getDouble("Test") + " master @s")), false);
            if (itemstack.getItem() instanceof YuunItem)
                itemstack.getOrCreateTag().putString("geckoAnim", ("wu" + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("Test"))));
            itemstack.getOrCreateTag().putDouble("Test", 0);
        }
    }
}
