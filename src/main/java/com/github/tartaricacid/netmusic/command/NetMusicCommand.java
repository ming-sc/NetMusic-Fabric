package com.github.tartaricacid.netmusic.command;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.argument.ColorArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.literal;

/**
 * @author : IMG
 * @create : 2024/10/2
 */
public class NetMusicCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("netmusic").executes(context -> {
            Text text = Text.literal("Hello, NetMusic!");
            context.getSource().getServer().getPlayerManager().broadcast(text, false);
            return Command.SINGLE_SUCCESS;
        }));
    }
}
