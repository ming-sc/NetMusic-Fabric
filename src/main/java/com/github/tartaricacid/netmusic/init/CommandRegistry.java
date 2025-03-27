package com.github.tartaricacid.netmusic.init;

import com.github.tartaricacid.netmusic.command.NetMusicCommand;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;

/**
 * @author : IMG
 * @create : 2024/10/2
 */

public class CommandRegistry {

    public static void registryCommand() {
        CommandRegistrationCallback.EVENT.register((
                (dispatcher, dedicated) -> {
                    dispatcher.register(NetMusicCommand.get());
                }));
    }
}
