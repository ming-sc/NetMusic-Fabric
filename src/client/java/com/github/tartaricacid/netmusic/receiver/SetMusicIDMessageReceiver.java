package com.github.tartaricacid.netmusic.receiver;

import com.github.tartaricacid.netmusic.networking.message.MusicToClientMessage;
import com.github.tartaricacid.netmusic.networking.message.SetMusicIDMessage;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;

/**
 * @author : IMG
 * @create : 2024/10/8
 */
public class SetMusicIDMessageReceiver {

//    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender sender) {
//        SetMusicIDMessage message = SetMusicIDMessage.fromBuffer(buf);
//        client.execute(() -> {
//            // 获取消息发送者
//
//            // TODO: 是发送给服务器的
//            // 获取消息发送者的背包
//        });
//    }
}
