package com.github.tartaricacid.netmusic.receiver;

import com.github.tartaricacid.netmusic.inventory.CDBurnerMenu;
import com.github.tartaricacid.netmusic.inventory.ComputerMenu;
import com.github.tartaricacid.netmusic.networking.message.SetMusicIDMessage;
import net.fabricmc.fabric.impl.networking.ServerSidePacketRegistryImpl;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.thread.ThreadExecutor;

/**
 * @author : IMG
 * @create : 2024/10/8
 */
public class SetMusicIDMessageReceiver {

    public static void receive() {
        ServerSidePacketRegistryImpl.INSTANCE.register(SetMusicIDMessage.getPacketIdStatic(), (packetContext, buf) -> {
            SetMusicIDMessage message = SetMusicIDMessage.fromBuffer(buf);
            ThreadExecutor server = packetContext.getTaskQueue();
            PlayerEntity player = packetContext.getPlayer();
            server.execute(() -> {
                if (player == null){
                    return;
                }

                if (player.currentScreenHandler instanceof CDBurnerMenu) {
                    CDBurnerMenu menu = (CDBurnerMenu) player.currentScreenHandler;
                    menu.setSongInfo(message.song);
                    return;
                }
                if (player.currentScreenHandler instanceof ComputerMenu) {
                    ComputerMenu menu = (ComputerMenu) player.currentScreenHandler;
                    menu.setSongInfo(message.song);
                }
            });
        });
    }
}
