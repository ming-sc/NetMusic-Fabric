package com.github.tartaricacid.netmusic.receiver;

import com.github.tartaricacid.netmusic.audio.MusicPlayManager;
import com.github.tartaricacid.netmusic.audio.NetMusicSound;
import com.github.tartaricacid.netmusic.networking.message.MusicToClientMessage;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Util;

import java.util.concurrent.CompletableFuture;

/**
 * @author : IMG
 * @create : 2024/10/4
 */
public class MusicToClientMessageReceiver {

    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender sender) {
        MusicToClientMessage message = MusicToClientMessage.getMessageFromBuffer(buf);

        client.execute(() -> {
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
            }, Util.getMainWorkerExecutor());
        });
    }
}
