package com.github.tartaricacid.netmusic.network;

import com.github.tartaricacid.netmusic.networking.message.Message;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.PacketByteBuf;

/**
 * @author : IMG
 * @create : 2024/10/8
 */
public class ClientNetWorkHandler {

    public static void sendToServer(Message<?> message) {
        PacketByteBuf buffer = message.toBuffer();
        ClientPlayNetworking.send(message.getPacketId(), buffer);
    }
}
