package com.github.tartaricacid.netmusic.client.network;

import com.github.tartaricacid.netmusic.networking.message.Message;
import net.fabricmc.fabric.impl.networking.ClientSidePacketRegistryImpl;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.c2s.play.CustomPayloadC2SPacket;
import net.minecraft.util.Identifier;

import java.util.Objects;

/**
 * @author : IMG
 * @create : 2024/10/8
 */
public class ClientNetWorkHandler {

    public static void sendToServer(Message<?> message) {
        PacketByteBuf buffer = message.toBuffer();
//        ClientPlayNetworkHandler networkHandler = MinecraftClient.getInstance().getNetworkHandler();
//        if (networkHandler != null) {
//            networkHandler.sendPacket(createC2SPacket(message.getPacketId(), buffer));
//        }
        ClientSidePacketRegistryImpl.INSTANCE.sendToServer(message.getPacketId(), buffer);
    }

    public static Packet<?> createC2SPacket(Identifier channelName, PacketByteBuf buf) {
        Objects.requireNonNull(channelName, "Channel name cannot be null");
        Objects.requireNonNull(buf, "Buf cannot be null");
        return new CustomPayloadC2SPacket(channelName, buf);
    }
}
