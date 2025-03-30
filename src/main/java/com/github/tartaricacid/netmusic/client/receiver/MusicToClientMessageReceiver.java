package com.github.tartaricacid.netmusic.client.receiver;

import com.github.tartaricacid.netmusic.client.audio.MusicPlayManager;
import com.github.tartaricacid.netmusic.client.audio.NetMusicSound;
import com.github.tartaricacid.netmusic.networking.message.MusicToClientMessage;
import net.fabricmc.fabric.api.network.PacketContext;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Util;

import java.util.concurrent.CompletableFuture;

/**
 * @author : IMG
 * @create : 2024/10/4
 */
public class MusicToClientMessageReceiver {

    public static void receive(PacketContext packetContext, PacketByteBuf buf) {
        MusicToClientMessage message = MusicToClientMessage.getMessageFromBuffer(buf);

        packetContext.getTaskQueue().execute(() -> {
            CompletableFuture.runAsync(() -> {
                MusicPlayManager.play(
                        message.getUrl(),
                        message.getSongName(),
                        url -> new NetMusicSound(
                                message.getPos(),
                                url,
                                message.getTimeSecond()
                        )
                );
            }, Util.getServerWorkerExecutor());
        });
    }
}
