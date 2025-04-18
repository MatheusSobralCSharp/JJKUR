package com.jujutsu.jujutsucraftaddon.command;

import com.jujutsu.jujutsucraftaddon.procedures.VowClearProcedure;
import net.minecraft.commands.Commands;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class JjkuClearVowsCommand {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("jjkuClearVows").requires(s -> s.hasPermission(2)).executes(arguments -> {
            Level world = arguments.getSource().getUnsidedLevel();
            double x = arguments.getSource().getPosition().x();
            double y = arguments.getSource().getPosition().y();
            double z = arguments.getSource().getPosition().z();
            Entity entity = arguments.getSource().getEntity();
            if (entity == null && world instanceof ServerLevel _servLevel)
                entity = FakePlayerFactory.getMinecraft(_servLevel);
            Direction direction = Direction.DOWN;
            if (entity != null)
                direction = entity.getDirection();

            VowClearProcedure.execute(entity);
            return 0;
        }));
    }
}
