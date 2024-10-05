package com.github.tartaricacid.netmusic.init;

import com.github.tartaricacid.netmusic.command.NetMusicCommand;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

import static net.minecraft.server.command.CommandManager.*;

/**
 * @author : IMG
 * @create : 2024/10/2
 */

public class CommandRegistry {

    public static void registryCommand(){
        CommandRegistrationCallback.EVENT.register((
                (dispatcher, registryAccess, environment) -> {
//                    if (environment.dedicated){
                        NetMusicCommand.register(dispatcher);
//                    }
                }));
    }
}
